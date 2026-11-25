package com.yunbao.mall.bean;

import com.alibaba.fastjson.annotation.JSONField;
import defpackage.li1;

/* loaded from: /tmp/classes2.dex */
public class RefundReasonBean implements li1 {
    private String mId;
    private String mName;

    @JSONField(name = "id")
    public String getId() {
        return this.mId;
    }

    @JSONField(name = "name")
    public String getName() {
        return this.mName;
    }

    @Override // defpackage.li1
    public String getWheelText() {
        return this.mName;
    }

    @JSONField(name = "id")
    public void setId(String str) {
        this.mId = str;
    }

    @JSONField(name = "name")
    public void setName(String str) {
        this.mName = str;
    }
}
