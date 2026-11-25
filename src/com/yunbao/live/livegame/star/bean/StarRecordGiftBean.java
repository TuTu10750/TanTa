package com.yunbao.live.livegame.star.bean;

import com.alibaba.fastjson.annotation.JSONField;

/* loaded from: /tmp/classes2.dex */
public class StarRecordGiftBean {
    private String mCount;
    private String mGiftIcon;

    @JSONField(name = "nums")
    public String getCount() {
        return this.mCount;
    }

    @JSONField(name = "gifticon")
    public String getGiftIcon() {
        return this.mGiftIcon;
    }

    @JSONField(name = "nums")
    public void setCount(String str) {
        this.mCount = str;
    }

    @JSONField(name = "gifticon")
    public void setGiftIcon(String str) {
        this.mGiftIcon = str;
    }
}
