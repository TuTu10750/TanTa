package com.yunbao.live.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.alibaba.fastjson.JSON;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.custom.CommonRefreshView;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.common.utils.a;
import com.yunbao.live.bean.LiveShutUpBean;
import defpackage.aq4;
import defpackage.b73;
import defpackage.ce3;
import defpackage.e32;
import defpackage.et2;
import defpackage.l52;
import defpackage.m93;
import defpackage.t54;
import defpackage.x73;
import java.util.Arrays;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class LiveShutUpActivity extends AbsActivity implements et2 {
    public CommonRefreshView e;
    public l52 f;
    public String g;

    /* loaded from: /tmp/classes2.dex */
    public class a implements CommonRefreshView.e {
        public a() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public ce3 getAdapter() {
            if (LiveShutUpActivity.this.f == null) {
                LiveShutUpActivity liveShutUpActivity = LiveShutUpActivity.this;
                liveShutUpActivity.f = new l52(liveShutUpActivity.b);
                LiveShutUpActivity.this.f.R(LiveShutUpActivity.this);
            }
            return LiveShutUpActivity.this.f;
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void loadData(int i, HttpCallback httpCallback) {
            e32.U(LiveShutUpActivity.this.g, i, httpCallback);
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
            return JSON.parseArray(Arrays.toString(strArr), LiveShutUpBean.class);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements a.m {
        public final /* synthetic */ LiveShutUpBean a;

        /* loaded from: /tmp/classes2.dex */
        public class a extends HttpCallback {
            public a() {
            }

            @Override // com.yunbao.common.http.HttpCallback
            public void onSuccess(int i, String str, String[] strArr) {
                if (i == 0 && LiveShutUpActivity.this.f != null) {
                    LiveShutUpActivity.this.f.Y(b.this.a.getUid());
                }
                t54.b(str);
            }
        }

        public b(LiveShutUpBean liveShutUpBean) {
            this.a = liveShutUpBean;
        }

        @Override // com.yunbao.common.utils.a.m
        public void b(Dialog dialog, String str) {
            e32.s0(LiveShutUpActivity.this.g, this.a.getUid(), new a());
        }
    }

    public static void A1(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) LiveShutUpActivity.class);
        intent.putExtra("liveUid", str);
        context.startActivity(intent);
    }

    @Override // defpackage.et2
    /* renamed from: B1, reason: merged with bridge method [inline-methods] */
    public void onItemClick(LiveShutUpBean liveShutUpBean, int i) {
        com.yunbao.common.utils.a.l(this.b, aq4.a(m93.P4), new b(liveShutUpBean));
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return x73.m;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.V4));
        String stringExtra = getIntent().getStringExtra("liveUid");
        this.g = stringExtra;
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        CommonRefreshView commonRefreshView = (CommonRefreshView) findViewById(b73.E4);
        this.e = commonRefreshView;
        commonRefreshView.setEmptyLayoutId(x73.C2);
        this.e.setLayoutManager(new LinearLayoutManager(this.b, 1, false));
        this.e.setDataHelper(new a());
        this.e.k();
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        e32.f("getLiveShutUpList");
        e32.f("LiveCancelShutUp");
        super.onDestroy();
    }
}
