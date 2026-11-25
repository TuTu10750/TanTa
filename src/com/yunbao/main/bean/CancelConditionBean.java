package com.yunbao.main.bean;

import com.alibaba.fastjson.annotation.JSONField;

/* loaded from: /tmp/classes2.dex */
public class CancelConditionBean {
    private String mContent;
    private int mIsOK;
    private String mTitle;

    @JSONField(name = "content")
    public String getContent() {
        return this.mContent;
    }

    @JSONField(name = "is_ok")
    public int getIsOK() {
        return this.mIsOK;
    }

    @JSONField(name = "title")
    public String getTitle() {
        return this.mTitle;
    }

    @JSONField(name = "content")
    public void setContent(String str) {
        this.mContent = str;
    }

    @JSONField(name = "is_ok")
    public void setIsOK(int i) {
        this.mIsOK = i;
    }

    @JSONField(name = "title")
    public void setTitle(String str) {
        this.mTitle = str;
    }
}
