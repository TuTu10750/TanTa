package defpackage;

import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import java.lang.ref.WeakReference;
import java.util.Map;

/* loaded from: /tmp/classes2.dex */
public class kx2 {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public long i;
    public FragmentActivity j;
    public zw2 k;
    public int l;

    public kx2(FragmentActivity fragmentActivity) {
        this.j = (FragmentActivity) new WeakReference(fragmentActivity).get();
    }

    public final void a(String str, String str2, Map map) {
        t54.b("不可用");
    }

    public void b(String str, String str2, String str3, Map map) {
        if (TextUtils.isEmpty(str)) {
            t54.a(m93.Fa);
            return;
        }
        str.getClass();
        char c = 65535;
        switch (str.hashCode()) {
            case -995205389:
                if (str.equals("paypal")) {
                    c = 0;
                    break;
                }
                break;
            case 3809:
                if (str.equals("wx")) {
                    c = 1;
                    break;
                }
                break;
            case 96670:
                if (str.equals("ali")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                c(str2, str3, map);
                return;
            case 1:
                p(map);
                return;
            case 2:
                a(str2, str3, map);
                return;
            default:
                return;
        }
    }

    public final void c(String str, String str2, Map map) {
        t54.b("不可用");
    }

    public void d() {
        this.j = null;
        this.k = null;
    }

    public void e(String str) {
        this.d = str;
    }

    public void f(String str) {
        this.a = str;
    }

    public void g(String str) {
        this.c = str;
    }

    public void h(String str) {
        this.b = str;
    }

    public void i(long j) {
        this.i = j;
    }

    public void j(int i) {
        this.l = i;
    }

    public void k(zw2 zw2Var) {
        this.k = zw2Var;
    }

    public void l(String str) {
        this.f = str;
    }

    public void m(String str) {
        this.h = str;
    }

    public void n(String str) {
        this.g = str;
    }

    public void o(String str) {
        this.e = str;
    }

    public final void p(Map map) {
    }
}
