package com.zzhoujay.richtext.ig;

import com.zzhoujay.richtext.ImageHolder;
import com.zzhoujay.richtext.cache.BitmapPool;
import com.zzhoujay.richtext.callback.BitmapStream;
import com.zzhoujay.richtext.exceptions.ImageDownloadTaskAddFailureException;
import com.zzhoujay.richtext.exceptions.ImageLoadCancelledException;
import com.zzhoujay.richtext.ext.Debug;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: /tmp/classes2.dex */
class ImageDownloaderManager {
    private final ImageDownloadFinishCallback IMAGE_READY_CALLBACK;
    private final HashMap<String, Task> tasks;

    /* loaded from: /tmp/classes2.dex */
    public static class ExecutorServiceHolder {
        private static final ExecutorService EXECUTOR_SERVICE = Executors.newCachedThreadPool();

        private ExecutorServiceHolder() {
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface ImageDownloadFinishCallback {
        void imageDownloadFinish(String str);
    }

    /* loaded from: /tmp/classes2.dex */
    public static class ImageDownloaderManagerHolder {
        private static final ImageDownloaderManager IMAGE_DOWNLOADER_MANAGER = new ImageDownloaderManager();

        private ImageDownloaderManagerHolder() {
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static class Task implements Runnable {
        private static final int STATE_CALLBACK = 2;
        private static final int STATE_FINISHED = 3;
        private static final int STATE_INIT = 0;
        private static final int STATE_WORK = 1;
        private final ImageDownloadFinishCallback imageDownloadFinishCallback;
        private final ImageDownloader imageDownloader;
        private final String imageUrl;
        private final String key;
        private final Object stateLock = new Object();
        private volatile int state = 0;
        private final ArrayList<CallbackImageLoader> callbackList = new ArrayList<>();

        public Task(String str, String str2, ImageDownloader imageDownloader, ImageDownloadFinishCallback imageDownloadFinishCallback) {
            this.imageUrl = str;
            this.imageDownloader = imageDownloader;
            this.imageDownloadFinishCallback = imageDownloadFinishCallback;
            this.key = str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Cancelable exec(ExecutorService executorService, CallbackImageLoader callbackImageLoader) {
            TaskCancelable taskCancelable;
            synchronized (this.stateLock) {
                try {
                    if (this.state == 1) {
                        synchronized (this.callbackList) {
                            this.callbackList.add(callbackImageLoader);
                            taskCancelable = new TaskCancelable(this, callbackImageLoader);
                        }
                    } else {
                        taskCancelable = null;
                    }
                    if (this.state == 0) {
                        this.state = 1;
                        executorService.submit(this);
                        synchronized (this.callbackList) {
                            this.callbackList.add(callbackImageLoader);
                            taskCancelable = new TaskCancelable(this, callbackImageLoader);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (taskCancelable == null) {
                callbackImageLoader.onFailure(new ImageDownloadTaskAddFailureException());
            }
            return taskCancelable;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeCallback(CallbackImageLoader callbackImageLoader) {
            synchronized (this.callbackList) {
                this.callbackList.remove(callbackImageLoader);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.stateLock) {
                this.state = 1;
            }
            try {
                BitmapStream download = this.imageDownloader.download(this.imageUrl);
                BitmapPool.getPool().writeBitmapToTemp(this.key, download.getInputStream());
                download.close();
                e = null;
            } catch (Exception e) {
                e = e;
            }
            synchronized (this.stateLock) {
                try {
                    this.imageDownloadFinishCallback.imageDownloadFinish(this.key);
                    if (this.state != 1) {
                        return;
                    }
                    this.state = 2;
                    synchronized (this.callbackList) {
                        Iterator<CallbackImageLoader> it = this.callbackList.iterator();
                        while (it.hasNext()) {
                            try {
                                it.next().onImageDownloadFinish(this.key, e);
                            } catch (Throwable th) {
                                Debug.e(th);
                            }
                        }
                    }
                    this.state = 3;
                } catch (Throwable th2) {
                    throw th2;
                } finally {
                }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static class TaskCancelable implements Cancelable {
        private WeakReference<CallbackImageLoader> callbackImageLoaderWeakReference;
        private WeakReference<Task> taskWeakReference;

        public TaskCancelable(Task task, CallbackImageLoader callbackImageLoader) {
            this.taskWeakReference = new WeakReference<>(task);
            this.callbackImageLoaderWeakReference = new WeakReference<>(callbackImageLoader);
        }

        @Override // com.zzhoujay.richtext.ig.Cancelable
        public void cancel() {
            CallbackImageLoader callbackImageLoader;
            Task task = this.taskWeakReference.get();
            if (task == null || (callbackImageLoader = this.callbackImageLoaderWeakReference.get()) == null) {
                return;
            }
            task.removeCallback(callbackImageLoader);
            callbackImageLoader.onFailure(new ImageLoadCancelledException());
        }
    }

    private ImageDownloaderManager() {
        this.IMAGE_READY_CALLBACK = new ImageDownloadFinishCallback() { // from class: com.zzhoujay.richtext.ig.ImageDownloaderManager.1
            @Override // com.zzhoujay.richtext.ig.ImageDownloaderManager.ImageDownloadFinishCallback
            public void imageDownloadFinish(String str) {
                synchronized (ImageDownloaderManager.this.tasks) {
                    ImageDownloaderManager.this.tasks.remove(str);
                }
            }
        };
        this.tasks = new HashMap<>();
    }

    private static ExecutorService getExecutorService() {
        return ExecutorServiceHolder.EXECUTOR_SERVICE;
    }

    public static ImageDownloaderManager getImageDownloaderManager() {
        return ImageDownloaderManagerHolder.IMAGE_DOWNLOADER_MANAGER;
    }

    public Cancelable addTask(ImageHolder imageHolder, ImageDownloader imageDownloader, CallbackImageLoader callbackImageLoader) {
        Cancelable exec;
        String key = imageHolder.getKey();
        synchronized (this.tasks) {
            try {
                Task task = this.tasks.get(key);
                if (task == null) {
                    task = new Task(imageHolder.getSource(), key, imageDownloader, this.IMAGE_READY_CALLBACK);
                    this.tasks.put(key, task);
                }
                exec = task.exec(getExecutorService(), callbackImageLoader);
            } catch (Throwable th) {
                throw th;
            }
        }
        return exec;
    }
}
