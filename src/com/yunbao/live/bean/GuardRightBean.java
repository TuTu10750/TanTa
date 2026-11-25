package com.yunbao.live.bean;

import com.alibaba.fastjson.annotation.JSONField;

/* loaded from: /tmp/classes2.dex */
public class GuardRightBean {
    private String des;
    private String icon0;
    private String icon1;
    private boolean mChecked;
    private String title;

    public String getDes() {
        return this.des;
    }

    @JSONField(name = "thumb_g")
    public String getIcon0() {
        return this.icon0;
    }

    @JSONField(name = "thumb_c")
    public String getIcon1() {
        return this.icon1;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean isChecked() {
        return this.mChecked;
    }

    public void setChecked(boolean z) {
        this.mChecked = z;
    }

    public void setDes(String str) {
        this.des = str;
    }

    @JSONField(name = "thumb_g")
    public void setIcon0(String str) {
        this.icon0 = str;
    }

    @JSONField(name = "thumb_c")
    public void setIcon1(String str) {
        this.icon1 = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
