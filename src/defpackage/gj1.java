package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class gj1 extends xv2 {
    public List c;

    public gj1(Context context, dt2 dt2Var) {
        LayoutInflater from = LayoutInflater.from(context);
        this.c = new ArrayList();
        List b = jz0.b();
        int size = b.size();
        int i = size / 20;
        if (size % 20 > 0) {
            i++;
            int i2 = (i * 20) - size;
            for (int i3 = 0; i3 < i2; i3++) {
                b.add("");
            }
        }
        int i4 = 0;
        int i5 = 0;
        while (i4 < i) {
            RecyclerView inflate = from.inflate(u73.P, (ViewGroup) null, false);
            inflate.setHasFixedSize(true);
            inflate.setLayoutManager(new GridLayoutManager(context, 7, 1, false));
            int i6 = i5 + 20;
            ArrayList arrayList = new ArrayList();
            while (i5 < i6) {
                arrayList.add((String) b.get(i5));
                i5++;
            }
            arrayList.add("<");
            inflate.setAdapter(new fj1(arrayList, from, dt2Var));
            this.c.add(inflate);
            i4++;
            i5 = i6;
        }
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
