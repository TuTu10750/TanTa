package defpackage;

import java.io.IOException;
import java.util.zip.Deflater;

/* loaded from: /tmp/classes2.dex */
public final class ij0 implements kq3 {
    public final rk a;
    public final Deflater b;
    public boolean c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ij0(kq3 kq3Var, Deflater deflater) {
        this(qs2.c(kq3Var), deflater);
        kq3Var.getClass();
        deflater.getClass();
    }

    public ij0(rk rkVar, Deflater deflater) {
        rkVar.getClass();
        deflater.getClass();
        this.a = rkVar;
        this.b = deflater;
    }

    public final void a(boolean z) {
        gl3 I0;
        int deflate;
        lk k = this.a.k();
        while (true) {
            I0 = k.I0(1);
            Deflater deflater = this.b;
            if (z) {
                try {
                    byte[] bArr = I0.a;
                    int i = I0.c;
                    deflate = deflater.deflate(bArr, i, 8192 - i, 2);
                } catch (NullPointerException e) {
                    throw new IOException("Deflater already closed", e);
                }
            } else {
                byte[] bArr2 = I0.a;
                int i2 = I0.c;
                deflate = deflater.deflate(bArr2, i2, 8192 - i2);
            }
            if (deflate > 0) {
                I0.c += deflate;
                k.F0(k.size() + deflate);
                this.a.F();
            } else if (this.b.needsInput()) {
                break;
            }
        }
        if (I0.b == I0.c) {
            k.a = I0.b();
            kl3.b(I0);
        }
    }

    @Override // defpackage.kq3, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.c) {
            return;
        }
        try {
            g();
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.b.end();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        try {
            this.a.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.c = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // defpackage.kq3, java.io.Flushable
    public void flush() {
        a(true);
        this.a.flush();
    }

    public final void g() {
        this.b.finish();
        a(false);
    }

    @Override // defpackage.kq3
    public d54 timeout() {
        return this.a.timeout();
    }

    public String toString() {
        return "DeflaterSink(" + this.a + ')';
    }

    @Override // defpackage.kq3
    public void write(lk lkVar, long j) {
        lkVar.getClass();
        r.b(lkVar.size(), 0L, j);
        while (j > 0) {
            gl3 gl3Var = lkVar.a;
            gl3Var.getClass();
            int min = (int) Math.min(j, gl3Var.c - gl3Var.b);
            this.b.setInput(gl3Var.a, gl3Var.b, min);
            a(false);
            long j2 = min;
            lkVar.F0(lkVar.size() - j2);
            int i = gl3Var.b + min;
            gl3Var.b = i;
            if (i == gl3Var.c) {
                lkVar.a = gl3Var.b();
                kl3.b(gl3Var);
            }
            j -= j2;
        }
    }
}
