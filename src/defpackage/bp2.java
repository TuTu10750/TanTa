package defpackage;

import java.util.LinkedList;
import java.util.List;
import kotlin.Triple;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable;

/* loaded from: /tmp/classes2.dex */
public final class bp2 implements ap2 {
    public final ProtoBuf$StringTable a;
    public final ProtoBuf$QualifiedNameTable b;

    /* loaded from: /tmp/classes2.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ProtoBuf$QualifiedNameTable.QualifiedName.Kind.values().length];
            try {
                iArr[ProtoBuf$QualifiedNameTable.QualifiedName.Kind.CLASS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ProtoBuf$QualifiedNameTable.QualifiedName.Kind.PACKAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ProtoBuf$QualifiedNameTable.QualifiedName.Kind.LOCAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    public bp2(ProtoBuf$StringTable protoBuf$StringTable, ProtoBuf$QualifiedNameTable protoBuf$QualifiedNameTable) {
        protoBuf$StringTable.getClass();
        protoBuf$QualifiedNameTable.getClass();
        this.a = protoBuf$StringTable;
        this.b = protoBuf$QualifiedNameTable;
    }

    @Override // defpackage.ap2
    public String a(int i) {
        Triple c = c(i);
        List list = (List) c.getFirst();
        String k0 = b30.k0((List) c.getSecond(), ".", null, null, 0, null, null, 62, null);
        if (list.isEmpty()) {
            return k0;
        }
        return b30.k0(list, "/", null, null, 0, null, null, 62, null) + '/' + k0;
    }

    @Override // defpackage.ap2
    public boolean b(int i) {
        return ((Boolean) c(i).f()).booleanValue();
    }

    public final Triple c(int i) {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        boolean z = false;
        while (i != -1) {
            ProtoBuf$QualifiedNameTable.QualifiedName v = this.b.v(i);
            String v2 = this.a.v(v.z());
            ProtoBuf$QualifiedNameTable.QualifiedName.Kind x = v.x();
            x.getClass();
            int i2 = a.a[x.ordinal()];
            if (i2 == 1) {
                linkedList2.addFirst(v2);
            } else if (i2 == 2) {
                linkedList.addFirst(v2);
            } else if (i2 == 3) {
                linkedList2.addFirst(v2);
                z = true;
            }
            i = v.y();
        }
        return new Triple(linkedList, linkedList2, Boolean.valueOf(z));
    }

    @Override // defpackage.ap2
    public String getString(int i) {
        String v = this.a.v(i);
        v.getClass();
        return v;
    }
}
