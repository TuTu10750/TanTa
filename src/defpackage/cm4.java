package defpackage;

import android.content.Context;
import android.media.MediaPlayer;
import android.text.TextUtils;

/* loaded from: /tmp/classes2.dex */
public class cm4 {
    public MediaPlayer a;
    public boolean b;
    public boolean c;
    public boolean d;
    public String e;
    public d f;
    public MediaPlayer.OnPreparedListener g = new a();
    public MediaPlayer.OnCompletionListener h = new b();
    public MediaPlayer.OnErrorListener i = new c();

    /* loaded from: /tmp/classes2.dex */
    public class a implements MediaPlayer.OnPreparedListener {
        public a() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            boolean z = cm4.this.d;
            cm4 cm4Var = cm4.this;
            if (z) {
                cm4Var.f();
            } else {
                cm4Var.a.start();
                cm4.this.b = true;
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements MediaPlayer.OnCompletionListener {
        public b() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            cm4.this.b = false;
            cm4.this.e = null;
            if (cm4.this.f != null) {
                cm4.this.f.a();
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c implements MediaPlayer.OnErrorListener {
        public c() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            cm4.this.b = false;
            cm4.this.e = null;
            if (cm4.this.f != null) {
                cm4.this.f.a();
            }
            return false;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface d {
        void a();
    }

    public cm4(Context context) {
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.a = mediaPlayer;
        mediaPlayer.setOnPreparedListener(this.g);
        this.a.setOnErrorListener(this.i);
        this.a.setOnCompletionListener(this.h);
        this.a.setAudioStreamType(3);
    }

    public void f() {
        k();
        MediaPlayer mediaPlayer = this.a;
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        this.f = null;
        this.d = true;
    }

    public void g() {
        MediaPlayer mediaPlayer = this.a;
        if (mediaPlayer == null || !this.b || this.d) {
            return;
        }
        mediaPlayer.pause();
        this.c = true;
    }

    public void h() {
        MediaPlayer mediaPlayer = this.a;
        if (mediaPlayer == null || !this.b || this.d || !this.c) {
            return;
        }
        this.c = false;
        mediaPlayer.start();
    }

    public void i(d dVar) {
        this.f = dVar;
    }

    public void j(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!this.b) {
            this.e = str;
            try {
                this.a.reset();
                this.a.setDataSource(str);
                this.a.setLooping(false);
                this.a.setVolume(1.0f, 1.0f);
                this.a.prepare();
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        if (str.equals(this.e)) {
            return;
        }
        this.e = str;
        this.b = false;
        try {
            this.a.stop();
            this.a.reset();
            this.a.setDataSource(str);
            this.a.setLooping(false);
            this.a.setVolume(1.0f, 1.0f);
            this.a.prepare();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void k() {
        MediaPlayer mediaPlayer = this.a;
        if (mediaPlayer != null && this.b) {
            mediaPlayer.stop();
        }
        this.b = false;
        this.e = null;
    }
}
