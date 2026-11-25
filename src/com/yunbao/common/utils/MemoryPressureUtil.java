package com.yunbao.common.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import com.yunbao.common.CommonAppContext;
import com.yunbao.common.utils.MemoryPressureUtil;
import com.yunbao.common.utils.a;
import defpackage.kn1;
import defpackage.t54;

/* loaded from: /tmp/classes2.dex */
public abstract class MemoryPressureUtil {
    public static long a;
    public static long b;
    public static boolean c;
    public static boolean d;

    /* loaded from: /tmp/classes2.dex */
    public enum Level {
        NORMAL,
        LOW,
        CRITICAL
    }

    /* loaded from: /tmp/classes2.dex */
    public class a implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ Runnable b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ boolean d;

        public a(String str, Runnable runnable, boolean z, boolean z2) {
            this.a = str;
            this.b = runnable;
            this.c = z;
            this.d = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Activity r = CommonAppContext.r();
            if (!CommonAppContext.w(r)) {
                t54.b(this.a);
                Runnable runnable = this.b;
                if (runnable != null) {
                    runnable.run();
                    return;
                }
                return;
            }
            if (this.c) {
                boolean unused = MemoryPressureUtil.c = true;
            } else {
                boolean unused2 = MemoryPressureUtil.d = true;
            }
            try {
                Dialog c = new a.j(r).q("温馨提示").k(this.a).j("知道了").g(this.d).h(MemoryPressureUtil.f(this.c, this.b)).c();
                final boolean z = this.c;
                c.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: jk2
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        MemoryPressureUtil.k(z);
                    }
                });
                c.show();
            } catch (Throwable unused3) {
                MemoryPressureUtil.k(this.c);
                t54.b(this.a);
                Runnable runnable2 = this.b;
                if (runnable2 != null) {
                    runnable2.run();
                }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements a.m {
        public final /* synthetic */ Runnable a;

        public b(Runnable runnable) {
            this.a = runnable;
        }

        @Override // com.yunbao.common.utils.a.m
        public void b(Dialog dialog, String str) {
            MemoryPressureUtil.k(true);
            Runnable runnable = this.a;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c implements a.l {
        public final /* synthetic */ Runnable a;

        public c(Runnable runnable) {
            this.a = runnable;
        }

        @Override // com.yunbao.common.utils.a.l
        public void a() {
            MemoryPressureUtil.k(false);
            Runnable runnable = this.a;
            if (runnable != null) {
                runnable.run();
            }
        }

        @Override // com.yunbao.common.utils.a.m
        public void b(Dialog dialog, String str) {
            MemoryPressureUtil.k(false);
            Runnable runnable = this.a;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d implements Runnable {
        public final /* synthetic */ Runnable a;

        public d(Runnable runnable) {
            this.a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.run();
        }
    }

    public static void e() {
        try {
            kn1.c();
        } catch (Throwable unused) {
        }
        try {
            System.gc();
        } catch (Throwable unused2) {
        }
    }

    public static a.m f(boolean z, Runnable runnable) {
        return z ? new b(runnable) : new c(runnable);
    }

    public static long g() {
        Runtime runtime = Runtime.getRuntime();
        return runtime.maxMemory() - (runtime.totalMemory() - runtime.freeMemory());
    }

    public static Level h() {
        long g = g();
        return g < 33554432 ? Level.CRITICAL : g < 100663296 ? Level.LOW : Level.NORMAL;
    }

    public static boolean i() {
        return h() == Level.CRITICAL;
    }

    public static boolean j() {
        return h() != Level.NORMAL;
    }

    public static void k(boolean z) {
        if (z) {
            c = false;
        } else {
            d = false;
        }
    }

    public static void l() {
        long currentTimeMillis = System.currentTimeMillis();
        if (c || currentTimeMillis - a < 60000) {
            return;
        }
        a = currentTimeMillis;
        o("检测到当前手机运行异常卡顿，已为你减少后台加载任务，建议清理后台应用后继续使用", true, null, true);
    }

    public static void m(Runnable runnable) {
        long currentTimeMillis = System.currentTimeMillis();
        if (d || currentTimeMillis - b < 60000) {
            n(runnable);
        } else {
            b = currentTimeMillis;
            o("内存不足以打开直播间，请先清理后台", false, runnable, false);
        }
    }

    public static void n(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        CommonAppContext.z(new d(runnable));
    }

    public static void o(String str, boolean z, Runnable runnable, boolean z2) {
        CommonAppContext.z(new a(str, runnable, z, z2));
    }
}
