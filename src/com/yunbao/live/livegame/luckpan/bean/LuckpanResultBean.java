package com.yunbao.live.livegame.luckpan.bean;

import com.alibaba.fastjson.annotation.JSONField;
import defpackage.rx1;

/* loaded from: /tmp/classes2.dex */
public class LuckpanResultBean {
    private String mCount;
    private String mGiftIcon;
    private String mGiftName;
    private String mGiftNameEn;
    private String mTotalCoin;

    @JSONField(name = "nums")
    public String getCount() {
        return this.mCount;
    }

    @JSONField(name = "gifticon")
    public String getGiftIcon() {
        return this.mGiftIcon;
    }

    @JSONField(name = "giftname")
    public String getGiftName() {
        return this.mGiftName;
    }

    @JSONField(name = "giftname_en")
    public String getGiftNameEn() {
        return this.mGiftNameEn;
    }

    public String getGiftNameTrans() {
        return rx1.h() ? this.mGiftName : this.mGiftNameEn;
    }

    @JSONField(name = "total")
    public String getTotalCoin() {
        return this.mTotalCoin;
    }

    @JSONField(name = "nums")
    public void setCount(String str) {
        this.mCount = str;
    }

    @JSONField(name = "gifticon")
    public void setGiftIcon(String str) {
        this.mGiftIcon = str;
    }

    @JSONField(name = "giftname")
    public void setGiftName(String str) {
        this.mGiftName = str;
    }

    @JSONField(name = "giftname_en")
    public void setGiftNameEn(String str) {
        this.mGiftNameEn = str;
    }

    @JSONField(name = "total")
    public void setTotalCoin(String str) {
        this.mTotalCoin = str;
    }
}
