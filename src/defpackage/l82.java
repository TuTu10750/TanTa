package defpackage;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yunbao.common.bean.CountryBean;
import com.yunbao.common.http.CommonHttpUtil;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.main.activity.RegisterNewActivity;
import defpackage.uo2;

/* loaded from: /tmp/classes2.dex */
public class l82 extends v0 implements View.OnClickListener {
    public TextView a;
    public EditText b;
    public EditText c;
    public TextView d;
    public sl3 e;
    public String f;
    public String g;
    public String h;
    public uo2 i;

    /* loaded from: /tmp/classes2.dex */
    public class a extends k30 {
        public a() {
        }

        @Override // defpackage.k30
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CountryBean countryBean) {
            l82.this.f = countryBean.getTel();
            l82.this.a.setText(countryBean.getName() + "(+" + countryBean.getTel() + ")");
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends HttpCallback {
        public b() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            t54.b(str);
            if (i == 0) {
                l82.this.h0();
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends HttpCallback {
        public c() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length <= 0) {
                t54.b(str);
                return;
            }
            JSONObject parseObject = JSON.parseObject(strArr[0]);
            j30.q().Z(parseObject.getString("uid"), parseObject.getString("token"), false);
            t54.b("登录成功");
            l82.this.mContext.finish();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d implements uo2.b {
        public d() {
        }

        @Override // uo2.c
        public void a(String str) {
        }

        @Override // uo2.b
        public void b(int i) {
            l82.this.d.setText("下次获取" + i);
        }

        @Override // uo2.c
        public void c() {
            l82.this.d.setEnabled(true);
            l82.this.d.setBackground(o60.d(l82.this.mContext, i63.k));
            l82.this.d.setTextColor(-1);
            l82.this.d.setText("发送验证码");
        }
    }

    public l82(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
        this.f = "86";
        this.g = "";
        this.h = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h0() {
        if (this.i == null) {
            uo2 uo2Var = new uo2();
            this.i = uo2Var;
            uo2Var.l(new d());
        }
        this.i.m(60).n();
        this.d.setEnabled(false);
        this.d.setBackground(o60.d(this.mContext, i63.j));
        this.d.setTextColor(o60.b(this.mContext, p53.m));
    }

    @Override // defpackage.v0
    public void getData() {
        this.g = this.b.getText().toString();
        this.h = this.c.getText().toString();
        if (this.f.isEmpty()) {
            t54.b("地区不能为空");
            return;
        }
        if (this.g.isEmpty()) {
            t54.b("手机号不能为空");
        } else if (this.h.isEmpty()) {
            t54.b("验证码不能为空");
        } else {
            db2.g0(this.g, this.h, this.f, new c());
        }
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return y73.e0;
    }

    public void i0() {
        this.g = this.b.getText().toString();
        if (this.f.isEmpty()) {
            t54.b("地区不能为空");
        } else if (this.g.isEmpty()) {
            t54.b("手机号不能为空");
        } else {
            CommonHttpUtil.getBindCode(this.g, this.f, new b());
        }
    }

    @Override // defpackage.b1
    public void init() {
        this.a = (TextView) findViewById(c73.Q4);
        this.b = (EditText) findViewById(c73.e2);
        this.c = (EditText) findViewById(c73.c2);
        TextView textView = (TextView) findViewById(c73.e5);
        this.d = textView;
        textView.setOnClickListener(this);
        findViewById(c73.t3).setOnClickListener(this);
        sl3 sl3Var = new sl3();
        this.e = sl3Var;
        sl3Var.v2(new a());
        findViewById(c73.S4).setOnClickListener(this);
        findViewById(c73.Y4).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == c73.e5) {
            i0();
            return;
        }
        if (view.getId() == c73.t3) {
            this.e.w2(this.mContext.getSupportFragmentManager(), "mCountryDialog");
            return;
        }
        if (view.getId() == c73.S4) {
            getData();
        } else if (view.getId() == c73.Y4) {
            this.mContext.startActivity(new Intent(this.mContext, (Class<?>) RegisterNewActivity.class));
            this.mContext.finish();
        }
    }

    @Override // defpackage.b1, defpackage.uy1
    public void onDestroy() {
        super.onDestroy();
        uo2 uo2Var = this.i;
        if (uo2Var != null) {
            uo2Var.k();
        }
    }
}
