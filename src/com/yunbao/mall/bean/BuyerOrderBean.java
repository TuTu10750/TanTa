package com.yunbao.mall.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.umeng.analytics.pro.cl;
import com.umeng.commonsdk.deeplink.DeepLinkPresetEvent;

/* loaded from: /tmp/classes2.dex */
public class BuyerOrderBean {
    private String mGoodsId;
    private String mGoodsName;
    private String mGoodsNum;
    private String mGoodsPrice;
    private String mGoodsSpecName;
    private String mGoodsSpecThumb;
    private String mId;
    private int mIsAppend;
    private int mRefundStatus;
    private String mSellerId;
    private String mShopName;
    private int mStatus;
    private String mStatusTip;
    private String mTotalPrice;
    private String mUid;

    @JSONField(name = "goodsid")
    public String getGoodsId() {
        return this.mGoodsId;
    }

    @JSONField(name = "goods_name")
    public String getGoodsName() {
        return this.mGoodsName;
    }

    @JSONField(name = "nums")
    public String getGoodsNum() {
        return this.mGoodsNum;
    }

    @JSONField(name = DeepLinkPresetEvent.UMEventParamPrice)
    public String getGoodsPrice() {
        return this.mGoodsPrice;
    }

    @JSONField(name = "spec_name")
    public String getGoodsSpecName() {
        return this.mGoodsSpecName;
    }

    @JSONField(name = "spec_thumb")
    public String getGoodsSpecThumb() {
        return this.mGoodsSpecThumb;
    }

    @JSONField(name = "id")
    public String getId() {
        return this.mId;
    }

    @JSONField(name = "is_append_evaluate")
    public int getIsAppend() {
        return this.mIsAppend;
    }

    @JSONField(name = "refund_status")
    public int getRefundStatus() {
        return this.mRefundStatus;
    }

    @JSONField(name = "shop_uid")
    public String getSellerId() {
        return this.mSellerId;
    }

    @JSONField(name = "shop_name")
    public String getShopName() {
        return this.mShopName;
    }

    @JSONField(name = cl.i)
    public int getStatus() {
        return this.mStatus;
    }

    @JSONField(name = "status_name")
    public String getStatusTip() {
        return this.mStatusTip;
    }

    @JSONField(name = "total")
    public String getTotalPrice() {
        return this.mTotalPrice;
    }

    @JSONField(name = "uid")
    public String getUid() {
        return this.mUid;
    }

    @JSONField(name = "goodsid")
    public void setGoodsId(String str) {
        this.mGoodsId = str;
    }

    @JSONField(name = "goods_name")
    public void setGoodsName(String str) {
        this.mGoodsName = str;
    }

    @JSONField(name = "nums")
    public void setGoodsNum(String str) {
        this.mGoodsNum = str;
    }

    @JSONField(name = DeepLinkPresetEvent.UMEventParamPrice)
    public void setGoodsPrice(String str) {
        this.mGoodsPrice = str;
    }

    @JSONField(name = "spec_name")
    public void setGoodsSpecName(String str) {
        this.mGoodsSpecName = str;
    }

    @JSONField(name = "spec_thumb")
    public void setGoodsSpecThumb(String str) {
        this.mGoodsSpecThumb = str;
    }

    @JSONField(name = "id")
    public void setId(String str) {
        this.mId = str;
    }

    @JSONField(name = "is_append_evaluate")
    public void setIsAppend(int i) {
        this.mIsAppend = i;
    }

    @JSONField(name = "refund_status")
    public void setRefundStatus(int i) {
        this.mRefundStatus = i;
    }

    @JSONField(name = "shop_uid")
    public void setSellerId(String str) {
        this.mSellerId = str;
    }

    @JSONField(name = "shop_name")
    public void setShopName(String str) {
        this.mShopName = str;
    }

    @JSONField(name = cl.i)
    public void setStatus(int i) {
        this.mStatus = i;
    }

    @JSONField(name = "status_name")
    public void setStatusTip(String str) {
        this.mStatusTip = str;
    }

    @JSONField(name = "total")
    public void setTotalPrice(String str) {
        this.mTotalPrice = str;
    }

    @JSONField(name = "uid")
    public void setUid(String str) {
        this.mUid = str;
    }
}
