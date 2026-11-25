package defpackage;

import java.util.List;

/* loaded from: /tmp/classes2.dex */
public interface ed2 {

    /* loaded from: /tmp/classes2.dex */
    public static final class a {
        public static b a(ed2 ed2Var) {
            return new b(ed2Var);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static final class b {
        public final ed2 a;

        public b(ed2 ed2Var) {
            ed2Var.getClass();
            this.a = ed2Var;
        }

        public final ed2 a() {
            return this.a;
        }
    }

    b a();

    List b();
}
