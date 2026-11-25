package com.umeng.crash;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Debug;
import android.os.Looper;
import android.os.Process;
import android.system.Os;
import android.text.TextUtils;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.umeng.analytics.pro.cl;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.umcrash.UMCrash;
import com.umeng.umcrash.custom_exception.UMCustomLogInfoBuilder;
import com.zzhoujay.richtext.cache.CacheIOHelper;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /tmp/classes2.dex */
public final class m {
    private static final String[] a = {"/data/local/su", "/data/local/bin/su", "/data/local/xbin/su", "/system/xbin/su", "/system/bin/su", "/system/bin/.ext/su", "/system/bin/failsafe/su", "/system/sd/xbin/su", "/system/usr/we-need-root/su", "/sbin/su", "/su/bin/su"};

    public static ActivityManager.ProcessErrorStateInfo a() {
        ActivityManager activityManager = (ActivityManager) UMGlobalContext.getAppContext().getSystemService("activity");
        if (activityManager == null) {
            return null;
        }
        int myPid = Process.myPid();
        for (int i = 0; i < 50; i++) {
            List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
            if (processesInErrorState != null) {
                if (i % 2 == 0) {
                    UCrash.a().a("UCrash.Utils", "state not null. times:" + (i / 2));
                }
                for (ActivityManager.ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
                    if (processErrorStateInfo.pid == myPid && processErrorStateInfo.condition == 2) {
                        UCrash.a().b("UCrash.Utils", "anr info.pid:" + processErrorStateInfo.pid + ", info.condition:" + processErrorStateInfo.condition);
                        return processErrorStateInfo;
                    }
                }
            } else if (i % 2 == 0) {
                UCrash.a().a("UCrash.Utils", "state empty. total:25, times:" + (i / 2));
            }
            try {
                Thread.sleep(500L);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static String a(Context context) {
        return UMFrUtils.getCurrentProcessName(context);
    }

    public static String a(String str) {
        StringBuilder sb = new StringBuilder("java stacktrace:\n");
        Iterator<Map.Entry<Thread, StackTraceElement[]>> it = Thread.getAllStackTraces().entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<Thread, StackTraceElement[]> next = it.next();
            if (TextUtils.equals(str, next.getKey().getName())) {
                StackTraceElement[] value = next.getValue();
                for (StackTraceElement stackTraceElement : value) {
                    sb.append("\tat ");
                    sb.append(stackTraceElement.toString());
                    sb.append(UMCustomLogInfoBuilder.LINE_SEP);
                }
            }
        }
        return sb.toString();
    }

    public static String a(String str, long j, String str2) {
        c a2 = c.a();
        e a3 = e.a();
        Locale locale = Locale.US;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss", locale);
        StringBuilder sb = new StringBuilder("*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** ***\n");
        sb.append(String.format(locale, "Basic Information: 'pid: %d/tid: %d/time: %s'\n", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()), simpleDateFormat.format(Long.valueOf(j))));
        sb.append(String.format(locale, "Cpu Information: 'abi: %s/%s'\n", TextUtils.join(",", Build.SUPPORTED_ABIS), q()));
        String[] o = o();
        sb.append(String.format(locale, "Mobile Information: 'model: %s/version: %s/sdk: %s'\n", p(), o[0], o[1]));
        if (ControllerCenter.getGlobalEnvStruct().getCustomController() == null || (ControllerCenter.getGlobalEnvStruct().getCustomController().isCanUseDeviceModel() && ControllerCenter.getGlobalEnvStruct().getCustomController().isCanUseSystemVersion())) {
            sb.append(String.format(locale, "Build fingerprint: '%s'\n", Build.FINGERPRINT));
        } else {
            sb.append(String.format(locale, "Build fingerprint: '%s'\n", "UNKNOWN"));
        }
        sb.append(String.format(locale, "Runtime Information: 'start: %s/maxheap: %d/primaryabi: %s/ground: %s'\n", simpleDateFormat.format(Long.valueOf(a2.k)), Long.valueOf(Runtime.getRuntime().maxMemory()), a2.i, a3.a ? "fg" : "bg"));
        sb.append(String.format(locale, "Application Information: 'version: %s/versioncode: %s'\n", a2.g, a2.h));
        sb.append(String.format(locale, "CrashSDK Information: 'version: %s'\n", "1.1.1"));
        sb.append(String.format(locale, "Report Name: %s\n", str2));
        sb.append(String.format(locale, "UUID: %s\n", r()));
        sb.append(String.format(locale, "Log Type: %s\n", str));
        if ("anr".equals(str) || "jni".equals(str)) {
            sb.append(String.format(locale, "Build time: %s\n", Long.valueOf(Build.TIME)));
            sb.append(String.format(locale, "Build version incremental: %s\n", Build.VERSION.INCREMENTAL));
        }
        sb.append(String.format(locale, "Activity: %s\n", TextUtils.isEmpty(a3.b) ? "null" : a3.b));
        return sb.toString();
    }

    private static String a(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    public static String a(boolean z) {
        return String.format(Locale.US, "recent status:\nlast version: '%s'\ndumping all threads: %s\n", c.a().d, Boolean.valueOf(z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [int] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.io.Closeable] */
    private static void a(int i, StringBuilder sb, String str, int i2, char c) {
        Throwable th;
        BufferedReader bufferedReader;
        Exception e;
        String num = Integer.toString(i);
        ArrayList arrayList = new ArrayList();
        arrayList.add("/system/bin/logcat");
        arrayList.add("-b");
        arrayList.add(str);
        arrayList.add("-d");
        arrayList.add("-v");
        arrayList.add("threadtime");
        arrayList.add("-t");
        arrayList.add(Integer.toString(i2));
        arrayList.add("--pid");
        arrayList.add(num);
        arrayList.add("*:".concat(String.valueOf(c)));
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(new ProcessBuilder(new String[0]).command(arrayList).start().getInputStream()));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            k.a(bufferedReader);
                            return;
                        } else {
                            sb.append(readLine);
                            sb.append(UMCustomLogInfoBuilder.LINE_SEP);
                        }
                    } catch (Exception e2) {
                        e = e2;
                        UCrash.a().a("UCrash.Utils", "get logcat failed", e);
                        k.a(bufferedReader);
                        return;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                k.a((Closeable) i2);
                throw th;
            }
        } catch (Exception e3) {
            bufferedReader = null;
            e = e3;
        } catch (Throwable th3) {
            i2 = 0;
            th = th3;
            k.a((Closeable) i2);
            throw th;
        }
    }

    public static String b() {
        String str;
        StringBuilder sb = new StringBuilder();
        try {
            File[] listFiles = new File("/proc/self/fd").listFiles(new FilenameFilter() { // from class: com.umeng.crash.m.1
                @Override // java.io.FilenameFilter
                public final boolean accept(File file, String str2) {
                    return TextUtils.isDigitsOnly(str2);
                }
            });
            if (listFiles != null) {
                sb.append("opened file count: ");
                sb.append(listFiles.length);
                sb.append(", write limit: 0\n");
                sb.append("opened files:\n");
                for (File file : listFiles) {
                    try {
                        str = Os.readlink(file.getAbsolutePath());
                    } catch (Throwable unused) {
                        str = null;
                    }
                    try {
                        if (TextUtils.isEmpty(str)) {
                            str = file.getCanonicalPath();
                        }
                    } catch (Exception unused2) {
                    }
                    sb.append(file.getName());
                    sb.append(" -> ");
                    sb.append(TextUtils.isEmpty(str) ? "" : str.trim());
                    sb.append('\n');
                }
            }
        } catch (Throwable unused3) {
        }
        sb.append('\n');
        return sb.toString();
    }

    public static String b(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            Field declaredField = ApplicationInfo.class.getDeclaredField("primaryCpuAbi");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(applicationInfo);
            return obj instanceof String ? (String) obj : "";
        } catch (Throwable th) {
            UCrash.a().a("UCrash.Utils", "get primary cpu abi failed", th);
            return "";
        }
    }

    public static String b(String str) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
            Thread key = entry.getKey();
            StackTraceElement[] value = entry.getValue();
            if (!TextUtils.equals(str, key.getName()) && value != null && value.length != 0) {
                sb.append("--- --- --- ---\ntid: ");
                sb.append(key.getId());
                sb.append(", name: ");
                sb.append(key.getName());
                sb.append("\njava stacktrace:\n");
                for (StackTraceElement stackTraceElement : value) {
                    sb.append("\tat ");
                    sb.append(stackTraceElement.toString());
                    sb.append(UMCustomLogInfoBuilder.LINE_SEP);
                }
            }
        }
        return sb.toString();
    }

    public static String c() {
        int myPid = Process.myPid();
        StringBuilder sb = new StringBuilder();
        sb.append("logcat:\n");
        c a2 = c.a();
        int i = a2.l;
        if (i > 0) {
            a(myPid, sb, "main", i, 'D');
        }
        int i2 = a2.m;
        if (i2 > 0) {
            a(myPid, sb, "system", i2, 'W');
        }
        int i3 = a2.n;
        if (i3 > 0) {
            a(myPid, sb, com.umeng.analytics.pro.g.ax, i3, 'I');
        }
        return sb.toString();
    }

    public static String c(Context context) {
        return UMUtils.getAppkey(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x005f A[Catch: all -> 0x0079, TryCatch #0 {all -> 0x0079, blocks: (B:2:0x0000, B:4:0x001f, B:8:0x0035, B:11:0x0064, B:15:0x005f, B:16:0x0030), top: B:1:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String c(java.lang.String r14) {
        /*
            android.os.StatFs r0 = new android.os.StatFs     // Catch: java.lang.Throwable -> L79
            r0.<init>(r14)     // Catch: java.lang.Throwable -> L79
            long r1 = r0.getBlockSizeLong()     // Catch: java.lang.Throwable -> L79
            long r3 = r0.getBlockCountLong()     // Catch: java.lang.Throwable -> L79
            long r3 = r3 * r1
            long r5 = r0.getAvailableBlocksLong()     // Catch: java.lang.Throwable -> L79
            long r5 = r5 * r1
            com.efs.sdk.base.core.config.GlobalEnvStruct r7 = com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct()     // Catch: java.lang.Throwable -> L79
            com.efs.sdk.base.UMAPMCustomController r7 = r7.getCustomController()     // Catch: java.lang.Throwable -> L79
            r8 = -1
            if (r7 == 0) goto L30
            com.efs.sdk.base.core.config.GlobalEnvStruct r7 = com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct()     // Catch: java.lang.Throwable -> L79
            com.efs.sdk.base.UMAPMCustomController r7 = r7.getCustomController()     // Catch: java.lang.Throwable -> L79
            boolean r7 = r7.isCanUseRemainingStorageSpace()     // Catch: java.lang.Throwable -> L79
            if (r7 == 0) goto L2e
            goto L30
        L2e:
            r10 = r8
            goto L35
        L30:
            long r10 = r0.getFreeBlocksLong()     // Catch: java.lang.Throwable -> L79
            long r10 = r10 * r1
        L35:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L79
            java.lang.String r7 = "disk info:\n"
            r0.<init>(r7)     // Catch: java.lang.Throwable -> L79
            r0.append(r14)     // Catch: java.lang.Throwable -> L79
            java.lang.String r14 = ":\n  total:      "
            r0.append(r14)     // Catch: java.lang.Throwable -> L79
            r12 = 1024(0x400, double:5.06E-321)
            long r3 = r3 / r12
            r0.append(r3)     // Catch: java.lang.Throwable -> L79
            java.lang.String r14 = " kB\n  available:  "
            r0.append(r14)     // Catch: java.lang.Throwable -> L79
            long r5 = r5 / r12
            r0.append(r5)     // Catch: java.lang.Throwable -> L79
            java.lang.String r14 = " kB\n  free:       "
            r0.append(r14)     // Catch: java.lang.Throwable -> L79
            int r14 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r14 != 0) goto L5f
            java.lang.String r14 = "null"
            goto L64
        L5f:
            long r10 = r10 / r12
            java.lang.Long r14 = java.lang.Long.valueOf(r10)     // Catch: java.lang.Throwable -> L79
        L64:
            r0.append(r14)     // Catch: java.lang.Throwable -> L79
            java.lang.String r14 = " kB\n  block size: "
            r0.append(r14)     // Catch: java.lang.Throwable -> L79
            r0.append(r1)     // Catch: java.lang.Throwable -> L79
            java.lang.String r14 = " B\n"
            r0.append(r14)     // Catch: java.lang.Throwable -> L79
            java.lang.String r14 = r0.toString()     // Catch: java.lang.Throwable -> L79
            return r14
        L79:
            r14 = move-exception
            com.umeng.crash.g r0 = com.umeng.crash.UCrash.a()
            java.lang.String r1 = "UCrash.Utils"
            java.lang.String r2 = "getDiskInfoImpl"
            r0.a(r1, r2, r14)
            java.lang.String r14 = "\n"
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.crash.m.c(java.lang.String):java.lang.String");
    }

    public static String d(Context context) {
        return DeviceConfig.getAppVersionName(context);
    }

    public static boolean d() {
        return SdkVersion.MINI_VERSION.equals(a("debug.umeng.apm", "0"));
    }

    public static String e() {
        try {
            StringBuilder sb = new StringBuilder("memory info:\nJavaMax:    ");
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

    public static String e(Context context) {
        return DeviceConfig.getAppVersionCode(context);
    }

    public static String f() {
        BufferedReader bufferedReader;
        StringBuilder sb = new StringBuilder("meminfo:\n");
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
        k.a(bufferedReader);
        sb.append(UMCustomLogInfoBuilder.LINE_SEP);
        return sb.toString();
    }

    public static String g() {
        BufferedReader bufferedReader;
        StringBuilder sb = new StringBuilder("limits:\n");
        try {
            bufferedReader = new BufferedReader(new FileReader(String.format(Locale.US, "/proc/%d/limits", Integer.valueOf(Process.myPid()))), CacheIOHelper.BUFFER_SIZE);
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
            } while (i < 100);
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
        k.a(bufferedReader);
        sb.append(UMCustomLogInfoBuilder.LINE_SEP);
        return sb.toString();
    }

    public static String h() {
        BufferedReader bufferedReader;
        StringBuilder sb = new StringBuilder("status:\n");
        try {
            bufferedReader = new BufferedReader(new FileReader(String.format(Locale.US, "/proc/%d/status", Integer.valueOf(Process.myPid()))), CacheIOHelper.BUFFER_SIZE);
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
            } while (i < 200);
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
        k.a(bufferedReader);
        sb.append(UMCustomLogInfoBuilder.LINE_SEP);
        return sb.toString();
    }

    public static String i() {
        StringBuilder sb = new StringBuilder("um_app_key: ");
        Map<String, String> b = c.a().b();
        String remove = b.remove(UMCrash.KEY_HEADER_APPKEY);
        if (TextUtils.isEmpty(remove)) {
            remove = UMUtils.getAppkey(UMGlobalContext.getAppContext());
        }
        sb.append(remove);
        sb.append(UMCustomLogInfoBuilder.LINE_SEP);
        for (Map.Entry<String, String> entry : b.entrySet()) {
            String key = entry.getKey();
            if (key != null) {
                String value = entry.getValue();
                if (value == null) {
                    value = "";
                }
                sb.append(key);
                sb.append(": ");
                sb.append(value);
                sb.append(UMCustomLogInfoBuilder.LINE_SEP);
            }
        }
        return sb.toString();
    }

    public static String j() {
        try {
            Intent registerReceiver = UMGlobalContext.getAppContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver == null) {
                return "null\n";
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
            return "battery info:\nlevel: " + intExtra + "\nscale: " + registerReceiver.getIntExtra("scale", -1) + "\nhealth: " + registerReceiver.getIntExtra("health", -1) + "\npluged: " + i + "\nstatus: " + i2 + "\nvoltage: " + intExtra2 + "\ntemperature: " + intExtra3 + "\ntechnology: " + registerReceiver.getStringExtra("technology") + UMCustomLogInfoBuilder.LINE_SEP;
        } catch (Throwable th) {
            UCrash.a().a("UCrash.Utils", "getBatteryInfo", th);
            return "null\n";
        }
    }

    public static String k() {
        try {
            return c(UMGlobalContext.getAppContext().getFilesDir().getParent());
        } catch (Throwable th) {
            UCrash.a().a("UCrash.Utils", "getDiskInfo", th);
            return UMCustomLogInfoBuilder.LINE_SEP;
        }
    }

    public static String l() {
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper != null) {
            return mainLooper.getThread().getName();
        }
        return null;
    }

    public static String m() {
        return String.format(Locale.US, "device status:\nhas root: %s\nbuild tags: %s\n", Boolean.valueOf(n()), Build.TAGS);
    }

    private static boolean n() {
        try {
            for (String str : a) {
                if (new File(str).exists()) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    private static String[] o() {
        String[] strArr = {"UNKNOWN", "0"};
        try {
            if (ControllerCenter.getGlobalEnvStruct().getCustomController() == null || ControllerCenter.getGlobalEnvStruct().getCustomController().isCanUseSystemVersion()) {
                strArr[0] = Build.VERSION.RELEASE;
                StringBuilder sb = new StringBuilder();
                sb.append(Build.VERSION.SDK_INT);
                strArr[1] = sb.toString();
            }
        } catch (Throwable unused) {
        }
        return strArr;
    }

    private static String p() {
        String str;
        if (ControllerCenter.getGlobalEnvStruct().getCustomController() != null && !ControllerCenter.getGlobalEnvStruct().getCustomController().isCanUseDeviceModel()) {
            return "UNKNOWN";
        }
        if (TextUtils.isEmpty(a("ro.miui.ui.version.name", ""))) {
            str = null;
        } else {
            try {
                str = a("ro.product.marketname", "");
                try {
                    if (TextUtils.isEmpty(str)) {
                        str = a("ro.product.model", "");
                    }
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
                str = "";
            }
        }
        if (TextUtils.isEmpty(str)) {
            str = Build.MODEL;
        }
        return str == null ? "" : str;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0056 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String q() {
        /*
            r0 = 0
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L4a
            java.io.FileReader r2 = new java.io.FileReader     // Catch: java.lang.Throwable -> L4a
            java.lang.String r3 = "/proc/cpuinfo"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L4a
            r3 = 512(0x200, float:7.17E-43)
            r1.<init>(r2, r3)     // Catch: java.lang.Throwable -> L4a
            r2 = 0
            r3 = r2
            r2 = r0
        L12:
            java.lang.String r4 = r1.readLine()     // Catch: java.lang.Throwable -> L46
            if (r4 == 0) goto L42
            java.lang.String r5 = ":"
            int r5 = r4.indexOf(r5)     // Catch: java.lang.Throwable -> L46
            int r5 = r5 + 1
            java.lang.String r5 = r4.substring(r5)     // Catch: java.lang.Throwable -> L46
            java.lang.String r5 = r5.trim()     // Catch: java.lang.Throwable -> L46
            java.lang.String r6 = "Hardware"
            boolean r6 = r4.startsWith(r6)     // Catch: java.lang.Throwable -> L46
            if (r6 == 0) goto L34
            int r3 = r3 + 1
            r0 = r5
            goto L3f
        L34:
            java.lang.String r6 = "Processor"
            boolean r4 = r4.startsWith(r6)     // Catch: java.lang.Throwable -> L46
            if (r4 == 0) goto L3f
            int r3 = r3 + 1
            r2 = r5
        L3f:
            r4 = 2
            if (r3 < r4) goto L12
        L42:
            com.umeng.crash.k.a(r1)
            goto L50
        L46:
            r7 = r1
            r1 = r0
            r0 = r7
            goto L4c
        L4a:
            r1 = r0
            r2 = r1
        L4c:
            com.umeng.crash.k.a(r0)
            r0 = r1
        L50:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L58
            java.lang.String r0 = android.os.Build.HARDWARE     // Catch: java.lang.Throwable -> L58
        L58:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r3 = "-"
            if (r1 == 0) goto L61
            r0 = r3
        L61:
            boolean r1 = android.text.TextUtils.isEmpty(r2)
            if (r1 == 0) goto L68
            r2 = r3
        L68:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "processor: "
            r1.<init>(r3)
            r1.append(r2)
            java.lang.String r2 = "/hardware: "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.crash.m.q():java.lang.String");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x005f A[Catch: all -> 0x0056, TRY_ENTER, TryCatch #0 {all -> 0x0056, blocks: (B:47:0x0052, B:15:0x005f, B:18:0x0069, B:20:0x0073, B:24:0x007d, B:29:0x0094, B:33:0x0099), top: B:46:0x0052 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0073 A[Catch: all -> 0x0056, TryCatch #0 {all -> 0x0056, blocks: (B:47:0x0052, B:15:0x005f, B:18:0x0069, B:20:0x0073, B:24:0x007d, B:29:0x0094, B:33:0x0099), top: B:46:0x0052 }] */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String r() {
        /*
            r0 = 0
            android.content.Context r1 = com.umeng.commonsdk.service.UMGlobalContext.getAppContext()     // Catch: java.lang.Throwable -> L9d
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L9d
            java.io.File r1 = r1.getFilesDir()     // Catch: java.lang.Throwable -> L9d
            java.lang.String r1 = r1.getParent()     // Catch: java.lang.Throwable -> L9d
            java.lang.String r3 = "crashsdk/tags"
            r2.<init>(r1, r3)     // Catch: java.lang.Throwable -> L9d
            boolean r1 = r2.exists()     // Catch: java.lang.Throwable -> L9d
            if (r1 == 0) goto L23
            boolean r1 = r2.isDirectory()     // Catch: java.lang.Throwable -> L9d
            if (r1 != 0) goto L23
            r2.delete()     // Catch: java.lang.Throwable -> L9d
        L23:
            boolean r1 = r2.exists()     // Catch: java.lang.Throwable -> L9d
            if (r1 != 0) goto L2c
            r2.mkdirs()     // Catch: java.lang.Throwable -> L9d
        L2c:
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L9d
            java.lang.String r3 = "unique"
            r1.<init>(r2, r3)     // Catch: java.lang.Throwable -> L9d
            boolean r2 = r1.exists()     // Catch: java.lang.Throwable -> L9d
            if (r2 == 0) goto L5c
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L58
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L58
            r3 = 48
            byte[] r3 = new byte[r3]     // Catch: java.lang.Throwable -> L59
            int r4 = r2.read(r3)     // Catch: java.lang.Throwable -> L59
            if (r4 > 0) goto L4c
            com.umeng.crash.k.a(r2)     // Catch: java.lang.Throwable -> L9d
            return r0
        L4c:
            java.lang.String r5 = new java.lang.String     // Catch: java.lang.Throwable -> L59
            r6 = 0
            r5.<init>(r3, r6, r4)     // Catch: java.lang.Throwable -> L59
            com.umeng.crash.k.a(r2)     // Catch: java.lang.Throwable -> L56
            goto L5d
        L56:
            r0 = r5
            goto L9d
        L58:
            r2 = r0
        L59:
            com.umeng.crash.k.a(r2)     // Catch: java.lang.Throwable -> L9d
        L5c:
            r5 = r0
        L5d:
            if (r5 == 0) goto L71
            int r2 = r5.length()     // Catch: java.lang.Throwable -> L56
            r3 = 36
            if (r2 == r3) goto L69
            r5 = r0
            goto L71
        L69:
            java.lang.String r2 = "[^0-9a-zA-Z-]"
            java.lang.String r3 = "-"
            java.lang.String r5 = r5.replaceAll(r2, r3)     // Catch: java.lang.Throwable -> L56
        L71:
            if (r5 == 0) goto L7d
            java.lang.String r2 = r5.trim()     // Catch: java.lang.Throwable -> L56
            boolean r2 = r2.isEmpty()     // Catch: java.lang.Throwable -> L56
            if (r2 == 0) goto L9e
        L7d:
            java.util.UUID r2 = java.util.UUID.randomUUID()     // Catch: java.lang.Throwable -> L56
            java.lang.String r5 = r2.toString()     // Catch: java.lang.Throwable -> L56
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L99
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L99
            byte[] r0 = r5.getBytes()     // Catch: java.lang.Throwable -> L98
            r2.write(r0)     // Catch: java.lang.Throwable -> L98
            r2.flush()     // Catch: java.lang.Throwable -> L98
            com.umeng.crash.k.a(r2)     // Catch: java.lang.Throwable -> L56
            goto L9e
        L98:
            r0 = r2
        L99:
            com.umeng.crash.k.a(r0)     // Catch: java.lang.Throwable -> L56
            goto L9e
        L9d:
            r5 = r0
        L9e:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.crash.m.r():java.lang.String");
    }
}
