package defpackage;

import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeFlexibility;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;

/* loaded from: /tmp/classes2.dex */
public final class dt1 extends lu0 {
    public final TypeUsage d;
    public final JavaTypeFlexibility e;
    public final boolean f;
    public final boolean g;
    public final Set h;
    public final zp3 i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dt1(TypeUsage typeUsage, JavaTypeFlexibility javaTypeFlexibility, boolean z, boolean z2, Set set, zp3 zp3Var) {
        super(typeUsage, set, zp3Var);
        typeUsage.getClass();
        javaTypeFlexibility.getClass();
        this.d = typeUsage;
        this.e = javaTypeFlexibility;
        this.f = z;
        this.g = z2;
        this.h = set;
        this.i = zp3Var;
    }

    public /* synthetic */ dt1(TypeUsage typeUsage, JavaTypeFlexibility javaTypeFlexibility, boolean z, boolean z2, Set set, zp3 zp3Var, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(typeUsage, (i & 2) != 0 ? JavaTypeFlexibility.INFLEXIBLE : javaTypeFlexibility, (i & 4) != 0 ? false : z, (i & 8) != 0 ? false : z2, (i & 16) != 0 ? null : set, (i & 32) != 0 ? null : zp3Var);
    }

    public static /* synthetic */ dt1 f(dt1 dt1Var, TypeUsage typeUsage, JavaTypeFlexibility javaTypeFlexibility, boolean z, boolean z2, Set set, zp3 zp3Var, int i, Object obj) {
        if ((i & 1) != 0) {
            typeUsage = dt1Var.d;
        }
        if ((i & 2) != 0) {
            javaTypeFlexibility = dt1Var.e;
        }
        if ((i & 4) != 0) {
            z = dt1Var.f;
        }
        if ((i & 8) != 0) {
            z2 = dt1Var.g;
        }
        if ((i & 16) != 0) {
            set = dt1Var.h;
        }
        if ((i & 32) != 0) {
            zp3Var = dt1Var.i;
        }
        Set set2 = set;
        zp3 zp3Var2 = zp3Var;
        return dt1Var.e(typeUsage, javaTypeFlexibility, z, z2, set2, zp3Var2);
    }

    @Override // defpackage.lu0
    public zp3 a() {
        return this.i;
    }

    @Override // defpackage.lu0
    public TypeUsage b() {
        return this.d;
    }

    @Override // defpackage.lu0
    public Set c() {
        return this.h;
    }

    public final dt1 e(TypeUsage typeUsage, JavaTypeFlexibility javaTypeFlexibility, boolean z, boolean z2, Set set, zp3 zp3Var) {
        typeUsage.getClass();
        javaTypeFlexibility.getClass();
        return new dt1(typeUsage, javaTypeFlexibility, z, z2, set, zp3Var);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof dt1)) {
            return false;
        }
        dt1 dt1Var = (dt1) obj;
        return dq1.a(dt1Var.a(), a()) && dt1Var.b() == b() && dt1Var.e == this.e && dt1Var.f == this.f && dt1Var.g == this.g;
    }

    public final JavaTypeFlexibility g() {
        return this.e;
    }

    public final boolean h() {
        return this.g;
    }

    @Override // defpackage.lu0
    public int hashCode() {
        zp3 a = a();
        int hashCode = a != null ? a.hashCode() : 0;
        int hashCode2 = hashCode + (hashCode * 31) + b().hashCode();
        int hashCode3 = hashCode2 + (hashCode2 * 31) + this.e.hashCode();
        int i = hashCode3 + (hashCode3 * 31) + (this.f ? 1 : 0);
        return i + (i * 31) + (this.g ? 1 : 0);
    }

    public final boolean i() {
        return this.f;
    }

    public final dt1 j(boolean z) {
        return f(this, null, null, z, false, null, null, 59, null);
    }

    public dt1 k(zp3 zp3Var) {
        return f(this, null, null, false, false, null, zp3Var, 31, null);
    }

    public final dt1 l(JavaTypeFlexibility javaTypeFlexibility) {
        javaTypeFlexibility.getClass();
        return f(this, null, javaTypeFlexibility, false, false, null, null, 61, null);
    }

    @Override // defpackage.lu0
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public dt1 d(oa4 oa4Var) {
        oa4Var.getClass();
        return f(this, null, null, false, false, c() != null ? fo3.l(c(), oa4Var) : do3.d(oa4Var), null, 47, null);
    }

    public String toString() {
        return "JavaTypeAttributes(howThisTypeIsUsed=" + this.d + ", flexibility=" + this.e + ", isRaw=" + this.f + ", isForAnnotationParameter=" + this.g + ", visitedTypeParameters=" + this.h + ", defaultType=" + this.i + ')';
    }
}
