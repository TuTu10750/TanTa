package defpackage;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /tmp/classes2.dex */
public abstract class bv1 {

    /* loaded from: /tmp/classes2.dex */
    public static final class a extends bv1 {
        public final String a;
        public final String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, String str2) {
            super(null);
            str.getClass();
            str2.getClass();
            this.a = str;
            this.b = str2;
        }

        @Override // defpackage.bv1
        public String a() {
            return c() + ':' + b();
        }

        @Override // defpackage.bv1
        public String b() {
            return this.b;
        }

        @Override // defpackage.bv1
        public String c() {
            return this.a;
        }

        public final String d() {
            return this.a;
        }

        public final String e() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return dq1.a(this.a, aVar.a) && dq1.a(this.b, aVar.b);
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static final class b extends bv1 {
        public final String a;
        public final String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, String str2) {
            super(null);
            str.getClass();
            str2.getClass();
            this.a = str;
            this.b = str2;
        }

        @Override // defpackage.bv1
        public String a() {
            return c() + b();
        }

        @Override // defpackage.bv1
        public String b() {
            return this.b;
        }

        @Override // defpackage.bv1
        public String c() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return dq1.a(this.a, bVar.a) && dq1.a(this.b, bVar.b);
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }
    }

    public bv1() {
    }

    public /* synthetic */ bv1(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract String a();

    public abstract String b();

    public abstract String c();

    public final String toString() {
        return a();
    }
}
