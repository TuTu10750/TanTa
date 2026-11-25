package defpackage;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.umeng.ccg.c;
import com.yunbao.common.bean.CoinBean;
import com.yunbao.common.bean.CoinPayBean2;
import com.yunbao.common.http.CommonHttpConsts;
import com.yunbao.common.http.CommonHttpUtil;
import com.yunbao.common.http.HttpCallback;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class g12 extends l0 implements View.OnClickListener {
    public List A0;
    public oy B0;
    public b C0;
    public CoinBean D0;
    public TextView E0;
    public TextView F0;
    public kx2 G0;
    public RecyclerView z0;

    /* loaded from: /tmp/classes2.dex */
    public class a extends HttpCallback {

        /* renamed from: g12$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/classes2.dex */
        public class C0068a implements et2 {
            public C0068a() {
            }

            @Override // defpackage.et2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onItemClick(CoinPayBean2 coinPayBean2, int i) {
                "paypal".equals(coinPayBean2.getId());
                zu0.c().j(new hy(coinPayBean2.getId()));
            }
        }

        public a() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length <= 0 || g12.this.z0 == null) {
                return;
            }
            JSONObject parseObject = JSON.parseObject(strArr[0]);
            List parseArray = JSON.parseArray(parseObject.getString("paylist"), CoinPayBean2.class);
            int size = parseArray.size();
            int i2 = 0;
            while (i2 < size) {
                ((CoinPayBean2) parseArray.get(i2)).setChecked(i2 == 0);
                i2++;
            }
            g12.this.A0 = parseArray;
            JSON.parseArray(parseObject.getString("rules"), CoinBean.class);
            if (g12.this.A0 != null) {
                g12 g12Var = g12.this;
                g12Var.B0 = new oy(g12Var.x0, g12Var.A0);
                g12.this.B0.W(new C0068a());
                g12.this.z0.setAdapter(g12.this.B0);
                g12.this.B0.S();
            }
            if (g12.this.G0 != null) {
                g12.this.G0.i(Long.parseLong(parseObject.getString("coin")));
                g12.this.G0.f(parseObject.getString("aliapp_partner"));
                g12.this.G0.h(parseObject.getString("aliapp_seller_id"));
                g12.this.G0.g(parseObject.getString("aliapp_key_android"));
                g12.this.G0.o(parseObject.getString("wx_appid"));
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface b {
        void n(CoinPayBean2 coinPayBean2);
    }

    private void x2() {
        b bVar;
        oy oyVar = this.B0;
        if (oyVar != null && (bVar = this.C0) != null) {
            bVar.n(oyVar.S());
            S1();
        }
        oy oyVar2 = this.B0;
        if (oyVar2 == null || oyVar2.S() == null) {
            y2();
            return;
        }
        f12 f12Var = new f12();
        CoinPayBean2 S = this.B0.S();
        S.getCharge_config();
        f12Var.t2(S);
        f12Var.u2(this.G0);
        f12Var.d2(this.x0.getSupportFragmentManager(), "ChatChargePayDialogFragment");
        S1();
    }

    private void y2() {
        CommonHttpUtil.getBalanceNew(new a());
    }

    @Override // defpackage.l0
    public void C0() {
        zu0.c().j(new hy(""));
        CommonHttpUtil.cancel(CommonHttpConsts.GET_BALANCE);
        this.C0 = null;
        this.G0 = null;
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
        return u73.h;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == y63.i) {
            S1();
        } else if (id == y63.h) {
            x2();
        }
    }

    @Override // defpackage.l0
    public void p2(Window window) {
        window.setWindowAnimations(s93.b);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = zn0.a(c.u);
        attributes.height = zn0.a(350);
        attributes.gravity = 17;
        window.setAttributes(attributes);
    }

    public void r0(Bundle bundle) {
        super.r0(bundle);
        k2(y63.h).setOnClickListener(this);
        k2(y63.i).setOnClickListener(this);
        this.E0 = (TextView) k2(y63.w);
        this.F0 = (TextView) k2(y63.S);
        TextView textView = (TextView) k2(y63.R);
        CoinBean coinBean = this.D0;
        if (coinBean != null) {
            textView.setText(coinBean.getMoney());
        }
        RecyclerView k2 = k2(y63.Z);
        this.z0 = k2;
        k2.setHasFixedSize(true);
        this.z0.setLayoutManager(new LinearLayoutManager(this.x0, 1, false));
        y2();
    }

    public void z2(kx2 kx2Var) {
        this.G0 = kx2Var;
    }
}
