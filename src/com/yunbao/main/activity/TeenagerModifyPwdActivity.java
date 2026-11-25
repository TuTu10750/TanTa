package com.yunbao.main.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.custom.SplitEditText;
import com.yunbao.common.http.HttpCallback;
import defpackage.aq4;
import defpackage.c73;
import defpackage.db2;
import defpackage.m93;
import defpackage.t54;
import defpackage.y73;

/* loaded from: /tmp/classes2.dex */
public class TeenagerModifyPwdActivity extends AbsActivity implements SplitEditText.c {
    public InputMethodManager e;
    public SplitEditText f;
    public SplitEditText g;
    public SplitEditText h;
    public View i;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TeenagerModifyPwdActivity.this.A1();
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
            TeenagerModifyPwdActivity.this.e.showSoftInput(this.a, 2);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d extends HttpCallback {
        public d() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i == 0) {
                if (TeenagerModifyPwdActivity.this.e != null) {
                    TeenagerModifyPwdActivity.this.e.hideSoftInputFromWindow(TeenagerModifyPwdActivity.this.findViewById(c73.Q1).getWindowToken(), 0);
                }
                TeenagerModifyPwdActivity.this.finish();
            }
            t54.b(str);
        }
    }

    public static void z1(Context context) {
        context.startActivity(new Intent(context, (Class<?>) TeenagerModifyPwdActivity.class));
    }

    public final void A1() {
        String obj = this.f.getText().toString();
        String obj2 = this.g.getText().toString();
        if (obj2.equals(this.h.getText().toString())) {
            db2.j0(obj, obj2, new d());
        } else {
            t54.a(m93.O9);
        }
    }

    @Override // com.yunbao.common.custom.SplitEditText.c
    public void C(String str) {
        this.i.setEnabled(this.f.getText().toString().length() == 4 && this.g.getText().toString().length() == 4 && this.h.getText().toString().length() == 4);
    }

    @Override // com.yunbao.common.custom.SplitEditText.c
    public void Z(String str) {
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return y73.T;
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.j0));
        this.e = (InputMethodManager) this.b.getSystemService("input_method");
        SplitEditText splitEditText = (SplitEditText) findViewById(c73.Q1);
        this.f = splitEditText;
        splitEditText.setOnInputListener(this);
        SplitEditText splitEditText2 = (SplitEditText) findViewById(c73.R1);
        this.g = splitEditText2;
        splitEditText2.setOnInputListener(this);
        SplitEditText splitEditText3 = (SplitEditText) findViewById(c73.S1);
        this.h = splitEditText3;
        splitEditText3.setOnInputListener(this);
        y1(this.f, c73.M5);
        y1(this.g, c73.N5);
        y1(this.h, c73.O5);
        View findViewById = findViewById(c73.p1);
        this.i = findViewById;
        findViewById.setOnClickListener(new a());
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        db2.i("modifyTeenagerPwd");
        super.onDestroy();
    }

    public final void y1(SplitEditText splitEditText, int i) {
        View findViewById = findViewById(i);
        findViewById.setOnLongClickListener(new b());
        findViewById.setOnClickListener(new c(splitEditText));
    }
}
