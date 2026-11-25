package com.umeng.analytics.pro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.analytics.pro.h;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /tmp/classes2.dex */
public class l {
    public static final int a = 2049;
    public static final int b = 2050;
    private static final int c = 1000;
    private static Context d = null;
    private static String e = null;
    private static final String f = "umeng+";
    private static final String g = "ek__id";
    private static final String h = "ek_key";
    private List<String> i;
    private List<Integer> j;
    private String k;
    private List<String> l;

    /* loaded from: /tmp/classes2.dex */
    public enum a {
        AUTOPAGE,
        PAGE,
        BEGIN,
        END,
        NEWSESSION,
        INSTANTSESSIONBEGIN
    }

    /* loaded from: /tmp/classes2.dex */
    public static class b {
        private static final l a = new l();

        private b() {
        }
    }

    private l() {
        this.i = new ArrayList();
        this.j = new ArrayList();
        this.k = null;
        this.l = new ArrayList();
    }

    private Cursor a(String str, SQLiteDatabase sQLiteDatabase, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        if (sQLiteDatabase == null) {
            return null;
        }
        try {
            if (sQLiteDatabase.isOpen()) {
                return sQLiteDatabase.query(str, strArr, str2, strArr2, str3, str4, str5, str6);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static l a(Context context) {
        l lVar = b.a;
        if (d == null && context != null) {
            d = context.getApplicationContext();
            lVar.k();
        }
        return lVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0234, code lost:
    
        if (r2 == null) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x021a, code lost:
    
        r2.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0218, code lost:
    
        if (r2 == null) goto L87;
     */
    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0215  */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r10v10, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v22 */
    /* JADX WARN: Type inference failed for: r10v23 */
    /* JADX WARN: Type inference failed for: r10v24 */
    /* JADX WARN: Type inference failed for: r10v25 */
    /* JADX WARN: Type inference failed for: r10v26 */
    /* JADX WARN: Type inference failed for: r10v27 */
    /* JADX WARN: Type inference failed for: r10v28 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r22v0, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object, org.json.JSONArray] */
    /* JADX WARN: Type inference failed for: r4v2, types: [org.json.JSONObject, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String a(org.json.JSONObject r22, boolean r23) {
        /*
            Method dump skipped, instructions count: 588
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.l.a(org.json.JSONObject, boolean):java.lang.String");
    }

    private void a(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase) {
        try {
            long longValue = ((Long) jSONObject.opt(h.d.a.g)).longValue();
            Object opt = jSONObject.opt(h.d.a.h);
            long longValue2 = (opt == null || !(opt instanceof Long)) ? 0L : ((Long) opt).longValue();
            JSONObject optJSONObject = jSONObject.optJSONObject("__sp");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("__pp");
            String str2 = "";
            String c2 = (optJSONObject == null || optJSONObject.length() <= 0) ? "" : c(optJSONObject.toString());
            if (optJSONObject2 != null && optJSONObject2.length() > 0) {
                str2 = c(optJSONObject2.toString());
            }
            sQLiteDatabase.execSQL("update __sd set __f=\"" + longValue + "\", __g=\"" + longValue2 + "\", __sp=\"" + c2 + "\", __pp=\"" + str2 + "\" where __ii=\"" + str + "\"");
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0070 A[Catch: all -> 0x0062, TryCatch #1 {all -> 0x0062, blocks: (B:52:0x004f, B:54:0x0055, B:15:0x0065, B:17:0x0070, B:18:0x0075, B:26:0x0084, B:29:0x008a, B:31:0x0090, B:38:0x0096, B:40:0x00a4, B:33:0x0093), top: B:51:0x004f }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x004f A[EXC_TOP_SPLITTER, LOOP:1: B:51:0x004f->B:54:0x0055, LOOP_START, PHI: r12
      0x004f: PHI (r12v2 java.lang.String) = (r12v7 java.lang.String), (r12v3 java.lang.String) binds: [B:14:0x004d, B:54:0x0055] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(java.lang.String r15, org.json.JSONObject r16, android.database.sqlite.SQLiteDatabase r17, java.lang.String r18) {
        /*
            r14 = this;
            r0 = r16
            r10 = r18
            java.lang.String r11 = "=\""
            java.lang.String r1 = "__b"
            java.lang.String r2 = "__a"
            r12 = 0
            boolean r3 = r2.equals(r10)     // Catch: java.lang.Throwable -> Ldb
            if (r3 == 0) goto L21
            org.json.JSONArray r0 = r0.optJSONArray(r2)     // Catch: java.lang.Throwable -> Ldb
            if (r0 == 0) goto Le0
            int r1 = r0.length()     // Catch: java.lang.Throwable -> Ldb
            if (r1 > 0) goto L1f
            goto Le0
        L1f:
            r13 = r0
            goto L36
        L21:
            boolean r2 = r1.equals(r10)     // Catch: java.lang.Throwable -> Ldb
            if (r2 == 0) goto L35
            org.json.JSONArray r0 = r0.optJSONArray(r1)     // Catch: java.lang.Throwable -> Ldb
            if (r0 == 0) goto Le0
            int r1 = r0.length()     // Catch: java.lang.Throwable -> Ldb
            if (r1 > 0) goto L1f
            goto Le0
        L35:
            r13 = r12
        L36:
            java.lang.String[] r3 = new java.lang.String[]{r10}     // Catch: java.lang.Throwable -> Ldb
            java.lang.String r1 = "__sd"
            java.lang.String r4 = "__ii=? "
            java.lang.String[] r5 = new java.lang.String[]{r15}     // Catch: java.lang.Throwable -> Ldb
            r8 = 0
            r9 = 0
            r6 = 0
            r7 = 0
            r0 = r14
            r2 = r17
            android.database.Cursor r1 = r0.a(r1, r2, r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> Ldb
            if (r1 == 0) goto L65
        L4f:
            boolean r2 = r1.moveToNext()     // Catch: java.lang.Throwable -> L62
            if (r2 == 0) goto L65
            int r2 = r1.getColumnIndex(r10)     // Catch: java.lang.Throwable -> L62
            java.lang.String r2 = r1.getString(r2)     // Catch: java.lang.Throwable -> L62
            java.lang.String r12 = r14.d(r2)     // Catch: java.lang.Throwable -> L62
            goto L4f
        L62:
            r12 = r1
            goto Ldb
        L65:
            org.json.JSONArray r2 = new org.json.JSONArray     // Catch: java.lang.Throwable -> L62
            r2.<init>()     // Catch: java.lang.Throwable -> L62
            boolean r3 = android.text.TextUtils.isEmpty(r12)     // Catch: java.lang.Throwable -> L62
            if (r3 != 0) goto L75
            org.json.JSONArray r2 = new org.json.JSONArray     // Catch: java.lang.Throwable -> L62
            r2.<init>(r12)     // Catch: java.lang.Throwable -> L62
        L75:
            int r3 = r2.length()     // Catch: java.lang.Throwable -> L62
            r4 = 1000(0x3e8, float:1.401E-42)
            if (r3 <= r4) goto L83
            if (r1 == 0) goto Le0
            r1.close()
            return
        L83:
            r3 = 0
        L84:
            int r4 = r13.length()     // Catch: java.lang.Throwable -> L62
            if (r3 >= r4) goto L96
            org.json.JSONObject r4 = r13.getJSONObject(r3)     // Catch: java.lang.Throwable -> L62 org.json.JSONException -> L93
            if (r4 == 0) goto L93
            r2.put(r4)     // Catch: java.lang.Throwable -> L62
        L93:
            int r3 = r3 + 1
            goto L84
        L96:
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L62
            java.lang.String r0 = r14.c(r2)     // Catch: java.lang.Throwable -> L62
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L62
            if (r2 != 0) goto Ld5
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L62
            r2.<init>()     // Catch: java.lang.Throwable -> L62
            java.lang.String r3 = "update __sd set "
            r2.append(r3)     // Catch: java.lang.Throwable -> L62
            r2.append(r10)     // Catch: java.lang.Throwable -> L62
            r2.append(r11)     // Catch: java.lang.Throwable -> L62
            r2.append(r0)     // Catch: java.lang.Throwable -> L62
            java.lang.String r0 = "\" where "
            r2.append(r0)     // Catch: java.lang.Throwable -> L62
            java.lang.String r0 = "__ii"
            r2.append(r0)     // Catch: java.lang.Throwable -> L62
            r2.append(r11)     // Catch: java.lang.Throwable -> L62
            r2.append(r15)     // Catch: java.lang.Throwable -> L62
            java.lang.String r0 = "\""
            r2.append(r0)     // Catch: java.lang.Throwable -> L62
            java.lang.String r0 = r2.toString()     // Catch: java.lang.Throwable -> L62
            r2 = r17
            r2.execSQL(r0)     // Catch: java.lang.Throwable -> L62
        Ld5:
            if (r1 == 0) goto Le0
            r1.close()
            goto Le0
        Ldb:
            if (r12 == 0) goto Le0
            r12.close()
        Le0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.l.a(java.lang.String, org.json.JSONObject, android.database.sqlite.SQLiteDatabase, java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:104:0x01a5, code lost:
    
        if (r4 != null) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0195, code lost:
    
        if (r4 != null) goto L94;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x01ae: IF  (r4 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:115:0x01b3, block:B:114:0x01ae */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(org.json.JSONObject r13, java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 445
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.l.a(org.json.JSONObject, java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x00e2, code lost:
    
        if (r4 != null) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00d2, code lost:
    
        if (r4 != null) goto L58;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x00eb: IF  (r4 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:62:0x00f0, block:B:61:0x00eb */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String b(org.json.JSONObject r13, boolean r14) {
        /*
            Method dump skipped, instructions count: 250
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.l.b(org.json.JSONObject, boolean):java.lang.String");
    }

    private JSONArray b(JSONArray jSONArray) {
        JSONArray jSONArray2 = new JSONArray();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null && optJSONObject.optLong("duration") > 0) {
                jSONArray2.put(optJSONObject);
            }
        }
        return jSONArray2;
    }

    private void b(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase) {
        try {
            long longValue = ((Long) jSONObject.get("__e")).longValue();
            JSONObject optJSONObject = jSONObject.optJSONObject("__sp");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("__pp");
            String str2 = "";
            String c2 = (optJSONObject == null || optJSONObject.length() <= 0) ? "" : c(optJSONObject.toString());
            if (optJSONObject2 != null && optJSONObject2.length() > 0) {
                str2 = c(optJSONObject2.toString());
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("__ii", str);
            contentValues.put("__e", String.valueOf(longValue));
            contentValues.put("__sp", c2);
            contentValues.put("__pp", str2);
            contentValues.put("__av", UMGlobalContext.getInstance(d).getAppVersion());
            contentValues.put("__vc", UMUtils.getAppVersionCode(d));
            sQLiteDatabase.insert(h.c.a, null, contentValues);
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00a7, code lost:
    
        if (r4 != null) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0097, code lost:
    
        if (r4 != null) goto L52;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x00b0: IF  (r4 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:52:0x00b5, block:B:51:0x00b0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void b(org.json.JSONObject r13, java.lang.String r14) {
        /*
            r12 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.l.d     // Catch: java.lang.Throwable -> L87 android.database.sqlite.SQLiteDatabaseCorruptException -> L8a
            com.umeng.analytics.pro.j r1 = com.umeng.analytics.pro.j.a(r1)     // Catch: java.lang.Throwable -> L87 android.database.sqlite.SQLiteDatabaseCorruptException -> L8a
            android.database.sqlite.SQLiteDatabase r4 = r1.a()     // Catch: java.lang.Throwable -> L87 android.database.sqlite.SQLiteDatabaseCorruptException -> L8a
            r4.beginTransaction()     // Catch: java.lang.Throwable -> L28 android.database.sqlite.SQLiteDatabaseCorruptException -> L2b
            boolean r1 = android.text.TextUtils.isEmpty(r14)     // Catch: java.lang.Throwable -> L28 android.database.sqlite.SQLiteDatabaseCorruptException -> L2b
            if (r1 != 0) goto L2e
            java.lang.String r3 = "__er"
            java.lang.String r6 = "__i=? "
            java.lang.String[] r7 = new java.lang.String[]{r14}     // Catch: java.lang.Throwable -> L28 android.database.sqlite.SQLiteDatabaseCorruptException -> L2b
            r10 = 0
            r11 = 0
            r5 = 0
            r8 = 0
            r9 = 0
            r2 = r12
            android.database.Cursor r12 = r2.a(r3, r4, r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L28 android.database.sqlite.SQLiteDatabaseCorruptException -> L2b
        L26:
            r0 = r12
            goto L3d
        L28:
            r12 = r0
            goto L8d
        L2b:
            r12 = r0
            goto L9d
        L2e:
            r2 = r12
            java.lang.String r3 = "__er"
            r10 = 0
            r11 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r12 = r2.a(r3, r4, r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L28 android.database.sqlite.SQLiteDatabaseCorruptException -> L2b
            goto L26
        L3d:
            if (r0 == 0) goto L72
            org.json.JSONArray r12 = new org.json.JSONArray     // Catch: java.lang.Throwable -> L28 android.database.sqlite.SQLiteDatabaseCorruptException -> L2b
            r12.<init>()     // Catch: java.lang.Throwable -> L28 android.database.sqlite.SQLiteDatabaseCorruptException -> L2b
        L44:
            boolean r14 = r0.moveToNext()     // Catch: java.lang.Throwable -> L28 android.database.sqlite.SQLiteDatabaseCorruptException -> L2b
            if (r14 == 0) goto L67
            java.lang.String r14 = "__a"
            int r14 = r0.getColumnIndex(r14)     // Catch: java.lang.Throwable -> L28 android.database.sqlite.SQLiteDatabaseCorruptException -> L2b
            java.lang.String r14 = r0.getString(r14)     // Catch: java.lang.Throwable -> L28 android.database.sqlite.SQLiteDatabaseCorruptException -> L2b
            boolean r1 = android.text.TextUtils.isEmpty(r14)     // Catch: java.lang.Throwable -> L28 android.database.sqlite.SQLiteDatabaseCorruptException -> L2b
            if (r1 != 0) goto L44
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L28 android.database.sqlite.SQLiteDatabaseCorruptException -> L2b
            java.lang.String r14 = r2.d(r14)     // Catch: java.lang.Throwable -> L28 android.database.sqlite.SQLiteDatabaseCorruptException -> L2b
            r1.<init>(r14)     // Catch: java.lang.Throwable -> L28 android.database.sqlite.SQLiteDatabaseCorruptException -> L2b
            r12.put(r1)     // Catch: java.lang.Throwable -> L28 android.database.sqlite.SQLiteDatabaseCorruptException -> L2b
            goto L44
        L67:
            int r14 = r12.length()     // Catch: java.lang.Throwable -> L28 android.database.sqlite.SQLiteDatabaseCorruptException -> L2b
            if (r14 <= 0) goto L72
            java.lang.String r14 = "error"
            r13.put(r14, r12)     // Catch: java.lang.Throwable -> L28 android.database.sqlite.SQLiteDatabaseCorruptException -> L2b
        L72:
            r4.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L28 android.database.sqlite.SQLiteDatabaseCorruptException -> L2b
            if (r0 == 0) goto L7a
            r0.close()
        L7a:
            r4.endTransaction()     // Catch: java.lang.Throwable -> L7d
        L7d:
            android.content.Context r12 = com.umeng.analytics.pro.l.d
            com.umeng.analytics.pro.j r12 = com.umeng.analytics.pro.j.a(r12)
            r12.b()
            goto Laa
        L87:
            r12 = r0
            r4 = r12
            goto L8d
        L8a:
            r12 = r0
            r4 = r12
            goto L9d
        L8d:
            android.content.Context r13 = com.umeng.analytics.pro.l.d     // Catch: java.lang.Throwable -> L9a
            com.umeng.analytics.pro.k.a(r13)     // Catch: java.lang.Throwable -> L9a
            if (r12 == 0) goto L97
            r12.close()
        L97:
            if (r4 == 0) goto L7d
            goto L7a
        L9a:
            r0 = move-exception
            r13 = r0
            goto Lab
        L9d:
            android.content.Context r13 = com.umeng.analytics.pro.l.d     // Catch: java.lang.Throwable -> L9a
            com.umeng.analytics.pro.k.a(r13)     // Catch: java.lang.Throwable -> L9a
            if (r12 == 0) goto La7
            r12.close()
        La7:
            if (r4 == 0) goto L7d
            goto L7a
        Laa:
            return
        Lab:
            if (r12 == 0) goto Lb0
            r12.close()
        Lb0:
            if (r4 == 0) goto Lb5
            r4.endTransaction()     // Catch: java.lang.Throwable -> Lb5
        Lb5:
            android.content.Context r12 = com.umeng.analytics.pro.l.d
            com.umeng.analytics.pro.j r12 = com.umeng.analytics.pro.j.a(r12)
            r12.b()
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.l.b(org.json.JSONObject, java.lang.String):void");
    }

    private void c(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase) {
        SQLiteDatabase sQLiteDatabase2;
        Cursor cursor;
        Cursor cursor2 = null;
        r13 = null;
        r13 = null;
        String str2 = null;
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject(h.d.a.e);
            if (optJSONObject != null) {
                sQLiteDatabase2 = sQLiteDatabase;
                cursor = a(h.d.a, sQLiteDatabase2, new String[]{h.d.a.e}, "__ii=? ", new String[]{str}, null, null, null, null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        try {
                            str2 = d(cursor.getString(cursor.getColumnIndex(h.d.a.e)));
                        } catch (Throwable unused) {
                            cursor2 = cursor;
                            if (cursor2 != null) {
                                cursor2.close();
                                return;
                            }
                            return;
                        }
                    }
                }
            } else {
                sQLiteDatabase2 = sQLiteDatabase;
                cursor = null;
            }
            if (optJSONObject != null) {
                JSONArray jSONArray = new JSONArray();
                if (!TextUtils.isEmpty(str2)) {
                    jSONArray = new JSONArray(str2);
                }
                jSONArray.put(optJSONObject);
                String c2 = c(jSONArray.toString());
                if (!TextUtils.isEmpty(c2)) {
                    sQLiteDatabase2.execSQL("update  __sd set __d=\"" + c2 + "\" where __ii=\"" + str + "\"");
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject(h.d.a.d);
            if (optJSONObject2 != null) {
                String c3 = c(optJSONObject2.toString());
                if (!TextUtils.isEmpty(c3)) {
                    sQLiteDatabase2.execSQL("update  __sd set __c=\"" + c3 + "\" where __ii=\"" + str + "\"");
                }
            }
            sQLiteDatabase2.execSQL("update  __sd set __f=\"" + String.valueOf(jSONObject.optLong(h.d.a.g)) + "\" where __ii=\"" + str + "\"");
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable unused2) {
        }
    }

    private void k() {
        synchronized (this) {
            l();
            this.i.clear();
            this.l.clear();
            this.j.clear();
        }
    }

    private void l() {
        try {
            if (TextUtils.isEmpty(e)) {
                String multiProcessSP = UMUtils.getMultiProcessSP(d, g);
                if (TextUtils.isEmpty(multiProcessSP)) {
                    multiProcessSP = PreferenceWrapper.getDefault(d).getString(g, null);
                    if (TextUtils.isEmpty(multiProcessSP)) {
                        multiProcessSP = UMUtils.genId();
                    }
                    if (!TextUtils.isEmpty(multiProcessSP)) {
                        UMUtils.setMultiProcessSP(d, g, multiProcessSP);
                    }
                }
                if (!TextUtils.isEmpty(multiProcessSP)) {
                    String substring = multiProcessSP.substring(1, 9);
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < substring.length(); i++) {
                        char charAt = substring.charAt(i);
                        if (!Character.isDigit(charAt)) {
                            sb.append(charAt);
                        } else if (Integer.parseInt(Character.toString(charAt)) == 0) {
                            sb.append(0);
                        } else {
                            sb.append(10 - Integer.parseInt(Character.toString(charAt)));
                        }
                    }
                    e = sb.toString();
                }
                if (TextUtils.isEmpty(e)) {
                    return;
                }
                e += new StringBuilder(e).reverse().toString();
                String multiProcessSP2 = UMUtils.getMultiProcessSP(d, h);
                if (TextUtils.isEmpty(multiProcessSP2)) {
                    UMUtils.setMultiProcessSP(d, h, c(f));
                } else {
                    if (f.equals(d(multiProcessSP2))) {
                        return;
                    }
                    b(true, false);
                    a(true, false);
                    h();
                    i();
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0069, code lost:
    
        if (r7 != null) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long a(java.lang.String r16) {
        /*
            r15 = this;
            java.lang.String r0 = "__f"
            r1 = 0
            r2 = 0
            android.content.Context r4 = com.umeng.analytics.pro.l.d     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4e
            com.umeng.analytics.pro.j r4 = com.umeng.analytics.pro.j.a(r4)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4e
            android.database.sqlite.SQLiteDatabase r7 = r4.a()     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4e
            r7.beginTransaction()     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L64
            java.lang.String[] r8 = new java.lang.String[]{r0}     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L64
            java.lang.String r6 = "__sd"
            java.lang.String r9 = "__ii=? "
            java.lang.String[] r10 = new java.lang.String[]{r16}     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L64
            r13 = 0
            r14 = 0
            r11 = 0
            r12 = 0
            r5 = r15
            android.database.Cursor r1 = r5.a(r6, r7, r8, r9, r10, r11, r12, r13, r14)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L64
            if (r1 == 0) goto L38
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L64
            int r15 = r1.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L64
            long r2 = r1.getLong(r15)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L64
            goto L38
        L35:
            r0 = move-exception
            r15 = r0
            goto L50
        L38:
            if (r1 == 0) goto L3d
            r1.close()     // Catch: java.lang.Exception -> L40
        L3d:
            r7.endTransaction()     // Catch: java.lang.Exception -> L40
        L40:
            android.content.Context r15 = com.umeng.analytics.pro.l.d
            com.umeng.analytics.pro.j r15 = com.umeng.analytics.pro.j.a(r15)
            r15.b()
            goto L6c
        L4a:
            r0 = move-exception
            r15 = r0
            r7 = r1
            goto L50
        L4e:
            r7 = r1
            goto L64
        L50:
            if (r1 == 0) goto L55
            r1.close()     // Catch: java.lang.Exception -> L5a
        L55:
            if (r7 == 0) goto L5a
            r7.endTransaction()     // Catch: java.lang.Exception -> L5a
        L5a:
            android.content.Context r0 = com.umeng.analytics.pro.l.d
            com.umeng.analytics.pro.j r0 = com.umeng.analytics.pro.j.a(r0)
            r0.b()
            throw r15
        L64:
            if (r1 == 0) goto L69
            r1.close()     // Catch: java.lang.Exception -> L40
        L69:
            if (r7 == 0) goto L40
            goto L3d
        L6c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.l.a(java.lang.String):long");
    }

    public JSONObject a(boolean z) {
        a();
        this.j.clear();
        JSONObject jSONObject = new JSONObject();
        if (!z) {
            a(jSONObject, z);
            b(jSONObject, (String) null);
            a(jSONObject, (String) null);
            return jSONObject;
        }
        String a2 = a(jSONObject, z);
        if (!TextUtils.isEmpty(a2)) {
            b(jSONObject, a2);
            a(jSONObject, a2);
        }
        return jSONObject;
    }

    public void a() {
        this.i.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a2, code lost:
    
        if (r2 == null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00a4, code lost:
    
        r2.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00ad, code lost:
    
        if (r2 == null) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(org.json.JSONArray r11) {
        /*
            r10 = this;
            java.lang.String r0 = "__t"
            java.lang.String r1 = "__i"
            r2 = 0
            android.content.Context r3 = com.umeng.analytics.pro.l.d     // Catch: java.lang.Throwable -> La2 android.database.sqlite.SQLiteDatabaseCorruptException -> La8
            com.umeng.analytics.pro.j r3 = com.umeng.analytics.pro.j.a(r3)     // Catch: java.lang.Throwable -> La2 android.database.sqlite.SQLiteDatabaseCorruptException -> La8
            android.database.sqlite.SQLiteDatabase r3 = r3.a()     // Catch: java.lang.Throwable -> La2 android.database.sqlite.SQLiteDatabaseCorruptException -> La8
            r3.beginTransaction()     // Catch: java.lang.Throwable -> L35 android.database.sqlite.SQLiteDatabaseCorruptException -> La0
            r4 = 0
        L13:
            int r5 = r11.length()     // Catch: java.lang.Throwable -> L35 android.database.sqlite.SQLiteDatabaseCorruptException -> La0
            if (r4 >= r5) goto L90
            org.json.JSONObject r5 = r11.getJSONObject(r4)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8d
            android.content.ContentValues r6 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8d
            r6.<init>()     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8d
            java.lang.String r7 = r5.optString(r1)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8d
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8d
            java.lang.String r9 = "-1"
            if (r8 != 0) goto L37
            boolean r8 = r9.equals(r7)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8d
            if (r8 == 0) goto L46
            goto L37
        L35:
            r2 = r3
            goto La2
        L37:
            com.umeng.analytics.pro.x r7 = com.umeng.analytics.pro.x.a()     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8d
            java.lang.String r7 = r7.b()     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8d
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8d
            if (r8 == 0) goto L46
            r7 = r9
        L46:
            r6.put(r1, r7)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8d
            java.lang.String r7 = "__e"
            java.lang.String r8 = "id"
            java.lang.String r8 = r5.optString(r8)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8d
            r6.put(r7, r8)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8d
            int r7 = r5.optInt(r0)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8d
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8d
            r6.put(r0, r7)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8d
            java.lang.String r7 = "__av"
            android.content.Context r8 = com.umeng.analytics.pro.l.d     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8d
            java.lang.String r8 = com.umeng.commonsdk.utils.UMUtils.getAppVersionName(r8)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8d
            r6.put(r7, r8)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8d
            java.lang.String r7 = "__vc"
            android.content.Context r8 = com.umeng.analytics.pro.l.d     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8d
            java.lang.String r8 = com.umeng.commonsdk.utils.UMUtils.getAppVersionCode(r8)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8d
            r6.put(r7, r8)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8d
            r5.remove(r1)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8d
            r5.remove(r0)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8d
            java.lang.String r7 = "__s"
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8d
            java.lang.String r5 = r10.c(r5)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8d
            r6.put(r7, r5)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8d
            java.lang.String r5 = "__et"
            r3.insert(r5, r2, r6)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L8d
        L8d:
            int r4 = r4 + 1
            goto L13
        L90:
            r3.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L35 android.database.sqlite.SQLiteDatabaseCorruptException -> La0
            r3.endTransaction()     // Catch: java.lang.Throwable -> L96
        L96:
            android.content.Context r10 = com.umeng.analytics.pro.l.d
            com.umeng.analytics.pro.j r10 = com.umeng.analytics.pro.j.a(r10)
            r10.b()
            goto Lb0
        La0:
            r2 = r3
            goto La8
        La2:
            if (r2 == 0) goto L96
        La4:
            r2.endTransaction()     // Catch: java.lang.Throwable -> L96
            goto L96
        La8:
            android.content.Context r10 = com.umeng.analytics.pro.l.d     // Catch: java.lang.Throwable -> Lb1
            com.umeng.analytics.pro.k.a(r10)     // Catch: java.lang.Throwable -> Lb1
            if (r2 == 0) goto L96
            goto La4
        Lb0:
            return
        Lb1:
            r10 = move-exception
            if (r2 == 0) goto Lb7
            r2.endTransaction()     // Catch: java.lang.Throwable -> Lb7
        Lb7:
            android.content.Context r11 = com.umeng.analytics.pro.l.d
            com.umeng.analytics.pro.j r11 = com.umeng.analytics.pro.j.a(r11)
            r11.b()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.l.a(org.json.JSONArray):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0050, code lost:
    
        if (r0 == null) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(boolean r4, java.lang.String r5) {
        /*
            r3 = this;
            java.lang.String r4 = "__i=?"
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.l.d     // Catch: java.lang.Throwable -> L48 android.database.sqlite.SQLiteDatabaseCorruptException -> L4b
            com.umeng.analytics.pro.j r1 = com.umeng.analytics.pro.j.a(r1)     // Catch: java.lang.Throwable -> L48 android.database.sqlite.SQLiteDatabaseCorruptException -> L4b
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch: java.lang.Throwable -> L48 android.database.sqlite.SQLiteDatabaseCorruptException -> L4b
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L48 android.database.sqlite.SQLiteDatabaseCorruptException -> L4b
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L48 android.database.sqlite.SQLiteDatabaseCorruptException -> L4b
            if (r1 != 0) goto L38
            java.lang.String r1 = "__er"
            java.lang.String[] r2 = new java.lang.String[]{r5}     // Catch: java.lang.Throwable -> L48 android.database.sqlite.SQLiteDatabaseCorruptException -> L4b
            r0.delete(r1, r4, r2)     // Catch: java.lang.Throwable -> L48 android.database.sqlite.SQLiteDatabaseCorruptException -> L4b
            java.lang.String r1 = "__et"
            java.lang.String[] r2 = new java.lang.String[]{r5}     // Catch: java.lang.Throwable -> L48 android.database.sqlite.SQLiteDatabaseCorruptException -> L4b
            r0.delete(r1, r4, r2)     // Catch: java.lang.Throwable -> L48 android.database.sqlite.SQLiteDatabaseCorruptException -> L4b
            java.util.List<java.lang.Integer> r3 = r3.j     // Catch: java.lang.Throwable -> L48 android.database.sqlite.SQLiteDatabaseCorruptException -> L4b
            r3.clear()     // Catch: java.lang.Throwable -> L48 android.database.sqlite.SQLiteDatabaseCorruptException -> L4b
            java.lang.String r3 = "__sd"
            java.lang.String r4 = "__ii=?"
            java.lang.String[] r5 = new java.lang.String[]{r5}     // Catch: java.lang.Throwable -> L48 android.database.sqlite.SQLiteDatabaseCorruptException -> L4b
            r0.delete(r3, r4, r5)     // Catch: java.lang.Throwable -> L48 android.database.sqlite.SQLiteDatabaseCorruptException -> L4b
        L38:
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L48 android.database.sqlite.SQLiteDatabaseCorruptException -> L4b
        L3b:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L3e
        L3e:
            android.content.Context r3 = com.umeng.analytics.pro.l.d
            com.umeng.analytics.pro.j r3 = com.umeng.analytics.pro.j.a(r3)
            r3.b()
            goto L53
        L48:
            if (r0 == 0) goto L3e
            goto L3b
        L4b:
            android.content.Context r3 = com.umeng.analytics.pro.l.d     // Catch: java.lang.Throwable -> L54
            com.umeng.analytics.pro.k.a(r3)     // Catch: java.lang.Throwable -> L54
            if (r0 == 0) goto L3e
            goto L3b
        L53:
            return
        L54:
            r3 = move-exception
            if (r0 == 0) goto L5a
            r0.endTransaction()     // Catch: java.lang.Throwable -> L5a
        L5a:
            android.content.Context r4 = com.umeng.analytics.pro.l.d
            com.umeng.analytics.pro.j r4 = com.umeng.analytics.pro.j.a(r4)
            r4.b()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.l.a(boolean, java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0064, code lost:
    
        if (r0 == null) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(boolean r6, boolean r7) {
        /*
            r5 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.l.d     // Catch: java.lang.Throwable -> L55 android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            com.umeng.analytics.pro.j r1 = com.umeng.analytics.pro.j.a(r1)     // Catch: java.lang.Throwable -> L55 android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch: java.lang.Throwable -> L55 android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L55 android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            if (r7 == 0) goto L18
            if (r6 == 0) goto L45
            java.lang.String r5 = "delete from __is"
            r0.execSQL(r5)     // Catch: java.lang.Throwable -> L55 android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            goto L45
        L18:
            java.util.List<java.lang.String> r6 = r5.l     // Catch: java.lang.Throwable -> L55 android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            int r6 = r6.size()     // Catch: java.lang.Throwable -> L55 android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            r7 = 0
            if (r6 <= 0) goto L3e
            r1 = r7
        L22:
            if (r7 >= r6) goto L3d
            java.util.List<java.lang.String> r2 = r5.l     // Catch: java.lang.Throwable -> L55 android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            java.lang.Object r2 = r2.get(r7)     // Catch: java.lang.Throwable -> L55 android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> L55 android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            if (r2 != 0) goto L2f
            r1 = 1
        L2f:
            java.lang.String r3 = "__is"
            java.lang.String r4 = "__ii=?"
            java.lang.String[] r2 = new java.lang.String[]{r2}     // Catch: java.lang.Throwable -> L55 android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            r0.delete(r3, r4, r2)     // Catch: java.lang.Throwable -> L55 android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
            int r7 = r7 + 1
            goto L22
        L3d:
            r7 = r1
        L3e:
            if (r7 == 0) goto L45
            java.lang.String r5 = "delete from __is where __ii is null"
            r0.execSQL(r5)     // Catch: java.lang.Throwable -> L55 android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
        L45:
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L55 android.database.sqlite.SQLiteDatabaseCorruptException -> L5f
        L48:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L4b
        L4b:
            android.content.Context r5 = com.umeng.analytics.pro.l.d
            com.umeng.analytics.pro.j r5 = com.umeng.analytics.pro.j.a(r5)
            r5.b()
            goto L67
        L55:
            android.content.Context r5 = com.umeng.analytics.pro.l.d     // Catch: java.lang.Throwable -> L5d
            com.umeng.analytics.pro.k.a(r5)     // Catch: java.lang.Throwable -> L5d
            if (r0 == 0) goto L4b
            goto L48
        L5d:
            r5 = move-exception
            goto L68
        L5f:
            android.content.Context r5 = com.umeng.analytics.pro.l.d     // Catch: java.lang.Throwable -> L5d
            com.umeng.analytics.pro.k.a(r5)     // Catch: java.lang.Throwable -> L5d
            if (r0 == 0) goto L4b
            goto L48
        L67:
            return
        L68:
            if (r0 == 0) goto L6d
            r0.endTransaction()     // Catch: java.lang.Throwable -> L6d
        L6d:
            android.content.Context r6 = com.umeng.analytics.pro.l.d
            com.umeng.analytics.pro.j r6 = com.umeng.analytics.pro.j.a(r6)
            r6.b()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.l.a(boolean, boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x006b, code lost:
    
        if (r0 == null) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0062, code lost:
    
        r0.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0060, code lost:
    
        if (r0 == null) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(java.lang.String r5, java.lang.String r6, int r7) {
        /*
            r4 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.l.d     // Catch: java.lang.Throwable -> L60 android.database.sqlite.SQLiteDatabaseCorruptException -> L66
            com.umeng.analytics.pro.j r1 = com.umeng.analytics.pro.j.a(r1)     // Catch: java.lang.Throwable -> L60 android.database.sqlite.SQLiteDatabaseCorruptException -> L66
            android.database.sqlite.SQLiteDatabase r1 = r1.a()     // Catch: java.lang.Throwable -> L60 android.database.sqlite.SQLiteDatabaseCorruptException -> L66
            r1.beginTransaction()     // Catch: java.lang.Throwable -> L4c android.database.sqlite.SQLiteDatabaseCorruptException -> L4e
            android.content.ContentValues r2 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L4c android.database.sqlite.SQLiteDatabaseCorruptException -> L4e
            r2.<init>()     // Catch: java.lang.Throwable -> L4c android.database.sqlite.SQLiteDatabaseCorruptException -> L4e
            java.lang.String r3 = "__i"
            r2.put(r3, r5)     // Catch: java.lang.Throwable -> L4c android.database.sqlite.SQLiteDatabaseCorruptException -> L4e
            java.lang.String r4 = r4.c(r6)     // Catch: java.lang.Throwable -> L4c android.database.sqlite.SQLiteDatabaseCorruptException -> L4e
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L4c android.database.sqlite.SQLiteDatabaseCorruptException -> L4e
            if (r5 != 0) goto L50
            java.lang.String r5 = "__a"
            r2.put(r5, r4)     // Catch: java.lang.Throwable -> L4c android.database.sqlite.SQLiteDatabaseCorruptException -> L4e
            java.lang.String r4 = "__t"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.Throwable -> L4c android.database.sqlite.SQLiteDatabaseCorruptException -> L4e
            r2.put(r4, r5)     // Catch: java.lang.Throwable -> L4c android.database.sqlite.SQLiteDatabaseCorruptException -> L4e
            java.lang.String r4 = "__av"
            android.content.Context r5 = com.umeng.analytics.pro.l.d     // Catch: java.lang.Throwable -> L4c android.database.sqlite.SQLiteDatabaseCorruptException -> L4e
            java.lang.String r5 = com.umeng.commonsdk.utils.UMUtils.getAppVersionName(r5)     // Catch: java.lang.Throwable -> L4c android.database.sqlite.SQLiteDatabaseCorruptException -> L4e
            r2.put(r4, r5)     // Catch: java.lang.Throwable -> L4c android.database.sqlite.SQLiteDatabaseCorruptException -> L4e
            java.lang.String r4 = "__vc"
            android.content.Context r5 = com.umeng.analytics.pro.l.d     // Catch: java.lang.Throwable -> L4c android.database.sqlite.SQLiteDatabaseCorruptException -> L4e
            java.lang.String r5 = com.umeng.commonsdk.utils.UMUtils.getAppVersionCode(r5)     // Catch: java.lang.Throwable -> L4c android.database.sqlite.SQLiteDatabaseCorruptException -> L4e
            r2.put(r4, r5)     // Catch: java.lang.Throwable -> L4c android.database.sqlite.SQLiteDatabaseCorruptException -> L4e
            java.lang.String r4 = "__er"
            r1.insert(r4, r0, r2)     // Catch: java.lang.Throwable -> L4c android.database.sqlite.SQLiteDatabaseCorruptException -> L4e
            goto L50
        L4c:
            r0 = r1
            goto L60
        L4e:
            r0 = r1
            goto L66
        L50:
            r1.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L4c android.database.sqlite.SQLiteDatabaseCorruptException -> L4e
            r1.endTransaction()     // Catch: java.lang.Throwable -> L56
        L56:
            android.content.Context r4 = com.umeng.analytics.pro.l.d
            com.umeng.analytics.pro.j r4 = com.umeng.analytics.pro.j.a(r4)
            r4.b()
            goto L6e
        L60:
            if (r0 == 0) goto L56
        L62:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L56
            goto L56
        L66:
            android.content.Context r4 = com.umeng.analytics.pro.l.d     // Catch: java.lang.Throwable -> L70
            com.umeng.analytics.pro.k.a(r4)     // Catch: java.lang.Throwable -> L70
            if (r0 == 0) goto L56
            goto L62
        L6e:
            r4 = 0
            return r4
        L70:
            r4 = move-exception
            if (r0 == 0) goto L76
            r0.endTransaction()     // Catch: java.lang.Throwable -> L76
        L76:
            android.content.Context r5 = com.umeng.analytics.pro.l.d
            com.umeng.analytics.pro.j r5 = com.umeng.analytics.pro.j.a(r5)
            r5.b()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.l.a(java.lang.String, java.lang.String, int):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0099, code lost:
    
        if (r2 == null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0090, code lost:
    
        r2.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x008e, code lost:
    
        if (r2 == null) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(java.lang.String r6, org.json.JSONObject r7, com.umeng.analytics.pro.l.a r8) {
        /*
            r5 = this;
            java.lang.String r0 = "__e"
            r1 = 0
            if (r7 != 0) goto L6
            return r1
        L6:
            r2 = 0
            android.content.Context r3 = com.umeng.analytics.pro.l.d     // Catch: java.lang.Throwable -> L8e android.database.sqlite.SQLiteDatabaseCorruptException -> L94
            com.umeng.analytics.pro.j r3 = com.umeng.analytics.pro.j.a(r3)     // Catch: java.lang.Throwable -> L8e android.database.sqlite.SQLiteDatabaseCorruptException -> L94
            android.database.sqlite.SQLiteDatabase r3 = r3.a()     // Catch: java.lang.Throwable -> L8e android.database.sqlite.SQLiteDatabaseCorruptException -> L94
            r3.beginTransaction()     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L51
            com.umeng.analytics.pro.l$a r4 = com.umeng.analytics.pro.l.a.BEGIN     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L51
            if (r8 != r4) goto L53
            java.lang.Object r5 = r7.opt(r0)     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L51
            java.lang.Long r5 = (java.lang.Long) r5     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L51
            long r7 = r5.longValue()     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L51
            android.content.ContentValues r5 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L51
            r5.<init>()     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L51
            java.lang.String r4 = "__ii"
            r5.put(r4, r6)     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L51
            java.lang.String r6 = java.lang.String.valueOf(r7)     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L51
            r5.put(r0, r6)     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L51
            java.lang.String r6 = "__av"
            android.content.Context r7 = com.umeng.analytics.pro.l.d     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L51
            java.lang.String r7 = com.umeng.commonsdk.utils.UMUtils.getAppVersionName(r7)     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L51
            r5.put(r6, r7)     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L51
            java.lang.String r6 = "__vc"
            android.content.Context r7 = com.umeng.analytics.pro.l.d     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L51
            java.lang.String r7 = com.umeng.commonsdk.utils.UMUtils.getAppVersionCode(r7)     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L51
            r5.put(r6, r7)     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L51
            java.lang.String r6 = "__sd"
            r3.insert(r6, r2, r5)     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L51
            goto L7e
        L4f:
            r2 = r3
            goto L8e
        L51:
            r2 = r3
            goto L94
        L53:
            com.umeng.analytics.pro.l$a r0 = com.umeng.analytics.pro.l.a.INSTANTSESSIONBEGIN     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L51
            if (r8 != r0) goto L5b
            r5.b(r6, r7, r3)     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L51
            goto L7e
        L5b:
            com.umeng.analytics.pro.l$a r0 = com.umeng.analytics.pro.l.a.END     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L51
            if (r8 != r0) goto L63
            r5.a(r6, r7, r3)     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L51
            goto L7e
        L63:
            com.umeng.analytics.pro.l$a r0 = com.umeng.analytics.pro.l.a.PAGE     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L51
            if (r8 != r0) goto L6d
            java.lang.String r8 = "__a"
            r5.a(r6, r7, r3, r8)     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L51
            goto L7e
        L6d:
            com.umeng.analytics.pro.l$a r0 = com.umeng.analytics.pro.l.a.AUTOPAGE     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L51
            if (r8 != r0) goto L77
            java.lang.String r8 = "__b"
            r5.a(r6, r7, r3, r8)     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L51
            goto L7e
        L77:
            com.umeng.analytics.pro.l$a r0 = com.umeng.analytics.pro.l.a.NEWSESSION     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L51
            if (r8 != r0) goto L7e
            r5.c(r6, r7, r3)     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L51
        L7e:
            r3.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L51
            r3.endTransaction()     // Catch: java.lang.Throwable -> L84
        L84:
            android.content.Context r5 = com.umeng.analytics.pro.l.d
            com.umeng.analytics.pro.j r5 = com.umeng.analytics.pro.j.a(r5)
            r5.b()
            goto L9c
        L8e:
            if (r2 == 0) goto L84
        L90:
            r2.endTransaction()     // Catch: java.lang.Throwable -> L84
            goto L84
        L94:
            android.content.Context r5 = com.umeng.analytics.pro.l.d     // Catch: java.lang.Throwable -> L9d
            com.umeng.analytics.pro.k.a(r5)     // Catch: java.lang.Throwable -> L9d
            if (r2 == 0) goto L84
            goto L90
        L9c:
            return r1
        L9d:
            r5 = move-exception
            if (r2 == 0) goto La3
            r2.endTransaction()     // Catch: java.lang.Throwable -> La3
        La3:
            android.content.Context r6 = com.umeng.analytics.pro.l.d
            com.umeng.analytics.pro.j r6 = com.umeng.analytics.pro.j.a(r6)
            r6.b()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.l.a(java.lang.String, org.json.JSONObject, com.umeng.analytics.pro.l$a):boolean");
    }

    public JSONObject b(boolean z) {
        JSONObject jSONObject = new JSONObject();
        b(jSONObject, z);
        return jSONObject;
    }

    public void b() {
        this.l.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0037, code lost:
    
        if (r2 == null) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(java.lang.String r3) {
        /*
            r2 = this;
            r2 = 0
            android.content.Context r0 = com.umeng.analytics.pro.l.d     // Catch: java.lang.Throwable -> L2f android.database.sqlite.SQLiteDatabaseCorruptException -> L32
            com.umeng.analytics.pro.j r0 = com.umeng.analytics.pro.j.a(r0)     // Catch: java.lang.Throwable -> L2f android.database.sqlite.SQLiteDatabaseCorruptException -> L32
            android.database.sqlite.SQLiteDatabase r2 = r0.a()     // Catch: java.lang.Throwable -> L2f android.database.sqlite.SQLiteDatabaseCorruptException -> L32
            r2.beginTransaction()     // Catch: java.lang.Throwable -> L2f android.database.sqlite.SQLiteDatabaseCorruptException -> L32
            boolean r0 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L2f android.database.sqlite.SQLiteDatabaseCorruptException -> L32
            if (r0 != 0) goto L1f
            java.lang.String r0 = "__is"
            java.lang.String r1 = "__ii=?"
            java.lang.String[] r3 = new java.lang.String[]{r3}     // Catch: java.lang.Throwable -> L2f android.database.sqlite.SQLiteDatabaseCorruptException -> L32
            r2.delete(r0, r1, r3)     // Catch: java.lang.Throwable -> L2f android.database.sqlite.SQLiteDatabaseCorruptException -> L32
        L1f:
            r2.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L2f android.database.sqlite.SQLiteDatabaseCorruptException -> L32
        L22:
            r2.endTransaction()     // Catch: java.lang.Throwable -> L25
        L25:
            android.content.Context r2 = com.umeng.analytics.pro.l.d
            com.umeng.analytics.pro.j r2 = com.umeng.analytics.pro.j.a(r2)
            r2.b()
            goto L3a
        L2f:
            if (r2 == 0) goto L25
            goto L22
        L32:
            android.content.Context r3 = com.umeng.analytics.pro.l.d     // Catch: java.lang.Throwable -> L3b
            com.umeng.analytics.pro.k.a(r3)     // Catch: java.lang.Throwable -> L3b
            if (r2 == 0) goto L25
            goto L22
        L3a:
            return
        L3b:
            r3 = move-exception
            if (r2 == 0) goto L41
            r2.endTransaction()     // Catch: java.lang.Throwable -> L41
        L41:
            android.content.Context r2 = com.umeng.analytics.pro.l.d
            com.umeng.analytics.pro.j r2 = com.umeng.analytics.pro.j.a(r2)
            r2.b()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.l.b(java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0057, code lost:
    
        if (r0 == null) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(boolean r4, boolean r5) {
        /*
            r3 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.l.d     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            com.umeng.analytics.pro.j r1 = com.umeng.analytics.pro.j.a(r1)     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            if (r5 == 0) goto L18
            if (r4 == 0) goto L3f
            java.lang.String r3 = "delete from __sd"
            r0.execSQL(r3)     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            goto L3f
        L18:
            java.util.List<java.lang.String> r4 = r3.i     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            int r4 = r4.size()     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            if (r4 <= 0) goto L3f
            r4 = 0
        L21:
            java.util.List<java.lang.String> r5 = r3.i     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            int r5 = r5.size()     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            if (r4 >= r5) goto L3f
            java.util.List<java.lang.String> r5 = r3.i     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            java.lang.Object r5 = r5.get(r4)     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            java.lang.String r1 = "__sd"
            java.lang.String r2 = "__ii=?"
            java.lang.String[] r5 = new java.lang.String[]{r5}     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            r0.delete(r1, r2, r5)     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            int r4 = r4 + 1
            goto L21
        L3f:
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L4f android.database.sqlite.SQLiteDatabaseCorruptException -> L52
        L42:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L45
        L45:
            android.content.Context r3 = com.umeng.analytics.pro.l.d
            com.umeng.analytics.pro.j r3 = com.umeng.analytics.pro.j.a(r3)
            r3.b()
            goto L5a
        L4f:
            if (r0 == 0) goto L45
            goto L42
        L52:
            android.content.Context r3 = com.umeng.analytics.pro.l.d     // Catch: java.lang.Throwable -> L5b
            com.umeng.analytics.pro.k.a(r3)     // Catch: java.lang.Throwable -> L5b
            if (r0 == 0) goto L45
            goto L42
        L5a:
            return
        L5b:
            r3 = move-exception
            if (r0 == 0) goto L61
            r0.endTransaction()     // Catch: java.lang.Throwable -> L61
        L61:
            android.content.Context r4 = com.umeng.analytics.pro.l.d
            com.umeng.analytics.pro.j r4 = com.umeng.analytics.pro.j.a(r4)
            r4.b()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.l.b(boolean, boolean):void");
    }

    public String c(String str) {
        try {
            return TextUtils.isEmpty(e) ? str : Base64.encodeToString(DataHelper.encrypt(str.getBytes(), e.getBytes()), 0);
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean c() {
        return this.l.isEmpty();
    }

    public String d(String str) {
        try {
            return TextUtils.isEmpty(e) ? str : new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), e.getBytes()));
        } catch (Exception unused) {
            if (Build.VERSION.SDK_INT >= 29 && !TextUtils.isEmpty(str)) {
                try {
                    new JSONObject(str);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> UMStoreManager decrypt failed, return origin data.");
                    return str;
                } catch (Throwable unused2) {
                    return null;
                }
            }
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x007d, code lost:
    
        if (r5 == null) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d() {
        /*
            r5 = this;
            r5 = 0
            android.content.Context r0 = com.umeng.analytics.pro.l.d     // Catch: java.lang.Throwable -> L75 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            com.umeng.analytics.pro.j r0 = com.umeng.analytics.pro.j.a(r0)     // Catch: java.lang.Throwable -> L75 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            android.database.sqlite.SQLiteDatabase r5 = r0.a()     // Catch: java.lang.Throwable -> L75 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            r5.beginTransaction()     // Catch: java.lang.Throwable -> L75 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            com.umeng.analytics.pro.x r0 = com.umeng.analytics.pro.x.a()     // Catch: java.lang.Throwable -> L75 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            java.lang.String r0 = r0.c()     // Catch: java.lang.Throwable -> L75 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L75 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            if (r1 == 0) goto L29
            r5.endTransaction()     // Catch: java.lang.Throwable -> L1f
        L1f:
            android.content.Context r5 = com.umeng.analytics.pro.l.d
            com.umeng.analytics.pro.j r5 = com.umeng.analytics.pro.j.a(r5)
            r5.b()
            return
        L29:
            java.lang.String r1 = ""
            java.lang.String r2 = "-1"
            java.lang.String[] r1 = new java.lang.String[]{r1, r2}     // Catch: java.lang.Throwable -> L75 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            r2 = 0
        L32:
            r3 = 2
            if (r2 >= r3) goto L65
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L75 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            r3.<init>()     // Catch: java.lang.Throwable -> L75 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            java.lang.String r4 = "update __et set __i=\""
            r3.append(r4)     // Catch: java.lang.Throwable -> L75 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            r3.append(r0)     // Catch: java.lang.Throwable -> L75 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            java.lang.String r4 = "\" where "
            r3.append(r4)     // Catch: java.lang.Throwable -> L75 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            java.lang.String r4 = "__i"
            r3.append(r4)     // Catch: java.lang.Throwable -> L75 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            java.lang.String r4 = "=\""
            r3.append(r4)     // Catch: java.lang.Throwable -> L75 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            r4 = r1[r2]     // Catch: java.lang.Throwable -> L75 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            r3.append(r4)     // Catch: java.lang.Throwable -> L75 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            java.lang.String r4 = "\""
            r3.append(r4)     // Catch: java.lang.Throwable -> L75 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L75 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            r5.execSQL(r3)     // Catch: java.lang.Throwable -> L75 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            int r2 = r2 + 1
            goto L32
        L65:
            r5.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L75 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
        L68:
            r5.endTransaction()     // Catch: java.lang.Throwable -> L6b
        L6b:
            android.content.Context r5 = com.umeng.analytics.pro.l.d
            com.umeng.analytics.pro.j r5 = com.umeng.analytics.pro.j.a(r5)
            r5.b()
            goto L80
        L75:
            if (r5 == 0) goto L6b
            goto L68
        L78:
            android.content.Context r0 = com.umeng.analytics.pro.l.d     // Catch: java.lang.Throwable -> L81
            com.umeng.analytics.pro.k.a(r0)     // Catch: java.lang.Throwable -> L81
            if (r5 == 0) goto L6b
            goto L68
        L80:
            return
        L81:
            r0 = move-exception
            if (r5 == 0) goto L87
            r5.endTransaction()     // Catch: java.lang.Throwable -> L87
        L87:
            android.content.Context r5 = com.umeng.analytics.pro.l.d
            com.umeng.analytics.pro.j r5 = com.umeng.analytics.pro.j.a(r5)
            r5.b()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.l.d():void");
    }

    public boolean e() {
        return this.i.isEmpty();
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x00a1, code lost:
    
        if (r6 != null) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0089, code lost:
    
        r6.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0087, code lost:
    
        if (r6 != null) goto L54;
     */
    /* JADX WARN: Finally extract failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.json.JSONObject f() {
        /*
            r14 = this;
            java.lang.String r0 = "__vc"
            java.lang.String r1 = "__av"
            java.util.List<java.lang.String> r2 = r14.l
            boolean r2 = r2.isEmpty()
            r3 = 0
            if (r2 == 0) goto Le
            return r3
        Le:
            android.content.Context r2 = com.umeng.analytics.pro.l.d     // Catch: java.lang.Throwable -> L7c android.database.sqlite.SQLiteDatabaseCorruptException -> L7f
            com.umeng.analytics.pro.j r2 = com.umeng.analytics.pro.j.a(r2)     // Catch: java.lang.Throwable -> L7c android.database.sqlite.SQLiteDatabaseCorruptException -> L7f
            android.database.sqlite.SQLiteDatabase r6 = r2.a()     // Catch: java.lang.Throwable -> L7c android.database.sqlite.SQLiteDatabaseCorruptException -> L7f
            r6.beginTransaction()     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            java.util.List<java.lang.String> r2 = r14.l     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            r4 = 0
            java.lang.Object r2 = r2.get(r4)     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            java.lang.String r5 = "__is"
            java.lang.String r8 = "__ii=? "
            java.lang.String[] r9 = new java.lang.String[]{r2}     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            r12 = 0
            r13 = 0
            r7 = 0
            r10 = 0
            r11 = 0
            r4 = r14
            android.database.Cursor r14 = r4.a(r5, r6, r7, r8, r9, r10, r11, r12, r13)     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            if (r14 == 0) goto L63
            boolean r2 = r14.moveToNext()     // Catch: java.lang.Throwable -> L5f android.database.sqlite.SQLiteDatabaseCorruptException -> L61
            if (r2 == 0) goto L63
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L5f android.database.sqlite.SQLiteDatabaseCorruptException -> L61
            r2.<init>()     // Catch: java.lang.Throwable -> L5f android.database.sqlite.SQLiteDatabaseCorruptException -> L61
            int r3 = r14.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L5b android.database.sqlite.SQLiteDatabaseCorruptException -> L5d
            java.lang.String r3 = r14.getString(r3)     // Catch: java.lang.Throwable -> L5b android.database.sqlite.SQLiteDatabaseCorruptException -> L5d
            int r4 = r14.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L5b android.database.sqlite.SQLiteDatabaseCorruptException -> L5d
            java.lang.String r4 = r14.getString(r4)     // Catch: java.lang.Throwable -> L5b android.database.sqlite.SQLiteDatabaseCorruptException -> L5d
            r2.put(r1, r3)     // Catch: java.lang.Throwable -> L5b android.database.sqlite.SQLiteDatabaseCorruptException -> L5d
            r2.put(r0, r4)     // Catch: java.lang.Throwable -> L5b android.database.sqlite.SQLiteDatabaseCorruptException -> L5d
            r3 = r2
            goto L63
        L5b:
            r3 = r14
            goto L82
        L5d:
            r3 = r14
            goto L97
        L5f:
            r2 = r3
            goto L5b
        L61:
            r2 = r3
            goto L5d
        L63:
            r6.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L5f android.database.sqlite.SQLiteDatabaseCorruptException -> L61
            if (r14 == 0) goto L6b
            r14.close()
        L6b:
            r6.endTransaction()     // Catch: java.lang.Throwable -> L6e
        L6e:
            android.content.Context r14 = com.umeng.analytics.pro.l.d
            com.umeng.analytics.pro.j r14 = com.umeng.analytics.pro.j.a(r14)
            r14.b()
            goto La4
        L78:
            r2 = r3
            goto L82
        L7a:
            r2 = r3
            goto L97
        L7c:
            r2 = r3
            r6 = r2
            goto L82
        L7f:
            r2 = r3
            r6 = r2
            goto L97
        L82:
            if (r3 == 0) goto L87
            r3.close()
        L87:
            if (r6 == 0) goto L8c
        L89:
            r6.endTransaction()     // Catch: java.lang.Throwable -> L8c
        L8c:
            android.content.Context r14 = com.umeng.analytics.pro.l.d
            com.umeng.analytics.pro.j r14 = com.umeng.analytics.pro.j.a(r14)
            r14.b()
            r3 = r2
            goto La4
        L97:
            android.content.Context r14 = com.umeng.analytics.pro.l.d     // Catch: java.lang.Throwable -> La5
            com.umeng.analytics.pro.k.a(r14)     // Catch: java.lang.Throwable -> La5
            if (r3 == 0) goto La1
            r3.close()
        La1:
            if (r6 == 0) goto L8c
            goto L89
        La4:
            return r3
        La5:
            r0 = move-exception
            r14 = r0
            if (r3 == 0) goto Lac
            r3.close()
        Lac:
            if (r6 == 0) goto Lb1
            r6.endTransaction()     // Catch: java.lang.Throwable -> Lb1
        Lb1:
            android.content.Context r0 = com.umeng.analytics.pro.l.d
            com.umeng.analytics.pro.j r0 = com.umeng.analytics.pro.j.a(r0)
            r0.b()
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.l.f():org.json.JSONObject");
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x00a1, code lost:
    
        if (r6 != null) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0089, code lost:
    
        r6.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0087, code lost:
    
        if (r6 != null) goto L54;
     */
    /* JADX WARN: Finally extract failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.json.JSONObject g() {
        /*
            r14 = this;
            java.lang.String r0 = "__vc"
            java.lang.String r1 = "__av"
            java.util.List<java.lang.String> r2 = r14.i
            boolean r2 = r2.isEmpty()
            r3 = 0
            if (r2 == 0) goto Le
            return r3
        Le:
            android.content.Context r2 = com.umeng.analytics.pro.l.d     // Catch: java.lang.Throwable -> L7c android.database.sqlite.SQLiteDatabaseCorruptException -> L7f
            com.umeng.analytics.pro.j r2 = com.umeng.analytics.pro.j.a(r2)     // Catch: java.lang.Throwable -> L7c android.database.sqlite.SQLiteDatabaseCorruptException -> L7f
            android.database.sqlite.SQLiteDatabase r6 = r2.a()     // Catch: java.lang.Throwable -> L7c android.database.sqlite.SQLiteDatabaseCorruptException -> L7f
            r6.beginTransaction()     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            java.util.List<java.lang.String> r2 = r14.i     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            r4 = 0
            java.lang.Object r2 = r2.get(r4)     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            java.lang.String r5 = "__sd"
            java.lang.String r8 = "__ii=? "
            java.lang.String[] r9 = new java.lang.String[]{r2}     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            r12 = 0
            r13 = 0
            r7 = 0
            r10 = 0
            r11 = 0
            r4 = r14
            android.database.Cursor r14 = r4.a(r5, r6, r7, r8, r9, r10, r11, r12, r13)     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            if (r14 == 0) goto L63
            boolean r2 = r14.moveToNext()     // Catch: java.lang.Throwable -> L5f android.database.sqlite.SQLiteDatabaseCorruptException -> L61
            if (r2 == 0) goto L63
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L5f android.database.sqlite.SQLiteDatabaseCorruptException -> L61
            r2.<init>()     // Catch: java.lang.Throwable -> L5f android.database.sqlite.SQLiteDatabaseCorruptException -> L61
            int r3 = r14.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L5b android.database.sqlite.SQLiteDatabaseCorruptException -> L5d
            java.lang.String r3 = r14.getString(r3)     // Catch: java.lang.Throwable -> L5b android.database.sqlite.SQLiteDatabaseCorruptException -> L5d
            int r4 = r14.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L5b android.database.sqlite.SQLiteDatabaseCorruptException -> L5d
            java.lang.String r4 = r14.getString(r4)     // Catch: java.lang.Throwable -> L5b android.database.sqlite.SQLiteDatabaseCorruptException -> L5d
            r2.put(r1, r3)     // Catch: java.lang.Throwable -> L5b android.database.sqlite.SQLiteDatabaseCorruptException -> L5d
            r2.put(r0, r4)     // Catch: java.lang.Throwable -> L5b android.database.sqlite.SQLiteDatabaseCorruptException -> L5d
            r3 = r2
            goto L63
        L5b:
            r3 = r14
            goto L82
        L5d:
            r3 = r14
            goto L97
        L5f:
            r2 = r3
            goto L5b
        L61:
            r2 = r3
            goto L5d
        L63:
            r6.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L5f android.database.sqlite.SQLiteDatabaseCorruptException -> L61
            if (r14 == 0) goto L6b
            r14.close()
        L6b:
            r6.endTransaction()     // Catch: java.lang.Throwable -> L6e
        L6e:
            android.content.Context r14 = com.umeng.analytics.pro.l.d
            com.umeng.analytics.pro.j r14 = com.umeng.analytics.pro.j.a(r14)
            r14.b()
            goto La4
        L78:
            r2 = r3
            goto L82
        L7a:
            r2 = r3
            goto L97
        L7c:
            r2 = r3
            r6 = r2
            goto L82
        L7f:
            r2 = r3
            r6 = r2
            goto L97
        L82:
            if (r3 == 0) goto L87
            r3.close()
        L87:
            if (r6 == 0) goto L8c
        L89:
            r6.endTransaction()     // Catch: java.lang.Throwable -> L8c
        L8c:
            android.content.Context r14 = com.umeng.analytics.pro.l.d
            com.umeng.analytics.pro.j r14 = com.umeng.analytics.pro.j.a(r14)
            r14.b()
            r3 = r2
            goto La4
        L97:
            android.content.Context r14 = com.umeng.analytics.pro.l.d     // Catch: java.lang.Throwable -> La5
            com.umeng.analytics.pro.k.a(r14)     // Catch: java.lang.Throwable -> La5
            if (r3 == 0) goto La1
            r3.close()
        La1:
            if (r6 == 0) goto L8c
            goto L89
        La4:
            return r3
        La5:
            r0 = move-exception
            r14 = r0
            if (r3 == 0) goto Lac
            r3.close()
        Lac:
            if (r6 == 0) goto Lb1
            r6.endTransaction()     // Catch: java.lang.Throwable -> Lb1
        Lb1:
            android.content.Context r0 = com.umeng.analytics.pro.l.d
            com.umeng.analytics.pro.j r0 = com.umeng.analytics.pro.j.a(r0)
            r0.b()
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.l.g():org.json.JSONObject");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x005a, code lost:
    
        if (r0 == null) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void h() {
        /*
            r5 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.l.d     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L55
            com.umeng.analytics.pro.j r1 = com.umeng.analytics.pro.j.a(r1)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L55
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L55
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L55
            java.util.List<java.lang.Integer> r1 = r5.j     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L55
            int r1 = r1.size()     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L55
            if (r1 <= 0) goto L3d
            r1 = 0
        L17:
            java.util.List<java.lang.Integer> r2 = r5.j     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L55
            int r2 = r2.size()     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L55
            if (r1 >= r2) goto L3d
            java.util.List<java.lang.Integer> r2 = r5.j     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L55
            java.lang.Object r2 = r2.get(r1)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L55
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L55
            int r2 = r2.intValue()     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L55
            java.lang.String r3 = "__et"
            java.lang.String r4 = "rowid=?"
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L55
            java.lang.String[] r2 = new java.lang.String[]{r2}     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L55
            r0.delete(r3, r4, r2)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L55
            int r1 = r1 + 1
            goto L17
        L3d:
            java.util.List<java.lang.Integer> r5 = r5.j     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L55
            r5.clear()     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L55
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L55
        L45:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L48
        L48:
            android.content.Context r5 = com.umeng.analytics.pro.l.d
            com.umeng.analytics.pro.j r5 = com.umeng.analytics.pro.j.a(r5)
            r5.b()
            goto L5d
        L52:
            if (r0 == 0) goto L48
            goto L45
        L55:
            android.content.Context r5 = com.umeng.analytics.pro.l.d     // Catch: java.lang.Throwable -> L5e
            com.umeng.analytics.pro.k.a(r5)     // Catch: java.lang.Throwable -> L5e
            if (r0 == 0) goto L48
            goto L45
        L5d:
            return
        L5e:
            r5 = move-exception
            if (r0 == 0) goto L64
            r0.endTransaction()     // Catch: java.lang.Throwable -> L64
        L64:
            android.content.Context r0 = com.umeng.analytics.pro.l.d
            com.umeng.analytics.pro.j r0 = com.umeng.analytics.pro.j.a(r0)
            r0.b()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.l.h():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002b, code lost:
    
        if (r1 == null) goto L5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void i() {
        /*
            r1 = this;
            r1 = 0
            android.content.Context r0 = com.umeng.analytics.pro.l.d     // Catch: java.lang.Throwable -> L23 android.database.sqlite.SQLiteDatabaseCorruptException -> L26
            com.umeng.analytics.pro.j r0 = com.umeng.analytics.pro.j.a(r0)     // Catch: java.lang.Throwable -> L23 android.database.sqlite.SQLiteDatabaseCorruptException -> L26
            android.database.sqlite.SQLiteDatabase r1 = r0.a()     // Catch: java.lang.Throwable -> L23 android.database.sqlite.SQLiteDatabaseCorruptException -> L26
            r1.beginTransaction()     // Catch: java.lang.Throwable -> L23 android.database.sqlite.SQLiteDatabaseCorruptException -> L26
            java.lang.String r0 = "delete from __er"
            r1.execSQL(r0)     // Catch: java.lang.Throwable -> L23 android.database.sqlite.SQLiteDatabaseCorruptException -> L26
            r1.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L23 android.database.sqlite.SQLiteDatabaseCorruptException -> L26
        L16:
            r1.endTransaction()     // Catch: java.lang.Throwable -> L19
        L19:
            android.content.Context r1 = com.umeng.analytics.pro.l.d
            com.umeng.analytics.pro.j r1 = com.umeng.analytics.pro.j.a(r1)
            r1.b()
            goto L2e
        L23:
            if (r1 == 0) goto L19
            goto L16
        L26:
            android.content.Context r0 = com.umeng.analytics.pro.l.d     // Catch: java.lang.Throwable -> L2f
            com.umeng.analytics.pro.k.a(r0)     // Catch: java.lang.Throwable -> L2f
            if (r1 == 0) goto L19
            goto L16
        L2e:
            return
        L2f:
            r0 = move-exception
            if (r1 == 0) goto L35
            r1.endTransaction()     // Catch: java.lang.Throwable -> L35
        L35:
            android.content.Context r1 = com.umeng.analytics.pro.l.d
            com.umeng.analytics.pro.j r1 = com.umeng.analytics.pro.j.a(r1)
            r1.b()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.l.i():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x004a, code lost:
    
        if (r1 == null) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void j() {
        /*
            r5 = this;
            java.lang.String r0 = "__i=?"
            java.lang.String r1 = r5.k
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            r2 = 0
            if (r1 != 0) goto L5d
            android.content.Context r1 = com.umeng.analytics.pro.l.d     // Catch: java.lang.Throwable -> L3e android.database.sqlite.SQLiteDatabaseCorruptException -> L40
            com.umeng.analytics.pro.j r1 = com.umeng.analytics.pro.j.a(r1)     // Catch: java.lang.Throwable -> L3e android.database.sqlite.SQLiteDatabaseCorruptException -> L40
            android.database.sqlite.SQLiteDatabase r1 = r1.a()     // Catch: java.lang.Throwable -> L3e android.database.sqlite.SQLiteDatabaseCorruptException -> L40
            r1.beginTransaction()     // Catch: java.lang.Throwable -> L42 android.database.sqlite.SQLiteDatabaseCorruptException -> L45
            java.lang.String r3 = "__er"
            java.lang.String r4 = r5.k     // Catch: java.lang.Throwable -> L42 android.database.sqlite.SQLiteDatabaseCorruptException -> L45
            java.lang.String[] r4 = new java.lang.String[]{r4}     // Catch: java.lang.Throwable -> L42 android.database.sqlite.SQLiteDatabaseCorruptException -> L45
            r1.delete(r3, r0, r4)     // Catch: java.lang.Throwable -> L42 android.database.sqlite.SQLiteDatabaseCorruptException -> L45
            java.lang.String r3 = "__et"
            java.lang.String r4 = r5.k     // Catch: java.lang.Throwable -> L42 android.database.sqlite.SQLiteDatabaseCorruptException -> L45
            java.lang.String[] r4 = new java.lang.String[]{r4}     // Catch: java.lang.Throwable -> L42 android.database.sqlite.SQLiteDatabaseCorruptException -> L45
            r1.delete(r3, r0, r4)     // Catch: java.lang.Throwable -> L42 android.database.sqlite.SQLiteDatabaseCorruptException -> L45
            r1.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L42 android.database.sqlite.SQLiteDatabaseCorruptException -> L45
        L31:
            r1.endTransaction()     // Catch: java.lang.Throwable -> L34
        L34:
            android.content.Context r0 = com.umeng.analytics.pro.l.d
            com.umeng.analytics.pro.j r0 = com.umeng.analytics.pro.j.a(r0)
            r0.b()
            goto L5d
        L3e:
            r1 = r2
            goto L42
        L40:
            r1 = r2
            goto L45
        L42:
            if (r1 == 0) goto L34
            goto L31
        L45:
            android.content.Context r0 = com.umeng.analytics.pro.l.d     // Catch: java.lang.Throwable -> L4d
            com.umeng.analytics.pro.k.a(r0)     // Catch: java.lang.Throwable -> L4d
            if (r1 == 0) goto L34
            goto L31
        L4d:
            r5 = move-exception
            if (r1 == 0) goto L53
            r1.endTransaction()     // Catch: java.lang.Throwable -> L53
        L53:
            android.content.Context r0 = com.umeng.analytics.pro.l.d
            com.umeng.analytics.pro.j r0 = com.umeng.analytics.pro.j.a(r0)
            r0.b()
            throw r5
        L5d:
            r5.k = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.l.j():void");
    }
}
