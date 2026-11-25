package com.yunbao.main.bean;

import com.alibaba.fastjson.annotation.JSONField;

/* loaded from: /tmp/classes2.dex */
public class CashAccountBean {
    private String account;
    private String bankName;
    private boolean checked;
    private String id;
    private int type;
    private String uid;
    private String userName;

    public String getAccount() {
        return this.account;
    }

    @JSONField(name = "account_bank")
    public String getBankName() {
        return this.bankName;
    }

    public String getId() {
        return this.id;
    }

    public int getType() {
        return this.type;
    }

    public String getUid() {
        return this.uid;
    }

    @JSONField(name = "name")
    public String getUserName() {
        return this.userName;
    }

    public boolean isChecked() {
        return this.checked;
    }

    public void setAccount(String str) {
        this.account = str;
    }

    @JSONField(name = "account_bank")
    public void setBankName(String str) {
        this.bankName = str;
    }

    public void setChecked(boolean z) {
        this.checked = z;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    @JSONField(name = "name")
    public void setUserName(String str) {
        this.userName = str;
    }
}
