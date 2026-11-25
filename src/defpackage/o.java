package defpackage;

import java.util.ArrayList;
import okio.ByteString;

/* loaded from: /tmp/classes2.dex */
public abstract class o {
    public static final ByteString a;
    public static final ByteString b;
    public static final ByteString c;
    public static final ByteString d;
    public static final ByteString e;

    static {
        ByteString.Companion companion = ByteString.INSTANCE;
        a = companion.d("/");
        b = companion.d("\\");
        c = companion.d("/\\");
        d = companion.d(".");
        e = companion.d("..");
    }

    public static final uw2 j(uw2 uw2Var, uw2 uw2Var2, boolean z) {
        uw2Var.getClass();
        uw2Var2.getClass();
        if (uw2Var2.isAbsolute() || uw2Var2.p() != null) {
            return uw2Var2;
        }
        ByteString m = m(uw2Var);
        if (m == null && (m = m(uw2Var2)) == null) {
            m = s(uw2.c);
        }
        lk lkVar = new lk();
        lkVar.l0(uw2Var.b());
        if (lkVar.size() > 0) {
            lkVar.l0(m);
        }
        lkVar.l0(uw2Var2.b());
        return q(lkVar, z);
    }

    public static final uw2 k(String str, boolean z) {
        str.getClass();
        return q(new lk().O(str), z);
    }

    public static final int l(uw2 uw2Var) {
        int x = ByteString.x(uw2Var.b(), a, 0, 2, null);
        return x != -1 ? x : ByteString.x(uw2Var.b(), b, 0, 2, null);
    }

    public static final ByteString m(uw2 uw2Var) {
        ByteString b2 = uw2Var.b();
        ByteString byteString = a;
        if (ByteString.q(b2, byteString, 0, 2, null) != -1) {
            return byteString;
        }
        ByteString b3 = uw2Var.b();
        ByteString byteString2 = b;
        if (ByteString.q(b3, byteString2, 0, 2, null) != -1) {
            return byteString2;
        }
        return null;
    }

    public static final boolean n(uw2 uw2Var) {
        return uw2Var.b().h(e) && (uw2Var.b().G() == 2 || uw2Var.b().A(uw2Var.b().G() + (-3), a, 0, 1) || uw2Var.b().A(uw2Var.b().G() + (-3), b, 0, 1));
    }

    public static final int o(uw2 uw2Var) {
        if (uw2Var.b().G() == 0) {
            return -1;
        }
        if (uw2Var.b().i(0) == 47) {
            return 1;
        }
        if (uw2Var.b().i(0) == 92) {
            if (uw2Var.b().G() <= 2 || uw2Var.b().i(1) != 92) {
                return 1;
            }
            int o = uw2Var.b().o(b, 2);
            return o == -1 ? uw2Var.b().G() : o;
        }
        if (uw2Var.b().G() > 2 && uw2Var.b().i(1) == 58 && uw2Var.b().i(2) == 92) {
            char i = (char) uw2Var.b().i(0);
            if ('a' <= i && i < '{') {
                return 3;
            }
            if ('A' <= i && i < '[') {
                return 3;
            }
        }
        return -1;
    }

    public static final boolean p(lk lkVar, ByteString byteString) {
        if (!dq1.a(byteString, b) || lkVar.size() < 2 || lkVar.q0(1L) != 58) {
            return false;
        }
        char q0 = (char) lkVar.q0(0L);
        if ('a' > q0 || q0 >= '{') {
            return 'A' <= q0 && q0 < '[';
        }
        return true;
    }

    public static final uw2 q(lk lkVar, boolean z) {
        ByteString byteString;
        ByteString h;
        lkVar.getClass();
        lk lkVar2 = new lk();
        ByteString byteString2 = null;
        int i = 0;
        while (true) {
            if (!lkVar.R(0L, a)) {
                byteString = b;
                if (!lkVar.R(0L, byteString)) {
                    break;
                }
            }
            byte readByte = lkVar.readByte();
            if (byteString2 == null) {
                byteString2 = r(readByte);
            }
            i++;
        }
        boolean z2 = i >= 2 && dq1.a(byteString2, byteString);
        if (z2) {
            byteString2.getClass();
            lkVar2.l0(byteString2);
            lkVar2.l0(byteString2);
        } else if (i > 0) {
            byteString2.getClass();
            lkVar2.l0(byteString2);
        } else {
            long D = lkVar.D(c);
            if (byteString2 == null) {
                byteString2 = D == -1 ? s(uw2.c) : r(lkVar.q0(D));
            }
            if (p(lkVar, byteString2)) {
                if (D == 2) {
                    lkVar2.write(lkVar, 3L);
                } else {
                    lkVar2.write(lkVar, 2L);
                }
            }
        }
        boolean z3 = lkVar2.size() > 0;
        ArrayList arrayList = new ArrayList();
        while (!lkVar.B()) {
            long D2 = lkVar.D(c);
            if (D2 == -1) {
                h = lkVar.Z();
            } else {
                h = lkVar.h(D2);
                lkVar.readByte();
            }
            ByteString byteString3 = e;
            if (dq1.a(h, byteString3)) {
                if (!z3 || !arrayList.isEmpty()) {
                    if (!z || (!z3 && (arrayList.isEmpty() || dq1.a(b30.m0(arrayList), byteString3)))) {
                        arrayList.add(h);
                    } else if (!z2 || arrayList.size() != 1) {
                        x20.H(arrayList);
                    }
                }
            } else if (!dq1.a(h, d) && !dq1.a(h, ByteString.e)) {
                arrayList.add(h);
            }
        }
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (i2 > 0) {
                lkVar2.l0(byteString2);
            }
            lkVar2.l0((ByteString) arrayList.get(i2));
        }
        if (lkVar2.size() == 0) {
            lkVar2.l0(d);
        }
        return new uw2(lkVar2.Z());
    }

    public static final ByteString r(byte b2) {
        if (b2 == 47) {
            return a;
        }
        if (b2 == 92) {
            return b;
        }
        m.a("not a directory separator: ", b2);
        return null;
    }

    public static final ByteString s(String str) {
        if (dq1.a(str, "/")) {
            return a;
        }
        if (dq1.a(str, "\\")) {
            return b;
        }
        n.a("not a directory separator: ", str);
        return null;
    }
}
