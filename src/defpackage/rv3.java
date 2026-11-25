package defpackage;

import android.text.TextUtils;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.regex.Pattern;

/* loaded from: /tmp/classes2.dex */
public abstract class rv3 {
    public static final DecimalFormat a;
    public static final DecimalFormat b;
    public static final Pattern c;
    public static final Random d;
    public static final StringBuilder e;

    static {
        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        a = decimalFormat;
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        DecimalFormat decimalFormat2 = new DecimalFormat("#.##");
        b = decimalFormat2;
        decimalFormat2.setRoundingMode(RoundingMode.DOWN);
        c = Pattern.compile("^[-\\+]?[\\d]*$");
        d = new Random();
        e = new StringBuilder();
    }

    public static String a(String... strArr) {
        StringBuilder sb = e;
        sb.delete(0, sb.length());
        for (String str : strArr) {
            e.append(str);
        }
        return e.toString();
    }

    public static String b() {
        return a("dynamic/", da0.c(), "/", j30.q().C(), "/", String.valueOf(d.nextInt(999999)));
    }

    public static String c() {
        return a(da0.c(), "/", j30.q().C(), "/", String.valueOf(d.nextInt(999999)));
    }

    public static String d(long j) {
        int i = (int) (j / 3600000);
        int i2 = (int) ((j % 3600000) / 60000);
        int i3 = (int) ((j % 60000) / 1000);
        StringBuilder sb = e;
        sb.delete(0, sb.length());
        if (i > 0) {
            if (i < 10) {
                sb.append("0");
            }
            sb.append(String.valueOf(i));
            sb.append(":");
        }
        if (i2 > 0) {
            if (i2 < 10) {
                sb.append("0");
            }
            sb.append(String.valueOf(i2));
            sb.append(":");
        } else {
            sb.append("00:");
        }
        if (i3 > 0) {
            if (i3 < 10) {
                sb.append("0");
            }
            sb.append(String.valueOf(i3));
        } else {
            sb.append("00");
        }
        return sb.toString();
    }

    public static String e(int i, StringBuilder sb) {
        int i2 = i / 3600;
        int i3 = i % 3600;
        int i4 = i3 > 0 ? i3 / 60 : 0;
        int i5 = i % 60;
        sb.delete(0, sb.length());
        if (i2 > 0) {
            if (i2 < 10) {
                sb.append("0");
            }
            sb.append(String.valueOf(i2));
            sb.append(":");
        }
        if (i4 > 0) {
            if (i4 < 10) {
                sb.append("0");
            }
            sb.append(String.valueOf(i4));
            sb.append(":");
        } else {
            sb.append("00:");
        }
        if (i5 > 0) {
            if (i5 < 10) {
                sb.append("0");
            }
            sb.append(String.valueOf(i5));
        } else {
            sb.append("00");
        }
        return sb.toString();
    }

    public static int f(int i) {
        return d.nextInt(i);
    }

    public static boolean g(String str) {
        return c.matcher(str).matches();
    }

    public static int h(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            String trim = str.trim();
            if (!"undefined".equals(trim) && !"null".equals(trim)) {
                try {
                    return Integer.parseInt(trim);
                } catch (NumberFormatException unused) {
                }
            }
        }
        return i;
    }

    public static String i(long j) {
        if (j < 10000) {
            return String.valueOf(j);
        }
        return a.format(j / 10000.0d) + "W";
    }

    public static String j(long j) {
        return j < 10000 ? String.valueOf(j) : a.format(j / 10000.0d);
    }

    public static String k(long j) {
        if (j < 10000) {
            return String.valueOf(j);
        }
        return b.format(j / 10000.0d) + "w";
    }
}
