package defpackage;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.BufferedChannelKt;

/* loaded from: /tmp/classes2.dex */
public final class vx extends hl3 {
    public final BufferedChannel e;
    public final /* synthetic */ AtomicReferenceArray f;

    public vx(long j, vx vxVar, BufferedChannel bufferedChannel, int i) {
        super(j, vxVar, i);
        this.e = bufferedChannel;
        this.f = new AtomicReferenceArray(BufferedChannelKt.b * 2);
    }

    public final Object A(int i) {
        return z().get(i * 2);
    }

    public final Object B(int i) {
        return z().get((i * 2) + 1);
    }

    public final void C(int i, boolean z) {
        if (z) {
            y().K0((this.c * BufferedChannelKt.b) + i);
        }
        t();
    }

    public final Object D(int i) {
        Object A = A(i);
        w(i);
        return A;
    }

    public final void E(int i, Object obj) {
        z().set(i * 2, obj);
    }

    public final void F(int i, Object obj) {
        z().set((i * 2) + 1, obj);
    }

    public final void G(int i, Object obj) {
        E(i, obj);
    }

    @Override // defpackage.hl3
    public int r() {
        return BufferedChannelKt.b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x004d, code lost:
    
        w(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0050, code lost:
    
        if (r0 == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0052, code lost:
    
        r3 = y().c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0058, code lost:
    
        if (r3 == null) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x005a, code lost:
    
        defpackage.tt2.a(r3, r5, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x005d, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:?, code lost:
    
        return;
     */
    @Override // defpackage.hl3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void s(int r4, java.lang.Throwable r5, kotlin.coroutines.d r6) {
        /*
            r3 = this;
            int r5 = kotlinx.coroutines.channels.BufferedChannelKt.b
            if (r4 < r5) goto L6
            r0 = 1
            goto L7
        L6:
            r0 = 0
        L7:
            if (r0 == 0) goto La
            int r4 = r4 - r5
        La:
            java.lang.Object r5 = r3.A(r4)
        Le:
            java.lang.Object r1 = r3.B(r4)
            boolean r2 = r1 instanceof defpackage.im4
            if (r2 != 0) goto L5e
            boolean r2 = r1 instanceof defpackage.jm4
            if (r2 == 0) goto L1b
            goto L5e
        L1b:
            p04 r2 = kotlinx.coroutines.channels.BufferedChannelKt.j()
            if (r1 == r2) goto L4d
            p04 r2 = kotlinx.coroutines.channels.BufferedChannelKt.i()
            if (r1 != r2) goto L28
            goto L4d
        L28:
            p04 r2 = kotlinx.coroutines.channels.BufferedChannelKt.p()
            if (r1 == r2) goto Le
            p04 r2 = kotlinx.coroutines.channels.BufferedChannelKt.q()
            if (r1 != r2) goto L35
            goto Le
        L35:
            p04 r3 = kotlinx.coroutines.channels.BufferedChannelKt.f()
            if (r1 == r3) goto L84
            p04 r3 = kotlinx.coroutines.channels.BufferedChannelKt.d
            if (r1 != r3) goto L40
            goto L84
        L40:
            p04 r3 = kotlinx.coroutines.channels.BufferedChannelKt.z()
            if (r1 != r3) goto L47
            goto L84
        L47:
            java.lang.String r3 = "unexpected state: "
            defpackage.vt1.a(r3, r1)
            return
        L4d:
            r3.w(r4)
            if (r0 == 0) goto L84
            kotlinx.coroutines.channels.BufferedChannel r3 = r3.y()
            n81 r3 = r3.c
            if (r3 == 0) goto L84
            defpackage.tt2.a(r3, r5, r6)
            return
        L5e:
            if (r0 == 0) goto L65
            p04 r2 = kotlinx.coroutines.channels.BufferedChannelKt.j()
            goto L69
        L65:
            p04 r2 = kotlinx.coroutines.channels.BufferedChannelKt.i()
        L69:
            boolean r1 = r3.v(r4, r1, r2)
            if (r1 == 0) goto Le
            r3.w(r4)
            r1 = r0 ^ 1
            r3.C(r4, r1)
            if (r0 == 0) goto L84
            kotlinx.coroutines.channels.BufferedChannel r3 = r3.y()
            n81 r3 = r3.c
            if (r3 == 0) goto L84
            defpackage.tt2.a(r3, r5, r6)
        L84:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vx.s(int, java.lang.Throwable, kotlin.coroutines.d):void");
    }

    public final boolean v(int i, Object obj, Object obj2) {
        return ux.a(z(), (i * 2) + 1, obj, obj2);
    }

    public final void w(int i) {
        E(i, null);
    }

    public final Object x(int i, Object obj) {
        return z().getAndSet((i * 2) + 1, obj);
    }

    public final BufferedChannel y() {
        BufferedChannel bufferedChannel = this.e;
        bufferedChannel.getClass();
        return bufferedChannel;
    }

    public final /* synthetic */ AtomicReferenceArray z() {
        return this.f;
    }
}
