package com.yunbao.main.activity;

import android.content.Context;
import android.content.Intent;
import androidx.recyclerview.widget.LinearLayoutManager;
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
import defpackage.m93;
import defpackage.t62;
import defpackage.v31;
import defpackage.y73;
import java.util.Arrays;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class LiveVoiceRoomListActivity extends AbsActivity implements et2 {
    public CommonRefreshView e;
    public t62 f;
    public CheckLivePresenter g;

    /* loaded from: /tmp/classes2.dex */
    public class a implements CommonRefreshView.e {
        public a() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public ce3 getAdapter() {
            if (LiveVoiceRoomListActivity.this.f == null) {
                LiveVoiceRoomListActivity liveVoiceRoomListActivity = LiveVoiceRoomListActivity.this;
                liveVoiceRoomListActivity.f = new t62(liveVoiceRoomListActivity.b);
                LiveVoiceRoomListActivity.this.f.R(LiveVoiceRoomListActivity.this);
            }
            return LiveVoiceRoomListActivity.this.f;
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void loadData(int i, HttpCallback httpCallback) {
            db2.e0(i, httpCallback);
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

    public static void z1(Context context) {
        context.startActivity(new Intent(context, (Class<?>) LiveVoiceRoomListActivity.class));
    }

    @Override // defpackage.et2
    /* renamed from: A1, reason: merged with bridge method [inline-methods] */
    public void onItemClick(LiveBean liveBean, int i) {
        B1(liveBean, i);
    }

    public void B1(LiveBean liveBean, int i) {
        if (v31.a(true)) {
            if (this.g == null) {
                this.g = new CheckLivePresenter(this.b);
            }
            this.g.watchLive(liveBean);
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return y73.B;
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.I));
        CommonRefreshView commonRefreshView = (CommonRefreshView) findViewById(c73.r4);
        this.e = commonRefreshView;
        commonRefreshView.setLayoutManager(new LinearLayoutManager(this.b, 1, false));
        this.e.setDataHelper(new a());
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        db2.i("getVoiceRoomList");
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
