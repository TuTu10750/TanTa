package defpackage;

import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.WireFormat;
import kotlin.reflect.jvm.internal.impl.protobuf.d;

/* loaded from: /tmp/classes2.dex */
public abstract class yk {
    public static final GeneratedMessageLite.e a = GeneratedMessageLite.o(ProtoBuf$Package.K(), 0, null, null, 151, WireFormat.FieldType.g, Integer.class);
    public static final GeneratedMessageLite.e b;
    public static final GeneratedMessageLite.e c;
    public static final GeneratedMessageLite.e d;
    public static final GeneratedMessageLite.e e;
    public static final GeneratedMessageLite.e f;
    public static final GeneratedMessageLite.e g;
    public static final GeneratedMessageLite.e h;
    public static final GeneratedMessageLite.e i;
    public static final GeneratedMessageLite.e j;
    public static final GeneratedMessageLite.e k;
    public static final GeneratedMessageLite.e l;

    static {
        ProtoBuf$Class y0 = ProtoBuf$Class.y0();
        ProtoBuf$Annotation z = ProtoBuf$Annotation.z();
        WireFormat.FieldType fieldType = WireFormat.FieldType.m;
        b = GeneratedMessageLite.n(y0, z, null, 150, fieldType, false, ProtoBuf$Annotation.class);
        c = GeneratedMessageLite.n(ProtoBuf$Constructor.H(), ProtoBuf$Annotation.z(), null, 150, fieldType, false, ProtoBuf$Annotation.class);
        d = GeneratedMessageLite.n(ProtoBuf$Function.a0(), ProtoBuf$Annotation.z(), null, 150, fieldType, false, ProtoBuf$Annotation.class);
        e = GeneratedMessageLite.n(ProtoBuf$Property.Y(), ProtoBuf$Annotation.z(), null, 150, fieldType, false, ProtoBuf$Annotation.class);
        f = GeneratedMessageLite.n(ProtoBuf$Property.Y(), ProtoBuf$Annotation.z(), null, 152, fieldType, false, ProtoBuf$Annotation.class);
        g = GeneratedMessageLite.n(ProtoBuf$Property.Y(), ProtoBuf$Annotation.z(), null, 153, fieldType, false, ProtoBuf$Annotation.class);
        h = GeneratedMessageLite.o(ProtoBuf$Property.Y(), ProtoBuf$Annotation.Argument.Value.L(), ProtoBuf$Annotation.Argument.Value.L(), null, 151, fieldType, ProtoBuf$Annotation.Argument.Value.class);
        i = GeneratedMessageLite.n(ProtoBuf$EnumEntry.D(), ProtoBuf$Annotation.z(), null, 150, fieldType, false, ProtoBuf$Annotation.class);
        j = GeneratedMessageLite.n(ProtoBuf$ValueParameter.I(), ProtoBuf$Annotation.z(), null, 150, fieldType, false, ProtoBuf$Annotation.class);
        k = GeneratedMessageLite.n(ProtoBuf$Type.X(), ProtoBuf$Annotation.z(), null, 150, fieldType, false, ProtoBuf$Annotation.class);
        l = GeneratedMessageLite.n(ProtoBuf$TypeParameter.K(), ProtoBuf$Annotation.z(), null, 150, fieldType, false, ProtoBuf$Annotation.class);
    }

    public static void a(d dVar) {
        dVar.a(a);
        dVar.a(b);
        dVar.a(c);
        dVar.a(d);
        dVar.a(e);
        dVar.a(f);
        dVar.a(g);
        dVar.a(h);
        dVar.a(i);
        dVar.a(j);
        dVar.a(k);
        dVar.a(l);
    }
}
