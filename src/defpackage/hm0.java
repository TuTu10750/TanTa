package defpackage;

import android.os.Build;
import android.provider.Settings;
import com.yunbao.common.CommonAppContext;

/* loaded from: /tmp/classes2.dex */
public abstract class hm0 {
    public static String a() {
        return fa2.a(rv3.a(Settings.System.getString(CommonAppContext.n().getContentResolver(), "android_id"), Build.SERIAL, Build.FINGERPRINT, String.valueOf(Build.TIME), Build.USER, Build.HOST, Build.getRadioVersion(), Build.HARDWARE, j30.y));
    }
}
