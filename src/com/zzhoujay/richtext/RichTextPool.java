package com.zzhoujay.richtext;

import android.text.SpannableStringBuilder;
import com.zzhoujay.richtext.ext.Debug;
import com.zzhoujay.richtext.ext.MD5;
import com.zzhoujay.richtext.parser.CachedSpannedParser;
import com.zzhoujay.richtext.spans.ClickableImageSpan;
import com.zzhoujay.richtext.spans.LongClickableURLSpan;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.WeakHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /tmp/classes2.dex */
public class RichTextPool {
    private static final int MAX_RICH_TEXT_SIZE = 50;
    private static final String TAG = "RichTextPool";
    private final WeakHashMap<Object, HashSet<WeakReference<RichText>>> instances;
    private final j92 richCache;

    /* loaded from: /tmp/classes2.dex */
    public static class RichTextPoolHolder {
        private static final RichTextPool RICH_TEXT_POOL = new RichTextPool();

        private RichTextPoolHolder() {
        }
    }

    private RichTextPool() {
        this.richCache = new j92(MAX_RICH_TEXT_SIZE);
        this.instances = new WeakHashMap<>();
    }

    public static RichTextPool getPool() {
        return RichTextPoolHolder.RICH_TEXT_POOL;
    }

    public void bind(Object obj, RichText richText) {
        HashSet<WeakReference<RichText>> hashSet = this.instances.get(obj);
        if (hashSet == null) {
            hashSet = new HashSet<>();
            this.instances.put(obj, hashSet);
        }
        hashSet.add(new WeakReference<>(richText));
    }

    public void cache(String str, SpannableStringBuilder spannableStringBuilder) {
        String generate = MD5.generate(str);
        if (this.richCache.get(generate) != null) {
            Debug.log(TAG, "cached");
            return;
        }
        SpannableStringBuilder clearSpans = clearSpans(new SpannableStringBuilder(spannableStringBuilder));
        clearSpans.setSpan(new CachedSpannedParser.Cached(), 0, clearSpans.length(), 33);
        this.richCache.put(generate, new SoftReference(clearSpans));
    }

    public void clear(Object obj) {
        HashSet<WeakReference<RichText>> hashSet = this.instances.get(obj);
        if (hashSet != null) {
            Iterator<WeakReference<RichText>> it = hashSet.iterator();
            while (it.hasNext()) {
                RichText richText = it.next().get();
                if (richText != null) {
                    richText.clear();
                }
            }
        }
        this.instances.remove(obj);
    }

    public SpannableStringBuilder clearSpans(SpannableStringBuilder spannableStringBuilder) {
        ClickableImageSpan[] clickableImageSpanArr = (ClickableImageSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), ClickableImageSpan.class);
        if (clickableImageSpanArr != null && clickableImageSpanArr.length > 0) {
            for (ClickableImageSpan clickableImageSpan : clickableImageSpanArr) {
                int spanStart = spannableStringBuilder.getSpanStart(clickableImageSpan);
                int spanEnd = spannableStringBuilder.getSpanEnd(clickableImageSpan);
                int spanFlags = spannableStringBuilder.getSpanFlags(clickableImageSpan);
                Object copy = clickableImageSpan.copy();
                spannableStringBuilder.removeSpan(clickableImageSpan);
                spannableStringBuilder.setSpan(copy, spanStart, spanEnd, spanFlags);
            }
            Debug.loge(TAG, "clearSpans > " + clickableImageSpanArr.length);
        }
        LongClickableURLSpan[] longClickableURLSpanArr = (LongClickableURLSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), LongClickableURLSpan.class);
        if (longClickableURLSpanArr != null && longClickableURLSpanArr.length > 0) {
            for (LongClickableURLSpan longClickableURLSpan : longClickableURLSpanArr) {
                int spanStart2 = spannableStringBuilder.getSpanStart(longClickableURLSpan);
                int spanEnd2 = spannableStringBuilder.getSpanEnd(longClickableURLSpan);
                int spanFlags2 = spannableStringBuilder.getSpanFlags(longClickableURLSpan);
                Object copy2 = longClickableURLSpan.copy();
                spannableStringBuilder.removeSpan(longClickableURLSpan);
                spannableStringBuilder.setSpan(copy2, spanStart2, spanEnd2, spanFlags2);
            }
        }
        return spannableStringBuilder;
    }

    public SpannableStringBuilder loadCache(String str) {
        SoftReference softReference = (SoftReference) this.richCache.get(MD5.generate(str));
        SpannableStringBuilder spannableStringBuilder = softReference == null ? null : (SpannableStringBuilder) softReference.get();
        if (spannableStringBuilder == null) {
            return null;
        }
        Debug.log(TAG, "cache hit -- text");
        return new SpannableStringBuilder(spannableStringBuilder);
    }

    public void recycle() {
        this.richCache.evictAll();
    }
}
