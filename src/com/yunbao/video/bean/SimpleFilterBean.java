package com.yunbao.video.bean;

/* loaded from: /tmp/classes2.dex */
public class SimpleFilterBean {
    private boolean mChecked;
    private int mFilterSrc;
    private int mImgSrc;

    public SimpleFilterBean() {
    }

    public SimpleFilterBean(int i, int i2) {
        this.mImgSrc = i;
        this.mFilterSrc = i2;
    }

    public SimpleFilterBean(int i, int i2, boolean z) {
        this(i, i2);
        this.mChecked = z;
    }

    public int getFilterSrc() {
        return this.mFilterSrc;
    }

    public int getImgSrc() {
        return this.mImgSrc;
    }

    public boolean isChecked() {
        return this.mChecked;
    }

    public void setChecked(boolean z) {
        this.mChecked = z;
    }

    public void setFilterSrc(int i) {
        this.mFilterSrc = i;
    }

    public void setImgSrc(int i) {
        this.mImgSrc = i;
    }
}
