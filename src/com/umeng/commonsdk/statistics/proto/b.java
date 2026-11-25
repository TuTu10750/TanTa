package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.cl;
import com.umeng.analytics.pro.db;
import com.umeng.analytics.pro.de;
import com.umeng.analytics.pro.dk;
import com.umeng.analytics.pro.dl;
import com.umeng.analytics.pro.dq;
import com.umeng.analytics.pro.dr;
import com.umeng.analytics.pro.dx;
import com.umeng.analytics.pro.dy;
import com.umeng.analytics.pro.ed;
import com.umeng.analytics.pro.ee;
import com.umeng.analytics.pro.eg;
import com.umeng.analytics.pro.ei;
import com.umeng.analytics.pro.ej;
import com.umeng.analytics.pro.el;
import com.umeng.analytics.pro.em;
import com.umeng.analytics.pro.en;
import com.umeng.analytics.pro.eo;
import com.umeng.analytics.pro.ep;
import defpackage.fe1;
import defpackage.rr4;
import defpackage.sr4;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: /tmp/classes2.dex */
public class b implements de<b, e>, Serializable, Cloneable {
    public static final Map<e, dq> d;
    private static final long e = -6496538196005191531L;
    private static final ei f = new ei("IdSnapshot");
    private static final dy g = new dy("identity", (byte) 11, 1);
    private static final dy h = new dy("ts", (byte) 10, 2);
    private static final dy i = new dy(cl.n, (byte) 8, 3);
    private static final Map<Class<? extends el>, em> j;
    private static final int k = 0;
    private static final int l = 1;
    public String a;
    public long b;
    public int c;
    private byte m;

    /* loaded from: /tmp/classes2.dex */
    public static class a extends en<b> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.el
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(ed edVar, b bVar) {
            edVar.j();
            while (true) {
                dy l = edVar.l();
                byte b = l.b;
                if (b == 0) {
                    break;
                }
                short s = l.c;
                if (s != 1) {
                    if (s != 2) {
                        if (s != 3) {
                            eg.a(edVar, b);
                        } else if (b == 8) {
                            bVar.c = edVar.w();
                            bVar.c(true);
                        } else {
                            eg.a(edVar, b);
                        }
                    } else if (b == 10) {
                        bVar.b = edVar.x();
                        bVar.b(true);
                    } else {
                        eg.a(edVar, b);
                    }
                } else if (b == 11) {
                    bVar.a = edVar.z();
                    bVar.a(true);
                } else {
                    eg.a(edVar, b);
                }
                edVar.m();
            }
            edVar.k();
            if (!bVar.g()) {
                rr4.a("Required field 'ts' was not found in serialized data! Struct: ", this);
            } else if (bVar.j()) {
                bVar.k();
            } else {
                rr4.a("Required field 'version' was not found in serialized data! Struct: ", this);
            }
        }

        @Override // com.umeng.analytics.pro.el
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ed edVar, b bVar) {
            bVar.k();
            edVar.a(b.f);
            if (bVar.a != null) {
                edVar.a(b.g);
                edVar.a(bVar.a);
                edVar.c();
            }
            edVar.a(b.h);
            edVar.a(bVar.b);
            edVar.c();
            edVar.a(b.i);
            edVar.a(bVar.c);
            edVar.c();
            edVar.d();
            edVar.b();
        }
    }

    /* renamed from: com.umeng.commonsdk.statistics.proto.b$b, reason: collision with other inner class name */
    /* loaded from: /tmp/classes2.dex */
    public static class C0022b implements em {
        private C0022b() {
        }

        @Override // com.umeng.analytics.pro.em
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static class c extends eo<b> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.el
        public void a(ed edVar, b bVar) {
            ej ejVar = (ej) edVar;
            ejVar.a(bVar.a);
            ejVar.a(bVar.b);
            ejVar.a(bVar.c);
        }

        @Override // com.umeng.analytics.pro.el
        public void b(ed edVar, b bVar) {
            ej ejVar = (ej) edVar;
            bVar.a = ejVar.z();
            bVar.a(true);
            bVar.b = ejVar.x();
            bVar.b(true);
            bVar.c = ejVar.w();
            bVar.c(true);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static class d implements em {
        private d() {
        }

        @Override // com.umeng.analytics.pro.em
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c b() {
            return new c();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public enum e implements dl {
        IDENTITY(1, "identity"),
        TS(2, "ts"),
        VERSION(3, cl.n);

        private static final Map<String, e> d = new HashMap();
        private final short e;
        private final String f;

        static {
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                d.put(eVar.b(), eVar);
            }
        }

        e(short s, String str) {
            this.e = s;
            this.f = str;
        }

        public static e a(int i) {
            if (i == 1) {
                return IDENTITY;
            }
            if (i == 2) {
                return TS;
            }
            if (i != 3) {
                return null;
            }
            return VERSION;
        }

        public static e a(String str) {
            return d.get(str);
        }

        public static e b(int i) {
            e a = a(i);
            if (a != null) {
                return a;
            }
            sr4.a("Field ", i, " doesn't exist!");
            return null;
        }

        @Override // com.umeng.analytics.pro.dl
        public short a() {
            return this.e;
        }

        @Override // com.umeng.analytics.pro.dl
        public String b() {
            return this.f;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        j = hashMap;
        hashMap.put(en.class, new C0022b());
        hashMap.put(eo.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.IDENTITY, (e) new dq("identity", (byte) 1, new dr((byte) 11)));
        enumMap.put((EnumMap) e.TS, (e) new dq("ts", (byte) 1, new dr((byte) 10)));
        enumMap.put((EnumMap) e.VERSION, (e) new dq(cl.n, (byte) 1, new dr((byte) 8)));
        Map<e, dq> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        d = unmodifiableMap;
        dq.a(b.class, unmodifiableMap);
    }

    public b() {
        this.m = (byte) 0;
    }

    public b(b bVar) {
        this.m = (byte) 0;
        this.m = bVar.m;
        if (bVar.d()) {
            this.a = bVar.a;
        }
        this.b = bVar.b;
        this.c = bVar.c;
    }

    public b(String str, long j2, int i2) {
        this();
        this.a = str;
        this.b = j2;
        b(true);
        this.c = i2;
        c(true);
    }

    private void a(ObjectInputStream objectInputStream) {
        try {
            this.m = (byte) 0;
            read(new dx(new ep(objectInputStream)));
        } catch (dk e2) {
            fe1.a(e2.getMessage());
        }
    }

    private void a(ObjectOutputStream objectOutputStream) {
        try {
            write(new dx(new ep(objectOutputStream)));
        } catch (dk e2) {
            fe1.a(e2.getMessage());
        }
    }

    @Override // com.umeng.analytics.pro.de
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public b deepCopy() {
        return new b(this);
    }

    public b a(int i2) {
        this.c = i2;
        c(true);
        return this;
    }

    public b a(long j2) {
        this.b = j2;
        b(true);
        return this;
    }

    public b a(String str) {
        this.a = str;
        return this;
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.a = null;
    }

    @Override // com.umeng.analytics.pro.de
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e fieldForId(int i2) {
        return e.a(i2);
    }

    public String b() {
        return this.a;
    }

    public void b(boolean z) {
        this.m = db.a(this.m, 0, z);
    }

    public void c() {
        this.a = null;
    }

    public void c(boolean z) {
        this.m = db.a(this.m, 1, z);
    }

    @Override // com.umeng.analytics.pro.de
    public void clear() {
        this.a = null;
        b(false);
        this.b = 0L;
        c(false);
        this.c = 0;
    }

    public boolean d() {
        return this.a != null;
    }

    public long e() {
        return this.b;
    }

    public void f() {
        this.m = db.b(this.m, 0);
    }

    public boolean g() {
        return db.a(this.m, 0);
    }

    public int h() {
        return this.c;
    }

    public void i() {
        this.m = db.b(this.m, 1);
    }

    public boolean j() {
        return db.a(this.m, 1);
    }

    public void k() {
        if (this.a != null) {
            return;
        }
        throw new ee("Required field 'identity' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.de
    public void read(ed edVar) {
        j.get(edVar.D()).b().b(edVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdSnapshot(identity:");
        String str = this.a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("ts:");
        sb.append(this.b);
        sb.append(", ");
        sb.append("version:");
        sb.append(this.c);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.de
    public void write(ed edVar) {
        j.get(edVar.D()).b().a(edVar, this);
    }
}
