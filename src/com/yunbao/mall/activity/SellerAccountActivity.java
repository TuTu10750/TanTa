package com.yunbao.mall.activity;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.activity.WebViewActivity;
import com.yunbao.common.custom.CommonRefreshView;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.mall.bean.BuyerRefundRecordBean;
import defpackage.am;
import defpackage.aq4;
import defpackage.ce3;
import defpackage.d73;
import defpackage.ec2;
import defpackage.m93;
import defpackage.rv3;
import defpackage.wg1;
import defpackage.z73;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class SellerAccountActivity extends AbsActivity implements View.OnClickListener {
    public TextView e;
    public TextView f;
    public TextView g;
    public CommonRefreshView h;
    public am i;
    public String j;
    public String k;

    /* loaded from: /tmp/classes2.dex */
    public class a implements CommonRefreshView.e {
        public a() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public ce3 getAdapter() {
            if (SellerAccountActivity.this.i == null) {
                SellerAccountActivity sellerAccountActivity = SellerAccountActivity.this;
                sellerAccountActivity.i = new am(sellerAccountActivity.b);
            }
            return SellerAccountActivity.this.i;
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void loadData(int i, HttpCallback httpCallback) {
            ec2.d0(i, httpCallback);
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void onLoadMoreFailure() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void onLoadMoreSuccess(List list, int i) {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void onRefreshFailure() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void onRefreshSuccess(List list, int i) {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public List processData(String[] strArr) {
            JSONObject parseObject = JSON.parseObject(strArr[0]);
            JSONObject jSONObject = parseObject.getJSONObject("user_balance");
            SellerAccountActivity.this.k = jSONObject.getString("balance_total");
            SellerAccountActivity.this.j = jSONObject.getString("balance");
            if (SellerAccountActivity.this.e != null) {
                TextView textView = SellerAccountActivity.this.e;
                SellerAccountActivity sellerAccountActivity = SellerAccountActivity.this;
                textView.setText(sellerAccountActivity.I1(sellerAccountActivity.k));
            }
            if (SellerAccountActivity.this.f != null) {
                SellerAccountActivity.this.f.setText(SellerAccountActivity.this.I1(jSONObject.getString("wait_settlement")));
            }
            if (SellerAccountActivity.this.g != null) {
                SellerAccountActivity.this.g.setText(rv3.a(aq4.a(m93.O8), SellerAccountActivity.this.j));
            }
            return JSON.parseArray(parseObject.getString("list"), BuyerRefundRecordBean.class);
        }
    }

    public static void H1(Context context) {
        context.startActivity(new Intent(context, (Class<?>) SellerAccountActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CharSequence I1(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (!str.contains(".")) {
            str = str.concat(".00");
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(12, true), str.indexOf("."), spannableStringBuilder.length(), 33);
        return spannableStringBuilder;
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return z73.H;
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.v7));
        this.e = (TextView) findViewById(d73.n4);
        this.f = (TextView) findViewById(d73.q4);
        this.g = (TextView) findViewById(d73.m);
        findViewById(d73.Q).setOnClickListener(this);
        findViewById(d73.P).setOnClickListener(this);
        CommonRefreshView commonRefreshView = (CommonRefreshView) findViewById(d73.C3);
        this.h = commonRefreshView;
        commonRefreshView.setEmptyLayoutId(z73.S1);
        this.h.setLayoutManager(new LinearLayoutManager(this.b, 1, false));
        this.h.setDataHelper(new a());
        this.h.k();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        CommonRefreshView commonRefreshView;
        super/*androidx.fragment.app.FragmentActivity*/.onActivityResult(i, i2, intent);
        if (i2 != -1 || (commonRefreshView = this.h) == null) {
            return;
        }
        commonRefreshView.k();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == d73.Q) {
            WebViewActivity.E1(this.b, wg1.s);
        } else if (id == d73.P) {
            SellerCashActivity.C1(this.b, this.j, this.k);
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        ec2.u("getSellerAccountInfo");
        super.onDestroy();
    }
}
