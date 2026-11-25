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
import com.yunbao.common.http.CommonHttpConsts;
import com.yunbao.common.http.CommonHttpUtil;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.mall.bean.GoodsPayBean;
import java.util.HashMap;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class fx2 extends l0 implements View.OnClickListener {
    public kd1 A0;
    public String B0;
    public double C0;
    public String D0;
    public c E0;
    public kx2 F0;
    public RecyclerView z0;

    /* loaded from: /tmp/classes2.dex */
    public class a extends HttpCallback {

        /* renamed from: fx2$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/classes2.dex */
        public class C0066a implements zw2 {
            public C0066a() {
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
            fx2 fx2Var = fx2.this;
            fx2Var.A0 = new kd1(fx2Var.x0, parseArray, parseObject.getString("balance"));
            if (fx2.this.z0 != null) {
                fx2.this.z0.setAdapter(fx2.this.A0);
            }
            fx2 fx2Var2 = fx2.this;
            fx2Var2.F0 = new kx2(fx2Var2.x0);
            fx2.this.F0.l("Paidprogram.getAliOrder");
            fx2.this.F0.n("Paidprogram.getWxOrder");
            fx2.this.F0.m("Paidprogram.getBraintreePaypalOrder");
            fx2.this.F0.e(wg1.g);
            fx2.this.F0.f(parseObject.getString("aliapp_partner"));
            fx2.this.F0.h(parseObject.getString("aliapp_seller_id"));
            fx2.this.F0.g(parseObject.getString("aliapp_key_android"));
            fx2.this.F0.o(parseObject.getString("wx_appid"));
            fx2.this.F0.k(new C0066a());
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends HttpCallback {
        public b() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i == 0) {
                fx2.this.S1();
                if (fx2.this.E0 != null) {
                    fx2.this.E0.A();
                }
            }
            t54.b(str);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface c {
        void A();
    }

    private void A2() {
        kd1 kd1Var;
        GoodsPayBean a0;
        if (TextUtils.isEmpty(this.B0) || this.x0 == null || (kd1Var = this.A0) == null || (a0 = kd1Var.a0()) == null) {
            return;
        }
        if ("balance".equals(a0.getId())) {
            z2();
            return;
        }
        if (this.F0 == null) {
            return;
        }
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        j30 q = j30.q();
        String C = q.C();
        String B = q.B();
        String a2 = fa2.a(rv3.a("object_id=", this.B0, "&time=", valueOf, "&token=", B, "&uid=", C, "&", CommonHttpUtil.SALT));
        HashMap hashMap = new HashMap();
        hashMap.put("uid", C);
        hashMap.put("token", B);
        hashMap.put(DeepLinkPresetEvent.UMEventParamTime, valueOf);
        hashMap.put("sign", a2);
        hashMap.put("object_id", this.B0);
        this.F0.b(a0.getId(), String.valueOf(this.C0), this.D0, hashMap);
    }

    public void B2(c cVar) {
        this.E0 = cVar;
    }

    @Override // defpackage.l0
    public void C0() {
        ec2.u("getPayContentPayList");
        ec2.u("buyPayContent");
        ec2.u(CommonHttpConsts.GET_ALI_ORDER);
        ec2.u(CommonHttpConsts.GET_WX_ORDER);
        kx2 kx2Var = this.F0;
        if (kx2Var != null) {
            kx2Var.d();
        }
        this.F0 = null;
        this.x0 = null;
        this.A0 = null;
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
        return z73.g0;
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
        this.B0 = z.getString("mallGoodsId");
        this.C0 = z.getDouble("mallOrderMoney", 0.0d);
        this.D0 = z.getString("mallGoodsName");
        ((TextView) k2(d73.P2)).setText(String.valueOf(this.C0));
        RecyclerView k2 = k2(d73.u3);
        this.z0 = k2;
        k2.setLayoutManager(new LinearLayoutManager(this.x0, 1, false));
        k2(d73.W).setOnClickListener(this);
        k2(d73.M0).setOnClickListener(this);
        ec2.Y(new a());
    }

    public final void z2() {
        ec2.d(this.B0, new b());
    }
}
