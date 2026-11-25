package com.yunbao.mall.bean;

import com.alibaba.fastjson.annotation.JSONField;

/* loaded from: /tmp/classes2.dex */
public class WuliuBean {
    private String mId;
    private String mName;
    private String mThumb;

    @JSONField(name = "id")
    public String getId() {
        return this.mId;
    }

    @JSONField(name = "express_name")
    public String getName() {
        return this.mName;
    }

    @JSONField(name = "express_thumb")
    public String getThumb() {
        return this.mThumb;
    }

    @JSONField(name = "id")
    public void setId(String str) {
        this.mId = str;
    }

    @JSONField(name = "express_name")
    public void setName(String str) {
        this.mName = str;
    }

    @JSONField(name = "express_thumb")
    public void setThumb(String str) {
        this.mThumb = str;
    }
}
