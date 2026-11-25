package defpackage;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yunbao.common.activity.WebViewActivity;
import com.yunbao.common.custom.CommonRefreshView;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.common.utils.a;
import com.yunbao.im.activity.ChatRoomActivity;
import com.yunbao.im.bean.ImConUserBean;
import com.yunbao.mall.activity.SellerOrderActivity;
import com.yunbao.mall.activity.SellerOrderDetailActivity;
import com.yunbao.mall.activity.SellerRefundDetailActivity;
import com.yunbao.mall.activity.SellerSendActivity;
import com.yunbao.mall.bean.SellerOrderBean;
import defpackage.am3;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public abstract class a1 extends k0 implements am3.b {
    public CommonRefreshView b;
    public am3 c;
    public String d;

    /* loaded from: /tmp/classes2.dex */
    public class a implements CommonRefreshView.e {
        public a() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public ce3 getAdapter() {
            if (a1.this.c == null) {
                a1 a1Var = a1.this;
                a1Var.c = a1Var.j0();
                a1.this.c.W(a1.this);
            }
            return a1.this.c;
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void loadData(int i, HttpCallback httpCallback) {
            ec2.g0(a1.this.i0(), i, httpCallback);
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
            if (TextUtils.isEmpty(a1.this.d) || a1.this.mContext == null) {
                return;
            }
            ((SellerOrderActivity) a1.this.mContext).R1(a1.this.d);
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public List processData(String[] strArr) {
            JSONObject parseObject = JSON.parseObject(strArr[0]);
            a1.this.d = parseObject.getString("type_list_nums");
            return JSON.parseArray(parseObject.getString("list"), SellerOrderBean.class);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements a.m {
        public final /* synthetic */ SellerOrderBean a;

        /* loaded from: /tmp/classes2.dex */
        public class a extends HttpCallback {
            public a() {
            }

            @Override // com.yunbao.common.http.HttpCallback
            public void onSuccess(int i, String str, String[] strArr) {
                if (i == 0) {
                    a1.this.k0();
                }
                t54.b(str);
            }
        }

        public b(SellerOrderBean sellerOrderBean) {
            this.a = sellerOrderBean;
        }

        @Override // com.yunbao.common.utils.a.m
        public void b(Dialog dialog, String str) {
            ec2.w0(this.a.getId(), new a());
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends HttpCallback {
        public c() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            ImConUserBean imConUserBean;
            if (i != 0 || strArr.length <= 0 || (imConUserBean = (ImConUserBean) JSON.parseObject(strArr[0], ImConUserBean.class)) == null) {
                return;
            }
            ChatRoomActivity.A1(a1.this.mContext, imConUserBean, imConUserBean.getAttent() == 1, false);
        }
    }

    public a1(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    @Override // am3.b
    public void B(SellerOrderBean sellerOrderBean) {
        xj1.g(sellerOrderBean.getUid(), new c());
    }

    @Override // am3.b
    public void E(SellerOrderBean sellerOrderBean) {
        SellerRefundDetailActivity.V1(this.mContext, sellerOrderBean.getId());
    }

    @Override // am3.b
    public void O(SellerOrderBean sellerOrderBean) {
        new a.j(this.mContext).k(aq4.a(m93.d8)).g(true).d(true).h(new b(sellerOrderBean)).c().show();
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return z73.b2;
    }

    public abstract String i0();

    @Override // defpackage.b1
    public void init() {
        CommonRefreshView commonRefreshView = (CommonRefreshView) findViewById(d73.C3);
        this.b = commonRefreshView;
        commonRefreshView.setEmptyLayoutId(z73.I1);
        this.b.setLayoutManager(new LinearLayoutManager(this.mContext, 1, false));
        this.b.setDataHelper(new a());
    }

    public abstract am3 j0();

    public void k0() {
        CommonRefreshView commonRefreshView = this.b;
        if (commonRefreshView != null) {
            commonRefreshView.k();
        }
    }

    @Override // am3.b
    public void l(SellerOrderBean sellerOrderBean) {
        WebViewActivity.E1(this.mContext, rv3.a(wg1.q, "orderid=", sellerOrderBean.getId(), "&user_type=seller"));
    }

    @Override // defpackage.k0
    public void loadData() {
        CommonRefreshView commonRefreshView = this.b;
        if (commonRefreshView != null) {
            commonRefreshView.k();
        }
    }

    @Override // am3.b
    public void m(SellerOrderBean sellerOrderBean) {
        SellerSendActivity.T1(this.mContext, sellerOrderBean.getId());
    }

    @Override // am3.b
    public void x(SellerOrderBean sellerOrderBean) {
        int status = sellerOrderBean.getStatus();
        Context context = this.mContext;
        if (status == 5) {
            SellerRefundDetailActivity.V1(context, sellerOrderBean.getId());
        } else {
            SellerOrderDetailActivity.Z1(context, sellerOrderBean.getId());
        }
    }
}
