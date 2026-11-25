package com.yunbao.im.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import com.zzhoujay.richtext.ImageHolder;
import defpackage.j30;
import defpackage.lx1;
import defpackage.pi3;

/* loaded from: /tmp/classes2.dex */
public class ImMsgNotifyActivity extends Activity {

    /* loaded from: /tmp/classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!j30.q().M()) {
                pi3.i();
            }
            ImMsgNotifyActivity.this.finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Window window = getWindow();
        window.clearFlags(67108864);
        window.getDecorView().setSystemUiVisibility(9986);
        window.addFlags(ImageHolder.WRAP_CONTENT);
        window.setStatusBarColor(0);
        super.onCreate(bundle);
        new Handler().postDelayed(new a(), 500L);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        lx1.b("腾讯TPNS----ImMsgNotifyActivity--->onDestroy");
        super.onDestroy();
    }
}
