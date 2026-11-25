package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /tmp/classes2.dex */
public abstract class ai {
    public static final Logger a = Logger.getLogger(ai.class.getName());

    /* loaded from: /tmp/classes2.dex */
    public static class a {
        public uv2 a;
        public byte[][] b;
    }

    public static Object a(Object obj, List list) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof byte[]) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("_placeholder", true);
                jSONObject.put("num", list.size());
                list.add((byte[]) obj);
                return jSONObject;
            } catch (JSONException e) {
                a.log(Level.WARNING, "An error occured while putting data to JSONObject", (Throwable) e);
                return null;
            }
        }
        if (obj instanceof JSONArray) {
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = (JSONArray) obj;
            int length = jSONArray2.length();
            for (int i = 0; i < length; i++) {
                try {
                    jSONArray.put(i, a(jSONArray2.get(i), list));
                } catch (JSONException e2) {
                    a.log(Level.WARNING, "An error occured while putting packet data to JSONObject", (Throwable) e2);
                    return null;
                }
            }
            return jSONArray;
        }
        if (!(obj instanceof JSONObject)) {
            return obj;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = (JSONObject) obj;
        Iterator<String> keys = jSONObject3.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                jSONObject2.put(next, a(jSONObject3.get(next), list));
            } catch (JSONException e3) {
                a.log(Level.WARNING, "An error occured while putting data to JSONObject", (Throwable) e3);
                return null;
            }
        }
        return jSONObject2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [org.json.JSONObject] */
    public static Object b(Object obj, byte[][] bArr) {
        if (obj instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj;
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                try {
                    jSONArray.put(i, b(jSONArray.get(i), bArr));
                } catch (JSONException e) {
                    a.log(Level.WARNING, "An error occured while putting packet data to JSONObject", (Throwable) e);
                    return null;
                }
            }
            return jSONArray;
        }
        if (obj instanceof JSONObject) {
            obj = (JSONObject) obj;
            if (obj.optBoolean("_placeholder")) {
                int optInt = obj.optInt("num", -1);
                if (optInt < 0 || optInt >= bArr.length) {
                    return null;
                }
                return bArr[optInt];
            }
            Iterator<String> keys = obj.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    obj.put(next, b(obj.get(next), bArr));
                } catch (JSONException e2) {
                    a.log(Level.WARNING, "An error occured while putting data to JSONObject", (Throwable) e2);
                    return null;
                }
            }
        }
        return obj;
    }

    public static a c(uv2 uv2Var) {
        ArrayList arrayList = new ArrayList();
        uv2Var.d = a(uv2Var.d, arrayList);
        uv2Var.e = arrayList.size();
        a aVar = new a();
        aVar.a = uv2Var;
        aVar.b = (byte[][]) arrayList.toArray(new byte[arrayList.size()]);
        return aVar;
    }

    public static uv2 d(uv2 uv2Var, byte[][] bArr) {
        uv2Var.d = b(uv2Var.d, bArr);
        uv2Var.e = -1;
        return uv2Var;
    }
}
