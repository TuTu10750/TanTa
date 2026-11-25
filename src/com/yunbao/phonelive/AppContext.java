package com.yunbao.phonelive;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import com.yunbao.common.CommonAppContext;
import com.yunbao.common.utils.MemoryPressureUtil;
import defpackage.j30;
import defpackage.kn1;
import defpackage.lc4;
import defpackage.lx1;
import defpackage.n22;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class AppContext extends CommonAppContext {

    /* loaded from: /tmp/classes2.dex */
    public class a implements gi1 {
        public a() {
        }

        public boolean a(CharSequence charSequence) {
            return !CommonAppContext.n().x();
        }
    }

    public static String D(Context context, int i) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            lx1.d("9528", "procInfo:" + runningAppProcessInfo.processName);
            if (runningAppProcessInfo.pid == i) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    public static void E() {
        lc4.a(CommonAppContext.n(), false);
    }

    @Override // com.yunbao.common.CommonAppContext
    public void C() {
        E();
    }

    public final void F(String str) {
        try {
            if (MemoryPressureUtil.i()) {
                pg4.s();
                MemoryPressureUtil.l();
            } else {
                pg4.c();
            }
            kn1.c();
            lx1.c("AppContext", "trim runtime memory: " + str);
        } catch (Throwable th) {
            lx1.c("AppContext", "trim runtime memory failed: " + th.getMessage());
        }
    }

    @Override // com.yunbao.common.CommonAppContext, android.app.Application
    public void onCreate() {
        super.onCreate();
        j30.y = getPackageName();
        lx1.d("9528", "AppContext000:" + System.currentTimeMillis());
        String D = D(this, Process.myPid());
        lx1.d("9528", "processName:" + D);
        if (D == null || !D.equals(getPackageName())) {
            return;
        }
        u54.a(this);
        u54.e(new a());
        lx1.e(false);
        lx1.d("9528", "AppContext555:" + System.currentTimeMillis());
        n22.y0();
        pg4.c();
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        F("lowMemory");
    }

    @Override // android.app.Application, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        if (i >= 10) {
            F("trimMemory:" + i);
        }
    }
}
