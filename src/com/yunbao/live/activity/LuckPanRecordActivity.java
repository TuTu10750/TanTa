package com.yunbao.live.activity;

import android.app.Dialog;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.custom.CommonRefreshView;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.common.utils.a;
import com.yunbao.live.bean.LuckPanBean;
import defpackage.aq4;
import defpackage.b73;
import defpackage.ce3;
import defpackage.e32;
import defpackage.m93;
import defpackage.mu1;
import defpackage.q92;
import defpackage.x73;
import java.util.Arrays;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class LuckPanRecordActivity extends AbsActivity implements View.OnClickListener {
    public CommonRefreshView e;
    public q92 f;

    /* loaded from: /tmp/classes2.dex */
    public class a implements CommonRefreshView.e {
        public a() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public ce3 getAdapter() {
            if (LuckPanRecordActivity.this.f == null) {
                LuckPanRecordActivity luckPanRecordActivity = LuckPanRecordActivity.this;
                luckPanRecordActivity.f = new q92(luckPanRecordActivity.b, false);
            }
            return LuckPanRecordActivity.this.f;
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void loadData(int i, HttpCallback httpCallback) {
            e32.f0(0, i, httpCallback);
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
            return mu1.a(Arrays.toString(strArr), LuckPanBean.class);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements a.m {

        /* loaded from: /tmp/classes2.dex */
        public class a extends HttpCallback {
            public a() {
            }

            @Override // com.yunbao.common.http.HttpCallback
            public void onSuccess(int i, String str, String[] strArr) {
                if (i != 0 || LuckPanRecordActivity.this.e == null) {
                    return;
                }
                LuckPanRecordActivity.this.e.k();
            }
        }

        public b() {
        }

        @Override // com.yunbao.common.utils.a.m
        public void b(Dialog dialog, String str) {
            e32.m(new a());
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return x73.j;
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.U8));
        findViewById(b73.G).setOnClickListener(this);
        CommonRefreshView commonRefreshView = (CommonRefreshView) findViewById(b73.E4);
        this.e = commonRefreshView;
        commonRefreshView.setLayoutManager(new LinearLayoutManager(this.b, 1, false));
        this.e.setDataHelper(new a());
        this.e.k();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q92 q92Var = this.f;
        if (q92Var == null || q92Var.j() == 0) {
            return;
        }
        new a.j(this.b).k(aq4.a(m93.d0)).g(true).o(true).d(true).h(new b()).c().show();
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        e32.f("Turntable.GetWin");
        e32.f("clearTurnRecord");
        super.onDestroy();
    }
}
