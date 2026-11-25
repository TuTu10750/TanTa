package defpackage;

import android.app.Dialog;
import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.alibaba.fastjson.JSON;
import com.yunbao.common.custom.CommonRefreshView;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.common.utils.a;
import com.yunbao.mall.activity.GoodsAddOutSideActivity;
import com.yunbao.mall.activity.GoodsDetailActivity;
import com.yunbao.mall.activity.SellerAddGoodsActivity;
import com.yunbao.mall.activity.SellerManageGoodsActivity;
import com.yunbao.mall.bean.GoodsManageBean;
import defpackage.rm3;
import java.util.Arrays;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class sm3 extends k0 implements rm3.e {
    public CommonRefreshView b;
    public rm3 c;

    /* loaded from: /tmp/classes2.dex */
    public class a implements CommonRefreshView.e {
        public a() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public ce3 getAdapter() {
            if (sm3.this.c == null) {
                sm3 sm3Var = sm3.this;
                sm3Var.c = new rm3(sm3Var.mContext);
                sm3.this.c.a0(sm3.this);
            }
            return sm3.this.c;
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void loadData(int i, HttpCallback httpCallback) {
            ec2.Q("remove_shelves", i, httpCallback);
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
            return JSON.parseArray(Arrays.toString(strArr), GoodsManageBean.class);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements a.m {
        public final /* synthetic */ GoodsManageBean a;

        /* loaded from: /tmp/classes2.dex */
        public class a extends HttpCallback {
            public a() {
            }

            @Override // com.yunbao.common.http.HttpCallback
            public void onSuccess(int i, String str, String[] strArr) {
                if (i != 0) {
                    t54.b(str);
                    return;
                }
                if (sm3.this.b != null) {
                    sm3.this.b.k();
                }
                ((SellerManageGoodsActivity) sm3.this.mContext).R1();
            }
        }

        public b(GoodsManageBean goodsManageBean) {
            this.a = goodsManageBean;
        }

        @Override // com.yunbao.common.utils.a.m
        public void b(Dialog dialog, String str) {
            ec2.o0(this.a.getId(), new a());
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c implements a.m {
        public final /* synthetic */ GoodsManageBean a;

        /* loaded from: /tmp/classes2.dex */
        public class a extends HttpCallback {
            public a() {
            }

            @Override // com.yunbao.common.http.HttpCallback
            public void onSuccess(int i, String str, String[] strArr) {
                if (i != 0) {
                    t54.b(str);
                    return;
                }
                if (sm3.this.b != null) {
                    sm3.this.b.k();
                }
                ((SellerManageGoodsActivity) sm3.this.mContext).R1();
            }
        }

        public c(GoodsManageBean goodsManageBean) {
            this.a = goodsManageBean;
        }

        @Override // com.yunbao.common.utils.a.m
        public void b(Dialog dialog, String str) {
            ec2.q0(this.a.getId(), 1, new a());
        }
    }

    public sm3(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    @Override // rm3.e
    public void G(GoodsManageBean goodsManageBean) {
        new a.j(this.mContext).k(aq4.a(m93.o8)).g(true).d(true).h(new c(goodsManageBean)).c().show();
    }

    @Override // rm3.e
    public void a(GoodsManageBean goodsManageBean) {
        GoodsDetailActivity.t2(this.mContext, goodsManageBean.getId(), goodsManageBean.getType());
    }

    @Override // rm3.e
    public void d(GoodsManageBean goodsManageBean) {
        int type = goodsManageBean.getType();
        Context context = this.mContext;
        if (type == 1) {
            GoodsAddOutSideActivity.L1(context, goodsManageBean.getId());
        } else {
            SellerAddGoodsActivity.b2(context, goodsManageBean.getId());
        }
    }

    @Override // rm3.e
    public void f(GoodsManageBean goodsManageBean) {
        new a.j(this.mContext).k(aq4.a(m93.p8)).g(true).d(true).h(new b(goodsManageBean)).c().show();
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return z73.Z1;
    }

    @Override // defpackage.b1
    public void init() {
        CommonRefreshView commonRefreshView = (CommonRefreshView) findViewById(d73.C3);
        this.b = commonRefreshView;
        commonRefreshView.setEmptyLayoutId(z73.N1);
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
}
