package defpackage;

import kotlin.reflect.jvm.internal.impl.load.kotlin.c;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerAbiStability;

/* loaded from: /tmp/classes2.dex */
public final class gv1 implements bl0 {
    public final xu1 b;
    public final xu1 c;
    public final un1 d;
    public final boolean e;
    public final DeserializedContainerAbiStability f;
    public final c g;
    public final String h;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public gv1(kotlin.reflect.jvm.internal.impl.load.kotlin.c r11, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package r12, defpackage.ap2 r13, defpackage.un1 r14, boolean r15, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerAbiStability r16) {
        /*
            r10 = this;
            r11.getClass()
            r12.getClass()
            r13.getClass()
            r16.getClass()
            q00 r0 = r11.l()
            xu1 r2 = defpackage.xu1.b(r0)
            r2.getClass()
            kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader r0 = r11.b()
            java.lang.String r0 = r0.e()
            r1 = 0
            if (r0 == 0) goto L2c
            int r3 = r0.length()
            if (r3 <= 0) goto L2c
            xu1 r1 = defpackage.xu1.d(r0)
        L2c:
            r9 = r11
            r4 = r12
            r5 = r13
            r6 = r14
            r7 = r15
            r8 = r16
            r3 = r1
            r1 = r10
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.gv1.<init>(kotlin.reflect.jvm.internal.impl.load.kotlin.c, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package, ap2, un1, boolean, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerAbiStability):void");
    }

    public gv1(xu1 xu1Var, xu1 xu1Var2, ProtoBuf$Package protoBuf$Package, ap2 ap2Var, un1 un1Var, boolean z, DeserializedContainerAbiStability deserializedContainerAbiStability, c cVar) {
        String string;
        xu1Var.getClass();
        protoBuf$Package.getClass();
        ap2Var.getClass();
        deserializedContainerAbiStability.getClass();
        this.b = xu1Var;
        this.c = xu1Var2;
        this.d = un1Var;
        this.e = z;
        this.f = deserializedContainerAbiStability;
        this.g = cVar;
        GeneratedMessageLite.e eVar = JvmProtoBuf.m;
        eVar.getClass();
        Integer num = (Integer) z33.a(protoBuf$Package, eVar);
        this.h = (num == null || (string = ap2Var.getString(num.intValue())) == null) ? "main" : string;
    }

    @Override // defpackage.xr3
    public yr3 a() {
        yr3 yr3Var = yr3.a;
        yr3Var.getClass();
        return yr3Var;
    }

    @Override // defpackage.bl0
    public String c() {
        return "Class '" + d().b().b() + '\'';
    }

    public final q00 d() {
        return new q00(e().g(), h());
    }

    public xu1 e() {
        return this.b;
    }

    public xu1 f() {
        return this.c;
    }

    public final c g() {
        return this.g;
    }

    public final zo2 h() {
        String f = e().f();
        f.getClass();
        zo2 i = zo2.i(hw3.G0(f, '/', null, 2, null));
        i.getClass();
        return i;
    }

    public String toString() {
        return gv1.class.getSimpleName() + ": " + e();
    }
}
