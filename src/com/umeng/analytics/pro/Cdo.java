package com.umeng.analytics.pro;

import com.umeng.analytics.pro.Cdo;
import com.umeng.analytics.pro.dl;
import defpackage.vr4;
import defpackage.wr4;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: com.umeng.analytics.pro.do, reason: invalid class name */
/* loaded from: /tmp/classes2.dex */
public abstract class Cdo<T extends Cdo<?, ?>, F extends dl> implements de<T, F> {
    private static final Map<Class<? extends el>, em> c;
    protected Object a;
    protected F b;

    /* renamed from: com.umeng.analytics.pro.do$a */
    /* loaded from: /tmp/classes2.dex */
    public static class a extends en<Cdo> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.el
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(ed edVar, Cdo cdo) {
            cdo.b = null;
            cdo.a = null;
            edVar.j();
            dy l = edVar.l();
            Object a = cdo.a(edVar, l);
            cdo.a = a;
            if (a != null) {
                cdo.b = (F) cdo.a(l.c);
            }
            edVar.m();
            edVar.l();
            edVar.k();
        }

        @Override // com.umeng.analytics.pro.el
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ed edVar, Cdo cdo) {
            if (cdo.a() == null || cdo.b() == null) {
                throw new ee("Cannot write a TUnion with no set value!");
            }
            edVar.a(cdo.d());
            edVar.a(cdo.c(cdo.b));
            cdo.a(edVar);
            edVar.c();
            edVar.d();
            edVar.b();
        }
    }

    /* renamed from: com.umeng.analytics.pro.do$b */
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

    /* renamed from: com.umeng.analytics.pro.do$c */
    /* loaded from: /tmp/classes2.dex */
    public static class c extends eo<Cdo> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.el
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(ed edVar, Cdo cdo) {
            cdo.b = null;
            cdo.a = null;
            short v = edVar.v();
            Object a = cdo.a(edVar, v);
            cdo.a = a;
            if (a != null) {
                cdo.b = (F) cdo.a(v);
            }
        }

        @Override // com.umeng.analytics.pro.el
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ed edVar, Cdo cdo) {
            if (cdo.a() == null || cdo.b() == null) {
                throw new ee("Cannot write a TUnion with no set value!");
            }
            edVar.a(cdo.b.a());
            cdo.b(edVar);
        }
    }

    /* renamed from: com.umeng.analytics.pro.do$d */
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

    static {
        HashMap hashMap = new HashMap();
        c = hashMap;
        hashMap.put(en.class, new b());
        hashMap.put(eo.class, new d());
    }

    public Cdo() {
        this.b = null;
        this.a = null;
    }

    public Cdo(F f, Object obj) {
        a((Cdo<T, F>) f, obj);
    }

    public Cdo(Cdo<T, F> cdo) {
        if (!cdo.getClass().equals(getClass())) {
            vr4.a();
            throw null;
        }
        this.b = cdo.b;
        this.a = a(cdo.a);
    }

    private static Object a(Object obj) {
        return obj instanceof de ? ((de) obj).deepCopy() : obj instanceof ByteBuffer ? df.d((ByteBuffer) obj) : obj instanceof List ? a((List) obj) : obj instanceof Set ? a((Set) obj) : obj instanceof Map ? a((Map<Object, Object>) obj) : obj;
    }

    private static List a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(a(it.next()));
        }
        return arrayList;
    }

    private static Map a(Map<Object, Object> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            hashMap.put(a(entry.getKey()), a(entry.getValue()));
        }
        return hashMap;
    }

    private static Set a(Set set) {
        HashSet hashSet = new HashSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            hashSet.add(a(it.next()));
        }
        return hashSet;
    }

    public F a() {
        return this.b;
    }

    public abstract F a(short s);

    public Object a(int i) {
        return a((Cdo<T, F>) a((short) i));
    }

    public Object a(F f) {
        if (f == this.b) {
            return b();
        }
        StringBuilder sb = new StringBuilder("Cannot get the value of field ");
        sb.append(f);
        wr4.a(sb, " because union's set field is ", this.b);
        return null;
    }

    public abstract Object a(ed edVar, dy dyVar);

    public abstract Object a(ed edVar, short s);

    public void a(int i, Object obj) {
        a((Cdo<T, F>) a((short) i), obj);
    }

    public void a(F f, Object obj) {
        b(f, obj);
        this.b = f;
        this.a = obj;
    }

    public abstract void a(ed edVar);

    public Object b() {
        return this.a;
    }

    public abstract void b(F f, Object obj);

    public abstract void b(ed edVar);

    public boolean b(int i) {
        return b((Cdo<T, F>) a((short) i));
    }

    public boolean b(F f) {
        return this.b == f;
    }

    public abstract dy c(F f);

    public boolean c() {
        return this.b != null;
    }

    @Override // com.umeng.analytics.pro.de
    public final void clear() {
        this.b = null;
        this.a = null;
    }

    public abstract ei d();

    @Override // com.umeng.analytics.pro.de
    public void read(ed edVar) {
        c.get(edVar.D()).b().b(edVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        sb.append(getClass().getSimpleName());
        sb.append(" ");
        if (a() != null) {
            Object b2 = b();
            sb.append(c(a()).a);
            sb.append(":");
            if (b2 instanceof ByteBuffer) {
                df.a((ByteBuffer) b2, sb);
            } else {
                sb.append(b2.toString());
            }
        }
        sb.append(">");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.de
    public void write(ed edVar) {
        c.get(edVar.D()).b().a(edVar, this);
    }
}
