package com.umeng.analytics.pro;

import android.content.Context;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.service.UMGlobalContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /tmp/classes2.dex */
public class u {
    private static final int a = 0;
    private static final int b = 1;
    private static final int c = 2;
    private static final int d = 3;
    private final long e;

    /* loaded from: /tmp/classes2.dex */
    public static class a {
        public static final u a = new u();

        private a() {
        }
    }

    private u() {
        this.e = 60000L;
    }

    public static u a() {
        return a.a;
    }

    private void a(JSONObject jSONObject, boolean z) {
        if (!z && jSONObject.has(g.n)) {
            jSONObject.remove(g.n);
        }
        if (jSONObject.has(g.L)) {
            jSONObject.remove(g.L);
        }
        if (jSONObject.has("error")) {
            jSONObject.remove("error");
        }
        if (jSONObject.has("ekv")) {
            jSONObject.remove("ekv");
        }
        if (jSONObject.has(g.Z)) {
            jSONObject.remove(g.Z);
        }
        if (jSONObject.has(g.L)) {
            jSONObject.remove(g.L);
        }
        if (jSONObject.has("userlevel")) {
            jSONObject.remove("userlevel");
        }
    }

    private JSONArray b() {
        JSONArray jSONArray = new JSONArray();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", ab.a().a(UMGlobalContext.getAppContext(null)));
            jSONObject.put(g.p, currentTimeMillis);
            jSONObject.put(g.q, currentTimeMillis + 60000);
            jSONObject.put("duration", 60000L);
            jSONArray.put(jSONObject);
        } catch (JSONException unused) {
        }
        return jSONArray;
    }

    private JSONArray c() {
        JSONArray jSONArray = new JSONArray();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", ab.a().d(UMGlobalContext.getAppContext(null)));
            jSONObject.put(g.p, currentTimeMillis);
            jSONArray.put(jSONObject);
        } catch (JSONException unused) {
        }
        return jSONArray;
    }

    public int a(Context context) {
        return Integer.valueOf(UMEnvelopeBuild.imprintProperty(context, "defcon", String.valueOf(0))).intValue();
    }

    public void a(JSONObject jSONObject, Context context) {
        int a2 = a(context);
        if (a2 == 1) {
            a(jSONObject, true);
            l.a(context).b(false, true);
        } else {
            if (a2 == 2) {
                jSONObject.remove(g.n);
                try {
                    jSONObject.put(g.n, b());
                } catch (Exception unused) {
                }
                a(jSONObject, true);
                l.a(context).b(false, true);
                return;
            }
            if (a2 == 3) {
                a(jSONObject, false);
                l.a(context).b(false, true);
            }
        }
    }

    public void b(JSONObject jSONObject, Context context) {
        int a2 = a(context);
        if (a2 == 1) {
            if (jSONObject.has(g.L)) {
                jSONObject.remove(g.L);
            }
            if (jSONObject.has(g.n)) {
                try {
                    JSONArray jSONArray = jSONObject.getJSONArray(g.n);
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        if (jSONObject2.has(g.aA)) {
                            jSONObject2.remove(g.aA);
                        }
                        if (jSONObject2.has(g.aB)) {
                            jSONObject2.remove(g.aB);
                        }
                    }
                } catch (JSONException unused) {
                }
            }
            l.a(context).a(false, true);
            return;
        }
        if (a2 == 2) {
            if (jSONObject.has(g.L)) {
                jSONObject.remove(g.L);
            }
            if (jSONObject.has(g.n)) {
                jSONObject.remove(g.n);
            }
            try {
                jSONObject.put(g.n, c());
            } catch (Exception unused2) {
            }
            l.a(context).a(false, true);
            return;
        }
        if (a2 == 3) {
            if (jSONObject.has(g.L)) {
                jSONObject.remove(g.L);
            }
            jSONObject.remove(g.n);
            l.a(context).a(false, true);
        }
    }
}
