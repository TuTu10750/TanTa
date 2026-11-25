package com.zzhoujay.richtext.ig;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import com.zzhoujay.richtext.CacheType;
import com.zzhoujay.richtext.ImageHolder;
import com.zzhoujay.richtext.RichTextConfig;
import com.zzhoujay.richtext.cache.BitmapPool;
import com.zzhoujay.richtext.callback.ImageFixCallback;
import com.zzhoujay.richtext.callback.ImageLoadNotify;
import com.zzhoujay.richtext.drawable.DrawableWrapper;
import com.zzhoujay.richtext.exceptions.ImageDecodeException;
import com.zzhoujay.richtext.ext.ContextKit;
import com.zzhoujay.richtext.ext.Debug;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /tmp/classes2.dex */
public abstract class AbstractImageLoader<T> implements ImageLoader {
    private static final String TAG = "AbstractImageLoader";
    private final RichTextConfig config;
    private final WeakReference<DrawableWrapper> drawableWrapperWeakReference;
    final ImageHolder holder;
    private WeakReference<ImageWrapper> imageWrapperWeakReference;
    private final WeakReference<ImageLoadNotify> notifyWeakReference;
    private final SourceDecode<T> sourceDecode;
    private final WeakReference<TextView> textViewWeakReference;

    public AbstractImageLoader(ImageHolder imageHolder, RichTextConfig richTextConfig, TextView textView, DrawableWrapper drawableWrapper, ImageLoadNotify imageLoadNotify, SourceDecode<T> sourceDecode) {
        this.holder = imageHolder;
        this.config = richTextConfig;
        this.sourceDecode = sourceDecode;
        this.textViewWeakReference = new WeakReference<>(textView);
        this.drawableWrapperWeakReference = new WeakReference<>(drawableWrapper);
        this.notifyWeakReference = new WeakReference<>(imageLoadNotify);
        onLoading();
    }

    private boolean activityDestroyed() {
        TextView textView = this.textViewWeakReference.get();
        if (textView == null) {
            Debug.loge(TAG, "textView is recycle");
            return true;
        }
        boolean activityIsAlive = ContextKit.activityIsAlive(textView.getContext());
        if (!activityIsAlive) {
            Debug.loge(TAG, "activity is destroy");
        }
        return !activityIsAlive;
    }

    private void done() {
        ImageLoadNotify imageLoadNotify = this.notifyWeakReference.get();
        if (imageLoadNotify != null) {
            imageLoadNotify.done(this);
        }
    }

    private int[] getDimensions(T t, BitmapFactory.Options options) {
        options.inJustDecodeBounds = true;
        this.sourceDecode.decodeSize(t, options);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    private int getHolderHeight(int i) {
        int height = this.holder.getHeight();
        return height == Integer.MAX_VALUE ? getRealHeight() : height == Integer.MIN_VALUE ? i : height;
    }

    private int getHolderWidth(int i) {
        int width = this.holder.getWidth();
        return width == Integer.MAX_VALUE ? getRealWidth() : width == Integer.MIN_VALUE ? i : width;
    }

    private int getRealHeight() {
        TextView textView = this.textViewWeakReference.get();
        if (textView == null) {
            return 0;
        }
        return (textView.getHeight() - textView.getPaddingTop()) - textView.getPaddingBottom();
    }

    private int getRealWidth() {
        TextView textView = this.textViewWeakReference.get();
        if (textView == null) {
            return 0;
        }
        return (textView.getWidth() - textView.getPaddingRight()) - textView.getPaddingLeft();
    }

    private static int getSampleSize(int i, int i2, int i3, int i4) {
        int ceil = (int) Math.ceil(Math.max(i2 / i4, i / i3));
        int max = Math.max(1, Integer.highestOneBit(ceil));
        return max << (max >= ceil ? 0 : 1);
    }

    private void resetText() {
        final TextView textView = this.textViewWeakReference.get();
        if (textView != null) {
            textView.post(new Runnable() { // from class: com.zzhoujay.richtext.ig.AbstractImageLoader.1
                @Override // java.lang.Runnable
                public void run() {
                    textView.setText(textView.getText());
                }
            });
        }
    }

    public void doLoadImage(T t) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        int[] dimensions = getDimensions(t, options);
        options.inSampleSize = onSizeReady(dimensions[0], dimensions[1]);
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        onResourceReady(this.sourceDecode.decode(this.holder, t, options));
    }

    @Override // com.zzhoujay.richtext.ig.ImageLoader
    public void onFailure(Exception exc) {
        DrawableWrapper drawableWrapper;
        Debug.loge(TAG, "onFailure > " + this.holder.getSource(), exc);
        if (activityDestroyed() || (drawableWrapper = this.drawableWrapperWeakReference.get()) == null) {
            return;
        }
        this.holder.setImageState(3);
        Drawable errorImage = this.holder.getErrorImage();
        Rect bounds = errorImage.getBounds();
        drawableWrapper.setDrawable(errorImage);
        ImageFixCallback imageFixCallback = this.config.imageFixCallback;
        if (imageFixCallback != null) {
            imageFixCallback.onFailure(this.holder, exc);
        }
        if (drawableWrapper.isHasCache()) {
            errorImage.setBounds(drawableWrapper.getBounds());
        } else {
            drawableWrapper.setScaleType(this.holder.getScaleType());
            drawableWrapper.setBounds(0, 0, getHolderWidth(bounds.width()), getHolderHeight(bounds.height()));
            drawableWrapper.setBorderHolder(this.holder.getBorderHolder());
            drawableWrapper.calculate();
        }
        resetText();
        done();
    }

    @Override // com.zzhoujay.richtext.ig.ImageLoader
    public void onLoading() {
        DrawableWrapper drawableWrapper;
        Debug.log(TAG, "onLoading > " + this.holder.getSource());
        if (activityDestroyed() || (drawableWrapper = this.drawableWrapperWeakReference.get()) == null) {
            return;
        }
        this.holder.setImageState(1);
        Drawable placeHolder = this.holder.getPlaceHolder();
        Rect bounds = placeHolder.getBounds();
        drawableWrapper.setDrawable(placeHolder);
        ImageFixCallback imageFixCallback = this.config.imageFixCallback;
        if (imageFixCallback != null) {
            imageFixCallback.onLoading(this.holder);
        }
        if (drawableWrapper.isHasCache()) {
            placeHolder.setBounds(drawableWrapper.getBounds());
        } else {
            drawableWrapper.setScaleType(this.holder.getScaleType());
            drawableWrapper.setBorderHolder(this.holder.getBorderHolder());
            drawableWrapper.setBounds(0, 0, getHolderWidth(bounds.width()), getHolderHeight(bounds.height()));
            drawableWrapper.calculate();
        }
        resetText();
    }

    @Override // com.zzhoujay.richtext.ig.ImageLoader
    public void onResourceReady(ImageWrapper imageWrapper) {
        TextView textView;
        Debug.log(TAG, "onResourceReady > " + this.holder.getSource());
        if (imageWrapper == null) {
            onFailure(new ImageDecodeException());
            return;
        }
        DrawableWrapper drawableWrapper = this.drawableWrapperWeakReference.get();
        if (drawableWrapper == null || (textView = this.textViewWeakReference.get()) == null) {
            return;
        }
        this.imageWrapperWeakReference = new WeakReference<>(imageWrapper);
        this.holder.setImageState(2);
        Drawable drawable = imageWrapper.getDrawable(textView.getResources());
        drawableWrapper.setDrawable(drawable);
        int width = imageWrapper.getWidth();
        int height = imageWrapper.getHeight();
        ImageFixCallback imageFixCallback = this.config.imageFixCallback;
        if (imageFixCallback != null) {
            imageFixCallback.onImageReady(this.holder, width, height);
        }
        if (drawableWrapper.isHasCache()) {
            drawable.setBounds(drawableWrapper.getBounds());
        } else {
            drawableWrapper.setScaleType(this.holder.getScaleType());
            drawableWrapper.setBounds(0, 0, getHolderWidth(width), getHolderHeight(height));
            drawableWrapper.setBorderHolder(this.holder.getBorderHolder());
            drawableWrapper.calculate();
        }
        if (imageWrapper.isGif() && this.holder.isAutoPlay()) {
            imageWrapper.getAsGif().start(textView);
        }
        BitmapPool pool = BitmapPool.getPool();
        String key = this.holder.getKey();
        if (this.config.cacheType.intValue() > CacheType.none.intValue() && !drawableWrapper.isHasCache()) {
            pool.cacheSize(key, drawableWrapper.getSizeHolder());
        }
        if (this.config.cacheType.intValue() > CacheType.layout.intValue() && !imageWrapper.isGif()) {
            pool.cacheBitmap(key, imageWrapper.getAsBitmap());
        }
        resetText();
        done();
    }

    @Override // com.zzhoujay.richtext.ig.ImageLoader
    public int onSizeReady(int i, int i2) {
        Debug.log(TAG, "onSizeReady > width = " + i + " , height = " + i2 + " , " + this.holder.getSource());
        this.holder.setImageState(4);
        ImageHolder.SizeHolder sizeHolder = new ImageHolder.SizeHolder(i, i2);
        ImageFixCallback imageFixCallback = this.config.imageFixCallback;
        if (imageFixCallback != null) {
            imageFixCallback.onSizeReady(this.holder, i, i2, sizeHolder);
        }
        int sampleSize = sizeHolder.isInvalidateSize() ? getSampleSize(i, i2, sizeHolder.getWidth(), sizeHolder.getHeight()) : getSampleSize(i, i2, getRealWidth(), ImageHolder.MATCH_PARENT);
        return Math.max(1, sampleSize == 0 ? 0 : Integer.highestOneBit(sampleSize));
    }

    @Override // com.zzhoujay.richtext.callback.Recyclable
    public void recycle() {
        ImageWrapper imageWrapper;
        WeakReference<ImageWrapper> weakReference = this.imageWrapperWeakReference;
        if (weakReference == null || (imageWrapper = weakReference.get()) == null) {
            return;
        }
        imageWrapper.recycle();
    }
}
