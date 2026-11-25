package com.yunbao.common.bean;

import com.alibaba.fastjson.annotation.JSONField;

/* loaded from: /tmp/classes2.dex */
public class LiveClassBean {
    private boolean checked;
    private String des;
    protected int id;
    protected String name;
    protected int orderNo;
    protected String thumb;

    public LiveClassBean() {
    }

    public LiveClassBean(int i, String str, boolean z) {
        this.id = i;
        this.name = str;
        this.checked = z;
    }

    public String getDes() {
        return this.des;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    @JSONField(name = "orderno")
    public int getOrderNo() {
        return this.orderNo;
    }

    public String getThumb() {
        return this.thumb;
    }

    public boolean isChecked() {
        return this.checked;
    }

    public void setChecked(boolean z) {
        this.checked = z;
    }

    public void setDes(String str) {
        this.des = str;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setName(String str) {
        this.name = str;
    }

    @JSONField(name = "orderno")
    public void setOrderNo(int i) {
        this.orderNo = i;
    }

    public void setThumb(String str) {
        this.thumb = str;
    }
}
