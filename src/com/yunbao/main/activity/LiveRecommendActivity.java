package com.yunbao.main.activity;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.custom.CommonRefreshView;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.live.bean.LiveBean;
import com.yunbao.main.presenter.CheckLivePresenter;
import defpackage.aq4;
import defpackage.c73;
import defpackage.ce3;
import defpackage.db2;
import defpackage.et2;
import defpackage.m52;
import defpackage.m93;
import defpackage.v31;
import defpackage.wa2;
import defpackage.y73;
import java.util.Arrays;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class LiveRecommendActivity extends AbsActivity implements et2 {
    public CommonRefreshView e;
    public wa2 f;
    public CheckLivePresenter g;

    /* loaded from: /tmp/classes2.dex */
    public class a implements CommonRefreshView.e {
        public a() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public ce3 getAdapter() {
            if (LiveRecommendActivity.this.f == null) {
                LiveRecommendActivity liveRecommendActivity = LiveRecommendActivity.this;
                liveRecommendActivity.f = new wa2(liveRecommendActivity.b);
                LiveRecommendActivity.this.f.R(LiveRecommendActivity.this);
            }
            return LiveRecommendActivity.this.f;
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void loadData(int i, HttpCallback httpCallback) {
            db2.X(i, httpCallback);
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
            return JSON.parseArray(Arrays.toString(strArr), LiveBean.class);
        }
    }

    public void A1(LiveBean liveBean, int i) {
        if (v31.a(true)) {
            if (this.g == null) {
                this.g = new CheckLivePresenter(this.b);
            }
            this.g.watchLive(liveBean);
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return y73.y;
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.m5));
        CommonRefreshView commonRefreshView = (CommonRefreshView) findViewById(c73.r4);
        this.e = commonRefreshView;
        commonRefreshView.setEmptyLayoutId(y73.A1);
        this.e.setLayoutManager(new GridLayoutManager(this.b, 2, 1, false));
        RecyclerView.n rq1Var = new rq1(this.b, 0, 5.0f, 0.0f);
        rq1Var.l(true);
        this.e.setItemDecoration(rq1Var);
        this.e.setDataHelper(new a());
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        m52.c().d("liveRecommend");
        db2.i("getClassLive");
        super.onDestroy();
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onResume() {
        super.onResume();
        this.e.k();
    }

    @Override // defpackage.et2
    /* renamed from: z1, reason: merged with bridge method [inline-methods] */
    public void onItemClick(LiveBean liveBean, int i) {
        A1(liveBean, i);
    }
}
