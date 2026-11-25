package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class ab {
    private static volatile ab c;
    private z a = new aa();
    private String b;
    private List<a> d;
    private String e;

    /* loaded from: /tmp/classes2.dex */
    public interface a {
        void a(String str, long j, long j2, long j3);

        void a(String str, String str2, long j, long j2, long j3);
    }

    private ab() {
    }

    private long a(Context context, String str) {
        long j;
        try {
            j = PreferenceWrapper.getDefault(context).getLong(str, 0L);
        } catch (Exception unused) {
            j = 0;
        }
        return j <= 0 ? System.currentTimeMillis() : j;
    }

    public static ab a() {
        if (c == null) {
            synchronized (ab.class) {
                try {
                    if (c == null) {
                        c = new ab();
                    }
                } finally {
                }
            }
        }
        return c;
    }

    private void a(long j, long j2, long j3, String str, boolean z) {
        List<a> list = this.d;
        if (list != null) {
            for (a aVar : list) {
                String str2 = this.b;
                if (z) {
                    try {
                        aVar.a(str, str2, j, j2, j3);
                    } catch (Exception unused) {
                    }
                } else {
                    aVar.a(str2, j, j2, j3);
                }
            }
        }
    }

    private String f(Context context) {
        try {
            SharedPreferences.Editor edit = PreferenceWrapper.getDefault(context).edit();
            edit.putString(x.d, d(context));
            edit.commit();
        } catch (Exception unused) {
        }
        long h = h(context);
        long i = i(context);
        String str = this.b;
        long a2 = x.a(context);
        long j = a2 * 5000;
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>*** 读取 foreground count 值完成，count次数：" + a2);
        if (!FieldManager.allow(com.umeng.commonsdk.utils.d.E)) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>*** foreground count druation云控参数关闭。");
        } else if (UMWorkDispatch.eventHasExist()) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>*** 读取 foreground count druation值完成，终止checker timer.");
            UMWorkDispatch.removeEvent();
        } else {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>*** 读取 foreground count druation值完成，无未处理check timer事件。");
        }
        a(i, h, j, str, false);
        this.b = this.a.a(context);
        a(i, h, j, str, true);
        this.a.a(context, this.b);
        return this.b;
    }

    private boolean g(Context context) {
        return !TextUtils.isEmpty(this.b) && l.a(context).a(this.b) > 0;
    }

    private long h(Context context) {
        return a(context, x.f);
    }

    private long i(Context context) {
        return a(context, x.a);
    }

    private boolean j(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(appContext);
            long j = sharedPreferences.getLong(x.e, 0L);
            long j2 = sharedPreferences.getLong(x.f, 0L);
            if (FieldManager.allow(com.umeng.commonsdk.utils.d.E) && j > 0 && j2 == 0) {
                long a2 = x.a(appContext);
                if (a2 > 0) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> last session end time stamp = 0, reconstruct it by foreground count value.");
                    j2 = j + (a2 * 5000);
                }
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> interval of last session is: " + (j2 - j));
            return this.a.a(j, j2);
        } catch (Exception unused) {
            return false;
        }
    }

    public String a(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        if (appContext == null) {
            return "";
        }
        String str = "";
        try {
            synchronized (ab.class) {
                str = PreferenceWrapper.getDefault(appContext).getString(x.d, "");
            }
            return str;
        } catch (Exception unused) {
            return str;
        }
    }

    public String a(Context context, long j) {
        if (TextUtils.isEmpty(this.e)) {
            String str = "SUB" + j;
            this.e = str.concat(String.format("%0" + (32 - str.length()) + "d", 0));
        }
        return this.e;
    }

    public void a(long j) {
        this.a.a(j);
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        if (this.d == null) {
            this.d = new ArrayList();
        }
        if (this.d.contains(aVar)) {
            return;
        }
        this.d.add(aVar);
    }

    public long b() {
        return this.a.a();
    }

    public synchronized String b(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        if (appContext == null) {
            return "";
        }
        this.b = d(appContext);
        if (e(appContext)) {
            try {
                this.b = f(appContext);
            } catch (Exception unused) {
            }
        }
        return this.b;
    }

    public void b(a aVar) {
        List<a> list;
        if (aVar == null || (list = this.d) == null || list.size() == 0) {
            return;
        }
        this.d.remove(aVar);
    }

    public String c(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        if (appContext == null) {
            return "";
        }
        try {
            this.b = f(appContext);
        } catch (Exception unused) {
        }
        return this.b;
    }

    public String d(Context context) {
        if (TextUtils.isEmpty(this.b)) {
            try {
                this.b = PreferenceWrapper.getDefault(context).getString("session_id", null);
            } catch (Exception unused) {
            }
        }
        return this.b;
    }

    public boolean e(Context context) {
        if (TextUtils.isEmpty(this.b)) {
            this.b = d(context);
        }
        return TextUtils.isEmpty(this.b) || j(context) || g(context);
    }
}
