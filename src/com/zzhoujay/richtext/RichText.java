package com.zzhoujay.richtext;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import com.zzhoujay.richtext.RichTextConfig;
import com.zzhoujay.richtext.cache.BitmapPool;
import com.zzhoujay.richtext.callback.Callback;
import com.zzhoujay.richtext.callback.ImageFixCallback;
import com.zzhoujay.richtext.callback.ImageLoadNotify;
import com.zzhoujay.richtext.ext.ContextKit;
import com.zzhoujay.richtext.ext.Debug;
import com.zzhoujay.richtext.ext.HtmlTagHandler;
import com.zzhoujay.richtext.ext.LongClickableLinkMovementMethod;
import com.zzhoujay.richtext.parser.CachedSpannedParser;
import com.zzhoujay.richtext.parser.Html2SpannedParser;
import com.zzhoujay.richtext.parser.ImageGetterWrapper;
import com.zzhoujay.richtext.parser.Markdown2SpannedParser;
import com.zzhoujay.richtext.parser.SpannedParser;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: /tmp/classes2.dex */
public class RichText implements ImageGetterWrapper, ImageLoadNotify {
    private static final String TAG = "RichText";
    private static final String TAG_TARGET = "target";
    public static boolean debugMode = true;
    private final CachedSpannedParser cachedSpannedParser;
    private final RichTextConfig config;
    private int count;
    private HashMap<String, ImageHolder> imageHolderMap;
    private int loadingCount;
    private final SpannedParser spannedParser;
    private RichState state = RichState.ready;
    private final WeakReference<TextView> textViewWeakReference;
    private static Pattern IMAGE_TAG_PATTERN = Pattern.compile("<(img|IMG)(.*?)>");
    private static Pattern IMAGE_WIDTH_PATTERN = Pattern.compile("(width|WIDTH)=\"(.*?)\"");
    private static Pattern IMAGE_HEIGHT_PATTERN = Pattern.compile("(height|HEIGHT)=\"(.*?)\"");
    private static Pattern IMAGE_SRC_PATTERN = Pattern.compile("(src|SRC)=\"(.*?)\"");
    private static final HashMap<String, Object> GLOBAL_ARGS = new HashMap<>();

    /* loaded from: /tmp/classes2.dex */
    public static class ParseAsyncTask extends AsyncTask<Void, Void, CharSequence> {
        private RichText richText;
        private WeakReference<TextView> textViewWeakReference;

        public ParseAsyncTask(RichText richText, TextView textView) {
            this.richText = richText;
            this.textViewWeakReference = new WeakReference<>(textView);
        }

        @Override // android.os.AsyncTask
        public CharSequence doInBackground(Void[] voidArr) {
            if (this.textViewWeakReference.get() == null) {
                return null;
            }
            return this.richText.generateRichText();
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(CharSequence charSequence) {
            TextView textView;
            WeakReference<TextView> weakReference = this.textViewWeakReference;
            if (weakReference == null || (textView = weakReference.get()) == null || charSequence == null) {
                return;
            }
            if (this.richText.config.cacheType.intValue() >= CacheType.layout.intValue()) {
                RichTextPool.getPool().cache(this.richText.config.source, (SpannableStringBuilder) charSequence);
            }
            textView.setText(charSequence);
            if (this.richText.config.callback != null) {
                this.richText.config.callback.done(false);
            }
        }
    }

    public RichText(RichTextConfig richTextConfig, TextView textView) {
        this.config = richTextConfig;
        this.textViewWeakReference = new WeakReference<>(textView);
        if (richTextConfig.richType == RichType.markdown) {
            this.spannedParser = new Markdown2SpannedParser(textView);
        } else {
            this.spannedParser = new Html2SpannedParser(new HtmlTagHandler(textView));
        }
        int i = richTextConfig.clickable;
        if (i > 0) {
            textView.setMovementMethod(new LongClickableLinkMovementMethod());
        } else if (i == 0) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        this.cachedSpannedParser = new CachedSpannedParser();
        richTextConfig.setRichTextInstance(this);
    }

    private synchronized void analyzeImages(String str) {
        try {
            this.imageHolderMap = new HashMap<>();
            Matcher matcher = IMAGE_TAG_PATTERN.matcher(str);
            int i = 0;
            while (matcher.find()) {
                String trim = matcher.group(2).trim();
                Matcher matcher2 = IMAGE_SRC_PATTERN.matcher(trim);
                String trim2 = matcher2.find() ? matcher2.group(2).trim() : null;
                if (!TextUtils.isEmpty(trim2)) {
                    ImageHolder imageHolder = new ImageHolder(trim2, i, this.config, this.textViewWeakReference.get());
                    imageHolder.setIsGif(isGif(trim2));
                    RichTextConfig richTextConfig = this.config;
                    if (!richTextConfig.autoFix && !richTextConfig.resetSize) {
                        Matcher matcher3 = IMAGE_WIDTH_PATTERN.matcher(trim);
                        if (matcher3.find()) {
                            imageHolder.setWidth(parseStringToInteger(matcher3.group(2).trim()));
                        }
                        Matcher matcher4 = IMAGE_HEIGHT_PATTERN.matcher(trim);
                        if (matcher4.find()) {
                            imageHolder.setHeight(parseStringToInteger(matcher4.group(2).trim()));
                        }
                    }
                    this.imageHolderMap.put(imageHolder.getSource(), imageHolder);
                    i++;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private void asyncGenerate(TextView textView) {
        ParseAsyncTask parseAsyncTask = new ParseAsyncTask(this, textView);
        if (this.config.singleLoad) {
            parseAsyncTask.execute(new Void[0]);
        } else {
            parseAsyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    public static void bind(Object obj, RichText richText) {
        RichTextPool.getPool().bind(obj, richText);
    }

    public static void clear(Object obj) {
        RichTextPool.getPool().clear(obj);
    }

    public static RichTextConfig.RichTextConfigBuild from(String str) {
        return fromHtml(str);
    }

    public static RichTextConfig.RichTextConfigBuild from(String str, RichType richType) {
        return new RichTextConfig.RichTextConfigBuild(str, richType);
    }

    public static RichTextConfig.RichTextConfigBuild fromHtml(String str) {
        return from(str, RichType.html);
    }

    public static RichTextConfig.RichTextConfigBuild fromMarkdown(String str) {
        return from(str, RichType.markdown);
    }

    public static Object getArgs(String str) {
        Object obj;
        HashMap<String, Object> hashMap = GLOBAL_ARGS;
        synchronized (hashMap) {
            obj = hashMap.get(str);
        }
        return obj;
    }

    public static void initCacheDir(Context context) {
        File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir == null) {
            externalCacheDir = context.getCacheDir();
        }
        initCacheDir(externalCacheDir);
    }

    public static void initCacheDir(File file) {
        BitmapPool.setCacheDir(file);
    }

    private static boolean isGif(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf > 0 && "gif".toUpperCase().equals(str.substring(lastIndexOf + 1).toUpperCase());
    }

    private SpannableStringBuilder parseRichText() {
        Spanned parse = this.spannedParser.parse(this.config.source);
        if (parse instanceof SpannableStringBuilder) {
            return (SpannableStringBuilder) parse;
        }
        if (parse == null) {
            parse = new SpannableString("");
        }
        return new SpannableStringBuilder(parse);
    }

    private static int parseStringToInteger(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static void putArgs(String str, Object obj) {
        HashMap<String, Object> hashMap = GLOBAL_ARGS;
        synchronized (hashMap) {
            hashMap.put(str, obj);
        }
    }

    public static void recycle() {
        BitmapPool.getPool().clear();
        RichTextPool.getPool().recycle();
    }

    public void clear() {
        TextView textView = this.textViewWeakReference.get();
        if (textView != null) {
            textView.setText((CharSequence) null);
        }
        this.config.imageGetter.recycle();
    }

    @Override // com.zzhoujay.richtext.callback.ImageLoadNotify
    public void done(Object obj) {
        if (!(obj instanceof Integer) || ((Integer) obj).intValue() < this.count) {
            return;
        }
        this.state = RichState.loaded;
        TextView textView = this.textViewWeakReference.get();
        if (this.config.callback == null || textView == null) {
            return;
        }
        textView.post(new Runnable() { // from class: com.zzhoujay.richtext.RichText.1
            @Override // java.lang.Runnable
            public void run() {
                RichText.this.config.callback.done(true);
            }
        });
    }

    public void generateAndSet() {
        TextView textView = this.textViewWeakReference.get();
        if (textView == null) {
            Debug.loge(TAG, "generateAndSet textView is recycle");
            return;
        }
        if (!this.config.syncParse) {
            asyncGenerate(textView);
            return;
        }
        textView.setText(generateRichText());
        Callback callback = this.config.callback;
        if (callback != null) {
            callback.done(false);
        }
    }

    public CharSequence generateRichText() {
        if (this.textViewWeakReference.get() == null) {
            return null;
        }
        RichTextConfig richTextConfig = this.config;
        if (richTextConfig.richType != RichType.markdown) {
            analyzeImages(richTextConfig.source);
        } else {
            this.imageHolderMap = new HashMap<>();
        }
        this.state = RichState.loading;
        SpannableStringBuilder loadCache = this.config.cacheType.intValue() > CacheType.none.intValue() ? RichTextPool.getPool().loadCache(this.config.source) : null;
        if (loadCache == null) {
            loadCache = parseRichText();
        }
        this.config.imageGetter.registerImageLoadNotify(this);
        this.count = this.cachedSpannedParser.parse(loadCache, this, this.config);
        return loadCache;
    }

    @Override // com.zzhoujay.richtext.parser.ImageGetterWrapper
    public Drawable getDrawable(String str) {
        TextView textView;
        ImageHolder imageHolder;
        this.loadingCount++;
        RichTextConfig richTextConfig = this.config;
        if (richTextConfig.imageGetter == null || richTextConfig.noImage || (textView = this.textViewWeakReference.get()) == null || !ContextKit.activityIsAlive(textView.getContext())) {
            return null;
        }
        RichTextConfig richTextConfig2 = this.config;
        if (richTextConfig2.richType == RichType.markdown) {
            imageHolder = new ImageHolder(str, this.loadingCount - 1, richTextConfig2, textView);
            this.imageHolderMap.put(str, imageHolder);
        } else {
            imageHolder = this.imageHolderMap.get(str);
            if (imageHolder == null) {
                imageHolder = new ImageHolder(str, this.loadingCount - 1, this.config, textView);
                this.imageHolderMap.put(str, imageHolder);
            }
        }
        imageHolder.setImageState(0);
        ImageFixCallback imageFixCallback = this.config.imageFixCallback;
        if (imageFixCallback != null) {
            imageFixCallback.onInit(imageHolder);
            if (!imageHolder.isShow()) {
                return null;
            }
        }
        RichTextConfig richTextConfig3 = this.config;
        return richTextConfig3.imageGetter.getDrawable(imageHolder, richTextConfig3, textView);
    }

    public RichState getState() {
        return this.state;
    }
}
