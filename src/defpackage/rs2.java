package defpackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;

/* loaded from: /tmp/classes2.dex */
public abstract /* synthetic */ class rs2 {
    public static final Logger a = Logger.getLogger("okio.Okio");

    public static final kq3 b(File file) {
        file.getClass();
        return qs2.g(new FileOutputStream(file, true));
    }

    public static final boolean c(AssertionError assertionError) {
        assertionError.getClass();
        if (assertionError.getCause() != null) {
            String message = assertionError.getMessage();
            if (message != null ? hw3.O(message, "getsockname failed", false, 2, null) : false) {
                return true;
            }
        }
        return false;
    }

    public static final kq3 d(File file, boolean z) {
        file.getClass();
        return qs2.g(new FileOutputStream(file, z));
    }

    public static final kq3 e(OutputStream outputStream) {
        outputStream.getClass();
        return new xu2(outputStream, new d54());
    }

    public static final kq3 f(Socket socket) {
        socket.getClass();
        ir3 ir3Var = new ir3(socket);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.getClass();
        return ir3Var.sink(new xu2(outputStream, ir3Var));
    }

    public static /* synthetic */ kq3 g(File file, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return qs2.f(file, z);
    }

    public static final wr3 h(File file) {
        file.getClass();
        return new fp1(new FileInputStream(file), d54.NONE);
    }

    public static final wr3 i(InputStream inputStream) {
        inputStream.getClass();
        return new fp1(inputStream, new d54());
    }

    public static final wr3 j(Socket socket) {
        socket.getClass();
        ir3 ir3Var = new ir3(socket);
        InputStream inputStream = socket.getInputStream();
        inputStream.getClass();
        return ir3Var.source(new fp1(inputStream, ir3Var));
    }
}
