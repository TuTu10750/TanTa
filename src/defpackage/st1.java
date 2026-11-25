package defpackage;

import kotlinx.coroutines.g;
import kotlinx.coroutines.h;

/* loaded from: /tmp/classes2.dex */
public class st1 extends h implements t30 {
    public final boolean c;

    public st1(g gVar) {
        super(true);
        J(gVar);
        this.c = o0();
    }

    @Override // kotlinx.coroutines.h
    public boolean A() {
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001f, code lost:
    
        r3 = r3.C();
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0025, code lost:
    
        if ((r3 instanceof defpackage.kz) == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0027, code lost:
    
        r3 = (defpackage.kz) r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002b, code lost:
    
        if (r3 == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002d, code lost:
    
        r3 = r3.u();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:
    
        if (r3 != null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002a, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x001d, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0014, code lost:
    
        if (r3 != null) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001b, code lost:
    
        if (r3.z() == false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean o0() {
        /*
            r3 = this;
            jz r3 = r3.C()
            boolean r0 = r3 instanceof defpackage.kz
            r1 = 0
            if (r0 == 0) goto Lc
            kz r3 = (defpackage.kz) r3
            goto Ld
        Lc:
            r3 = r1
        Ld:
            r0 = 0
            if (r3 == 0) goto L33
            kotlinx.coroutines.h r3 = r3.u()
            if (r3 != 0) goto L17
            goto L33
        L17:
            boolean r2 = r3.z()
            if (r2 == 0) goto L1f
            r3 = 1
            return r3
        L1f:
            jz r3 = r3.C()
            boolean r2 = r3 instanceof defpackage.kz
            if (r2 == 0) goto L2a
            kz r3 = (defpackage.kz) r3
            goto L2b
        L2a:
            r3 = r1
        L2b:
            if (r3 == 0) goto L33
            kotlinx.coroutines.h r3 = r3.u()
            if (r3 != 0) goto L17
        L33:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.st1.o0():boolean");
    }

    @Override // kotlinx.coroutines.h
    public boolean z() {
        return this.c;
    }
}
