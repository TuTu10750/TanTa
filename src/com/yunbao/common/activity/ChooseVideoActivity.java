package com.yunbao.common.activity;

import android.content.Intent;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.common.bean.ChooseVideoBean;
import defpackage.aq4;
import defpackage.k30;
import defpackage.m93;
import defpackage.sz;
import defpackage.tz;
import defpackage.u73;
import defpackage.wi4;
import defpackage.y63;
import defpackage.zj2;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class ChooseVideoActivity extends AbsActivity implements sz.b {
    public RecyclerView e;
    public sz f;
    public tz g;
    public boolean h;
    public boolean i;

    /* loaded from: /tmp/classes2.dex */
    public class a extends k30 {
        public a() {
        }

        @Override // defpackage.k30
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(List list) {
            ChooseVideoActivity chooseVideoActivity = ChooseVideoActivity.this;
            if (chooseVideoActivity.b == null || chooseVideoActivity.e == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            if (ChooseVideoActivity.this.h) {
                arrayList.add(new ChooseVideoBean(0, null));
            }
            if (list == null || list.size() <= 0) {
                View findViewById = ChooseVideoActivity.this.findViewById(y63.U);
                if (findViewById != null && findViewById.getVisibility() != 0) {
                    findViewById.setVisibility(0);
                }
            } else {
                arrayList.addAll(list);
            }
            ChooseVideoActivity chooseVideoActivity2 = ChooseVideoActivity.this;
            chooseVideoActivity2.f = new sz(chooseVideoActivity2.b, arrayList);
            ChooseVideoActivity.this.f.P(ChooseVideoActivity.this);
            ChooseVideoActivity.this.e.setAdapter(ChooseVideoActivity.this.f);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements wi4 {
        public b() {
        }

        @Override // defpackage.wi4
        public void a(File file, long j) {
            Intent intent = new Intent();
            intent.putExtra("videoPath", file.getAbsolutePath());
            intent.putExtra("videoDuration", j);
            ChooseVideoActivity.this.setResult(-1, intent);
            ChooseVideoActivity.this.finish();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void A1(String str, long j) {
        Intent intent = new Intent();
        intent.putExtra("videoPath", str);
        intent.putExtra("videoDuration", j);
        setResult(-1, intent);
        finish();
    }

    @Override // sz.b
    public void O(ChooseVideoBean chooseVideoBean) {
        if (this.i) {
            return;
        }
        A1(chooseVideoBean.getVideoFile().getAbsolutePath(), chooseVideoBean.getDuration());
    }

    @Override // sz.b
    public void b() {
        zj2.y(this, new b());
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return u73.c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        Intent intent = getIntent();
        this.h = intent.getBooleanExtra("useCamera", true);
        this.i = intent.getBooleanExtra("usePreview", true);
        t1(aq4.a(m93.ua));
        RecyclerView findViewById = findViewById(y63.Z);
        this.e = findViewById;
        findViewById.setHasFixedSize(true);
        this.e.setLayoutManager(new GridLayoutManager(this.b, 4, 1, false));
        rq1 rq1Var = new rq1(this.b, 0, 5.0f, 5.0f);
        rq1Var.l(true);
        this.e.k(rq1Var);
        tz tzVar = new tz();
        this.g = tzVar;
        tzVar.d(new a());
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        tz tzVar = this.g;
        if (tzVar != null) {
            tzVar.e();
        }
        this.g = null;
        super.onDestroy();
    }
}
