package defpackage;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* loaded from: /tmp/classes2.dex */
public abstract class kv1 {
    public static final b a = new b(null);
    public static final d b = new d(JvmPrimitiveType.BOOLEAN);
    public static final d c = new d(JvmPrimitiveType.CHAR);
    public static final d d = new d(JvmPrimitiveType.BYTE);
    public static final d e = new d(JvmPrimitiveType.SHORT);
    public static final d f = new d(JvmPrimitiveType.INT);
    public static final d g = new d(JvmPrimitiveType.FLOAT);
    public static final d h = new d(JvmPrimitiveType.LONG);
    public static final d i = new d(JvmPrimitiveType.DOUBLE);

    /* loaded from: /tmp/classes2.dex */
    public static final class a extends kv1 {
        public final kv1 j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(kv1 kv1Var) {
            super(null);
            kv1Var.getClass();
            this.j = kv1Var;
        }

        public final kv1 i() {
            return this.j;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final d a() {
            return kv1.b;
        }

        public final d b() {
            return kv1.d;
        }

        public final d c() {
            return kv1.c;
        }

        public final d d() {
            return kv1.i;
        }

        public final d e() {
            return kv1.g;
        }

        public final d f() {
            return kv1.f;
        }

        public final d g() {
            return kv1.h;
        }

        public final d h() {
            return kv1.e;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static final class c extends kv1 {
        public final String j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str) {
            super(null);
            str.getClass();
            this.j = str;
        }

        public final String i() {
            return this.j;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static final class d extends kv1 {
        public final JvmPrimitiveType j;

        public d(JvmPrimitiveType jvmPrimitiveType) {
            super(null);
            this.j = jvmPrimitiveType;
        }

        public final JvmPrimitiveType i() {
            return this.j;
        }
    }

    public kv1() {
    }

    public /* synthetic */ kv1(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public String toString() {
        return mv1.a.a(this);
    }
}
