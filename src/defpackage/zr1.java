package defpackage;

import java.util.HashMap;
import java.util.Map;

/* loaded from: /tmp/classes2.dex */
public abstract class zr1 {
    public static final pk0 a;
    public static final pk0 b;
    public static final pk0 c;
    public static final Map d;

    /* loaded from: /tmp/classes2.dex */
    public static class a extends lj0 {
        public a(am4 am4Var) {
            super(am4Var);
        }

        private static /* synthetic */ void g(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$1";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // defpackage.pk0
        public boolean e(bc3 bc3Var, ya0 ya0Var, ra0 ra0Var, boolean z) {
            if (ya0Var == null) {
                g(0);
            }
            if (ra0Var == null) {
                g(1);
            }
            return zr1.d(ya0Var, ra0Var);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static class b extends lj0 {
        public b(am4 am4Var) {
            super(am4Var);
        }

        private static /* synthetic */ void g(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$2";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // defpackage.pk0
        public boolean e(bc3 bc3Var, ya0 ya0Var, ra0 ra0Var, boolean z) {
            if (ya0Var == null) {
                g(0);
            }
            if (ra0Var == null) {
                g(1);
            }
            return zr1.e(bc3Var, ya0Var, ra0Var);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static class c extends lj0 {
        public c(am4 am4Var) {
            super(am4Var);
        }

        private static /* synthetic */ void g(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$3";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // defpackage.pk0
        public boolean e(bc3 bc3Var, ya0 ya0Var, ra0 ra0Var, boolean z) {
            if (ya0Var == null) {
                g(0);
            }
            if (ra0Var == null) {
                g(1);
            }
            return zr1.e(bc3Var, ya0Var, ra0Var);
        }
    }

    static {
        a aVar = new a(mt1.c);
        a = aVar;
        b bVar = new b(ot1.c);
        b = bVar;
        c cVar = new c(nt1.c);
        c = cVar;
        d = new HashMap();
        f(aVar);
        f(bVar);
        f(cVar);
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 5 || i == 6) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 5 || i == 6) ? 2 : 3];
        switch (i) {
            case 1:
                objArr[0] = "from";
                break;
            case 2:
                objArr[0] = "first";
                break;
            case 3:
                objArr[0] = "second";
                break;
            case 4:
                objArr[0] = "visibility";
                break;
            case 5:
            case 6:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities";
                break;
            default:
                objArr[0] = "what";
                break;
        }
        if (i == 5 || i == 6) {
            objArr[1] = "toDescriptorVisibility";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities";
        }
        if (i == 2 || i == 3) {
            objArr[2] = "areInSamePackage";
        } else if (i == 4) {
            objArr[2] = "toDescriptorVisibility";
        } else if (i != 5 && i != 6) {
            objArr[2] = "isVisibleForProtectedAndPackage";
        }
        String format = String.format(str, objArr);
        if (i != 5 && i != 6) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    public static boolean d(ra0 ra0Var, ra0 ra0Var2) {
        if (ra0Var == null) {
            a(2);
        }
        if (ra0Var2 == null) {
            a(3);
        }
        kv2 kv2Var = (kv2) lk0.r(ra0Var, kv2.class, false);
        kv2 kv2Var2 = (kv2) lk0.r(ra0Var2, kv2.class, false);
        return (kv2Var2 == null || kv2Var == null || !kv2Var.d().equals(kv2Var2.d())) ? false : true;
    }

    public static boolean e(bc3 bc3Var, ya0 ya0Var, ra0 ra0Var) {
        if (ya0Var == null) {
            a(0);
        }
        if (ra0Var == null) {
            a(1);
        }
        if (d(lk0.M(ya0Var), ra0Var)) {
            return true;
        }
        return ok0.c.e(bc3Var, ya0Var, ra0Var, false);
    }

    public static void f(pk0 pk0Var) {
        d.put(pk0Var.b(), pk0Var);
    }

    public static pk0 g(am4 am4Var) {
        if (am4Var == null) {
            a(4);
        }
        pk0 pk0Var = (pk0) d.get(am4Var);
        if (pk0Var != null) {
            return pk0Var;
        }
        pk0 j = ok0.j(am4Var);
        if (j == null) {
            a(5);
        }
        return j;
    }
}
