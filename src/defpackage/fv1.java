package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;

/* loaded from: /tmp/classes2.dex */
public abstract class fv1 {
    public static final List a(List list) {
        list.getClass();
        ArrayList arrayList = new ArrayList();
        arrayList.ensureCapacity(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            JvmProtoBuf.StringTableTypes.Record record = (JvmProtoBuf.StringTableTypes.Record) it.next();
            int F = record.F();
            for (int i = 0; i < F; i++) {
                arrayList.add(record);
            }
        }
        arrayList.trimToSize();
        return arrayList;
    }
}
