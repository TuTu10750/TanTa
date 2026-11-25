package com.yunbao.beauty.bean;

import android.graphics.Bitmap;

/* loaded from: /tmp/classes2.dex */
public class MeiYanDataBean {
    private int filterId;
    private int hahaName;
    private boolean hahaTeXiao;
    private boolean makeupBlush;
    private boolean makeupEyebrow;
    private boolean makeupEyelash;
    private boolean makeupEyeliner;
    private boolean makeupLipstick;
    private MeiYanValueBean meiYanValueBean;
    private int teXiaoId;
    private int tieZhiAction;
    private boolean tieZhiIsAction;
    private String tieZhiKey;
    private String tieZhiName;
    private boolean tieZhiShow;
    private int[] useFaces;
    private Bitmap waterBitmap;
    private int waterRes;
    private int waterposition;

    public int getFilterId() {
        return this.filterId;
    }

    public int getHahaName() {
        return this.hahaName;
    }

    public boolean getHahaTeXiao() {
        return this.hahaTeXiao;
    }

    public MeiYanValueBean getMeiYanValueBean() {
        return this.meiYanValueBean;
    }

    public int getTeXiaoId() {
        return this.teXiaoId;
    }

    public int getTieZhiAction() {
        return this.tieZhiAction;
    }

    public boolean getTieZhiIsAction() {
        return this.tieZhiIsAction;
    }

    public String getTieZhiKey() {
        return this.tieZhiKey;
    }

    public String getTieZhiName() {
        return this.tieZhiName;
    }

    public boolean getTieZhiShow() {
        return this.tieZhiShow;
    }

    public int[] getUseFaces() {
        return this.useFaces;
    }

    public Bitmap getWaterBitmap() {
        return this.waterBitmap;
    }

    public int getWaterRes() {
        return this.waterRes;
    }

    public int getWaterposition() {
        return this.waterposition;
    }

    public boolean isMakeupBlush() {
        return this.makeupBlush;
    }

    public boolean isMakeupEyebrow() {
        return this.makeupEyebrow;
    }

    public boolean isMakeupEyelash() {
        return this.makeupEyelash;
    }

    public boolean isMakeupEyeliner() {
        return this.makeupEyeliner;
    }

    public boolean isMakeupLipstick() {
        return this.makeupLipstick;
    }

    public void setFilterId(int i) {
        this.filterId = i;
    }

    public void setHahaName(int i) {
        this.hahaName = i;
    }

    public void setHahaTeXiao(boolean z) {
        this.hahaTeXiao = z;
    }

    public void setMakeupBlush(boolean z) {
        this.makeupBlush = z;
    }

    public void setMakeupEyebrow(boolean z) {
        this.makeupEyebrow = z;
    }

    public void setMakeupEyelash(boolean z) {
        this.makeupEyelash = z;
    }

    public void setMakeupEyeliner(boolean z) {
        this.makeupEyeliner = z;
    }

    public void setMakeupLipstick(boolean z) {
        this.makeupLipstick = z;
    }

    public void setMeiYanValueBean(MeiYanValueBean meiYanValueBean) {
        this.meiYanValueBean = meiYanValueBean;
    }

    public void setTeXiaoId(int i) {
        this.teXiaoId = i;
    }

    public void setTieZhiAction(int i) {
        this.tieZhiAction = i;
    }

    public void setTieZhiIsAction(boolean z) {
        this.tieZhiIsAction = z;
    }

    public void setTieZhiKey(String str) {
        this.tieZhiKey = str;
    }

    public void setTieZhiName(String str) {
        this.tieZhiName = str;
    }

    public void setTieZhiShow(boolean z) {
        this.tieZhiShow = z;
    }

    public void setUseFaces(int[] iArr) {
        this.useFaces = iArr;
    }

    public void setWaterBitmap(Bitmap bitmap) {
        this.waterBitmap = bitmap;
    }

    public void setWaterRes(int i) {
        this.waterRes = i;
    }

    public void setWaterposition(int i) {
        this.waterposition = i;
    }
}
