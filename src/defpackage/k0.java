package defpackage;

import android.content.Context;
import android.view.ViewGroup;

/* loaded from: /tmp/classes2.dex */
public abstract class k0 extends b1 {
    public boolean a;

    public k0(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
        this.a = true;
    }

    public k0(Context context, ViewGroup viewGroup, Object... objArr) {
        super(context, viewGroup, objArr);
        this.a = true;
    }

    public boolean isFirstLoadData() {
        if (!this.a) {
            return false;
        }
        this.a = false;
        return true;
    }

    public void loadData() {
    }
}
