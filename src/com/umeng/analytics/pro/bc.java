package com.umeng.analytics.pro;

import android.text.TextUtils;
import com.umeng.commonsdk.debug.UMRTLog;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /tmp/classes2.dex */
public class bc {
    public static final String[] a = {"um_plus_game_level", "um_plus_game_pay", "um_plus_game_buy", "um_plus_game_use", "um_plus_game_bonus"};
    public static final String[] b = {"id", "ts", g.ac, "__ct__", "pn", "ds"};
    public static final String c = "^(?!\\d)[a-zA-Z0-9_\\-\\+\\.]{1,}$";
    public static final int d = 128;
    public static final int e = 256;
    public static final int f = 100;
    private a h;
    private String i;
    private String j;
    private boolean k;
    private Map<String, String> l = null;
    private Map<String, Object> m = null;
    JSONObject g = null;

    /* renamed from: com.umeng.analytics.pro.bc$1, reason: invalid class name */
    /* loaded from: /tmp/classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[a.values().length];
            a = iArr;
            try {
                iArr[a.ID.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[a.LABEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[a.STRING_MAP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[a.OBJECT_MAP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public enum a {
        ID,
        LABEL,
        STRING_MAP,
        OBJECT_MAP
    }

    private JSONArray a(String str, Object obj) {
        JSONArray jSONArray = null;
        try {
            JSONObject b2 = b(str, obj);
            if (b2.length() > 0) {
                JSONArray jSONArray2 = new JSONArray();
                try {
                    jSONArray2.put(b2);
                    jSONArray = jSONArray2;
                } catch (Throwable unused) {
                    return jSONArray2;
                }
            }
            JSONObject c2 = c(str, obj);
            if (c2.length() <= 0) {
                return jSONArray;
            }
            if (jSONArray == null) {
                jSONArray = new JSONArray();
            }
            jSONArray.put(c2);
            return jSONArray;
        } catch (Throwable unused2) {
            return jSONArray;
        }
    }

    private JSONObject a(String str, String str2, boolean z) {
        JSONArray jSONArray;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONArray = new JSONArray();
        } catch (Throwable unused) {
        }
        if (str2 == null) {
            jSONArray.put(az.i);
            jSONObject.put(cl.g, jSONArray);
            jSONObject.put("pid", "");
            jSONObject.put(cl.h, str);
            return jSONObject;
        }
        if (str2.getBytes().length > 256) {
            if (z) {
                jSONArray.put(az.m);
            } else {
                jSONArray.put(az.j);
            }
            jSONObject.put(cl.g, jSONArray);
            if (str2.length() > 256) {
                str2 = str2.substring(0, 256);
            }
            jSONObject.put("pid", str2);
            jSONObject.put(cl.h, str);
        }
        return jSONObject;
    }

    private void a(Map<String, Object> map, JSONObject jSONObject, JSONArray jSONArray) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray2 = new JSONArray();
            if (map == null) {
                jSONArray2.put(az.n);
            } else if (map.isEmpty()) {
                jSONArray2.put(az.k);
            } else if (map.size() > 100) {
                jSONArray2.put(az.f);
            }
            if (jSONArray2.length() <= 0) {
                b(map, jSONObject, jSONArray);
            } else {
                jSONObject2.put(cl.g, jSONArray2);
                jSONArray.put(jSONObject2);
            }
        } catch (Throwable unused) {
        }
    }

    private void a(JSONObject jSONObject, JSONArray jSONArray) {
        if (this.g == null) {
            this.g = new JSONObject();
        }
        if (jSONArray.length() > 0) {
            this.g.put("epps", jSONArray);
            if (jSONObject.length() > 0) {
                this.g.put("pps", jSONObject);
            }
        }
        if (!this.g.has("epps") || this.g.has(cl.g)) {
            return;
        }
        this.g.put("eID", this.i);
    }

    private JSONObject b(String str, Object obj) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            if (str == null) {
                jSONArray.put(az.o);
                jSONObject.put("pid", "");
            } else if (TextUtils.isEmpty(str.trim())) {
                jSONArray.put(az.l);
                jSONObject.put("pid", "");
            } else {
                boolean z = str.trim().getBytes().length > 128;
                if (Arrays.asList(b).contains(str)) {
                    jSONArray.put(az.g);
                    jSONObject.put("pid", str);
                }
                if (!Pattern.matches(c, str)) {
                    jSONArray.put(az.p);
                    jSONObject.put("pid", str);
                }
                if (z) {
                    jSONArray.put(az.h);
                    if (str.length() > 128) {
                        str = str.substring(0, 128);
                    }
                    jSONObject.put("pid", str);
                }
            }
            if (jSONArray.length() > 0) {
                jSONObject.put(cl.g, jSONArray);
                jSONObject.put(cl.h, obj);
            }
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    private void b(Map<String, Object> map, JSONObject jSONObject, JSONArray jSONArray) {
        try {
            for (String str : map.keySet()) {
                Object obj = map.get(str);
                JSONArray a2 = a(str, obj);
                if (a2 == null || a2.length() <= 0) {
                    jSONObject.put(str, obj);
                } else {
                    for (int i = 0; i < a2.length(); i++) {
                        jSONArray.put(a2.get(i));
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    private JSONObject c(String str, Object obj) {
        JSONObject jSONObject = new JSONObject();
        if (obj instanceof String) {
            return a(str, (String) obj, false);
        }
        if ((obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Short) || (obj instanceof Float) || (obj instanceof Double)) {
            return jSONObject;
        }
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(az.q);
        jSONObject.put(cl.g, jSONArray);
        jSONObject.put("pid", obj.getClass().getName());
        jSONObject.put(cl.h, str);
        return jSONObject;
    }

    private void h() {
        String str;
        try {
            JSONArray jSONArray = new JSONArray();
            String str2 = this.i;
            String str3 = "";
            if (str2 == null) {
                jSONArray.put(az.a);
            } else if (TextUtils.isEmpty(str2.trim())) {
                jSONArray.put(az.b);
            } else {
                boolean z = this.i.trim().getBytes().length > 128;
                if (Arrays.asList(a).contains(this.i)) {
                    jSONArray.put(az.c);
                    str = this.i;
                } else {
                    str = null;
                }
                if (!Pattern.matches(c, this.i)) {
                    jSONArray.put(az.e);
                    str = this.i;
                }
                if (z) {
                    jSONArray.put(az.d);
                    int length = this.i.length();
                    str = this.i;
                    if (length > 128) {
                        str3 = str.substring(0, 128);
                    }
                }
                str3 = str;
            }
            if (str3 != null) {
                this.g.put("eID", str3);
                if (jSONArray.length() > 0) {
                    this.g.put(cl.g, jSONArray);
                }
            }
        } catch (Throwable unused) {
        }
    }

    private void i() {
        try {
            h();
            JSONObject a2 = a(this.i, this.j, true);
            if (a2.length() > 0) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(a2);
                if (this.g == null) {
                    this.g = new JSONObject();
                }
                if (!this.g.has("eID")) {
                    this.g.put("eID", this.i);
                }
                this.g.put("epps", jSONArray);
            }
        } catch (Throwable unused) {
        }
    }

    private void j() {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            h();
            if (this.l == null) {
                this.m = null;
            } else {
                this.m = new HashMap(this.l);
            }
            a(this.m, jSONObject, jSONArray);
            a(jSONObject, jSONArray);
        } catch (Throwable unused) {
        }
    }

    private void k() {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            h();
            a(this.m, jSONObject, jSONArray);
            a(jSONObject, jSONArray);
        } catch (Throwable unused) {
        }
    }

    public a a() {
        return this.h;
    }

    public bc a(a aVar) {
        this.h = aVar;
        return this;
    }

    public bc a(String str) {
        this.i = str;
        return this;
    }

    public bc a(Map<String, String> map) {
        this.l = map;
        return this;
    }

    public bc a(boolean z) {
        this.k = z;
        return this;
    }

    public bc b(String str) {
        this.j = str;
        return this;
    }

    public bc b(Map<String, Object> map) {
        this.m = map;
        return this;
    }

    public String b() {
        return this.i;
    }

    public String c() {
        return this.j;
    }

    public boolean d() {
        return this.k;
    }

    public Map<String, String> e() {
        return this.l;
    }

    public Map<String, Object> f() {
        return this.m;
    }

    public JSONObject g() {
        this.g = new JSONObject();
        int i = AnonymousClass1.a[this.h.ordinal()];
        if (i == 1) {
            h();
            JSONObject jSONObject = this.g;
            if (jSONObject == null || jSONObject.length() <= 0) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "未检查到错误。 ");
            } else {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "result: " + this.g);
            }
        } else if (i == 2) {
            i();
            JSONObject jSONObject2 = this.g;
            if (jSONObject2 == null || jSONObject2.length() <= 0) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "未检查到错误。 ");
            } else {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "result: " + this.g);
            }
        } else if (i == 3) {
            j();
            JSONObject jSONObject3 = this.g;
            if (jSONObject3 == null || jSONObject3.length() <= 0) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "未检查到错误。 ");
            } else {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "result: " + this.g);
            }
        } else if (i != 4) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "unknown CkItem type!");
        } else {
            k();
            JSONObject jSONObject4 = this.g;
            if (jSONObject4 == null || jSONObject4.length() <= 0) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "未检查到错误。 ");
            } else {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "result: " + this.g);
            }
        }
        return this.g;
    }
}
