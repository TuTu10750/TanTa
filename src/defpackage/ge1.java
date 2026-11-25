package defpackage;

import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* loaded from: /tmp/classes2.dex */
public final class ge1 implements wr3 {
    public byte a;
    public final qb3 b;
    public final Inflater c;
    public final lo1 d;
    public final CRC32 e;

    public ge1(wr3 wr3Var) {
        wr3Var.getClass();
        qb3 qb3Var = new qb3(wr3Var);
        this.b = qb3Var;
        Inflater inflater = new Inflater(true);
        this.c = inflater;
        this.d = new lo1((sk) qb3Var, inflater);
        this.e = new CRC32();
    }

    public final void H() {
        a("CRC", this.b.h0(), (int) this.e.getValue());
        a("ISIZE", this.b.h0(), (int) this.c.getBytesWritten());
    }

    public final void T(lk lkVar, long j, long j2) {
        gl3 gl3Var = lkVar.a;
        gl3Var.getClass();
        while (true) {
            int i = gl3Var.c;
            int i2 = gl3Var.b;
            if (j < i - i2) {
                break;
            }
            j -= i - i2;
            gl3Var = gl3Var.f;
            gl3Var.getClass();
        }
        while (j2 > 0) {
            int min = (int) Math.min(gl3Var.c - r6, j2);
            this.e.update(gl3Var.a, (int) (gl3Var.b + j), min);
            j2 -= min;
            gl3Var = gl3Var.f;
            gl3Var.getClass();
            j = 0;
        }
    }

    public final void a(String str, int i, int i2) {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i)}, 3)));
        }
    }

    @Override // defpackage.wr3, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.d.close();
    }

    public final void g() {
        this.b.r0(10L);
        byte q0 = this.b.b.q0(3L);
        boolean z = ((q0 >> 1) & 1) == 1;
        if (z) {
            T(this.b.b, 0L, 10L);
        }
        a("ID1ID2", 8075, this.b.readShort());
        this.b.skip(8L);
        if (((q0 >> 2) & 1) == 1) {
            this.b.r0(2L);
            if (z) {
                T(this.b.b, 0L, 2L);
            }
            long n0 = this.b.b.n0() & 65535;
            this.b.r0(n0);
            if (z) {
                T(this.b.b, 0L, n0);
            }
            this.b.skip(n0);
        }
        if (((q0 >> 3) & 1) == 1) {
            long b = this.b.b((byte) 0);
            if (b == -1) {
                gk.a();
                return;
            } else {
                if (z) {
                    T(this.b.b, 0L, b + 1);
                }
                this.b.skip(b + 1);
            }
        }
        if (((q0 >> 4) & 1) == 1) {
            long b2 = this.b.b((byte) 0);
            if (b2 == -1) {
                gk.a();
                return;
            } else {
                if (z) {
                    T(this.b.b, 0L, b2 + 1);
                }
                this.b.skip(b2 + 1);
            }
        }
        if (z) {
            a("FHCRC", this.b.n0(), (short) this.e.getValue());
            this.e.reset();
        }
    }

    @Override // defpackage.wr3
    public long read(lk lkVar, long j) {
        lkVar.getClass();
        if (j < 0) {
            hk.a("byteCount < 0: ", j);
            return 0L;
        }
        if (j == 0) {
            return 0L;
        }
        if (this.a == 0) {
            g();
            this.a = (byte) 1;
        }
        if (this.a == 1) {
            long size = lkVar.size();
            long read = this.d.read(lkVar, j);
            if (read != -1) {
                T(lkVar, size, read);
                return read;
            }
            this.a = (byte) 2;
        }
        if (this.a == 2) {
            H();
            this.a = (byte) 3;
            if (!this.b.B()) {
                fe1.a("gzip finished without exhausting source");
                return 0L;
            }
        }
        return -1L;
    }

    @Override // defpackage.wr3
    public d54 timeout() {
        return this.b.timeout();
    }
}
