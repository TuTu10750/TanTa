package com.yunbao.beauty.bean;

/* loaded from: /tmp/classes2.dex */
public class MeiYanOneKeyValue {
    private Value mChangBi;
    private Value mDaYan;
    private Value mETou;
    private Value mHongRun;
    private Value mKaiYanJiao;
    private Value mMeiBai;
    private Value mMeiMao;
    private Value mMoPi;
    private Value mShouBi;
    private Value mShouLian;
    private Value mXiaBa;
    private Value mXueLian;
    private Value mYanJiao;
    private Value mYanJu;
    private Value mZuiXing;

    /* loaded from: /tmp/classes2.dex */
    public static class Value {
        private int maxValue;
        private int minValue;

        public Value(int i, int i2) {
            this.minValue = i;
            this.maxValue = i2;
        }

        public int getValue(float f) {
            return this.minValue + ((int) ((this.maxValue - r0) * f));
        }
    }

    public MeiYanOneKeyValue(Value value, Value value2, Value value3, Value value4, Value value5, Value value6, Value value7, Value value8, Value value9, Value value10, Value value11, Value value12, Value value13, Value value14, Value value15) {
        this.mMeiBai = value;
        this.mMoPi = value2;
        this.mHongRun = value3;
        this.mDaYan = value4;
        this.mMeiMao = value5;
        this.mYanJu = value6;
        this.mYanJiao = value7;
        this.mShouLian = value8;
        this.mZuiXing = value9;
        this.mShouBi = value10;
        this.mXiaBa = value11;
        this.mETou = value12;
        this.mChangBi = value13;
        this.mXueLian = value14;
        this.mKaiYanJiao = value15;
    }

    public void calculateValue(MeiYanValueBean meiYanValueBean, float f) {
        meiYanValueBean.setMeiBai(this.mMeiBai.getValue(f));
        meiYanValueBean.setMoPi(this.mMoPi.getValue(f));
        meiYanValueBean.setHongRun(this.mHongRun.getValue(f));
        meiYanValueBean.setDaYan(this.mDaYan.getValue(f));
        meiYanValueBean.setMeiMao(this.mMeiMao.getValue(f));
        meiYanValueBean.setYanJu(this.mYanJu.getValue(f));
        meiYanValueBean.setYanJiao(this.mYanJiao.getValue(f));
        meiYanValueBean.setShouLian(this.mShouLian.getValue(f));
        meiYanValueBean.setZuiXing(this.mZuiXing.getValue(f));
        meiYanValueBean.setShouBi(this.mShouBi.getValue(f));
        meiYanValueBean.setXiaBa(this.mXiaBa.getValue(f));
        meiYanValueBean.setETou(this.mETou.getValue(f));
        meiYanValueBean.setChangBi(this.mChangBi.getValue(f));
        meiYanValueBean.setXueLian(this.mXueLian.getValue(f));
        meiYanValueBean.setKaiYanJiao(this.mKaiYanJiao.getValue(f));
    }
}
