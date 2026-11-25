package defpackage;

import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /tmp/classes2.dex */
public final class iz1 implements Iterator, bw1 {
    public static final a f = new a(null);
    public final CharSequence a;
    public int b;
    public int c;
    public int d;
    public int e;

    /* loaded from: /tmp/classes2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public iz1(CharSequence charSequence) {
        charSequence.getClass();
        this.a = charSequence;
    }

    @Override // java.util.Iterator
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public String next() {
        if (!hasNext()) {
            zm.a();
            return null;
        }
        this.b = 0;
        int i = this.d;
        int i2 = this.c;
        this.c = this.e + i;
        return this.a.subSequence(i2, i).toString();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        int i;
        int i2;
        int i3 = this.b;
        if (i3 != 0) {
            return i3 == 1;
        }
        if (this.e < 0) {
            this.b = 2;
            return false;
        }
        int length = this.a.length();
        int length2 = this.a.length();
        for (int i4 = this.c; i4 < length2; i4++) {
            char charAt = this.a.charAt(i4);
            if (charAt == '\n' || charAt == '\r') {
                i = (charAt == '\r' && (i2 = i4 + 1) < this.a.length() && this.a.charAt(i2) == '\n') ? 2 : 1;
                length = i4;
                this.b = 1;
                this.e = i;
                this.d = length;
                return true;
            }
        }
        i = -1;
        this.b = 1;
        this.e = i;
        this.d = length;
        return true;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
