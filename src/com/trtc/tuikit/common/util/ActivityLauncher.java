package com.trtc.tuikit.common.util;

import android.app.Application;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/* loaded from: /tmp/classes2.dex */
public class ActivityLauncher {
    private static final String TAG = "IntentUtils";

    public static void startActivity(Context context, Intent intent) {
        if (intent == null || context == null) {
            Log.e(TAG, "intent or activity is null");
            return;
        }
        if (context.getPackageManager().resolveActivity(intent, 65536) == null) {
            Log.w(TAG, "No activity match : " + intent.toString());
            return;
        }
        try {
            if (context instanceof Application) {
                intent.setFlags(268435456);
            }
            context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            Log.e(TAG, "ActivityNotFoundException : " + intent.toString());
        }
    }
}
