package defpackage;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.alibaba.fastjson.JSON;
import com.yunbao.common.activity.WebViewActivity;
import com.yunbao.common.custom.CommonRefreshView;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.common.utils.a;
import com.yunbao.mall.activity.BuyerCommentActivity;
import com.yunbao.mall.activity.BuyerOrderActivity;
import com.yunbao.mall.activity.BuyerOrderDetailActivity;
import com.yunbao.mall.activity.BuyerRefundDetailActivity;
import com.yunbao.mall.activity.ShopHomeActivity;
import com.yunbao.mall.bean.BuyerOrderBean;
import defpackage.ld1;
import defpackage.ol;
import java.util.Arrays;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public abstract class j0 extends k0 implements ol.c, ld1.c {
    public CommonRefreshView b;
    public ol c;

    /* loaded from: /tmp/classes2.dex */
    public class a implements CommonRefreshView.e {
        public a() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public ce3 getAdapter() {
            if (j0.this.c == null) {
                j0 j0Var = j0.this;
                j0Var.c = j0Var.d0();
                j0.this.c.X(j0.this);
            }
            return j0.this.c;
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void loadData(int i, HttpCallback httpCallback) {
            ec2.H(j0.this.e0(), i, httpCallback);
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void onLoadMoreFailure() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void onLoadMoreSuccess(List list, int i) {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void onRefreshFailure() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void onRefreshSuccess(List list, int i) {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public List processData(String[] strArr) {
            return JSON.parseArray(Arrays.toString(strArr), BuyerOrderBean.class);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements a.m {
        public final /* synthetic */ BuyerOrderBean a;

        /* loaded from: /tmp/classes2.dex */
        public class a extends HttpCallback {
            public a() {
            }

            @Override // com.yunbao.common.http.HttpCallback
            public void onSuccess(int i, String str, String[] strArr) {
                if (i == 0) {
                    j0.this.f0();
                }
                t54.b(str);
            }
        }

        public b(BuyerOrderBean buyerOrderBean) {
            this.a = buyerOrderBean;
        }

        @Override // com.yunbao.common.utils.a.m
        public void b(Dialog dialog, String str) {
            ec2.k(this.a.getId(), new a());
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c implements a.m {
        public final /* synthetic */ BuyerOrderBean a;

        /* loaded from: /tmp/classes2.dex */
        public class a extends HttpCallback {
            public a() {
            }

            @Override // com.yunbao.common.http.HttpCallback
            public void onSuccess(int i, String str, String[] strArr) {
                if (i == 0) {
                    j0.this.f0();
                }
                t54.b(str);
            }
        }

        public c(BuyerOrderBean buyerOrderBean) {
            this.a = buyerOrderBean;
        }

        @Override // com.yunbao.common.utils.a.m
        public void b(Dialog dialog, String str) {
            ec2.q(this.a.getId(), new a());
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d implements a.m {
        public final /* synthetic */ BuyerOrderBean a;

        /* loaded from: /tmp/classes2.dex */
        public class a extends HttpCallback {
            public a() {
            }

            @Override // com.yunbao.common.http.HttpCallback
            public void onSuccess(int i, String str, String[] strArr) {
                if (i == 0) {
                    j0.this.f0();
                }
                t54.b(str);
            }
        }

        public d(BuyerOrderBean buyerOrderBean) {
            this.a = buyerOrderBean;
        }

        @Override // com.yunbao.common.utils.a.m
        public void b(Dialog dialog, String str) {
            ec2.m(this.a.getId(), new a());
        }
    }

    public j0(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    @Override // ol.c
    public void A(BuyerOrderBean buyerOrderBean) {
        ShopHomeActivity.M1(this.mContext, buyerOrderBean.getSellerId());
    }

    @Override // ol.c
    public void L(BuyerOrderBean buyerOrderBean) {
        WebViewActivity.E1(this.mContext, rv3.a(wg1.q, "orderid=", buyerOrderBean.getId(), "&user_type=buyer"));
    }

    @Override // ol.c
    public void P(BuyerOrderBean buyerOrderBean) {
        BuyerRefundDetailActivity.Z1(this.mContext, buyerOrderBean.getId());
    }

    @Override // ol.c
    public void Y(BuyerOrderBean buyerOrderBean) {
        new a.j(this.mContext).k(aq4.a(m93.d8)).g(true).d(true).h(new c(buyerOrderBean)).c().show();
    }

    public abstract ol d0();

    public abstract String e0();

    public void f0() {
        CommonRefreshView commonRefreshView = this.b;
        if (commonRefreshView != null) {
            commonRefreshView.k();
        }
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return z73.E1;
    }

    @Override // ol.c
    public void i(BuyerOrderBean buyerOrderBean) {
        new a.j(this.mContext).k(aq4.a(m93.f8)).g(true).d(true).h(new d(buyerOrderBean)).c().show();
    }

    @Override // defpackage.b1
    public void init() {
        CommonRefreshView commonRefreshView = (CommonRefreshView) findViewById(d73.C3);
        this.b = commonRefreshView;
        commonRefreshView.setEmptyLayoutId(z73.I1);
        this.b.setLayoutManager(new LinearLayoutManager(this.mContext, 1, false));
        this.b.setDataHelper(new a());
    }

    @Override // defpackage.k0
    public void loadData() {
        CommonRefreshView commonRefreshView = this.b;
        if (commonRefreshView != null) {
            commonRefreshView.k();
        }
    }

    @Override // ol.c
    public void o(BuyerOrderBean buyerOrderBean) {
        ld1 ld1Var = new ld1();
        Bundle bundle = new Bundle();
        bundle.putString("mallOrderId", buyerOrderBean.getId());
        bundle.putDouble("mallOrderMoney", Double.parseDouble(buyerOrderBean.getTotalPrice()));
        bundle.putString("mallGoodsName", buyerOrderBean.getGoodsName());
        ld1Var.F1(bundle);
        ld1Var.B2(this);
        ld1Var.d2(((BuyerOrderActivity) this.mContext).getSupportFragmentManager(), "GoodsPayDialogFragment");
    }

    @Override // ol.c
    public void p(BuyerOrderBean buyerOrderBean) {
        BuyerCommentActivity.R1(this.mContext, buyerOrderBean.getId());
    }

    @Override // ol.c
    public void r(BuyerOrderBean buyerOrderBean) {
        int status = buyerOrderBean.getStatus();
        Context context = this.mContext;
        if (status == 5) {
            BuyerRefundDetailActivity.Z1(context, buyerOrderBean.getId());
        } else {
            BuyerOrderDetailActivity.f2(context, buyerOrderBean.getId());
        }
    }

    @Override // ld1.c
    public void x0(boolean z) {
        if (z) {
            f0();
        }
    }

    @Override // ol.c
    public void z(BuyerOrderBean buyerOrderBean) {
        new a.j(this.mContext).k(aq4.a(m93.e8)).g(true).d(true).h(new b(buyerOrderBean)).c().show();
    }
}
