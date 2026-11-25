package defpackage;

import java.nio.channels.WritableByteChannel;
import okio.ByteString;

/* loaded from: /tmp/classes2.dex */
public interface rk extends kq3, WritableByteChannel {
    rk A(int i);

    long E(wr3 wr3Var);

    rk F();

    rk O(String str);

    rk W(String str, int i, int i2);

    rk X(long j);

    @Override // defpackage.kq3, java.io.Flushable
    void flush();

    lk k();

    rk l0(ByteString byteString);

    lk q();

    rk s();

    rk t0(long j);

    rk w(long j);

    rk write(byte[] bArr);

    rk write(byte[] bArr, int i, int i2);

    rk writeByte(int i);

    rk writeInt(int i);

    rk writeShort(int i);
}
