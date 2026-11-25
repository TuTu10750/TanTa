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
import defpackage.t54;
import defpackage.z73;

/* loaded from: /tmp/classes2.dex */
public class ShopApplyResultActivity extends AbsActivity implements View.OnClickListener {

    /* loaded from: /tmp/classes2.dex */
    public class a extends HttpCallback {
        public a() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0) {
                t54.b(str);
            } else if (strArr.length > 0) {
                JSONObject parseObject = JSON.parseObject(strArr[0]);
                ShopApplyResultActivity.this.finish();
                ShopApplyActivity.s2(ShopApplyResultActivity.this.b, parseObject.getString("cer_no"), parseObject.getString("real_name"), true);
            }
        }
    }

    public static void x1(Context context, boolean z, String str) {
        Intent intent = new Intent(context, (Class<?>) ShopApplyResultActivity.class);
        intent.putExtra("mallApplyFailed", z);
        intent.putExtra("tip", str);
        context.startActivity(intent);
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return z73.W;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.w5));
        if (!getIntent().getBooleanExtra("mallApplyFailed", false)) {
            findViewById(d73.u2).setVisibility(0);
            return;
        }
        findViewById(d73.n2).setVisibility(0);
        findViewById(d73.E).setOnClickListener(this);
        String stringExtra = getIntent().getStringExtra("tip");
        TextView textView = (TextView) findViewById(d73.t3);
        if (textView != null) {
            textView.setText(stringExtra);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ec2.l0(new a());
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        ec2.u("getUserAuthInfo");
        super.onDestroy();
    }
}
