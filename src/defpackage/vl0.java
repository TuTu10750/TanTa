package defpackage;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;
import com.alibaba.fastjson.JSON;
import com.umeng.ccg.a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

/* loaded from: /tmp/classes2.dex */
public abstract class vl0 {
    public static String a(Context context) {
        return f(context) ? "emulator" : e() ? "root" : "normal";
    }

    public static String b(String str) {
        if (str == null) {
            System.err.println("输入的 URL 不能为 null");
            return null;
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            System.err.println("不支持的编码格式：UTF-8");
            e.printStackTrace();
            return null;
        }
    }

    public static String c(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("isEmulator", Boolean.valueOf(f(context)));
        hashMap.put("brand", Build.BRAND);
        hashMap.put("device", Build.DEVICE);
        hashMap.put("fingerprint", Build.FINGERPRINT);
        hashMap.put("hardware", Build.HARDWARE);
        hashMap.put("model", Build.MODEL);
        hashMap.put("product", Build.PRODUCT);
        hashMap.put("manufacturer", Build.MANUFACTURER);
        try {
            hashMap.put("androidId", Settings.Secure.getString(context.getContentResolver(), "android_id"));
        } catch (Exception unused) {
        }
        return b(JSON.toJSONString(hashMap));
    }

    public static String d() {
        HashMap hashMap = new HashMap();
        hashMap.put("isRoot", Boolean.valueOf(e()));
        return b(JSON.toJSONString(hashMap));
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0060, code lost:
    
        if (r2 != null) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean e() {
        /*
            java.lang.String r6 = "/system/app/Superuser.apk"
            java.lang.String r7 = "/system/app/Magisk.apk"
            java.lang.String r0 = "/system/bin/su"
            java.lang.String r1 = "/system/xbin/su"
            java.lang.String r2 = "/sbin/su"
            java.lang.String r3 = "/system/su"
            java.lang.String r4 = "/system/bin/.ext/su"
            java.lang.String r5 = "/system/usr/we-need-root/su"
            java.lang.String[] r0 = new java.lang.String[]{r0, r1, r2, r3, r4, r5, r6, r7}
            r1 = 0
            r2 = r1
        L16:
            r3 = 1
            r4 = 8
            if (r2 >= r4) goto L2c
            r4 = r0[r2]
            java.io.File r5 = new java.io.File
            r5.<init>(r4)
            boolean r4 = r5.exists()
            if (r4 == 0) goto L29
            return r3
        L29:
            int r2 = r2 + 1
            goto L16
        L2c:
            r2 = 0
            java.lang.Runtime r0 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L60
            java.lang.String r4 = "/system/xbin/which"
            java.lang.String r5 = "su"
            java.lang.String[] r4 = new java.lang.String[]{r4, r5}     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L60
            java.lang.Process r2 = r0.exec(r4)     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L60
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L60
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L60
            java.io.InputStream r5 = r2.getInputStream()     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L60
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L60
            r0.<init>(r4)     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L60
            java.lang.String r0 = r0.readLine()     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L60
            if (r0 == 0) goto L55
            r2.destroy()
            return r3
        L55:
            r2.destroy()
            goto L63
        L59:
            r0 = move-exception
            if (r2 == 0) goto L5f
            r2.destroy()
        L5f:
            throw r0
        L60:
            if (r2 == 0) goto L63
            goto L55
        L63:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vl0.e():boolean");
    }

    public static boolean f(Context context) {
        String str = Build.BRAND;
        String str2 = Build.DEVICE;
        String str3 = Build.FINGERPRINT;
        String str4 = Build.HARDWARE;
        String str5 = Build.MODEL;
        String str6 = Build.PRODUCT;
        String str7 = Build.MANUFACTURER;
        lx1.d("DeviceCheckUtil", "brand:" + str + "\ndevice:" + str2 + "\nfingerprint:" + str3 + "\nhardware:" + str4 + "\nmodel:" + str5 + "\nproduct:" + str6 + "\nmanufacturer:" + str7);
        if (str != null && str.toLowerCase().contains("generic")) {
            return true;
        }
        if (str2 != null && str2.toLowerCase().contains("generic")) {
            return true;
        }
        if (str3 != null && str3.toLowerCase().contains("generic")) {
            return true;
        }
        if (str5 != null && str5.toLowerCase().contains(a.x)) {
            return true;
        }
        if (str6 != null && str6.toLowerCase().contains(a.x)) {
            return true;
        }
        if (str7 != null && str7.toLowerCase().contains("genymotion")) {
            return true;
        }
        if (str4 != null && (str4.toLowerCase().contains("goldfish") || str4.toLowerCase().contains("ranchu"))) {
            return true;
        }
        try {
            return "9774d56d682e549c".equals(Settings.Secure.getString(context.getContentResolver(), "android_id"));
        } catch (Exception e) {
            Log.e("DeviceCheckUtil", "get ANDROID_ID failed", e);
            return false;
        }
    }
}
