package defpackage;

/* loaded from: /tmp/classes2.dex */
public abstract /* synthetic */ class pr1 {
    public static /* synthetic */ qs1 a(qr1 qr1Var, r51 r51Var, boolean z, int i, Object obj) {
        if (obj != null) {
            qm.a("Super calls with default arguments not supported in this target, function: findPackage");
            return null;
        }
        if ((i & 2) != 0) {
            z = true;
        }
        return qr1Var.b(r51Var, z);
    }
}
