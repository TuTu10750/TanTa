package defpackage;

import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;

/* loaded from: /tmp/classes2.dex */
public abstract class z33 {
    public static final Object a(GeneratedMessageLite.ExtendableMessage extendableMessage, GeneratedMessageLite.e eVar) {
        extendableMessage.getClass();
        eVar.getClass();
        if (extendableMessage.x(eVar)) {
            return extendableMessage.u(eVar);
        }
        return null;
    }

    public static final Object b(GeneratedMessageLite.ExtendableMessage extendableMessage, GeneratedMessageLite.e eVar, int i) {
        extendableMessage.getClass();
        eVar.getClass();
        if (i < extendableMessage.w(eVar)) {
            return extendableMessage.v(eVar, i);
        }
        return null;
    }
}
