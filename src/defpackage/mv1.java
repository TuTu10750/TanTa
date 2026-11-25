package defpackage;

import defpackage.kv1;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* loaded from: /tmp/classes2.dex */
public final class mv1 implements lv1 {
    public static final mv1 a = new mv1();

    /* loaded from: /tmp/classes2.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[PrimitiveType.values().length];
            try {
                iArr[PrimitiveType.BOOLEAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PrimitiveType.CHAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PrimitiveType.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PrimitiveType.SHORT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PrimitiveType.INT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PrimitiveType.FLOAT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[PrimitiveType.LONG.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[PrimitiveType.DOUBLE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            a = iArr;
        }
    }

    @Override // defpackage.lv1
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public kv1 d(kv1 kv1Var) {
        kv1Var.getClass();
        if (kv1Var instanceof kv1.d) {
            kv1.d dVar = (kv1.d) kv1Var;
            if (dVar.i() != null) {
                String f = xu1.c(dVar.i().j()).f();
                f.getClass();
                return c(f);
            }
        }
        return kv1Var;
    }

    @Override // defpackage.lv1
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public kv1 b(String str) {
        JvmPrimitiveType jvmPrimitiveType;
        str.getClass();
        str.length();
        char charAt = str.charAt(0);
        JvmPrimitiveType[] values = JvmPrimitiveType.values();
        int length = values.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                jvmPrimitiveType = null;
                break;
            }
            jvmPrimitiveType = values[i];
            if (jvmPrimitiveType.d().charAt(0) == charAt) {
                break;
            }
            i++;
        }
        if (jvmPrimitiveType != null) {
            return new kv1.d(jvmPrimitiveType);
        }
        if (charAt == 'V') {
            return new kv1.d(null);
        }
        if (charAt == '[') {
            return new kv1.a(b(str.substring(1)));
        }
        if (charAt == 'L') {
            hw3.R(str, ';', false, 2, null);
        }
        return new kv1.c(str.substring(1, str.length() - 1));
    }

    @Override // defpackage.lv1
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public kv1.c c(String str) {
        str.getClass();
        return new kv1.c(str);
    }

    @Override // defpackage.lv1
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public kv1 f(PrimitiveType primitiveType) {
        primitiveType.getClass();
        switch (a.a[primitiveType.ordinal()]) {
            case 1:
                return kv1.a.a();
            case 2:
                return kv1.a.c();
            case 3:
                return kv1.a.b();
            case 4:
                return kv1.a.h();
            case 5:
                return kv1.a.f();
            case 6:
                return kv1.a.e();
            case 7:
                return kv1.a.g();
            case 8:
                return kv1.a.d();
            default:
                u.a();
                return null;
        }
    }

    @Override // defpackage.lv1
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public kv1 e() {
        return c("java/lang/Class");
    }

    @Override // defpackage.lv1
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public String a(kv1 kv1Var) {
        String d;
        kv1Var.getClass();
        if (kv1Var instanceof kv1.a) {
            return "[" + a(((kv1.a) kv1Var).i());
        }
        if (kv1Var instanceof kv1.d) {
            JvmPrimitiveType i = ((kv1.d) kv1Var).i();
            return (i == null || (d = i.d()) == null) ? "V" : d;
        }
        if (!(kv1Var instanceof kv1.c)) {
            u.a();
            return null;
        }
        return "L" + ((kv1.c) kv1Var).i() + ';';
    }
}
