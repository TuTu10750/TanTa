package defpackage;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;

/* loaded from: /tmp/classes2.dex */
public abstract class du2 {
    public static Method a;

    public static final boolean a() {
        Context context = null;
        try {
            if (a == null) {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentApplication", null);
                a = method;
                method.setAccessible(true);
            }
            context = (Context) a.invoke(null, null);
        } catch (Exception e) {
            Log.e("OpenIdHelper", "ActivityThread:currentApplication --> " + e.toString());
        }
        if (context == null) {
            return false;
        }
        return nr4.b().g(context, false);
    }

    public static String b(Context context) {
        nr4 b = nr4.b();
        return b.c(context.getApplicationContext(), b.b);
    }
}
