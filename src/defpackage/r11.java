package defpackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/* loaded from: /tmp/classes2.dex */
public abstract class r11 {
    public static void a(File file, String str, String str2) {
        PrintWriter printWriter;
        PrintWriter printWriter2 = null;
        try {
            try {
                printWriter = new PrintWriter(new FileOutputStream(new File(file, str2)));
            } catch (Throwable th) {
                th = th;
            }
        } catch (FileNotFoundException e) {
            e = e;
        }
        try {
            printWriter.write(str);
            printWriter.flush();
            printWriter.close();
        } catch (FileNotFoundException e2) {
            e = e2;
            printWriter2 = printWriter;
            e.printStackTrace();
            if (printWriter2 != null) {
                printWriter2.close();
            }
        } catch (Throwable th2) {
            th = th2;
            printWriter2 = printWriter;
            if (printWriter2 != null) {
                printWriter2.close();
            }
            throw th;
        }
    }
}
