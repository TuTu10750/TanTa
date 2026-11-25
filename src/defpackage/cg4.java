package defpackage;

/* loaded from: /tmp/classes2.dex */
public abstract class cg4 {
    public static volatile String[] a;
    public static volatile boolean b;

    public static boolean a(String str) {
        if (b) {
            return true;
        }
        String[] strArr = a;
        if (strArr != null && strArr.length != 0) {
            for (String str2 : strArr) {
                if (str2.equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }
}
