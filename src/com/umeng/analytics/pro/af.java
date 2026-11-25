package com.umeng.analytics.pro;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /tmp/classes2.dex */
public class af extends ac {
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private ArrayList<Pair<String, Integer>> f;
    private int g;

    public af(String str, ArrayList<ad> arrayList) {
        super(str, arrayList);
        this.c = 60;
        this.d = 180;
    }

    private void a(JSONObject jSONObject) {
        int i;
        if (jSONObject != null) {
            try {
                int i2 = this.a;
                int i3 = 0;
                if (i2 != 0) {
                    if (i2 == 1) {
                        int randNumber = DeviceConfig.getRandNumber(0, this.e - 1);
                        String str = (String) this.f.get(randNumber).first;
                        int intValue = ((Integer) this.f.get(randNumber).second).intValue();
                        jSONObject.put(com.umeng.ccg.a.F, str);
                        jSONObject.put(com.umeng.ccg.a.G, intValue);
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "selPoclicy: 1, currIndex: " + randNumber);
                        return;
                    }
                    if (i2 != 2 || (i = this.g) >= this.e) {
                        return;
                    }
                    String str2 = (String) this.f.get(i).first;
                    int intValue2 = ((Integer) this.f.get(this.g).second).intValue();
                    jSONObject.put(com.umeng.ccg.a.F, str2);
                    jSONObject.put(com.umeng.ccg.a.G, intValue2);
                    jSONObject.put(com.umeng.ccg.a.H, this.g);
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "processInternal():: selPoclicy: 2, currIndex: " + this.g);
                    this.g = this.g + 1;
                    return;
                }
                SharedPreferences a = av.a(UMGlobalContext.getAppContext());
                if (a != null) {
                    int i4 = a.getInt(av.h, 0);
                    int i5 = this.e;
                    ArrayList<Pair<String, Integer>> arrayList = this.f;
                    if (i4 < i5) {
                        String str3 = (String) arrayList.get(i4).first;
                        int intValue3 = ((Integer) this.f.get(i4).second).intValue();
                        jSONObject.put(com.umeng.ccg.a.F, str3);
                        jSONObject.put(com.umeng.ccg.a.G, intValue3);
                        jSONObject.put(com.umeng.ccg.a.H, i4);
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "selPoclicy: 0, currIndex: " + i4);
                        if (i4 < this.e - 1) {
                            i3 = i4 + 1;
                        }
                    } else {
                        String str4 = (String) arrayList.get(0).first;
                        int intValue4 = ((Integer) this.f.get(0).second).intValue();
                        jSONObject.put(com.umeng.ccg.a.F, str4);
                        jSONObject.put(com.umeng.ccg.a.G, intValue4);
                        jSONObject.put(com.umeng.ccg.a.H, 0);
                    }
                    a.edit().putInt(av.h, i3).commit();
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.umeng.analytics.pro.ac
    public String a() {
        return super.a();
    }

    @Override // com.umeng.analytics.pro.ac, com.umeng.analytics.pro.ak
    public JSONObject a(String str, JSONObject jSONObject) {
        JSONObject a = super.a(str, jSONObject);
        if (this.e == 0) {
            return null;
        }
        if (jSONObject != null) {
            try {
                a.put(com.umeng.ccg.a.C, this.b);
                a.put(com.umeng.ccg.a.B, this.a);
                int optInt = jSONObject.optInt(com.umeng.ccg.a.j);
                if (this.b == 0 && optInt == 202) {
                    a(a);
                }
                if (this.b == 1 && optInt == 304) {
                    a(a);
                }
            } catch (Throwable unused) {
            }
        }
        return a;
    }

    public void a(int i) {
        this.a = i;
    }

    @Override // com.umeng.analytics.pro.ac
    public void a(String str) {
        super.a(str);
    }

    @Override // com.umeng.analytics.pro.ac
    public String b() {
        return super.b();
    }

    public void b(int i) {
        this.b = i;
    }

    @Override // com.umeng.analytics.pro.ac
    public void b(String str) {
        super.b(str);
    }

    @Override // com.umeng.analytics.pro.ac, com.umeng.analytics.pro.ak
    public void b(String str, JSONObject jSONObject) {
        super.b(str, jSONObject);
        if (jSONObject.has(com.umeng.ccg.a.B)) {
            a(jSONObject.optInt(com.umeng.ccg.a.B));
        }
        if (jSONObject.has(com.umeng.ccg.a.C)) {
            b(jSONObject.optInt(com.umeng.ccg.a.C));
        }
        if (jSONObject.has(com.umeng.ccg.a.A)) {
            c(jSONObject.optString(com.umeng.ccg.a.A));
        }
        if (jSONObject.has(com.umeng.ccg.a.D)) {
            c(jSONObject.optInt(com.umeng.ccg.a.D));
        }
        if (jSONObject.has(com.umeng.ccg.a.E)) {
            d(jSONObject.optInt(com.umeng.ccg.a.E));
        }
    }

    @Override // com.umeng.analytics.pro.ac
    public String c() {
        return super.c();
    }

    public void c(int i) {
        this.c = i;
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(new String(ay.a(Base64.decode(str, 0), UMUtils.genSin())));
            int length = jSONArray.length();
            if (length > 0) {
                this.f = new ArrayList<>();
            }
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String optString = jSONObject.has("type") ? jSONObject.optString("type") : "";
                int valueOf = jSONObject.has(com.umeng.ccg.a.G) ? Integer.valueOf(jSONObject.optInt(com.umeng.ccg.a.G)) : 1;
                if (!TextUtils.isEmpty(optString)) {
                    this.f.add(new Pair<>(optString, valueOf));
                }
            }
            this.e = this.f.size();
            this.g = 0;
        } catch (Throwable unused) {
        }
    }

    public int d() {
        return this.e;
    }

    public JSONObject d(String str) {
        JSONObject jSONObject = null;
        try {
            if (this.g < this.e) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    String str2 = (String) this.f.get(this.g).first;
                    int intValue = ((Integer) this.f.get(this.g).second).intValue();
                    jSONObject2.put(com.umeng.ccg.a.F, str2);
                    jSONObject2.put(com.umeng.ccg.a.G, intValue);
                    jSONObject2.put(com.umeng.ccg.a.H, this.g);
                    jSONObject2.put("actionName", str);
                    jSONObject2.put(com.umeng.ccg.a.x, c());
                    jSONObject2.put(com.umeng.ccg.a.u, "uapp");
                    jSONObject2.put(com.umeng.ccg.a.v, "");
                    jSONObject2.put(com.umeng.ccg.a.w, "");
                    jSONObject2.put(com.umeng.ccg.a.C, this.b);
                    jSONObject2.put(com.umeng.ccg.a.B, this.a);
                    int i = i();
                    jSONObject2.put("delay", i);
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "getNextTypeArg():: currIndex: " + this.g + "; delay: " + i);
                    this.g = this.g + 1;
                    return jSONObject2;
                } catch (Throwable unused) {
                    jSONObject = jSONObject2;
                }
            } else {
                this.g = 0;
            }
        } catch (Throwable unused2) {
        }
        return jSONObject;
    }

    public void d(int i) {
        this.d = i;
    }

    public int e() {
        return this.a;
    }

    public int f() {
        return this.b;
    }

    public int g() {
        return this.c;
    }

    public int h() {
        return this.d;
    }

    public int i() {
        return at.a(this.c, this.d);
    }

    public ArrayList<Pair<String, Integer>> j() {
        return this.f;
    }
}
