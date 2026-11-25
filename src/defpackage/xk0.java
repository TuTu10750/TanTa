package defpackage;

import defpackage.j8;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.PropertyReference1Impl;

/* loaded from: /tmp/classes2.dex */
public class xk0 implements j8 {
    public static final /* synthetic */ iw1[] b = {zd3.g(new PropertyReference1Impl(zd3.b(xk0.class), "annotations", "getAnnotations()Ljava/util/List;"))};
    public final wq2 a;

    public xk0(lu3 lu3Var, l81 l81Var) {
        lu3Var.getClass();
        l81Var.getClass();
        this.a = lu3Var.i(l81Var);
    }

    private final List g() {
        return (List) ku3.a(this.a, this, b[0]);
    }

    @Override // defpackage.j8
    public d8 a(r51 r51Var) {
        return j8.b.a(this, r51Var);
    }

    @Override // defpackage.j8
    public boolean c(r51 r51Var) {
        return j8.b.b(this, r51Var);
    }

    @Override // defpackage.j8
    public boolean isEmpty() {
        return g().isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return g().iterator();
    }
}
