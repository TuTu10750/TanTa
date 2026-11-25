package defpackage;

import android.view.View;
import android.view.ViewGroup;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class dk4 extends xv2 {
    public List c;

    public dk4(List list) {
        this.c = list;
    }

    public void a(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) this.c.get(i));
    }

    public int d() {
        return this.c.size();
    }

    public Object h(ViewGroup viewGroup, int i) {
        View view = (View) this.c.get(i);
        viewGroup.addView(view);
        return view;
    }

    public boolean i(View view, Object obj) {
        return view == obj;
    }
}
