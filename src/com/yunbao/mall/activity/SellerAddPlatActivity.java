package com.yunbao.mall.activity;

import android.content.Context;
import android.content.Intent;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.custom.CommonRefreshView;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.mall.bean.GoodsPlatBean;
import defpackage.ao3;
import defpackage.aq4;
import defpackage.ce3;
import defpackage.d73;
import defpackage.ec2;
import defpackage.m93;
import defpackage.pw3;
import defpackage.ul3;
import defpackage.z73;
import defpackage.zu0;
import java.util.Arrays;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: /tmp/classes2.dex */
public class SellerAddPlatActivity extends AbsActivity {
    public CommonRefreshView e;
    public ul3 f;

    /* loaded from: /tmp/classes2.dex */
    public class a implements CommonRefreshView.e {
        public a() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public ce3 getAdapter() {
            if (SellerAddPlatActivity.this.f == null) {
                SellerAddPlatActivity sellerAddPlatActivity = SellerAddPlatActivity.this;
                sellerAddPlatActivity.f = new ul3(sellerAddPlatActivity.b);
            }
            return SellerAddPlatActivity.this.f;
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void loadData(int i, HttpCallback httpCallback) {
            ec2.y(i, httpCallback);
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void onLoadMoreFailure() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void onLoadMoreSuccess(List list, int i) {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void onRefreshFailure() {
            ((ShopHomeActivity) SellerAddPlatActivity.this.b).L1();
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void onRefreshSuccess(List list, int i) {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public List processData(String[] strArr) {
            return JSON.parseArray(Arrays.toString(strArr), GoodsPlatBean.class);
        }
    }

    public static void A1(Context context) {
        context.startActivity(new Intent(context, (Class<?>) SellerAddPlatActivity.class));
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return z73.J;
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.z8));
        CommonRefreshView commonRefreshView = (CommonRefreshView) findViewById(d73.C3);
        this.e = commonRefreshView;
        commonRefreshView.setEmptyLayoutId(z73.M1);
        this.e.setLayoutManager(new GridLayoutManager(this.b, 2, 1, false));
        RecyclerView.n rq1Var = new rq1(this.b, 0, 10.0f, 0.0f);
        rq1Var.l(true);
        this.e.setItemDecoration(rq1Var);
        this.e.setDataHelper(new a());
        zu0.c().n(this);
        this.e.k();
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        zu0.c().p(this);
        ec2.u("getAddPlatGoods");
        ec2.u("setPlatGoods");
        super.onDestroy();
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onSetPlatGoodsEvent(ao3 ao3Var) {
        ul3 ul3Var = this.f;
        if (ul3Var != null) {
            ul3Var.h0(ao3Var.a(), ao3Var.b());
        }
    }
}
