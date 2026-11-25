package com.yunbao.mall.activity;

import android.app.Dialog;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import cn.qqtheme.framework.entity.City;
import cn.qqtheme.framework.entity.County;
import cn.qqtheme.framework.entity.Province;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.http.HttpCallback;
import defpackage.aq4;
import defpackage.d73;
import defpackage.ec2;
import defpackage.g00;
import defpackage.j30;
import defpackage.k30;
import defpackage.m93;
import defpackage.rv3;
import defpackage.t54;
import defpackage.z73;
import java.util.ArrayList;

/* loaded from: /tmp/classes2.dex */
public class SellerAddressEditActivity extends AbsActivity implements View.OnClickListener {
    public EditText e;
    public EditText f;
    public TextView g;
    public EditText h;
    public String i;
    public String j;
    public String k;

    /* loaded from: /tmp/classes2.dex */
    public class a extends k30 {
        public final /* synthetic */ Dialog a;

        public a(Dialog dialog) {
            this.a = dialog;
        }

        @Override // defpackage.k30
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ArrayList arrayList) {
            this.a.dismiss();
            if (arrayList != null) {
                SellerAddressEditActivity.this.C1(arrayList);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements e {
        public b() {
        }

        public void a(Province province, City city, County county) {
            String areaName = province.getAreaName();
            String areaName2 = city.getAreaName();
            String areaName3 = county.getAreaName();
            SellerAddressEditActivity.this.i = areaName;
            SellerAddressEditActivity.this.j = areaName2;
            SellerAddressEditActivity.this.k = areaName3;
            SellerAddressEditActivity.this.g.setText(rv3.a(areaName, " ", areaName2, " ", areaName3));
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends HttpCallback {
        public c() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i == 0) {
                SellerAddressEditActivity.this.setResult(-1);
                SellerAddressEditActivity.this.finish();
            }
            t54.b(str);
        }
    }

    private void B1() {
        ArrayList e = g00.g().e();
        if (e != null && e.size() != 0) {
            C1(e);
            return;
        }
        Dialog c2 = com.yunbao.common.utils.a.c(this.b);
        c2.show();
        g00.g().f(new a(c2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void C1(ArrayList arrayList) {
        com.yunbao.common.utils.a.g(this, arrayList, j30.q().z(), j30.q().f(), j30.q().k(), new b());
    }

    private void D1() {
        String trim = this.e.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            t54.a(m93.q6);
            return;
        }
        String trim2 = this.f.getText().toString().trim();
        if (TextUtils.isEmpty(trim2)) {
            t54.a(m93.r6);
            return;
        }
        if (TextUtils.isEmpty(this.g.getText().toString().trim())) {
            t54.a(m93.s6);
            return;
        }
        String trim3 = this.h.getText().toString().trim();
        if (TextUtils.isEmpty(trim3)) {
            t54.a(m93.t6);
        } else {
            ec2.r0(trim, trim2, this.i, this.j, this.k, trim3, new c());
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return z73.L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.p6));
        this.e = (EditText) findViewById(d73.I3);
        this.f = (EditText) findViewById(d73.J3);
        this.g = (TextView) findViewById(d73.F3);
        this.h = (EditText) findViewById(d73.E3);
        findViewById(d73.X0).setOnClickListener(this);
        findViewById(d73.n1).setOnClickListener(this);
        Intent intent = getIntent();
        this.e.setText(intent.getStringExtra("mallRefundName"));
        this.f.setText(intent.getStringExtra("mallRefundPhone"));
        this.h.setText(intent.getStringExtra("mallRefundAddress"));
        this.i = intent.getStringExtra("mallRefundProvince");
        this.j = intent.getStringExtra("mallRefundCity");
        String stringExtra = intent.getStringExtra("mallRefundZone");
        this.k = stringExtra;
        this.g.setText(rv3.a(this.i, " ", this.j, " ", stringExtra));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == d73.X0) {
            B1();
        } else if (id == d73.n1) {
            D1();
        }
    }
}
