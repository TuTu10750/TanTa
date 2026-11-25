package com.yunbao.im.bean;

import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class ImChatImageBean {
    private List<ImMessageBean> list;
    private int position;

    public ImChatImageBean(List<ImMessageBean> list, int i) {
        this.list = list;
        this.position = i;
    }

    public List<ImMessageBean> getList() {
        return this.list;
    }

    public int getPosition() {
        return this.position;
    }

    public void setList(List<ImMessageBean> list) {
        this.list = list;
    }

    public void setPosition(int i) {
        this.position = i;
    }
}
