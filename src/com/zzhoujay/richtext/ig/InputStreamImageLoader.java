package com.zzhoujay.richtext.ig;

import android.widget.TextView;
import com.zzhoujay.richtext.ImageHolder;
import com.zzhoujay.richtext.RichTextConfig;
import com.zzhoujay.richtext.callback.ImageLoadNotify;
import com.zzhoujay.richtext.drawable.DrawableWrapper;
import com.zzhoujay.richtext.exceptions.BitmapInputStreamNullPointException;
import com.zzhoujay.richtext.exceptions.ImageDecodeException;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: /tmp/classes2.dex */
class InputStreamImageLoader extends AbstractImageLoader<InputStream> implements Runnable {
    private InputStream inputStream;

    public InputStreamImageLoader(ImageHolder imageHolder, RichTextConfig richTextConfig, TextView textView, DrawableWrapper drawableWrapper, ImageLoadNotify imageLoadNotify, InputStream inputStream) {
        super(imageHolder, richTextConfig, textView, drawableWrapper, imageLoadNotify, SourceDecode.INPUT_STREAM_DECODE);
        this.inputStream = inputStream;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.inputStream == null) {
            onFailure(new BitmapInputStreamNullPointException());
            return;
        }
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(this.inputStream);
            doLoadImage(bufferedInputStream);
            bufferedInputStream.close();
            this.inputStream.close();
        } catch (IOException e) {
            onFailure(e);
        } catch (OutOfMemoryError e2) {
            onFailure(new ImageDecodeException(e2));
        }
    }
}
