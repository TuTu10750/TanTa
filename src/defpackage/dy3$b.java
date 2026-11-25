package defpackage;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: /tmp/classes2.dex */
public class dy3$b {
    public final Context a;
    public final String b;
    public final a c;
    public final boolean d;

    /* loaded from: /tmp/classes2.dex */
    public static class a {
        public Context a;
        public String b;
        public a c;
        public boolean d;

        public a(Context context) {
            this.a = context;
        }

        public dy3$b a() {
            if (this.c == null) {
                ik.a("Must set a callback to create the configuration.");
                return null;
            }
            if (this.a == null) {
                ik.a("Must set a non-null context to create the configuration.");
                return null;
            }
            if (!this.d || !TextUtils.isEmpty(this.b)) {
                return new dy3$b(this.a, this.b, this.c, this.d);
            }
            ik.a("Must set a non-null database name to a configuration that uses the no backup directory.");
            return null;
        }

        public a b(a aVar) {
            this.c = aVar;
            return this;
        }

        public a c(String str) {
            this.b = str;
            return this;
        }
    }

    public dy3$b(Context context, String str, a aVar, boolean z) {
        this.a = context;
        this.b = str;
        this.c = aVar;
        this.d = z;
    }

    public static a a(Context context) {
        return new a(context);
    }
}
