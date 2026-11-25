package com.yunbao.main.activity;

import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.common.upload.UploadBean;
import com.yunbao.common.utils.a;
import defpackage.an1;
import defpackage.aq4;
import defpackage.c73;
import defpackage.db2;
import defpackage.k30;
import defpackage.kn1;
import defpackage.m93;
import defpackage.pd4;
import defpackage.qd4;
import defpackage.rd4;
import defpackage.t54;
import defpackage.y73;
import defpackage.zj2;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class FamilyApplyActivity extends AbsActivity implements View.OnClickListener {
    public EditText e;
    public EditText f;
    public EditText g;
    public EditText h;
    public EditText i;
    public ImageView j;
    public ImageView k;
    public ImageView l;
    public File m;
    public File n;
    public File o;
    public String p;
    public String q;
    public String r;
    public int s;
    public Dialog t;
    public an1 u = new a();

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
            int i = FamilyApplyActivity.this.s;
            FamilyApplyActivity familyApplyActivity = FamilyApplyActivity.this;
            if (i == 0) {
                familyApplyActivity.m = file;
                if (FamilyApplyActivity.this.j != null) {
                    kn1.e(FamilyApplyActivity.this.b, file, FamilyApplyActivity.this.j);
                    return;
                }
                return;
            }
            int i2 = familyApplyActivity.s;
            FamilyApplyActivity familyApplyActivity2 = FamilyApplyActivity.this;
            if (i2 == 1) {
                familyApplyActivity2.n = file;
                if (FamilyApplyActivity.this.k != null) {
                    kn1.e(FamilyApplyActivity.this.b, file, FamilyApplyActivity.this.k);
                    return;
                }
                return;
            }
            if (familyApplyActivity2.s == 2) {
                FamilyApplyActivity.this.o = file;
                if (FamilyApplyActivity.this.l != null) {
                    kn1.e(FamilyApplyActivity.this.b, file, FamilyApplyActivity.this.l);
                }
            }
        }

        @Override // defpackage.an1
        public void b() {
        }

        @Override // defpackage.an1
        public void c() {
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements a.n {
        public b() {
        }

        @Override // com.yunbao.common.utils.a.n
        public void a(String str, int i) {
            if (i == m93.R0) {
                FamilyApplyActivity familyApplyActivity = FamilyApplyActivity.this;
                zj2.n(familyApplyActivity, false, familyApplyActivity.u);
            } else if (i == m93.K0) {
                FamilyApplyActivity familyApplyActivity2 = FamilyApplyActivity.this;
                zj2.k(familyApplyActivity2, false, familyApplyActivity2.u);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends k30 {
        public final /* synthetic */ List a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;

        /* loaded from: /tmp/classes2.dex */
        public class a implements pd4 {

            /* renamed from: com.yunbao.main.activity.FamilyApplyActivity$c$a$a, reason: collision with other inner class name */
            /* loaded from: /tmp/classes2.dex */
            public class C0048a extends HttpCallback {
                public C0048a() {
                }

                @Override // com.yunbao.common.http.HttpCallback
                public void onFinish() {
                    FamilyApplyActivity.this.P1();
                }

                @Override // com.yunbao.common.http.HttpCallback
                public void onSuccess(int i, String str, String[] strArr) {
                    if (i == 0) {
                        FamilyApplyActivity.this.setResult(-1);
                        FamilyApplyActivity.this.finish();
                    }
                    t54.b(str);
                }
            }

            public a() {
            }

            @Override // defpackage.pd4
            public void a(List list, boolean z) {
                if (!z) {
                    FamilyApplyActivity.this.P1();
                    return;
                }
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    UploadBean uploadBean = (UploadBean) it.next();
                    int intValue = ((Integer) uploadBean.getTag()).intValue();
                    if (intValue == 0) {
                        FamilyApplyActivity.this.p = uploadBean.getRemoteFileName();
                    } else if (intValue == 1) {
                        FamilyApplyActivity.this.q = uploadBean.getRemoteFileName();
                    } else if (intValue == 2) {
                        FamilyApplyActivity.this.r = uploadBean.getRemoteFileName();
                    }
                }
                c cVar = c.this;
                db2.o(cVar.b, cVar.c, cVar.d, cVar.e, cVar.f, FamilyApplyActivity.this.p, FamilyApplyActivity.this.q, FamilyApplyActivity.this.r, new C0048a());
            }
        }

        public c(List list, String str, String str2, String str3, String str4, String str5) {
            this.a = list;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = str4;
            this.f = str5;
        }

        @Override // defpackage.k30
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(qd4 qd4Var) {
            qd4Var.a(this.a, true, new a());
        }
    }

    private void O1() {
        com.yunbao.common.utils.a.r(this.b, new Integer[]{Integer.valueOf(m93.K0), Integer.valueOf(m93.R0)}, new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P1() {
        Dialog dialog = this.t;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.t.dismiss();
    }

    private void Q1() {
        if (this.t == null) {
            this.t = com.yunbao.common.utils.a.d(this.b, aq4.a(m93.ya));
        }
        if (this.t.isShowing()) {
            return;
        }
        this.t.show();
    }

    public void R1() {
        String obj = this.e.getText().toString();
        if (TextUtils.isEmpty(obj)) {
            t54.a(m93.m);
            return;
        }
        String obj2 = this.f.getText().toString();
        if (TextUtils.isEmpty(obj2)) {
            t54.a(m93.n);
            return;
        }
        String obj3 = this.g.getText().toString();
        if (TextUtils.isEmpty(obj3)) {
            t54.a(m93.i);
            return;
        }
        String obj4 = this.h.getText().toString();
        if (TextUtils.isEmpty(obj4)) {
            t54.a(m93.o);
            return;
        }
        String obj5 = this.i.getText().toString();
        if (TextUtils.isEmpty(obj5)) {
            t54.a(m93.p);
            return;
        }
        ArrayList arrayList = new ArrayList();
        File file = this.m;
        if (file != null) {
            UploadBean uploadBean = new UploadBean(file, 0);
            uploadBean.setTag(0);
            arrayList.add(uploadBean);
        }
        File file2 = this.n;
        if (file2 != null) {
            UploadBean uploadBean2 = new UploadBean(file2, 0);
            uploadBean2.setTag(1);
            arrayList.add(uploadBean2);
        }
        File file3 = this.o;
        if (file3 != null) {
            UploadBean uploadBean3 = new UploadBean(file3, 0);
            uploadBean3.setTag(2);
            arrayList.add(uploadBean3);
        }
        if (this.m == null || this.n == null || this.o == null) {
            t54.a(m93.J);
        } else {
            Q1();
            rd4.d(new c(arrayList, obj, obj2, obj3, obj4, obj5));
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return y73.u;
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.L));
        this.e = (EditText) findViewById(c73.i2);
        this.f = (EditText) findViewById(c73.u5);
        this.g = (EditText) findViewById(c73.y1);
        this.h = (EditText) findViewById(c73.A1);
        this.i = (EditText) findViewById(c73.h2);
        this.j = (ImageView) findViewById(c73.M2);
        this.k = (ImageView) findViewById(c73.J2);
        this.l = (ImageView) findViewById(c73.L2);
        findViewById(c73.w0).setOnClickListener(this);
        findViewById(c73.u0).setOnClickListener(this);
        findViewById(c73.v0).setOnClickListener(this);
        findViewById(c73.k1).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == c73.w0) {
            this.s = 0;
            O1();
            return;
        }
        if (id == c73.u0) {
            this.s = 1;
            O1();
        } else if (id == c73.v0) {
            this.s = 2;
            O1();
        } else if (id == c73.k1) {
            R1();
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        db2.i("setAuth");
        rd4.c();
        P1();
        super.onDestroy();
    }
}
