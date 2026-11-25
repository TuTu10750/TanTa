package com.yunbao.main.activity;

import android.content.Intent;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.custom.CommonRefreshView;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.live.bean.LiveBean;
import com.yunbao.main.presenter.CheckLivePresenter;
import defpackage.c73;
import defpackage.ce3;
import defpackage.db2;
import defpackage.et2;
import defpackage.m52;
import defpackage.rv3;
import defpackage.v31;
import defpackage.wa2;
import defpackage.y73;
import java.util.Arrays;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class LiveClassActivity extends AbsActivity implements et2 {
    public int e;
    public CommonRefreshView f;
    public wa2 g;
    public CheckLivePresenter h;
    public String i;

    /* loaded from: /tmp/classes2.dex */
    public class a implements CommonRefreshView.e {
        public a() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public ce3 getAdapter() {
            if (LiveClassActivity.this.g == null) {
                LiveClassActivity liveClassActivity = LiveClassActivity.this;
                liveClassActivity.g = new wa2(liveClassActivity.b);
                LiveClassActivity.this.g.R(LiveClassActivity.this);
            }
            return LiveClassActivity.this.g;
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void loadData(int i, HttpCallback httpCallback) {
            db2.I(LiveClassActivity.this.e, i, httpCallback);
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

    @Override // defpackage.et2
    /* renamed from: A1, reason: merged with bridge method [inline-methods] */
    public void onItemClick(LiveBean liveBean, int i) {
        B1(liveBean, i);
    }

    public void B1(LiveBean liveBean, int i) {
        if (v31.a(true)) {
            if (this.h == null) {
                this.h = new CheckLivePresenter(this.b);
            }
            this.h.watchLive(liveBean);
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return y73.y;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        Intent intent = getIntent();
        int intExtra = intent.getIntExtra("classID", 0);
        this.e = intExtra;
        this.i = rv3.a("liveClass_", String.valueOf(intExtra));
        t1(intent.getStringExtra("className"));
        CommonRefreshView commonRefreshView = (CommonRefreshView) findViewById(c73.r4);
        this.f = commonRefreshView;
        commonRefreshView.setEmptyLayoutId(y73.A1);
        this.f.setLayoutManager(new GridLayoutManager(this.b, 2, 1, false));
        RecyclerView.n rq1Var = new rq1(this.b, 0, 5.0f, 0.0f);
        rq1Var.l(true);
        this.f.setItemDecoration(rq1Var);
        this.f.setDataHelper(new a());
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        m52.c().d(this.i);
        db2.i("getClassLive");
        super.onDestroy();
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onResume() {
        super.onResume();
        CommonRefreshView commonRefreshView = this.f;
        if (commonRefreshView != null) {
            commonRefreshView.k();
        }
    }
}
