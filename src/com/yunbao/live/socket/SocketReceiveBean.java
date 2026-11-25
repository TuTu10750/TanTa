package com.yunbao.live.socket;

import com.alibaba.fastjson.JSONArray;

/* loaded from: /tmp/classes2.dex */
public class SocketReceiveBean {
    private JSONArray msg;
    private String retcode;
    private String retmsg;

    public JSONArray getMsg() {
        return this.msg;
    }

    public String getRetcode() {
        return this.retcode;
    }

    public String getRetmsg() {
        return this.retmsg;
    }

    public void setMsg(JSONArray jSONArray) {
        this.msg = jSONArray;
    }

    public void setRetcode(String str) {
        this.retcode = str;
    }

    public void setRetmsg(String str) {
        this.retmsg = str;
    }
}
