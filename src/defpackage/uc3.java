package defpackage;

import java.lang.annotation.Annotation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;

/* loaded from: /tmp/classes2.dex */
public abstract class uc3 implements er1 {
    public static final a b = new a(null);
    public final zo2 a;

    /* loaded from: /tmp/classes2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final uc3 a(Object obj, zo2 zo2Var) {
            obj.getClass();
            return ReflectClassUtilKt.g(obj.getClass()) ? new gd3(zo2Var, (Enum) obj) : obj instanceof Annotation ? new vc3(zo2Var, (Annotation) obj) : obj instanceof Object[] ? new yc3(zo2Var, (Object[]) obj) : obj instanceof Class ? new cd3(zo2Var, (Class) obj) : new id3(zo2Var, obj);
        }
    }

    public uc3(zo2 zo2Var) {
        this.a = zo2Var;
    }

    public /* synthetic */ uc3(zo2 zo2Var, DefaultConstructorMarker defaultConstructorMarker) {
        this(zo2Var);
    }

    @Override // defpackage.er1
    public zo2 getName() {
        return this.a;
    }
}
