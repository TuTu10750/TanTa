package com.umeng.umzid;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.lang.reflect.Method;

/* loaded from: /tmp/classes2.dex */
public class ZIDManager {
    public static ZIDManager d;
    public boolean a = false;
    public boolean b = false;
    public boolean c;

    /* loaded from: /tmp/classes2.dex */
    public class a implements Runnable {
        public final /* synthetic */ Context a;
        public final /* synthetic */ IZIDCompletionCallback b;

        public a(Context context, IZIDCompletionCallback iZIDCompletionCallback) {
            this.a = context;
            this.b = iZIDCompletionCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            String a = ZIDManager.a(ZIDManager.this, this.a);
            boolean isEmpty = TextUtils.isEmpty(a);
            IZIDCompletionCallback iZIDCompletionCallback = this.b;
            if (isEmpty) {
                if (iZIDCompletionCallback != null) {
                    iZIDCompletionCallback.onFailure("1002", "获取zid失败");
                }
            } else if (iZIDCompletionCallback != null) {
                iZIDCompletionCallback.onSuccess(a);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements Runnable {
        public final /* synthetic */ Context a;

        public b(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            ZIDManager.this.b(this.a);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c implements Runnable {
        public final /* synthetic */ Context a;

        public c(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            ZIDManager.a(ZIDManager.this, this.a);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0060 A[Catch: all -> 0x0066, TryCatch #1 {all -> 0x0066, blocks: (B:7:0x0011, B:11:0x001e, B:22:0x0060, B:23:0x0068, B:26:0x0078, B:28:0x008a, B:30:0x0097, B:32:0x00ac, B:33:0x00af, B:35:0x00bb, B:36:0x00be, B:38:0x00ca, B:39:0x00cd, B:45:0x005b), top: B:6:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008a A[Catch: all -> 0x0066, TryCatch #1 {all -> 0x0066, blocks: (B:7:0x0011, B:11:0x001e, B:22:0x0060, B:23:0x0068, B:26:0x0078, B:28:0x008a, B:30:0x0097, B:32:0x00ac, B:33:0x00af, B:35:0x00bb, B:36:0x00be, B:38:0x00ca, B:39:0x00cd, B:45:0x005b), top: B:6:0x0011 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ java.lang.String a(com.umeng.umzid.ZIDManager r11, android.content.Context r12) {
        /*
            java.lang.String r0 = "/anti/postZdata"
            boolean r1 = r11.a
            r2 = 0
            if (r1 == 0) goto L8
            return r2
        L8:
            r1 = 1
            r11.a = r1
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
            r4 = 0
            java.lang.String r5 = com.umeng.umzid.Spy.getID()     // Catch: java.lang.Throwable -> L66
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L66
            if (r6 == 0) goto L1e
            r11.a = r4
            return r2
        L1e:
            java.lang.String r6 = "z"
            r3.put(r6, r5)     // Catch: java.lang.Throwable -> L66
            java.lang.String r6 = com.umeng.umzid.d.e(r12)     // Catch: java.lang.Throwable -> L66
            java.lang.String r7 = "mc"
            r3.put(r7, r6)     // Catch: java.lang.Throwable -> L66
            java.lang.String r7 = com.umeng.umzid.d.f(r12)     // Catch: java.lang.Throwable -> L66
            java.lang.String r8 = "o"
            r3.put(r8, r7)     // Catch: java.lang.Throwable -> L66
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L58
            r8.<init>()     // Catch: java.lang.Throwable -> L58
            java.lang.String r9 = "vpn_pxy"
            boolean r10 = com.umeng.umzid.d.i(r12)     // Catch: java.lang.Throwable -> L56
            r8.put(r9, r10)     // Catch: java.lang.Throwable -> L56
            java.lang.String r9 = "wifi_pxy"
            boolean r10 = com.umeng.umzid.d.j(r12)     // Catch: java.lang.Throwable -> L56
            r8.put(r9, r10)     // Catch: java.lang.Throwable -> L56
            java.lang.String r9 = "double"
            boolean r10 = com.umeng.umzid.d.g(r12)     // Catch: java.lang.Throwable -> L56
            r8.put(r9, r10)     // Catch: java.lang.Throwable -> L56
            goto L5e
        L56:
            r9 = move-exception
            goto L5b
        L58:
            r8 = move-exception
            r9 = r8
            r8 = r2
        L5b:
            r9.printStackTrace()     // Catch: java.lang.Throwable -> L66
        L5e:
            if (r8 == 0) goto L68
            java.lang.String r9 = "anti"
            r3.put(r9, r8)     // Catch: java.lang.Throwable -> L66
            goto L68
        L66:
            r12 = move-exception
            goto Ld1
        L68:
            r11.a(r12, r3)     // Catch: java.lang.Throwable -> L66
            java.lang.String r8 = com.umeng.umzid.d.b(r12)     // Catch: java.lang.Throwable -> L66
            int r9 = r8.length()     // Catch: java.lang.Throwable -> L66
            if (r9 <= 0) goto L76
            goto L78
        L76:
            java.lang.String r8 = "https://utoken.umeng.com"
        L78:
            java.lang.String r0 = r8.concat(r0)     // Catch: java.lang.Throwable -> L66
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L66
            java.lang.String r0 = com.umeng.umzid.a.a(r0, r3)     // Catch: java.lang.Throwable -> L66
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L66
            if (r3 != 0) goto Lcd
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L66
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L66
            java.lang.String r0 = "suc"
            boolean r0 = r3.optBoolean(r0)     // Catch: java.lang.Throwable -> L66
            if (r0 != r1) goto Lcd
            com.umeng.umzid.d.f(r12, r5)     // Catch: java.lang.Throwable -> L66
            com.umeng.umzid.d.a(r12, r6)     // Catch: java.lang.Throwable -> L66
            com.umeng.umzid.d.b(r12, r7)     // Catch: java.lang.Throwable -> L66
            java.lang.String r0 = "aaid"
            java.lang.String r2 = r3.optString(r0)     // Catch: java.lang.Throwable -> L66
            boolean r0 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L66
            if (r0 != 0) goto Laf
            com.umeng.umzid.d.e(r12, r2)     // Catch: java.lang.Throwable -> L66
        Laf:
            java.lang.String r0 = "uabc"
            java.lang.String r0 = r3.optString(r0)     // Catch: java.lang.Throwable -> L66
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L66
            if (r1 != 0) goto Lbe
            com.umeng.umzid.d.d(r12, r0)     // Catch: java.lang.Throwable -> L66
        Lbe:
            java.lang.String r0 = "resetToken"
            java.lang.String r0 = r3.optString(r0)     // Catch: java.lang.Throwable -> L66
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L66
            if (r1 != 0) goto Lcd
            com.umeng.umzid.d.c(r12, r0)     // Catch: java.lang.Throwable -> L66
        Lcd:
            r11.a(r12)     // Catch: java.lang.Throwable -> L66
            goto Ld4
        Ld1:
            r12.printStackTrace()     // Catch: java.lang.Throwable -> Ld7
        Ld4:
            r11.a = r4
            return r2
        Ld7:
            r12 = move-exception
            r11.a = r4
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.umzid.ZIDManager.a(com.umeng.umzid.ZIDManager, android.content.Context):java.lang.String");
    }

    public static void configureDomain(Context context, String str) {
        SharedPreferences a2;
        SharedPreferences.Editor edit;
        String b2 = d.b(str);
        if (context == null || b2 == null || TextUtils.isEmpty(b2) || (a2 = com.umeng.umzid.a.a(context)) == null || (edit = a2.edit()) == null) {
            return;
        }
        edit.putString("inputDomain", b2).commit();
    }

    public static synchronized ZIDManager getInstance() {
        ZIDManager zIDManager;
        synchronized (ZIDManager.class) {
            try {
                if (d == null) {
                    d = new ZIDManager();
                }
                zIDManager = d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zIDManager;
    }

    public static String getSDKVersion() {
        return "1.8.7.2";
    }

    /* JADX WARN: Can't wrap try/catch for region: R(39:1|(5:88|89|(2:96|97)|91|(37:93|4|5|6|7|8|(2:10|(30:14|15|16|17|18|19|(3:69|70|(5:72|73|(2:76|74)|77|78))|21|(1:23)(1:68)|24|(1:26)(1:67)|27|28|29|30|31|32|33|34|35|36|(1:40)|41|42|43|44|45|(2:47|(2:51|52))|54|55))|86|15|16|17|18|19|(0)|21|(0)(0)|24|(0)(0)|27|28|29|30|31|32|33|34|35|36|(2:38|40)|41|42|43|44|45|(0)|54|55))|3|4|5|6|7|8|(0)|86|15|16|17|18|19|(0)|21|(0)(0)|24|(0)(0)|27|28|29|30|31|32|33|34|35|36|(0)|41|42|43|44|45|(0)|54|55) */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x015f, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0160, code lost:
    
        r4.printStackTrace();
        r4 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0146, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0147, code lost:
    
        r4.printStackTrace();
        r4 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x012b, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x012c, code lost:
    
        r4.printStackTrace();
        r4 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x00e1, code lost:
    
        r5 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0070 A[Catch: all -> 0x0084, TryCatch #1 {all -> 0x0084, blocks: (B:6:0x0062, B:8:0x0066, B:10:0x0070, B:12:0x007d, B:14:0x0081), top: B:5:0x0062 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x018a A[Catch: all -> 0x019e, TryCatch #5 {all -> 0x019e, blocks: (B:43:0x017c, B:45:0x0180, B:47:0x018a, B:49:0x0197, B:51:0x019b), top: B:42:0x017c }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ac A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final org.json.JSONObject a(android.content.Context r10, org.json.JSONObject r11) {
        /*
            Method dump skipped, instructions count: 420
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.umzid.ZIDManager.a(android.content.Context, org.json.JSONObject):org.json.JSONObject");
    }

    public final void a(Context context) {
        Object invoke;
        Method declaredMethod;
        try {
            Class<?> cls = Class.forName("com.uyumao.sdk.UYMManager");
            Method declaredMethod2 = cls.getDeclaredMethod("getInstance", null);
            if (declaredMethod2 == null || (invoke = declaredMethod2.invoke(cls, null)) == null || (declaredMethod = cls.getDeclaredMethod("init", Context.class)) == null) {
                return;
            }
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(invoke, context);
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0050 A[Catch: all -> 0x0163, TRY_ENTER, TryCatch #0 {all -> 0x0163, blocks: (B:82:0x0035, B:84:0x003b, B:14:0x0043, B:18:0x0050, B:20:0x005c, B:22:0x0062, B:24:0x006e, B:25:0x0074, B:27:0x0084, B:29:0x008a, B:31:0x0096, B:32:0x009c, B:35:0x00bf, B:37:0x00c5, B:38:0x00c9, B:40:0x00cf, B:51:0x00ff, B:52:0x0104, B:55:0x0111, B:57:0x0123, B:59:0x0130, B:61:0x0143, B:62:0x0146, B:64:0x0150, B:65:0x0153, B:67:0x015d, B:68:0x0160, B:75:0x00fa), top: B:81:0x0035 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ff A[Catch: all -> 0x0163, TryCatch #0 {all -> 0x0163, blocks: (B:82:0x0035, B:84:0x003b, B:14:0x0043, B:18:0x0050, B:20:0x005c, B:22:0x0062, B:24:0x006e, B:25:0x0074, B:27:0x0084, B:29:0x008a, B:31:0x0096, B:32:0x009c, B:35:0x00bf, B:37:0x00c5, B:38:0x00c9, B:40:0x00cf, B:51:0x00ff, B:52:0x0104, B:55:0x0111, B:57:0x0123, B:59:0x0130, B:61:0x0143, B:62:0x0146, B:64:0x0150, B:65:0x0153, B:67:0x015d, B:68:0x0160, B:75:0x00fa), top: B:81:0x0035 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0123 A[Catch: all -> 0x0163, TryCatch #0 {all -> 0x0163, blocks: (B:82:0x0035, B:84:0x003b, B:14:0x0043, B:18:0x0050, B:20:0x005c, B:22:0x0062, B:24:0x006e, B:25:0x0074, B:27:0x0084, B:29:0x008a, B:31:0x0096, B:32:0x009c, B:35:0x00bf, B:37:0x00c5, B:38:0x00c9, B:40:0x00cf, B:51:0x00ff, B:52:0x0104, B:55:0x0111, B:57:0x0123, B:59:0x0130, B:61:0x0143, B:62:0x0146, B:64:0x0150, B:65:0x0153, B:67:0x015d, B:68:0x0160, B:75:0x00fa), top: B:81:0x0035 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String b(android.content.Context r15) {
        /*
            Method dump skipped, instructions count: 358
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.umzid.ZIDManager.b(android.content.Context):java.lang.String");
    }

    public synchronized String getZID(Context context) {
        if (context == null) {
            return "";
        }
        Context applicationContext = context.getApplicationContext();
        String d2 = d.d(applicationContext);
        if (!TextUtils.isEmpty(d2)) {
            return d2;
        }
        com.umeng.umzid.c.a(new c(applicationContext));
        return "";
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x007b A[Catch: all -> 0x0017, TryCatch #1 {, blocks: (B:3:0x0001, B:10:0x000f, B:13:0x001c, B:16:0x0024, B:19:0x002d, B:22:0x0035, B:24:0x003b, B:26:0x0041, B:28:0x0047, B:29:0x0050, B:31:0x0056, B:34:0x005d, B:36:0x0067, B:37:0x0073, B:39:0x007b, B:40:0x0083, B:42:0x0089, B:46:0x0099, B:51:0x006b), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0089 A[Catch: all -> 0x0017, TRY_LEAVE, TryCatch #1 {, blocks: (B:3:0x0001, B:10:0x000f, B:13:0x001c, B:16:0x0024, B:19:0x002d, B:22:0x0035, B:24:0x003b, B:26:0x0041, B:28:0x0047, B:29:0x0050, B:31:0x0056, B:34:0x005d, B:36:0x0067, B:37:0x0073, B:39:0x007b, B:40:0x0083, B:42:0x0089, B:46:0x0099, B:51:0x006b), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void init(android.content.Context r4, java.lang.String r5, com.umeng.umzid.IZIDCompletionCallback r6) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = com.umeng.umzid.d.h(r4)     // Catch: java.lang.Throwable -> L17
            r3.c = r0     // Catch: java.lang.Throwable -> L17
            if (r0 != 0) goto Lb
            monitor-exit(r3)
            return
        Lb:
            if (r4 != 0) goto L1c
            if (r6 == 0) goto L1a
            java.lang.String r4 = "1001"
            java.lang.String r5 = "传入参数Context为null"
            r6.onFailure(r4, r5)     // Catch: java.lang.Throwable -> L17
            goto L1a
        L17:
            r4 = move-exception
            goto La8
        L1a:
            monitor-exit(r3)
            return
        L1c:
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L17
            if (r0 == 0) goto L2d
            if (r6 == 0) goto L2b
            java.lang.String r4 = "1003"
            java.lang.String r5 = "传入参数appkey为空"
            r6.onFailure(r4, r5)     // Catch: java.lang.Throwable -> L17
        L2b:
            monitor-exit(r3)
            return
        L2d:
            android.content.Context r0 = r4.getApplicationContext()     // Catch: java.lang.Throwable -> L17
            if (r0 == 0) goto L50
            if (r5 == 0) goto L50
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L17
            if (r1 != 0) goto L50
            android.content.SharedPreferences r1 = com.umeng.umzid.a.a(r0)     // Catch: java.lang.Throwable -> L17
            if (r1 == 0) goto L50
            android.content.SharedPreferences$Editor r1 = r1.edit()     // Catch: java.lang.Throwable -> L17
            if (r1 == 0) goto L50
            java.lang.String r2 = "appkey"
            android.content.SharedPreferences$Editor r5 = r1.putString(r2, r5)     // Catch: java.lang.Throwable -> L17
            r5.commit()     // Catch: java.lang.Throwable -> L17
        L50:
            java.lang.String r5 = com.umeng.umzid.d.d(r0)     // Catch: java.lang.Throwable -> L17
            if (r5 == 0) goto L6b
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L17
            if (r1 == 0) goto L5d
            goto L6b
        L5d:
            com.umeng.umzid.ZIDManager$b r1 = new com.umeng.umzid.ZIDManager$b     // Catch: java.lang.Throwable -> L17
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L17
            com.umeng.umzid.c.a(r1)     // Catch: java.lang.Throwable -> L17
            if (r6 == 0) goto L73
            r6.onSuccess(r5)     // Catch: java.lang.Throwable -> L17
            goto L73
        L6b:
            com.umeng.umzid.ZIDManager$a r5 = new com.umeng.umzid.ZIDManager$a     // Catch: java.lang.Throwable -> L17
            r5.<init>(r0, r6)     // Catch: java.lang.Throwable -> L17
            com.umeng.umzid.c.a(r5)     // Catch: java.lang.Throwable -> L17
        L73:
            java.lang.String r5 = ""
            android.content.SharedPreferences r6 = com.umeng.umzid.a.a(r4)     // Catch: java.lang.Throwable -> L17
            if (r6 == 0) goto L83
            java.lang.String r5 = "uuid"
            java.lang.String r0 = ""
            java.lang.String r5 = r6.getString(r5, r0)     // Catch: java.lang.Throwable -> L17
        L83:
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L17
            if (r5 == 0) goto La6
            java.lang.String r5 = ""
            android.content.SharedPreferences r4 = com.umeng.umzid.a.a(r4)     // Catch: java.lang.Throwable -> L17
            java.util.UUID r6 = java.util.UUID.randomUUID()     // Catch: java.lang.Throwable -> L17
            java.lang.String r5 = r6.toString()     // Catch: java.lang.Throwable -> L97
        L97:
            if (r4 == 0) goto La6
            android.content.SharedPreferences$Editor r4 = r4.edit()     // Catch: java.lang.Throwable -> L17
            java.lang.String r6 = "uuid"
            android.content.SharedPreferences$Editor r4 = r4.putString(r6, r5)     // Catch: java.lang.Throwable -> L17
            r4.commit()     // Catch: java.lang.Throwable -> L17
        La6:
            monitor-exit(r3)
            return
        La8:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L17
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.umzid.ZIDManager.init(android.content.Context, java.lang.String, com.umeng.umzid.IZIDCompletionCallback):void");
    }
}
