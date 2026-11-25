package com.umeng.commonsdk.config;

import java.util.HashMap;
import java.util.Map;

/* loaded from: /tmp/classes2.dex */
public class b implements f {
    private static Map<String, Boolean> a = new HashMap();
    private static Object b = new Object();

    /* loaded from: /tmp/classes2.dex */
    public static class a {
        private static final b a = new b();

        private a() {
        }
    }

    private b() {
    }

    public static boolean a(String str) {
        if (!d.a(str)) {
            return false;
        }
        synchronized (b) {
            try {
                if (!a.containsKey(str)) {
                    return true;
                }
                return a.get(str).booleanValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static b b() {
        return a.a;
    }

    public void a() {
        synchronized (b) {
            a.clear();
        }
    }

    @Override // com.umeng.commonsdk.config.f
    public void a(String str, Boolean bool) {
        if (d.a(str)) {
            synchronized (b) {
                try {
                    Map<String, Boolean> map = a;
                    if (map != null) {
                        map.put(str, bool);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
