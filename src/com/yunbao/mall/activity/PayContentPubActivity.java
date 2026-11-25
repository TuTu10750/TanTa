package com.yunbao.mall.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.common.upload.UploadBean;
import com.yunbao.common.utils.a;
import com.yunbao.mall.bean.PayContentVideoBean;
import defpackage.an1;
import defpackage.aq4;
import defpackage.b5;
import defpackage.bx2;
import defpackage.d73;
import defpackage.ec2;
import defpackage.k30;
import defpackage.kn1;
import defpackage.m93;
import defpackage.pd4;
import defpackage.qd4;
import defpackage.rd4;
import defpackage.s4;
import defpackage.t54;
import defpackage.z73;
import defpackage.zj2;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class PayContentPubActivity extends AbsActivity implements View.OnClickListener {
    public TextView e;
    public EditText f;
    public EditText g;
    public EditText h;
    public EditText i;
    public ImageView j;
    public View k;
    public TextView l;
    public TextView m;
    public String n;
    public File o;
    public List p;
    public Dialog q;
    public bx2 r;
    public an1 s = new a();

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
            PayContentPubActivity.this.o = file;
            if (PayContentPubActivity.this.j != null) {
                kn1.e(PayContentPubActivity.this.b, file, PayContentPubActivity.this.j);
            }
            if (PayContentPubActivity.this.k == null || PayContentPubActivity.this.k.getVisibility() == 0) {
                return;
            }
            PayContentPubActivity.this.k.setVisibility(0);
        }

        @Override // defpackage.an1
        public void b() {
        }

        @Override // defpackage.an1
        public void c() {
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends s4 {
        public b() {
        }

        @Override // defpackage.s4
        public void c(Intent intent) {
            if (intent != null) {
                PayContentPubActivity.this.n = intent.getStringExtra("classID");
                if (PayContentPubActivity.this.e != null) {
                    PayContentPubActivity.this.e.setText(intent.getStringExtra("className"));
                }
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
                PayContentPubActivity payContentPubActivity = PayContentPubActivity.this;
                zj2.n(payContentPubActivity, false, payContentPubActivity.s);
            } else if (i == m93.K0) {
                PayContentPubActivity payContentPubActivity2 = PayContentPubActivity.this;
                zj2.k(payContentPubActivity2, false, payContentPubActivity2.s);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d extends k30 {
        public final /* synthetic */ List a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;

        /* loaded from: /tmp/classes2.dex */
        public class a implements pd4 {

            /* renamed from: com.yunbao.mall.activity.PayContentPubActivity$d$a$a, reason: collision with other inner class name */
            /* loaded from: /tmp/classes2.dex */
            public class C0056a extends HttpCallback {
                public C0056a() {
                }

                @Override // com.yunbao.common.http.HttpCallback
                public void onSuccess(int i, String str, String[] strArr) {
                    if (i == 0) {
                        PayContentPubActivity.this.finish();
                    }
                    t54.b(str);
                }
            }

            public a() {
            }

            @Override // defpackage.pd4
            public void a(List list, boolean z) {
                String str;
                UploadBean uploadBean;
                PayContentPubActivity.this.L1();
                if (z) {
                    Iterator it = list.iterator();
                    String str2 = null;
                    loop0: while (true) {
                        str = str2;
                        while (it.hasNext()) {
                            uploadBean = (UploadBean) it.next();
                            if (uploadBean.getType() == 0) {
                                break;
                            } else {
                                ((PayContentVideoBean) uploadBean.getTag()).setUploadResultUrl(uploadBean.getRemoteFileName());
                            }
                        }
                        str2 = uploadBean.getRemoteFileName();
                    }
                    JSONArray jSONArray = new JSONArray();
                    int size = PayContentPubActivity.this.p.size();
                    int i = 0;
                    while (i < size) {
                        PayContentVideoBean payContentVideoBean = (PayContentVideoBean) PayContentPubActivity.this.p.get(i);
                        JSONObject jSONObject = new JSONObject();
                        i++;
                        jSONObject.put("video_id", String.valueOf(i));
                        jSONObject.put("video_url", payContentVideoBean.getUploadResultUrl());
                        jSONObject.put("video_title", payContentVideoBean.getTitle());
                        jSONObject.put("is_see", Integer.valueOf(payContentVideoBean.getIsSee()));
                        jSONObject.put("video_length", payContentVideoBean.getDuration());
                        jSONArray.add(jSONObject);
                    }
                    String jSONString = jSONArray.toJSONString();
                    String str3 = PayContentPubActivity.this.n;
                    d dVar = d.this;
                    ec2.s0(str3, dVar.b, dVar.c, dVar.d, dVar.e, str, jSONString, PayContentPubActivity.this.p.size() <= 1 ? 0 : 1, new C0056a());
                }
            }
        }

        public d(List list, String str, String str2, String str3, String str4) {
            this.a = list;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = str4;
        }

        @Override // defpackage.k30
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(qd4 qd4Var) {
            qd4Var.a(this.a, true, new a());
        }
    }

    private void H1() {
        com.yunbao.common.utils.a.r(this.b, new Integer[]{Integer.valueOf(m93.K0), Integer.valueOf(m93.R0)}, new c());
    }

    public static void K1(Context context) {
        context.startActivity(new Intent(context, (Class<?>) PayContentPubActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L1() {
        Dialog dialog = this.q;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.q.dismiss();
    }

    private void P1() {
        if (this.q == null) {
            this.q = com.yunbao.common.utils.a.d(this.b, aq4.a(m93.ya));
        }
        if (this.q.isShowing()) {
            return;
        }
        this.q.show();
    }

    private void Q1() {
        String trim = this.f.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            t54.a(m93.I7);
            return;
        }
        String trim2 = this.g.getText().toString().trim();
        if (TextUtils.isEmpty(trim2)) {
            t54.a(m93.J7);
            return;
        }
        String trim3 = this.h.getText().toString().trim();
        if (TextUtils.isEmpty(trim3)) {
            t54.a(m93.K7);
            return;
        }
        String trim4 = this.i.getText().toString().trim();
        if (TextUtils.isEmpty(trim4)) {
            t54.a(m93.L7);
            return;
        }
        File file = this.o;
        if (file == null || !file.exists()) {
            t54.a(m93.M7);
            return;
        }
        List list = this.p;
        if (list == null || list.size() == 0) {
            t54.a(m93.G7);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new UploadBean(this.o, 0));
        for (PayContentVideoBean payContentVideoBean : this.p) {
            UploadBean uploadBean = new UploadBean(new File(payContentVideoBean.getFilePath()), 1);
            uploadBean.setTag(payContentVideoBean);
            arrayList.add(uploadBean);
        }
        P1();
        rd4.d(new d(arrayList, trim, trim2, trim3, trim4));
    }

    public final void G1() {
        Intent intent = new Intent(this.b, (Class<?>) PayContentClassActivity.class);
        intent.putExtra("classID", this.n);
        b5.a(this, intent, new b());
    }

    public void I1() {
        bx2 bx2Var = this.r;
        if (bx2Var != null) {
            bx2Var.j0();
        }
    }

    public final void J1() {
        this.o = null;
        ImageView imageView = this.j;
        if (imageView != null) {
            imageView.setImageDrawable(null);
        }
        View view = this.k;
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        this.k.setVisibility(4);
    }

    public final void M1() {
        if (this.r == null) {
            bx2 bx2Var = new bx2(this.b, (ViewGroup) findViewById(d73.Q3));
            this.r = bx2Var;
            bx2Var.subscribeActivityLifeCycle();
            this.r.addToParent();
        }
        this.r.show();
    }

    public void N1(PayContentVideoBean payContentVideoBean) {
        if (this.p == null) {
            this.p = new ArrayList();
        }
        this.p.clear();
        this.p.add(payContentVideoBean);
        this.m.setText(SdkVersion.MINI_VERSION);
        this.l.setText(m93.D7);
    }

    public void O1(List list) {
        if (this.p == null) {
            this.p = new ArrayList();
        }
        this.p.clear();
        this.p.addAll(list);
        this.m.setText(String.valueOf(this.p.size()));
        this.l.setText(m93.E7);
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return z73.F;
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.B7));
        this.e = (TextView) findViewById(d73.C1);
        this.f = (EditText) findViewById(d73.E1);
        this.g = (EditText) findViewById(d73.D1);
        this.h = (EditText) findViewById(d73.r4);
        this.i = (EditText) findViewById(d73.k3);
        this.j = (ImageView) findViewById(d73.L1);
        this.k = findViewById(d73.j0);
        this.l = (TextView) findViewById(d73.t4);
        this.m = (TextView) findViewById(d73.s4);
        findViewById(d73.e0).setOnClickListener(this);
        findViewById(d73.h0).setOnClickListener(this);
        this.k.setOnClickListener(this);
        findViewById(d73.V).setOnClickListener(this);
        findViewById(d73.n1).setOnClickListener(this);
    }

    public void onBackPressed() {
        bx2 bx2Var = this.r;
        if (bx2Var == null || !bx2Var.isShowed()) {
            super/*androidx.activity.ComponentActivity*/.onBackPressed();
        } else {
            this.r.hide();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == d73.e0) {
            G1();
            return;
        }
        if (id == d73.h0) {
            H1();
            return;
        }
        if (id == d73.j0) {
            J1();
        } else if (id == d73.V) {
            M1();
        } else if (id == d73.n1) {
            Q1();
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        ec2.u("publishPayContent");
        L1();
        super.onDestroy();
    }
}
