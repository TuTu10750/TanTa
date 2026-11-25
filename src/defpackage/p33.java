package defpackage;

import com.uc.crashsdk.export.CrashStatKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.f;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.d;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.l;

/* loaded from: /tmp/classes2.dex */
public class p33 extends d implements o33 {
    public v01 A;
    public v01 B;
    public final Modality i;
    public pk0 j;
    public Collection k;
    public final o33 l;
    public final CallableMemberDescriptor.Kind m;
    public final boolean n;
    public final boolean o;
    public final boolean p;
    public final boolean q;
    public final boolean r;
    public final boolean s;
    public List t;
    public zb3 u;
    public zb3 v;
    public List w;
    public r33 x;
    public s33 y;
    public boolean z;

    /* loaded from: /tmp/classes2.dex */
    public class a {
        public ra0 a;
        public Modality b;
        public pk0 c;
        public CallableMemberDescriptor.Kind f;
        public zb3 i;
        public zo2 k;
        public fx1 l;
        public o33 d = null;
        public boolean e = false;
        public l g = l.b;
        public boolean h = true;
        public List j = null;

        public a() {
            this.a = p33.this.b();
            this.b = p33.this.l();
            this.c = p33.this.getVisibility();
            this.f = p33.this.i();
            this.i = p33.this.u;
            this.k = p33.this.getName();
            this.l = p33.this.getType();
        }

        public static /* synthetic */ void a(int i) {
            String str = (i == 1 || i == 2 || i == 3 || i == 5 || i == 7 || i == 9 || i == 11 || i == 19 || i == 13 || i == 14 || i == 16 || i == 17) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i == 1 || i == 2 || i == 3 || i == 5 || i == 7 || i == 9 || i == 11 || i == 19 || i == 13 || i == 14 || i == 16 || i == 17) ? 2 : 3];
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 5:
                case 7:
                case 9:
                case 11:
                case 13:
                case 14:
                case 16:
                case 17:
                case CrashStatKey.LOG_UPLOAD_BYTES_LIMIT /* 19 */:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl$CopyConfiguration";
                    break;
                case 4:
                    objArr[0] = "type";
                    break;
                case 6:
                    objArr[0] = "modality";
                    break;
                case 8:
                    objArr[0] = "visibility";
                    break;
                case 10:
                    objArr[0] = "kind";
                    break;
                case 12:
                    objArr[0] = "typeParameters";
                    break;
                case 15:
                    objArr[0] = "substitution";
                    break;
                case 18:
                    objArr[0] = "name";
                    break;
                default:
                    objArr[0] = "owner";
                    break;
            }
            if (i == 1) {
                objArr[1] = "setOwner";
            } else if (i == 2) {
                objArr[1] = "setOriginal";
            } else if (i == 3) {
                objArr[1] = "setPreserveSourceElement";
            } else if (i == 5) {
                objArr[1] = "setReturnType";
            } else if (i == 7) {
                objArr[1] = "setModality";
            } else if (i == 9) {
                objArr[1] = "setVisibility";
            } else if (i == 11) {
                objArr[1] = "setKind";
            } else if (i == 19) {
                objArr[1] = "setName";
            } else if (i == 13) {
                objArr[1] = "setTypeParameters";
            } else if (i == 14) {
                objArr[1] = "setDispatchReceiverParameter";
            } else if (i == 16) {
                objArr[1] = "setSubstitution";
            } else if (i != 17) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl$CopyConfiguration";
            } else {
                objArr[1] = "setCopyOverrides";
            }
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 5:
                case 7:
                case 9:
                case 11:
                case 13:
                case 14:
                case 16:
                case 17:
                case CrashStatKey.LOG_UPLOAD_BYTES_LIMIT /* 19 */:
                    break;
                case 4:
                    objArr[2] = "setReturnType";
                    break;
                case 6:
                    objArr[2] = "setModality";
                    break;
                case 8:
                    objArr[2] = "setVisibility";
                    break;
                case 10:
                    objArr[2] = "setKind";
                    break;
                case 12:
                    objArr[2] = "setTypeParameters";
                    break;
                case 15:
                    objArr[2] = "setSubstitution";
                    break;
                case 18:
                    objArr[2] = "setName";
                    break;
                default:
                    objArr[2] = "setOwner";
                    break;
            }
            String format = String.format(str, objArr);
            if (i != 1 && i != 2 && i != 3 && i != 5 && i != 7 && i != 9 && i != 11 && i != 19 && i != 13 && i != 14 && i != 16 && i != 17) {
                throw new IllegalArgumentException(format);
            }
            throw new IllegalStateException(format);
        }

        public o33 n() {
            return p33.this.Q0(this);
        }

        public q33 o() {
            o33 o33Var = this.d;
            if (o33Var == null) {
                return null;
            }
            return o33Var.f();
        }

        public s33 p() {
            o33 o33Var = this.d;
            if (o33Var == null) {
                return null;
            }
            return o33Var.g();
        }

        public a q(boolean z) {
            this.h = z;
            return this;
        }

        public a r(CallableMemberDescriptor.Kind kind) {
            if (kind == null) {
                a(10);
            }
            this.f = kind;
            return this;
        }

        public a s(Modality modality) {
            if (modality == null) {
                a(6);
            }
            this.b = modality;
            return this;
        }

        public a t(CallableMemberDescriptor callableMemberDescriptor) {
            this.d = (o33) callableMemberDescriptor;
            return this;
        }

        public a u(ra0 ra0Var) {
            if (ra0Var == null) {
                a(0);
            }
            this.a = ra0Var;
            return this;
        }

        public a v(l lVar) {
            if (lVar == null) {
                a(15);
            }
            this.g = lVar;
            return this;
        }

        public a w(pk0 pk0Var) {
            if (pk0Var == null) {
                a(8);
            }
            this.c = pk0Var;
            return this;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p33(ra0 ra0Var, o33 o33Var, j8 j8Var, Modality modality, pk0 pk0Var, boolean z, zo2 zo2Var, CallableMemberDescriptor.Kind kind, xr3 xr3Var, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        super(ra0Var, j8Var, zo2Var, null, z, xr3Var);
        if (ra0Var == null) {
            H(0);
        }
        if (j8Var == null) {
            H(1);
        }
        if (modality == null) {
            H(2);
        }
        if (pk0Var == null) {
            H(3);
        }
        if (zo2Var == null) {
            H(4);
        }
        if (kind == null) {
            H(5);
        }
        if (xr3Var == null) {
            H(6);
        }
        this.k = null;
        this.t = Collections.EMPTY_LIST;
        this.i = modality;
        this.j = pk0Var;
        this.l = o33Var == null ? this : o33Var;
        this.m = kind;
        this.n = z2;
        this.o = z3;
        this.p = z4;
        this.q = z5;
        this.r = z6;
        this.s = z7;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x011e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static /* synthetic */ void H(int r11) {
        /*
            Method dump skipped, instructions count: 538
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.p33.H(int):void");
    }

    public static p33 O0(ra0 ra0Var, j8 j8Var, Modality modality, pk0 pk0Var, boolean z, zo2 zo2Var, CallableMemberDescriptor.Kind kind, xr3 xr3Var, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        if (ra0Var == null) {
            H(7);
        }
        if (j8Var == null) {
            H(8);
        }
        if (modality == null) {
            H(9);
        }
        if (pk0Var == null) {
            H(10);
        }
        if (zo2Var == null) {
            H(11);
        }
        if (kind == null) {
            H(12);
        }
        if (xr3Var == null) {
            H(13);
        }
        return new p33(ra0Var, null, j8Var, modality, pk0Var, z, zo2Var, kind, xr3Var, z2, z3, z4, z5, z6, z7);
    }

    public static e T0(TypeSubstitutor typeSubstitutor, f fVar) {
        if (typeSubstitutor == null) {
            H(30);
        }
        if (fVar == null) {
            H(31);
        }
        if (fVar.d0() != null) {
            return fVar.d0().c(typeSubstitutor);
        }
        return null;
    }

    public static pk0 Y0(pk0 pk0Var, CallableMemberDescriptor.Kind kind) {
        return (kind == CallableMemberDescriptor.Kind.FAKE_OVERRIDE && ok0.g(pk0Var.f())) ? ok0.h : pk0Var;
    }

    public static zb3 d1(TypeSubstitutor typeSubstitutor, o33 o33Var, zb3 zb3Var) {
        fx1 p = typeSubstitutor.p(zb3Var.getType(), Variance.IN_VARIANCE);
        if (p == null) {
            return null;
        }
        return new ac3(o33Var, new p60(o33Var, p, ((sn1) zb3Var.getValue()).a(), zb3Var.getValue()), zb3Var.getAnnotations());
    }

    public static zb3 e1(TypeSubstitutor typeSubstitutor, o33 o33Var, zb3 zb3Var) {
        fx1 p = typeSubstitutor.p(zb3Var.getType(), Variance.IN_VARIANCE);
        if (p == null) {
            return null;
        }
        return new ac3(o33Var, new wy0(o33Var, p, zb3Var.getValue()), zb3Var.getAnnotations());
    }

    @Override // defpackage.ck2
    public boolean E0() {
        return this.q;
    }

    @Override // defpackage.ck2
    public boolean K() {
        return this.p;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.i
    public boolean N() {
        return this.s;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    /* renamed from: N0, reason: merged with bridge method [inline-methods] */
    public o33 M(ra0 ra0Var, Modality modality, pk0 pk0Var, CallableMemberDescriptor.Kind kind, boolean z) {
        o33 n = X0().u(ra0Var).t(null).s(modality).w(pk0Var).r(kind).q(z).n();
        if (n == null) {
            H(42);
        }
        return n;
    }

    public p33 P0(ra0 ra0Var, Modality modality, pk0 pk0Var, o33 o33Var, CallableMemberDescriptor.Kind kind, zo2 zo2Var, xr3 xr3Var) {
        if (ra0Var == null) {
            H(32);
        }
        if (modality == null) {
            H(33);
        }
        if (pk0Var == null) {
            H(34);
        }
        if (kind == null) {
            H(35);
        }
        if (zo2Var == null) {
            H(36);
        }
        if (xr3Var == null) {
            H(37);
        }
        return new p33(ra0Var, o33Var, getAnnotations(), modality, pk0Var, i0(), zo2Var, kind, xr3Var, q0(), z(), K(), E0(), isExternal(), N());
    }

    public o33 Q0(a aVar) {
        zb3 zb3Var;
        l81 l81Var;
        if (aVar == null) {
            H(29);
        }
        p33 P0 = P0(aVar.a, aVar.b, aVar.c, aVar.d, aVar.f, aVar.k, S0(aVar.e, aVar.d));
        List typeParameters = aVar.j == null ? getTypeParameters() : aVar.j;
        ArrayList arrayList = new ArrayList(typeParameters.size());
        TypeSubstitutor b = jk0.b(typeParameters, aVar.g, P0, arrayList);
        fx1 fx1Var = aVar.l;
        fx1 p = b.p(fx1Var, Variance.OUT_VARIANCE);
        if (p == null) {
            return null;
        }
        fx1 p2 = b.p(fx1Var, Variance.IN_VARIANCE);
        if (p2 != null) {
            P0.Z0(p2);
        }
        zb3 zb3Var2 = aVar.i;
        if (zb3Var2 != null) {
            zb3 c = zb3Var2.c(b);
            if (c == null) {
                return null;
            }
            zb3Var = c;
        } else {
            zb3Var = null;
        }
        zb3 zb3Var3 = this.v;
        zb3 e1 = zb3Var3 != null ? e1(b, P0, zb3Var3) : null;
        ArrayList arrayList2 = new ArrayList();
        Iterator it = this.t.iterator();
        while (it.hasNext()) {
            zb3 d1 = d1(b, P0, (zb3) it.next());
            if (d1 != null) {
                arrayList2.add(d1);
            }
        }
        P0.b1(p, arrayList, zb3Var, e1, arrayList2);
        r33 r33Var = this.x == null ? null : new r33(P0, this.x.getAnnotations(), aVar.b, Y0(this.x.getVisibility(), aVar.f), this.x.T(), this.x.isExternal(), this.x.isInline(), aVar.f, aVar.o(), xr3.a);
        if (r33Var != null) {
            fx1 returnType = this.x.getReturnType();
            r33Var.M0(T0(b, this.x));
            r33Var.P0(returnType != null ? b.p(returnType, Variance.OUT_VARIANCE) : null);
        }
        t33 t33Var = this.y == null ? null : new t33(P0, this.y.getAnnotations(), aVar.b, Y0(this.y.getVisibility(), aVar.f), this.y.T(), this.y.isExternal(), this.y.isInline(), aVar.f, aVar.p(), xr3.a);
        if (t33Var != null) {
            List P02 = kotlin.reflect.jvm.internal.impl.descriptors.impl.a.P0(t33Var, this.y.h(), b, false, false, null);
            if (P02 == null) {
                P0.a1(true);
                P02 = Collections.singletonList(t33.O0(t33Var, DescriptorUtilsKt.j(aVar.a).H(), ((h) this.y.h().get(0)).getAnnotations()));
            }
            if (P02.size() != 1) {
                pr4.a();
                return null;
            }
            t33Var.M0(T0(b, this.y));
            t33Var.Q0((h) P02.get(0));
        }
        v01 v01Var = this.A;
        w01 w01Var = v01Var == null ? null : new w01(v01Var.getAnnotations(), P0);
        v01 v01Var2 = this.B;
        P0.V0(r33Var, t33Var, w01Var, v01Var2 == null ? null : new w01(v01Var2.getAnnotations(), P0));
        if (aVar.h) {
            zq3 g = zq3.g();
            Iterator it2 = e().iterator();
            while (it2.hasNext()) {
                g.add(((o33) it2.next()).c(b));
            }
            P0.w0(g);
        }
        if (z() && (l81Var = this.h) != null) {
            P0.K0(this.g, l81Var);
        }
        return P0;
    }

    @Override // defpackage.o33
    /* renamed from: R0, reason: merged with bridge method [inline-methods] */
    public r33 f() {
        return this.x;
    }

    public final xr3 S0(boolean z, o33 o33Var) {
        xr3 xr3Var;
        if (z) {
            if (o33Var == null) {
                o33Var = a();
            }
            xr3Var = o33Var.j();
        } else {
            xr3Var = xr3.a;
        }
        if (xr3Var == null) {
            H(28);
        }
        return xr3Var;
    }

    public void U0(r33 r33Var, s33 s33Var) {
        V0(r33Var, s33Var, null, null);
    }

    public void V0(r33 r33Var, s33 s33Var, v01 v01Var, v01 v01Var2) {
        this.x = r33Var;
        this.y = s33Var;
        this.A = v01Var;
        this.B = v01Var2;
    }

    @Override // defpackage.ra0
    public Object W(va0 va0Var, Object obj) {
        return va0Var.c(this, obj);
    }

    public boolean W0() {
        return this.z;
    }

    public a X0() {
        return new a();
    }

    public void Z0(fx1 fx1Var) {
        if (fx1Var == null) {
            H(14);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [o33] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    @Override // defpackage.ua0, defpackage.sa0, defpackage.ra0, defpackage.z00
    public o33 a() {
        o33 o33Var = this.l;
        ?? r1 = this;
        if (o33Var != this) {
            r1 = o33Var.a();
        }
        if (r1 == 0) {
            H(38);
        }
        return r1;
    }

    public void a1(boolean z) {
        this.z = z;
    }

    public void b1(fx1 fx1Var, List list, zb3 zb3Var, zb3 zb3Var2, List list2) {
        if (fx1Var == null) {
            H(17);
        }
        if (list == null) {
            H(18);
        }
        if (list2 == null) {
            H(19);
        }
        F0(fx1Var);
        this.w = new ArrayList(list);
        this.v = zb3Var2;
        this.u = zb3Var;
        this.t = list2;
    }

    @Override // defpackage.vw3
    public o33 c(TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor == null) {
            H(27);
        }
        return typeSubstitutor.k() ? this : X0().v(typeSubstitutor.j()).t(a()).n();
    }

    public void c1(pk0 pk0Var) {
        if (pk0Var == null) {
            H(20);
        }
        this.j = pk0Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public Collection e() {
        Collection collection = this.k;
        if (collection == null) {
            collection = Collections.EMPTY_LIST;
        }
        if (collection == null) {
            H(41);
        }
        return collection;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.c, kotlin.reflect.jvm.internal.impl.descriptors.a
    public zb3 e0() {
        return this.u;
    }

    @Override // defpackage.o33
    public s33 g() {
        return this.y;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.c, kotlin.reflect.jvm.internal.impl.descriptors.a
    public fx1 getReturnType() {
        fx1 type = getType();
        if (type == null) {
            H(23);
        }
        return type;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.c, kotlin.reflect.jvm.internal.impl.descriptors.a
    public List getTypeParameters() {
        List list = this.w;
        if (list != null) {
            return list;
        }
        throw new IllegalStateException("typeParameters == null for " + toString());
    }

    @Override // defpackage.ya0
    public pk0 getVisibility() {
        pk0 pk0Var = this.j;
        if (pk0Var == null) {
            H(25);
        }
        return pk0Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public Object h0(a.InterfaceC0097a interfaceC0097a) {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public CallableMemberDescriptor.Kind i() {
        CallableMemberDescriptor.Kind kind = this.m;
        if (kind == null) {
            H(39);
        }
        return kind;
    }

    public boolean isExternal() {
        return this.r;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.c, kotlin.reflect.jvm.internal.impl.descriptors.a
    public zb3 k0() {
        return this.v;
    }

    @Override // defpackage.ck2
    public Modality l() {
        Modality modality = this.i;
        if (modality == null) {
            H(24);
        }
        return modality;
    }

    @Override // defpackage.o33
    public v01 l0() {
        return this.B;
    }

    @Override // defpackage.o33
    public v01 o0() {
        return this.A;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public List p0() {
        List list = this.t;
        if (list == null) {
            H(22);
        }
        return list;
    }

    @Override // defpackage.rf4
    public boolean q0() {
        return this.n;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public void w0(Collection collection) {
        if (collection == null) {
            H(40);
        }
        this.k = collection;
    }

    @Override // defpackage.o33
    public List x() {
        ArrayList arrayList = new ArrayList(2);
        r33 r33Var = this.x;
        if (r33Var != null) {
            arrayList.add(r33Var);
        }
        s33 s33Var = this.y;
        if (s33Var != null) {
            arrayList.add(s33Var);
        }
        return arrayList;
    }

    @Override // defpackage.rf4
    public boolean z() {
        return this.o;
    }
}
