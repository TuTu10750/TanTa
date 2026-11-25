package com.yunbao.main.activity;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.video.bean.VideoReportBean;
import defpackage.aq4;
import defpackage.c73;
import defpackage.db2;
import defpackage.m93;
import defpackage.t54;
import defpackage.uw1;
import defpackage.vi4;
import defpackage.x73;
import java.util.Arrays;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class ActiveReportActivity extends AbsActivity implements vi4.c, uw1.c {
    public String e;
    public RecyclerView f;
    public vi4 g;
    public uw1 h;

    /* loaded from: /tmp/classes2.dex */
    public class a extends HttpCallback {
        public a() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i == 0) {
                List parseArray = JSON.parseArray(Arrays.toString(strArr), VideoReportBean.class);
                ActiveReportActivity activeReportActivity = ActiveReportActivity.this;
                activeReportActivity.g = new vi4(activeReportActivity.b, parseArray);
                ActiveReportActivity.this.g.W(ActiveReportActivity.this);
                if (ActiveReportActivity.this.f != null) {
                    ActiveReportActivity.this.f.setAdapter(ActiveReportActivity.this.g);
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
                ActiveReportActivity.this.finish();
            }
        }
    }

    public static void A1(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) ActiveReportActivity.class);
        intent.putExtra("videoId", str);
        context.startActivity(intent);
    }

    private void B1() {
        db2.i("getActiveReportList");
        db2.i("activeReport");
        uw1 uw1Var = this.h;
        if (uw1Var != null) {
            uw1Var.i();
        }
        this.h = null;
        vi4 vi4Var = this.g;
        if (vi4Var != null) {
            vi4Var.W(null);
        }
        this.g = null;
    }

    @Override // vi4.c
    public void N0(VideoReportBean videoReportBean, String str) {
        if (TextUtils.isEmpty(this.e)) {
            return;
        }
        if (videoReportBean == null) {
            t54.a(m93.Aa);
            return;
        }
        String name = videoReportBean.getName();
        if (!TextUtils.isEmpty(str)) {
            name = name + " " + str;
        }
        db2.g(this.e, name, new b());
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return x73.i;
    }

    @Override // uw1.c
    public void h(int i) {
        vi4 vi4Var;
        RecyclerView recyclerView = this.f;
        if (recyclerView != null) {
            recyclerView.setTranslationY(-i);
            if (i <= 0 || (vi4Var = this.g) == null || vi4Var.j() < 9) {
                return;
            }
            this.f.E1(this.g.j() - 1);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.S9));
        this.e = getIntent().getStringExtra("videoId");
        RecyclerView findViewById = findViewById(c73.h4);
        this.f = findViewById;
        findViewById.setLayoutManager(new LinearLayoutManager(this.b, 1, false));
        this.h = new uw1(this.f, this);
        db2.C(new a());
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
