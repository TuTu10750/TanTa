package defpackage;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: /tmp/classes2.dex */
public final class kl3 {
    public static final kl3 a = new kl3();
    public static final int b = 65536;
    public static final gl3 c = new gl3(new byte[0], 0, 0, false, false);
    public static final int d;
    public static final AtomicReference[] e;

    static {
        int highestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        d = highestOneBit;
        AtomicReference[] atomicReferenceArr = new AtomicReference[highestOneBit];
        for (int i = 0; i < highestOneBit; i++) {
            atomicReferenceArr[i] = new AtomicReference();
        }
        e = atomicReferenceArr;
    }

    public static final void b(gl3 gl3Var) {
        gl3Var.getClass();
        if (gl3Var.f != null || gl3Var.g != null) {
            ik.a("Failed requirement.");
            return;
        }
        if (gl3Var.d) {
            return;
        }
        AtomicReference a2 = a.a();
        gl3 gl3Var2 = c;
        gl3 gl3Var3 = (gl3) a2.getAndSet(gl3Var2);
        if (gl3Var3 == gl3Var2) {
            return;
        }
        int i = gl3Var3 != null ? gl3Var3.c : 0;
        if (i >= b) {
            a2.set(gl3Var3);
            return;
        }
        gl3Var.f = gl3Var3;
        gl3Var.b = 0;
        gl3Var.c = i + 8192;
        a2.set(gl3Var);
    }

    public static final gl3 c() {
        AtomicReference a2 = a.a();
        gl3 gl3Var = c;
        gl3 gl3Var2 = (gl3) a2.getAndSet(gl3Var);
        if (gl3Var2 == gl3Var) {
            return new gl3();
        }
        if (gl3Var2 == null) {
            a2.set(null);
            return new gl3();
        }
        a2.set(gl3Var2.f);
        gl3Var2.f = null;
        gl3Var2.c = 0;
        return gl3Var2;
    }

    public final AtomicReference a() {
        return e[(int) (Thread.currentThread().getId() & (d - 1))];
    }
}
