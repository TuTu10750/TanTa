package defpackage;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.c;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;

/* loaded from: /tmp/classes2.dex */
public final class ud3 implements c {
    public static final a c = new a(null);
    public final Class a;
    public final KotlinClassHeader b;

    /* loaded from: /tmp/classes2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ud3 a(Class cls) {
            cls.getClass();
            kotlin.reflect.jvm.internal.impl.load.kotlin.header.a aVar = new kotlin.reflect.jvm.internal.impl.load.kotlin.header.a();
            sc3.a.b(cls, aVar);
            KotlinClassHeader n = aVar.n();
            DefaultConstructorMarker defaultConstructorMarker = null;
            if (n == null) {
                return null;
            }
            return new ud3(cls, n, defaultConstructorMarker);
        }
    }

    public ud3(Class cls, KotlinClassHeader kotlinClassHeader) {
        this.a = cls;
        this.b = kotlinClassHeader;
    }

    public /* synthetic */ ud3(Class cls, KotlinClassHeader kotlinClassHeader, DefaultConstructorMarker defaultConstructorMarker) {
        this(cls, kotlinClassHeader);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.c
    public String a() {
        return fw3.E(this.a.getName(), '.', '/', false, 4, null) + ".class";
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.c
    public KotlinClassHeader b() {
        return this.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.c
    public void c(c.InterfaceC0112c interfaceC0112c, byte[] bArr) {
        interfaceC0112c.getClass();
        sc3.a.b(this.a, interfaceC0112c);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.c
    public void d(c.d dVar, byte[] bArr) {
        dVar.getClass();
        sc3.a.i(this.a, dVar);
    }

    public final Class e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof ud3) && dq1.a(this.a, ((ud3) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.c
    public q00 l() {
        return ReflectClassUtilKt.a(this.a);
    }

    public String toString() {
        return ud3.class.getName() + ": " + this.a;
    }
}
