package defpackage;

import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: /tmp/classes2.dex */
public class oh extends RecyclerView.e0 {
    public final SparseArray u;

    public oh(View view) {
        super(view);
        this.u = new SparseArray();
    }

    public View O(int i) {
        View view = (View) this.u.get(i);
        if (view != null) {
            return view;
        }
        View findViewById = ((RecyclerView.e0) this).a.findViewById(i);
        this.u.put(i, findViewById);
        return findViewById;
    }
}
