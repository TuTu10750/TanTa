package defpackage;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;

/* loaded from: /tmp/classes2.dex */
public class le4 {
    public Context a;
    public String b;
    public String c;
    public String d;
    public String e;

    public le4(Context context) {
        this.a = context;
    }

    public void a() {
        if (TextUtils.isEmpty(this.b)) {
            return;
        }
        ((ClipboardManager) this.a.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text", wg1.c + this.b));
        t54.a(m93.u1);
    }

    public void b() {
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
    }

    public le4 c(String str) {
        this.d = str;
        return this;
    }

    public le4 d(String str) {
        this.e = str;
        return this;
    }

    public le4 e(String str) {
        this.c = str;
        return this;
    }

    public le4 f(String str) {
        this.b = str;
        return this;
    }

    public void g(String str) {
        if (TextUtils.isEmpty(this.b)) {
            return;
        }
        ro3 ro3Var = new ro3();
        ro3Var.c(aq4.b(m93.r2, this.c, aq4.a(m93.L0)));
        ro3Var.a(aq4.b(m93.s2, this.e));
        ro3Var.b(this.d);
        ro3Var.d(wg1.c + this.b);
    }
}
