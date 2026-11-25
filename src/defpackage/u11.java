package defpackage;

import java.io.File;

/* loaded from: /tmp/classes2.dex */
public abstract class u11 {
    public static final int a(String str) {
        int Z;
        char c = File.separatorChar;
        int Z2 = hw3.Z(str, c, 0, false, 4, null);
        if (Z2 == 0) {
            if (str.length() <= 1 || str.charAt(1) != c || (Z = hw3.Z(str, c, 2, false, 4, null)) < 0) {
                return 1;
            }
            int Z3 = hw3.Z(str, c, Z + 1, false, 4, null);
            return Z3 >= 0 ? Z3 + 1 : str.length();
        }
        if (Z2 > 0 && str.charAt(Z2 - 1) == ':') {
            return Z2 + 1;
        }
        if (Z2 == -1 && hw3.R(str, ':', false, 2, null)) {
            return str.length();
        }
        return 0;
    }

    public static final boolean b(File file) {
        file.getClass();
        String path = file.getPath();
        path.getClass();
        return a(path) > 0;
    }
}
