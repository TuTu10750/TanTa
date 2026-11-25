package com.umeng.ccg;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.pro.ac;
import com.umeng.analytics.pro.ad;
import com.umeng.analytics.pro.ae;
import com.umeng.analytics.pro.af;
import com.umeng.analytics.pro.ag;
import com.umeng.analytics.pro.ah;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.aj;
import com.umeng.analytics.pro.al;
import com.umeng.analytics.pro.an;
import com.umeng.analytics.pro.ap;
import com.umeng.analytics.pro.at;
import com.umeng.analytics.pro.av;
import com.umeng.analytics.pro.ay;
import com.umeng.analytics.pro.be;
import com.umeng.analytics.pro.bz;
import com.umeng.analytics.pro.cl;
import com.umeng.ccg.c;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /tmp/classes2.dex */
public class d implements c.a {
    private static final String a = "iucc";
    private static final String b = be.b().b(be.C);
    private static JSONObject c = null;
    private static final String[] d = {com.umeng.ccg.a.f, com.umeng.ccg.a.g, com.umeng.ccg.a.h};
    private static final String[] e = {com.umeng.ccg.a.f, com.umeng.ccg.a.g, com.umeng.ccg.a.h, com.umeng.ccg.a.i, com.umeng.ccg.a.n};
    private static ArrayList<ad> f = null;
    private static ArrayList<ad> g = null;
    private static ArrayList<ad> h = null;
    private static ArrayList<ad> i = null;
    private static ac j = null;
    private static volatile boolean m = false;
    private static f o = new f();
    private volatile String k = "";
    private volatile boolean l = false;
    private Map<String, c> n = new HashMap();

    /* loaded from: /tmp/classes2.dex */
    public class a {
        private long b;
        private long c;

        public a(long j, long j2) {
            this.b = j;
            this.c = j2;
        }

        public long a() {
            return this.b;
        }

        public long b() {
            return this.c;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static class b extends BroadcastReceiver {
        public long a(ArrayList<ad> arrayList) {
            if (arrayList == null || arrayList.size() <= 0) {
                return 0L;
            }
            for (int i = 0; i < arrayList.size(); i++) {
                ad adVar = arrayList.get(i);
                if (adVar instanceof ag) {
                    return ((ag) adVar).c();
                }
            }
            return 0L;
        }

        public boolean b(ArrayList<ad> arrayList) {
            if (arrayList == null || arrayList.size() <= 0) {
                return false;
            }
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i).b()) {
                    return false;
                }
            }
            return true;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                String action = intent.getAction();
                if (!TextUtils.isEmpty(action) && action.equals("android.intent.action.SCREEN_ON") && d.j != null && (d.j instanceof af)) {
                    if (!b(d.i)) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "don't send INVOKE_APPACT_WHEN_SCREEN_ON msg.");
                    } else {
                        com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), com.umeng.ccg.c.s, d.a(), null, a(d.i) * 1000);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c {
        private JSONArray b;
        private String c;

        public c(JSONArray jSONArray, String str) {
            this.b = jSONArray;
            this.c = str;
        }

        public JSONArray a() {
            return this.b;
        }

        public String b() {
            return this.c;
        }
    }

    /* renamed from: com.umeng.ccg.d$d, reason: collision with other inner class name */
    /* loaded from: /tmp/classes2.dex */
    public class C0016d {
        public String a;
        public int b;
        public int c;

        public C0016d(String str, int i, int i2) {
            this.a = str;
            this.b = i;
            this.c = i2;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static class e {
        private static final d a = new d();

        private e() {
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static class f extends BroadcastReceiver {
        public long a(ArrayList<ad> arrayList) {
            if (arrayList == null || arrayList.size() <= 0) {
                return 0L;
            }
            for (int i = 0; i < arrayList.size(); i++) {
                ad adVar = arrayList.get(i);
                if (adVar instanceof ag) {
                    return ((ag) adVar).c();
                }
            }
            return 0L;
        }

        public boolean b(ArrayList<ad> arrayList) {
            if (arrayList == null || arrayList.size() <= 0) {
                return false;
            }
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i).b()) {
                    return false;
                }
            }
            return true;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                String action = intent.getAction();
                if (TextUtils.isEmpty(action)) {
                    return;
                }
                if (action.equals("android.intent.action.SCREEN_ON")) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "recv intent : ACTION_SCREEN_ON");
                    if (b(d.f)) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "report screen_on event.");
                        com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), com.umeng.ccg.c.p, d.a(), null, a(d.f) * 1000);
                    } else {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "don't report screen_on event.");
                    }
                }
                if (action.equals("android.intent.action.SCREEN_OFF")) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "recv intent : ACTION_SCREEN_OFF");
                    if (b(d.g)) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "report screen_off event.");
                        com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), com.umeng.ccg.c.q, d.a(), null, a(d.g) * 1000);
                    } else {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "don't report screen_off event.");
                    }
                }
                if (action.equals("android.intent.action.USER_PRESENT")) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "recv intent : ACTION_USER_PRESENT");
                    if (!b(d.h)) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "don't report screen_unlock event.");
                        return;
                    }
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "report screen_unlock event.");
                    com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), com.umeng.ccg.c.r, d.a(), null, a(d.h) * 1000);
                }
            } catch (Throwable unused) {
            }
        }
    }

    private ac a(String str, JSONObject jSONObject) {
        ac acVar;
        JSONArray optJSONArray;
        String str2;
        JSONArray optJSONArray2;
        if (jSONObject == null) {
            return null;
        }
        try {
            if (!jSONObject.has(com.umeng.ccg.a.o) || (optJSONArray = jSONObject.optJSONArray(com.umeng.ccg.a.o)) == null || optJSONArray.length() <= 0) {
                return null;
            }
            JSONObject jSONObject2 = (JSONObject) optJSONArray.get(0);
            boolean has = jSONObject2.has(com.umeng.ccg.a.p);
            boolean has2 = jSONObject2.has(com.umeng.ccg.a.s);
            boolean has3 = jSONObject2.has(com.umeng.ccg.a.t);
            if (!has || !has2 || !has3) {
                return null;
            }
            int optInt = jSONObject2.optInt(com.umeng.ccg.a.p);
            long optLong = jSONObject2.optLong(com.umeng.ccg.a.s);
            long optLong2 = jSONObject2.optLong(com.umeng.ccg.a.t);
            String optString = jSONObject2.optString(com.umeng.ccg.a.u);
            ArrayList arrayList = new ArrayList();
            acVar = null;
            if (jSONObject2.has(com.umeng.ccg.a.q)) {
                try {
                    JSONArray optJSONArray3 = jSONObject2.optJSONArray(com.umeng.ccg.a.q);
                    HashSet hashSet = new HashSet();
                    if (optJSONArray3 != null) {
                        str2 = com.umeng.ccg.a.x;
                        int i2 = 0;
                        for (int length = optJSONArray3.length(); i2 < length; length = length) {
                            hashSet.add(Integer.valueOf(optJSONArray3.getInt(i2)));
                            i2++;
                        }
                    } else {
                        str2 = com.umeng.ccg.a.x;
                    }
                    if (hashSet.size() > 0) {
                        an anVar = new an(hashSet);
                        if (Arrays.asList(d).contains(str)) {
                            a(str, anVar);
                        } else {
                            arrayList.add(anVar);
                            if (com.umeng.ccg.a.i.equalsIgnoreCase(str)) {
                                a(str, anVar);
                            }
                        }
                    }
                } catch (Throwable unused) {
                    return acVar;
                }
            } else {
                str2 = com.umeng.ccg.a.x;
            }
            if (jSONObject2.has(com.umeng.ccg.a.r)) {
                String optString2 = jSONObject2.optString(com.umeng.ccg.a.r);
                if (!TextUtils.isEmpty(optString2)) {
                    al alVar = new al(optString2);
                    HashSet hashSet2 = new HashSet();
                    for (int i3 = 1; i3 <= 24; i3++) {
                        if (alVar.a(i3)) {
                            hashSet2.add(Integer.valueOf(i3));
                        }
                    }
                    if (hashSet2.size() > 0) {
                        ah ahVar = new ah(hashSet2);
                        if (Arrays.asList(d).contains(str)) {
                            a(str, ahVar);
                        } else {
                            arrayList.add(ahVar);
                        }
                        if (com.umeng.ccg.a.i.equalsIgnoreCase(str)) {
                            a(str, ahVar);
                        }
                    }
                }
            }
            arrayList.add(new aj(optInt));
            ai aiVar = new ai(str, optLong);
            String[] strArr = d;
            if (Arrays.asList(strArr).contains(str)) {
                a(str, aiVar);
            } else {
                arrayList.add(aiVar);
            }
            if (com.umeng.ccg.a.i.equalsIgnoreCase(str)) {
                a(str, aiVar);
            }
            ag agVar = new ag(optLong2);
            if (Arrays.asList(strArr).contains(str)) {
                a(str, agVar);
                arrayList.add(agVar);
            } else {
                arrayList.add(agVar);
            }
            if (com.umeng.ccg.a.i.equalsIgnoreCase(str)) {
                a(str, agVar);
            }
            ac aeVar = com.umeng.ccg.a.e.equals(str) ? new ae(str, arrayList) : com.umeng.ccg.a.i.equals(str) ? new af(str, arrayList) : new ac(str, arrayList);
            try {
                aeVar.b(str, jSONObject2);
                aeVar.a(optString);
                String str3 = "";
                String str4 = str2;
                if (jSONObject.has(str4) && (optJSONArray2 = jSONObject.optJSONArray(str4)) != null) {
                    Map<String, c> map = this.n;
                    if (map != null && !map.containsKey(str)) {
                        this.n.put(str, new c(new JSONArray(optJSONArray2.toString()), optString));
                    }
                    int length2 = optJSONArray2.length();
                    for (int i4 = 0; i4 < optJSONArray2.length(); i4++) {
                        String str5 = str3 + optJSONArray2.getString(i4);
                        if (i4 < length2 - 1) {
                            str5 = str5 + ",";
                        }
                        str3 = str5;
                    }
                }
                aeVar.b(str3);
                return aeVar;
            } catch (Throwable unused2) {
                return aeVar;
            }
        } catch (Throwable unused3) {
            acVar = null;
        }
    }

    public static d a() {
        return e.a;
    }

    private JSONObject a(String str, int i2, int i3) {
        c cVar;
        JSONObject jSONObject = new JSONObject();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            jSONObject.put("id", "$$_umc_ev1");
            jSONObject.put("ts", currentTimeMillis);
            jSONObject.put("tt", str);
            jSONObject.put(com.umeng.ccg.a.G, i2);
            jSONObject.put("result", i3);
            if (!this.n.containsKey(com.umeng.ccg.a.i) || (cVar = this.n.get(com.umeng.ccg.a.i)) == null) {
                return null;
            }
            JSONObject a2 = ap.a(UMGlobalContext.getAppContext(), cVar.a(), cVar.b());
            JSONObject a3 = ap.a(UMGlobalContext.getAppContext(), jSONObject);
            if (a2 == null || a3 == null) {
                return null;
            }
            return ap.a(a2, a3);
        } catch (Throwable unused) {
            return null;
        }
    }

    private void a(Context context, String str, long j2) {
        SharedPreferences a2;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String[] split = str.split("@");
            if (split.length != 4 || (a2 = av.a(context)) == null) {
                return;
            }
            long parseLong = Long.parseLong(split[0]);
            String str2 = split[1];
            SharedPreferences.Editor edit = a2.edit();
            edit.putLong("config_ts", j2);
            edit.putLong(av.d, parseLong);
            edit.putString(av.e, str2).commit();
            UMRTLog.i(UMRTLog.RTLOG_TAG, "updateTsS1S2 : ts = " + j2 + "; s1 = " + parseLong + "; s2 = " + str2);
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context, String str, BroadcastReceiver broadcastReceiver) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(str);
        context.registerReceiver(broadcastReceiver, intentFilter);
    }

    private void a(Context context, String str, JSONObject jSONObject) {
    }

    private synchronized void a(Context context, JSONObject jSONObject, String str) {
        long b2;
        byte[] a2;
        try {
            b2 = b(jSONObject);
            a2 = ay.a(jSONObject.toString().getBytes(), UMConfigure.sAppkey.getBytes());
        } catch (Throwable unused) {
        }
        if (a2 != null && a2.length > 1) {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(context.getFilesDir(), b));
            try {
                fileOutputStream.write(a2);
                fileOutputStream.flush();
                at.a(fileOutputStream);
                a(context, str, b2);
                UMRTLog.i(UMRTLog.RTLOG_TAG, "saveConfigFile success.");
                JSONObject optJSONObject = jSONObject.optJSONObject(com.umeng.ccg.a.a);
                if (optJSONObject != null) {
                    File file = new File(context.getFilesDir().getAbsolutePath() + File.separator + bz.n);
                    if (optJSONObject.has(com.umeng.ccg.a.l)) {
                        if (!file.exists()) {
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "PI: cfg is on, flag not exist, create it.");
                            file.createNewFile();
                        }
                    } else if (file.exists()) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "PI: cfg is off, flag exist, delete it.");
                        file.delete();
                    }
                }
            } catch (Throwable th) {
                at.a(fileOutputStream);
                throw th;
            }
        }
    }

    private void a(String str) {
        try {
            String[] split = str.split("@");
            if (split.length != 4) {
                return;
            }
            long parseLong = Long.parseLong(split[0]);
            String str2 = split[1];
            if (!TextUtils.isEmpty(this.k)) {
                String[] split2 = this.k.split("@");
                if (split2.length == 2) {
                    long parseLong2 = Long.parseLong(split2[0]);
                    String str3 = split2[1];
                    if (parseLong2 == parseLong && str3.equalsIgnoreCase(str2)) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "重复的iucc S1 and S2, 忽略本次更新，不发起fetch。");
                        return;
                    }
                }
            }
            SharedPreferences a2 = av.a(UMGlobalContext.getAppContext());
            if (a2 != null) {
                if (a2.getLong("config_ts", 0L) != parseLong) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "local config ts != iuccS1, send FETCH_NEW_CONFIG msg.");
                    this.k = String.valueOf(parseLong) + "@" + str2;
                    com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 101, a(), str);
                    return;
                }
                d(UMGlobalContext.getAppContext());
                if (e(UMGlobalContext.getAppContext()).equalsIgnoreCase(str2)) {
                    return;
                }
                UMRTLog.i(UMRTLog.RTLOG_TAG, "local S2 != iuccS2, send FETCH_NEW_CONFIG msg.");
                this.k = String.valueOf(parseLong) + "@" + str2;
                com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 101, a(), str);
            }
        } catch (Throwable unused) {
        }
    }

    private void a(String str, ad adVar) {
        if (com.umeng.ccg.a.f.equalsIgnoreCase(str)) {
            if (f == null) {
                f = new ArrayList<>();
            }
            f.add(adVar);
        }
        if (com.umeng.ccg.a.g.equalsIgnoreCase(str)) {
            if (g == null) {
                g = new ArrayList<>();
            }
            g.add(adVar);
        }
        if (com.umeng.ccg.a.h.equalsIgnoreCase(str)) {
            if (h == null) {
                h = new ArrayList<>();
            }
            h.add(adVar);
        }
        if (com.umeng.ccg.a.i.equalsIgnoreCase(str)) {
            if (i == null) {
                i = new ArrayList<>();
            }
            i.add(adVar);
        }
    }

    private void a(boolean z) {
        try {
            SharedPreferences a2 = av.a(UMGlobalContext.getAppContext());
            if (a2 != null) {
                SharedPreferences.Editor edit = a2.edit();
                if (z) {
                    edit.putString(av.g, SdkVersion.MINI_VERSION).commit();
                } else {
                    edit.putString(av.g, "").commit();
                }
            }
        } catch (Throwable unused) {
        }
    }

    private boolean a(JSONObject jSONObject) {
        if (jSONObject == null || !jSONObject.has(cl.g)) {
            return false;
        }
        try {
            if (200 == jSONObject.optInt(cl.g) && jSONObject.has(com.umeng.ccg.a.a)) {
                return jSONObject.has("ts");
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    private long b(JSONObject jSONObject) {
        if (jSONObject == null || !jSONObject.has("ts")) {
            return 0L;
        }
        try {
            return jSONObject.optLong("ts");
        } catch (Throwable unused) {
            return 0L;
        }
    }

    private void b(String str) {
        String str2 = "interval_" + str;
        SharedPreferences a2 = av.a(UMGlobalContext.getAppContext());
        if (a2 != null) {
            a2.edit().putLong(str2, System.currentTimeMillis()).commit();
        }
    }

    private void c(Context context) {
        ImprintHandler.getImprintService(context).registImprintCallback(a, new UMImprintChangeCallback() { // from class: com.umeng.ccg.d.1
            @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
            public void onImprintValueChanged(String str, String str2) {
                com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 107, d.a(), str2);
            }
        });
    }

    private void c(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.has(com.umeng.ccg.a.a)) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject(com.umeng.ccg.a.a);
                ac a2 = optJSONObject.has(com.umeng.ccg.a.b) ? a(com.umeng.ccg.a.b, optJSONObject.optJSONObject(com.umeng.ccg.a.b)) : null;
                ac a3 = optJSONObject.has(com.umeng.ccg.a.c) ? a(com.umeng.ccg.a.c, optJSONObject.optJSONObject(com.umeng.ccg.a.c)) : null;
                ac a4 = optJSONObject.has(com.umeng.ccg.a.d) ? a(com.umeng.ccg.a.d, optJSONObject.optJSONObject(com.umeng.ccg.a.d)) : null;
                ac a5 = optJSONObject.has(com.umeng.ccg.a.e) ? a(com.umeng.ccg.a.e, optJSONObject.optJSONObject(com.umeng.ccg.a.e)) : null;
                ac a6 = optJSONObject.has(com.umeng.ccg.a.f) ? a(com.umeng.ccg.a.f, optJSONObject.optJSONObject(com.umeng.ccg.a.f)) : null;
                ac a7 = optJSONObject.has(com.umeng.ccg.a.g) ? a(com.umeng.ccg.a.g, optJSONObject.optJSONObject(com.umeng.ccg.a.g)) : null;
                ac a8 = optJSONObject.has(com.umeng.ccg.a.h) ? a(com.umeng.ccg.a.h, optJSONObject.optJSONObject(com.umeng.ccg.a.h)) : null;
                ac a9 = optJSONObject.has(com.umeng.ccg.a.n) ? a(com.umeng.ccg.a.n, optJSONObject.optJSONObject(com.umeng.ccg.a.n)) : null;
                ArrayList arrayList = new ArrayList();
                if (a2 != null) {
                    arrayList.add(a2);
                }
                if (a3 != null) {
                    arrayList.add(a3);
                }
                if (a4 != null) {
                    arrayList.add(a4);
                }
                if (a5 != null) {
                    arrayList.add(a5);
                }
                if (a6 != null) {
                    arrayList.add(a6);
                }
                if (a7 != null) {
                    arrayList.add(a7);
                }
                if (a8 != null) {
                    arrayList.add(a8);
                }
                if (a9 != null) {
                    arrayList.add(a9);
                }
                com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 202, a(), arrayList);
            } catch (Throwable unused) {
            }
        }
    }

    private Long d(Context context) {
        long j2 = 0L;
        try {
            SharedPreferences a2 = av.a(context);
            return a2 != null ? Long.valueOf(a2.getLong(av.d, 0L)) : j2;
        } catch (Throwable unused) {
            return j2;
        }
    }

    private String e(Context context) {
        try {
            SharedPreferences a2 = av.a(context);
            return a2 != null ? a2.getString(av.e, "") : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    private boolean g() {
        SharedPreferences a2 = av.a(UMGlobalContext.getAppContext());
        if (a2 != null) {
            String string = a2.getString(av.f, "");
            if (TextUtils.isEmpty(string)) {
                h();
                return false;
            }
            try {
                if (!at.a().keySet().equals(at.a(new JSONObject(string)).keySet())) {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    private void h() {
        try {
            SharedPreferences a2 = av.a(UMGlobalContext.getAppContext());
            if (a2 != null) {
                a2.edit().putString(av.f, new JSONObject(at.a()).toString()).commit();
            }
        } catch (Throwable unused) {
        }
    }

    private boolean i() {
        try {
            SharedPreferences a2 = av.a(UMGlobalContext.getAppContext());
            if (a2 != null) {
                return !TextUtils.isEmpty(a2.getString(av.g, ""));
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    private JSONObject j() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ay.b(UMUtils.genUmc(), byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            ay.a(byteArray, UMUtils.genSin());
            String str = new String(byteArray);
            byteArrayOutputStream.reset();
            return new JSONObject(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public JSONObject a(String str, String str2, String str3, long j2, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", "$$_umc_ev2");
            jSONObject.put("ts", j2);
            jSONObject.put("tt", str);
            jSONObject.put("flag", str2);
            jSONObject.put("ss", str3);
            if (z) {
                jSONObject.put("cd", 1);
            } else {
                jSONObject.put("cd", 0);
            }
            JSONObject a2 = ap.a(UMGlobalContext.getAppContext(), new JSONArray(), "");
            JSONObject a3 = ap.a(UMGlobalContext.getAppContext(), jSONObject);
            if (a2 == null || a3 == null) {
                return null;
            }
            return ap.a(a2, a3);
        } catch (Throwable unused) {
            return null;
        }
    }

    public void a(Context context) {
        com.umeng.ccg.c.a(context, 105, a(), null);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:327|(1:329)|330|331|332|333|(3:345|346|(7:348|336|337|338|(1:340)|342|343))|335|336|337|338|(0)|342|343) */
    /* JADX WARN: Removed duplicated region for block: B:340:0x07d1 A[Catch: all -> 0x07d4, TRY_LEAVE, TryCatch #6 {all -> 0x07d4, blocks: (B:338:0x07cc, B:340:0x07d1), top: B:337:0x07cc }] */
    @Override // com.umeng.ccg.c.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(java.lang.Object r33, int r34) {
        /*
            Method dump skipped, instructions count: 2610
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.ccg.d.a(java.lang.Object, int):void");
    }

    public synchronized JSONObject b(Context context) {
        File filesDir;
        String str;
        FileInputStream fileInputStream;
        JSONObject jSONObject = null;
        try {
            filesDir = context.getFilesDir();
            str = b;
        } catch (Throwable unused) {
        }
        if (!new File(filesDir, str).exists()) {
            return null;
        }
        try {
            fileInputStream = context.openFileInput(str);
        } catch (Throwable unused2) {
            fileInputStream = null;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(new String(ay.a(HelperUtils.readStreamToByteArray(fileInputStream), UMConfigure.sAppkey.getBytes())));
            try {
                at.a(fileInputStream);
            } catch (Throwable unused3) {
            }
            jSONObject = jSONObject2;
        } catch (Throwable unused4) {
            at.a(fileInputStream);
            return jSONObject;
        }
        return jSONObject;
    }
}
