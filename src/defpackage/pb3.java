package defpackage;

import java.nio.ByteBuffer;
import okio.ByteString;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: /tmp/classes2.dex */
public final class pb3 implements rk {
    public final kq3 a;
    public final lk b;
    public boolean c;

    public pb3(kq3 kq3Var) {
        kq3Var.getClass();
        this.a = kq3Var;
        this.b = new lk();
    }

    @Override // defpackage.rk
    public rk A(int i) {
        if (this.c) {
            fl3.a("closed");
            return null;
        }
        this.b.A(i);
        return F();
    }

    @Override // defpackage.rk
    public long E(wr3 wr3Var) {
        wr3Var.getClass();
        long j = 0;
        while (true) {
            long read = wr3Var.read(this.b, IjkMediaMeta.AV_CH_TOP_FRONT_CENTER);
            if (read == -1) {
                return j;
            }
            j += read;
            F();
        }
    }

    @Override // defpackage.rk
    public rk F() {
        if (this.c) {
            fl3.a("closed");
            return null;
        }
        long T = this.b.T();
        if (T > 0) {
            this.a.write(this.b, T);
        }
        return this;
    }

    @Override // defpackage.rk
    public rk O(String str) {
        str.getClass();
        if (this.c) {
            fl3.a("closed");
            return null;
        }
        this.b.O(str);
        return F();
    }

    @Override // defpackage.rk
    public rk W(String str, int i, int i2) {
        str.getClass();
        if (this.c) {
            fl3.a("closed");
            return null;
        }
        this.b.W(str, i, i2);
        return F();
    }

    @Override // defpackage.rk
    public rk X(long j) {
        if (this.c) {
            fl3.a("closed");
            return null;
        }
        this.b.X(j);
        return F();
    }

    @Override // defpackage.kq3, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.c) {
            return;
        }
        try {
            if (this.b.size() > 0) {
                kq3 kq3Var = this.a;
                lk lkVar = this.b;
                kq3Var.write(lkVar, lkVar.size());
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.a.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.c = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // defpackage.rk, defpackage.kq3, java.io.Flushable
    public void flush() {
        if (this.c) {
            fl3.a("closed");
            return;
        }
        if (this.b.size() > 0) {
            kq3 kq3Var = this.a;
            lk lkVar = this.b;
            kq3Var.write(lkVar, lkVar.size());
        }
        this.a.flush();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.c;
    }

    @Override // defpackage.rk
    public lk k() {
        return this.b;
    }

    @Override // defpackage.rk
    public rk l0(ByteString byteString) {
        byteString.getClass();
        if (this.c) {
            fl3.a("closed");
            return null;
        }
        this.b.l0(byteString);
        return F();
    }

    @Override // defpackage.rk
    public lk q() {
        return this.b;
    }

    @Override // defpackage.rk
    public rk s() {
        if (this.c) {
            fl3.a("closed");
            return null;
        }
        long size = this.b.size();
        if (size > 0) {
            this.a.write(this.b, size);
        }
        return this;
    }

    @Override // defpackage.rk
    public rk t0(long j) {
        if (this.c) {
            fl3.a("closed");
            return null;
        }
        this.b.t0(j);
        return F();
    }

    @Override // defpackage.kq3
    public d54 timeout() {
        return this.a.timeout();
    }

    public String toString() {
        return "buffer(" + this.a + ')';
    }

    @Override // defpackage.rk
    public rk w(long j) {
        if (this.c) {
            fl3.a("closed");
            return null;
        }
        this.b.w(j);
        return F();
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        byteBuffer.getClass();
        if (this.c) {
            fl3.a("closed");
            return 0;
        }
        int write = this.b.write(byteBuffer);
        F();
        return write;
    }

    @Override // defpackage.rk
    public rk write(byte[] bArr) {
        bArr.getClass();
        if (this.c) {
            fl3.a("closed");
            return null;
        }
        this.b.write(bArr);
        return F();
    }

    @Override // defpackage.rk
    public rk write(byte[] bArr, int i, int i2) {
        bArr.getClass();
        if (this.c) {
            fl3.a("closed");
            return null;
        }
        this.b.write(bArr, i, i2);
        return F();
    }

    @Override // defpackage.kq3
    public void write(lk lkVar, long j) {
        lkVar.getClass();
        if (this.c) {
            fl3.a("closed");
        } else {
            this.b.write(lkVar, j);
            F();
        }
    }

    @Override // defpackage.rk
    public rk writeByte(int i) {
        if (this.c) {
            fl3.a("closed");
            return null;
        }
        this.b.writeByte(i);
        return F();
    }

    @Override // defpackage.rk
    public rk writeInt(int i) {
        if (this.c) {
            fl3.a("closed");
            return null;
        }
        this.b.writeInt(i);
        return F();
    }

    @Override // defpackage.rk
    public rk writeShort(int i) {
        if (this.c) {
            fl3.a("closed");
            return null;
        }
        this.b.writeShort(i);
        return F();
    }
}
