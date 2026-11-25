package com.yunbao.common.bean;

import com.alibaba.fastjson.annotation.JSONField;

/* loaded from: /tmp/classes2.dex */
public class FirstChargeItemBean {
    private String mCount;
    private String mIcon;
    private String mName;

    @JSONField(name = "count")
    public String getCount() {
        return this.mCount;
    }

    @JSONField(name = "thumb")
    public String getIcon() {
        return this.mIcon;
    }

    @JSONField(name = "name")
    public String getName() {
        return this.mName;
    }

    @JSONField(name = "count")
    public void setCount(String str) {
        this.mCount = str;
    }

    @JSONField(name = "thumb")
    public void setIcon(String str) {
        this.mIcon = str;
    }

    @JSONField(name = "name")
    public void setName(String str) {
        this.mName = str;
    }
}
