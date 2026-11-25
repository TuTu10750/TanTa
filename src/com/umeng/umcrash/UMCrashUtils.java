package com.umeng.umcrash;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.efs.sdk.base.core.util.concurrent.WorkThreadUtil;
import com.uc.crashsdk.export.CrashApi;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.umcrash.custom_exception.UMCustomLogInfoBuilder;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/* loaded from: /tmp/classes2.dex */
public class UMCrashUtils {
    private static final int DEF_CLOSE_RATE = 0;
    private static final int MAX_THREAD_TRACE_LENGTH = 20480;
    private static final int MAX_TRACE_RATE = 100;
    public static final String UNKNOW = "";
    private static volatile boolean hasReadOperatorName = false;
    private static volatile String sOperatorName = "";

    public static boolean checkPermission(Context context, String str) {
        if (context == null) {
            return false;
        }
        return ((Integer) Class.forName("android.content.Context").getMethod("checkSelfPermission", String.class).invoke(context, str)).intValue() == 0;
    }

    public static String[] getActiveUser(Context context) {
        Class<UMUtils> cls;
        Method method;
        if (context == null) {
            return null;
        }
        try {
            cls = UMUtils.class;
            String str = UMUtils.UNKNOW;
        } catch (ClassNotFoundException unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            method = cls.getMethod("getActiveUser", Context.class);
        } catch (NoSuchMethodException unused2) {
            method = null;
        }
        if (method == null) {
            return null;
        }
        try {
            Object invoke = method.invoke(null, context);
            if (invoke != null) {
                return (String[]) invoke;
            }
            return null;
        } catch (IllegalAccessException | InvocationTargetException unused3) {
            return null;
        }
    }

    public static Map<String, String> getAllThreadTraces() {
        HashMap hashMap = new HashMap();
        try {
            Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
            if (allStackTraces == null) {
                return null;
            }
            Thread thread = Looper.getMainLooper().getThread();
            if (!allStackTraces.containsKey(thread)) {
                allStackTraces.put(thread, thread.getStackTrace());
            }
            long id = Thread.currentThread().getId();
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()) {
                if (id != entry.getKey().getId()) {
                    int i = 0;
                    sb.setLength(0);
                    if (entry.getValue() != null && entry.getValue().length != 0) {
                        StackTraceElement[] value = entry.getValue();
                        int length = value.length;
                        while (true) {
                            if (i >= length) {
                                break;
                            }
                            StackTraceElement stackTraceElement = value[i];
                            if (sb.length() >= MAX_THREAD_TRACE_LENGTH) {
                                sb.append("\n[Stack trace size must be less than :");
                                sb.append(MAX_THREAD_TRACE_LENGTH);
                                sb.append("!]");
                                break;
                            }
                            sb.append("  at ");
                            sb.append(stackTraceElement.toString());
                            sb.append(UMCustomLogInfoBuilder.LINE_SEP);
                            i++;
                        }
                        hashMap.put(entry.getKey().getName() + "(" + entry.getKey().getId() + ")", sb.toString());
                    }
                }
            }
            return hashMap;
        } catch (Throwable th) {
            th.printStackTrace();
            return hashMap;
        }
    }

    public static int getInnerConfig(Context context, String str, int i) {
        SharedPreferences sharedPreferences;
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str) && (sharedPreferences = context.getSharedPreferences(UMCrashContent.KEY_SP_UMCRASH, 0)) != null) {
                    return sharedPreferences.getInt(str, i);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return i;
    }

    public static String getNetworkOperatorName(Context context) {
        if (!TextUtils.isEmpty(sOperatorName)) {
            return sOperatorName;
        }
        if (hasReadOperatorName || context == null) {
            return "";
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                sOperatorName = telephonyManager.getNetworkOperatorName();
            }
        } catch (Throwable unused) {
        }
        hasReadOperatorName = true;
        return sOperatorName;
    }

    public static synchronized String getSessionId(Context context) {
        Class<DeviceConfig> cls;
        Method method;
        synchronized (UMCrashUtils.class) {
            String str = null;
            if (context == null) {
                return null;
            }
            try {
                cls = DeviceConfig.class;
                String str2 = DeviceConfig.UNKNOW;
            } catch (ClassNotFoundException unused) {
                cls = null;
            }
            if (cls != null) {
                try {
                    method = cls.getMethod("getSid", Context.class);
                } catch (NoSuchMethodException unused2) {
                    method = null;
                }
                if (method != null) {
                    try {
                        Object invoke = method.invoke(null, context);
                        if (invoke != null) {
                            str = invoke.toString();
                        }
                    } catch (IllegalAccessException | InvocationTargetException unused3) {
                    }
                }
            }
            return str;
        }
    }

    public static synchronized String getUMID(Context context) {
        Class<UMConfigure> cls;
        Method method;
        synchronized (UMCrashUtils.class) {
            String str = null;
            if (context == null) {
                return null;
            }
            try {
                cls = UMConfigure.class;
                UMLog uMLog = UMConfigure.umDebugLog;
            } catch (ClassNotFoundException unused) {
                cls = null;
            }
            if (cls != null) {
                try {
                    method = cls.getMethod("getUMIDString", Context.class);
                } catch (NoSuchMethodException unused2) {
                    method = null;
                }
                if (method != null) {
                    try {
                        Object invoke = method.invoke(null, context);
                        if (invoke != null) {
                            str = invoke.toString();
                        }
                    } catch (IllegalAccessException | InvocationTargetException unused3) {
                    }
                }
            }
            return str;
        }
    }

    public static boolean isHarmony(final Context context) {
        final SharedPreferences sharedPreferences;
        try {
            sharedPreferences = context.getSharedPreferences(UMCrashContent.KEY_SP_UMCRASH, 0);
        } catch (Throwable unused) {
        }
        if (sharedPreferences.contains("um_apm_harmony")) {
            return sharedPreferences.getBoolean("um_apm_harmony", false);
        }
        WorkThreadUtil.submit(new Runnable() { // from class: com.umeng.umcrash.UMCrashUtils.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    sharedPreferences.edit().putBoolean("um_apm_harmony", context.getString(Resources.getSystem().getIdentifier("config_os_brand", "string", "android")).equals("harmony")).apply();
                } catch (Throwable unused2) {
                }
            }
        });
        return false;
    }

    public static boolean random(int i) {
        if (i == 0) {
            return false;
        }
        return i == 100 || new Random().nextInt(100) <= i;
    }

    public static void saveInnerConfig(Context context, String str, Object obj) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor edit;
        if (context != null) {
            try {
                if (TextUtils.isEmpty(str) || obj == null || (sharedPreferences = context.getSharedPreferences(UMCrashContent.KEY_SP_UMCRASH, 0)) == null || (edit = sharedPreferences.edit()) == null) {
                    return;
                }
                edit.putInt(str, Integer.parseInt(obj.toString()));
                edit.commit();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void setCommonTag(String str, String str2) {
        try {
            UMLog uMLog = UMConfigure.umDebugLog;
            UMConfigure.BS_TYPE bs_type = UMConfigure.BS_TYPE.APM;
            Method declaredMethod = UMConfigure.class.getDeclaredMethod("setModuleTag", UMConfigure.BS_TYPE.class, String.class, String.class);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                for (Enum r5 : (Enum[]) UMConfigure.BS_TYPE.class.getEnumConstants()) {
                    if (r5 != null && r5.name().equals("APM")) {
                        declaredMethod.invoke(UMConfigure.class, r5, str, str2);
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void setIntegrationTesingParams(String str) {
        if (CrashApi.getInstance() != null) {
            CrashApi.getInstance().addHeaderInfo("um_dk", str);
        }
        if (UMCrash.getReporter() != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("um_dk", str);
            UMCrash.getReporter().addPublicParams(hashMap);
        }
    }

    public static void setPuidAndProvider(String str, String str2) {
        if (CrashApi.getInstance() != null) {
            CrashApi.getInstance().addHeaderInfo(UMCrash.KEY_HEADER_PUID, str);
            CrashApi.getInstance().addHeaderInfo(UMCrash.KEY_HEADER_PROVIDER, str2);
        }
        HashMap hashMap = new HashMap();
        hashMap.put(UMCrash.KEY_HEADER_PUID, str);
        hashMap.put(UMCrash.KEY_HEADER_PROVIDER, str2);
        if (UMCrash.getReporter() != null) {
            UMCrash.getReporter().addPublicParams(hashMap);
        }
    }

    public static String splitByByte(String str, int i) {
        StringBuffer stringBuffer = new StringBuffer(i);
        try {
            int length = str.length();
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                String valueOf = String.valueOf(str.charAt(i3));
                i2 += valueOf.getBytes().length;
                if (i < i2) {
                    break;
                }
                stringBuffer.append(valueOf);
            }
        } catch (Throwable unused) {
        }
        return stringBuffer.toString();
    }
}
