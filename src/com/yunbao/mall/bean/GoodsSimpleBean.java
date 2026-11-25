package com.yunbao.mall.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.umeng.commonsdk.deeplink.DeepLinkPresetEvent;

/* loaded from: /tmp/classes2.dex */
public class GoodsSimpleBean {
    protected String mId;
    protected String mName;
    protected String mOriginPrice;
    protected String mPrice;
    protected String mPriceYong;
    protected String mSaleNum;
    protected String mThumb;
    protected int mType;

    @JSONField(name = "id")
    public String getId() {
        return this.mId;
    }

    @JSONField(name = "name")
    public String getName() {
        return this.mName;
    }

    @JSONField(name = "original_price")
    public String getOriginPrice() {
        return this.mOriginPrice;
    }

    @JSONField(name = DeepLinkPresetEvent.UMEventParamPrice)
    public String getPrice() {
        return this.mPrice;
    }

    @JSONField(name = "commission")
    public String getPriceYong() {
        return this.mPriceYong;
    }

    @JSONField(name = "sale_nums")
    public String getSaleNum() {
        return this.mSaleNum;
    }

    @JSONField(name = "thumb")
    public String getThumb() {
        return this.mThumb;
    }

    @JSONField(name = "type")
    public int getType() {
        return this.mType;
    }

    @JSONField(name = "id")
    public void setId(String str) {
        this.mId = str;
    }

    @JSONField(name = "name")
    public void setName(String str) {
        this.mName = str;
    }

    @JSONField(name = "original_price")
    public void setOriginPrice(String str) {
        this.mOriginPrice = str;
    }

    @JSONField(name = DeepLinkPresetEvent.UMEventParamPrice)
    public void setPrice(String str) {
        this.mPrice = str;
    }

    @JSONField(name = "commission")
    public void setPriceYong(String str) {
        this.mPriceYong = str;
    }

    @JSONField(name = "sale_nums")
    public void setSaleNum(String str) {
        this.mSaleNum = str;
    }

    @JSONField(name = "thumb")
    public void setThumb(String str) {
        this.mThumb = str;
    }

    @JSONField(name = "type")
    public void setType(int i) {
        this.mType = i;
    }
}
