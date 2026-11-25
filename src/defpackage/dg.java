package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public abstract class dg extends RecyclerView.Adapter {
    public Context d;
    public List e;
    public LayoutInflater f;
    public int g = 2;

    public dg(Context context, List list) {
        this.e = list;
        this.d = context;
        this.f = LayoutInflater.from(context);
    }

    public int L() {
        List list = this.e;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public int M(int i) {
        return kg.b(this.g == 2, i, L());
    }

    public abstract void N(RecyclerView.e0 e0Var, Object obj, int i, int i2);

    public void O(List list) {
        List list2 = this.e;
        if (list2 == null || list == null) {
            return;
        }
        list2.clear();
        this.e.addAll(list);
        p();
    }

    public void P(int i) {
        this.g = i;
    }

    public int j() {
        return L() > 1 ? L() + this.g : L();
    }

    public final void z(RecyclerView.e0 e0Var, int i) {
        int M = M(i);
        N(e0Var, this.e.get(M), M, L());
    }
}
