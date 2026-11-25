package com.yunbao.common.activity;

import android.content.Intent;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yunbao.common.bean.TxLocationPoiBean;
import com.yunbao.common.custom.CommonRefreshView;
import com.yunbao.common.http.CommonHttpConsts;
import com.yunbao.common.http.CommonHttpUtil;
import com.yunbao.common.http.HttpCallback;
import defpackage.aq4;
import defpackage.ce3;
import defpackage.et2;
import defpackage.j30;
import defpackage.l72;
import defpackage.m93;
import defpackage.pw3;
import defpackage.rz;
import defpackage.u73;
import defpackage.y63;
import defpackage.zu0;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: /tmp/classes2.dex */
public class ChooseLocationActivity extends AbsActivity implements et2 {
    public CommonRefreshView e;
    public rz f;

    /* loaded from: /tmp/classes2.dex */
    public class a implements CommonRefreshView.e {
        public a() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public ce3 getAdapter() {
            if (ChooseLocationActivity.this.f == null) {
                ChooseLocationActivity chooseLocationActivity = ChooseLocationActivity.this;
                chooseLocationActivity.f = new rz(chooseLocationActivity.b);
                ChooseLocationActivity.this.f.R(ChooseLocationActivity.this);
            }
            return ChooseLocationActivity.this.f;
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void loadData(int i, HttpCallback httpCallback) {
            double v = j30.q().v();
            double r = j30.q().r();
            if (v == 0.0d || r == 0.0d) {
                return;
            }
            CommonHttpUtil.getAddressInfoByTxLocaitonSdk(v, r, 1, i, CommonHttpConsts.GET_MAP_INFO, httpCallback);
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
            if (parseObject != null) {
                return JSON.parseArray(parseObject.getString("pois"), TxLocationPoiBean.class);
            }
            return null;
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return u73.b;
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.b5));
        CommonRefreshView commonRefreshView = (CommonRefreshView) findViewById(y63.b0);
        this.e = commonRefreshView;
        commonRefreshView.setLayoutManager(new LinearLayoutManager(this.b, 1, false));
        this.e.setDataHelper(new a());
        if (j30.q().r() == 0.0d || j30.q().v() == 0.0d) {
            zu0.c().n(this);
            return;
        }
        CommonRefreshView commonRefreshView2 = this.e;
        if (commonRefreshView2 != null) {
            commonRefreshView2.k();
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        if (zu0.c().h(this)) {
            zu0.c().p(this);
        }
        super.onDestroy();
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onLocationEvent(l72 l72Var) {
        CommonRefreshView commonRefreshView = this.e;
        if (commonRefreshView != null) {
            commonRefreshView.k();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.et2
    /* renamed from: y1, reason: merged with bridge method [inline-methods] */
    public void onItemClick(TxLocationPoiBean txLocationPoiBean, int i) {
        Intent intent = new Intent();
        intent.putExtra("chooseLocation", txLocationPoiBean != null ? txLocationPoiBean.getTitle() : "");
        setResult(-1, intent);
        finish();
    }
}
