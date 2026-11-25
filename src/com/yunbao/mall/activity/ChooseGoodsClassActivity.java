package com.yunbao.mall.activity;

import android.content.Intent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.mall.bean.GoodsClassBean;
import com.yunbao.mall.bean.GoodsClassTitleBean;
import defpackage.aq4;
import defpackage.d73;
import defpackage.dd1;
import defpackage.ec2;
import defpackage.ed1;
import defpackage.et2;
import defpackage.m93;
import defpackage.z73;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: /tmp/classes2.dex */
public class ChooseGoodsClassActivity extends AbsActivity implements et2 {
    public RecyclerView e;
    public RecyclerView f;
    public dd1 g;
    public ed1 h;

    /* loaded from: /tmp/classes2.dex */
    public class a extends HttpCallback {

        /* renamed from: com.yunbao.mall.activity.ChooseGoodsClassActivity$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/classes2.dex */
        public class C0053a implements et2 {
            public C0053a() {
            }

            @Override // defpackage.et2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onItemClick(GoodsClassTitleBean goodsClassTitleBean, int i) {
                if (ChooseGoodsClassActivity.this.h != null) {
                    ChooseGoodsClassActivity.this.h.P(goodsClassTitleBean.getList());
                }
                if (ChooseGoodsClassActivity.this.f != null) {
                    ChooseGoodsClassActivity.this.f.v1(0);
                }
            }
        }

        public a() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length <= 0) {
                return;
            }
            JSONArray parseArray = JSON.parseArray(Arrays.toString(strArr));
            ArrayList arrayList = new ArrayList();
            int size = parseArray.size();
            int i2 = 0;
            while (true) {
                boolean z = true;
                if (i2 >= size) {
                    break;
                }
                JSONObject jSONObject = parseArray.getJSONObject(i2);
                GoodsClassTitleBean goodsClassTitleBean = new GoodsClassTitleBean();
                String string = jSONObject.getString("gc_id");
                goodsClassTitleBean.setId(string);
                goodsClassTitleBean.setName(jSONObject.getString("gc_name"));
                ArrayList arrayList2 = new ArrayList();
                JSONArray jSONArray = jSONObject.getJSONArray("two_list");
                int size2 = jSONArray.size();
                int i3 = 0;
                while (i3 < size2) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                    GoodsClassBean goodsClassBean = new GoodsClassBean();
                    goodsClassBean.setTitle(z);
                    String string2 = jSONObject2.getString("gc_id");
                    goodsClassBean.setId(string2);
                    JSONArray jSONArray2 = parseArray;
                    goodsClassBean.setName(jSONObject2.getString("gc_name"));
                    arrayList2.add(goodsClassBean);
                    JSONArray jSONArray3 = jSONObject2.getJSONArray("three_list");
                    int i4 = 0;
                    for (int size3 = jSONArray3.size(); i4 < size3; size3 = size3) {
                        int i5 = size;
                        JSONObject jSONObject3 = jSONArray3.getJSONObject(i4);
                        JSONArray jSONArray4 = jSONArray3;
                        GoodsClassBean goodsClassBean2 = new GoodsClassBean();
                        goodsClassBean2.setTitle(false);
                        goodsClassBean2.setId(jSONObject3.getString("gc_id"));
                        goodsClassBean2.setName(jSONObject3.getString("gc_name"));
                        goodsClassBean2.setOneClassId(string);
                        goodsClassBean2.setTwoClassId(string2);
                        arrayList2.add(goodsClassBean2);
                        i4++;
                        size = i5;
                        jSONArray3 = jSONArray4;
                    }
                    i3++;
                    parseArray = jSONArray2;
                    z = true;
                }
                goodsClassTitleBean.setList(arrayList2);
                arrayList.add(goodsClassTitleBean);
                i2++;
            }
            if (arrayList.size() > 0) {
                GoodsClassTitleBean goodsClassTitleBean2 = (GoodsClassTitleBean) arrayList.get(0);
                goodsClassTitleBean2.setChecked(true);
                if (ChooseGoodsClassActivity.this.e != null) {
                    ChooseGoodsClassActivity chooseGoodsClassActivity = ChooseGoodsClassActivity.this;
                    chooseGoodsClassActivity.g = new dd1(chooseGoodsClassActivity.b, arrayList);
                    ChooseGoodsClassActivity.this.g.R(new C0053a());
                    ChooseGoodsClassActivity.this.e.setAdapter(ChooseGoodsClassActivity.this.g);
                }
                if (ChooseGoodsClassActivity.this.f != null) {
                    ChooseGoodsClassActivity chooseGoodsClassActivity2 = ChooseGoodsClassActivity.this;
                    chooseGoodsClassActivity2.h = new ed1(chooseGoodsClassActivity2.b);
                    ChooseGoodsClassActivity.this.h.Q(goodsClassTitleBean2.getList());
                    ChooseGoodsClassActivity.this.h.R(ChooseGoodsClassActivity.this);
                    ChooseGoodsClassActivity.this.f.setAdapter(ChooseGoodsClassActivity.this.h);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.et2
    /* renamed from: E1, reason: merged with bridge method [inline-methods] */
    public void onItemClick(GoodsClassBean goodsClassBean, int i) {
        Intent intent = new Intent();
        intent.putExtra("mallGoodsClass", goodsClassBean);
        setResult(-1, intent);
        finish();
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return z73.n;
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.O5));
        RecyclerView findViewById = findViewById(d73.x3);
        this.e = findViewById;
        findViewById.setHasFixedSize(true);
        this.e.setLayoutManager(new LinearLayoutManager(this.b, 1, false));
        RecyclerView findViewById2 = findViewById(d73.y3);
        this.f = findViewById2;
        findViewById2.setHasFixedSize(true);
        this.f.setLayoutManager(new LinearLayoutManager(this.b, 1, false));
        ec2.K(new a());
    }
}
