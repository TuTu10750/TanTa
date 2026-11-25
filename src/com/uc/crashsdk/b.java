package com.uc.crashsdk;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.util.Log;
import com.uc.crashsdk.a.h;
import defpackage.jr4;
import java.io.File;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.WeakHashMap;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: /tmp/classes2.dex */
public class b {
    private static boolean A = false;
    private static boolean B = false;
    private static boolean C = false;
    private static boolean D = false;
    private static boolean E = false;
    private static boolean F = false;
    private static String H = null;
    private static int I = 0;
    private static boolean J = false;
    private static boolean K = false;
    private static boolean L = true;
    private static RandomAccessFile M = null;
    private static boolean N = false;
    private static String P = null;
    private static boolean Q = false;
    private static volatile Object[] R = null;
    public static boolean a = false;
    public static boolean b = false;
    public static boolean c = false;
    public static boolean d = false;
    public static boolean f = false;
    public static boolean g = true;
    public static boolean h = false;
    static final /* synthetic */ boolean i = true;
    private static String j = null;
    private static String k = null;
    private static String l = null;
    private static String m = null;
    private static String n = null;
    private static String o = null;
    private static String p = null;
    private static String q = null;
    private static String r = null;
    private static String s = null;
    private static String t = null;
    private static String u = null;
    private static String v = null;
    private static String w = null;
    private static boolean x = false;
    private static boolean y = false;
    private static volatile boolean z = false;
    public static final Object e = new Object();
    private static final Object G = new Object();
    private static final Object O = new Object();
    private static Runnable S = new com.uc.crashsdk.a.e(101);
    private static boolean T = false;
    private static long U = 0;
    private static final Object V = new Object();
    private static long W = 0;
    private static boolean X = false;
    private static boolean Y = false;
    private static boolean Z = false;
    private static long aa = 0;
    private static final WeakHashMap<Activity, Integer> ab = new WeakHashMap<>();
    private static boolean ac = false;
    private static String ad = null;
    private static boolean ae = false;
    private static boolean af = false;
    private static boolean ag = false;
    private static boolean ah = false;
    private static boolean ai = false;
    private static final Object aj = new Object();
    private static PendingIntent ak = null;

    public static boolean A() {
        return Y || !ad();
    }

    public static boolean B() {
        return Y && !x;
    }

    public static void C() {
        com.uc.crashsdk.a.f.a(2, new com.uc.crashsdk.a.e(100));
    }

    public static void D() {
        String str;
        if (!d || (str = ad) == null) {
            return;
        }
        JNIBridge.set(129, str);
    }

    public static String E() {
        String str = ad;
        return str == null ? "" : str;
    }

    public static boolean F() {
        if (!ae) {
            if (!com.uc.crashsdk.a.g.a(a.a) && a.a.equals(e.h())) {
                af = true;
                if (d) {
                    JNIBridge.set(2, true);
                }
            }
            ae = true;
        }
        return af;
    }

    public static void G() {
        ag = true;
        if (d) {
            JNIBridge.set(34, true);
        }
    }

    public static boolean H() {
        return ag;
    }

    public static int I() {
        boolean U2 = U();
        return t() ? U2 ? 3 : 6 : s() ? U2 ? 2 : 5 : U2 ? 4 : 1;
    }

    public static int J() {
        boolean V2 = V();
        boolean W2 = W();
        boolean X2 = X();
        if (t()) {
            if (V2) {
                return 12;
            }
            if (W2) {
                return 14;
            }
            return X2 ? 16 : 98;
        }
        if (!s()) {
            return 1;
        }
        if (V2) {
            return 11;
        }
        if (W2) {
            return 13;
        }
        return X2 ? 15 : 97;
    }

    public static void K() {
        if (d) {
            JNIBridge.nativeSet(27, I, "12", null);
            JNIBridge.set(30, L);
        }
    }

    public static boolean L() {
        if (!ai) {
            synchronized (aj) {
                try {
                    if (!ai) {
                        ah = ae();
                        ai = true;
                    }
                } finally {
                }
            }
        }
        return ah;
    }

    public static void M() {
        if (e.F() || L() || ak != null || g.h() < 0) {
            return;
        }
        try {
            Context a2 = com.uc.crashsdk.a.g.a();
            Intent launchIntentForPackage = a2.getPackageManager().getLaunchIntentForPackage(a2.getPackageName());
            launchIntentForPackage.addFlags(335544320);
            ak = PendingIntent.getActivity(a2, 0, launchIntentForPackage, 0);
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    public static boolean N() {
        if (ak == null) {
            com.uc.crashsdk.a.a.b("Restart intent is null!");
            return false;
        }
        try {
            com.uc.crashsdk.a.a.a("crashsdk", "restarting ...");
            ((AlarmManager) com.uc.crashsdk.a.g.a().getSystemService("alarm")).set(1, System.currentTimeMillis() + 200, ak);
            return true;
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return false;
        }
    }

    public static /* synthetic */ boolean O() {
        ac = true;
        return true;
    }

    private static String Q() {
        if (j == null) {
            j = d("ss");
        }
        return j;
    }

    private static String R() {
        if (l == null) {
            l = d("ctn");
        }
        return l;
    }

    private static String S() {
        if (m == null) {
            m = d("cta");
        }
        return m;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:13|(10:17|18|(1:24)|25|26|(1:28)|30|31|32|33)|36|18|(2:20|24)|25|26|(0)|30|31|32|33) */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0077, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0078, code lost:
    
        com.uc.crashsdk.a.g.a(r1);
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0073 A[Catch: all -> 0x0077, TRY_LEAVE, TryCatch #1 {all -> 0x0077, blocks: (B:26:0x006d, B:28:0x0073), top: B:25:0x006d, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void T() {
        /*
            boolean r0 = com.uc.crashsdk.b.z
            if (r0 != 0) goto L81
            boolean r0 = com.uc.crashsdk.b.y
            if (r0 == 0) goto La
            goto L81
        La:
            java.lang.Object r0 = com.uc.crashsdk.b.G
            monitor-enter(r0)
            boolean r1 = com.uc.crashsdk.b.z     // Catch: java.lang.Throwable -> L13
            if (r1 == 0) goto L15
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L13
            return
        L13:
            r1 = move-exception
            goto L7f
        L15:
            java.lang.String r1 = com.uc.crashsdk.g.X()     // Catch: java.lang.Throwable -> L13
            f(r1)     // Catch: java.lang.Throwable -> L13
            java.lang.String r1 = p()     // Catch: java.lang.Throwable -> L13
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L13
            java.lang.String r3 = b()     // Catch: java.lang.Throwable -> L13
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L13
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L13
            java.lang.String r4 = R()     // Catch: java.lang.Throwable -> L13
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L13
            java.lang.String r4 = "f"
            boolean r4 = r4.equals(r1)     // Catch: java.lang.Throwable -> L13
            com.uc.crashsdk.b.A = r4     // Catch: java.lang.Throwable -> L13
            java.lang.String r4 = "b"
            boolean r1 = r4.equals(r1)     // Catch: java.lang.Throwable -> L13
            com.uc.crashsdk.b.B = r1     // Catch: java.lang.Throwable -> L13
            boolean r1 = r2.exists()     // Catch: java.lang.Throwable -> L13
            com.uc.crashsdk.b.D = r1     // Catch: java.lang.Throwable -> L13
            boolean r1 = r3.exists()     // Catch: java.lang.Throwable -> L13
            com.uc.crashsdk.b.E = r1     // Catch: java.lang.Throwable -> L13
            boolean r2 = com.uc.crashsdk.b.D     // Catch: java.lang.Throwable -> L13
            r3 = 1
            if (r2 != 0) goto L58
            if (r1 == 0) goto L56
            goto L58
        L56:
            r1 = 0
            goto L59
        L58:
            r1 = r3
        L59:
            com.uc.crashsdk.b.C = r1     // Catch: java.lang.Throwable -> L13
            if (r1 != 0) goto L6d
            boolean r1 = com.uc.crashsdk.b.A     // Catch: java.lang.Throwable -> L13
            if (r1 != 0) goto L65
            boolean r1 = com.uc.crashsdk.b.B     // Catch: java.lang.Throwable -> L13
            if (r1 == 0) goto L6d
        L65:
            boolean r1 = r()     // Catch: java.lang.Throwable -> L13
            com.uc.crashsdk.b.F = r1     // Catch: java.lang.Throwable -> L13
            com.uc.crashsdk.b.C = r1     // Catch: java.lang.Throwable -> L13
        L6d:
            boolean r1 = z()     // Catch: java.lang.Throwable -> L77
            if (r1 == 0) goto L7b
            Z()     // Catch: java.lang.Throwable -> L77
            goto L7b
        L77:
            r1 = move-exception
            com.uc.crashsdk.a.g.a(r1)     // Catch: java.lang.Throwable -> L13
        L7b:
            com.uc.crashsdk.b.z = r3     // Catch: java.lang.Throwable -> L13
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L13
            goto L81
        L7f:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L13
            throw r1
        L81:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.b.T():void");
    }

    private static boolean U() {
        T();
        return C;
    }

    private static boolean V() {
        T();
        return D;
    }

    private static boolean W() {
        T();
        return E;
    }

    private static boolean X() {
        T();
        return F;
    }

    private static void Y() {
        if (d) {
            JNIBridge.set(26, x);
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0042 -> B:13:0x0045). Please report as a decompilation issue!!! */
    private static void Z() {
        if (!T) {
            T = true;
            try {
                new File(b()).delete();
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
            try {
                new File(R()).delete();
            } catch (Throwable th2) {
                com.uc.crashsdk.a.g.a(th2);
            }
            try {
                if (d) {
                    JNIBridge.cmd(16);
                } else {
                    new File(S()).delete();
                }
            } catch (Throwable th3) {
                com.uc.crashsdk.a.g.a(th3);
            }
        }
        Object[] ab2 = ab();
        if (!ab2[0].equals(P) && R == null) {
            a(ab2);
        } else {
            Q = true;
            aa();
        }
    }

    private static Object a(Object obj, Class<?> cls, String str) {
        if (obj == null) {
            return null;
        }
        if (cls == null) {
            cls = obj.getClass();
        }
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return null;
        }
    }

    public static String a() {
        String str = H;
        if (str != null) {
            return str;
        }
        String h2 = e.h();
        if (com.uc.crashsdk.a.g.a(h2)) {
            H = "LLUN";
        } else {
            int i2 = 0;
            if (h2.length() > 48) {
                int length = h2.length() - 48;
                h2 = h2.substring(0, 48);
                i2 = length;
            }
            StringBuilder sb = new StringBuilder();
            byte[] bytes = h2.getBytes();
            for (int length2 = bytes.length - 1; length2 >= 0; length2--) {
                byte b2 = bytes[length2];
                if (b2 == 46) {
                    sb.append('0');
                } else if (b2 == 58) {
                    sb.append('1');
                } else if (b2 >= 97 && b2 <= 122) {
                    sb.append((char) (b2 - 32));
                } else if (b2 >= 65 && b2 <= 90) {
                    sb.append((char) b2);
                } else if (b2 < 48 || b2 > 57) {
                    sb.append('2');
                } else {
                    sb.append((char) b2);
                }
            }
            if (i2 > 0) {
                sb.append(String.valueOf(i2));
            }
            H = sb.toString();
        }
        return H;
    }

    public static String a(String str) {
        if (str == null || str.length() <= 0 || !str.endsWith(".st")) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(".st");
        if (!i && lastIndexOf < 0) {
            jr4.a();
            return null;
        }
        String substring = str.substring(0, lastIndexOf);
        if (substring.length() <= 0) {
            return null;
        }
        return substring.concat(".stcb");
    }

    public static void a(int i2) {
        Object a2;
        Activity activity;
        int i3;
        boolean z2 = false;
        switch (i2) {
            case 100:
                Object ac2 = ac();
                if (ac2 == null || (a2 = a(ac2, (Class<?>) null, "mActivities")) == null) {
                    return;
                }
                try {
                    Iterator it = ((Map) a2).entrySet().iterator();
                    boolean z3 = false;
                    while (it.hasNext()) {
                        Object value = ((Map.Entry) it.next()).getValue();
                        if (value != null && (activity = (Activity) a(value, (Class<?>) null, "activity")) != null) {
                            boolean booleanValue = ((Boolean) a(value, (Class<?>) null, "paused")).booleanValue();
                            boolean booleanValue2 = ((Boolean) a(value, (Class<?>) null, "stopped")).booleanValue();
                            WeakHashMap<Activity, Integer> weakHashMap = ab;
                            synchronized (weakHashMap) {
                                if (booleanValue || booleanValue2) {
                                    i3 = 2;
                                } else {
                                    i3 = 1;
                                    z3 = true;
                                }
                                weakHashMap.put(activity, Integer.valueOf(i3));
                            }
                        }
                        z2 = true;
                    }
                    if (z2) {
                        b(z3);
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    com.uc.crashsdk.a.g.a(th);
                    return;
                }
            case 101:
                try {
                    boolean exists = new File(Q()).exists();
                    N = !exists;
                    if (!exists || Q) {
                        a(ab());
                        Q = false;
                        return;
                    }
                    return;
                } catch (Throwable th2) {
                    com.uc.crashsdk.a.g.a(th2);
                    return;
                }
            case 102:
                com.uc.crashsdk.a.f.a(1, new com.uc.crashsdk.a.e(103));
                return;
            case 103:
                try {
                    com.uc.crashsdk.a.g.a(new File(S()));
                    return;
                } catch (Throwable th3) {
                    com.uc.crashsdk.a.g.a(th3);
                    return;
                }
            case 104:
                h.d();
                f.a(102);
                if (F()) {
                    e.C();
                    return;
                }
                return;
            default:
                if (i) {
                    return;
                }
                jr4.a();
                return;
        }
    }

    public static void a(boolean z2) {
        L = z2;
        if (d) {
            JNIBridge.set(30, z2);
        }
    }

    private static void a(Object[] objArr) {
        R = objArr;
        synchronized (O) {
            try {
                String str = (String) objArr[0];
                Long l2 = (Long) objArr[1];
                long longValue = l2.longValue();
                if (longValue < U) {
                    com.uc.crashsdk.a.a.c("crashsdk", String.format(Locale.US, "Update state generation %d, last is: %d", l2, Long.valueOf(U)));
                    return;
                }
                U = longValue;
                String Q2 = Q();
                if (d) {
                    RandomAccessFile randomAccessFile = M;
                    if (randomAccessFile != null) {
                        com.uc.crashsdk.a.g.a(randomAccessFile);
                        M = null;
                    }
                    boolean nativeChangeState = JNIBridge.nativeChangeState(Q2, str, N);
                    N = false;
                    if (!nativeChangeState) {
                        com.uc.crashsdk.a.a.b("write state failed: " + str);
                    }
                } else {
                    RandomAccessFile randomAccessFile2 = M;
                    if (randomAccessFile2 == null || N) {
                        if (randomAccessFile2 != null) {
                            com.uc.crashsdk.a.g.a(randomAccessFile2);
                            M = null;
                        }
                        try {
                            RandomAccessFile randomAccessFile3 = new RandomAccessFile(Q2, "rw");
                            M = randomAccessFile3;
                            randomAccessFile3.seek(0L);
                            N = false;
                        } catch (Exception e2) {
                            com.uc.crashsdk.a.g.a(e2);
                        }
                    }
                    try {
                        M.write(str.getBytes());
                        M.seek(0L);
                    } catch (Exception e3) {
                        com.uc.crashsdk.a.g.a(e3);
                    }
                }
                P = str;
                R = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean a(Context context) {
        try {
            ((Application) context).registerActivityLifecycleCallbacks(new c());
            if (!g.M()) {
                return true;
            }
            C();
            return true;
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return false;
        }
    }

    public static boolean a(Object obj, String str, com.uc.crashsdk.a.e eVar) {
        FileChannel fileChannel;
        boolean z2;
        synchronized (obj) {
            FileChannel fileChannel2 = null;
            r1 = null;
            FileLock fileLock = null;
            FileChannel fileChannel3 = null;
            boolean z3 = false;
            if (d) {
                int nativeOpenFile = JNIBridge.nativeOpenFile(str);
                if (nativeOpenFile < 0) {
                    com.uc.crashsdk.a.a.a("crashsdk", "Can not open file: " + str, null);
                    return false;
                }
                try {
                    boolean nativeLockFile = JNIBridge.nativeLockFile(nativeOpenFile, true);
                    try {
                        z2 = eVar.a();
                        return z2;
                    } finally {
                        if (nativeLockFile) {
                            JNIBridge.nativeLockFile(nativeOpenFile, false);
                        }
                    }
                } finally {
                    JNIBridge.nativeCloseFile(nativeOpenFile);
                }
            }
            File file = new File(str);
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (Exception e2) {
                    com.uc.crashsdk.a.g.a(e2);
                }
            }
            try {
                try {
                    fileChannel = new RandomAccessFile(file, "rw").getChannel();
                } catch (Throwable th) {
                    th = th;
                    com.uc.crashsdk.a.g.a(fileChannel3);
                    throw th;
                }
            } catch (Exception e3) {
                try {
                    com.uc.crashsdk.a.g.a(e3);
                    fileChannel = null;
                } catch (Exception e4) {
                    e = e4;
                    com.uc.crashsdk.a.g.a(e);
                    com.uc.crashsdk.a.g.a(fileChannel2);
                    z2 = z3;
                    return z2;
                }
            }
            if (fileChannel != null) {
                try {
                    try {
                        fileLock = fileChannel.lock();
                    } catch (Exception e5) {
                        try {
                            com.uc.crashsdk.a.g.a(e5);
                        } catch (Exception e6) {
                            e = e6;
                            fileChannel2 = fileChannel;
                            com.uc.crashsdk.a.g.a(e);
                            com.uc.crashsdk.a.g.a(fileChannel2);
                            z2 = z3;
                            return z2;
                        }
                    }
                } catch (Throwable th2) {
                    fileChannel3 = fileChannel;
                    th = th2;
                    com.uc.crashsdk.a.g.a(fileChannel3);
                    throw th;
                }
            }
            try {
                z3 = eVar.a();
                com.uc.crashsdk.a.g.a(fileChannel);
                z2 = z3;
                return z2;
            } finally {
                if (fileLock != null) {
                    try {
                        fileLock.release();
                    } catch (Exception e7) {
                        com.uc.crashsdk.a.g.a(e7);
                    }
                }
            }
        }
    }

    private static void aa() {
        if (!com.uc.crashsdk.a.f.b(S)) {
            com.uc.crashsdk.a.f.a(1, S);
            return;
        }
        Object[] objArr = R;
        if (objArr == null || !ab()[0].equals(objArr[0])) {
            com.uc.crashsdk.a.f.a(S);
            com.uc.crashsdk.a.f.a(1, S);
        }
    }

    private static Object[] ab() {
        synchronized (V) {
            try {
                long j2 = W + 1;
                W = j2;
                if (x) {
                    return new Object[]{"e", Long.valueOf(j2)};
                }
                if (B()) {
                    return new Object[]{"f", Long.valueOf(W)};
                }
                return new Object[]{"b", Long.valueOf(W)};
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static Object ac() {
        Object a2;
        Object a3 = a((Application) com.uc.crashsdk.a.g.a(), (Class<?>) Application.class, "mLoadedApk");
        if (a3 != null && (a2 = a(a3, (Class<?>) null, "mActivityThread")) != null) {
            return a2;
        }
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread").getDeclaredMethod("currentActivityThread", null);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                return declaredMethod.invoke(null, null);
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        return null;
    }

    private static boolean ad() {
        String a2 = com.uc.crashsdk.a.g.a(new File("/proc/self/cgroup"), IjkMediaMeta.FF_PROFILE_H264_CONSTRAINED, false);
        if (com.uc.crashsdk.a.g.a(a2)) {
            return false;
        }
        return a2.contains("/bg_non_interactive") || a2.contains("/background");
    }

    private static boolean ae() {
        try {
            Method declaredMethod = Process.class.getDeclaredMethod("isIsolated", null);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(null, null);
                if (invoke != null && (invoke instanceof Boolean)) {
                    return ((Boolean) invoke).booleanValue();
                }
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        int myUid = Process.myUid() % 100000;
        return myUid >= 99000 && myUid <= 99999;
    }

    public static String b() {
        if (k == null) {
            k = d("ctj");
        }
        return k;
    }

    public static String b(String str) {
        return "debug.crs." + str;
    }

    public static void b(int i2) {
        I = i2;
        K();
    }

    public static void b(Context context) {
        long j2;
        boolean z2;
        com.uc.crashsdk.a.a.a("Restart APP");
        if (context == null) {
            return;
        }
        if (p == null) {
            p = d("rt");
        }
        File file = new File(p);
        try {
            j2 = Long.parseLong(com.uc.crashsdk.a.g.d(file));
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            j2 = -1;
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (g.h() < 0 || (j2 > 0 && currentTimeMillis - j2 <= g.h())) {
            z2 = false;
        } else {
            f(g.X());
            com.uc.crashsdk.a.g.a(file, String.valueOf(currentTimeMillis));
            z2 = true;
        }
        com.uc.crashsdk.a.a.a("lastTime: " + j2 + ", currentTime: " + currentTimeMillis + ", needRestart: " + z2);
        if (z2) {
            try {
                d.a(true);
            } catch (Throwable th2) {
                com.uc.crashsdk.a.g.a(th2);
            }
            N();
        }
    }

    public static void b(boolean z2) {
        if (e.u()) {
            return;
        }
        if (z2 && x) {
            if (g.P()) {
                Log.v("crashsdk", "setForeground, reset sExited to false!!!");
            }
            x = false;
            Y();
        }
        boolean z3 = e.F() || L();
        long currentTimeMillis = System.currentTimeMillis();
        if (X && !Y && z2) {
            long j2 = aa;
            if (j2 != 0 && !z3 && currentTimeMillis - j2 > 1800000) {
                com.uc.crashsdk.a.f.a(1, new com.uc.crashsdk.a.e(104), 1000L);
            }
        }
        aa = currentTimeMillis;
        Y = z2;
        if (z2) {
            X = true;
        }
        if (d) {
            JNIBridge.nativeSetForeground(z2);
        }
        if (x || z3) {
            return;
        }
        T();
        Z();
        if (z2) {
            a.a(false);
            if (!Z) {
                e.B();
                Z = true;
            }
        }
        if (!N) {
            aa();
        }
        e.c(z2);
    }

    public static String c() {
        if (n == null) {
            n = d("st");
        }
        return n;
    }

    public static boolean c(int i2) {
        return (i2 & I) != 0;
    }

    private static String d(String str) {
        return g.X() + a() + "." + str;
    }

    public static File[] d() {
        return e(".st");
    }

    public static String e() {
        if (o == null) {
            o = d("stcb");
        }
        return o;
    }

    private static File[] e(String str) {
        if (!i && str.length() <= 0) {
            jr4.a();
            return null;
        }
        File[] listFiles = new File(g.X()).listFiles();
        if (listFiles == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (File file : listFiles) {
            if (file.getPath().endsWith(str)) {
                arrayList.add(file);
            }
        }
        return (File[]) arrayList.toArray(new File[arrayList.size()]);
    }

    private static boolean f(String str) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (file.isDirectory()) {
            return true;
        }
        com.uc.crashsdk.a.a.a("crashsdk", "Crash log directory was placed by a file!", null);
        if (!file.delete()) {
            return false;
        }
        file.mkdirs();
        return true;
    }

    public static File[] f() {
        return e(".stcb");
    }

    public static String g() {
        if (v == null) {
            v = d("bati");
        }
        return v;
    }

    public static String h() {
        if (w == null) {
            w = d("hdr");
        }
        return w;
    }

    public static String i() {
        if (q == null) {
            q = g.X() + com.umeng.analytics.pro.g.R;
        }
        return q;
    }

    public static String j() {
        if (r == null) {
            r = g.X() + "authu";
        }
        return r;
    }

    public static String k() {
        if (s == null) {
            s = g.X() + "statu";
        }
        return s;
    }

    public static String l() {
        if (t == null) {
            t = g.X() + "poli";
        }
        return t;
    }

    public static String m() {
        if (u == null) {
            u = g.X() + "ver";
        }
        return u;
    }

    public static String n() {
        return g.X() + "bvu";
    }

    public static String o() {
        return g.X() + "fds";
    }

    public static String p() {
        return com.uc.crashsdk.a.g.a(new File(Q()), 8, false);
    }

    public static boolean q() {
        return y;
    }

    public static boolean r() {
        if (!J) {
            if (d) {
                K = JNIBridge.cmd(15) == 1;
            } else {
                K = new File(S()).exists();
            }
            J = true;
        }
        return K;
    }

    public static boolean s() {
        T();
        return A;
    }

    public static boolean t() {
        T();
        return B;
    }

    public static boolean u() {
        return x;
    }

    public static void v() {
        boolean z2;
        f(g.X());
        y = true;
        A = false;
        B = false;
        C = false;
        D = false;
        E = false;
        F = false;
        String[] strArr = {".st", ".wa", ".callback", ".ctn", ".ctj", ".cta", ".signal"};
        String[] strArr2 = {com.umeng.analytics.pro.g.R, "authu", "statu", "poli"};
        File[] listFiles = new File(g.X()).listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                String name = file.getName();
                int i2 = 0;
                while (true) {
                    if (i2 >= 7) {
                        z2 = false;
                        break;
                    } else {
                        if (name.endsWith(strArr[i2])) {
                            z2 = true;
                            break;
                        }
                        i2++;
                    }
                }
                if (!z2) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= 4) {
                            break;
                        }
                        if (name.equals(strArr2[i3])) {
                            z2 = true;
                            break;
                        }
                        i3++;
                    }
                }
                if (z2) {
                    com.uc.crashsdk.a.a.a("crashsdk", "delete file: " + file.getPath());
                    com.uc.crashsdk.a.g.a(file);
                }
            }
        }
        Z();
    }

    public static void w() {
        if (x) {
            return;
        }
        x = true;
        if (L() || e.u()) {
            return;
        }
        f(g.X());
        Y();
        Z();
    }

    public static boolean x() {
        return f(g.X());
    }

    public static boolean y() {
        return f(g.Y());
    }

    public static boolean z() {
        return X || !ad();
    }
}
