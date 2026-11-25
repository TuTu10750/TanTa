package defpackage;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /tmp/classes2.dex */
public abstract class iq4 {
    public static char[] a;
    public static int b;
    public static int c = 0;
    public static String d;
    public static Map e;

    static {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '-', '_'};
        a = cArr;
        b = cArr.length;
        e = new HashMap(b);
        for (int i = 0; i < b; i++) {
            e.put(Character.valueOf(a[i]), Integer.valueOf(i));
        }
    }

    public static String a(long j) {
        StringBuilder sb = new StringBuilder();
        do {
            sb.insert(0, a[(int) (j % b)]);
            j /= b;
        } while (j > 0);
        return sb.toString();
    }

    public static String b() {
        String a2 = a(new Date().getTime());
        if (!a2.equals(d)) {
            c = 0;
            d = a2;
            return a2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(a2);
        sb.append(".");
        int i = c;
        c = i + 1;
        sb.append(a(i));
        return sb.toString();
    }
}
