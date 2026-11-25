package com.yunbao.live.bean;

import com.alibaba.fastjson.annotation.JSONField;

/* loaded from: /tmp/classes2.dex */
public class LiveDanMuBean {
    private String avatar;
    private String content;
    private int level;
    private String uid;
    private String userNiceName;
    private String votes;

    public String getAvatar() {
        return this.avatar;
    }

    public String getContent() {
        return this.content;
    }

    public int getLevel() {
        return this.level;
    }

    public String getUid() {
        return this.uid;
    }

    public String getUserNiceName() {
        return this.userNiceName;
    }

    @JSONField(name = "votestotal")
    public String getVotes() {
        return this.votes;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void setUserNiceName(String str) {
        this.userNiceName = str;
    }

    @JSONField(name = "votestotal")
    public void setVotes(String str) {
        this.votes = str;
    }
}
