package com.yunbao.im.activity;

import android.content.Context;
import android.content.Intent;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.alibaba.fastjson.JSON;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.custom.CommonRefreshView;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.im.bean.VideoImConcatBean;
import defpackage.a73;
import defpackage.aq4;
import defpackage.ce3;
import defpackage.fk1;
import defpackage.m93;
import defpackage.pw3;
import defpackage.q41;
import defpackage.w73;
import defpackage.xj1;
import defpackage.zu0;
import java.util.Arrays;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: /tmp/classes2.dex */
public class ImMsgConcatActivity extends AbsActivity {
    public CommonRefreshView e;
    public fk1 f;

    /* loaded from: /tmp/classes2.dex */
    public class a implements CommonRefreshView.e {
        public a() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public ce3 getAdapter() {
            if (ImMsgConcatActivity.this.f == null) {
                ImMsgConcatActivity imMsgConcatActivity = ImMsgConcatActivity.this;
                imMsgConcatActivity.f = new fk1(imMsgConcatActivity.b);
            }
            return ImMsgConcatActivity.this.f;
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void loadData(int i, HttpCallback httpCallback) {
            xj1.d(i, httpCallback);
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
            return JSON.parseArray(Arrays.toString(strArr), VideoImConcatBean.class);
        }
    }

    public static void z1(Context context) {
        context.startActivity(new Intent(context, (Class<?>) ImMsgConcatActivity.class));
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return w73.d;
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.S));
        CommonRefreshView commonRefreshView = (CommonRefreshView) findViewById(a73.e0);
        this.e = commonRefreshView;
        commonRefreshView.setLayoutManager(new LinearLayoutManager(this.b, 1, false));
        this.e.setDataHelper(new a());
        zu0.c().n(this);
        this.e.k();
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        zu0.c().p(this);
        xj1.a("getImConcatList");
        super.onDestroy();
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onFollowEvent(q41 q41Var) {
        fk1 fk1Var = this.f;
        if (fk1Var != null) {
            fk1Var.c0(q41Var.b(), q41Var.a());
        }
    }
}
