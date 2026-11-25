package com.yunbao.mall.activity;

import android.content.Intent;
import android.text.TextUtils;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.alibaba.fastjson.JSON;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.custom.CommonRefreshView;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.mall.bean.PayContentClassBean;
import defpackage.aq4;
import defpackage.ce3;
import defpackage.cx2;
import defpackage.d73;
import defpackage.ec2;
import defpackage.et2;
import defpackage.m93;
import defpackage.z73;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class PayContentClassActivity extends AbsActivity implements et2 {
    public String e;
    public cx2 f;

    /* loaded from: /tmp/classes2.dex */
    public class a implements CommonRefreshView.e {
        public a() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public ce3 getAdapter() {
            if (PayContentClassActivity.this.f == null) {
                PayContentClassActivity payContentClassActivity = PayContentClassActivity.this;
                payContentClassActivity.f = new cx2(payContentClassActivity.b);
                PayContentClassActivity.this.f.R(PayContentClassActivity.this);
            }
            return PayContentClassActivity.this.f;
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void loadData(int i, HttpCallback httpCallback) {
            ec2.W(httpCallback);
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
            List parseArray = JSON.parseArray(Arrays.toString(strArr), PayContentClassBean.class);
            if (parseArray != null && parseArray.size() > 0) {
                if (!TextUtils.isEmpty(PayContentClassActivity.this.e)) {
                    Iterator it = parseArray.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        PayContentClassBean payContentClassBean = (PayContentClassBean) it.next();
                        if (PayContentClassActivity.this.e.equals(payContentClassBean.getId())) {
                            payContentClassBean.setChecked(true);
                            break;
                        }
                    }
                } else {
                    ((PayContentClassBean) parseArray.get(0)).setChecked(true);
                    return parseArray;
                }
            }
            return parseArray;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.et2
    /* renamed from: A1, reason: merged with bridge method [inline-methods] */
    public void onItemClick(PayContentClassBean payContentClassBean, int i) {
        Intent intent = new Intent();
        intent.putExtra("classID", payContentClassBean.getId());
        intent.putExtra("className", payContentClassBean.getName());
        setResult(-1, intent);
        finish();
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return z73.D;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.C7));
        this.e = getIntent().getStringExtra("classID");
        CommonRefreshView commonRefreshView = (CommonRefreshView) findViewById(d73.C3);
        commonRefreshView.setLayoutManager(new LinearLayoutManager(this.b, 1, false));
        commonRefreshView.setDataHelper(new a());
        commonRefreshView.k();
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        ec2.u("getPayClassList");
        super.onDestroy();
    }
}
