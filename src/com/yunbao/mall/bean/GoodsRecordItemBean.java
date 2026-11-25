package com.yunbao.mall.bean;

import com.alibaba.fastjson.annotation.JSONField;

/* loaded from: /tmp/classes2.dex */
public class GoodsRecordItemBean extends GoodsRecordBean {
    private String mGoodsId;
    private String mId;
    private String mName;
    private String mOriginPrice;
    private GoodsRecordTitleBean mParent;
    private String mPrice;
    private int mStatus;
    private String mThumb;
    private int mType;
    private String mUid;

    @JSONField(name = "goodsid")
    public String getGoodsId() {
        return this.mGoodsId;
    }

    @JSONField(name = "id")
    public String getId() {
        return this.mId;
    }

    @JSONField(name = "goods_name")
    public String getName() {
        return this.mName;
    }

    @JSONField(name = "original_price")
    public String getOriginPrice() {
        return this.mOriginPrice;
    }

    @JSONField(serialize = false)
    public GoodsRecordTitleBean getParent() {
        return this.mParent;
    }

    @JSONField(name = "goods_price")
    public String getPrice() {
        return this.mPrice;
    }

    @JSONField(name = "goods_status")
    public int getStatus() {
        return this.mStatus;
    }

    @JSONField(name = "goods_thumb")
    public String getThumb() {
        return this.mThumb;
    }

    @JSONField(name = "type")
    public int getType() {
        return this.mType;
    }

    @JSONField(name = "uid")
    public String getUid() {
        return this.mUid;
    }

    @JSONField(name = "goodsid")
    public void setGoodsId(String str) {
        this.mGoodsId = str;
    }

    @JSONField(name = "id")
    public void setId(String str) {
        this.mId = str;
    }

    @JSONField(name = "goods_name")
    public void setName(String str) {
        this.mName = str;
    }

    @JSONField(name = "original_price")
    public void setOriginPrice(String str) {
        this.mOriginPrice = str;
    }

    @JSONField(serialize = false)
    public void setParent(GoodsRecordTitleBean goodsRecordTitleBean) {
        this.mParent = goodsRecordTitleBean;
    }

    @JSONField(name = "goods_price")
    public void setPrice(String str) {
        this.mPrice = str;
    }

    @JSONField(name = "goods_status")
    public void setStatus(int i) {
        this.mStatus = i;
    }

    @JSONField(name = "goods_thumb")
    public void setThumb(String str) {
        this.mThumb = str;
    }

    @JSONField(name = "type")
    public void setType(int i) {
        this.mType = i;
    }

    @JSONField(name = "uid")
    public void setUid(String str) {
        this.mUid = str;
    }
}
