package com.yunbao.main.activity;

import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.common.utils.a;
import com.yunbao.main.bean.CashAccountBean;
import defpackage.aq4;
import defpackage.ax;
import defpackage.bx;
import defpackage.c73;
import defpackage.db2;
import defpackage.m93;
import defpackage.t54;
import defpackage.y73;
import java.util.Arrays;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class CashActivity extends AbsActivity implements View.OnClickListener, ax.c {
    public bx e;
    public View f;
    public RecyclerView g;
    public ax h;
    public String i;

    /* loaded from: /tmp/classes2.dex */
    public class a extends HttpCallback {
        public a() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i == 0) {
                List parseArray = JSON.parseArray(Arrays.toString(strArr), CashAccountBean.class);
                int size = parseArray.size();
                CashActivity cashActivity = CashActivity.this;
                if (size > 0) {
                    if (cashActivity.f.getVisibility() == 0) {
                        CashActivity.this.f.setVisibility(4);
                    }
                    CashActivity.this.h.V(parseArray);
                } else if (cashActivity.f.getVisibility() != 0) {
                    CashActivity.this.f.setVisibility(0);
                }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements a.m {
        public final /* synthetic */ CashAccountBean a;
        public final /* synthetic */ int b;

        /* loaded from: /tmp/classes2.dex */
        public class a extends HttpCallback {
            public a() {
            }

            @Override // com.yunbao.common.http.HttpCallback
            public void onSuccess(int i, String str, String[] strArr) {
                if (i == 0 && CashActivity.this.h != null) {
                    CashActivity.this.h.T(b.this.b);
                    if (CashActivity.this.h.j() == 0 && CashActivity.this.f.getVisibility() != 0) {
                        CashActivity.this.f.setVisibility(0);
                    }
                }
                t54.b(str);
            }
        }

        public b(CashAccountBean cashAccountBean, int i) {
            this.a = cashAccountBean;
            this.b = i;
        }

        @Override // com.yunbao.common.utils.a.m
        public void b(Dialog dialog, String str) {
            db2.p(this.a.getId(), new a());
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return y73.j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        String stringExtra = getIntent().getStringExtra("cashAccountID");
        this.i = stringExtra;
        if (stringExtra == null) {
            this.i = "";
        }
        findViewById(c73.F).setOnClickListener(this);
        this.f = findViewById(c73.Q3);
        RecyclerView findViewById = findViewById(c73.h4);
        this.g = findViewById;
        findViewById.setHasFixedSize(true);
        this.g.setLayoutManager(new LinearLayoutManager(this.b, 1, false));
        ax axVar = new ax(this.b, this.i);
        this.h = axVar;
        axVar.U(this);
        this.g.setAdapter(this.h);
        z1();
    }

    public void onBackPressed() {
        bx bxVar = this.e;
        if (bxVar == null || !bxVar.isShowed()) {
            super/*androidx.activity.ComponentActivity*/.onBackPressed();
        } else {
            this.e.removeFromParent();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == c73.F) {
            y1();
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        db2.i("GetUserAccountList");
        db2.i("addCashAccount");
        db2.i("deleteCashAccount");
        super.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ax.c
    public void x(CashAccountBean cashAccountBean, int i) {
        Intent intent = new Intent();
        intent.putExtra("cashAccountID", cashAccountBean.getId());
        intent.putExtra("cashAccount", cashAccountBean.getAccount());
        intent.putExtra("cashAccountType", String.valueOf(cashAccountBean.getType()));
        intent.putExtra("cashAccountName", cashAccountBean.getUserName());
        setResult(-1, intent);
        finish();
    }

    @Override // ax.c
    public void y(CashAccountBean cashAccountBean, int i) {
        com.yunbao.common.utils.a.i(this.b, aq4.a(m93.Z0), new b(cashAccountBean, i));
    }

    public final void y1() {
        if (this.e == null) {
            this.e = new bx(this.b, (ViewGroup) findViewById(c73.u4));
        }
        this.e.addToParent();
    }

    public void z1() {
        db2.H(new a());
    }
}
