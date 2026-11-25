package com.yunbao.mall.bean;

import com.alibaba.fastjson.annotation.JSONField;

/* loaded from: /tmp/classes2.dex */
public class BuyerRefundRecordBean {
    private String mAddTime;
    private String mBalance;
    private String mId;
    private String mResult;
    private String mToUid;

    @JSONField(name = "addtime")
    public String getAddTime() {
        return this.mAddTime;
    }

    @JSONField(name = "balance")
    public String getBalance() {
        return this.mBalance;
    }

    @JSONField(name = "id")
    public String getId() {
        return this.mId;
    }

    @JSONField(name = "result")
    public String getResult() {
        return this.mResult;
    }

    @JSONField(name = "touid")
    public String getToUid() {
        return this.mToUid;
    }

    @JSONField(name = "addtime")
    public void setAddTime(String str) {
        this.mAddTime = str;
    }

    @JSONField(name = "balance")
    public void setBalance(String str) {
        this.mBalance = str;
    }

    @JSONField(name = "id")
    public void setId(String str) {
        this.mId = str;
    }

    @JSONField(name = "result")
    public void setResult(String str) {
        this.mResult = str;
    }

    @JSONField(name = "touid")
    public void setToUid(String str) {
        this.mToUid = str;
    }
}
