package defpackage;

import android.text.TextUtils;

/* loaded from: /tmp/classes2.dex */
public abstract class t54 {
    public static long a;
    public static String b;

    public static void a(int i) {
        b(aq4.a(i));
    }

    public static void b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - a > 2000) {
                a = currentTimeMillis;
                b = str;
                u54.h(str);
            } else {
                if (str.equals(b)) {
                    return;
                }
                a = currentTimeMillis;
                b = str;
                u54.h(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
