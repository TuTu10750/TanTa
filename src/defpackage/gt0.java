package defpackage;

/* loaded from: /tmp/classes2.dex */
public final class gt0 implements vn1 {
    public final boolean a;

    public gt0(boolean z) {
        this.a = z;
    }

    @Override // defpackage.vn1
    public boolean a() {
        return this.a;
    }

    @Override // defpackage.vn1
    public nq2 c() {
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Empty{");
        sb.append(a() ? "Active" : "New");
        sb.append('}');
        return sb.toString();
    }
}
