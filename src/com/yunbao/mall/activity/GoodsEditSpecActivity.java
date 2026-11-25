package com.yunbao.mall.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.http.CommonHttpConsts;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.mall.bean.AddGoodsSpecBean;
import defpackage.aq4;
import defpackage.d73;
import defpackage.ec2;
import defpackage.jd1;
import defpackage.m93;
import defpackage.t54;
import defpackage.z73;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class GoodsEditSpecActivity extends AbsActivity implements View.OnClickListener {
    public String e;
    public RecyclerView f;
    public jd1 g;

    /* loaded from: /tmp/classes2.dex */
    public class a extends HttpCallback {
        public a() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length <= 0) {
                return;
            }
            List parseArray = JSON.parseArray(JSON.parseObject(strArr[0]).getJSONObject("goods_info").getString("specs"), AddGoodsSpecBean.class);
            GoodsEditSpecActivity goodsEditSpecActivity = GoodsEditSpecActivity.this;
            goodsEditSpecActivity.g = new jd1(goodsEditSpecActivity.b, parseArray);
            if (GoodsEditSpecActivity.this.f != null) {
                GoodsEditSpecActivity.this.f.setAdapter(GoodsEditSpecActivity.this.g);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends HttpCallback {
        public b() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i == 0) {
                GoodsEditSpecActivity.this.finish();
            }
            t54.b(str);
        }
    }

    public static void A1(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) GoodsEditSpecActivity.class);
        intent.putExtra("mallGoodsId", str);
        context.startActivity(intent);
    }

    private void B1() {
        List N;
        jd1 jd1Var = this.g;
        if (jd1Var == null || (N = jd1Var.N()) == null || N.size() == 0) {
            return;
        }
        ec2.p0(this.e, JSON.toJSONString(N), new b());
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return z73.r;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.e6));
        RecyclerView findViewById = findViewById(d73.u3);
        this.f = findViewById;
        findViewById.setLayoutManager(new LinearLayoutManager(this.b, 1, false));
        this.e = getIntent().getStringExtra("mallGoodsId");
        findViewById(d73.n1).setOnClickListener(this);
        ec2.N(this.e, new a());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d73.n1) {
            B1();
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        ec2.u(CommonHttpConsts.GET_GOODS_INFO);
        ec2.u("goodsModifySpec");
        super.onDestroy();
    }
}
