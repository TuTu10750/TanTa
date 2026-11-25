package defpackage;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /tmp/classes2.dex */
public final class hk0 {
    public static final a c;
    public static int d;
    public static final int e;
    public static final int f;
    public static final int g;
    public static final int h;
    public static final int i;
    public static final int j;
    public static final int k;
    public static final int l;
    public static final int m;
    public static final int n;
    public static final hk0 o;
    public static final hk0 p;
    public static final hk0 q;
    public static final hk0 r;
    public static final hk0 s;
    public static final hk0 t;
    public static final hk0 u;
    public static final hk0 v;
    public static final hk0 w;
    public static final hk0 x;
    public static final List y;
    public static final List z;
    public final List a;
    public final int b;

    /* loaded from: /tmp/classes2.dex */
    public static final class a {

        /* renamed from: hk0$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/classes2.dex */
        public static final class C0070a {
            public final int a;
            public final String b;

            public C0070a(int i, String str) {
                str.getClass();
                this.a = i;
                this.b = str;
            }

            public final int a() {
                return this.a;
            }

            public final String b() {
                return this.b;
            }
        }

        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int b() {
            return hk0.k;
        }

        public final int c() {
            return hk0.l;
        }

        public final int d() {
            return hk0.i;
        }

        public final int e() {
            return hk0.e;
        }

        public final int f() {
            return hk0.h;
        }

        public final int g() {
            return hk0.f;
        }

        public final int h() {
            return hk0.g;
        }

        public final int i() {
            return hk0.j;
        }

        public final int j() {
            int i = hk0.d;
            hk0.d <<= 1;
            return i;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        a.C0070a c0070a;
        a.C0070a c0070a2;
        a aVar = new a(null);
        c = aVar;
        d = 1;
        int j2 = aVar.j();
        e = j2;
        int j3 = aVar.j();
        f = j3;
        int j4 = aVar.j();
        g = j4;
        int j5 = aVar.j();
        h = j5;
        int j6 = aVar.j();
        i = j6;
        int j7 = aVar.j();
        j = j7;
        int j8 = aVar.j() - 1;
        k = j8;
        int i2 = j2 | j3 | j4;
        l = i2;
        int i3 = j3 | j6 | j7;
        m = i3;
        int i4 = j6 | j7;
        n = i4;
        int i5 = 2;
        o = new hk0(j8, 0 == true ? 1 : 0, i5, 0 == true ? 1 : 0);
        p = new hk0(i4, 0 == true ? 1 : 0, i5, 0 == true ? 1 : 0);
        q = new hk0(j2, 0 == true ? 1 : 0, i5, 0 == true ? 1 : 0);
        r = new hk0(j3, 0 == true ? 1 : 0, i5, 0 == true ? 1 : 0);
        s = new hk0(j4, 0 == true ? 1 : 0, i5, 0 == true ? 1 : 0);
        t = new hk0(i2, 0 == true ? 1 : 0, i5, 0 == true ? 1 : 0);
        u = new hk0(j5, 0 == true ? 1 : 0, i5, 0 == true ? 1 : 0);
        v = new hk0(j6, 0 == true ? 1 : 0, i5, 0 == true ? 1 : 0);
        w = new hk0(j7, 0 == true ? 1 : 0, i5, 0 == true ? 1 : 0);
        x = new hk0(i3, 0 == true ? 1 : 0, i5, 0 == true ? 1 : 0);
        Field[] fields = hk0.class.getFields();
        fields.getClass();
        ArrayList<Field> arrayList = new ArrayList();
        for (Field field : fields) {
            if (Modifier.isStatic(field.getModifiers())) {
                arrayList.add(field);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Field field2 : arrayList) {
            Object obj = field2.get(null);
            hk0 hk0Var = obj instanceof hk0 ? (hk0) obj : null;
            if (hk0Var != null) {
                int i6 = hk0Var.b;
                String name = field2.getName();
                name.getClass();
                c0070a2 = new a.C0070a(i6, name);
            } else {
                c0070a2 = null;
            }
            if (c0070a2 != null) {
                arrayList2.add(c0070a2);
            }
        }
        y = arrayList2;
        Field[] fields2 = hk0.class.getFields();
        fields2.getClass();
        ArrayList arrayList3 = new ArrayList();
        for (Field field3 : fields2) {
            if (Modifier.isStatic(field3.getModifiers())) {
                arrayList3.add(field3);
            }
        }
        ArrayList<Field> arrayList4 = new ArrayList();
        for (Object obj2 : arrayList3) {
            if (dq1.a(((Field) obj2).getType(), Integer.TYPE)) {
                arrayList4.add(obj2);
            }
        }
        ArrayList arrayList5 = new ArrayList();
        for (Field field4 : arrayList4) {
            Object obj3 = field4.get(null);
            obj3.getClass();
            int intValue = ((Integer) obj3).intValue();
            if (intValue == ((-intValue) & intValue)) {
                String name2 = field4.getName();
                name2.getClass();
                c0070a = new a.C0070a(intValue, name2);
            } else {
                c0070a = null;
            }
            if (c0070a != null) {
                arrayList5.add(c0070a);
            }
        }
        z = arrayList5;
    }

    public hk0(int i2, List list) {
        list.getClass();
        this.a = list;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            i2 &= ~((gk0) it.next()).a();
        }
        this.b = i2;
    }

    public /* synthetic */ hk0(int i2, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i2, (i3 & 2) != 0 ? s20.k() : list);
    }

    public final boolean a(int i2) {
        return (this.b & i2) != 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!dq1.a(hk0.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        obj.getClass();
        hk0 hk0Var = (hk0) obj;
        return dq1.a(this.a, hk0Var.a) && this.b == hk0Var.b;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b;
    }

    public final List l() {
        return this.a;
    }

    public final int m() {
        return this.b;
    }

    public final hk0 n(int i2) {
        int i3 = i2 & this.b;
        if (i3 == 0) {
            return null;
        }
        return new hk0(i3, this.a);
    }

    public String toString() {
        Object obj;
        Iterator it = y.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((a.C0070a) obj).a() == this.b) {
                break;
            }
        }
        a.C0070a c0070a = (a.C0070a) obj;
        String b = c0070a != null ? c0070a.b() : null;
        if (b == null) {
            List<a.C0070a> list = z;
            ArrayList arrayList = new ArrayList();
            for (a.C0070a c0070a2 : list) {
                String b2 = a(c0070a2.a()) ? c0070a2.b() : null;
                if (b2 != null) {
                    arrayList.add(b2);
                }
            }
            b = b30.k0(arrayList, " | ", null, null, 0, null, null, 62, null);
        }
        return "DescriptorKindFilter(" + b + ", " + this.a + ')';
    }
}
