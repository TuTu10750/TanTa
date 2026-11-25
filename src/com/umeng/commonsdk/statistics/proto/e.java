package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.db;
import com.umeng.analytics.pro.de;
import com.umeng.analytics.pro.dk;
import com.umeng.analytics.pro.dl;
import com.umeng.analytics.pro.dq;
import com.umeng.analytics.pro.dr;
import com.umeng.analytics.pro.dx;
import com.umeng.analytics.pro.dy;
import com.umeng.analytics.pro.ed;
import com.umeng.analytics.pro.eg;
import com.umeng.analytics.pro.ei;
import com.umeng.analytics.pro.ej;
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
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: /tmp/classes2.dex */
public class e implements de<e, EnumC0025e>, Serializable, Cloneable {
    public static final Map<EnumC0025e, dq> d;
    private static final long e = 7501688097813630241L;
    private static final ei f = new ei("ImprintValue");
    private static final dy g = new dy("value", (byte) 11, 1);
    private static final dy h = new dy("ts", (byte) 10, 2);
    private static final dy i = new dy("guid", (byte) 11, 3);
    private static final Map<Class<? extends el>, em> j;
    private static final int k = 0;
    public String a;
    public long b;
    public String c;
    private byte l;
    private EnumC0025e[] m;

    /* loaded from: /tmp/classes2.dex */
    public static class a extends en<e> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.el
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(ed edVar, e eVar) {
            edVar.j();
            while (true) {
                dy l = edVar.l();
                byte b = l.b;
                if (b == 0) {
                    edVar.k();
                    eVar.k();
                    return;
                }
                short s = l.c;
                if (s != 1) {
                    if (s != 2) {
                        if (s != 3) {
                            eg.a(edVar, b);
                        } else if (b == 11) {
                            eVar.c = edVar.z();
                            eVar.c(true);
                        } else {
                            eg.a(edVar, b);
                        }
                    } else if (b == 10) {
                        eVar.b = edVar.x();
                        eVar.b(true);
                    } else {
                        eg.a(edVar, b);
                    }
                } else if (b == 11) {
                    eVar.a = edVar.z();
                    eVar.a(true);
                } else {
                    eg.a(edVar, b);
                }
                edVar.m();
            }
        }

        @Override // com.umeng.analytics.pro.el
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ed edVar, e eVar) {
            eVar.k();
            edVar.a(e.f);
            if (eVar.a != null && eVar.d()) {
                edVar.a(e.g);
                edVar.a(eVar.a);
                edVar.c();
            }
            if (eVar.g()) {
                edVar.a(e.h);
                edVar.a(eVar.b);
                edVar.c();
            }
            if (eVar.c != null && eVar.j()) {
                edVar.a(e.i);
                edVar.a(eVar.c);
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
    public static class c extends eo<e> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.el
        public void a(ed edVar, e eVar) {
            ej ejVar = (ej) edVar;
            BitSet bitSet = new BitSet();
            if (eVar.d()) {
                bitSet.set(0);
            }
            if (eVar.g()) {
                bitSet.set(1);
            }
            if (eVar.j()) {
                bitSet.set(2);
            }
            ejVar.a(bitSet, 3);
            if (eVar.d()) {
                ejVar.a(eVar.a);
            }
            if (eVar.g()) {
                ejVar.a(eVar.b);
            }
            if (eVar.j()) {
                ejVar.a(eVar.c);
            }
        }

        @Override // com.umeng.analytics.pro.el
        public void b(ed edVar, e eVar) {
            ej ejVar = (ej) edVar;
            BitSet b = ejVar.b(3);
            if (b.get(0)) {
                eVar.a = ejVar.z();
                eVar.a(true);
            }
            if (b.get(1)) {
                eVar.b = ejVar.x();
                eVar.b(true);
            }
            if (b.get(2)) {
                eVar.c = ejVar.z();
                eVar.c(true);
            }
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

    /* renamed from: com.umeng.commonsdk.statistics.proto.e$e, reason: collision with other inner class name */
    /* loaded from: /tmp/classes2.dex */
    public enum EnumC0025e implements dl {
        VALUE(1, "value"),
        TS(2, "ts"),
        GUID(3, "guid");

        private static final Map<String, EnumC0025e> d = new HashMap();
        private final short e;
        private final String f;

        static {
            Iterator it = EnumSet.allOf(EnumC0025e.class).iterator();
            while (it.hasNext()) {
                EnumC0025e enumC0025e = (EnumC0025e) it.next();
                d.put(enumC0025e.b(), enumC0025e);
            }
        }

        EnumC0025e(short s, String str) {
            this.e = s;
            this.f = str;
        }

        public static EnumC0025e a(int i) {
            if (i == 1) {
                return VALUE;
            }
            if (i == 2) {
                return TS;
            }
            if (i != 3) {
                return null;
            }
            return GUID;
        }

        public static EnumC0025e a(String str) {
            return d.get(str);
        }

        public static EnumC0025e b(int i) {
            EnumC0025e a = a(i);
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
        EnumMap enumMap = new EnumMap(EnumC0025e.class);
        enumMap.put((EnumMap) EnumC0025e.VALUE, (EnumC0025e) new dq("value", (byte) 2, new dr((byte) 11)));
        enumMap.put((EnumMap) EnumC0025e.TS, (EnumC0025e) new dq("ts", (byte) 2, new dr((byte) 10)));
        enumMap.put((EnumMap) EnumC0025e.GUID, (EnumC0025e) new dq("guid", (byte) 2, new dr((byte) 11)));
        Map<EnumC0025e, dq> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        d = unmodifiableMap;
        dq.a(e.class, unmodifiableMap);
    }

    public e() {
        this.l = (byte) 0;
        this.m = new EnumC0025e[]{EnumC0025e.VALUE, EnumC0025e.TS, EnumC0025e.GUID};
    }

    public e(long j2, String str) {
        this();
        this.b = j2;
        b(true);
        this.c = str;
    }

    public e(e eVar) {
        this.l = (byte) 0;
        this.m = new EnumC0025e[]{EnumC0025e.VALUE, EnumC0025e.TS, EnumC0025e.GUID};
        this.l = eVar.l;
        if (eVar.d()) {
            this.a = eVar.a;
        }
        this.b = eVar.b;
        if (eVar.j()) {
            this.c = eVar.c;
        }
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
    public EnumC0025e fieldForId(int i2) {
        return EnumC0025e.a(i2);
    }

    @Override // com.umeng.analytics.pro.de
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public e deepCopy() {
        return new e(this);
    }

    public e a(long j2) {
        this.b = j2;
        b(true);
        return this;
    }

    public e a(String str) {
        this.a = str;
        return this;
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.a = null;
    }

    public e b(String str) {
        this.c = str;
        return this;
    }

    public String b() {
        return this.a;
    }

    public void b(boolean z) {
        this.l = db.a(this.l, 0, z);
    }

    public void c() {
        this.a = null;
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
        this.b = 0L;
        this.c = null;
    }

    public boolean d() {
        return this.a != null;
    }

    public long e() {
        return this.b;
    }

    public void f() {
        this.l = db.b(this.l, 0);
    }

    public boolean g() {
        return db.a(this.l, 0);
    }

    public String h() {
        return this.c;
    }

    public void i() {
        this.c = null;
    }

    public boolean j() {
        return this.c != null;
    }

    public void k() {
    }

    @Override // com.umeng.analytics.pro.de
    public void read(ed edVar) {
        j.get(edVar.D()).b().b(edVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ImprintValue(");
        if (d()) {
            sb.append("value:");
            String str = this.a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            sb.append(", ");
        }
        sb.append("ts:");
        sb.append(this.b);
        sb.append(", ");
        sb.append("guid:");
        String str2 = this.c;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.de
    public void write(ed edVar) {
        j.get(edVar.D()).b().a(edVar, this);
    }
}
