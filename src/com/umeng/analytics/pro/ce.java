package com.umeng.analytics.pro;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: /tmp/classes2.dex */
public class ce implements cd {
    private static final String a = "cache_domain";
    private static volatile String b = "";

    /* loaded from: /tmp/classes2.dex */
    public static class a {
        public static final ce a = new ce();

        private a() {
        }
    }

    private ce() {
        d();
    }

    public static ce b() {
        return a.a;
    }

    private void d() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(UMGlobalContext.getAppContext());
        if (sharedPreferences != null) {
            b = sharedPreferences.getString(a, "");
        }
    }

    private void e() {
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(UMGlobalContext.getAppContext());
            if (sharedPreferences != null) {
                sharedPreferences.edit().putString(a, b).commit();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.umeng.analytics.pro.cd
    public void a() {
    }

    @Override // com.umeng.analytics.pro.cd
    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("Status") && jSONObject.getInt("Status") == 0 && jSONObject.has("Answer")) {
                String optString = jSONObject.optString("Answer");
                if (TextUtils.isEmpty(optString)) {
                    return;
                }
                String optString2 = jSONObject.has(IjkMediaPlayer.OnNativeInvokeListener.ARG_IP) ? jSONObject.optString(IjkMediaPlayer.OnNativeInvokeListener.ARG_IP) : "";
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> domain下发结果：" + optString);
                if (!TextUtils.isEmpty(optString2)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> 对应domain下发请求ip：" + optString2);
                }
                b = optString;
                e();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.umeng.analytics.pro.cd
    public void a(Throwable th) {
    }

    public String c() {
        return b;
    }
}
