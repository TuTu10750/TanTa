package defpackage;

import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import com.yunbao.common.CommonAppContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: /tmp/classes2.dex */
public abstract class iz0 {
    public static ForegroundColorSpan a = new ForegroundColorSpan(-3618616);
    public static AbsoluteSizeSpan b = new AbsoluteSizeSpan(12, true);
    public static final int c = zn0.a(20);
    public static final int d = zn0.a(16);
    public static final Pattern e = Pattern.compile("\\[([一-龥\\w])+\\]");

    public static CharSequence a(String str, int i) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        Drawable d2 = o60.d(CommonAppContext.n(), i);
        int i2 = c;
        d2.setBounds(0, 0, i2, i2);
        spannableStringBuilder.setSpan(new ImageSpan(d2, 0), 0, str.length(), 33);
        return spannableStringBuilder;
    }

    public static CharSequence b(String str) {
        Matcher matcher = e.matcher(str);
        SpannableStringBuilder spannableStringBuilder = null;
        boolean z = false;
        while (matcher.find()) {
            String group = matcher.group();
            Integer a2 = jz0.a(group);
            if (a2 != null && a2.intValue() != 0) {
                if (spannableStringBuilder == null) {
                    spannableStringBuilder = new SpannableStringBuilder(str);
                }
                Drawable d2 = o60.d(CommonAppContext.n(), a2.intValue());
                if (d2 != null) {
                    int i = c;
                    d2.setBounds(0, 0, i, i);
                    kx kxVar = new kx(d2);
                    int start = matcher.start();
                    spannableStringBuilder.setSpan(kxVar, start, group.length() + start, 33);
                }
                z = true;
            }
        }
        return z ? spannableStringBuilder : str;
    }

    public static CharSequence c(String str, String str2) {
        Drawable d2;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        Matcher matcher = e.matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            Integer a2 = jz0.a(group);
            if (a2 != null && a2.intValue() != 0 && (d2 = o60.d(CommonAppContext.n(), a2.intValue())) != null) {
                int i = d;
                d2.setBounds(0, 0, i, i);
                ImageSpan imageSpan = new ImageSpan(d2, 0);
                int start = matcher.start();
                spannableStringBuilder.setSpan(imageSpan, start, group.length() + start, 33);
            }
        }
        int length = spannableStringBuilder.length();
        spannableStringBuilder.append((CharSequence) str2);
        int length2 = str2.length() + length;
        spannableStringBuilder.setSpan(a, length, length2, 33);
        spannableStringBuilder.setSpan(b, length, length2, 33);
        return spannableStringBuilder;
    }

    public static String d(String str, String str2) {
        return e.matcher(str).replaceAll(str2);
    }
}
