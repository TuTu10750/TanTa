package com.umeng.crash;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.commonsdk.deeplink.DeepLinkPresetEvent;
import java.io.File;
import java.util.Calendar;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /tmp/classes2.dex */
public final class j {
    public static String a(Context context, String str) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("um_crash_cfg", 0);
            String str2 = "k_ver";
            if (!TextUtils.isEmpty(str)) {
                String[] split = str.split(":");
                if (split.length > 1) {
                    str2 = "k_ver_" + split[1];
                }
            }
            return sharedPreferences.getString(str2, "");
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean a(long j, long j2) {
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        calendar2.setTimeInMillis(j2);
        return calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6);
    }

    public static boolean a(Context context) {
        try {
            String string = context.getSharedPreferences("um_crash_cfg", 0).getString("k_generate", null);
            if (TextUtils.isEmpty(string)) {
                return true;
            }
            JSONObject jSONObject = new JSONObject(string);
            long optLong = jSONObject.optLong("ts", 0L);
            int optInt = jSONObject.optInt("cnt", 0);
            if (!a(System.currentTimeMillis(), optLong)) {
                optInt = 0;
            }
            return optInt < c.a().o;
        } catch (Exception unused) {
            return true;
        }
    }

    public static boolean a(Context context, File file) {
        SharedPreferences sharedPreferences;
        String string;
        JSONObject jSONObject;
        JSONObject optJSONObject;
        try {
            sharedPreferences = context.getSharedPreferences("um_crash_cfg", 0);
            string = sharedPreferences.getString("k_upload", null);
            UCrash.a().a("UCrash.Upload", "get upload cfg: ".concat(String.valueOf(string)));
        } catch (Exception unused) {
        }
        if (TextUtils.isEmpty(string)) {
            return true;
        }
        String str = "crash";
        if (!k.d(file.getPath()) && !k.c(file.getPath()) && !k.b(file.getPath())) {
            if (k.e(file.getPath())) {
                str = "custom";
            }
            return false;
        }
        try {
            jSONObject = new JSONObject(string);
            optJSONObject = jSONObject.optJSONObject(str);
        } catch (Exception unused2) {
        }
        if (optJSONObject == null) {
            return true;
        }
        if ("custom".equals(str)) {
            long optLong = optJSONObject.optLong("ts", 0L);
            int optInt = optJSONObject.optInt("cnt", 0);
            if (!a(System.currentTimeMillis(), optLong)) {
                optInt = 0;
            }
            return optInt < c.a().p;
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray(DeepLinkPresetEvent.UMEventParamTime);
        if (optJSONArray != null && optJSONArray.length() >= 25) {
            JSONArray jSONArray = new JSONArray();
            for (int length = optJSONArray.length() - 1; length >= 0; length--) {
                long optLong2 = optJSONArray.optLong(length, 0L);
                if (optLong2 >= System.currentTimeMillis() - 86400000) {
                    jSONArray.put(optLong2);
                }
            }
            optJSONObject.put(DeepLinkPresetEvent.UMEventParamTime, jSONArray);
            sharedPreferences.edit().putString("k_upload", jSONObject.toString()).apply();
            return jSONArray.length() < 25;
        }
        return true;
    }

    public static void b(Context context, File file) {
        JSONObject jSONObject;
        try {
            String str = "crash";
            if (!k.d(file.getPath()) && !k.c(file.getPath()) && !k.b(file.getPath())) {
                if (!k.e(file.getPath())) {
                    return;
                } else {
                    str = "custom";
                }
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences("um_crash_cfg", 0);
            String string = sharedPreferences.getString("k_upload", null);
            if (TextUtils.isEmpty(string)) {
                jSONObject = new JSONObject();
            } else {
                try {
                    jSONObject = new JSONObject(string);
                } catch (Exception unused) {
                    jSONObject = new JSONObject();
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(str);
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            if ("custom".equals(str)) {
                long optLong = optJSONObject.optLong("ts", 0L);
                int optInt = optJSONObject.optInt("cnt", 0);
                long currentTimeMillis = System.currentTimeMillis();
                int i = a(currentTimeMillis, optLong) ? 1 + optInt : 1;
                optJSONObject.put("ts", currentTimeMillis);
                optJSONObject.put("cnt", i);
            } else {
                JSONArray optJSONArray = optJSONObject.optJSONArray(DeepLinkPresetEvent.UMEventParamTime);
                if (optJSONArray == null) {
                    optJSONArray = new JSONArray();
                }
                optJSONArray.put(System.currentTimeMillis());
                optJSONObject.put(DeepLinkPresetEvent.UMEventParamTime, optJSONArray);
            }
            jSONObject.put(str, optJSONObject);
            sharedPreferences.edit().putString("k_upload", jSONObject.toString()).commit();
            UCrash.a().a("UCrash.Upload", "save cfg: ".concat(String.valueOf(jSONObject)));
        } catch (Exception e) {
            UCrash.a().a("UCrash.Upload", "save cfg failed", e);
        }
    }
}
