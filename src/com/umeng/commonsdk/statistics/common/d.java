package com.umeng.commonsdk.statistics.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.analytics.pro.bt;
import com.umeng.analytics.pro.bv;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /tmp/classes2.dex */
public class d {
    private static final boolean a = false;
    private static volatile JSONObject b = null;
    private static boolean c = true;
    private static final a d = new a();

    /* loaded from: /tmp/classes2.dex */
    public static class a {
        private static final String a = "ins_referrer";
        private JSONArray b;

        private a() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x0041, code lost:
        
            if (r10 == null) goto L20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:5:0x0023, code lost:
        
            if (r10 != null) goto L31;
         */
        /* JADX WARN: Code restructure failed: missing block: B:6:0x0044, code lost:
        
            return null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0025, code lost:
        
            r10.close();
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private org.json.JSONObject a(android.content.Context r10, android.net.Uri r11, java.lang.String[] r12) {
            /*
                r9 = this;
                java.lang.String r1 = "[iReferrer] failed: "
                r2 = 0
                android.content.ContentResolver r3 = r10.getContentResolver()     // Catch: java.lang.Throwable -> L29
                r6 = 0
                r8 = 0
                r5 = 0
                r4 = r11
                r7 = r12
                android.database.Cursor r10 = r3.query(r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L29
                if (r10 == 0) goto L23
                boolean r11 = r10.moveToFirst()     // Catch: java.lang.Throwable -> L20
                if (r11 == 0) goto L23
                org.json.JSONObject r9 = r9.a(r10)     // Catch: java.lang.Throwable -> L20
                r10.close()     // Catch: java.lang.Throwable -> L1f
            L1f:
                return r9
            L20:
                r0 = move-exception
                r9 = r0
                goto L2c
            L23:
                if (r10 == 0) goto L44
            L25:
                r10.close()     // Catch: java.lang.Throwable -> L44
                goto L44
            L29:
                r0 = move-exception
                r9 = r0
                r10 = r2
            L2c:
                java.lang.String r11 = "MobclickRT"
                java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L45
                r12.<init>(r1)     // Catch: java.lang.Throwable -> L45
                java.lang.String r9 = r9.getMessage()     // Catch: java.lang.Throwable -> L45
                r12.append(r9)     // Catch: java.lang.Throwable -> L45
                java.lang.String r9 = r12.toString()     // Catch: java.lang.Throwable -> L45
                com.umeng.commonsdk.debug.UMRTLog.se(r11, r9)     // Catch: java.lang.Throwable -> L45
                if (r10 == 0) goto L44
                goto L25
            L44:
                return r2
            L45:
                r0 = move-exception
                r9 = r0
                if (r10 == 0) goto L4c
                r10.close()     // Catch: java.lang.Throwable -> L4c
            L4c:
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.common.d.a.a(android.content.Context, android.net.Uri, java.lang.String[]):org.json.JSONObject");
        }

        private JSONObject a(Cursor cursor) {
            JSONObject jSONObject = new JSONObject();
            int min = Math.min(cursor.getColumnCount(), 20);
            for (int i = 0; i < min; i++) {
                try {
                    jSONObject.put(cursor.getColumnName(i), cursor.getString(i));
                } catch (Throwable th) {
                    UMRTLog.se(UMRTLog.RTLOG_TAG, "[iReferrer] failed: " + th.getMessage());
                }
            }
            return jSONObject;
        }

        private boolean a() {
            return f() || b() || c() || e() || d() || g();
        }

        private boolean a(Context context, String str) {
            try {
                ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider(str, 0);
                if (resolveContentProvider != null) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "[iReferrer] pi: " + resolveContentProvider.packageName + "/" + resolveContentProvider.name);
                    return true;
                }
            } catch (Throwable unused) {
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "[iReferrer] pi: null");
            return false;
        }

        private boolean a(String... strArr) {
            String str = Build.BRAND;
            String str2 = Build.MANUFACTURER;
            for (String str3 : strArr) {
                if (str3.equalsIgnoreCase(str) || str3.equalsIgnoreCase(str2)) {
                    return true;
                }
            }
            return false;
        }

        private JSONArray b(Context context) {
            String str;
            JSONObject d;
            JSONArray jSONArray = new JSONArray();
            UMRTLog.i(UMRTLog.RTLOG_TAG, "[iReferrer] start");
            long currentTimeMillis = System.currentTimeMillis();
            try {
            } catch (Throwable th) {
                UMRTLog.se(UMRTLog.RTLOG_TAG, "[iReferrer] failed: " + th.getMessage());
            }
            if (!f() && !bt.c()) {
                if (g()) {
                    str = "honor";
                    d = c(context);
                } else if (b()) {
                    str = "xiaomi";
                    d = e(context);
                } else if (c()) {
                    str = "vivo";
                    d = f(context);
                } else if (e()) {
                    str = "samsung";
                    d = h(context);
                } else if (d()) {
                    str = "oppo";
                    d = g(context);
                } else {
                    str = null;
                    d = null;
                }
                if (d != null && d.length() > 0) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("source", str);
                    jSONObject.put("referrer", d);
                    jSONArray.put(jSONObject);
                    MLog.i("[iReferrer] get:" + jSONObject);
                }
                UMRTLog.i(UMRTLog.RTLOG_TAG, "[iReferrer] result: " + jSONArray + " cost: " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                return jSONArray;
            }
            str = "huawei";
            d = d(context);
            if (d != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("source", str);
                jSONObject2.put("referrer", d);
                jSONArray.put(jSONObject2);
                MLog.i("[iReferrer] get:" + jSONObject2);
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "[iReferrer] result: " + jSONArray + " cost: " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
            return jSONArray;
        }

        private boolean b() {
            return a("XIAOMI", "REDMI", "BLACKSHARK");
        }

        private JSONObject c(Context context) {
            Uri parse = Uri.parse("content://com.hihonor.appmarket.commondata/item/wisepackage");
            String[] strArr = {context.getPackageName()};
            if (a(context, parse.getAuthority())) {
                return a(context, parse, strArr);
            }
            return null;
        }

        private boolean c() {
            return a("VIVO");
        }

        private JSONObject d(Context context) {
            Uri parse = Uri.parse("content://com.huawei.appmarket.commondata/item/5");
            String[] strArr = {context.getPackageName()};
            if (a(context, parse.getAuthority())) {
                return a(context, parse, strArr);
            }
            return null;
        }

        private boolean d() {
            return a("OPPO", "REALME", "ONEPLUS");
        }

        private JSONObject e(Context context) {
            Uri parse = Uri.parse("content://com.xiaomi.market.provider.DirectMailProvider/referrer/v3");
            if (a(context, parse.getAuthority())) {
                return a(context, parse, null);
            }
            return null;
        }

        private boolean e() {
            return a("SAMSUNG");
        }

        private JSONObject f(Context context) {
            try {
                Uri parse = Uri.parse("content://com.bbk.appstore.provider.appstatus");
                if (!a(context, parse.getAuthority())) {
                    return null;
                }
                Bundle bundle = new Bundle();
                bundle.putString(bv.o, context.getPackageName());
                Bundle call = context.getContentResolver().call(parse, "read_channel", (String) null, bundle);
                if (call != null && !call.isEmpty()) {
                    JSONObject jSONObject = new JSONObject();
                    for (String str : call.keySet()) {
                        Object obj = call.get(str);
                        if (obj != null) {
                            jSONObject.put(str, obj.toString());
                        }
                    }
                    return jSONObject;
                }
                return null;
            } catch (Throwable th) {
                UMRTLog.se(UMRTLog.RTLOG_TAG, "[iReferrer] failed: " + th.getMessage());
                return null;
            }
        }

        private boolean f() {
            return a("HUAWEI");
        }

        private JSONObject g(Context context) {
            Bundle call;
            try {
                Uri parse = Uri.parse("content://com.heytap.market.TrackProvider");
                if (a(context, parse.getAuthority()) && (call = context.getContentResolver().call(parse, "getTrackInfo", (String) null, (Bundle) null)) != null && !call.isEmpty()) {
                    JSONObject jSONObject = new JSONObject();
                    for (String str : call.keySet()) {
                        Object obj = call.get(str);
                        if (obj != null) {
                            jSONObject.put(str, obj.toString());
                        }
                    }
                    return jSONObject;
                }
                return null;
            } catch (Throwable th) {
                UMRTLog.se(UMRTLog.RTLOG_TAG, "[iReferrer] failed: " + th.getMessage());
                return null;
            }
        }

        private boolean g() {
            return a("HONOR");
        }

        private JSONObject h(Context context) {
            Uri parse = Uri.parse("content://com.sec.android.app.samsungapps.referrer");
            if (a(context, parse.getAuthority())) {
                return a(context, parse, null);
            }
            return null;
        }

        public JSONArray a(Context context) {
            JSONArray jSONArray = this.b;
            if (jSONArray != null) {
                if (jSONArray.length() > 0) {
                    return this.b;
                }
                return null;
            }
            if (!a()) {
                this.b = new JSONArray();
                return null;
            }
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            String string = sharedPreferences.getString(a, null);
            if (string != null) {
                String str = new String(Base64.decode(string, 2));
                UMRTLog.i(UMRTLog.RTLOG_TAG, "[iReferrer] cache: ".concat(str));
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.optInt("ver", 0) == 1) {
                        JSONArray optJSONArray = jSONObject.optJSONArray("ref");
                        this.b = optJSONArray;
                        if (optJSONArray == null) {
                            this.b = new JSONArray();
                        }
                        if (this.b.length() == 0) {
                            return null;
                        }
                        return this.b;
                    }
                } catch (Throwable unused) {
                }
            }
            this.b = this.b(context);
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("ver", 1);
                jSONObject2.put("ref", this.b);
                sharedPreferences.edit().putString(a, Base64.encodeToString(jSONObject2.toString().getBytes(), 2)).apply();
            } catch (Throwable th) {
                UMRTLog.se(UMRTLog.RTLOG_TAG, "[iReferrer] failed: " + th.getMessage());
            }
            if (this.b.length() > 0) {
                return this.b;
            }
            return null;
        }
    }

    public static JSONArray a(Context context) {
        if (c && context != null) {
            return d.a(context);
        }
        return null;
    }

    public static JSONObject a() {
        return b;
    }

    public static void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            MLog.w("[iReferrer] args cannot empty source: " + str + " referrer: " + str2);
            return;
        }
        if (str.length() > 128) {
            MLog.w("[iReferrer] source too long[>128]: ".concat(str));
            return;
        }
        if (str2.length() > 4096) {
            MLog.w("[iReferrer] referrer too long[>4096]: ".concat(str2));
            return;
        }
        if (b == null) {
            b = new JSONObject();
        }
        try {
            b.put("source", str);
            b.put("referrer", str2);
        } catch (Throwable unused) {
        }
        MLog.i("[iReferrer] set: " + b);
    }

    public static void a(boolean z) {
        c = z;
    }
}
