package defpackage;

import java.lang.annotation.Annotation;

/* loaded from: /tmp/classes2.dex */
public final class vc3 extends uc3 implements fr1 {
    public final Annotation c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vc3(zo2 zo2Var, Annotation annotation) {
        super(zo2Var, null);
        annotation.getClass();
        this.c = annotation;
    }

    @Override // defpackage.fr1
    public dr1 a() {
        return new tc3(this.c);
    }
}
