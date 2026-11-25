package defpackage;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;

/* loaded from: /tmp/classes2.dex */
public abstract class dj1 {
    public static Object a;
    public static Class b;
    public static Method c;
    public static Method d;
    public static Method e;
    public static Method f;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            b = cls;
            a = cls.newInstance();
            c = b.getMethod("getUDID", Context.class);
            d = b.getMethod("getOAID", Context.class);
            e = b.getMethod("getVAID", Context.class);
            f = b.getMethod("getAAID", Context.class);
        } catch (Exception e2) {
            Log.e("IdentifierManager", "reflect exception!", e2);
        }
    }

    public static String a(Context context, Method method) {
        Object obj = a;
        if (obj == null || method == null) {
            return null;
        }
        try {
            Object invoke = method.invoke(obj, context);
            if (invoke != null) {
                return (String) invoke;
            }
            return null;
        } catch (Exception e2) {
            Log.e("IdentifierManager", "invoke exception!", e2);
            return null;
        }
    }

    public static boolean b() {
        return (b == null || a == null) ? false : true;
    }

    public static String c(Context context) {
        return a(context, d);
    }
}
