package com.yunbao.live.bean;

import com.alibaba.fastjson.annotation.JSONField;

/* loaded from: /tmp/classes2.dex */
public class VoiceRoomAccPullBean {
    private int mIsAnchor;
    private String mPull;
    private String mUid;

    @JSONField(name = "isanchor")
    public int getIsAnchor() {
        return this.mIsAnchor;
    }

    @JSONField(name = "pull")
    public String getPull() {
        return this.mPull;
    }

    @JSONField(name = "uid")
    public String getUid() {
        return this.mUid;
    }

    @JSONField(name = "isanchor")
    public void setIsAnchor(int i) {
        this.mIsAnchor = i;
    }

    @JSONField(name = "pull")
    public void setPull(String str) {
        this.mPull = str;
    }

    @JSONField(name = "uid")
    public void setUid(String str) {
        this.mUid = str;
    }
}
