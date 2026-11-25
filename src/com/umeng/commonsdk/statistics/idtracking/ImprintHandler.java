package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.umeng.analytics.pro.be;
import com.umeng.analytics.pro.bv;
import com.umeng.analytics.pro.dn;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback;
import com.umeng.commonsdk.statistics.internal.UMImprintPreProcessCallback;
import com.umeng.commonsdk.utils.FileLockCallback;
import com.umeng.commonsdk.utils.FileLockUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: /tmp/classes2.dex */
public class ImprintHandler implements FileLockCallback {
    private static final String a = "ImprintHandler";
    private static Context k = null;
    private static FileLockUtil l = null;
    private static final int m = 0;
    private static final int n = 1;
    private com.umeng.commonsdk.statistics.internal.d e;
    private a h = new a();
    private com.umeng.commonsdk.statistics.proto.d i = null;
    private static Object b = new Object();
    private static final String c = be.b().b(be.c);
    private static final byte[] d = "pbl0".getBytes();
    private static Map<String, ArrayList<UMImprintChangeCallback>> f = new HashMap();
    private static Object g = new Object();
    private static ImprintHandler j = null;
    private static Map<String, UMImprintPreProcessCallback> o = new HashMap();
    private static Object p = new Object();

    /* loaded from: /tmp/classes2.dex */
    public static class a {
        private Map<String, String> a = new HashMap();

        public a() {
        }

        public a(com.umeng.commonsdk.statistics.proto.d dVar) {
            a(dVar);
        }

        private synchronized void b(com.umeng.commonsdk.statistics.proto.d dVar) {
            com.umeng.commonsdk.statistics.proto.e eVar;
            if (dVar != null) {
                if (dVar.e()) {
                    Map<String, com.umeng.commonsdk.statistics.proto.e> c = dVar.c();
                    for (String str : c.keySet()) {
                        if (!TextUtils.isEmpty(str) && (eVar = c.get(str)) != null) {
                            String b = eVar.b();
                            if (!TextUtils.isEmpty(b)) {
                                this.a.put(str, b);
                                if (AnalyticsConstants.UM_DEBUG) {
                                    Log.i(ImprintHandler.a, "imKey is " + str + ", imValue is " + b);
                                }
                            }
                        }
                    }
                }
            }
        }

        public synchronized String a(String str, String str2) {
            if (!TextUtils.isEmpty(str) && this.a.size() > 0) {
                String str3 = this.a.get(str);
                return !TextUtils.isEmpty(str3) ? str3 : str2;
            }
            return str2;
        }

        public void a(com.umeng.commonsdk.statistics.proto.d dVar) {
            if (dVar == null) {
                return;
            }
            b(dVar);
        }

        public synchronized void a(String str) {
            Map<String, String> map = this.a;
            if (map != null && map.size() > 0 && !TextUtils.isEmpty(str) && this.a.containsKey(str)) {
                this.a.remove(str);
            }
        }
    }

    private ImprintHandler(Context context) {
        k = context.getApplicationContext();
    }

    private com.umeng.commonsdk.statistics.proto.d a(com.umeng.commonsdk.statistics.proto.d dVar, com.umeng.commonsdk.statistics.proto.d dVar2, Map<String, String> map) {
        UMImprintPreProcessCallback uMImprintPreProcessCallback;
        ArrayList<UMImprintChangeCallback> arrayList;
        if (dVar2 == null) {
            return dVar;
        }
        Map<String, com.umeng.commonsdk.statistics.proto.e> c2 = dVar.c();
        for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar2.c().entrySet()) {
            int i = 0;
            if (entry.getValue().d()) {
                String key = entry.getKey();
                String str = entry.getValue().a;
                synchronized (p) {
                    try {
                        if (!TextUtils.isEmpty(key) && o.containsKey(key) && (uMImprintPreProcessCallback = o.get(key)) != null && uMImprintPreProcessCallback.onPreProcessImprintKey(key, str)) {
                            i = 1;
                        }
                    } finally {
                    }
                }
                if (i == 0) {
                    c2.put(entry.getKey(), entry.getValue());
                    synchronized (g) {
                        try {
                            if (!TextUtils.isEmpty(key) && f.containsKey(key) && f.get(key) != null) {
                                map.put(key, str);
                            }
                        } finally {
                        }
                    }
                } else {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> merge: [" + key + "] should be ignored.");
                }
            } else {
                String key2 = entry.getKey();
                synchronized (g) {
                    try {
                        if (!TextUtils.isEmpty(key2) && f.containsKey(key2) && (arrayList = f.get(key2)) != null) {
                            while (i < arrayList.size()) {
                                arrayList.get(i).onImprintValueChanged(key2, null);
                                i++;
                            }
                        }
                    } finally {
                    }
                }
                c2.remove(key2);
                this.h.a(key2);
            }
        }
        dVar.a(dVar2.f());
        dVar.a(a(dVar));
        return dVar;
    }

    private void a(File file) {
        if (this.i == null) {
            return;
        }
        try {
            synchronized (b) {
                try {
                    byte[] a2 = new dn().a(this.i);
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    try {
                        fileOutputStream.write(a2);
                        fileOutputStream.flush();
                    } finally {
                        HelperUtils.safeClose(fileOutputStream);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void a(String str, UMImprintChangeCallback uMImprintChangeCallback) {
        synchronized (g) {
            try {
                int i = 0;
                if (f.containsKey(str)) {
                    ArrayList<UMImprintChangeCallback> arrayList = f.get(str);
                    int size = arrayList.size();
                    ULog.i("--->>> addCallback: before add: callbacks size is: " + size);
                    while (i < size) {
                        if (uMImprintChangeCallback == arrayList.get(i)) {
                            ULog.i("--->>> addCallback: callback has exist, just exit");
                            return;
                        }
                        i++;
                    }
                    arrayList.add(uMImprintChangeCallback);
                    ULog.i("--->>> addCallback: after add: callbacks size is: " + arrayList.size());
                } else {
                    ArrayList<UMImprintChangeCallback> arrayList2 = new ArrayList<>();
                    int size2 = arrayList2.size();
                    ULog.i("--->>> addCallback: before add: callbacks size is: " + size2);
                    while (i < size2) {
                        if (uMImprintChangeCallback == arrayList2.get(i)) {
                            ULog.i("--->>> addCallback: callback has exist, just exit");
                            return;
                        }
                        i++;
                    }
                    arrayList2.add(uMImprintChangeCallback);
                    ULog.i("--->>> addCallback: after add: callbacks size is: " + arrayList2.size());
                    f.put(str, arrayList2);
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(k, th);
            }
        }
    }

    private boolean a(String str, String str2) {
        return str == null ? str2 == null : str.equals(str2);
    }

    private static void b(String str, UMImprintChangeCallback uMImprintChangeCallback) {
        if (TextUtils.isEmpty(str) || uMImprintChangeCallback == null) {
            return;
        }
        synchronized (g) {
            try {
                if (f.containsKey(str)) {
                    ArrayList<UMImprintChangeCallback> arrayList = f.get(str);
                    if (arrayList.size() > 0) {
                        int size = arrayList.size();
                        ULog.i("--->>> removeCallback: before remove: callbacks size is: " + size);
                        int i = 0;
                        while (true) {
                            if (i >= size) {
                                break;
                            }
                            if (uMImprintChangeCallback == arrayList.get(i)) {
                                ULog.i("--->>> removeCallback: remove index " + i);
                                arrayList.remove(i);
                                break;
                            }
                            i++;
                        }
                        ULog.i("--->>> removeCallback: after remove: callbacks size is: " + arrayList.size());
                        if (arrayList.size() == 0) {
                            ULog.i("--->>> removeCallback: remove key from map: key = " + str);
                            f.remove(str);
                        }
                    }
                }
            } finally {
            }
        }
    }

    private boolean c(com.umeng.commonsdk.statistics.proto.d dVar) {
        if (!dVar.i().equals(a(dVar))) {
            return false;
        }
        for (com.umeng.commonsdk.statistics.proto.e eVar : dVar.c().values()) {
            String h = eVar.h();
            if (!TextUtils.isEmpty(h)) {
                byte[] reverseHexString = DataHelper.reverseHexString(h);
                byte[] a2 = a(eVar);
                for (int i = 0; i < 4; i++) {
                    if (reverseHexString[i] != a2[i]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private com.umeng.commonsdk.statistics.proto.d d(com.umeng.commonsdk.statistics.proto.d dVar) {
        Map<String, com.umeng.commonsdk.statistics.proto.e> c2 = dVar.c();
        if (c2.containsKey(bv.f)) {
            c2.remove(bv.f);
            this.h.a(bv.f);
            dVar.a(dVar.f());
            dVar.a(a(dVar));
        }
        return dVar;
    }

    private com.umeng.commonsdk.statistics.proto.d e(com.umeng.commonsdk.statistics.proto.d dVar) {
        ArrayList<UMImprintChangeCallback> arrayList;
        boolean z;
        ArrayList<UMImprintChangeCallback> arrayList2;
        UMImprintPreProcessCallback uMImprintPreProcessCallback;
        Map<String, com.umeng.commonsdk.statistics.proto.e> c2 = dVar.c();
        ArrayList<String> arrayList3 = new ArrayList(c2.size() / 2);
        Iterator<Map.Entry<String, com.umeng.commonsdk.statistics.proto.e>> it = c2.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> next = it.next();
            if (next.getValue().d()) {
                String key = next.getKey();
                String str = next.getValue().a;
                synchronized (p) {
                    try {
                        z = !TextUtils.isEmpty(key) && o.containsKey(key) && (uMImprintPreProcessCallback = o.get(key)) != null && uMImprintPreProcessCallback.onPreProcessImprintKey(key, str);
                    } finally {
                    }
                }
                if (z) {
                    arrayList3.add(key);
                }
                synchronized (g) {
                    try {
                        if (!TextUtils.isEmpty(key) && f.containsKey(key) && (arrayList2 = f.get(key)) != null) {
                            for (int i = 0; i < arrayList2.size(); i++) {
                                arrayList2.get(i).onImprintValueChanged(key, str);
                            }
                        }
                    } finally {
                    }
                }
            } else {
                arrayList3.add(next.getKey());
            }
        }
        for (String str2 : arrayList3) {
            synchronized (g) {
                try {
                    if (!TextUtils.isEmpty(str2) && f.containsKey(str2) && (arrayList = f.get(str2)) != null) {
                        for (int i2 = 0; i2 < arrayList.size(); i2++) {
                            arrayList.get(i2).onImprintValueChanged(str2, null);
                        }
                    }
                } finally {
                }
            }
            c2.remove(str2);
        }
        return dVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0038 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void e() {
        /*
            r4 = this;
            java.io.File r0 = new java.io.File
            android.content.Context r1 = com.umeng.commonsdk.statistics.idtracking.ImprintHandler.k
            java.io.File r1 = r1.getFilesDir()
            java.lang.String r2 = com.umeng.commonsdk.statistics.idtracking.ImprintHandler.c
            r0.<init>(r1, r2)
            java.lang.Object r1 = com.umeng.commonsdk.statistics.idtracking.ImprintHandler.b
            monitor-enter(r1)
            boolean r0 = r0.exists()     // Catch: java.lang.Throwable -> L18
            if (r0 != 0) goto L1a
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L18
            return
        L18:
            r4 = move-exception
            goto L5f
        L1a:
            r0 = 0
            android.content.Context r3 = com.umeng.commonsdk.statistics.idtracking.ImprintHandler.k     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L30
            java.io.FileInputStream r2 = r3.openFileInput(r2)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L30
            byte[] r0 = com.umeng.commonsdk.statistics.common.HelperUtils.readStreamToByteArray(r2)     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L2c
        L25:
            com.umeng.commonsdk.statistics.common.HelperUtils.safeClose(r2)     // Catch: java.lang.Throwable -> L18
            goto L36
        L29:
            r4 = move-exception
            r0 = r2
            goto L5b
        L2c:
            r3 = move-exception
            goto L32
        L2e:
            r4 = move-exception
            goto L5b
        L30:
            r3 = move-exception
            r2 = r0
        L32:
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L29
            goto L25
        L36:
            if (r0 == 0) goto L59
            com.umeng.commonsdk.statistics.proto.d r2 = new com.umeng.commonsdk.statistics.proto.d     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L55
            r2.<init>()     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L55
            com.umeng.analytics.pro.dh r3 = new com.umeng.analytics.pro.dh     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L55
            r3.<init>()     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L55
            r3.a(r2, r0)     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L55
            r4.i = r2     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L55
            com.umeng.commonsdk.statistics.idtracking.ImprintHandler$a r0 = r4.h     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L55
            r0.a(r2)     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L55
            com.umeng.commonsdk.statistics.proto.d r0 = r4.i     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L55
            com.umeng.commonsdk.statistics.proto.d r0 = r4.d(r0)     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L55
            r4.i = r0     // Catch: java.lang.Throwable -> L18 java.lang.Exception -> L55
            goto L59
        L55:
            r4 = move-exception
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L18
        L59:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L18
            return
        L5b:
            com.umeng.commonsdk.statistics.common.HelperUtils.safeClose(r0)     // Catch: java.lang.Throwable -> L18
            throw r4     // Catch: java.lang.Throwable -> L18
        L5f:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L18
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.idtracking.ImprintHandler.e():void");
    }

    public static synchronized ImprintHandler getImprintService(Context context) {
        ImprintHandler imprintHandler;
        synchronized (ImprintHandler.class) {
            try {
                if (j == null) {
                    j = new ImprintHandler(context);
                    l = new FileLockUtil();
                    l.doFileOperateion(new File(k.getFilesDir(), c), j, 0);
                }
                imprintHandler = j;
            } catch (Throwable th) {
                throw th;
            }
        }
        return imprintHandler;
    }

    public String a(com.umeng.commonsdk.statistics.proto.d dVar) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : new TreeMap(dVar.c()).entrySet()) {
            sb.append((String) entry.getKey());
            if (((com.umeng.commonsdk.statistics.proto.e) entry.getValue()).d()) {
                sb.append(((com.umeng.commonsdk.statistics.proto.e) entry.getValue()).b());
            }
        }
        sb.append(dVar.b);
        return HelperUtils.MD5(sb.toString()).toLowerCase(Locale.US);
    }

    public void a(com.umeng.commonsdk.statistics.internal.d dVar) {
        this.e = dVar;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (p) {
            try {
                if (o.containsKey(str)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> unregistPreProcessCallback: unregist [" + str + "] success.");
                    f.remove(str);
                } else {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> unregistPreProcessCallback: can't find [" + str + "], pls regist first.");
                }
            } finally {
            }
        }
    }

    public byte[] a() {
        try {
            synchronized (this) {
                try {
                    com.umeng.commonsdk.statistics.proto.d dVar = this.i;
                    if (dVar == null) {
                        return null;
                    }
                    if (dVar.b() <= 0) {
                        return null;
                    }
                    return new dn().a(this.i);
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable th2) {
            UMCrashManager.reportCrash(k, th2);
            return null;
        }
    }

    public byte[] a(com.umeng.commonsdk.statistics.proto.e eVar) {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(null);
        allocate.putLong(eVar.e());
        byte[] array = allocate.array();
        byte[] bArr = d;
        byte[] bArr2 = new byte[4];
        for (int i = 0; i < 4; i++) {
            bArr2[i] = (byte) (array[i] ^ bArr[i]);
        }
        return bArr2;
    }

    public synchronized com.umeng.commonsdk.statistics.proto.d b() {
        return this.i;
    }

    public void b(com.umeng.commonsdk.statistics.proto.d dVar) {
        boolean a2;
        if (dVar == null) {
            if (AnalyticsConstants.UM_DEBUG) {
                UMRTLog.d(UMRTLog.RTLOG_TAG, "Imprint is null");
                return;
            }
            return;
        }
        if (!c(dVar)) {
            if (AnalyticsConstants.UM_DEBUG) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "Imprint is not valid");
                return;
            }
            return;
        }
        String str = AnalyticsConstants.OS;
        HashMap hashMap = new HashMap();
        synchronized (this) {
            try {
                com.umeng.commonsdk.statistics.proto.d dVar2 = this.i;
                com.umeng.commonsdk.statistics.proto.d d2 = d(dVar);
                String str2 = null;
                String i = dVar2 == null ? null : dVar2.i();
                com.umeng.commonsdk.statistics.proto.d e = dVar2 == null ? e(d2) : a(dVar2, d2, hashMap);
                this.i = e;
                if (e != null) {
                    str2 = e.i();
                }
                a2 = a(i, str2);
            } finally {
            }
        }
        com.umeng.commonsdk.statistics.proto.d dVar3 = this.i;
        if (dVar3 != null && !a2) {
            this.h.a(dVar3);
            com.umeng.commonsdk.statistics.internal.d dVar4 = this.e;
            if (dVar4 != null) {
                dVar4.onImprintChanged(this.h);
            }
        }
        if (hashMap.size() > 0) {
            synchronized (g) {
                try {
                    for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                        String key = entry.getKey();
                        String value = entry.getValue();
                        if (!TextUtils.isEmpty(key) && f.containsKey(key)) {
                            ULog.i("--->>> target imprint key is: " + key + "; value is: " + value);
                            ArrayList<UMImprintChangeCallback> arrayList = f.get(key);
                            if (arrayList != null) {
                                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                                    arrayList.get(i2).onImprintValueChanged(key, value);
                                }
                            }
                        }
                    }
                } finally {
                }
            }
        }
    }

    public a c() {
        return this.h;
    }

    public void d() {
        if (this.i == null || l == null) {
            return;
        }
        File file = new File(k.getFilesDir(), c);
        if (!file.exists()) {
            try {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    UMCrashManager.reportCrash(k, e);
                }
            } catch (IOException unused) {
                file.createNewFile();
            }
        }
        l.doFileOperateion(file, j, 1);
    }

    @Override // com.umeng.commonsdk.utils.FileLockCallback
    public boolean onFileLock(File file, int i) {
        if (i == 0) {
            j.e();
        } else if (i == 1) {
            j.a(file);
        }
        return true;
    }

    @Override // com.umeng.commonsdk.utils.FileLockCallback
    public boolean onFileLock(String str) {
        return false;
    }

    @Override // com.umeng.commonsdk.utils.FileLockCallback
    public boolean onFileLock(String str, Object obj) {
        return false;
    }

    public void registImprintCallback(String str, UMImprintChangeCallback uMImprintChangeCallback) {
        if (TextUtils.isEmpty(str) || uMImprintChangeCallback == null) {
            return;
        }
        a(str, uMImprintChangeCallback);
    }

    public void registPreProcessCallback(String str, UMImprintPreProcessCallback uMImprintPreProcessCallback) {
        if (TextUtils.isEmpty(str) || uMImprintPreProcessCallback == null) {
            return;
        }
        synchronized (p) {
            try {
                if (o.containsKey(str)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> key : " + str + " PreProcesser has registed!");
                } else {
                    o.put(str, uMImprintPreProcessCallback);
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> registPreProcessCallback: key : " + str + " regist success.");
                }
            } finally {
            }
        }
    }

    public void unregistImprintCallback(String str, UMImprintChangeCallback uMImprintChangeCallback) {
        if (TextUtils.isEmpty(str) || uMImprintChangeCallback == null) {
            return;
        }
        b(str, uMImprintChangeCallback);
    }
}
