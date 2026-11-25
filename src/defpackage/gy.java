package defpackage;

import java.util.Arrays;

/* loaded from: /tmp/classes2.dex */
public final class gy extends tp1 {
    public gy(char c) {
        super(Character.valueOf(c));
    }

    public final String c(char c) {
        return c == '\b' ? "\\b" : c == '\t' ? "\\t" : c == '\n' ? "\\n" : c == '\f' ? "\\f" : c == '\r' ? "\\r" : e(c) ? String.valueOf(c) : "?";
    }

    @Override // defpackage.k50
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public zp3 a(mm2 mm2Var) {
        mm2Var.getClass();
        zp3 u = mm2Var.q().u();
        u.getClass();
        return u;
    }

    public final boolean e(char c) {
        byte type = (byte) Character.getType(c);
        return (type == 0 || type == 13 || type == 14 || type == 15 || type == 16 || type == 18 || type == 19) ? false : true;
    }

    @Override // defpackage.k50
    public String toString() {
        return String.format("\\u%04X ('%s')", Arrays.copyOf(new Object[]{Integer.valueOf(((Character) b()).charValue()), c(((Character) b()).charValue())}, 2));
    }
}
