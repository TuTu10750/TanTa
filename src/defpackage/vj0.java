package defpackage;

import java.util.Iterator;

/* loaded from: /tmp/classes2.dex */
public final class vj0 implements bn3 {
    public final CharSequence a;
    public final int b;
    public final int c;
    public final b91 d;

    /* loaded from: /tmp/classes2.dex */
    public static final class a implements Iterator, bw1 {
        public int a = -1;
        public int b;
        public int c;
        public pp1 d;
        public int e;

        public a() {
            int i = fb3.i(vj0.this.b, 0, vj0.this.a.length());
            this.b = i;
            this.c = i;
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0020, code lost:
        
            if (r0 < r6.f.c) goto L10;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private final void d() {
            /*
                r6 = this;
                int r0 = r6.c
                r1 = 0
                if (r0 >= 0) goto Lb
                r6.a = r1
                r0 = 0
                r6.d = r0
                return
            Lb:
                vj0 r0 = defpackage.vj0.this
                int r0 = defpackage.vj0.d(r0)
                r2 = -1
                r3 = 1
                if (r0 <= 0) goto L22
                int r0 = r6.e
                int r0 = r0 + r3
                r6.e = r0
                vj0 r4 = defpackage.vj0.this
                int r4 = defpackage.vj0.d(r4)
                if (r0 >= r4) goto L30
            L22:
                int r0 = r6.c
                vj0 r4 = defpackage.vj0.this
                java.lang.CharSequence r4 = defpackage.vj0.c(r4)
                int r4 = r4.length()
                if (r0 <= r4) goto L46
            L30:
                pp1 r0 = new pp1
                int r1 = r6.b
                vj0 r4 = defpackage.vj0.this
                java.lang.CharSequence r4 = defpackage.vj0.c(r4)
                int r4 = defpackage.hw3.U(r4)
                r0.<init>(r1, r4)
                r6.d = r0
                r6.c = r2
                goto L9b
            L46:
                vj0 r0 = defpackage.vj0.this
                b91 r0 = defpackage.vj0.b(r0)
                vj0 r4 = defpackage.vj0.this
                java.lang.CharSequence r4 = defpackage.vj0.c(r4)
                int r5 = r6.c
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object r0 = r0.invoke(r4, r5)
                kotlin.Pair r0 = (kotlin.Pair) r0
                if (r0 != 0) goto L76
                pp1 r0 = new pp1
                int r1 = r6.b
                vj0 r4 = defpackage.vj0.this
                java.lang.CharSequence r4 = defpackage.vj0.c(r4)
                int r4 = defpackage.hw3.U(r4)
                r0.<init>(r1, r4)
                r6.d = r0
                r6.c = r2
                goto L9b
            L76:
                java.lang.Object r2 = r0.getFirst()
                java.lang.Number r2 = (java.lang.Number) r2
                int r2 = r2.intValue()
                java.lang.Object r0 = r0.getSecond()
                java.lang.Number r0 = (java.lang.Number) r0
                int r0 = r0.intValue()
                int r4 = r6.b
                pp1 r4 = defpackage.fb3.m(r4, r2)
                r6.d = r4
                int r2 = r2 + r0
                r6.b = r2
                if (r0 != 0) goto L98
                r1 = r3
            L98:
                int r2 = r2 + r1
                r6.c = r2
            L9b:
                r6.a = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: vj0.a.d():void");
        }

        @Override // java.util.Iterator
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public pp1 next() {
            if (this.a == -1) {
                d();
            }
            if (this.a == 0) {
                zm.a();
                return null;
            }
            pp1 pp1Var = this.d;
            pp1Var.getClass();
            this.d = null;
            this.a = -1;
            return pp1Var;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.a == -1) {
                d();
            }
            return this.a == 1;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public vj0(CharSequence charSequence, int i, int i2, b91 b91Var) {
        charSequence.getClass();
        b91Var.getClass();
        this.a = charSequence;
        this.b = i;
        this.c = i2;
        this.d = b91Var;
    }

    @Override // defpackage.bn3
    public Iterator iterator() {
        return new a();
    }
}
