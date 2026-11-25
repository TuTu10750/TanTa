package defpackage;

import java.util.NoSuchElementException;

/* loaded from: /tmp/classes2.dex */
public abstract class jw3 extends iw3 {
    public static final String S0(String str, int i) {
        str.getClass();
        if (i >= 0) {
            return str.substring(fb3.g(i, str.length()));
        }
        ll3.a("Requested character count ", i, " is less than zero.");
        return null;
    }

    public static char T0(CharSequence charSequence) {
        charSequence.getClass();
        if (charSequence.length() != 0) {
            return charSequence.charAt(0);
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    public static char U0(CharSequence charSequence) {
        charSequence.getClass();
        if (charSequence.length() != 0) {
            return charSequence.charAt(hw3.U(charSequence));
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    public static String V0(String str, int i) {
        str.getClass();
        if (i >= 0) {
            return str.substring(0, fb3.g(i, str.length()));
        }
        ll3.a("Requested character count ", i, " is less than zero.");
        return null;
    }

    public static String W0(String str, int i) {
        str.getClass();
        if (i >= 0) {
            int length = str.length();
            return str.substring(length - fb3.g(i, length));
        }
        ll3.a("Requested character count ", i, " is less than zero.");
        return null;
    }
}
