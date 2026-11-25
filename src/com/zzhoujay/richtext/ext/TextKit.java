package com.zzhoujay.richtext.ext;

import android.text.TextUtils;

/* loaded from: /tmp/classes2.dex */
public class TextKit {
    private static final String ASSETS_PREFIX = "file:///android_asset/";
    private static final String LOCAL_FILE_PREFIX = "/";

    public static boolean isAssetPath(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith(ASSETS_PREFIX);
    }

    public static boolean isLocalPath(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith(LOCAL_FILE_PREFIX);
    }
}
