package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class wa1 extends RecyclerView.Adapter {
    public List d;
    public LayoutInflater e;
    public View.OnClickListener f;
    public et2 g;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag == null || wa1.this.g == null) {
                return;
            }
            wa1.this.g.onItemClick((Integer) tag, 0);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends RecyclerView.e0 {
        public ImageView u;
        public TextView v;

        public b(View view) {
            super(view);
            this.u = (ImageView) view.findViewById(z63.m);
            this.v = (TextView) view.findViewById(z63.p);
            view.setOnClickListener(wa1.this.f);
        }

        public void O(Integer num) {
            ((RecyclerView.e0) this).a.setTag(num);
            this.u.setImageResource(za1.a(num.intValue()));
            this.v.setText(za1.b(num.intValue()));
        }
    }

    public wa1(Context context, List list) {
        this.d = list;
        if (list == null) {
            this.d = new ArrayList();
        }
        this.e = LayoutInflater.from(context);
        this.f = new a();
    }

    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public void z(b bVar, int i) {
        bVar.O((Integer) this.d.get(i));
    }

    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public b B(ViewGroup viewGroup, int i) {
        return new b(this.e.inflate(v73.f, viewGroup, false));
    }

    public void P(et2 et2Var) {
        this.g = et2Var;
    }

    public int j() {
        return this.d.size();
    }
}
