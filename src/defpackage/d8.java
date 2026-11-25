package defpackage;

import java.util.Map;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* loaded from: /tmp/classes2.dex */
public interface d8 {

    /* loaded from: /tmp/classes2.dex */
    public static final class a {
        public static r51 a(d8 d8Var) {
            m00 i = DescriptorUtilsKt.i(d8Var);
            if (i != null) {
                if (xu0.m(i)) {
                    i = null;
                }
                if (i != null) {
                    return DescriptorUtilsKt.h(i);
                }
            }
            return null;
        }
    }

    r51 d();

    fx1 getType();

    xr3 j();

    Map k();
}
