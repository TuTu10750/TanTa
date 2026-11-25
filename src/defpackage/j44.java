package defpackage;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: /tmp/classes2.dex */
public class j44 {
    public static final /* synthetic */ AtomicIntegerFieldUpdater b = AtomicIntegerFieldUpdater.newUpdater(j44.class, "_size$volatile");
    private volatile /* synthetic */ int _size$volatile;
    public k44[] a;

    public final void a(k44 k44Var) {
        k44Var.c(this);
        k44[] g = g();
        int c = c();
        k(c + 1);
        g[c] = k44Var;
        k44Var.setIndex(c);
        m(c);
    }

    public final k44 b() {
        k44[] k44VarArr = this.a;
        if (k44VarArr != null) {
            return k44VarArr[0];
        }
        return null;
    }

    public final int c() {
        return b.get(this);
    }

    public final boolean e() {
        return c() == 0;
    }

    public final k44 f() {
        k44 b2;
        synchronized (this) {
            b2 = b();
        }
        return b2;
    }

    public final k44[] g() {
        k44[] k44VarArr = this.a;
        if (k44VarArr == null) {
            k44[] k44VarArr2 = new k44[4];
            this.a = k44VarArr2;
            return k44VarArr2;
        }
        if (c() < k44VarArr.length) {
            return k44VarArr;
        }
        k44[] k44VarArr3 = (k44[]) Arrays.copyOf(k44VarArr, c() * 2);
        this.a = k44VarArr3;
        return k44VarArr3;
    }

    public final boolean h(k44 k44Var) {
        boolean z;
        synchronized (this) {
            if (k44Var.a() == null) {
                z = false;
            } else {
                i(k44Var.getIndex());
                z = true;
            }
        }
        return z;
    }

    public final k44 i(int i) {
        k44[] k44VarArr = this.a;
        k44VarArr.getClass();
        k(c() - 1);
        if (i < c()) {
            n(i, c());
            int i2 = (i - 1) / 2;
            if (i > 0) {
                k44 k44Var = k44VarArr[i];
                k44Var.getClass();
                k44 k44Var2 = k44VarArr[i2];
                k44Var2.getClass();
                if (((Comparable) k44Var).compareTo(k44Var2) < 0) {
                    n(i, i2);
                    m(i2);
                }
            }
            l(i);
        }
        k44 k44Var3 = k44VarArr[c()];
        k44Var3.getClass();
        k44Var3.c(null);
        k44Var3.setIndex(-1);
        k44VarArr[c()] = null;
        return k44Var3;
    }

    public final k44 j() {
        k44 i;
        synchronized (this) {
            i = c() > 0 ? i(0) : null;
        }
        return i;
    }

    public final void k(int i) {
        b.set(this, i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0028, code lost:
    
        if (((java.lang.Comparable) r3).compareTo(r4) < 0) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(int r6) {
        /*
            r5 = this;
        L0:
            int r0 = r6 * 2
            int r1 = r0 + 1
            int r2 = r5.c()
            if (r1 < r2) goto Lb
            goto L3e
        Lb:
            k44[] r2 = r5.a
            r2.getClass()
            int r0 = r0 + 2
            int r3 = r5.c()
            if (r0 >= r3) goto L2b
            r3 = r2[r0]
            r3.getClass()
            java.lang.Comparable r3 = (java.lang.Comparable) r3
            r4 = r2[r1]
            r4.getClass()
            int r3 = r3.compareTo(r4)
            if (r3 >= 0) goto L2b
            goto L2c
        L2b:
            r0 = r1
        L2c:
            r1 = r2[r6]
            r1.getClass()
            java.lang.Comparable r1 = (java.lang.Comparable) r1
            r2 = r2[r0]
            r2.getClass()
            int r1 = r1.compareTo(r2)
            if (r1 > 0) goto L3f
        L3e:
            return
        L3f:
            r5.n(r6, r0)
            r6 = r0
            goto L0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.j44.l(int):void");
    }

    public final void m(int i) {
        while (i > 0) {
            k44[] k44VarArr = this.a;
            k44VarArr.getClass();
            int i2 = (i - 1) / 2;
            k44 k44Var = k44VarArr[i2];
            k44Var.getClass();
            k44 k44Var2 = k44VarArr[i];
            k44Var2.getClass();
            if (((Comparable) k44Var).compareTo(k44Var2) <= 0) {
                return;
            }
            n(i, i2);
            i = i2;
        }
    }

    public final void n(int i, int i2) {
        k44[] k44VarArr = this.a;
        k44VarArr.getClass();
        k44 k44Var = k44VarArr[i2];
        k44Var.getClass();
        k44 k44Var2 = k44VarArr[i];
        k44Var2.getClass();
        k44VarArr[i] = k44Var;
        k44VarArr[i2] = k44Var2;
        k44Var.setIndex(i);
        k44Var2.setIndex(i2);
    }
}
