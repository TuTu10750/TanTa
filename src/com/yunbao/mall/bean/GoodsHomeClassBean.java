package com.yunbao.mall.bean;

import com.alibaba.fastjson.annotation.JSONField;

/* loaded from: /tmp/classes2.dex */
public class GoodsHomeClassBean {
    private String mIcon;
    private String mId;
    private String mName;

    @JSONField(name = "gc_icon")
    public String getIcon() {
        return this.mIcon;
    }

    @JSONField(name = "gc_id")
    public String getId() {
        return this.mId;
    }

    @JSONField(name = "gc_name")
    public String getName() {
        return this.mName;
    }

    @JSONField(name = "gc_icon")
    public void setIcon(String str) {
        this.mIcon = str;
    }

    @JSONField(name = "gc_id")
    public void setId(String str) {
        this.mId = str;
    }

    @JSONField(name = "gc_name")
    public void setName(String str) {
        this.mName = str;
    }
}
