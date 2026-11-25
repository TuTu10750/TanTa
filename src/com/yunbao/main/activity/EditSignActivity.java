package com.yunbao.main.activity;

import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.alibaba.fastjson.JSON;
import com.umeng.analytics.pro.cl;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.bean.UserBean;
import com.yunbao.common.http.HttpCallback;
import defpackage.aq4;
import defpackage.c73;
import defpackage.db2;
import defpackage.j30;
import defpackage.m93;
import defpackage.t54;
import defpackage.y73;

/* loaded from: /tmp/classes2.dex */
public class EditSignActivity extends AbsActivity implements View.OnClickListener {
    public EditText e;
    public View f;

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
            if (EditSignActivity.this.f != null) {
                boolean isEmpty = TextUtils.isEmpty(charSequence);
                EditSignActivity editSignActivity = EditSignActivity.this;
                if (isEmpty) {
                    if (editSignActivity.f.getVisibility() == 0) {
                        EditSignActivity.this.f.setVisibility(4);
                    }
                } else if (editSignActivity.f.getVisibility() != 0) {
                    EditSignActivity.this.f.setVisibility(0);
                }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends HttpCallback {
        public final /* synthetic */ String a;

        public b(String str) {
            this.a = str;
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0) {
                t54.b(str);
                return;
            }
            if (strArr.length > 0) {
                t54.b(JSON.parseObject(strArr[0]).getString(cl.h));
                UserBean D = j30.q().D();
                if (D != null) {
                    D.setSignature(this.a);
                }
                Intent intent = EditSignActivity.this.getIntent();
                intent.putExtra("sign", this.a);
                EditSignActivity.this.setResult(-1, intent);
                EditSignActivity.this.finish();
            }
        }
    }

    private void x1() {
        EditText editText = this.e;
        if (editText != null) {
            editText.setText((CharSequence) null);
        }
    }

    private void y1() {
        String trim = this.e.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            t54.a(m93.F1);
            return;
        }
        if (trim.length() > 20) {
            t54.a(m93.B1);
            return;
        }
        db2.y0("{\"signature\":\"" + trim + "\"}", new b(trim));
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return y73.s;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.I1));
        EditText editText = (EditText) findViewById(c73.P1);
        this.e = editText;
        editText.addTextChangedListener(new a());
        View findViewById = findViewById(c73.Y);
        this.f = findViewById;
        findViewById.setOnClickListener(this);
        findViewById(c73.b1).setOnClickListener(this);
        String stringExtra = getIntent().getStringExtra("sign");
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        this.e.setText(stringExtra);
        this.e.setSelection(stringExtra.length());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (c1()) {
            int id = view.getId();
            if (id == c73.Y) {
                x1();
            } else if (id == c73.b1) {
                y1();
            }
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        db2.i("updateFields");
        super.onDestroy();
    }
}
