package defpackage;

import android.content.Context;
import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;

/* loaded from: /tmp/classes2.dex */
public abstract class lc4 {
    public static void a(Context context, boolean z) {
        String y = j30.y("UMENG_APPKEY");
        UMConfigure.preInit(context, y, context.getPackageName());
        UMConfigure.setLogEnabled(z);
        UMConfigure.submitPolicyGrantResult(context, true);
        UMConfigure.init(context, y, context.getPackageName(), 1, "");
        MobclickAgent.setPageCollectionMode(MobclickAgent.PageMode.AUTO);
        u70.s();
    }

    public static void b(String str, String str2) {
        MobclickAgent.onProfileSignIn(str, str2);
    }

    public static void c() {
        MobclickAgent.onProfileSignOff();
    }
}
