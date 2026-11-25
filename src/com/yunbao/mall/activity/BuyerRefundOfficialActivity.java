package com.yunbao.mall.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.fastjson.JSON;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.common.upload.UploadBean;
import com.yunbao.common.utils.a;
import com.yunbao.mall.bean.RefundReasonBean;
import defpackage.an1;
import defpackage.aq4;
import defpackage.d73;
import defpackage.ec2;
import defpackage.fs2;
import defpackage.k30;
import defpackage.kn1;
import defpackage.m93;
import defpackage.pd4;
import defpackage.qd4;
import defpackage.rd4;
import defpackage.rv3;
import defpackage.t54;
import defpackage.z73;
import defpackage.zj2;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class BuyerRefundOfficialActivity extends AbsActivity implements View.OnClickListener {
    public String e;
    public TextView f;
    public EditText g;
    public TextView h;
    public ImageView i;
    public View j;
    public File k;
    public Dialog l;
    public List m;
    public String n;
    public an1 o = new a();

    /* loaded from: /tmp/classes2.dex */
    public class a implements an1 {
        public a() {
        }

        @Override // defpackage.an1
        public void a(File file) {
            if (file == null || !file.exists()) {
                t54.a(m93.K1);
                return;
            }
            BuyerRefundOfficialActivity.this.k = file;
            if (BuyerRefundOfficialActivity.this.i != null) {
                kn1.e(BuyerRefundOfficialActivity.this.b, file, BuyerRefundOfficialActivity.this.i);
            }
            if (BuyerRefundOfficialActivity.this.j == null || BuyerRefundOfficialActivity.this.j.getVisibility() == 0) {
                return;
            }
            BuyerRefundOfficialActivity.this.j.setVisibility(0);
        }

        @Override // defpackage.an1
        public void b() {
        }

        @Override // defpackage.an1
        public void c() {
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (BuyerRefundOfficialActivity.this.h != null) {
                BuyerRefundOfficialActivity.this.h.setText(rv3.a(String.valueOf(charSequence.length()), "/300"));
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c implements a.n {
        public c() {
        }

        @Override // com.yunbao.common.utils.a.n
        public void a(String str, int i) {
            if (i == m93.R0) {
                BuyerRefundOfficialActivity buyerRefundOfficialActivity = BuyerRefundOfficialActivity.this;
                zj2.n(buyerRefundOfficialActivity, false, buyerRefundOfficialActivity.o);
            } else if (i == m93.K0) {
                BuyerRefundOfficialActivity buyerRefundOfficialActivity2 = BuyerRefundOfficialActivity.this;
                zj2.k(buyerRefundOfficialActivity2, false, buyerRefundOfficialActivity2.o);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d extends HttpCallback {
        public d() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i == 0) {
                BuyerRefundOfficialActivity.this.m = JSON.parseArray(Arrays.toString(strArr), RefundReasonBean.class);
                BuyerRefundOfficialActivity.this.O1();
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e extends HttpCallback {
        public e() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i == 0) {
                BuyerRefundOfficialActivity.this.setResult(-1);
                BuyerRefundOfficialActivity.this.finish();
            }
            t54.b(str);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class f extends k30 {
        public final /* synthetic */ List a;

        /* loaded from: /tmp/classes2.dex */
        public class a implements pd4 {
            public a() {
            }

            @Override // defpackage.pd4
            public void a(List list, boolean z) {
                BuyerRefundOfficialActivity.this.L1();
                if (!z) {
                    BuyerRefundOfficialActivity.this.J1(null);
                } else {
                    BuyerRefundOfficialActivity.this.J1(((UploadBean) list.get(0)).getRemoteFileName());
                }
            }
        }

        public f(List list) {
            this.a = list;
        }

        @Override // defpackage.k30
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(qd4 qd4Var) {
            qd4Var.a(this.a, true, new a());
        }
    }

    private void G1() {
        if (this.k != null) {
            return;
        }
        com.yunbao.common.utils.a.r(this.b, new Integer[]{Integer.valueOf(m93.K0), Integer.valueOf(m93.R0)}, new c());
    }

    public static void K1(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) BuyerRefundOfficialActivity.class);
        intent.putExtra("mallOrderId", str);
        ((Activity) context).startActivityForResult(intent, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L1() {
        Dialog dialog = this.l;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.l.dismiss();
    }

    private void N1() {
        if (this.l == null) {
            this.l = com.yunbao.common.utils.a.d(this.b, aq4.a(m93.ya));
        }
        if (this.l.isShowing()) {
            return;
        }
        this.l.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O1() {
        fs2 fs2Var = new fs2();
        fs2Var.r2(this.m);
        fs2Var.d2(getSupportFragmentManager(), "OfficialRefundReasonDialogFragment");
    }

    private void P1() {
        if (TextUtils.isEmpty(this.n)) {
            t54.a(m93.o7);
            return;
        }
        File file = this.k;
        if (file == null || !file.exists()) {
            J1(null);
        } else {
            Q1();
        }
    }

    private void Q1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new UploadBean(this.k, 0));
        N1();
        rd4.d(new f(arrayList));
    }

    public final void H1() {
        if (this.m == null) {
            ec2.T(new d());
        } else {
            O1();
        }
    }

    public final void I1() {
        this.k = null;
        ImageView imageView = this.i;
        if (imageView != null) {
            imageView.setImageDrawable(null);
        }
        View view = this.j;
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        this.j.setVisibility(4);
    }

    public final void J1(String str) {
        ec2.h(this.e, this.n, this.g.getText().toString().trim(), str, new e());
    }

    public void M1(RefundReasonBean refundReasonBean) {
        this.n = refundReasonBean.getId();
        TextView textView = this.f;
        if (textView != null) {
            textView.setText(refundReasonBean.getName());
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return z73.l;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.q7));
        this.e = getIntent().getStringExtra("mallOrderId");
        this.f = (TextView) findViewById(d73.t3);
        this.g = (EditText) findViewById(d73.R1);
        this.h = (TextView) findViewById(d73.F1);
        this.g.addTextChangedListener(new b());
        this.h = (TextView) findViewById(d73.F1);
        this.i = (ImageView) findViewById(d73.x2);
        this.j = findViewById(d73.i0);
        findViewById(d73.R0).setOnClickListener(this);
        findViewById(d73.n1).setOnClickListener(this);
        findViewById(d73.t).setOnClickListener(this);
        this.j.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == d73.R0) {
            H1();
            return;
        }
        if (id == d73.n1) {
            P1();
        } else if (id == d73.t) {
            G1();
        } else if (id == d73.i0) {
            I1();
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        ec2.u("getOfficialRefundReason");
        ec2.u("buyerApplyOfficialRefund");
        rd4.c();
        L1();
        super.onDestroy();
    }
}
