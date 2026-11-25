package com.yunbao.live.bean;

import com.alibaba.fastjson.annotation.JSONField;

/* loaded from: /tmp/classes2.dex */
public class ImpressBean {
    private int check;
    private String color;
    private String color2;
    private int id;
    private String name;
    private String nums;
    private int order;

    @JSONField(name = "ifcheck")
    public int getCheck() {
        return this.check;
    }

    @JSONField(name = "colour")
    public String getColor() {
        return this.color;
    }

    @JSONField(name = "colour2")
    public String getColor2() {
        return this.color2;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getNums() {
        return this.nums;
    }

    @JSONField(name = "orderno")
    public int getOrder() {
        return this.order;
    }

    public boolean isChecked() {
        return this.check == 1;
    }

    @JSONField(name = "ifcheck")
    public void setCheck(int i) {
        this.check = i;
    }

    @JSONField(name = "colour")
    public void setColor(String str) {
        this.color = str;
    }

    @JSONField(name = "colour2")
    public void setColor2(String str) {
        this.color2 = str;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNums(String str) {
        this.nums = str;
    }

    @JSONField(name = "orderno")
    public void setOrder(int i) {
        this.order = i;
    }
}
