package com.yunbao.main.activity;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.alibaba.fastjson.JSON;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.custom.CommonRefreshView;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.live.bean.SearchUserBean;
import defpackage.aq4;
import defpackage.c73;
import defpackage.ce3;
import defpackage.db2;
import defpackage.et2;
import defpackage.j30;
import defpackage.m93;
import defpackage.ok3;
import defpackage.pi3;
import defpackage.pw3;
import defpackage.q41;
import defpackage.y73;
import defpackage.zu0;
import java.util.Arrays;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: /tmp/classes2.dex */
public class FollowActivity extends AbsActivity implements et2 {
    public CommonRefreshView e;
    public ok3 f;
    public String g;

    /* loaded from: /tmp/classes2.dex */
    public class a implements CommonRefreshView.e {
        public a() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public ce3 getAdapter() {
            if (FollowActivity.this.f == null) {
                FollowActivity followActivity = FollowActivity.this;
                followActivity.f = new ok3(followActivity.b, 1002);
                FollowActivity.this.f.R(FollowActivity.this);
            }
            return FollowActivity.this.f;
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void loadData(int i, HttpCallback httpCallback) {
            db2.Q(FollowActivity.this.g, i, httpCallback);
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
            return JSON.parseArray(Arrays.toString(strArr), SearchUserBean.class);
        }
    }

    public static void A1(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) FollowActivity.class);
        intent.putExtra("toUid", str);
        context.startActivity(intent);
    }

    @Override // defpackage.et2
    /* renamed from: B1, reason: merged with bridge method [inline-methods] */
    public void onItemClick(SearchUserBean searchUserBean, int i) {
        pi3.q(this.b, searchUserBean.getId());
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return y73.x;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.M1));
        String stringExtra = getIntent().getStringExtra("toUid");
        this.g = stringExtra;
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        this.e = (CommonRefreshView) findViewById(c73.r4);
        boolean equals = this.g.equals(j30.q().C());
        CommonRefreshView commonRefreshView = this.e;
        if (equals) {
            commonRefreshView.setEmptyLayoutId(y73.y1);
        } else {
            commonRefreshView.setEmptyLayoutId(y73.z1);
        }
        this.e.setLayoutManager(new LinearLayoutManager(this.b, 1, false));
        this.e.setDataHelper(new a());
        zu0.c().n(this);
        this.e.k();
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        zu0.c().p(this);
        db2.i("getFollowList");
        super.onDestroy();
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onFollowEvent(q41 q41Var) {
        ok3 ok3Var = this.f;
        if (ok3Var != null) {
            ok3Var.e0(q41Var.b(), q41Var.a());
        }
    }
}
