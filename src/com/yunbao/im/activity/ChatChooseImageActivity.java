package com.yunbao.im.activity;

import android.content.Intent;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.common.activity.AbsActivity;
import defpackage.a73;
import defpackage.aq4;
import defpackage.ej1;
import defpackage.k30;
import defpackage.m93;
import defpackage.qz;
import defpackage.t54;
import defpackage.w73;
import java.io.File;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class ChatChooseImageActivity extends AbsActivity implements View.OnClickListener {
    public RecyclerView e;
    public ej1 f;
    public qz g;

    /* loaded from: /tmp/classes2.dex */
    public class a extends k30 {
        public a() {
        }

        @Override // defpackage.k30
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(List list) {
            if (list != null && list.size() != 0) {
                ChatChooseImageActivity chatChooseImageActivity = ChatChooseImageActivity.this;
                chatChooseImageActivity.f = new ej1(chatChooseImageActivity.b, list);
                ChatChooseImageActivity.this.e.setAdapter(ChatChooseImageActivity.this.f);
            } else {
                View findViewById = ChatChooseImageActivity.this.findViewById(a73.W);
                if (findViewById.getVisibility() != 0) {
                    findViewById.setVisibility(0);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void A1() {
        ej1 ej1Var = this.f;
        if (ej1Var == null) {
            t54.b(aq4.a(m93.B2));
            return;
        }
        File a0 = ej1Var.a0();
        if (a0 == null || !a0.exists()) {
            t54.b(aq4.a(m93.C2));
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("selectedImagePath", a0.getAbsolutePath());
        setResult(-1, intent);
        finish();
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return w73.a;
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        findViewById(a73.i).setOnClickListener(this);
        findViewById(a73.y).setOnClickListener(this);
        RecyclerView findViewById = findViewById(a73.Y);
        this.e = findViewById;
        findViewById.setHasFixedSize(true);
        this.e.setLayoutManager(new GridLayoutManager(this.b, 4, 1, false));
        rq1 rq1Var = new rq1(this.b, 0, 1.0f, 1.0f);
        rq1Var.l(true);
        this.e.k(rq1Var);
        qz qzVar = new qz();
        this.g = qzVar;
        qzVar.d(new a());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == a73.i) {
            onBackPressed();
        } else if (id == a73.y) {
            A1();
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        this.g.e();
        super.onDestroy();
    }
}
