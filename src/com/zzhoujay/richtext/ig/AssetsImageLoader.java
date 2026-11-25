package com.zzhoujay.richtext.ig;

import android.widget.TextView;
import com.zzhoujay.richtext.ImageHolder;
import com.zzhoujay.richtext.RichTextConfig;
import com.zzhoujay.richtext.callback.ImageLoadNotify;
import com.zzhoujay.richtext.drawable.DrawableWrapper;
import com.zzhoujay.richtext.ext.Debug;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: /tmp/classes2.dex */
class AssetsImageLoader extends InputStreamImageLoader implements Runnable {
    private static final String ASSETS_PREFIX = "file:///android_asset/";

    public AssetsImageLoader(ImageHolder imageHolder, RichTextConfig richTextConfig, TextView textView, DrawableWrapper drawableWrapper, ImageLoadNotify imageLoadNotify) {
        super(imageHolder, richTextConfig, textView, drawableWrapper, imageLoadNotify, openAssetInputStream(imageHolder, textView));
    }

    private static String getAssetFileName(String str) {
        if (str == null || !str.startsWith(ASSETS_PREFIX)) {
            return null;
        }
        return str.replace(ASSETS_PREFIX, "");
    }

    private static InputStream openAssetInputStream(ImageHolder imageHolder, TextView textView) {
        try {
            return textView.getContext().getAssets().open(getAssetFileName(imageHolder.getSource()));
        } catch (IOException e) {
            Debug.e(e);
            return null;
        }
    }
}
