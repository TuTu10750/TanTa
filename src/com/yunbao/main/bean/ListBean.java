package com.yunbao.main.bean;

import com.alibaba.fastjson.annotation.JSONField;

/* loaded from: /tmp/classes2.dex */
public class ListBean {
    private int attention;
    private String avatarThumb;
    private int level;
    private int levelAnchor;
    private int sex;
    private String totalCoin;
    private String uid;
    private String userNiceName;

    @JSONField(name = "isAttention")
    public int getAttention() {
        return this.attention;
    }

    @JSONField(name = "avatar_thumb")
    public String getAvatarThumb() {
        return this.avatarThumb;
    }

    public int getLevel() {
        return this.level;
    }

    public int getLevelAnchor() {
        return this.levelAnchor;
    }

    public int getSex() {
        return this.sex;
    }

    @JSONField(name = "totalcoin")
    public String getTotalCoin() {
        return this.totalCoin;
    }

    public String getTotalCoinFormat() {
        return this.totalCoin;
    }

    public String getUid() {
        return this.uid;
    }

    @JSONField(name = "user_nickname")
    public String getUserNiceName() {
        return this.userNiceName;
    }

    @JSONField(name = "isAttention")
    public void setAttention(int i) {
        this.attention = i;
    }

    @JSONField(name = "avatar_thumb")
    public void setAvatarThumb(String str) {
        this.avatarThumb = str;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    public void setLevelAnchor(int i) {
        this.levelAnchor = i;
    }

    public void setSex(int i) {
        this.sex = i;
    }

    @JSONField(name = "totalcoin")
    public void setTotalCoin(String str) {
        this.totalCoin = str;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    @JSONField(name = "user_nickname")
    public void setUserNiceName(String str) {
        this.userNiceName = str;
    }
}
