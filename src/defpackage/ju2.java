package defpackage;

import java.util.List;
import java.util.RandomAccess;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okio.ByteString;

/* loaded from: /tmp/classes2.dex */
public final class ju2 extends p1 implements RandomAccess {
    public static final a d = new a(null);
    public final ByteString[] b;
    public final int[] c;

    /* loaded from: /tmp/classes2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void b(a aVar, long j, lk lkVar, int i, List list, int i2, int i3, List list2, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                j = 0;
            }
            aVar.a(j, lkVar, (i4 & 4) != 0 ? 0 : i, list, (i4 & 16) != 0 ? 0 : i2, (i4 & 32) != 0 ? list.size() : i3, list2);
        }

        public final void a(long j, lk lkVar, int i, List list, int i2, int i3, List list2) {
            int i4;
            int i5;
            long j2;
            int i6;
            long j3;
            int i7 = i;
            if (i2 >= i3) {
                ik.a("Failed requirement.");
                return;
            }
            for (int i8 = i2; i8 < i3; i8++) {
                if (((ByteString) list.get(i8)).G() < i7) {
                    ik.a("Failed requirement.");
                    return;
                }
            }
            ByteString byteString = (ByteString) list.get(i2);
            ByteString byteString2 = (ByteString) list.get(i3 - 1);
            char c = 65535;
            if (i7 == byteString.G()) {
                int intValue = ((Number) list2.get(i2)).intValue();
                int i9 = i2 + 1;
                ByteString byteString3 = (ByteString) list.get(i9);
                i4 = i9;
                i5 = intValue;
                byteString = byteString3;
            } else {
                i4 = i2;
                i5 = -1;
            }
            long j4 = 2;
            if (byteString.i(i7) == byteString2.i(i7)) {
                int min = Math.min(byteString.G(), byteString2.G());
                int i10 = 0;
                int i11 = i7;
                while (true) {
                    char c2 = c;
                    if (i11 >= min) {
                        j2 = j4;
                        break;
                    }
                    j2 = j4;
                    if (byteString.i(i11) != byteString2.i(i11)) {
                        break;
                    }
                    i10++;
                    i11++;
                    c = c2;
                    j4 = j2;
                }
                long c3 = j + c(lkVar) + j2 + i10 + 1;
                lkVar.writeInt(-i10);
                lkVar.writeInt(i5);
                int i12 = i7 + i10;
                while (i7 < i12) {
                    lkVar.writeInt(byteString.i(i7) & 255);
                    i7++;
                }
                if (i4 + 1 == i3) {
                    if (i12 == ((ByteString) list.get(i4)).G()) {
                        lkVar.writeInt(((Number) list2.get(i4)).intValue());
                        return;
                    } else {
                        fl3.a("Check failed.");
                        return;
                    }
                }
                lk lkVar2 = new lk();
                lkVar.writeInt(((int) (c(lkVar2) + c3)) * (-1));
                a(c3, lkVar2, i12, list, i4, i3, list2);
                lkVar.E(lkVar2);
                return;
            }
            int i13 = 1;
            for (int i14 = i4 + 1; i14 < i3; i14++) {
                if (((ByteString) list.get(i14 - 1)).i(i7) != ((ByteString) list.get(i14)).i(i7)) {
                    i13++;
                }
            }
            long c4 = j + c(lkVar) + 2 + (i13 * 2);
            lkVar.writeInt(i13);
            lkVar.writeInt(i5);
            for (int i15 = i4; i15 < i3; i15++) {
                byte i16 = ((ByteString) list.get(i15)).i(i7);
                if (i15 == i4 || i16 != ((ByteString) list.get(i15 - 1)).i(i7)) {
                    lkVar.writeInt(i16 & 255);
                }
            }
            lk lkVar3 = new lk();
            while (i4 < i3) {
                byte i17 = ((ByteString) list.get(i4)).i(i7);
                int i18 = i4 + 1;
                int i19 = i18;
                while (true) {
                    if (i19 >= i3) {
                        i6 = i3;
                        break;
                    } else {
                        if (i17 != ((ByteString) list.get(i19)).i(i7)) {
                            i6 = i19;
                            break;
                        }
                        i19++;
                    }
                }
                if (i18 == i6 && i7 + 1 == ((ByteString) list.get(i4)).G()) {
                    lkVar.writeInt(((Number) list2.get(i4)).intValue());
                    j3 = c4;
                } else {
                    lkVar.writeInt(((int) (c(lkVar3) + c4)) * (-1));
                    j3 = c4;
                    a(j3, lkVar3, i7 + 1, list, i4, i6, list2);
                }
                c4 = j3;
                i4 = i6;
            }
            lkVar.E(lkVar3);
        }

        public final long c(lk lkVar) {
            return lkVar.size() / 4;
        }

        /* JADX WARN: Code restructure failed: missing block: B:38:0x00bf, code lost:
        
            continue;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final defpackage.ju2 d(okio.ByteString... r17) {
            /*
                Method dump skipped, instructions count: 254
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ju2.a.d(okio.ByteString[]):ju2");
        }
    }

    public ju2(ByteString[] byteStringArr, int[] iArr) {
        this.b = byteStringArr;
        this.c = iArr;
    }

    public /* synthetic */ ju2(ByteString[] byteStringArr, int[] iArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(byteStringArr, iArr);
    }

    public static final ju2 o(ByteString... byteStringArr) {
        return d.d(byteStringArr);
    }

    @Override // defpackage.j1, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof ByteString) {
            return i((ByteString) obj);
        }
        return false;
    }

    @Override // defpackage.j1
    public int h() {
        return this.b.length;
    }

    public /* bridge */ boolean i(ByteString byteString) {
        return super.contains(byteString);
    }

    @Override // defpackage.p1, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof ByteString) {
            return m((ByteString) obj);
        }
        return -1;
    }

    @Override // defpackage.p1, java.util.List
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public ByteString get(int i) {
        return this.b[i];
    }

    public final ByteString[] k() {
        return this.b;
    }

    public final int[] l() {
        return this.c;
    }

    @Override // defpackage.p1, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof ByteString) {
            return n((ByteString) obj);
        }
        return -1;
    }

    public /* bridge */ int m(ByteString byteString) {
        return super.indexOf(byteString);
    }

    public /* bridge */ int n(ByteString byteString) {
        return super.lastIndexOf(byteString);
    }
}
