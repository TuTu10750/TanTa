package com.yunbao.common.activity;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.common.bean.ChooseImageBean;
import defpackage.an1;
import defpackage.k30;
import defpackage.pz;
import defpackage.qz;
import defpackage.rv3;
import defpackage.u73;
import defpackage.y63;
import defpackage.zj2;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class ChooseImageActivity extends AbsActivity implements pz.b, View.OnClickListener {
    public RecyclerView e;
    public pz f;
    public qz g;
    public View h;
    public TextView i;
    public TextView j;
    public int k;

    /* loaded from: /tmp/classes2.dex */
    public class a extends k30 {
        public a() {
        }

        @Override // defpackage.k30
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(List list) {
            ChooseImageActivity chooseImageActivity = ChooseImageActivity.this;
            if (chooseImageActivity.b == null || chooseImageActivity.e == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(new ChooseImageBean(0, null));
            if (list == null || list.size() <= 0) {
                View findViewById = ChooseImageActivity.this.findViewById(y63.U);
                if (findViewById != null && findViewById.getVisibility() != 0) {
                    findViewById.setVisibility(0);
                }
            } else {
                arrayList.addAll(list);
            }
            ChooseImageActivity chooseImageActivity2 = ChooseImageActivity.this;
            chooseImageActivity2.f = new pz(chooseImageActivity2.b, arrayList, chooseImageActivity2.k);
            ChooseImageActivity.this.f.U(ChooseImageActivity.this);
            ChooseImageActivity.this.e.setAdapter(ChooseImageActivity.this.f);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements an1 {
        public b() {
        }

        @Override // defpackage.an1
        public void a(File file) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(file.getAbsolutePath());
            Intent intent = new Intent();
            intent.putStringArrayListExtra("chooseImage", arrayList);
            ChooseImageActivity.this.setResult(-1, intent);
            ChooseImageActivity.this.finish();
        }

        @Override // defpackage.an1
        public void b() {
        }

        @Override // defpackage.an1
        public void c() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void A1() {
        ArrayList<String> T;
        pz pzVar = this.f;
        if (pzVar == null || (T = pzVar.T()) == null || T.size() == 0) {
            return;
        }
        Intent intent = new Intent();
        intent.putStringArrayListExtra("chooseImage", T);
        setResult(-1, intent);
        finish();
    }

    @Override // pz.b
    public void b() {
        zj2.l(this, new b());
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return u73.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        this.k = getIntent().getIntExtra("maxCount", 9);
        View findViewById = findViewById(y63.m);
        this.h = findViewById;
        findViewById.setOnClickListener(this);
        this.h.setClickable(false);
        this.i = (TextView) findViewById(y63.B);
        this.j = (TextView) findViewById(y63.z);
        RecyclerView findViewById2 = findViewById(y63.Z);
        this.e = findViewById2;
        findViewById2.setHasFixedSize(true);
        this.e.setLayoutManager(new GridLayoutManager(this.b, 4, 1, false));
        rq1 rq1Var = new rq1(this.b, 0, 5.0f, 5.0f);
        rq1Var.l(true);
        this.e.k(rq1Var);
        qz qzVar = new qz();
        this.g = qzVar;
        qzVar.d(new a());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == y63.m) {
            A1();
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        qz qzVar = this.g;
        if (qzVar != null) {
            qzVar.e();
        }
        this.g = null;
        super.onDestroy();
    }

    @Override // pz.b
    public void t0(int i) {
        TextView textView = this.j;
        if (i == 0) {
            if (textView.getVisibility() == 0) {
                this.j.setVisibility(8);
            }
            this.i.setTextColor(-6908266);
            this.h.setClickable(false);
            return;
        }
        if (textView.getVisibility() != 0) {
            this.j.setVisibility(0);
        }
        this.j.setText(rv3.a("(", String.valueOf(i), "/", String.valueOf(this.k), ")"));
        this.i.setTextColor(-13421773);
        this.h.setClickable(true);
    }
}
