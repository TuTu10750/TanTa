package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.load.kotlin.c;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.a;

/* loaded from: /tmp/classes2.dex */
public final class qv2 {
    public final DeserializedDescriptorResolver a;
    public final vd3 b;
    public final ConcurrentHashMap c;

    public qv2(DeserializedDescriptorResolver deserializedDescriptorResolver, vd3 vd3Var) {
        deserializedDescriptorResolver.getClass();
        vd3Var.getClass();
        this.a = deserializedDescriptorResolver;
        this.b = vd3Var;
        this.c = new ConcurrentHashMap();
    }

    public final MemberScope a(ud3 ud3Var) {
        Collection e;
        ud3Var.getClass();
        ConcurrentHashMap concurrentHashMap = this.c;
        q00 l = ud3Var.l();
        Object obj = concurrentHashMap.get(l);
        if (obj == null) {
            r51 h = ud3Var.l().h();
            h.getClass();
            if (ud3Var.b().c() == KotlinClassHeader.Kind.MULTIFILE_CLASS) {
                List f = ud3Var.b().f();
                e = new ArrayList();
                Iterator it = f.iterator();
                while (it.hasNext()) {
                    q00 m = q00.m(xu1.d((String) it.next()).e());
                    m.getClass();
                    c a = bx1.a(this.b, m, wk0.a(this.a.d().g()));
                    if (a != null) {
                        e.add(a);
                    }
                }
            } else {
                e = r20.e(ud3Var);
            }
            mt0 mt0Var = new mt0(this.a.d().p(), h);
            ArrayList arrayList = new ArrayList();
            Iterator it2 = e.iterator();
            while (it2.hasNext()) {
                MemberScope b = this.a.b(mt0Var, (c) it2.next());
                if (b != null) {
                    arrayList.add(b);
                }
            }
            List I0 = b30.I0(arrayList);
            MemberScope a2 = a.d.a("package " + h + " (" + ud3Var + ')', I0);
            Object putIfAbsent = concurrentHashMap.putIfAbsent(l, a2);
            obj = putIfAbsent == null ? a2 : putIfAbsent;
        }
        obj.getClass();
        return (MemberScope) obj;
    }
}
