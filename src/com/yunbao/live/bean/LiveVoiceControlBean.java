package com.yunbao.live.bean;

import com.alibaba.fastjson.annotation.JSONField;

/* loaded from: /tmp/classes2.dex */
public class LiveVoiceControlBean {
    private String mAvatar;
    private int mLevel;
    private int mPosition;
    private int mSex;
    private int mStatus;
    private String mUid;
    private String mUserName;

    @JSONField(name = "avatar")
    public String getAvatar() {
        return this.mAvatar;
    }

    @JSONField(name = "level")
    public int getLevel() {
        return this.mLevel;
    }

    @JSONField(name = "position")
    public int getPosition() {
        return this.mPosition;
    }

    @JSONField(name = "sex")
    public int getSex() {
        return this.mSex;
    }

    @JSONField(name = "mic_status")
    public int getStatus() {
        return this.mStatus;
    }

    @JSONField(name = "id")
    public String getUid() {
        return this.mUid;
    }

    @JSONField(name = "user_nickname")
    public String getUserName() {
        return this.mUserName;
    }

    @JSONField(name = "avatar")
    public void setAvatar(String str) {
        this.mAvatar = str;
    }

    @JSONField(name = "level")
    public void setLevel(int i) {
        this.mLevel = i;
    }

    @JSONField(name = "position")
    public void setPosition(int i) {
        this.mPosition = i;
    }

    @JSONField(name = "sex")
    public void setSex(int i) {
        this.mSex = i;
    }

    @JSONField(name = "mic_status")
    public void setStatus(int i) {
        this.mStatus = i;
    }

    @JSONField(name = "id")
    public void setUid(String str) {
        this.mUid = str;
    }

    @JSONField(name = "user_nickname")
    public void setUserName(String str) {
        this.mUserName = str;
    }
}
