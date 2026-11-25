package defpackage;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.umeng.commonsdk.deeplink.DeepLinkPresetEvent;
import com.yunbao.common.bean.ConfigBean;
import com.yunbao.common.http.CommonHttpConsts;
import com.yunbao.common.http.CommonHttpUtil;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.mall.bean.GoodsPayBean;
import java.util.HashMap;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class ld1 extends l0 implements View.OnClickListener {
    public kd1 A0;
    public String B0;
    public double C0;
    public String D0;
    public c E0;
    public kx2 F0;
    public boolean G0;
    public RecyclerView z0;

    /* loaded from: /tmp/classes2.dex */
    public class a extends HttpCallback {

        /* renamed from: ld1$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/classes2.dex */
        public class C0133a implements zw2 {
            public C0133a() {
            }
        }

        public a() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length <= 0) {
                return;
            }
            JSONObject parseObject = JSON.parseObject(strArr[0]);
            List parseArray = JSON.parseArray(parseObject.getString("paylist"), GoodsPayBean.class);
            if (parseArray == null || parseArray.size() <= 0) {
                return;
            }
            ((GoodsPayBean) parseArray.get(0)).setChecked(true);
            ld1 ld1Var = ld1.this;
            ld1Var.A0 = new kd1(ld1Var.x0, parseArray, parseObject.getString("balance"));
            if (ld1.this.z0 != null) {
                ld1.this.z0.setAdapter(ld1.this.A0);
            }
            ld1 ld1Var2 = ld1.this;
            ld1Var2.F0 = new kx2(ld1Var2.x0);
            ld1.this.F0.l("Buyer.goodsOrderPay");
            ld1.this.F0.n("Buyer.goodsOrderPay");
            ld1.this.F0.m("Buyer.goodsOrderPay");
            ld1.this.F0.e(wg1.f);
            ld1.this.F0.f(parseObject.getString("aliapp_partner"));
            ld1.this.F0.h(parseObject.getString("aliapp_seller_id"));
            ld1.this.F0.g(parseObject.getString("aliapp_key_android"));
            ld1.this.F0.o(parseObject.getString("wx_appid"));
            ld1.this.F0.k(new C0133a());
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends HttpCallback {
        public b() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i == 0) {
                ld1.this.G0 = true;
                ld1.this.S1();
            }
            t54.b(str);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface c {
        void x0(boolean z);
    }

    private void A2() {
        kd1 kd1Var;
        GoodsPayBean a0;
        if (TextUtils.isEmpty(this.B0) || this.x0 == null || (kd1Var = this.A0) == null || (a0 = kd1Var.a0()) == null) {
            return;
        }
        String type = a0.getType();
        if ("balance".equals(a0.getId())) {
            z2(type);
            return;
        }
        if (this.F0 == null) {
            return;
        }
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        j30 q = j30.q();
        String C = q.C();
        String B = q.B();
        String a2 = fa2.a(rv3.a("orderid=", this.B0, "&time=", valueOf, "&token=", B, "&type=", type, "&uid=", C, "&", CommonHttpUtil.SALT));
        HashMap hashMap = new HashMap();
        hashMap.put("uid", C);
        hashMap.put("token", B);
        hashMap.put(DeepLinkPresetEvent.UMEventParamTime, valueOf);
        hashMap.put("sign", a2);
        hashMap.put("orderid", this.B0);
        hashMap.put("type", type);
        this.F0.b(a0.getId(), String.valueOf(this.C0), this.D0, hashMap);
    }

    public void B2(c cVar) {
        this.E0 = cVar;
    }

    @Override // defpackage.l0
    public void C0() {
        ec2.u("getBuyerPayList");
        ec2.u("buyerPayOrder");
        ec2.u(CommonHttpConsts.GET_ALI_ORDER);
        ec2.u(CommonHttpConsts.GET_WX_ORDER);
        kx2 kx2Var = this.F0;
        if (kx2Var != null) {
            kx2Var.d();
        }
        this.F0 = null;
        this.A0 = null;
        this.x0 = null;
        c cVar = this.E0;
        if (cVar != null) {
            cVar.x0(this.G0);
        }
        this.E0 = null;
        super.C0();
    }

    @Override // defpackage.l0
    public boolean f2() {
        return true;
    }

    @Override // defpackage.l0
    public int l2() {
        return s93.c;
    }

    @Override // defpackage.l0
    public int m2() {
        return z73.b0;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == d73.W) {
            S1();
        } else if (id == d73.M0) {
            A2();
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
        Bundle z = z();
        if (z == null) {
            return;
        }
        this.B0 = z.getString("mallOrderId");
        this.C0 = z.getDouble("mallOrderMoney", 0.0d);
        this.D0 = z.getString("mallGoodsName");
        TextView textView = (TextView) k2(d73.g3);
        ConfigBean h = j30.q().h();
        textView.setText(aq4.b(m93.F6, h != null ? h.getShopSystemName() : aq4.a(m93.p5)));
        ((TextView) k2(d73.P2)).setText(String.valueOf(this.C0));
        RecyclerView k2 = k2(d73.u3);
        this.z0 = k2;
        k2.setLayoutManager(new LinearLayoutManager(this.x0, 1, false));
        k2(d73.W).setOnClickListener(this);
        k2(d73.M0).setOnClickListener(this);
        ec2.I(new a());
    }

    public final void z2(String str) {
        ec2.s(this.B0, str, new b());
    }
}
