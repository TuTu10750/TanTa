package com.uc.crashsdk;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.ConditionVariable;
import android.os.Debug;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.StatFs;
import android.os.StrictMode;
import com.uc.crashsdk.a.h;
import com.uc.crashsdk.export.LogType;
import com.umeng.analytics.pro.cl;
import com.umeng.umcrash.custom_exception.UMCustomLogInfoBuilder;
import com.zzhoujay.richtext.cache.CacheIOHelper;
import defpackage.jr4;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.lang.Thread;
import java.lang.reflect.Method;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: /tmp/classes2.dex */
public class e implements Thread.UncaughtExceptionHandler {
    static final /* synthetic */ boolean a = true;
    private static long b;
    private static String i;
    private final List<FileInputStream> e = new ArrayList();
    private static final AtomicBoolean c = new AtomicBoolean(false);
    private static boolean d = false;
    private static long f = 0;
    private static long g = -1;
    private static boolean h = true;
    private static String j = "";
    private static String k = null;
    private static String l = null;
    private static String m = null;
    private static final Object n = new Object();
    private static final ConditionVariable o = new ConditionVariable();
    private static final Object p = new Object();
    private static final Object q = new Object();
    private static final Object r = new Object();
    private static final ArrayList<String> s = new ArrayList<>();
    private static int t = 0;
    private static String u = null;
    private static boolean v = false;
    private static String w = null;
    private static String x = null;
    private static final Object y = new Object();
    private static final Object z = new Object();
    private static Map<String, Integer> A = null;
    private static String B = null;
    private static int C = -1;
    private static int D = -1;
    private static int E = -1;
    private static int F = -1;
    private static int G = -1;
    private static int H = -1;
    private static int I = -1;
    private static String J = "?";
    private static boolean K = false;
    private static boolean L = false;
    private static int M = 0;
    private static int N = 0;
    private static boolean O = false;
    private static com.uc.crashsdk.a.e P = new com.uc.crashsdk.a.e(405);
    private static c Q = new c(0);
    private static boolean R = false;
    private static final com.uc.crashsdk.a.e S = new com.uc.crashsdk.a.e(412);
    private static Thread.UncaughtExceptionHandler T = null;
    private static Throwable U = null;
    private static boolean V = false;
    private static boolean W = false;
    private static Runnable X = null;
    private static final Object Y = new Object();
    private static int Z = 101;
    private static Runnable aa = new com.uc.crashsdk.a.e(407);
    private static final Object ab = new Object();
    private static volatile boolean ac = false;
    private static Object ad = new Object();
    private static ParcelFileDescriptor ae = null;
    private static boolean af = false;
    private static boolean ag = false;

    /* loaded from: /tmp/classes2.dex */
    public static class a extends OutputStream {
        private final long a;
        private final OutputStream b;
        private int c = 0;
        private int d = 0;
        private boolean e = false;

        public a(long j, OutputStream outputStream) {
            this.a = j;
            this.b = outputStream;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0027  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0030  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private int a(byte[] r6, int r7, int r8) {
            /*
                r5 = this;
                int r0 = r5.d
                int r0 = r0 + r8
                r5.d = r0
                boolean r0 = r5.e
                if (r0 == 0) goto Lb
                r5 = 0
                return r5
            Lb:
                int r0 = com.uc.crashsdk.g.B()
                if (r0 <= 0) goto L19
                int r1 = r5.c
                int r2 = r1 + r8
                if (r2 <= r0) goto L19
                int r0 = r0 - r1
                goto L1a
            L19:
                r0 = r8
            L1a:
                int r1 = r5.c
                int r1 = r1 + r0
                r5.c = r1
                long r1 = r5.a
                r3 = 0
                int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
                if (r1 == 0) goto L30
                java.lang.String r1 = new java.lang.String
                r1.<init>(r6, r7, r0)
                r5.b(r1)
                goto L35
            L30:
                java.io.OutputStream r1 = r5.b
                r1.write(r6, r7, r0)
            L35:
                if (r0 >= r8) goto L3a
                r6 = 1
                r5.e = r6
            L3a:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.a.a(byte[], int, int):int");
        }

        private void b(String str) {
            if (com.uc.crashsdk.b.d) {
                JNIBridge.nativeClientWriteData(this.a, str);
            }
        }

        public final void a() {
            try {
                if (this.d - this.c > 0) {
                    a(UMCustomLogInfoBuilder.LINE_SEP);
                    a("--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n");
                }
                a(String.format(Locale.US, "Full: %d bytes, write: %d bytes, limit: %d bytes, reject: %d bytes.\n", Integer.valueOf(this.d), Integer.valueOf(this.c), Integer.valueOf(g.B()), Integer.valueOf(this.d - this.c)));
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
        }

        public final void a(String str) {
            if (e.h && e.I()) {
                com.uc.crashsdk.a.a.d("DEBUG", str);
            }
            if (this.a != 0) {
                b(str);
            } else {
                this.b.write(str.getBytes("UTF-8"));
            }
        }

        @Override // java.io.OutputStream
        public final void write(int i) {
            if (e.h && e.I()) {
                com.uc.crashsdk.a.a.d("DEBUG", String.format(Locale.US, "%c", Integer.valueOf(i)));
            }
            if (this.a != 0) {
                b(String.format(Locale.US, "%c", Integer.valueOf(i)));
            } else {
                this.b.write(i);
            }
            this.c++;
            this.d++;
        }

        @Override // java.io.OutputStream
        public final void write(byte[] bArr) {
            if (e.h && e.I() && (bArr.length != 1 || bArr[0] != 10)) {
                try {
                    com.uc.crashsdk.a.a.d("DEBUG", new String(bArr));
                } catch (Throwable unused) {
                }
            }
            a(bArr, 0, bArr.length);
        }

        @Override // java.io.OutputStream
        public final void write(byte[] bArr, int i, int i2) {
            if (e.h && e.I()) {
                byte[] bArr2 = new byte[i2];
                System.arraycopy(bArr, i, bArr2, 0, i2);
                if (i2 != 1 || bArr2[0] != 10) {
                    try {
                        com.uc.crashsdk.a.a.d("DEBUG", new String(bArr2));
                    } catch (Throwable unused) {
                    }
                }
            }
            a(bArr, i, i2);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static class b implements Comparator<File> {
        private b() {
        }

        public /* synthetic */ b(byte b) {
            this();
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(File file, File file2) {
            File file3 = file;
            File file4 = file2;
            if (file3.lastModified() > file4.lastModified()) {
                return 1;
            }
            return file3.lastModified() < file4.lastModified() ? -1 : 0;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static class c extends BroadcastReceiver {
        private c() {
        }

        public /* synthetic */ c(byte b) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (!"android.intent.action.BATTERY_CHANGED".equals(action)) {
                if ("android.intent.action.BATTERY_LOW".equals(action) || "android.intent.action.BATTERY_OKAY".equals(action)) {
                    boolean unused = e.K = "android.intent.action.BATTERY_LOW".equals(action);
                    e.K();
                    return;
                } else {
                    if ("android.intent.action.ANR".equals(action)) {
                        try {
                            e.d(context);
                            return;
                        } catch (Throwable th) {
                            com.uc.crashsdk.a.g.a(th);
                            return;
                        }
                    }
                    return;
                }
            }
            int unused2 = e.C = intent.getIntExtra("level", -1);
            int unused3 = e.D = intent.getIntExtra("scale", -1);
            int unused4 = e.E = intent.getIntExtra("voltage", -1);
            int unused5 = e.F = intent.getIntExtra("health", -1);
            int unused6 = e.G = intent.getIntExtra("plugged", -1);
            int unused7 = e.H = intent.getIntExtra(cl.i, -1);
            int unused8 = e.I = intent.getIntExtra("temperature", -1);
            String unused9 = e.J = intent.getStringExtra("technology");
            if (e.J() >= 2) {
                e.K();
                e.L();
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static class d {
        long a;
        long b;
        int c;
        int d;
        boolean e;
        boolean f;
        boolean g;

        private d() {
            this.a = 0L;
            this.b = 0L;
            this.c = 0;
            this.d = 0;
            this.e = false;
            this.f = false;
            this.g = false;
        }

        public /* synthetic */ d(byte b) {
            this();
        }
    }

    public e() {
        try {
            M();
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    public static void A() {
        if (g.r()) {
            com.uc.crashsdk.a.f.a(0, new com.uc.crashsdk.a.e(403), 10000L);
        }
    }

    public static void B() {
        if (ac || com.uc.crashsdk.b.L()) {
            return;
        }
        com.uc.crashsdk.a.f.a(1, new com.uc.crashsdk.a.e(408), 1000L);
    }

    public static void C() {
        com.uc.crashsdk.a.f.a(1, new com.uc.crashsdk.a.e(409), 7000L);
    }

    public static void D() {
        int O2 = g.O();
        boolean z2 = false;
        boolean z3 = true;
        if (O2 != 0 && O2 != 3 && O2 != 4 && O2 == 1) {
            z3 = false;
        }
        if (!z3) {
            com.uc.crashsdk.a.a.a("crashsdk", "SIG 3 is disabled by settings");
        }
        boolean L2 = com.uc.crashsdk.b.L();
        if (Looper.getMainLooper() == Looper.myLooper() || !z3) {
            z2 = z3;
        } else {
            com.uc.crashsdk.a.f.a(2, new com.uc.crashsdk.a.e(413));
        }
        JNIBridge.nativeCmd(7, L2 ? 1L : 0L, null, null);
        if (z2) {
            JNIBridge.cmd(8);
        }
    }

    public static ParcelFileDescriptor E() {
        if (!com.uc.crashsdk.b.d) {
            com.uc.crashsdk.a.a.d("crashsdk", "Crash so is not loaded!");
            return null;
        }
        synchronized (ad) {
            try {
                ParcelFileDescriptor parcelFileDescriptor = ae;
                if (parcelFileDescriptor != null) {
                    return parcelFileDescriptor;
                }
                int cmd = (int) JNIBridge.cmd(14);
                if (cmd == -1) {
                    return null;
                }
                ParcelFileDescriptor adoptFd = ParcelFileDescriptor.adoptFd(cmd);
                ae = adoptFd;
                af = true;
                return adoptFd;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean F() {
        return ag;
    }

    public static void G() {
        String Y2 = g.Y();
        File file = new File(Y2);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                com.uc.crashsdk.a.a.b("Ucebu can not list folder: " + Y2);
                return;
            }
            for (File file2 : listFiles) {
                if (file2.isFile() && file2.getName().contains("ucebu")) {
                    a(false, false);
                    return;
                }
            }
        }
    }

    public static /* synthetic */ boolean I() {
        return O();
    }

    public static /* synthetic */ int J() {
        int i2 = M + 1;
        M = i2;
        return i2;
    }

    public static /* synthetic */ void K() {
        StringBuilder Y2;
        if (com.uc.crashsdk.b.d && (Y2 = Y()) != null) {
            JNIBridge.set(125, Y2.toString());
        }
        L = true;
        Z();
    }

    public static /* synthetic */ int L() {
        M = 0;
        return 0;
    }

    private void M() {
        int J2 = g.J();
        for (int i2 = 0; i2 < J2; i2++) {
            try {
                this.e.add(new FileInputStream("/dev/null"));
            } catch (Exception e) {
                com.uc.crashsdk.a.g.a(e);
                return;
            }
        }
    }

    private void N() {
        Iterator<FileInputStream> it = this.e.iterator();
        while (it.hasNext()) {
            com.uc.crashsdk.a.g.a(it.next());
        }
        this.e.clear();
    }

    private static boolean O() {
        if (g.Q()) {
            return true;
        }
        return a();
    }

    private static String P() {
        return g.e() + "_";
    }

    private static String Q() {
        return com.uc.crashsdk.b.B() ? "fg" : "bg";
    }

    private static byte[] R() {
        byte[] bArr = null;
        int i2 = CacheIOHelper.BUFFER_SIZE;
        while (bArr == null && i2 > 0) {
            try {
                bArr = new byte[i2];
            } catch (Throwable unused) {
                i2 /= 2;
                if (i2 < 16) {
                    break;
                }
            }
        }
        return bArr;
    }

    private static String S() {
        return (!com.uc.crashsdk.b.F() || d) ? "java" : "ucebujava";
    }

    private static void T() {
        String str;
        BufferedReader bufferedReader;
        Throwable th;
        FileReader fileReader;
        String str2 = "-";
        try {
            str = Build.HARDWARE;
        } catch (Throwable th2) {
            com.uc.crashsdk.a.g.a(th2);
            str = "-";
        }
        try {
            fileReader = new FileReader(new File("/proc/cpuinfo"));
            try {
                bufferedReader = new BufferedReader(fileReader, IjkMediaMeta.FF_PROFILE_H264_CONSTRAINED);
                int i2 = 0;
                do {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        if (readLine.startsWith("Hardware")) {
                            str = readLine.substring(readLine.indexOf(":") + 1).trim();
                        } else if (readLine.startsWith("Processor")) {
                            str2 = readLine.substring(readLine.indexOf(":") + 1).trim();
                        }
                        i2++;
                    } catch (Throwable th3) {
                        th = th3;
                        try {
                            com.uc.crashsdk.a.g.a(th);
                            com.uc.crashsdk.a.g.a(fileReader);
                            com.uc.crashsdk.a.g.a(bufferedReader);
                            k = str;
                            l = str2;
                        } catch (Throwable th4) {
                            com.uc.crashsdk.a.g.a(fileReader);
                            com.uc.crashsdk.a.g.a(bufferedReader);
                            throw th4;
                        }
                    }
                } while (i2 < 2);
                com.uc.crashsdk.a.g.a(fileReader);
            } catch (Throwable th5) {
                bufferedReader = null;
                th = th5;
            }
        } catch (Throwable th6) {
            bufferedReader = null;
            th = th6;
            fileReader = null;
        }
        com.uc.crashsdk.a.g.a(bufferedReader);
        k = str;
        l = str2;
    }

    private static String U() {
        return g.X() + "bytes";
    }

    private static boolean V() {
        return Build.VERSION.SDK_INT < 29;
    }

    private static void W() {
        if (O || com.uc.crashsdk.b.F() || com.uc.crashsdk.b.L()) {
            return;
        }
        JNIBridge.cmd(18);
    }

    private static void X() {
        com.uc.crashsdk.a.f.a(3, new com.uc.crashsdk.a.e(414), 1000L);
    }

    private static StringBuilder Y() {
        String str;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("level: ");
            sb.append(C);
            sb.append("\nscale: ");
            sb.append(D);
            sb.append(UMCustomLogInfoBuilder.LINE_SEP);
            switch (F) {
                case 1:
                    str = " (Unknown)";
                    break;
                case 2:
                    str = " (Good)";
                    break;
                case 3:
                    str = " (Overheat)";
                    break;
                case 4:
                    str = " (Dead)";
                    break;
                case 5:
                    str = " (Over voltage)";
                    break;
                case 6:
                    str = " (Unspecified failure)";
                    break;
                case 7:
                    str = " (Cold)";
                    break;
                default:
                    str = " (?)";
                    break;
            }
            sb.append("health: ");
            sb.append(F);
            sb.append(str);
            sb.append(UMCustomLogInfoBuilder.LINE_SEP);
            int i2 = G;
            String str2 = i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 4 ? " (?)" : " (Wireless)" : " (USB port)" : " (AC charger)" : " (None)";
            sb.append("pluged: ");
            sb.append(G);
            sb.append(str2);
            sb.append(UMCustomLogInfoBuilder.LINE_SEP);
            int i3 = H;
            String str3 = i3 != 1 ? i3 != 2 ? i3 != 3 ? i3 != 4 ? i3 != 5 ? " (?)" : " (Full)" : " (Not charging)" : " (Discharging)" : " (Charging)" : " (Unknown)";
            sb.append("status: ");
            sb.append(H);
            sb.append(str3);
            sb.append("\nvoltage: ");
            sb.append(E);
            sb.append("\ntemperature: ");
            sb.append(I);
            sb.append("\ntechnology: ");
            sb.append(J);
            sb.append("\nbattery low: ");
            sb.append(K);
            sb.append(UMCustomLogInfoBuilder.LINE_SEP);
            return sb;
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return null;
        }
    }

    private static void Z() {
        if (com.uc.crashsdk.b.c && L && com.uc.crashsdk.a.c) {
            L = false;
            if (com.uc.crashsdk.a.f.b(P)) {
                return;
            }
            com.uc.crashsdk.a.f.a(0, P, 2000L);
        }
    }

    public static int a(OutputStream outputStream, String str, int i2) {
        int i3 = 0;
        if (str == null) {
            a(outputStream);
            return 0;
        }
        try {
            String a2 = com.uc.crashsdk.a.b.a(str);
            if (a2 == null) {
                a2 = "file: '" + str + "' not found or decode failed!";
            }
            int length = a2.length();
            if (length <= i2 + 32) {
                i2 = length;
            }
            if (i2 > 0) {
                try {
                    outputStream.write(a2.getBytes("UTF-8"), 0, i2);
                    outputStream.write(UMCustomLogInfoBuilder.LINE_SEP.getBytes("UTF-8"));
                } catch (Throwable th) {
                    th = th;
                    i3 = i2;
                    a(th, outputStream);
                    i2 = i3;
                    a(outputStream);
                    return i2;
                }
            }
            if (i2 < a2.length()) {
                outputStream.write(String.format(Locale.US, "(truncated %d bytes)\n", Integer.valueOf(a2.length() - i2)).getBytes("UTF-8"));
            }
        } catch (Throwable th2) {
            th = th2;
        }
        a(outputStream);
        return i2;
    }

    private static long a(StatFs statFs, String str, String str2) {
        try {
            Method declaredMethod = StatFs.class.getDeclaredMethod(str, null);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(statFs, null);
            if (invoke != null && (invoke instanceof Long)) {
                return ((Long) invoke).longValue();
            }
        } catch (Throwable unused) {
        }
        try {
            Method declaredMethod2 = StatFs.class.getDeclaredMethod(str2, null);
            declaredMethod2.setAccessible(true);
            Object invoke2 = declaredMethod2.invoke(statFs, null);
            if (invoke2 == null || !(invoke2 instanceof Integer)) {
                return 0L;
            }
            return ((Integer) invoke2).intValue();
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return 0L;
        }
    }

    private static BufferedReader a(InputStreamReader inputStreamReader) {
        BufferedReader bufferedReader = null;
        int i2 = 8192;
        while (bufferedReader == null && i2 > 0) {
            try {
                bufferedReader = new BufferedReader(inputStreamReader, i2);
            } catch (Throwable unused) {
                i2 /= 2;
                if (i2 < 512) {
                    break;
                }
            }
        }
        return bufferedReader;
    }

    public static String a(int i2) {
        try {
            String a2 = com.uc.crashsdk.a.g.a(new File(String.format(Locale.US, "/proc/%d/cmdline", Integer.valueOf(i2))), 128, false);
            return com.uc.crashsdk.a.g.b(a2) ? l(a2) : "unknown";
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return "unknown";
        }
    }

    private static String a(File file) {
        String str;
        try {
            str = file.getCanonicalPath();
        } catch (Throwable unused) {
            str = null;
        }
        return com.uc.crashsdk.a.g.a(str) ? file.getPath() : str;
    }

    public static String a(String str) {
        int lastIndexOf;
        int indexOf;
        int i2;
        int indexOf2;
        File file;
        byte[] e;
        byte[] bArr;
        if (g.y() && (lastIndexOf = str.lastIndexOf(47)) > 0 && (indexOf = str.indexOf(95, lastIndexOf)) > lastIndexOf && (indexOf2 = str.indexOf(95, (i2 = indexOf + 1))) > indexOf) {
            String d2 = com.uc.crashsdk.a.g.d("CrashSDK" + str.substring(lastIndexOf + 1, indexOf) + str.substring(i2, indexOf2));
            if (d2 != null && (e = com.uc.crashsdk.a.g.e((file = new File(str)))) != null && e.length > 0) {
                try {
                    bArr = com.uc.crashsdk.a.c.b(e, d2.substring(0, 16).getBytes());
                } catch (Throwable th) {
                    com.uc.crashsdk.a.g.a(th);
                    bArr = null;
                }
                if (bArr != null) {
                    String concat = str.concat(".ec");
                    File file2 = new File(concat.concat(".tmp"));
                    if (com.uc.crashsdk.a.g.a(file2, bArr)) {
                        if (file2.renameTo(new File(concat))) {
                            file.delete();
                            return concat;
                        }
                        file2.delete();
                        return str;
                    }
                }
            }
        }
        return str;
    }

    public static String a(String str, String str2) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(new String[]{"ps", "-ef"}).getInputStream()));
            boolean b2 = com.uc.crashsdk.a.g.b(str);
            boolean b3 = com.uc.crashsdk.a.g.b(str2);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return byteArrayOutputStream.toString("UTF-8");
                }
                if (b2) {
                    if (readLine.contains(str)) {
                        byteArrayOutputStream.write(readLine.getBytes("UTF-8"));
                        byteArrayOutputStream.write(UMCustomLogInfoBuilder.LINE_SEP.getBytes("UTF-8"));
                    }
                }
                if (b3) {
                    if (readLine.contains(str2)) {
                        byteArrayOutputStream.write(readLine.getBytes("UTF-8"));
                        byteArrayOutputStream.write(UMCustomLogInfoBuilder.LINE_SEP.getBytes("UTF-8"));
                    }
                }
                if (readLine.indexOf(47) < 0 && readLine.indexOf(46) > 0) {
                    byteArrayOutputStream.write(readLine.getBytes("UTF-8"));
                    byteArrayOutputStream.write(UMCustomLogInfoBuilder.LINE_SEP.getBytes("UTF-8"));
                }
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return "exception exists.";
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(44:1|2|3|4|(2:320|321)|6|(2:8|9)(1:319)|(52:10|11|12|13|(1:15)|17|(2:304|305)|19|20|22|23|25|26|(4:28|29|30|31)(1:297)|32|(1:36)|40|41|42|43|44|45|46|48|49|(2:276|277)|51|52|53|(2:54|55)|57|58|59|60|61|62|63|(4:65|66|67|68)|72|73|74|75|76|77|78|80|81|(1:83)(2:251|(1:253))|84|85|86|87)|(4:89|90|91|92)(3:201|202|(41:209|210|211|212|213|214|215|(41:217|218|219|220|221|222|223|224|225|95|96|97|98|99|(1:101)(6:164|(1:166)|167|(1:169)|170|(3:172|(1:174)(1:176)|175))|102|103|104|105|106|(4:108|109|110|111)|115|116|117|118|119|120|(4:122|123|124|125)|129|130|131|(1:133)|134|135|136|(1:138)|139|140|(1:142)(1:147)|143|144)|94|95|96|97|98|99|(0)(0)|102|103|104|105|106|(0)|115|116|117|118|119|120|(0)|129|130|131|(0)|134|135|136|(0)|139|140|(0)(0)|143|144))|93|94|95|96|97|98|99|(0)(0)|102|103|104|105|106|(0)|115|116|117|118|119|120|(0)|129|130|131|(0)|134|135|136|(0)|139|140|(0)(0)|143|144|(2:(0)|(1:154))) */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x04aa, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x04b4, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x046b, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x046c, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0443, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x0444, code lost:
    
        a(r0, r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x043a, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x043b, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x0417, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x0418, code lost:
    
        a(r0, r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x0376, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x0377, code lost:
    
        a(r0, r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x035b, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x035c, code lost:
    
        a(r0, r13);
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0363 A[Catch: all -> 0x0376, TRY_ENTER, TRY_LEAVE, TryCatch #13 {all -> 0x0376, blocks: (B:101:0x0363, B:164:0x037f, B:167:0x03a1, B:169:0x03af, B:170:0x03b4, B:172:0x03cc, B:175:0x03ed), top: B:99:0x0361, outer: #20 }] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x041f A[Catch: all -> 0x037c, TRY_LEAVE, TryCatch #20 {all -> 0x037c, blocks: (B:95:0x034e, B:98:0x035f, B:102:0x0407, B:106:0x041b, B:108:0x041f, B:111:0x0433, B:114:0x0430, B:120:0x0447, B:122:0x044b, B:125:0x045f, B:128:0x045c, B:129:0x0461, B:153:0x046c, B:157:0x0444, B:160:0x043b, B:163:0x0418, B:178:0x0377, B:181:0x035c, B:233:0x034b, B:131:0x0467, B:110:0x0421, B:101:0x0363, B:164:0x037f, B:167:0x03a1, B:169:0x03af, B:170:0x03b4, B:172:0x03cc, B:175:0x03ed, B:116:0x0435, B:119:0x043f, B:105:0x0413, B:124:0x044d, B:97:0x0351), top: B:232:0x034b, inners: #8, #9, #13, #16, #28, #38, #42, #43 }] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x044b A[Catch: all -> 0x037c, TRY_LEAVE, TryCatch #20 {all -> 0x037c, blocks: (B:95:0x034e, B:98:0x035f, B:102:0x0407, B:106:0x041b, B:108:0x041f, B:111:0x0433, B:114:0x0430, B:120:0x0447, B:122:0x044b, B:125:0x045f, B:128:0x045c, B:129:0x0461, B:153:0x046c, B:157:0x0444, B:160:0x043b, B:163:0x0418, B:178:0x0377, B:181:0x035c, B:233:0x034b, B:131:0x0467, B:110:0x0421, B:101:0x0363, B:164:0x037f, B:167:0x03a1, B:169:0x03af, B:170:0x03b4, B:172:0x03cc, B:175:0x03ed, B:116:0x0435, B:119:0x043f, B:105:0x0413, B:124:0x044d, B:97:0x0351), top: B:232:0x034b, inners: #8, #9, #13, #16, #28, #38, #42, #43 }] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0471  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x049a  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x04a1 A[Catch: all -> 0x04aa, TryCatch #7 {all -> 0x04aa, blocks: (B:140:0x049d, B:142:0x04a1, B:143:0x04ae), top: B:139:0x049d }] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x04ac  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x037f A[Catch: all -> 0x0376, TRY_ENTER, TryCatch #13 {all -> 0x0376, blocks: (B:101:0x0363, B:164:0x037f, B:167:0x03a1, B:169:0x03af, B:170:0x03b4, B:172:0x03cc, B:175:0x03ed), top: B:99:0x0361, outer: #20 }] */
    /* JADX WARN: Removed duplicated region for block: B:188:0x048f  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0248 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0200 A[Catch: all -> 0x01fe, TryCatch #23 {all -> 0x01fe, blocks: (B:81:0x01e8, B:83:0x01ec, B:251:0x0200, B:253:0x0206), top: B:80:0x01e8, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:276:0x013f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01b1 A[Catch: all -> 0x0061, TRY_LEAVE, TryCatch #0 {all -> 0x0061, blocks: (B:17:0x004f, B:303:0x00a5, B:291:0x0119, B:288:0x0127, B:44:0x012a, B:283:0x013a, B:272:0x017e, B:270:0x019a, B:59:0x019d, B:63:0x01ac, B:65:0x01b1, B:68:0x01c5, B:71:0x01c2, B:264:0x01cc, B:74:0x01cf, B:258:0x01e5, B:84:0x0215, B:87:0x0226, B:89:0x022a, B:92:0x023e, B:200:0x023b, B:250:0x0223, B:256:0x0212, B:261:0x01d7, B:267:0x01a9, B:275:0x0159, B:280:0x0144, B:285:0x0132, B:39:0x010c, B:308:0x005d, B:312:0x004c, B:86:0x0218, B:78:0x01da, B:20:0x0067, B:43:0x011c, B:62:0x01a4, B:46:0x012d, B:49:0x0135, B:91:0x022c, B:55:0x015c, B:81:0x01e8, B:83:0x01ec, B:251:0x0200, B:253:0x0206, B:67:0x01b3, B:277:0x013f, B:73:0x01c7, B:13:0x0041, B:15:0x0045, B:76:0x01d2, B:53:0x0149, B:41:0x010f, B:58:0x0181, B:305:0x0058), top: B:12:0x0041, inners: #1, #2, #3, #5, #6, #10, #15, #17, #22, #23, #26, #29, #33, #34, #37, #39, #40, #41, #44 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01ec A[Catch: all -> 0x01fe, TryCatch #23 {all -> 0x01fe, blocks: (B:81:0x01e8, B:83:0x01ec, B:251:0x0200, B:253:0x0206), top: B:80:0x01e8, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x022a A[Catch: all -> 0x0061, TRY_LEAVE, TryCatch #0 {all -> 0x0061, blocks: (B:17:0x004f, B:303:0x00a5, B:291:0x0119, B:288:0x0127, B:44:0x012a, B:283:0x013a, B:272:0x017e, B:270:0x019a, B:59:0x019d, B:63:0x01ac, B:65:0x01b1, B:68:0x01c5, B:71:0x01c2, B:264:0x01cc, B:74:0x01cf, B:258:0x01e5, B:84:0x0215, B:87:0x0226, B:89:0x022a, B:92:0x023e, B:200:0x023b, B:250:0x0223, B:256:0x0212, B:261:0x01d7, B:267:0x01a9, B:275:0x0159, B:280:0x0144, B:285:0x0132, B:39:0x010c, B:308:0x005d, B:312:0x004c, B:86:0x0218, B:78:0x01da, B:20:0x0067, B:43:0x011c, B:62:0x01a4, B:46:0x012d, B:49:0x0135, B:91:0x022c, B:55:0x015c, B:81:0x01e8, B:83:0x01ec, B:251:0x0200, B:253:0x0206, B:67:0x01b3, B:277:0x013f, B:73:0x01c7, B:13:0x0041, B:15:0x0045, B:76:0x01d2, B:53:0x0149, B:41:0x010f, B:58:0x0181, B:305:0x0058), top: B:12:0x0041, inners: #1, #2, #3, #5, #6, #10, #15, #17, #22, #23, #26, #29, #33, #34, #37, #39, #40, #41, #44 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String a(java.lang.Throwable r30, java.lang.String r31, long r32, boolean r34) {
        /*
            Method dump skipped, instructions count: 1223
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.a(java.lang.Throwable, java.lang.String, long, boolean):java.lang.String");
    }

    private static String a(Date date) {
        return String.format(Locale.US, "%d%02d%02d%02d%02d%02d", Integer.valueOf(date.getYear() + 1900), Integer.valueOf(date.getMonth() + 1), Integer.valueOf(date.getDate()), Integer.valueOf(date.getHours()), Integer.valueOf(date.getMinutes()), Integer.valueOf(date.getSeconds()));
    }

    public static StringBuilder a(StackTraceElement[] stackTraceElementArr, String str) {
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        if (stackTraceElementArr != null && stackTraceElementArr.length > 0) {
            boolean z2 = str == null;
            int i3 = 0;
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                i3++;
                sb.append("  at ");
                sb.append(stackTraceElement.toString());
                sb.append(UMCustomLogInfoBuilder.LINE_SEP);
                if (!z2 && stackTraceElement.getMethodName().contains(str)) {
                    sb.delete(0, sb.length());
                    i3 = 0;
                    z2 = true;
                }
            }
            i2 = i3;
        }
        if (i2 == 0) {
            sb.append("  (no java stack)\n");
        }
        return sb;
    }

    public static void a(int i2, Object[] objArr) {
        int i3;
        switch (i2) {
            case com.umeng.ccg.c.y /* 401 */:
                JNIBridge.nativeCmd(10, com.uc.crashsdk.b.I() == 5 ? 1L : 0L, null, null);
                com.uc.crashsdk.a.c = true;
                com.uc.crashsdk.a.a(false);
                L = true;
                Z();
                y();
                return;
            case com.umeng.ccg.c.z /* 402 */:
                Object obj = Y;
                synchronized (obj) {
                    try {
                        if (X == null) {
                            return;
                        }
                        W = true;
                        if (com.uc.crashsdk.b.q()) {
                            return;
                        }
                        if (!com.uc.crashsdk.a.d.e()) {
                            com.uc.crashsdk.a.a.c("DEBUG", com.uc.crashsdk.a.d.b());
                            return;
                        }
                        if (!d(LogType.UNEXP_TYPE)) {
                            com.uc.crashsdk.a.a.d("DEBUG", "unexp sample miss");
                            return;
                        }
                        int nativeGenerateUnexpLog = JNIBridge.nativeGenerateUnexpLog(g.p(), g.q());
                        if (nativeGenerateUnexpLog != 0) {
                            f.a(11);
                            if ((nativeGenerateUnexpLog & 4352) != 0) {
                                Z = 105;
                                i3 = 30;
                            } else if ((nativeGenerateUnexpLog & LogType.UNEXP_EXIT) != 0) {
                                Z = 104;
                                i3 = 31;
                            } else if ((nativeGenerateUnexpLog & LogType.UNEXP_RESTART) != 0) {
                                Z = 106;
                                i3 = 32;
                            } else {
                                if ((nativeGenerateUnexpLog & LogType.UNEXP_ANR) != 0) {
                                    Z = 103;
                                    f.a(10);
                                } else if ((nativeGenerateUnexpLog & LogType.UNEXP_LOW_MEMORY) != 0) {
                                    Z = 107;
                                    f.a(29);
                                } else {
                                    Z = 102;
                                }
                                a(true);
                            }
                            f.a(i3);
                            a(true);
                        }
                        synchronized (obj) {
                            X = null;
                        }
                        return;
                    } finally {
                    }
                }
            case 403:
                ab();
                return;
            case 404:
            default:
                if (a) {
                    return;
                }
                jr4.a();
                return;
            case 405:
                L = false;
                StringBuilder Y2 = Y();
                String g2 = com.uc.crashsdk.b.g();
                if (Y2 != null) {
                    com.uc.crashsdk.a.g.a(new File(g2), Y2.toString());
                    return;
                }
                return;
            case 406:
                if (a || objArr != null) {
                    a((String) objArr[0], ((Boolean) objArr[1]).booleanValue(), ((Boolean) objArr[2]).booleanValue());
                    return;
                } else {
                    jr4.a();
                    return;
                }
            case 407:
                try {
                    com.uc.crashsdk.a.d();
                    return;
                } catch (Throwable th) {
                    com.uc.crashsdk.a.g.a(th);
                    return;
                }
            case 408:
                synchronized (ab) {
                    try {
                        if (!ac && g.R() && com.uc.crashsdk.b.z()) {
                            com.uc.crashsdk.b.s();
                            h.f();
                            f.c();
                            if (com.uc.crashsdk.b.F()) {
                                C();
                            }
                            if (g.R()) {
                                a(Calendar.getInstance());
                            }
                            ac = true;
                        }
                    } finally {
                    }
                }
                return;
            case 409:
                d(false);
                return;
            case 410:
                a(false, true);
                return;
            case 411:
                if (com.uc.crashsdk.b.d) {
                    JNIBridge.set(28, d("jni"));
                    JNIBridge.set(29, d("anr"));
                    return;
                }
                return;
            case 412:
                if (!R && com.uc.crashsdk.b.B() && g.N()) {
                    b(com.uc.crashsdk.a.g.a());
                    return;
                }
                if (R) {
                    if (com.uc.crashsdk.b.B() && g.N()) {
                        return;
                    }
                    try {
                        com.uc.crashsdk.a.g.a().unregisterReceiver(Q);
                        R = false;
                        return;
                    } catch (Throwable th2) {
                        com.uc.crashsdk.a.g.a(th2);
                        return;
                    }
                }
                return;
            case 413:
                JNIBridge.cmd(8);
                return;
            case 414:
                try {
                    if (d(com.uc.crashsdk.a.g.a())) {
                        return;
                    }
                    int i4 = N + 1;
                    N = i4;
                    if (i4 < 10) {
                        X();
                        return;
                    } else {
                        if (com.uc.crashsdk.b.d) {
                            JNIBridge.set(130, "(get failed)");
                            return;
                        }
                        return;
                    }
                } catch (Throwable th3) {
                    com.uc.crashsdk.a.g.a(th3);
                    return;
                }
            case 415:
                if (!a && objArr == null) {
                    jr4.a();
                    return;
                }
                long longValue = ((Long) objArr[0]).longValue();
                Calendar calendar = Calendar.getInstance();
                if (calendar.getTimeInMillis() >= longValue) {
                    h.g();
                    f.a(100);
                    d(true);
                    f.a(true);
                    h.b();
                } else {
                    h.h();
                    h.i();
                    h.c();
                }
                a(calendar);
                break;
            case 416:
                break;
        }
        W();
    }

    public static void a(Context context) {
        try {
            if (V()) {
                context.registerReceiver(new c((byte) 0), new IntentFilter("android.intent.action.ANR"), null, com.uc.crashsdk.a.f.a(3));
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    private static void a(a aVar) {
        try {
            aVar.a(String.format(Locale.US, "log end: %s\n", n()));
        } catch (Throwable th) {
            a(th, aVar);
        }
    }

    private static void a(a aVar, String str, long j2) {
        String nativeDumpThreads;
        if (com.uc.crashsdk.b.d) {
            try {
                aVar.flush();
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
            nativeDumpThreads = JNIBridge.nativeDumpThreads(str, j2);
            if (ag || nativeDumpThreads == null || nativeDumpThreads.length() >= 512 || !nativeDumpThreads.startsWith("/") || nativeDumpThreads.indexOf(10) >= 0) {
                r2 = nativeDumpThreads;
            } else {
                r2 = nativeDumpThreads;
                nativeDumpThreads = new File(nativeDumpThreads).exists() ? null : "Can not found ".concat(nativeDumpThreads);
            }
        } else {
            nativeDumpThreads = "Native not initialized, skip dump!";
        }
        if (nativeDumpThreads != null) {
            try {
                aVar.write(nativeDumpThreads.getBytes("UTF-8"));
                aVar.write(UMCustomLogInfoBuilder.LINE_SEP.getBytes("UTF-8"));
            } catch (Throwable th2) {
                com.uc.crashsdk.a.g.a(th2);
            }
            a((OutputStream) aVar);
        } else if (r2 != null && !ag) {
            b(aVar, r2, LogType.ANR);
            File file = new File(r2);
            if (file.exists()) {
                file.delete();
            }
        }
        try {
            aVar.flush();
        } catch (Throwable th3) {
            com.uc.crashsdk.a.g.a(th3);
        }
    }

    private static void a(OutputStream outputStream) {
        try {
            outputStream.write("--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---\n".getBytes("UTF-8"));
        } catch (Throwable th) {
            a(th, outputStream);
        }
    }

    public static void a(OutputStream outputStream, String str, String str2) {
        h = false;
        try {
            outputStream.write(String.format(Locale.US, "$^%s`%s^$", str, str2).getBytes("UTF-8"));
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        h = true;
    }

    public static void a(OutputStream outputStream, String str, String str2, int i2, boolean z2, boolean z3) {
        h = false;
        try {
            outputStream.write(String.format(Locale.US, "$^%s`%s`%d`%d,%d^$", str, str2, Integer.valueOf(i2), Integer.valueOf(z2 ? 1 : 0), Integer.valueOf(z3 ? 1 : 0)).getBytes("UTF-8"));
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        h = true;
        a(outputStream);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(17:35|(5:37|(3:197|42|(3:44|45|26))|41|42|(0))(1:198)|46|47|48|(2:50|(17:52|53|54|55|56|57|58|(1:60)(1:181)|61|62|(6:64|(1:66)(1:179)|67|68|(1:70)(1:178)|71)(1:180)|72|(1:74)(1:(1:177))|(1:76)(2:77|(9:82|(1:84)(1:171)|85|(2:87|(5:89|90|91|(2:93|94)(2:95|(2:97|98)(2:99|(2:101|102)(9:103|(2:105|(6:107|(1:155)(1:111)|112|(5:114|(1:116)|117|(1:119)(1:151)|120)(2:152|(1:154))|121|(2:125|126)(2:123|124)))|156|(1:109)|155|112|(0)(0)|121|(0)(0))))|26))(1:170)|157|(2:159|(1:(3:164|165|90))(1:(3:169|165|90)))|91|(0)(0)|26)(1:81))|24|25|26))|188|(0)(0)|61|62|(0)(0)|72|(0)(0)|(0)(0)|24|25|26) */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x01b0, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x01b1, code lost:
    
        r25 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:209:0x0447, code lost:
    
        if (r31 == false) goto L195;
     */
    /* JADX WARN: Removed duplicated region for block: B:114:0x035a A[Catch: all -> 0x0034, TryCatch #2 {all -> 0x0034, blocks: (B:4:0x000a, B:6:0x0010, B:8:0x001f, B:14:0x0037, B:16:0x003d, B:17:0x0050, B:19:0x0060, B:21:0x006a, B:26:0x03d2, B:27:0x0072, B:29:0x0082, B:31:0x0094, B:32:0x00b2, B:34:0x00c0, B:37:0x00ca, B:42:0x00f7, B:62:0x01c7, B:64:0x01db, B:66:0x01df, B:68:0x01e7, B:70:0x01eb, B:71:0x01f0, B:72:0x01fa, B:76:0x021d, B:77:0x0234, B:79:0x023a, B:81:0x0243, B:82:0x024a, B:84:0x026a, B:85:0x027d, B:87:0x028f, B:89:0x029f, B:90:0x02b0, B:91:0x02f0, B:95:0x02ff, B:99:0x030e, B:103:0x031e, B:105:0x032c, B:107:0x0339, B:109:0x0341, B:112:0x034e, B:114:0x035a, B:116:0x0374, B:117:0x0379, B:119:0x0388, B:120:0x0399, B:126:0x03bd, B:128:0x03e3, B:130:0x03ea, B:132:0x03f1, B:134:0x03f8, B:136:0x03ff, B:138:0x0406, B:143:0x0418, B:145:0x041f, B:147:0x0426, B:149:0x042d, B:150:0x0411, B:151:0x0391, B:152:0x03b1, B:154:0x03b5, B:157:0x02b8, B:159:0x02be, B:162:0x02c6, B:164:0x02ca, B:165:0x02d7, B:167:0x02de, B:169:0x02e2, B:173:0x0204, B:175:0x0212, B:177:0x0218, B:184:0x01c2, B:194:0x00e9, B:201:0x0433), top: B:3:0x000a, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x03cc  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x03bd A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x03b1 A[Catch: all -> 0x0034, TryCatch #2 {all -> 0x0034, blocks: (B:4:0x000a, B:6:0x0010, B:8:0x001f, B:14:0x0037, B:16:0x003d, B:17:0x0050, B:19:0x0060, B:21:0x006a, B:26:0x03d2, B:27:0x0072, B:29:0x0082, B:31:0x0094, B:32:0x00b2, B:34:0x00c0, B:37:0x00ca, B:42:0x00f7, B:62:0x01c7, B:64:0x01db, B:66:0x01df, B:68:0x01e7, B:70:0x01eb, B:71:0x01f0, B:72:0x01fa, B:76:0x021d, B:77:0x0234, B:79:0x023a, B:81:0x0243, B:82:0x024a, B:84:0x026a, B:85:0x027d, B:87:0x028f, B:89:0x029f, B:90:0x02b0, B:91:0x02f0, B:95:0x02ff, B:99:0x030e, B:103:0x031e, B:105:0x032c, B:107:0x0339, B:109:0x0341, B:112:0x034e, B:114:0x035a, B:116:0x0374, B:117:0x0379, B:119:0x0388, B:120:0x0399, B:126:0x03bd, B:128:0x03e3, B:130:0x03ea, B:132:0x03f1, B:134:0x03f8, B:136:0x03ff, B:138:0x0406, B:143:0x0418, B:145:0x041f, B:147:0x0426, B:149:0x042d, B:150:0x0411, B:151:0x0391, B:152:0x03b1, B:154:0x03b5, B:157:0x02b8, B:159:0x02be, B:162:0x02c6, B:164:0x02ca, B:165:0x02d7, B:167:0x02de, B:169:0x02e2, B:173:0x0204, B:175:0x0212, B:177:0x0218, B:184:0x01c2, B:194:0x00e9, B:201:0x0433), top: B:3:0x000a, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01db A[Catch: all -> 0x0034, TryCatch #2 {all -> 0x0034, blocks: (B:4:0x000a, B:6:0x0010, B:8:0x001f, B:14:0x0037, B:16:0x003d, B:17:0x0050, B:19:0x0060, B:21:0x006a, B:26:0x03d2, B:27:0x0072, B:29:0x0082, B:31:0x0094, B:32:0x00b2, B:34:0x00c0, B:37:0x00ca, B:42:0x00f7, B:62:0x01c7, B:64:0x01db, B:66:0x01df, B:68:0x01e7, B:70:0x01eb, B:71:0x01f0, B:72:0x01fa, B:76:0x021d, B:77:0x0234, B:79:0x023a, B:81:0x0243, B:82:0x024a, B:84:0x026a, B:85:0x027d, B:87:0x028f, B:89:0x029f, B:90:0x02b0, B:91:0x02f0, B:95:0x02ff, B:99:0x030e, B:103:0x031e, B:105:0x032c, B:107:0x0339, B:109:0x0341, B:112:0x034e, B:114:0x035a, B:116:0x0374, B:117:0x0379, B:119:0x0388, B:120:0x0399, B:126:0x03bd, B:128:0x03e3, B:130:0x03ea, B:132:0x03f1, B:134:0x03f8, B:136:0x03ff, B:138:0x0406, B:143:0x0418, B:145:0x041f, B:147:0x0426, B:149:0x042d, B:150:0x0411, B:151:0x0391, B:152:0x03b1, B:154:0x03b5, B:157:0x02b8, B:159:0x02be, B:162:0x02c6, B:164:0x02ca, B:165:0x02d7, B:167:0x02de, B:169:0x02e2, B:173:0x0204, B:175:0x0212, B:177:0x0218, B:184:0x01c2, B:194:0x00e9, B:201:0x0433), top: B:3:0x000a, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x021d A[Catch: all -> 0x0034, TryCatch #2 {all -> 0x0034, blocks: (B:4:0x000a, B:6:0x0010, B:8:0x001f, B:14:0x0037, B:16:0x003d, B:17:0x0050, B:19:0x0060, B:21:0x006a, B:26:0x03d2, B:27:0x0072, B:29:0x0082, B:31:0x0094, B:32:0x00b2, B:34:0x00c0, B:37:0x00ca, B:42:0x00f7, B:62:0x01c7, B:64:0x01db, B:66:0x01df, B:68:0x01e7, B:70:0x01eb, B:71:0x01f0, B:72:0x01fa, B:76:0x021d, B:77:0x0234, B:79:0x023a, B:81:0x0243, B:82:0x024a, B:84:0x026a, B:85:0x027d, B:87:0x028f, B:89:0x029f, B:90:0x02b0, B:91:0x02f0, B:95:0x02ff, B:99:0x030e, B:103:0x031e, B:105:0x032c, B:107:0x0339, B:109:0x0341, B:112:0x034e, B:114:0x035a, B:116:0x0374, B:117:0x0379, B:119:0x0388, B:120:0x0399, B:126:0x03bd, B:128:0x03e3, B:130:0x03ea, B:132:0x03f1, B:134:0x03f8, B:136:0x03ff, B:138:0x0406, B:143:0x0418, B:145:0x041f, B:147:0x0426, B:149:0x042d, B:150:0x0411, B:151:0x0391, B:152:0x03b1, B:154:0x03b5, B:157:0x02b8, B:159:0x02be, B:162:0x02c6, B:164:0x02ca, B:165:0x02d7, B:167:0x02de, B:169:0x02e2, B:173:0x0204, B:175:0x0212, B:177:0x0218, B:184:0x01c2, B:194:0x00e9, B:201:0x0433), top: B:3:0x000a, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0234 A[Catch: all -> 0x0034, TryCatch #2 {all -> 0x0034, blocks: (B:4:0x000a, B:6:0x0010, B:8:0x001f, B:14:0x0037, B:16:0x003d, B:17:0x0050, B:19:0x0060, B:21:0x006a, B:26:0x03d2, B:27:0x0072, B:29:0x0082, B:31:0x0094, B:32:0x00b2, B:34:0x00c0, B:37:0x00ca, B:42:0x00f7, B:62:0x01c7, B:64:0x01db, B:66:0x01df, B:68:0x01e7, B:70:0x01eb, B:71:0x01f0, B:72:0x01fa, B:76:0x021d, B:77:0x0234, B:79:0x023a, B:81:0x0243, B:82:0x024a, B:84:0x026a, B:85:0x027d, B:87:0x028f, B:89:0x029f, B:90:0x02b0, B:91:0x02f0, B:95:0x02ff, B:99:0x030e, B:103:0x031e, B:105:0x032c, B:107:0x0339, B:109:0x0341, B:112:0x034e, B:114:0x035a, B:116:0x0374, B:117:0x0379, B:119:0x0388, B:120:0x0399, B:126:0x03bd, B:128:0x03e3, B:130:0x03ea, B:132:0x03f1, B:134:0x03f8, B:136:0x03ff, B:138:0x0406, B:143:0x0418, B:145:0x041f, B:147:0x0426, B:149:0x042d, B:150:0x0411, B:151:0x0391, B:152:0x03b1, B:154:0x03b5, B:157:0x02b8, B:159:0x02be, B:162:0x02c6, B:164:0x02ca, B:165:0x02d7, B:167:0x02de, B:169:0x02e2, B:173:0x0204, B:175:0x0212, B:177:0x0218, B:184:0x01c2, B:194:0x00e9, B:201:0x0433), top: B:3:0x000a, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02ff A[Catch: all -> 0x0034, TryCatch #2 {all -> 0x0034, blocks: (B:4:0x000a, B:6:0x0010, B:8:0x001f, B:14:0x0037, B:16:0x003d, B:17:0x0050, B:19:0x0060, B:21:0x006a, B:26:0x03d2, B:27:0x0072, B:29:0x0082, B:31:0x0094, B:32:0x00b2, B:34:0x00c0, B:37:0x00ca, B:42:0x00f7, B:62:0x01c7, B:64:0x01db, B:66:0x01df, B:68:0x01e7, B:70:0x01eb, B:71:0x01f0, B:72:0x01fa, B:76:0x021d, B:77:0x0234, B:79:0x023a, B:81:0x0243, B:82:0x024a, B:84:0x026a, B:85:0x027d, B:87:0x028f, B:89:0x029f, B:90:0x02b0, B:91:0x02f0, B:95:0x02ff, B:99:0x030e, B:103:0x031e, B:105:0x032c, B:107:0x0339, B:109:0x0341, B:112:0x034e, B:114:0x035a, B:116:0x0374, B:117:0x0379, B:119:0x0388, B:120:0x0399, B:126:0x03bd, B:128:0x03e3, B:130:0x03ea, B:132:0x03f1, B:134:0x03f8, B:136:0x03ff, B:138:0x0406, B:143:0x0418, B:145:0x041f, B:147:0x0426, B:149:0x042d, B:150:0x0411, B:151:0x0391, B:152:0x03b1, B:154:0x03b5, B:157:0x02b8, B:159:0x02be, B:162:0x02c6, B:164:0x02ca, B:165:0x02d7, B:167:0x02de, B:169:0x02e2, B:173:0x0204, B:175:0x0212, B:177:0x0218, B:184:0x01c2, B:194:0x00e9, B:201:0x0433), top: B:3:0x000a, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void a(java.lang.String r29, boolean r30, boolean r31) {
        /*
            Method dump skipped, instructions count: 1111
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.a(java.lang.String, boolean, boolean):void");
    }

    private static void a(Throwable th) {
        try {
            com.uc.crashsdk.a.a.d("DEBUG", a(th.getStackTrace(), (String) null).toString());
        } catch (Throwable unused) {
        }
    }

    public static void a(Throwable th, OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.write("[DEBUG] CrashHandler occurred new exception:\n".getBytes("UTF-8"));
                th.printStackTrace(new PrintStream(outputStream));
                outputStream.write("\n\n".getBytes("UTF-8"));
            } catch (Throwable th2) {
                com.uc.crashsdk.a.g.a(th2);
            }
        }
        com.uc.crashsdk.a.g.a(th);
    }

    private static void a(Calendar calendar) {
        if (g.T()) {
            long timeInMillis = calendar.getTimeInMillis();
            calendar.add(5, 1);
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            long timeInMillis2 = calendar.getTimeInMillis();
            long j2 = timeInMillis2 - timeInMillis;
            com.uc.crashsdk.a.f.a(0, new com.uc.crashsdk.a.e(415, new Object[]{Long.valueOf(timeInMillis2)}), j2 <= 3600000 ? 1000 + j2 : 3600000L);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(boolean z2) {
        File[] listFiles;
        try {
            if (com.uc.crashsdk.b.y() && (listFiles = new File(g.Y()).listFiles()) != null) {
                int m2 = g.m();
                int n2 = g.n();
                if (listFiles.length < Math.min(m2, n2)) {
                    return;
                }
                Object[] objArr = 0;
                int i2 = 0;
                int i3 = 0;
                for (File file : listFiles) {
                    if (b(file)) {
                        i2++;
                    } else {
                        i3++;
                    }
                }
                int i4 = (!z2 || i2 < m2) ? 0 : (i2 - m2) + 1;
                int i5 = (z2 || i3 < n2) ? 0 : (i3 - n2) + 1;
                if (i4 == 0 && i5 == 0) {
                    return;
                }
                Arrays.sort(listFiles, new b(objArr == true ? 1 : 0));
                int i6 = i4;
                int i7 = i5;
                for (File file2 : listFiles) {
                    boolean b2 = b(file2);
                    if (b2 && i6 > 0) {
                        com.uc.crashsdk.a.a.a("crashsdk", "Delete oldest crash log: " + file2.getPath());
                        file2.delete();
                        i6 += -1;
                    } else if (!b2 && i7 > 0) {
                        com.uc.crashsdk.a.a.a("crashsdk", "Delete oldest custom log: " + file2.getPath());
                        file2.delete();
                        i7 += -1;
                    }
                    if (i6 == 0 && i7 == 0) {
                        break;
                    }
                }
                f.a(16, i4 + i5);
                if (i4 > 0) {
                    f.a(22, i4);
                }
                if (i5 > 0) {
                    f.a(23, i5);
                }
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    public static boolean a() {
        if (f == 0) {
            f = 2L;
            if (h(com.uc.crashsdk.b.b("logs")) == 1) {
                f = 1L;
            }
        }
        return f == 1;
    }

    public static boolean a(ParcelFileDescriptor parcelFileDescriptor) {
        if (af) {
            com.uc.crashsdk.a.a.d("crashsdk", "Can not call setHostFd and getHostFd in the same process!");
            return false;
        }
        if (!com.uc.crashsdk.b.d) {
            com.uc.crashsdk.a.a.d("crashsdk", "Crash so is not loaded!");
            return false;
        }
        if (ae != null) {
            com.uc.crashsdk.a.a.c("crashsdk", "Has already set host fd!");
        }
        ae = parcelFileDescriptor;
        int fd = parcelFileDescriptor.getFd();
        int nativeCmd = (int) JNIBridge.nativeCmd(13, fd, null, null);
        ag = nativeCmd != -1;
        return fd == -1 || nativeCmd != -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0044 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean a(java.lang.String r17, long r18, java.lang.StringBuffer r20, java.lang.String r21, long r22, java.util.ArrayList<java.lang.String> r24, java.util.ArrayList<java.lang.String> r25, java.util.ArrayList<java.lang.String> r26, java.lang.String r27) {
        /*
            Method dump skipped, instructions count: 393
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.a(java.lang.String, long, java.lang.StringBuffer, java.lang.String, long, java.util.ArrayList, java.util.ArrayList, java.util.ArrayList, java.lang.String):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r5v7 */
    private static boolean a(String str, com.uc.crashsdk.a.e eVar) {
        boolean z2;
        FileChannel fileChannel;
        Exception e;
        synchronized (p) {
            File file = new File(str);
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (Exception e2) {
                    com.uc.crashsdk.a.g.a(e2);
                }
            }
            ?? r5 = 0;
            r5 = null;
            FileLock lock = null;
            z2 = false;
            try {
                try {
                    try {
                        fileChannel = new RandomAccessFile(file, "rw").getChannel();
                    } catch (Throwable th) {
                        th = th;
                        r5 = file;
                        com.uc.crashsdk.a.g.a((Closeable) r5);
                        throw th;
                    }
                } catch (Exception e3) {
                    try {
                        com.uc.crashsdk.a.g.a(e3);
                        fileChannel = null;
                    } catch (Exception e4) {
                        fileChannel = null;
                        e = e4;
                        com.uc.crashsdk.a.g.a(e);
                        com.uc.crashsdk.a.g.a(fileChannel);
                        return z2;
                    }
                }
                if (fileChannel != null) {
                    try {
                        lock = fileChannel.lock();
                    } catch (Exception e5) {
                        try {
                            com.uc.crashsdk.a.g.a(e5);
                        } catch (Exception e6) {
                            e = e6;
                            com.uc.crashsdk.a.g.a(e);
                            com.uc.crashsdk.a.g.a(fileChannel);
                            return z2;
                        }
                    }
                }
                try {
                    z2 = eVar.a();
                    com.uc.crashsdk.a.g.a(fileChannel);
                } finally {
                    if (lock != null) {
                        try {
                            lock.release();
                        } catch (Exception e7) {
                            com.uc.crashsdk.a.g.a(e7);
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return z2;
    }

    private static boolean a(String str, d dVar) {
        String a2 = com.uc.crashsdk.a.g.a(new File(str), 64, false);
        if (a2 == null) {
            return false;
        }
        try {
            Matcher matcher = Pattern.compile("(\\d+)\\s+(\\d+)\\s+(\\d+)\\s+(\\d+)").matcher(a2);
            if (matcher.find()) {
                long parseLong = Long.parseLong(matcher.group(1));
                if (System.currentTimeMillis() - parseLong < 86400000) {
                    dVar.b = Long.parseLong(matcher.group(2));
                    dVar.c = Integer.parseInt(matcher.group(3));
                    dVar.d = Integer.parseInt(matcher.group(4));
                    dVar.a = parseLong;
                }
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        return true;
    }

    public static boolean a(String str, String str2, boolean z2) {
        if (!o(str2)) {
            return false;
        }
        h.a(str, str2, true, z2);
        com.uc.crashsdk.a.a.b(String.format(Locale.US, "Custom log '%s' has reach max count!", str2));
        return true;
    }

    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6, types: [boolean, int] */
    public static boolean a(StringBuffer stringBuffer, String str, long j2, ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3, String str2) {
        long j3;
        boolean z2;
        long j4;
        boolean a2;
        if (c.get()) {
            com.uc.crashsdk.a.a.b("Processing java crash, skip generate custom log: " + str);
            return false;
        }
        boolean z3 = ag || com.uc.crashsdk.b.L();
        if (!z3 && !com.uc.crashsdk.a.d.e()) {
            com.uc.crashsdk.a.a.c("DEBUG", com.uc.crashsdk.a.d.b());
            return false;
        }
        if (!d(str)) {
            com.uc.crashsdk.a.a.d("DEBUG", "custom log sample miss: " + str);
            return false;
        }
        if (aa()) {
            com.uc.crashsdk.a.a.b("Processing native crash, skip generate custom log: " + str);
            return false;
        }
        if (stringBuffer == null || str == null) {
            return false;
        }
        String str3 = g.Y() + k(str);
        ?? r1 = (j2 & 32) != 0 ? 1 : 0;
        if (z3) {
            j3 = com.uc.crashsdk.b.d ? JNIBridge.nativeClientCreateConnection(str3, "custom", str, r1) : 0L;
            if (j3 == 0) {
                com.uc.crashsdk.a.a.d("DEBUG", "skip custom log: ".concat(str));
                return false;
            }
        } else {
            if (a(h(), str, (boolean) r1)) {
                return false;
            }
            g.a();
            a(false);
            j3 = 0;
        }
        synchronized (q) {
            z2 = r1;
            j4 = j3;
            a2 = a(str3, j4, stringBuffer, str, j2, arrayList, arrayList2, arrayList3, str2);
        }
        if (a2 && !z3) {
            b(h(), str, z2);
        }
        if (j4 != 0) {
            JNIBridge.nativeClientCloseConnection(j4);
        }
        if (!a2) {
            return false;
        }
        if (!z3) {
            r(str3);
        }
        if (!z3) {
            str3 = a(m(str3));
        }
        b(str3, str);
        if (z2 && !z3) {
            try {
                a(true, false);
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
        }
        return true;
    }

    public static boolean a(boolean z2, boolean z3) {
        if (!d) {
            if (com.uc.crashsdk.b.d) {
                JNIBridge.set(1, true);
            }
            d = true;
        }
        try {
            String k2 = k();
            if (com.uc.crashsdk.a.g.a(k2)) {
                com.uc.crashsdk.a.a.a("crashsdk", "CrashHandler url is empty!");
                return false;
            }
            if (com.uc.crashsdk.a.f.a(z2 ? 1 : 0, new com.uc.crashsdk.a.e(406, new Object[]{k2, Boolean.valueOf(z3), Boolean.valueOf(z2)})) && z2) {
                ConditionVariable conditionVariable = o;
                conditionVariable.close();
                if (!conditionVariable.block(3000L)) {
                    com.uc.crashsdk.a.a.a("crashsdk", "timeout to wait for uploading");
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return false;
        }
    }

    private static boolean aa() {
        return com.uc.crashsdk.b.d && JNIBridge.nativeIsCrashing();
    }

    private static void ab() {
        String Z2 = g.Z();
        File file = new File(Z2);
        if (file.isDirectory()) {
            try {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length > 150) {
                    Arrays.sort(listFiles, new b((byte) 0));
                    int length = listFiles.length - 150;
                    if (length < 0) {
                        length = 0;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    int i2 = 0;
                    int i3 = 0;
                    int i4 = 0;
                    while (i2 < listFiles.length) {
                        File file2 = listFiles[i2];
                        boolean z2 = i2 < length;
                        if (!z2 && currentTimeMillis - file2.lastModified() >= 432000000) {
                            z2 = true;
                        }
                        if (!z2) {
                            break;
                        }
                        try {
                            file2.delete();
                            i3++;
                            i4 = 0;
                        } catch (Throwable th) {
                            i4++;
                            com.uc.crashsdk.a.g.a(th);
                        }
                        if (i4 >= 3) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                    com.uc.crashsdk.a.a.a("Removed " + i3 + " logs in " + Z2);
                }
            } catch (Throwable th2) {
                com.uc.crashsdk.a.g.a(th2);
            }
        }
    }

    public static int b(OutputStream outputStream, String str, int i2) {
        int i3;
        DataInputStream dataInputStream = null;
        int i4 = 0;
        try {
            File file = new File(str);
            if (file.exists()) {
                byte[] R2 = R();
                if (R2 == null) {
                    outputStream.write("(alloc buffer failed!)\n".getBytes("UTF-8"));
                    return 0;
                }
                DataInputStream dataInputStream2 = new DataInputStream(new FileInputStream(file));
                int i5 = 0;
                int i6 = 0;
                boolean z2 = false;
                while (true) {
                    try {
                        int read = dataInputStream2.read(R2);
                        if (read == -1) {
                            break;
                        }
                        i5 += read;
                        int i7 = i2 - i6;
                        if (read <= i7 + 32) {
                            i7 = read;
                        }
                        if (i7 > 0 && !z2) {
                            outputStream.write(R2, 0, i7);
                            i6 += i7;
                        }
                        if (!z2) {
                            z2 = i7 < read || i6 >= i2;
                        }
                    } catch (Throwable th) {
                        th = th;
                        i4 = i6;
                        dataInputStream = dataInputStream2;
                        try {
                            a(th, outputStream);
                            a(outputStream);
                            return i4;
                        } finally {
                            com.uc.crashsdk.a.g.a(dataInputStream);
                        }
                    }
                }
                i3 = i5;
                i4 = i6;
                dataInputStream = dataInputStream2;
            } else {
                outputStream.write(("file: '" + str + "' not exists!\n").getBytes("UTF-8"));
                i3 = 0;
            }
            if (i4 > 0) {
                outputStream.write(UMCustomLogInfoBuilder.LINE_SEP.getBytes("UTF-8"));
            }
            if (i4 < i3) {
                outputStream.write(String.format(Locale.US, "(truncated %d bytes)\n", Integer.valueOf(i3 - i4)).getBytes("UTF-8"));
            }
        } catch (Throwable th2) {
            th = th2;
        }
        a(outputStream);
        return i4;
    }

    public static long b() {
        if (g == -1) {
            g = h(com.uc.crashsdk.b.b("local"));
        }
        return g;
    }

    private static String b(String str, boolean z2, boolean z3) {
        if (z2) {
            try {
                str = m(str);
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
        }
        if (!z3) {
            return str;
        }
        try {
            return a(str);
        } catch (Throwable th2) {
            com.uc.crashsdk.a.g.a(th2);
            return str;
        }
    }

    public static void b(int i2) {
        com.uc.crashsdk.a.f.a(0, new com.uc.crashsdk.a.e(410), i2 * IjkMediaCodecInfo.RANK_MAX);
    }

    public static void b(Context context) {
        if (g.N()) {
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
                intentFilter.addAction("android.intent.action.BATTERY_LOW");
                intentFilter.addAction("android.intent.action.BATTERY_OKAY");
                context.registerReceiver(Q, intentFilter, null, com.uc.crashsdk.a.f.a(1));
                R = true;
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
        }
    }

    private static void b(a aVar) {
        h = false;
        try {
            aVar.write((s("LOG_END") + UMCustomLogInfoBuilder.LINE_SEP).getBytes("UTF-8"));
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        h = true;
    }

    private static void b(OutputStream outputStream) {
        BufferedReader bufferedReader = null;
        try {
            try {
                outputStream.write("logcat:\n".getBytes("UTF-8"));
            } catch (Throwable th) {
                h = true;
                a(th, outputStream);
            }
            if (g.o() <= 0) {
                try {
                    outputStream.write("[DEBUG] custom java logcat lines count is 0!\n".getBytes("UTF-8"));
                } catch (Throwable th2) {
                    a(th2, outputStream);
                }
                a(outputStream);
                return;
            }
            int o2 = g.o();
            bufferedReader = a(new InputStreamReader(Runtime.getRuntime().exec(new String[]{"logcat", "-d", "-b", com.umeng.analytics.pro.g.ax, "-b", "main", "-v", "threadtime", "-t", String.valueOf(o2)}).getInputStream()));
            if (bufferedReader == null) {
                try {
                    outputStream.write("[DEBUG] alloc buffer failed!\n".getBytes("UTF-8"));
                } catch (Throwable th3) {
                    a(th3, outputStream);
                }
                a(outputStream);
                return;
            }
            int i2 = 0;
            h = false;
            int i3 = 0;
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    i2++;
                    if (i3 < o2 && !readLine.contains(" I auditd ") && !readLine.contains(" I liblog ")) {
                        outputStream.write(readLine.getBytes("UTF-8"));
                        outputStream.write(UMCustomLogInfoBuilder.LINE_SEP.getBytes("UTF-8"));
                        i3++;
                    }
                } else {
                    try {
                        break;
                    } catch (Throwable th4) {
                        a(th4, outputStream);
                    }
                }
            }
            outputStream.write(String.format(Locale.US, "[DEBUG] Read %d lines, wrote %d lines.\n", Integer.valueOf(i2), Integer.valueOf(i3)).getBytes("UTF-8"));
            h = true;
            a(outputStream);
            return;
            h = true;
            a(th, outputStream);
            a(outputStream);
            return;
        } finally {
            com.uc.crashsdk.a.g.a((Closeable) null);
        }
    }

    private static void b(OutputStream outputStream, String str, String str2) {
        String str3;
        try {
            outputStream.write("*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** ***\n".getBytes("UTF-8"));
        } catch (Throwable th) {
            a(th, outputStream);
        }
        try {
            Locale locale = Locale.US;
            outputStream.write(String.format(locale, "Basic Information: 'pid: %d/tid: %d/time: %s'\n", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()), n()).getBytes("UTF-8"));
            String e = e();
            if (com.uc.crashsdk.a.g.a(l)) {
                T();
            }
            outputStream.write(String.format(locale, "Cpu Information: 'abi: %s/processor: %s/hardware: %s'\n", e, l, f()).getBytes("UTF-8"));
        } catch (Throwable th2) {
            a(th2, outputStream);
        }
        try {
            Locale locale2 = Locale.US;
            outputStream.write(String.format(locale2, "Mobile Information: 'model: %s/version: %s/sdk: %d'\n", Build.MODEL, Build.VERSION.RELEASE, Integer.valueOf(Build.VERSION.SDK_INT)).getBytes("UTF-8"));
            outputStream.write(("Build fingerprint: '" + Build.FINGERPRINT + "'\n").getBytes("UTF-8"));
            outputStream.write(String.format(locale2, "Runtime Information: 'start: %s/maxheap: %s/primaryabi: %s/ground: %s'\n", a(new Date(b)), Long.valueOf(Runtime.getRuntime().maxMemory()), com.uc.crashsdk.a.g.d(), com.uc.crashsdk.b.B() ? "fg" : "bg").getBytes("UTF-8"));
        } catch (Throwable th3) {
            a(th3, outputStream);
        }
        try {
            Locale locale3 = Locale.US;
            outputStream.write(String.format(locale3, "Application Information: 'version: %s/subversion: %s/buildseq: %s/versioncode: %d'\n", g.U(), g.V(), g.W(), Integer.valueOf(com.uc.crashsdk.a.c())).getBytes("UTF-8"));
            String str4 = "0";
            if (com.uc.crashsdk.b.d) {
                String nativeGet = JNIBridge.nativeGet(1, 0L, null);
                str3 = JNIBridge.nativeGet(2, 0L, null);
                str4 = nativeGet;
            } else {
                str3 = "";
            }
            outputStream.write(String.format(locale3, "CrashSDK Information: 'version: %s/nativeseq: %s/javaseq: %s/arch: %s/target: %s'\n", "3.3.2.2", str4, "240515102041", str3, "umeng").getBytes("UTF-8"));
            if (str == null) {
                str = "";
            }
            outputStream.write(("Report Name: " + str.substring(str.lastIndexOf(47) + 1) + UMCustomLogInfoBuilder.LINE_SEP).getBytes("UTF-8"));
        } catch (Throwable th4) {
            a(th4, outputStream);
        }
        try {
            outputStream.write(String.format("UUID: %s\n", ag ? s("UUID") : B).getBytes("UTF-8"));
            outputStream.write(("Log Type: " + str2 + UMCustomLogInfoBuilder.LINE_SEP).getBytes("UTF-8"));
        } catch (Throwable th5) {
            a(th5, outputStream);
        }
        try {
            String E2 = com.uc.crashsdk.b.E();
            if (com.uc.crashsdk.a.g.a(E2)) {
                E2 = "(none)";
            }
            outputStream.write(("Activity: " + E2 + UMCustomLogInfoBuilder.LINE_SEP).getBytes("UTF-8"));
        } catch (Throwable th6) {
            a(th6, outputStream);
        }
        a(outputStream);
        try {
            com.uc.crashsdk.a.a(outputStream, "UTF-8");
            if (ag) {
                h = false;
                outputStream.write(s("HEADER").getBytes("UTF-8"));
                h = true;
            }
        } catch (Throwable th7) {
            a(th7, outputStream);
        }
        a(outputStream);
    }

    public static void b(String str) {
        synchronized (y) {
            x = str;
            com.uc.crashsdk.a.b.a(com.uc.crashsdk.b.i(), str + UMCustomLogInfoBuilder.LINE_SEP);
        }
    }

    private static void b(String str, String str2) {
        try {
            com.uc.crashsdk.d.a(str, h(), str2);
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    public static void b(String str, String str2, boolean z2) {
        h.a(str, str2, false, z2);
    }

    public static void b(boolean z2) {
        try {
            boolean z3 = g.s() && com.uc.crashsdk.b.F() && !d;
            if (!z3) {
                z3 = g.t();
            }
            if (z3) {
                if (!z2) {
                    a(true, false);
                    return;
                }
                String k2 = k();
                if (com.uc.crashsdk.a.g.a(k2)) {
                    return;
                }
                j();
                a(k2, false, false);
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    public static boolean b(int i2, Object[] objArr) {
        if (i2 == 451) {
            if (a || objArr != null) {
                return a((String) objArr[0], (d) objArr[1]);
            }
            jr4.a();
            return false;
        }
        if (i2 != 452) {
            if (a) {
                return false;
            }
            jr4.a();
            return false;
        }
        if (!a && objArr == null) {
            jr4.a();
            return false;
        }
        String str = (String) objArr[0];
        d dVar = (d) objArr[1];
        return com.uc.crashsdk.a.g.a(new File(str), String.format(Locale.US, "%d %d %d %d", Long.valueOf(dVar.a), Long.valueOf(dVar.b), Integer.valueOf(dVar.c), Integer.valueOf(dVar.d)).getBytes());
    }

    private static boolean b(File file) {
        int indexOf;
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(95);
        if (lastIndexOf <= 0 || (indexOf = name.indexOf(46, lastIndexOf)) <= 0) {
            return false;
        }
        String substring = name.substring(lastIndexOf + 1, indexOf);
        return "java".equals(substring) || "ucebujava".equals(substring) || "jni".equals(substring) || "ucebujni".equals(substring) || LogType.UNEXP_TYPE.equals(substring) || "anr".equals(substring);
    }

    public static void c() {
        i = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0080 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void c(java.io.OutputStream r8) {
        /*
            java.lang.String r0 = "UTF-8"
            boolean r1 = com.uc.crashsdk.b.d
            r2 = 0
            if (r1 == 0) goto L3d
            java.lang.String r0 = com.uc.crashsdk.b.o()
            com.uc.crashsdk.e.h = r2
            r1 = 17
            long r1 = com.uc.crashsdk.JNIBridge.cmd(r1, r0)
            r3 = 1
            int r1 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            r2 = 1
            if (r1 != 0) goto L3a
            java.io.File r1 = new java.io.File
            r1.<init>(r0)
            byte[] r0 = com.uc.crashsdk.a.g.e(r1)     // Catch: java.lang.Throwable -> L29
            if (r0 == 0) goto L2d
            r8.write(r0)     // Catch: java.lang.Throwable -> L29
            goto L2d
        L29:
            r0 = move-exception
            a(r0, r8)
        L2d:
            r1.delete()     // Catch: java.lang.Throwable -> L31
            goto L35
        L31:
            r0 = move-exception
            a(r0, r8)
        L35:
            com.uc.crashsdk.e.h = r2
            a(r8)
        L3a:
            com.uc.crashsdk.e.h = r2
            return
        L3d:
            r1 = 0
            int r3 = com.uc.crashsdk.g.K()     // Catch: java.lang.Throwable -> L78
            java.io.File r4 = new java.io.File     // Catch: java.lang.Throwable -> L6c
            java.lang.String r5 = "/proc/self/fd"
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L6c
            java.io.File[] r1 = r4.listFiles()     // Catch: java.lang.Throwable -> L6c
            if (r1 == 0) goto L6e
            java.util.Locale r4 = java.util.Locale.US     // Catch: java.lang.Throwable -> L6c
            java.lang.String r5 = "opened file count: %d, write limit: %d.\n"
            int r6 = r1.length     // Catch: java.lang.Throwable -> L6c
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Throwable -> L6c
            java.lang.Integer r7 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Throwable -> L6c
            java.lang.Object[] r6 = new java.lang.Object[]{r6, r7}     // Catch: java.lang.Throwable -> L6c
            java.lang.String r4 = java.lang.String.format(r4, r5, r6)     // Catch: java.lang.Throwable -> L6c
            byte[] r4 = r4.getBytes(r0)     // Catch: java.lang.Throwable -> L6c
            r8.write(r4)     // Catch: java.lang.Throwable -> L6c
            goto L7e
        L6c:
            r4 = move-exception
            goto L7b
        L6e:
            java.lang.String r4 = "[DEBUG] listFiles failed!\n"
            byte[] r4 = r4.getBytes(r0)     // Catch: java.lang.Throwable -> L6c
            r8.write(r4)     // Catch: java.lang.Throwable -> L6c
            goto L7e
        L78:
            r4 = move-exception
            r3 = 900(0x384, float:1.261E-42)
        L7b:
            a(r4, r8)
        L7e:
            if (r1 == 0) goto Lc5
            int r4 = r1.length     // Catch: java.lang.Throwable -> Lc1
            if (r4 < r3) goto Lc5
            java.lang.String r3 = "opened files:\n"
            byte[] r3 = r3.getBytes(r0)     // Catch: java.lang.Throwable -> Lc1
            r8.write(r3)     // Catch: java.lang.Throwable -> Lc1
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc1
            r3.<init>()     // Catch: java.lang.Throwable -> Lc1
            int r4 = r1.length     // Catch: java.lang.Throwable -> Lb1
        L92:
            if (r2 >= r4) goto Lb5
            r5 = r1[r2]     // Catch: java.lang.Throwable -> Lb1
            java.lang.String r6 = r5.getName()     // Catch: java.lang.Throwable -> Lb1
            r3.append(r6)     // Catch: java.lang.Throwable -> Lb1
            java.lang.String r6 = " -> "
            r3.append(r6)     // Catch: java.lang.Throwable -> Lb1
            java.lang.String r5 = r5.getCanonicalPath()     // Catch: java.lang.Throwable -> Lb1
            r3.append(r5)     // Catch: java.lang.Throwable -> Lb1
            java.lang.String r5 = "\n"
            r3.append(r5)     // Catch: java.lang.Throwable -> Lb1
            int r2 = r2 + 1
            goto L92
        Lb1:
            r1 = move-exception
            a(r1, r8)     // Catch: java.lang.Throwable -> Lc1
        Lb5:
            java.lang.String r1 = r3.toString()     // Catch: java.lang.Throwable -> Lc1
            byte[] r0 = r1.getBytes(r0)     // Catch: java.lang.Throwable -> Lc1
            r8.write(r0)     // Catch: java.lang.Throwable -> Lc1
            goto Lc5
        Lc1:
            r0 = move-exception
            a(r0, r8)
        Lc5:
            a(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.c(java.io.OutputStream):void");
    }

    public static void c(String str) {
        synchronized (z) {
            com.uc.crashsdk.a.b.a(com.uc.crashsdk.b.l(), str + UMCustomLogInfoBuilder.LINE_SEP);
        }
    }

    public static void c(boolean z2) {
        if (R) {
            if (z2 && g.N()) {
                return;
            }
        } else if (!z2 || !g.N()) {
            return;
        }
        com.uc.crashsdk.a.e eVar = S;
        if (com.uc.crashsdk.a.f.b(eVar)) {
            com.uc.crashsdk.a.f.a(eVar);
        }
        com.uc.crashsdk.a.f.a(0, eVar, 3000L);
    }

    public static String d() {
        String str = i;
        if (str != null) {
            return str;
        }
        String j2 = j(null);
        i = j2;
        return j2;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0026 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void d(java.io.OutputStream r9) {
        /*
            java.lang.String r0 = "UTF-8"
            r1 = 0
            r2 = 0
            int r3 = com.uc.crashsdk.g.L()     // Catch: java.lang.Throwable -> L1c
            java.io.File r4 = new java.io.File     // Catch: java.lang.Throwable -> L1a
            java.lang.String r5 = "/proc/self/task"
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L1a
            java.io.File[] r1 = r4.listFiles()     // Catch: java.lang.Throwable -> L1a
            if (r1 != 0) goto L16
            goto L25
        L16:
            int r4 = r1.length     // Catch: java.lang.Throwable -> L1a
            if (r4 >= r3) goto L23
            goto L25
        L1a:
            r4 = move-exception
            goto L1f
        L1c:
            r4 = move-exception
            r3 = 300(0x12c, float:4.2E-43)
        L1f:
            com.uc.crashsdk.a.g.a(r4)
            r4 = r2
        L23:
            if (r1 != 0) goto L26
        L25:
            return
        L26:
            java.lang.String r5 = "threads info:\n"
            byte[] r5 = r5.getBytes(r0)     // Catch: java.lang.Throwable -> L88
            r9.write(r5)     // Catch: java.lang.Throwable -> L88
            java.util.Locale r5 = java.util.Locale.US     // Catch: java.lang.Throwable -> L88
            java.lang.String r6 = "threads count: %d, dump limit: %d.\n"
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Throwable -> L88
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Throwable -> L88
            java.lang.Object[] r3 = new java.lang.Object[]{r4, r3}     // Catch: java.lang.Throwable -> L88
            java.lang.String r3 = java.lang.String.format(r5, r6, r3)     // Catch: java.lang.Throwable -> L88
            byte[] r3 = r3.getBytes(r0)     // Catch: java.lang.Throwable -> L88
            r9.write(r3)     // Catch: java.lang.Throwable -> L88
            java.lang.String r3 = " tid     name\n"
            byte[] r3 = r3.getBytes(r0)     // Catch: java.lang.Throwable -> L88
            r9.write(r3)     // Catch: java.lang.Throwable -> L88
            int r3 = r1.length     // Catch: java.lang.Throwable -> L88
            r4 = r2
        L55:
            if (r4 >= r3) goto L8c
            r5 = r1[r4]     // Catch: java.lang.Throwable -> L88
            java.io.File r6 = new java.io.File     // Catch: java.lang.Throwable -> L88
            java.lang.String r7 = r5.getPath()     // Catch: java.lang.Throwable -> L88
            java.lang.String r8 = "comm"
            r6.<init>(r7, r8)     // Catch: java.lang.Throwable -> L88
            r7 = 128(0x80, float:1.8E-43)
            java.lang.String r6 = com.uc.crashsdk.a.g.a(r6, r7, r2)     // Catch: java.lang.Throwable -> L88
            java.lang.String r6 = l(r6)     // Catch: java.lang.Throwable -> L88
            java.util.Locale r7 = java.util.Locale.US     // Catch: java.lang.Throwable -> L88
            java.lang.String r8 = "%5s %s\n"
            java.lang.String r5 = r5.getName()     // Catch: java.lang.Throwable -> L88
            java.lang.Object[] r5 = new java.lang.Object[]{r5, r6}     // Catch: java.lang.Throwable -> L88
            java.lang.String r5 = java.lang.String.format(r7, r8, r5)     // Catch: java.lang.Throwable -> L88
            byte[] r5 = r5.getBytes(r0)     // Catch: java.lang.Throwable -> L88
            r9.write(r5)     // Catch: java.lang.Throwable -> L88
            int r4 = r4 + 1
            goto L55
        L88:
            r0 = move-exception
            a(r0, r9)
        L8c:
            a(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.d(java.io.OutputStream):void");
    }

    public static void d(boolean z2) {
        f.d(false);
        if (z2) {
            f.a(com.uc.crashsdk.b.c(), false);
            h.i();
        } else {
            f.a();
            h.i();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(Context context) {
        List<ActivityManager.ProcessErrorStateInfo> processesInErrorState;
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null || (processesInErrorState = activityManager.getProcessesInErrorState()) == null) {
            return false;
        }
        int myPid = Process.myPid();
        Iterator<ActivityManager.ProcessErrorStateInfo> it = processesInErrorState.iterator();
        while (true) {
            if (it.hasNext()) {
                ActivityManager.ProcessErrorStateInfo next = it.next();
                if (next.pid == myPid) {
                    O = true;
                    if (O()) {
                        com.uc.crashsdk.a.a.d("crashsdk", "ANR occurred in process: " + next.processName);
                    }
                    if (com.uc.crashsdk.b.d) {
                        JNIBridge.set(130, next.longMsg);
                    }
                }
            } else if (com.uc.crashsdk.b.d) {
                W();
            }
        }
        return true;
    }

    public static boolean d(String str) {
        if (ag) {
            return true;
        }
        try {
            return p(str);
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return true;
        }
    }

    public static int e(boolean z2) {
        return f.a(z2);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:45|(2:46|47)|48|49|50|(1:54)|55|(1:59)|61|62) */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0132, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0133, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a1 A[Catch: all -> 0x00bf, TRY_LEAVE, TryCatch #5 {all -> 0x00bf, blocks: (B:43:0x008f, B:45:0x00a1), top: B:42:0x008f }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00cf A[Catch: all -> 0x0132, TryCatch #0 {all -> 0x0132, blocks: (B:50:0x00c9, B:52:0x00cf, B:54:0x00d7, B:55:0x00fd, B:57:0x0103, B:59:0x010b), top: B:49:0x00c9 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0103 A[Catch: all -> 0x0132, TryCatch #0 {all -> 0x0132, blocks: (B:50:0x00c9, B:52:0x00cf, B:54:0x00d7, B:55:0x00fd, B:57:0x0103, B:59:0x010b), top: B:49:0x00c9 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String e() {
        /*
            Method dump skipped, instructions count: 313
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.e():java.lang.String");
    }

    private static void e(OutputStream outputStream) {
        BufferedReader bufferedReader;
        int indexOf;
        if (com.uc.crashsdk.b.d) {
            try {
                outputStream.write("solib build id:\n".getBytes("UTF-8"));
            } catch (Throwable th) {
                a(th, outputStream);
            }
            FileReader fileReader = null;
            try {
                ArrayList arrayList = new ArrayList();
                FileReader fileReader2 = new FileReader(new File("/proc/self/maps"));
                try {
                    bufferedReader = new BufferedReader(fileReader2, IjkMediaMeta.FF_PROFILE_H264_CONSTRAINED);
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            if (readLine.endsWith(".so") && (indexOf = readLine.indexOf(47)) != -1) {
                                String substring = readLine.substring(indexOf);
                                if (!substring.contains("/data/") && !substring.contains(com.uc.crashsdk.a.a)) {
                                }
                                if (!arrayList.contains(substring)) {
                                    arrayList.add(substring);
                                    if (ag) {
                                        try {
                                            outputStream.write((String.format("$^%s`%s^$", "SOBUILDID", substring) + UMCustomLogInfoBuilder.LINE_SEP).getBytes("UTF-8"));
                                        } catch (Throwable th2) {
                                            a(th2, outputStream);
                                        }
                                    } else {
                                        outputStream.write(String.format(Locale.US, "%s: %s\n", substring, JNIBridge.nativeGet(3, 0L, substring)).getBytes("UTF-8"));
                                    }
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            fileReader = fileReader2;
                            try {
                                a(th, outputStream);
                                com.uc.crashsdk.a.g.a(fileReader);
                                com.uc.crashsdk.a.g.a(bufferedReader);
                                a(outputStream);
                            } catch (Throwable th4) {
                                com.uc.crashsdk.a.g.a(fileReader);
                                com.uc.crashsdk.a.g.a(bufferedReader);
                                throw th4;
                            }
                        }
                    }
                    com.uc.crashsdk.a.g.a(fileReader2);
                } catch (Throwable th5) {
                    th = th5;
                    bufferedReader = null;
                }
            } catch (Throwable th6) {
                th = th6;
                bufferedReader = null;
            }
            com.uc.crashsdk.a.g.a(bufferedReader);
            a(outputStream);
        }
    }

    public static boolean e(String str) {
        try {
            if (!com.uc.crashsdk.a.g.b(str) || !str.startsWith("lib") || !str.endsWith(".so")) {
                return false;
            }
            System.loadLibrary(str.substring(3, str.length() - 3));
            return true;
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
            return false;
        }
    }

    public static int f(boolean z2) {
        int b2 = z2 ? f.a(com.uc.crashsdk.b.c()) ? 1 : 0 : f.b();
        int b3 = f.b(z2);
        return b3 > b2 ? b3 : b2;
    }

    public static String f() {
        if (com.uc.crashsdk.a.g.a(k)) {
            T();
        }
        return k;
    }

    public static StringBuilder f(String str) {
        return a(Thread.currentThread().getStackTrace(), str);
    }

    private static void f(OutputStream outputStream) {
        try {
            outputStream.write("recent status:\n".getBytes("UTF-8"));
        } catch (Throwable th) {
            a(th, outputStream);
        }
        try {
            outputStream.write(String.format(Locale.US, "last version: '%s'\n", ag ? s("LASTVER") : com.uc.crashsdk.a.m()).getBytes("UTF-8"));
        } catch (Throwable th2) {
            a(th2, outputStream);
        }
        try {
            ArrayList<String> arrayList = s;
            synchronized (arrayList) {
                try {
                    if (u != null) {
                        outputStream.write(String.format(Locale.US, "generating log: %s\n", u).getBytes("UTF-8"));
                    }
                    if (t > 0 || arrayList.size() > 0) {
                        outputStream.write(String.format(Locale.US, "generated %d logs, recent are:\n", Integer.valueOf(t)).getBytes("UTF-8"));
                        Iterator<String> it = arrayList.iterator();
                        while (it.hasNext()) {
                            outputStream.write(String.format(Locale.US, "* %s\n", it.next()).getBytes("UTF-8"));
                        }
                    }
                } finally {
                }
            }
            Locale locale = Locale.US;
            outputStream.write(String.format(locale, "dumping all threads: %s\n", Boolean.valueOf(v)).getBytes("UTF-8"));
            String str = w;
            if (str != null) {
                outputStream.write(String.format(locale, "dumping threads: %s\n", str).getBytes("UTF-8"));
            }
        } catch (Throwable th3) {
            a(th3, outputStream);
        }
        a(outputStream);
    }

    public static String g() {
        try {
            StringBuilder sb = new StringBuilder("JavaMax:    ");
            sb.append(Runtime.getRuntime().maxMemory() / 1024);
            sb.append(" kB\nJavaTotal:  ");
            sb.append(Runtime.getRuntime().totalMemory() / 1024);
            sb.append(" kB\nJavaFree:   ");
            sb.append(Runtime.getRuntime().freeMemory() / 1024);
            sb.append(" kB\nNativeHeap: ");
            sb.append(Debug.getNativeHeapSize() / 1024);
            sb.append(" kB\nNativeAllocated: ");
            sb.append(Debug.getNativeHeapAllocatedSize() / 1024);
            sb.append(" kB\nNativeFree: ");
            sb.append(Debug.getNativeHeapFreeSize() / 1024);
            sb.append(" kB\n");
            try {
                ActivityManager activityManager = (ActivityManager) com.uc.crashsdk.a.g.a().getSystemService("activity");
                if (activityManager != null) {
                    ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                    activityManager.getMemoryInfo(memoryInfo);
                    sb.append("availMem:   ");
                    sb.append(memoryInfo.availMem / 1024);
                    sb.append(" kB\n");
                    sb.append("threshold:  ");
                    sb.append(memoryInfo.threshold / 1024);
                    sb.append(" kB\n");
                    sb.append("lowMemory:  ");
                    sb.append(memoryInfo.lowMemory);
                    sb.append(UMCustomLogInfoBuilder.LINE_SEP);
                }
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
            return sb.toString();
        } catch (Throwable th2) {
            com.uc.crashsdk.a.g.a(th2);
            return "";
        }
    }

    private static long h(String str) {
        try {
            Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("getLong", String.class, Long.TYPE);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                return ((Long) declaredMethod.invoke(null, str, 0L)).longValue();
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
        return 0L;
    }

    public static String h() {
        String str = m;
        if (str != null) {
            return str;
        }
        String a2 = a(Process.myPid());
        m = a2;
        return a2;
    }

    private static String i(String str) {
        try {
            return str.replaceAll("[^0-9a-zA-Z-.]", "-");
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    public static boolean i() {
        return d;
    }

    private static String j(String str) {
        if (str == null) {
            str = String.valueOf(System.currentTimeMillis()) + new Random().nextInt(65536);
        }
        return String.format(Locale.US, "%s%s_%s_%s_%s_%s_", P(), g.U(), g.W(), i(Build.MODEL), i(Build.VERSION.RELEASE), str);
    }

    public static void j() {
        try {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(StrictMode.getThreadPolicy()).permitNetwork().build());
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    public static String k() {
        String a2;
        String str = x;
        if (!com.uc.crashsdk.a.g.a(str)) {
            return str;
        }
        synchronized (y) {
            a2 = com.uc.crashsdk.a.g.a(com.uc.crashsdk.b.i(), g.z(), true);
            x = a2;
        }
        return a2;
    }

    private static String k(String str) {
        return String.format(Locale.US, "%s%s_%s_%s.log", d(), n(), Q(), str);
    }

    private static String l(String str) {
        if (!com.uc.crashsdk.a.g.b(str)) {
            return "";
        }
        int indexOf = str.indexOf(0);
        if (indexOf >= 0) {
            str = str.substring(0, indexOf);
        }
        return str.trim();
    }

    public static void l() {
        synchronized (y) {
            x = null;
        }
    }

    private static String m(String str) {
        String a2 = com.uc.crashsdk.a.b.a(str, g.x(), g.w());
        if (!str.equals(a2)) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
        return a2;
    }

    public static void m() {
        if (ag) {
            return;
        }
        com.uc.crashsdk.a.f.a(1, new com.uc.crashsdk.a.e(411), 1000L);
    }

    public static String n() {
        return a(new Date());
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0055, code lost:
    
        if (r7.endsWith(r3) != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x006d, code lost:
    
        if (r7.indexOf(".log", r7.lastIndexOf(95)) != r7.lastIndexOf(".log")) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean[] n(java.lang.String r7) {
        /*
            boolean r0 = com.uc.crashsdk.g.w()
            boolean r1 = com.uc.crashsdk.g.y()
            r2 = 0
            if (r0 != 0) goto Ld
            if (r1 == 0) goto L70
        Ld:
            java.lang.String r3 = ".tmp"
            boolean r3 = r7.endsWith(r3)
            if (r3 != 0) goto L3c
            java.lang.String r3 = ".ec"
            boolean r3 = r7.contains(r3)
            if (r3 == 0) goto L1e
            goto L3c
        L1e:
            char r3 = java.io.File.separatorChar
            int r3 = r7.lastIndexOf(r3)
            if (r3 >= 0) goto L29
            r3 = r2
            r4 = r3
            goto L2a
        L29:
            r4 = r2
        L2a:
            r5 = 95
            int r3 = r7.indexOf(r5, r3)
            if (r3 < 0) goto L36
            int r4 = r4 + 1
            int r3 = r3 + 1
        L36:
            if (r3 >= 0) goto L2a
            r3 = 8
            if (r4 == r3) goto L3f
        L3c:
            r0 = r2
            r1 = r0
            goto L70
        L3f:
            java.lang.String r3 = com.uc.crashsdk.g.x()
            java.lang.String r4 = ".log"
            boolean r6 = r7.endsWith(r4)
            if (r6 != 0) goto L5a
            boolean r0 = com.uc.crashsdk.a.g.a(r3)
            if (r0 != 0) goto L3c
            boolean r7 = r7.endsWith(r3)
            if (r7 != 0) goto L58
            goto L3c
        L58:
            r0 = r2
            goto L70
        L5a:
            boolean r3 = com.uc.crashsdk.a.g.a(r3)
            if (r3 == 0) goto L61
            goto L58
        L61:
            int r3 = r7.lastIndexOf(r5)
            int r3 = r7.indexOf(r4, r3)
            int r7 = r7.lastIndexOf(r4)
            if (r3 == r7) goto L70
            goto L58
        L70:
            r7 = 2
            boolean[] r7 = new boolean[r7]
            r7[r2] = r0
            r0 = 1
            r7[r0] = r1
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.n(java.lang.String):boolean[]");
    }

    public static void o() {
        b = System.currentTimeMillis();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:3|4|(3:6|(3:9|(1:11)(15:12|13|14|(3:16|17|18)(1:51)|19|(1:47)(1:22)|23|(1:25)|26|27|28|29|30|31|32)|7)|52)|53|(0)|26|27|28|29|30|31|32) */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00d4, code lost:
    
        r15 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00df, code lost:
    
        com.uc.crashsdk.a.g.a(r15);
        r1 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00db, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00dc, code lost:
    
        r1 = null;
        r15 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00d6, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00d7, code lost:
    
        r1 = 0;
        r15 = r1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00aa A[Catch: all -> 0x0053, TRY_LEAVE, TryCatch #1 {all -> 0x0053, blocks: (B:4:0x0003, B:6:0x002f, B:7:0x003d, B:9:0x0043, B:11:0x004e, B:13:0x0056, B:18:0x0069, B:19:0x007a, B:23:0x0085, B:25:0x00aa, B:31:0x00ce, B:32:0x00e3, B:41:0x00e5, B:42:0x00e8, B:50:0x0073), top: B:3:0x0003, inners: #5 }] */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v14, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v16, types: [java.util.Locale] */
    /* JADX WARN: Type inference failed for: r1v18, types: [java.util.regex.Pattern] */
    /* JADX WARN: Type inference failed for: r1v19, types: [java.util.regex.Matcher] */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.CharSequence, java.lang.StringBuffer] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean o(java.lang.String r15) {
        /*
            Method dump skipped, instructions count: 235
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.o(java.lang.String):boolean");
    }

    public static void p() {
        String str;
        Throwable th;
        if (com.uc.crashsdk.a.g.a(B)) {
            String str2 = null;
            try {
                File file = new File(g.X() + "unique");
                if (file.exists()) {
                    str = com.uc.crashsdk.a.g.a(file, 48, false);
                    try {
                        if (str != null) {
                            try {
                                if (str.length() == 36) {
                                    str2 = str.replaceAll("[^0-9a-zA-Z-]", "-");
                                }
                            } catch (Exception e) {
                                com.uc.crashsdk.a.g.a(e);
                            }
                        }
                        str2 = str;
                    } catch (Throwable th2) {
                        th = th2;
                        com.uc.crashsdk.a.g.a(th);
                        str2 = str;
                        B = str2;
                    }
                }
                if (com.uc.crashsdk.a.g.a(str2)) {
                    com.uc.crashsdk.b.G();
                    str2 = UUID.randomUUID().toString();
                    if (!com.uc.crashsdk.a.g.a(str2)) {
                        com.uc.crashsdk.a.g.a(file, str2.getBytes());
                    }
                }
            } catch (Throwable th3) {
                str = str2;
                th = th3;
            }
            B = str2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00ab A[Catch: all -> 0x0019, TryCatch #0 {all -> 0x0019, blocks: (B:4:0x0003, B:6:0x0008, B:7:0x001c, B:9:0x0027, B:10:0x0044, B:11:0x0030, B:13:0x00ab, B:18:0x00d1, B:24:0x00ec, B:25:0x00dc, B:39:0x00f9, B:42:0x0103, B:46:0x0036, B:48:0x003e, B:49:0x0047, B:51:0x004f, B:53:0x0057, B:55:0x005f, B:60:0x006d, B:62:0x0077, B:64:0x0082, B:66:0x008c, B:67:0x0095, B:69:0x009f), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x009f A[Catch: all -> 0x0019, TryCatch #0 {all -> 0x0019, blocks: (B:4:0x0003, B:6:0x0008, B:7:0x001c, B:9:0x0027, B:10:0x0044, B:11:0x0030, B:13:0x00ab, B:18:0x00d1, B:24:0x00ec, B:25:0x00dc, B:39:0x00f9, B:42:0x0103, B:46:0x0036, B:48:0x003e, B:49:0x0047, B:51:0x004f, B:53:0x0057, B:55:0x005f, B:60:0x006d, B:62:0x0077, B:64:0x0082, B:66:0x008c, B:67:0x0095, B:69:0x009f), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean p(java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 263
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.p(java.lang.String):boolean");
    }

    public static String q() {
        return B;
    }

    private static Map<String, Integer> q(String str) {
        HashMap hashMap = new HashMap();
        for (String str2 : str.split("\\|", 30)) {
            String[] split = str2.split(":", 3);
            if (split.length == 2) {
                String trim = split[0].trim();
                if (!com.uc.crashsdk.a.g.a(trim)) {
                    int i2 = 1;
                    try {
                        i2 = Integer.parseInt(split[1].trim(), 10);
                    } catch (Throwable th) {
                        com.uc.crashsdk.a.g.a(th);
                    }
                    hashMap.put(trim, Integer.valueOf(i2));
                }
            }
        }
        return hashMap;
    }

    public static void r() {
        O = false;
        if (!com.uc.crashsdk.b.B()) {
            com.uc.crashsdk.a.f.a(3, new com.uc.crashsdk.a.e(416), 11000L);
        }
        if (V()) {
            return;
        }
        N = 0;
        X();
    }

    private static void r(String str) {
        if (g.r()) {
            try {
                ab();
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
            if (str == null || "".equals(str)) {
                return;
            }
            try {
                File file = new File(g.Z());
                if (!file.exists()) {
                    file.mkdirs();
                }
                com.uc.crashsdk.a.a.a("crashsdk", "copy log to: " + file);
                com.uc.crashsdk.a.g.a(new File(str), file);
            } catch (Throwable th2) {
                com.uc.crashsdk.a.g.a(th2);
            }
        }
    }

    private static String s(String str) {
        return String.format("$^%s^$", str);
    }

    public static void s() {
        T = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new e());
    }

    public static void t() {
        Thread.setDefaultUncaughtExceptionHandler(T);
    }

    public static boolean u() {
        return c.get() || aa();
    }

    public static Throwable v() {
        return U;
    }

    public static int w() {
        if (com.uc.crashsdk.b.I() == 5) {
            return Z;
        }
        return 100;
    }

    public static void x() {
        long p2 = g.p();
        if (p2 < 0) {
            return;
        }
        boolean z2 = com.uc.crashsdk.b.I() == 5;
        com.uc.crashsdk.a.f.a(0, new com.uc.crashsdk.a.e(com.umeng.ccg.c.y));
        if (z2) {
            com.uc.crashsdk.a.e eVar = new com.uc.crashsdk.a.e(com.umeng.ccg.c.z);
            X = eVar;
            com.uc.crashsdk.a.f.a(0, eVar, p2);
        }
    }

    public static void y() {
        if (com.uc.crashsdk.b.c && com.uc.crashsdk.a.c && !com.uc.crashsdk.a.f.b(aa)) {
            com.uc.crashsdk.a.f.a(0, aa, 1000L);
        }
    }

    public static boolean z() {
        synchronized (Y) {
            try {
                Runnable runnable = X;
                if (runnable == null || W) {
                    return false;
                }
                com.uc.crashsdk.a.f.a(runnable);
                X = null;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:14|(3:51|52|(15:55|56|57|(1:19)|20|21|22|23|(1:25)|26|(1:30)|31|(1:34)|36|(1:43)))|16|(1:19)|20|21|22|23|(0)|26|(2:28|30)|31|(1:34)|36|(2:38|43)(1:44)) */
    /* JADX WARN: Can't wrap try/catch for region: R(16:550|(4:552|(6:555|556|557|558|(2:560|561)(1:563)|553)|567|562)|(3:601|602|(17:605|606|607|(1:572)|573|574|575|576|(1:578)|579|(1:583)|584|(1:587)|589|(1:593)|40|41))|569|(1:572)|573|574|575|576|(0)|579|(2:581|583)|584|(1:587)|589|(2:591|593)(1:594)) */
    /* JADX WARN: Can't wrap try/catch for region: R(17:(1:158)|(3:194|195|(18:198|199|200|201|161|(1:164)|165|166|167|168|(1:170)|171|(1:175)|176|(1:179)|181|182|(1:186)))|160|161|(1:164)|165|166|167|168|(0)|171|(2:173|175)|176|(1:179)|181|182|(2:184|186)(1:187)) */
    /* JADX WARN: Can't wrap try/catch for region: R(17:291|(3:327|328|(18:331|332|333|334|294|(1:297)|298|299|301|302|(1:304)|305|(1:309)|310|(1:313)|315|316|(1:320)))|293|294|(1:297)|298|299|301|302|(0)|305|(2:307|309)|310|(1:313)|315|316|(2:318|320)(1:321)) */
    /* JADX WARN: Can't wrap try/catch for region: R(17:344|(3:380|381|(18:384|385|386|387|347|(1:350)|351|352|354|355|(1:357)|358|(1:362)|363|(1:366)|368|369|(1:373)))|346|347|(1:350)|351|352|354|355|(0)|358|(2:360|362)|363|(1:366)|368|369|(2:371|373)(1:374)) */
    /* JADX WARN: Can't wrap try/catch for region: R(18:99|(1:103)|(3:139|140|(18:143|144|145|146|106|(1:109)|110|111|112|113|(1:115)|116|(1:120)|121|(1:124)|126|127|(1:131)))|105|106|(1:109)|110|111|112|113|(0)|116|(2:118|120)|121|(1:124)|126|127|(2:129|131)(1:132)) */
    /* JADX WARN: Can't wrap try/catch for region: R(20:468|469|470|(1:474)|(3:512|513|(18:516|517|518|519|477|(1:480)|481|482|484|485|(0)|488|(2:490|492)|493|(1:496)|498|499|(0)(0)))|476|477|(0)|481|482|484|485|(0)|488|(0)|493|(0)|498|499|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(21:395|209|(6:214|(1:216)|217|218|219|220)|224|(1:228)|(3:264|265|(18:268|269|270|271|231|(1:234)|235|236|237|238|(1:240)|241|(1:245)|246|(1:249)|251|252|(1:256)))|230|231|(1:234)|235|236|237|238|(0)|241|(2:243|245)|246|(1:249)|251|252|(2:254|256)(1:257)) */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x03c1, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x03d5, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x0399, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x039a, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x0445, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x0459, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x041d, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x041e, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:258:0x0534, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:260:0x0548, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:262:0x050c, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:263:0x050d, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:322:0x0299, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:324:0x02ad, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:325:0x0271, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:326:0x0272, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:375:0x031f, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:377:0x0333, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:378:0x02f7, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:379:0x02f8, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x013a, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x014c, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0112, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:507:0x066c, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:509:0x0680, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0113, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:510:0x0644, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:511:0x0645, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:595:0x00b1, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:597:0x00c3, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:599:0x0089, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:600:0x008a, code lost:
    
        com.uc.crashsdk.a.g.a(r0);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0390 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x03a7  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x03b9 A[Catch: all -> 0x03c1, TryCatch #12 {all -> 0x03c1, blocks: (B:113:0x039d, B:116:0x03a8, B:118:0x03b9, B:120:0x03bd, B:121:0x03c3, B:124:0x03cb), top: B:112:0x039d }] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x03c9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x03e1  */
    /* JADX WARN: Removed duplicated region for block: B:132:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0414 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x042b  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x043d A[Catch: all -> 0x0445, TryCatch #17 {all -> 0x0445, blocks: (B:168:0x0421, B:171:0x042c, B:173:0x043d, B:175:0x0441, B:176:0x0447, B:179:0x044f), top: B:167:0x0421 }] */
    /* JADX WARN: Removed duplicated region for block: B:178:0x044d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0465  */
    /* JADX WARN: Removed duplicated region for block: B:187:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0109 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:216:0x049d A[Catch: all -> 0x03e9, TryCatch #28 {all -> 0x03e9, blocks: (B:209:0x046d, B:212:0x047f, B:214:0x0485, B:216:0x049d, B:217:0x04a0, B:220:0x04bf, B:223:0x04bc, B:99:0x0362, B:219:0x04b7), top: B:90:0x0217, inners: #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0503 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:240:0x051a  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x052c A[Catch: all -> 0x0534, TryCatch #8 {all -> 0x0534, blocks: (B:238:0x0510, B:241:0x051b, B:243:0x052c, B:245:0x0530, B:246:0x0536, B:249:0x053e), top: B:237:0x0510 }] */
    /* JADX WARN: Removed duplicated region for block: B:248:0x053c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0554  */
    /* JADX WARN: Removed duplicated region for block: B:257:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x04e8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:280:0x0219 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0132 A[Catch: all -> 0x013a, TryCatch #9 {all -> 0x013a, blocks: (B:23:0x0116, B:26:0x0121, B:28:0x0132, B:30:0x0136, B:31:0x013c, B:34:0x0144), top: B:22:0x0116 }] */
    /* JADX WARN: Removed duplicated region for block: B:296:0x0268 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:304:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x0291 A[Catch: all -> 0x0299, TryCatch #48 {all -> 0x0299, blocks: (B:302:0x0275, B:305:0x0280, B:307:0x0291, B:309:0x0295, B:310:0x029b, B:313:0x02a3), top: B:301:0x0275 }] */
    /* JADX WARN: Removed duplicated region for block: B:312:0x02a1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:318:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:321:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0142 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:349:0x02ee A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:357:0x0305  */
    /* JADX WARN: Removed duplicated region for block: B:360:0x0317 A[Catch: all -> 0x031f, TryCatch #50 {all -> 0x031f, blocks: (B:355:0x02fb, B:358:0x0306, B:360:0x0317, B:362:0x031b, B:363:0x0321, B:366:0x0329), top: B:354:0x02fb }] */
    /* JADX WARN: Removed duplicated region for block: B:365:0x0327 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:371:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:374:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:411:0x057a A[Catch: all -> 0x058d, TRY_LEAVE, TryCatch #45 {all -> 0x058d, blocks: (B:409:0x0564, B:411:0x057a), top: B:408:0x0564 }] */
    /* JADX WARN: Removed duplicated region for block: B:415:0x0595  */
    /* JADX WARN: Removed duplicated region for block: B:422:0x05b9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:430:0x05d0  */
    /* JADX WARN: Removed duplicated region for block: B:433:0x05e2 A[Catch: all -> 0x05ea, TryCatch #29 {all -> 0x05ea, blocks: (B:428:0x05c6, B:431:0x05d1, B:433:0x05e2, B:435:0x05e6, B:436:0x05ec, B:439:0x05f4), top: B:427:0x05c6 }] */
    /* JADX WARN: Removed duplicated region for block: B:438:0x05f2 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:444:0x060a  */
    /* JADX WARN: Removed duplicated region for block: B:447:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:453:0x059e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:479:0x063b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:487:0x0652  */
    /* JADX WARN: Removed duplicated region for block: B:490:0x0664 A[Catch: all -> 0x066c, TryCatch #30 {all -> 0x066c, blocks: (B:485:0x0648, B:488:0x0653, B:490:0x0664, B:492:0x0668, B:493:0x066e, B:496:0x0676), top: B:484:0x0648 }] */
    /* JADX WARN: Removed duplicated region for block: B:495:0x0674 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:501:0x068c  */
    /* JADX WARN: Removed duplicated region for block: B:506:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:571:0x0080 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:578:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:581:0x00a9 A[Catch: all -> 0x00b1, TryCatch #7 {all -> 0x00b1, blocks: (B:576:0x008d, B:579:0x0098, B:581:0x00a9, B:583:0x00ad, B:584:0x00b3, B:587:0x00bb), top: B:575:0x008d }] */
    /* JADX WARN: Removed duplicated region for block: B:586:0x00b9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:591:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:594:0x0612 A[ADDED_TO_REGION, ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x034b  */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v7, types: [long] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(java.lang.Thread r22, java.lang.Throwable r23, boolean r24) {
        /*
            Method dump skipped, instructions count: 1690
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.e.a(java.lang.Thread, java.lang.Throwable, boolean):void");
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        a(thread, th, false);
    }
}
