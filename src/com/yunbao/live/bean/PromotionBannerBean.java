package com.yunbao.live.bean;

import com.alibaba.fastjson.annotation.JSONField;

/* loaded from: /tmp/classes2.dex */
public class PromotionBannerBean {
    private String pic;
    private int target;
    private String url;

    @JSONField(name = "slide_pic")
    public String getPic() {
        return this.pic;
    }

    public int getTarget() {
        return this.target;
    }

    @JSONField(name = "slide_url")
    public String getUrl() {
        return this.url;
    }

    @JSONField(name = "slide_pic")
    public void setPic(String str) {
        this.pic = str;
    }

    public void setTarget(int i) {
        this.target = i;
    }

    @JSONField(name = "slide_url")
    public void setUrl(String str) {
        this.url = str;
    }
}
