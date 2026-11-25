package com.umeng.crash;

import java.io.OutputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /tmp/classes2.dex */
public final class f {

    /* loaded from: /tmp/classes2.dex */
    public interface a {
        void a(String str, OutputStream outputStream);

        void a(String str, String str2);
    }

    /* loaded from: /tmp/classes2.dex */
    public static class b {
        a a;
        boolean b;
        boolean c;
        boolean d;
        boolean e;
        boolean g;
        boolean h;
        boolean j;
        boolean l;
        boolean m;
        boolean q;
        boolean f = true;
        boolean i = true;
        boolean k = true;
        boolean n = true;
        boolean o = true;
        boolean p = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002e A[Catch: all -> 0x001b, TRY_LEAVE, TryCatch #0 {all -> 0x001b, blocks: (B:8:0x0008, B:10:0x0012, B:12:0x0016, B:15:0x002a, B:17:0x002e, B:22:0x003f, B:23:0x004a, B:25:0x004e, B:31:0x0055, B:33:0x001d, B:35:0x0021, B:19:0x003a), top: B:7:0x0008, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static synchronized int a(android.content.Context r4, com.umeng.crash.f.b r5) {
        /*
            java.lang.Class<com.umeng.crash.f> r0 = com.umeng.crash.f.class
            monitor-enter(r0)
            if (r4 != 0) goto L8
            monitor-exit(r0)
            r4 = -1
            return r4
        L8:
            com.umeng.crash.a r1 = com.umeng.crash.a.a()     // Catch: java.lang.Throwable -> L1b
            r1.a = r5     // Catch: java.lang.Throwable -> L1b
            boolean r1 = r5.b     // Catch: java.lang.Throwable -> L1b
            if (r1 != 0) goto L1d
            boolean r1 = r5.g     // Catch: java.lang.Throwable -> L1b
            if (r1 != 0) goto L1d
            boolean r1 = r5.l     // Catch: java.lang.Throwable -> L1b
            if (r1 == 0) goto L2a
            goto L1d
        L1b:
            r4 = move-exception
            goto L5f
        L1d:
            boolean r1 = r4 instanceof android.app.Application     // Catch: java.lang.Throwable -> L1b
            if (r1 == 0) goto L2a
            com.umeng.crash.e r1 = com.umeng.crash.e.a()     // Catch: java.lang.Throwable -> L1b
            android.app.Application r4 = (android.app.Application) r4     // Catch: java.lang.Throwable -> L1b
            r4.registerActivityLifecycleCallbacks(r1)     // Catch: java.lang.Throwable -> L1b
        L2a:
            boolean r4 = r5.b     // Catch: java.lang.Throwable -> L1b
            if (r4 == 0) goto L4a
            com.umeng.crash.d r4 = com.umeng.crash.d.a()     // Catch: java.lang.Throwable -> L1b
            r4.a = r5     // Catch: java.lang.Throwable -> L1b
            java.lang.Thread$UncaughtExceptionHandler r1 = java.lang.Thread.getDefaultUncaughtExceptionHandler()     // Catch: java.lang.Throwable -> L1b
            r4.b = r1     // Catch: java.lang.Throwable -> L1b
            java.lang.Thread.setDefaultUncaughtExceptionHandler(r4)     // Catch: java.lang.Throwable -> L3e
            goto L4a
        L3e:
            r4 = move-exception
            com.umeng.crash.g r1 = com.umeng.crash.UCrash.a()     // Catch: java.lang.Throwable -> L1b
            java.lang.String r2 = "UCrash.Java"
            java.lang.String r3 = "setDefaultUncaughtExceptionHandler failed"
            r1.a(r2, r3, r4)     // Catch: java.lang.Throwable -> L1b
        L4a:
            boolean r4 = r5.g     // Catch: java.lang.Throwable -> L1b
            if (r4 != 0) goto L55
            boolean r4 = r5.l     // Catch: java.lang.Throwable -> L1b
            if (r4 == 0) goto L53
            goto L55
        L53:
            r4 = 0
            goto L5d
        L55:
            com.umeng.crash.i r4 = com.umeng.crash.i.a()     // Catch: java.lang.Throwable -> L1b
            int r4 = r4.a(r5)     // Catch: java.lang.Throwable -> L1b
        L5d:
            monitor-exit(r0)
            return r4
        L5f:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L1b
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.crash.f.a(android.content.Context, com.umeng.crash.f$b):int");
    }
}
