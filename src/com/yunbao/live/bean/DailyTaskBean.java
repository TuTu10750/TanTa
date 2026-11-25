package com.yunbao.live.bean;

import com.alibaba.fastjson.annotation.JSONField;

/* loaded from: /tmp/classes2.dex */
public class DailyTaskBean {
    private String mId;
    private int mStatus;
    private String mTip;
    private String mTitle;

    @JSONField(name = "id")
    public String getId() {
        return this.mId;
    }

    @JSONField(name = "state")
    public int getStatus() {
        return this.mStatus;
    }

    @JSONField(name = "tip_m")
    public String getTip() {
        return this.mTip;
    }

    @JSONField(name = "title")
    public String getTitle() {
        return this.mTitle;
    }

    @JSONField(name = "id")
    public void setId(String str) {
        this.mId = str;
    }

    @JSONField(name = "state")
    public void setStatus(int i) {
        this.mStatus = i;
    }

    @JSONField(name = "tip_m")
    public void setTip(String str) {
        this.mTip = str;
    }

    @JSONField(name = "title")
    public void setTitle(String str) {
        this.mTitle = str;
    }
}
