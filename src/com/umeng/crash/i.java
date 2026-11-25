package com.umeng.crash;

import android.os.Handler;
import android.os.Looper;
import com.umeng.analytics.pro.r;
import com.umeng.crash.f;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /tmp/classes2.dex */
public final class i {
    private static final i e = new i();
    f.b a;
    boolean b;
    String c;
    long d;
    private final long f = 25000;

    private i() {
    }

    public static i a() {
        return e;
    }

    public static void a(String str, OutputStream outputStream, boolean z) {
        boolean z2;
        FileInputStream fileInputStream;
        Throwable th;
        File file = new File(str + ".traces.hk");
        if (!file.exists() || file.length() <= 0) {
            z2 = false;
        } else {
            UCrash.a().b("UCrash.Native", "anr traces hk exists");
            z2 = true;
        }
        File file2 = new File(str + ".traces.dp");
        if (file2.exists() && file2.length() > 0) {
            UCrash.a().b("UCrash.Native", "anr traces dp exists");
            if (z2) {
                file2.delete();
            } else {
                file = file2;
            }
        }
        if (!file.exists()) {
            if (z) {
                UCrash.a().b("UCrash.Native", "anr traces not exists");
                return;
            }
            return;
        }
        k.a(outputStream);
        k.a(outputStream, "anr traces:\n");
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Throwable th2) {
            fileInputStream = null;
            th = th2;
        }
        try {
            byte[] bArr = new byte[r.a.u];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    outputStream.flush();
                    k.a(fileInputStream);
                    file.delete();
                    return;
                }
                outputStream.write(bArr, 0, read);
            }
        } catch (Throwable th3) {
            th = th3;
            k.a(fileInputStream);
            throw th;
        }
    }

    public static void a(String str, boolean z, String str2) {
        Throwable th;
        UCrash.a().c("UCrash.Native", "onCrash time: " + new Date());
        f.b bVar = e.a;
        if (bVar == null) {
            UCrash.a().d("UCrash.Native", "onCrash config null.");
            return;
        }
        f.a aVar = bVar.a;
        if (aVar == null) {
            UCrash.a().d("UCrash.Native", "onCrash callback null.");
            return;
        }
        BufferedOutputStream bufferedOutputStream = null;
        if (z) {
            try {
                str2 = m.l();
            } catch (Throwable th2) {
                th = th2;
                try {
                    UCrash.a().a("UCrash.Native", "onLogGenerated(TYPE_NATIVE) failed", th);
                } finally {
                    k.a((Closeable) bufferedOutputStream);
                }
            }
        }
        BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(str, true));
        try {
            k.a((OutputStream) bufferedOutputStream2);
            k.a(bufferedOutputStream2, m.a(str2));
            k.a((OutputStream) bufferedOutputStream2);
            k.a(bufferedOutputStream2, m.m());
            if (bVar.j) {
                k.a((OutputStream) bufferedOutputStream2);
                k.a(bufferedOutputStream2, "dumping all threads:\n");
                k.a(bufferedOutputStream2, m.b(str2));
            }
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
            if (bVar.k) {
                k.a((OutputStream) bufferedOutputStream2);
                k.a(bufferedOutputStream2, m.c());
            }
            k.a((OutputStream) bufferedOutputStream2);
            k.a(bufferedOutputStream2, m.j());
            k.a((OutputStream) bufferedOutputStream2);
            k.a(bufferedOutputStream2, m.e());
            k.a((OutputStream) bufferedOutputStream2);
            k.a(bufferedOutputStream2, m.k());
            aVar.a("jni", bufferedOutputStream2);
            bufferedOutputStream2.flush();
            aVar.a("jni", str);
            if (!bVar.h) {
                e.a().b();
            }
            k.a((Closeable) bufferedOutputStream2);
        } catch (Throwable th3) {
            th = th3;
            bufferedOutputStream = bufferedOutputStream2;
            UCrash.a().a("UCrash.Native", "onLogGenerated(TYPE_NATIVE) failed", th);
        }
    }

    public static void b() {
        UCrash.a().c("UCrash.Native", "onAnrSignal time: " + new Date());
        new Handler(Looper.getMainLooper()).sendEmptyMessage(0);
    }

    public final int a(f.b bVar) {
        if (bVar == null) {
            return -2;
        }
        try {
            System.loadLibrary("ucrash");
            this.a = bVar;
            try {
                int init = UCrashJNI.init(c.a().j, h.a);
                if (init != 0) {
                    UCrash.a().d("UCrash.Native", "init failed code: ".concat(String.valueOf(init)));
                    return -4;
                }
                if (bVar.g && UCrashJNI.registerNative(bVar.h) != 0) {
                    return -5;
                }
                if (bVar.l && UCrashJNI.registerAnr(bVar.m) != 0) {
                    return -6;
                }
                this.b = true;
                return 0;
            } catch (Throwable unused) {
                return -100;
            }
        } catch (Throwable unused2) {
            return -3;
        }
    }
}
