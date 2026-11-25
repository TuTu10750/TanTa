package defpackage;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.umeng.commonsdk.statistics.SdkVersion;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* loaded from: /tmp/classes2.dex */
public class aj1 {
    public static int A = 0;
    public static int B = 0;
    public static int C = 0;
    public static Object b = new Object();
    public static Context c = null;
    public static boolean d = false;
    public static bj1 e;
    public static bj1 f;
    public static bj1 g;
    public static HandlerThread h;
    public static Handler i;
    public static String j;
    public static String k;
    public static String l;
    public static String m;
    public static String n;
    public static String o;
    public static volatile aj1 p;
    public static volatile i90 q;
    public static int r;
    public static int s;
    public static int t;
    public static int u;
    public static int v;
    public static int w;
    public static int x;
    public static int y;
    public static int z;
    public final int a;

    /* loaded from: /tmp/classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (aj1.r + aj1.s + aj1.x + aj1.A + aj1.t + aj1.u + aj1.z + aj1.A + aj1.v + aj1.w + aj1.B + aj1.C > 0) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("oaid", aj1.this.h(aj1.r, aj1.s, aj1.x, aj1.y));
                contentValues.put("vaid", aj1.this.h(aj1.t, aj1.u, aj1.z, aj1.A));
                contentValues.put("aaid", aj1.this.h(aj1.v, aj1.w, aj1.B, aj1.C));
                aj1.q.b(7, "vivo", new ContentValues[]{contentValues});
                int unused = aj1.r = aj1.s = aj1.t = aj1.u = aj1.v = aj1.w = 0;
                int unused2 = aj1.x = aj1.y = aj1.z = aj1.A = aj1.B = aj1.C = 0;
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 11) {
                Log.e("VMS_SDK_Client", "message type valid");
                return;
            }
            int i = message.getData().getInt("type");
            try {
                String a = aj1.q.a(i, message.getData().getString("appid"));
                if (i == 0) {
                    String unused = aj1.j = a;
                    aj1.w(8, aj1.j);
                } else if (i == 1) {
                    if (a != null) {
                        String unused2 = aj1.k = a;
                    } else {
                        Log.e("VMS_SDK_Client", "get vaid failed");
                    }
                    aj1.w(9, aj1.k);
                } else if (i == 2) {
                    if (a != null) {
                        String unused3 = aj1.l = a;
                    } else {
                        Log.e("VMS_SDK_Client", "get aaid failed");
                    }
                    aj1.w(10, aj1.l);
                } else if (i != 3) {
                    if (i == 4) {
                        String unused4 = aj1.n = a;
                    } else if (i == 5) {
                        if (a != null) {
                            String unused5 = aj1.o = a;
                        } else {
                            Log.e("VMS_SDK_Client", "get guid failed");
                        }
                    }
                } else if (a != null) {
                    String unused6 = aj1.m = a;
                } else {
                    Log.e("VMS_SDK_Client", "get udid failed");
                }
            } catch (Exception e) {
                Log.e("VMS_SDK_Client", "readException:" + e.toString());
            }
            synchronized (aj1.b) {
                aj1.b.notify();
            }
        }
    }

    public aj1() {
        d();
        q = new i90(c);
        this.a = t(c);
    }

    public static void d() {
        HandlerThread handlerThread = new HandlerThread("SqlWorkThread");
        h = handlerThread;
        handlerThread.start();
        i = new b(h.getLooper());
    }

    public static void e() {
        d = SdkVersion.MINI_VERSION.equals(k("persist.sys.identifierid.supported", "0")) || SdkVersion.MINI_VERSION.equals(k("persist.sys.identifierid", "0"));
    }

    public static aj1 g(Context context) {
        if (c == null) {
            if (context == null) {
                return null;
            }
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            c = context;
        }
        if (p == null) {
            synchronized (aj1.class) {
                try {
                    if (p == null) {
                        p = new aj1();
                        p.c();
                    }
                } finally {
                }
            }
        }
        return p;
    }

    public static String k(String str, String str2) {
        try {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "0");
            } catch (Exception e2) {
                Log.e("VMS_SDK_Client", "getProperty: invoke is error" + e2.getMessage());
                return str2;
            }
        } catch (Throwable unused) {
            return str2;
        }
    }

    public static synchronized void m(Context context, int i2, String str) {
        synchronized (aj1.class) {
            try {
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 == 2) {
                            if (g == null) {
                                g = new bj1(p, 2, str);
                                context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/" + context.getPackageName()), false, g);
                            }
                        }
                    } else if (f == null) {
                        f = new bj1(p, 1, str);
                        context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + str), false, f);
                    }
                } else if (e == null) {
                    e = new bj1(p, 0, null);
                    context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean n() {
        if (!d) {
            e();
        }
        return d;
    }

    public static aj1 p(Context context) {
        if (n()) {
            return g(context);
        }
        return null;
    }

    public static int t(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.vivo.vms", 0).versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static void w(int i2, String str) {
        if (i2 == 0) {
            if (str == null) {
                s++;
                return;
            } else {
                r++;
                return;
            }
        }
        if (i2 == 1) {
            if (str == null) {
                u++;
                return;
            } else {
                t++;
                return;
            }
        }
        if (i2 == 2) {
            if (str == null) {
                w++;
                return;
            } else {
                v++;
                return;
            }
        }
        switch (i2) {
            case 8:
                if (str == null) {
                    y++;
                    return;
                } else {
                    x++;
                    return;
                }
            case 9:
                if (str == null) {
                    A++;
                    return;
                } else {
                    z++;
                    return;
                }
            case 10:
                if (str == null) {
                    C++;
                    return;
                } else {
                    B++;
                    return;
                }
            default:
                return;
        }
    }

    public final void B(int i2, String str) {
        synchronized (b) {
            l(i2, str);
            long uptimeMillis = SystemClock.uptimeMillis();
            try {
                b.wait(2000L);
            } catch (InterruptedException unused) {
                Log.e("VMS_SDK_Client", "queryId: lock error");
            }
            if (SystemClock.uptimeMillis() - uptimeMillis >= 2000) {
                Log.d("VMS_SDK_Client", "query timeout");
            }
        }
    }

    public final void c() {
        Executors.newScheduledThreadPool(1).scheduleWithFixedDelay(new a(), 600L, 600L, TimeUnit.SECONDS);
    }

    public final String h(int i2, int i3, int i4, int i5) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(i2);
        stringBuffer.append(",");
        stringBuffer.append(i3);
        stringBuffer.append(";");
        stringBuffer.append(i4);
        stringBuffer.append(",");
        stringBuffer.append(i5);
        return stringBuffer.toString();
    }

    public void l(int i2, String str) {
        Message obtainMessage = i.obtainMessage();
        obtainMessage.what = 11;
        Bundle bundle = new Bundle();
        bundle.putInt("type", i2);
        if (i2 == 1 || i2 == 2 || i2 == 6) {
            bundle.putString("appid", str);
        }
        obtainMessage.setData(bundle);
        i.sendMessage(obtainMessage);
    }

    public String u() {
        String str = j;
        if (str != null) {
            w(0, str);
            return j;
        }
        B(0, null);
        if (e == null) {
            m(c, 0, null);
        }
        w(0, j);
        return j;
    }
}
