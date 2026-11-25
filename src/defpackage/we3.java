package defpackage;

import java.util.Iterator;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public abstract class we3 {
    public static final String a(s51 s51Var) {
        s51Var.getClass();
        List h = s51Var.h();
        h.getClass();
        return c(h);
    }

    public static final String b(zo2 zo2Var) {
        zo2Var.getClass();
        boolean e = e(zo2Var);
        String b = zo2Var.b();
        b.getClass();
        if (!e) {
            return b;
        }
        return ("`" + b).concat("`");
    }

    public static final String c(List list) {
        list.getClass();
        StringBuilder sb = new StringBuilder();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zo2 zo2Var = (zo2) it.next();
            if (sb.length() > 0) {
                sb.append(".");
            }
            sb.append(b(zo2Var));
        }
        return sb.toString();
    }

    public static final String d(String str, String str2, String str3, String str4, String str5) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        str4.getClass();
        str5.getClass();
        if (fw3.J(str, str2, false, 2, null) && fw3.J(str3, str4, false, 2, null)) {
            String substring = str.substring(str2.length());
            String substring2 = str3.substring(str4.length());
            String str6 = str5 + substring;
            if (dq1.a(substring, substring2)) {
                return str6;
            }
            if (f(substring, substring2)) {
                return str6.concat("!");
            }
        }
        return null;
    }

    public static final boolean e(zo2 zo2Var) {
        String b = zo2Var.b();
        b.getClass();
        if (yw1.a.contains(b)) {
            return true;
        }
        for (int i = 0; i < b.length(); i++) {
            char charAt = b.charAt(i);
            if (!Character.isLetterOrDigit(charAt) && charAt != '_') {
                return true;
            }
        }
        return false;
    }

    public static final boolean f(String str, String str2) {
        str.getClass();
        str2.getClass();
        if (dq1.a(str, fw3.F(str2, "?", "", false, 4, null))) {
            return true;
        }
        if (fw3.w(str2, "?", false, 2, null)) {
            if (dq1.a(str + '?', str2)) {
                return true;
            }
        }
        StringBuilder sb = new StringBuilder("(");
        sb.append(str);
        sb.append(")?");
        return dq1.a(sb.toString(), str2);
    }
}
