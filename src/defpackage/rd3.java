package defpackage;

import java.lang.annotation.Annotation;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public final class rd3 extends fd3 implements lt1 {
    public final pd3 a;
    public final Annotation[] b;
    public final String c;
    public final boolean d;

    public rd3(pd3 pd3Var, Annotation[] annotationArr, String str, boolean z) {
        pd3Var.getClass();
        annotationArr.getClass();
        this.a = pd3Var;
        this.b = annotationArr;
        this.c = str;
        this.d = z;
    }

    @Override // defpackage.lt1
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public pd3 getType() {
        return this.a;
    }

    @Override // defpackage.hr1
    public tc3 a(r51 r51Var) {
        r51Var.getClass();
        return xc3.a(this.b, r51Var);
    }

    @Override // defpackage.lt1
    public boolean b() {
        return this.d;
    }

    @Override // defpackage.hr1
    public List getAnnotations() {
        return xc3.b(this.b);
    }

    @Override // defpackage.lt1
    public zo2 getName() {
        String str = this.c;
        if (str != null) {
            return zo2.h(str);
        }
        return null;
    }

    @Override // defpackage.hr1
    public boolean o() {
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(rd3.class.getName());
        sb.append(": ");
        sb.append(b() ? "vararg " : "");
        sb.append(getName());
        sb.append(": ");
        sb.append(getType());
        return sb.toString();
    }
}
