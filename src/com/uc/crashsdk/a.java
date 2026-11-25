package com.uc.crashsdk;

import android.content.pm.PackageInfo;
import android.util.Log;
import android.util.SparseArray;
import com.uc.crashsdk.export.LogType;
import com.umeng.umcrash.custom_exception.UMCustomLogInfoBuilder;
import defpackage.jr4;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: /tmp/classes2.dex */
public class a {
    public static String a = "";
    public static String b = "";
    static final /* synthetic */ boolean d = true;
    private static final Map<String, String> e = new HashMap();
    private static final List<String> f = new ArrayList();
    private static String g = "";
    private static String h = null;
    private static int i = -1;
    private static long j = 0;
    private static final HashMap<String, Object[]> k = new HashMap<>();
    private static final List<String> l = new ArrayList();
    private static int m = 0;
    private static int n = 0;
    private static int o = 0;
    private static int p = 0;
    private static final HashMap<String, Object[]> q = new HashMap<>();
    private static final List<String> r = new ArrayList();
    private static int s = 0;
    private static int t = 0;
    private static int u = 0;
    private static int v = 0;
    private static int w = 0;
    private static int x = 0;
    private static final SparseArray<Object[]> y = new SparseArray<>();
    private static final List<Integer> z = new ArrayList();
    private static final HashMap<String, Object[]> A = new HashMap<>();
    private static final List<String> B = new ArrayList();
    private static int C = 0;
    private static int D = 0;
    private static int E = 0;
    static boolean c = false;
    private static Runnable F = new com.uc.crashsdk.a.e(201);
    private static boolean G = false;
    private static boolean H = false;
    private static boolean I = false;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0051 A[RETURN] */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int a(int r5, java.lang.String r6) {
        /*
            boolean r0 = com.uc.crashsdk.a.g.a(r6)
            if (r0 == 0) goto Le
            java.lang.Thread r6 = java.lang.Thread.currentThread()
            java.lang.String r6 = r6.getName()
        Le:
            boolean r0 = com.uc.crashsdk.export.LogType.isForNative(r5)
            if (r0 != 0) goto L1a
            boolean r0 = com.uc.crashsdk.export.LogType.isForANR(r5)
            if (r0 == 0) goto L40
        L1a:
            boolean r0 = com.uc.crashsdk.b.d
            r1 = 0
            if (r0 == 0) goto L39
            android.util.SparseArray<java.lang.Object[]> r0 = com.uc.crashsdk.a.y
            monitor-enter(r0)
            r2 = 4
            long r3 = (long) r5
            com.uc.crashsdk.JNIBridge.nativeCmd(r2, r3, r6, r1)     // Catch: java.lang.Throwable -> L36
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L36
            boolean r0 = com.uc.crashsdk.export.LogType.isForNative(r5)
            boolean r1 = com.uc.crashsdk.export.LogType.isForANR(r5)
            if (r1 == 0) goto L41
            r1 = 1048576(0x100000, float:1.469368E-39)
            r0 = r0 | r1
            goto L41
        L36:
            r5 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L36
            throw r5
        L39:
            java.lang.String r0 = "crashsdk so has not loaded!"
            java.lang.String r2 = "crashsdk"
            com.uc.crashsdk.a.a.a(r2, r0, r1)
        L40:
            r0 = 0
        L41:
            boolean r5 = com.uc.crashsdk.export.LogType.isForJava(r5)
            if (r5 == 0) goto L51
            java.lang.Thread r5 = java.lang.Thread.currentThread()
            a(r6, r5)
            r5 = r0 | 16
            return r5
        L51:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.a(int, java.lang.String):int");
    }

    public static int a(String str, int i2, int i3) {
        int i4;
        int i5 = 0;
        if (str == null || i2 <= 0) {
            return 0;
        }
        if (i2 > 1500) {
            com.uc.crashsdk.a.a.a("crashsdk", "createCachedInfo: capacity is too large!", null);
            return 0;
        }
        HashMap<String, Object[]> hashMap = A;
        synchronized (hashMap) {
            try {
                if (hashMap.containsKey(str)) {
                    i5 = ((Integer) hashMap.get(str)[1]).intValue();
                    i4 = LogType.addType(i5, i3);
                } else {
                    i4 = i3;
                }
                if (LogType.isForJava(i4) && !LogType.isForJava(i5)) {
                    int i6 = C;
                    if (i6 >= 8) {
                        i4 = LogType.removeType(i4, 16);
                    } else {
                        C = i6 + 1;
                    }
                }
                if (LogType.isForNative(i4) && !LogType.isForNative(i5)) {
                    int i7 = D;
                    if (i7 >= 8) {
                        i4 = LogType.removeType(i4, 1);
                    } else {
                        D = i7 + 1;
                    }
                }
                if (LogType.isForANR(i4) && !LogType.isForANR(i5)) {
                    int i8 = E;
                    if (i8 >= 8) {
                        i4 = LogType.removeType(i4, LogType.ANR);
                    } else {
                        E = i8 + 1;
                    }
                }
                if ((1048849 & i4) == 0) {
                    return i4;
                }
                if (i5 == 0) {
                    B.add(str);
                }
                if (b.d && (i3 & 1048577) != 0) {
                    int nativeCreateCachedInfo = JNIBridge.nativeCreateCachedInfo(str, i2, i4);
                    if (!LogType.isForNative(nativeCreateCachedInfo)) {
                        i4 = LogType.removeType(i4, 1);
                    }
                    if (!LogType.isForANR(nativeCreateCachedInfo)) {
                        i4 = LogType.removeType(i4, LogType.ANR);
                    }
                }
                hashMap.put(str, new Object[]{Integer.valueOf(i2), Integer.valueOf(i4), new ArrayList()});
                return i4;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0056, code lost:
    
        if ((r8 - com.uc.crashsdk.a.w) >= 6) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0099 A[Catch: all -> 0x0029, TryCatch #0 {all -> 0x0029, blocks: (B:8:0x000d, B:10:0x0013, B:12:0x0027, B:14:0x002e, B:16:0x0038, B:18:0x003e, B:21:0x0058, B:24:0x0049, B:27:0x004e, B:28:0x005f, B:29:0x0052, B:31:0x0062, B:33:0x0068, B:35:0x006e, B:39:0x0099, B:40:0x00a0, B:42:0x00a8, B:44:0x00ae, B:46:0x00b2, B:47:0x00b8, B:48:0x00bc, B:50:0x00c4, B:52:0x00ca, B:54:0x00ce, B:55:0x00d3, B:56:0x00d7, B:58:0x00dd, B:61:0x00e1, B:62:0x00e6, B:64:0x00ea, B:66:0x00f0, B:68:0x00fc, B:70:0x0102, B:72:0x0109, B:73:0x010e, B:75:0x0114, B:77:0x011a, B:78:0x011f, B:80:0x0125, B:82:0x012b, B:83:0x0133, B:84:0x0148, B:90:0x007b, B:93:0x0080, B:94:0x008a, B:97:0x0091), top: B:7:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ce A[Catch: all -> 0x0029, TryCatch #0 {all -> 0x0029, blocks: (B:8:0x000d, B:10:0x0013, B:12:0x0027, B:14:0x002e, B:16:0x0038, B:18:0x003e, B:21:0x0058, B:24:0x0049, B:27:0x004e, B:28:0x005f, B:29:0x0052, B:31:0x0062, B:33:0x0068, B:35:0x006e, B:39:0x0099, B:40:0x00a0, B:42:0x00a8, B:44:0x00ae, B:46:0x00b2, B:47:0x00b8, B:48:0x00bc, B:50:0x00c4, B:52:0x00ca, B:54:0x00ce, B:55:0x00d3, B:56:0x00d7, B:58:0x00dd, B:61:0x00e1, B:62:0x00e6, B:64:0x00ea, B:66:0x00f0, B:68:0x00fc, B:70:0x0102, B:72:0x0109, B:73:0x010e, B:75:0x0114, B:77:0x011a, B:78:0x011f, B:80:0x0125, B:82:0x012b, B:83:0x0133, B:84:0x0148, B:90:0x007b, B:93:0x0080, B:94:0x008a, B:97:0x0091), top: B:7:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00d3 A[Catch: all -> 0x0029, TryCatch #0 {all -> 0x0029, blocks: (B:8:0x000d, B:10:0x0013, B:12:0x0027, B:14:0x002e, B:16:0x0038, B:18:0x003e, B:21:0x0058, B:24:0x0049, B:27:0x004e, B:28:0x005f, B:29:0x0052, B:31:0x0062, B:33:0x0068, B:35:0x006e, B:39:0x0099, B:40:0x00a0, B:42:0x00a8, B:44:0x00ae, B:46:0x00b2, B:47:0x00b8, B:48:0x00bc, B:50:0x00c4, B:52:0x00ca, B:54:0x00ce, B:55:0x00d3, B:56:0x00d7, B:58:0x00dd, B:61:0x00e1, B:62:0x00e6, B:64:0x00ea, B:66:0x00f0, B:68:0x00fc, B:70:0x0102, B:72:0x0109, B:73:0x010e, B:75:0x0114, B:77:0x011a, B:78:0x011f, B:80:0x0125, B:82:0x012b, B:83:0x0133, B:84:0x0148, B:90:0x007b, B:93:0x0080, B:94:0x008a, B:97:0x0091), top: B:7:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00dd A[Catch: all -> 0x0029, DONT_GENERATE, TryCatch #0 {all -> 0x0029, blocks: (B:8:0x000d, B:10:0x0013, B:12:0x0027, B:14:0x002e, B:16:0x0038, B:18:0x003e, B:21:0x0058, B:24:0x0049, B:27:0x004e, B:28:0x005f, B:29:0x0052, B:31:0x0062, B:33:0x0068, B:35:0x006e, B:39:0x0099, B:40:0x00a0, B:42:0x00a8, B:44:0x00ae, B:46:0x00b2, B:47:0x00b8, B:48:0x00bc, B:50:0x00c4, B:52:0x00ca, B:54:0x00ce, B:55:0x00d3, B:56:0x00d7, B:58:0x00dd, B:61:0x00e1, B:62:0x00e6, B:64:0x00ea, B:66:0x00f0, B:68:0x00fc, B:70:0x0102, B:72:0x0109, B:73:0x010e, B:75:0x0114, B:77:0x011a, B:78:0x011f, B:80:0x0125, B:82:0x012b, B:83:0x0133, B:84:0x0148, B:90:0x007b, B:93:0x0080, B:94:0x008a, B:97:0x0091), top: B:7:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00df  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int a(java.lang.String r16, int r17, java.util.concurrent.Callable<java.lang.String> r18, long r19, int r21) {
        /*
            Method dump skipped, instructions count: 332
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.a(java.lang.String, int, java.util.concurrent.Callable, long, int):int");
    }

    public static int a(String str, String str2, boolean z2, boolean z3, int i2, boolean z4) {
        int i3;
        int i4 = 0;
        if (str == null || str2 == null) {
            return 0;
        }
        if (str.length() > 256) {
            com.uc.crashsdk.a.a.a("crashsdk", "addDumpFile: description is too long!", null);
            return 0;
        }
        HashMap<String, Object[]> hashMap = k;
        synchronized (hashMap) {
            try {
                if (hashMap.containsKey(str)) {
                    i4 = ((Integer) hashMap.get(str)[0]).intValue();
                    i3 = LogType.addType(i4, i2);
                } else {
                    i3 = i2;
                }
                if (LogType.isForJava(i3) && !LogType.isForJava(i4)) {
                    int i5 = m;
                    if (i5 >= 10) {
                        i3 = LogType.removeType(i3, 16);
                    } else {
                        m = i5 + 1;
                    }
                }
                if (LogType.isForNative(i3) && !LogType.isForNative(i4)) {
                    int i6 = n;
                    if (i6 >= 10) {
                        i3 = LogType.removeType(i3, 1);
                    } else {
                        n = i6 + 1;
                    }
                }
                if (LogType.isForUnexp(i3) && !LogType.isForUnexp(i4)) {
                    int i7 = o;
                    if (i7 >= 10) {
                        i3 = LogType.removeType(i3, 256);
                    } else {
                        o = i7 + 1;
                    }
                }
                if (LogType.isForANR(i3) && !LogType.isForANR(i4)) {
                    int i8 = p;
                    if (i8 >= 10) {
                        i3 = LogType.removeType(i3, LogType.ANR);
                    } else {
                        p = i8 + 1;
                    }
                }
                if ((1048849 & i3) == 0) {
                    return i3;
                }
                if (i4 == 0) {
                    l.add(str);
                }
                if (b.d && (1048833 & i2) != 0) {
                    int nativeAddDumpFile = JNIBridge.nativeAddDumpFile(str, str2, z2, z3, i2, z4);
                    if (!LogType.isForNative(nativeAddDumpFile)) {
                        i3 = LogType.removeType(i3, 1);
                    }
                    if (!LogType.isForUnexp(nativeAddDumpFile)) {
                        i3 = LogType.removeType(i3, 256);
                    }
                    if (!LogType.isForANR(nativeAddDumpFile)) {
                        i3 = LogType.removeType(i3, LogType.ANR);
                    }
                }
                hashMap.put(str, new Object[]{Integer.valueOf(i3), str2, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)});
                return i3;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static String a() {
        String str = h;
        return str != null ? str : o() ? h : "";
    }

    public static String a(String str) {
        HashMap<String, Object[]> hashMap = k;
        synchronized (hashMap) {
            try {
                Object[] objArr = hashMap.get(str);
                if (objArr == null) {
                    return null;
                }
                return String.format(Locale.US, "%s%s%d%d", (String) objArr[1], "`", Integer.valueOf(((Boolean) objArr[2]).booleanValue() ? 1 : 0), Integer.valueOf(((Boolean) objArr[3]).booleanValue() ? 1 : 0));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static String a(String str, boolean z2) {
        String nativeGetCallbackInfo;
        HashMap<String, Object[]> hashMap = q;
        synchronized (hashMap) {
            try {
                Object[] objArr = hashMap.get(str);
                long longValue = ((Long) objArr[2]).longValue();
                nativeGetCallbackInfo = longValue != 0 ? JNIBridge.nativeGetCallbackInfo(str, longValue, ((Integer) objArr[3]).intValue(), z2) : b(str, z2).toString();
            } catch (Throwable th) {
                throw th;
            }
        }
        return nativeGetCallbackInfo;
    }

    public static void a(int i2) {
        if (i2 == 201) {
            com.uc.crashsdk.a.a.a("crashsdk", "Begin update info ...");
            long currentTimeMillis = System.currentTimeMillis();
            if (b.d && c) {
                JNIBridge.nativeCmd(11, g.H(), String.valueOf(g.I()), null);
            }
            com.uc.crashsdk.a.a.a("crashsdk", "Update info took " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            a(false);
            return;
        }
        if (i2 != 202) {
            if (d) {
                return;
            }
            jr4.a();
            return;
        }
        p();
        Locale locale = Locale.US;
        String format = String.format(locale, "%s/%s/%s", g.U(), g.V(), g.W());
        g = m();
        if (b.d) {
            JNIBridge.set(128, g);
        }
        boolean equals = format.equals(g);
        if (!equals) {
            com.uc.crashsdk.a.b.a(b.m(), format);
        }
        if (equals || !g.v()) {
            return;
        }
        com.uc.crashsdk.a.a.a("crashsdk", String.format(locale, "Is new version ('%s' -> '%s'), deleting old stats data!", g, format));
        b.v();
    }

    public static void a(OutputStream outputStream, String str) {
        synchronized (e) {
            try {
                for (String str2 : f) {
                    try {
                        StringBuilder sb = new StringBuilder(11);
                        sb.append(str2);
                        sb.append(": ");
                        String str3 = e.get(str2);
                        if (str3 != null) {
                            sb.append(str3);
                        }
                        sb.append(UMCustomLogInfoBuilder.LINE_SEP);
                        outputStream.write(sb.toString().getBytes(str));
                    } catch (Throwable th) {
                        e.a(th, outputStream);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b8 A[Catch: all -> 0x00c2, TryCatch #1 {all -> 0x00c2, blocks: (B:32:0x00b1, B:34:0x00b8, B:35:0x00c4, B:37:0x00c8, B:39:0x00cc, B:40:0x00d5), top: B:31:0x00b1, outer: #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c8 A[Catch: all -> 0x00c2, TryCatch #1 {all -> 0x00c2, blocks: (B:32:0x00b1, B:34:0x00b8, B:35:0x00c4, B:37:0x00c8, B:39:0x00cc, B:40:0x00d5), top: B:31:0x00b1, outer: #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(java.io.OutputStream r13, java.lang.String r14, java.lang.String r15) {
        /*
            Method dump skipped, instructions count: 273
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.a(java.io.OutputStream, java.lang.String, java.lang.String):void");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:7|(2:8|9)|(3:35|36|(4:39|40|41|17)(1:38))(3:11|12|(4:14|15|16|17)(1:18))|19|(1:21)(1:34)|(1:33)(1:25)|26|27|29|17|5) */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a4, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a5, code lost:
    
        com.uc.crashsdk.e.a(r2, r9);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(java.io.OutputStream r9, java.lang.String r10, java.lang.String r11, java.util.ArrayList<java.lang.String> r12) {
        /*
            java.util.HashMap<java.lang.String, java.lang.Object[]> r0 = com.uc.crashsdk.a.q
            monitor-enter(r0)
            java.util.List<java.lang.String> r1 = com.uc.crashsdk.a.r     // Catch: java.lang.Throwable -> Laa
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> Laa
        L9:
            boolean r2 = r1.hasNext()     // Catch: java.lang.Throwable -> Laa
            if (r2 == 0) goto Lac
            java.lang.Object r2 = r1.next()     // Catch: java.lang.Throwable -> Laa
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> Laa
            java.util.HashMap<java.lang.String, java.lang.Object[]> r3 = com.uc.crashsdk.a.q     // Catch: java.lang.Throwable -> L2f
            java.lang.Object r3 = r3.get(r2)     // Catch: java.lang.Throwable -> L2f
            java.lang.Object[] r3 = (java.lang.Object[]) r3     // Catch: java.lang.Throwable -> L2f
            r4 = 0
            r5 = r3[r4]     // Catch: java.lang.Throwable -> L2f
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch: java.lang.Throwable -> L2f
            int r5 = r5.intValue()     // Catch: java.lang.Throwable -> L2f
            if (r12 != 0) goto L31
            boolean r5 = com.uc.crashsdk.export.LogType.isForJava(r5)     // Catch: java.lang.Throwable -> L2f
            if (r5 != 0) goto L38
            goto L9
        L2f:
            r2 = move-exception
            goto L8f
        L31:
            boolean r5 = a(r12, r2)     // Catch: java.lang.Throwable -> L2f
            if (r5 != 0) goto L38
            goto L9
        L38:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2f
            r5.<init>()     // Catch: java.lang.Throwable -> L2f
            r5.append(r2)     // Catch: java.lang.Throwable -> L2f
            java.lang.String r6 = "\n"
            r5.append(r6)     // Catch: java.lang.Throwable -> L2f
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L2f
            byte[] r5 = r5.getBytes(r10)     // Catch: java.lang.Throwable -> L2f
            r9.write(r5)     // Catch: java.lang.Throwable -> L2f
            r5 = 2
            r5 = r3[r5]     // Catch: java.lang.Throwable -> L2f
            java.lang.Long r5 = (java.lang.Long) r5     // Catch: java.lang.Throwable -> L2f
            long r5 = r5.longValue()     // Catch: java.lang.Throwable -> L2f
            r7 = 0
            int r7 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r7 == 0) goto L6d
            r7 = 3
            r3 = r3[r7]     // Catch: java.lang.Throwable -> L2f
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch: java.lang.Throwable -> L2f
            int r3 = r3.intValue()     // Catch: java.lang.Throwable -> L2f
            java.lang.String r2 = com.uc.crashsdk.JNIBridge.nativeGetCallbackInfo(r2, r5, r3, r4)     // Catch: java.lang.Throwable -> L2f
            goto L75
        L6d:
            java.lang.StringBuilder r2 = b(r2, r4)     // Catch: java.lang.Throwable -> L2f
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L2f
        L75:
            if (r2 == 0) goto L85
            int r3 = r2.length()     // Catch: java.lang.Throwable -> L2f
            if (r3 <= 0) goto L85
            byte[] r2 = r2.getBytes(r10)     // Catch: java.lang.Throwable -> L2f
            r9.write(r2)     // Catch: java.lang.Throwable -> L2f
            goto L92
        L85:
            java.lang.String r2 = "(data is null)\n"
            byte[] r2 = r2.getBytes(r10)     // Catch: java.lang.Throwable -> L2f
            r9.write(r2)     // Catch: java.lang.Throwable -> L2f
            goto L92
        L8f:
            com.uc.crashsdk.e.a(r2, r9)     // Catch: java.lang.Throwable -> Laa
        L92:
            java.lang.String r2 = "\n"
            byte[] r2 = r2.getBytes(r10)     // Catch: java.lang.Throwable -> La4
            r9.write(r2)     // Catch: java.lang.Throwable -> La4
            byte[] r2 = r11.getBytes(r10)     // Catch: java.lang.Throwable -> La4
            r9.write(r2)     // Catch: java.lang.Throwable -> La4
            goto L9
        La4:
            r2 = move-exception
            com.uc.crashsdk.e.a(r2, r9)     // Catch: java.lang.Throwable -> Laa
            goto L9
        Laa:
            r9 = move-exception
            goto Ld4
        Lac:
            if (r12 == 0) goto Ld2
            boolean r10 = com.uc.crashsdk.e.F()     // Catch: java.lang.Throwable -> Laa
            if (r10 == 0) goto Ld2
            java.util.Iterator r10 = r12.iterator()     // Catch: java.lang.Throwable -> Laa
        Lb8:
            boolean r11 = r10.hasNext()     // Catch: java.lang.Throwable -> Laa
            if (r11 == 0) goto Ld2
            java.lang.Object r11 = r10.next()     // Catch: java.lang.Throwable -> Laa
            java.lang.String r11 = (java.lang.String) r11     // Catch: java.lang.Throwable -> Laa
            java.util.List<java.lang.String> r12 = com.uc.crashsdk.a.r     // Catch: java.lang.Throwable -> Laa
            boolean r12 = a(r12, r11)     // Catch: java.lang.Throwable -> Laa
            if (r12 != 0) goto Lb8
            java.lang.String r12 = "CUSTOMCALLBACKINFO"
            com.uc.crashsdk.e.a(r9, r12, r11)     // Catch: java.lang.Throwable -> Laa
            goto Lb8
        Ld2:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Laa
            return
        Ld4:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Laa
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.a(java.io.OutputStream, java.lang.String, java.lang.String, java.util.ArrayList):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0055 A[Catch: all -> 0x003e, TRY_LEAVE, TryCatch #3 {all -> 0x003e, blocks: (B:12:0x0025, B:70:0x002f, B:22:0x004a, B:24:0x0055, B:15:0x0043), top: B:11:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ce A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0019 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b2 A[Catch: all -> 0x00ac, TryCatch #2 {all -> 0x00ac, blocks: (B:33:0x0080, B:37:0x009c, B:39:0x00a4, B:58:0x00b2, B:59:0x00b6, B:60:0x00b8), top: B:32:0x0080 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b8 A[Catch: all -> 0x00ac, TRY_LEAVE, TryCatch #2 {all -> 0x00ac, blocks: (B:33:0x0080, B:37:0x009c, B:39:0x00a4, B:58:0x00b2, B:59:0x00b6, B:60:0x00b8), top: B:32:0x0080 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(java.io.OutputStream r16, java.lang.String r17, java.util.ArrayList<java.lang.String> r18) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.a(java.io.OutputStream, java.lang.String, java.util.ArrayList):void");
    }

    public static void a(String str, String str2) {
        Map<String, String> map = e;
        synchronized (map) {
            try {
                if (!map.containsKey(str)) {
                    f.add(str);
                }
                map.put(str, str2);
                if (b.d) {
                    JNIBridge.nativeAddHeaderInfo(str, str2);
                }
                e.y();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static boolean a(String str, Thread thread) {
        if (thread == null) {
            return false;
        }
        SparseArray<Object[]> sparseArray = y;
        synchronized (sparseArray) {
            try {
                int id = (int) thread.getId();
                if (sparseArray.get(id) == null) {
                    z.add(Integer.valueOf(id));
                }
                sparseArray.put(id, new Object[]{new WeakReference(thread), str});
            } catch (Throwable th) {
                throw th;
            }
        }
        return true;
    }

    private static boolean a(List<String> list, String str) {
        if (com.uc.crashsdk.a.g.a(str)) {
            return false;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (str.equals(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(boolean z2) {
        int H2;
        if (!b.c) {
            com.uc.crashsdk.a.a.a("crashsdk", "Unexp log not enabled, skip update unexp info!");
            return false;
        }
        if (e.F() || b.L()) {
            return false;
        }
        if (z2) {
            com.uc.crashsdk.a.f.a(F);
            H2 = 0;
        } else {
            if (!b.B()) {
                com.uc.crashsdk.a.a.a("crashsdk", "Stop update unexp info in background!");
                return false;
            }
            if (g.H() <= 0) {
                return false;
            }
            if (com.uc.crashsdk.a.f.b(F)) {
                return true;
            }
            H2 = g.H() * IjkMediaCodecInfo.RANK_MAX;
        }
        com.uc.crashsdk.a.f.a(0, F, H2);
        return true;
    }

    public static int b(String str, String str2) {
        int i2;
        if (str == null || str2 == null) {
            return 0;
        }
        if (str2.length() > 2048) {
            str2 = str2.substring(0, IjkMediaMeta.FF_PROFILE_H264_INTRA);
        }
        HashMap<String, Object[]> hashMap = A;
        synchronized (hashMap) {
            try {
                Object[] objArr = hashMap.get(str);
                if (objArr != null) {
                    int intValue = ((Integer) objArr[0]).intValue();
                    int intValue2 = ((Integer) objArr[1]).intValue();
                    List list = (List) objArr[2];
                    if (list.size() >= intValue) {
                        list.remove(0);
                    }
                    list.add(str2);
                    r0 = LogType.isForJava(intValue2) ? LogType.addType(0, 16) : 0;
                    if (!b.d) {
                        if (LogType.isForNative(intValue2)) {
                            r0 = LogType.addType(r0, 1);
                        }
                        if (LogType.isForANR(intValue2)) {
                            r0 = LogType.addType(r0, LogType.ANR);
                        }
                    }
                    i2 = r0;
                    r0 = intValue2;
                } else {
                    i2 = 0;
                }
                if (b.d && JNIBridge.nativeAddCachedInfo(str, str2)) {
                    if (LogType.isForNative(r0)) {
                        i2 = LogType.addType(i2, 1);
                    }
                    if (LogType.isForANR(r0)) {
                        i2 = LogType.addType(i2, LogType.ANR);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return i2;
    }

    public static long b() {
        return j;
    }

    public static String b(String str) {
        StringBuilder sb = new StringBuilder();
        HashMap<String, Object[]> hashMap = A;
        synchronized (hashMap) {
            try {
                Object[] objArr = hashMap.get(str);
                Integer num = (Integer) objArr[0];
                num.intValue();
                List list = (List) objArr[2];
                sb.append(String.format(Locale.US, "%s (%d/%d)\n", str, Integer.valueOf(list.size()), num));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    sb.append((String) it.next());
                    sb.append(UMCustomLogInfoBuilder.LINE_SEP);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sb.toString();
    }

    private static StringBuilder b(String str, boolean z2) {
        String a2;
        StringBuilder sb = new StringBuilder();
        try {
            Object[] objArr = q.get(str);
            try {
                if (objArr == null) {
                    a2 = "Unknown callback: " + str;
                } else {
                    Callable callable = (Callable) objArr[1];
                    a2 = callable != null ? (String) callable.call() : d.a(str, z2);
                }
                if (a2 != null) {
                    sb.append(a2);
                }
            } catch (Throwable th) {
                sb.append("[DEBUG] Callback occurred new exception:\n");
                sb.append(Log.getStackTraceString(th));
            }
        } catch (Throwable th2) {
            com.uc.crashsdk.a.g.a(th2);
        }
        try {
            if (sb.length() == 0) {
                sb.append("(data is null)\n");
            }
        } catch (Throwable th3) {
            com.uc.crashsdk.a.g.a(th3);
        }
        return sb;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:7|(3:34|35|(4:37|38|39|24))(3:9|10|(2:33|24))|12|13|15|16|(2:19|17)|20|21|23|24|5) */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x009c, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x009d, code lost:
    
        com.uc.crashsdk.e.a(r2, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0086, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0087, code lost:
    
        com.uc.crashsdk.e.a(r2, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0061, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0062, code lost:
    
        com.uc.crashsdk.e.a(r2, r8);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void b(java.io.OutputStream r8, java.lang.String r9, java.lang.String r10, java.util.ArrayList<java.lang.String> r11) {
        /*
            java.util.HashMap<java.lang.String, java.lang.Object[]> r0 = com.uc.crashsdk.a.A
            monitor-enter(r0)
            java.util.List<java.lang.String> r1 = com.uc.crashsdk.a.B     // Catch: java.lang.Throwable -> L3c
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> L3c
        L9:
            boolean r2 = r1.hasNext()     // Catch: java.lang.Throwable -> L3c
            if (r2 == 0) goto La2
            java.lang.Object r2 = r1.next()     // Catch: java.lang.Throwable -> L3c
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> L3c
            java.util.HashMap<java.lang.String, java.lang.Object[]> r3 = com.uc.crashsdk.a.A     // Catch: java.lang.Throwable -> L3c
            java.lang.Object r3 = r3.get(r2)     // Catch: java.lang.Throwable -> L3c
            java.lang.Object[] r3 = (java.lang.Object[]) r3     // Catch: java.lang.Throwable -> L3c
            r4 = 0
            r4 = r3[r4]     // Catch: java.lang.Throwable -> L3c
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch: java.lang.Throwable -> L3c
            r4.intValue()     // Catch: java.lang.Throwable -> L3c
            r5 = 1
            r5 = r3[r5]     // Catch: java.lang.Throwable -> L3c
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch: java.lang.Throwable -> L3c
            int r5 = r5.intValue()     // Catch: java.lang.Throwable -> L3c
            r6 = 2
            r3 = r3[r6]     // Catch: java.lang.Throwable -> L3c
            java.util.List r3 = (java.util.List) r3     // Catch: java.lang.Throwable -> L3c
            if (r11 != 0) goto L3f
            boolean r5 = com.uc.crashsdk.export.LogType.isForJava(r5)     // Catch: java.lang.Throwable -> L3c
            if (r5 != 0) goto L45
            goto L9
        L3c:
            r8 = move-exception
            goto Lca
        L3f:
            boolean r5 = a(r11, r2)     // Catch: java.lang.Throwable -> L3c
            if (r5 == 0) goto L9
        L45:
            java.util.Locale r5 = java.util.Locale.US     // Catch: java.lang.Throwable -> L61
            java.lang.String r6 = "%s (%d/%d)\n"
            int r7 = r3.size()     // Catch: java.lang.Throwable -> L61
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.Throwable -> L61
            java.lang.Object[] r2 = new java.lang.Object[]{r2, r7, r4}     // Catch: java.lang.Throwable -> L61
            java.lang.String r2 = java.lang.String.format(r5, r6, r2)     // Catch: java.lang.Throwable -> L61
            byte[] r2 = r2.getBytes(r9)     // Catch: java.lang.Throwable -> L61
            r8.write(r2)     // Catch: java.lang.Throwable -> L61
            goto L65
        L61:
            r2 = move-exception
            com.uc.crashsdk.e.a(r2, r8)     // Catch: java.lang.Throwable -> L3c
        L65:
            java.util.Iterator r2 = r3.iterator()     // Catch: java.lang.Throwable -> L86
        L69:
            boolean r3 = r2.hasNext()     // Catch: java.lang.Throwable -> L86
            if (r3 == 0) goto L8a
            java.lang.Object r3 = r2.next()     // Catch: java.lang.Throwable -> L86
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L86
            byte[] r3 = r3.getBytes(r9)     // Catch: java.lang.Throwable -> L86
            r8.write(r3)     // Catch: java.lang.Throwable -> L86
            java.lang.String r3 = "\n"
            byte[] r3 = r3.getBytes(r9)     // Catch: java.lang.Throwable -> L86
            r8.write(r3)     // Catch: java.lang.Throwable -> L86
            goto L69
        L86:
            r2 = move-exception
            com.uc.crashsdk.e.a(r2, r8)     // Catch: java.lang.Throwable -> L3c
        L8a:
            java.lang.String r2 = "\n"
            byte[] r2 = r2.getBytes(r9)     // Catch: java.lang.Throwable -> L9c
            r8.write(r2)     // Catch: java.lang.Throwable -> L9c
            byte[] r2 = r10.getBytes(r9)     // Catch: java.lang.Throwable -> L9c
            r8.write(r2)     // Catch: java.lang.Throwable -> L9c
            goto L9
        L9c:
            r2 = move-exception
            com.uc.crashsdk.e.a(r2, r8)     // Catch: java.lang.Throwable -> L3c
            goto L9
        La2:
            if (r11 == 0) goto Lc8
            boolean r9 = com.uc.crashsdk.e.F()     // Catch: java.lang.Throwable -> L3c
            if (r9 == 0) goto Lc8
            java.util.Iterator r9 = r11.iterator()     // Catch: java.lang.Throwable -> L3c
        Lae:
            boolean r10 = r9.hasNext()     // Catch: java.lang.Throwable -> L3c
            if (r10 == 0) goto Lc8
            java.lang.Object r10 = r9.next()     // Catch: java.lang.Throwable -> L3c
            java.lang.String r10 = (java.lang.String) r10     // Catch: java.lang.Throwable -> L3c
            java.util.List<java.lang.String> r11 = com.uc.crashsdk.a.B     // Catch: java.lang.Throwable -> L3c
            boolean r11 = a(r11, r10)     // Catch: java.lang.Throwable -> L3c
            if (r11 != 0) goto Lae
            java.lang.String r11 = "CUSTOMCACHEDINFO"
            com.uc.crashsdk.e.a(r8, r11, r10)     // Catch: java.lang.Throwable -> L3c
            goto Lae
        Lc8:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L3c
            return
        Lca:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L3c
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.b(java.io.OutputStream, java.lang.String, java.lang.String, java.util.ArrayList):void");
    }

    public static int c() {
        if (i == -1) {
            o();
        }
        return i;
    }

    public static ArrayList<String> c(String str) {
        if (com.uc.crashsdk.a.g.a(str)) {
            return null;
        }
        String[] split = str.split(";", 20);
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str2 : split) {
            if (!com.uc.crashsdk.a.g.a(str2)) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    public static void d() {
        StringBuilder sb = new StringBuilder();
        synchronized (e) {
            try {
                for (String str : f) {
                    String str2 = e.get(str);
                    sb.append(str);
                    sb.append(": ");
                    if (str2 != null) {
                        sb.append(str2);
                    }
                    sb.append(UMCustomLogInfoBuilder.LINE_SEP);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        sb.append(String.format(Locale.US, "(saved at %s)\n", e.n()));
        com.uc.crashsdk.a.b.a(b.h(), sb.toString());
    }

    public static void e() {
        if (!d && !b.d) {
            jr4.a();
            return;
        }
        synchronized (e) {
            try {
                for (String str : f) {
                    JNIBridge.nativeAddHeaderInfo(str, e.get(str));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static byte[] f() {
        return new byte[]{24, 99, 121, 60};
    }

    public static void g() {
        if (!d && !b.d) {
            jr4.a();
            return;
        }
        synchronized (k) {
            try {
                for (String str : l) {
                    Object[] objArr = k.get(str);
                    int intValue = ((Integer) objArr[0]).intValue();
                    if ((1048833 & intValue) != 0) {
                        JNIBridge.nativeAddDumpFile(str, (String) objArr[1], ((Boolean) objArr[2]).booleanValue(), ((Boolean) objArr[3]).booleanValue(), intValue, ((Boolean) objArr[4]).booleanValue());
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static String h() {
        StringBuilder sb = new StringBuilder();
        synchronized (k) {
            try {
                boolean z2 = true;
                for (String str : l) {
                    if (LogType.isForJava(((Integer) k.get(str)[0]).intValue())) {
                        if (!z2) {
                            sb.append("`");
                        }
                        sb.append(str);
                        z2 = false;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sb.toString();
    }

    public static void i() {
        if (!d && !b.d) {
            jr4.a();
            return;
        }
        synchronized (q) {
            try {
                for (String str : r) {
                    Object[] objArr = q.get(str);
                    int intValue = ((Integer) objArr[0]).intValue();
                    if ((1048833 & intValue) != 0) {
                        JNIBridge.nativeAddCallbackInfo(str, intValue, ((Long) objArr[2]).longValue(), ((Integer) objArr[3]).intValue());
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static String j() {
        String sb;
        synchronized (q) {
            StringBuilder sb2 = new StringBuilder();
            List<String> list = r;
            synchronized (list) {
                try {
                    boolean z2 = true;
                    for (String str : list) {
                        if (LogType.isForJava(((Integer) q.get(str)[0]).intValue())) {
                            if (!z2) {
                                sb2.append("`");
                            }
                            sb2.append(str);
                            z2 = false;
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            sb = sb2.toString();
        }
        return sb;
    }

    public static void k() {
        if (!d && !b.d) {
            jr4.a();
            return;
        }
        synchronized (A) {
            try {
                for (String str : B) {
                    Object[] objArr = A.get(str);
                    int intValue = ((Integer) objArr[0]).intValue();
                    int intValue2 = ((Integer) objArr[1]).intValue();
                    List list = (List) objArr[2];
                    if ((1048577 & intValue2) != 0 && JNIBridge.nativeCreateCachedInfo(str, intValue, intValue2) != 0) {
                        Iterator it = list.iterator();
                        while (it.hasNext() && JNIBridge.nativeAddCachedInfo(str, (String) it.next())) {
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static String l() {
        StringBuilder sb = new StringBuilder();
        synchronized (A) {
            try {
                boolean z2 = true;
                for (String str : B) {
                    if (LogType.isForJava(((Integer) A.get(str)[1]).intValue())) {
                        if (!z2) {
                            sb.append("`");
                        }
                        sb.append(str);
                        z2 = false;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sb.toString();
    }

    public static String m() {
        if (!G) {
            String a2 = com.uc.crashsdk.a.b.a(b.m());
            g = a2;
            G = true;
            if (a2 == null) {
                g = "";
            }
        }
        return g;
    }

    public static void n() {
        p();
        if (!H) {
            H = true;
            com.uc.crashsdk.a.f.a(0, new com.uc.crashsdk.a.e(202));
        } else if (b.d) {
            JNIBridge.set(128, g);
        }
    }

    private static boolean o() {
        try {
            PackageInfo packageInfo = com.uc.crashsdk.a.g.a().getPackageManager().getPackageInfo(a, 0);
            h = packageInfo.versionName;
            j = packageInfo.lastUpdateTime;
            i = packageInfo.versionCode;
            return true;
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.b(th);
            return false;
        }
    }

    private static void p() {
        if (!I && e.a()) {
            if (b.d || !b.g) {
                String format = String.format(Locale.US, "%s/%s/%s", g.U(), g.V(), g.W());
                com.uc.crashsdk.a.a.b("crashsdk", "UUID: " + e.q());
                com.uc.crashsdk.a.a.b("crashsdk", "Version: ".concat(format));
                com.uc.crashsdk.a.a.b("crashsdk", "Process Name: " + e.h());
                I = true;
            }
        }
    }
}
