package com.yunbao.mall.activity;

import android.content.Context;
import android.content.Intent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.custom.CommonRefreshView;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.mall.bean.GoodsCommentBean;
import com.yunbao.mall.bean.GoodsCommentTypeBean;
import defpackage.aq4;
import defpackage.ce3;
import defpackage.d73;
import defpackage.ec2;
import defpackage.et2;
import defpackage.gd1;
import defpackage.hd1;
import defpackage.m93;
import defpackage.z73;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class GoodsCommentActivity extends AbsActivity implements et2 {
    public String e;
    public RecyclerView f;
    public hd1 g;
    public CommonRefreshView h;
    public gd1 i;

    /* loaded from: /tmp/classes2.dex */
    public class a implements CommonRefreshView.e {
        public a() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public ce3 getAdapter() {
            if (GoodsCommentActivity.this.i == null) {
                GoodsCommentActivity goodsCommentActivity = GoodsCommentActivity.this;
                goodsCommentActivity.i = new gd1(goodsCommentActivity.b, true);
            }
            return GoodsCommentActivity.this.i;
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void loadData(int i, HttpCallback httpCallback) {
            if (GoodsCommentActivity.this.g == null) {
                return;
            }
            ec2.M(GoodsCommentActivity.this.e, GoodsCommentActivity.this.g.d0(), i, httpCallback);
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
            JSONObject jSONObject = parseObject.getJSONObject("type_nums");
            if (GoodsCommentActivity.this.g != null) {
                GoodsCommentActivity.this.g.e0(jSONObject.getString("all_nums"), jSONObject.getString("img_nums"), jSONObject.getString("video_nums"), jSONObject.getString("append_nums"));
            }
            return JSON.parseArray(parseObject.getString("comment_lists"), GoodsCommentBean.class);
        }
    }

    public static void B1(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) GoodsCommentActivity.class);
        intent.putExtra("mallGoodsId", str);
        context.startActivity(intent);
    }

    @Override // defpackage.et2
    /* renamed from: C1, reason: merged with bridge method [inline-methods] */
    public void onItemClick(GoodsCommentTypeBean goodsCommentTypeBean, int i) {
        CommonRefreshView commonRefreshView = this.h;
        if (commonRefreshView != null) {
            commonRefreshView.k();
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return z73.x;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.t7));
        this.e = getIntent().getStringExtra("mallGoodsId");
        RecyclerView findViewById = findViewById(d73.u3);
        this.f = findViewById;
        findViewById.setLayoutManager(new FlexboxLayoutManager(this.b));
        hd1 hd1Var = new hd1(this.b);
        this.g = hd1Var;
        hd1Var.R(this);
        this.f.setAdapter(this.g);
        CommonRefreshView commonRefreshView = (CommonRefreshView) findViewById(d73.C3);
        this.h = commonRefreshView;
        commonRefreshView.setEmptyLayoutId(z73.L1);
        this.h.setLayoutManager(new LinearLayoutManager(this.b, 1, false));
        this.h.setDataHelper(new a());
        this.h.k();
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        ec2.u("getGoodsCommentList");
        super.onDestroy();
    }
}
