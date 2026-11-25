package com.yunbao.mall.activity;

import androidx.recyclerview.widget.LinearLayoutManager;
import com.alibaba.fastjson.JSON;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.custom.CommonRefreshView;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.mall.bean.OrderMsgBean;
import defpackage.aq4;
import defpackage.ce3;
import defpackage.d73;
import defpackage.ec2;
import defpackage.m93;
import defpackage.ou2;
import defpackage.z73;
import java.util.Arrays;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class OrderMessageActivity extends AbsActivity {
    public CommonRefreshView e;
    public ou2 f;

    /* loaded from: /tmp/classes2.dex */
    public class a implements CommonRefreshView.e {
        public a() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public ce3 getAdapter() {
            if (OrderMessageActivity.this.f == null) {
                OrderMessageActivity orderMessageActivity = OrderMessageActivity.this;
                orderMessageActivity.f = new ou2(orderMessageActivity.b);
            }
            return OrderMessageActivity.this.f;
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void loadData(int i, HttpCallback httpCallback) {
            ec2.U(i, httpCallback);
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
            return JSON.parseArray(Arrays.toString(strArr), OrderMsgBean.class);
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return z73.z;
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.b8));
        CommonRefreshView commonRefreshView = (CommonRefreshView) findViewById(d73.C3);
        this.e = commonRefreshView;
        commonRefreshView.setLayoutManager(new LinearLayoutManager(this.b, 1, false));
        this.e.setDataHelper(new a());
        this.e.k();
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        ec2.u("getOrderMsgList");
        super.onDestroy();
    }
}
