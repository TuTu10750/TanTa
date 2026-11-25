package com.yunbao.mall.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.alibaba.fastjson.JSON;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.custom.CommonRefreshView;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.mall.bean.BuyerAddressBean;
import defpackage.aq4;
import defpackage.ce3;
import defpackage.d73;
import defpackage.ec2;
import defpackage.ll;
import defpackage.m93;
import defpackage.z73;
import java.util.Arrays;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class BuyerAddressActivity extends AbsActivity implements View.OnClickListener, ll.c {
    public CommonRefreshView e;
    public ll f;
    public boolean g;

    /* loaded from: /tmp/classes2.dex */
    public class a implements CommonRefreshView.e {
        public a() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public ce3 getAdapter() {
            if (BuyerAddressActivity.this.f == null) {
                BuyerAddressActivity buyerAddressActivity = BuyerAddressActivity.this;
                buyerAddressActivity.f = new ll(buyerAddressActivity.b);
                BuyerAddressActivity.this.f.V(BuyerAddressActivity.this);
            }
            return BuyerAddressActivity.this.f;
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void loadData(int i, HttpCallback httpCallback) {
            ec2.D(httpCallback);
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
            return JSON.parseArray(Arrays.toString(strArr), BuyerAddressBean.class);
        }
    }

    public static void z1(Context context) {
        context.startActivity(new Intent(context, (Class<?>) BuyerAddressActivity.class));
    }

    public final void A1(BuyerAddressBean buyerAddressBean) {
        Intent intent = new Intent(this.b, (Class<?>) BuyerAddressEditActivity.class);
        if (buyerAddressBean != null) {
            intent.putExtra("mallBuyerAddress", buyerAddressBean);
        }
        startActivityForResult(intent, 100);
    }

    @Override // ll.c
    public void S(BuyerAddressBean buyerAddressBean) {
        A1(buyerAddressBean);
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return z73.c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.u6));
        this.g = getIntent().getBooleanExtra("mallBuyerAddress", false);
        findViewById(d73.r).setOnClickListener(this);
        CommonRefreshView commonRefreshView = (CommonRefreshView) findViewById(d73.C3);
        this.e = commonRefreshView;
        commonRefreshView.setEmptyLayoutId(z73.H1);
        this.e.setLayoutManager(new LinearLayoutManager(this.b, 1, false));
        this.e.setDataHelper(new a());
        this.e.k();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        CommonRefreshView commonRefreshView;
        super/*androidx.fragment.app.FragmentActivity*/.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 100 && (commonRefreshView = this.e) != null) {
            commonRefreshView.k();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        A1(null);
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        ec2.u("getBuyerAddress");
        super.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ll.c
    public void u0(BuyerAddressBean buyerAddressBean) {
        if (!this.g) {
            A1(buyerAddressBean);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("mallBuyerAddress", buyerAddressBean);
        setResult(-1, intent);
        finish();
    }
}
