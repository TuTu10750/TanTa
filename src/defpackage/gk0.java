package defpackage;

import defpackage.hk0;

/* loaded from: /tmp/classes2.dex */
public abstract class gk0 {

    /* loaded from: /tmp/classes2.dex */
    public static final class a extends gk0 {
        public static final a a = new a();
        public static final int b;

        static {
            hk0.a aVar = hk0.c;
            b = (~(aVar.i() | aVar.d())) & aVar.b();
        }

        @Override // defpackage.gk0
        public int a() {
            return b;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static final class b extends gk0 {
        public static final b a = new b();

        @Override // defpackage.gk0
        public int a() {
            return 0;
        }
    }

    public abstract int a();

    public String toString() {
        return getClass().getSimpleName();
    }
}
