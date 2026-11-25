package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.be;
import com.umeng.analytics.pro.dh;
import com.umeng.analytics.pro.dn;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: /tmp/classes2.dex */
public class f {
    public static final long a = 86400000;
    public static f b;
    private static final String c = be.b().b("id");
    private static Object j = new Object();
    private File d;
    private long f;
    private a i;
    private com.umeng.commonsdk.statistics.proto.c e = null;
    private Set<com.umeng.commonsdk.statistics.idtracking.a> h = new HashSet();
    private long g = 86400000;

    /* loaded from: /tmp/classes2.dex */
    public static class a {
        private Context a;
        private Set<String> b = new HashSet();

        public a(Context context) {
            this.a = context;
        }

        public synchronized void a() {
            try {
                if (!this.b.isEmpty()) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<String> it = this.b.iterator();
                    while (it.hasNext()) {
                        sb.append(it.next());
                        sb.append(',');
                    }
                    sb.deleteCharAt(sb.length() - 1);
                    PreferenceWrapper.getDefault(this.a).edit().putString("invld_id", sb.toString()).commit();
                }
            } catch (Throwable th) {
                throw th;
            }
        }

        public synchronized boolean a(String str) {
            return !this.b.contains(str);
        }

        public synchronized void b() {
            String[] split;
            String string = PreferenceWrapper.getDefault(this.a).getString("invld_id", null);
            if (!TextUtils.isEmpty(string) && (split = string.split(",")) != null) {
                for (String str : split) {
                    if (!TextUtils.isEmpty(str)) {
                        this.b.add(str);
                    }
                }
            }
        }

        public synchronized void b(String str) {
            this.b.add(str);
        }

        public void c(String str) {
            this.b.remove(str);
        }
    }

    public f(Context context) {
        this.i = null;
        this.d = new File(context.getFilesDir(), c);
        a aVar = new a(context);
        this.i = aVar;
        aVar.b();
    }

    public static synchronized f a(Context context) {
        f fVar;
        synchronized (f.class) {
            try {
                if (b == null) {
                    f fVar2 = new f(context);
                    b = fVar2;
                    fVar2.a(new g(context));
                    b.a(new b(context));
                    b.a(new k(context));
                    b.a(new e(context));
                    b.a(new d(context));
                    b.a(new h(context));
                    b.a(new j());
                    if (FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
                        b.a(new i(context));
                        if (DeviceConfig.isHonorDevice()) {
                            b.a(new c(context));
                        }
                    }
                    b.f();
                }
                fVar = b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return fVar;
    }

    public static synchronized void a() {
        synchronized (f.class) {
            f fVar = b;
            if (fVar != null) {
                fVar.e();
                b = null;
            }
        }
    }

    private void a(com.umeng.commonsdk.statistics.proto.c cVar) {
        Map<String, com.umeng.commonsdk.statistics.proto.b> map;
        if (cVar == null || (map = cVar.a) == null) {
            return;
        }
        if (map.containsKey("mac") && !FieldManager.allow(com.umeng.commonsdk.utils.d.h)) {
            cVar.a.remove("mac");
        }
        if (cVar.a.containsKey("imei") && !FieldManager.allow(com.umeng.commonsdk.utils.d.g)) {
            cVar.a.remove("imei");
        }
        if (cVar.a.containsKey("android_id") && !FieldManager.allow(com.umeng.commonsdk.utils.d.i)) {
            cVar.a.remove("android_id");
        }
        if (cVar.a.containsKey("serial") && !FieldManager.allow(com.umeng.commonsdk.utils.d.j)) {
            cVar.a.remove("serial");
        }
        if (cVar.a.containsKey("idfa") && !FieldManager.allow(com.umeng.commonsdk.utils.d.w)) {
            cVar.a.remove("idfa");
        }
        if (!cVar.a.containsKey("oaid") || FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
            return;
        }
        cVar.a.remove("oaid");
    }

    private boolean a(com.umeng.commonsdk.statistics.idtracking.a aVar) {
        if (this.i.a(aVar.b())) {
            return this.h.add(aVar);
        }
        if (!AnalyticsConstants.UM_DEBUG) {
            return false;
        }
        MLog.w("invalid domain: " + aVar.b());
        return false;
    }

    private void b(com.umeng.commonsdk.statistics.proto.c cVar) {
        byte[] a2;
        synchronized (j) {
            if (cVar != null) {
                try {
                    synchronized (this) {
                        a(cVar);
                        a2 = new dn().a(cVar);
                    }
                    if (a2 != null) {
                        HelperUtils.writeFile(this.d, a2);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private synchronized void h() {
        try {
            com.umeng.commonsdk.statistics.proto.c cVar = new com.umeng.commonsdk.statistics.proto.c();
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.h) {
                if (aVar.c()) {
                    if (aVar.d() != null) {
                        hashMap.put(aVar.b(), aVar.d());
                    }
                    if (aVar.e() != null && !aVar.e().isEmpty()) {
                        arrayList.addAll(aVar.e());
                    }
                }
            }
            cVar.a(arrayList);
            cVar.a(hashMap);
            synchronized (this) {
                this.e = cVar;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private com.umeng.commonsdk.statistics.proto.c i() {
        FileInputStream fileInputStream;
        synchronized (j) {
            FileInputStream fileInputStream2 = null;
            if (!this.d.exists()) {
                return null;
            }
            try {
                fileInputStream = new FileInputStream(this.d);
                try {
                    try {
                        byte[] readStreamToByteArray = HelperUtils.readStreamToByteArray(fileInputStream);
                        com.umeng.commonsdk.statistics.proto.c cVar = new com.umeng.commonsdk.statistics.proto.c();
                        new dh().a(cVar, readStreamToByteArray);
                        HelperUtils.safeClose(fileInputStream);
                        return cVar;
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        HelperUtils.safeClose(fileInputStream);
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    HelperUtils.safeClose(fileInputStream2);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                HelperUtils.safeClose(fileInputStream2);
                throw th;
            }
        }
    }

    public void a(long j2) {
        this.g = j2;
    }

    public synchronized void b() {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f >= this.g) {
                boolean z = false;
                for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.h) {
                    if (aVar.c() && aVar.a()) {
                        if (!aVar.c()) {
                            this.i.b(aVar.b());
                        }
                        z = true;
                    }
                }
                if (z) {
                    h();
                    this.i.a();
                    g();
                }
                this.f = currentTimeMillis;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized com.umeng.commonsdk.statistics.proto.c c() {
        return this.e;
    }

    public String d() {
        return null;
    }

    public synchronized void e() {
        try {
            if (b == null) {
                return;
            }
            boolean z = false;
            for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.h) {
                if (aVar.c() && aVar.e() != null && !aVar.e().isEmpty()) {
                    aVar.a((List<com.umeng.commonsdk.statistics.proto.a>) null);
                    z = true;
                }
            }
            if (z) {
                com.umeng.commonsdk.statistics.proto.c cVar = this.e;
                if (cVar != null) {
                    cVar.b(false);
                }
                g();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void f() {
        com.umeng.commonsdk.statistics.proto.c i = i();
        if (i == null) {
            return;
        }
        a(i);
        ArrayList arrayList = new ArrayList(this.h.size());
        synchronized (this) {
            try {
                this.e = i;
                for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.h) {
                    aVar.a(this.e);
                    if (!aVar.c()) {
                        arrayList.add(aVar);
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    this.h.remove((com.umeng.commonsdk.statistics.idtracking.a) it.next());
                }
                h();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public synchronized void g() {
        com.umeng.commonsdk.statistics.proto.c cVar = this.e;
        if (cVar != null) {
            b(cVar);
        }
    }
}
