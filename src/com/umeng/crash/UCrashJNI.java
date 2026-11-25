package com.umeng.crash;

import android.app.ActivityManager;
import com.umeng.crash.f;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /tmp/classes2.dex */
public class UCrashJNI {
    private static String getValue(int i) {
        i a = i.a();
        if (i == 1) {
            return m.i();
        }
        if (i == 100) {
            long currentTimeMillis = System.currentTimeMillis();
            a.d = currentTimeMillis;
            a.c = k.a(currentTimeMillis, "_jni.log");
            return c.a().c + File.separator + a.c;
        }
        if (i == 101) {
            return m.a("jni", a.d, a.c);
        }
        if (i != 200) {
            return i == 201 ? m.a("anr", a.d, a.c) : "";
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        a.d = currentTimeMillis2;
        a.c = k.a(currentTimeMillis2, "_anr.log");
        return c.a().c + File.separator + a.c;
    }

    public static native int init(String str, boolean z);

    private static void onAnr(String str) {
        String str2;
        i.a();
        UCrash.a().c("UCrash.Native", "onAnr time: " + new Date() + " path:" + str);
        BufferedOutputStream bufferedOutputStream = null;
        try {
            f.b bVar = i.a().a;
            if (bVar == null) {
                UCrash.a().d("UCrash.Native", "onAnr config null.");
                return;
            }
            f.a aVar = bVar.a;
            if (aVar == null) {
                UCrash.a().d("UCrash.Native", "onAnr callback null.");
                return;
            }
            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(str, true));
            try {
                k.a((OutputStream) bufferedOutputStream2);
                k.a(bufferedOutputStream2, m.a(m.l()));
                k.a((OutputStream) bufferedOutputStream2);
                k.a(bufferedOutputStream2, m.m());
                k.a((OutputStream) bufferedOutputStream2);
                k.a(bufferedOutputStream2, m.f());
                k.a((OutputStream) bufferedOutputStream2);
                k.a(bufferedOutputStream2, m.h());
                k.a((OutputStream) bufferedOutputStream2);
                k.a(bufferedOutputStream2, m.g());
                if (bVar.i) {
                    k.a((OutputStream) bufferedOutputStream2);
                    k.a(bufferedOutputStream2, m.b());
                }
                k.a((OutputStream) bufferedOutputStream2);
                k.a(bufferedOutputStream2, m.j());
                k.a((OutputStream) bufferedOutputStream2);
                k.a(bufferedOutputStream2, m.e());
                k.a((OutputStream) bufferedOutputStream2);
                k.a(bufferedOutputStream2, m.k());
                if (bVar.p) {
                    k.a((OutputStream) bufferedOutputStream2);
                    k.a(bufferedOutputStream2, m.c());
                }
                aVar.a("anr", bufferedOutputStream2);
                i.a(str, (OutputStream) bufferedOutputStream2, false);
                String format = String.format(Locale.US, "Process Name: '%s'\nThread Name: '%s'\nANR Time: %s\n\nANR Info:\n", c.a().f, m.l(), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault()).format(new Date()));
                k.a((OutputStream) bufferedOutputStream2);
                k.a(bufferedOutputStream2, format);
                bufferedOutputStream2.flush();
                i.a().getClass();
                ActivityManager.ProcessErrorStateInfo a = m.a();
                if (a != null) {
                    str2 = a.longMsg;
                } else {
                    str2 = "(get failed)";
                    try {
                        UCrash.a().d("UCrash.Native", "checkProcessAnrState false, not ANR.");
                        try {
                            bufferedOutputStream2.close();
                        } catch (IOException e) {
                            UCrash.a().a("UCrash.Native", "close outputStream failed", e);
                        }
                        File file = new File(str);
                        if (file.exists()) {
                            file.delete();
                        }
                        File file2 = new File(str + ".traces.dp");
                        if (file2.exists()) {
                            file2.delete();
                        }
                        File file3 = new File(str + ".traces.hk");
                        if (file3.exists()) {
                            file3.delete();
                        }
                        k.a((Closeable) bufferedOutputStream2);
                        return;
                    } catch (Exception unused) {
                    }
                }
                k.a(bufferedOutputStream2, str2);
                bufferedOutputStream2.flush();
                i.a(str, (OutputStream) bufferedOutputStream2, true);
                aVar.a("anr", str);
                k.a((Closeable) bufferedOutputStream2);
            } catch (Throwable th) {
                th = th;
                bufferedOutputStream = bufferedOutputStream2;
                try {
                    UCrash.a().a("UCrash.Native", "onLogGenerated(TYPE_NATIVE) failed", th);
                } finally {
                    k.a((Closeable) bufferedOutputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static void onAnrSignal() {
        i.a();
        i.b();
    }

    private static void onCrash(String str, boolean z, String str2) {
        i.a();
        i.a(str, z, str2);
    }

    public static native void onJavaCrashed();

    public static native int registerAnr(boolean z);

    public static native int registerNative(boolean z);
}
