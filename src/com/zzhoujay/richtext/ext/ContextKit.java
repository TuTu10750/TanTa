package com.zzhoujay.richtext.ext;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;

/* loaded from: /tmp/classes2.dex */
public class ContextKit {
    public static boolean activityIsAlive(Context context) {
        Activity activity = getActivity(context);
        return (activity == null || activity.isFinishing() || activity.isDestroyed()) ? false : true;
    }

    public static Activity getActivity(Context context) {
        boolean z;
        if (context == null) {
            return null;
        }
        while (true) {
            z = context instanceof Activity;
            if (z || !(context instanceof ContextWrapper)) {
                break;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        if (z) {
            return (Activity) context;
        }
        return null;
    }
}
