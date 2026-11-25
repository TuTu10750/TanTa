package defpackage;

import java.util.HashMap;
import java.util.Map;

/* loaded from: /tmp/classes2.dex */
public abstract class mw2 {
    public static Map a(String str) {
        HashMap hashMap = new HashMap();
        for (String str2 : str.split("&")) {
            String[] split = str2.split("=");
            hashMap.put(uc1.a(split[0]), split.length > 1 ? uc1.a(split[1]) : "");
        }
        return hashMap;
    }

    public static String b(Map map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : map.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(uc1.b((String) entry.getKey()));
            sb.append("=");
            sb.append(uc1.b((String) entry.getValue()));
        }
        return sb.toString();
    }
}
