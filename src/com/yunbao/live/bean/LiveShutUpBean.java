package com.yunbao.live.bean;

import com.yunbao.common.bean.UserBean;

/* loaded from: /tmp/classes2.dex */
public class LiveShutUpBean extends UserBean {
    private String uid;

    public String getUid() {
        return this.uid;
    }

    public void setUid(String str) {
        this.uid = str;
        this.id = str;
    }
}
