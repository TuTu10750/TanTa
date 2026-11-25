package com.yunbao.common.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.umeng.ccg.a;

/* loaded from: /tmp/classes2.dex */
public class AdBean {
    private String mLink;
    private String mUrl;
    private int target;

    @JSONField(name = "href")
    public String getLink() {
        return this.mLink;
    }

    @JSONField(name = a.F)
    public int getTarget() {
        return this.target;
    }

    @JSONField(name = "thumb")
    public String getUrl() {
        return this.mUrl;
    }

    @JSONField(name = "href")
    public void setLink(String str) {
        this.mLink = str;
    }

    @JSONField(name = a.F)
    public void setTarget(int i) {
        this.target = i;
    }

    @JSONField(name = "thumb")
    public void setUrl(String str) {
        this.mUrl = str;
    }
}
