package defpackage;

import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import okio.ByteString;

/* loaded from: /tmp/classes2.dex */
public interface sk extends wr3, ReadableByteChannel {
    boolean B();

    long C(byte b, long j, long j2);

    long D(ByteString byteString);

    long G();

    String I(long j);

    long P(kq3 kq3Var);

    boolean R(long j, ByteString byteString);

    String S(Charset charset);

    ByteString Z();

    boolean c0(long j);

    String f(long j);

    String g0();

    ByteString h(long j);

    int h0();

    byte[] i0(long j);

    lk k();

    short n0();

    long p0();

    sk peek();

    void r0(long j);

    byte readByte();

    void readFully(byte[] bArr);

    int readInt();

    long readLong();

    short readShort();

    void skip(long j);

    int t(ju2 ju2Var);

    long v0();

    InputStream w0();

    void x0(lk lkVar, long j);

    byte[] y();

    long z(ByteString byteString);
}
