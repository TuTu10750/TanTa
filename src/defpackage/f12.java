package defpackage;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.netshield.Netshield;
import com.yunbao.common.bean.CoinPayBean2;
import com.yunbao.common.http.CommonHttpConsts;
import com.yunbao.common.http.CommonHttpUtil;
import defpackage.g12;
import java.util.HashMap;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: /tmp/classes2.dex */
public class f12 extends l0 implements View.OnClickListener, et2, g12.b {
    public TextView A0;
    public List B0;
    public ny C0;
    public CoinPayBean2.ChargeConfigBean D0;
    public kx2 E0;
    public boolean F0;
    public CoinPayBean2 G0;
    public RecyclerView z0;

    private void r2() {
        n(this.G0);
    }

    @Override // defpackage.l0
    public void C0() {
        zu0.c().p(this);
        CommonHttpUtil.cancel(CommonHttpConsts.GET_BALANCE);
        this.E0 = null;
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
        return u73.g;
    }

    @Override // g12.b
    public void n(CoinPayBean2 coinPayBean2) {
        if (this.E0 != null && this.D0 != null) {
            String href = coinPayBean2.getHref();
            if (TextUtils.isEmpty(href)) {
                String money = this.D0.getMoney();
                "paypal".equals(coinPayBean2.getId());
                String money2 = this.D0.getMoney();
                String a = rv3.a(money2, j30.q().g());
                HashMap hashMap = new HashMap();
                hashMap.put("uid", j30.q().C());
                hashMap.put("token", j30.q().B());
                hashMap.put("money", money);
                hashMap.put("changeid", this.D0.getId() + "");
                hashMap.put("coin", money2);
                this.E0.b(coinPayBean2.getId(), money, a, hashMap);
            } else {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                String str = href + "?uid=" + j30.q().C() + "&changeid=" + this.D0.getId() + "&payid=" + coinPayBean2.getId() + "&token=" + j30.q().B();
                System.out.println("url-----".concat(str));
                if (str.contains("com/")) {
                    String[] split = str.split("com/");
                    str = "http://127.0.0.1:" + Netshield.getLocalhostPort(j30.G()) + "/" + split[1];
                }
                intent.setData(Uri.parse(str));
                this.x0.startActivity(intent);
            }
        }
        S1();
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onChargeTypeEvent(hy hyVar) {
        ny nyVar;
        CoinPayBean2.ChargeConfigBean T;
        boolean equals = "paypal".equals(hyVar.a());
        if (this.F0 != equals && (nyVar = this.C0) != null && (T = nyVar.T()) != null && this.A0 != null) {
            this.A0.setText(aq4.b(m93.j1, rv3.a(equals ? "$" : "￥", T.getMoney())));
        }
        this.F0 = equals;
        ny nyVar2 = this.C0;
        if (nyVar2 != null) {
            nyVar2.X(equals);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == y63.i) {
            S1();
        } else if (id == y63.h) {
            r2();
        }
    }

    @Override // defpackage.l0
    public void p2(Window window) {
        window.setWindowAnimations(s93.b);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        attributes.gravity = 80;
        window.setAttributes(attributes);
    }

    public void r0(Bundle bundle) {
        super.r0(bundle);
        RecyclerView k2 = k2(y63.Z);
        this.z0 = k2;
        k2.setHasFixedSize(true);
        this.z0.setLayoutManager(new GridLayoutManager(this.x0, 3, 1, false));
        rq1 rq1Var = new rq1(this.x0, 0, 5.0f, 10.0f);
        rq1Var.l(true);
        this.z0.k(rq1Var);
        TextView textView = (TextView) k2(y63.h);
        this.A0 = textView;
        textView.setOnClickListener(this);
        k2(y63.i).setOnClickListener(this);
        zu0.c().n(this);
        List list = this.B0;
        if (list == null || list.size() <= 0) {
            return;
        }
        CoinPayBean2.ChargeConfigBean chargeConfigBean = (CoinPayBean2.ChargeConfigBean) this.B0.get(0);
        chargeConfigBean.setChecked(true);
        ny nyVar = new ny(this.x0, this.B0);
        this.C0 = nyVar;
        nyVar.Y(this);
        this.z0.setAdapter(this.C0);
        this.C0.X(this.F0);
        v2(chargeConfigBean);
    }

    @Override // defpackage.et2
    /* renamed from: s2, reason: merged with bridge method [inline-methods] */
    public void onItemClick(CoinPayBean2.ChargeConfigBean chargeConfigBean, int i) {
        v2(chargeConfigBean);
    }

    public void t2(CoinPayBean2 coinPayBean2) {
        this.G0 = coinPayBean2;
        List<CoinPayBean2.ChargeConfigBean> charge_config = coinPayBean2.getCharge_config();
        int size = charge_config.size();
        int i = 0;
        while (i < size) {
            charge_config.get(i).setChecked(i == 0);
            i++;
        }
        this.B0 = charge_config;
    }

    public void u2(kx2 kx2Var) {
        this.E0 = kx2Var;
    }

    public final void v2(CoinPayBean2.ChargeConfigBean chargeConfigBean) {
        this.D0 = chargeConfigBean;
        if (chargeConfigBean == null || this.A0 == null) {
            return;
        }
        this.A0.setText(aq4.b(m93.j1, rv3.a(this.F0 ? "$" : "￥", chargeConfigBean.getMoney())));
    }
}
