package com.yunbao.beauty.bean;

import com.alibaba.fastjson.annotation.JSONField;

/* loaded from: /tmp/classes2.dex */
public class MeiYanValueBean {
    private int mChangBi;
    private int mDaYan;
    private int mETou;
    private int mHongRun;
    private int mKaiYanJiao;
    private int mLiangDu;
    private int mMeiBai;
    private int mMeiMao;
    private int mMoPi;
    private int mShouBi;
    private int mShouLian;
    private int mXiaBa;
    private int mXueLian;
    private int mYanJiao;
    private int mYanJu;
    private int mZuiXing;

    public static MeiYanValueBean copy(MeiYanValueBean meiYanValueBean) {
        if (meiYanValueBean == null) {
            return null;
        }
        MeiYanValueBean meiYanValueBean2 = new MeiYanValueBean();
        meiYanValueBean2.setMeiBai(meiYanValueBean.getMeiBai());
        meiYanValueBean2.setMoPi(meiYanValueBean.getMoPi());
        meiYanValueBean2.setHongRun(meiYanValueBean.getHongRun());
        meiYanValueBean2.setLiangDu(meiYanValueBean.getLiangDu());
        meiYanValueBean2.setDaYan(meiYanValueBean.getDaYan());
        meiYanValueBean2.setMeiMao(meiYanValueBean.getMeiMao());
        meiYanValueBean2.setYanJu(meiYanValueBean.getYanJu());
        meiYanValueBean2.setYanJiao(meiYanValueBean.getYanJiao());
        meiYanValueBean2.setShouLian(meiYanValueBean.getShouLian());
        meiYanValueBean2.setZuiXing(meiYanValueBean.getZuiXing());
        meiYanValueBean2.setShouBi(meiYanValueBean.getShouBi());
        meiYanValueBean2.setXiaBa(meiYanValueBean.getXiaBa());
        meiYanValueBean2.setETou(meiYanValueBean.getETou());
        meiYanValueBean2.setChangBi(meiYanValueBean.getChangBi());
        meiYanValueBean2.setXueLian(meiYanValueBean.getXueLian());
        meiYanValueBean2.setKaiYanJiao(meiYanValueBean.getKaiYanJiao());
        return meiYanValueBean2;
    }

    @JSONField(name = "lengthen_noseLift")
    public int getChangBi() {
        return this.mChangBi;
    }

    @JSONField(name = "big_eye")
    public int getDaYan() {
        return this.mDaYan;
    }

    @JSONField(name = "forehead_lift")
    public int getETou() {
        return this.mETou;
    }

    @JSONField(name = "skin_tenderness")
    public int getHongRun() {
        return this.mHongRun;
    }

    @JSONField(name = "eye_alat")
    public int getKaiYanJiao() {
        return this.mKaiYanJiao;
    }

    @JSONField(name = "brightness")
    public int getLiangDu() {
        return this.mLiangDu;
    }

    @JSONField(name = "skin_whiting")
    public int getMeiBai() {
        return this.mMeiBai;
    }

    @JSONField(name = "eye_brow")
    public int getMeiMao() {
        return this.mMeiMao;
    }

    @JSONField(name = "skin_smooth")
    public int getMoPi() {
        return this.mMoPi;
    }

    @JSONField(name = "nose_lift")
    public int getShouBi() {
        return this.mShouBi;
    }

    @JSONField(name = "face_lift")
    public int getShouLian() {
        return this.mShouLian;
    }

    @JSONField(name = "chin_lift")
    public int getXiaBa() {
        return this.mXiaBa;
    }

    @JSONField(name = "face_shave")
    public int getXueLian() {
        return this.mXueLian;
    }

    @JSONField(name = "eye_corner")
    public int getYanJiao() {
        return this.mYanJiao;
    }

    @JSONField(name = "eye_length")
    public int getYanJu() {
        return this.mYanJu;
    }

    @JSONField(name = "mouse_lift")
    public int getZuiXing() {
        return this.mZuiXing;
    }

    @JSONField(name = "lengthen_noseLift")
    public void setChangBi(int i) {
        this.mChangBi = i;
    }

    @JSONField(name = "big_eye")
    public void setDaYan(int i) {
        this.mDaYan = i;
    }

    @JSONField(name = "forehead_lift")
    public void setETou(int i) {
        this.mETou = i;
    }

    @JSONField(name = "skin_tenderness")
    public void setHongRun(int i) {
        this.mHongRun = i;
    }

    @JSONField(name = "eye_alat")
    public void setKaiYanJiao(int i) {
        this.mKaiYanJiao = i;
    }

    @JSONField(name = "brightness")
    public void setLiangDu(int i) {
        this.mLiangDu = i;
    }

    @JSONField(name = "skin_whiting")
    public void setMeiBai(int i) {
        this.mMeiBai = i;
    }

    @JSONField(name = "eye_brow")
    public void setMeiMao(int i) {
        this.mMeiMao = i;
    }

    @JSONField(name = "skin_smooth")
    public void setMoPi(int i) {
        this.mMoPi = i;
    }

    @JSONField(name = "nose_lift")
    public void setShouBi(int i) {
        this.mShouBi = i;
    }

    @JSONField(name = "face_lift")
    public void setShouLian(int i) {
        this.mShouLian = i;
    }

    @JSONField(name = "chin_lift")
    public void setXiaBa(int i) {
        this.mXiaBa = i;
    }

    @JSONField(name = "face_shave")
    public void setXueLian(int i) {
        this.mXueLian = i;
    }

    @JSONField(name = "eye_corner")
    public void setYanJiao(int i) {
        this.mYanJiao = i;
    }

    @JSONField(name = "eye_length")
    public void setYanJu(int i) {
        this.mYanJu = i;
    }

    @JSONField(name = "mouse_lift")
    public void setZuiXing(int i) {
        this.mZuiXing = i;
    }

    public String toString() {
        return "MeiYanValueBean{mMeiBai=" + this.mMeiBai + ", mMoPi=" + this.mMoPi + ", mHongRun=" + this.mHongRun + ", mLiangDu=" + this.mLiangDu + ", mDaYan=" + this.mDaYan + ", mMeiMao=" + this.mMeiMao + ", mYanJu=" + this.mYanJu + ", mYanJiao=" + this.mYanJiao + ", mShouLian=" + this.mShouLian + ", mZuiXing=" + this.mZuiXing + ", mShouBi=" + this.mShouBi + ", mXiaBa=" + this.mXiaBa + ", mETou=" + this.mETou + ", mChangBi=" + this.mChangBi + ", mXueLian=" + this.mXueLian + ", mKaiYanJiao=" + this.mKaiYanJiao + '}';
    }
}
