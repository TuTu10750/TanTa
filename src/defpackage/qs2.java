package defpackage;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/* loaded from: /tmp/classes2.dex */
public abstract class qs2 {
    public static final kq3 a(File file) {
        return rs2.b(file);
    }

    public static final kq3 b() {
        return ss2.a();
    }

    public static final rk c(kq3 kq3Var) {
        return ss2.b(kq3Var);
    }

    public static final sk d(wr3 wr3Var) {
        return ss2.c(wr3Var);
    }

    public static final boolean e(AssertionError assertionError) {
        return rs2.c(assertionError);
    }

    public static final kq3 f(File file, boolean z) {
        return rs2.d(file, z);
    }

    public static final kq3 g(OutputStream outputStream) {
        return rs2.e(outputStream);
    }

    public static final kq3 h(Socket socket) {
        return rs2.f(socket);
    }

    public static final wr3 j(File file) {
        return rs2.h(file);
    }

    public static final wr3 k(InputStream inputStream) {
        return rs2.i(inputStream);
    }

    public static final wr3 l(Socket socket) {
        return rs2.j(socket);
    }
}
