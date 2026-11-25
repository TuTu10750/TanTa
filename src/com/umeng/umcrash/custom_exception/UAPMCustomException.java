package com.umeng.umcrash.custom_exception;

import android.text.TextUtils;
import android.util.Log;
import com.uc.crashsdk.export.CrashApi;
import com.uc.crashsdk.export.CustomLogInfo;
import com.umeng.crash.UCrash;
import com.umeng.innner.umcrash.UMCrashThreadPoolExecutorFactory;
import com.umeng.umcrash.UMCrash;
import com.umeng.umcrash.UMCrashUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /tmp/classes2.dex */
public class UAPMCustomException {
    private static final String TAG = "UAPMCustomException";

    public static void generateCustomLog(final boolean z, final boolean z2, final boolean z3, final String str, final String str2, final String str3, final boolean z4, final boolean z5) {
        if (!z && !z2) {
            Log.e(TAG, "generate user is closed .");
        } else if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            Log.e(TAG, "generate custom log failed ! e is null or type is empty .");
        } else {
            UMCrashThreadPoolExecutorFactory.execute(new Runnable() { // from class: com.umeng.umcrash.custom_exception.UAPMCustomException.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        HashMap hashMap = new HashMap(20);
                        hashMap.put(UMCustomLogInfoBuilder.LOG_KEY_CT, "exception");
                        hashMap.put(UMCustomLogInfoBuilder.LOG_KEY_AC, str2);
                        StringBuffer stringBuffer = new StringBuffer();
                        for (Map.Entry entry : hashMap.entrySet()) {
                            stringBuffer.append((String) entry.getKey());
                            stringBuffer.append(":");
                            stringBuffer.append((String) entry.getValue());
                            stringBuffer.append(UMCustomLogInfoBuilder.LINE_SEP);
                        }
                        String str4 = str3;
                        if (str4 == null) {
                            str4 = "";
                        }
                        String str5 = "Exception message:" + str4 + UMCustomLogInfoBuilder.LINE_SEP + "Back traces starts." + UMCustomLogInfoBuilder.LINE_SEP + str + UMCustomLogInfoBuilder.LINE_SEP + "Back traces ends.";
                        if (!TextUtils.isEmpty(str5)) {
                            stringBuffer.append(str5);
                            stringBuffer.append(UMCustomLogInfoBuilder.LINE_SEP);
                        }
                        if (z5) {
                            Map<String, String> allThreadTraces = UMCrashUtils.getAllThreadTraces();
                            stringBuffer.append(UMCustomLogInfoBuilder.LOG_SECTION_SEP);
                            stringBuffer.append(UMCustomLogInfoBuilder.LINE_SEP);
                            stringBuffer.append("AllThreadsTraces: \n");
                            for (Map.Entry<String, String> entry2 : allThreadTraces.entrySet()) {
                                stringBuffer.append(entry2.getKey());
                                stringBuffer.append(UMCustomLogInfoBuilder.LINE_SEP);
                                stringBuffer.append(entry2.getValue());
                                stringBuffer.append(UMCustomLogInfoBuilder.LINE_SEP);
                            }
                        }
                        if (z) {
                            UCrash.generateCustomLog(stringBuffer.toString(), z4);
                            return;
                        }
                        if (z2) {
                            CustomLogInfo customLogInfo = new CustomLogInfo(null, "exception");
                            ArrayList<String> arrayList = new ArrayList<>();
                            arrayList.add(UMCrash.KEY_CALLBACK_UMID);
                            arrayList.add(UMCrash.KEY_CALLBACK_UM_INFOS);
                            arrayList.add(UMCrash.KEY_CALLBACK_USER_STRING);
                            arrayList.add(UMCrash.KEY_CALLBACK_USER_STRING_CUSTOM_LOG);
                            customLogInfo.mCallbacks = arrayList;
                            Log.i(UAPMCustomException.TAG, "upload is " + z3);
                            customLogInfo.mUploadNow = z3;
                            customLogInfo.mAddLogcat = z4;
                            customLogInfo.mData = stringBuffer;
                            CrashApi crashApi = CrashApi.getInstance();
                            if (crashApi == null) {
                                Log.e(UAPMCustomException.TAG, "CrashApi is null, not init .");
                            } else {
                                crashApi.generateCustomLog(customLogInfo);
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    public static void generateCustomLog(final boolean z, final boolean z2, final boolean z3, final Throwable th, final String str, final String str2, final boolean z4, final boolean z5) {
        if (!z && !z2) {
            Log.e(TAG, "generate user is closed .");
        } else if (th == null || TextUtils.isEmpty(str)) {
            Log.e(TAG, "generate custom log failed ! e is null or type is empty .");
        } else {
            UMCrashThreadPoolExecutorFactory.execute(new Runnable() { // from class: com.umeng.umcrash.custom_exception.UAPMCustomException.2
                @Override // java.lang.Runnable
                public void run() {
                    CustomLogInfo build;
                    try {
                        UMCustomLogInfoBuilder addLogCat = new UMCustomLogInfoBuilder(str).stack(th, str2).addLogCat(z4);
                        if (z5) {
                            StringBuilder sb = new StringBuilder("AllThreadsTraces: \n");
                            for (Map.Entry<String, String> entry : UMCrashUtils.getAllThreadTraces().entrySet()) {
                                sb.append(entry.getKey());
                                sb.append(UMCustomLogInfoBuilder.LINE_SEP);
                                sb.append(entry.getValue());
                                sb.append(UMCustomLogInfoBuilder.LINE_SEP);
                            }
                            build = addLogCat.addSection(sb.toString()).build();
                        } else {
                            build = addLogCat.build();
                        }
                        if (z) {
                            UCrash.generateCustomLog(build.mData.toString(), z4);
                            return;
                        }
                        if (z2) {
                            ArrayList<String> arrayList = new ArrayList<>();
                            arrayList.add(UMCrash.KEY_CALLBACK_UMID);
                            arrayList.add(UMCrash.KEY_CALLBACK_UM_INFOS);
                            arrayList.add(UMCrash.KEY_CALLBACK_USER_STRING);
                            arrayList.add(UMCrash.KEY_CALLBACK_USER_STRING_CUSTOM_LOG);
                            build.mCallbacks = arrayList;
                            Log.i(UAPMCustomException.TAG, "upload is " + z3);
                            build.mUploadNow = z3;
                            CrashApi crashApi = CrashApi.getInstance();
                            if (crashApi == null) {
                                Log.e(UAPMCustomException.TAG, "CrashApi is null, not init .");
                            } else {
                                crashApi.generateCustomLog(build);
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }
}
