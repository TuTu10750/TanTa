package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.StyleSpan;
import android.widget.TextView;
import com.yunbao.common.CommonAppContext;
import com.yunbao.common.bean.LevelBean;
import com.yunbao.live.bean.LiveChatBean;
import defpackage.kn1;

/* loaded from: /tmp/classes2.dex */
public abstract class n52 {
    public static StyleSpan a = new StyleSpan(1);
    public static StyleSpan b = new StyleSpan(0);
    public static ForegroundColorSpan c = new ForegroundColorSpan(-1);
    public static ForegroundColorSpan d = new ForegroundColorSpan(-42888);
    public static AbsoluteSizeSpan e = new AbsoluteSizeSpan(17, true);
    public static AbsoluteSizeSpan f = new AbsoluteSizeSpan(12, true);
    public static AbsoluteSizeSpan g = new AbsoluteSizeSpan(14, true);

    /* loaded from: /tmp/classes2.dex */
    public class a implements kn1.a {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ LiveChatBean b;

        public a(TextView textView, LiveChatBean liveChatBean) {
            this.a = textView;
            this.b = liveChatBean;
        }

        @Override // kn1.a
        public void onLoadFailed() {
            if (this.a != null) {
                SpannableStringBuilder b = n52.b(null, this.b);
                b.length();
                b.append((CharSequence) (this.b.getUserNiceName() + " "));
                this.a.setText(b);
            }
        }

        @Override // kn1.a
        public void onLoadSuccess(Drawable drawable) {
            if (this.a != null) {
                SpannableStringBuilder b = n52.b(drawable, this.b);
                b.length();
                b.append((CharSequence) (this.b.getUserNiceName() + " "));
                b.append((CharSequence) this.b.getContent());
                this.a.setText(b);
            }
        }
    }

    public static SpannableStringBuilder b(Drawable drawable, LiveChatBean liveChatBean) {
        int i;
        Drawable d2;
        Drawable d3;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (drawable != null) {
            spannableStringBuilder.append((CharSequence) "  ");
            drawable.setBounds(0, 0, zn0.a(28), zn0.a(14));
            spannableStringBuilder.setSpan(new mg4(drawable), 0, 1, 33);
            i = 2;
        } else {
            i = 0;
        }
        if (liveChatBean.getVipType() != 0 && (d3 = o60.d(CommonAppContext.n(), t83.F)) != null) {
            spannableStringBuilder.append((CharSequence) "  ");
            d3.setBounds(0, 0, zn0.a(28), zn0.a(14));
            spannableStringBuilder.setSpan(new mg4(d3), i, i + 1, 33);
            i += 2;
        }
        if (liveChatBean.getGuardType() != 0) {
            Drawable d4 = o60.d(CommonAppContext.n(), liveChatBean.getGuardType() == 2 ? t83.B : t83.A);
            if (d4 != null) {
                spannableStringBuilder.append((CharSequence) "  ");
                d4.setBounds(0, 0, zn0.a(16), zn0.a(16));
                spannableStringBuilder.setSpan(new mg4(d4), i, i + 1, 33);
                i += 2;
            }
        }
        if (!TextUtils.isEmpty(liveChatBean.getLiangName()) && (d2 = o60.d(CommonAppContext.n(), t83.C)) != null) {
            spannableStringBuilder.append((CharSequence) "  ");
            d2.setBounds(0, 0, zn0.a(17), zn0.a(14));
            spannableStringBuilder.setSpan(new mg4(d2), i, i + 1, 33);
        }
        return spannableStringBuilder;
    }

    public static void c(Context context, TextView textView, LiveChatBean liveChatBean) {
        LevelBean s = j30.q().s(liveChatBean.getLevel());
        if (s == null) {
            return;
        }
        kn1.j(context, s.getThumb(), new a(textView, liveChatBean));
    }

    public static SpannableStringBuilder d(int i) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String valueOf = String.valueOf(i);
        spannableStringBuilder.append((CharSequence) valueOf);
        int length = valueOf.length();
        for (int i2 = 0; i2 < length; i2++) {
            String valueOf2 = String.valueOf(valueOf.charAt(i2));
            if (rv3.g(valueOf2)) {
                Drawable d2 = o60.d(CommonAppContext.n(), f32.b(rv3.h(valueOf2, 0)));
                if (d2 != null) {
                    d2.setBounds(0, 0, zn0.a(24), zn0.a(32));
                    spannableStringBuilder.setSpan(new ImageSpan(d2), i2, i2 + 1, 33);
                }
            }
        }
        return spannableStringBuilder;
    }

    public static SpannableStringBuilder e(String str, String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String a2 = TextUtils.isEmpty(str2) ? aq4.a(m93.C4) : aq4.b(m93.H4, str2);
        String a3 = rv3.a(a2, " ", str);
        int length = a2.length();
        spannableStringBuilder.append((CharSequence) a3);
        spannableStringBuilder.setSpan(d, length, a3.length(), 33);
        return spannableStringBuilder;
    }

    public static CharSequence f(long j) {
        if (j < 10000) {
            return String.valueOf(j);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String str = " " + aq4.a(m93.S8);
        String str2 = rv3.j(j) + str;
        spannableStringBuilder.append((CharSequence) str2);
        int length = str2.length();
        int length2 = length - str.length();
        spannableStringBuilder.setSpan(b, length2, length, 33);
        spannableStringBuilder.setSpan(f, length2, length, 33);
        return spannableStringBuilder;
    }
}
