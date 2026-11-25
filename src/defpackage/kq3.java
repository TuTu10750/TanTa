package defpackage;

import java.io.Closeable;
import java.io.Flushable;

/* loaded from: /tmp/classes2.dex */
public interface kq3 extends Closeable, Flushable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    void flush();

    d54 timeout();

    void write(lk lkVar, long j);
}
