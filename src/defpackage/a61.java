package defpackage;

import java.util.List;

/* loaded from: /tmp/classes2.dex */
public abstract class a61 {
    public static k03 a(List list, int i) {
        k03 k03Var;
        if (i >= 0 && i <= list.size() - 1) {
            return (k03) list.get(i);
        }
        k03 k03Var2 = new k03();
        if (i < 0) {
            k03Var = (k03) list.get(0);
        } else {
            i = (i - list.size()) + 1;
            k03Var = (k03) list.get(list.size() - 1);
        }
        k03Var2.a = k03Var.a + (k03Var.b() * i);
        k03Var2.b = k03Var.b;
        k03Var2.c = k03Var.c + (k03Var.b() * i);
        k03Var2.d = k03Var.d;
        k03Var2.e = k03Var.e + (k03Var.b() * i);
        k03Var2.f = k03Var.f;
        k03Var2.g = k03Var.g + (i * k03Var.b());
        k03Var2.h = k03Var.h;
        return k03Var2;
    }
}
