package com.umeng.analytics.pro;

import java.lang.reflect.InvocationTargetException;

/* loaded from: /tmp/classes2.dex */
public class dj {
    public static di a(Class<? extends di> cls, int i) {
        try {
            return (di) cls.getMethod("findByValue", Integer.TYPE).invoke(null, Integer.valueOf(i));
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }
}
