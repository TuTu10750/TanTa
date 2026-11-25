package defpackage;

import java.util.Iterator;
import java.util.Locale;

/* loaded from: /tmp/classes2.dex */
public abstract class iv {
    public static final String a(String str) {
        char charAt;
        str.getClass();
        if (str.length() == 0 || 'a' > (charAt = str.charAt(0)) || charAt >= '{') {
            return str;
        }
        return Character.toUpperCase(charAt) + str.substring(1);
    }

    public static final String b(String str) {
        char charAt;
        str.getClass();
        if (str.length() == 0 || 'A' > (charAt = str.charAt(0)) || charAt >= '[') {
            return str;
        }
        return Character.toLowerCase(charAt) + str.substring(1);
    }

    public static final String c(String str, boolean z) {
        Object obj;
        str.getClass();
        if (str.length() == 0 || !d(str, 0, z)) {
            return str;
        }
        if (str.length() == 1 || !d(str, 1, z)) {
            if (z) {
                return b(str);
            }
            if (str.length() <= 0) {
                return str;
            }
            return Character.toLowerCase(str.charAt(0)) + str.substring(1);
        }
        Iterator it = hw3.T(str).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (!d(str, ((Number) obj).intValue(), z)) {
                break;
            }
        }
        Integer num = (Integer) obj;
        if (num == null) {
            return e(str, z);
        }
        int intValue = num.intValue() - 1;
        return e(str.substring(0, intValue), z) + str.substring(intValue);
    }

    public static final boolean d(String str, int i, boolean z) {
        char charAt = str.charAt(i);
        return z ? 'A' <= charAt && charAt < '[' : Character.isUpperCase(charAt);
    }

    public static final String e(String str, boolean z) {
        if (z) {
            return f(str);
        }
        String lowerCase = str.toLowerCase(Locale.ROOT);
        lowerCase.getClass();
        return lowerCase;
    }

    public static final String f(String str) {
        str.getClass();
        StringBuilder sb = new StringBuilder(str.length());
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if ('A' <= charAt && charAt < '[') {
                charAt = Character.toLowerCase(charAt);
            }
            sb.append(charAt);
        }
        return sb.toString();
    }
}
