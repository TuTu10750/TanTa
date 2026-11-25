package defpackage;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.b;
import kotlin.reflect.jvm.internal.impl.descriptors.c;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.a;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;

/* loaded from: /tmp/classes2.dex */
public class j00 extends a implements b {
    public final boolean E;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j00(m00 m00Var, c cVar, j8 j8Var, boolean z, CallableMemberDescriptor.Kind kind, xr3 xr3Var) {
        super(m00Var, cVar, j8Var, ls3.j, kind, xr3Var);
        if (m00Var == null) {
            H(0);
        }
        if (j8Var == null) {
            H(1);
        }
        if (kind == null) {
            H(2);
        }
        if (xr3Var == null) {
            H(3);
        }
        this.E = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0018  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00aa A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static /* synthetic */ void H(int r8) {
        /*
            Method dump skipped, instructions count: 354
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.j00.H(int):void");
    }

    public static j00 n1(m00 m00Var, j8 j8Var, boolean z, xr3 xr3Var) {
        if (m00Var == null) {
            H(4);
        }
        if (j8Var == null) {
            H(5);
        }
        if (xr3Var == null) {
            H(6);
        }
        return new j00(m00Var, null, j8Var, z, CallableMemberDescriptor.Kind.DECLARATION, xr3Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.c
    public boolean A() {
        return this.E;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.c
    public m00 B() {
        m00 b = b();
        if (b == null) {
            H(18);
        }
        return b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.a, defpackage.ra0
    public Object W(va0 va0Var, Object obj) {
        return va0Var.j(this, obj);
    }

    @Override // defpackage.ua0, defpackage.sa0, defpackage.ra0, defpackage.z00
    public b a() {
        b bVar = (b) super.a();
        if (bVar == null) {
            H(19);
        }
        return bVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.a, defpackage.vw3
    public b c(TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor == null) {
            H(20);
        }
        return (b) super.c(typeSubstitutor);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.a, kotlin.reflect.jvm.internal.impl.descriptors.e, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.a
    public Collection e() {
        Set set = Collections.EMPTY_SET;
        if (set == null) {
            H(21);
        }
        return set;
    }

    public final List k1() {
        m00 b = b();
        if (b.G0().isEmpty()) {
            List list = Collections.EMPTY_LIST;
            if (list == null) {
                H(16);
            }
            return list;
        }
        List G0 = b.G0();
        if (G0 == null) {
            H(15);
        }
        return G0;
    }

    public zb3 l1() {
        m00 b = b();
        if (!b.o()) {
            return null;
        }
        ra0 b2 = b.b();
        if (b2 instanceof m00) {
            return ((m00) b2).J0();
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    /* renamed from: m1, reason: merged with bridge method [inline-methods] */
    public b M(ra0 ra0Var, Modality modality, pk0 pk0Var, CallableMemberDescriptor.Kind kind, boolean z) {
        b bVar = (b) super.K0(ra0Var, modality, pk0Var, kind, z);
        if (bVar == null) {
            H(27);
        }
        return bVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.a
    /* renamed from: o1, reason: merged with bridge method [inline-methods] */
    public j00 L0(ra0 ra0Var, e eVar, CallableMemberDescriptor.Kind kind, zo2 zo2Var, j8 j8Var, xr3 xr3Var) {
        if (ra0Var == null) {
            H(23);
        }
        if (kind == null) {
            H(24);
        }
        if (j8Var == null) {
            H(25);
        }
        if (xr3Var == null) {
            H(26);
        }
        CallableMemberDescriptor.Kind kind2 = CallableMemberDescriptor.Kind.DECLARATION;
        if (kind == kind2 || kind == CallableMemberDescriptor.Kind.SYNTHESIZED) {
            return new j00((m00) ra0Var, this, j8Var, this.E, kind2, xr3Var);
        }
        throw new IllegalStateException("Attempt at creating a constructor that is not a declaration: \ncopy from: " + this + "\nnewOwner: " + ra0Var + "\nkind: " + kind);
    }

    @Override // defpackage.ua0, defpackage.ra0, defpackage.qf4, defpackage.ta0
    /* renamed from: p1, reason: merged with bridge method [inline-methods] */
    public m00 b() {
        m00 m00Var = (m00) super.b();
        if (m00Var == null) {
            H(17);
        }
        return m00Var;
    }

    public j00 q1(List list, pk0 pk0Var) {
        if (list == null) {
            H(13);
        }
        if (pk0Var == null) {
            H(14);
        }
        r1(list, pk0Var, b().w());
        return this;
    }

    public j00 r1(List list, pk0 pk0Var, List list2) {
        if (list == null) {
            H(10);
        }
        if (pk0Var == null) {
            H(11);
        }
        if (list2 == null) {
            H(12);
        }
        super.R0(null, l1(), k1(), list2, list, null, Modality.FINAL, pk0Var);
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.a, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public void w0(Collection collection) {
        if (collection == null) {
            H(22);
        }
    }
}
