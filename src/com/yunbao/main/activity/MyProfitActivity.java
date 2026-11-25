package com.yunbao.main.activity;

import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.activity.WebViewActivity;
import com.yunbao.common.http.HttpCallback;
import defpackage.aq4;
import defpackage.b5;
import defpackage.c73;
import defpackage.db2;
import defpackage.j10;
import defpackage.j30;
import defpackage.l30;
import defpackage.lx1;
import defpackage.m93;
import defpackage.rv3;
import defpackage.s4;
import defpackage.t54;
import defpackage.wg1;
import defpackage.y73;

/* loaded from: /tmp/classes2.dex */
public class MyProfitActivity extends AbsActivity implements View.OnClickListener {
    public TextView e;
    public TextView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public TextView j;
    public TextView k;
    public EditText l;
    public double m;
    public double n;
    public long o;
    public View p;
    public View q;
    public ImageView r;
    public TextView s;
    public String t;
    public String u;
    public View v;
    public String w;

    /* loaded from: /tmp/classes2.dex */
    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (charSequence.length() <= 0) {
                MyProfitActivity.this.j.setText(rv3.a(MyProfitActivity.this.w, "0"));
                MyProfitActivity.this.v.setEnabled(false);
                return;
            }
            long parseLong = Long.parseLong(charSequence.toString());
            if (MyProfitActivity.this.m != 0.0d) {
                MyProfitActivity.this.j.setText(rv3.a(MyProfitActivity.this.w, String.format("%.2f", Double.valueOf(((1.0d - MyProfitActivity.this.n) * parseLong) / MyProfitActivity.this.m))));
            }
            MyProfitActivity.this.v.setEnabled(true);
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
            try {
                JSONObject parseObject = JSON.parseObject(strArr[0]);
                MyProfitActivity.this.k.setText(parseObject.getString("cash_desc"));
                MyProfitActivity.this.f.setText(parseObject.getString("votestotal"));
                String string = parseObject.getString("votes");
                MyProfitActivity.this.h.setText(string);
                if (string.contains(".")) {
                    string = string.substring(0, string.indexOf(46));
                }
                MyProfitActivity.this.o = Long.parseLong(string);
                MyProfitActivity.this.m = parseObject.getDoubleValue("cash_rate");
                MyProfitActivity.this.n = parseObject.getDoubleValue("cash_take") / 100.0d;
            } catch (Exception e) {
                lx1.b("提现接口错误------>" + e.getClass() + "------>" + e.getMessage());
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends HttpCallback {
        public c() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i == 0) {
                if (MyProfitActivity.this.l != null) {
                    MyProfitActivity.this.l.setText((CharSequence) null);
                }
                MyProfitActivity.this.R1();
            }
            t54.b(str);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d extends s4 {
        public d() {
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
                if (MyProfitActivity.this.p.getVisibility() == 0) {
                    MyProfitActivity.this.p.setVisibility(4);
                }
                if (MyProfitActivity.this.q.getVisibility() != 0) {
                    MyProfitActivity.this.q.setVisibility(0);
                }
                MyProfitActivity.this.t = stringExtra;
                MyProfitActivity.this.r.setImageResource(l30.a(h));
                MyProfitActivity myProfitActivity = MyProfitActivity.this;
                if (h == 2) {
                    myProfitActivity.s.setText(stringExtra2);
                } else {
                    myProfitActivity.s.setText(rv3.a(stringExtra2, "(", stringExtra4, ")"));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R1() {
        db2.U(new b());
    }

    public final void O1() {
        String trim = this.l.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            t54.b(aq4.b(m93.q9, this.u));
            return;
        }
        if (Long.parseLong(trim) > this.o) {
            t54.a(m93.r9);
        } else if (TextUtils.isEmpty(this.t)) {
            t54.a(m93.p9);
        } else {
            db2.r(trim, this.t, new c());
        }
    }

    public final void P1() {
        WebViewActivity.E1(this.b, wg1.d);
    }

    public final void Q1() {
        Intent intent = new Intent();
        intent.setClassName(j30.y, "com.yunbao.main.activity.CashActivity");
        intent.putExtra("cashAccountID", this.t);
        b5.a(this, intent, new d());
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return y73.K;
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        this.w = aq4.a(m93.O8);
        this.e = (TextView) findViewById(c73.g);
        this.f = (TextView) findViewById(c73.f);
        this.g = (TextView) findViewById(c73.x1);
        this.h = (TextView) findViewById(c73.w1);
        this.i = (TextView) findViewById(c73.m2);
        this.k = (TextView) findViewById(c73.G4);
        this.j = (TextView) findViewById(c73.K3);
        EditText editText = (EditText) findViewById(c73.P1);
        this.l = editText;
        editText.addTextChangedListener(new a());
        String F = j30.q().F();
        this.u = F;
        this.e.setText(aq4.b(m93.s9, F));
        this.g.setText(aq4.b(m93.t9, this.u));
        this.i.setText(aq4.b(m93.u9, this.u));
        View findViewById = findViewById(c73.O);
        this.v = findViewById;
        findViewById.setOnClickListener(this);
        findViewById(c73.U).setOnClickListener(this);
        findViewById(c73.P).setOnClickListener(this);
        this.p = findViewById(c73.z1);
        this.q = findViewById(c73.b);
        this.r = (ImageView) findViewById(c73.c);
        this.s = (TextView) findViewById(c73.a);
        R1();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == c73.O) {
            if (j10.a()) {
                O1();
            }
        } else if (id == c73.U) {
            Q1();
        } else if (id == c73.P) {
            P1();
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        db2.i("doCash");
        db2.i("getProfit");
        super.onDestroy();
    }
}
