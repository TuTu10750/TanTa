package com.yunbao.beauty.bean;

/* loaded from: /tmp/classes2.dex */
public class TeXiaoWaterBean {
    private boolean mChecked;
    private int mPositon;
    private int mRes;
    private int mThumb;

    public TeXiaoWaterBean(int i, int i2, int i3) {
        this.mThumb = i;
        this.mRes = i2;
        this.mPositon = i3;
    }

    public TeXiaoWaterBean(int i, int i2, int i3, boolean z) {
        this(i, i2, i3);
        this.mChecked = z;
    }

    public int getPositon() {
        return this.mPositon;
    }

    public int getRes() {
        return this.mRes;
    }

    public int getThumb() {
        return this.mThumb;
    }

    public boolean isChecked() {
        return this.mChecked;
    }

    public void setChecked(boolean z) {
        this.mChecked = z;
    }
}
