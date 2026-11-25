package defpackage;

import defpackage.uc3;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public final class yc3 extends uc3 implements ir1 {
    public final Object[] c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yc3(zo2 zo2Var, Object[] objArr) {
        super(zo2Var, null);
        objArr.getClass();
        this.c = objArr;
    }

    @Override // defpackage.ir1
    public List e() {
        Object[] objArr = this.c;
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            uc3.a aVar = uc3.b;
            obj.getClass();
            arrayList.add(aVar.a(obj, null));
        }
        return arrayList;
    }
}
