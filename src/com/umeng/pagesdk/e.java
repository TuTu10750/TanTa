package com.umeng.pagesdk;

import android.content.Context;
import android.text.TextUtils;
import com.efs.sdk.base.core.util.ProcessUtil;

/* loaded from: /tmp/classes2.dex */
public final class e {
    public static boolean a(Context context) {
        try {
            String currentProcessName = ProcessUtil.getCurrentProcessName();
            String packageName = context.getApplicationContext().getPackageName();
            if (!TextUtils.isEmpty(currentProcessName) && !TextUtils.isEmpty(packageName)) {
                if (currentProcessName.equals(packageName)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
