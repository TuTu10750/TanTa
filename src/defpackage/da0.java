package defpackage;

import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: /tmp/classes2.dex */
public abstract class da0 {
    public static SimpleDateFormat a = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    public static SimpleDateFormat b = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS");
    public static SimpleDateFormat c = new SimpleDateFormat("MM.dd-HH:mm:ss");
    public static SimpleDateFormat d = new SimpleDateFormat("yyyyMMdd");

    public static String a() {
        return a.format(new Date());
    }

    public static String b() {
        return c.format(new Date());
    }

    public static String c() {
        return d.format(new Date());
    }
}
