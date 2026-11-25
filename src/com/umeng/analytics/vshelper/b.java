package com.umeng.analytics.vshelper;

import android.app.Activity;
import android.os.Bundle;
import com.umeng.analytics.pro.cf;

/* loaded from: /tmp/classes2.dex */
public class b implements cf {
    private static final String a = "RealTimeDebugSwitch";
    private static volatile int b;

    public static boolean d() {
        return b > 0;
    }

    @Override // com.umeng.analytics.pro.cf
    public void a() {
    }

    @Override // com.umeng.analytics.pro.cf
    public void a(Activity activity) {
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0075  */
    @Override // com.umeng.analytics.pro.cf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(android.app.Activity r8, android.os.Bundle r9) {
        /*
            Method dump skipped, instructions count: 283
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.vshelper.b.a(android.app.Activity, android.os.Bundle):void");
    }

    @Override // com.umeng.analytics.pro.cf
    public void b() {
    }

    @Override // com.umeng.analytics.pro.cf
    public void b(Activity activity) {
    }

    @Override // com.umeng.analytics.pro.cf
    public void b(Activity activity, Bundle bundle) {
    }

    @Override // com.umeng.analytics.pro.cf
    public void c() {
    }

    @Override // com.umeng.analytics.pro.cf
    public void c(Activity activity) {
        b++;
    }

    @Override // com.umeng.analytics.pro.cf
    public void d(Activity activity) {
        b--;
    }

    @Override // com.umeng.analytics.pro.cf
    public void e(Activity activity) {
    }
}
