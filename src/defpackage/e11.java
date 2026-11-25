package defpackage;

import java.io.Closeable;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: /tmp/classes2.dex */
public abstract class e11 implements Closeable {
    public final boolean a;
    public boolean b;
    public int c;
    public final ReentrantLock d = ir4.b();

    /* loaded from: /tmp/classes2.dex */
    public static final class a implements wr3 {
        public final e11 a;
        public long b;
        public boolean c;

        public a(e11 e11Var, long j) {
            e11Var.getClass();
            this.a = e11Var;
            this.b = j;
        }

        @Override // defpackage.wr3, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.c) {
                return;
            }
            this.c = true;
            ReentrantLock H = this.a.H();
            H.lock();
            try {
                e11 e11Var = this.a;
                e11Var.c--;
                if (this.a.c == 0 && this.a.b) {
                    qc4 qc4Var = qc4.a;
                    H.unlock();
                    this.a.T();
                }
            } finally {
                H.unlock();
            }
        }

        @Override // defpackage.wr3
        public long read(lk lkVar, long j) {
            lkVar.getClass();
            if (this.c) {
                fl3.a("closed");
                return 0L;
            }
            long k0 = this.a.k0(this.b, lkVar, j);
            if (k0 != -1) {
                this.b += k0;
            }
            return k0;
        }

        @Override // defpackage.wr3
        public d54 timeout() {
            return d54.NONE;
        }
    }

    public e11(boolean z) {
        this.a = z;
    }

    public final ReentrantLock H() {
        return this.d;
    }

    public abstract void T();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        ReentrantLock reentrantLock = this.d;
        reentrantLock.lock();
        try {
            if (this.b) {
                return;
            }
            this.b = true;
            if (this.c != 0) {
                return;
            }
            qc4 qc4Var = qc4.a;
            reentrantLock.unlock();
            T();
        } finally {
            reentrantLock.unlock();
        }
    }

    public abstract int d0(long j, byte[] bArr, int i, int i2);

    public abstract long e0();

    public final long k0(long j, lk lkVar, long j2) {
        if (j2 < 0) {
            hk.a("byteCount < 0: ", j2);
            return 0L;
        }
        long j3 = j2 + j;
        long j4 = j;
        while (true) {
            if (j4 >= j3) {
                break;
            }
            gl3 I0 = lkVar.I0(1);
            int d0 = d0(j4, I0.a, I0.c, (int) Math.min(j3 - j4, 8192 - r7));
            if (d0 == -1) {
                if (I0.b == I0.c) {
                    lkVar.a = I0.b();
                    kl3.b(I0);
                }
                if (j == j4) {
                    return -1L;
                }
            } else {
                I0.c += d0;
                long j5 = d0;
                j4 += j5;
                lkVar.F0(lkVar.size() + j5);
            }
        }
        return j4 - j;
    }

    public final wr3 m0(long j) {
        ReentrantLock reentrantLock = this.d;
        reentrantLock.lock();
        try {
            if (this.b) {
                throw new IllegalStateException("closed");
            }
            this.c++;
            reentrantLock.unlock();
            return new a(this, j);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final long size() {
        ReentrantLock reentrantLock = this.d;
        reentrantLock.lock();
        try {
            if (this.b) {
                throw new IllegalStateException("closed");
            }
            qc4 qc4Var = qc4.a;
            reentrantLock.unlock();
            return e0();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}
