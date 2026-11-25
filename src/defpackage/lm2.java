package defpackage;

import java.util.List;
import java.util.Set;

/* loaded from: /tmp/classes2.dex */
public final class lm2 implements km2 {
    public final List a;
    public final Set b;
    public final List c;
    public final Set d;

    public lm2(List list, Set set, List list2, Set set2) {
        list.getClass();
        set.getClass();
        list2.getClass();
        set2.getClass();
        this.a = list;
        this.b = set;
        this.c = list2;
        this.d = set2;
    }

    @Override // defpackage.km2
    public List a() {
        return this.a;
    }

    @Override // defpackage.km2
    public Set b() {
        return this.b;
    }

    @Override // defpackage.km2
    public List c() {
        return this.c;
    }
}
