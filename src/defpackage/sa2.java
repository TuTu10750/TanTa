package defpackage;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yunbao.common.activity.WebViewActivity;
import com.yunbao.common.bean.CoinBean;
import com.yunbao.common.bean.CoinPayBean2;
import com.yunbao.common.http.CommonHttpConsts;
import com.yunbao.common.http.CommonHttpUtil;
import com.yunbao.common.http.HttpCallback;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: /tmp/classes2.dex */
public class sa2 extends v0 implements View.OnClickListener {
    public SwipeRefreshLayout a;
    public RecyclerView b;
    public RecyclerView c;
    public k20 d;
    public ql4 e;
    public TextView f;
    public long g;
    public boolean h;
    public kx2 i;
    public String j;
    public TextView k;
    public TextView l;
    public TextView m;
    public boolean n;
    public boolean o;

    /* loaded from: /tmp/classes2.dex */
    public class a implements SwipeRefreshLayout.j {
        public a() {
        }

        public void a() {
            sa2.this.d.l = 0;
            sa2.this.e.i = 0;
            sa2.this.loadData();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements et2 {
        public b() {
        }

        @Override // defpackage.et2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onItemClick(CoinPayBean2.ChargeConfigBean chargeConfigBean, int i) {
            if (chargeConfigBean == null || sa2.this.l == null) {
                return;
            }
            sa2.this.l.setText(aq4.b(m93.j1, rv3.a(sa2.this.n ? "$" : "￥", chargeConfigBean.getMoney())));
            sa2.this.d.l = i;
            sa2.this.d.p();
            sa2.this.m.setText(chargeConfigBean.getDescribe());
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c implements et2 {
        public c() {
        }

        @Override // defpackage.et2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onItemClick(CoinPayBean2 coinPayBean2, int i) {
            CoinPayBean2.ChargeConfigBean S;
            sa2.this.e.i = i;
            sa2.this.e.p();
            sa2.this.d.l = 0;
            boolean equals = "paypal".equals(coinPayBean2.getId());
            sa2.this.m.setText(coinPayBean2.getCharge_config().get(0).getDescribe());
            if (sa2.this.n != equals && sa2.this.d != null && (S = sa2.this.d.S()) != null && sa2.this.l != null) {
                sa2.this.l.setText(aq4.b(m93.j1, rv3.a(equals ? "$" : "￥", S.getMoney())));
            }
            sa2.this.n = equals;
            if (sa2.this.d != null) {
                sa2.this.d.T(equals);
            }
            System.out.println("1111111-------------");
            if (sa2.this.d != null) {
                System.out.println("222222222-------------");
                List<CoinPayBean2.ChargeConfigBean> charge_config = coinPayBean2.getCharge_config();
                sa2.this.d.U(charge_config);
                if (charge_config != null && charge_config.size() > 0) {
                    System.out.println("3333333333-------------");
                    sa2.this.n = "paypal".equals(Integer.valueOf(charge_config.get(0).getId()));
                    sa2.this.d.T(sa2.this.n);
                }
                CoinPayBean2.ChargeConfigBean S2 = sa2.this.d.S();
                if (S2 == null || sa2.this.l == null) {
                    return;
                }
                System.out.println("444444444-------------");
                sa2.this.l.setText(aq4.b(m93.j1, rv3.a(sa2.this.n ? "$" : "￥", S2.getMoney())));
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d implements zw2 {
        public d() {
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e extends HttpCallback {
        public e() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onFinish() {
            if (sa2.this.a != null) {
                sa2.this.a.setRefreshing(false);
            }
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length <= 0) {
                return;
            }
            JSONObject parseObject = JSON.parseObject(strArr[0]);
            String string = parseObject.getString("coin");
            sa2.this.g = Long.parseLong(string);
            sa2.this.f.setText("￥" + string);
            sa2.this.k.setText(parseObject.getString("score"));
            List parseArray = JSON.parseArray(parseObject.getString("paylist"), CoinPayBean2.class);
            if (parseArray.isEmpty()) {
                return;
            }
            if (sa2.this.e != null) {
                sa2.this.e.S(parseArray);
            }
            JSON.parseArray(parseObject.getString("rules"), CoinBean.class);
            if (sa2.this.d != null && parseArray.size() > 0) {
                List<CoinPayBean2.ChargeConfigBean> charge_config = ((CoinPayBean2) parseArray.get(0)).getCharge_config();
                sa2.this.m.setText(charge_config.get(0).getDescribe());
                sa2.this.d.U(charge_config);
                if (parseArray.size() > 0) {
                    sa2.this.n = "paypal".equals(((CoinPayBean2) parseArray.get(0)).getId());
                    sa2.this.d.T(sa2.this.n);
                }
                CoinPayBean2.ChargeConfigBean S = sa2.this.d.S();
                if (S != null && sa2.this.l != null) {
                    sa2.this.l.setText(aq4.b(m93.j1, rv3.a(sa2.this.n ? "$" : "￥", S.getMoney())));
                }
            }
            if (sa2.this.i != null) {
                sa2.this.i.i(sa2.this.g);
                sa2.this.i.f(parseObject.getString("aliapp_partner"));
                sa2.this.i.h(parseObject.getString("aliapp_seller_id"));
                sa2.this.i.g(parseObject.getString("aliapp_key_android"));
                sa2.this.i.o(parseObject.getString("wx_appid"));
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class f extends HttpCallback {
        public final /* synthetic */ CoinPayBean2 a;
        public final /* synthetic */ Dialog b;

        public f(CoinPayBean2 coinPayBean2, Dialog dialog) {
            this.a = coinPayBean2;
            this.b = dialog;
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onFinish() {
            super.onFinish();
            this.b.dismiss();
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            StringBuilder sb = new StringBuilder("coin pay response code=");
            sb.append(i);
            sb.append(", msg=");
            sb.append(str);
            sb.append(", infoCount=");
            sb.append(strArr == null ? -1 : strArr.length);
            lx1.c("RechargePay", sb.toString());
            if (i == 0 && strArr != null && strArr.length > 0) {
                sa2 sa2Var = sa2.this;
                sa2Var.q0(sa2Var.r0(strArr[0]), this.a.getOpen_type());
            } else {
                if (TextUtils.isEmpty(str)) {
                    str = "支付链接获取失败，请稍后重试";
                }
                t54.b(str);
            }
        }
    }

    public sa2(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
        this.h = true;
        this.o = true;
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return y73.m;
    }

    @Override // defpackage.b1
    public void init() {
        TextView textView = (TextView) findViewById(c73.R);
        this.l = textView;
        textView.setOnClickListener(this);
        this.m = (TextView) findViewById(c73.h5);
        findViewById(c73.T).setOnClickListener(this);
        findViewById(c73.S).setOnClickListener(this);
        findViewById(c73.s3).setOnClickListener(this);
        this.k = (TextView) findViewById(c73.D1);
        SwipeRefreshLayout findViewById = findViewById(c73.q4);
        this.a = findViewById;
        findViewById.setColorSchemeResources(new int[]{p53.c});
        this.a.setOnRefreshListener(new a());
        this.j = j30.q().g();
        this.f = (TextView) findViewById(c73.C1);
        ((TextView) findViewById(c73.E1)).setText(aq4.b(m93.Ea, this.j));
        ((TextView) findViewById(c73.w4)).setText(aq4.b(m93.Ea, j30.q().A()));
        RecyclerView findViewById2 = findViewById(c73.h4);
        this.b = findViewById2;
        findViewById2.setLayoutManager(new GridLayoutManager(this.mContext, 3, 1, false));
        rq1 rq1Var = new rq1(this.mContext, 0, 5.0f, 10.0f);
        rq1Var.l(true);
        this.b.k(rq1Var);
        k20 k20Var = new k20(this.mContext, this.j);
        this.d = k20Var;
        k20Var.V(new b());
        this.b.setAdapter(this.d);
        findViewById(c73.m1).setOnClickListener(this);
        this.c = findViewById(c73.X3);
        rq1 rq1Var2 = new rq1(this.mContext, 0, 14.0f, 10.0f);
        rq1Var2.l(true);
        this.c.k(rq1Var2);
        this.c.setLayoutManager(new GridLayoutManager(this.mContext, 3, 1, false));
        ql4 ql4Var = new ql4(this.mContext);
        this.e = ql4Var;
        ql4Var.T(new c());
        this.c.setAdapter(this.e);
        kx2 kx2Var = new kx2(this.mContext);
        this.i = kx2Var;
        kx2Var.l("Charge.getAliOrder");
        this.i.n("Charge.getWxOrder");
        this.i.m("Charge.getBraintreePaypalOrder");
        this.i.e(wg1.e);
        this.i.k(new d());
        zu0.c().n(this);
    }

    @Override // defpackage.y0
    public void loadData() {
        CommonHttpUtil.getBalanceNew(new e());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == c73.m1) {
            WebViewActivity.E1(this.mContext, wg1.n);
            return;
        }
        if (id == c73.R) {
            if (j10.a()) {
                p0();
                return;
            }
            return;
        }
        if (id == c73.T) {
            new k21().d2(this.mContext.getSupportFragmentManager(), "FirstChargeDialogFragment");
            return;
        }
        if (id == c73.S) {
            WebViewActivity.E1(this.mContext, wg1.o);
            return;
        }
        if (id == c73.s3) {
            if (!this.o) {
                this.o = true;
                TextView textView = this.f;
                textView.setText((CharSequence) textView.getTag());
            } else {
                this.o = false;
                TextView textView2 = this.f;
                textView2.setTag(textView2.getText());
                this.f.setText("￥****");
            }
        }
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onCoinChangeEvent(l20 l20Var) {
        if (this.f != null) {
            throw null;
        }
    }

    @Override // defpackage.b1, defpackage.uy1
    public void onDestroy() {
        zu0.c().p(this);
        CommonHttpUtil.cancel(CommonHttpConsts.GET_BALANCE);
        CommonHttpUtil.cancel(CommonHttpConsts.GET_ALI_ORDER);
        CommonHttpUtil.cancel(CommonHttpConsts.GET_WX_ORDER);
        SwipeRefreshLayout swipeRefreshLayout = this.a;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setOnRefreshListener((SwipeRefreshLayout.j) null);
        }
        this.a = null;
        kx2 kx2Var = this.i;
        if (kx2Var != null) {
            kx2Var.d();
        }
        this.i = null;
        super.onDestroy();
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onFirstChargeEvent(l21 l21Var) {
        loadData();
    }

    @Override // defpackage.b1, defpackage.uy1
    public void onResume() {
        super.onResume();
        if (this.h) {
            this.h = false;
            loadData();
        }
    }

    public final void p0() {
        CoinPayBean2.ChargeConfigBean S;
        k20 k20Var = this.d;
        if (k20Var == null || this.i == null || this.e == null || (S = k20Var.S()) == null) {
            return;
        }
        CoinPayBean2 P = this.e.P();
        if (P == null) {
            t54.a(m93.Fa);
            return;
        }
        Dialog c2 = com.yunbao.common.utils.a.c(this.mContext);
        c2.show();
        CommonHttpUtil.chargePay(S.getId(), P.getId(), new f(P, c2));
    }

    public final void q0(String str, int i) {
        lx1.c("RechargePay", "open coin pay url openType=" + i + ", url=" + str);
        if (TextUtils.isEmpty(str)) {
            t54.b("支付链接异常，请稍后重试");
            return;
        }
        if (i == 1) {
            WebViewActivity.E1(this.mContext, str);
            return;
        }
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            this.mContext.startActivity(intent);
        } catch (Exception unused) {
            t54.b("未找到可打开支付链接的浏览器");
        }
    }

    public final String r0(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String trim = str.trim();
        if (trim.startsWith("{")) {
            try {
                JSONObject parseObject = JSON.parseObject(trim);
                String string = parseObject.getString("pay_url");
                if (TextUtils.isEmpty(string)) {
                    string = parseObject.getString("payUrl");
                }
                if (TextUtils.isEmpty(string)) {
                    string = parseObject.getString("payurl");
                }
                if (TextUtils.isEmpty(string)) {
                    string = parseObject.getString(IjkMediaPlayer.OnNativeInvokeListener.ARG_URL);
                }
                return TextUtils.isEmpty(string) ? parseObject.getString("redirect_url") : string;
            } catch (Exception unused) {
                return trim;
            }
        }
        return trim;
    }
}
