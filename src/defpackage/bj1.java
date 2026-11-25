package defpackage;

import android.database.ContentObserver;
import android.util.Log;

/* loaded from: /tmp/classes2.dex */
public class bj1 extends ContentObserver {
    public String a;
    public int b;
    public aj1 c;

    public bj1(aj1 aj1Var, int i, String str) {
        super(null);
        this.c = aj1Var;
        this.b = i;
        this.a = str;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        aj1 aj1Var = this.c;
        if (aj1Var != null) {
            aj1Var.l(this.b, this.a);
        } else {
            Log.e("VMS_SDK_Observer", "mIdentifierIdClient is null");
        }
    }
}
