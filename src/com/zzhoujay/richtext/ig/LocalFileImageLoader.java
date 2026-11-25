package com.zzhoujay.richtext.ig;

import android.widget.TextView;
import com.zzhoujay.richtext.ImageHolder;
import com.zzhoujay.richtext.RichTextConfig;
import com.zzhoujay.richtext.callback.ImageLoadNotify;
import com.zzhoujay.richtext.drawable.DrawableWrapper;
import com.zzhoujay.richtext.exceptions.ImageDecodeException;

/* loaded from: /tmp/classes2.dex */
class LocalFileImageLoader extends AbstractImageLoader<String> implements Runnable {
    public LocalFileImageLoader(ImageHolder imageHolder, RichTextConfig richTextConfig, TextView textView, DrawableWrapper drawableWrapper, ImageLoadNotify imageLoadNotify) {
        super(imageHolder, richTextConfig, textView, drawableWrapper, imageLoadNotify, SourceDecode.LOCAL_FILE_SOURCE_DECODE);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            doLoadImage(this.holder.getSource());
        } catch (Exception e) {
            onFailure(new ImageDecodeException(e));
        } catch (OutOfMemoryError e2) {
            onFailure(new ImageDecodeException(e2));
        }
    }
}
