package defpackage;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;

/* loaded from: /tmp/classes2.dex */
public abstract class ev1 implements ap2 {
    public static final a d = new a(null);
    public static final String e;
    public static final List f;
    public static final Map g;
    public final String[] a;
    public final Set b;
    public final List c;

    /* loaded from: /tmp/classes2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[JvmProtoBuf.StringTableTypes.Record.Operation.values().length];
            try {
                iArr[JvmProtoBuf.StringTableTypes.Record.Operation.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[JvmProtoBuf.StringTableTypes.Record.Operation.INTERNAL_TO_CLASS_ID.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[JvmProtoBuf.StringTableTypes.Record.Operation.DESC_TO_CLASS_ID.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    static {
        String k0 = b30.k0(s20.n('k', 'o', 't', 'l', 'i', 'n'), "", null, null, 0, null, null, 62, null);
        e = k0;
        List n = s20.n(k0 + "/Any", k0 + "/Nothing", k0 + "/Unit", k0 + "/Throwable", k0 + "/Number", k0 + "/Byte", k0 + "/Double", k0 + "/Float", k0 + "/Int", k0 + "/Long", k0 + "/Short", k0 + "/Boolean", k0 + "/Char", k0 + "/CharSequence", k0 + "/String", k0 + "/Comparable", k0 + "/Enum", k0 + "/Array", k0 + "/ByteArray", k0 + "/DoubleArray", k0 + "/FloatArray", k0 + "/IntArray", k0 + "/LongArray", k0 + "/ShortArray", k0 + "/BooleanArray", k0 + "/CharArray", k0 + "/Cloneable", k0 + "/Annotation", k0 + "/collections/Iterable", k0 + "/collections/MutableIterable", k0 + "/collections/Collection", k0 + "/collections/MutableCollection", k0 + "/collections/List", k0 + "/collections/MutableList", k0 + "/collections/Set", k0 + "/collections/MutableSet", k0 + "/collections/Map", k0 + "/collections/MutableMap", k0 + "/collections/Map.Entry", k0 + "/collections/MutableMap.MutableEntry", k0 + "/collections/Iterator", k0 + "/collections/MutableIterator", k0 + "/collections/ListIterator", k0 + "/collections/MutableListIterator");
        f = n;
        Iterable<co1> O0 = b30.O0(n);
        LinkedHashMap linkedHashMap = new LinkedHashMap(fb3.c(sc2.e(t20.v(O0, 10)), 16));
        for (co1 co1Var : O0) {
            linkedHashMap.put((String) co1Var.d(), Integer.valueOf(co1Var.c()));
        }
        g = linkedHashMap;
    }

    public ev1(String[] strArr, Set set, List list) {
        strArr.getClass();
        set.getClass();
        list.getClass();
        this.a = strArr;
        this.b = set;
        this.c = list;
    }

    @Override // defpackage.ap2
    public String a(int i) {
        return getString(i);
    }

    @Override // defpackage.ap2
    public boolean b(int i) {
        return this.b.contains(Integer.valueOf(i));
    }

    @Override // defpackage.ap2
    public String getString(int i) {
        String str;
        JvmProtoBuf.StringTableTypes.Record record = (JvmProtoBuf.StringTableTypes.Record) this.c.get(i);
        if (record.P()) {
            str = record.I();
        } else {
            if (record.N()) {
                List list = f;
                int size = list.size();
                int E = record.E();
                if (E >= 0 && E < size) {
                    str = (String) list.get(record.E());
                }
            }
            str = this.a[i];
        }
        if (record.K() >= 2) {
            List L = record.L();
            L.getClass();
            Integer num = (Integer) L.get(0);
            Integer num2 = (Integer) L.get(1);
            num.getClass();
            if (num.intValue() >= 0) {
                int intValue = num.intValue();
                num2.getClass();
                if (intValue <= num2.intValue() && num2.intValue() <= str.length()) {
                    str = str.substring(num.intValue(), num2.intValue());
                }
            }
        }
        String str2 = str;
        if (record.G() >= 2) {
            List H = record.H();
            H.getClass();
            Integer num3 = (Integer) H.get(0);
            Integer num4 = (Integer) H.get(1);
            str2.getClass();
            str2 = fw3.E(str2, (char) num3.intValue(), (char) num4.intValue(), false, 4, null);
        }
        String str3 = str2;
        JvmProtoBuf.StringTableTypes.Record.Operation D = record.D();
        if (D == null) {
            D = JvmProtoBuf.StringTableTypes.Record.Operation.NONE;
        }
        int i2 = b.a[D.ordinal()];
        if (i2 == 2) {
            str3.getClass();
            str3 = fw3.E(str3, '$', '.', false, 4, null);
        } else if (i2 == 3) {
            if (str3.length() >= 2) {
                str3 = str3.substring(1, str3.length() - 1);
            }
            str3 = fw3.E(str3, '$', '.', false, 4, null);
        }
        str3.getClass();
        return str3;
    }
}
