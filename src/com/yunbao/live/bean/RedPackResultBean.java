package com.yunbao.live.bean;

import com.alibaba.fastjson.annotation.JSONField;

/* loaded from: /tmp/classes2.dex */
public class RedPackResultBean {
    private String avatar;
    private String time;
    private String uid;
    private String userNiceName;
    private String winCoin;

    public String getAvatar() {
        return this.avatar;
    }

    public String getTime() {
        return this.time;
    }

    public String getUid() {
        return this.uid;
    }

    @JSONField(name = "user_nickname")
    public String getUserNiceName() {
        return this.userNiceName;
    }

    @JSONField(name = "win")
    public String getWinCoin() {
        return this.winCoin;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public void setTime(String str) {
        this.time = str;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    @JSONField(name = "user_nickname")
    public void setUserNiceName(String str) {
        this.userNiceName = str;
    }

    @JSONField(name = "win")
    public void setWinCoin(String str) {
        this.winCoin = str;
    }
}
