package com.efs.sdk.memleaksdk.monitor.internal;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Debug;
import android.os.StatFs;
import com.umeng.analytics.pro.cl;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.umcrash.custom_exception.UMCustomLogInfoBuilder;
import com.zzhoujay.richtext.cache.CacheIOHelper;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileReader;

/* loaded from: /tmp/classes2.dex */
public class df {
    private static long a(StatFs statFs) {
        return statFs.getBlockCountLong();
    }

    public static String a() {
        try {
            StringBuilder sb = new StringBuilder("JavaMax:    ");
            sb.append(Runtime.getRuntime().maxMemory() / 1024);
            sb.append(" kB\nJavaTotal:  ");
            sb.append(Runtime.getRuntime().totalMemory() / 1024);
            sb.append(" kB\nJavaFree:   ");
            sb.append(Runtime.getRuntime().freeMemory() / 1024);
            sb.append(" kB\nNativeHeap: ");
            sb.append(Debug.getNativeHeapSize() / 1024);
            sb.append(" kB\nNativeAllocated: ");
            sb.append(Debug.getNativeHeapAllocatedSize() / 1024);
            sb.append(" kB\nNativeFree: ");
            sb.append(Debug.getNativeHeapFreeSize() / 1024);
            sb.append(" kB\n");
            try {
                ActivityManager activityManager = (ActivityManager) UMGlobalContext.getAppContext().getSystemService("activity");
                if (activityManager != null) {
                    ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                    activityManager.getMemoryInfo(memoryInfo);
                    sb.append("availMem:   ");
                    sb.append(memoryInfo.availMem / 1024);
                    sb.append(" kB\n");
                    sb.append("threshold:  ");
                    sb.append(memoryInfo.threshold / 1024);
                    sb.append(" kB\n");
                    sb.append("lowMemory:  ");
                    sb.append(memoryInfo.lowMemory);
                }
            } catch (Throwable unused) {
            }
            sb.append(UMCustomLogInfoBuilder.LINE_SEP);
            return sb.toString();
        } catch (Throwable unused2) {
            return "";
        }
    }

    public static String a(Context context) {
        try {
            Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver == null) {
                return "";
            }
            int intExtra = registerReceiver.getIntExtra("level", -1);
            int intExtra2 = registerReceiver.getIntExtra("voltage", -1);
            int intExtra3 = registerReceiver.getIntExtra("temperature", -1);
            int intExtra4 = registerReceiver.getIntExtra(cl.i, -1);
            int i = 0;
            int i2 = intExtra4 == 1 ? -1 : intExtra4 == 2 ? 1 : intExtra4 == 5 ? 2 : 0;
            int intExtra5 = registerReceiver.getIntExtra("plugged", -1);
            if (intExtra5 == 1) {
                i = 1;
            } else if (intExtra5 == 2) {
                i = 2;
            }
            return "level: " + intExtra + "\nscale: " + registerReceiver.getIntExtra("scale", -1) + "\nhealth: " + registerReceiver.getIntExtra("health", -1) + "\npluged: " + i + "\nstatus: " + i2 + "\nvoltage: " + intExtra2 + "\ntemperature: " + intExtra3 + "\ntechnology: " + registerReceiver.getStringExtra("technology") + UMCustomLogInfoBuilder.LINE_SEP;
        } catch (Throwable unused) {
            return "";
        }
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    private static long b(StatFs statFs) {
        return statFs.getBlockSizeLong();
    }

    public static String b() {
        BufferedReader bufferedReader;
        StringBuilder sb = new StringBuilder();
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), CacheIOHelper.BUFFER_SIZE);
            int i = 0;
            do {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine.trim());
                    sb.append(UMCustomLogInfoBuilder.LINE_SEP);
                    i++;
                } catch (Throwable unused) {
                }
            } while (i < 500);
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
        a(bufferedReader);
        sb.append(UMCustomLogInfoBuilder.LINE_SEP);
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005f A[Catch: all -> 0x0079, TryCatch #0 {all -> 0x0079, blocks: (B:3:0x0002, B:5:0x0029, B:9:0x003f, B:12:0x0064, B:16:0x005f, B:17:0x003a), top: B:2:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String b(android.content.Context r12) {
        /*
            java.lang.String r0 = "total:      "
            java.io.File r12 = r12.getFilesDir()     // Catch: java.lang.Throwable -> L79
            java.lang.String r12 = r12.getParent()     // Catch: java.lang.Throwable -> L79
            android.os.StatFs r1 = new android.os.StatFs     // Catch: java.lang.Throwable -> L79
            r1.<init>(r12)     // Catch: java.lang.Throwable -> L79
            long r2 = b(r1)     // Catch: java.lang.Throwable -> L79
            long r4 = a(r1)     // Catch: java.lang.Throwable -> L79
            long r4 = r4 * r2
            long r6 = c(r1)     // Catch: java.lang.Throwable -> L79
            long r6 = r6 * r2
            com.efs.sdk.base.core.config.GlobalEnvStruct r12 = com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct()     // Catch: java.lang.Throwable -> L79
            com.efs.sdk.base.UMAPMCustomController r12 = r12.getCustomController()     // Catch: java.lang.Throwable -> L79
            r8 = -1
            if (r12 == 0) goto L3a
            com.efs.sdk.base.core.config.GlobalEnvStruct r12 = com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct()     // Catch: java.lang.Throwable -> L79
            com.efs.sdk.base.UMAPMCustomController r12 = r12.getCustomController()     // Catch: java.lang.Throwable -> L79
            boolean r12 = r12.isCanUseRemainingStorageSpace()     // Catch: java.lang.Throwable -> L79
            if (r12 == 0) goto L38
            goto L3a
        L38:
            r10 = r8
            goto L3f
        L3a:
            long r10 = d(r1)     // Catch: java.lang.Throwable -> L79
            long r10 = r10 * r2
        L3f:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L79
            r12.<init>(r0)     // Catch: java.lang.Throwable -> L79
            r0 = 1024(0x400, double:5.06E-321)
            long r4 = r4 / r0
            r12.append(r4)     // Catch: java.lang.Throwable -> L79
            java.lang.String r4 = " kB\navailable:  "
            r12.append(r4)     // Catch: java.lang.Throwable -> L79
            long r6 = r6 / r0
            r12.append(r6)     // Catch: java.lang.Throwable -> L79
            java.lang.String r4 = " kB\nfree:       "
            r12.append(r4)     // Catch: java.lang.Throwable -> L79
            int r4 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r4 != 0) goto L5f
            java.lang.String r0 = "null"
            goto L64
        L5f:
            long r10 = r10 / r0
            java.lang.Long r0 = java.lang.Long.valueOf(r10)     // Catch: java.lang.Throwable -> L79
        L64:
            r12.append(r0)     // Catch: java.lang.Throwable -> L79
            java.lang.String r0 = " kB\nblock size: "
            r12.append(r0)     // Catch: java.lang.Throwable -> L79
            r12.append(r2)     // Catch: java.lang.Throwable -> L79
            java.lang.String r0 = " B\n"
            r12.append(r0)     // Catch: java.lang.Throwable -> L79
            java.lang.String r12 = r12.toString()     // Catch: java.lang.Throwable -> L79
            return r12
        L79:
            java.lang.String r12 = ""
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.efs.sdk.memleaksdk.monitor.internal.df.b(android.content.Context):java.lang.String");
    }

    private static long c(StatFs statFs) {
        return statFs.getAvailableBlocksLong();
    }

    private static long d(StatFs statFs) {
        return statFs.getFreeBlocksLong();
    }
}
