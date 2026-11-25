package com.yunbao.mall.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.umeng.analytics.pro.cl;

/* loaded from: /tmp/classes2.dex */
public class OrderMsgBean {
    private String mAddTime;
    private String mAvatar;
    private int mIsYong;
    private String mOrderId;
    private int mStatus;
    private String mTitle;
    private int mType;

    @JSONField(name = "addtime")
    public String getAddTime() {
        return this.mAddTime;
    }

    @JSONField(name = "avatar")
    public String getAvatar() {
        return this.mAvatar;
    }

    @JSONField(name = "is_commission")
    public int getIsYong() {
        return this.mIsYong;
    }

    @JSONField(name = "orderid")
    public String getOrderId() {
        return this.mOrderId;
    }

    @JSONField(name = cl.i)
    public int getStatus() {
        return this.mStatus;
    }

    @JSONField(name = "title")
    public String getTitle() {
        return this.mTitle;
    }

    @JSONField(name = "type")
    public int getType() {
        return this.mType;
    }

    @JSONField(name = "addtime")
    public void setAddTime(String str) {
        this.mAddTime = str;
    }

    @JSONField(name = "avatar")
    public void setAvatar(String str) {
        this.mAvatar = str;
    }

    @JSONField(name = "is_commission")
    public void setIsYong(int i) {
        this.mIsYong = i;
    }

    @JSONField(name = "orderid")
    public void setOrderId(String str) {
        this.mOrderId = str;
    }

    @JSONField(name = cl.i)
    public void setStatus(int i) {
        this.mStatus = i;
    }

    @JSONField(name = "title")
    public void setTitle(String str) {
        this.mTitle = str;
    }

    @JSONField(name = "type")
    public void setType(int i) {
        this.mType = i;
    }
}
