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
import defpackage.wd;
import defpackage.y73;
import defpackage.zj2;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class AuthActivity extends AbsActivity implements View.OnClickListener {
    public EditText e;
    public EditText f;
    public EditText g;
    public ImageView h;
    public ImageView i;
    public ImageView j;
    public File k;
    public File l;
    public File m;
    public String n;
    public String o;
    public String p;
    public int q;
    public Dialog r;
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
            int i = AuthActivity.this.q;
            AuthActivity authActivity = AuthActivity.this;
            if (i == 0) {
                authActivity.k = file;
                if (AuthActivity.this.h != null) {
                    kn1.e(AuthActivity.this.b, file, AuthActivity.this.h);
                    return;
                }
                return;
            }
            int i2 = authActivity.q;
            AuthActivity authActivity2 = AuthActivity.this;
            if (i2 == 1) {
                authActivity2.l = file;
                if (AuthActivity.this.i != null) {
                    kn1.e(AuthActivity.this.b, file, AuthActivity.this.i);
                    return;
                }
                return;
            }
            if (authActivity2.q == 2) {
                AuthActivity.this.m = file;
                if (AuthActivity.this.j != null) {
                    kn1.e(AuthActivity.this.b, file, AuthActivity.this.j);
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
                AuthActivity authActivity = AuthActivity.this;
                zj2.n(authActivity, false, authActivity.s);
            } else if (i == m93.K0) {
                AuthActivity authActivity2 = AuthActivity.this;
                zj2.k(authActivity2, false, authActivity2.s);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends k30 {
        public final /* synthetic */ List a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        /* loaded from: /tmp/classes2.dex */
        public class a implements pd4 {

            /* renamed from: com.yunbao.main.activity.AuthActivity$c$a$a, reason: collision with other inner class name */
            /* loaded from: /tmp/classes2.dex */
            public class C0042a extends HttpCallback {
                public C0042a() {
                }

                @Override // com.yunbao.common.http.HttpCallback
                public void onFinish() {
                    AuthActivity.this.P1();
                }

                @Override // com.yunbao.common.http.HttpCallback
                public void onSuccess(int i, String str, String[] strArr) {
                    if (i == 0) {
                        AuthActivity.this.setResult(-1);
                        AuthActivity.this.finish();
                    }
                    t54.b(str);
                }
            }

            public a() {
            }

            @Override // defpackage.pd4
            public void a(List list, boolean z) {
                if (!z) {
                    AuthActivity.this.P1();
                    return;
                }
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    UploadBean uploadBean = (UploadBean) it.next();
                    int intValue = ((Integer) uploadBean.getTag()).intValue();
                    if (intValue == 0) {
                        AuthActivity.this.n = uploadBean.getRemoteFileName();
                    } else if (intValue == 1) {
                        AuthActivity.this.o = uploadBean.getRemoteFileName();
                    } else if (intValue == 2) {
                        AuthActivity.this.p = uploadBean.getRemoteFileName();
                    }
                }
                c cVar = c.this;
                db2.s0(cVar.b, cVar.c, cVar.d, AuthActivity.this.n, AuthActivity.this.o, AuthActivity.this.p, new C0042a());
            }
        }

        public c(List list, String str, String str2, String str3) {
            this.a = list;
            this.b = str;
            this.c = str2;
            this.d = str3;
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
        Dialog dialog = this.r;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.r.dismiss();
    }

    private void Q1() {
        if (this.r == null) {
            this.r = com.yunbao.common.utils.a.d(this.b, aq4.a(m93.ya));
        }
        if (this.r.isShowing()) {
            return;
        }
        this.r.show();
    }

    public void R1() {
        String obj = this.e.getText().toString();
        if (TextUtils.isEmpty(obj)) {
            t54.a(m93.g);
            return;
        }
        String obj2 = this.f.getText().toString();
        if (TextUtils.isEmpty(obj2)) {
            t54.a(m93.h);
            return;
        }
        String obj3 = this.g.getText().toString();
        if (TextUtils.isEmpty(obj3)) {
            t54.a(m93.i);
            return;
        }
        if (this.k == null || this.l == null || this.m == null) {
            t54.a(m93.J);
            return;
        }
        ArrayList arrayList = new ArrayList();
        File file = this.k;
        if (file != null) {
            UploadBean uploadBean = new UploadBean(file, 0);
            uploadBean.setTag(0);
            arrayList.add(uploadBean);
        }
        File file2 = this.l;
        if (file2 != null) {
            UploadBean uploadBean2 = new UploadBean(file2, 0);
            uploadBean2.setTag(1);
            arrayList.add(uploadBean2);
        }
        File file3 = this.m;
        if (file3 != null) {
            UploadBean uploadBean3 = new UploadBean(file3, 0);
            uploadBean3.setTag(2);
            arrayList.add(uploadBean3);
        }
        Q1();
        rd4.d(new c(arrayList, obj, obj2, obj3));
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return y73.g;
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.j));
        this.e = (EditText) findViewById(c73.L3);
        this.f = (EditText) findViewById(c73.Y3);
        this.g = (EditText) findViewById(c73.y1);
        this.h = (ImageView) findViewById(c73.M2);
        this.i = (ImageView) findViewById(c73.J2);
        this.j = (ImageView) findViewById(c73.N2);
        findViewById(c73.w0).setOnClickListener(this);
        findViewById(c73.u0).setOnClickListener(this);
        findViewById(c73.x0).setOnClickListener(this);
        findViewById(c73.k1).setOnClickListener(this);
        findViewById(c73.j0).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == c73.w0) {
            this.q = 0;
            O1();
            return;
        }
        if (id == c73.u0) {
            this.q = 1;
            O1();
        } else if (id == c73.x0) {
            this.q = 2;
            O1();
        } else if (id == c73.k1) {
            R1();
        } else if (id == c73.j0) {
            new wd().d2(getSupportFragmentManager(), "AuthExampleDialogFragment");
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
