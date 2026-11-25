package defpackage;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okio.ByteString;

/* loaded from: /tmp/classes2.dex */
public final class uw2 implements Comparable {
    public static final a b = new a(null);
    public static final String c;
    public final ByteString a;

    /* loaded from: /tmp/classes2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ uw2 d(a aVar, File file, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = false;
            }
            return aVar.a(file, z);
        }

        public static /* synthetic */ uw2 e(a aVar, String str, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = false;
            }
            return aVar.b(str, z);
        }

        public static /* synthetic */ uw2 f(a aVar, Path path, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = false;
            }
            return aVar.c(path, z);
        }

        public final uw2 a(File file, boolean z) {
            file.getClass();
            String file2 = file.toString();
            file2.getClass();
            return b(file2, z);
        }

        public final uw2 b(String str, boolean z) {
            str.getClass();
            return o.k(str, z);
        }

        public final uw2 c(Path path, boolean z) {
            path.getClass();
            return b(path.toString(), z);
        }
    }

    static {
        String str = File.separator;
        str.getClass();
        c = str;
    }

    public uw2(ByteString byteString) {
        byteString.getClass();
        this.a = byteString;
    }

    public static /* synthetic */ uw2 n(uw2 uw2Var, uw2 uw2Var2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return uw2Var.l(uw2Var2, z);
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(uw2 uw2Var) {
        uw2Var.getClass();
        return b().compareTo(uw2Var.b());
    }

    public final ByteString b() {
        return this.a;
    }

    public final uw2 c() {
        int o;
        o = o.o(this);
        if (o == -1) {
            return null;
        }
        return new uw2(b().I(0, o));
    }

    public final List d() {
        int o;
        ArrayList arrayList = new ArrayList();
        o = o.o(this);
        if (o == -1) {
            o = 0;
        } else if (o < b().G() && b().i(o) == 92) {
            o++;
        }
        int G = b().G();
        int i = o;
        while (o < G) {
            if (b().i(o) == 47 || b().i(o) == 92) {
                arrayList.add(b().I(i, o));
                i = o + 1;
            }
            o++;
        }
        if (i < b().G()) {
            arrayList.add(b().I(i, b().G()));
        }
        return arrayList;
    }

    public boolean equals(Object obj) {
        return (obj instanceof uw2) && dq1.a(((uw2) obj).b(), b());
    }

    public final String h() {
        return i().M();
    }

    public int hashCode() {
        return b().hashCode();
    }

    public final ByteString i() {
        int l;
        l = o.l(this);
        return l != -1 ? ByteString.J(b(), l + 1, 0, 2, null) : (p() == null || b().G() != 2) ? b() : ByteString.e;
    }

    public final boolean isAbsolute() {
        int o;
        o = o.o(this);
        return o != -1;
    }

    public final uw2 j() {
        ByteString byteString;
        ByteString byteString2;
        ByteString byteString3;
        boolean n;
        int l;
        ByteString byteString4;
        ByteString byteString5;
        ByteString b2 = b();
        byteString = o.d;
        if (!dq1.a(b2, byteString)) {
            ByteString b3 = b();
            byteString2 = o.a;
            if (!dq1.a(b3, byteString2)) {
                ByteString b4 = b();
                byteString3 = o.b;
                if (!dq1.a(b4, byteString3)) {
                    n = o.n(this);
                    if (!n) {
                        l = o.l(this);
                        if (l == 2 && p() != null) {
                            if (b().G() == 3) {
                                return null;
                            }
                            return new uw2(ByteString.J(b(), 0, 3, 1, null));
                        }
                        if (l == 1) {
                            ByteString b5 = b();
                            byteString5 = o.b;
                            if (b5.H(byteString5)) {
                                return null;
                            }
                        }
                        if (l == -1 && p() != null) {
                            if (b().G() == 2) {
                                return null;
                            }
                            return new uw2(ByteString.J(b(), 0, 2, 1, null));
                        }
                        if (l != -1) {
                            return l == 0 ? new uw2(ByteString.J(b(), 0, 1, 1, null)) : new uw2(ByteString.J(b(), 0, l, 1, null));
                        }
                        byteString4 = o.d;
                        return new uw2(byteString4);
                    }
                }
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0079, code lost:
    
        r9 = defpackage.o.m(r8);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.uw2 k(defpackage.uw2 r9) {
        /*
            r8 = this;
            r9.getClass()
            uw2 r0 = r8.c()
            uw2 r1 = r9.c()
            boolean r0 = defpackage.dq1.a(r0, r1)
            java.lang.String r1 = " and "
            if (r0 == 0) goto Ld1
            java.util.List r0 = r8.d()
            java.util.List r2 = r9.d()
            int r3 = r0.size()
            int r4 = r2.size()
            int r3 = java.lang.Math.min(r3, r4)
            r4 = 0
            r5 = r4
        L29:
            if (r5 >= r3) goto L3c
            java.lang.Object r6 = r0.get(r5)
            java.lang.Object r7 = r2.get(r5)
            boolean r6 = defpackage.dq1.a(r6, r7)
            if (r6 == 0) goto L3c
            int r5 = r5 + 1
            goto L29
        L3c:
            if (r5 != r3) goto L5b
            okio.ByteString r3 = r8.b()
            int r3 = r3.G()
            okio.ByteString r6 = r9.b()
            int r6 = r6.G()
            if (r3 != r6) goto L5b
            uw2$a r8 = defpackage.uw2.b
            java.lang.String r9 = "."
            r0 = 0
            r1 = 1
            uw2 r8 = uw2.a.e(r8, r9, r4, r1, r0)
            return r8
        L5b:
            int r3 = r2.size()
            java.util.List r3 = r2.subList(r5, r3)
            okio.ByteString r6 = defpackage.o.c()
            int r3 = r3.indexOf(r6)
            r6 = -1
            if (r3 != r6) goto Lb3
            lk r1 = new lk
            r1.<init>()
            okio.ByteString r9 = defpackage.o.f(r9)
            if (r9 != 0) goto L85
            okio.ByteString r9 = defpackage.o.f(r8)
            if (r9 != 0) goto L85
            java.lang.String r8 = defpackage.uw2.c
            okio.ByteString r9 = defpackage.o.i(r8)
        L85:
            int r8 = r2.size()
            r2 = r5
        L8a:
            if (r2 >= r8) goto L99
            okio.ByteString r3 = defpackage.o.c()
            r1.l0(r3)
            r1.l0(r9)
            int r2 = r2 + 1
            goto L8a
        L99:
            int r8 = r0.size()
        L9d:
            if (r5 >= r8) goto Lae
            java.lang.Object r2 = r0.get(r5)
            okio.ByteString r2 = (okio.ByteString) r2
            r1.l0(r2)
            r1.l0(r9)
            int r5 = r5 + 1
            goto L9d
        Lae:
            uw2 r8 = defpackage.o.q(r1, r4)
            return r8
        Lb3:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "Impossible relative path to resolve: "
            r0.<init>(r2)
            r0.append(r8)
            r0.append(r1)
            r0.append(r9)
            java.lang.String r8 = r0.toString()
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r8 = r8.toString()
            r9.<init>(r8)
            throw r9
        Ld1:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "Paths of different roots cannot be relative to each other: "
            r0.<init>(r2)
            r0.append(r8)
            r0.append(r1)
            r0.append(r9)
            java.lang.String r8 = r0.toString()
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r8 = r8.toString()
            r9.<init>(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.uw2.k(uw2):uw2");
    }

    public final uw2 l(uw2 uw2Var, boolean z) {
        uw2Var.getClass();
        return o.j(this, uw2Var, z);
    }

    public final uw2 m(String str) {
        str.getClass();
        return o.j(this, o.q(new lk().O(str), false), false);
    }

    public final Path o() {
        Path path = Paths.get(toString(), new String[0]);
        path.getClass();
        return path;
    }

    public final Character p() {
        ByteString byteString;
        ByteString b2 = b();
        byteString = o.a;
        if (ByteString.q(b2, byteString, 0, 2, null) != -1 || b().G() < 2 || b().i(1) != 58) {
            return null;
        }
        char i = (char) b().i(0);
        if (('a' > i || i >= '{') && ('A' > i || i >= '[')) {
            return null;
        }
        return Character.valueOf(i);
    }

    public final File toFile() {
        return new File(toString());
    }

    public String toString() {
        return b().M();
    }
}
