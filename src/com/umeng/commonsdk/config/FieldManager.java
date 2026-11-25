package com.umeng.commonsdk.config;

import android.content.Context;
import android.util.Pair;
import com.umeng.commonsdk.config.d;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import java.util.ArrayList;

/* loaded from: /tmp/classes2.dex */
public class FieldManager {
    private static final String a = "cfgfd";
    private static b b = b.b();
    private static boolean c = false;
    private static Object d = new Object();

    /* loaded from: /tmp/classes2.dex */
    public static class a {
        private static final FieldManager a = new FieldManager();

        private a() {
        }
    }

    private FieldManager() {
    }

    private static Pair<Long, String> a(String str) {
        Pair<Long, String> pair = new Pair<>(-1L, null);
        if (str != null && str.length() >= 2) {
            String[] split = str.split("@");
            if (split.length >= 2) {
                try {
                    long parseLong = Long.parseLong(split[0]);
                    return new Pair<>(Long.valueOf(parseLong), split[1]);
                } catch (Throwable unused) {
                }
            }
        }
        return pair;
    }

    public static FieldManager a() {
        return a.a;
    }

    public static boolean allow(String str) {
        synchronized (d) {
            try {
                if (!c) {
                    return false;
                }
                return b.a(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean b() {
        boolean z;
        synchronized (d) {
            z = c;
        }
        return z;
    }

    public void a(Context context) {
        String str;
        String str2 = "1001@3749699455,2130669566,262139,1983";
        String[] strArr = {d.a.class.getName(), d.b.class.getName(), d.c.class.getName(), d.EnumC0017d.class.getName()};
        String imprintProperty = UMEnvelopeBuild.imprintProperty(context, "cfgfd", "1001@3749699455,2130669566,262139,1983");
        synchronized (d) {
            try {
                Pair<Long, String> a2 = a(imprintProperty);
                if (((Long) a2.first).longValue() > 1000 && (str = (String) a2.second) != null && str.length() > 0) {
                    str2 = str;
                }
                String[] split = str2.split(",");
                int length = split.length;
                if (length > 0) {
                    ArrayList arrayList = new ArrayList();
                    g gVar = new g();
                    for (int i = 0; i < length; i++) {
                        arrayList.add(gVar);
                        ((e) arrayList.get(i)).a(split[i], b, d.b(strArr[i]));
                    }
                }
                c = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(Context context, String str) {
        String str2;
        String str3 = "1001@3749699455,2130669566,262139,1983";
        String[] strArr = {d.a.class.getName(), d.b.class.getName(), d.c.class.getName(), d.EnumC0017d.class.getName()};
        synchronized (d) {
            try {
                b.a();
                if (str != null) {
                    Pair<Long, String> a2 = a(str);
                    if (((Long) a2.first).longValue() > 1000 && (str2 = (String) a2.second) != null && str2.length() > 0) {
                        str3 = str2;
                    }
                }
                String[] split = str3.split(",");
                int length = split.length;
                if (length > 0) {
                    ArrayList arrayList = new ArrayList();
                    g gVar = new g();
                    for (int i = 0; i < length; i++) {
                        arrayList.add(gVar);
                        ((e) arrayList.get(i)).a(split[i], b, d.b(strArr[i]));
                    }
                }
                c = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
