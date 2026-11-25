package defpackage;

import java.util.Comparator;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;

/* loaded from: /tmp/classes2.dex */
public class zv1 implements Comparator {
    public final b91 a;

    public zv1(b91 b91Var) {
        this.a = b91Var;
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        int C;
        C = KDeclarationContainerImpl.C(this.a, obj, obj2);
        return C;
    }
}
