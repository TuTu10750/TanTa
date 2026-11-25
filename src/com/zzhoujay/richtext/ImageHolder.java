package com.zzhoujay.richtext;

import android.graphics.drawable.Drawable;
import android.widget.TextView;
import com.zzhoujay.richtext.drawable.DrawableBorderHolder;
import com.zzhoujay.richtext.exceptions.ResetImageSourceException;
import com.zzhoujay.richtext.ext.MD5;
import com.zzhoujay.richtext.ig.ImageDownloader;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: /tmp/classes2.dex */
public class ImageHolder {
    public static final int MATCH_PARENT = Integer.MAX_VALUE;
    public static final int WRAP_CONTENT = Integer.MIN_VALUE;
    private boolean autoFix;
    private boolean autoPlay;
    private DrawableBorderHolder borderHolder;
    private int configHashcode;
    private Drawable errorImage;
    private int height;
    private int imageState;
    private boolean isGif = false;
    private String key;
    private Drawable placeHolder;
    private final int position;
    private String prefixCode;
    private ScaleType scaleType;
    private boolean show;
    private String source;
    private int width;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: /tmp/classes2.dex */
    public @interface ImageState {
        public static final int FAILED = 3;
        public static final int INIT = 0;
        public static final int LOADING = 1;
        public static final int READY = 2;
        public static final int SIZE_READY = 4;
    }

    /* loaded from: /tmp/classes2.dex */
    public enum ScaleType {
        none(0),
        center(1),
        center_crop(2),
        center_inside(3),
        fit_center(4),
        fit_start(5),
        fit_end(6),
        fit_xy(7),
        fit_auto(8);

        int value;

        ScaleType(int i) {
            this.value = i;
        }

        public static ScaleType valueOf(int i) {
            return values()[i];
        }

        public int intValue() {
            return this.value;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static class SizeHolder {
        private int height;
        private float scale = 1.0f;
        private int width;

        public SizeHolder(int i, int i2) {
            this.width = i;
            this.height = i2;
        }

        public int getHeight() {
            return (int) (this.scale * this.height);
        }

        public int getWidth() {
            return (int) (this.scale * this.width);
        }

        public boolean isInvalidateSize() {
            return this.scale > 0.0f && this.width > 0 && this.height > 0;
        }

        public void setScale(float f) {
            this.scale = f;
        }

        public void setSize(int i, int i2) {
            this.width = i;
            this.height = i2;
        }
    }

    public ImageHolder(String str, int i, RichTextConfig richTextConfig, TextView textView) {
        this.source = str;
        this.position = i;
        this.configHashcode = richTextConfig.key();
        ImageDownloader imageDownloader = richTextConfig.imageDownloader;
        this.prefixCode = imageDownloader == null ? "" : imageDownloader.getClass().getName();
        generateKey();
        this.autoPlay = richTextConfig.autoPlay;
        if (richTextConfig.autoFix) {
            this.width = MATCH_PARENT;
            this.height = WRAP_CONTENT;
            this.scaleType = ScaleType.fit_auto;
        } else {
            this.scaleType = richTextConfig.scaleType;
            this.width = richTextConfig.width;
            this.height = richTextConfig.height;
        }
        this.show = !richTextConfig.noImage;
        this.borderHolder = new DrawableBorderHolder(richTextConfig.borderHolder);
        this.placeHolder = richTextConfig.placeHolderDrawableGetter.getDrawable(this, richTextConfig, textView);
        this.errorImage = richTextConfig.errorImageDrawableGetter.getDrawable(this, richTextConfig, textView);
    }

    private void generateKey() {
        this.key = MD5.generate(this.prefixCode + this.configHashcode + this.source);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImageHolder)) {
            return false;
        }
        ImageHolder imageHolder = (ImageHolder) obj;
        if (this.position != imageHolder.position || this.width != imageHolder.width || this.height != imageHolder.height || this.scaleType != imageHolder.scaleType || this.imageState != imageHolder.imageState || this.autoFix != imageHolder.autoFix || this.autoPlay != imageHolder.autoPlay || this.show != imageHolder.show || this.isGif != imageHolder.isGif || !this.prefixCode.equals(imageHolder.prefixCode) || !this.source.equals(imageHolder.source) || !this.key.equals(imageHolder.key) || !this.borderHolder.equals(imageHolder.borderHolder)) {
            return false;
        }
        Drawable drawable = this.placeHolder;
        Drawable drawable2 = imageHolder.placeHolder;
        if (drawable == null ? drawable2 != null : !drawable.equals(drawable2)) {
            return false;
        }
        Drawable drawable3 = this.errorImage;
        Drawable drawable4 = imageHolder.errorImage;
        return drawable3 != null ? drawable3.equals(drawable4) : drawable4 == null;
    }

    public boolean failed() {
        return this.imageState == 3;
    }

    public DrawableBorderHolder getBorderHolder() {
        return this.borderHolder;
    }

    public Drawable getErrorImage() {
        return this.errorImage;
    }

    public int getHeight() {
        return this.height;
    }

    public int getImageState() {
        return this.imageState;
    }

    public String getKey() {
        return this.key;
    }

    public Drawable getPlaceHolder() {
        return this.placeHolder;
    }

    public int getPosition() {
        return this.position;
    }

    public ScaleType getScaleType() {
        return this.scaleType;
    }

    public String getSource() {
        return this.source;
    }

    public int getWidth() {
        return this.width;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((((((this.source.hashCode() * 31) + this.key.hashCode()) * 31) + this.position) * 31) + this.width) * 31) + this.height) * 31) + this.scaleType.hashCode()) * 31) + this.imageState) * 31) + (this.autoFix ? 1 : 0)) * 31) + (this.autoPlay ? 1 : 0)) * 31) + (this.show ? 1 : 0)) * 31) + (this.isGif ? 1 : 0)) * 31;
        DrawableBorderHolder drawableBorderHolder = this.borderHolder;
        int hashCode2 = (hashCode + (drawableBorderHolder != null ? drawableBorderHolder.hashCode() : 0)) * 31;
        Drawable drawable = this.placeHolder;
        int hashCode3 = (hashCode2 + (drawable != null ? drawable.hashCode() : 0)) * 31;
        Drawable drawable2 = this.errorImage;
        return ((hashCode3 + (drawable2 != null ? drawable2.hashCode() : 0)) * 31) + this.prefixCode.hashCode();
    }

    public boolean isAutoFix() {
        return this.autoFix;
    }

    public boolean isAutoPlay() {
        return this.autoPlay;
    }

    public boolean isGif() {
        return this.isGif;
    }

    public boolean isInvalidateSize() {
        return this.width > 0 && this.height > 0;
    }

    public boolean isShow() {
        return this.show;
    }

    public void setAutoFix(boolean z) {
        this.autoFix = z;
        if (z) {
            this.width = MATCH_PARENT;
            this.height = WRAP_CONTENT;
            this.scaleType = ScaleType.fit_auto;
        } else {
            this.width = WRAP_CONTENT;
            this.height = WRAP_CONTENT;
            this.scaleType = ScaleType.none;
        }
    }

    public void setAutoPlay(boolean z) {
        this.autoPlay = z;
    }

    public void setBorderColor(int i) {
        this.borderHolder.setBorderColor(i);
    }

    public void setBorderRadius(float f) {
        this.borderHolder.setRadius(f);
    }

    public void setBorderSize(float f) {
        this.borderHolder.setBorderSize(f);
    }

    public void setErrorImage(Drawable drawable) {
        this.errorImage = drawable;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public void setImageState(int i) {
        this.imageState = i;
    }

    public void setIsGif(boolean z) {
        this.isGif = z;
    }

    public void setPlaceHolder(Drawable drawable) {
        this.placeHolder = drawable;
    }

    public void setScaleType(ScaleType scaleType) {
        this.scaleType = scaleType;
    }

    public void setShow(boolean z) {
        this.show = z;
    }

    public void setShowBorder(boolean z) {
        this.borderHolder.setShowBorder(z);
    }

    public void setSize(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    public void setSource(String str) {
        if (this.imageState != 0) {
            throw new ResetImageSourceException();
        }
        this.source = str;
        generateKey();
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public boolean success() {
        return this.imageState == 2;
    }

    public String toString() {
        return "ImageHolder{source='" + this.source + "', key='" + this.key + "', position=" + this.position + ", width=" + this.width + ", height=" + this.height + ", scaleType=" + this.scaleType + ", imageState=" + this.imageState + ", autoFix=" + this.autoFix + ", autoPlay=" + this.autoPlay + ", show=" + this.show + ", isGif=" + this.isGif + ", borderHolder=" + this.borderHolder + ", placeHolder=" + this.placeHolder + ", errorImage=" + this.errorImage + ", prefixCode=" + this.prefixCode + '}';
    }
}
