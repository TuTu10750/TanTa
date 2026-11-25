package com.yunbao.live.socket;

import android.text.TextUtils;
import com.umeng.analytics.pro.cl;
import defpackage.lx1;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /tmp/classes2.dex */
public class SocketSendBean {
    private JSONObject mResult = new JSONObject();
    private JSONArray mMsg = new JSONArray();
    private JSONObject mMsg0 = new JSONObject();

    public JSONObject create() {
        try {
            this.mMsg.put(this.mMsg0);
            this.mResult.put("retcode", "000000");
            this.mResult.put("retmsg", "ok");
            this.mResult.put(cl.h, this.mMsg);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        lx1.b("发送socket-->" + this.mResult.toString());
        return this.mResult;
    }

    public SocketSendBean param(String str, int i) {
        return param(str, String.valueOf(i));
    }

    public SocketSendBean param(String str, String str2) {
        try {
            this.mMsg0.put(str, str2);
            return this;
        } catch (JSONException e) {
            e.printStackTrace();
            return this;
        }
    }

    public SocketSendBean param(String str, JSONObject jSONObject) {
        try {
            this.mMsg0.put(str, jSONObject);
            return this;
        } catch (JSONException e) {
            e.printStackTrace();
            return this;
        }
    }

    public SocketSendBean paramJsonArray(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            try {
                this.mMsg0.put(str, new JSONArray(str2));
                return this;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    public SocketSendBean paramJsonObject(String str, String str2) {
        try {
            this.mMsg0.put(str, new JSONObject(str2));
            return this;
        } catch (JSONException e) {
            e.printStackTrace();
            return this;
        }
    }
}
