package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yunbao.common.bean.CountryBean;
import com.yunbao.common.bean.UserBean;
import com.yunbao.common.http.CommonHttpUtil;
import com.yunbao.common.http.HttpCallback;
import defpackage.uo2;

/* loaded from: /tmp/classes2.dex */
public class ji extends v0 implements View.OnClickListener {
    public LinearLayout a;
    public TextView b;
    public EditText c;
    public EditText d;
    public TextView e;
    public LinearLayout f;
    public TextView g;
    public TextView h;
    public sl3 i;
    public String j;
    public String k;
    public String l;
    public uo2 m;

    /* loaded from: /tmp/classes2.dex */
    public class a extends k30 {
        public a() {
        }

        @Override // defpackage.k30
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CountryBean countryBean) {
            ji.this.j = countryBean.getTel();
            ji.this.b.setText(countryBean.getName() + "(+" + countryBean.getTel() + ")");
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends HttpCallback {
        public b() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0) {
                t54.b(str);
            } else {
                t54.b("验证码已经发送");
                ji.this.o0();
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends HttpCallback {

        /* loaded from: /tmp/classes2.dex */
        public class a extends k30 {
            public a() {
            }

            @Override // defpackage.k30
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(UserBean userBean) {
            }
        }

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
            t54.b("绑定成功");
            j30.q().D().setCountryCode(ji.this.j);
            j30.q().D().setUserLogin(ji.this.k);
            ji.this.g.setText("+" + ji.this.j);
            ji.this.h.setText(ji.this.k);
            ji.this.a.setVisibility(8);
            ji.this.f.setVisibility(0);
            zu0.c().j(new ii());
            db2.E(new a());
            if (ji.this.m != null) {
                ji.this.m.k();
            }
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
            ji.this.e.setText("下次获取" + i);
        }

        @Override // uo2.c
        public void c() {
            ji.this.e.setEnabled(true);
            ji.this.e.setBackground(o60.d(ji.this.mContext, i63.k));
            ji.this.e.setTextColor(-1);
            ji.this.e.setText("发送验证码");
        }
    }

    public ji(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
        this.j = "86";
        this.k = "";
        this.l = "";
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return y73.b1;
    }

    @Override // defpackage.b1
    public void init() {
        this.a = (LinearLayout) findViewById(c73.t2);
        this.b = (TextView) findViewById(c73.Q4);
        this.c = (EditText) findViewById(c73.e2);
        this.d = (EditText) findViewById(c73.c2);
        this.e = (TextView) findViewById(c73.e5);
        this.f = (LinearLayout) findViewById(c73.C3);
        this.g = (TextView) findViewById(c73.M4);
        this.h = (TextView) findViewById(c73.N4);
        this.e.setOnClickListener(this);
        findViewById(c73.L4).setOnClickListener(this);
        findViewById(c73.t3).setOnClickListener(this);
        sl3 sl3Var = new sl3();
        this.i = sl3Var;
        sl3Var.v2(new a());
        UserBean D = j30.q().D();
        if (D.getUserLogin() == null || D.getUserLogin().isEmpty()) {
            this.a.setVisibility(0);
            this.f.setVisibility(8);
            return;
        }
        this.a.setVisibility(8);
        this.f.setVisibility(0);
        this.g.setText("+" + D.getCountryCode());
        this.h.setText(D.getUserLogin());
    }

    public final void n0() {
        this.k = this.c.getText().toString();
        this.l = this.d.getText().toString();
        if (this.j.isEmpty()) {
            t54.b("地区不能为空");
            return;
        }
        if (this.k.isEmpty()) {
            t54.b("手机号不能为空");
        } else if (this.l.isEmpty()) {
            t54.b("验证码不能为空");
        } else {
            CommonHttpUtil.bindLogin(this.k, this.l, this.j, new c());
        }
    }

    public final void o0() {
        if (this.m == null) {
            uo2 uo2Var = new uo2();
            this.m = uo2Var;
            uo2Var.l(new d());
        }
        this.m.m(60).n();
        this.e.setEnabled(false);
        this.e.setBackground(o60.d(this.mContext, i63.j));
        this.e.setTextColor(o60.b(this.mContext, p53.m));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == c73.L4) {
            n0();
        } else if (view.getId() == c73.e5) {
            p0();
        } else if (view.getId() == c73.t3) {
            this.i.w2(this.mContext.getSupportFragmentManager(), "mCountryDialog");
        }
    }

    @Override // defpackage.b1, defpackage.uy1
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // defpackage.b1, defpackage.uy1
    public void onResume() {
        super.onResume();
    }

    public void p0() {
        this.k = this.c.getText().toString();
        if (this.j.isEmpty()) {
            t54.b("地区不能为空");
        } else if (this.k.isEmpty()) {
            t54.b("手机号不能为空");
        } else {
            CommonHttpUtil.getBindCode(this.k, this.j, new b());
        }
    }
}
