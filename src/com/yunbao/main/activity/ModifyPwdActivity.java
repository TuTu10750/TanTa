package com.yunbao.main.activity;

import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.umeng.analytics.pro.cl;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.http.HttpCallback;
import defpackage.aq4;
import defpackage.c73;
import defpackage.db2;
import defpackage.le3;
import defpackage.m93;
import defpackage.pw3;
import defpackage.rv3;
import defpackage.t54;
import defpackage.y73;
import defpackage.zu0;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: /tmp/classes2.dex */
public class ModifyPwdActivity extends AbsActivity implements View.OnClickListener {
    public EditText e;
    public EditText f;
    public EditText g;
    public View h;
    public boolean i;

    /* loaded from: /tmp/classes2.dex */
    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            ModifyPwdActivity.this.h.setEnabled((TextUtils.isEmpty(ModifyPwdActivity.this.e.getText().toString()) || TextUtils.isEmpty(ModifyPwdActivity.this.f.getText().toString()) || TextUtils.isEmpty(ModifyPwdActivity.this.g.getText().toString())) ? false : true);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends HttpCallback {
        public b() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length <= 0) {
                return;
            }
            JSONObject parseObject = JSON.parseObject(strArr[0]);
            ModifyPwdActivity.this.i = parseObject.getIntValue("sendcode_type") == 1;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends HttpCallback {
        public c() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0) {
                t54.b(str);
            } else {
                t54.b(JSON.parseObject(strArr[0]).getString(cl.h));
                ModifyPwdActivity.this.finish();
            }
        }
    }

    public final void B1() {
        db2.i0(this.e.getText().toString().trim(), this.f.getText().toString().trim(), this.g.getText().toString().trim(), new c());
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return y73.H;
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.N8));
        this.e = (EditText) findViewById(c73.W1);
        this.f = (EditText) findViewById(c73.V1);
        this.g = (EditText) findViewById(c73.U1);
        View findViewById = findViewById(c73.c0);
        this.h = findViewById;
        findViewById.setOnClickListener(this);
        a aVar = new a();
        this.e.addTextChangedListener(aVar);
        this.f.addTextChangedListener(aVar);
        this.g.addTextChangedListener(aVar);
        TextView textView = (TextView) findViewById(c73.q0);
        textView.setOnClickListener(this);
        textView.setText(rv3.a(aq4.a(m93.L1), "?"));
        zu0.c().n(this);
        db2.R(new b());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != c73.q0) {
            if (id == c73.c0) {
                B1();
            }
        } else {
            Intent intent = new Intent(this.b, (Class<?>) FindPwdActivity.class);
            intent.putExtra("fromLogin", false);
            intent.putExtra("tip", this.i);
            startActivity(intent);
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        zu0.c().p(this);
        db2.i("modifyPwd");
        super.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @pw3(threadMode = ThreadMode.MAIN)
    public void onRegSuccessEvent(le3 le3Var) {
        finish();
    }
}
