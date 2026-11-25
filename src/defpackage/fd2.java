package defpackage;

import defpackage.ed2;
import defpackage.fd2;
import java.util.Iterator;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.sequences.SequencesKt___SequencesKt;

/* loaded from: /tmp/classes2.dex */
public final class fd2 implements ed2 {
    public final Matcher a;
    public final CharSequence b;
    public final dd2 c;
    public List d;

    /* loaded from: /tmp/classes2.dex */
    public static final class a extends p1 {
        public a() {
        }

        @Override // defpackage.j1, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof String) {
                return i((String) obj);
            }
            return false;
        }

        @Override // defpackage.j1
        public int h() {
            return fd2.this.d().groupCount() + 1;
        }

        public /* bridge */ boolean i(String str) {
            return super.contains(str);
        }

        @Override // defpackage.p1, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof String) {
                return k((String) obj);
            }
            return -1;
        }

        @Override // defpackage.p1, java.util.List
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public String get(int i) {
            String group = fd2.this.d().group(i);
            return group == null ? "" : group;
        }

        public /* bridge */ int k(String str) {
            return super.indexOf(str);
        }

        public /* bridge */ int l(String str) {
            return super.lastIndexOf(str);
        }

        @Override // defpackage.p1, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof String) {
                return l((String) obj);
            }
            return -1;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static final class b extends j1 implements dd2 {
        public b() {
        }

        public static cd2 i(b bVar, int i) {
            return bVar.k(i);
        }

        @Override // defpackage.j1, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj == null ? true : obj instanceof cd2) {
                return j((cd2) obj);
            }
            return false;
        }

        @Override // defpackage.j1
        public int h() {
            return fd2.this.d().groupCount() + 1;
        }

        @Override // defpackage.j1, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return SequencesKt___SequencesKt.M(b30.S(s20.l(this)), new n81() { // from class: gd2
                @Override // defpackage.n81
                public final Object invoke(Object obj) {
                    return fd2.b.i(fd2.b.this, ((Integer) obj).intValue());
                }
            }).iterator();
        }

        public /* bridge */ boolean j(cd2 cd2Var) {
            return super.contains(cd2Var);
        }

        public cd2 k(int i) {
            pp1 f;
            f = me3.f(fd2.this.d(), i);
            if (f.n().intValue() < 0) {
                return null;
            }
            String group = fd2.this.d().group(i);
            group.getClass();
            return new cd2(group, f);
        }
    }

    public fd2(Matcher matcher, CharSequence charSequence) {
        matcher.getClass();
        charSequence.getClass();
        this.a = matcher;
        this.b = charSequence;
        this.c = new b();
    }

    @Override // defpackage.ed2
    public /* bridge */ ed2.b a() {
        return ed2.a.a(this);
    }

    @Override // defpackage.ed2
    public List b() {
        if (this.d == null) {
            this.d = new a();
        }
        List list = this.d;
        list.getClass();
        return list;
    }

    public final MatchResult d() {
        return this.a;
    }
}
