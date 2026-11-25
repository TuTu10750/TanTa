package com.yunbao.mall.bean;

import com.alibaba.fastjson.annotation.JSONField;

/* loaded from: /tmp/classes2.dex */
public class PayContentVideoPlayBean extends PayContentVideoBean {
    private String mDurationString;

    @JSONField(name = "video_length_format")
    public String getDurationString() {
        return this.mDurationString;
    }

    @JSONField(name = "video_length_format")
    public void setDurationString(String str) {
        this.mDurationString = str;
    }
}
