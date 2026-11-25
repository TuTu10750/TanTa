package defpackage;

import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: /tmp/classes2.dex */
public abstract class wj1 {
    public static final SimpleDateFormat a = new SimpleDateFormat("MM-dd HH:mm");

    public static String a(long j) {
        return a.format(new Date(j));
    }

    public static boolean b(long j, long j2) {
        return Math.abs(j2 - j) < 60000;
    }
}
