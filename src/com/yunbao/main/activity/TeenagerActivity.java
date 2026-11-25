package com.yunbao.main.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.umeng.analytics.pro.cl;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.http.HttpCallback;
import defpackage.aq4;
import defpackage.c73;
import defpackage.db2;
import defpackage.m93;
import defpackage.y73;

/* loaded from: /tmp/classes2.dex */
public class TeenagerActivity extends AbsActivity implements View.OnClickListener {
    public TextView e;
    public TextView f;
    public View g;
    public boolean h;
    public boolean i;

    /* loaded from: /tmp/classes2.dex */
    public class a extends HttpCallback {
        public a() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length <= 0) {
                return;
            }
            JSONObject parseObject = JSON.parseObject(strArr[0]);
            TeenagerActivity.this.h = parseObject.getIntValue(cl.i) == 1;
            TeenagerActivity.this.i = parseObject.getIntValue("is_setpassword") == 1;
            if (TeenagerActivity.this.i && TeenagerActivity.this.g != null) {
                TeenagerActivity.this.g.setVisibility(0);
            }
            boolean z = TeenagerActivity.this.h;
            TeenagerActivity teenagerActivity = TeenagerActivity.this;
            if (z) {
                if (teenagerActivity.f != null) {
                    TeenagerActivity.this.f.setText(m93.m0);
                }
                if (TeenagerActivity.this.e != null) {
                    TeenagerActivity.this.e.setText(m93.o0);
                    return;
                }
                return;
            }
            if (teenagerActivity.f != null) {
                TeenagerActivity.this.f.setText(m93.l0);
            }
            if (TeenagerActivity.this.e != null) {
                TeenagerActivity.this.e.setText(m93.n0);
            }
        }
    }

    public static void D1(Context context) {
        context.startActivity(new Intent(context, (Class<?>) TeenagerActivity.class));
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return y73.S;
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.k0));
        TextView textView = (TextView) findViewById(c73.l1);
        this.e = textView;
        textView.setOnClickListener(this);
        this.f = (TextView) findViewById(c73.G4);
        View findViewById = findViewById(c73.G0);
        this.g = findViewById;
        findViewById.setOnClickListener(this);
        db2.l(new a());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == c73.l1) {
            TeenagerPwdActivity.C1(this.b, this.h, this.i, 1);
        } else if (id == c73.G0) {
            TeenagerModifyPwdActivity.z1(this.b);
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        db2.i("checkTeenager");
        super.onDestroy();
    }
}
