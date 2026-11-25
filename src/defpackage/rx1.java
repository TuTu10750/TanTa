package defpackage;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import com.yunbao.common.CommonAppContext;
import java.util.Locale;

/* loaded from: /tmp/classes2.dex */
public class rx1 {
    public static rx1 b;
    public String a;

    public rx1() {
        String g = bs3.d().g("language");
        this.a = g;
        if (TextUtils.isEmpty(g)) {
            f();
        }
    }

    public static Context a(Context context) {
        return b(context);
    }

    public static Context b(Context context) {
        Configuration configuration = context.getResources().getConfiguration();
        configuration.setLocale(e());
        return context.createConfigurationContext(configuration);
    }

    public static rx1 c() {
        if (b == null) {
            synchronized (rx1.class) {
                try {
                    if (b == null) {
                        b = new rx1();
                    }
                } finally {
                }
            }
        }
        return b;
    }

    public static Locale e() {
        String d = c().d();
        if (!TextUtils.isEmpty(d)) {
            if ("zh-cn".equals(d)) {
                return Locale.SIMPLIFIED_CHINESE;
            }
            if ("en".equals(d)) {
                return Locale.US;
            }
        }
        return Locale.SIMPLIFIED_CHINESE;
    }

    public static boolean g() {
        return "en".equals(c().d());
    }

    public static boolean h() {
        return "zh-cn".equals(c().d());
    }

    public static void i() {
        Locale e = e();
        Resources resources = CommonAppContext.n().getResources();
        Configuration configuration = resources.getConfiguration();
        configuration.setLocale(e);
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
    }

    public String d() {
        if (TextUtils.isEmpty(this.a)) {
            String g = bs3.d().g("language");
            this.a = g;
            if (TextUtils.isEmpty(g)) {
                f();
            }
        }
        return this.a;
    }

    public final void f() {
        Locale c;
        f72 a = b50.a(Resources.getSystem().getConfiguration());
        String str = "zh-cn";
        if (a.f() > 0 && (c = a.c(0)) != null && c.toString().startsWith("en")) {
            str = "en";
        }
        j(str);
    }

    public void j(String str) {
        this.a = str;
        bs3.d().p("language", str);
    }

    public void k(String str) {
        j(str);
        i();
    }
}
