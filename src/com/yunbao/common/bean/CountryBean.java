package com.yunbao.common.bean;

import com.alibaba.fastjson.annotation.JSONField;

/* loaded from: /tmp/classes2.dex */
public class CountryBean {
    private String name;
    private String name_en;
    private String tel;

    @JSONField(name = "name")
    public String getName() {
        return this.name;
    }

    @JSONField(name = "name_en")
    public String getName_en() {
        return this.name_en;
    }

    @JSONField(name = "tel")
    public String getTel() {
        return this.tel;
    }

    @JSONField(name = "name")
    public void setName(String str) {
        this.name = str;
    }

    @JSONField(name = "name_en")
    public void setName_en(String str) {
        this.name_en = str;
    }

    @JSONField(name = "tel")
    public void setTel(String str) {
        this.tel = str;
    }
}
