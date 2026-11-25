package defpackage;

import java.util.Arrays;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /tmp/classes2.dex */
public final class gb extends fb {
    public static final a c = new a(null);
    public Object[] a;
    public int b;

    /* loaded from: /tmp/classes2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static final class b extends n1 {
        public int c = -1;

        public b() {
        }

        @Override // defpackage.n1
        public void d() {
            do {
                int i = this.c + 1;
                this.c = i;
                if (i >= gb.this.a.length) {
                    break;
                }
            } while (gb.this.a[this.c] == null);
            if (this.c >= gb.this.a.length) {
                e();
                return;
            }
            Object obj = gb.this.a[this.c];
            obj.getClass();
            f(obj);
        }
    }

    public gb() {
        this(new Object[20], 0);
    }

    public gb(Object[] objArr, int i) {
        super(null);
        this.a = objArr;
        this.b = i;
    }

    private final void j(int i) {
        Object[] objArr = this.a;
        if (objArr.length <= i) {
            this.a = Arrays.copyOf(objArr, objArr.length * 2);
        }
    }

    @Override // defpackage.fb
    public int g() {
        return this.b;
    }

    @Override // defpackage.fb
    public Object get(int i) {
        return rb.I(this.a, i);
    }

    @Override // defpackage.fb
    public void h(int i, Object obj) {
        obj.getClass();
        j(i);
        if (this.a[i] == null) {
            this.b = g() + 1;
        }
        this.a[i] = obj;
    }

    @Override // defpackage.fb, java.lang.Iterable
    public Iterator iterator() {
        return new b();
    }
}
