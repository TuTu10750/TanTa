package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.de;
import com.umeng.analytics.pro.dk;
import com.umeng.analytics.pro.dl;
import com.umeng.analytics.pro.dq;
import com.umeng.analytics.pro.dr;
import com.umeng.analytics.pro.ds;
import com.umeng.analytics.pro.dt;
import com.umeng.analytics.pro.dv;
import com.umeng.analytics.pro.dx;
import com.umeng.analytics.pro.dy;
import com.umeng.analytics.pro.dz;
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
import defpackage.sr4;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: /tmp/classes2.dex */
public class c implements de<c, e>, Serializable, Cloneable {
    public static final Map<e, dq> d;
    private static final long e = -5764118265293965743L;
    private static final ei f = new ei("IdTracking");
    private static final dy g = new dy("snapshots", ek.k, 1);
    private static final dy h = new dy("journals", ek.m, 2);
    private static final dy i = new dy("checksum", (byte) 11, 3);
    private static final Map<Class<? extends el>, em> j;
    public Map<String, com.umeng.commonsdk.statistics.proto.b> a;
    public List<com.umeng.commonsdk.statistics.proto.a> b;
    public String c;
    private e[] k;

    /* loaded from: /tmp/classes2.dex */
    public static class a extends en<c> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.el
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(ed edVar, c cVar) {
            edVar.j();
            while (true) {
                dy l = edVar.l();
                byte b = l.b;
                if (b == 0) {
                    edVar.k();
                    cVar.n();
                    return;
                }
                short s = l.c;
                int i = 0;
                if (s != 1) {
                    if (s != 2) {
                        if (s != 3) {
                            eg.a(edVar, b);
                        } else if (b == 11) {
                            cVar.c = edVar.z();
                            cVar.c(true);
                        } else {
                            eg.a(edVar, b);
                        }
                    } else if (b == 15) {
                        dz p = edVar.p();
                        cVar.b = new ArrayList(p.b);
                        while (i < p.b) {
                            com.umeng.commonsdk.statistics.proto.a aVar = new com.umeng.commonsdk.statistics.proto.a();
                            aVar.read(edVar);
                            cVar.b.add(aVar);
                            i++;
                        }
                        edVar.q();
                        cVar.b(true);
                    } else {
                        eg.a(edVar, b);
                    }
                } else if (b == 13) {
                    ea n = edVar.n();
                    cVar.a = new HashMap(n.c * 2);
                    while (i < n.c) {
                        String z = edVar.z();
                        com.umeng.commonsdk.statistics.proto.b bVar = new com.umeng.commonsdk.statistics.proto.b();
                        bVar.read(edVar);
                        cVar.a.put(z, bVar);
                        i++;
                    }
                    edVar.o();
                    cVar.a(true);
                } else {
                    eg.a(edVar, b);
                }
                edVar.m();
            }
        }

        @Override // com.umeng.analytics.pro.el
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ed edVar, c cVar) {
            cVar.n();
            edVar.a(c.f);
            if (cVar.a != null) {
                edVar.a(c.g);
                edVar.a(new ea((byte) 11, (byte) 12, cVar.a.size()));
                for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.b> entry : cVar.a.entrySet()) {
                    edVar.a(entry.getKey());
                    entry.getValue().write(edVar);
                }
                edVar.e();
                edVar.c();
            }
            if (cVar.b != null && cVar.j()) {
                edVar.a(c.h);
                edVar.a(new dz((byte) 12, cVar.b.size()));
                Iterator<com.umeng.commonsdk.statistics.proto.a> it = cVar.b.iterator();
                while (it.hasNext()) {
                    it.next().write(edVar);
                }
                edVar.f();
                edVar.c();
            }
            if (cVar.c != null && cVar.m()) {
                edVar.a(c.i);
                edVar.a(cVar.c);
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

    /* renamed from: com.umeng.commonsdk.statistics.proto.c$c, reason: collision with other inner class name */
    /* loaded from: /tmp/classes2.dex */
    public static class C0023c extends eo<c> {
        private C0023c() {
        }

        @Override // com.umeng.analytics.pro.el
        public void a(ed edVar, c cVar) {
            ej ejVar = (ej) edVar;
            ejVar.a(cVar.a.size());
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.b> entry : cVar.a.entrySet()) {
                ejVar.a(entry.getKey());
                entry.getValue().write(ejVar);
            }
            BitSet bitSet = new BitSet();
            if (cVar.j()) {
                bitSet.set(0);
            }
            if (cVar.m()) {
                bitSet.set(1);
            }
            ejVar.a(bitSet, 2);
            if (cVar.j()) {
                ejVar.a(cVar.b.size());
                Iterator<com.umeng.commonsdk.statistics.proto.a> it = cVar.b.iterator();
                while (it.hasNext()) {
                    it.next().write(ejVar);
                }
            }
            if (cVar.m()) {
                ejVar.a(cVar.c);
            }
        }

        @Override // com.umeng.analytics.pro.el
        public void b(ed edVar, c cVar) {
            ej ejVar = (ej) edVar;
            ea eaVar = new ea((byte) 11, (byte) 12, ejVar.w());
            cVar.a = new HashMap(eaVar.c * 2);
            for (int i = 0; i < eaVar.c; i++) {
                String z = ejVar.z();
                com.umeng.commonsdk.statistics.proto.b bVar = new com.umeng.commonsdk.statistics.proto.b();
                bVar.read(ejVar);
                cVar.a.put(z, bVar);
            }
            cVar.a(true);
            BitSet b = ejVar.b(2);
            if (b.get(0)) {
                dz dzVar = new dz((byte) 12, ejVar.w());
                cVar.b = new ArrayList(dzVar.b);
                for (int i2 = 0; i2 < dzVar.b; i2++) {
                    com.umeng.commonsdk.statistics.proto.a aVar = new com.umeng.commonsdk.statistics.proto.a();
                    aVar.read(ejVar);
                    cVar.b.add(aVar);
                }
                cVar.b(true);
            }
            if (b.get(1)) {
                cVar.c = ejVar.z();
                cVar.c(true);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static class d implements em {
        private d() {
        }

        @Override // com.umeng.analytics.pro.em
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0023c b() {
            return new C0023c();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public enum e implements dl {
        SNAPSHOTS(1, "snapshots"),
        JOURNALS(2, "journals"),
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
                return SNAPSHOTS;
            }
            if (i == 2) {
                return JOURNALS;
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
        hashMap.put(eo.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.SNAPSHOTS, (e) new dq("snapshots", (byte) 1, new dt(ek.k, new dr((byte) 11), new dv((byte) 12, com.umeng.commonsdk.statistics.proto.b.class))));
        enumMap.put((EnumMap) e.JOURNALS, (e) new dq("journals", (byte) 2, new ds(ek.m, new dv((byte) 12, com.umeng.commonsdk.statistics.proto.a.class))));
        enumMap.put((EnumMap) e.CHECKSUM, (e) new dq("checksum", (byte) 2, new dr((byte) 11)));
        Map<e, dq> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        d = unmodifiableMap;
        dq.a(c.class, unmodifiableMap);
    }

    public c() {
        this.k = new e[]{e.JOURNALS, e.CHECKSUM};
    }

    public c(c cVar) {
        this.k = new e[]{e.JOURNALS, e.CHECKSUM};
        if (cVar.e()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.b> entry : cVar.a.entrySet()) {
                hashMap.put(entry.getKey(), new com.umeng.commonsdk.statistics.proto.b(entry.getValue()));
            }
            this.a = hashMap;
        }
        if (cVar.j()) {
            ArrayList arrayList = new ArrayList();
            Iterator<com.umeng.commonsdk.statistics.proto.a> it = cVar.b.iterator();
            while (it.hasNext()) {
                arrayList.add(new com.umeng.commonsdk.statistics.proto.a(it.next()));
            }
            this.b = arrayList;
        }
        if (cVar.m()) {
            this.c = cVar.c;
        }
    }

    public c(Map<String, com.umeng.commonsdk.statistics.proto.b> map) {
        this();
        this.a = map;
    }

    private void a(ObjectInputStream objectInputStream) {
        try {
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
    public e fieldForId(int i2) {
        return e.a(i2);
    }

    @Override // com.umeng.analytics.pro.de
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public c deepCopy() {
        return new c(this);
    }

    public c a(String str) {
        this.c = str;
        return this;
    }

    public c a(List<com.umeng.commonsdk.statistics.proto.a> list) {
        this.b = list;
        return this;
    }

    public c a(Map<String, com.umeng.commonsdk.statistics.proto.b> map) {
        this.a = map;
        return this;
    }

    public void a(com.umeng.commonsdk.statistics.proto.a aVar) {
        if (this.b == null) {
            this.b = new ArrayList();
        }
        this.b.add(aVar);
    }

    public void a(String str, com.umeng.commonsdk.statistics.proto.b bVar) {
        if (this.a == null) {
            this.a = new HashMap();
        }
        this.a.put(str, bVar);
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.a = null;
    }

    public int b() {
        Map<String, com.umeng.commonsdk.statistics.proto.b> map = this.a;
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    public void b(boolean z) {
        if (z) {
            return;
        }
        this.b = null;
    }

    public Map<String, com.umeng.commonsdk.statistics.proto.b> c() {
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
        this.b = null;
        this.c = null;
    }

    public void d() {
        this.a = null;
    }

    public boolean e() {
        return this.a != null;
    }

    public int f() {
        List<com.umeng.commonsdk.statistics.proto.a> list = this.b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public Iterator<com.umeng.commonsdk.statistics.proto.a> g() {
        List<com.umeng.commonsdk.statistics.proto.a> list = this.b;
        if (list == null) {
            return null;
        }
        return list.iterator();
    }

    public List<com.umeng.commonsdk.statistics.proto.a> h() {
        return this.b;
    }

    public void i() {
        this.b = null;
    }

    public boolean j() {
        return this.b != null;
    }

    public String k() {
        return this.c;
    }

    public void l() {
        this.c = null;
    }

    public boolean m() {
        return this.c != null;
    }

    public void n() {
        if (this.a != null) {
            return;
        }
        throw new ee("Required field 'snapshots' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.de
    public void read(ed edVar) {
        j.get(edVar.D()).b().b(edVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdTracking(snapshots:");
        Map<String, com.umeng.commonsdk.statistics.proto.b> map = this.a;
        if (map == null) {
            sb.append("null");
        } else {
            sb.append(map);
        }
        if (j()) {
            sb.append(", ");
            sb.append("journals:");
            List<com.umeng.commonsdk.statistics.proto.a> list = this.b;
            if (list == null) {
                sb.append("null");
            } else {
                sb.append(list);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("checksum:");
            String str = this.c;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.de
    public void write(ed edVar) {
        j.get(edVar.D()).b().a(edVar, this);
    }
}
