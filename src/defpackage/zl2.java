package defpackage;

import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;

/* loaded from: /tmp/classes2.dex */
public abstract class zl2 {
    public static final boolean a(m00 m00Var) {
        m00Var.getClass();
        return m00Var.l() == Modality.FINAL && m00Var.i() != ClassKind.ENUM_CLASS;
    }
}
