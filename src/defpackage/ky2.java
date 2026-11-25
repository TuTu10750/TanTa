package defpackage;

import kotlin.reflect.jvm.internal.impl.descriptors.g;

/* loaded from: /tmp/classes2.dex */
public interface ky2 {

    /* loaded from: /tmp/classes2.dex */
    public static final class a implements ky2 {
        public static final a a = new a();

        @Override // defpackage.ky2
        public boolean e(m00 m00Var, g gVar) {
            m00Var.getClass();
            gVar.getClass();
            return true;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static final class b implements ky2 {
        public static final b a = new b();

        @Override // defpackage.ky2
        public boolean e(m00 m00Var, g gVar) {
            m00Var.getClass();
            gVar.getClass();
            return !gVar.getAnnotations().c(ly2.a());
        }
    }

    boolean e(m00 m00Var, g gVar);
}
