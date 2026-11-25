package com.yunbao.mall.bean;

import com.alibaba.fastjson.annotation.JSONField;

/* loaded from: /tmp/classes2.dex */
public class GoodsPlatBean extends GoodsSimpleBean {
    private int mAdd;
    private String mPriceYong;

    @JSONField(name = "isadd")
    public int getAdd() {
        return this.mAdd;
    }

    @Override // com.yunbao.mall.bean.GoodsSimpleBean
    @JSONField(name = "commission")
    public String getPriceYong() {
        return this.mPriceYong;
    }

    @JSONField(name = "isadd")
    public void setAdd(int i) {
        this.mAdd = i;
    }

    @Override // com.yunbao.mall.bean.GoodsSimpleBean
    @JSONField(name = "commission")
    public void setPriceYong(String str) {
        this.mPriceYong = str;
    }
}
