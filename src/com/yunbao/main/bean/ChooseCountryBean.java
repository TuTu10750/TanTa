package com.yunbao.main.bean;

import com.alibaba.fastjson.annotation.JSONField;
import defpackage.di1;
import defpackage.rx1;

/* loaded from: /tmp/classes2.dex */
public class ChooseCountryBean implements di1 {
    private String mIndex;
    private String mName;
    private String mNameEn;
    private String mTel;

    public String getIndex() {
        return this.mIndex;
    }

    @JSONField(name = "name")
    public String getName() {
        return this.mName;
    }

    @JSONField(name = "name_en")
    public String getNameEn() {
        return this.mNameEn;
    }

    @Override // defpackage.di1
    public String getSuspensionTag() {
        return this.mIndex;
    }

    @JSONField(name = "tel")
    public String getTel() {
        return this.mTel;
    }

    public String getTransName() {
        return rx1.h() ? this.mName : this.mNameEn;
    }

    @Override // defpackage.di1
    public boolean isShowSuspension() {
        return true;
    }

    public void setIndex(String str) {
        this.mIndex = str;
    }

    @JSONField(name = "name")
    public void setName(String str) {
        this.mName = str;
    }

    @JSONField(name = "name_en")
    public void setNameEn(String str) {
        this.mNameEn = str;
    }

    @JSONField(name = "tel")
    public void setTel(String str) {
        this.mTel = str;
    }
}
