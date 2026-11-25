package com.yunbao.mall.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.http.HttpCallback;
import defpackage.aq4;
import defpackage.b5;
import defpackage.d73;
import defpackage.ec2;
import defpackage.j30;
import defpackage.l30;
import defpackage.m93;
import defpackage.rv3;
import defpackage.s4;
import defpackage.t54;
import defpackage.z73;

/* loaded from: /tmp/classes2.dex */
public class SellerCashActivity extends AbsActivity implements View.OnClickListener {
    public String e;
    public TextView f;
    public TextView g;
    public EditText h;
    public View i;
    public View j;
    public ImageView k;
    public TextView l;

    /* loaded from: /tmp/classes2.dex */
    public class a extends HttpCallback {
        public a() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i == 0) {
                SellerCashActivity.this.setResult(-1);
                SellerCashActivity.this.finish();
            }
            t54.b(str);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends s4 {
        public b() {
        }

        @Override // defpackage.s4
        public void c(Intent intent) {
            if (intent != null) {
                String stringExtra = intent.getStringExtra("cashAccountID");
                String stringExtra2 = intent.getStringExtra("cashAccount");
                String stringExtra3 = intent.getStringExtra("cashAccountType");
                String stringExtra4 = intent.getStringExtra("cashAccountName");
                int h = !TextUtils.isEmpty(stringExtra3) ? rv3.h(stringExtra3, 0) : 0;
                if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2)) {
                    return;
                }
                if (SellerCashActivity.this.i.getVisibility() == 0) {
                    SellerCashActivity.this.i.setVisibility(4);
                }
                if (SellerCashActivity.this.j.getVisibility() != 0) {
                    SellerCashActivity.this.j.setVisibility(0);
                }
                SellerCashActivity.this.e = stringExtra;
                SellerCashActivity.this.k.setImageResource(l30.a(h));
                SellerCashActivity sellerCashActivity = SellerCashActivity.this;
                if (h == 2) {
                    sellerCashActivity.l.setText(stringExtra2);
                } else {
                    sellerCashActivity.l.setText(rv3.a(stringExtra2, "(", stringExtra4, ")"));
                }
            }
        }
    }

    private void B1() {
        Intent intent = new Intent();
        intent.setClassName(j30.y, "com.yunbao.main.activity.CashActivity");
        intent.putExtra("cashAccountID", this.e);
        b5.a(this, intent, new b());
    }

    public static void C1(Context context, String str, String str2) {
        Intent intent = new Intent(context, (Class<?>) SellerCashActivity.class);
        intent.putExtra("mallCashBalance", str);
        intent.putExtra("mallCashTotal", str2);
        ((Activity) context).startActivityForResult(intent, 0);
    }

    private CharSequence D1(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (!str.contains(".")) {
            str = str.concat(".00");
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(16, true), str.indexOf("."), spannableStringBuilder.length(), 33);
        return spannableStringBuilder;
    }

    private void E1() {
        if (TextUtils.isEmpty(this.e)) {
            t54.a(m93.p9);
            return;
        }
        String trim = this.h.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            t54.a(m93.x7);
        } else {
            ec2.n0(this.e, trim, new a());
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return z73.M;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.w7));
        this.f = (TextView) findViewById(d73.n4);
        this.g = (TextView) findViewById(d73.m);
        this.h = (EditText) findViewById(d73.P2);
        this.i = findViewById(d73.z1);
        this.j = findViewById(d73.a);
        this.k = (ImageView) findViewById(d73.b);
        this.l = (TextView) findViewById(d73.c);
        findViewById(d73.T).setOnClickListener(this);
        findViewById(d73.n1).setOnClickListener(this);
        String stringExtra = getIntent().getStringExtra("mallCashTotal");
        String stringExtra2 = getIntent().getStringExtra("mallCashBalance");
        this.f.setText(D1(stringExtra));
        this.g.setText(D1(stringExtra2));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == d73.T) {
            B1();
        } else if (id == d73.n1) {
            E1();
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        ec2.u("goodsCash");
        super.onDestroy();
    }
}
