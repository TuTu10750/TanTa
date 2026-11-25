package defpackage;

import defpackage.fw1;
import defpackage.iw1;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.calls.a;

/* loaded from: /tmp/classes2.dex */
public abstract class qv1 {
    public static final boolean a(ov1 ov1Var) {
        a D;
        ov1Var.getClass();
        if (ov1Var instanceof fw1) {
            iw1 iw1Var = (iw1) ov1Var;
            Field b = td3.b(iw1Var);
            if (b != null ? b.isAccessible() : true) {
                Method c = td3.c(iw1Var);
                if (c != null ? c.isAccessible() : true) {
                    Method e = td3.e((fw1) ov1Var);
                    if (e != null ? e.isAccessible() : true) {
                        return true;
                    }
                }
            }
            return false;
        }
        if (ov1Var instanceof iw1) {
            iw1 iw1Var2 = (iw1) ov1Var;
            Field b2 = td3.b(iw1Var2);
            if (b2 != null ? b2.isAccessible() : true) {
                Method c2 = td3.c(iw1Var2);
                if (c2 != null ? c2.isAccessible() : true) {
                    return true;
                }
            }
            return false;
        }
        if (ov1Var instanceof iw1.b) {
            Field b3 = td3.b(((iw1.b) ov1Var).t());
            if (b3 != null ? b3.isAccessible() : true) {
                Method d = td3.d((aw1) ov1Var);
                if (d != null ? d.isAccessible() : true) {
                    return true;
                }
            }
            return false;
        }
        if (ov1Var instanceof fw1.a) {
            Field b4 = td3.b(((fw1.a) ov1Var).t());
            if (b4 != null ? b4.isAccessible() : true) {
                Method d2 = td3.d((aw1) ov1Var);
                if (d2 != null ? d2.isAccessible() : true) {
                    return true;
                }
            }
            return false;
        }
        if (!(ov1Var instanceof aw1)) {
            StringBuilder sb = new StringBuilder("Unknown callable: ");
            sb.append(ov1Var);
            Class<?> cls = ov1Var.getClass();
            sb.append(" (");
            sb.append(cls);
            sb.append(')');
            throw new UnsupportedOperationException(sb.toString());
        }
        aw1 aw1Var = (aw1) ov1Var;
        Method d3 = td3.d(aw1Var);
        if (d3 != null ? d3.isAccessible() : true) {
            KCallableImpl b5 = if4.b(ov1Var);
            Member b6 = (b5 == null || (D = b5.D()) == null) ? null : D.b();
            AccessibleObject accessibleObject = b6 instanceof AccessibleObject ? (AccessibleObject) b6 : null;
            if (accessibleObject != null ? accessibleObject.isAccessible() : true) {
                Constructor a = td3.a(aw1Var);
                if (a != null ? a.isAccessible() : true) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final void b(ov1 ov1Var, boolean z) {
        a D;
        ov1Var.getClass();
        if (ov1Var instanceof fw1) {
            iw1 iw1Var = (iw1) ov1Var;
            Field b = td3.b(iw1Var);
            if (b != null) {
                b.setAccessible(z);
            }
            Method c = td3.c(iw1Var);
            if (c != null) {
                c.setAccessible(z);
            }
            Method e = td3.e((fw1) ov1Var);
            if (e == null) {
                return;
            }
            e.setAccessible(z);
            return;
        }
        if (ov1Var instanceof iw1) {
            iw1 iw1Var2 = (iw1) ov1Var;
            Field b2 = td3.b(iw1Var2);
            if (b2 != null) {
                b2.setAccessible(z);
            }
            Method c2 = td3.c(iw1Var2);
            if (c2 == null) {
                return;
            }
            c2.setAccessible(z);
            return;
        }
        if (ov1Var instanceof iw1.b) {
            Field b3 = td3.b(((iw1.b) ov1Var).t());
            if (b3 != null) {
                b3.setAccessible(z);
            }
            Method d = td3.d((aw1) ov1Var);
            if (d == null) {
                return;
            }
            d.setAccessible(z);
            return;
        }
        if (ov1Var instanceof fw1.a) {
            Field b4 = td3.b(((fw1.a) ov1Var).t());
            if (b4 != null) {
                b4.setAccessible(z);
            }
            Method d2 = td3.d((aw1) ov1Var);
            if (d2 == null) {
                return;
            }
            d2.setAccessible(z);
            return;
        }
        if (!(ov1Var instanceof aw1)) {
            StringBuilder sb = new StringBuilder("Unknown callable: ");
            sb.append(ov1Var);
            Class<?> cls = ov1Var.getClass();
            sb.append(" (");
            sb.append(cls);
            sb.append(')');
            throw new UnsupportedOperationException(sb.toString());
        }
        aw1 aw1Var = (aw1) ov1Var;
        Method d3 = td3.d(aw1Var);
        if (d3 != null) {
            d3.setAccessible(z);
        }
        KCallableImpl b5 = if4.b(ov1Var);
        Member b6 = (b5 == null || (D = b5.D()) == null) ? null : D.b();
        AccessibleObject accessibleObject = b6 instanceof AccessibleObject ? (AccessibleObject) b6 : null;
        if (accessibleObject != null) {
            accessibleObject.setAccessible(true);
        }
        Constructor a = td3.a(aw1Var);
        if (a == null) {
            return;
        }
        a.setAccessible(z);
    }
}
