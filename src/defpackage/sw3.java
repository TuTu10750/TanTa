package defpackage;

import java.lang.reflect.Method;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: /tmp/classes2.dex */
public class sw3 {
    public final Method a;
    public final ThreadMode b;
    public final Class c;
    public final int d;
    public final boolean e;
    public String f;

    public sw3(Method method, Class cls, ThreadMode threadMode, int i, boolean z) {
        this.a = method;
        this.b = threadMode;
        this.c = cls;
        this.d = i;
        this.e = z;
    }

    public final synchronized void a() {
        if (this.f == null) {
            StringBuilder sb = new StringBuilder(64);
            sb.append(this.a.getDeclaringClass().getName());
            sb.append('#');
            sb.append(this.a.getName());
            sb.append('(');
            sb.append(this.c.getName());
            this.f = sb.toString();
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof sw3)) {
            return false;
        }
        a();
        sw3 sw3Var = (sw3) obj;
        sw3Var.a();
        return this.f.equals(sw3Var.f);
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
