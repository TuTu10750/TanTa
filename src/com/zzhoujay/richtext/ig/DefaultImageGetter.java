package com.zzhoujay.richtext.ig;

import android.widget.TextView;
import com.zzhoujay.richtext.ImageHolder;
import com.zzhoujay.richtext.R;
import com.zzhoujay.richtext.RichTextConfig;
import com.zzhoujay.richtext.callback.ImageGetter;
import com.zzhoujay.richtext.callback.ImageLoadNotify;
import com.zzhoujay.richtext.drawable.DrawableWrapper;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: /tmp/classes2.dex */
public class DefaultImageGetter implements ImageGetter, ImageLoadNotify {
    public static final String GLOBAL_ID = "com.zzhoujay.richtext.ig.DefaultImageGetter";
    public static final String TAG = "DefaultImageGetter";
    private static final int TASK_TAG = R.id.zhou_default_image_tag_id;
    private ImageLoadNotify notify;
    private int loadedCount = 0;
    private final HashSet<Cancelable> tasks = new HashSet<>();
    private final WeakHashMap<ImageLoader, Cancelable> taskMap = new WeakHashMap<>();

    /* loaded from: /tmp/classes2.dex */
    public static class ExecutorServiceHolder {
        private static final ExecutorService EXECUTOR_SERVICE = Executors.newCachedThreadPool();

        private ExecutorServiceHolder() {
        }
    }

    private void addTask(Cancelable cancelable, AbstractImageLoader abstractImageLoader) {
        synchronized (DefaultImageGetter.class) {
            this.tasks.add(cancelable);
            this.taskMap.put(abstractImageLoader, cancelable);
        }
    }

    private void checkTarget(TextView textView) {
        synchronized (DefaultImageGetter.class) {
            try {
                HashSet<Cancelable> hashSet = (HashSet) textView.getTag(TASK_TAG);
                if (hashSet != null) {
                    if (hashSet == this.tasks) {
                        return;
                    }
                    HashSet hashSet2 = new HashSet(hashSet);
                    Iterator it = hashSet2.iterator();
                    while (it.hasNext()) {
                        ((Cancelable) it.next()).cancel();
                    }
                    hashSet2.clear();
                    hashSet.clear();
                }
                textView.setTag(TASK_TAG, this.tasks);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void errorHandle(ImageHolder imageHolder, RichTextConfig richTextConfig, TextView textView, DrawableWrapper drawableWrapper, Exception exc) {
        new AbstractImageLoader<Object>(imageHolder, richTextConfig, textView, drawableWrapper, this, null) { // from class: com.zzhoujay.richtext.ig.DefaultImageGetter.1
        }.onFailure(exc);
    }

    private static ExecutorService getExecutorService() {
        return ExecutorServiceHolder.EXECUTOR_SERVICE;
    }

    @Override // com.zzhoujay.richtext.callback.ImageLoadNotify
    public void done(Object obj) {
        if (obj instanceof AbstractImageLoader) {
            AbstractImageLoader abstractImageLoader = (AbstractImageLoader) obj;
            synchronized (DefaultImageGetter.class) {
                try {
                    Cancelable cancelable = this.taskMap.get(abstractImageLoader);
                    if (cancelable != null) {
                        this.tasks.remove(cancelable);
                    }
                    this.taskMap.remove(abstractImageLoader);
                    int i = this.loadedCount + 1;
                    this.loadedCount = i;
                    ImageLoadNotify imageLoadNotify = this.notify;
                    if (imageLoadNotify != null) {
                        imageLoadNotify.done(Integer.valueOf(i));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ed A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v10, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v28, types: [com.zzhoujay.richtext.ig.InputStreamImageLoader, java.lang.Runnable] */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r2v27, types: [java.util.concurrent.ExecutorService] */
    /* JADX WARN: Type inference failed for: r2v31, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    @Override // com.zzhoujay.richtext.callback.DrawableGetter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.graphics.drawable.Drawable getDrawable(com.zzhoujay.richtext.ImageHolder r19, com.zzhoujay.richtext.RichTextConfig r20, android.widget.TextView r21) {
        /*
            Method dump skipped, instructions count: 545
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zzhoujay.richtext.ig.DefaultImageGetter.getDrawable(com.zzhoujay.richtext.ImageHolder, com.zzhoujay.richtext.RichTextConfig, android.widget.TextView):android.graphics.drawable.Drawable");
    }

    @Override // com.zzhoujay.richtext.callback.Recyclable
    public void recycle() {
        synchronized (DefaultImageGetter.class) {
            try {
                Iterator<Cancelable> it = this.tasks.iterator();
                while (it.hasNext()) {
                    it.next().cancel();
                }
                this.tasks.clear();
                Iterator<Map.Entry<ImageLoader, Cancelable>> it2 = this.taskMap.entrySet().iterator();
                while (it2.hasNext()) {
                    it2.next().getKey().recycle();
                }
                this.taskMap.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.zzhoujay.richtext.callback.ImageGetter
    public void registerImageLoadNotify(ImageLoadNotify imageLoadNotify) {
        this.notify = imageLoadNotify;
    }
}
