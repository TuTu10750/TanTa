package defpackage;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* loaded from: /tmp/classes2.dex */
public final class lo1 implements wr3 {
    public final sk a;
    public final Inflater b;
    public int c;
    public boolean d;

    public lo1(sk skVar, Inflater inflater) {
        skVar.getClass();
        inflater.getClass();
        this.a = skVar;
        this.b = inflater;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public lo1(wr3 wr3Var, Inflater inflater) {
        this(qs2.d(wr3Var), inflater);
        wr3Var.getClass();
        inflater.getClass();
    }

    public final void H() {
        int i = this.c;
        if (i == 0) {
            return;
        }
        int remaining = i - this.b.getRemaining();
        this.c -= remaining;
        this.a.skip(remaining);
    }

    public final long a(lk lkVar, long j) {
        lkVar.getClass();
        if (j < 0) {
            hk.a("byteCount < 0: ", j);
            return 0L;
        }
        if (this.d) {
            fl3.a("closed");
            return 0L;
        }
        if (j == 0) {
            return 0L;
        }
        try {
            gl3 I0 = lkVar.I0(1);
            int min = (int) Math.min(j, 8192 - I0.c);
            g();
            int inflate = this.b.inflate(I0.a, I0.c, min);
            H();
            if (inflate > 0) {
                I0.c += inflate;
                long j2 = inflate;
                lkVar.F0(lkVar.size() + j2);
                return j2;
            }
            if (I0.b == I0.c) {
                lkVar.a = I0.b();
                kl3.b(I0);
            }
            return 0L;
        } catch (DataFormatException e) {
            throw new IOException(e);
        }
    }

    @Override // defpackage.wr3, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.d) {
            return;
        }
        this.b.end();
        this.d = true;
        this.a.close();
    }

    public final boolean g() {
        if (!this.b.needsInput()) {
            return false;
        }
        if (this.a.B()) {
            return true;
        }
        gl3 gl3Var = this.a.k().a;
        gl3Var.getClass();
        int i = gl3Var.c;
        int i2 = gl3Var.b;
        int i3 = i - i2;
        this.c = i3;
        this.b.setInput(gl3Var.a, i2, i3);
        return false;
    }

    @Override // defpackage.wr3
    public long read(lk lkVar, long j) {
        lkVar.getClass();
        do {
            long a = a(lkVar, j);
            if (a > 0) {
                return a;
            }
            if (this.b.finished() || this.b.needsDictionary()) {
                return -1L;
            }
        } while (!this.a.B());
        throw new EOFException("source exhausted prematurely");
    }

    @Override // defpackage.wr3
    public d54 timeout() {
        return this.a.timeout();
    }
}
