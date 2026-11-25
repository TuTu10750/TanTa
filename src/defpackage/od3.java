package defpackage;

import java.lang.reflect.Member;
import java.lang.reflect.Method;

/* loaded from: /tmp/classes2.dex */
public final class od3 extends jd3 implements us1 {
    public final Object a;

    public od3(Object obj) {
        obj.getClass();
        this.a = obj;
    }

    @Override // defpackage.jd3
    public Member R() {
        Method c = ar1.a.c(this.a);
        if (c != null) {
            return c;
        }
        throw new NoSuchMethodError("Can't find `getAccessor` method");
    }

    @Override // defpackage.us1
    public boolean b() {
        return false;
    }

    @Override // defpackage.us1
    public ct1 getType() {
        Class d = ar1.a.d(this.a);
        if (d != null) {
            return new dd3(d);
        }
        throw new NoSuchMethodError("Can't find `getType` method");
    }
}
