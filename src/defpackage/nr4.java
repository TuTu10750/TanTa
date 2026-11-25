package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Log;
import com.umeng.analytics.pro.cl;

/* loaded from: /tmp/classes2.dex */
public class nr4 {
    public static volatile nr4 g = null;
    public static boolean h = false;
    public BroadcastReceiver f;
    public cu2 a = new cu2("udid");
    public cu2 b = new cu2("oaid");
    public cu2 d = new cu2("vaid");
    public cu2 c = new cu2("aaid");
    public tx3 e = new tx3();

    public static pf4 a(Cursor cursor) {
        pf4 pf4Var = new pf4(null, 0);
        if (cursor == null) {
            e("parseValue fail, cursor is null.");
            return pf4Var;
        }
        if (cursor.isClosed()) {
            e("parseValue fail, cursor is closed.");
            return pf4Var;
        }
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex("value");
        if (columnIndex >= 0) {
            pf4Var.a = cursor.getString(columnIndex);
        } else {
            e("parseValue fail, index < 0.");
        }
        int columnIndex2 = cursor.getColumnIndex(cl.g);
        if (columnIndex2 >= 0) {
            pf4Var.b = cursor.getInt(columnIndex2);
        } else {
            e("parseCode fail, index < 0.");
        }
        int columnIndex3 = cursor.getColumnIndex("expired");
        if (columnIndex3 >= 0) {
            pf4Var.c = cursor.getLong(columnIndex3);
            return pf4Var;
        }
        e("parseExpired fail, index < 0.");
        return pf4Var;
    }

    public static final nr4 b() {
        if (g == null) {
            synchronized (nr4.class) {
                try {
                    if (g == null) {
                        g = new nr4();
                    }
                } finally {
                }
            }
        }
        return g;
    }

    public static String d(PackageManager packageManager, String str) {
        ProviderInfo resolveContentProvider;
        if (packageManager == null || (resolveContentProvider = packageManager.resolveContentProvider(str, 0)) == null || (resolveContentProvider.applicationInfo.flags & 1) == 0) {
            return null;
        }
        return resolveContentProvider.packageName;
    }

    public static void e(String str) {
        if (h) {
            Log.d("OpenIdManager", str);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0040, code lost:
    
        if (r8 != null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0042, code lost:
    
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x005e, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005b, code lost:
    
        if (r8 == null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0032, code lost:
    
        if ("0".equals(r9.a) != false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean f(android.content.Context r9) {
        /*
            java.lang.String r0 = "querySupport version : 1.0.8"
            e(r0)
            java.lang.String r0 = "content://com.meizu.flyme.openidsdk/"
            android.net.Uri r2 = android.net.Uri.parse(r0)
            r7 = 0
            r8 = 0
            android.content.ContentResolver r1 = r9.getContentResolver()     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L38
            java.lang.String r9 = "supported"
            java.lang.String[] r5 = new java.lang.String[]{r9}     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L38
            r6 = 0
            r3 = 0
            r4 = 0
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L38
            if (r8 == 0) goto L40
            pf4 r9 = a(r8)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L38
            int r0 = r9.b     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L38
            r1 = 1000(0x3e8, float:1.401E-42)
            if (r1 != r0) goto L3b
            java.lang.String r0 = "0"
            java.lang.String r9 = r9.a     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L38
            boolean r9 = r0.equals(r9)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L38
            if (r9 == 0) goto L3c
            goto L3b
        L35:
            r0 = move-exception
            r9 = r0
            goto L5f
        L38:
            r0 = move-exception
            r9 = r0
            goto L46
        L3b:
            r7 = 1
        L3c:
            r8.close()
            return r7
        L40:
            if (r8 == 0) goto L5e
        L42:
            r8.close()
            goto L5e
        L46:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L35
            java.lang.String r1 = "querySupport, Exception : "
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L35
            java.lang.String r9 = r9.getMessage()     // Catch: java.lang.Throwable -> L35
            r0.append(r9)     // Catch: java.lang.Throwable -> L35
            java.lang.String r9 = r0.toString()     // Catch: java.lang.Throwable -> L35
            e(r9)     // Catch: java.lang.Throwable -> L35
            if (r8 == 0) goto L5e
            goto L42
        L5e:
            return r7
        L5f:
            if (r8 == 0) goto L64
            r8.close()
        L64:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.nr4.f(android.content.Context):boolean");
    }

    public static String i(PackageManager packageManager, String str) {
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionName;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            e("getAppVersion, Exception : " + e.getMessage());
            return null;
        }
    }

    public final String c(Context context, cu2 cu2Var) {
        String str;
        if (cu2Var == null) {
            str = "getId, openId = null.";
        } else {
            if (cu2Var.d()) {
                return cu2Var.b;
            }
            if (g(context, true)) {
                return h(context, cu2Var);
            }
            str = "getId, isSupported = false.";
        }
        e(str);
        return null;
    }

    public final boolean g(Context context, boolean z) {
        if (!this.e.b() || z) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            String d = d(packageManager, "com.meizu.flyme.openidsdk");
            if (TextUtils.isEmpty(d)) {
                return false;
            }
            String i = i(packageManager, d);
            if (!this.e.b() || !this.e.c(i)) {
                this.e.d(i);
                boolean f = f(context);
                e("query support, result : ".concat(String.valueOf(f)));
                this.e.a(f);
                return f;
            }
            e("use same version cache, safeVersion : ".concat(String.valueOf(i)));
        }
        return this.e.e();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String h(android.content.Context r9, defpackage.cu2 r10) {
        /*
            r8 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "queryId : "
            r0.<init>(r1)
            java.lang.String r1 = r10.c
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            e(r0)
            java.lang.String r0 = "content://com.meizu.flyme.openidsdk/"
            android.net.Uri r2 = android.net.Uri.parse(r0)
            r7 = 0
            android.content.ContentResolver r1 = r9.getContentResolver()     // Catch: java.lang.Throwable -> L9e java.lang.Exception -> La1
            java.lang.String r0 = r10.c     // Catch: java.lang.Throwable -> L9e java.lang.Exception -> La1
            java.lang.String[] r5 = new java.lang.String[]{r0}     // Catch: java.lang.Throwable -> L9e java.lang.Exception -> La1
            r6 = 0
            r3 = 0
            r4 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L9e java.lang.Exception -> La1
            r0 = 1
            r2 = 0
            if (r1 == 0) goto L87
            pf4 r3 = a(r1)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L82
            java.lang.String r7 = r3.a     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L82
            r10.c(r7)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L82
            long r4 = r3.c     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L82
            r10.b(r4)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L82
            int r4 = r3.b     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L82
            r10.a(r4)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L82
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L82
            r4.<init>()     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L82
            java.lang.String r5 = r10.c     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L82
            r4.append(r5)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L82
            java.lang.String r5 = " errorCode : "
            r4.append(r5)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L82
            int r10 = r10.d     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L82
            r4.append(r10)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L82
            java.lang.String r10 = r4.toString()     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L82
            e(r10)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L82
            int r10 = r3.b     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L82
            r3 = 1000(0x3e8, float:1.401E-42)
            if (r10 == r3) goto L98
            r8.j(r9)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L82
            boolean r10 = r8.g(r9, r2)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L82
            if (r10 != 0) goto L98
            boolean r8 = r8.g(r9, r0)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L82
            java.lang.String r9 = "not support, forceQuery isSupported: "
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L82
        L76:
            java.lang.String r8 = r9.concat(r8)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L82
            e(r8)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L82
            goto L98
        L7e:
            r0 = move-exception
            r8 = r0
            r7 = r1
            goto Lbf
        L82:
            r0 = move-exception
            r8 = r0
            r9 = r7
            r7 = r1
            goto La4
        L87:
            boolean r10 = r8.g(r9, r2)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L82
            if (r10 == 0) goto L98
            boolean r8 = r8.g(r9, r0)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L82
            java.lang.String r9 = "forceQuery isSupported : "
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L82
            goto L76
        L98:
            if (r1 == 0) goto L9d
            r1.close()
        L9d:
            return r7
        L9e:
            r0 = move-exception
            r8 = r0
            goto Lbf
        La1:
            r0 = move-exception
            r8 = r0
            r9 = r7
        La4:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9e
            java.lang.String r0 = "queryId, Exception : "
            r10.<init>(r0)     // Catch: java.lang.Throwable -> L9e
            java.lang.String r8 = r8.getMessage()     // Catch: java.lang.Throwable -> L9e
            r10.append(r8)     // Catch: java.lang.Throwable -> L9e
            java.lang.String r8 = r10.toString()     // Catch: java.lang.Throwable -> L9e
            e(r8)     // Catch: java.lang.Throwable -> L9e
            if (r7 == 0) goto Lbe
            r7.close()
        Lbe:
            return r9
        Lbf:
            if (r7 == 0) goto Lc4
            r7.close()
        Lc4:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.nr4.h(android.content.Context, cu2):java.lang.String");
    }

    public final synchronized void j(Context context) {
        if (this.f != null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.meizu.flyme.openid.ACTION_OPEN_ID_CHANGE");
        mr4 mr4Var = new mr4();
        this.f = mr4Var;
        context.registerReceiver(mr4Var, intentFilter, "com.meizu.flyme.openid.permission.OPEN_ID_CHANGE", null);
    }
}
