package defpackage;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragment;

/* loaded from: /tmp/classes2.dex */
public final class x33 implements l00 {
    public final ap2 a;
    public final gi b;
    public final n81 c;
    public final Map d;

    public x33(ProtoBuf$PackageFragment protoBuf$PackageFragment, ap2 ap2Var, gi giVar, n81 n81Var) {
        protoBuf$PackageFragment.getClass();
        ap2Var.getClass();
        giVar.getClass();
        n81Var.getClass();
        this.a = ap2Var;
        this.b = giVar;
        this.c = n81Var;
        List J = protoBuf$PackageFragment.J();
        J.getClass();
        LinkedHashMap linkedHashMap = new LinkedHashMap(fb3.c(sc2.e(t20.v(J, 10)), 16));
        for (Object obj : J) {
            linkedHashMap.put(cp2.a(this.a, ((ProtoBuf$Class) obj).E0()), obj);
        }
        this.d = linkedHashMap;
    }

    @Override // defpackage.l00
    public k00 a(q00 q00Var) {
        q00Var.getClass();
        ProtoBuf$Class protoBuf$Class = (ProtoBuf$Class) this.d.get(q00Var);
        if (protoBuf$Class == null) {
            return null;
        }
        return new k00(this.a, protoBuf$Class, this.b, (xr3) this.c.invoke(q00Var));
    }

    public final Collection b() {
        return this.d.keySet();
    }
}
