package defpackage;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;

/* loaded from: /tmp/classes2.dex */
public abstract class yu0 extends k50 {
    public static final a b = new a(null);

    /* loaded from: /tmp/classes2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final yu0 a(String str) {
            str.getClass();
            return new b(str);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static final class b extends yu0 {
        public final String c;

        public b(String str) {
            str.getClass();
            this.c = str;
        }

        @Override // defpackage.k50
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public vu0 a(mm2 mm2Var) {
            mm2Var.getClass();
            return xu0.d(ErrorTypeKind.o0, this.c);
        }

        @Override // defpackage.k50
        public String toString() {
            return this.c;
        }
    }

    public yu0() {
        super(qc4.a);
    }

    @Override // defpackage.k50
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public qc4 b() {
        throw new UnsupportedOperationException();
    }
}
