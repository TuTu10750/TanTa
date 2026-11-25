package defpackage;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yunbao.common.custom.CommonRefreshView;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.mall.activity.GoodsDetailActivity;
import com.yunbao.mall.activity.ShopHomeActivity;
import com.yunbao.mall.bean.GoodsSimpleBean;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class xo3 extends k0 implements et2 {
    public CommonRefreshView b;
    public wo3 c;
    public String d;

    /* loaded from: /tmp/classes2.dex */
    public class a implements CommonRefreshView.e {
        public a() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public ce3 getAdapter() {
            return null;
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void loadData(int i, HttpCallback httpCallback) {
            ec2.j0(xo3.this.d, i, httpCallback);
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void onLoadMoreFailure() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void onLoadMoreSuccess(List list, int i) {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void onRefreshFailure() {
            ((ShopHomeActivity) xo3.this.mContext).L1();
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void onRefreshSuccess(List list, int i) {
            ((ShopHomeActivity) xo3.this.mContext).L1();
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public List processData(String[] strArr) {
            JSONObject parseObject = JSON.parseObject(strArr[0]);
            ((ShopHomeActivity) xo3.this.mContext).Q1(parseObject.getJSONObject("shop_info"));
            return JSON.parseArray(parseObject.getString("list"), GoodsSimpleBean.class);
        }
    }

    public xo3(Context context, ViewGroup viewGroup, String str) {
        super(context, viewGroup, str);
    }

    @Override // defpackage.et2
    /* renamed from: f0, reason: merged with bridge method [inline-methods] */
    public void onItemClick(GoodsSimpleBean goodsSimpleBean, int i) {
        GoodsDetailActivity.u2(this.mContext, goodsSimpleBean.getId(), true, goodsSimpleBean.getType());
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return z73.c2;
    }

    @Override // defpackage.b1
    public void init() {
        CommonRefreshView commonRefreshView = (CommonRefreshView) findViewById(d73.C3);
        this.b = commonRefreshView;
        commonRefreshView.setEmptyLayoutId(z73.O1);
        this.b.setLayoutManager(new GridLayoutManager(this.mContext, 2, 1, false));
        RecyclerView.n rq1Var = new rq1(this.mContext, 0, 10.0f, 0.0f);
        rq1Var.l(true);
        this.b.setItemDecoration(rq1Var);
        wo3 wo3Var = new wo3(this.mContext);
        this.c = wo3Var;
        wo3Var.R(this);
        this.b.setRecyclerViewAdapter(this.c);
        this.b.setDataHelper(new a());
    }

    @Override // defpackage.k0
    public void loadData() {
        CommonRefreshView commonRefreshView = this.b;
        if (commonRefreshView != null) {
            commonRefreshView.k();
        }
    }

    @Override // defpackage.b1, defpackage.uy1
    public void onDestroy() {
        ec2.u("getShopHome");
        super.onDestroy();
    }

    @Override // defpackage.b1
    public void processArguments(Object... objArr) {
        if (objArr.length > 0) {
            this.d = (String) objArr[0];
        }
    }
}
