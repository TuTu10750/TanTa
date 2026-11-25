package com.yunbao.live.bean;

import com.alibaba.fastjson.annotation.JSONField;

/* loaded from: /tmp/classes2.dex */
public class GlobalGiftBean {
    private String mGiftName;
    private String mLiveName;
    private String mLiveUid;
    private String mUserName;

    @JSONField(name = "giftname")
    public String getGiftName() {
        return this.mGiftName;
    }

    @JSONField(name = "livename")
    public String getLiveName() {
        return this.mLiveName;
    }

    @JSONField(name = "liveuid")
    public String getLiveUid() {
        return this.mLiveUid;
    }

    @JSONField(name = "uname")
    public String getUserName() {
        return this.mUserName;
    }

    @JSONField(name = "giftname")
    public void setGiftName(String str) {
        this.mGiftName = str;
    }

    @JSONField(name = "livename")
    public void setLiveName(String str) {
        this.mLiveName = str;
    }

    @JSONField(name = "liveuid")
    public void setLiveUid(String str) {
        this.mLiveUid = str;
    }

    @JSONField(name = "uname")
    public void setUserName(String str) {
        this.mUserName = str;
    }
}
