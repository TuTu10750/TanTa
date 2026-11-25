package defpackage;

import kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations;

/* loaded from: /tmp/classes2.dex */
public abstract class l8 {
    public static final j8 a(j8 j8Var, j8 j8Var2) {
        j8Var.getClass();
        j8Var2.getClass();
        return j8Var.isEmpty() ? j8Var2 : j8Var2.isEmpty() ? j8Var : new CompositeAnnotations(j8Var, j8Var2);
    }
}
