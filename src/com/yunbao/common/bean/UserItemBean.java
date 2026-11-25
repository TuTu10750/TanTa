package com.yunbao.common.bean;

import android.text.TextUtils;

/* loaded from: /tmp/classes2.dex */
public class UserItemBean {
    private String href;
    private int id;
    private String name;
    private String thumb;

    public String getHref() {
        return this.href;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getThumb() {
        return this.thumb;
    }

    public boolean isEqual(UserItemBean userItemBean) {
        return userItemBean != null && !TextUtils.isEmpty(this.href) && this.href.equals(userItemBean.getHref()) && this.id == userItemBean.getId() && !TextUtils.isEmpty(this.name) && this.name.equals(userItemBean.getName()) && !TextUtils.isEmpty(this.thumb) && this.thumb.equals(userItemBean.getThumb());
    }

    public void setHref(String str) {
        this.href = str;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setThumb(String str) {
        this.thumb = str;
    }
}
