package com.yunbao.main.activity;

import android.content.Context;
import android.content.Intent;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.bean.LiveClassBean;
import com.yunbao.common.custom.CommonRefreshView;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.live.bean.LiveBean;
import com.yunbao.main.presenter.CheckLivePresenter;
import defpackage.aq4;
import defpackage.c73;
import defpackage.ce3;
import defpackage.db2;
import defpackage.et2;
import defpackage.lb2;
import defpackage.m93;
import defpackage.v31;
import defpackage.wa2;
import defpackage.y73;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class LiveFollowActivity extends AbsActivity implements et2 {
    public CommonRefreshView e;
    public wa2 f;
    public int g;
    public CheckLivePresenter h;

    /* loaded from: /tmp/classes2.dex */
    public class a implements et2 {
        public a() {
        }

        @Override // defpackage.et2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onItemClick(LiveClassBean liveClassBean, int i) {
            LiveFollowActivity.this.g = liveClassBean.getId();
            if (LiveFollowActivity.this.e != null) {
                LiveFollowActivity.this.e.k();
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements CommonRefreshView.e {
        public b() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public ce3 getAdapter() {
            if (LiveFollowActivity.this.f == null) {
                LiveFollowActivity liveFollowActivity = LiveFollowActivity.this;
                liveFollowActivity.f = new wa2(liveFollowActivity.b);
                LiveFollowActivity.this.f.R(LiveFollowActivity.this);
            }
            return LiveFollowActivity.this.f;
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void loadData(int i, HttpCallback httpCallback) {
            db2.P(i, LiveFollowActivity.this.g, httpCallback);
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
            return JSON.parseArray(JSON.parseObject(strArr[0]).getString("list"), LiveBean.class);
        }
    }

    public static void C1(Context context) {
        context.startActivity(new Intent(context, (Class<?>) LiveFollowActivity.class));
    }

    @Override // defpackage.et2
    /* renamed from: D1, reason: merged with bridge method [inline-methods] */
    public void onItemClick(LiveBean liveBean, int i) {
        if (v31.a(true)) {
            if (this.h == null) {
                this.h = new CheckLivePresenter(this.b);
            }
            this.h.watchLive(liveBean);
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return y73.z;
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.e0));
        RecyclerView findViewById = findViewById(c73.k4);
        findViewById.setHasFixedSize(true);
        findViewById.setLayoutManager(new LinearLayoutManager(this.b, 0, false));
        lb2 lb2Var = new lb2(this.b);
        lb2Var.R(new a());
        findViewById.setAdapter(lb2Var);
        CommonRefreshView commonRefreshView = (CommonRefreshView) findViewById(c73.r4);
        this.e = commonRefreshView;
        commonRefreshView.setEmptyLayoutId(y73.B1);
        this.e.setLayoutManager(new GridLayoutManager(this.b, 2, 1, false));
        RecyclerView.n rq1Var = new rq1(this.b, 0, 5.0f, 0.0f);
        rq1Var.l(true);
        this.e.setItemDecoration(rq1Var);
        this.e.setDataHelper(new b());
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        db2.i("getFollow");
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
