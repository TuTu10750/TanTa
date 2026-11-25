package com.yunbao.main.activity;

import android.content.Intent;
import android.view.View;
import android.widget.RadioButton;
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
public class EditSexActivity extends AbsActivity implements View.OnClickListener {
    public RadioButton e;
    public RadioButton f;
    public int g;

    /* loaded from: /tmp/classes2.dex */
    public class a extends HttpCallback {
        public a() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length <= 0) {
                return;
            }
            t54.b(JSON.parseObject(strArr[0]).getString(cl.h));
            int i2 = EditSexActivity.this.g;
            EditSexActivity editSexActivity = EditSexActivity.this;
            if (i2 == 1) {
                editSexActivity.e.setChecked(true);
            } else {
                editSexActivity.f.setChecked(true);
            }
            UserBean D = j30.q().D();
            if (D != null) {
                D.setSex(EditSexActivity.this.g);
            }
            Intent intent = EditSexActivity.this.getIntent();
            intent.putExtra("sex", EditSexActivity.this.g);
            EditSexActivity.this.setResult(-1, intent);
            EditSexActivity.this.finish();
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return y73.r;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.E1));
        this.e = (RadioButton) findViewById(c73.F0);
        this.f = (RadioButton) findViewById(c73.l0);
        this.e.setOnClickListener(this);
        this.f.setOnClickListener(this);
        int intExtra = getIntent().getIntExtra("sex", 1);
        this.g = intExtra;
        if (intExtra == 2) {
            this.f.setChecked(true);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (c1()) {
            int id = view.getId();
            if (id == c73.F0) {
                z1(1);
            } else if (id == c73.l0) {
                z1(2);
            }
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        db2.i("updateFields");
        super.onDestroy();
    }

    public final void z1(int i) {
        if (this.g == i) {
            return;
        }
        this.g = i;
        db2.y0("{\"sex\":\"" + i + "\"}", new a());
    }
}
