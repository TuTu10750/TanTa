package com.yunbao.live.bean;

import com.yunbao.common.bean.UserBean;

/* loaded from: /tmp/classes2.dex */
public class GuardUserBean extends UserBean {
    private String contribute;
    private int type;

    public String getContribute() {
        return this.contribute;
    }

    public int getType() {
        return this.type;
    }

    public void setContribute(String str) {
        this.contribute = str;
    }

    public void setType(int i) {
        this.type = i;
    }
}
