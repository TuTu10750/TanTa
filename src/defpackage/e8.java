package defpackage;

import defpackage.d8;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;

/* loaded from: /tmp/classes2.dex */
public class e8 implements d8 {
    public final fx1 a;
    public final Map b;
    public final xr3 c;

    public e8(fx1 fx1Var, Map map, xr3 xr3Var) {
        if (fx1Var == null) {
            a(0);
        }
        if (map == null) {
            a(1);
        }
        if (xr3Var == null) {
            a(2);
        }
        this.a = fx1Var;
        this.b = map;
        this.c = xr3Var;
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 3 || i == 4 || i == 5) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 3 || i == 4 || i == 5) ? 2 : 3];
        if (i == 1) {
            objArr[0] = "valueArguments";
        } else if (i == 2) {
            objArr[0] = "source";
        } else if (i == 3 || i == 4 || i == 5) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl";
        } else {
            objArr[0] = "annotationType";
        }
        if (i == 3) {
            objArr[1] = "getType";
        } else if (i == 4) {
            objArr[1] = "getAllValueArguments";
        } else if (i != 5) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl";
        } else {
            objArr[1] = "getSource";
        }
        if (i != 3 && i != 4 && i != 5) {
            objArr[2] = "<init>";
        }
        String format = String.format(str, objArr);
        if (i != 3 && i != 4 && i != 5) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @Override // defpackage.d8
    public r51 d() {
        return d8.a.a(this);
    }

    @Override // defpackage.d8
    public fx1 getType() {
        fx1 fx1Var = this.a;
        if (fx1Var == null) {
            a(3);
        }
        return fx1Var;
    }

    @Override // defpackage.d8
    public xr3 j() {
        xr3 xr3Var = this.c;
        if (xr3Var == null) {
            a(5);
        }
        return xr3Var;
    }

    @Override // defpackage.d8
    public Map k() {
        Map map = this.b;
        if (map == null) {
            a(4);
        }
        return map;
    }

    public String toString() {
        return DescriptorRenderer.g.r(this, null);
    }
}
