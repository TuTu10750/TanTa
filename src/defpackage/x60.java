package defpackage;

import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer;

/* loaded from: /tmp/classes2.dex */
public interface x60 {
    public static final a a = a.a;

    /* loaded from: /tmp/classes2.dex */
    public static final class a {
        public static final /* synthetic */ a a = new a();
        public static final x60 b = new C0165a();

        /* renamed from: x60$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/classes2.dex */
        public static final class C0165a implements x60 {
            @Override // defpackage.x60
            public Pair a(ProtoBuf$Function protoBuf$Function, e eVar, cb4 cb4Var, TypeDeserializer typeDeserializer) {
                protoBuf$Function.getClass();
                eVar.getClass();
                cb4Var.getClass();
                typeDeserializer.getClass();
                return null;
            }
        }

        public final x60 a() {
            return b;
        }
    }

    Pair a(ProtoBuf$Function protoBuf$Function, e eVar, cb4 cb4Var, TypeDeserializer typeDeserializer);
}
