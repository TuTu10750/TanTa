package defpackage;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import android.view.View;
import android.view.WindowManager;
import com.yunbao.common.CommonAppContext;
import com.yunbao.live.floatwindow.FloatPermissionActivity;

/* loaded from: /tmp/classes2.dex */
public class w31 {
    public static w31 a;

    public static w31 a() {
        if (a == null) {
            synchronized (w31.class) {
                try {
                    if (a == null) {
                        a = new w31();
                    }
                } finally {
                }
            }
        }
        return a;
    }

    public final boolean b() {
        return Settings.canDrawOverlays(CommonAppContext.n());
    }

    public final boolean c(Context context) {
        try {
            WindowManager windowManager = (WindowManager) CommonAppContext.n().getSystemService("window");
            if (windowManager == null) {
                return false;
            }
            View view = new View(context);
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(0, 0, 2038, 24, -2);
            view.setLayoutParams(layoutParams);
            windowManager.addView(view, layoutParams);
            windowManager.removeView(view);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean d(Context context) {
        return Build.VERSION.SDK_INT == 26 ? c(context) : Settings.canDrawOverlays(CommonAppContext.n());
    }

    public final void e() {
        Intent intent = new Intent(CommonAppContext.n(), (Class<?>) FloatPermissionActivity.class);
        intent.setFlags(268435456);
        CommonAppContext.n().startActivity(intent);
    }

    public void f() {
        if (b()) {
            x31.f().k();
        } else if (wl2.a()) {
            e();
        } else {
            e();
        }
    }
}
