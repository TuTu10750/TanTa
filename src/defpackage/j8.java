package defpackage;

import java.util.Iterator;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public interface j8 extends Iterable, bw1 {
    public static final a a0 = a.a;

    /* loaded from: /tmp/classes2.dex */
    public static final class a {
        public static final /* synthetic */ a a = new a();
        public static final j8 b = new C0083a();

        /* renamed from: j8$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/classes2.dex */
        public static final class C0083a implements j8 {
            @Override // defpackage.j8
            public /* bridge */ /* synthetic */ d8 a(r51 r51Var) {
                return (d8) g(r51Var);
            }

            @Override // defpackage.j8
            public boolean c(r51 r51Var) {
                return b.b(this, r51Var);
            }

            public Void g(r51 r51Var) {
                r51Var.getClass();
                return null;
            }

            @Override // defpackage.j8
            public boolean isEmpty() {
                return true;
            }

            @Override // java.lang.Iterable
            public Iterator iterator() {
                return s20.k().iterator();
            }

            public String toString() {
                return "EMPTY";
            }
        }

        public final j8 a(List list) {
            list.getClass();
            return list.isEmpty() ? b : new k8(list);
        }

        public final j8 b() {
            return b;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static final class b {
        public static d8 a(j8 j8Var, r51 r51Var) {
            Object obj;
            r51Var.getClass();
            Iterator it = j8Var.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (dq1.a(((d8) obj).d(), r51Var)) {
                    break;
                }
            }
            return (d8) obj;
        }

        public static boolean b(j8 j8Var, r51 r51Var) {
            r51Var.getClass();
            return j8Var.a(r51Var) != null;
        }
    }

    d8 a(r51 r51Var);

    boolean c(r51 r51Var);

    boolean isEmpty();
}
