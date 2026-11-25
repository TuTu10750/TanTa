package com.yunbao.main.activity;

import android.content.Context;
import android.content.Intent;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.alibaba.fastjson.JSON;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.custom.CommonRefreshView;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.main.bean.ActiveBean;
import defpackage.c73;
import defpackage.ce3;
import defpackage.d4;
import defpackage.db2;
import defpackage.e4;
import defpackage.i4;
import defpackage.pw3;
import defpackage.q41;
import defpackage.y73;
import defpackage.z3;
import defpackage.zu0;
import java.util.Arrays;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: /tmp/classes2.dex */
public class ActiveTopicActivity extends AbsActivity {
    public String e;
    public CommonRefreshView f;
    public z3 g;

    /* loaded from: /tmp/classes2.dex */
    public class a implements CommonRefreshView.e {
        public a() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public ce3 getAdapter() {
            if (ActiveTopicActivity.this.g == null) {
                ActiveTopicActivity activeTopicActivity = ActiveTopicActivity.this;
                activeTopicActivity.g = new z3(activeTopicActivity.b);
            }
            return ActiveTopicActivity.this.g;
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void loadData(int i, HttpCallback httpCallback) {
            db2.c0(ActiveTopicActivity.this.e, i, httpCallback);
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
            return JSON.parseArray(Arrays.toString(strArr), ActiveBean.class);
        }
    }

    public static void A1(Context context, String str, String str2) {
        Intent intent = new Intent(context, (Class<?>) ActiveTopicActivity.class);
        intent.putExtra("classID", str);
        intent.putExtra("className", str2);
        context.startActivity(intent);
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return y73.e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        Intent intent = getIntent();
        t1(intent.getStringExtra("className"));
        this.e = intent.getStringExtra("classID");
        CommonRefreshView commonRefreshView = (CommonRefreshView) findViewById(c73.r4);
        this.f = commonRefreshView;
        commonRefreshView.setEmptyLayoutId(y73.t1);
        this.f.setLayoutManager(new LinearLayoutManager(this.b, 1, false));
        this.f.setDataHelper(new a());
        zu0.c().n(this);
        this.f.k();
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onActiveCommentEvent(d4 d4Var) {
        z3 z3Var = this.g;
        if (z3Var == null || d4Var == null) {
            return;
        }
        z3Var.P0(d4Var.a(), d4Var.b());
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onActiveDeleted(e4 e4Var) {
        z3 z3Var = this.g;
        if (z3Var == null || e4Var == null) {
            return;
        }
        z3Var.O0(e4Var.a());
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onActiveLikeEvent(i4 i4Var) {
        z3 z3Var = this.g;
        if (z3Var == null || i4Var == null) {
            return;
        }
        z3Var.R0(i4Var.b(), i4Var.a(), i4Var.d(), i4Var.c());
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        zu0.c().p(this);
        z3 z3Var = this.g;
        if (z3Var != null) {
            z3Var.T0();
        }
        db2.i("getTopicActiveList");
        super.onDestroy();
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onFollowEvent(q41 q41Var) {
        z3 z3Var = this.g;
        if (z3Var == null || q41Var == null) {
            return;
        }
        z3Var.Q0(q41Var.b(), q41Var.a());
    }
}
