package defpackage;

import com.zzhoujay.richtext.cache.CacheIOHelper;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.c;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;

/* loaded from: /tmp/classes2.dex */
public final class zk0 extends j00 implements yk0 {
    public final ProtoBuf$Constructor F;
    public final ap2 G;
    public final cb4 H;
    public final fg4 I;
    public final bl0 J;

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public zk0(defpackage.m00 r8, kotlin.reflect.jvm.internal.impl.descriptors.c r9, defpackage.j8 r10, boolean r11, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind r12, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor r13, defpackage.ap2 r14, defpackage.cb4 r15, defpackage.fg4 r16, defpackage.bl0 r17, defpackage.xr3 r18) {
        /*
            r7 = this;
            r8.getClass()
            r10.getClass()
            r12.getClass()
            r13.getClass()
            r14.getClass()
            r15.getClass()
            r16.getClass()
            if (r18 != 0) goto L21
            xr3 r0 = defpackage.xr3.a
            r6 = r0
            r1 = r8
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r12
            r0 = r7
            goto L29
        L21:
            r6 = r18
            r0 = r7
            r1 = r8
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r12
        L29:
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r7.F = r13
            r7.G = r14
            r7.H = r15
            r1 = r16
            r7.I = r1
            r1 = r17
            r7.J = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.zk0.<init>(m00, kotlin.reflect.jvm.internal.impl.descriptors.c, j8, boolean, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor, ap2, cb4, fg4, bl0, xr3):void");
    }

    public /* synthetic */ zk0(m00 m00Var, c cVar, j8 j8Var, boolean z, CallableMemberDescriptor.Kind kind, ProtoBuf$Constructor protoBuf$Constructor, ap2 ap2Var, cb4 cb4Var, fg4 fg4Var, bl0 bl0Var, xr3 xr3Var, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(m00Var, cVar, j8Var, z, kind, protoBuf$Constructor, ap2Var, cb4Var, fg4Var, bl0Var, (i & CacheIOHelper.BUFFER_SIZE) != 0 ? null : xr3Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.a, kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean O() {
        return false;
    }

    @Override // defpackage.cl0
    public cb4 R() {
        return this.H;
    }

    @Override // defpackage.cl0
    public ap2 Z() {
        return this.G;
    }

    @Override // defpackage.cl0
    public bl0 c0() {
        return this.J;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.a, defpackage.ck2
    public boolean isExternal() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.a, kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean isInline() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.a, kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean isSuspend() {
        return false;
    }

    @Override // defpackage.j00
    /* renamed from: s1, reason: merged with bridge method [inline-methods] */
    public zk0 L0(ra0 ra0Var, e eVar, CallableMemberDescriptor.Kind kind, zo2 zo2Var, j8 j8Var, xr3 xr3Var) {
        ra0Var.getClass();
        kind.getClass();
        j8Var.getClass();
        xr3Var.getClass();
        zk0 zk0Var = new zk0((m00) ra0Var, (c) eVar, j8Var, this.E, kind, D(), Z(), R(), u1(), c0(), xr3Var);
        zk0Var.Y0(Q0());
        return zk0Var;
    }

    @Override // defpackage.cl0
    /* renamed from: t1, reason: merged with bridge method [inline-methods] */
    public ProtoBuf$Constructor D() {
        return this.F;
    }

    public fg4 u1() {
        return this.I;
    }
}
