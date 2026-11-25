package com.yunbao.im.bean;

import com.yunbao.im.dao.IMMessageBean;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class ImChatImageBean1 {
    private List<IMMessageBean> list;
    private int position;

    public ImChatImageBean1(List<IMMessageBean> list, int i) {
        this.list = list;
        this.position = i;
    }

    public List<IMMessageBean> getList() {
        return this.list;
    }

    public int getPosition() {
        return this.position;
    }

    public void setList(List<IMMessageBean> list) {
        this.list = list;
    }

    public void setPosition(int i) {
        this.position = i;
    }
}
