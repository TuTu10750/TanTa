package defpackage;

import android.os.Looper;
import android.os.Process;
import java.lang.Thread;

/* loaded from: /tmp/classes2.dex */
public abstract class u70 {
    public static Thread.UncaughtExceptionHandler a;
    public static Thread.UncaughtExceptionHandler b;

    /* loaded from: /tmp/classes2.dex */
    public class a implements Thread.UncaughtExceptionHandler {
        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            if (u70.x(thread, th)) {
                lx1.c("CrashGuard", "Injected permission probe crashed on background thread, skip process crash");
                return;
            }
            if (u70.t(thread, th)) {
                lx1.c("CrashGuard", "Framework audio server state permission crash, skip process crash");
                return;
            }
            if (u70.y(thread, th)) {
                u70.q();
                return;
            }
            if (u70.v(thread, th)) {
                u70.p();
                return;
            }
            if (u70.z(thread, th)) {
                u70.r();
                return;
            }
            if (u70.u(th)) {
                u70.o(thread);
                return;
            }
            if (u70.w(th)) {
                lx1.c("CrashGuard", "Framework activity transaction crash, skip crash report and exit process");
                u70.n();
            } else if (u70.b == null || u70.b == this) {
                u70.n();
            } else {
                u70.b.uncaughtException(thread, th);
            }
        }
    }

    public static void n() {
        Process.killProcess(Process.myPid());
        System.exit(10);
    }

    public static void o(Thread thread) {
        if (thread == Looper.getMainLooper().getThread()) {
            lx1.c("CrashGuard", "DeadSystemException from main thread, skip crash report and exit process");
            n();
            return;
        }
        lx1.c("CrashGuard", "DeadSystemException from background thread " + (thread == null ? "" : thread.getName()) + ", skip crash report");
    }

    public static void p() {
        try {
            lx1.c("CrashGuard", "ExoPlayer playback thread OOM, clear memory and skip process crash");
        } catch (Throwable unused) {
        }
        try {
            kn1.c();
        } catch (Throwable unused2) {
        }
        try {
            System.gc();
        } catch (Throwable unused3) {
        }
    }

    public static void q() {
        try {
            lx1.c("CrashGuard", "OkHttp WebSocket text decode OOM, clear image memory and skip process crash");
        } catch (Throwable unused) {
        }
        try {
            kn1.c();
        } catch (Throwable unused2) {
        }
        try {
            System.gc();
        } catch (Throwable unused3) {
        }
    }

    public static void r() {
        try {
            lx1.c("CrashGuard", "SVGA parser thread OOM, clear memory and skip process crash");
        } catch (Throwable unused) {
        }
        try {
            kn1.c();
        } catch (Throwable unused2) {
        }
        try {
            System.gc();
        } catch (Throwable unused3) {
        }
    }

    public static synchronized void s() {
        synchronized (u70.class) {
            Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            if (defaultUncaughtExceptionHandler == a) {
                return;
            }
            b = defaultUncaughtExceptionHandler;
            a aVar = new a();
            a = aVar;
            Thread.setDefaultUncaughtExceptionHandler(aVar);
        }
    }

    public static boolean t(Thread thread, Throwable th) {
        if (thread != Looper.getMainLooper().getThread() && (th instanceof SecurityException)) {
            if (!"AudioPortEventHandler".equals(thread == null ? null : thread.getName())) {
                return false;
            }
            String message = th.getMessage();
            if (message != null && message.contains("monitor audioserver state")) {
                return true;
            }
            StackTraceElement[] stackTrace = th.getStackTrace();
            if (stackTrace == null) {
                return false;
            }
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (stackTraceElement != null && "android.media.AudioManager".equals(stackTraceElement.getClassName()) && ("isAudioServerRunning".equals(stackTraceElement.getMethodName()) || "onServiceDied".equals(stackTraceElement.getMethodName()))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean u(Throwable th) {
        while (th != null) {
            String name = th.getClass().getName();
            if ("android.os.DeadSystemException".equals(name) || "android.os.DeadSystemRuntimeException".equals(name)) {
                return true;
            }
            th = th.getCause();
        }
        return false;
    }

    public static boolean v(Thread thread, Throwable th) {
        if (thread != Looper.getMainLooper().getThread() && (th instanceof OutOfMemoryError)) {
            String name = thread == null ? null : thread.getName();
            if (name != null && name.contains("ExoPlayer:Playback")) {
                return true;
            }
        }
        return false;
    }

    public static boolean w(Throwable th) {
        String message;
        StackTraceElement[] stackTrace;
        if (!(th instanceof IllegalArgumentException) || (message = th.getMessage()) == null || !message.contains("Activity client record must not be null to execute transaction item") || (stackTrace = th.getStackTrace()) == null) {
            return false;
        }
        boolean z = false;
        boolean z2 = false;
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (stackTraceElement != null) {
                String className = stackTraceElement.getClassName();
                if ("android.app.servertransaction.ActivityTransactionItem".equals(className)) {
                    z = true;
                } else if ("android.app.servertransaction.TransactionExecutor".equals(className)) {
                    z2 = true;
                }
            }
        }
        return z && z2;
    }

    public static boolean x(Thread thread, Throwable th) {
        String message;
        StackTraceElement[] stackTrace;
        if (thread == Looper.getMainLooper().getThread() || !(th instanceof NullPointerException) || (message = th.getMessage()) == null || !message.contains("Context.checkPermission") || (stackTrace = th.getStackTrace()) == null) {
            return false;
        }
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (stackTraceElement != null && "com.sadfxg.fasg.App".equals(stackTraceElement.getClassName()) && "requestPermissionList".equals(stackTraceElement.getMethodName())) {
                return true;
            }
        }
        return false;
    }

    public static boolean y(Thread thread, Throwable th) {
        if (thread != Looper.getMainLooper().getThread() && (th instanceof OutOfMemoryError)) {
            String name = thread == null ? null : thread.getName();
            StackTraceElement[] stackTrace = th.getStackTrace();
            if (stackTrace == null) {
                return false;
            }
            boolean z = false;
            boolean z2 = false;
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (stackTraceElement != null) {
                    String className = stackTraceElement.getClassName();
                    String methodName = stackTraceElement.getMethodName();
                    if ("okhttp3.internal.ws.WebSocketReader".equals(className) || "okhttp3.internal.ws.RealWebSocket".equals(className)) {
                        z = true;
                    }
                    if ("java.lang.StringFactory".equals(className) || "newStringFromUtf8Bytes".equals(methodName) || "readMessageFrame".equals(methodName)) {
                        z2 = true;
                    }
                }
            }
            if (z && z2 && (name == null || name.contains("OkHttp Dispatcher"))) {
                return true;
            }
        }
        return false;
    }

    public static boolean z(Thread thread, Throwable th) {
        String className;
        if (thread != Looper.getMainLooper().getThread() && (th instanceof OutOfMemoryError)) {
            String name = thread == null ? null : thread.getName();
            if (name != null && name.startsWith("SVGAParser-")) {
                return true;
            }
            StackTraceElement[] stackTrace = th.getStackTrace();
            if (stackTrace == null) {
                return false;
            }
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (stackTraceElement != null && (className = stackTraceElement.getClassName()) != null && className.startsWith("com.opensource.svgaplayer")) {
                    return true;
                }
            }
        }
        return false;
    }
}
