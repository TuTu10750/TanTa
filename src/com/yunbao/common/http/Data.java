package com.yunbao.common.http;

/* loaded from: /tmp/classes2.dex */
public class Data {
    private int code;
    private String[] info;
    private String msg;

    public int getCode() {
        return this.code;
    }

    public String[] getInfo() {
        return this.info;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setInfo(String[] strArr) {
        this.info = strArr;
    }

    public void setMsg(String str) {
        this.msg = str;
    }
}
