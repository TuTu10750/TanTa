package defpackage;

/* loaded from: /tmp/classes2.dex */
public final class kz extends ut1 implements jz {
    public final lz e;

    public kz(lz lzVar) {
        this.e = lzVar;
    }

    @Override // defpackage.jz
    public boolean b(Throwable th) {
        return u().s(th);
    }

    @Override // defpackage.ut1
    public boolean v() {
        return true;
    }

    @Override // defpackage.ut1
    public void w(Throwable th) {
        this.e.d0(u());
    }
}
