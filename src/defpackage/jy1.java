package defpackage;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
import kotlin.reflect.jvm.internal.impl.protobuf.f;

/* loaded from: /tmp/classes2.dex */
public class jy1 extends AbstractList implements RandomAccess, ky1 {
    public static final ky1 b = new jy1().f();
    public final List a;

    public jy1() {
        this.a = new ArrayList();
    }

    public jy1(ky1 ky1Var) {
        this.a = new ArrayList(ky1Var.size());
        addAll(ky1Var);
    }

    public static tm h(Object obj) {
        return obj instanceof tm ? (tm) obj : obj instanceof String ? tm.l((String) obj) : tm.j((byte[]) obj);
    }

    public static String i(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof tm ? ((tm) obj).x() : f.b((byte[]) obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i, Collection collection) {
        if (collection instanceof ky1) {
            collection = ((ky1) collection).b();
        }
        boolean addAll = this.a.addAll(i, collection);
        ((AbstractList) this).modCount++;
        return addAll;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }

    @Override // defpackage.ky1
    public List b() {
        return Collections.unmodifiableList(this.a);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.a.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // defpackage.ky1
    public void d(tm tmVar) {
        this.a.add(tmVar);
        ((AbstractList) this).modCount++;
    }

    @Override // defpackage.ky1
    public tm e(int i) {
        Object obj = this.a.get(i);
        tm h = h(obj);
        if (h != obj) {
            this.a.set(i, h);
        }
        return h;
    }

    @Override // defpackage.ky1
    public ky1 f() {
        return new yc4(this);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void add(int i, String str) {
        this.a.add(i, str);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public String get(int i) {
        Object obj = this.a.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof tm) {
            tm tmVar = (tm) obj;
            String x = tmVar.x();
            if (tmVar.q()) {
                this.a.set(i, x);
            }
            return x;
        }
        byte[] bArr = (byte[]) obj;
        String b2 = f.b(bArr);
        if (f.a(bArr)) {
            this.a.set(i, b2);
        }
        return b2;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public String remove(int i) {
        Object remove = this.a.remove(i);
        ((AbstractList) this).modCount++;
        return i(remove);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public String set(int i, String str) {
        return i(this.a.set(i, str));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.a.size();
    }
}
