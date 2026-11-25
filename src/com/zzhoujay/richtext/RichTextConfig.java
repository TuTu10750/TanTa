package com.zzhoujay.richtext;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.TextView;
import com.zzhoujay.richtext.ImageHolder;
import com.zzhoujay.richtext.callback.Callback;
import com.zzhoujay.richtext.callback.DrawableGetter;
import com.zzhoujay.richtext.callback.ImageFixCallback;
import com.zzhoujay.richtext.callback.ImageGetter;
import com.zzhoujay.richtext.callback.LinkFixCallback;
import com.zzhoujay.richtext.callback.OnImageClickListener;
import com.zzhoujay.richtext.callback.OnImageLongClickListener;
import com.zzhoujay.richtext.callback.OnUrlClickListener;
import com.zzhoujay.richtext.callback.OnUrlLongClickListener;
import com.zzhoujay.richtext.drawable.DrawableBorderHolder;
import com.zzhoujay.richtext.ig.DefaultImageDownloader;
import com.zzhoujay.richtext.ig.DefaultImageGetter;
import com.zzhoujay.richtext.ig.ImageDownloader;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* loaded from: /tmp/classes2.dex */
public final class RichTextConfig {
    public static final String OK_HTTP_GLOBAL_ID = "com.zzhoujay.okhttpimagedownloader.OkHttpImageDownloader";
    private final HashMap<String, Object> argsPool;
    public final boolean autoFix;
    public final boolean autoPlay;
    public final DrawableBorderHolder borderHolder;
    public final CacheType cacheType;
    public final Callback callback;
    public final int clickable;
    public final DrawableGetter errorImageDrawableGetter;
    public final int height;
    public final ImageDownloader imageDownloader;
    public final ImageFixCallback imageFixCallback;
    final ImageGetter imageGetter;
    public final LinkFixCallback linkFixCallback;
    public final boolean noImage;
    public final OnImageClickListener onImageClickListener;
    public final OnImageLongClickListener onImageLongClickListener;
    public final OnUrlClickListener onUrlClickListener;
    public final OnUrlLongClickListener onUrlLongClickListener;
    public final DrawableGetter placeHolderDrawableGetter;
    public final boolean resetSize;
    private WeakReference<RichText> richTextInstanceWeakReference;
    public final RichType richType;
    public final ImageHolder.ScaleType scaleType;
    public final boolean singleLoad;
    public final String source;
    public final boolean syncParse;
    public final int width;

    /* loaded from: /tmp/classes2.dex */
    public static final class RichTextConfigBuild {
        private static final int SET_BOUNDS = 9;
        Callback callback;
        ImageDownloader imageDownloader;
        ImageFixCallback imageFixCallback;
        ImageGetter imageGetter;
        LinkFixCallback linkFixCallback;
        OnImageClickListener onImageClickListener;
        OnImageLongClickListener onImageLongClickListener;
        OnUrlClickListener onUrlClickListener;
        OnUrlLongClickListener onUrlLongClickListener;
        RichType richType;
        final String source;
        WeakReference<Object> tag;
        private static final Handler HANDLER = new Handler(Looper.getMainLooper()) { // from class: com.zzhoujay.richtext.RichTextConfig.RichTextConfigBuild.1
            @Override // android.os.Handler
            public void dispatchMessage(Message message) {
                if (message.what == 9) {
                    bw2 bw2Var = (bw2) message.obj;
                    Drawable drawable = (Drawable) bw2Var.a;
                    TextView textView = (TextView) bw2Var.b;
                    int width = (textView.getWidth() - textView.getPaddingLeft()) - textView.getPaddingRight();
                    drawable.setBounds(0, 0, width, width / 2);
                }
            }
        };
        private static final DrawableGetter PLACE_HOLDER_DRAWABLE_GETTER = new DrawableGetter() { // from class: com.zzhoujay.richtext.RichTextConfig.RichTextConfigBuild.2
            @Override // com.zzhoujay.richtext.callback.DrawableGetter
            public Drawable getDrawable(ImageHolder imageHolder, RichTextConfig richTextConfig, TextView textView) {
                ColorDrawable colorDrawable = new ColorDrawable(-3355444);
                int width = textView.getWidth();
                colorDrawable.setBounds(0, 0, width, width / 2);
                RichTextConfigBuild.HANDLER.obtainMessage(9, bw2.a(colorDrawable, textView)).sendToTarget();
                return colorDrawable;
            }
        };
        private static final DrawableGetter ERROR_IMAGE_DRAWABLE_GETTER = new DrawableGetter() { // from class: com.zzhoujay.richtext.RichTextConfig.RichTextConfigBuild.3
            @Override // com.zzhoujay.richtext.callback.DrawableGetter
            public Drawable getDrawable(ImageHolder imageHolder, RichTextConfig richTextConfig, TextView textView) {
                ColorDrawable colorDrawable = new ColorDrawable(-12303292);
                int width = textView.getWidth();
                colorDrawable.setBounds(0, 0, width, width / 2);
                RichTextConfigBuild.HANDLER.obtainMessage(9, bw2.a(colorDrawable, textView)).sendToTarget();
                return colorDrawable;
            }
        };
        boolean autoFix = true;
        boolean resetSize = false;
        boolean noImage = false;
        int clickable = 0;
        CacheType cacheType = CacheType.all;
        boolean autoPlay = false;
        ImageHolder.ScaleType scaleType = ImageHolder.ScaleType.none;
        int width = ImageHolder.WRAP_CONTENT;
        int height = ImageHolder.WRAP_CONTENT;
        DrawableBorderHolder borderHolder = new DrawableBorderHolder();
        boolean singleLoad = true;
        DrawableGetter placeHolderDrawableGetter = PLACE_HOLDER_DRAWABLE_GETTER;
        DrawableGetter errorImageDrawableGetter = ERROR_IMAGE_DRAWABLE_GETTER;
        boolean syncParse = false;

        public RichTextConfigBuild(String str, RichType richType) {
            this.source = str;
            this.richType = richType;
        }

        public RichTextConfigBuild autoFix(boolean z) {
            this.autoFix = z;
            return this;
        }

        public RichTextConfigBuild autoPlay(boolean z) {
            this.autoPlay = z;
            return this;
        }

        public RichTextConfigBuild bind(Object obj) {
            this.tag = new WeakReference<>(obj);
            return this;
        }

        public RichTextConfigBuild borderColor(int i) {
            this.borderHolder.setBorderColor(i);
            return this;
        }

        public RichTextConfigBuild borderRadius(float f) {
            this.borderHolder.setRadius(f);
            return this;
        }

        public RichTextConfigBuild borderSize(float f) {
            this.borderHolder.setBorderSize(f);
            return this;
        }

        public RichTextConfigBuild cache(CacheType cacheType) {
            this.cacheType = cacheType;
            return this;
        }

        public RichTextConfigBuild clickable(boolean z) {
            this.clickable = z ? 1 : -1;
            return this;
        }

        public RichTextConfigBuild done(Callback callback) {
            this.callback = callback;
            return this;
        }

        public RichTextConfigBuild errorImage(DrawableGetter drawableGetter) {
            this.errorImageDrawableGetter = drawableGetter;
            return this;
        }

        public RichTextConfigBuild fix(ImageFixCallback imageFixCallback) {
            this.imageFixCallback = imageFixCallback;
            return this;
        }

        public RichTextConfigBuild imageClick(OnImageClickListener onImageClickListener) {
            this.onImageClickListener = onImageClickListener;
            return this;
        }

        public RichTextConfigBuild imageDownloader(ImageDownloader imageDownloader) {
            this.imageDownloader = imageDownloader;
            return this;
        }

        public RichTextConfigBuild imageGetter(ImageGetter imageGetter) {
            this.imageGetter = imageGetter;
            return this;
        }

        public RichTextConfigBuild imageLongClick(OnImageLongClickListener onImageLongClickListener) {
            this.onImageLongClickListener = onImageLongClickListener;
            return this;
        }

        public RichText into(TextView textView) {
            if (this.imageGetter == null) {
                this.imageGetter = new DefaultImageGetter();
            }
            if ((this.imageGetter instanceof DefaultImageGetter) && this.imageDownloader == null) {
                try {
                    Class<?> cls = Class.forName(RichTextConfig.OK_HTTP_GLOBAL_ID);
                    ImageDownloader imageDownloader = (ImageDownloader) RichText.getArgs(RichTextConfig.OK_HTTP_GLOBAL_ID);
                    if (imageDownloader == null) {
                        imageDownloader = (ImageDownloader) cls.newInstance();
                        RichText.putArgs(RichTextConfig.OK_HTTP_GLOBAL_ID, imageDownloader);
                    }
                    this.imageDownloader = imageDownloader;
                } catch (Exception unused) {
                    String str = DefaultImageDownloader.GLOBAL_ID;
                    DefaultImageDownloader defaultImageDownloader = (DefaultImageDownloader) RichText.getArgs(str);
                    if (defaultImageDownloader == null) {
                        defaultImageDownloader = new DefaultImageDownloader();
                        RichText.putArgs(str, defaultImageDownloader);
                    }
                    this.imageDownloader = defaultImageDownloader;
                }
            }
            RichText richText = new RichText(new RichTextConfig(this), textView);
            WeakReference<Object> weakReference = this.tag;
            if (weakReference != null) {
                RichText.bind(weakReference.get(), richText);
            }
            this.tag = null;
            richText.generateAndSet();
            return richText;
        }

        public RichTextConfigBuild linkFix(LinkFixCallback linkFixCallback) {
            this.linkFixCallback = linkFixCallback;
            return this;
        }

        public RichTextConfigBuild noImage(boolean z) {
            this.noImage = z;
            return this;
        }

        public RichTextConfigBuild placeHolder(DrawableGetter drawableGetter) {
            this.placeHolderDrawableGetter = drawableGetter;
            return this;
        }

        public RichTextConfigBuild resetSize(boolean z) {
            this.resetSize = z;
            return this;
        }

        public RichTextConfigBuild scaleType(ImageHolder.ScaleType scaleType) {
            this.scaleType = scaleType;
            return this;
        }

        public RichTextConfigBuild showBorder(boolean z) {
            this.borderHolder.setShowBorder(z);
            return this;
        }

        public RichTextConfigBuild singleLoad(boolean z) {
            this.singleLoad = z;
            return this;
        }

        public RichTextConfigBuild size(int i, int i2) {
            this.width = i;
            this.height = i2;
            return this;
        }

        public RichTextConfigBuild sync(boolean z) {
            this.syncParse = z;
            return this;
        }

        public RichTextConfigBuild type(RichType richType) {
            this.richType = richType;
            return this;
        }

        public RichTextConfigBuild urlClick(OnUrlClickListener onUrlClickListener) {
            this.onUrlClickListener = onUrlClickListener;
            return this;
        }

        public RichTextConfigBuild urlLongClick(OnUrlLongClickListener onUrlLongClickListener) {
            this.onUrlLongClickListener = onUrlLongClickListener;
            return this;
        }
    }

    private RichTextConfig(RichTextConfigBuild richTextConfigBuild) {
        this(richTextConfigBuild.source, richTextConfigBuild.richType, richTextConfigBuild.autoFix, richTextConfigBuild.resetSize, richTextConfigBuild.cacheType, richTextConfigBuild.imageFixCallback, richTextConfigBuild.linkFixCallback, richTextConfigBuild.noImage, richTextConfigBuild.clickable, richTextConfigBuild.onImageClickListener, richTextConfigBuild.onUrlClickListener, richTextConfigBuild.onImageLongClickListener, richTextConfigBuild.onUrlLongClickListener, richTextConfigBuild.imageGetter, richTextConfigBuild.callback, richTextConfigBuild.autoPlay, richTextConfigBuild.scaleType, richTextConfigBuild.width, richTextConfigBuild.height, richTextConfigBuild.borderHolder, richTextConfigBuild.singleLoad, richTextConfigBuild.syncParse, richTextConfigBuild.imageDownloader, richTextConfigBuild.placeHolderDrawableGetter, richTextConfigBuild.errorImageDrawableGetter);
    }

    private RichTextConfig(String str, RichType richType, boolean z, boolean z2, CacheType cacheType, ImageFixCallback imageFixCallback, LinkFixCallback linkFixCallback, boolean z3, int i, OnImageClickListener onImageClickListener, OnUrlClickListener onUrlClickListener, OnImageLongClickListener onImageLongClickListener, OnUrlLongClickListener onUrlLongClickListener, ImageGetter imageGetter, Callback callback, boolean z4, ImageHolder.ScaleType scaleType, int i2, int i3, DrawableBorderHolder drawableBorderHolder, boolean z5, boolean z6, ImageDownloader imageDownloader, DrawableGetter drawableGetter, DrawableGetter drawableGetter2) {
        this.source = str;
        this.richType = richType;
        this.autoFix = z;
        this.resetSize = z2;
        this.imageFixCallback = imageFixCallback;
        this.linkFixCallback = linkFixCallback;
        this.noImage = z3;
        this.cacheType = cacheType;
        this.onImageClickListener = onImageClickListener;
        this.onUrlClickListener = onUrlClickListener;
        this.onImageLongClickListener = onImageLongClickListener;
        this.onUrlLongClickListener = onUrlLongClickListener;
        this.imageGetter = imageGetter;
        this.callback = callback;
        this.scaleType = scaleType;
        this.autoPlay = z4;
        this.width = i2;
        this.height = i3;
        this.borderHolder = drawableBorderHolder;
        this.singleLoad = z5;
        this.syncParse = z6;
        this.imageDownloader = imageDownloader;
        this.placeHolderDrawableGetter = drawableGetter;
        this.errorImageDrawableGetter = drawableGetter2;
        if (i == 0 && (onImageLongClickListener != null || onUrlLongClickListener != null || onImageClickListener != null || onUrlClickListener != null)) {
            i = 1;
        }
        this.clickable = i;
        this.argsPool = new HashMap<>();
    }

    public Object getArgs(String str) {
        return this.argsPool.get(str);
    }

    public RichText getRichTextInstance() {
        WeakReference<RichText> weakReference = this.richTextInstanceWeakReference;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public int key() {
        return (((((((((((((((((((((this.source.hashCode() * 31) + this.richType.hashCode()) * 31) + (this.autoFix ? 1 : 0)) * 31) + (this.resetSize ? 1 : 0)) * 31) + (this.autoPlay ? 1 : 0)) * 31) + this.scaleType.hashCode()) * 31) + this.cacheType.hashCode()) * 31) + this.width) * 31) + this.height) * 31) + (this.noImage ? 1 : 0)) * 31) + this.clickable) * 31) + this.borderHolder.hashCode();
    }

    public void setArgs(String str, Object obj) {
        this.argsPool.put(str, obj);
    }

    public void setRichTextInstance(RichText richText) {
        if (this.richTextInstanceWeakReference == null) {
            this.richTextInstanceWeakReference = new WeakReference<>(richText);
        }
    }
}
