package com.yunbao.main.bean;

import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;
import com.umeng.ccg.a;

/* loaded from: /tmp/classes2.dex */
public class BannerBean {
    private String mImageUrl;
    private String mLink;
    private int target;

    @JSONField(name = "slide_pic")
    public String getImageUrl() {
        return this.mImageUrl;
    }

    @JSONField(name = "slide_url")
    public String getLink() {
        return this.mLink;
    }

    @JSONField(name = a.F)
    public int getTarget() {
        return this.target;
    }

    public boolean isEqual(BannerBean bannerBean) {
        return (bannerBean == null || TextUtils.isEmpty(this.mImageUrl) || !this.mImageUrl.equals(bannerBean.getImageUrl()) || TextUtils.isEmpty(this.mLink) || !this.mLink.equals(bannerBean.getLink())) ? false : true;
    }

    @JSONField(name = "slide_pic")
    public void setImageUrl(String str) {
        this.mImageUrl = str;
    }

    @JSONField(name = "slide_url")
    public void setLink(String str) {
        this.mLink = str;
    }

    @JSONField(name = a.F)
    public void setTarget(int i) {
        this.target = i;
    }
}
