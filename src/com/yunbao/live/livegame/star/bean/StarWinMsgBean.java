package com.yunbao.live.livegame.star.bean;

import com.alibaba.fastjson.annotation.JSONField;
import defpackage.rx1;

/* loaded from: /tmp/classes2.dex */
public class StarWinMsgBean {
    private String mGiftIcon;
    private String mTitle;
    private String mTitleEn;

    @JSONField(name = "gifticon")
    public String getGiftIcon() {
        return this.mGiftIcon;
    }

    @JSONField(name = "title")
    public String getTitle() {
        return this.mTitle;
    }

    @JSONField(name = "title_en")
    public String getTitleEn() {
        return this.mTitleEn;
    }

    public String getTitleTrans() {
        return rx1.h() ? this.mTitle : this.mTitleEn;
    }

    @JSONField(name = "gifticon")
    public void setGiftIcon(String str) {
        this.mGiftIcon = str;
    }

    @JSONField(name = "title")
    public void setTitle(String str) {
        this.mTitle = str;
    }

    @JSONField(name = "title_en")
    public void setTitleEn(String str) {
        this.mTitleEn = str;
    }
}
