package defpackage;

import java.lang.annotation.Annotation;

/* loaded from: /tmp/classes2.dex */
public abstract class wu1 {
    public static final rv1 a(Annotation annotation) {
        annotation.getClass();
        Class<? extends Annotation> annotationType = annotation.annotationType();
        annotationType.getClass();
        rv1 e = e(annotationType);
        e.getClass();
        return e;
    }

    public static final Class b(rv1 rv1Var) {
        rv1Var.getClass();
        Class c = ((i00) rv1Var).c();
        c.getClass();
        return c;
    }

    public static final Class c(rv1 rv1Var) {
        rv1Var.getClass();
        Class c = ((i00) rv1Var).c();
        if (!c.isPrimitive()) {
            return c;
        }
        String name = c.getName();
        switch (name.hashCode()) {
            case -1325958191:
                return !name.equals("double") ? c : Double.class;
            case 104431:
                return !name.equals("int") ? c : Integer.class;
            case 3039496:
                return !name.equals("byte") ? c : Byte.class;
            case 3052374:
                return !name.equals("char") ? c : Character.class;
            case 3327612:
                return !name.equals("long") ? c : Long.class;
            case 3625364:
                return !name.equals("void") ? c : Void.class;
            case 64711720:
                return !name.equals("boolean") ? c : Boolean.class;
            case 97526364:
                return !name.equals("float") ? c : Float.class;
            case 109413500:
                return !name.equals("short") ? c : Short.class;
            default:
                return c;
        }
    }

    public static final Class d(rv1 rv1Var) {
        rv1Var.getClass();
        Class c = ((i00) rv1Var).c();
        if (c.isPrimitive()) {
            return c;
        }
        String name = c.getName();
        switch (name.hashCode()) {
            case -2056817302:
                if (name.equals("java.lang.Integer")) {
                    return Integer.TYPE;
                }
                return null;
            case -527879800:
                if (name.equals("java.lang.Float")) {
                    return Float.TYPE;
                }
                return null;
            case -515992664:
                if (name.equals("java.lang.Short")) {
                    return Short.TYPE;
                }
                return null;
            case 155276373:
                if (name.equals("java.lang.Character")) {
                    return Character.TYPE;
                }
                return null;
            case 344809556:
                if (name.equals("java.lang.Boolean")) {
                    return Boolean.TYPE;
                }
                return null;
            case 398507100:
                if (name.equals("java.lang.Byte")) {
                    return Byte.TYPE;
                }
                return null;
            case 398795216:
                if (name.equals("java.lang.Long")) {
                    return Long.TYPE;
                }
                return null;
            case 399092968:
                if (name.equals("java.lang.Void")) {
                    return Void.TYPE;
                }
                return null;
            case 761287205:
                if (name.equals("java.lang.Double")) {
                    return Double.TYPE;
                }
                return null;
            default:
                return null;
        }
    }

    public static final rv1 e(Class cls) {
        cls.getClass();
        return zd3.b(cls);
    }
}
