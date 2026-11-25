package com.yunbao.live.livegame.luckpan.bean;

import com.alibaba.fastjson.annotation.JSONField;

/* loaded from: /tmp/classes2.dex */
public class LuckRankBean {
    private String mAvatar;
    private String mCoin;
    private String mUserName;

    @JSONField(name = "avatar")
    public String getAvatar() {
        return this.mAvatar;
    }

    @JSONField(name = "total")
    public String getCoin() {
        return this.mCoin;
    }

    @JSONField(name = "user_nickname")
    public String getUserName() {
        return this.mUserName;
    }

    @JSONField(name = "avatar")
    public void setAvatar(String str) {
        this.mAvatar = str;
    }

    @JSONField(name = "total")
    public void setCoin(String str) {
        this.mCoin = str;
    }

    @JSONField(name = "user_nickname")
    public void setUserName(String str) {
        this.mUserName = str;
    }
}
