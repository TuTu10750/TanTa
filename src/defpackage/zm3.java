package defpackage;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.coroutines.d;

/* loaded from: /tmp/classes2.dex */
public final class zm3 extends hl3 {
    public final /* synthetic */ AtomicReferenceArray e;

    public zm3(long j, zm3 zm3Var, int i) {
        super(j, zm3Var, i);
        int i2;
        i2 = ym3.f;
        this.e = new AtomicReferenceArray(i2);
    }

    @Override // defpackage.hl3
    public int r() {
        int i;
        i = ym3.f;
        return i;
    }

    @Override // defpackage.hl3
    public void s(int i, Throwable th, d dVar) {
        p04 p04Var;
        p04Var = ym3.e;
        v().set(i, p04Var);
        t();
    }

    public String toString() {
        return "SemaphoreSegment[id=" + this.c + ", hashCode=" + hashCode() + ']';
    }

    public final /* synthetic */ AtomicReferenceArray v() {
        return this.e;
    }
}
