package defpackage;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.b;
import kotlinx.coroutines.c;

/* loaded from: /tmp/classes2.dex */
public final class u30 {
    public final Object a;
    public final b b;
    public final d91 c;
    public final Object d;
    public final Throwable e;

    public u30(Object obj, b bVar, d91 d91Var, Object obj2, Throwable th) {
        this.a = obj;
        this.b = bVar;
        this.c = d91Var;
        this.d = obj2;
        this.e = th;
    }

    public /* synthetic */ u30(Object obj, b bVar, d91 d91Var, Object obj2, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, (i & 2) != 0 ? null : bVar, (i & 4) != 0 ? null : d91Var, (i & 8) != 0 ? null : obj2, (i & 16) != 0 ? null : th);
    }

    public static /* synthetic */ u30 b(u30 u30Var, Object obj, b bVar, d91 d91Var, Object obj2, Throwable th, int i, Object obj3) {
        if ((i & 1) != 0) {
            obj = u30Var.a;
        }
        if ((i & 2) != 0) {
            bVar = u30Var.b;
        }
        if ((i & 4) != 0) {
            d91Var = u30Var.c;
        }
        if ((i & 8) != 0) {
            obj2 = u30Var.d;
        }
        if ((i & 16) != 0) {
            th = u30Var.e;
        }
        Throwable th2 = th;
        d91 d91Var2 = d91Var;
        return u30Var.a(obj, bVar, d91Var2, obj2, th2);
    }

    public final u30 a(Object obj, b bVar, d91 d91Var, Object obj2, Throwable th) {
        return new u30(obj, bVar, d91Var, obj2, th);
    }

    public final boolean c() {
        return this.e != null;
    }

    public final void d(c cVar, Throwable th) {
        b bVar = this.b;
        if (bVar != null) {
            cVar.o(bVar, th);
        }
        d91 d91Var = this.c;
        if (d91Var != null) {
            cVar.p(d91Var, th, this.a);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u30)) {
            return false;
        }
        u30 u30Var = (u30) obj;
        return dq1.a(this.a, u30Var.a) && dq1.a(this.b, u30Var.b) && dq1.a(this.c, u30Var.c) && dq1.a(this.d, u30Var.d) && dq1.a(this.e, u30Var.e);
    }

    public int hashCode() {
        Object obj = this.a;
        int hashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        b bVar = this.b;
        int hashCode2 = (hashCode + (bVar == null ? 0 : bVar.hashCode())) * 31;
        d91 d91Var = this.c;
        int hashCode3 = (hashCode2 + (d91Var == null ? 0 : d91Var.hashCode())) * 31;
        Object obj2 = this.d;
        int hashCode4 = (hashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.e;
        return hashCode4 + (th != null ? th.hashCode() : 0);
    }

    public String toString() {
        return "CompletedContinuation(result=" + this.a + ", cancelHandler=" + this.b + ", onCancellation=" + this.c + ", idempotentResume=" + this.d + ", cancelCause=" + this.e + ')';
    }
}
