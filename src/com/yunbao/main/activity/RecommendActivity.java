package com.yunbao.main.activity;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.main.bean.RecommendBean;
import defpackage.a82;
import defpackage.c73;
import defpackage.cc3;
import defpackage.db2;
import defpackage.y73;
import defpackage.zu0;
import java.util.Arrays;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class RecommendActivity extends AbsActivity implements View.OnClickListener {
    public RecyclerView e;
    public cc3 f;
    public boolean g;

    /* loaded from: /tmp/classes2.dex */
    public class a extends HttpCallback {
        public a() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i == 0) {
                List parseArray = JSON.parseArray(Arrays.toString(strArr), RecommendBean.class);
                if (RecommendActivity.this.f == null) {
                    RecommendActivity recommendActivity = RecommendActivity.this;
                    recommendActivity.f = new cc3(recommendActivity.b, parseArray);
                    RecommendActivity.this.e.setAdapter(RecommendActivity.this.f);
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
            if (i == 0) {
                RecommendActivity.this.D1();
            }
        }
    }

    public static void C1(Context context, boolean z) {
        Intent intent = new Intent(context, (Class<?>) RecommendActivity.class);
        intent.putExtra("firstLogin", z);
        context.startActivity(intent);
    }

    public final void B1() {
        cc3 cc3Var = this.f;
        if (cc3Var == null) {
            D1();
            return;
        }
        String Q = cc3Var.Q();
        if (TextUtils.isEmpty(Q)) {
            D1();
        } else {
            db2.m0(Q, new b());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void D1() {
        zu0.c().j(new a82(true, this.g));
        finish();
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return y73.N;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        this.g = getIntent().getBooleanExtra("firstLogin", false);
        findViewById(c73.i0).setOnClickListener(this);
        findViewById(c73.i1).setOnClickListener(this);
        RecyclerView findViewById = findViewById(c73.h4);
        this.e = findViewById;
        findViewById.setHasFixedSize(true);
        this.e.setLayoutManager(new GridLayoutManager(this.b, 3, 1, false));
        db2.W(new a());
    }

    public void onBackPressed() {
        D1();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == c73.i0) {
            B1();
        } else if (id == c73.i1) {
            D1();
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        db2.i("getRecommend");
        db2.i("recommendFollow");
        super.onDestroy();
    }
}
