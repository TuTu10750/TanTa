package defpackage;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.bean.CoinPayBean2;
import com.yunbao.common.http.CommonHttpUtil;
import com.yunbao.common.http.HttpCallback;
import java.util.HashMap;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class n21 extends l0 implements et2 {
    public m21 A0;
    public kx2 B0;
    public String C0;
    public String D0;
    public String E0;
    public String F0;
    public RecyclerView z0;

    /* loaded from: /tmp/classes2.dex */
    public class a implements zw2 {
        public a() {
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
            JSONObject parseObject = JSON.parseObject(strArr[0]);
            List parseArray = JSON.parseArray(parseObject.getString("paylist"), CoinPayBean2.class);
            if (n21.this.B0 != null) {
                n21.this.B0.f(parseObject.getString("aliapp_partner"));
                n21.this.B0.h(parseObject.getString("aliapp_seller_id"));
                n21.this.B0.g(parseObject.getString("aliapp_key_android"));
                n21.this.B0.o(parseObject.getString("wx_appid"));
            }
            n21.this.A0.P(parseArray);
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
        return u73.l;
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
        this.C0 = z.getString("id");
        this.D0 = z.getString("name");
        this.E0 = z.getString("money");
        this.F0 = z.getString("coin");
        RecyclerView k2 = k2(y63.Z);
        this.z0 = k2;
        k2.setLayoutManager(new LinearLayoutManager(this.x0, 1, false));
        m21 m21Var = new m21(this.x0);
        this.A0 = m21Var;
        m21Var.R(this);
        this.z0.setAdapter(this.A0);
        kx2 kx2Var = new kx2((AbsActivity) this.x0);
        this.B0 = kx2Var;
        kx2Var.l("Charge.getAliOrder");
        this.B0.n("Charge.getWxOrder");
        this.B0.m("Charge.getBraintreePaypalOrder");
        this.B0.e(wg1.e);
        this.B0.k(new a());
        CommonHttpUtil.getBalance(new b());
    }

    @Override // defpackage.et2
    /* renamed from: t2, reason: merged with bridge method [inline-methods] */
    public void onItemClick(CoinPayBean2 coinPayBean2, int i) {
        String href = coinPayBean2.getHref();
        if (TextUtils.isEmpty(href)) {
            HashMap hashMap = new HashMap();
            hashMap.put("uid", j30.q().C());
            hashMap.put("token", j30.q().B());
            hashMap.put("money", this.E0);
            hashMap.put("changeid", this.C0);
            hashMap.put("coin", this.F0);
            this.B0.b(coinPayBean2.getId(), this.E0, this.D0, hashMap);
            return;
        }
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(href));
            this.x0.startActivity(intent);
        } catch (Exception e) {
            ah1.a(e);
        }
    }
}
