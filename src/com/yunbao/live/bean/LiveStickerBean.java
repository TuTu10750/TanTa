package com.yunbao.live.bean;

import com.alibaba.fastjson.annotation.JSONField;

/* loaded from: /tmp/classes2.dex */
public class LiveStickerBean {
    private String mId;
    private String mName;
    private long mPlayTime;
    private String mResource;

    @JSONField(name = "id")
    public String getId() {
        return this.mId;
    }

    @JSONField(name = "name")
    public String getName() {
        return this.mName;
    }

    @JSONField(serialize = false)
    public long getPlayTime() {
        return this.mPlayTime;
    }

    @JSONField(name = "resource")
    public String getResource() {
        return this.mResource;
    }

    @JSONField(name = "id")
    public void setId(String str) {
        this.mId = str;
    }

    @JSONField(name = "name")
    public void setName(String str) {
        this.mName = str;
    }

    @JSONField(serialize = false)
    public void setPlayTime(long j) {
        this.mPlayTime = j;
    }

    @JSONField(name = "resource")
    public void setResource(String str) {
        this.mResource = str;
    }
}
