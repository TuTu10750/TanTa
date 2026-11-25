package defpackage;

import android.media.MediaRecorder;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: /tmp/classes2.dex */
public class ti2 {
    public long b;
    public String d;
    public boolean f;
    public MediaRecorder a = new MediaRecorder();
    public ExecutorService c = Executors.newSingleThreadExecutor();
    public Runnable e = new a();

    /* loaded from: /tmp/classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ti2.this.f = false;
            try {
                if (ti2.this.b > 0) {
                    ti2.this.a.reset();
                }
                ti2.this.a.setAudioSource(1);
                ti2.this.a.setOutputFormat(2);
                ti2.this.a.setAudioEncoder(3);
                ti2.this.a.setAudioSamplingRate(44100);
                ti2.this.a.setAudioEncodingBitRate(192000);
                ti2.this.a.setOutputFile(ti2.this.d);
                ti2.this.a.prepare();
                ti2.this.a.start();
                ti2.this.b = System.currentTimeMillis();
                ti2.this.f = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void f() {
        MediaRecorder mediaRecorder = this.a;
        if (mediaRecorder != null) {
            try {
                mediaRecorder.setOnErrorListener(null);
                this.a.setOnInfoListener(null);
                this.a.setPreviewDisplay(null);
                this.a.stop();
                this.a.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        ExecutorService executorService = this.c;
        if (executorService != null) {
            executorService.shutdownNow();
        }
    }

    public void g(String str) {
        this.d = str;
        this.c.submit(this.e);
    }

    public long h() {
        if (!this.f) {
            return 0L;
        }
        this.f = false;
        try {
            this.a.setOnErrorListener(null);
            this.a.setOnInfoListener(null);
            this.a.setPreviewDisplay(null);
            this.a.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return System.currentTimeMillis() - this.b;
    }
}
