package defpackage;

import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

/* loaded from: /tmp/classes2.dex */
public final class s51 {
    public static final zo2 e = zo2.l("<root>");
    public static final Pattern f = Pattern.compile("\\.");
    public static final n81 g = new a();
    public final String a;
    public transient r51 b;
    public transient s51 c;
    public transient zo2 d;

    /* loaded from: /tmp/classes2.dex */
    public static class a implements n81 {
        @Override // defpackage.n81
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public zo2 invoke(String str) {
            return zo2.h(str);
        }
    }

    public s51(String str) {
        if (str == null) {
            a(2);
        }
        this.a = str;
    }

    public s51(String str, r51 r51Var) {
        if (str == null) {
            a(0);
        }
        if (r51Var == null) {
            a(1);
        }
        this.a = str;
        this.b = r51Var;
    }

    public s51(String str, s51 s51Var, zo2 zo2Var) {
        if (str == null) {
            a(3);
        }
        this.a = str;
        this.c = s51Var;
        this.d = zo2Var;
    }

    public static /* synthetic */ void a(int i) {
        String str;
        int i2;
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 9:
            case 15:
            case 16:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                i2 = 2;
                break;
            case 9:
            case 15:
            case 16:
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        if (i != 1) {
            switch (i) {
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 17:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe";
                    break;
                case 9:
                    objArr[0] = "name";
                    break;
                case 15:
                    objArr[0] = "segment";
                    break;
                case 16:
                    objArr[0] = "shortName";
                    break;
                default:
                    objArr[0] = "fqName";
                    break;
            }
        } else {
            objArr[0] = "safe";
        }
        switch (i) {
            case 4:
                objArr[1] = "asString";
                break;
            case 5:
            case 6:
                objArr[1] = "toSafe";
                break;
            case 7:
            case 8:
                objArr[1] = "parent";
                break;
            case 9:
            case 15:
            case 16:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe";
                break;
            case 10:
            case 11:
                objArr[1] = "shortName";
                break;
            case 12:
            case 13:
                objArr[1] = "shortNameOrSpecial";
                break;
            case 14:
                objArr[1] = "pathSegments";
                break;
            case 17:
                objArr[1] = "toString";
                break;
        }
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                break;
            case 9:
                objArr[2] = "child";
                break;
            case 15:
                objArr[2] = "startsWith";
                break;
            case 16:
                objArr[2] = "topLevel";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                throw new IllegalStateException(format);
            case 9:
            case 15:
            case 16:
            default:
                throw new IllegalArgumentException(format);
        }
    }

    public static s51 m(zo2 zo2Var) {
        if (zo2Var == null) {
            a(16);
        }
        return new s51(zo2Var.b(), r51.c.j(), zo2Var);
    }

    public String b() {
        String str = this.a;
        if (str == null) {
            a(4);
        }
        return str;
    }

    public s51 c(zo2 zo2Var) {
        String str;
        if (zo2Var == null) {
            a(9);
        }
        if (e()) {
            str = zo2Var.b();
        } else {
            str = this.a + "." + zo2Var.b();
        }
        return new s51(str, this, zo2Var);
    }

    public final void d() {
        int lastIndexOf = this.a.lastIndexOf(46);
        String str = this.a;
        if (lastIndexOf >= 0) {
            this.d = zo2.h(str.substring(lastIndexOf + 1));
            this.c = new s51(this.a.substring(0, lastIndexOf));
        } else {
            this.d = zo2.h(str);
            this.c = r51.c.j();
        }
    }

    public boolean e() {
        return this.a.isEmpty();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof s51) && this.a.equals(((s51) obj).a);
    }

    public boolean f() {
        return this.b != null || b().indexOf(60) < 0;
    }

    public s51 g() {
        s51 s51Var = this.c;
        if (s51Var != null) {
            if (s51Var == null) {
                a(7);
            }
            return s51Var;
        }
        if (e()) {
            fl3.a("root");
            return null;
        }
        d();
        s51 s51Var2 = this.c;
        if (s51Var2 == null) {
            a(8);
        }
        return s51Var2;
    }

    public List h() {
        List U = e() ? Collections.EMPTY_LIST : rb.U(f.split(this.a), g);
        if (U == null) {
            a(14);
        }
        return U;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public zo2 i() {
        zo2 zo2Var = this.d;
        if (zo2Var != null) {
            if (zo2Var == null) {
                a(10);
            }
            return zo2Var;
        }
        if (e()) {
            fl3.a("root");
            return null;
        }
        d();
        zo2 zo2Var2 = this.d;
        if (zo2Var2 == null) {
            a(11);
        }
        return zo2Var2;
    }

    public zo2 j() {
        if (e()) {
            zo2 zo2Var = e;
            if (zo2Var == null) {
                a(12);
            }
            return zo2Var;
        }
        zo2 i = i();
        if (i == null) {
            a(13);
        }
        return i;
    }

    public boolean k(zo2 zo2Var) {
        if (zo2Var == null) {
            a(15);
        }
        if (e()) {
            return false;
        }
        int indexOf = this.a.indexOf(46);
        String b = zo2Var.b();
        String str = this.a;
        if (indexOf == -1) {
            indexOf = Math.max(str.length(), b.length());
        }
        return str.regionMatches(0, b, 0, indexOf);
    }

    public r51 l() {
        r51 r51Var = this.b;
        if (r51Var != null) {
            if (r51Var == null) {
                a(5);
            }
            return r51Var;
        }
        r51 r51Var2 = new r51(this);
        this.b = r51Var2;
        return r51Var2;
    }

    public String toString() {
        String b = e() ? e.b() : this.a;
        if (b == null) {
            a(17);
        }
        return b;
    }
}
