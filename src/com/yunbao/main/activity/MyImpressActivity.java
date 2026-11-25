package com.yunbao.main.activity;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alibaba.fastjson.JSON;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.live.bean.ImpressBean;
import com.yunbao.live.custom.MyTextView;
import defpackage.aq4;
import defpackage.c73;
import defpackage.db2;
import defpackage.m93;
import defpackage.x73;
import defpackage.y73;
import java.util.Arrays;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class MyImpressActivity extends AbsActivity {
    public LinearLayout e;
    public TextView f;

    /* loaded from: /tmp/classes2.dex */
    public class a extends HttpCallback {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v3, types: [android.view.View, com.yunbao.live.custom.MyTextView] */
        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i == 0) {
                if (strArr.length <= 0) {
                    MyImpressActivity.this.f.setText(aq4.a(m93.U2));
                    return;
                }
                List parseArray = JSON.parseArray(Arrays.toString(strArr), ImpressBean.class);
                LayoutInflater from = LayoutInflater.from(MyImpressActivity.this.b);
                boolean z = true;
                int i2 = 0;
                int i3 = 0;
                while (z) {
                    LinearLayout linearLayout = (LinearLayout) from.inflate(x73.G1, MyImpressActivity.this.e, false);
                    int i4 = i2 % 2 == 0 ? i3 + 3 : i3 + 2;
                    if (i4 >= parseArray.size()) {
                        i4 = parseArray.size();
                        z = false;
                    }
                    while (i3 < i4) {
                        ?? r6 = (MyTextView) from.inflate(x73.D1, (ViewGroup) linearLayout, false);
                        ImpressBean impressBean = (ImpressBean) parseArray.get(i3);
                        impressBean.setCheck(1);
                        r6.u(impressBean, true);
                        linearLayout.addView(r6);
                        i3++;
                    }
                    i2++;
                    MyImpressActivity.this.e.addView(linearLayout);
                    i3 = i4;
                }
            }
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return y73.J;
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.Q2));
        this.e = (LinearLayout) findViewById(c73.t2);
        this.f = (TextView) findViewById(c73.G4);
        db2.S(new a());
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        db2.i("getMyImpress");
        super.onDestroy();
    }
}
