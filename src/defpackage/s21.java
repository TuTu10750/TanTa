package defpackage;

/* loaded from: /tmp/classes2.dex */
public final class s21 extends n51 {
    public final long a;
    public final boolean b;
    public long c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s21(wr3 wr3Var, long j, boolean z) {
        super(wr3Var);
        wr3Var.getClass();
        this.a = j;
        this.b = z;
    }

    public final void a(lk lkVar, long j) {
        lk lkVar2 = new lk();
        lkVar2.E(lkVar);
        lkVar.write(lkVar2, j);
        lkVar2.a();
    }

    @Override // defpackage.n51, defpackage.wr3
    public long read(lk lkVar, long j) {
        lkVar.getClass();
        long j2 = this.c;
        long j3 = this.a;
        if (j2 > j3) {
            j = 0;
        } else if (this.b) {
            long j4 = j3 - j2;
            if (j4 == 0) {
                return -1L;
            }
            j = Math.min(j, j4);
        }
        long read = super.read(lkVar, j);
        if (read != -1) {
            this.c += read;
        }
        long j5 = this.c;
        long j6 = this.a;
        if ((j5 >= j6 || read != -1) && j5 <= j6) {
            return read;
        }
        if (read > 0 && j5 > j6) {
            a(lkVar, lkVar.size() - (this.c - this.a));
        }
        c43.a("expected ", this.a, " bytes but got ", this.c);
        return 0L;
    }
}
