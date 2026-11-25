package com.umeng.umcrash;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.UMAPMCustomController;
import com.efs.sdk.base.custommapping.IUMPerfCallback;
import com.efs.sdk.base.custommapping.InnerCustomMappingManager;
import com.efs.sdk.base.observer.IConfigCallback;
import com.efs.sdk.h5pagesdk.H5Manager;
import com.efs.sdk.launch.LaunchManager;
import com.efs.sdk.memleaksdk.IMemLeakClient;
import com.efs.sdk.memleaksdk.MemLeakManager;
import com.efs.sdk.memoryinfo.UMMemoryMonitor;
import com.efs.sdk.pa.IPaClient;
import com.uc.crashsdk.export.CrashApi;
import com.uc.crashsdk.export.ICrashClient;
import com.uc.crashsdk.export.LogType;
import com.umeng.analytics.pro.cl;
import com.umeng.crash.UCrash;
import com.umeng.crash.UCrashCallback;
import com.umeng.logsdk.ULogManager;
import com.umeng.logsdk.UploadFileFilterCodeLog;
import com.umeng.pagesdk.PageManger;
import com.umeng.powersdk.PowerManager;
import com.umeng.umcrash.IUMCrashCallbackWithType;
import com.umeng.umcrash.custom_exception.UAPMCustomException;
import com.umeng.umcrash.custominfo.UAPMCustomInfo;
import com.umeng.umcrash.customlog.UAPMCustomLogManager;
import defpackage.ah1;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /tmp/classes2.dex */
public class UMCrash {
    private static final boolean DEFAULT_VALUE_CODE_LOG = true;
    private static final boolean DEFAULT_VALUE_CRASH_ANR = true;
    private static final boolean DEFAULT_VALUE_CRASH_JAVA = true;
    private static final boolean DEFAULT_VALUE_CRASH_NATIVE = true;
    private static final boolean DEFAULT_VALUE_CRASH_UNEXP = false;
    private static final boolean DEFAULT_VALUE_FLUTTER = true;
    private static final boolean DEFAULT_VALUE_H5PAGE = true;
    private static final boolean DEFAULT_VALUE_LAUNCH = true;
    private static final boolean DEFAULT_VALUE_MEM = true;
    private static final boolean DEFAULT_VALUE_MEMLEAK = true;
    private static final boolean DEFAULT_VALUE_NET = true;
    private static final boolean DEFAULT_VALUE_PA = true;
    private static final boolean DEFAULT_VALUE_PAGE = true;
    private static final boolean DEFAULT_VALUE_POWER = true;
    private static final String INTEGRATIONTESTING_SP = "itconfig";
    private static final String IT_DEBUGKEY = "apm_debugkey";
    private static final String IT_SENDAGING = "apm_sendaging";
    private static final String KEY_ACTIITY_ON_CREATED = "onCreated";
    private static final String KEY_ACTIITY_ON_DESTROYED = "onDestroyed";
    private static final String KEY_ACTIITY_ON_PAUSED = "onPaused";
    private static final String KEY_ACTIITY_ON_RESUMED = "onResumed";
    private static final String KEY_ACTIITY_ON_STARTED = "onStarted";
    private static final String KEY_ACTIITY_ON_STOPPED = "onStopped";
    public static final String KEY_APM_DEFAULT_SECRET = "NEej8y@anWa*8hep";
    public static final String KEY_APM_ROOT_NAME = "UApm";
    public static final String KEY_CALLBACK_CUSTOM_LOG = "um_custom_log";
    public static final String KEY_CALLBACK_CUSTOM_MAPPING = "um_custom_mapping";
    public static final String KEY_CALLBACK_PAGE_ACTION = "um_action_log";
    public static final String KEY_CALLBACK_SESSION_ID = "um_session_id";
    public static final String KEY_CALLBACK_UMID = "um_umid";
    public static final String KEY_CALLBACK_UM_INFOS = "um_infos:";
    public static final String KEY_CALLBACK_USER_STRING = "um_user_string";
    private static final String KEY_CALLBACK_USER_STRING_ANR = "um_user_str_anr:";
    public static final String KEY_CALLBACK_USER_STRING_CUSTOM_LOG = "um_user_str_custom_log:";
    private static final String KEY_CALLBACK_USER_STRING_JAVA = "um_user_str_java:";
    private static final String KEY_CALLBACK_USER_STRING_NATIVE = "um_user_str_native:";
    public static final String KEY_DEBUGKEY = "um_dk";
    public static final String KEY_ENABLE_ANR = "enableANRLog";
    public static final String KEY_ENABLE_CODE_LOG = "enableCodeLog";
    public static final String KEY_ENABLE_CRASH_JAVA = "enableJavaLog";
    public static final String KEY_ENABLE_CRASH_NATIVE = "enableNativeLog";
    public static final String KEY_ENABLE_CRASH_UNEXP = "enableUnexpLog";
    public static final String KEY_ENABLE_FLUTTER = "enableFlutterLog";
    public static final String KEY_ENABLE_H5PAGE = "enableH5PageLog";
    public static final String KEY_ENABLE_LAUNCH = "enableLaunchLog";
    public static final String KEY_ENABLE_MEM = "enableMemLog";
    public static final String KEY_ENABLE_MEMLEAK = "enableMemLeakLog";
    public static final String KEY_ENABLE_NET = "enableNetLog";
    public static final String KEY_ENABLE_PA = "enablePaLog";
    public static final String KEY_ENABLE_PAGE = "enablePageLog";
    public static final String KEY_ENABLE_POWER = "enablePowerLog";
    public static final String KEY_HEADER_ACCESS = "um_access";
    public static final String KEY_HEADER_ACCESS_SUBTYPE = "um_access_subtype";
    public static final String KEY_HEADER_APPKEY = "um_app_key";
    public static final String KEY_HEADER_BESRIAL = "um_bserial";
    public static final String KEY_HEADER_BSVER = "um_bsver";
    public static final String KEY_HEADER_BVER = "um_bver";
    public static final String KEY_HEADER_CARRIER = "um_app_carrier";
    public static final String KEY_HEADER_CHANNEL = "um_app_channel";
    public static final String KEY_HEADER_CRASH_VERSION = "um_crash_sdk_version";
    public static final String KEY_HEADER_DEBUGKEY = "um_dk";
    public static final String KEY_HEADER_NETWORK_TYPE = "um_network_type";
    public static final String KEY_HEADER_OS = "um_os";
    public static final String KEY_HEADER_PROVIDER = "um_app_provider";
    public static final String KEY_HEADER_PUID = "um_app_puid";
    public static final String KEY_HEADER_START_TIME = "um_app_start_time";
    public static final String KEY_HEADER_UMID = "um_umid_header";
    public static final String KEY_LOG_DEVICES_ID = "log_devices_id";
    public static final String KEY_LOG_USER_ID = "log_user_id";
    private static final int KEY_MAX_LENGTH = 20480;
    private static final int KEY_MAX_LENGTH_128 = 128;
    public static final String KEY_PA_TIMEOUT_TIME = "pa_timeout_time";
    public static final String SP_KEY_DEBUG = "debugkey";
    public static final String SP_KEY_TIMESTAMP = "timestamp";
    private static final String TAG = "UMCrash";
    private static String crashSdkVersion = "2.0.8";
    private static boolean isBuildId = true;
    private static boolean isDebug = true;
    private static boolean isEncrypt = false;
    private static boolean isIntl = false;
    private static boolean isZip = true;
    private static Context mContext = null;
    private static UMCrashCallback mUMCrashCallback = null;
    private static IUMCrashCallbackWithType mUMCrashCallbackWithType = null;
    private static boolean sIsDumpAllStackTrace = true;
    private static boolean sIsEnableLogBackup = false;
    private static boolean sIsKillProcessAfterCrash = true;
    public static EfsReporter sReporter;
    public static UMAPMCustomController sUMAPMCustomController;
    private static String userBesrial;
    private static String userBsver;
    private static String userBver;
    private static Object pageArrayLock = new Object();
    private static ArrayList<String> mArrayList = new ArrayList<>(10);
    private static int sApmCallbackLimit = 0;
    private static boolean isPA = false;
    private static boolean isLa = false;
    private static boolean isNet = false;
    private static boolean isPage = false;
    private static boolean isPower = false;
    private static boolean isFlutter = false;
    private static boolean isCodeLog = false;
    private static boolean isMemLeak = false;
    private static boolean enableJavaLog = true;
    private static boolean enableNativeLog = true;
    private static boolean enableANRLog = true;
    private static boolean enablePaLog = true;
    private static boolean enableLaunchLog = true;
    private static boolean enableMemLog = true;
    private static boolean enableNetLog = true;
    private static boolean enableH5PageLog = true;
    private static boolean enablePageLog = true;
    private static boolean enableCodeLog = true;
    private static boolean enablePowerLog = true;
    private static boolean enableFlutterLog = true;
    private static boolean enableMemLeakLog = true;
    private static boolean enableUCJavaLog = false;
    private static boolean enableUCNativeLog = false;
    private static boolean enableUCANRLog = false;
    private static boolean enableUCUserLog = false;
    private static boolean enableUMJavaLog = true;
    private static boolean enableUMNativeLog = true;
    private static boolean enableUMANRLog = true;
    private static boolean enableUMUserLog = true;
    private static boolean enableUMAnrTrace = true;
    private static final long DEFAULT_PA_TIMEOUT_TIME = 2000;
    private static long paTimeoutTime = DEFAULT_PA_TIMEOUT_TIME;
    private static int index = 0;
    private static boolean isOpenUserCrash = true;
    private static boolean isUploadNowUserCrash = false;

    /* loaded from: /tmp/classes2.dex */
    public static class CrashClientImpl implements ICrashClient {
        private CrashClientImpl() {
        }

        @Override // com.uc.crashsdk.export.ICrashClient
        public void onAddCrashStats(String str, int i, int i2) {
        }

        @Override // com.uc.crashsdk.export.ICrashClient
        public File onBeforeUploadLog(File file) {
            return file;
        }

        @Override // com.uc.crashsdk.export.ICrashClient
        public void onClientProcessLogGenerated(String str, File file, String str2) {
        }

        @Override // com.uc.crashsdk.export.ICrashClient
        public void onCrashRestarting(boolean z) {
        }

        @Override // com.uc.crashsdk.export.ICrashClient
        public String onGetCallbackInfo(String str, boolean z) {
            if (UMCrash.KEY_CALLBACK_UMID.equals(str)) {
                return UMCrashUtils.getUMID(UMCrash.mContext);
            }
            if (UMCrash.KEY_CALLBACK_UM_INFOS.equals(str)) {
                return UMCrash.access$100();
            }
            if (UMCrash.KEY_CALLBACK_USER_STRING.equals(str)) {
                return UMCrash.access$200();
            }
            if (UMCrash.KEY_CALLBACK_USER_STRING_JAVA.equals(str)) {
                return UMCrash.access$300();
            }
            if (UMCrash.KEY_CALLBACK_USER_STRING_NATIVE.equals(str)) {
                return UMCrash.access$400();
            }
            if (UMCrash.KEY_CALLBACK_USER_STRING_ANR.equals(str)) {
                return UMCrash.access$500();
            }
            if (UMCrash.KEY_CALLBACK_USER_STRING_CUSTOM_LOG.equals(str)) {
                return UMCrash.access$600();
            }
            return null;
        }

        @Override // com.uc.crashsdk.export.ICrashClient
        public void onLogGenerated(File file, String str) {
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static class MemLeakClientImpl implements IMemLeakClient {
        private MemLeakClientImpl() {
        }

        public String onGetCallbackInfo(String str) {
            String onCallback;
            String str2 = null;
            if (!UMCrash.KEY_CALLBACK_PAGE_ACTION.equals(str)) {
                if (UMCrash.KEY_CALLBACK_USER_STRING.equals(str)) {
                    if (UMCrash.mUMCrashCallbackWithType != null) {
                        String onCallback2 = UMCrash.mUMCrashCallbackWithType.onCallback(IUMCrashCallbackWithType.CrashType.CRASH_TYPE_MEM_LEAK);
                        if (onCallback2 == null) {
                            return null;
                        }
                        return onCallback2.trim().getBytes().length > Math.max(UMCrash.KEY_MAX_LENGTH, UMCrash.sApmCallbackLimit) ? UMCrashUtils.splitByByte(onCallback2, Math.max(UMCrash.KEY_MAX_LENGTH, UMCrash.sApmCallbackLimit)) : onCallback2;
                    }
                    if (UMCrash.mUMCrashCallback == null || (onCallback = UMCrash.mUMCrashCallback.onCallback()) == null) {
                        return null;
                    }
                    return onCallback.trim().getBytes().length > Math.max(UMCrash.KEY_MAX_LENGTH, UMCrash.sApmCallbackLimit) ? UMCrashUtils.splitByByte(onCallback, Math.max(UMCrash.KEY_MAX_LENGTH, UMCrash.sApmCallbackLimit)) : onCallback;
                }
                return null;
            }
            try {
                if (UMCrash.mArrayList != null && UMCrash.mArrayList.size() > 0) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("source", 0);
                    jSONObject.put("action_name", "page_view");
                    jSONObject.put("action_page_state", UMCrash.isPage);
                    JSONArray jSONArray = new JSONArray();
                    for (int i = 0; i < UMCrash.mArrayList.size(); i++) {
                        String str3 = (String) UMCrash.mArrayList.get(i);
                        if (str3 != null) {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("name", str3);
                            jSONArray.put(jSONObject2);
                        }
                    }
                    jSONObject.put("action_parameter", jSONArray);
                    str2 = jSONObject.toString();
                    if (UMCrash.isDebug) {
                        Log.i(UMCrash.TAG, "page json is " + str2);
                    }
                }
            } catch (Throwable unused) {
            }
            return str2;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static class PaClientImpl implements IPaClient {
        private PaClientImpl() {
        }

        public String onGetCallbackInfo(String str) {
            String onCallback;
            String str2 = null;
            if (!UMCrash.KEY_CALLBACK_PAGE_ACTION.equals(str)) {
                if (UMCrash.KEY_CALLBACK_USER_STRING.equals(str)) {
                    if (UMCrash.mUMCrashCallbackWithType != null) {
                        String onCallback2 = UMCrash.mUMCrashCallbackWithType.onCallback(IUMCrashCallbackWithType.CrashType.CRASH_TYPE_BLOCK);
                        if (onCallback2 == null) {
                            return null;
                        }
                        return onCallback2.trim().getBytes().length > Math.max(UMCrash.KEY_MAX_LENGTH, UMCrash.sApmCallbackLimit) ? UMCrashUtils.splitByByte(onCallback2, Math.max(UMCrash.KEY_MAX_LENGTH, UMCrash.sApmCallbackLimit)) : onCallback2;
                    }
                    if (UMCrash.mUMCrashCallback == null || (onCallback = UMCrash.mUMCrashCallback.onCallback()) == null) {
                        return null;
                    }
                    return onCallback.trim().getBytes().length > Math.max(UMCrash.KEY_MAX_LENGTH, UMCrash.sApmCallbackLimit) ? UMCrashUtils.splitByByte(onCallback, Math.max(UMCrash.KEY_MAX_LENGTH, UMCrash.sApmCallbackLimit)) : onCallback;
                }
                return null;
            }
            try {
                if (UMCrash.mArrayList != null && UMCrash.mArrayList.size() > 0) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("source", 0);
                    jSONObject.put("action_name", "page_view");
                    jSONObject.put("action_page_state", UMCrash.isPage);
                    JSONArray jSONArray = new JSONArray();
                    for (int i = 0; i < UMCrash.mArrayList.size(); i++) {
                        String str3 = (String) UMCrash.mArrayList.get(i);
                        if (str3 != null) {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("name", str3);
                            jSONArray.put(jSONObject2);
                        }
                    }
                    jSONObject.put("action_parameter", jSONArray);
                    str2 = jSONObject.toString();
                    if (UMCrash.isDebug) {
                        Log.i(UMCrash.TAG, "page json is " + str2);
                    }
                }
            } catch (Throwable unused) {
            }
            return str2;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static class UCrashCallbackImpl implements UCrashCallback {
        private UCrashCallbackImpl() {
        }

        @Override // com.umeng.crash.UCrashCallback
        public Map<String, String> getExtras(String str) {
            HashMap hashMap = new HashMap();
            hashMap.put(UMCrash.KEY_CALLBACK_USER_STRING, UMCrash.access$200());
            if ("java".equals(str)) {
                hashMap.put(UMCrash.KEY_CALLBACK_USER_STRING_JAVA, UMCrash.access$300());
            } else if ("jni".equals(str)) {
                hashMap.put(UMCrash.KEY_CALLBACK_USER_STRING_NATIVE, UMCrash.access$400());
            } else if ("anr".equals(str)) {
                hashMap.put(UMCrash.KEY_CALLBACK_USER_STRING_ANR, UMCrash.access$500());
            } else if ("exception".equals(str)) {
                hashMap.put(UMCrash.KEY_CALLBACK_USER_STRING_CUSTOM_LOG, UMCrash.access$600());
            }
            hashMap.put(UMCrash.KEY_CALLBACK_UMID, UMCrashUtils.getUMID(UMCrash.mContext));
            hashMap.put(UMCrash.KEY_CALLBACK_UM_INFOS, UMCrash.access$100());
            return hashMap;
        }
    }

    public static /* synthetic */ String access$100() {
        return generateUMInfos();
    }

    public static /* synthetic */ int access$1608() {
        int i = index;
        index = i + 1;
        return i;
    }

    public static /* synthetic */ int access$1610() {
        int i = index;
        index = i - 1;
        return i;
    }

    public static /* synthetic */ String access$200() {
        return generateNormalUserString();
    }

    public static /* synthetic */ String access$300() {
        return generateJavaUserString();
    }

    public static /* synthetic */ String access$400() {
        return generateNativeUserString();
    }

    public static /* synthetic */ String access$500() {
        return generateANRUserString();
    }

    public static /* synthetic */ String access$600() {
        return generateCustomUserString();
    }

    public static void addCustomInfo(String str, String str2) {
        UAPMCustomInfo.addCustomInfo(str, str2);
    }

    @Deprecated
    public static void enableANRLog(boolean z) {
        enableANRLog = z;
    }

    public static void enableDumpAllStackTrace(boolean z) {
        sIsDumpAllStackTrace = z;
    }

    public static void enableJavaScriptBridge(View view) {
        try {
            H5Manager.setWebView(view);
        } catch (Throwable unused) {
        }
    }

    public static void enableJavaScriptBridge(WebView webView) {
        enableJavaScriptBridge((View) webView);
    }

    public static void enableKillProcessAfterCrash(boolean z) {
        sIsKillProcessAfterCrash = z;
    }

    public static void enableLogBackup(boolean z) {
        sIsEnableLogBackup = z;
    }

    @Deprecated
    public static void enableMemoryMonitor(boolean z) {
        UMMemoryMonitor.get().setEnable(z);
    }

    @Deprecated
    public static void enableNativeLog(boolean z) {
        enableNativeLog = z;
    }

    private static String generateANRUserString() {
        String onCallback;
        IUMCrashCallbackWithType iUMCrashCallbackWithType = mUMCrashCallbackWithType;
        if (iUMCrashCallbackWithType == null || (onCallback = iUMCrashCallbackWithType.onCallback(IUMCrashCallbackWithType.CrashType.CRASH_TYPE_ANR)) == null) {
            return null;
        }
        return onCallback.trim().getBytes().length > Math.max(KEY_MAX_LENGTH, sApmCallbackLimit) ? UMCrashUtils.splitByByte(onCallback, Math.max(KEY_MAX_LENGTH, sApmCallbackLimit)) : onCallback;
    }

    public static void generateCustomLog(String str, String str2) {
        generateCustomLog(str, str2, false, false);
    }

    public static void generateCustomLog(String str, String str2, String str3, boolean z, boolean z2) {
        UAPMCustomException.generateCustomLog(enableUMUserLog, enableUCUserLog, isUploadNowUserCrash, str, str2, str3, z, z2);
    }

    public static void generateCustomLog(String str, String str2, boolean z, boolean z2) {
        generateCustomLog(str, str2, (String) null, z, z2);
    }

    public static void generateCustomLog(Throwable th, String str) {
        generateCustomLog(th, str, false, false);
    }

    public static void generateCustomLog(Throwable th, String str, String str2, boolean z, boolean z2) {
        UAPMCustomException.generateCustomLog(enableUMUserLog, enableUCUserLog, isUploadNowUserCrash, th, str, str2, z, z2);
    }

    public static void generateCustomLog(Throwable th, String str, boolean z, boolean z2) {
        generateCustomLog(th, str, (String) null, z, z2);
    }

    private static String generateCustomUserString() {
        String onCallback;
        IUMCrashCallbackWithType iUMCrashCallbackWithType = mUMCrashCallbackWithType;
        if (iUMCrashCallbackWithType == null || (onCallback = iUMCrashCallbackWithType.onCallback(IUMCrashCallbackWithType.CrashType.CRASH_TYPE_CUSTOM_LOG)) == null) {
            return null;
        }
        return onCallback.trim().getBytes().length > Math.max(KEY_MAX_LENGTH, sApmCallbackLimit) ? UMCrashUtils.splitByByte(onCallback, Math.max(KEY_MAX_LENGTH, sApmCallbackLimit)) : onCallback;
    }

    private static String generateJavaUserString() {
        String onCallback;
        IUMCrashCallbackWithType iUMCrashCallbackWithType = mUMCrashCallbackWithType;
        if (iUMCrashCallbackWithType == null || (onCallback = iUMCrashCallbackWithType.onCallback(IUMCrashCallbackWithType.CrashType.CRASH_TYPE_JAVA)) == null) {
            return null;
        }
        return onCallback.trim().getBytes().length > Math.max(KEY_MAX_LENGTH, sApmCallbackLimit) ? UMCrashUtils.splitByByte(onCallback, Math.max(KEY_MAX_LENGTH, sApmCallbackLimit)) : onCallback;
    }

    private static String generateNativeUserString() {
        String onCallback;
        IUMCrashCallbackWithType iUMCrashCallbackWithType = mUMCrashCallbackWithType;
        if (iUMCrashCallbackWithType == null || (onCallback = iUMCrashCallbackWithType.onCallback(IUMCrashCallbackWithType.CrashType.CRASH_TYPE_NATIVE)) == null) {
            return null;
        }
        return onCallback.trim().getBytes().length > Math.max(KEY_MAX_LENGTH, sApmCallbackLimit) ? UMCrashUtils.splitByByte(onCallback, Math.max(KEY_MAX_LENGTH, sApmCallbackLimit)) : onCallback;
    }

    private static String generateNormalUserString() {
        UMCrashCallback uMCrashCallback;
        String onCallback;
        if (mUMCrashCallbackWithType != null || (uMCrashCallback = mUMCrashCallback) == null || (onCallback = uMCrashCallback.onCallback()) == null) {
            return null;
        }
        return onCallback.trim().getBytes().length > Math.max(KEY_MAX_LENGTH, sApmCallbackLimit) ? UMCrashUtils.splitByByte(onCallback, Math.max(KEY_MAX_LENGTH, sApmCallbackLimit)) : onCallback;
    }

    private static String generateUMInfos() {
        JSONObject jSONObject = new JSONObject();
        try {
            ArrayList<String> arrayList = mArrayList;
            if (arrayList != null && arrayList.size() > 0) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("source", 0);
                jSONObject2.put("action_name", "page_view");
                jSONObject2.put("action_page_state", isPage);
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < mArrayList.size(); i++) {
                    String str = mArrayList.get(i);
                    if (str != null) {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("name", str);
                        jSONArray.put(jSONObject3);
                    }
                }
                jSONObject2.put("action_parameter", jSONArray);
                String jSONObject4 = jSONObject2.toString();
                if (isDebug) {
                    Log.i(TAG, "page json is " + jSONObject4);
                }
                jSONObject.put(KEY_CALLBACK_PAGE_ACTION, jSONObject4);
            }
        } catch (Throwable unused) {
        }
        try {
            jSONObject.put(KEY_CALLBACK_SESSION_ID, UMCrashUtils.getSessionId(mContext));
            jSONObject.put(KEY_CALLBACK_CUSTOM_LOG, UAPMCustomLogManager.getCustomLogs());
            jSONObject.put(KEY_CALLBACK_CUSTOM_MAPPING, InnerCustomMappingManager.getCustomMappingJsonStr());
            return jSONObject.toString();
        } catch (JSONException e) {
            ah1.a(e);
            return null;
        }
    }

    public static EfsReporter getReporter() {
        return sReporter;
    }

    public static String getUMAPMFlag() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(cl.n, 0);
            jSONObject.put("crash", 1);
            if (enableJavaLog) {
                jSONObject.put("crashJava", 1);
            } else {
                jSONObject.put("crashJava", 0);
            }
            if (enableNativeLog) {
                jSONObject.put("crashNative", 1);
            } else {
                jSONObject.put("crashNative", 0);
            }
            if (enableANRLog) {
                jSONObject.put("anr", 1);
            } else {
                jSONObject.put("anr", 0);
            }
            if (isPA) {
                jSONObject.put("pa", 1);
            } else {
                jSONObject.put("pa", 0);
            }
            if (isLa) {
                jSONObject.put("la", 1);
            } else {
                jSONObject.put("la", 0);
            }
            if (UMMemoryMonitor.get().isEnable()) {
                jSONObject.put("mem", 1);
            } else {
                jSONObject.put("mem", 0);
            }
            if (isNet) {
                jSONObject.put("net", 1);
            } else {
                jSONObject.put("net", 0);
            }
            if (H5Manager.getH5ConfigMananger() == null || !H5Manager.getH5ConfigMananger().isH5TracerEnable()) {
                jSONObject.put("h5", 0);
            } else {
                jSONObject.put("h5", 1);
            }
            if (isOpenUserCrash) {
                jSONObject.put("crashUser", 1);
            } else {
                jSONObject.put("crashUser", 0);
            }
            if (isPage) {
                jSONObject.put("page", 1);
            } else {
                jSONObject.put("page", 0);
            }
            if (isPower) {
                jSONObject.put("power", 1);
            } else {
                jSONObject.put("power", 0);
            }
            if (isCodeLog) {
                jSONObject.put("codelog", 1);
            } else {
                jSONObject.put("codelog", 0);
            }
            if (isMemLeak) {
                jSONObject.put("memleak", 1);
            } else {
                jSONObject.put("memleak", 0);
            }
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x039a  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x03c7 A[Catch: all -> 0x03db, TryCatch #31 {all -> 0x03db, blocks: (B:104:0x03b8, B:106:0x03c7, B:108:0x03df, B:110:0x03e3, B:111:0x0428, B:113:0x042c, B:351:0x03ed, B:353:0x03f1, B:354:0x03f8, B:356:0x03fc, B:358:0x0406, B:360:0x0410, B:361:0x0423, B:362:0x0426), top: B:103:0x03b8 }] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x03df A[Catch: all -> 0x03db, TryCatch #31 {all -> 0x03db, blocks: (B:104:0x03b8, B:106:0x03c7, B:108:0x03df, B:110:0x03e3, B:111:0x0428, B:113:0x042c, B:351:0x03ed, B:353:0x03f1, B:354:0x03f8, B:356:0x03fc, B:358:0x0406, B:360:0x0410, B:361:0x0423, B:362:0x0426), top: B:103:0x03b8 }] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x042c A[Catch: all -> 0x03db, TRY_LEAVE, TryCatch #31 {all -> 0x03db, blocks: (B:104:0x03b8, B:106:0x03c7, B:108:0x03df, B:110:0x03e3, B:111:0x0428, B:113:0x042c, B:351:0x03ed, B:353:0x03f1, B:354:0x03f8, B:356:0x03fc, B:358:0x0406, B:360:0x0410, B:361:0x0423, B:362:0x0426), top: B:103:0x03b8 }] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0464 A[Catch: all -> 0x0471, TryCatch #6 {all -> 0x0471, blocks: (B:118:0x044d, B:120:0x0464, B:122:0x046a, B:343:0x0473), top: B:117:0x044d }] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x048b A[Catch: all -> 0x0494, TryCatch #29 {all -> 0x0494, blocks: (B:124:0x0487, B:126:0x048b, B:337:0x0496, B:339:0x049a), top: B:123:0x0487 }] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x04a9 A[Catch: all -> 0x04d0, TRY_LEAVE, TryCatch #24 {all -> 0x04d0, blocks: (B:128:0x04a5, B:130:0x04a9, B:136:0x04c3, B:138:0x04c9, B:325:0x04d2, B:327:0x04d6, B:328:0x04dd, B:330:0x04c0, B:331:0x04ec, B:333:0x04f0, B:132:0x04ae, B:134:0x04b4), top: B:127:0x04a5, inners: #16 }] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x04ff A[Catch: all -> 0x0509, TryCatch #18 {all -> 0x0509, blocks: (B:142:0x04fb, B:144:0x04ff, B:319:0x050b, B:321:0x050f), top: B:141:0x04fb }] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0529 A[Catch: all -> 0x053d, TryCatch #14 {all -> 0x053d, blocks: (B:146:0x051a, B:148:0x0529, B:150:0x0541, B:152:0x0545, B:300:0x054f, B:302:0x0553, B:303:0x055a, B:305:0x055e, B:312:0x0575, B:313:0x0579, B:315:0x057d, B:307:0x0563, B:309:0x0569), top: B:145:0x051a, inners: #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0541 A[Catch: all -> 0x053d, TryCatch #14 {all -> 0x053d, blocks: (B:146:0x051a, B:148:0x0529, B:150:0x0541, B:152:0x0545, B:300:0x054f, B:302:0x0553, B:303:0x055a, B:305:0x055e, B:312:0x0575, B:313:0x0579, B:315:0x057d, B:307:0x0563, B:309:0x0569), top: B:145:0x051a, inners: #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0597 A[Catch: all -> 0x05ab, TryCatch #4 {all -> 0x05ab, blocks: (B:154:0x0588, B:156:0x0597, B:158:0x05af, B:160:0x05b3, B:287:0x05bd, B:289:0x05c1, B:290:0x05c8, B:292:0x05cc, B:293:0x05d2, B:295:0x05d6), top: B:153:0x0588 }] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x05af A[Catch: all -> 0x05ab, TryCatch #4 {all -> 0x05ab, blocks: (B:154:0x0588, B:156:0x0597, B:158:0x05af, B:160:0x05b3, B:287:0x05bd, B:289:0x05c1, B:290:0x05c8, B:292:0x05cc, B:293:0x05d2, B:295:0x05d6), top: B:153:0x0588 }] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x05f0 A[Catch: all -> 0x0604, TryCatch #17 {all -> 0x0604, blocks: (B:162:0x05e1, B:164:0x05f0, B:166:0x0608, B:168:0x060c, B:267:0x0616, B:269:0x061a, B:270:0x0621, B:272:0x0625, B:279:0x063e, B:280:0x0642, B:282:0x0646, B:274:0x062c, B:276:0x0632), top: B:161:0x05e1, inners: #13 }] */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0608 A[Catch: all -> 0x0604, TryCatch #17 {all -> 0x0604, blocks: (B:162:0x05e1, B:164:0x05f0, B:166:0x0608, B:168:0x060c, B:267:0x0616, B:269:0x061a, B:270:0x0621, B:272:0x0625, B:279:0x063e, B:280:0x0642, B:282:0x0646, B:274:0x062c, B:276:0x0632), top: B:161:0x05e1, inners: #13 }] */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0660 A[Catch: all -> 0x0674, TryCatch #8 {all -> 0x0674, blocks: (B:170:0x0651, B:172:0x0660, B:174:0x0678, B:176:0x067c, B:247:0x0686, B:249:0x068a, B:250:0x0691, B:252:0x0695, B:259:0x06ae, B:260:0x06b2, B:262:0x06b6, B:254:0x069c, B:256:0x06a2), top: B:169:0x0651, inners: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0678 A[Catch: all -> 0x0674, TryCatch #8 {all -> 0x0674, blocks: (B:170:0x0651, B:172:0x0660, B:174:0x0678, B:176:0x067c, B:247:0x0686, B:249:0x068a, B:250:0x0691, B:252:0x0695, B:259:0x06ae, B:260:0x06b2, B:262:0x06b6, B:254:0x069c, B:256:0x06a2), top: B:169:0x0651, inners: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:180:0x06d0 A[Catch: all -> 0x06e4, TryCatch #1 {all -> 0x06e4, blocks: (B:178:0x06c1, B:180:0x06d0, B:182:0x06e8, B:184:0x06ec, B:227:0x06f6, B:229:0x06fa, B:230:0x0701, B:232:0x0705, B:239:0x071e, B:240:0x0722, B:242:0x0726, B:234:0x070c, B:236:0x0712), top: B:177:0x06c1, inners: #32 }] */
    /* JADX WARN: Removed duplicated region for block: B:182:0x06e8 A[Catch: all -> 0x06e4, TryCatch #1 {all -> 0x06e4, blocks: (B:178:0x06c1, B:180:0x06d0, B:182:0x06e8, B:184:0x06ec, B:227:0x06f6, B:229:0x06fa, B:230:0x0701, B:232:0x0705, B:239:0x071e, B:240:0x0722, B:242:0x0726, B:234:0x070c, B:236:0x0712), top: B:177:0x06c1, inners: #32 }] */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0740 A[Catch: all -> 0x0754, TryCatch #28 {all -> 0x0754, blocks: (B:186:0x0731, B:188:0x0740, B:190:0x0758, B:192:0x075c, B:207:0x0766, B:209:0x076a, B:210:0x0771, B:212:0x0775, B:219:0x0794, B:220:0x0798, B:222:0x079c, B:214:0x0782, B:216:0x0788), top: B:185:0x0731, inners: #26 }] */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0758 A[Catch: all -> 0x0754, TryCatch #28 {all -> 0x0754, blocks: (B:186:0x0731, B:188:0x0740, B:190:0x0758, B:192:0x075c, B:207:0x0766, B:209:0x076a, B:210:0x0771, B:212:0x0775, B:219:0x0794, B:220:0x0798, B:222:0x079c, B:214:0x0782, B:216:0x0788), top: B:185:0x0731, inners: #26 }] */
    /* JADX WARN: Removed duplicated region for block: B:196:0x07b8 A[Catch: all -> 0x07ce, TRY_LEAVE, TryCatch #22 {all -> 0x07ce, blocks: (B:194:0x07a7, B:196:0x07b8), top: B:193:0x07a7 }] */
    /* JADX WARN: Removed duplicated region for block: B:200:0x07d6  */
    /* JADX WARN: Removed duplicated region for block: B:203:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0764  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00bc A[Catch: all -> 0x00ce, TryCatch #23 {all -> 0x00ce, blocks: (B:19:0x00af, B:21:0x00bc, B:24:0x00d5), top: B:18:0x00af }] */
    /* JADX WARN: Removed duplicated region for block: B:226:0x06f4  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0684  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0614  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x05bb  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x054d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0121 A[Catch: all -> 0x0155, TRY_ENTER, TRY_LEAVE, TryCatch #30 {all -> 0x0155, blocks: (B:27:0x00e2, B:30:0x0121), top: B:26:0x00e2 }] */
    /* JADX WARN: Removed duplicated region for block: B:319:0x050b A[Catch: all -> 0x0509, TryCatch #18 {all -> 0x0509, blocks: (B:142:0x04fb, B:144:0x04ff, B:319:0x050b, B:321:0x050f), top: B:141:0x04fb }] */
    /* JADX WARN: Removed duplicated region for block: B:331:0x04ec A[Catch: all -> 0x04d0, TryCatch #24 {all -> 0x04d0, blocks: (B:128:0x04a5, B:130:0x04a9, B:136:0x04c3, B:138:0x04c9, B:325:0x04d2, B:327:0x04d6, B:328:0x04dd, B:330:0x04c0, B:331:0x04ec, B:333:0x04f0, B:132:0x04ae, B:134:0x04b4), top: B:127:0x04a5, inners: #16 }] */
    /* JADX WARN: Removed duplicated region for block: B:337:0x0496 A[Catch: all -> 0x0494, TryCatch #29 {all -> 0x0494, blocks: (B:124:0x0487, B:126:0x048b, B:337:0x0496, B:339:0x049a), top: B:123:0x0487 }] */
    /* JADX WARN: Removed duplicated region for block: B:350:0x03eb  */
    /* JADX WARN: Removed duplicated region for block: B:371:0x030b A[Catch: all -> 0x03b6, TRY_LEAVE, TryCatch #9 {all -> 0x03b6, blocks: (B:95:0x0304, B:369:0x031e, B:98:0x032d, B:101:0x039b, B:371:0x030b, B:388:0x0322, B:97:0x0314), top: B:48:0x01ea, inners: #33 }] */
    /* JADX WARN: Removed duplicated region for block: B:372:0x02ea A[Catch: all -> 0x02e8, TRY_LEAVE, TryCatch #2 {all -> 0x02e8, blocks: (B:86:0x02d7, B:90:0x02e1, B:372:0x02ea), top: B:85:0x02d7, outer: #21 }] */
    /* JADX WARN: Removed duplicated region for block: B:388:0x0322 A[Catch: all -> 0x03b6, TryCatch #9 {all -> 0x03b6, blocks: (B:95:0x0304, B:369:0x031e, B:98:0x032d, B:101:0x039b, B:371:0x030b, B:388:0x0322, B:97:0x0314), top: B:48:0x01ea, inners: #33 }] */
    /* JADX WARN: Removed duplicated region for block: B:390:0x01c6 A[Catch: all -> 0x014a, TryCatch #20 {all -> 0x014a, blocks: (B:36:0x0131, B:37:0x015c, B:39:0x0160, B:40:0x0187, B:44:0x01af, B:46:0x01be, B:47:0x01de, B:50:0x01ec, B:390:0x01c6, B:392:0x01d7), top: B:35:0x0131 }] */
    /* JADX WARN: Removed duplicated region for block: B:398:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0160 A[Catch: all -> 0x014a, TryCatch #20 {all -> 0x014a, blocks: (B:36:0x0131, B:37:0x015c, B:39:0x0160, B:40:0x0187, B:44:0x01af, B:46:0x01be, B:47:0x01de, B:50:0x01ec, B:390:0x01c6, B:392:0x01d7), top: B:35:0x0131 }] */
    /* JADX WARN: Removed duplicated region for block: B:401:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01ec A[Catch: all -> 0x014a, TRY_LEAVE, TryCatch #20 {all -> 0x014a, blocks: (B:36:0x0131, B:37:0x015c, B:39:0x0160, B:40:0x0187, B:44:0x01af, B:46:0x01be, B:47:0x01de, B:50:0x01ec, B:390:0x01c6, B:392:0x01d7), top: B:35:0x0131 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x027a A[Catch: all -> 0x014c, TryCatch #21 {all -> 0x014c, blocks: (B:67:0x0245, B:68:0x0251, B:71:0x0257, B:73:0x025d, B:74:0x0272, B:76:0x027a, B:77:0x0286, B:79:0x028e, B:80:0x029a, B:82:0x02a2, B:378:0x02d4, B:91:0x02f6, B:93:0x02fd, B:375:0x02f3, B:379:0x0264, B:86:0x02d7, B:90:0x02e1, B:372:0x02ea, B:84:0x02ae), top: B:66:0x0245, inners: #2, #27 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x028e A[Catch: all -> 0x014c, TryCatch #21 {all -> 0x014c, blocks: (B:67:0x0245, B:68:0x0251, B:71:0x0257, B:73:0x025d, B:74:0x0272, B:76:0x027a, B:77:0x0286, B:79:0x028e, B:80:0x029a, B:82:0x02a2, B:378:0x02d4, B:91:0x02f6, B:93:0x02fd, B:375:0x02f3, B:379:0x0264, B:86:0x02d7, B:90:0x02e1, B:372:0x02ea, B:84:0x02ae), top: B:66:0x0245, inners: #2, #27 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x02a2 A[Catch: all -> 0x014c, TRY_LEAVE, TryCatch #21 {all -> 0x014c, blocks: (B:67:0x0245, B:68:0x0251, B:71:0x0257, B:73:0x025d, B:74:0x0272, B:76:0x027a, B:77:0x0286, B:79:0x028e, B:80:0x029a, B:82:0x02a2, B:378:0x02d4, B:91:0x02f6, B:93:0x02fd, B:375:0x02f3, B:379:0x0264, B:86:0x02d7, B:90:0x02e1, B:372:0x02ea, B:84:0x02ae), top: B:66:0x0245, inners: #2, #27 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x02fd A[Catch: all -> 0x014c, TRY_LEAVE, TryCatch #21 {all -> 0x014c, blocks: (B:67:0x0245, B:68:0x0251, B:71:0x0257, B:73:0x025d, B:74:0x0272, B:76:0x027a, B:77:0x0286, B:79:0x028e, B:80:0x029a, B:82:0x02a2, B:378:0x02d4, B:91:0x02f6, B:93:0x02fd, B:375:0x02f3, B:379:0x0264, B:86:0x02d7, B:90:0x02e1, B:372:0x02ea, B:84:0x02ae), top: B:66:0x0245, inners: #2, #27 }] */
    /* JADX WARN: Type inference failed for: r5v22, types: [com.uc.crashsdk.export.CrashApi] */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v24, types: [com.uc.crashsdk.export.ICrashClient, com.umeng.umcrash.UMCrash$CrashClientImpl] */
    /* JADX WARN: Type inference failed for: r6v25 */
    /* JADX WARN: Type inference failed for: r6v26 */
    /* JADX WARN: Type inference failed for: r6v27 */
    /* JADX WARN: Type inference failed for: r6v29 */
    /* JADX WARN: Type inference failed for: r6v30, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v31, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v32 */
    /* JADX WARN: Type inference failed for: r6v49 */
    /* JADX WARN: Type inference failed for: r6v50 */
    /* JADX WARN: Type inference failed for: r6v51 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v19 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3, types: [android.content.SharedPreferences] */
    /* JADX WARN: Type inference failed for: r8v30 */
    /* JADX WARN: Type inference failed for: r8v31 */
    /* JADX WARN: Type inference failed for: r8v32 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void init(final android.content.Context r40, final java.lang.String r41, java.lang.String r42) {
        /*
            Method dump skipped, instructions count: 2022
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.umcrash.UMCrash.init(android.content.Context, java.lang.String, java.lang.String):void");
    }

    public static void initConfig(Bundle bundle) {
        if (bundle != null) {
            if (bundle.getBoolean(KEY_ENABLE_CRASH_JAVA, true)) {
                enableJavaLog = true;
            } else {
                enableJavaLog = false;
            }
            if (bundle.getBoolean(KEY_ENABLE_CRASH_NATIVE, true)) {
                enableNativeLog = true;
            } else {
                enableNativeLog = false;
            }
            if (bundle.getBoolean(KEY_ENABLE_ANR, true)) {
                enableANRLog = true;
            } else {
                enableANRLog = false;
            }
            if (bundle.getBoolean(KEY_ENABLE_PA, true)) {
                enablePaLog = true;
            } else {
                enablePaLog = false;
            }
            if (bundle.getBoolean(KEY_ENABLE_LAUNCH, true)) {
                enableLaunchLog = true;
            } else {
                enableLaunchLog = false;
            }
            if (bundle.getBoolean(KEY_ENABLE_MEM, true)) {
                enableMemLog = true;
            } else {
                enableMemLog = false;
            }
            if (bundle.getBoolean(KEY_ENABLE_NET, true)) {
                enableNetLog = true;
            } else {
                enableNetLog = false;
            }
            if (bundle.getBoolean(KEY_ENABLE_H5PAGE, true)) {
                enableH5PageLog = true;
            } else {
                enableH5PageLog = false;
            }
            paTimeoutTime = bundle.getLong(KEY_PA_TIMEOUT_TIME, DEFAULT_PA_TIMEOUT_TIME);
            if (bundle.getBoolean(KEY_ENABLE_PAGE, true)) {
                enablePageLog = true;
            } else {
                enablePageLog = false;
            }
            try {
                if (bundle.getBoolean(KEY_ENABLE_CODE_LOG, true)) {
                    enableCodeLog = true;
                } else {
                    enableCodeLog = false;
                }
                ULogManager.setUserID(bundle.getString(KEY_LOG_USER_ID, ""));
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (bundle.getBoolean(KEY_ENABLE_POWER, true)) {
                enablePowerLog = true;
            } else {
                enablePowerLog = false;
            }
            if (bundle.getBoolean(KEY_ENABLE_FLUTTER, true)) {
                enableFlutterLog = true;
            } else {
                enableFlutterLog = false;
            }
            if (bundle.getBoolean(KEY_ENABLE_MEMLEAK, true)) {
                enableMemLeakLog = true;
            } else {
                enableMemLeakLog = false;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00fc A[Catch: all -> 0x0102, TryCatch #0 {all -> 0x0102, blocks: (B:2:0x0000, B:4:0x0008, B:6:0x001a, B:7:0x002a, B:9:0x002e, B:13:0x0036, B:14:0x003d, B:16:0x0041, B:18:0x0053, B:19:0x0063, B:21:0x0067, B:25:0x006f, B:26:0x0076, B:28:0x007a, B:30:0x008c, B:31:0x009c, B:33:0x00a0, B:37:0x00a8, B:38:0x00af, B:40:0x00c1, B:41:0x00d1, B:43:0x00d5, B:47:0x00dd, B:49:0x00fc, B:52:0x00ff, B:56:0x00ab, B:58:0x0072, B:60:0x0039), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ff A[Catch: all -> 0x0102, TRY_LEAVE, TryCatch #0 {all -> 0x0102, blocks: (B:2:0x0000, B:4:0x0008, B:6:0x001a, B:7:0x002a, B:9:0x002e, B:13:0x0036, B:14:0x003d, B:16:0x0041, B:18:0x0053, B:19:0x0063, B:21:0x0067, B:25:0x006f, B:26:0x0076, B:28:0x007a, B:30:0x008c, B:31:0x009c, B:33:0x00a0, B:37:0x00a8, B:38:0x00af, B:40:0x00c1, B:41:0x00d1, B:43:0x00d5, B:47:0x00dd, B:49:0x00fc, B:52:0x00ff, B:56:0x00ab, B:58:0x0072, B:60:0x0039), top: B:1:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void initCrashState(android.content.Context r5) {
        /*
            Method dump skipped, instructions count: 263
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.umcrash.UMCrash.initCrashState(android.content.Context):void");
    }

    private static void initReporter(final Context context, String str, String str2) {
        HashMap hashMap = new HashMap(1);
        hashMap.put(KEY_HEADER_UMID, UMCrashUtils.getUMID(context));
        hashMap.put(KEY_HEADER_CHANNEL, str2);
        UMAPMCustomController uMAPMCustomController = sUMAPMCustomController;
        if (uMAPMCustomController == null || uMAPMCustomController.isCanUseNetworkOperator()) {
            hashMap.put(KEY_HEADER_CARRIER, UMCrashUtils.getNetworkOperatorName(context));
        } else {
            hashMap.put(KEY_HEADER_CARRIER, "");
        }
        hashMap.put(KEY_HEADER_OS, "android");
        hashMap.put(KEY_HEADER_CRASH_VERSION, crashSdkVersion);
        try {
            String[] activeUser = UMCrashUtils.getActiveUser(context);
            if (activeUser != null && activeUser.length == 2) {
                hashMap.put(KEY_HEADER_PUID, activeUser[1]);
                hashMap.put(KEY_HEADER_PROVIDER, activeUser[0]);
            }
        } catch (Throwable unused) {
            hashMap.put(KEY_HEADER_PUID, "");
            hashMap.put(KEY_HEADER_PROVIDER, "");
        }
        if (!TextUtils.isEmpty(userBver)) {
            hashMap.put(KEY_HEADER_BVER, userBver);
        }
        if (!TextUtils.isEmpty(userBsver)) {
            hashMap.put(KEY_HEADER_BSVER, userBsver);
        }
        if (!TextUtils.isEmpty(userBesrial)) {
            hashMap.put(KEY_HEADER_BESRIAL, userBesrial);
        }
        try {
            if (UMCrashUtils.isHarmony(context)) {
                hashMap.put("others_OS", "harmony");
            } else {
                hashMap.put("others_OS", "Android");
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        EfsReporter build = new EfsReporter.Builder(context.getApplicationContext(), str, KEY_APM_DEFAULT_SECRET).debug(isDebug).enablePaBackup(sIsEnableLogBackup).efsDirRootName(KEY_APM_ROOT_NAME).printLogDetail(isDebug).intl(isIntl).enableWaStat(false).logUid(ULogManager.getUserID()).logDid(ULogManager.getDeviceID()).setOpenCodeLog(isCodeLog).customController(sUMAPMCustomController).build();
        sReporter = build;
        build.addPublicParams(hashMap);
        try {
            if (isCodeLog) {
                sReporter.setFileFilterCodeLog(new UploadFileFilterCodeLog());
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        try {
            sReporter.getAllSdkConfig(new String[]{UMCrashContent.APM_STATE_CODE_LOG, UMCrashContent.APM_STATE_HIT_WL, UMCrashContent.APM_STATE_MEMLEAK, UMCrashContent.APM_STATE_FLUTTER, UMCrashContent.APM_STATE_POWER, UMCrashContent.APM_STATE_PAGE, UMCrashContent.APM_STATE_NET, UMCrashContent.APM_STATE_NATIVE_H5, UMCrashContent.APM_CRASH_JAVA_SAMPLING_RATE, UMCrashContent.APM_CRASH_NATIVE_SAMPLING_RATE, UMCrashContent.APM_CRASH_ANR_SAMPLING_RATE, UMCrashContent.APM_CRASH_USER_SAMPLING_RATE, UMCrashContent.APM_CRASH_USER_MAX_COUNT, UMCrashContent.APM_CRASH_USER_UPLOAD_TYPE, UMCrashContent.APM_CALLBACK_LIMIT, UMCrashContent.APM_UM_CRASH_JAVA_SAMPLING_RATE, UMCrashContent.APM_UM_CRASH_NATIVE_SAMPLING_RATE, UMCrashContent.APM_UM_CRASH_ANR_SAMPLING_RATE, UMCrashContent.APM_UM_CRASH_USER_SAMPLING_RATE, UMCrashContent.APM_UM_CRASH_ANR_TRACE_STATE}, new IConfigCallback() { // from class: com.umeng.umcrash.UMCrash.6
                /* JADX WARN: Removed duplicated region for block: B:100:? A[RETURN, SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:15:0x007e A[Catch: all -> 0x0098, TryCatch #9 {all -> 0x0098, blocks: (B:13:0x0078, B:15:0x007e, B:17:0x0084, B:18:0x009a), top: B:12:0x0078 }] */
                /* JADX WARN: Removed duplicated region for block: B:29:0x00c1 A[Catch: all -> 0x00db, TryCatch #10 {all -> 0x00db, blocks: (B:27:0x00bb, B:29:0x00c1, B:31:0x00c7, B:32:0x00dd, B:34:0x00eb, B:35:0x00f4, B:37:0x00f0), top: B:26:0x00bb }] */
                /* JADX WARN: Removed duplicated region for block: B:41:0x0107 A[Catch: all -> 0x0121, TryCatch #1 {all -> 0x0121, blocks: (B:39:0x0101, B:41:0x0107, B:43:0x010d, B:44:0x0123), top: B:38:0x0101 }] */
                /* JADX WARN: Removed duplicated region for block: B:49:0x0136 A[Catch: all -> 0x0150, TryCatch #7 {all -> 0x0150, blocks: (B:47:0x0130, B:49:0x0136, B:51:0x013c, B:52:0x0152), top: B:46:0x0130 }] */
                /* JADX WARN: Removed duplicated region for block: B:57:0x0165 A[Catch: all -> 0x017d, TryCatch #12 {all -> 0x017d, blocks: (B:55:0x015f, B:57:0x0165, B:59:0x016b, B:60:0x017f), top: B:54:0x015f }] */
                /* JADX WARN: Removed duplicated region for block: B:66:0x0195 A[Catch: all -> 0x01ad, TryCatch #4 {all -> 0x01ad, blocks: (B:64:0x018f, B:66:0x0195, B:68:0x019b, B:69:0x01af), top: B:63:0x018f }] */
                /* JADX WARN: Removed duplicated region for block: B:75:0x01c5 A[Catch: all -> 0x01dd, TryCatch #11 {all -> 0x01dd, blocks: (B:73:0x01bf, B:75:0x01c5, B:77:0x01cb, B:78:0x01df), top: B:72:0x01bf }] */
                /* JADX WARN: Removed duplicated region for block: B:84:0x01f5 A[Catch: all -> 0x020d, TryCatch #3 {all -> 0x020d, blocks: (B:82:0x01ef, B:84:0x01f5, B:86:0x01fb, B:87:0x020f), top: B:81:0x01ef }] */
                /* JADX WARN: Removed duplicated region for block: B:93:0x0225 A[Catch: all -> 0x0246, TryCatch #2 {all -> 0x0246, blocks: (B:91:0x021f, B:93:0x0225, B:95:0x022b, B:96:0x023c), top: B:90:0x021f }] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public void onChange(java.util.Map<java.lang.String, java.lang.Object> r26) {
                    /*
                        Method dump skipped, instructions count: 587
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.umeng.umcrash.UMCrash.AnonymousClass6.onChange(java.util.Map):void");
                }
            });
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
    }

    public static void isBuildId(boolean z) {
        isBuildId = z;
    }

    public static void reRegisterAnrHandler() {
        if (enableUMANRLog) {
            UCrash.reRegisterAnrHandler();
        }
    }

    private static void registerInfoCallback(CrashApi crashApi) {
        crashApi.registerInfoCallback(KEY_CALLBACK_USER_STRING_JAVA, 16);
        crashApi.registerInfoCallback(KEY_CALLBACK_USER_STRING_NATIVE, 1);
        crashApi.registerInfoCallback(KEY_CALLBACK_USER_STRING_ANR, LogType.ANR);
        crashApi.registerInfoCallback(KEY_CALLBACK_USER_STRING_CUSTOM_LOG, 256);
        crashApi.registerInfoCallback(KEY_CALLBACK_UM_INFOS, 1048593);
        crashApi.registerInfoCallback(KEY_CALLBACK_UMID, 1048593);
    }

    public static void registerPerfCallback(IUMPerfCallback iUMPerfCallback) {
        EfsReporter.registerPerfCallback(iUMPerfCallback);
    }

    public static void registerUMCrashCallback(IUMCrashCallbackWithType iUMCrashCallbackWithType) {
        if (iUMCrashCallbackWithType != null) {
            mUMCrashCallbackWithType = iUMCrashCallbackWithType;
        } else {
            Log.e(TAG, "callback error.");
        }
    }

    public static void registerUMCrashCallback(UMCrashCallback uMCrashCallback) {
        if (uMCrashCallback == null) {
            Log.e(TAG, "callback error.");
            return;
        }
        mUMCrashCallback = uMCrashCallback;
        if (CrashApi.getInstance() != null) {
            CrashApi.getInstance().registerInfoCallback(KEY_CALLBACK_USER_STRING, 1048593);
        } else {
            Log.e(TAG, "callback error, instance is null.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void saveActivityState(String str, String str2) {
        ArrayList<String> arrayList;
        try {
            UMAPMCustomController uMAPMCustomController = sUMAPMCustomController;
            if ((uMAPMCustomController == null || uMAPMCustomController.isCanUseUserOperationRecord()) && (arrayList = mArrayList) != null) {
                if (arrayList.size() >= 20) {
                    mArrayList.remove(0);
                }
                mArrayList.add(str + "-" + System.currentTimeMillis() + "-" + str2);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void saveLocalCrashSampling(Context context, Map<String, Object> map) {
        if (context == null || map == null) {
            return;
        }
        Object obj = map.get(UMCrashContent.APM_UM_CRASH_JAVA_SAMPLING_RATE);
        if (obj != null) {
            if (isDebug) {
                Log.i("efs.config", "callback umCrashJavaSampling is " + obj);
            }
            UMCrashUtils.saveInnerConfig(context.getApplicationContext(), UMCrashContent.APM_UM_CRASH_JAVA_SAMPLING_RATE, obj);
        }
        Object obj2 = map.get(UMCrashContent.APM_UM_CRASH_NATIVE_SAMPLING_RATE);
        if (obj2 != null) {
            if (isDebug) {
                Log.i("efs.config", "callback umCrashNativeSampling is " + obj2);
            }
            UMCrashUtils.saveInnerConfig(context.getApplicationContext(), UMCrashContent.APM_UM_CRASH_NATIVE_SAMPLING_RATE, obj2);
        }
        Object obj3 = map.get(UMCrashContent.APM_UM_CRASH_ANR_SAMPLING_RATE);
        if (obj3 != null) {
            if (isDebug) {
                Log.i("efs.config", "callback umCrashANRSampling is " + obj3);
            }
            UMCrashUtils.saveInnerConfig(context.getApplicationContext(), UMCrashContent.APM_UM_CRASH_ANR_SAMPLING_RATE, obj3);
        }
        Object obj4 = map.get(UMCrashContent.APM_UM_CRASH_USER_SAMPLING_RATE);
        if (obj4 != null) {
            if (isDebug) {
                Log.i("efs.config", "callback umCrashUserSampling is " + obj4);
            }
            UMCrashUtils.saveInnerConfig(context.getApplicationContext(), UMCrashContent.APM_UM_CRASH_USER_SAMPLING_RATE, obj4);
        }
        Object obj5 = map.get(UMCrashContent.APM_UM_CRASH_ANR_TRACE_STATE);
        if (obj5 != null) {
            if (isDebug) {
                Log.i("efs.config", "callback umCrashANRTraceSampling is " + obj5);
            }
            UMCrashUtils.saveInnerConfig(context.getApplicationContext(), UMCrashContent.APM_UM_CRASH_ANR_TRACE_STATE, obj5);
        }
        Object obj6 = map.get(UMCrashContent.APM_CRASH_JAVA_SAMPLING_RATE);
        if (obj6 != null) {
            if (isDebug) {
                Log.i("efs.config", "callback ucCrashJavaSampling is " + obj6);
            }
            UMCrashUtils.saveInnerConfig(context.getApplicationContext(), UMCrashContent.APM_CRASH_JAVA_SAMPLING_RATE, obj6);
        }
        Object obj7 = map.get(UMCrashContent.APM_CRASH_NATIVE_SAMPLING_RATE);
        if (obj7 != null) {
            if (isDebug) {
                Log.i("efs.config", "callback ucCrashNativeSampling is " + obj7);
            }
            UMCrashUtils.saveInnerConfig(context.getApplicationContext(), UMCrashContent.APM_CRASH_NATIVE_SAMPLING_RATE, obj7);
        }
        Object obj8 = map.get(UMCrashContent.APM_CRASH_ANR_SAMPLING_RATE);
        if (obj8 != null) {
            if (isDebug) {
                Log.i("efs.config", "callback ucCrashANRSampling is " + obj8);
            }
            UMCrashUtils.saveInnerConfig(context.getApplicationContext(), UMCrashContent.APM_CRASH_ANR_SAMPLING_RATE, obj8);
        }
        Object obj9 = map.get(UMCrashContent.APM_CRASH_USER_SAMPLING_RATE);
        if (obj9 != null) {
            if (isDebug) {
                Log.i("efs.config", "callback ucCrashUserSampling is " + obj9);
            }
            UMCrashUtils.saveInnerConfig(context.getApplicationContext(), UMCrashContent.APM_CRASH_USER_SAMPLING_RATE, obj9);
        }
    }

    public static void setAppVersion(String str, String str2, String str3) {
        try {
            if (!TextUtils.isEmpty(str)) {
                if (str.trim().getBytes().length > 128) {
                    str = UMCrashUtils.splitByByte(str, 128);
                }
                userBver = str;
            } else if (isDebug) {
                Log.e(TAG, "version is null or empty !");
            }
            if (!TextUtils.isEmpty(str2)) {
                if (str2.trim().getBytes().length > 128) {
                    str2 = UMCrashUtils.splitByByte(str2, 128);
                }
                userBsver = str2;
            } else if (isDebug) {
                Log.e(TAG, "sub version is null or empty !");
            }
            if (!TextUtils.isEmpty(str3)) {
                if (str3.trim().getBytes().length > 128) {
                    str3 = UMCrashUtils.splitByByte(str3, 128);
                }
                userBesrial = str3;
            } else if (isDebug) {
                Log.e(TAG, "build id is null or empty !");
            }
            CrashApi crashApi = CrashApi.getInstance();
            if (crashApi != null) {
                if (!TextUtils.isEmpty(userBver)) {
                    crashApi.addHeaderInfo(KEY_HEADER_BVER, userBver);
                    UCrash.addHeader(KEY_HEADER_BVER, userBver);
                }
                if (!TextUtils.isEmpty(userBsver)) {
                    crashApi.addHeaderInfo(KEY_HEADER_BSVER, userBsver);
                    UCrash.addHeader(KEY_HEADER_BSVER, userBsver);
                }
                if (!TextUtils.isEmpty(userBesrial)) {
                    crashApi.addHeaderInfo(KEY_HEADER_BESRIAL, userBesrial);
                    UCrash.addHeader(KEY_HEADER_BESRIAL, userBesrial);
                }
            } else if (isDebug) {
                Log.e(TAG, "set app version. crashApi is null");
            }
            HashMap hashMap = new HashMap(1);
            if (!TextUtils.isEmpty(userBver)) {
                hashMap.put(KEY_HEADER_BVER, userBver);
            }
            if (!TextUtils.isEmpty(userBsver)) {
                hashMap.put(KEY_HEADER_BSVER, userBsver);
            }
            if (!TextUtils.isEmpty(userBesrial)) {
                hashMap.put(KEY_HEADER_BESRIAL, userBesrial);
            }
            EfsReporter efsReporter = sReporter;
            if (efsReporter != null) {
                efsReporter.addPublicParams(hashMap);
            } else if (isDebug) {
                Log.e(TAG, "set app version.  sReporter is null");
            }
            if (!TextUtils.isEmpty(userBver)) {
                UMCrashUtils.setCommonTag(KEY_HEADER_BVER, userBver);
            }
            if (!TextUtils.isEmpty(userBsver)) {
                UMCrashUtils.setCommonTag(KEY_HEADER_BSVER, userBsver);
            }
            if (TextUtils.isEmpty(userBesrial)) {
                return;
            }
            UMCrashUtils.setCommonTag(KEY_HEADER_BESRIAL, userBesrial);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void setCustomController(UMAPMCustomController uMAPMCustomController) {
        sUMAPMCustomController = uMAPMCustomController;
    }

    public static void setDebug(boolean z) {
        isDebug = z;
        LaunchManager.isDebug = z;
        H5Manager.isDebug = z;
        PageManger.isDebug = z;
        PowerManager.isDebug = z;
        ULogManager.isDebug = z;
        MemLeakManager.isDebug = z;
    }

    public static void setLogCollectSaveSize(long j) {
        ULogManager.setsLogMaxCache(j);
    }

    public static void setPaTimeoutTime(long j) {
        paTimeoutTime = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void updateLocalCrashConfig(Context context, Map<String, Object> map) {
        if (context == null || map == null) {
            return;
        }
        Bundle bundle = new Bundle();
        Object obj = map.get(UMCrashContent.APM_CRASH_USER_MAX_COUNT);
        if (obj != null) {
            if (isDebug) {
                Log.i("efs.config", "callback crashMaxUserCount is " + obj.toString());
            }
            bundle.putInt("mMaxCustomLogCountPerTypePerDay", Integer.valueOf(obj.toString()).intValue());
            bundle.putInt("mMaxUploadCustomLogCountPerDay", Integer.valueOf(obj.toString()).intValue());
            UCrash.updateCustomLogLimit(Integer.valueOf(obj.toString()).intValue(), Integer.valueOf(obj.toString()).intValue());
        }
        CrashApi.getInstance().updateCustomInfo(bundle);
    }

    private static void updateLocalCrashSampling(Object obj, Object obj2, Object obj3, Object obj4) {
        CrashApi crashApi = CrashApi.getInstance();
        if (crashApi != null) {
            if (obj != null && UMCrashUtils.random(Integer.valueOf(obj.toString()).intValue())) {
                crashApi.disableLog(16);
            }
            if (obj2 != null && UMCrashUtils.random(Integer.valueOf(obj2.toString()).intValue())) {
                crashApi.disableLog(1);
            }
            if (obj3 != null && UMCrashUtils.random(Integer.valueOf(obj3.toString()).intValue())) {
                crashApi.disableLog(LogType.ANR);
            }
            if (obj4 == null || !UMCrashUtils.random(Integer.valueOf(obj4.toString()).intValue())) {
                return;
            }
            isOpenUserCrash = false;
        }
    }

    private static void useIntlServices(boolean z) {
        isIntl = z;
        if (isDebug) {
            Log.i(TAG, "useIntlServices is " + isIntl);
        }
    }
}
