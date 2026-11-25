package com.yunbao.mall.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.http.HttpCallback;
import defpackage.aq4;
import defpackage.d73;
import defpackage.ec2;
import defpackage.m93;
import defpackage.rv3;
import defpackage.z73;

/* loaded from: /tmp/classes2.dex */
public class SellerAddressActivity extends AbsActivity implements View.OnClickListener {
    public TextView e;
    public TextView f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;

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
            SellerAddressActivity.this.g = parseObject.getString("receiver");
            SellerAddressActivity.this.h = parseObject.getString("receiver_phone");
            SellerAddressActivity.this.i = parseObject.getString("receiver_province");
            SellerAddressActivity.this.j = parseObject.getString("receiver_city");
            SellerAddressActivity.this.k = parseObject.getString("receiver_area");
            SellerAddressActivity.this.l = parseObject.getString("receiver_address");
            if (SellerAddressActivity.this.e != null) {
                SellerAddressActivity.this.e.setText(rv3.a(SellerAddressActivity.this.g, "  ", SellerAddressActivity.this.h));
            }
            if (SellerAddressActivity.this.f != null) {
                SellerAddressActivity.this.f.setText(rv3.a(SellerAddressActivity.this.i, " ", SellerAddressActivity.this.j, " ", SellerAddressActivity.this.k, " ", SellerAddressActivity.this.l));
            }
        }
    }

    public static void K1(Context context) {
        context.startActivity(new Intent(context, (Class<?>) SellerAddressActivity.class));
    }

    private void L1() {
        ec2.a0(new a());
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return z73.K;
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.o6));
        this.e = (TextView) findViewById(d73.R2);
        this.f = (TextView) findViewById(d73.d);
        findViewById(d73.q0).setOnClickListener(this);
        L1();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super/*androidx.fragment.app.FragmentActivity*/.onActivityResult(i, i2, intent);
        if (i == 100 && i2 == -1) {
            L1();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent(this.b, (Class<?>) SellerAddressEditActivity.class);
        intent.putExtra("mallRefundName", this.g);
        intent.putExtra("mallRefundPhone", this.h);
        intent.putExtra("mallRefundProvince", this.i);
        intent.putExtra("mallRefundCity", this.j);
        intent.putExtra("mallRefundZone", this.k);
        intent.putExtra("mallRefundAddress", this.l);
        startActivityForResult(intent, 100);
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        ec2.u("getRefundAddress");
        super.onDestroy();
    }
}
