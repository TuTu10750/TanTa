package defpackage;

import com.zzhoujay.richtext.cache.CacheIOHelper;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.g;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.a;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;

/* loaded from: /tmp/classes2.dex */
public final class gl0 extends up3 implements yk0 {
    public final ProtoBuf$Function E;
    public final ap2 F;
    public final cb4 G;
    public final fg4 H;
    public final bl0 I;

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public gl0(defpackage.ra0 r8, kotlin.reflect.jvm.internal.impl.descriptors.g r9, defpackage.j8 r10, defpackage.zo2 r11, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind r12, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function r13, defpackage.ap2 r14, defpackage.cb4 r15, defpackage.fg4 r16, defpackage.bl0 r17, defpackage.xr3 r18) {
        /*
            r7 = this;
            r8.getClass()
            r10.getClass()
            r11.getClass()
            r12.getClass()
            r13.getClass()
            r14.getClass()
            r15.getClass()
            r16.getClass()
            if (r18 != 0) goto L24
            xr3 r0 = defpackage.xr3.a
            r6 = r0
            r1 = r8
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r12
            r0 = r7
            goto L2c
        L24:
            r6 = r18
            r0 = r7
            r1 = r8
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r12
        L2c:
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r7.E = r13
            r7.F = r14
            r7.G = r15
            r1 = r16
            r7.H = r1
            r1 = r17
            r7.I = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.gl0.<init>(ra0, kotlin.reflect.jvm.internal.impl.descriptors.g, j8, zo2, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function, ap2, cb4, fg4, bl0, xr3):void");
    }

    public /* synthetic */ gl0(ra0 ra0Var, g gVar, j8 j8Var, zo2 zo2Var, CallableMemberDescriptor.Kind kind, ProtoBuf$Function protoBuf$Function, ap2 ap2Var, cb4 cb4Var, fg4 fg4Var, bl0 bl0Var, xr3 xr3Var, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(ra0Var, gVar, j8Var, zo2Var, kind, protoBuf$Function, ap2Var, cb4Var, fg4Var, bl0Var, (i & CacheIOHelper.BUFFER_SIZE) != 0 ? null : xr3Var);
    }

    @Override // defpackage.up3, kotlin.reflect.jvm.internal.impl.descriptors.impl.a
    public a L0(ra0 ra0Var, e eVar, CallableMemberDescriptor.Kind kind, zo2 zo2Var, j8 j8Var, xr3 xr3Var) {
        zo2 zo2Var2;
        ra0Var.getClass();
        kind.getClass();
        j8Var.getClass();
        xr3Var.getClass();
        g gVar = (g) eVar;
        if (zo2Var == null) {
            zo2 name = getName();
            name.getClass();
            zo2Var2 = name;
        } else {
            zo2Var2 = zo2Var;
        }
        gl0 gl0Var = new gl0(ra0Var, gVar, j8Var, zo2Var2, kind, D(), Z(), R(), q1(), c0(), xr3Var);
        gl0Var.Y0(Q0());
        return gl0Var;
    }

    @Override // defpackage.cl0
    public cb4 R() {
        return this.G;
    }

    @Override // defpackage.cl0
    public ap2 Z() {
        return this.F;
    }

    @Override // defpackage.cl0
    public bl0 c0() {
        return this.I;
    }

    @Override // defpackage.cl0
    /* renamed from: p1, reason: merged with bridge method [inline-methods] */
    public ProtoBuf$Function D() {
        return this.E;
    }

    public fg4 q1() {
        return this.H;
    }
}
