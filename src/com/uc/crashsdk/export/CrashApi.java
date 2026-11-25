package com.uc.crashsdk.export;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.webkit.ValueCallback;
import com.uc.crashsdk.JNIBridge;
import com.uc.crashsdk.a.a;
import com.uc.crashsdk.a.d;
import com.uc.crashsdk.a.h;
import com.uc.crashsdk.b;
import com.uc.crashsdk.e;
import com.uc.crashsdk.g;
import com.umeng.umcrash.UMCrash;
import defpackage.ik;
import defpackage.m;
import defpackage.z60;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Callable;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: /tmp/classes2.dex */
public class CrashApi {
    private static CrashApi a = null;
    private static boolean c = true;
    private static boolean d = false;
    private boolean b;

    private CrashApi(Context context, CustomInfo customInfo, VersionInfo versionInfo, ICrashClient iCrashClient, boolean z, boolean z2, boolean z3) {
        this.b = false;
        Context a2 = a(context);
        b(a2);
        b.g = z2;
        b.h = z3;
        if (b.L()) {
            b(a2);
            a(a2, customInfo, versionInfo, iCrashClient);
            if (z) {
                a();
            }
            if (b.g && e.e("libcrashsdk.so")) {
                b.f = true;
                b();
                return;
            }
            return;
        }
        if (customInfo == null || versionInfo == null) {
            a.d("crashsdk", "VersionInfo and CustomInfo can not be null!");
            throw null;
        }
        g.a(customInfo);
        try {
            a(a2, customInfo, versionInfo, iCrashClient);
        } catch (Throwable th) {
            a(th);
        }
        if (z) {
            try {
                a();
            } catch (Throwable th2) {
                a(th2);
            }
        }
        try {
            b.M();
            h.a();
            d.a();
            com.uc.crashsdk.a.g.j();
        } catch (Throwable th3) {
            com.uc.crashsdk.a.g.a(th3);
        }
        try {
            if (!b.a(a2)) {
                a.d("crashsdk", "registerLifecycleCallbacks failed!");
            }
        } catch (Throwable th4) {
            com.uc.crashsdk.a.g.a(th4);
        }
        try {
            com.uc.crashsdk.a.n();
            try {
                e.A();
            } catch (Throwable th5) {
                com.uc.crashsdk.a.g.b(th5);
            }
            e.B();
        } catch (Throwable th6) {
            com.uc.crashsdk.a.g.a(th6);
        }
        try {
            if (g.s() && b.F() && !this.b) {
                e.G();
                this.b = true;
            }
        } catch (Throwable th7) {
            com.uc.crashsdk.a.g.b(th7);
        }
    }

    private static Context a(Context context) {
        if (context == null) {
            a.d("crashsdk", "context can not be null!");
            throw null;
        }
        if (!c || (context instanceof Application)) {
            return context;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null && (applicationContext instanceof Application)) {
            return applicationContext;
        }
        a.d("crashsdk", "Can not get Application context from given context!");
        ik.a("Can not get Application context from given context!");
        return null;
    }

    private static void a() {
        if (b.a) {
            a.b("Has enabled java log!");
            return;
        }
        e.s();
        e.o();
        b.a = true;
    }

    private static void a(Context context, CustomInfo customInfo, VersionInfo versionInfo, ICrashClient iCrashClient) {
        com.uc.crashsdk.d.a(iCrashClient);
        g.a(customInfo, versionInfo);
        if (b.L()) {
            return;
        }
        e.p();
        e.a(context);
        e.b(context);
    }

    private static void a(Throwable th) {
        new e().a(Thread.currentThread(), th, true);
    }

    private static boolean a(String str) {
        if (!b.L()) {
            return false;
        }
        a.d("crashsdk", "Can not call '" + str + "' in isolated process!");
        return true;
    }

    private static void b() {
        synchronized (b.e) {
            try {
                if (b.g && b.f) {
                    if (b.b) {
                        a.b("Has enabled native log!");
                        return;
                    }
                    c();
                    e.D();
                    b.b = true;
                    JNIBridge.cmd(6);
                    g.d();
                }
            } finally {
            }
        }
    }

    private static void b(Context context) {
        try {
            if (d) {
                return;
            }
            com.uc.crashsdk.a.g.a(context);
            com.uc.crashsdk.a.a = context.getPackageName();
            d = true;
        } catch (Throwable th) {
            a(th);
        }
    }

    private static void c() {
        if (b.d) {
            return;
        }
        g.b();
        JNIBridge.cmd(5);
        g.c();
        b.d = true;
    }

    public static synchronized CrashApi createInstance(Context context, CustomInfo customInfo, VersionInfo versionInfo, ICrashClient iCrashClient, boolean z, boolean z2, boolean z3) {
        CrashApi crashApi;
        synchronized (CrashApi.class) {
            try {
                if (a == null) {
                    a = new CrashApi(context, customInfo, versionInfo, iCrashClient, z, z2, z3);
                }
                crashApi = a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return crashApi;
    }

    public static CrashApi createInstanceEx(Context context, String str, boolean z) {
        return createInstanceEx(context, str, z, null);
    }

    public static CrashApi createInstanceEx(Context context, String str, boolean z, Bundle bundle) {
        return createInstanceEx(context, str, z, bundle, null);
    }

    public static CrashApi createInstanceEx(Context context, String str, boolean z, Bundle bundle, ICrashClient iCrashClient) {
        CrashApi crashApi = a;
        if (crashApi != null) {
            return crashApi;
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        c = bundle.getBoolean("useApplicationContext", true);
        Context a2 = a(context);
        b(a2);
        CustomInfo customInfo = new CustomInfo(str);
        customInfo.mEnableStatReport = false;
        customInfo.mZipLog = true;
        customInfo.mPrintStackInfos = z;
        bundle.putString("crver", "2.0");
        CustomInfo a3 = g.a(customInfo, bundle);
        VersionInfo a4 = g.a(bundle);
        boolean z2 = bundle.getBoolean(UMCrash.KEY_ENABLE_CRASH_JAVA, true);
        boolean z3 = bundle.getBoolean(UMCrash.KEY_ENABLE_CRASH_NATIVE, true);
        boolean z4 = bundle.getBoolean(UMCrash.KEY_ENABLE_CRASH_UNEXP, b.F());
        boolean z5 = bundle.getBoolean(UMCrash.KEY_ENABLE_ANR, true);
        CrashApi createInstance = createInstance(a2, a3, a4, iCrashClient, z2, z3, z4);
        createInstance.disableLog(805306368);
        b.a(z5);
        if (z3 || z4) {
            if (e.e("libcrashsdk.so")) {
                createInstance.crashSoLoaded();
            } else {
                a.d("crashsdk", "load libcrashsdk.so failed!");
            }
        }
        int i = bundle.getInt("uploadLogDelaySeconds", 15);
        if (i >= 0 && b.F()) {
            e.b(i);
        }
        return createInstance;
    }

    public static CrashApi getInstance() {
        return a;
    }

    public int addCachedInfo(String str, String str2) {
        if (str == null || str2 == null) {
            throw null;
        }
        return com.uc.crashsdk.a.b(str, str2);
    }

    public int addDumpFile(DumpFileInfo dumpFileInfo) {
        String str;
        dumpFileInfo.getClass();
        String str2 = dumpFileInfo.mCategory;
        if (str2 == null || (str = dumpFileInfo.mFileTobeDump) == null) {
            throw null;
        }
        int i = dumpFileInfo.mLogType;
        if ((1048849 & i) == 0) {
            return 0;
        }
        return com.uc.crashsdk.a.a(str2, str, dumpFileInfo.mIsEncrypted, dumpFileInfo.mWriteCategory, i, dumpFileInfo.mDeleteAfterDump);
    }

    public int addDumpFile(String str, String str2, int i, Bundle bundle) {
        DumpFileInfo dumpFileInfo = new DumpFileInfo(str, str2, i);
        if (bundle != null) {
            dumpFileInfo.mIsEncrypted = bundle.getBoolean("mIsEncrypted", dumpFileInfo.mIsEncrypted);
            dumpFileInfo.mWriteCategory = bundle.getBoolean("mWriteCategory", dumpFileInfo.mWriteCategory);
            dumpFileInfo.mDeleteAfterDump = bundle.getBoolean("mDeleteAfterDump", dumpFileInfo.mDeleteAfterDump);
        }
        return addDumpFile(dumpFileInfo);
    }

    public void addHeaderInfo(String str, String str2) {
        str.getClass();
        com.uc.crashsdk.a.a(str, str2);
    }

    public boolean addStatInfo(String str, String str2) {
        if (a("addStatInfo")) {
            return false;
        }
        if (com.uc.crashsdk.a.g.a(str)) {
            throw null;
        }
        if (str.length() > 24) {
            ik.a("key is too long!");
            return false;
        }
        if (str2 != null && str2.length() > 512) {
            str2 = str2.substring(0, IjkMediaMeta.FF_PROFILE_H264_CONSTRAINED);
        }
        return h.a(str, str2);
    }

    public void crashSoLoaded() {
        if (a("crashSoLoaded")) {
            return;
        }
        b.f = true;
        b();
        synchronized (b.e) {
            try {
                if (b.h && b.f && !b.c) {
                    if (!b.d) {
                        c();
                        g.d();
                    }
                    e.x();
                    b.c = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        com.uc.crashsdk.a.n();
        e.m();
    }

    public int createCachedInfo(String str, int i, int i2) {
        str.getClass();
        if (i <= 0) {
            ik.a("capacity must > 0!");
            return 0;
        }
        if ((1048849 & i2) == 0) {
            return 0;
        }
        return com.uc.crashsdk.a.a(str, i, i2);
    }

    public void disableLog(int i) {
        synchronized (b.e) {
            try {
                b.b(i);
                if (LogType.isForJava(i) && b.a) {
                    e.t();
                    b.a = false;
                }
                if (LogType.isForNative(i)) {
                    if (b.b) {
                        JNIBridge.cmd(9);
                        b.b = false;
                    } else {
                        b.g = false;
                    }
                }
                if (LogType.isForANR(i)) {
                    b.a(false);
                }
                if (LogType.isForUnexp(i)) {
                    if (!b.c) {
                        b.h = false;
                    } else if (e.z()) {
                        b.c = false;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean generateCustomLog(CustomLogInfo customLogInfo) {
        String str;
        StringBuilder sb;
        customLogInfo.getClass();
        if (customLogInfo.mData == null || (str = customLogInfo.mLogType) == null) {
            z60.a("mData or mLogType is null!");
            return false;
        }
        if (str.contains("_") || customLogInfo.mLogType.contains(" ")) {
            ik.a("mLogType can not contain char '_' and ' '");
            return false;
        }
        ArrayList<Integer> arrayList = customLogInfo.mDumpTids;
        if (arrayList == null || arrayList.size() <= 0) {
            sb = null;
        } else {
            sb = new StringBuilder();
            Iterator<Integer> it = customLogInfo.mDumpTids.iterator();
            while (it.hasNext()) {
                sb.append(it.next().intValue());
                sb.append(" ");
            }
        }
        long j = customLogInfo.mAddHeader ? 1L : 0L;
        if (customLogInfo.mAddFooter) {
            j |= 2;
        }
        if (customLogInfo.mAddLogcat) {
            j |= 4;
        }
        if (customLogInfo.mAddThreadsDump) {
            j |= 8;
        }
        if (customLogInfo.mAddBuildId) {
            j |= 16;
        }
        if (customLogInfo.mUploadNow) {
            j |= 32;
        }
        return e.a(customLogInfo.mData, customLogInfo.mLogType, j, customLogInfo.mDumpFiles, customLogInfo.mCallbacks, customLogInfo.mCachedInfos, sb != null ? sb.toString() : null);
    }

    public boolean generateCustomLog(StringBuffer stringBuffer, String str, Bundle bundle) {
        CustomLogInfo customLogInfo = new CustomLogInfo(stringBuffer, str);
        if (bundle != null) {
            customLogInfo.mAddHeader = bundle.getBoolean("mAddHeader", customLogInfo.mAddHeader);
            customLogInfo.mAddFooter = bundle.getBoolean("mAddFooter", customLogInfo.mAddFooter);
            customLogInfo.mAddLogcat = bundle.getBoolean("mAddLogcat", customLogInfo.mAddLogcat);
            customLogInfo.mUploadNow = bundle.getBoolean("mUploadNow", customLogInfo.mUploadNow);
            customLogInfo.mAddThreadsDump = bundle.getBoolean("mAddThreadsDump", customLogInfo.mAddThreadsDump);
            customLogInfo.mAddBuildId = bundle.getBoolean("mAddBuildId", customLogInfo.mAddBuildId);
            customLogInfo.mDumpFiles = bundle.getStringArrayList("mDumpFiles");
            customLogInfo.mCallbacks = bundle.getStringArrayList("mCallbacks");
            customLogInfo.mCachedInfos = bundle.getStringArrayList("mCachedInfos");
            customLogInfo.mDumpTids = bundle.getIntegerArrayList("mDumpTids");
        }
        return generateCustomLog(customLogInfo);
    }

    public boolean generateTraces(String str, long j) {
        if (a("generateTraces")) {
            return false;
        }
        if (b.d) {
            return JNIBridge.nativeCmd(12, j, str, null) == 1;
        }
        a.d("crashsdk", "Crash so is not loaded!");
        return false;
    }

    public String getCrashLogUploadUrl() {
        if (a("getCrashLogUploadUrl")) {
            return null;
        }
        return e.k();
    }

    public ParcelFileDescriptor getHostFd() {
        return e.E();
    }

    public ParcelFileDescriptor getIsolatedHostFd() {
        return e.E();
    }

    public int getLastExitType() {
        if (a("getLastExitType")) {
            return 1;
        }
        return b.I();
    }

    public int getLastExitTypeEx() {
        if (a("getLastExitTypeEx")) {
            return 1;
        }
        return b.J();
    }

    public Throwable getUncaughtException() {
        return e.v();
    }

    public int getUnexpReason() {
        if (a("getUnexpReason")) {
            return 100;
        }
        return e.w();
    }

    public void onExit() {
        b.w();
    }

    public boolean registerCallback(int i, ValueCallback<Bundle> valueCallback) {
        valueCallback.getClass();
        if (i == 1) {
            return com.uc.crashsdk.d.a(valueCallback);
        }
        if (i == 2) {
            return com.uc.crashsdk.d.c(valueCallback);
        }
        if (i == 3) {
            return com.uc.crashsdk.d.d(valueCallback);
        }
        if (i == 4) {
            return com.uc.crashsdk.d.b(valueCallback);
        }
        m.a("Unknown event type: ", i);
        return false;
    }

    public int registerInfoCallback(String str, int i) {
        str.getClass();
        if ((1048849 & i) == 0) {
            return 0;
        }
        return com.uc.crashsdk.a.a(str, i, null, 0L, 0);
    }

    public int registerInfoCallback(String str, int i, Callable<String> callable) {
        if (str == null || callable == null) {
            throw null;
        }
        if ((1048849 & i) == 0) {
            return 0;
        }
        return com.uc.crashsdk.a.a(str, i, callable, 0L, 0);
    }

    public int registerThread(int i, String str) {
        return com.uc.crashsdk.a.a(i, str);
    }

    public int reportCrashStats(boolean z) {
        if (a("reportCrashStats")) {
            return 0;
        }
        if (g.P()) {
            a.a("CrashApi::reportCrashStats. currentProcessOnly: " + z);
        }
        e.d(z);
        return e.e(z);
    }

    public int resetCrashStats(boolean z) {
        if (a("resetCrashStats")) {
            return 0;
        }
        if (g.P()) {
            a.a("CrashApi::resetCrashStats. currentProcessOnly: " + z);
        }
        return e.f(z);
    }

    public void setForeground(boolean z) {
        b.b(z);
    }

    public boolean setHostFd(ParcelFileDescriptor parcelFileDescriptor) {
        return e.a(parcelFileDescriptor);
    }

    public boolean setIsolatedHostFd(ParcelFileDescriptor parcelFileDescriptor) {
        return e.a(parcelFileDescriptor);
    }

    public void setNewInstall() {
        if (a("setNewInstall")) {
            return;
        }
        b.v();
    }

    public int updateCustomInfo(Bundle bundle) {
        bundle.getClass();
        return updateCustomInfo(g.a((CustomInfo) null, bundle));
    }

    public int updateCustomInfo(CustomInfo customInfo) {
        customInfo.getClass();
        return g.b(customInfo);
    }

    public boolean updateUnexpInfo() {
        if (a("updateUnexpInfo")) {
            return false;
        }
        return com.uc.crashsdk.a.a(true);
    }

    public void updateVersionInfo(Bundle bundle) {
        bundle.getClass();
        updateVersionInfo(g.a(bundle));
    }

    public void updateVersionInfo(VersionInfo versionInfo) {
        versionInfo.getClass();
        g.a(versionInfo);
    }

    public void uploadCrashLogs() {
        if (a("uploadCrashLogs")) {
            return;
        }
        e.a(false, true);
    }
}
