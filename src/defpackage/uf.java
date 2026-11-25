package defpackage;

import android.util.Log;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

/* loaded from: /tmp/classes2.dex */
public final class uf implements Runnable {
    public final px2 a = new px2();
    public final zu0 b;
    public volatile boolean c;

    public uf(zu0 zu0Var) {
        this.b = zu0Var;
    }

    public void a(uw3 uw3Var, Object obj) {
        ox2 a = ox2.a(uw3Var, obj);
        synchronized (this) {
            try {
                this.a.a(a);
                if (!this.c) {
                    this.c = true;
                    this.b.d().execute(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        while (true) {
            try {
                try {
                    ox2 c = this.a.c(IjkMediaCodecInfo.RANK_MAX);
                    if (c == null) {
                        synchronized (this) {
                            c = this.a.b();
                            if (c == null) {
                                this.c = false;
                                this.c = false;
                                return;
                            }
                        }
                    }
                    this.b.f(c);
                } catch (InterruptedException e) {
                    Log.w("Event", Thread.currentThread().getName() + " was interruppted", e);
                    this.c = false;
                    return;
                }
            } catch (Throwable th) {
                this.c = false;
                throw th;
            }
        }
    }
}
