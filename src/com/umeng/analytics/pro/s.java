package com.umeng.analytics.pro;

import com.umeng.analytics.AnalyticsConfig;
import java.lang.Thread;

/* loaded from: /tmp/classes2.dex */
public class s implements Thread.UncaughtExceptionHandler {
    private Thread.UncaughtExceptionHandler a;
    private w b;

    public s() {
        if (Thread.getDefaultUncaughtExceptionHandler() == this) {
            return;
        }
        this.a = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    private void a(Throwable th) {
        boolean z = AnalyticsConfig.CATCH_EXCEPTION;
        w wVar = this.b;
        if (z) {
            wVar.a(th);
        } else {
            wVar.a(null);
        }
    }

    public void a(w wVar) {
        this.b = wVar;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        a(th);
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.a;
        if (uncaughtExceptionHandler == null || uncaughtExceptionHandler == Thread.getDefaultUncaughtExceptionHandler()) {
            return;
        }
        this.a.uncaughtException(thread, th);
    }
}
