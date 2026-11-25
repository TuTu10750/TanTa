package defpackage;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yunbao.common.bean.LevelBean;
import com.yunbao.common.bean.UserBean;
import com.yunbao.common.http.CommonHttpUtil;
import com.yunbao.common.http.HttpCallback;

/* loaded from: /tmp/classes2.dex */
public class f62 extends l0 implements View.OnClickListener {
    public ImageView A0;
    public TextView B0;
    public TextView C0;
    public ImageView D0;
    public ImageView E0;
    public ImageView F0;
    public ImageView G0;
    public TextView H0;
    public TextView I0;
    public TextView J0;
    public TextView K0;
    public TextView L0;
    public TextView M0;
    public TextView N0;
    public TextView O0;
    public TextView P0;
    public TextView Q0;
    public TextView R0;
    public TextView S0;
    public TextView T0;
    public String U0;
    public String V0;
    public UserBean W0;
    public int X0;
    public int Y0;
    public int Z0;
    public String a1;
    public int b1;
    public m30 c1;
    public m30 d1;
    public k30 e1 = new b();
    public HttpCallback f1 = new g();
    public TextView z0;

    /* loaded from: /tmp/classes2.dex */
    public class a extends HttpCallback {
        public a() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length <= 0) {
                return;
            }
            f62.this.I2(strArr[0]);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends k30 {
        public b() {
        }

        @Override // defpackage.k30
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Integer num) {
            int intValue = num.intValue();
            f62 f62Var = f62.this;
            if (intValue == 1) {
                f62Var.C0.setText("取消关注");
                f62.this.C0.setBackgroundResource(h63.r);
                f62.this.C0.setTextColor(-3618616);
                if (f62.this.U0.equals(f62.this.V0)) {
                    f62.this.c1.a(2, f62.this.V0);
                    return;
                }
                return;
            }
            f62Var.C0.setText("关注+");
            f62.this.C0.setBackgroundResource(h63.q);
            f62.this.C0.setTextColor(-1);
            if (f62.this.U0.equals(f62.this.V0)) {
                f62.this.c1.a(3, f62.this.V0);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends HttpCallback {
        public c() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || f62.this.c1 == null) {
                t54.b(str);
            } else {
                f62.this.c1.a(1, f62.this.V0);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d extends HttpCallback {
        public d() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || f62.this.c1 == null) {
                t54.b(str);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e extends HttpCallback {
        public e() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || f62.this.c1 == null) {
                t54.b(str);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class f extends HttpCallback {
        public f() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length <= 0) {
                return;
            }
            int intValue = JSON.parseObject(strArr[0]).getIntValue("isadmin");
            f62 f62Var = f62.this;
            if (intValue == 1) {
                f62Var.c1.a(4, f62.this.V0);
            } else {
                f62Var.c1.a(5, f62.this.V0);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class g extends HttpCallback {
        public g() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i == 0) {
                f62.this.c1.a(7, f62.this.U0);
            } else {
                t54.b(str);
            }
        }
    }

    private void B2() {
        e32.V(this.V0, this.U0, new a());
    }

    public static /* synthetic */ void r2(f62 f62Var, View view) {
        f62Var.y2();
        f62Var.S1();
    }

    public static /* synthetic */ void s2(f62 f62Var, View view) {
        if (f62Var.b1 == 1) {
            f62Var.E2();
        } else {
            f62Var.H2();
        }
        f62Var.S1();
    }

    private void y2() {
        S1();
        e32.L0(this.U0, "live_" + this.U0, 0, null, this.f1);
    }

    public final void A2() {
        e32.p0(this.U0, this.V0, new c());
    }

    @Override // defpackage.l0
    public void C0() {
        e32.f("getLiveUser");
        super.C0();
    }

    public final void C2() {
        e32.C0(this.U0, this.V0, "live_" + this.U0, new f());
    }

    public final void D2() {
        CommonHttpUtil.setAttention("tag", "live_" + this.U0, this.V0, this.e1);
    }

    public final void E2() {
        e32.D0(this.U0, this.V0, "live_" + this.U0, new e());
    }

    public void F2(m30 m30Var) {
        this.c1 = m30Var;
    }

    public void G2(m30 m30Var) {
        this.d1 = m30Var;
    }

    public final void H2() {
        e32.H0(this.U0, "live_" + this.U0, "0", 1, this.V0, new d());
    }

    public final void I2(String str) {
        JSONObject parseObject = JSON.parseObject(str);
        this.W0 = (UserBean) JSON.toJavaObject(parseObject, UserBean.class);
        j30 q = j30.q();
        this.z0.setText(this.W0.getLiangNameTip());
        String string = parseObject.getString("user_nickname");
        this.a1 = string;
        this.B0.setText(string);
        kn1.g(this.x0, parseObject.getString("avatar"), this.A0);
        this.H0.setText(parseObject.getString(com.umeng.ccg.a.A));
        LevelBean c2 = q.c(parseObject.getIntValue("level_anchor"));
        if (c2 != null) {
            kn1.f(this.x0, c2.getThumb(), this.F0);
        }
        LevelBean s = q.s(parseObject.getIntValue("level"));
        if (s != null) {
            kn1.f(this.x0, s.getThumb(), this.G0);
        }
        this.E0.setImageResource(l30.b(parseObject.getIntValue("sex")));
        int intValue = parseObject.getJSONObject("vip").getIntValue("type");
        ImageView imageView = this.D0;
        if (intValue == 1) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
        this.I0.setText(n52.f(parseObject.getLongValue("follows")));
        this.J0.setText(n52.f(parseObject.getLongValue("fans")));
        this.K0.setText(n52.f(parseObject.getLongValue("consumption")));
        this.L0.setText(n52.f(parseObject.getLongValue("votestotal")));
        int intValue2 = parseObject.getIntValue("isattention");
        this.Z0 = intValue2;
        TextView textView = this.C0;
        if (intValue2 == 1) {
            textView.setText("取消关注");
            this.C0.setBackgroundResource(h63.r);
            this.C0.setTextColor(-3618616);
        } else {
            textView.setText("关注+");
            this.C0.setBackgroundResource(h63.q);
            this.C0.setTextColor(-1);
        }
        int intValue3 = parseObject.getIntValue(com.umeng.ccg.a.z);
        int intValue4 = parseObject.getIntValue("isshut");
        this.b1 = intValue4;
        this.R0.setText(intValue4 == 1 ? "解除禁言" : "禁言");
        if (!this.U0.equals(j30.q().C()) || this.V0.equals(this.U0)) {
            if (this.X0 == 1) {
                this.S0.setVisibility(0);
            }
            if (this.Y0 == 40 && !this.U0.equals(this.V0)) {
                this.Q0.setVisibility(0);
                this.R0.setVisibility(0);
            }
            if (this.X0 == 1 && this.Y0 == 40 && !this.U0.equals(this.V0) && !this.V0.equals(j30.q().C())) {
                this.S0.setVisibility(8);
                this.T0.setText("关播直播");
                this.T0.setVisibility(0);
                this.T0.setOnClickListener(new View.OnClickListener() { // from class: e62
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        f62.r2(f62.this, view);
                    }
                });
            }
        } else {
            this.N0.setVisibility(0);
            this.Q0.setVisibility(0);
            this.T0.setText(this.b1 == 1 ? "解除禁言" : "禁言");
            this.T0.setVisibility(0);
            this.T0.setOnClickListener(new View.OnClickListener() { // from class: d62
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    f62.s2(f62.this, view);
                }
            });
            TextView textView2 = this.N0;
            if (intValue3 == 502) {
                textView2.setText("取消管理");
            } else {
                textView2.setText("设为管理");
            }
        }
        if (this.V0.equals(j30.q().C())) {
            this.P0.setVisibility(8);
            this.O0.setVisibility(8);
            this.S0.setVisibility(8);
            this.Q0.setVisibility(8);
            this.R0.setVisibility(8);
            this.N0.setVisibility(8);
        }
    }

    @Override // defpackage.l0
    public boolean f2() {
        return true;
    }

    @Override // defpackage.l0
    public int l2() {
        return s93.d;
    }

    @Override // defpackage.l0
    public int m2() {
        return x73.d0;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == b73.y5) {
            D2();
        } else if (id == b73.s5) {
            z2();
        } else if (id == b73.O5) {
            C2();
        } else if (id == b73.o5) {
            this.c1.a(6, this.a1);
        } else if (id == b73.p5) {
            this.d1.a(this.Z0, this.W0);
        } else if (id == b73.G5) {
            A2();
        } else if (id == b73.D5) {
            if (this.b1 == 1) {
                E2();
            } else {
                H2();
            }
        } else if (id == b73.t5) {
            y2();
        }
        S1();
    }

    @Override // defpackage.l0
    public void p2(Window window) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        window.setWindowAnimations(s93.b);
        attributes.width = -1;
        attributes.height = -2;
        attributes.gravity = 80;
        window.setAttributes(attributes);
    }

    public void r0(Bundle bundle) {
        super.r0(bundle);
        Bundle z = z();
        if (z == null) {
            return;
        }
        this.U0 = z.getString("liveUid");
        this.V0 = z.getString("toUid");
        this.X0 = z.getInt("isSupper");
        this.Y0 = z.getInt("userType");
        if (TextUtils.isEmpty(this.U0) || TextUtils.isEmpty(this.V0)) {
            return;
        }
        this.A0 = (ImageView) this.y0.findViewById(b73.d);
        this.z0 = (TextView) this.y0.findViewById(b73.Y5);
        this.B0 = (TextView) this.y0.findViewById(b73.C5);
        this.C0 = (TextView) this.y0.findViewById(b73.y5);
        this.D0 = (ImageView) this.y0.findViewById(b73.q3);
        this.E0 = (ImageView) this.y0.findViewById(b73.p3);
        this.F0 = (ImageView) this.y0.findViewById(b73.o3);
        this.G0 = (ImageView) this.y0.findViewById(b73.n3);
        this.H0 = (TextView) this.y0.findViewById(b73.P5);
        this.I0 = (TextView) this.y0.findViewById(b73.x5);
        this.J0 = (TextView) this.y0.findViewById(b73.w5);
        this.K0 = (TextView) this.y0.findViewById(b73.N5);
        this.L0 = (TextView) this.y0.findViewById(b73.K5);
        this.M0 = (TextView) this.y0.findViewById(b73.s5);
        this.N0 = (TextView) this.y0.findViewById(b73.O5);
        this.O0 = (TextView) this.y0.findViewById(b73.o5);
        this.P0 = (TextView) this.y0.findViewById(b73.p5);
        this.Q0 = (TextView) this.y0.findViewById(b73.G5);
        this.R0 = (TextView) this.y0.findViewById(b73.D5);
        this.T0 = (TextView) this.y0.findViewById(b73.Q5);
        this.S0 = (TextView) this.y0.findViewById(b73.t5);
        this.C0.setOnClickListener(this);
        this.M0.setOnClickListener(this);
        this.N0.setOnClickListener(this);
        this.O0.setOnClickListener(this);
        this.P0.setOnClickListener(this);
        this.Q0.setOnClickListener(this);
        this.R0.setOnClickListener(this);
        this.S0.setOnClickListener(this);
        this.O0.setText("@TA");
        if (this.V0.equals(j30.q().C())) {
            this.C0.setVisibility(8);
        }
        B2();
    }

    public final void z2() {
        S1();
        pi3.r(this.x0, this.V0, true, this.U0);
    }
}
