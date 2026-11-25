package defpackage;

import android.text.TextUtils;

/* loaded from: /tmp/classes2.dex */
public class tx3 {
    public String a;
    public Boolean b;

    public void a(boolean z) {
        this.b = Boolean.valueOf(z);
    }

    public boolean b() {
        return this.b != null;
    }

    public boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return TextUtils.equals(this.a, str);
    }

    public void d(String str) {
        this.a = str;
    }

    public boolean e() {
        Boolean bool = this.b;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }
}
