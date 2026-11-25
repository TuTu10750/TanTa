package defpackage;

import android.text.TextUtils;
import java.io.File;
import java.io.FileWriter;

/* loaded from: /tmp/classes2.dex */
public abstract class u72 {
    public static void a(File file, String str) {
        FileWriter fileWriter;
        if (file == null || TextUtils.isEmpty(str)) {
            return;
        }
        FileWriter fileWriter2 = null;
        try {
            try {
                try {
                    fileWriter = new FileWriter(file, true);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e) {
                e = e;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            fileWriter.write(str);
            fileWriter.close();
        } catch (Exception e3) {
            e = e3;
            fileWriter2 = fileWriter;
            e.printStackTrace();
            if (fileWriter2 != null) {
                fileWriter2.close();
            }
        } catch (Throwable th2) {
            th = th2;
            fileWriter2 = fileWriter;
            if (fileWriter2 != null) {
                try {
                    fileWriter2.close();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
    }
}
