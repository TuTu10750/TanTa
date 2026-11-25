package com.yunbao.common;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import androidx.multidex.MultiDexApplication;
import defpackage.bs3;
import defpackage.j30;
import defpackage.ka;
import defpackage.la;
import defpackage.lx1;
import defpackage.m93;
import defpackage.ma;
import defpackage.u70;
import defpackage.v31;
import defpackage.zu0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class CommonAppContext extends MultiDexApplication {
    public static CommonAppContext c;
    public static Handler d;
    public static WeakReference f;
    public int a;
    public boolean b;
    public static List e = new ArrayList();
    public static boolean g = true;
    public static boolean h = true;

    /* loaded from: /tmp/classes2.dex */
    public class a implements Application.ActivityLifecycleCallbacks {
        public a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            CommonAppContext.e.remove(activity);
            if ((CommonAppContext.f == null ? null : (Activity) CommonAppContext.f.get()) == activity) {
                WeakReference unused = CommonAppContext.f = null;
            }
            CommonAppContext.this.y();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            WeakReference unused = CommonAppContext.f = new WeakReference(activity);
            if (CommonAppContext.e.contains(activity)) {
                return;
            }
            CommonAppContext.e.add(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            CommonAppContext.b(CommonAppContext.this);
            if (!CommonAppContext.e.contains(activity)) {
                CommonAppContext.e.add(activity);
            }
            if (CommonAppContext.this.b) {
                return;
            }
            CommonAppContext.this.b = true;
            lx1.b("AppContext------->处于前台");
            zu0.c().j(new ka(true));
            zu0.c().j(new la(true));
            j30.q().U(true);
            v31.c(true);
            ma.c();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            CommonAppContext.c(CommonAppContext.this);
            if (CommonAppContext.this.a == 0) {
                CommonAppContext.this.b = false;
                lx1.b("AppContext------->处于后台");
                CommonAppContext.e.remove(activity);
                zu0.c().j(new ka(false));
                j30.q().U(false);
                v31.c(false);
                ma.b();
            }
        }
    }

    public static void A(Runnable runnable, long j) {
        Handler handler = d;
        if (handler != null) {
            handler.postDelayed(runnable, j);
        }
    }

    public static /* synthetic */ int b(CommonAppContext commonAppContext) {
        int i = commonAppContext.a;
        commonAppContext.a = i + 1;
        return i;
    }

    public static /* synthetic */ int c(CommonAppContext commonAppContext) {
        int i = commonAppContext.a;
        commonAppContext.a = i - 1;
        return i;
    }

    public static CommonAppContext n() {
        if (c == null) {
            try {
                Object invoke = Class.forName("android.app.ActivityThread").getMethod("currentApplication", null).invoke(null, null);
                if (invoke != null && (invoke instanceof CommonAppContext)) {
                    c = (CommonAppContext) invoke;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return c;
    }

    public static Activity r() {
        WeakReference weakReference = f;
        Activity activity = weakReference == null ? null : (Activity) weakReference.get();
        if (w(activity)) {
            return activity;
        }
        for (int size = e.size() - 1; size >= 0; size--) {
            Activity activity2 = (Activity) e.get(size);
            if (w(activity2)) {
                f = new WeakReference(activity2);
                return activity2;
            }
        }
        return null;
    }

    public static boolean w(Activity activity) {
        return (activity == null || activity.isFinishing() || activity.isDestroyed()) ? false : true;
    }

    public static void z(Runnable runnable) {
        Handler handler = d;
        if (handler != null) {
            handler.post(runnable);
        }
    }

    public final void B() {
        registerActivityLifecycleCallbacks(new a());
    }

    public void C() {
    }

    @Override // androidx.multidex.MultiDexApplication, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        lx1.d("9528", "attachBaseContext:" + System.currentTimeMillis());
        un2.l(this);
        super.attachBaseContext(context);
    }

    public boolean i() {
        return bs3.d().b(getString(m93.c9), false);
    }

    public boolean j() {
        return bs3.d().b(getString(m93.d9), false);
    }

    public boolean k() {
        return bs3.d().b(getString(m93.e9), false);
    }

    public boolean l() {
        return bs3.d().b(getString(m93.f9), false);
    }

    public boolean m() {
        return bs3.d().b(getString(m93.g9), false);
    }

    public boolean o() {
        return bs3.d().b(getString(m93.h9), false);
    }

    @Override // android.app.Application
    public void onCreate() {
        lx1.d("9528", "CommonAppContext:" + System.currentTimeMillis());
        u70.s();
        super.onCreate();
        c = this;
        d = new Handler();
        B();
    }

    public String p() {
        return bs3.d().h(getString(m93.i9), "");
    }

    public int q() {
        try {
            return Integer.valueOf(bs3.d().h(getString(m93.j9), "")).intValue();
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public boolean s() {
        return bs3.d().b(getString(m93.k9), false);
    }

    public boolean t() {
        return bs3.d().b(getString(m93.l9), false);
    }

    public boolean u() {
        return bs3.d().b(getString(m93.m9), false);
    }

    public boolean v() {
        return bs3.d().b(getString(m93.n9), false);
    }

    public boolean x() {
        return this.b;
    }

    public void y() {
    }
}
