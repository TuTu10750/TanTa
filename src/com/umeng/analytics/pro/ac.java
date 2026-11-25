package com.umeng.analytics.pro;

import android.text.TextUtils;
import com.umeng.ccg.ActionInfo;
import com.umeng.ccg.CcgAgent;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.ArrayList;
import org.json.JSONObject;

/* loaded from: /tmp/classes2.dex */
public class ac implements ak {
    private String a;
    private ArrayList<ad> b;
    private String c;
    private String d;
    private String e;
    private String f;

    public ac(String str, ArrayList<ad> arrayList) {
        this.a = null;
        new ArrayList();
        this.c = "";
        this.d = "";
        this.e = "";
        this.f = "";
        this.a = str;
        this.b = arrayList;
    }

    private String c(String str) {
        String[] split = str.split(",");
        String str2 = "";
        if (split.length > 0) {
            ArrayList<String> forbidSdkArray = CcgAgent.getForbidSdkArray(this.a);
            if (forbidSdkArray == null || forbidSdkArray.size() <= 0) {
                for (String str3 : split) {
                    ActionInfo actionInfo = CcgAgent.getActionInfo(str3);
                    if (actionInfo != null) {
                        String[] supportAction = actionInfo.getSupportAction(UMGlobalContext.getAppContext());
                        if (supportAction.length > 0) {
                            int i = 0;
                            while (true) {
                                if (i >= supportAction.length) {
                                    break;
                                }
                                if (this.a.equals(supportAction[i])) {
                                    str2 = str3;
                                    break;
                                }
                                i++;
                            }
                            if (!TextUtils.isEmpty(str2)) {
                                return str2;
                            }
                        } else {
                            continue;
                        }
                    }
                }
            } else {
                this.f = forbidSdkArray.toString();
                for (String str4 : split) {
                    if (CcgAgent.getActionInfo(str4) != null && !forbidSdkArray.contains(str4)) {
                        return str4;
                    }
                }
            }
        }
        return str2;
    }

    public String a() {
        return this.a;
    }

    @Override // com.umeng.analytics.pro.ak
    public JSONObject a(String str, JSONObject jSONObject) {
        try {
            int size = this.b.size();
            if (size == 0) {
                return null;
            }
            for (int i = 0; i < size; i++) {
                if (this.b.get(i).b()) {
                    return null;
                }
            }
            if (CcgAgent.hasRegistedActionInfo() && !TextUtils.isEmpty(this.d)) {
                String c = c(this.d);
                this.e = c;
                if (TextUtils.isEmpty(c)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "采集项：" + this.a + "; 未选中可用Module ; sdk: " + this.d);
                } else {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "采集项：" + this.a + "; 选中Module: " + this.e + "; sdk: " + this.d);
                }
            }
            ad adVar = this.b.get(size - 1);
            if (adVar == null || !(adVar instanceof ag)) {
                return null;
            }
            long c2 = adVar.c();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("actionName", this.a);
                jSONObject2.put(com.umeng.ccg.a.x, this.d);
                jSONObject2.put(com.umeng.ccg.a.u, this.c);
                jSONObject2.put("delay", c2);
                jSONObject2.put(com.umeng.ccg.a.v, this.e);
                jSONObject2.put(com.umeng.ccg.a.w, this.f);
                return jSONObject2;
            } catch (Throwable unused) {
                return jSONObject2;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    public void a(String str) {
        this.c = str;
    }

    public String b() {
        return this.c;
    }

    public void b(String str) {
        this.d = str;
    }

    @Override // com.umeng.analytics.pro.ak
    public void b(String str, JSONObject jSONObject) {
    }

    public String c() {
        return this.d;
    }
}
