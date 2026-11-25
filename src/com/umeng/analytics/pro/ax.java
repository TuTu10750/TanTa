package com.umeng.analytics.pro;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: /tmp/classes2.dex */
public class ax {
    public static Class<?> a(String str) {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (contextClassLoader == null) {
            contextClassLoader = ax.class.getClassLoader();
        }
        try {
            try {
                return Class.forName(str, true, contextClassLoader);
            } catch (Throwable unused) {
                return Class.forName(str, true, ax.class.getClassLoader());
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static Object a(String str, String str2, Object obj) {
        return a(a(str, str2), obj);
    }

    public static Object a(String str, String str2, Class<?>[] clsArr, Object obj, Object[] objArr) {
        Method a = a(str, str2, clsArr);
        if (a != null) {
            return a(a, obj, objArr);
        }
        return null;
    }

    public static Object a(String str, Class<?>[] clsArr, Object[] objArr) {
        Class<?> a = a(str);
        if (a == null) {
            return null;
        }
        try {
            return a.getConstructor(clsArr).newInstance(objArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Object a(Field field, Object obj) {
        if (field == null) {
            return null;
        }
        try {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            return field.get(obj);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Object a(Method method, Object obj, Object[] objArr) {
        if (method == null) {
            return null;
        }
        try {
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            return method.invoke(obj, objArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static Field a(String str, String str2) {
        Class<?> a;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (a = a(str)) == null) {
            return null;
        }
        try {
            return a.getField(str2);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Method a(String str, String str2, Class<?>... clsArr) {
        Class<?> a;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (a = a(str)) == null) {
            return null;
        }
        try {
            return a.getDeclaredMethod(str2, clsArr);
        } catch (Throwable unused) {
            return null;
        }
    }
}
