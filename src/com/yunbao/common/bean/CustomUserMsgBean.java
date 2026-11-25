package com.yunbao.common.bean;

import com.google.gson.annotations.SerializedName;

/* loaded from: /tmp/classes2.dex */
public class CustomUserMsgBean {

    @SerializedName("isAdmin")
    public int isAdmin;

    @SerializedName("isGuard")
    public int isGuard;

    @SerializedName("isVip")
    public int isVip;

    @SerializedName("level")
    public int level;

    @SerializedName("liang")
    public int liang;

    @SerializedName("text")
    public String text;

    public String toString() {
        return "{isVip=" + this.isVip + ", isGuard=" + this.isGuard + ", isAdmin=" + this.isAdmin + ", level=" + this.level + ", text=" + this.text + ", liang=" + this.liang + "}";
    }
}
