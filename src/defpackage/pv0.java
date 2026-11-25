package defpackage;

import java.io.File;

/* loaded from: /tmp/classes2.dex */
public abstract class pv0 {
    public static final String b(File file, File file2, String str) {
        StringBuilder sb = new StringBuilder(file.toString());
        if (file2 != null) {
            sb.append(" -> " + file2);
        }
        if (str != null) {
            sb.append(": ".concat(str));
        }
        return sb.toString();
    }
}
