package defpackage;

import defpackage.lk;

/* loaded from: /tmp/classes2.dex */
public abstract class b {
    public static final byte[] a = ir4.a("0123456789abcdef");

    public static final lk.b a(lk lkVar, lk.b bVar) {
        lkVar.getClass();
        bVar.getClass();
        lk.b g = r.g(bVar);
        if (g.a != null) {
            fl3.a("already attached to a buffer");
            return null;
        }
        g.a = lkVar;
        g.b = true;
        return g;
    }

    public static final byte[] b() {
        return a;
    }

    public static final boolean c(gl3 gl3Var, int i, byte[] bArr, int i2, int i3) {
        gl3Var.getClass();
        bArr.getClass();
        int i4 = gl3Var.c;
        byte[] bArr2 = gl3Var.a;
        while (i2 < i3) {
            if (i == i4) {
                gl3Var = gl3Var.f;
                gl3Var.getClass();
                byte[] bArr3 = gl3Var.a;
                bArr2 = bArr3;
                i = gl3Var.b;
                i4 = gl3Var.c;
            }
            if (bArr2[i] != bArr[i2]) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    public static final String d(lk lkVar, long j) {
        lkVar.getClass();
        if (j > 0) {
            long j2 = j - 1;
            if (lkVar.q0(j2) == 13) {
                String f = lkVar.f(j2);
                lkVar.skip(2L);
                return f;
            }
        }
        String f2 = lkVar.f(j);
        lkVar.skip(1L);
        return f2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x005e, code lost:
    
        if (r19 == false) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0060, code lost:
    
        return -2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final int e(defpackage.lk r17, defpackage.ju2 r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 166
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.b.e(lk, ju2, boolean):int");
    }

    public static /* synthetic */ int f(lk lkVar, ju2 ju2Var, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return e(lkVar, ju2Var, z);
    }
}
