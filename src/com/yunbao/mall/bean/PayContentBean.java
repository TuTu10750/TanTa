package com.yunbao.mall.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.umeng.analytics.pro.cl;

/* loaded from: /tmp/classes2.dex */
public class PayContentBean {
    private String mId;
    private String mMoney;
    private String mSaleNum;
    private int mStatus = 1;
    private String mThumb;
    private String mTitle;
    private String mVideoNum;

    @JSONField(name = "id")
    public String getId() {
        return this.mId;
    }

    @JSONField(name = "money")
    public String getMoney() {
        return this.mMoney;
    }

    @JSONField(name = "sale_nums")
    public String getSaleNum() {
        return this.mSaleNum;
    }

    @JSONField(name = cl.i)
    public int getStatus() {
        return this.mStatus;
    }

    @JSONField(name = "thumb_format")
    public String getThumb() {
        return this.mThumb;
    }

    @JSONField(name = "title")
    public String getTitle() {
        return this.mTitle;
    }

    @JSONField(name = "video_num")
    public String getVideoNum() {
        return this.mVideoNum;
    }

    @JSONField(name = "id")
    public void setId(String str) {
        this.mId = str;
    }

    @JSONField(name = "money")
    public void setMoney(String str) {
        this.mMoney = str;
    }

    @JSONField(name = "sale_nums")
    public void setSaleNum(String str) {
        this.mSaleNum = str;
    }

    @JSONField(name = cl.i)
    public void setStatus(int i) {
        this.mStatus = i;
    }

    @JSONField(name = "thumb_format")
    public void setThumb(String str) {
        this.mThumb = str;
    }

    @JSONField(name = "title")
    public void setTitle(String str) {
        this.mTitle = str;
    }

    @JSONField(name = "video_num")
    public void setVideoNum(String str) {
        this.mVideoNum = str;
    }
}
