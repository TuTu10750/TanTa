package defpackage;

import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$MemberKind;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Modality;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Visibility;
import kotlin.reflect.jvm.internal.impl.protobuf.f;

/* loaded from: /tmp/classes2.dex */
public abstract class e31 {
    public static final b A;
    public static final b B;
    public static final b C;
    public static final b D;
    public static final b E;
    public static final b F;
    public static final b G;
    public static final b H;
    public static final b I;
    public static final b J;
    public static final b K;
    public static final b L;
    public static final b M;
    public static final b N;
    public static final b O;
    public static final b a;
    public static final b b;
    public static final b c;
    public static final d d;
    public static final d e;
    public static final d f;
    public static final b g;
    public static final b h;
    public static final b i;
    public static final b j;
    public static final b k;
    public static final b l;
    public static final b m;
    public static final b n;
    public static final d o;
    public static final b p;
    public static final b q;
    public static final b r;
    public static final b s;
    public static final b t;
    public static final b u;
    public static final b v;
    public static final b w;
    public static final b x;
    public static final b y;
    public static final b z;

    /* loaded from: /tmp/classes2.dex */
    public static class b extends d {
        public b(int i) {
            super(i, 1);
        }

        @Override // e31.d
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public Boolean d(int i) {
            return Boolean.valueOf(((1 << this.a) & i) != 0);
        }

        @Override // e31.d
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public int e(Boolean bool) {
            if (bool.booleanValue()) {
                return 1 << this.a;
            }
            return 0;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static class c extends d {
        public final f.a[] c;

        public c(int i, f.a[] aVarArr) {
            super(i, g(aVarArr));
            this.c = aVarArr;
        }

        private static /* synthetic */ void f(int i) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "enumEntries", "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags$EnumLiteFlagField", "bitWidth"));
        }

        public static int g(Object[] objArr) {
            if (objArr == null) {
                f(0);
            }
            int length = objArr.length - 1;
            if (length == 0) {
                return 1;
            }
            for (int i = 31; i >= 0; i--) {
                if (((1 << i) & length) != 0) {
                    return i + 1;
                }
            }
            di3.a("Empty enum: ", objArr.getClass());
            return 0;
        }

        @Override // e31.d
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public f.a d(int i) {
            int i2 = (1 << this.b) - 1;
            int i3 = this.a;
            int i4 = (i & (i2 << i3)) >> i3;
            for (f.a aVar : this.c) {
                if (aVar.getNumber() == i4) {
                    return aVar;
                }
            }
            return null;
        }

        @Override // e31.d
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public int e(f.a aVar) {
            return aVar.getNumber() << this.a;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static abstract class d {
        public final int a;
        public final int b;

        public d(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        public static d a(d dVar, f.a[] aVarArr) {
            return new c(dVar.a + dVar.b, aVarArr);
        }

        public static b b(d dVar) {
            return new b(dVar.a + dVar.b);
        }

        public static b c() {
            return new b(0);
        }

        public abstract Object d(int i);

        public abstract int e(Object obj);
    }

    static {
        b c2 = d.c();
        a = c2;
        b = d.b(c2);
        b c3 = d.c();
        c = c3;
        d a2 = d.a(c3, ProtoBuf$Visibility.values());
        d = a2;
        d a3 = d.a(a2, ProtoBuf$Modality.values());
        e = a3;
        d a4 = d.a(a3, ProtoBuf$Class.Kind.values());
        f = a4;
        b b2 = d.b(a4);
        g = b2;
        b b3 = d.b(b2);
        h = b3;
        b b4 = d.b(b3);
        i = b4;
        b b5 = d.b(b4);
        j = b5;
        b b6 = d.b(b5);
        k = b6;
        l = d.b(b6);
        b b7 = d.b(a2);
        m = b7;
        n = d.b(b7);
        d a5 = d.a(a3, ProtoBuf$MemberKind.values());
        o = a5;
        b b8 = d.b(a5);
        p = b8;
        b b9 = d.b(b8);
        q = b9;
        b b10 = d.b(b9);
        r = b10;
        b b11 = d.b(b10);
        s = b11;
        b b12 = d.b(b11);
        t = b12;
        b b13 = d.b(b12);
        u = b13;
        b b14 = d.b(b13);
        v = b14;
        w = d.b(b14);
        b b15 = d.b(a5);
        x = b15;
        b b16 = d.b(b15);
        y = b16;
        b b17 = d.b(b16);
        z = b17;
        b b18 = d.b(b17);
        A = b18;
        b b19 = d.b(b18);
        B = b19;
        b b20 = d.b(b19);
        C = b20;
        b b21 = d.b(b20);
        D = b21;
        b b22 = d.b(b21);
        E = b22;
        F = d.b(b22);
        b b23 = d.b(c3);
        G = b23;
        b b24 = d.b(b23);
        H = b24;
        I = d.b(b24);
        b b25 = d.b(a3);
        J = b25;
        b b26 = d.b(b25);
        K = b26;
        L = d.b(b26);
        b c4 = d.c();
        M = c4;
        N = d.b(c4);
        O = d.c();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void a(int r5) {
        /*
            r0 = 3
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r1 = 0
            r2 = 2
            r3 = 1
            if (r5 == r3) goto L2b
            if (r5 == r2) goto L26
            r4 = 5
            if (r5 == r4) goto L2b
            r4 = 6
            if (r5 == r4) goto L21
            r4 = 8
            if (r5 == r4) goto L2b
            r4 = 9
            if (r5 == r4) goto L21
            r4 = 11
            if (r5 == r4) goto L2b
            java.lang.String r4 = "visibility"
            r0[r1] = r4
            goto L2f
        L21:
            java.lang.String r4 = "memberKind"
            r0[r1] = r4
            goto L2f
        L26:
            java.lang.String r4 = "kind"
            r0[r1] = r4
            goto L2f
        L2b:
            java.lang.String r4 = "modality"
            r0[r1] = r4
        L2f:
            java.lang.String r1 = "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags"
            r0[r3] = r1
            switch(r5) {
                case 3: goto L4a;
                case 4: goto L45;
                case 5: goto L45;
                case 6: goto L45;
                case 7: goto L40;
                case 8: goto L40;
                case 9: goto L40;
                case 10: goto L3b;
                case 11: goto L3b;
                default: goto L36;
            }
        L36:
            java.lang.String r5 = "getClassFlags"
            r0[r2] = r5
            goto L4e
        L3b:
            java.lang.String r5 = "getAccessorFlags"
            r0[r2] = r5
            goto L4e
        L40:
            java.lang.String r5 = "getPropertyFlags"
            r0[r2] = r5
            goto L4e
        L45:
            java.lang.String r5 = "getFunctionFlags"
            r0[r2] = r5
            goto L4e
        L4a:
            java.lang.String r5 = "getConstructorFlags"
            r0[r2] = r5
        L4e:
            java.lang.String r5 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
            java.lang.String r5 = java.lang.String.format(r5, r0)
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.e31.a(int):void");
    }

    public static int b(boolean z2, ProtoBuf$Visibility protoBuf$Visibility, ProtoBuf$Modality protoBuf$Modality, boolean z3, boolean z4, boolean z5) {
        if (protoBuf$Visibility == null) {
            a(10);
        }
        if (protoBuf$Modality == null) {
            a(11);
        }
        return c.e(Boolean.valueOf(z2)) | e.e(protoBuf$Modality) | d.e(protoBuf$Visibility) | J.e(Boolean.valueOf(z3)) | K.e(Boolean.valueOf(z4)) | L.e(Boolean.valueOf(z5));
    }
}
