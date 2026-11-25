package defpackage;

/* loaded from: /tmp/classes2.dex */
public final class nx2 implements wr3 {
    public final sk a;
    public final lk b;
    public gl3 c;
    public int d;
    public boolean e;
    public long f;

    public nx2(sk skVar) {
        skVar.getClass();
        this.a = skVar;
        lk k = skVar.k();
        this.b = k;
        gl3 gl3Var = k.a;
        this.c = gl3Var;
        this.d = gl3Var != null ? gl3Var.b : -1;
    }

    @Override // defpackage.wr3, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.e = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001e, code lost:
    
        if (r3 == r4.b) goto L16;
     */
    @Override // defpackage.wr3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long read(defpackage.lk r9, long r10) {
        /*
            r8 = this;
            r9.getClass()
            r0 = 0
            int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r2 < 0) goto L70
            boolean r3 = r8.e
            if (r3 != 0) goto L6a
            gl3 r3 = r8.c
            if (r3 == 0) goto L29
            lk r4 = r8.b
            gl3 r4 = r4.a
            if (r3 != r4) goto L21
            int r3 = r8.d
            r4.getClass()
            int r4 = r4.b
            if (r3 != r4) goto L21
            goto L29
        L21:
            java.lang.String r8 = "Peek source is invalid because upstream source was used"
            defpackage.fl3.a(r8)
        L26:
            r8 = 0
            return r8
        L29:
            if (r2 != 0) goto L2c
            return r0
        L2c:
            sk r0 = r8.a
            long r1 = r8.f
            r3 = 1
            long r1 = r1 + r3
            boolean r0 = r0.c0(r1)
            if (r0 != 0) goto L3c
            r8 = -1
            return r8
        L3c:
            gl3 r0 = r8.c
            if (r0 != 0) goto L4f
            lk r0 = r8.b
            gl3 r0 = r0.a
            if (r0 == 0) goto L4f
            r8.c = r0
            r0.getClass()
            int r0 = r0.b
            r8.d = r0
        L4f:
            lk r0 = r8.b
            long r0 = r0.size()
            long r2 = r8.f
            long r0 = r0 - r2
            long r6 = java.lang.Math.min(r10, r0)
            lk r2 = r8.b
            long r4 = r8.f
            r3 = r9
            r2.e0(r3, r4, r6)
            long r9 = r8.f
            long r9 = r9 + r6
            r8.f = r9
            return r6
        L6a:
            java.lang.String r8 = "closed"
            defpackage.fl3.a(r8)
            goto L26
        L70:
            java.lang.String r8 = "byteCount < 0: "
            defpackage.hk.a(r8, r10)
            goto L26
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.nx2.read(lk, long):long");
    }

    @Override // defpackage.wr3
    public d54 timeout() {
        return this.a.timeout();
    }
}
