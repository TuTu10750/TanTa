package defpackage;

import java.io.OutputStream;

/* loaded from: /tmp/classes2.dex */
public final class xu2 implements kq3 {
    public final OutputStream a;
    public final d54 b;

    public xu2(OutputStream outputStream, d54 d54Var) {
        outputStream.getClass();
        d54Var.getClass();
        this.a = outputStream;
        this.b = d54Var;
    }

    @Override // defpackage.kq3, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.a.close();
    }

    @Override // defpackage.kq3, java.io.Flushable
    public void flush() {
        this.a.flush();
    }

    @Override // defpackage.kq3
    public d54 timeout() {
        return this.b;
    }

    public String toString() {
        return "sink(" + this.a + ')';
    }

    @Override // defpackage.kq3
    public void write(lk lkVar, long j) {
        lkVar.getClass();
        r.b(lkVar.size(), 0L, j);
        while (j > 0) {
            this.b.throwIfReached();
            gl3 gl3Var = lkVar.a;
            gl3Var.getClass();
            int min = (int) Math.min(j, gl3Var.c - gl3Var.b);
            this.a.write(gl3Var.a, gl3Var.b, min);
            gl3Var.b += min;
            long j2 = min;
            j -= j2;
            lkVar.F0(lkVar.size() - j2);
            if (gl3Var.b == gl3Var.c) {
                lkVar.a = gl3Var.b();
                kl3.b(gl3Var);
            }
        }
    }
}
