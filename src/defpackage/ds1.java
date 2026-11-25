package defpackage;

import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;

/* loaded from: /tmp/classes2.dex */
public final class ds1 implements m31 {
    public static final ds1 a = new ds1();

    @Override // defpackage.m31
    public fx1 a(ProtoBuf$Type protoBuf$Type, String str, zp3 zp3Var, zp3 zp3Var2) {
        protoBuf$Type.getClass();
        str.getClass();
        zp3Var.getClass();
        zp3Var2.getClass();
        return !dq1.a(str, "kotlin.jvm.PlatformType") ? xu0.d(ErrorTypeKind.J, str, zp3Var.toString(), zp3Var2.toString()) : protoBuf$Type.x(JvmProtoBuf.g) ? new RawTypeImpl(zp3Var, zp3Var2) : KotlinTypeFactory.d(zp3Var, zp3Var2);
    }
}
