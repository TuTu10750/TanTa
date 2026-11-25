package com.yunbao.mall.activity;

import android.app.Dialog;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.alibaba.fastjson.JSON;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.bean.GoodsBean;
import com.yunbao.common.custom.CommonRefreshView;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.common.utils.a;
import defpackage.aq4;
import defpackage.ce3;
import defpackage.d73;
import defpackage.ec2;
import defpackage.fd1;
import defpackage.m93;
import defpackage.t54;
import defpackage.z73;
import java.util.Arrays;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class GoodsCollectActivity extends AbsActivity implements View.OnClickListener {
    public CommonRefreshView e;
    public fd1 f;
    public TextView g;
    public boolean h;

    /* loaded from: /tmp/classes2.dex */
    public class a implements CommonRefreshView.e {
        public a() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public ce3 getAdapter() {
            if (GoodsCollectActivity.this.f == null) {
                GoodsCollectActivity goodsCollectActivity = GoodsCollectActivity.this;
                goodsCollectActivity.f = new fd1(goodsCollectActivity.b);
            }
            return GoodsCollectActivity.this.f;
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void loadData(int i, HttpCallback httpCallback) {
            ec2.L(i, httpCallback);
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
            return JSON.parseArray(Arrays.toString(strArr), GoodsBean.class);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements a.l {

        /* loaded from: /tmp/classes2.dex */
        public class a extends HttpCallback {
            public a() {
            }

            @Override // com.yunbao.common.http.HttpCallback
            public void onSuccess(int i, String str, String[] strArr) {
                if (i == 0 && GoodsCollectActivity.this.e != null) {
                    GoodsCollectActivity.this.e.k();
                }
                t54.b(str);
            }
        }

        public b() {
        }

        @Override // com.yunbao.common.utils.a.l
        public void a() {
            GoodsCollectActivity.this.f.m0(false);
            GoodsCollectActivity.this.A1(false);
        }

        @Override // com.yunbao.common.utils.a.m
        public void b(Dialog dialog, String str) {
            GoodsCollectActivity.this.A1(false);
            ec2.x(GoodsCollectActivity.this.f.k0(), new a());
        }
    }

    public void A1(boolean z) {
        this.h = z;
        TextView textView = this.g;
        if (textView != null) {
            textView.setText(z ? m93.z1 : m93.E8);
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return z73.o;
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.s8));
        TextView textView = (TextView) findViewById(d73.K0);
        this.g = textView;
        textView.setOnClickListener(this);
        CommonRefreshView commonRefreshView = (CommonRefreshView) findViewById(d73.C3);
        this.e = commonRefreshView;
        commonRefreshView.setEmptyLayoutId(z73.K1);
        this.e.setLayoutManager(new LinearLayoutManager(this.b, 1, false));
        this.e.setDataHelper(new a());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        fd1 fd1Var = this.f;
        if (fd1Var != null) {
            if (this.h) {
                new a.j(this.b).k(aq4.a(m93.Q)).g(true).o(true).d(true).h(new b()).c().show();
            } else {
                fd1Var.n0();
            }
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        ec2.u("getGoodsCollect");
        ec2.u("deleteGoodsCollect");
        super.onDestroy();
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onResume() {
        super.onResume();
        CommonRefreshView commonRefreshView = this.e;
        if (commonRefreshView != null) {
            commonRefreshView.k();
        }
    }
}
