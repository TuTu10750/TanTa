package defpackage;

import com.umeng.commonsdk.statistics.UMErrorCode;
import java.util.Iterator;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.types.j;

/* loaded from: /tmp/classes2.dex */
public abstract class zp3 extends gd4 implements aq3, t94 {
    public zp3() {
        super(null);
    }

    /* renamed from: U0 */
    public abstract zp3 R0(boolean z);

    /* renamed from: V0 */
    public abstract zp3 T0(j jVar);

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator it = getAnnotations().iterator();
        while (it.hasNext()) {
            cw3.o(sb, "[", DescriptorRenderer.s(DescriptorRenderer.j, (d8) it.next(), null, 2, null), "] ");
        }
        sb.append(N0());
        if (!L0().isEmpty()) {
            b30.i0(L0(), sb, ", ", "<", ">", 0, null, null, UMErrorCode.E_UM_BE_DEFLATE_FAILED, null);
        }
        if (O0()) {
            sb.append("?");
        }
        return sb.toString();
    }
}
