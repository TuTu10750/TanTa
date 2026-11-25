package defpackage;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yunbao.common.activity.WebViewActivity;
import com.yunbao.common.bean.CoinPayBean2;
import com.yunbao.common.http.CommonHttpConsts;
import com.yunbao.common.http.CommonHttpUtil;
import com.yunbao.common.http.HttpCallback;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: /tmp/classes2.dex */
public class ac2 extends v0 implements View.OnClickListener {
    public SwipeRefreshLayout a;
    public RecyclerView b;
    public ql4 c;
    public sl4 d;
    public rl4 e;
    public TextView f;
    public TextView g;
    public boolean h;
    public kx2 i;
    public TextView j;
    public TextView k;
    public String l;

    /* loaded from: /tmp/classes2.dex */
    public class a implements SwipeRefreshLayout.j {
        public a() {
        }

        public void a() {
            ac2.this.c.i = 0;
            ac2.this.d.j = 0;
            ac2.this.loadData();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements et2 {
        public b() {
        }

        @Override // defpackage.et2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onItemClick(CoinPayBean2 coinPayBean2, int i) {
            ac2.this.c.i = i;
            ac2.this.c.p();
            ac2.this.d.j = 0;
            ac2.this.d.R(coinPayBean2.getVip_config());
            ac2.this.k.setText(coinPayBean2.getVip_config().get(0).getDescribe());
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c implements et2 {
        public c() {
        }

        @Override // defpackage.et2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onItemClick(CoinPayBean2.ChargeConfigBean chargeConfigBean, int i) {
            ac2.this.e.N(chargeConfigBean.getPrivilege());
            ac2.this.k.setText(chargeConfigBean.getDescribe());
            ac2.this.d.j = i;
            ac2.this.d.p();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d extends GridLayoutManager.c {
        public final /* synthetic */ h a;

        public d(h hVar) {
            this.a = hVar;
        }

        public int getSpanSize(int i) {
            int j = ac2.this.c.j();
            if (i < j) {
                return 1;
            }
            int i2 = i - j;
            return (i2 >= this.a.j() && i2 - this.a.j() < ac2.this.d.j()) ? 1 : 3;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e implements zw2 {
        public e() {
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class f extends HttpCallback {
        public f() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onFinish() {
            if (ac2.this.a != null) {
                ac2.this.a.setRefreshing(false);
            }
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length <= 0) {
                return;
            }
            int i2 = 0;
            JSONObject parseObject = JSON.parseObject(strArr[0]);
            List parseArray = JSON.parseArray(parseObject.getString("paylist"), CoinPayBean2.class);
            String string = parseObject.getString("endtime");
            boolean isEmpty = string.isEmpty();
            ac2 ac2Var = ac2.this;
            if (isEmpty) {
                ac2Var.g.setVisibility(8);
                if (ac2.this.f != null) {
                    ac2.this.f.setText("您现在还不是VIP.");
                }
            } else {
                ac2Var.g.setVisibility(0);
                if (ac2.this.f != null) {
                    ac2.this.f.setText(string);
                }
            }
            if (parseArray.isEmpty()) {
                return;
            }
            ac2.this.k.setText(((CoinPayBean2) parseArray.get(0)).getVip_config().get(0).getDescribe());
            if (ac2.this.c != null) {
                ac2.this.c.S(parseArray);
            }
            if (ac2.this.d != null) {
                ac2.this.d.R(((CoinPayBean2) parseArray.get(0)).getVip_config());
                int i3 = ac2.this.c.i;
                if (i3 < 0 || i3 >= parseArray.size()) {
                    ac2.this.c.i = 0;
                    i3 = 0;
                }
                List<CoinPayBean2.ChargeConfigBean> vip_config = ((CoinPayBean2) parseArray.get(i3)).getVip_config();
                int i4 = ac2.this.d.j;
                if (vip_config == null || vip_config.isEmpty()) {
                    return;
                }
                if (i4 < 0 || i4 >= vip_config.size()) {
                    ac2.this.d.j = 0;
                } else {
                    i2 = i4;
                }
                String privilege = ((CoinPayBean2) parseArray.get(i3)).getVip_config().get(i2).getPrivilege();
                if (ac2.this.e != null) {
                    ac2.this.e.N(privilege);
                }
            }
            if (ac2.this.i != null) {
                ac2.this.i.i(123L);
                ac2.this.i.f(parseObject.getString("aliapp_partner"));
                ac2.this.i.h(parseObject.getString("aliapp_seller_id"));
                ac2.this.i.g(parseObject.getString("aliapp_key_android"));
                ac2.this.i.o(parseObject.getString("wx_appid"));
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class g extends HttpCallback {
        public final /* synthetic */ CoinPayBean2 a;
        public final /* synthetic */ Dialog b;

        public g(CoinPayBean2 coinPayBean2, Dialog dialog) {
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
            StringBuilder sb = new StringBuilder("vip pay response code=");
            sb.append(i);
            sb.append(", msg=");
            sb.append(str);
            sb.append(", infoCount=");
            sb.append(strArr == null ? -1 : strArr.length);
            lx1.c("RechargePay", sb.toString());
            if (i == 0 && strArr != null && strArr.length > 0) {
                ac2 ac2Var = ac2.this;
                ac2Var.m0(ac2Var.n0(strArr[0]), this.a.getOpen_type());
            } else {
                if (TextUtils.isEmpty(str)) {
                    str = "支付链接获取失败，请稍后重试";
                }
                t54.b(str);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static class h extends RecyclerView.Adapter {

        /* loaded from: /tmp/classes2.dex */
        public static class a extends RecyclerView.e0 {
            public a(View view) {
                super(view);
            }
        }

        public h() {
        }

        public /* synthetic */ h(a aVar) {
            this();
        }

        /* renamed from: L, reason: merged with bridge method [inline-methods] */
        public void z(a aVar, int i) {
        }

        /* renamed from: M, reason: merged with bridge method [inline-methods] */
        public a B(ViewGroup viewGroup, int i) {
            View view = new View(viewGroup.getContext());
            view.setLayoutParams(new ViewGroup.LayoutParams(-1, zn0.a(15)));
            return new a(view);
        }

        public int j() {
            return 1;
        }
    }

    public ac2(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
        this.h = true;
        this.l = "";
    }

    private void l0() {
        ql4 ql4Var = this.c;
        if (ql4Var == null || this.i == null || this.d == null) {
            return;
        }
        CoinPayBean2 P = ql4Var.P();
        if (P == null) {
            t54.a(m93.Fa);
            return;
        }
        CoinPayBean2.ChargeConfigBean chargeConfigBean = P.getVip_config().get(this.d.j);
        if (chargeConfigBean == null) {
            return;
        }
        Dialog c2 = com.yunbao.common.utils.a.c(this.mContext);
        c2.show();
        CommonHttpUtil.vipPay(chargeConfigBean.getId(), P.getId(), new g(P, c2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0(String str, int i) {
        lx1.c("RechargePay", "open vip pay url openType=" + i + ", url=" + str);
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

    /* JADX INFO: Access modifiers changed from: private */
    public String n0(String str) {
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

    @Override // defpackage.v0
    public void getData() {
        if (isFirstLoadData()) {
            loadData();
        }
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return y73.e1;
    }

    @Override // defpackage.b1
    public void init() {
        this.f = (TextView) findViewById(c73.r5);
        this.g = (TextView) findViewById(c73.s5);
        TextView textView = (TextView) findViewById(c73.R);
        this.j = textView;
        textView.setOnClickListener(this);
        findViewById(c73.O4).setOnClickListener(this);
        this.k = (TextView) findViewById(c73.h5);
        SwipeRefreshLayout findViewById = findViewById(c73.q4);
        this.a = findViewById;
        findViewById.setColorSchemeResources(new int[]{p53.c});
        this.a.setOnRefreshListener(new a());
        ql4 ql4Var = new ql4(this.mContext);
        this.c = ql4Var;
        ql4Var.T(new b());
        sl4 sl4Var = new sl4(this.mContext);
        this.d = sl4Var;
        sl4Var.S(new c());
        this.e = new rl4(this.mContext);
        h hVar = new h(null);
        ConcatAdapter concatAdapter = new ConcatAdapter(new RecyclerView.Adapter[]{this.c, hVar, this.d, this.e});
        this.b = findViewById(c73.h4);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.mContext, 3, 1, false);
        gridLayoutManager.s3(new d(hVar));
        this.b.setLayoutManager(gridLayoutManager);
        rq1 rq1Var = new rq1(this.mContext, 0, 13.0f, 10.0f);
        rq1Var.l(true);
        this.b.k(rq1Var);
        this.b.setAdapter(concatAdapter);
        kx2 kx2Var = new kx2(this.mContext);
        this.i = kx2Var;
        kx2Var.j(1);
        this.i.l("Charge.getAliOrder");
        this.i.n("Charge.getWxOrder");
        this.i.m("Charge.getBraintreePaypalOrder");
        this.i.e(wg1.e);
        this.i.k(new e());
        zu0.c().n(this);
    }

    @Override // defpackage.y0
    public void loadData() {
        CommonHttpUtil.getVip(new f());
    }

    public void o0(String str) {
        this.l = str;
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
                l0();
            }
        } else if (id == c73.T) {
            new k21().d2(this.mContext.getSupportFragmentManager(), "FirstChargeDialogFragment");
        } else if (id == c73.S) {
            WebViewActivity.E1(this.mContext, wg1.o);
        } else if (id == c73.O4) {
            WebViewActivity.E1(this.mContext, wg1.o);
        }
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onCoinChangeEvent(l20 l20Var) {
        loadData();
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
}
