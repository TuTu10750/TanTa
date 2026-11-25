package com.yunbao.main.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.custom.SplitEditText;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.common.utils.a;
import defpackage.aq4;
import defpackage.c73;
import defpackage.db2;
import defpackage.j30;
import defpackage.m93;
import defpackage.t54;
import defpackage.y73;

/* loaded from: /tmp/classes2.dex */
public class TeenagerPwdActivity extends AbsActivity {
    public InputMethodManager e;
    public boolean f;
    public boolean g;
    public int h;

    /* loaded from: /tmp/classes2.dex */
    public class a implements SplitEditText.c {

        /* renamed from: com.yunbao.main.activity.TeenagerPwdActivity$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/classes2.dex */
        public class C0050a extends HttpCallback {
            public C0050a() {
            }

            @Override // com.yunbao.common.http.HttpCallback
            public void onSuccess(int i, String str, String[] strArr) {
                if (i == 0) {
                    j30.q().c0(false);
                    TeenagerPwdActivity.this.D1();
                }
                t54.b(str);
            }
        }

        /* loaded from: /tmp/classes2.dex */
        public class b extends HttpCallback {

            /* renamed from: com.yunbao.main.activity.TeenagerPwdActivity$a$b$a, reason: collision with other inner class name */
            /* loaded from: /tmp/classes2.dex */
            public class C0051a implements a.l {
                public C0051a() {
                }

                @Override // com.yunbao.common.utils.a.l
                public void a() {
                    if (TeenagerPwdActivity.this.e != null) {
                        TeenagerPwdActivity.this.e.hideSoftInputFromWindow(TeenagerPwdActivity.this.findViewById(c73.P1).getWindowToken(), 0);
                    }
                    TeenagerPwdActivity.C1(TeenagerPwdActivity.this.b, false, true, 0);
                    TeenagerPwdActivity.this.finish();
                }

                @Override // com.yunbao.common.utils.a.m
                public void b(Dialog dialog, String str) {
                    TeenagerPwdActivity.this.D1();
                }
            }

            public b() {
            }

            @Override // com.yunbao.common.http.HttpCallback
            public void onSuccess(int i, String str, String[] strArr) {
                if (i != 0) {
                    t54.b(str);
                    return;
                }
                j30.q().c0(true);
                if (!TeenagerPwdActivity.this.g) {
                    new a.j(TeenagerPwdActivity.this.b).k(aq4.a(m93.s0)).f(aq4.a(m93.u0)).g(false).d(false).h(new C0051a()).c().show();
                } else {
                    t54.b(str);
                    TeenagerPwdActivity.this.D1();
                }
            }
        }

        public a() {
        }

        @Override // com.yunbao.common.custom.SplitEditText.c
        public void C(String str) {
        }

        @Override // com.yunbao.common.custom.SplitEditText.c
        public void Z(String str) {
            if (TeenagerPwdActivity.this.f) {
                db2.m(str, new C0050a());
            } else {
                db2.k0(str, TeenagerPwdActivity.this.h, new b());
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements View.OnLongClickListener {
        public b() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            return true;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c implements View.OnClickListener {
        public final /* synthetic */ SplitEditText a;

        public c(SplitEditText splitEditText) {
            this.a = splitEditText;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.requestFocus();
            TeenagerPwdActivity.this.e.showSoftInput(this.a, 2);
        }
    }

    public static void C1(Context context, boolean z, boolean z2, int i) {
        Intent intent = new Intent(context, (Class<?>) TeenagerPwdActivity.class);
        intent.putExtra("isOpen", z);
        intent.putExtra("hasSetPwd", z2);
        intent.putExtra("type", i);
        context.startActivity(intent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void D1() {
        InputMethodManager inputMethodManager = this.e;
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(findViewById(c73.P1).getWindowToken(), 0);
        }
        Intent intent = new Intent(this.b, (Class<?>) MainActivity.class);
        intent.putExtra("exit", false);
        startActivity(intent);
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return y73.U;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        Intent intent = getIntent();
        this.f = intent.getBooleanExtra("isOpen", false);
        this.g = intent.getBooleanExtra("hasSetPwd", false);
        this.h = intent.getIntExtra("type", 0);
        t1(aq4.a(this.g ? m93.r0 : m93.p0));
        ((TextView) findViewById(c73.G4)).setText(this.g ? m93.f5 : m93.q0);
        this.e = (InputMethodManager) this.b.getSystemService("input_method");
        SplitEditText splitEditText = (SplitEditText) findViewById(c73.P1);
        splitEditText.setOnInputListener(new a());
        View findViewById = findViewById(c73.L5);
        findViewById.setOnLongClickListener(new b());
        findViewById.setOnClickListener(new c(splitEditText));
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        db2.i("openTeenager");
        db2.i("closeTeenager");
        super.onDestroy();
    }
}
