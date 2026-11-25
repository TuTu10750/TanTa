package defpackage;

import java.util.Iterator;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;

/* loaded from: /tmp/classes2.dex */
public abstract class en3 {

    /* loaded from: /tmp/classes2.dex */
    public static final class a implements bn3 {
        public final /* synthetic */ b91 a;

        public a(b91 b91Var) {
            this.a = b91Var;
        }

        @Override // defpackage.bn3
        public Iterator iterator() {
            return en3.a(this.a);
        }
    }

    public static final Iterator a(b91 b91Var) {
        b91Var.getClass();
        cn3 cn3Var = new cn3();
        cn3Var.n(IntrinsicsKt__IntrinsicsJvmKt.a(b91Var, cn3Var, cn3Var));
        return cn3Var;
    }

    public static bn3 b(b91 b91Var) {
        b91Var.getClass();
        return new a(b91Var);
    }
}
