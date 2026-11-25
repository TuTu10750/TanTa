package com.yunbao.main.activity;

import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.custom.CommonRefreshView;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.main.bean.GoodsShareUserBean;
import defpackage.aq4;
import defpackage.c73;
import defpackage.ce3;
import defpackage.ck1;
import defpackage.db2;
import defpackage.j30;
import defpackage.m93;
import defpackage.nd1;
import defpackage.y73;
import defpackage.z73;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class GoodsShareFriendActivity extends AbsActivity implements View.OnClickListener {
    public CommonRefreshView e;
    public nd1 f;
    public String g;
    public Dialog h;

    /* loaded from: /tmp/classes2.dex */
    public class a implements CommonRefreshView.e {
        public a() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public ce3 getAdapter() {
            if (GoodsShareFriendActivity.this.f == null) {
                GoodsShareFriendActivity goodsShareFriendActivity = GoodsShareFriendActivity.this;
                goodsShareFriendActivity.f = new nd1(goodsShareFriendActivity.b);
            }
            return GoodsShareFriendActivity.this.f;
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void loadData(int i, HttpCallback httpCallback) {
            db2.Q(j30.q().C(), i, httpCallback);
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
            return JSON.parseArray(Arrays.toString(strArr), GoodsShareUserBean.class);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (GoodsShareFriendActivity.this.h != null && GoodsShareFriendActivity.this.h.isShowing()) {
                GoodsShareFriendActivity.this.h.dismiss();
                GoodsShareFriendActivity.this.h = null;
            }
            GoodsShareFriendActivity.this.finish();
        }
    }

    private void B1() {
        nd1 nd1Var;
        List<GoodsShareUserBean> N;
        if (TextUtils.isEmpty(this.g) || (nd1Var = this.f) == null || (N = nd1Var.N()) == null || N.size() == 0) {
            return;
        }
        ArrayList arrayList = null;
        for (GoodsShareUserBean goodsShareUserBean : N) {
            if (goodsShareUserBean.isChecked()) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(goodsShareUserBean.getId());
            }
        }
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        if (this.h == null) {
            this.h = com.yunbao.common.utils.a.d(this.b, aq4.a(m93.N));
        }
        this.h.show();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("method", "GoodsMsg");
        jSONObject.put("goodsid", this.g);
        ck1.e().r(arrayList, jSONObject.toJSONString(), new b());
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return z73.w;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        this.g = getIntent().getStringExtra("mallGoodsId");
        findViewById(c73.f1).setOnClickListener(this);
        CommonRefreshView commonRefreshView = (CommonRefreshView) findViewById(c73.r4);
        this.e = commonRefreshView;
        commonRefreshView.setEmptyLayoutId(y73.y1);
        this.e.setLayoutManager(new LinearLayoutManager(this.b, 1, false));
        this.e.setDataHelper(new a());
        this.e.k();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == c73.f1) {
            B1();
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        Dialog dialog = this.h;
        if (dialog != null && dialog.isShowing()) {
            this.h.dismiss();
            this.h = null;
        }
        db2.i("getFollowList");
        super.onDestroy();
    }
}
