package defpackage;

import kotlin.jvm.internal.DefaultConstructorMarker;
import okio.ByteString;

/* loaded from: /tmp/classes2.dex */
public final class e71 extends n51 {
    public static final a b = new a(null);
    public static final ByteString c = ByteString.INSTANCE.b("0021F904");
    public final lk a;

    /* loaded from: /tmp/classes2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public e71(wr3 wr3Var) {
        super(wr3Var);
        this.a = new lk();
    }

    private final boolean c0(long j) {
        if (this.a.size() >= j) {
            return true;
        }
        long size = j - this.a.size();
        return super.read(this.a, size) == size;
    }

    private final long z(ByteString byteString) {
        long j = -1;
        while (true) {
            j = this.a.s0(byteString.i(0), j + 1);
            if (j != -1 && (!c0(byteString.G()) || !this.a.R(j, byteString))) {
            }
        }
        return j;
    }

    public final long a(lk lkVar, long j) {
        return fb3.d(this.a.read(lkVar, j), 0L);
    }

    @Override // defpackage.n51, defpackage.wr3
    public long read(lk lkVar, long j) {
        c0(j);
        if (this.a.size() == 0) {
            return j == 0 ? 0L : -1L;
        }
        long j2 = 0;
        while (true) {
            long z = z(c);
            if (z == -1) {
                break;
            }
            j2 += a(lkVar, z + 4);
            if (c0(5L) && this.a.q0(4L) == 0 && this.a.q0(1L) < 2) {
                lkVar.writeByte(this.a.q0(0L));
                lkVar.writeByte(10);
                lkVar.writeByte(0);
                this.a.skip(3L);
            }
        }
        if (j2 < j) {
            j2 += a(lkVar, j - j2);
        }
        if (j2 == 0) {
            return -1L;
        }
        return j2;
    }
}
