package com.yunbao.mall.activity;

import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import cn.qqtheme.framework.entity.City;
import cn.qqtheme.framework.entity.County;
import cn.qqtheme.framework.entity.Province;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.common.utils.a;
import com.yunbao.mall.bean.BuyerAddressBean;
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
public class BuyerAddressEditActivity extends AbsActivity implements View.OnClickListener {
    public BuyerAddressBean e;
    public EditText f;
    public EditText g;
    public TextView h;
    public EditText i;
    public CheckBox j;
    public View k;
    public String l;
    public String m;
    public String n;

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
                BuyerAddressEditActivity.this.G1(arrayList);
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
            BuyerAddressEditActivity.this.l = areaName;
            BuyerAddressEditActivity.this.m = areaName2;
            BuyerAddressEditActivity.this.n = areaName3;
            BuyerAddressEditActivity.this.h.setText(rv3.a(areaName, " ", areaName2, " ", areaName3));
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends HttpCallback {
        public c() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i == 0) {
                BuyerAddressEditActivity.this.setResult(-1);
                BuyerAddressEditActivity.this.finish();
            }
            t54.b(str);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d extends HttpCallback {
        public d() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i == 0) {
                BuyerAddressEditActivity.this.setResult(-1);
                BuyerAddressEditActivity.this.finish();
            }
            t54.b(str);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e implements a.m {

        /* loaded from: /tmp/classes2.dex */
        public class a extends HttpCallback {
            public a() {
            }

            @Override // com.yunbao.common.http.HttpCallback
            public void onSuccess(int i, String str, String[] strArr) {
                if (i == 0) {
                    BuyerAddressEditActivity.this.setResult(-1);
                    BuyerAddressEditActivity.this.finish();
                }
                t54.b(str);
            }
        }

        public e() {
        }

        @Override // com.yunbao.common.utils.a.m
        public void b(Dialog dialog, String str) {
            ec2.o(BuyerAddressEditActivity.this.e.getId(), new a());
        }
    }

    private void D1() {
        ArrayList e2 = g00.g().e();
        if (e2 != null && e2.size() != 0) {
            G1(e2);
            return;
        }
        Dialog c2 = com.yunbao.common.utils.a.c(this.b);
        c2.show();
        g00.g().f(new a(c2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void G1(ArrayList arrayList) {
        com.yunbao.common.utils.a.g(this, arrayList, j30.q().z(), j30.q().f(), j30.q().k(), new b());
    }

    public final void C1() {
        String trim = this.f.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            t54.a(m93.q6);
            return;
        }
        String trim2 = this.g.getText().toString().trim();
        if (TextUtils.isEmpty(trim2)) {
            t54.a(m93.r6);
            return;
        }
        if (TextUtils.isEmpty(this.h.getText().toString().trim())) {
            t54.a(m93.s6);
            return;
        }
        String trim3 = this.i.getText().toString().trim();
        if (TextUtils.isEmpty(trim3)) {
            t54.a(m93.t6);
        } else {
            ec2.e(trim, trim2, this.l, this.m, this.n, trim3, this.j.isChecked() ? SdkVersion.MINI_VERSION : "0", new c());
        }
    }

    public final void E1() {
        if (this.e == null) {
            return;
        }
        new a.j(this.b).k(aq4.a(m93.w6)).g(true).d(true).h(new e()).c().show();
    }

    public final void F1() {
        if (this.e == null) {
            return;
        }
        String trim = this.f.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            t54.a(m93.q6);
            return;
        }
        String trim2 = this.g.getText().toString().trim();
        if (TextUtils.isEmpty(trim2)) {
            t54.a(m93.r6);
            return;
        }
        if (TextUtils.isEmpty(this.h.getText().toString().trim())) {
            t54.a(m93.s6);
            return;
        }
        String trim3 = this.i.getText().toString().trim();
        if (TextUtils.isEmpty(trim3)) {
            t54.a(m93.t6);
        } else {
            ec2.r(trim, trim2, this.l, this.m, this.n, trim3, this.j.isChecked() ? SdkVersion.MINI_VERSION : "0", this.e.getId(), new d());
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return z73.d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        this.f = (EditText) findViewById(d73.R2);
        this.g = (EditText) findViewById(d73.h3);
        this.h = (TextView) findViewById(d73.j);
        this.i = (EditText) findViewById(d73.d);
        this.j = (CheckBox) findViewById(d73.y1);
        this.k = findViewById(d73.i0);
        findViewById(d73.n1).setOnClickListener(this);
        findViewById(d73.D).setOnClickListener(this);
        BuyerAddressBean buyerAddressBean = (BuyerAddressBean) getIntent().getParcelableExtra("mallBuyerAddress");
        if (buyerAddressBean == null) {
            t1(aq4.a(m93.v6));
            return;
        }
        t1(aq4.a(m93.v6));
        this.e = buyerAddressBean;
        this.f.setText(buyerAddressBean.getName());
        this.g.setText(buyerAddressBean.getPhoneNum());
        this.l = buyerAddressBean.getProvince();
        this.m = buyerAddressBean.getCity();
        String zone = buyerAddressBean.getZone();
        this.n = zone;
        this.h.setText(rv3.a(this.l, " ", this.m, " ", zone));
        this.i.setText(buyerAddressBean.getAddress());
        this.j.setChecked(buyerAddressBean.getIsDefault() == 1);
        this.k.setVisibility(0);
        this.k.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == d73.n1) {
            if (this.e != null) {
                F1();
                return;
            } else {
                C1();
                return;
            }
        }
        if (id == d73.D) {
            D1();
        } else if (id == d73.i0) {
            E1();
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        ec2.u("buyerAddAddress");
        ec2.u("buyerDeleteAddress");
        ec2.u("buyerModifyAddress");
        super.onDestroy();
    }
}
