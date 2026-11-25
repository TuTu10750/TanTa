package defpackage;

import java.util.List;

/* loaded from: /tmp/classes2.dex */
public final class r51 {
    public static final r51 c = new r51("");
    public final s51 a;
    public transient r51 b;

    public r51(String str) {
        if (str == null) {
            a(1);
        }
        this.a = new s51(str, this);
    }

    public r51(s51 s51Var) {
        if (s51Var == null) {
            a(2);
        }
        this.a = s51Var;
    }

    public r51(s51 s51Var, r51 r51Var) {
        if (s51Var == null) {
            a(3);
        }
        this.a = s51Var;
        this.b = r51Var;
    }

    public static /* synthetic */ void a(int i) {
        String str;
        int i2;
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 8:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                i2 = 2;
                break;
            case 8:
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
            case 2:
            case 3:
                objArr[0] = "fqName";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/name/FqName";
                break;
            case 8:
                objArr[0] = "name";
                break;
            case 12:
                objArr[0] = "segment";
                break;
            case 13:
                objArr[0] = "shortName";
                break;
            default:
                objArr[0] = "names";
                break;
        }
        switch (i) {
            case 4:
                objArr[1] = "asString";
                break;
            case 5:
                objArr[1] = "toUnsafe";
                break;
            case 6:
            case 7:
                objArr[1] = "parent";
                break;
            case 8:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/name/FqName";
                break;
            case 9:
                objArr[1] = "shortName";
                break;
            case 10:
                objArr[1] = "shortNameOrSpecial";
                break;
            case 11:
                objArr[1] = "pathSegments";
                break;
        }
        switch (i) {
            case 1:
            case 2:
            case 3:
                objArr[2] = "<init>";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                break;
            case 8:
                objArr[2] = "child";
                break;
            case 12:
                objArr[2] = "startsWith";
                break;
            case 13:
                objArr[2] = "topLevel";
                break;
            default:
                objArr[2] = "fromSegments";
                break;
        }
        String format = String.format(str, objArr);
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                throw new IllegalStateException(format);
            case 8:
            default:
                throw new IllegalArgumentException(format);
        }
    }

    public static r51 k(zo2 zo2Var) {
        if (zo2Var == null) {
            a(13);
        }
        return new r51(s51.m(zo2Var));
    }

    public String b() {
        String b = this.a.b();
        if (b == null) {
            a(4);
        }
        return b;
    }

    public r51 c(zo2 zo2Var) {
        if (zo2Var == null) {
            a(8);
        }
        return new r51(this.a.c(zo2Var), this);
    }

    public boolean d() {
        return this.a.e();
    }

    public r51 e() {
        r51 r51Var = this.b;
        if (r51Var != null) {
            if (r51Var == null) {
                a(6);
            }
            return r51Var;
        }
        if (d()) {
            fl3.a("root");
            return null;
        }
        r51 r51Var2 = new r51(this.a.g());
        this.b = r51Var2;
        return r51Var2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof r51) && this.a.equals(((r51) obj).a);
    }

    public List f() {
        List h = this.a.h();
        if (h == null) {
            a(11);
        }
        return h;
    }

    public zo2 g() {
        zo2 i = this.a.i();
        if (i == null) {
            a(9);
        }
        return i;
    }

    public zo2 h() {
        zo2 j = this.a.j();
        if (j == null) {
            a(10);
        }
        return j;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public boolean i(zo2 zo2Var) {
        if (zo2Var == null) {
            a(12);
        }
        return this.a.k(zo2Var);
    }

    public s51 j() {
        s51 s51Var = this.a;
        if (s51Var == null) {
            a(5);
        }
        return s51Var;
    }

    public String toString() {
        return this.a.toString();
    }
}
