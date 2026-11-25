package com.yunbao.live.bean;

import com.alibaba.fastjson.annotation.JSONField;

/* loaded from: /tmp/classes2.dex */
public class LiveGiftPrizePoolWinBean {
    private String mAvatar;
    private String mCoin;
    private String mName;
    private String mUid;

    @JSONField(name = "uhead")
    public String getAvatar() {
        return this.mAvatar;
    }

    @JSONField(name = "wincoin")
    public String getCoin() {
        return this.mCoin;
    }

    @JSONField(name = "uname")
    public String getName() {
        return this.mName;
    }

    @JSONField(name = "uid")
    public String getUid() {
        return this.mUid;
    }

    @JSONField(name = "uhead")
    public void setAvatar(String str) {
        this.mAvatar = str;
    }

    @JSONField(name = "wincoin")
    public void setCoin(String str) {
        this.mCoin = str;
    }

    @JSONField(name = "uname")
    public void setName(String str) {
        this.mName = str;
    }

    @JSONField(name = "uid")
    public void setUid(String str) {
        this.mUid = str;
    }
}
