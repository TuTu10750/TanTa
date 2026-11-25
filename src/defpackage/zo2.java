package defpackage;

/* loaded from: /tmp/classes2.dex */
public final class zo2 implements Comparable {
    public final String a;
    public final boolean b;

    public zo2(String str, boolean z) {
        if (str == null) {
            a(0);
        }
        this.a = str;
        this.b = z;
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 1 || i == 2 || i == 3 || i == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 1 || i == 2 || i == 3 || i == 4) ? 2 : 3];
        if (i == 1 || i == 2 || i == 3 || i == 4) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/name/Name";
        } else {
            objArr[0] = "name";
        }
        if (i == 1) {
            objArr[1] = "asString";
        } else if (i == 2) {
            objArr[1] = "getIdentifier";
        } else if (i == 3 || i == 4) {
            objArr[1] = "asStringStripSpecialMarkers";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/name/Name";
        }
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
                break;
            case 5:
                objArr[2] = "identifier";
                break;
            case 6:
                objArr[2] = "isValidIdentifier";
                break;
            case 7:
                objArr[2] = "special";
                break;
            case 8:
                objArr[2] = "guessByFirstCharacter";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        if (i != 1 && i != 2 && i != 3 && i != 4) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    public static zo2 h(String str) {
        if (str == null) {
            a(8);
        }
        return str.startsWith("<") ? l(str) : i(str);
    }

    public static zo2 i(String str) {
        if (str == null) {
            a(5);
        }
        return new zo2(str, false);
    }

    public static boolean k(String str) {
        if (str == null) {
            a(6);
        }
        if (str.isEmpty() || str.startsWith("<")) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == '.' || charAt == '/' || charAt == '\\') {
                return false;
            }
        }
        return true;
    }

    public static zo2 l(String str) {
        if (str == null) {
            a(7);
        }
        if (str.startsWith("<")) {
            return new zo2(str, true);
        }
        ik.a("special name must start with '<': ".concat(str));
        return null;
    }

    public String b() {
        String str = this.a;
        if (str == null) {
            a(1);
        }
        return str;
    }

    @Override // java.lang.Comparable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(zo2 zo2Var) {
        return this.a.compareTo(zo2Var.a);
    }

    public String d() {
        if (this.b) {
            hu1.a("not identifier: ", this);
            return null;
        }
        String b = b();
        if (b == null) {
            a(2);
        }
        return b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zo2)) {
            return false;
        }
        zo2 zo2Var = (zo2) obj;
        return this.b == zo2Var.b && this.a.equals(zo2Var.a);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + (this.b ? 1 : 0);
    }

    public boolean j() {
        return this.b;
    }

    public String toString() {
        return this.a;
    }
}
