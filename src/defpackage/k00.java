package defpackage;

import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;

/* loaded from: /tmp/classes2.dex */
public final class k00 {
    public final ap2 a;
    public final ProtoBuf$Class b;
    public final gi c;
    public final xr3 d;

    public k00(ap2 ap2Var, ProtoBuf$Class protoBuf$Class, gi giVar, xr3 xr3Var) {
        ap2Var.getClass();
        protoBuf$Class.getClass();
        giVar.getClass();
        xr3Var.getClass();
        this.a = ap2Var;
        this.b = protoBuf$Class;
        this.c = giVar;
        this.d = xr3Var;
    }

    public final ap2 a() {
        return this.a;
    }

    public final ProtoBuf$Class b() {
        return this.b;
    }

    public final gi c() {
        return this.c;
    }

    public final xr3 d() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k00)) {
            return false;
        }
        k00 k00Var = (k00) obj;
        return dq1.a(this.a, k00Var.a) && dq1.a(this.b, k00Var.b) && dq1.a(this.c, k00Var.c) && dq1.a(this.d, k00Var.d);
    }

    public int hashCode() {
        return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public String toString() {
        return "ClassData(nameResolver=" + this.a + ", classProto=" + this.b + ", metadataVersion=" + this.c + ", sourceElement=" + this.d + ')';
    }
}
