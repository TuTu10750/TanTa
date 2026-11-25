package com.umeng.powersdk;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.protocol.record.EfsJSONLog;
import com.umeng.powersdk.c;
import java.lang.ref.WeakReference;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

/* loaded from: /tmp/classes2.dex */
public class PowerManager {
    public static final String TAG = "PowerManager";
    private static Context a = null;
    private static boolean b = false;
    private static EfsReporter c = null;
    private static PowerConfigManager d = null;
    public static boolean isDebug = true;

    public static Context getApplicationContext() {
        return a;
    }

    public static PowerConfigManager getPowerConfigManager() {
        return d;
    }

    public static EfsReporter getReporter() {
        return c;
    }

    public static void init(Context context, EfsReporter efsReporter) {
        String str;
        c cVar;
        if (context == null || efsReporter == null) {
            try {
                if (isDebug) {
                    str = "init power manager error! parameter is null!";
                    Log.e(TAG, str);
                    return;
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        if (isInit()) {
            if (isDebug) {
                str = "invalid init ！";
                Log.e(TAG, str);
                return;
            }
            return;
        }
        a = context.getApplicationContext();
        c = efsReporter;
        d = new PowerConfigManager(context, efsReporter);
        b = true;
        cVar = c.a.a;
        try {
            if (getPowerConfigManager() == null || !getPowerConfigManager().enableTracer()) {
                return;
            }
            SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("efs_power", 0);
            if (sharedPreferences != null) {
                cVar.b = sharedPreferences.getInt("apm_powerperf_collect_interval", 5);
                cVar.c = sharedPreferences.getInt("apm_powerperf_collect_max_period_sec", 100);
            }
            HandlerThread handlerThread = new HandlerThread("power-info");
            handlerThread.start();
            c.AnonymousClass1 anonymousClass1 = new Handler(handlerThread.getLooper()) { // from class: com.umeng.powersdk.c.1
                final /* synthetic */ HandlerThread a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass1(Looper looper, HandlerThread handlerThread2) {
                    super(looper);
                    r3 = handlerThread2;
                }

                @Override // android.os.Handler
                public final void handleMessage(Message message) {
                    super.handleMessage(message);
                    if (message.what == c.this.a) {
                        try {
                            r3.quit();
                        } catch (Throwable unused) {
                        }
                    }
                }
            };
            anonymousClass1.post(new Runnable() { // from class: com.umeng.powersdk.c.2
                final /* synthetic */ Handler a;

                public AnonymousClass2(Handler anonymousClass12) {
                    r2 = anonymousClass12;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        c cVar2 = c.this;
                        Handler handler = r2;
                        int i = cVar2.b;
                        handler.post(new Runnable() { // from class: com.umeng.powersdk.c.3
                            final /* synthetic */ long a;
                            final /* synthetic */ int b;
                            final /* synthetic */ Handler c;
                            final /* synthetic */ int d;

                            public AnonymousClass3(long j, int i2, Handler handler2, int i3) {
                                r2 = j;
                                r4 = i2;
                                r5 = handler2;
                                r6 = i3;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                if (c.this.e) {
                                    if (SystemClock.elapsedRealtime() - r2 > r4 * IjkMediaCodecInfo.RANK_MAX) {
                                        r5.sendEmptyMessage(c.this.a);
                                        return;
                                    }
                                    try {
                                        EfsJSONLog efsJSONLog = new EfsJSONLog("powerperf");
                                        efsJSONLog.put("power", c.this.a());
                                        EfsReporter reporter = PowerManager.getReporter();
                                        if (reporter != null) {
                                            reporter.send(efsJSONLog);
                                        }
                                    } catch (Throwable unused) {
                                    }
                                }
                                r5.postDelayed(this, r6 * IjkMediaCodecInfo.RANK_MAX);
                            }
                        });
                    } catch (Throwable unused) {
                        r2.sendEmptyMessage(c.this.a);
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    public static boolean isInit() {
        return b;
    }

    public static void onActivityResumed(Activity activity) {
        c cVar;
        cVar = c.a.a;
        try {
            if (getPowerConfigManager() != null && getPowerConfigManager().enableTracer()) {
                cVar.d = new WeakReference<>(activity);
            }
        } catch (Throwable unused) {
        }
    }

    public static void onActivityStarted(Activity activity) {
        c cVar;
        cVar = c.a.a;
        try {
            if (getPowerConfigManager() != null && getPowerConfigManager().enableTracer() && activity != null) {
                if (cVar.g) {
                    cVar.g = false;
                    return;
                }
                int i = cVar.f + 1;
                cVar.f = i;
                if (i == 1) {
                    cVar.e = true;
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void onActivityStopped(Activity activity) {
        c cVar;
        cVar = c.a.a;
        try {
            if (getPowerConfigManager() != null && getPowerConfigManager().enableTracer() && activity != null) {
                if (activity.isChangingConfigurations()) {
                    cVar.g = true;
                    return;
                }
                int i = cVar.f - 1;
                cVar.f = i;
                if (i == 0) {
                    cVar.e = false;
                }
            }
        } catch (Throwable unused) {
        }
    }
}
