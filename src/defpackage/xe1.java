package defpackage;

import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /tmp/classes2.dex */
public class xe1 {
    public String a;
    public String[] b;
    public long c;
    public long d;

    public xe1(String str) {
        this(new JSONObject(str));
    }

    public xe1(JSONObject jSONObject) {
        JSONArray jSONArray = jSONObject.getJSONArray("upgrades");
        int length = jSONArray.length();
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            strArr[i] = jSONArray.getString(i);
        }
        this.a = jSONObject.getString("sid");
        this.b = strArr;
        this.c = jSONObject.getLong("pingInterval");
        this.d = jSONObject.getLong("pingTimeout");
    }
}
