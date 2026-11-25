package defpackage;

import java.util.ArrayList;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable;

/* loaded from: /tmp/classes2.dex */
public final class cb4 {
    public final List a;

    public cb4(ProtoBuf$TypeTable protoBuf$TypeTable) {
        protoBuf$TypeTable.getClass();
        List A = protoBuf$TypeTable.A();
        if (protoBuf$TypeTable.B()) {
            int x = protoBuf$TypeTable.x();
            List A2 = protoBuf$TypeTable.A();
            A2.getClass();
            ArrayList arrayList = new ArrayList(t20.v(A2, 10));
            int i = 0;
            for (Object obj : A2) {
                int i2 = i + 1;
                if (i < 0) {
                    s20.u();
                }
                ProtoBuf$Type protoBuf$Type = (ProtoBuf$Type) obj;
                if (i >= x) {
                    protoBuf$Type = protoBuf$Type.b().G(true).build();
                }
                arrayList.add(protoBuf$Type);
                i = i2;
            }
            A = arrayList;
        }
        A.getClass();
        this.a = A;
    }

    public final ProtoBuf$Type a(int i) {
        return (ProtoBuf$Type) this.a.get(i);
    }
}
