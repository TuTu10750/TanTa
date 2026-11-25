package com.yunbao.live.activity;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.live.bean.LiveReportBean;
import defpackage.aq4;
import defpackage.b73;
import defpackage.e32;
import defpackage.m93;
import defpackage.t54;
import defpackage.uw1;
import defpackage.x73;
import defpackage.z42;
import java.util.Arrays;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class LiveReportActivity extends AbsActivity implements z42.c, uw1.c {
    public String e;
    public String f;
    public RecyclerView g;
    public z42 h;
    public uw1 i;
    public HttpCallback j = new b();

    /* loaded from: /tmp/classes2.dex */
    public class a extends HttpCallback {
        public a() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i == 0) {
                List parseArray = JSON.parseArray(Arrays.toString(strArr), LiveReportBean.class);
                LiveReportActivity liveReportActivity = LiveReportActivity.this;
                liveReportActivity.h = new z42(liveReportActivity.b, parseArray);
                LiveReportActivity.this.h.W(LiveReportActivity.this);
                if (LiveReportActivity.this.g != null) {
                    LiveReportActivity.this.g.setAdapter(LiveReportActivity.this.h);
                }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends HttpCallback {
        public b() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0) {
                t54.b(str);
            } else {
                t54.a(m93.Ba);
                LiveReportActivity.this.onBackPressed();
            }
        }
    }

    public static void A1(Context context, String str, String str2) {
        Intent intent = new Intent(context, (Class<?>) LiveReportActivity.class);
        intent.putExtra("toUid", str);
        intent.putExtra("toSource", str2);
        context.startActivity(intent);
    }

    private void B1() {
        e32.f("getLiveReportList");
        e32.f("setReport");
        uw1 uw1Var = this.i;
        if (uw1Var != null) {
            uw1Var.i();
        }
        this.i = null;
        z42 z42Var = this.h;
        if (z42Var != null) {
            z42Var.W(null);
        }
        this.h = null;
    }

    @Override // z42.c
    public void U(LiveReportBean liveReportBean, String str) {
        if (TextUtils.isEmpty(this.e)) {
            return;
        }
        if (liveReportBean == null) {
            t54.a(m93.Aa);
            return;
        }
        String name = liveReportBean.getName();
        if (!TextUtils.isEmpty(str)) {
            name = name + " " + str;
        }
        e32.G0(this.e, name, this.f, this.j);
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return x73.i;
    }

    @Override // uw1.c
    public void h(int i) {
        z42 z42Var;
        RecyclerView recyclerView = this.g;
        if (recyclerView != null) {
            recyclerView.setTranslationY(-i);
            if (i <= 0 || (z42Var = this.h) == null) {
                return;
            }
            this.g.E1(z42Var.j() - 1);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.S9));
        this.e = getIntent().getStringExtra("toUid");
        this.f = getIntent().getStringExtra("toSource");
        RecyclerView findViewById = findViewById(b73.B4);
        this.g = findViewById;
        findViewById.setLayoutManager(new LinearLayoutManager(this.b, 1, false));
        this.i = new uw1(this.g, this);
        e32.S(new a());
    }

    public void onBackPressed() {
        B1();
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        B1();
        super.onDestroy();
    }
}
