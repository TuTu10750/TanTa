package com.yunbao.live.bean;

import com.alibaba.fastjson.annotation.JSONField;
import defpackage.rx1;

/* loaded from: /tmp/classes2.dex */
public class LiveLuckGiftWinBean {
    private String mAvatar;
    private String mGiftId;
    private String mGiftName;
    private String mGiftNameEn;
    private String mLuckTime;
    private String mUid;
    private String mUserNiceName;

    @JSONField(name = "uhead")
    public String getAvatar() {
        return this.mAvatar;
    }

    @JSONField(name = "giftid")
    public String getGiftId() {
        return this.mGiftId;
    }

    @JSONField(name = "giftname")
    public String getGiftName() {
        return "en".equals(rx1.c().d()) ? this.mGiftNameEn : this.mGiftName;
    }

    @JSONField(name = "giftname_en")
    public String getGiftNameEn() {
        return this.mGiftNameEn;
    }

    @JSONField(name = "lucktimes")
    public String getLuckTime() {
        return this.mLuckTime;
    }

    @JSONField(name = "uid")
    public String getUid() {
        return this.mUid;
    }

    @JSONField(name = "uname")
    public String getUserNiceName() {
        return this.mUserNiceName;
    }

    @JSONField(name = "uhead")
    public void setAvatar(String str) {
        this.mAvatar = str;
    }

    @JSONField(name = "giftid")
    public void setGiftId(String str) {
        this.mGiftId = str;
    }

    @JSONField(name = "giftname")
    public void setGiftName(String str) {
        this.mGiftName = str;
    }

    @JSONField(name = "giftname_en")
    public void setGiftNameEn(String str) {
        this.mGiftNameEn = str;
    }

    @JSONField(name = "lucktimes")
    public void setLuckTime(String str) {
        this.mLuckTime = str;
    }

    @JSONField(name = "uid")
    public void setUid(String str) {
        this.mUid = str;
    }

    @JSONField(name = "uname")
    public void setUserNiceName(String str) {
        this.mUserNiceName = str;
    }
}
