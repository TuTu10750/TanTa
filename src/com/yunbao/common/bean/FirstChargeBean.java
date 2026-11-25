package com.yunbao.common.bean;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class FirstChargeBean {
    private String mCoin;
    private String mId;
    private List<FirstChargeItemBean> mList;
    private String mMoney;
    private String mTitle;

    @JSONField(name = "coin")
    public String getCoin() {
        return this.mCoin;
    }

    @JSONField(name = "id")
    public String getId() {
        return this.mId;
    }

    @JSONField(name = "list")
    public List<FirstChargeItemBean> getList() {
        return this.mList;
    }

    @JSONField(name = "money")
    public String getMoney() {
        return this.mMoney;
    }

    @JSONField(name = "title")
    public String getTitle() {
        return this.mTitle;
    }

    @JSONField(name = "coin")
    public void setCoin(String str) {
        this.mCoin = str;
    }

    @JSONField(name = "id")
    public void setId(String str) {
        this.mId = str;
    }

    @JSONField(name = "list")
    public void setList(List<FirstChargeItemBean> list) {
        this.mList = list;
    }

    @JSONField(name = "money")
    public void setMoney(String str) {
        this.mMoney = str;
    }

    @JSONField(name = "title")
    public void setTitle(String str) {
        this.mTitle = str;
    }
}
