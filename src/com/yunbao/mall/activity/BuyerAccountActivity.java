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
public class BuyerAccountActivity extends AbsActivity implements View.OnClickListener {
    public TextView e;
    public TextView f;
    public CommonRefreshView g;
    public am h;
    public String i;

    /* loaded from: /tmp/classes2.dex */
    public class a implements CommonRefreshView.e {
        public a() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public ce3 getAdapter() {
            if (BuyerAccountActivity.this.h == null) {
                BuyerAccountActivity buyerAccountActivity = BuyerAccountActivity.this;
                buyerAccountActivity.h = new am(buyerAccountActivity.b);
            }
            return BuyerAccountActivity.this.h;
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void loadData(int i, HttpCallback httpCallback) {
            ec2.C(i, httpCallback);
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
            BuyerAccountActivity.this.i = jSONObject.getString("balance");
            if (BuyerAccountActivity.this.e != null) {
                TextView textView = BuyerAccountActivity.this.e;
                BuyerAccountActivity buyerAccountActivity = BuyerAccountActivity.this;
                textView.setText(buyerAccountActivity.F1(buyerAccountActivity.i));
            }
            if (BuyerAccountActivity.this.f != null) {
                BuyerAccountActivity.this.f.setText(rv3.a(aq4.a(m93.O8), BuyerAccountActivity.this.i));
            }
            return JSON.parseArray(parseObject.getString("list"), BuyerRefundRecordBean.class);
        }
    }

    public static void E1(Context context) {
        context.startActivity(new Intent(context, (Class<?>) BuyerAccountActivity.class));
    }

    public final CharSequence F1(String str) {
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
        return z73.b;
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.q5));
        this.e = (TextView) findViewById(d73.n4);
        this.f = (TextView) findViewById(d73.m);
        findViewById(d73.Q).setOnClickListener(this);
        findViewById(d73.P).setOnClickListener(this);
        CommonRefreshView commonRefreshView = (CommonRefreshView) findViewById(d73.C3);
        this.g = commonRefreshView;
        commonRefreshView.setEmptyLayoutId(z73.R1);
        this.g.setLayoutManager(new LinearLayoutManager(this.b, 1, false));
        this.g.setDataHelper(new a());
        this.g.k();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        CommonRefreshView commonRefreshView;
        super/*androidx.fragment.app.FragmentActivity*/.onActivityResult(i, i2, intent);
        if (i2 != -1 || (commonRefreshView = this.g) == null) {
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
            BuyerCashActivity.C1(this.b, this.i);
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        ec2.u("getBuyerAccountInfo");
        super.onDestroy();
    }
}
