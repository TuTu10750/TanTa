package com.yunbao.live.bean;

/* loaded from: /tmp/classes2.dex */
public class LiveTimeChargeBean {
    private boolean mChecked;
    private int mCoin;

    public LiveTimeChargeBean() {
    }

    public LiveTimeChargeBean(int i) {
        this.mCoin = i;
    }

    public LiveTimeChargeBean(int i, boolean z) {
        this.mCoin = i;
        this.mChecked = z;
    }

    public int getCoin() {
        return this.mCoin;
    }

    public boolean isChecked() {
        return this.mChecked;
    }

    public void setChecked(boolean z) {
        this.mChecked = z;
    }

    public void setCoin(int i) {
        this.mCoin = i;
    }
}
