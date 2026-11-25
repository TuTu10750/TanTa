package com.yunbao.live.activity;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.alibaba.fastjson.JSON;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.custom.CommonRefreshView;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.live.bean.GuardUserBean;
import defpackage.aq4;
import defpackage.b73;
import defpackage.ce1;
import defpackage.ce3;
import defpackage.e32;
import defpackage.j30;
import defpackage.m93;
import defpackage.x73;
import java.util.Arrays;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class LiveGuardListActivity extends AbsActivity {
    public CommonRefreshView e;
    public ce1 f;
    public String g;

    /* loaded from: /tmp/classes2.dex */
    public class a implements CommonRefreshView.e {
        public a() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public ce3 getAdapter() {
            if (LiveGuardListActivity.this.f == null) {
                LiveGuardListActivity liveGuardListActivity = LiveGuardListActivity.this;
                liveGuardListActivity.f = new ce1(liveGuardListActivity.b, false);
            }
            return LiveGuardListActivity.this.f;
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void loadData(int i, HttpCallback httpCallback) {
            e32.K(LiveGuardListActivity.this.g, i, httpCallback);
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
            return JSON.parseArray(Arrays.toString(strArr), GuardUserBean.class);
        }
    }

    public static void A1(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) LiveGuardListActivity.class);
        intent.putExtra("toUid", str);
        context.startActivity(intent);
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return x73.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.i2));
        String stringExtra = getIntent().getStringExtra("toUid");
        this.g = stringExtra;
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        this.e = (CommonRefreshView) findViewById(b73.E4);
        this.e.setEmptyLayoutId(this.g.equals(j30.q().C()) ? x73.u2 : x73.w2);
        this.e.setLayoutManager(new LinearLayoutManager(this.b, 1, false));
        this.e.setDataHelper(new a());
        this.e.k();
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        e32.f("getGuardList");
        super.onDestroy();
    }
}
