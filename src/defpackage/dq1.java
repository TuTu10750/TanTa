package defpackage;

import java.util.Arrays;
import kotlin.KotlinNullPointerException;
import kotlin.UninitializedPropertyAccessException;

/* loaded from: /tmp/classes2.dex */
public abstract class dq1 {

    /* loaded from: /tmp/classes2.dex */
    public static class a {
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static int b(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    public static void c(int i, String str) {
        h();
    }

    public static Throwable d(Throwable th) {
        return e(th, dq1.class.getName());
    }

    public static Throwable e(Throwable th, String str) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(stackTrace[i2].getClassName())) {
                i = i2;
            }
        }
        th.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i + 1, length));
        return th;
    }

    public static String f(String str, Object obj) {
        return str + obj;
    }

    public static void g() {
        throw ((KotlinNullPointerException) d(new KotlinNullPointerException()));
    }

    public static void h() {
        i("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    public static void i(String str) {
        throw new UnsupportedOperationException(str);
    }

    public static void j(String str) {
        throw ((UninitializedPropertyAccessException) d(new UninitializedPropertyAccessException(str)));
    }

    public static void k(String str) {
        j("lateinit property " + str + " has not been initialized");
    }
}
