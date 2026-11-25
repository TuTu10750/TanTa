package com.yunbao.mall.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.custom.CommonRefreshView;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.mall.bean.GoodsRecordItemBean;
import com.yunbao.mall.bean.GoodsRecordTitleBean;
import defpackage.aq4;
import defpackage.ce3;
import defpackage.d73;
import defpackage.ec2;
import defpackage.m93;
import defpackage.md1;
import defpackage.t54;
import defpackage.z73;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class GoodsRecordActivity extends AbsActivity implements View.OnClickListener, md1.b {
    public CommonRefreshView e;
    public md1 f;
    public TextView g;
    public View h;
    public View i;
    public ImageView j;
    public HttpCallback k;

    /* loaded from: /tmp/classes2.dex */
    public class a implements CommonRefreshView.e {
        public a() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public ce3 getAdapter() {
            if (GoodsRecordActivity.this.f == null) {
                GoodsRecordActivity goodsRecordActivity = GoodsRecordActivity.this;
                goodsRecordActivity.f = new md1(goodsRecordActivity.b);
                GoodsRecordActivity.this.f.f0(GoodsRecordActivity.this);
            }
            return GoodsRecordActivity.this.f;
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void loadData(int i, HttpCallback httpCallback) {
            ec2.E(i, httpCallback);
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
            if (GoodsRecordActivity.this.g != null) {
                if (list == null || list.size() <= 0) {
                    if (GoodsRecordActivity.this.g.getVisibility() == 0) {
                        GoodsRecordActivity.this.g.setVisibility(4);
                    }
                } else if (GoodsRecordActivity.this.g.getVisibility() != 0) {
                    GoodsRecordActivity.this.g.setVisibility(0);
                }
            }
            if (GoodsRecordActivity.this.h == null || GoodsRecordActivity.this.h.getVisibility() == 8) {
                return;
            }
            GoodsRecordActivity.this.h.setVisibility(8);
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public List processData(String[] strArr) {
            JSONArray parseArray = JSON.parseArray(Arrays.toString(strArr));
            ArrayList arrayList = new ArrayList();
            int size = parseArray.size();
            for (int i = 0; i < size; i++) {
                JSONObject jSONObject = parseArray.getJSONObject(i);
                GoodsRecordTitleBean goodsRecordTitleBean = new GoodsRecordTitleBean();
                goodsRecordTitleBean.setDate(jSONObject.getString("date"));
                arrayList.add(goodsRecordTitleBean);
                List<GoodsRecordItemBean> parseArray2 = JSON.parseArray(jSONObject.getString("list"), GoodsRecordItemBean.class);
                goodsRecordTitleBean.setItemList(parseArray2);
                Iterator<GoodsRecordItemBean> it = parseArray2.iterator();
                while (it.hasNext()) {
                    it.next().setParent(goodsRecordTitleBean);
                }
                arrayList.addAll(parseArray2);
            }
            return arrayList;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends HttpCallback {
        public b() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i == 0 && GoodsRecordActivity.this.e != null) {
                GoodsRecordActivity.this.e.k();
            }
            t54.b(str);
        }
    }

    public static void F1(Context context) {
        context.startActivity(new Intent(context, (Class<?>) GoodsRecordActivity.class));
    }

    @Override // md1.b
    public void B(boolean z) {
        View view = this.i;
        if (view != null) {
            view.setEnabled(z);
        }
    }

    public final void C1() {
        md1 md1Var = this.f;
        if (md1Var != null) {
            md1Var.g0();
        }
    }

    public final void D1() {
        md1 md1Var = this.f;
        if (md1Var == null) {
            return;
        }
        String e0 = md1Var.e0();
        if (TextUtils.isEmpty(e0)) {
            return;
        }
        if (this.k == null) {
            this.k = new b();
        }
        ec2.p(e0, this.k);
    }

    public final void E1() {
        md1 md1Var = this.f;
        if (md1Var != null) {
            md1Var.h0();
        }
    }

    @Override // md1.b
    public void H0(boolean z) {
        TextView textView = this.g;
        if (z) {
            if (textView != null) {
                textView.setText(m93.S0);
            }
            View view = this.h;
            if (view == null || view.getVisibility() == 0) {
                return;
            }
            this.h.setVisibility(0);
            return;
        }
        if (textView != null) {
            textView.setText(m93.E8);
        }
        View view2 = this.h;
        if (view2 == null || view2.getVisibility() == 8) {
            return;
        }
        this.h.setVisibility(8);
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return z73.u;
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.y6));
        this.g = (TextView) findViewById(d73.A0);
        this.h = findViewById(d73.o);
        this.i = findViewById(d73.m0);
        this.j = (ImageView) findViewById(d73.y2);
        this.g.setOnClickListener(this);
        this.i.setOnClickListener(this);
        findViewById(d73.S).setOnClickListener(this);
        CommonRefreshView commonRefreshView = (CommonRefreshView) findViewById(d73.C3);
        this.e = commonRefreshView;
        commonRefreshView.setEmptyLayoutId(z73.J1);
        this.e.setLayoutManager(new LinearLayoutManager(this.b, 1, false));
        this.e.setDataHelper(new a());
        this.e.k();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == d73.A0) {
            E1();
        } else if (id == d73.S) {
            C1();
        } else if (id == d73.m0) {
            D1();
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        ec2.u("getBuyerGoodsRecord");
        ec2.u("buyerDeleteBrowseRecord");
        super.onDestroy();
    }

    @Override // md1.b
    public void t(Drawable drawable) {
        ImageView imageView = this.j;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
    }
}
