package defpackage;

import com.uc.crashsdk.export.CrashStatKey;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: /tmp/classes2.dex */
public abstract class y80 {

    /* loaded from: /tmp/classes2.dex */
    public static class a extends b {
        public final /* synthetic */ n81 a;
        public final /* synthetic */ boolean[] b;

        public a(n81 n81Var, boolean[] zArr) {
            this.a = n81Var;
            this.b = zArr;
        }

        @Override // y80.d
        public boolean c(Object obj) {
            if (((Boolean) this.a.invoke(obj)).booleanValue()) {
                this.b[0] = true;
            }
            return !this.b[0];
        }

        @Override // y80.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Boolean a() {
            return Boolean.valueOf(this.b[0]);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static abstract class b implements d {
        @Override // y80.d
        public void b(Object obj) {
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface c {
        Iterable a(Object obj);
    }

    /* loaded from: /tmp/classes2.dex */
    public interface d {
        Object a();

        void b(Object obj);

        boolean c(Object obj);
    }

    /* loaded from: /tmp/classes2.dex */
    public interface e {
        boolean a(Object obj);
    }

    /* loaded from: /tmp/classes2.dex */
    public static class f implements e {
        public final Set a;

        public f() {
            this(new HashSet());
        }

        public f(Set set) {
            if (set == null) {
                b(0);
            }
            this.a = set;
        }

        public static /* synthetic */ void b(int i) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "visited", "kotlin/reflect/jvm/internal/impl/utils/DFS$VisitedWithSet", "<init>"));
        }

        @Override // y80.e
        public boolean a(Object obj) {
            return this.a.add(obj);
        }
    }

    public static /* synthetic */ void a(int i) {
        Object[] objArr = new Object[3];
        switch (i) {
            case 1:
            case 5:
            case 8:
            case 11:
            case 15:
            case 18:
            case CrashStatKey.LOG_UPLOAD_CUSTOM_LIMIT /* 21 */:
            case CrashStatKey.LOG_ABANDONED_CUSTOM_FILE /* 23 */:
                objArr[0] = "neighbors";
                break;
            case 2:
            case 12:
            case 16:
            case CrashStatKey.LOG_UPLOAD_BYTES_LIMIT /* 19 */:
            case CrashStatKey.LOG_UPLOAD_ZIP_COUNT /* 24 */:
                objArr[0] = "visited";
                break;
            case 3:
            case 6:
            case 13:
            case CrashStatKey.LOG_RENAMED_COUNT /* 25 */:
                objArr[0] = "handler";
                break;
            case 4:
            case 7:
            case 17:
            case CrashStatKey.LOG_UPLOAD_BUILTIN_LIMIT /* 20 */:
            default:
                objArr[0] = "nodes";
                break;
            case 9:
                objArr[0] = "predicate";
                break;
            case 10:
            case 14:
                objArr[0] = "node";
                break;
            case CrashStatKey.LOG_ABANDONED_BUILTIN_FILE /* 22 */:
                objArr[0] = "current";
                break;
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/DFS";
        switch (i) {
            case 7:
            case 8:
            case 9:
                objArr[2] = "ifAny";
                break;
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
                objArr[2] = "dfsFromNode";
                break;
            case 17:
            case 18:
            case CrashStatKey.LOG_UPLOAD_BYTES_LIMIT /* 19 */:
            case CrashStatKey.LOG_UPLOAD_BUILTIN_LIMIT /* 20 */:
            case CrashStatKey.LOG_UPLOAD_CUSTOM_LIMIT /* 21 */:
                objArr[2] = "topologicalOrder";
                break;
            case CrashStatKey.LOG_ABANDONED_BUILTIN_FILE /* 22 */:
            case CrashStatKey.LOG_ABANDONED_CUSTOM_FILE /* 23 */:
            case CrashStatKey.LOG_UPLOAD_ZIP_COUNT /* 24 */:
            case CrashStatKey.LOG_RENAMED_COUNT /* 25 */:
                objArr[2] = "doDfs";
                break;
            default:
                objArr[2] = "dfs";
                break;
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public static Object b(Collection collection, c cVar, d dVar) {
        if (collection == null) {
            a(4);
        }
        if (cVar == null) {
            a(5);
        }
        if (dVar == null) {
            a(6);
        }
        return c(collection, cVar, new f(), dVar);
    }

    public static Object c(Collection collection, c cVar, e eVar, d dVar) {
        if (collection == null) {
            a(0);
        }
        if (cVar == null) {
            a(1);
        }
        if (eVar == null) {
            a(2);
        }
        if (dVar == null) {
            a(3);
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            d(it.next(), cVar, eVar, dVar);
        }
        return dVar.a();
    }

    public static void d(Object obj, c cVar, e eVar, d dVar) {
        if (obj == null) {
            a(22);
        }
        if (cVar == null) {
            a(23);
        }
        if (eVar == null) {
            a(24);
        }
        if (dVar == null) {
            a(25);
        }
        if (eVar.a(obj) && dVar.c(obj)) {
            Iterator it = cVar.a(obj).iterator();
            while (it.hasNext()) {
                d(it.next(), cVar, eVar, dVar);
            }
            dVar.b(obj);
        }
    }

    public static Boolean e(Collection collection, c cVar, n81 n81Var) {
        if (collection == null) {
            a(7);
        }
        if (cVar == null) {
            a(8);
        }
        if (n81Var == null) {
            a(9);
        }
        return (Boolean) b(collection, cVar, new a(n81Var, new boolean[1]));
    }
}
