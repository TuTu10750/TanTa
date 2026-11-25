package defpackage;

/* loaded from: /tmp/classes2.dex */
public abstract class ym3 {
    public static final int a;
    public static final p04 b;
    public static final p04 c;
    public static final p04 d;
    public static final p04 e;
    public static final int f;

    static {
        int e2;
        int e3;
        e2 = p14.e("kotlinx.coroutines.semaphore.maxSpinCycles", 100, 0, 0, 12, null);
        a = e2;
        b = new p04("PERMIT");
        c = new p04("TAKEN");
        d = new p04("BROKEN");
        e = new p04("CANCELLED");
        e3 = p14.e("kotlinx.coroutines.semaphore.segmentSize", 16, 0, 0, 12, null);
        f = e3;
    }

    public static final vm3 a(int i, int i2) {
        return new xm3(i, i2);
    }

    public static /* synthetic */ vm3 b(int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return a(i, i2);
    }

    public static final /* synthetic */ p04 d() {
        return d;
    }

    public static final /* synthetic */ p04 e() {
        return e;
    }

    public static final /* synthetic */ int f() {
        return a;
    }

    public static final /* synthetic */ p04 g() {
        return b;
    }

    public static final /* synthetic */ int h() {
        return f;
    }

    public static final /* synthetic */ p04 i() {
        return c;
    }

    public static final zm3 j(long j, zm3 zm3Var) {
        return new zm3(j, zm3Var, 0);
    }
}
