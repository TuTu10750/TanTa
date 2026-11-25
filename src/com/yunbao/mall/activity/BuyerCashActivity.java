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
public class BuyerCashActivity extends AbsActivity implements View.OnClickListener {
    public String e;
    public TextView f;
    public EditText g;
    public View h;
    public View i;
    public ImageView j;
    public TextView k;

    /* loaded from: /tmp/classes2.dex */
    public class a extends HttpCallback {
        public a() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i == 0) {
                BuyerCashActivity.this.setResult(-1);
                BuyerCashActivity.this.finish();
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
                if (BuyerCashActivity.this.h.getVisibility() == 0) {
                    BuyerCashActivity.this.h.setVisibility(4);
                }
                if (BuyerCashActivity.this.i.getVisibility() != 0) {
                    BuyerCashActivity.this.i.setVisibility(0);
                }
                BuyerCashActivity.this.e = stringExtra;
                BuyerCashActivity.this.j.setImageResource(l30.a(h));
                BuyerCashActivity buyerCashActivity = BuyerCashActivity.this;
                if (h == 2) {
                    buyerCashActivity.k.setText(stringExtra2);
                } else {
                    buyerCashActivity.k.setText(rv3.a(stringExtra2, "(", stringExtra4, ")"));
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

    public static void C1(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) BuyerCashActivity.class);
        intent.putExtra("mallCashBalance", str);
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
        String trim = this.g.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            t54.a(m93.x7);
        } else {
            ec2.n0(this.e, trim, new a());
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return z73.e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.u7));
        this.f = (TextView) findViewById(d73.m);
        this.g = (EditText) findViewById(d73.P2);
        this.h = findViewById(d73.z1);
        this.i = findViewById(d73.a);
        this.j = (ImageView) findViewById(d73.b);
        this.k = (TextView) findViewById(d73.c);
        findViewById(d73.T).setOnClickListener(this);
        findViewById(d73.n1).setOnClickListener(this);
        this.f.setText(D1(getIntent().getStringExtra("mallCashBalance")));
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
