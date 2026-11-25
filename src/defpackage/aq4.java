package defpackage;

import android.content.res.Configuration;
import android.content.res.Resources;
import com.yunbao.common.CommonAppContext;
import java.util.IllegalFormatException;
import java.util.Locale;

/* loaded from: /tmp/classes2.dex */
public abstract class aq4 {
    public static Resources a = CommonAppContext.n().getResources();

    public static String a(int i) {
        if (i == 0) {
            return "";
        }
        Locale e = rx1.e();
        Configuration configuration = a.getConfiguration();
        if (configuration.getLocales().indexOf(e) < 0) {
            configuration.setLocale(e);
            a.updateConfiguration(configuration, a.getDisplayMetrics());
        }
        return a.getString(i);
    }

    public static String b(int i, Object... objArr) {
        String a2 = a(i);
        if (a2 == null) {
            return "";
        }
        try {
            return String.format(a2, objArr);
        } catch (IllegalFormatException unused) {
            StringBuilder sb = new StringBuilder(a2);
            if (objArr != null) {
                for (Object obj : objArr) {
                    if (obj != null) {
                        sb.append(' ');
                        sb.append(obj);
                    }
                }
            }
            return sb.toString();
        }
    }
}
