package defpackage;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.load.kotlin.c;

/* loaded from: /tmp/classes2.dex */
public interface ax1 extends ex1 {

    /* loaded from: /tmp/classes2.dex */
    public static abstract class a {

        /* renamed from: ax1$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/classes2.dex */
        public static final class C0001a extends a {
            public final c a;
            public final byte[] b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0001a(c cVar, byte[] bArr) {
                super(null);
                cVar.getClass();
                this.a = cVar;
                this.b = bArr;
            }

            public /* synthetic */ C0001a(c cVar, byte[] bArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(cVar, (i & 2) != 0 ? null : bArr);
            }

            public final c b() {
                return this.a;
            }
        }

        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final c a() {
            C0001a c0001a = this instanceof C0001a ? (C0001a) this : null;
            if (c0001a != null) {
                return c0001a.b();
            }
            return null;
        }
    }

    a a(lr1 lr1Var, cv1 cv1Var);

    a b(q00 q00Var, cv1 cv1Var);
}
