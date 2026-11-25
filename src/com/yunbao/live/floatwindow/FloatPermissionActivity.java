package com.yunbao.live.floatwindow;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import defpackage.k12;
import defpackage.m93;
import defpackage.t54;
import defpackage.w31;
import defpackage.x31;

/* loaded from: /tmp/classes2.dex */
public class FloatPermissionActivity extends Activity {
    public final void a() {
        Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        intent.setData(Uri.parse("package:" + getPackageName()));
        startActivityForResult(intent, 10001);
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 10001) {
            if (w31.a().d(this)) {
                x31.f().k();
            } else {
                t54.a(m93.W8);
                k12.c().e(false);
                k12.c().d();
            }
        }
        finish();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a();
    }
}
