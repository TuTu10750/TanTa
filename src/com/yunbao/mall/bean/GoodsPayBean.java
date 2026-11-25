package com.yunbao.mall.bean;

import com.alibaba.fastjson.annotation.JSONField;

/* loaded from: /tmp/classes2.dex */
public class GoodsPayBean {
    private boolean mChecked;
    private String mId;
    private String mName;
    private String mThumb;
    private String mType;

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

    @JSONField(name = "type")
    public String getType() {
        return this.mType;
    }

    @JSONField(serialize = false)
    public boolean isChecked() {
        return this.mChecked;
    }

    @JSONField(serialize = false)
    public void setChecked(boolean z) {
        this.mChecked = z;
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

    @JSONField(name = "type")
    public void setType(String str) {
        this.mType = str;
    }
}
