package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.common.CommonAppContext;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public abstract class ce3 extends RecyclerView.Adapter {
    public Context d;
    public List e;
    public LayoutInflater f;
    public RecyclerView g;
    public et2 h;

    public ce3(Context context) {
        this(context, new ArrayList());
    }

    public ce3(Context context, List list) {
        this.e = list;
        this.d = context;
        this.f = LayoutInflater.from(CommonAppContext.n());
        I(false);
    }

    public boolean L() {
        return j10.a();
    }

    public void M() {
        List list;
        if (this.g == null || (list = this.e) == null) {
            return;
        }
        list.clear();
        p();
    }

    public List N() {
        return this.e;
    }

    public void O(List list) {
        if (this.g == null || this.e == null || list == null || list.size() <= 0) {
            return;
        }
        this.e.size();
        this.e.addAll(list);
        p();
    }

    public void P(List list) {
        if (this.g == null || list == null) {
            return;
        }
        this.e.clear();
        this.e.addAll(list);
        p();
    }

    public void Q(List list) {
        List list2 = this.e;
        if (list2 != null) {
            list2.clear();
            this.e.addAll(list);
        }
    }

    public void R(et2 et2Var) {
        this.h = et2Var;
    }

    public int j() {
        List list = this.e;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public long k(int i) {
        return i;
    }

    public void y(RecyclerView recyclerView) {
        this.g = recyclerView;
    }
}
