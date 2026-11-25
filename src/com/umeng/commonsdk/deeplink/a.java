package com.umeng.commonsdk.deeplink;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.ab;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.utils.UMUtils;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /tmp/classes2.dex */
public final class a {
    private a() {
    }

    public static void a(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            Context applicationContext = context.getApplicationContext();
            if (UMUtils.isMainProgress(applicationContext)) {
                String d = ab.a().d(applicationContext);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(IjkMediaPlayer.OnNativeInvokeListener.ARG_URL, str);
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("_umlnk_refid", str2);
                }
                if (!TextUtils.isEmpty(d)) {
                    jSONObject.put("session_id", d);
                }
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("dp", jSONObject);
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> [deeplink] attribution report: " + jSONObject3.toString());
                JSONObject buildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(applicationContext, jSONObject2, jSONObject3, "um_attribution_dp_log", "dl", "9.9.2");
                if (buildEnvelopeWithExtHeader == null || !buildEnvelopeWithExtHeader.has("exception")) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> [deeplink] attribution report success");
                    return;
                }
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [deeplink] attribution report failed: " + buildEnvelopeWithExtHeader.optString("exception"));
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
    }
}
