package com.umeng.analytics.pro;

import android.text.TextUtils;
import android.util.Base64;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /tmp/classes2.dex */
public class cx {
    private int a;
    private String b;
    private String c;
    private int d;
    private a e;

    /* loaded from: /tmp/classes2.dex */
    public static class a {
        private String a;
        private String b;
        private String c;
        private String d;
        private List<b> e;

        public String a() {
            return this.a;
        }

        public void a(String str) {
            this.a = str;
        }

        public void a(List<b> list) {
            this.e = list;
        }

        public String b() {
            return this.b;
        }

        public void b(String str) {
            this.b = str;
        }

        public String c() {
            return this.c;
        }

        public void c(String str) {
            this.c = str;
        }

        public String d() {
            return this.d;
        }

        public void d(String str) {
            this.d = str;
        }

        public List<b> e() {
            return this.e;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static class b {
        private List<Integer> a;
        private String b;
        private List<Integer> c;
        private int d;
        private String e;
        private String f;
        private String g;
        private String h;

        public List<Integer> a() {
            return this.a;
        }

        public void a(int i) {
            this.d = i;
        }

        public void a(String str) {
            this.b = str;
        }

        public void a(List<Integer> list) {
            this.a = list;
        }

        public String b() {
            return this.b;
        }

        public void b(String str) {
            this.e = str;
        }

        public void b(List<Integer> list) {
            this.c = list;
        }

        public List<Integer> c() {
            return this.c;
        }

        public void c(String str) {
            this.f = str;
        }

        public int d() {
            return this.d;
        }

        public void d(String str) {
            this.g = str;
        }

        public String e() {
            return this.e;
        }

        public void e(String str) {
            this.h = str;
        }

        public String f() {
            return this.f;
        }

        public String g() {
            return this.g;
        }

        public String h() {
            return this.h;
        }
    }

    public static cx a(JSONObject jSONObject) {
        cx cxVar = new cx();
        if (jSONObject != null) {
            try {
                cxVar.a(jSONObject.optInt(cl.g));
                cxVar.a(jSONObject.optString(cl.h));
                cxVar.b(jSONObject.optString(cl.n));
                cxVar.b(jSONObject.optInt(cl.i));
                JSONObject optJSONObject = jSONObject.optJSONObject(cl.b);
                if (optJSONObject != null) {
                    a aVar = new a();
                    aVar.a(optJSONObject.optString(cl.c));
                    aVar.b(optJSONObject.optString(cl.k));
                    aVar.c(optJSONObject.optString(cl.l));
                    aVar.d(optJSONObject.optString(cl.j));
                    if (optJSONObject.has(cl.o)) {
                        String optString = optJSONObject.optString(cl.o);
                        if (!TextUtils.isEmpty(optString)) {
                            try {
                                JSONArray jSONArray = new JSONArray(new String(ay.a(Base64.decode(optString, 0), UMUtils.genSin())));
                                ArrayList arrayList = new ArrayList();
                                for (int i = 0; i < jSONArray.length(); i++) {
                                    JSONObject optJSONObject2 = jSONArray.optJSONObject(i);
                                    if (optJSONObject2 != null) {
                                        b bVar = new b();
                                        JSONArray optJSONArray = optJSONObject2.optJSONArray(cl.d);
                                        if (optJSONArray != null) {
                                            ArrayList arrayList2 = new ArrayList();
                                            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                                arrayList2.add(Integer.valueOf(optJSONArray.optInt(i2)));
                                            }
                                            bVar.a(arrayList2);
                                        }
                                        JSONArray optJSONArray2 = optJSONObject2.optJSONArray(cl.e);
                                        if (optJSONArray2 != null) {
                                            ArrayList arrayList3 = new ArrayList();
                                            for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                                                arrayList3.add(Integer.valueOf(optJSONArray2.optInt(i3)));
                                            }
                                            bVar.b(arrayList3);
                                        }
                                        bVar.a(optJSONObject2.optString(cl.p));
                                        bVar.a(optJSONObject2.optInt(cl.q));
                                        bVar.b(optJSONObject2.optString(cl.r));
                                        bVar.c(optJSONObject2.optString(cl.s));
                                        bVar.d(optJSONObject2.optString("interval"));
                                        bVar.e(optJSONObject2.optString(cl.t));
                                        arrayList.add(bVar);
                                    }
                                }
                                aVar.a(arrayList);
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    }
                    cxVar.a(aVar);
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        return cxVar;
    }

    public int a() {
        return this.a;
    }

    public void a(int i) {
        this.a = i;
    }

    public void a(a aVar) {
        this.e = aVar;
    }

    public void a(String str) {
        this.b = str;
    }

    public String b() {
        return this.b;
    }

    public void b(int i) {
        this.d = i;
    }

    public void b(String str) {
        this.c = str;
    }

    public String c() {
        return this.c;
    }

    public int d() {
        return this.d;
    }

    public a e() {
        return this.e;
    }
}
