package defpackage;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.umeng.analytics.pro.cl;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.live.activity.LiveActivity;
import com.yunbao.live.bean.RedPackBean;

/* loaded from: /tmp/classes2.dex */
public class x42 extends l0 implements View.OnClickListener, lc3 {
    public View A0;
    public View B0;
    public View C0;
    public View D0;
    public ImageView E0;
    public TextView F0;
    public TextView G0;
    public TextView H0;
    public RedPackBean I0;
    public String J0;
    public TextView K0;
    public TextView L0;
    public TextView M0;
    public String N0;
    public TextView O0;
    public kc3 P0;
    public b Q0;
    public boolean R0;
    public StringBuilder S0;
    public View z0;

    /* loaded from: /tmp/classes2.dex */
    public class a extends HttpCallback {
        public a() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length <= 0) {
                return;
            }
            JSONObject parseObject = JSON.parseObject(strArr[0]);
            int intValue = parseObject.getIntValue("win");
            x42 x42Var = x42.this;
            if (intValue > 0) {
                x42Var.w2(String.valueOf(intValue));
            } else {
                x42Var.v2(parseObject.getString(cl.h));
            }
            if (x42.this.I0 != null) {
                x42.this.I0.setIsRob(0);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface b {
        void a(boolean z);

        void hide();
    }

    public void A2(kc3 kc3Var) {
        this.P0 = kc3Var;
    }

    public void B2(RedPackBean redPackBean) {
        this.I0 = redPackBean;
    }

    @Override // defpackage.l0
    public void C0() {
        b bVar = this.Q0;
        if (bVar != null) {
            bVar.a(this.R0);
        }
        this.Q0 = null;
        kc3 kc3Var = this.P0;
        if (kc3Var != null) {
            kc3Var.c0(null);
        }
        this.P0 = null;
        e32.f("robRedPack");
        super.C0();
    }

    public void C2(String str) {
        this.J0 = str;
    }

    public final void D2() {
        View view = this.A0;
        if (view == null || view.getVisibility() == 0) {
            return;
        }
        this.A0.setVisibility(0);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 2.0f, 1.0f, 2.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(500L);
        scaleAnimation.setRepeatCount(-1);
        scaleAnimation.setRepeatMode(2);
    }

    @Override // defpackage.l0
    public boolean f2() {
        return true;
    }

    @Override // defpackage.lc3
    public void h(int i) {
        View view = this.D0;
        if (i == 0) {
            if (view != null && view.getVisibility() == 0) {
                this.D0.setVisibility(4);
            }
            D2();
            return;
        }
        if (view != null && view.getVisibility() != 0) {
            this.D0.setVisibility(0);
        }
        if (this.O0 != null) {
            if (this.S0 == null) {
                this.S0 = new StringBuilder();
            }
            this.O0.setText(rv3.e(i, this.S0));
        }
    }

    @Override // defpackage.lc3
    public int i() {
        RedPackBean redPackBean = this.I0;
        if (redPackBean != null) {
            return redPackBean.getId();
        }
        return 0;
    }

    @Override // defpackage.l0
    public int l2() {
        return s93.d;
    }

    @Override // defpackage.l0
    public int m2() {
        return x73.V;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == b73.R0) {
            x2();
        } else if (id == b73.R || id == b73.S) {
            u2();
        }
    }

    @Override // defpackage.l0
    public void p2(Window window) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = zn0.a(300);
        attributes.height = zn0.a(390);
        attributes.gravity = 17;
        window.setAttributes(attributes);
    }

    public void r0(Bundle bundle) {
        super.r0(bundle);
        if (this.I0 == null || TextUtils.isEmpty(this.J0)) {
            return;
        }
        this.z0 = this.y0.findViewById(b73.J4);
        this.A0 = this.y0.findViewById(b73.K4);
        this.C0 = this.y0.findViewById(b73.G4);
        this.B0 = this.y0.findViewById(b73.o6);
        this.D0 = this.y0.findViewById(b73.k6);
        this.E0 = (ImageView) this.y0.findViewById(b73.d);
        this.F0 = (TextView) this.y0.findViewById(b73.X3);
        this.G0 = (TextView) this.y0.findViewById(b73.i5);
        this.H0 = (TextView) this.y0.findViewById(b73.j5);
        this.K0 = (TextView) this.y0.findViewById(b73.U3);
        this.L0 = (TextView) this.y0.findViewById(b73.p6);
        this.M0 = (TextView) this.y0.findViewById(b73.n6);
        this.O0 = (TextView) this.y0.findViewById(b73.E1);
        this.y0.findViewById(b73.R0).setOnClickListener(this);
        this.y0.findViewById(b73.R).setOnClickListener(this);
        this.y0.findViewById(b73.S).setOnClickListener(this);
        kn1.g(this.x0, this.I0.getAvatar(), this.E0);
        this.F0.setText(this.I0.getUserNiceName());
        this.G0.setText(this.I0.getTitle());
        this.H0.setText(this.I0.getTitle());
        if (this.I0.getSendType() != 1 || this.I0.getRobTime() == 0) {
            D2();
            return;
        }
        this.D0.setVisibility(0);
        if (this.O0 != null) {
            if (this.S0 == null) {
                this.S0 = new StringBuilder();
            }
            this.O0.setText(rv3.e(this.I0.getRobTime(), this.S0));
        }
        kc3 kc3Var = this.P0;
        if (kc3Var != null) {
            kc3Var.c0(this);
        }
    }

    public final void u2() {
        w42 w42Var = new w42();
        w42Var.E2(this.J0);
        w42Var.D2(this.I0);
        w42Var.C2(this.N0);
        this.R0 = true;
        S1();
        w42Var.d2(((LiveActivity) this.x0).getSupportFragmentManager(), "LiveRedPackResultDialogFragment");
    }

    public final void v2(String str) {
        View view = this.A0;
        if (view != null && view.getVisibility() == 0) {
            this.A0.setVisibility(4);
        }
        View view2 = this.C0;
        if (view2 != null && view2.getVisibility() != 0) {
            this.C0.setVisibility(0);
        }
        TextView textView = this.K0;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public final void w2(String str) {
        b bVar = this.Q0;
        if (bVar != null) {
            bVar.hide();
        }
        View view = this.z0;
        if (view != null && view.getVisibility() == 0) {
            this.z0.setVisibility(4);
        }
        View view2 = this.B0;
        if (view2 != null && view2.getVisibility() != 0) {
            this.B0.setVisibility(0);
        }
        TextView textView = this.M0;
        if (textView != null) {
            textView.setText(str);
        }
        TextView textView2 = this.L0;
        if (textView2 != null) {
            textView2.setText(aq4.b(m93.A9, this.I0.getUserNiceName(), this.N0));
        }
    }

    public final void x2() {
        RedPackBean redPackBean = this.I0;
        if (redPackBean == null) {
            return;
        }
        kc3 kc3Var = this.P0;
        if (kc3Var != null) {
            kc3Var.W(redPackBean.getId());
        }
        e32.v0(this.J0, this.I0.getId(), new a());
    }

    public void y2(b bVar) {
        this.Q0 = bVar;
    }

    public void z2(String str) {
        this.N0 = str;
    }
}
