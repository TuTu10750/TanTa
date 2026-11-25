package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.cl;
import com.umeng.analytics.pro.db;
import com.umeng.analytics.pro.de;
import com.umeng.analytics.pro.dk;
import com.umeng.analytics.pro.dl;
import com.umeng.analytics.pro.dq;
import com.umeng.analytics.pro.dr;
import com.umeng.analytics.pro.dt;
import com.umeng.analytics.pro.dv;
import com.umeng.analytics.pro.dx;
import com.umeng.analytics.pro.dy;
import com.umeng.analytics.pro.ea;
import com.umeng.analytics.pro.ed;
import com.umeng.analytics.pro.ee;
import com.umeng.analytics.pro.eg;
import com.umeng.analytics.pro.ei;
import com.umeng.analytics.pro.ej;
import com.umeng.analytics.pro.ek;
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
public class d implements de<d, e>, Serializable, Cloneable {
    public static final Map<e, dq> d;
    private static final long e = 2846460275012375038L;
    private static final ei f = new ei("Imprint");
    private static final dy g = new dy("property", ek.k, 1);
    private static final dy h = new dy(cl.n, (byte) 8, 2);
    private static final dy i = new dy("checksum", (byte) 11, 3);
    private static final Map<Class<? extends el>, em> j;
    private static final int k = 0;
    public Map<String, com.umeng.commonsdk.statistics.proto.e> a;
    public int b;
    public String c;
    private byte l;

    /* loaded from: /tmp/classes2.dex */
    public static class a extends en<d> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.el
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(ed edVar, d dVar) {
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
                        } else if (b == 11) {
                            dVar.c = edVar.z();
                            dVar.c(true);
                        } else {
                            eg.a(edVar, b);
                        }
                    } else if (b == 8) {
                        dVar.b = edVar.w();
                        dVar.b(true);
                    } else {
                        eg.a(edVar, b);
                    }
                } else if (b == 13) {
                    ea n = edVar.n();
                    dVar.a = new HashMap(n.c * 2);
                    for (int i = 0; i < n.c; i++) {
                        String z = edVar.z();
                        com.umeng.commonsdk.statistics.proto.e eVar = new com.umeng.commonsdk.statistics.proto.e();
                        eVar.read(edVar);
                        dVar.a.put(z, eVar);
                    }
                    edVar.o();
                    dVar.a(true);
                } else {
                    eg.a(edVar, b);
                }
                edVar.m();
            }
            edVar.k();
            if (dVar.h()) {
                dVar.l();
            } else {
                rr4.a("Required field 'version' was not found in serialized data! Struct: ", this);
            }
        }

        @Override // com.umeng.analytics.pro.el
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ed edVar, d dVar) {
            dVar.l();
            edVar.a(d.f);
            if (dVar.a != null) {
                edVar.a(d.g);
                edVar.a(new ea((byte) 11, (byte) 12, dVar.a.size()));
                for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar.a.entrySet()) {
                    edVar.a(entry.getKey());
                    entry.getValue().write(edVar);
                }
                edVar.e();
                edVar.c();
            }
            edVar.a(d.h);
            edVar.a(dVar.b);
            edVar.c();
            if (dVar.c != null) {
                edVar.a(d.i);
                edVar.a(dVar.c);
                edVar.c();
            }
            edVar.d();
            edVar.b();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static class b implements em {
        private b() {
        }

        @Override // com.umeng.analytics.pro.em
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static class c extends eo<d> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.el
        public void a(ed edVar, d dVar) {
            ej ejVar = (ej) edVar;
            ejVar.a(dVar.a.size());
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar.a.entrySet()) {
                ejVar.a(entry.getKey());
                entry.getValue().write(ejVar);
            }
            ejVar.a(dVar.b);
            ejVar.a(dVar.c);
        }

        @Override // com.umeng.analytics.pro.el
        public void b(ed edVar, d dVar) {
            ej ejVar = (ej) edVar;
            ea eaVar = new ea((byte) 11, (byte) 12, ejVar.w());
            dVar.a = new HashMap(eaVar.c * 2);
            for (int i = 0; i < eaVar.c; i++) {
                String z = ejVar.z();
                com.umeng.commonsdk.statistics.proto.e eVar = new com.umeng.commonsdk.statistics.proto.e();
                eVar.read(ejVar);
                dVar.a.put(z, eVar);
            }
            dVar.a(true);
            dVar.b = ejVar.w();
            dVar.b(true);
            dVar.c = ejVar.z();
            dVar.c(true);
        }
    }

    /* renamed from: com.umeng.commonsdk.statistics.proto.d$d, reason: collision with other inner class name */
    /* loaded from: /tmp/classes2.dex */
    public static class C0024d implements em {
        private C0024d() {
        }

        @Override // com.umeng.analytics.pro.em
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c b() {
            return new c();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public enum e implements dl {
        PROPERTY(1, "property"),
        VERSION(2, cl.n),
        CHECKSUM(3, "checksum");

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
                return PROPERTY;
            }
            if (i == 2) {
                return VERSION;
            }
            if (i != 3) {
                return null;
            }
            return CHECKSUM;
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
        hashMap.put(en.class, new b());
        hashMap.put(eo.class, new C0024d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.PROPERTY, (e) new dq("property", (byte) 1, new dt(ek.k, new dr((byte) 11), new dv((byte) 12, com.umeng.commonsdk.statistics.proto.e.class))));
        enumMap.put((EnumMap) e.VERSION, (e) new dq(cl.n, (byte) 1, new dr((byte) 8)));
        enumMap.put((EnumMap) e.CHECKSUM, (e) new dq("checksum", (byte) 1, new dr((byte) 11)));
        Map<e, dq> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        d = unmodifiableMap;
        dq.a(d.class, unmodifiableMap);
    }

    public d() {
        this.l = (byte) 0;
    }

    public d(d dVar) {
        this.l = (byte) 0;
        this.l = dVar.l;
        if (dVar.e()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar.a.entrySet()) {
                hashMap.put(entry.getKey(), new com.umeng.commonsdk.statistics.proto.e(entry.getValue()));
            }
            this.a = hashMap;
        }
        this.b = dVar.b;
        if (dVar.k()) {
            this.c = dVar.c;
        }
    }

    public d(Map<String, com.umeng.commonsdk.statistics.proto.e> map, int i2, String str) {
        this();
        this.a = map;
        this.b = i2;
        b(true);
        this.c = str;
    }

    private void a(ObjectInputStream objectInputStream) {
        try {
            this.l = (byte) 0;
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
    public d deepCopy() {
        return new d(this);
    }

    public d a(int i2) {
        this.b = i2;
        b(true);
        return this;
    }

    public d a(String str) {
        this.c = str;
        return this;
    }

    public d a(Map<String, com.umeng.commonsdk.statistics.proto.e> map) {
        this.a = map;
        return this;
    }

    public void a(String str, com.umeng.commonsdk.statistics.proto.e eVar) {
        if (this.a == null) {
            this.a = new HashMap();
        }
        this.a.put(str, eVar);
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.a = null;
    }

    public int b() {
        Map<String, com.umeng.commonsdk.statistics.proto.e> map = this.a;
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    @Override // com.umeng.analytics.pro.de
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e fieldForId(int i2) {
        return e.a(i2);
    }

    public void b(boolean z) {
        this.l = db.a(this.l, 0, z);
    }

    public Map<String, com.umeng.commonsdk.statistics.proto.e> c() {
        return this.a;
    }

    public void c(boolean z) {
        if (z) {
            return;
        }
        this.c = null;
    }

    @Override // com.umeng.analytics.pro.de
    public void clear() {
        this.a = null;
        b(false);
        this.b = 0;
        this.c = null;
    }

    public void d() {
        this.a = null;
    }

    public boolean e() {
        return this.a != null;
    }

    public int f() {
        return this.b;
    }

    public void g() {
        this.l = db.b(this.l, 0);
    }

    public boolean h() {
        return db.a(this.l, 0);
    }

    public String i() {
        return this.c;
    }

    public void j() {
        this.c = null;
    }

    public boolean k() {
        return this.c != null;
    }

    public void l() {
        if (this.a == null) {
            throw new ee("Required field 'property' was not present! Struct: " + toString());
        }
        if (this.c != null) {
            return;
        }
        throw new ee("Required field 'checksum' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.de
    public void read(ed edVar) {
        j.get(edVar.D()).b().b(edVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Imprint(property:");
        Map<String, com.umeng.commonsdk.statistics.proto.e> map = this.a;
        if (map == null) {
            sb.append("null");
        } else {
            sb.append(map);
        }
        sb.append(", ");
        sb.append("version:");
        sb.append(this.b);
        sb.append(", ");
        sb.append("checksum:");
        String str = this.c;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.de
    public void write(ed edVar) {
        j.get(edVar.D()).b().a(edVar, this);
    }
}
