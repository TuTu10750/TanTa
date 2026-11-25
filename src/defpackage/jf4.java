package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* loaded from: /tmp/classes2.dex */
public abstract class jf4 {
    public static final List a(Collection collection, Collection collection2, a aVar) {
        collection.getClass();
        collection2.getClass();
        aVar.getClass();
        collection.size();
        collection2.size();
        List<Pair> Q0 = b30.Q0(collection, collection2);
        ArrayList arrayList = new ArrayList(t20.v(Q0, 10));
        for (Pair pair : Q0) {
            fx1 fx1Var = (fx1) pair.getFirst();
            h hVar = (h) pair.getSecond();
            int index = hVar.getIndex();
            j8 annotations = hVar.getAnnotations();
            zo2 name = hVar.getName();
            name.getClass();
            boolean s0 = hVar.s0();
            boolean b0 = hVar.b0();
            boolean X = hVar.X();
            fx1 k = hVar.j0() != null ? DescriptorUtilsKt.p(aVar).q().k(fx1Var) : null;
            xr3 j = hVar.j();
            j.getClass();
            arrayList.add(new ValueParameterDescriptorImpl(aVar, null, index, annotations, name, fx1Var, s0, b0, X, k, j));
        }
        return arrayList;
    }

    public static final LazyJavaStaticClassScope b(m00 m00Var) {
        m00Var.getClass();
        m00 t = DescriptorUtilsKt.t(m00Var);
        if (t == null) {
            return null;
        }
        MemberScope Q = t.Q();
        LazyJavaStaticClassScope lazyJavaStaticClassScope = Q instanceof LazyJavaStaticClassScope ? (LazyJavaStaticClassScope) Q : null;
        return lazyJavaStaticClassScope == null ? b(t) : lazyJavaStaticClassScope;
    }
}
