package com.yunbao.common.bean;

import com.alibaba.fastjson.annotation.JSONField;

/* loaded from: /tmp/classes2.dex */
public class CoinPayBean {
    private boolean mChecked;
    private String mHref;
    private String mId;
    private String mName;
    private String mThumb;

    @JSONField(name = "href")
    public String getHref() {
        return this.mHref;
    }

    @JSONField(name = "id")
    public String getId() {
        return this.mId;
    }

    @JSONField(name = "name")
    public String getName() {
        return this.mName;
    }

    @JSONField(name = "thumb")
    public String getThumb() {
        return this.mThumb;
    }

    @JSONField(serialize = false)
    public boolean isChecked() {
        return this.mChecked;
    }

    @JSONField(serialize = false)
    public void setChecked(boolean z) {
        this.mChecked = z;
    }

    @JSONField(name = "href")
    public void setHref(String str) {
        this.mHref = str;
    }

    @JSONField(name = "id")
    public void setId(String str) {
        this.mId = str;
    }

    @JSONField(name = "name")
    public void setName(String str) {
        this.mName = str;
    }

    @JSONField(name = "thumb")
    public void setThumb(String str) {
        this.mThumb = str;
    }
}
