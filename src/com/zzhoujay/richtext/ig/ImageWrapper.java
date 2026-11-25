package com.zzhoujay.richtext.ig;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.zzhoujay.richtext.callback.Recyclable;
import com.zzhoujay.richtext.drawable.GifDrawable;
import com.zzhoujay.richtext.exceptions.ImageWrapperMultiSourceException;

/* loaded from: /tmp/classes2.dex */
class ImageWrapper implements Recyclable {
    private final Bitmap bitmap;
    private final GifDrawable gifDrawable;
    private final int height;
    private final int width;

    private ImageWrapper(GifDrawable gifDrawable, Bitmap bitmap) {
        this.gifDrawable = gifDrawable;
        this.bitmap = bitmap;
        if (gifDrawable == null) {
            if (bitmap == null) {
                throw new ImageWrapperMultiSourceException();
            }
            this.height = bitmap.getHeight();
            this.width = bitmap.getWidth();
            return;
        }
        if (bitmap != null) {
            throw new ImageWrapperMultiSourceException();
        }
        this.height = gifDrawable.getHeight();
        this.width = gifDrawable.getWidth();
    }

    public static ImageWrapper createAsBitmap(Bitmap bitmap) {
        return new ImageWrapper(null, bitmap);
    }

    public static ImageWrapper createAsGif(GifDrawable gifDrawable) {
        return new ImageWrapper(gifDrawable, null);
    }

    public Bitmap getAsBitmap() {
        return this.bitmap;
    }

    public GifDrawable getAsGif() {
        return this.gifDrawable;
    }

    public Drawable getDrawable(Resources resources) {
        GifDrawable gifDrawable = this.gifDrawable;
        if (gifDrawable != null) {
            return gifDrawable;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(resources, this.bitmap);
        bitmapDrawable.setBounds(0, 0, this.bitmap.getWidth(), this.bitmap.getHeight());
        return bitmapDrawable;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean isGif() {
        return this.gifDrawable != null;
    }

    @Override // com.zzhoujay.richtext.callback.Recyclable
    public void recycle() {
        GifDrawable gifDrawable = this.gifDrawable;
        if (gifDrawable != null) {
            gifDrawable.stop();
        }
    }
}
