package com.yunbao.im.bean;

/* loaded from: /tmp/classes2.dex */
public class ImMsgLocationBean {
    private String mAddress;
    private double mLat;
    private double mLng;
    private int mZoom;

    public ImMsgLocationBean(String str, int i, double d, double d2) {
        this.mAddress = str;
        this.mZoom = i;
        this.mLat = d;
        this.mLng = d2;
    }

    public String getAddress() {
        return this.mAddress;
    }

    public double getLat() {
        return this.mLat;
    }

    public double getLng() {
        return this.mLng;
    }

    public int getZoom() {
        return this.mZoom;
    }

    public void setAddress(String str) {
        this.mAddress = str;
    }

    public void setLat(double d) {
        this.mLat = d;
    }

    public void setLng(double d) {
        this.mLng = d;
    }

    public void setZoom(int i) {
        this.mZoom = i;
    }
}
