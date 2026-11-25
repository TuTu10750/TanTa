package defpackage;

import defpackage.ps1;
import kotlin.Pair;
import kotlin.collections.a;
import kotlin.reflect.jvm.internal.impl.load.java.Jsr305Settings;
import kotlin.reflect.jvm.internal.impl.load.java.NullabilityAnnotationStatesImpl;
import kotlin.reflect.jvm.internal.impl.load.java.ReportLevel;

/* loaded from: /tmp/classes2.dex */
public abstract class os1 {
    public static final r51 a;
    public static final r51 b;
    public static final r51 c;
    public static final r51 d;
    public static final String e;
    public static final r51[] f;
    public static final nr2 g;
    public static final ps1 h;

    static {
        r51 r51Var = new r51("org.jspecify.nullness");
        a = r51Var;
        r51 r51Var2 = new r51("org.jspecify.annotations");
        b = r51Var2;
        r51 r51Var3 = new r51("io.reactivex.rxjava3.annotations");
        c = r51Var3;
        r51 r51Var4 = new r51("org.checkerframework.checker.nullness.compatqual");
        d = r51Var4;
        String b2 = r51Var3.b();
        b2.getClass();
        e = b2;
        f = new r51[]{new r51(b2 + ".Nullable"), new r51(b2 + ".NonNull")};
        r51 r51Var5 = new r51("org.jetbrains.annotations");
        ps1.a aVar = ps1.d;
        Pair a2 = g94.a(r51Var5, aVar.a());
        Pair a3 = g94.a(new r51("androidx.annotation"), aVar.a());
        Pair a4 = g94.a(new r51("android.support.annotation"), aVar.a());
        Pair a5 = g94.a(new r51("android.annotation"), aVar.a());
        Pair a6 = g94.a(new r51("com.android.annotations"), aVar.a());
        Pair a7 = g94.a(new r51("org.eclipse.jdt.annotation"), aVar.a());
        Pair a8 = g94.a(new r51("org.checkerframework.checker.nullness.qual"), aVar.a());
        Pair a9 = g94.a(r51Var4, aVar.a());
        Pair a10 = g94.a(new r51("javax.annotation"), aVar.a());
        Pair a11 = g94.a(new r51("edu.umd.cs.findbugs.annotations"), aVar.a());
        Pair a12 = g94.a(new r51("io.reactivex.annotations"), aVar.a());
        r51 r51Var6 = new r51("androidx.annotation.RecentlyNullable");
        ReportLevel reportLevel = ReportLevel.WARN;
        Pair a13 = g94.a(r51Var6, new ps1(reportLevel, null, null, 4, null));
        Pair a14 = g94.a(new r51("androidx.annotation.RecentlyNonNull"), new ps1(reportLevel, null, null, 4, null));
        Pair a15 = g94.a(new r51("lombok"), aVar.a());
        jx1 jx1Var = new jx1(1, 9);
        ReportLevel reportLevel2 = ReportLevel.STRICT;
        g = new NullabilityAnnotationStatesImpl(a.l(a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, g94.a(r51Var, new ps1(reportLevel, jx1Var, reportLevel2)), g94.a(r51Var2, new ps1(reportLevel, new jx1(1, 9), reportLevel2)), g94.a(r51Var3, new ps1(reportLevel, new jx1(1, 8), reportLevel2))));
        h = new ps1(reportLevel, null, null, 4, null);
    }

    public static final Jsr305Settings a(jx1 jx1Var) {
        jx1Var.getClass();
        ps1 ps1Var = h;
        ReportLevel c2 = (ps1Var.d() == null || ps1Var.d().compareTo(jx1Var) > 0) ? ps1Var.c() : ps1Var.b();
        return new Jsr305Settings(c2, c(c2), null, 4, null);
    }

    public static /* synthetic */ Jsr305Settings b(jx1 jx1Var, int i, Object obj) {
        if ((i & 1) != 0) {
            jx1Var = jx1.f;
        }
        return a(jx1Var);
    }

    public static final ReportLevel c(ReportLevel reportLevel) {
        reportLevel.getClass();
        if (reportLevel == ReportLevel.WARN) {
            return null;
        }
        return reportLevel;
    }

    public static final ReportLevel d(r51 r51Var) {
        r51Var.getClass();
        return h(r51Var, nr2.a.a(), null, 4, null);
    }

    public static final r51 e() {
        return b;
    }

    public static final r51[] f() {
        return f;
    }

    public static final ReportLevel g(r51 r51Var, nr2 nr2Var, jx1 jx1Var) {
        r51Var.getClass();
        nr2Var.getClass();
        jx1Var.getClass();
        ReportLevel reportLevel = (ReportLevel) nr2Var.a(r51Var);
        if (reportLevel != null) {
            return reportLevel;
        }
        ps1 ps1Var = (ps1) g.a(r51Var);
        return ps1Var == null ? ReportLevel.IGNORE : (ps1Var.d() == null || ps1Var.d().compareTo(jx1Var) > 0) ? ps1Var.c() : ps1Var.b();
    }

    public static /* synthetic */ ReportLevel h(r51 r51Var, nr2 nr2Var, jx1 jx1Var, int i, Object obj) {
        if ((i & 4) != 0) {
            jx1Var = new jx1(1, 7, 20);
        }
        return g(r51Var, nr2Var, jx1Var);
    }
}
