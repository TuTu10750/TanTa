package defpackage;

import android.os.Looper;

/* loaded from: /tmp/classes2.dex */
public interface ww0 {

    /* loaded from: /tmp/classes2.dex */
    public static final class b {
        public static ww0 a(int i, int i2, int i3) {
            return new ux0(i, i2, i3);
        }
    }

    boolean c();

    void d(boolean z);

    int f();

    vf2 g(int i, int i2);

    long getCurrentPosition();

    long getDuration();

    int h();

    void i(a aVar, int i, Object obj);

    int j(int i);

    void k(int i, int i2);

    void l(c cVar);

    void m(a74... a74VarArr);

    void n(a aVar, int i, Object obj);

    Looper o();

    int p(int i);

    void release();

    void seekTo(long j);

    void stop();
}
