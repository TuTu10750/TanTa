package defpackage;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.l;

/* loaded from: /tmp/classes2.dex */
public final class bo1 extends l {
    public final oa4[] c;
    public final ta4[] d;
    public final boolean e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public bo1(List list, List list2) {
        this((oa4[]) list.toArray(new oa4[0]), (ta4[]) list2.toArray(new ta4[0]), false, 4, null);
        list.getClass();
        list2.getClass();
    }

    public bo1(oa4[] oa4VarArr, ta4[] ta4VarArr, boolean z) {
        oa4VarArr.getClass();
        ta4VarArr.getClass();
        this.c = oa4VarArr;
        this.d = ta4VarArr;
        this.e = z;
        int length = oa4VarArr.length;
        int length2 = ta4VarArr.length;
    }

    public /* synthetic */ bo1(oa4[] oa4VarArr, ta4[] ta4VarArr, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(oa4VarArr, ta4VarArr, (i & 4) != 0 ? false : z);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.l
    public boolean b() {
        return this.e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.l
    public ta4 e(fx1 fx1Var) {
        fx1Var.getClass();
        z00 b = fx1Var.N0().b();
        oa4 oa4Var = b instanceof oa4 ? (oa4) b : null;
        if (oa4Var == null) {
            return null;
        }
        int index = oa4Var.getIndex();
        oa4[] oa4VarArr = this.c;
        if (index >= oa4VarArr.length || !dq1.a(oa4VarArr[index].k(), oa4Var.k())) {
            return null;
        }
        return this.d[index];
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.l
    public boolean f() {
        return this.d.length == 0;
    }

    public final ta4[] i() {
        return this.d;
    }

    public final oa4[] j() {
        return this.c;
    }
}
