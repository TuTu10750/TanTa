package defpackage;

/* loaded from: /tmp/classes2.dex */
public class xu1 {
    public final String a;
    public r51 b;

    public xu1(String str) {
        if (str == null) {
            a(5);
        }
        this.a = str;
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 3 || i == 6 || i == 7 || i == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 3 || i == 6 || i == 7 || i == 8) ? 2 : 3];
        switch (i) {
            case 1:
                objArr[0] = "classId";
                break;
            case 2:
            case 4:
                objArr[0] = "fqName";
                break;
            case 3:
            case 6:
            case 7:
            case 8:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmClassName";
                break;
            case 5:
            default:
                objArr[0] = "internalName";
                break;
        }
        if (i == 3) {
            objArr[1] = "byFqNameWithoutInnerClasses";
        } else if (i == 6) {
            objArr[1] = "getFqNameForClassNameWithoutDollars";
        } else if (i == 7) {
            objArr[1] = "getPackageFqName";
        } else if (i != 8) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmClassName";
        } else {
            objArr[1] = "getInternalName";
        }
        switch (i) {
            case 1:
                objArr[2] = "byClassId";
                break;
            case 2:
            case 4:
                objArr[2] = "byFqNameWithoutInnerClasses";
                break;
            case 3:
            case 6:
            case 7:
            case 8:
                break;
            case 5:
                objArr[2] = "<init>";
                break;
            default:
                objArr[2] = "byInternalName";
                break;
        }
        String format = String.format(str, objArr);
        if (i != 3 && i != 6 && i != 7 && i != 8) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    public static xu1 b(q00 q00Var) {
        if (q00Var == null) {
            a(1);
        }
        r51 h = q00Var.h();
        String replace = q00Var.i().b().replace('.', '$');
        if (h.d()) {
            return new xu1(replace);
        }
        return new xu1(h.b().replace('.', '/') + "/" + replace);
    }

    public static xu1 c(r51 r51Var) {
        if (r51Var == null) {
            a(2);
        }
        xu1 xu1Var = new xu1(r51Var.b().replace('.', '/'));
        xu1Var.b = r51Var;
        return xu1Var;
    }

    public static xu1 d(String str) {
        if (str == null) {
            a(0);
        }
        return new xu1(str);
    }

    public r51 e() {
        return new r51(this.a.replace('/', '.'));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.a.equals(((xu1) obj).a);
    }

    public String f() {
        String str = this.a;
        if (str == null) {
            a(8);
        }
        return str;
    }

    public r51 g() {
        int lastIndexOf = this.a.lastIndexOf("/");
        if (lastIndexOf != -1) {
            return new r51(this.a.substring(0, lastIndexOf).replace('/', '.'));
        }
        r51 r51Var = r51.c;
        if (r51Var == null) {
            a(7);
        }
        return r51Var;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return this.a;
    }
}
