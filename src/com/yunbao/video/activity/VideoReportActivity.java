package com.yunbao.video.activity;

import android.text.TextUtils;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.video.bean.VideoReportBean;
import defpackage.aq4;
import defpackage.b83;
import defpackage.f73;
import defpackage.m93;
import defpackage.t54;
import defpackage.uw1;
import defpackage.vi4;
import defpackage.zh4;
import java.util.Arrays;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class VideoReportActivity extends AbsActivity implements vi4.c, uw1.c {
    public String e;
    public RecyclerView f;
    public vi4 g;
    public uw1 h;
    public HttpCallback i = new b();

    /* loaded from: /tmp/classes2.dex */
    public class a extends HttpCallback {
        public a() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i == 0) {
                List parseArray = JSON.parseArray(Arrays.toString(strArr), VideoReportBean.class);
                VideoReportActivity videoReportActivity = VideoReportActivity.this;
                videoReportActivity.g = new vi4(videoReportActivity.b, parseArray);
                VideoReportActivity.this.g.W(VideoReportActivity.this);
                if (VideoReportActivity.this.f != null) {
                    VideoReportActivity.this.f.setAdapter(VideoReportActivity.this.g);
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
                VideoReportActivity.this.onBackPressed();
            }
        }
    }

    private void A1() {
        zh4.a("getVideoReportList");
        zh4.a("videoReport");
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
        zh4.q(this.e, videoReportBean.getId(), name, this.i);
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return b83.e;
    }

    @Override // uw1.c
    public void h(int i) {
        vi4 vi4Var;
        RecyclerView recyclerView = this.f;
        if (recyclerView != null) {
            recyclerView.setTranslationY(-i);
        }
        if (i <= 0 || (vi4Var = this.g) == null) {
            return;
        }
        this.f.E1(vi4Var.j() - 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.S9));
        this.e = getIntent().getStringExtra("videoId");
        RecyclerView findViewById = findViewById(f73.M);
        this.f = findViewById;
        findViewById.setLayoutManager(new LinearLayoutManager(this.b, 1, false));
        this.h = new uw1(this.f, this);
        zh4.l(new a());
    }

    public void onBackPressed() {
        A1();
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        A1();
        super.onDestroy();
    }
}
