package defpackage;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.util.Log;

/* loaded from: /tmp/classes2.dex */
public class i90 {
    public Context a;

    public i90(Context context) {
        this.a = context;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0067 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0068 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r8v0, types: [i90] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r8v5, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String a(int r9, java.lang.String r10) {
        /*
            r8 = this;
            java.lang.String r0 = "VMS_SDK_DB"
            r1 = 0
            if (r9 == 0) goto L5e
            r2 = 1
            if (r9 == r2) goto L4b
            r2 = 2
            if (r9 == r2) goto L38
            r2 = 3
            if (r9 == r2) goto L31
            r2 = 4
            if (r9 == r2) goto L1e
            r10 = 5
            if (r9 == r10) goto L16
            r3 = r1
            goto L65
        L16:
            java.lang.String r9 = "content://com.vivo.abe.exidentifier/guid"
            android.net.Uri r9 = android.net.Uri.parse(r9)
        L1c:
            r3 = r9
            goto L65
        L1e:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r2 = "content://com.vivo.vms.IdProvider/IdentifierId/OAIDSTATUS_"
            r9.<init>(r2)
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            android.net.Uri r9 = android.net.Uri.parse(r9)
            goto L1c
        L31:
            java.lang.String r9 = "content://com.vivo.vms.IdProvider/IdentifierId/UDID"
            android.net.Uri r9 = android.net.Uri.parse(r9)
            goto L1c
        L38:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r2 = "content://com.vivo.vms.IdProvider/IdentifierId/AAID_"
            r9.<init>(r2)
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            android.net.Uri r9 = android.net.Uri.parse(r9)
            goto L1c
        L4b:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r2 = "content://com.vivo.vms.IdProvider/IdentifierId/VAID_"
            r9.<init>(r2)
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            android.net.Uri r9 = android.net.Uri.parse(r9)
            goto L1c
        L5e:
            java.lang.String r9 = "content://com.vivo.vms.IdProvider/IdentifierId/OAID"
            android.net.Uri r9 = android.net.Uri.parse(r9)
            goto L1c
        L65:
            if (r3 != 0) goto L68
            return r1
        L68:
            android.content.Context r8 = r8.a     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> L9b
            android.content.ContentResolver r2 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> L9b
            r6 = 0
            r7 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r8 = r2.query(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> L9b
            if (r8 == 0) goto L8d
            boolean r9 = r8.moveToNext()     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L9c
            if (r9 == 0) goto L92
            java.lang.String r9 = "value"
            int r9 = r8.getColumnIndex(r9)     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L9c
            java.lang.String r1 = r8.getString(r9)     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L9c
            goto L92
        L89:
            r0 = move-exception
            r9 = r0
            r1 = r8
            goto La7
        L8d:
            java.lang.String r9 = "return cursor is null,return"
            android.util.Log.d(r0, r9)     // Catch: java.lang.Throwable -> L89 java.lang.Exception -> L9c
        L92:
            if (r8 == 0) goto L97
            r8.close()
        L97:
            return r1
        L98:
            r0 = move-exception
            r9 = r0
            goto La7
        L9b:
            r8 = r1
        L9c:
            java.lang.String r9 = "return cursor is error"
            android.util.Log.e(r0, r9)     // Catch: java.lang.Throwable -> L89
            if (r8 == 0) goto La6
            r8.close()
        La6:
            return r1
        La7:
            if (r1 == 0) goto Lac
            r1.close()
        Lac:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.i90.a(int, java.lang.String):java.lang.String");
    }

    public boolean b(int i, String str, ContentValues[] contentValuesArr) {
        Uri parse;
        int bulkInsert;
        if (i == 6) {
            parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAIDBLACK_" + str);
        } else if (i != 7) {
            parse = null;
        } else {
            parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/STATISTICS_" + str);
        }
        if (parse == null) {
            return false;
        }
        try {
            bulkInsert = this.a.getContentResolver().bulkInsert(parse, contentValuesArr);
            Log.d("VMS_SDK_DB", "insert:" + bulkInsert);
        } catch (Exception unused) {
            Log.e("VMS_SDK_DB", "return insert is error");
        }
        return bulkInsert != 0;
    }
}
