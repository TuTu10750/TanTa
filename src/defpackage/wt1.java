package defpackage;

/* loaded from: /tmp/classes2.dex */
public abstract class wt1 {
    public static final p04 a = new p04("COMPLETING_ALREADY");
    public static final p04 b = new p04("COMPLETING_WAITING_CHILDREN");
    public static final p04 c = new p04("COMPLETING_RETRY");
    public static final p04 d = new p04("TOO_LATE_TO_CANCEL");
    public static final p04 e = new p04("SEALED");
    public static final gt0 f = new gt0(false);
    public static final gt0 g = new gt0(true);

    public static final Object g(Object obj) {
        return obj instanceof vn1 ? new wn1((vn1) obj) : obj;
    }

    public static final Object h(Object obj) {
        vn1 vn1Var;
        wn1 wn1Var = obj instanceof wn1 ? (wn1) obj : null;
        return (wn1Var == null || (vn1Var = wn1Var.a) == null) ? obj : vn1Var;
    }
}
