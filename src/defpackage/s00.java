package defpackage;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /tmp/classes2.dex */
public final class s00 {
    public static final s00 a = new s00();
    public static final String b = b30.k0(s20.n('k', 'o', 't', 'l', 'i', 'n'), "", null, null, 0, null, null, 62, null);
    public static final Map c;

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        List n = s20.n("Boolean", "Z", "Char", "C", "Byte", "B", "Short", "S", "Int", "I", "Float", "F", "Long", "J", "Double", "D");
        int c2 = d33.c(0, n.size() - 1, 2);
        if (c2 >= 0) {
            int i = 0;
            while (true) {
                StringBuilder sb = new StringBuilder();
                String str = b;
                sb.append(str);
                sb.append('/');
                sb.append((String) n.get(i));
                int i2 = i + 1;
                linkedHashMap.put(sb.toString(), n.get(i2));
                linkedHashMap.put(str + '/' + ((String) n.get(i)) + "Array", "[" + ((String) n.get(i2)));
                if (i == c2) {
                    break;
                } else {
                    i += 2;
                }
            }
        }
        linkedHashMap.put(b + "/Unit", "V");
        a(linkedHashMap, "Any", "java/lang/Object");
        a(linkedHashMap, "Nothing", "java/lang/Void");
        a(linkedHashMap, "Annotation", "java/lang/annotation/Annotation");
        for (String str2 : s20.n("String", "CharSequence", "Throwable", "Cloneable", "Number", "Comparable", "Enum")) {
            a(linkedHashMap, str2, "java/lang/" + str2);
        }
        for (String str3 : s20.n("Iterator", "Collection", "List", "Set", "Map", "ListIterator")) {
            a(linkedHashMap, "collections/" + str3, "java/util/" + str3);
            a(linkedHashMap, "collections/Mutable" + str3, "java/util/" + str3);
        }
        a(linkedHashMap, "collections/Iterable", "java/lang/Iterable");
        a(linkedHashMap, "collections/MutableIterable", "java/lang/Iterable");
        a(linkedHashMap, "collections/Map.Entry", "java/util/Map$Entry");
        a(linkedHashMap, "collections/MutableMap.MutableEntry", "java/util/Map$Entry");
        for (int i3 = 0; i3 < 23; i3++) {
            StringBuilder sb2 = new StringBuilder();
            String str4 = b;
            sb2.append(str4);
            sb2.append("/jvm/functions/Function");
            sb2.append(i3);
            a(linkedHashMap, "Function" + i3, sb2.toString());
            a(linkedHashMap, "reflect/KFunction" + i3, str4 + "/reflect/KFunction");
        }
        for (String str5 : s20.n("Char", "Byte", "Short", "Int", "Float", "Long", "Double", "String", "Enum")) {
            a(linkedHashMap, str5 + ".Companion", b + "/jvm/internal/" + str5 + "CompanionObject");
        }
        c = linkedHashMap;
    }

    public static final void a(Map map, String str, String str2) {
        map.put(b + '/' + str, "L" + str2 + ';');
    }

    public static final String b(String str) {
        str.getClass();
        String str2 = (String) c.get(str);
        if (str2 != null) {
            return str2;
        }
        return "L" + fw3.E(str, '.', '$', false, 4, null) + ';';
    }
}
