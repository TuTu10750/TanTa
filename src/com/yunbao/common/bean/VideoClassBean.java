package com.yunbao.common.bean;

import com.alibaba.fastjson.annotation.JSONField;

/* loaded from: /tmp/classes2.dex */
public class VideoClassBean {
    private boolean mChecked;
    private int mId;
    private String mName;

    public VideoClassBean() {
    }

    public VideoClassBean(int i, String str, boolean z) {
        this.mId = i;
        this.mName = str;
        this.mChecked = z;
    }

    @JSONField(name = "id")
    public int getId() {
        return this.mId;
    }

    @JSONField(name = "name")
    public String getName() {
        return this.mName;
    }

    public boolean isChecked() {
        return this.mChecked;
    }

    public void setChecked(boolean z) {
        this.mChecked = z;
    }

    @JSONField(name = "id")
    public void setId(int i) {
        this.mId = i;
    }

    @JSONField(name = "name")
    public void setName(String str) {
        this.mName = str;
    }
}
