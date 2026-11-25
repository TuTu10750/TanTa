package com.umeng.analytics.process;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.umeng.analytics.process.DBFileTraversalUtil;
import com.umeng.analytics.process.a;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.utils.FileLockCallback;
import com.umeng.commonsdk.utils.FileLockUtil;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /tmp/classes2.dex */
public class UMProcessDBHelper {
    private static UMProcessDBHelper mInstance;
    private Context mContext;
    private FileLockUtil mFileLock = new FileLockUtil();
    private InsertEventCallback ekvCallBack = new InsertEventCallback();

    /* loaded from: /tmp/classes2.dex */
    public class InsertEventCallback implements FileLockCallback {
        private InsertEventCallback() {
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(File file, int i) {
            return false;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str) {
            return false;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str, Object obj) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            String str2 = com.umeng.analytics.process.a.c;
            if (str.startsWith(str2)) {
                str = str.replaceFirst(str2, "");
            }
            UMProcessDBHelper.this.insertEvents(str.replace(com.umeng.analytics.process.a.d, ""), (JSONArray) obj);
            return true;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class ProcessToMainCallback implements FileLockCallback {
        private ProcessToMainCallback() {
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(File file, int i) {
            return false;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            String str2 = com.umeng.analytics.process.a.c;
            if (str.startsWith(str2)) {
                str = str.replaceFirst(str2, "");
            }
            UMProcessDBHelper.this.processToMain(str.replace(com.umeng.analytics.process.a.d, ""));
            return true;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str, Object obj) {
            return false;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class a implements Serializable {
        int a;
        String b;
        String c;
        String d;
        int e;
        String f;
        String g;
        String h;

        private a() {
        }
    }

    private UMProcessDBHelper() {
    }

    private UMProcessDBHelper(Context context) {
        com.umeng.common.a.a().a(context);
    }

    private List<a> datasAdapter(String str, JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    a aVar = new a();
                    aVar.c = jSONObject.optString("id");
                    aVar.g = UMUtils.getAppVersionName(this.mContext);
                    aVar.h = UMUtils.getAppVersionCode(this.mContext);
                    aVar.b = jSONObject.optString("__i");
                    aVar.e = jSONObject.optInt("__t");
                    aVar.f = str;
                    if (jSONObject.has("ds")) {
                        jSONObject.remove("ds");
                    }
                    jSONObject.put("ds", getDataSource());
                    jSONObject.remove("__i");
                    jSONObject.remove("__t");
                    aVar.d = com.umeng.common.a.a().a(jSONObject.toString());
                    jSONObject.remove("ds");
                    arrayList.add(aVar);
                } catch (Exception unused) {
                }
            }
        }
        return arrayList;
    }

    private boolean dbIsExists(String str) {
        try {
            return new File(b.b(this.mContext, str)).exists();
        } catch (Throwable unused) {
            return false;
        }
    }

    private int getDataSource() {
        return 0;
    }

    public static UMProcessDBHelper getInstance(Context context) {
        if (mInstance == null) {
            synchronized (UMProcessDBHelper.class) {
                try {
                    if (mInstance == null) {
                        mInstance = new UMProcessDBHelper(context);
                    }
                } finally {
                }
            }
        }
        UMProcessDBHelper uMProcessDBHelper = mInstance;
        uMProcessDBHelper.mContext = context;
        return uMProcessDBHelper;
    }

    private boolean insertEvents_(String str, List<a> list) {
        if (TextUtils.isEmpty(str) || list == null || list.isEmpty()) {
            return true;
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            SQLiteDatabase a2 = c.a(this.mContext).a(str);
            try {
                try {
                    a2.beginTransaction();
                    for (a aVar : list) {
                        try {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("__i", aVar.b);
                            contentValues.put("__e", aVar.c);
                            contentValues.put("__t", Integer.valueOf(aVar.e));
                            contentValues.put(a.InterfaceC0015a.f, aVar.f);
                            contentValues.put("__av", aVar.g);
                            contentValues.put("__vc", aVar.h);
                            contentValues.put("__s", aVar.d);
                            a2.insert(a.InterfaceC0015a.a, null, contentValues);
                        } catch (Exception unused) {
                        }
                    }
                    a2.setTransactionSuccessful();
                    try {
                        a2.endTransaction();
                    } catch (Throwable unused2) {
                    }
                    c.a(this.mContext).b(str);
                    return true;
                } catch (Exception unused3) {
                    sQLiteDatabase = a2;
                    if (sQLiteDatabase != null) {
                        try {
                            sQLiteDatabase.endTransaction();
                        } catch (Throwable unused4) {
                        }
                    }
                    c.a(this.mContext).b(str);
                    return false;
                }
            } catch (Throwable th) {
                th = th;
                sQLiteDatabase = a2;
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Throwable unused5) {
                    }
                }
                c.a(this.mContext).b(str);
                throw th;
            }
        } catch (Exception unused6) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private boolean processIsService(Context context) {
        return context.getPackageManager().getServiceInfo(new ComponentName(context, this.mContext.getClass()), 0) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processToMain(String str) {
        if (dbIsExists(str)) {
            List<a> readEventByProcess = readEventByProcess(str);
            if (!readEventByProcess.isEmpty() && insertEvents_(com.umeng.analytics.process.a.h, readEventByProcess)) {
                deleteEventDatas(str, null, readEventByProcess);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x00b4, code lost:
    
        if (r3 != null) goto L16;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.umeng.analytics.process.UMProcessDBHelper$1] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.util.List<com.umeng.analytics.process.UMProcessDBHelper.a> readEventByProcess(java.lang.String r12) {
        /*
            r11 = this;
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r2 = 0
            android.content.Context r0 = r11.mContext     // Catch: java.lang.Throwable -> La7 java.lang.Exception -> Laa
            com.umeng.analytics.process.c r0 = com.umeng.analytics.process.c.a(r0)     // Catch: java.lang.Throwable -> La7 java.lang.Exception -> Laa
            android.database.sqlite.SQLiteDatabase r3 = r0.a(r12)     // Catch: java.lang.Throwable -> La7 java.lang.Exception -> Laa
            r3.beginTransaction()     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
            java.lang.String r4 = "__et_p"
            r9 = 0
            r10 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r4 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La5
            if (r4 == 0) goto L91
        L21:
            boolean r0 = r4.moveToNext()     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8e
            if (r0 == 0) goto L91
            com.umeng.analytics.process.UMProcessDBHelper$a r0 = new com.umeng.analytics.process.UMProcessDBHelper$a     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8e
            r0.<init>()     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8e
            r5 = 0
            int r5 = r4.getInt(r5)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8e
            r0.a = r5     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8e
            java.lang.String r5 = "__i"
            int r5 = r4.getColumnIndex(r5)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8e
            java.lang.String r5 = r4.getString(r5)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8e
            r0.b = r5     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8e
            java.lang.String r5 = "__e"
            int r5 = r4.getColumnIndex(r5)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8e
            java.lang.String r5 = r4.getString(r5)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8e
            r0.c = r5     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8e
            java.lang.String r5 = "__s"
            int r5 = r4.getColumnIndex(r5)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8e
            java.lang.String r5 = r4.getString(r5)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8e
            r0.d = r5     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8e
            java.lang.String r5 = "__t"
            int r5 = r4.getColumnIndex(r5)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8e
            int r5 = r4.getInt(r5)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8e
            r0.e = r5     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8e
            java.lang.String r5 = "__pn"
            int r5 = r4.getColumnIndex(r5)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8e
            java.lang.String r5 = r4.getString(r5)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8e
            r0.f = r5     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8e
            java.lang.String r5 = "__av"
            int r5 = r4.getColumnIndex(r5)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8e
            java.lang.String r5 = r4.getString(r5)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8e
            r0.g = r5     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8e
            java.lang.String r5 = "__vc"
            int r5 = r4.getColumnIndex(r5)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8e
            java.lang.String r5 = r4.getString(r5)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8e
            r0.h = r5     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8e
            r1.add(r0)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L8e
            goto L21
        L8b:
            r0 = move-exception
            r2 = r4
            goto Lb8
        L8e:
            r0 = move-exception
            r2 = r4
            goto Lac
        L91:
            if (r4 == 0) goto L96
            r4.close()     // Catch: java.lang.Exception -> L99
        L96:
            r3.endTransaction()     // Catch: java.lang.Exception -> L99
        L99:
            android.content.Context r11 = r11.mContext
            com.umeng.analytics.process.c r11 = com.umeng.analytics.process.c.a(r11)
            r11.b(r12)
            goto Lb7
        La3:
            r0 = move-exception
            goto Lb8
        La5:
            r0 = move-exception
            goto Lac
        La7:
            r0 = move-exception
            r3 = r2
            goto Lb8
        Laa:
            r0 = move-exception
            r3 = r2
        Lac:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> La3
            if (r2 == 0) goto Lb4
            r2.close()     // Catch: java.lang.Exception -> L99
        Lb4:
            if (r3 == 0) goto L99
            goto L96
        Lb7:
            return r1
        Lb8:
            if (r2 == 0) goto Lbd
            r2.close()     // Catch: java.lang.Exception -> Lc2
        Lbd:
            if (r3 == 0) goto Lc2
            r3.endTransaction()     // Catch: java.lang.Exception -> Lc2
        Lc2:
            android.content.Context r11 = r11.mContext
            com.umeng.analytics.process.c r11 = com.umeng.analytics.process.c.a(r11)
            r11.b(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.process.UMProcessDBHelper.readEventByProcess(java.lang.String):java.util.List");
    }

    public void createDBByProcess(String str) {
        try {
            c.a(this.mContext).a(str);
            c.a(this.mContext).b(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteEventDatas(String str, String str2, List<a> list) {
        SQLiteDatabase sQLiteDatabase;
        Throwable th;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        SQLiteDatabase sQLiteDatabase2 = null;
        try {
            sQLiteDatabase = c.a(this.mContext).a(str);
        } catch (Exception unused) {
        } catch (Throwable th2) {
            sQLiteDatabase = null;
            th = th2;
        }
        try {
            sQLiteDatabase.beginTransaction();
            int size = list.size();
            if (size > 0) {
                for (int i = 0; i < size; i++) {
                    sQLiteDatabase.delete(a.InterfaceC0015a.a, "rowid=?", new String[]{String.valueOf(list.get(i).a)});
                }
            } else {
                sQLiteDatabase.delete(a.InterfaceC0015a.a, null, null);
            }
            sQLiteDatabase.setTransactionSuccessful();
            sQLiteDatabase.endTransaction();
        } catch (Exception unused2) {
            sQLiteDatabase2 = sQLiteDatabase;
            if (sQLiteDatabase2 != null) {
                sQLiteDatabase2.endTransaction();
            }
            c.a(this.mContext).b(str);
        } catch (Throwable th3) {
            th = th3;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
            c.a(this.mContext).b(str);
            throw th;
        }
        c.a(this.mContext).b(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0051, code lost:
    
        if (r1 != null) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void deleteMainProcessEventDatasByIds(java.util.List<java.lang.Integer> r6) {
        /*
            r5 = this;
            java.lang.String r0 = "_main_"
            r1 = 0
            android.content.Context r2 = r5.mContext     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L51
            com.umeng.analytics.process.c r2 = com.umeng.analytics.process.c.a(r2)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L51
            android.database.sqlite.SQLiteDatabase r1 = r2.a(r0)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L51
            r1.beginTransaction()     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L51
            java.util.Iterator r6 = r6.iterator()     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L51
        L14:
            boolean r2 = r6.hasNext()     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L51
            if (r2 == 0) goto L32
            java.lang.Object r2 = r6.next()     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L51
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L51
            java.lang.String r3 = "__et_p"
            java.lang.String r4 = "id=?"
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L51
            java.lang.String[] r2 = new java.lang.String[]{r2}     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L51
            r1.delete(r3, r4, r2)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L51
            goto L14
        L30:
            r6 = move-exception
            goto L42
        L32:
            r1.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L51
        L35:
            r1.endTransaction()
        L38:
            android.content.Context r5 = r5.mContext
            com.umeng.analytics.process.c r5 = com.umeng.analytics.process.c.a(r5)
            r5.b(r0)
            return
        L42:
            if (r1 == 0) goto L47
            r1.endTransaction()
        L47:
            android.content.Context r5 = r5.mContext
            com.umeng.analytics.process.c r5 = com.umeng.analytics.process.c.a(r5)
            r5.b(r0)
            throw r6
        L51:
            if (r1 == 0) goto L38
            goto L35
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.process.UMProcessDBHelper.deleteMainProcessEventDatasByIds(java.util.List):void");
    }

    public void insertEvents(String str, JSONArray jSONArray) {
        if (AnalyticsConstants.SUB_PROCESS_EVENT && !TextUtils.isEmpty(str)) {
            insertEvents_(str, datasAdapter(str, jSONArray));
        }
    }

    public void insertEventsInSubProcess(String str, JSONArray jSONArray) {
        if (AnalyticsConstants.SUB_PROCESS_EVENT && !TextUtils.isEmpty(str)) {
            File file = new File(b.b(this.mContext, str));
            if (file.exists()) {
                this.mFileLock.doFileOperateion(file, this.ekvCallBack, jSONArray);
            } else {
                insertEvents(str, jSONArray);
            }
        }
    }

    public void processDBToMain() {
        try {
            DBFileTraversalUtil.traverseDBFiles(b.a(this.mContext), new ProcessToMainCallback(), new DBFileTraversalUtil.a() { // from class: com.umeng.analytics.process.UMProcessDBHelper.1
                @Override // com.umeng.analytics.process.DBFileTraversalUtil.a
                public void a() {
                    if (AnalyticsConstants.SUB_PROCESS_EVENT) {
                        UMWorkDispatch.sendEvent(UMProcessDBHelper.this.mContext, UMProcessDBDatasSender.UM_PROCESS_CONSTRUCTMESSAGE, UMProcessDBDatasSender.getInstance(UMProcessDBHelper.this.mContext), null);
                    }
                }
            });
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00d2 A[Catch: all -> 0x00a8, Exception -> 0x00ab, TryCatch #6 {Exception -> 0x00ab, all -> 0x00a8, blocks: (B:6:0x0016, B:8:0x0027, B:10:0x002e, B:12:0x0034, B:15:0x0077, B:18:0x007e, B:27:0x0088, B:29:0x009f, B:32:0x00cc, B:34:0x00d2, B:35:0x00dc, B:37:0x00eb, B:39:0x00f2, B:61:0x00d7, B:62:0x00af, B:43:0x0107, B:45:0x010d, B:46:0x0116, B:48:0x011c, B:51:0x0139, B:56:0x013d, B:58:0x0143, B:68:0x0148), top: B:5:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00d7 A[Catch: all -> 0x00a8, Exception -> 0x00ab, TryCatch #6 {Exception -> 0x00ab, all -> 0x00a8, blocks: (B:6:0x0016, B:8:0x0027, B:10:0x002e, B:12:0x0034, B:15:0x0077, B:18:0x007e, B:27:0x0088, B:29:0x009f, B:32:0x00cc, B:34:0x00d2, B:35:0x00dc, B:37:0x00eb, B:39:0x00f2, B:61:0x00d7, B:62:0x00af, B:43:0x0107, B:45:0x010d, B:46:0x0116, B:48:0x011c, B:51:0x0139, B:56:0x013d, B:58:0x0143, B:68:0x0148), top: B:5:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0184 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.json.JSONObject readMainEvents(long r19, java.util.List<java.lang.Integer> r21) {
        /*
            Method dump skipped, instructions count: 401
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.process.UMProcessDBHelper.readMainEvents(long, java.util.List):org.json.JSONObject");
    }

    public JSONObject readVersionInfoFromColumId(Integer num) {
        SQLiteDatabase sQLiteDatabase;
        JSONObject jSONObject;
        Cursor cursor = null;
        r3 = null;
        JSONObject jSONObject2 = null;
        cursor = null;
        cursor = null;
        cursor = null;
        try {
            sQLiteDatabase = c.a(this.mContext).a(com.umeng.analytics.process.a.h);
            try {
                try {
                    sQLiteDatabase.beginTransaction();
                    Cursor query = sQLiteDatabase.query(a.InterfaceC0015a.a, null, "rowid=?", new String[]{String.valueOf(num)}, null, null, null);
                    if (query != null) {
                        try {
                            try {
                                if (query.moveToNext()) {
                                    jSONObject = new JSONObject();
                                    try {
                                        String string = query.getString(query.getColumnIndex("__av"));
                                        String string2 = query.getString(query.getColumnIndex("__vc"));
                                        if (!TextUtils.isEmpty(string)) {
                                            jSONObject.put("__av", string);
                                        }
                                        if (!TextUtils.isEmpty(string2)) {
                                            jSONObject.put("__vc", string2);
                                        }
                                        jSONObject2 = jSONObject;
                                    } catch (Exception e) {
                                        e = e;
                                        cursor = query;
                                        e.printStackTrace();
                                        if (cursor != null) {
                                            try {
                                                cursor.close();
                                            } catch (Exception unused) {
                                                c.a(this.mContext).b(com.umeng.analytics.process.a.h);
                                                return jSONObject;
                                            }
                                        }
                                        if (sQLiteDatabase != null) {
                                            sQLiteDatabase.endTransaction();
                                        }
                                        c.a(this.mContext).b(com.umeng.analytics.process.a.h);
                                        return jSONObject;
                                    }
                                }
                            } catch (Exception e2) {
                                e = e2;
                                jSONObject = null;
                            }
                        } catch (Throwable th) {
                            th = th;
                            cursor = query;
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Exception unused2) {
                                    c.a(this.mContext).b(com.umeng.analytics.process.a.h);
                                    throw th;
                                }
                            }
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.endTransaction();
                            }
                            c.a(this.mContext).b(com.umeng.analytics.process.a.h);
                            throw th;
                        }
                    }
                    if (query != null) {
                        try {
                            query.close();
                        } catch (Exception unused3) {
                        }
                    }
                    sQLiteDatabase.endTransaction();
                    c.a(this.mContext).b(com.umeng.analytics.process.a.h);
                    return jSONObject2;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e3) {
                e = e3;
                jSONObject = null;
            }
        } catch (Exception e4) {
            e = e4;
            jSONObject = null;
            sQLiteDatabase = null;
        } catch (Throwable th3) {
            th = th3;
            sQLiteDatabase = null;
        }
    }
}
