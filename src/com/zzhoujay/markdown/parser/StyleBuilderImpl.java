package com.zzhoujay.markdown.parser;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.StrikethroughSpan;
import android.widget.TextView;
import com.umeng.umcrash.custom_exception.UMCustomLogInfoBuilder;
import com.zzhoujay.markdown.style.CodeBlockSpan;
import com.zzhoujay.markdown.style.CodeSpan;
import com.zzhoujay.markdown.style.EmailSpan;
import com.zzhoujay.markdown.style.FontSpan;
import com.zzhoujay.markdown.style.LinkSpan;
import com.zzhoujay.markdown.style.MarkDownBulletSpan;
import com.zzhoujay.markdown.style.MarkDownQuoteSpan;
import com.zzhoujay.markdown.style.QuotaBulletSpan;
import com.zzhoujay.markdown.style.UnderLineSpan;
import java.lang.ref.WeakReference;

/* loaded from: /tmp/classes2.dex */
public class StyleBuilderImpl implements StyleBuilder {
    private static final float scale_h1 = 2.25f;
    private static final float scale_h2 = 1.75f;
    private static final float scale_h3 = 1.5f;
    private static final float scale_h4 = 1.25f;
    private static final float scale_h5 = 1.0f;
    private static final float scale_h6 = 1.0f;
    private static final float scale_normal = 1.0f;
    private Html.ImageGetter imageGetter;
    private WeakReference<TextView> textViewWeakReference;
    private static final int h1_color = Color.parseColor("#333333");
    private static final int h6_color = Color.parseColor("#777777");
    private static final int quota_color = Color.parseColor("#DDDDDD");
    private static final int code_color = Color.parseColor("#F0F0F0");
    private static final int link_color = Color.parseColor("#4078C0");
    private static final int h_under_line_color = Color.parseColor("#eeeeee");

    public StyleBuilderImpl(TextView textView, Html.ImageGetter imageGetter) {
        this.textViewWeakReference = new WeakReference<>(textView);
        this.imageGetter = imageGetter;
    }

    private int getTextViewRealWidth() {
        TextView textView = this.textViewWeakReference.get();
        if (textView != null) {
            return (textView.getWidth() - textView.getPaddingRight()) - textView.getPaddingLeft();
        }
        return 0;
    }

    private SpannableStringBuilder hWithUnderLine(CharSequence charSequence, float f) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        spannableStringBuilder.setSpan(new FontSpan(f, 1, h1_color), 0, spannableStringBuilder.length(), 33);
        UnderLineSpan underLineSpan = new UnderLineSpan(new ColorDrawable(h_under_line_color), getTextViewRealWidth(), 5);
        spannableStringBuilder.append('\n');
        int length = charSequence.length() + 1;
        spannableStringBuilder.append((CharSequence) "$");
        spannableStringBuilder.setSpan(underLineSpan, length, spannableStringBuilder.length(), 33);
        return spannableStringBuilder;
    }

    @Override // com.zzhoujay.markdown.parser.StyleBuilder
    public SpannableStringBuilder code(CharSequence charSequence) {
        SpannableStringBuilder valueOf = SpannableStringBuilder.valueOf(charSequence);
        valueOf.setSpan(new CodeSpan(code_color), 0, charSequence.length(), 33);
        return valueOf;
    }

    @Override // com.zzhoujay.markdown.parser.StyleBuilder
    public SpannableStringBuilder codeBlock(String str) {
        return codeBlock(str.split(UMCustomLogInfoBuilder.LINE_SEP));
    }

    @Override // com.zzhoujay.markdown.parser.StyleBuilder
    public SpannableStringBuilder codeBlock(CharSequence... charSequenceArr) {
        SpannableStringBuilder valueOf = SpannableStringBuilder.valueOf("$");
        valueOf.setSpan(new CodeBlockSpan(getTextViewRealWidth(), code_color, charSequenceArr), 0, valueOf.length(), 33);
        return valueOf;
    }

    @Override // com.zzhoujay.markdown.parser.StyleBuilder
    public SpannableStringBuilder delete(CharSequence charSequence) {
        SpannableStringBuilder valueOf = SpannableStringBuilder.valueOf(charSequence);
        StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
        valueOf.setSpan(new ForegroundColorSpan(h1_color), 0, charSequence.length(), 33);
        valueOf.setSpan(strikethroughSpan, 0, charSequence.length(), 33);
        return valueOf;
    }

    @Override // com.zzhoujay.markdown.parser.StyleBuilder
    public SpannableStringBuilder em(CharSequence charSequence) {
        SpannableStringBuilder valueOf = SpannableStringBuilder.valueOf(charSequence);
        valueOf.setSpan(new FontSpan(1.0f, 1, h1_color), 0, charSequence.length(), 33);
        return valueOf;
    }

    @Override // com.zzhoujay.markdown.parser.StyleBuilder
    public SpannableStringBuilder emItalic(CharSequence charSequence) {
        SpannableStringBuilder valueOf = SpannableStringBuilder.valueOf(charSequence);
        valueOf.setSpan(new FontSpan(1.0f, 3, h1_color), 0, charSequence.length(), 33);
        return valueOf;
    }

    @Override // com.zzhoujay.markdown.parser.StyleBuilder
    public SpannableStringBuilder email(CharSequence charSequence) {
        SpannableStringBuilder valueOf = SpannableStringBuilder.valueOf(charSequence);
        valueOf.setSpan(new EmailSpan(charSequence.toString(), link_color), 0, charSequence.length(), 33);
        return valueOf;
    }

    @Override // com.zzhoujay.markdown.parser.StyleBuilder
    public SpannableStringBuilder gap() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("$");
        spannableStringBuilder.setSpan(new UnderLineSpan(new ColorDrawable(h_under_line_color), getTextViewRealWidth(), 10), 0, spannableStringBuilder.length(), 33);
        return spannableStringBuilder;
    }

    public SpannableStringBuilder h(CharSequence charSequence, float f, int i) {
        SpannableStringBuilder valueOf = SpannableStringBuilder.valueOf(charSequence);
        valueOf.setSpan(new FontSpan(f, 1, i), 0, valueOf.length(), 33);
        return valueOf;
    }

    @Override // com.zzhoujay.markdown.parser.StyleBuilder
    public SpannableStringBuilder h1(CharSequence charSequence) {
        return hWithUnderLine(charSequence, scale_h1);
    }

    @Override // com.zzhoujay.markdown.parser.StyleBuilder
    public SpannableStringBuilder h2(CharSequence charSequence) {
        return hWithUnderLine(charSequence, scale_h2);
    }

    @Override // com.zzhoujay.markdown.parser.StyleBuilder
    public SpannableStringBuilder h3(CharSequence charSequence) {
        return h(charSequence, scale_h3, h1_color);
    }

    @Override // com.zzhoujay.markdown.parser.StyleBuilder
    public SpannableStringBuilder h4(CharSequence charSequence) {
        return h(charSequence, scale_h4, h1_color);
    }

    @Override // com.zzhoujay.markdown.parser.StyleBuilder
    public SpannableStringBuilder h5(CharSequence charSequence) {
        return h(charSequence, 1.0f, h1_color);
    }

    @Override // com.zzhoujay.markdown.parser.StyleBuilder
    public SpannableStringBuilder h6(CharSequence charSequence) {
        return h(charSequence, 1.0f, h6_color);
    }

    @Override // com.zzhoujay.markdown.parser.StyleBuilder
    public SpannableStringBuilder image(CharSequence charSequence, String str, String str2) {
        if (charSequence == null || charSequence.length() == 0) {
            charSequence = "$";
        }
        SpannableStringBuilder valueOf = SpannableStringBuilder.valueOf(charSequence);
        Html.ImageGetter imageGetter = this.imageGetter;
        Drawable drawable = imageGetter != null ? imageGetter.getDrawable(str) : null;
        if (drawable == null) {
            drawable = new ColorDrawable(0);
        }
        valueOf.setSpan(new ImageSpan(drawable, str), 0, valueOf.length(), 33);
        return valueOf;
    }

    @Override // com.zzhoujay.markdown.parser.StyleBuilder
    public SpannableStringBuilder italic(CharSequence charSequence) {
        SpannableStringBuilder valueOf = SpannableStringBuilder.valueOf(charSequence);
        valueOf.setSpan(new FontSpan(1.0f, 2, h1_color), 0, charSequence.length(), 33);
        return valueOf;
    }

    @Override // com.zzhoujay.markdown.parser.StyleBuilder
    public SpannableStringBuilder link(CharSequence charSequence, String str, String str2) {
        SpannableStringBuilder valueOf = SpannableStringBuilder.valueOf(charSequence);
        valueOf.setSpan(new LinkSpan(str, link_color), 0, charSequence.length(), 33);
        return valueOf;
    }

    @Override // com.zzhoujay.markdown.parser.StyleBuilder
    public SpannableStringBuilder ol(CharSequence charSequence, int i, int i2) {
        SpannableStringBuilder valueOf = SpannableStringBuilder.valueOf(charSequence);
        valueOf.setSpan(new MarkDownBulletSpan(i, h1_color, i2, this.textViewWeakReference.get()), 0, valueOf.length(), 33);
        return valueOf;
    }

    @Override // com.zzhoujay.markdown.parser.StyleBuilder
    public SpannableStringBuilder ol2(CharSequence charSequence, int i, int i2, int i3) {
        SpannableStringBuilder valueOf = SpannableStringBuilder.valueOf(charSequence);
        valueOf.setSpan(new QuotaBulletSpan(i, i2, quota_color, h1_color, i3, this.textViewWeakReference.get()), 0, valueOf.length(), 33);
        return valueOf;
    }

    @Override // com.zzhoujay.markdown.parser.StyleBuilder
    public SpannableStringBuilder quota(CharSequence charSequence) {
        SpannableStringBuilder valueOf = SpannableStringBuilder.valueOf(charSequence);
        valueOf.setSpan(new MarkDownQuoteSpan(quota_color), 0, valueOf.length(), 33);
        return valueOf;
    }

    @Override // com.zzhoujay.markdown.parser.StyleBuilder
    public SpannableStringBuilder ul(CharSequence charSequence, int i) {
        SpannableStringBuilder valueOf = SpannableStringBuilder.valueOf(charSequence);
        valueOf.setSpan(new MarkDownBulletSpan(i, h1_color, 0), 0, valueOf.length(), 33);
        return valueOf;
    }

    @Override // com.zzhoujay.markdown.parser.StyleBuilder
    public SpannableStringBuilder ul2(CharSequence charSequence, int i, int i2) {
        SpannableStringBuilder valueOf = SpannableStringBuilder.valueOf(charSequence);
        valueOf.setSpan(new QuotaBulletSpan(i, i2, quota_color, h1_color, 0, this.textViewWeakReference.get()), 0, valueOf.length(), 33);
        return valueOf;
    }
}
