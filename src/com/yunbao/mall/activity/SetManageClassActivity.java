package com.yunbao.mall.activity;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.umeng.analytics.pro.cl;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.mall.bean.ManageClassBean;
import defpackage.aq4;
import defpackage.d73;
import defpackage.ec2;
import defpackage.m93;
import defpackage.t54;
import defpackage.z73;
import defpackage.zn3;
import java.util.Arrays;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class SetManageClassActivity extends AbsActivity implements zn3.b, View.OnClickListener {
    public View e;
    public View f;
    public RecyclerView g;
    public zn3 h;
    public TextView i;

    /* loaded from: /tmp/classes2.dex */
    public class a extends ClickableSpan {
        public a() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (SetManageClassActivity.this.f != null) {
                SetManageClassActivity.this.f.setVisibility(4);
            }
            SetManageClassActivity.this.E1();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(-13395474);
            textPaint.setUnderlineText(false);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends HttpCallback {
        public b() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length <= 0) {
                return;
            }
            int intValue = JSON.parseObject(strArr[0]).getIntValue(cl.i);
            if (intValue == 1) {
                SetManageClassActivity.this.E1();
                return;
            }
            SetManageClassActivity setManageClassActivity = SetManageClassActivity.this;
            if (intValue == 0) {
                if (setManageClassActivity.e != null) {
                    SetManageClassActivity.this.e.setVisibility(0);
                }
            } else if (setManageClassActivity.f != null) {
                SetManageClassActivity.this.f.setVisibility(0);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends HttpCallback {
        public c() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || SetManageClassActivity.this.g == null) {
                return;
            }
            List parseArray = JSON.parseArray(Arrays.toString(strArr), ManageClassBean.class);
            SetManageClassActivity setManageClassActivity = SetManageClassActivity.this;
            setManageClassActivity.h = new zn3(setManageClassActivity.b, parseArray);
            SetManageClassActivity.this.h.b0(SetManageClassActivity.this);
            SetManageClassActivity.this.g.setAdapter(SetManageClassActivity.this.h);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d extends HttpCallback {
        public d() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i == 0) {
                SetManageClassActivity.this.finish();
            }
            t54.b(str);
        }
    }

    public static void D1(Context context) {
        context.startActivity(new Intent(context, (Class<?>) SetManageClassActivity.class));
    }

    public final void E1() {
        ec2.A(new c());
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return z73.T;
    }

    @Override // zn3.b
    public void k(int i) {
        TextView textView = this.i;
        if (textView != null) {
            textView.setEnabled(i > 0);
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.v8));
        this.e = findViewById(d73.j2);
        this.f = findViewById(d73.k2);
        TextView textView = (TextView) findViewById(d73.i4);
        TextView textView2 = (TextView) findViewById(d73.n1);
        this.i = textView2;
        textView2.setOnClickListener(this);
        String a2 = aq4.a(m93.t8);
        String a3 = aq4.a(m93.u8);
        SpannableString spannableString = new SpannableString(a2);
        int indexOf = a2.indexOf(a3);
        if (indexOf >= 0) {
            spannableString.setSpan(new a(), indexOf, a3.length() + indexOf, 33);
        }
        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setHighlightColor(0);
        RecyclerView findViewById = findViewById(d73.u3);
        this.g = findViewById;
        findViewById.setHasFixedSize(true);
        this.g.setLayoutManager(new LinearLayoutManager(this.b, 1, false));
        ec2.v(new b());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        zn3 zn3Var = this.h;
        if (zn3Var == null) {
            return;
        }
        String a0 = zn3Var.a0();
        if (TextUtils.isEmpty(a0)) {
            return;
        }
        ec2.a(a0, new d());
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        ec2.u("checkApplyBusinessCategory");
        ec2.u("getBusinessCategory");
        ec2.u("applyBusinessCategory");
        super.onDestroy();
    }
}
