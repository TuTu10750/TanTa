package defpackage;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yunbao.common.http.HttpCallback;

/* loaded from: /tmp/classes2.dex */
public class jc1 extends l0 implements View.OnClickListener {
    public TextView A0;
    public String B0;
    public String C0;
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
            JSONObject parseObject = JSON.parseObject(strArr[0]);
            if (jc1.this.z0 != null) {
                jc1.this.z0.setText(aq4.b(m93.I3, parseObject.getString("level")));
            }
            if (jc1.this.A0 != null) {
                jc1.this.A0.setText(parseObject.getString("total"));
            }
        }
    }

    @Override // defpackage.l0
    public void C0() {
        e32.f("getLiveGiftPrizePool");
        super.C0();
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
        return x73.D;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        S1();
    }

    @Override // defpackage.l0
    public void p2(Window window) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = zn0.a(280);
        attributes.height = zn0.a(240);
        attributes.y = -zn0.a(70);
        attributes.gravity = 17;
        window.setAttributes(attributes);
    }

    public void r0(Bundle bundle) {
        super.r0(bundle);
        this.z0 = (TextView) k2(b73.z3);
        this.A0 = (TextView) k2(b73.s1);
        k2(b73.H).setOnClickListener(this);
        e32.P(this.B0, this.C0, new a());
    }

    public void t2(String str) {
        this.B0 = str;
    }

    public void u2(String str) {
        this.C0 = str;
    }
}
