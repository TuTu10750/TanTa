package com.uc.crashsdk;

import android.os.Build;
import android.os.Bundle;
import com.uc.crashsdk.a.h;
import com.uc.crashsdk.export.CustomInfo;
import com.uc.crashsdk.export.VersionInfo;
import com.umeng.commonsdk.statistics.UMErrorCode;
import defpackage.ik;
import defpackage.jr4;
import java.io.File;
import java.lang.reflect.Field;

/* loaded from: /tmp/classes2.dex */
public class g {
    public static RuntimeException a = null;
    public static RuntimeException b = null;
    static final /* synthetic */ boolean c = true;
    private static CustomInfo d;
    private static VersionInfo e;
    private static String g;
    private static String h;
    private static String i;
    private static String j;
    private static final Object f = new Object();
    private static final Object k = new Object();

    public static String A() {
        return d.mCrashRateUploadUrl;
    }

    public static int B() {
        return d.mLogMaxBytesLimit;
    }

    public static int C() {
        return d.mLogMaxUploadBytesLimit;
    }

    public static long D() {
        return d.mMaxUploadBytesPerDay;
    }

    public static int E() {
        return d.mMaxUploadBuiltinLogCountPerDay;
    }

    public static int F() {
        return d.mMaxUploadCustomLogCountPerDay;
    }

    public static int G() {
        return d.mMaxCustomLogCountPerTypePerDay;
    }

    public static int H() {
        return d.mInfoUpdateInterval;
    }

    public static int I() {
        return d.mInfoSaveFrequency;
    }

    public static int J() {
        return d.mReservedJavaFileHandleCount;
    }

    public static int K() {
        return d.mFdDumpMinLimit;
    }

    public static int L() {
        return d.mThreadsDumpMinLimit;
    }

    public static boolean M() {
        return d.mAutoDetectLifeCycle;
    }

    public static boolean N() {
        return d.mMonitorBattery;
    }

    public static int O() {
        return d.mAnrTraceStrategy;
    }

    public static boolean P() {
        CustomInfo customInfo = d;
        return customInfo == null || customInfo.mDebug;
    }

    public static boolean Q() {
        CustomInfo customInfo = d;
        return customInfo == null || customInfo.mPrintStackInfos;
    }

    public static boolean R() {
        return d.mEnableStatReport;
    }

    public static boolean S() {
        return d.mIsInternational;
    }

    public static boolean T() {
        return d.mAddPvForNewDay;
    }

    public static String U() {
        return com.uc.crashsdk.a.g.a(e.mVersion) ? a.a() : a(e.mVersion);
    }

    public static String V() {
        return com.uc.crashsdk.a.g.a(e.mSubVersion) ? "release" : e.mSubVersion;
    }

    public static String W() {
        return com.uc.crashsdk.a.g.a(e.mBuildId) ? ae() : a(e.mBuildId);
    }

    public static String X() {
        if (h == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(com.uc.crashsdk.a.g.b());
            char c2 = File.separatorChar;
            sb.append(c2);
            sb.append(d.mTagFilesFolderName);
            sb.append(c2);
            h = sb.toString();
        }
        return h;
    }

    public static String Y() {
        if (i == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(com.uc.crashsdk.a.g.b());
            char c2 = File.separatorChar;
            sb.append(c2);
            sb.append(d.mCrashLogsFolderName);
            sb.append(c2);
            i = sb.toString();
        }
        return i;
    }

    public static String Z() {
        if (j == null) {
            if (com.uc.crashsdk.a.g.a(d.mLogsBackupPathName)) {
                StringBuilder sb = new StringBuilder();
                sb.append(com.uc.crashsdk.a.g.b());
                char c2 = File.separatorChar;
                sb.append(c2);
                sb.append("msdb");
                sb.append(c2);
                j = sb.toString() + c2 + d.mCrashLogsFolderName + c2;
            } else {
                String trim = d.mLogsBackupPathName.trim();
                String str = File.separator;
                if (!trim.endsWith(str)) {
                    trim = trim + str;
                }
                j = trim;
            }
        }
        return j;
    }

    public static CustomInfo a(CustomInfo customInfo, Bundle bundle) {
        if (customInfo == null) {
            CustomInfo customInfo2 = d;
            customInfo = customInfo2 == null ? new CustomInfo() : new CustomInfo(customInfo2);
        }
        Field[] fields = customInfo.getClass().getFields();
        for (String str : bundle.keySet()) {
            for (Field field : fields) {
                if (field.getName().equals(str)) {
                    Object obj = bundle.get(str);
                    try {
                        field.set(customInfo, obj);
                    } catch (Exception e2) {
                        com.uc.crashsdk.a.g.a(e2);
                        StringBuilder sb = new StringBuilder("Field ");
                        sb.append(str);
                        sb.append(" must be a ");
                        sb.append(field.getType().getName());
                        sb.append(", but give a ");
                        sb.append(obj != null ? obj.getClass().getName() : "(null)");
                        throw new IllegalArgumentException(sb.toString());
                    }
                }
            }
        }
        return customInfo;
    }

    public static VersionInfo a(Bundle bundle) {
        VersionInfo versionInfo = e;
        VersionInfo versionInfo2 = versionInfo == null ? new VersionInfo() : new VersionInfo(versionInfo);
        String string = bundle.getString("mVersion");
        if (!com.uc.crashsdk.a.g.a(string)) {
            versionInfo2.mVersion = string;
        }
        String string2 = bundle.getString("mSubVersion");
        if (!com.uc.crashsdk.a.g.a(string2)) {
            versionInfo2.mSubVersion = string2;
        }
        String string3 = bundle.getString("mBuildId");
        if (!com.uc.crashsdk.a.g.a(string3)) {
            versionInfo2.mBuildId = string3;
        }
        String string4 = bundle.getString("crver");
        if (!com.uc.crashsdk.a.g.a(string4)) {
            a.b = string4;
            af();
        }
        return versionInfo2;
    }

    private static String a(String str) {
        return (str == null || !str.contains("_")) ? str : str.replaceAll("_", "-");
    }

    public static void a() {
        b.y();
        b.x();
        if (d.mBackupLogs) {
            File file = new File(Z());
            if (file.exists()) {
                return;
            }
            file.mkdirs();
        }
    }

    public static void a(CustomInfo customInfo) {
        boolean z = c;
        if (!z && customInfo.mTagFilesFolderName == null) {
            jr4.a();
            return;
        }
        if (!z && customInfo.mCrashLogsFolderName == null) {
            jr4.a();
        } else if (customInfo.mTagFilesFolderName.equals(customInfo.mCrashLogsFolderName)) {
            ik.a("mTagFilesFolderName and mCrashLogsFolderName can not be set to the same!");
        }
    }

    public static void a(CustomInfo customInfo, VersionInfo versionInfo) {
        CustomInfo customInfo2 = new CustomInfo(customInfo);
        d = customInfo2;
        c(customInfo2);
        if (!d.mZipLog) {
            a = new RuntimeException("initialize set mZipLog to false, info.mZipLog: " + customInfo.mZipLog);
        }
        if (d.mEncryptLog) {
            b = new RuntimeException("initialize set mEncryptLog to true, info.mEncryptLog: " + customInfo.mEncryptLog);
        }
        e = new VersionInfo(versionInfo);
        if (b.L()) {
            return;
        }
        try {
            a();
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    public static void a(VersionInfo versionInfo) {
        synchronized (f) {
            try {
                e = new VersionInfo(versionInfo);
                e.c();
                if (b.d) {
                    JNIBridge.set(109, U());
                    JNIBridge.set(110, V());
                    JNIBridge.set(UMErrorCode.E_UM_BE_CREATE_FAILED, W());
                    JNIBridge.set(UMErrorCode.E_UM_BE_DEFLATE_FAILED, "240515102041");
                    JNIBridge.cmd(2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static boolean a(String str, String str2) {
        if (str == str2) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        return str.equals(str2);
    }

    public static boolean aa() {
        return d.mEnableCrpStat;
    }

    public static boolean ab() {
        return d.mEnableStatToWPKDirect;
    }

    public static String ac() {
        return d.mUserId;
    }

    public static String ad() {
        return d.mChannel;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0045, code lost:
    
        if (r1 == null) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String ae() {
        /*
            java.lang.String r0 = com.uc.crashsdk.g.g
            if (r0 == 0) goto L5
            return r0
        L5:
            r0 = 0
            java.util.zip.ZipFile r1 = new java.util.zip.ZipFile     // Catch: java.lang.Throwable -> L3a
            java.lang.String r2 = com.uc.crashsdk.a.g.c()     // Catch: java.lang.Throwable -> L3a
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L3a
            java.lang.String r0 = "classes.dex"
            java.util.zip.ZipEntry r0 = r1.getEntry(r0)     // Catch: java.lang.Throwable -> L38
            long r2 = r0.getCrc()     // Catch: java.lang.Throwable -> L38
            java.lang.String r0 = java.lang.Long.toHexString(r2)     // Catch: java.lang.Throwable -> L38
            com.uc.crashsdk.g.g = r0     // Catch: java.lang.Throwable -> L38
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L38
            java.lang.String r2 = "version unique build id: "
            r0.<init>(r2)     // Catch: java.lang.Throwable -> L38
            java.lang.String r2 = com.uc.crashsdk.g.g     // Catch: java.lang.Throwable -> L38
            r0.append(r2)     // Catch: java.lang.Throwable -> L38
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L38
            java.lang.String r2 = "crashsdk"
            com.uc.crashsdk.a.a.a(r2, r0)     // Catch: java.lang.Throwable -> L38
        L34:
            r1.close()     // Catch: java.lang.Throwable -> L48
            goto L48
        L38:
            r0 = move-exception
            goto L3e
        L3a:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L3e:
            java.lang.String r2 = ""
            com.uc.crashsdk.g.g = r2     // Catch: java.lang.Throwable -> L4b
            com.uc.crashsdk.a.g.a(r0)     // Catch: java.lang.Throwable -> L4b
            if (r1 == 0) goto L48
            goto L34
        L48:
            java.lang.String r0 = com.uc.crashsdk.g.g
            return r0
        L4b:
            r0 = move-exception
            if (r1 == 0) goto L51
            r1.close()     // Catch: java.lang.Throwable -> L51
        L51:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.g.ae():java.lang.String");
    }

    private static void af() {
        if (b.d) {
            JNIBridge.nativeSet(24, 1L, a.b, null);
        }
    }

    public static int b(CustomInfo customInfo) {
        int i2;
        int i3;
        boolean z;
        synchronized (k) {
            i2 = 0;
            if (customInfo != null) {
                try {
                    c(customInfo);
                    if (d == null) {
                        d = new CustomInfo();
                    }
                    CustomInfo customInfo2 = d;
                    boolean z2 = true;
                    if (a(customInfo.mAppId, customInfo2.mAppId)) {
                        i3 = 0;
                    } else {
                        String str = customInfo.mAppId;
                        customInfo2.mAppId = str;
                        if (b.d) {
                            JNIBridge.set(102, str);
                        }
                        i3 = 1;
                    }
                    int i4 = i3;
                    if (!a(customInfo.mJavaCrashLogFileName, customInfo2.mJavaCrashLogFileName)) {
                        customInfo2.mJavaCrashLogFileName = customInfo.mJavaCrashLogFileName;
                        i3++;
                    }
                    if (!a(customInfo.mNativeCrashLogFileName, customInfo2.mNativeCrashLogFileName)) {
                        String str2 = customInfo.mNativeCrashLogFileName;
                        customInfo2.mNativeCrashLogFileName = str2;
                        if (b.d) {
                            JNIBridge.set(100, str2);
                        }
                        i3++;
                        i4 = 1;
                    }
                    if (!a(customInfo.mUnexpCrashLogFileName, customInfo2.mUnexpCrashLogFileName)) {
                        String str3 = customInfo.mUnexpCrashLogFileName;
                        customInfo2.mUnexpCrashLogFileName = str3;
                        if (b.d) {
                            JNIBridge.set(101, str3);
                        }
                        i3++;
                        i4 = 1;
                    }
                    if (i4 != 0) {
                        e.c();
                        if (b.d) {
                            JNIBridge.cmd(2);
                        }
                    }
                    boolean z3 = customInfo2.mPrintStackInfos;
                    boolean z4 = customInfo.mPrintStackInfos;
                    if (z3 != z4) {
                        customInfo2.mPrintStackInfos = z4;
                        if (b.d) {
                            JNIBridge.set(11, z4);
                        }
                        i3++;
                    }
                    boolean z5 = customInfo2.mDebug;
                    boolean z6 = customInfo.mDebug;
                    if (z5 != z6) {
                        customInfo2.mDebug = z6;
                        if (b.d) {
                            JNIBridge.set(18, z6);
                        }
                        i3++;
                    }
                    boolean z7 = customInfo2.mBackupLogs;
                    boolean z8 = customInfo.mBackupLogs;
                    if (z7 != z8) {
                        customInfo2.mBackupLogs = z8;
                        if (b.d) {
                            JNIBridge.set(12, z8);
                        }
                        i3++;
                    }
                    boolean z9 = customInfo2.mOmitNativeCrash;
                    boolean z10 = customInfo.mOmitNativeCrash;
                    if (z9 != z10) {
                        customInfo2.mOmitNativeCrash = z10;
                        if (b.d) {
                            JNIBridge.set(21, z10);
                        }
                        i3++;
                    }
                    int i5 = customInfo2.mCrashRestartInterval;
                    int i6 = customInfo.mCrashRestartInterval;
                    if (i5 != i6) {
                        customInfo2.mCrashRestartInterval = i6;
                        if (b.d) {
                            JNIBridge.set(13, i6);
                        }
                        if (customInfo2.mCrashRestartInterval >= 0) {
                            b.M();
                        }
                        i3++;
                    }
                    int i7 = customInfo2.mMaxBuiltinLogFilesCount;
                    int i8 = customInfo.mMaxBuiltinLogFilesCount;
                    if (i7 != i8) {
                        customInfo2.mMaxBuiltinLogFilesCount = i8;
                        if (b.d) {
                            JNIBridge.set(14, i8);
                        }
                        i3++;
                    }
                    int i9 = customInfo2.mMaxNativeLogcatLineCount;
                    int i10 = customInfo.mMaxNativeLogcatLineCount;
                    if (i9 != i10) {
                        customInfo2.mMaxNativeLogcatLineCount = i10;
                        if (b.d) {
                            JNIBridge.set(15, i10);
                        }
                        i3++;
                    }
                    int i11 = customInfo2.mMaxJavaLogcatLineCount;
                    int i12 = customInfo.mMaxJavaLogcatLineCount;
                    if (i11 != i12) {
                        customInfo2.mMaxJavaLogcatLineCount = i12;
                        i3++;
                    }
                    int i13 = customInfo2.mMaxUnexpLogcatLineCount;
                    int i14 = customInfo.mMaxUnexpLogcatLineCount;
                    if (i13 != i14) {
                        customInfo2.mMaxUnexpLogcatLineCount = i14;
                        if (b.d) {
                            JNIBridge.set(16, i14);
                        }
                        i3++;
                    }
                    int i15 = customInfo2.mMaxAnrLogcatLineCount;
                    int i16 = customInfo.mMaxAnrLogcatLineCount;
                    if (i15 != i16) {
                        customInfo2.mMaxAnrLogcatLineCount = i16;
                        if (b.d) {
                            JNIBridge.set(31, i16);
                        }
                        i3++;
                    }
                    boolean z11 = customInfo2.mZipLog;
                    boolean z12 = customInfo.mZipLog;
                    if (z11 != z12) {
                        customInfo2.mZipLog = z12;
                        if (!z12) {
                            com.uc.crashsdk.a.a.d("DEBUG", "updateCustomInfoImpl set mZipLog to false");
                            a = new RuntimeException("updateCustomInfoImpl set mZipLog to false");
                        }
                        i3++;
                        z = true;
                    } else {
                        z = false;
                    }
                    if (a(customInfo.mZippedLogExtension, customInfo2.mZippedLogExtension)) {
                        z2 = z;
                    } else {
                        customInfo2.mZippedLogExtension = customInfo.mZippedLogExtension;
                        i3++;
                    }
                    if (z2 && b.d) {
                        JNIBridge.nativeSet(3, customInfo2.mZipLog ? 1L : 0L, customInfo2.mZippedLogExtension, null);
                    }
                    int i17 = customInfo2.mLogMaxBytesLimit;
                    int i18 = customInfo.mLogMaxBytesLimit;
                    if (i17 != i18) {
                        customInfo2.mLogMaxBytesLimit = i18;
                        if (b.d) {
                            JNIBridge.set(4, i18);
                        }
                        i3++;
                    }
                    boolean z13 = customInfo2.mEncryptLog;
                    boolean z14 = customInfo.mEncryptLog;
                    if (z13 != z14) {
                        customInfo2.mEncryptLog = z14;
                        if (z14) {
                            com.uc.crashsdk.a.a.d("DEBUG", "updateCustomInfoImpl set mEncryptLog to true");
                            b = new RuntimeException("updateCustomInfoImpl set mEncryptLog to true");
                        }
                        i3++;
                    }
                    boolean z15 = customInfo2.mSyncUploadSetupCrashLogs;
                    boolean z16 = customInfo.mSyncUploadSetupCrashLogs;
                    if (z15 != z16) {
                        customInfo2.mSyncUploadSetupCrashLogs = z16;
                        i3++;
                    }
                    boolean z17 = customInfo2.mSyncUploadLogs;
                    boolean z18 = customInfo.mSyncUploadLogs;
                    if (z17 != z18) {
                        customInfo2.mSyncUploadLogs = z18;
                        i3++;
                    }
                    int i19 = customInfo2.mMaxCustomLogFilesCount;
                    int i20 = customInfo.mMaxCustomLogFilesCount;
                    if (i19 != i20) {
                        customInfo2.mMaxCustomLogFilesCount = i20;
                        i3++;
                    }
                    boolean z19 = customInfo2.mOmitJavaCrash;
                    boolean z20 = customInfo.mOmitJavaCrash;
                    if (z19 != z20) {
                        customInfo2.mOmitJavaCrash = z20;
                        i3++;
                    }
                    int i21 = customInfo2.mLogMaxUploadBytesLimit;
                    int i22 = customInfo.mLogMaxUploadBytesLimit;
                    if (i21 != i22) {
                        customInfo2.mLogMaxUploadBytesLimit = i22;
                        i3++;
                    }
                    long j2 = customInfo2.mMaxUploadBytesPerDay;
                    long j3 = customInfo.mMaxUploadBytesPerDay;
                    if (j2 != j3) {
                        customInfo2.mMaxUploadBytesPerDay = j3;
                        i3++;
                    }
                    int i23 = customInfo2.mMaxUploadBuiltinLogCountPerDay;
                    int i24 = customInfo.mMaxUploadBuiltinLogCountPerDay;
                    if (i23 != i24) {
                        customInfo2.mMaxUploadBuiltinLogCountPerDay = i24;
                        i3++;
                    }
                    int i25 = customInfo2.mMaxUploadCustomLogCountPerDay;
                    int i26 = customInfo.mMaxUploadCustomLogCountPerDay;
                    if (i25 != i26) {
                        customInfo2.mMaxUploadCustomLogCountPerDay = i26;
                        i3++;
                    }
                    int i27 = customInfo2.mMaxCustomLogCountPerTypePerDay;
                    int i28 = customInfo.mMaxCustomLogCountPerTypePerDay;
                    if (i27 != i28) {
                        customInfo2.mMaxCustomLogCountPerTypePerDay = i28;
                        i3++;
                    }
                    int i29 = customInfo2.mMaxAnrLogCountPerProcess;
                    int i30 = customInfo.mMaxAnrLogCountPerProcess;
                    if (i29 != i30) {
                        customInfo2.mMaxAnrLogCountPerProcess = i30;
                        if (b.d) {
                            JNIBridge.set(32, d.mMaxAnrLogCountPerProcess);
                        }
                        i3++;
                    }
                    boolean z21 = customInfo2.mCallJavaDefaultHandler;
                    boolean z22 = customInfo.mCallJavaDefaultHandler;
                    if (z21 != z22) {
                        customInfo2.mCallJavaDefaultHandler = z22;
                        i3++;
                    }
                    boolean z23 = customInfo2.mEnableKillProcessAfterCrash;
                    boolean z24 = customInfo.mEnableKillProcessAfterCrash;
                    if (z23 != z24) {
                        customInfo2.mEnableKillProcessAfterCrash = z24;
                        i3++;
                    }
                    boolean z25 = customInfo2.mCallNativeDefaultHandler;
                    boolean z26 = customInfo.mCallNativeDefaultHandler;
                    if (z25 != z26) {
                        customInfo2.mCallNativeDefaultHandler = z26;
                        i3++;
                        if (b.d) {
                            JNIBridge.set(5, d.mCallNativeDefaultHandler);
                        }
                    }
                    boolean z27 = customInfo2.mDumpUserSolibBuildId;
                    boolean z28 = customInfo.mDumpUserSolibBuildId;
                    if (z27 != z28) {
                        customInfo2.mDumpUserSolibBuildId = z28;
                        i3++;
                        if (b.d) {
                            JNIBridge.set(6, d.mDumpUserSolibBuildId);
                        }
                    }
                    boolean z29 = customInfo2.mDumpHprofDataForJavaOOM;
                    boolean z30 = customInfo.mDumpHprofDataForJavaOOM;
                    if (z29 != z30) {
                        customInfo2.mDumpHprofDataForJavaOOM = z30;
                        i3++;
                    }
                    boolean z31 = customInfo2.mRenameFileToDefaultName;
                    boolean z32 = customInfo.mRenameFileToDefaultName;
                    if (z31 != z32) {
                        customInfo2.mRenameFileToDefaultName = z32;
                        i3++;
                    }
                    boolean z33 = customInfo2.mAutoDeleteOldVersionStats;
                    boolean z34 = customInfo.mAutoDeleteOldVersionStats;
                    if (z33 != z34) {
                        customInfo2.mAutoDeleteOldVersionStats = z34;
                        i3++;
                    }
                    int i31 = customInfo2.mFdDumpMinLimit;
                    int i32 = customInfo.mFdDumpMinLimit;
                    if (i31 != i32) {
                        customInfo2.mFdDumpMinLimit = i32;
                        if (b.d) {
                            JNIBridge.set(10, i32);
                        }
                        i3++;
                    }
                    int i33 = customInfo2.mThreadsDumpMinLimit;
                    int i34 = customInfo.mThreadsDumpMinLimit;
                    if (i33 != i34) {
                        customInfo2.mThreadsDumpMinLimit = i34;
                        if (b.d) {
                            JNIBridge.set(22, i34);
                        }
                        i3++;
                    }
                    int i35 = customInfo2.mInfoUpdateInterval;
                    int i36 = customInfo.mInfoUpdateInterval;
                    if (i35 != i36) {
                        if (i35 <= 0 && i36 > 0) {
                            a.a(false);
                        }
                        customInfo2.mInfoUpdateInterval = customInfo.mInfoUpdateInterval;
                        i3++;
                    }
                    int i37 = customInfo2.mInfoSaveFrequency;
                    int i38 = customInfo.mInfoSaveFrequency;
                    if (i37 != i38) {
                        customInfo2.mInfoSaveFrequency = i38;
                        i3++;
                    }
                    long j4 = customInfo2.mDisableBackgroundSignals;
                    long j5 = customInfo.mDisableBackgroundSignals;
                    if (j4 != j5) {
                        customInfo2.mDisableBackgroundSignals = j5;
                        if (b.d) {
                            JNIBridge.set(9, j5);
                        }
                        i3++;
                    }
                    boolean z35 = customInfo2.mEnableStatReport;
                    boolean z36 = customInfo.mEnableStatReport;
                    if (z35 != z36) {
                        customInfo2.mEnableStatReport = z36;
                        if (z36) {
                            e.B();
                        }
                        i3++;
                    }
                    boolean z37 = customInfo2.mEnableCrpStat;
                    boolean z38 = customInfo.mEnableCrpStat;
                    if (z37 != z38) {
                        customInfo2.mEnableCrpStat = z38;
                        i3++;
                    }
                    boolean z39 = customInfo2.mEnableStatToWPKDirect;
                    boolean z40 = customInfo.mEnableStatToWPKDirect;
                    if (z39 != z40) {
                        customInfo2.mEnableStatToWPKDirect = z40;
                        i3++;
                    }
                    boolean z41 = customInfo2.mIsInternational;
                    boolean z42 = customInfo.mIsInternational;
                    if (z41 != z42) {
                        customInfo2.mIsInternational = z42;
                        if (b.d) {
                            JNIBridge.set(23, z42);
                        }
                        e.l();
                        com.uc.crashsdk.a.d.c();
                        h.k();
                        i3++;
                    }
                    boolean z43 = customInfo2.mAutoDetectLifeCycle;
                    boolean z44 = customInfo.mAutoDetectLifeCycle;
                    if (z43 != z44) {
                        customInfo2.mAutoDetectLifeCycle = z44;
                        if (z44) {
                            b.C();
                        }
                        i3++;
                    }
                    boolean z45 = customInfo2.mMonitorBattery;
                    boolean z46 = customInfo.mMonitorBattery;
                    if (z45 != z46) {
                        customInfo2.mMonitorBattery = z46;
                        e.c(b.B());
                        i3++;
                    }
                    int i39 = customInfo2.mUnexpSubTypes;
                    int i40 = customInfo.mUnexpSubTypes;
                    if (i39 != i40) {
                        customInfo2.mUnexpSubTypes = i40;
                        i3++;
                    }
                    boolean z47 = customInfo2.mEnableMemoryGroup;
                    boolean z48 = customInfo.mEnableMemoryGroup;
                    if (z47 != z48) {
                        customInfo2.mEnableMemoryGroup = z48;
                        if (b.d) {
                            JNIBridge.set(35, z48);
                        }
                        i3++;
                    }
                    boolean z49 = customInfo2.mEnableLibcMallocDetail;
                    boolean z50 = customInfo.mEnableLibcMallocDetail;
                    if (z49 != z50) {
                        customInfo2.mEnableLibcMallocDetail = z50;
                        if (b.d) {
                            JNIBridge.set(36, z50);
                        }
                        i3++;
                    }
                    String str4 = customInfo2.mLibcMallocDetailConfig;
                    String str5 = customInfo.mLibcMallocDetailConfig;
                    if (str4 != str5) {
                        customInfo2.mLibcMallocDetailConfig = str5;
                        if (b.d) {
                            JNIBridge.set(131, str5);
                        }
                        i3++;
                    }
                    if (!a(customInfo.mUserId, customInfo2.mUserId)) {
                        customInfo2.mUserId = customInfo.mUserId;
                        i3++;
                    }
                    if (!a(customInfo.mChannel, customInfo2.mChannel)) {
                        customInfo2.mChannel = customInfo.mChannel;
                        i3++;
                    }
                    if (!a(customInfo2.mCrashLogUploadUrl, customInfo.mCrashLogUploadUrl)) {
                        customInfo2.mCrashLogUploadUrl = customInfo.mCrashLogUploadUrl;
                        i3++;
                    }
                    if (!a(customInfo2.mCrashRateUploadUrl, customInfo.mCrashRateUploadUrl)) {
                        String str6 = customInfo.mCrashRateUploadUrl;
                        customInfo2.mCrashRateUploadUrl = str6;
                        i3++;
                        if (b.d) {
                            JNIBridge.set(38, str6);
                        }
                    }
                    if (!a(customInfo2.mCrashSDKAuthUrl, customInfo.mCrashSDKAuthUrl)) {
                        String str7 = customInfo.mCrashSDKAuthUrl;
                        customInfo2.mCrashSDKAuthUrl = str7;
                        i3++;
                        if (b.d) {
                            JNIBridge.set(39, str7);
                        }
                    }
                    i2 = i3;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return i2;
    }

    public static void b() {
        JNIBridge.set(103, com.uc.crashsdk.a.g.b());
        JNIBridge.set(104, d.mTagFilesFolderName);
        JNIBridge.set(105, d.mCrashLogsFolderName);
        JNIBridge.set(106, Z());
        JNIBridge.set(107, e.h());
        JNIBridge.set(108, b.a());
        JNIBridge.set(109, U());
        JNIBridge.set(110, V());
        JNIBridge.set(UMErrorCode.E_UM_BE_CREATE_FAILED, W());
        JNIBridge.set(UMErrorCode.E_UM_BE_DEFLATE_FAILED, "240515102041");
        JNIBridge.set(116, Build.MODEL);
        JNIBridge.set(117, Build.VERSION.RELEASE);
        JNIBridge.set(118, e.q());
        JNIBridge.set(5, d.mCallNativeDefaultHandler);
        JNIBridge.set(6, d.mDumpUserSolibBuildId);
        JNIBridge.set(7, d.mReservedNativeMemoryBytes);
        JNIBridge.set(100, d.mNativeCrashLogFileName);
        JNIBridge.set(101, d.mUnexpCrashLogFileName);
        JNIBridge.set(35, d.mEnableMemoryGroup);
        JNIBridge.set(36, d.mEnableLibcMallocDetail);
        JNIBridge.set(131, d.mLibcMallocDetailConfig);
        JNIBridge.set(102, d.mAppId);
        JNIBridge.set(38, d.mCrashRateUploadUrl);
        JNIBridge.set(39, d.mCrashSDKAuthUrl);
    }

    public static void c() {
        JNIBridge.set(11, Q());
        JNIBridge.set(12, d.mBackupLogs);
        JNIBridge.set(13, d.mCrashRestartInterval);
        JNIBridge.set(14, d.mMaxBuiltinLogFilesCount);
        JNIBridge.set(15, d.mMaxNativeLogcatLineCount);
        JNIBridge.set(16, d.mMaxUnexpLogcatLineCount);
        JNIBridge.set(31, d.mMaxAnrLogcatLineCount);
        JNIBridge.set(18, P());
        JNIBridge.set(20, Build.VERSION.SDK_INT);
        JNIBridge.set(21, d.mOmitNativeCrash);
        JNIBridge.set(32, d.mMaxAnrLogCountPerProcess);
        JNIBridge.set(8, d.mDisableSignals);
        JNIBridge.set(9, d.mDisableBackgroundSignals);
        CustomInfo customInfo = d;
        JNIBridge.nativeSet(3, customInfo.mZipLog ? 1L : 0L, customInfo.mZippedLogExtension, null);
        JNIBridge.set(4, d.mLogMaxBytesLimit);
        JNIBridge.set(119, Build.FINGERPRINT);
    }

    private static void c(CustomInfo customInfo) {
        if (customInfo.mZippedLogExtension == null) {
            customInfo.mZippedLogExtension = "";
        }
        if (customInfo.mZippedLogExtension.equals(".tmp")) {
            ik.a("mZippedLogExtension can not be '.tmp'!");
            return;
        }
        if (customInfo.mOmitJavaCrash) {
            customInfo.mCallJavaDefaultHandler = false;
        }
        if (customInfo.mOmitNativeCrash) {
            customInfo.mCallNativeDefaultHandler = false;
        }
        long b2 = e.b();
        if (b2 >= 1) {
            customInfo.mMaxBuiltinLogFilesCount = 200;
            customInfo.mMaxCustomLogFilesCount = 100;
            customInfo.mMaxUploadBytesPerDay = 268435456L;
            customInfo.mMaxUploadBuiltinLogCountPerDay = 2000;
            customInfo.mMaxUploadCustomLogCountPerDay = 2000;
            customInfo.mMaxCustomLogCountPerTypePerDay = 100;
            customInfo.mMaxAnrLogCountPerProcess = 100;
            customInfo.mAnrTraceStrategy = 2;
            if (b2 >= 2) {
                customInfo.mSyncUploadSetupCrashLogs = true;
                customInfo.mSyncUploadLogs = true;
                if (b2 >= 3) {
                    customInfo.mBackupLogs = true;
                    customInfo.mPrintStackInfos = true;
                    customInfo.mDebug = true;
                }
            }
        }
    }

    public static void d() {
        JNIBridge.set(23, d.mIsInternational);
        if (b.H()) {
            JNIBridge.set(34, true);
        }
        if (e.i()) {
            JNIBridge.set(1, true);
        }
        JNIBridge.set(10, d.mFdDumpMinLimit);
        JNIBridge.nativeCmd(3, d.mReservedNativeFileHandleCount, null, null);
        JNIBridge.nativeSetForeground(b.B());
        JNIBridge.set(2, b.F());
        a.e();
        a.g();
        a.i();
        a.k();
        JNIBridge.set(UMErrorCode.E_UM_BE_RAW_OVERSIZE, a.a);
        JNIBridge.cmd(1);
        JNIBridge.set(22, d.mThreadsDumpMinLimit);
        JNIBridge.set(122, a.a());
        JNIBridge.set(33, a.c());
        af();
        b.K();
        b.D();
        com.uc.crashsdk.a.g.k();
    }

    public static String e() {
        return d.mAppId;
    }

    public static boolean f() {
        if (com.uc.crashsdk.a.g.b(d.mJavaCrashLogFileName) || com.uc.crashsdk.a.g.b(d.mNativeCrashLogFileName)) {
            return true;
        }
        return com.uc.crashsdk.a.g.b(d.mUnexpCrashLogFileName);
    }

    public static String g() {
        return d.mJavaCrashLogFileName;
    }

    public static int h() {
        return d.mCrashRestartInterval;
    }

    public static boolean i() {
        return d.mCallJavaDefaultHandler;
    }

    public static boolean j() {
        return d.mEnableKillProcessAfterCrash;
    }

    public static boolean k() {
        return d.mDumpHprofDataForJavaOOM;
    }

    public static boolean l() {
        return d.mRenameFileToDefaultName;
    }

    public static int m() {
        return d.mMaxBuiltinLogFilesCount;
    }

    public static int n() {
        return d.mMaxCustomLogFilesCount;
    }

    public static int o() {
        return d.mMaxJavaLogcatLineCount;
    }

    public static int p() {
        return d.mUnexpDelayMillSeconds;
    }

    public static int q() {
        return d.mUnexpSubTypes;
    }

    public static boolean r() {
        return d.mBackupLogs;
    }

    public static boolean s() {
        return d.mSyncUploadSetupCrashLogs;
    }

    public static boolean t() {
        return d.mSyncUploadLogs;
    }

    public static boolean u() {
        return d.mOmitJavaCrash;
    }

    public static boolean v() {
        return d.mAutoDeleteOldVersionStats;
    }

    public static boolean w() {
        return d.mZipLog;
    }

    public static String x() {
        return d.mZippedLogExtension;
    }

    public static boolean y() {
        return d.mEncryptLog;
    }

    public static String z() {
        return d.mCrashLogUploadUrl;
    }
}
