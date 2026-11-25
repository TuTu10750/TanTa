package defpackage;

import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /tmp/classes2.dex */
public abstract class fb implements Iterable, bw1 {
    public fb() {
    }

    public /* synthetic */ fb(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract int g();

    public abstract Object get(int i);

    public abstract void h(int i, Object obj);

    @Override // java.lang.Iterable
    public abstract Iterator iterator();
}
