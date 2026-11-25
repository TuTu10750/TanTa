package defpackage;

import java.io.File;
import java.io.RandomAccessFile;
import tv.danmaku.ijk.media.player.misc.IMediaDataSource;

/* loaded from: /tmp/classes2.dex */
public class j11 implements IMediaDataSource {
    public RandomAccessFile a;
    public long b;

    public j11(File file) {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        this.a = randomAccessFile;
        this.b = randomAccessFile.length();
    }

    @Override // tv.danmaku.ijk.media.player.misc.IMediaDataSource
    public void close() {
        this.b = 0L;
        this.a.close();
        this.a = null;
    }

    @Override // tv.danmaku.ijk.media.player.misc.IMediaDataSource
    public long getSize() {
        return this.b;
    }

    @Override // tv.danmaku.ijk.media.player.misc.IMediaDataSource
    public int readAt(long j, byte[] bArr, int i, int i2) {
        if (this.a.getFilePointer() != j) {
            this.a.seek(j);
        }
        if (i2 == 0) {
            return 0;
        }
        return this.a.read(bArr, 0, i2);
    }
}
