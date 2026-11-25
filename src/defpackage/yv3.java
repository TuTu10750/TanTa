package defpackage;

import com.umeng.umcrash.custom_exception.UMCustomLogInfoBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public abstract class yv3 extends vv3 {
    public static final n81 d(final String str) {
        return str.length() == 0 ? new n81() { // from class: wv3
            @Override // defpackage.n81
            public final Object invoke(Object obj) {
                String e;
                e = yv3.e((String) obj);
                return e;
            }
        } : new n81() { // from class: xv3
            @Override // defpackage.n81
            public final Object invoke(Object obj) {
                String f;
                f = yv3.f(str, (String) obj);
                return f;
            }
        };
    }

    public static final String e(String str) {
        str.getClass();
        return str;
    }

    public static final String f(String str, String str2) {
        str2.getClass();
        return str + str2;
    }

    public static final int g(String str) {
        int length = str.length();
        int i = 0;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            }
            if (!jy.c(str.charAt(i))) {
                break;
            }
            i++;
        }
        return i == -1 ? str.length() : i;
    }

    public static final String h(String str, String str2) {
        String str3;
        str.getClass();
        str2.getClass();
        List j0 = hw3.j0(str);
        ArrayList arrayList = new ArrayList();
        for (Object obj : j0) {
            if (!hw3.c0((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(t20.v(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Integer.valueOf(g((String) it.next())));
        }
        Integer num = (Integer) b30.r0(arrayList2);
        int i = 0;
        int intValue = num != null ? num.intValue() : 0;
        int length = str.length() + (str2.length() * j0.size());
        n81 d = d(str2);
        int m = s20.m(j0);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : j0) {
            int i2 = i + 1;
            if (i < 0) {
                s20.u();
            }
            String str4 = (String) obj2;
            if ((i == 0 || i == m) && hw3.c0(str4)) {
                str4 = null;
            } else {
                String S0 = jw3.S0(str4, intValue);
                if (S0 != null && (str3 = (String) d.invoke(S0)) != null) {
                    str4 = str3;
                }
            }
            if (str4 != null) {
                arrayList3.add(str4);
            }
            i = i2;
        }
        return ((StringBuilder) b30.i0(arrayList3, new StringBuilder(length), UMCustomLogInfoBuilder.LINE_SEP, null, null, 0, null, null, 124, null)).toString();
    }

    public static final String i(String str, String str2, String str3) {
        int i;
        String substring;
        String str4;
        str.getClass();
        str2.getClass();
        str3.getClass();
        if (hw3.c0(str3)) {
            ik.a("marginPrefix must be non-blank string.");
            return null;
        }
        List j0 = hw3.j0(str);
        int length = str.length() + (str2.length() * j0.size());
        n81 d = d(str2);
        int m = s20.m(j0);
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (Object obj : j0) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                s20.u();
            }
            String str5 = (String) obj;
            if ((i2 == 0 || i2 == m) && hw3.c0(str5)) {
                str5 = null;
            } else {
                int length2 = str5.length();
                int i4 = 0;
                while (true) {
                    if (i4 >= length2) {
                        i = -1;
                        break;
                    }
                    if (!jy.c(str5.charAt(i4))) {
                        i = i4;
                        break;
                    }
                    i4++;
                }
                if (i != -1 && fw3.I(str5, str3, i, false, 4, null)) {
                    int length3 = i + str3.length();
                    str5.getClass();
                    substring = str5.substring(length3);
                } else {
                    substring = null;
                }
                if (substring != null && (str4 = (String) d.invoke(substring)) != null) {
                    str5 = str4;
                }
            }
            if (str5 != null) {
                arrayList.add(str5);
            }
            i2 = i3;
        }
        return ((StringBuilder) b30.i0(arrayList, new StringBuilder(length), UMCustomLogInfoBuilder.LINE_SEP, null, null, 0, null, null, 124, null)).toString();
    }

    public static String j(String str) {
        str.getClass();
        return h(str, "");
    }

    public static final String k(String str, String str2) {
        str.getClass();
        str2.getClass();
        return i(str, "", str2);
    }

    public static /* synthetic */ String l(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = "|";
        }
        return k(str, str2);
    }
}
