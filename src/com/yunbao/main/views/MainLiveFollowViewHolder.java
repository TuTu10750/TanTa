package com.yunbao.main.views;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import com.alibaba.fastjson.JSON;
import com.yunbao.common.custom.CommonRefreshView;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.live.bean.LiveBean;
import com.yunbao.main.presenter.CheckLivePresenter;
import defpackage.b1;
import defpackage.c73;
import defpackage.ce3;
import defpackage.db2;
import defpackage.et2;
import defpackage.ud1;
import defpackage.v0;
import defpackage.v31;
import defpackage.xa2;
import defpackage.y73;
import defpackage.zn0;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class MainLiveFollowViewHolder extends v0 implements et2 {
    private xa2 mAdapter;
    private CheckLivePresenter mCheckLivePresenter;
    private int mLiveClassId;
    private CommonRefreshView mRefreshView;

    public MainLiveFollowViewHolder(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
        this.mLiveClassId = 0;
    }

    private void ensureCheckLivePresenter() {
        if (this.mCheckLivePresenter == null) {
            this.mCheckLivePresenter = new CheckLivePresenter(this.mContext);
        }
    }

    private void watchFollowLive(LiveBean liveBean, int i) {
        this.mCheckLivePresenter.watchLive(liveBean);
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return y73.A;
    }

    @Override // defpackage.b1
    public void init() {
        CommonRefreshView commonRefreshView = (CommonRefreshView) findViewById(c73.r4);
        this.mRefreshView = commonRefreshView;
        commonRefreshView.setEmptyLayoutId(y73.B1);
        this.mRefreshView.setLayoutManager(new GridLayoutManager(this.mContext, 3, 1, false));
        new rq1(this.mContext, 0, 5.0f, 0.0f).l(true);
        this.mRefreshView.setItemDecoration(new ud1(3, zn0.a(6), false));
        this.mRefreshView.setDataHelper(new CommonRefreshView.e() { // from class: com.yunbao.main.views.MainLiveFollowViewHolder.1
            @Override // com.yunbao.common.custom.CommonRefreshView.e
            public ce3 getAdapter() {
                if (MainLiveFollowViewHolder.this.mAdapter == null) {
                    MainLiveFollowViewHolder mainLiveFollowViewHolder = MainLiveFollowViewHolder.this;
                    mainLiveFollowViewHolder.mAdapter = new xa2(((b1) mainLiveFollowViewHolder).mContext, new ArrayList());
                    MainLiveFollowViewHolder.this.mAdapter.R(MainLiveFollowViewHolder.this);
                }
                return MainLiveFollowViewHolder.this.mAdapter;
            }

            @Override // com.yunbao.common.custom.CommonRefreshView.e
            public void loadData(int i, HttpCallback httpCallback) {
                db2.P(i, MainLiveFollowViewHolder.this.mLiveClassId, httpCallback);
            }

            @Override // com.yunbao.common.custom.CommonRefreshView.e
            public void onLoadMoreFailure() {
            }

            @Override // com.yunbao.common.custom.CommonRefreshView.e
            public void onLoadMoreSuccess(List<LiveBean> list, int i) {
            }

            @Override // com.yunbao.common.custom.CommonRefreshView.e
            public void onRefreshFailure() {
            }

            @Override // com.yunbao.common.custom.CommonRefreshView.e
            public void onRefreshSuccess(List<LiveBean> list, int i) {
            }

            @Override // com.yunbao.common.custom.CommonRefreshView.e
            public List<LiveBean> processData(String[] strArr) {
                return JSON.parseArray(JSON.parseObject(strArr[0]).getString("list"), LiveBean.class);
            }
        });
    }

    @Override // defpackage.y0
    public void loadData() {
        CommonRefreshView commonRefreshView = this.mRefreshView;
        if (commonRefreshView != null) {
            commonRefreshView.k();
        }
    }

    @Override // defpackage.b1, defpackage.uy1
    public void onDestroy() {
        db2.i("getFollow");
        super.onDestroy();
    }

    @Override // defpackage.et2
    public void onItemClick(LiveBean liveBean, int i) {
        if (v31.a(true)) {
            ensureCheckLivePresenter();
            watchFollowLive(liveBean, i);
        }
    }

    @Override // defpackage.b1, defpackage.uy1
    public void onResume() {
        super.onResume();
        CommonRefreshView commonRefreshView = this.mRefreshView;
        if (commonRefreshView != null) {
            commonRefreshView.k();
        }
    }
}
