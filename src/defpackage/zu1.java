package defpackage;

import java.io.RandomAccessFile;

/* loaded from: /tmp/classes2.dex */
public final class zu1 extends e11 {
    public final RandomAccessFile e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zu1(boolean z, RandomAccessFile randomAccessFile) {
        super(z);
        randomAccessFile.getClass();
        this.e = randomAccessFile;
    }

    @Override // defpackage.e11
    public synchronized void T() {
        this.e.close();
    }

    @Override // defpackage.e11
    public synchronized int d0(long j, byte[] bArr, int i, int i2) {
        bArr.getClass();
        this.e.seek(j);
        int i3 = 0;
        while (true) {
            if (i3 >= i2) {
                break;
            }
            int read = this.e.read(bArr, i, i2 - i3);
            if (read != -1) {
                i3 += read;
            } else if (i3 == 0) {
                return -1;
            }
        }
        return i3;
    }

    @Override // defpackage.e11
    public synchronized long e0() {
        return this.e.length();
    }
}
