package defpackage;

import android.content.Context;
import android.database.DataSetObservable;
import android.database.DataSetObserver;

/* loaded from: /tmp/classes2.dex */
public abstract class n30 {
    public final DataSetObservable a = new DataSetObservable();

    public abstract int a();

    public abstract zh1 b(Context context);

    public abstract bi1 c(Context context, int i);

    public float d(Context context, int i) {
        return 1.0f;
    }

    public final void e() {
        this.a.notifyChanged();
    }

    public final void f(DataSetObserver dataSetObserver) {
        this.a.registerObserver(dataSetObserver);
    }

    public final void g(DataSetObserver dataSetObserver) {
        this.a.unregisterObserver(dataSetObserver);
    }
}
