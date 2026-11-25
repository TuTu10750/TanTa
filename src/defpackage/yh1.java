package defpackage;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;

/* loaded from: /tmp/classes2.dex */
public abstract class yh1 {
    public static final char a = File.separatorChar;
    public static final String b;

    static {
        StringWriter stringWriter = new StringWriter(4);
        new PrintWriter(stringWriter).println();
        b = stringWriter.toString();
    }

    public static int a(InputStream inputStream, OutputStream outputStream) {
        long b2 = b(inputStream, outputStream);
        if (b2 > 2147483647L) {
            return -1;
        }
        return (int) b2;
    }

    public static long b(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[4096];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += read;
        }
    }

    public static byte[] c(InputStream inputStream) {
        em emVar = new em();
        a(inputStream, emVar);
        return emVar.g();
    }
}
