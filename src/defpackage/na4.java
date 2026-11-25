package defpackage;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: /tmp/classes2.dex */
public final class na4 {
    public static final a k = new a(null);
    public static final na4 l;
    public static final na4 m;
    public static final na4 n;
    public static final na4 o;
    public static final na4 p;
    public static final na4 q;
    public static final na4 r;
    public static final na4 s;
    public static final na4 t;
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final na4 f;
    public final boolean g;
    public final na4 h;
    public final na4 i;
    public final boolean j;

    /* loaded from: /tmp/classes2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Variance.values().length];
            try {
                iArr[Variance.IN_VARIANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Variance.INVARIANT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    static {
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        na4 na4Var = new na4(z, z2, z3, z4, z5, null, false, null, null, z6, 1023, null);
        l = na4Var;
        na4 na4Var2 = new na4(false, false, z6, false, false, null, false, null, null, true, 511, null);
        m = na4Var2;
        n = new na4(false, true, false, false, false, null, false, null, null, false, 1021, null);
        o = new na4(z, z2, z3, z4, z5, na4Var, false, null, null, z6, 988, null);
        p = new na4(false, false, z6, false, false, na4Var2, false, null, null, true, 476, null);
        DefaultConstructorMarker defaultConstructorMarker = null;
        boolean z7 = false;
        na4 na4Var3 = null;
        na4 na4Var4 = null;
        q = new na4(z, true, z3, z4, z5, na4Var, z7, na4Var3, na4Var4, z6, 988, defaultConstructorMarker);
        boolean z8 = false;
        boolean z9 = true;
        r = new na4(z, z8, z3, z9, z5, na4Var, z7, na4Var3, na4Var4, z6, 983, defaultConstructorMarker);
        s = new na4(z, z8, z3, z9, z5, na4Var, z7, na4Var3, na4Var4, z6, 919, defaultConstructorMarker);
        t = new na4(z, z8, true, false, z5, na4Var, z7, na4Var3, na4Var4, z6, 984, defaultConstructorMarker);
    }

    public na4(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, na4 na4Var, boolean z6, na4 na4Var2, na4 na4Var3, boolean z7) {
        this.a = z;
        this.b = z2;
        this.c = z3;
        this.d = z4;
        this.e = z5;
        this.f = na4Var;
        this.g = z6;
        this.h = na4Var2;
        this.i = na4Var3;
        this.j = z7;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ na4(boolean r3, boolean r4, boolean r5, boolean r6, boolean r7, defpackage.na4 r8, boolean r9, defpackage.na4 r10, defpackage.na4 r11, boolean r12, int r13, kotlin.jvm.internal.DefaultConstructorMarker r14) {
        /*
            r2 = this;
            r14 = r13 & 1
            r0 = 1
            if (r14 == 0) goto L6
            r3 = r0
        L6:
            r14 = r13 & 2
            if (r14 == 0) goto Lb
            r4 = r0
        Lb:
            r14 = r13 & 4
            r1 = 0
            if (r14 == 0) goto L11
            r5 = r1
        L11:
            r14 = r13 & 8
            if (r14 == 0) goto L16
            r6 = r1
        L16:
            r14 = r13 & 16
            if (r14 == 0) goto L1b
            r7 = r1
        L1b:
            r14 = r13 & 32
            if (r14 == 0) goto L20
            r8 = 0
        L20:
            r14 = r13 & 64
            if (r14 == 0) goto L25
            r9 = r0
        L25:
            r14 = r13 & 128(0x80, float:1.8E-43)
            if (r14 == 0) goto L2a
            r10 = r8
        L2a:
            r14 = r13 & 256(0x100, float:3.59E-43)
            if (r14 == 0) goto L2f
            r11 = r8
        L2f:
            r13 = r13 & 512(0x200, float:7.17E-43)
            if (r13 == 0) goto L34
            r12 = r1
        L34:
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.na4.<init>(boolean, boolean, boolean, boolean, boolean, na4, boolean, na4, na4, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final boolean a() {
        return this.g;
    }

    public final boolean b() {
        return this.j;
    }

    public final boolean c() {
        return this.b;
    }

    public final boolean d() {
        return this.a;
    }

    public final boolean e() {
        return this.c;
    }

    public final na4 f(Variance variance, boolean z) {
        variance.getClass();
        if (!z || !this.c) {
            int i = b.a[variance.ordinal()];
            if (i == 1) {
                na4 na4Var = this.h;
                if (na4Var != null) {
                    return na4Var;
                }
            } else if (i != 2) {
                na4 na4Var2 = this.f;
                if (na4Var2 != null) {
                    return na4Var2;
                }
            } else {
                na4 na4Var3 = this.i;
                if (na4Var3 != null) {
                    return na4Var3;
                }
            }
        }
        return this;
    }

    public final na4 g() {
        return new na4(this.a, true, this.c, this.d, this.e, this.f, this.g, this.h, this.i, false, IjkMediaMeta.FF_PROFILE_H264_CONSTRAINED, null);
    }
}
