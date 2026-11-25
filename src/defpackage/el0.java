package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope;

/* loaded from: /tmp/classes2.dex */
public class el0 extends DeserializedMemberScope {
    public final kv2 g;
    public final String h;
    public final r51 i;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public el0(defpackage.kv2 r8, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package r9, defpackage.ap2 r10, defpackage.gi r11, defpackage.bl0 r12, defpackage.rk0 r13, java.lang.String r14, defpackage.l81 r15) {
        /*
            r7 = this;
            r8.getClass()
            r9.getClass()
            r10.getClass()
            r11.getClass()
            r13.getClass()
            r14.getClass()
            r15.getClass()
            cb4 r3 = new cb4
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable r0 = r9.V()
            r0.getClass()
            r3.<init>(r0)
            fg4$a r0 = defpackage.fg4.b
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable r1 = r9.W()
            r1.getClass()
            fg4 r4 = r0.a(r1)
            r1 = r8
            r2 = r10
            r5 = r11
            r6 = r12
            r0 = r13
            vk0 r8 = r0.a(r1, r2, r3, r4, r5, r6)
            r10 = r9
            java.util.List r9 = r10.O()
            r9.getClass()
            r11 = r10
            java.util.List r10 = r11.R()
            r10.getClass()
            java.util.List r11 = r11.U()
            r11.getClass()
            r12 = r15
            r7.<init>(r8, r9, r10, r11, r12)
            r7.g = r1
            r7.h = r14
            r51 r8 = r1.d()
            r7.i = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.el0.<init>(kv2, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package, ap2, gi, bl0, rk0, java.lang.String, l81):void");
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope, defpackage.dk2, kotlin.reflect.jvm.internal.impl.resolve.scopes.c
    public z00 e(zo2 zo2Var, z82 z82Var) {
        zo2Var.getClass();
        z82Var.getClass();
        z(zo2Var, z82Var);
        return super.e(zo2Var, z82Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
    public void i(Collection collection, n81 n81Var) {
        collection.getClass();
        n81Var.getClass();
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
    public q00 m(zo2 zo2Var) {
        zo2Var.getClass();
        return new q00(this.i, zo2Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
    public Set s() {
        return eo3.e();
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
    public Set t() {
        return eo3.e();
    }

    public String toString() {
        return this.h;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
    public Set u() {
        return eo3.e();
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
    public boolean w(zo2 zo2Var) {
        zo2Var.getClass();
        if (super.w(zo2Var)) {
            return true;
        }
        Iterable k = p().c().k();
        if ((k instanceof Collection) && ((Collection) k).isEmpty()) {
            return false;
        }
        Iterator it = k.iterator();
        while (it.hasNext()) {
            if (((o00) it.next()).c(this.i, zo2Var)) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.dk2, kotlin.reflect.jvm.internal.impl.resolve.scopes.c
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public List f(hk0 hk0Var, n81 n81Var) {
        hk0Var.getClass();
        n81Var.getClass();
        Collection j = j(hk0Var, n81Var, NoLookupLocation.WHEN_GET_ALL_DESCRIPTORS);
        Iterable k = p().c().k();
        ArrayList arrayList = new ArrayList();
        Iterator it = k.iterator();
        while (it.hasNext()) {
            x20.A(arrayList, ((o00) it.next()).b(this.i));
        }
        return b30.v0(j, arrayList);
    }

    public void z(zo2 zo2Var, z82 z82Var) {
        zo2Var.getClass();
        z82Var.getClass();
        mf4.b(p().c().o(), z82Var, this.g, zo2Var);
    }
}
