package defpackage;

import android.view.View;
import android.view.ViewGroup;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class th extends xv2 {
    public final List c;
    public final List d;

    public th(List list, List list2) {
        this.c = list;
        this.d = list2;
    }

    public void a(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public int d() {
        return this.c.size();
    }

    public CharSequence f(int i) {
        List list = this.d;
        return (list == null || i >= list.size()) ? "" : (CharSequence) this.d.get(i);
    }

    public Object h(ViewGroup viewGroup, int i) {
        View view = (View) this.c.get(i);
        if (view.getParent() == null) {
            viewGroup.addView(view);
        }
        return view;
    }

    public boolean i(View view, Object obj) {
        return view == obj;
    }
}
