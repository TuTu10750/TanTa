package defpackage;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.TextView;
import com.yunbao.common.activity.WebViewActivity;
import com.yunbao.common.http.HttpCallback;

/* loaded from: /tmp/classes2.dex */
public class ix2 extends l0 implements View.OnClickListener {
    public String A0;
    public CheckBox B0;
    public String z0;

    /* loaded from: /tmp/classes2.dex */
    public class a extends ClickableSpan {
        public a() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (view instanceof TextView) {
                ((TextView) view).setHighlightColor(0);
            }
            WebViewActivity.E1(ix2.this.x0, wg1.u);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setUnderlineText(false);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends HttpCallback {
        public b() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i == 0) {
                ix2.this.S1();
            }
            t54.b(str);
        }
    }

    private void s2() {
        if (this.B0.isChecked()) {
            ec2.b(new b());
        } else {
            t54.a(m93.q8);
        }
    }

    @Override // defpackage.l0
    public boolean f2() {
        return true;
    }

    @Override // defpackage.l0
    public int l2() {
        return s93.c;
    }

    @Override // defpackage.l0
    public int m2() {
        return z73.i0;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d73.B) {
            s2();
        }
    }

    @Override // defpackage.l0
    public void p2(Window window) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = zn0.a(270);
        attributes.height = -2;
        attributes.gravity = 17;
        window.setAttributes(attributes);
    }

    public void r0(Bundle bundle) {
        super.r0(bundle);
        this.B0 = (CheckBox) k2(d73.y1);
        k2(d73.B).setOnClickListener(this);
        TextView textView = (TextView) k2(d73.B1);
        textView.setText(this.z0);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        SpannableString spannableString = new SpannableString(this.A0);
        a aVar = new a();
        int length = this.A0.length();
        spannableString.setSpan(aVar, 0, length, 33);
        spannableString.setSpan(new ForegroundColorSpan(-42888), 0, length, 33);
        textView.append(spannableString);
    }

    public void t2(String str, String str2) {
        this.z0 = str;
        this.A0 = str2;
    }
}
