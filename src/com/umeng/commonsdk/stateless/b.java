package com.umeng.commonsdk.stateless;

import android.content.Context;
import android.content.IntentFilter;
import android.os.FileObserver;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.analytics.pro.bv;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.common.ULog;
import java.io.File;
import java.util.LinkedList;

/* loaded from: /tmp/classes2.dex */
public class b {
    public static final int a = 273;
    private static Context b = null;
    private static HandlerThread c = null;
    private static Handler d = null;
    private static final int f = 274;
    private static final int g = 275;
    private static final int h = 512;
    private static a i = null;
    private static IntentFilter j = null;
    private static volatile boolean k = false;
    private static Object e = new Object();
    private static LinkedList<String> l = new LinkedList<>();

    /* loaded from: /tmp/classes2.dex */
    public static class a extends FileObserver {
        public a(String str) {
            super(str);
        }

        @Override // android.os.FileObserver
        public void onEvent(int i, String str) {
            if ((i & 8) != 8) {
                return;
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> envelope file created >>> " + str);
            b.a(b.f);
        }
    }

    public b(Context context) {
        synchronized (e) {
            if (context != null) {
                try {
                    try {
                        Context applicationContext = context.getApplicationContext();
                        b = applicationContext;
                        if (applicationContext != null && c == null) {
                            HandlerThread handlerThread = new HandlerThread("SL-NetWorkSender");
                            c = handlerThread;
                            handlerThread.start();
                            if (i == null) {
                                String str = b.getFilesDir() + File.separator + com.umeng.commonsdk.stateless.a.f;
                                File file = new File(str);
                                if (!file.exists()) {
                                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 2号数据仓目录不存在，创建之。");
                                    file.mkdir();
                                }
                                a aVar = new a(str);
                                i = aVar;
                                aVar.startWatching();
                                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 2号数据仓File Monitor启动.");
                            }
                            if (d == null) {
                                d = new Handler(c.getLooper()) { // from class: com.umeng.commonsdk.stateless.b.1
                                    @Override // android.os.Handler
                                    public void handleMessage(Message message) {
                                        int i2 = message.what;
                                        if (i2 != 512) {
                                            switch (i2) {
                                                case b.a /* 273 */:
                                                    b.l();
                                                    return;
                                                case b.f /* 274 */:
                                                    b.n();
                                                    return;
                                                case b.g /* 275 */:
                                                    b.p();
                                                    break;
                                                default:
                                                    return;
                                            }
                                        }
                                        b.q();
                                    }
                                };
                            }
                        }
                    } finally {
                    }
                } catch (Throwable th) {
                }
            }
        }
    }

    public static void a(int i2) {
        Handler handler;
        if (!k || (handler = d) == null) {
            return;
        }
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.what = i2;
        d.sendMessage(obtainMessage);
    }

    public static void a(boolean z) {
        k = z;
        if (!z) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>网络断连： 2号数据仓");
        } else {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>网络可用： 触发2号数据仓信封消费动作。");
            b(f);
        }
    }

    public static boolean a() {
        synchronized (e) {
            try {
                return i != null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void b() {
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>信封构建成功： 触发2号数据仓信封消费动作。");
        b(f);
    }

    public static void b(int i2) {
        Handler handler;
        try {
            if (!k || (handler = d) == null || handler.hasMessages(i2)) {
                return;
            }
            Message obtainMessage = d.obtainMessage();
            obtainMessage.what = i2;
            d.sendMessage(obtainMessage);
        } catch (Throwable th) {
            UMCrashManager.reportCrash(b, th);
        }
    }

    public static void c() {
        b(g);
    }

    public static void d() {
        b(512);
    }

    private static void i() {
        File[] c2 = d.c(b);
        if (c2 != null) {
            if (l.size() > 0) {
                l.clear();
            }
            for (File file : c2) {
                l.add(file.getAbsolutePath());
            }
        }
    }

    private static String j() {
        try {
            String peek = l.peek();
            if (peek == null) {
                return peek;
            }
            try {
                l.removeFirst();
                return peek;
            } catch (Throwable unused) {
                return peek;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    private static void k() {
        String pollFirst;
        byte[] bArr;
        if (l.size() <= 0) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> todoList无内容，无需处理。");
            return;
        }
        do {
            pollFirst = l.pollFirst();
            if (!TextUtils.isEmpty(pollFirst)) {
                File file = new File(pollFirst);
                if (file.exists()) {
                    c cVar = new c(b);
                    try {
                        bArr = d.a(pollFirst);
                    } catch (Exception unused) {
                        bArr = null;
                    }
                    String name = file.getName();
                    String substring = !TextUtils.isEmpty(name) ? name.substring(0, 1) : bv.aH;
                    String c2 = d.c(d.d(name));
                    if (SdkVersion.SDK_TYPE == 0) {
                        cVar.a();
                    } else {
                        com.umeng.commonsdk.stateless.a.g = com.umeng.commonsdk.stateless.a.j;
                        cVar.b();
                    }
                    if (cVar.a(bArr, c2, com.umeng.commonsdk.vchannel.a.c.equalsIgnoreCase(c2) ? com.umeng.commonsdk.vchannel.a.a : com.umeng.commonsdk.stateless.a.h, substring) && !file.delete()) {
                        file.delete();
                    }
                } else {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 信封文件不存在，处理下一个文件。");
                }
            }
        } while (pollFirst != null);
        l.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l() {
        File a2;
        byte[] bArr;
        if (!k || b == null) {
            return;
        }
        do {
            try {
                a2 = d.a(b);
                if (a2 != null && a2.getParentFile() != null && !TextUtils.isEmpty(a2.getParentFile().getName())) {
                    c cVar = new c(b);
                    String str = new String(Base64.decode(a2.getParentFile().getName(), 0));
                    if (!com.umeng.commonsdk.internal.a.a.equalsIgnoreCase(str) && !com.umeng.commonsdk.internal.a.b.equalsIgnoreCase(str) && !com.umeng.commonsdk.internal.a.K.equalsIgnoreCase(str)) {
                        ULog.i("walle", "[stateless] handleProcessNext, pathUrl is " + str);
                        try {
                            bArr = d.a(a2.getAbsolutePath());
                        } catch (Exception unused) {
                            bArr = null;
                        }
                        String str2 = bv.aH;
                        if (UMServerURL.PATH_SHARE.equalsIgnoreCase(str)) {
                            str2 = bv.aB;
                        }
                        if (UMServerURL.PATH_PUSH_LAUNCH.equalsIgnoreCase(str) || UMServerURL.PATH_PUSH_REGIST.equalsIgnoreCase(str) || UMServerURL.PATH_PUSH_LOG.equalsIgnoreCase(str)) {
                            str2 = bv.ax;
                        }
                        if (SdkVersion.SDK_TYPE == 0) {
                            cVar.a();
                        } else {
                            com.umeng.commonsdk.stateless.a.g = com.umeng.commonsdk.stateless.a.j;
                            cVar.b();
                        }
                        if (!cVar.a(bArr, str, com.umeng.commonsdk.vchannel.a.c.equalsIgnoreCase(str) ? com.umeng.commonsdk.vchannel.a.a : com.umeng.commonsdk.stateless.a.h, str2)) {
                            ULog.i("walle", "[stateless] Send envelope file failed, abandon and wait next trigger!");
                            return;
                        }
                        ULog.i("walle", "[stateless] Send envelope file success, delete it.");
                        File file = new File(a2.getAbsolutePath());
                        if (!file.delete()) {
                            ULog.i("walle", "[stateless] Failed to delete already processed file. We try again after delete failed.");
                            file.delete();
                        }
                    }
                    new File(a2.getAbsolutePath()).delete();
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(b, th);
            }
        } while (a2 != null);
        m();
    }

    private static void m() {
        try {
            File file = new File(b.getFilesDir() + File.separator + com.umeng.commonsdk.stateless.a.e);
            if (file.exists() && file.isDirectory()) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 2号数据仓：删除stateless目录。");
                d.a(file);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void n() {
        if (!k || b == null) {
            return;
        }
        i();
        k();
        c();
    }

    private static void o() {
        try {
            File file = new File(b.getFilesDir() + File.separator + com.umeng.commonsdk.stateless.a.e);
            if (file.exists() && file.isDirectory()) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>2号数据仓：检测到stateless目录。");
                b(a);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void p() {
        o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q() {
    }
}
