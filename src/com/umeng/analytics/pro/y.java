package com.umeng.analytics.pro;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.l;
import com.umeng.analytics.pro.r;
import com.umeng.analytics.vshelper.PageNameMonitor;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /tmp/classes2.dex */
public class y {
    private static final int c = 5;
    private static JSONArray d = new JSONArray();
    private static Object e = new Object();
    private final Map<String, Long> f = new HashMap();
    Stack<String> a = new Stack<>();
    com.umeng.analytics.vshelper.a b = PageNameMonitor.getInstance();

    public static void a(Context context) {
        String jSONArray;
        if (context != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                synchronized (e) {
                    jSONArray = d.toString();
                    d = new JSONArray();
                }
                if (jSONArray.length() > 0) {
                    jSONObject.put("__a", new JSONArray(jSONArray));
                    if (jSONObject.length() > 0) {
                        l.a(context).a(x.a().c(), jSONObject, l.a.PAGE);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public int a() {
        return 2;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (UMConfigure.isDebugLog() && this.a.size() != 0) {
            String[] strArr = {this.a.peek()};
            UMLog.aq(m.F, 0, "\\|", new String[]{"@"}, strArr, null, null);
        }
        this.b.customPageBegin(str);
        synchronized (this.f) {
            try {
                this.f.put(str, Long.valueOf(System.currentTimeMillis()));
                if (UMConfigure.isDebugLog()) {
                    this.a.push(str);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void b() {
        String str;
        synchronized (this.f) {
            try {
                str = null;
                long j = 0;
                for (Map.Entry<String, Long> entry : this.f.entrySet()) {
                    if (entry.getValue().longValue() > j) {
                        long longValue = entry.getValue().longValue();
                        str = entry.getKey();
                        j = longValue;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (str != null) {
            b(str);
        }
    }

    public void b(String str) {
        Long l;
        Context appContext;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!this.f.containsKey(str)) {
            if (UMConfigure.isDebugLog() && this.a.size() == 0) {
                UMLog.aq(m.G, 0, "\\|", new String[]{"@"}, new String[]{str}, null, null);
                return;
            }
            return;
        }
        synchronized (this.f) {
            l = this.f.get(str);
            this.f.remove(str);
        }
        if (l == null) {
            return;
        }
        if (UMConfigure.isDebugLog() && this.a.size() > 0 && str.equals(this.a.peek())) {
            this.a.pop();
        }
        long currentTimeMillis = System.currentTimeMillis() - l.longValue();
        synchronized (e) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(g.v, str);
                jSONObject.put("duration", currentTimeMillis);
                jSONObject.put(g.x, l);
                jSONObject.put("type", a());
                d.put(jSONObject);
                if (d.length() >= 5 && (appContext = UMGlobalContext.getAppContext(null)) != null) {
                    UMWorkDispatch.sendEvent(appContext, r.a.c, CoreProtocol.getInstance(appContext), null);
                }
            } catch (Throwable unused) {
            }
        }
        if (!UMConfigure.isDebugLog() || this.a.size() == 0) {
            return;
        }
        UMLog.aq(m.E, 0, "\\|", new String[]{"@"}, new String[]{str}, null, null);
    }
}
