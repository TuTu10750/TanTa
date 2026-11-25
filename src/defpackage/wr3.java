package defpackage;

import java.io.Closeable;

/* loaded from: /tmp/classes2.dex */
public interface wr3 extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    long read(lk lkVar, long j);

    d54 timeout();
}
