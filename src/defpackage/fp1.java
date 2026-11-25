package defpackage;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: /tmp/classes2.dex */
public class fp1 implements wr3 {
    public final InputStream a;
    public final d54 b;

    public fp1(InputStream inputStream, d54 d54Var) {
        inputStream.getClass();
        d54Var.getClass();
        this.a = inputStream;
        this.b = d54Var;
    }

    @Override // defpackage.wr3, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.a.close();
    }

    @Override // defpackage.wr3
    public long read(lk lkVar, long j) {
        lkVar.getClass();
        if (j == 0) {
            return 0L;
        }
        if (j < 0) {
            hk.a("byteCount < 0: ", j);
            return 0L;
        }
        try {
            this.b.throwIfReached();
            gl3 I0 = lkVar.I0(1);
            int read = this.a.read(I0.a, I0.c, (int) Math.min(j, 8192 - I0.c));
            if (read != -1) {
                I0.c += read;
                long j2 = read;
                lkVar.F0(lkVar.size() + j2);
                return j2;
            }
            if (I0.b != I0.c) {
                return -1L;
            }
            lkVar.a = I0.b();
            kl3.b(I0);
            return -1L;
        } catch (AssertionError e) {
            if (qs2.e(e)) {
                throw new IOException(e);
            }
            throw e;
        }
    }

    @Override // defpackage.wr3
    public d54 timeout() {
        return this.b;
    }

    public String toString() {
        return "source(" + this.a + ')';
    }
}
