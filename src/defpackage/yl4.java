package defpackage;

import com.umeng.commonsdk.framework.UMModuleRegister;
import java.util.Map;

/* loaded from: /tmp/classes2.dex */
public final class yl4 {
    public static final yl4 a = new yl4();
    public static final Map b;
    public static final h c;

    /* loaded from: /tmp/classes2.dex */
    public static final class a extends am4 {
        public static final a c = new a();

        public a() {
            super("inherited", false);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static final class b extends am4 {
        public static final b c = new b();

        public b() {
            super(UMModuleRegister.INNER, false);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static final class c extends am4 {
        public static final c c = new c();

        public c() {
            super("invisible_fake", false);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static final class d extends am4 {
        public static final d c = new d();

        public d() {
            super("local", false);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static final class e extends am4 {
        public static final e c = new e();

        public e() {
            super("private", false);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static final class f extends am4 {
        public static final f c = new f();

        public f() {
            super("private_to_this", false);
        }

        @Override // defpackage.am4
        public String b() {
            return "private/*private to this*/";
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static final class g extends am4 {
        public static final g c = new g();

        public g() {
            super("protected", true);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static final class h extends am4 {
        public static final h c = new h();

        public h() {
            super("public", true);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static final class i extends am4 {
        public static final i c = new i();

        public i() {
            super("unknown", false);
        }
    }

    static {
        Map c2 = sc2.c();
        c2.put(f.c, 0);
        c2.put(e.c, 0);
        c2.put(b.c, 1);
        c2.put(g.c, 1);
        h hVar = h.c;
        c2.put(hVar, 2);
        b = sc2.b(c2);
        c = hVar;
    }

    public final Integer a(am4 am4Var, am4 am4Var2) {
        am4Var.getClass();
        am4Var2.getClass();
        if (am4Var == am4Var2) {
            return 0;
        }
        Map map = b;
        Integer num = (Integer) map.get(am4Var);
        Integer num2 = (Integer) map.get(am4Var2);
        if (num == null || num2 == null || dq1.a(num, num2)) {
            return null;
        }
        return Integer.valueOf(num.intValue() - num2.intValue());
    }

    public final boolean b(am4 am4Var) {
        am4Var.getClass();
        return am4Var == e.c || am4Var == f.c;
    }
}
