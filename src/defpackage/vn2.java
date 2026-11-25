package defpackage;

import java.util.List;
import java.util.Map;
import kotlin.collections.a;

/* loaded from: /tmp/classes2.dex */
public final class vn2 extends nf4 {
    public final List a;
    public final Map b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vn2(List list) {
        super(null);
        list.getClass();
        this.a = list;
        Map s = a.s(a());
        if (s.size() == a().size()) {
            this.b = s;
        } else {
            ik.a("Some properties have the same names");
            throw null;
        }
    }

    @Override // defpackage.nf4
    public List a() {
        return this.a;
    }

    public String toString() {
        return "MultiFieldValueClassRepresentation(underlyingPropertyNamesToTypes=" + a() + ')';
    }
}
