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
import com.yunbao.common.http.HttpCallback;
import com.yunbao.main.activity.RegisterNewActivity;

/* loaded from: /tmp/classes2.dex */
public class k82 extends v0 {
    public TextView a;
    public EditText b;
    public EditText c;
    public sl3 d;
    public String e;

    /* loaded from: /tmp/classes2.dex */
    public class a extends k30 {
        public a() {
        }

        @Override // defpackage.k30
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CountryBean countryBean) {
            k82.this.e = countryBean.getTel();
            k82.this.a.setText(countryBean.getName() + "(+" + countryBean.getTel() + ")");
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends HttpCallback {
        public b() {
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
            k82.this.mContext.finish();
        }
    }

    public k82(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
        this.e = "86";
    }

    public static /* synthetic */ void b0(k82 k82Var, View view) {
        k82Var.mContext.startActivity(new Intent(k82Var.mContext, (Class<?>) RegisterNewActivity.class));
        k82Var.mContext.finish();
    }

    @Override // defpackage.v0
    public void getData() {
        String obj = this.b.getText().toString();
        String obj2 = this.c.getText().toString();
        if (this.e.isEmpty()) {
            t54.b("地区不能为空");
            return;
        }
        if (obj.isEmpty()) {
            t54.b("手机号不能为空");
        } else if (obj2.isEmpty()) {
            t54.b("密码不能为空");
        } else {
            db2.h0(obj, obj2, this.e, new b());
        }
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return y73.d0;
    }

    @Override // defpackage.b1
    public void init() {
        this.a = (TextView) findViewById(c73.Q4);
        this.b = (EditText) findViewById(c73.e2);
        this.c = (EditText) findViewById(c73.f2);
        findViewById(c73.t3).setOnClickListener(new View.OnClickListener() { // from class: h82
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r0.d.w2(k82.this.mContext.getSupportFragmentManager(), "mCountryDialog");
            }
        });
        sl3 sl3Var = new sl3();
        this.d = sl3Var;
        sl3Var.v2(new a());
        findViewById(c73.S4).setOnClickListener(new View.OnClickListener() { // from class: i82
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k82.this.getData();
            }
        });
        findViewById(c73.Y4).setOnClickListener(new View.OnClickListener() { // from class: j82
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k82.b0(k82.this, view);
            }
        });
    }
}
