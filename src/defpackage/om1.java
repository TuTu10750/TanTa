package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.l;

/* loaded from: /tmp/classes2.dex */
public class om1 extends RecyclerView.Adapter {
    public LayoutInflater d;
    public c e;
    public int f;
    public LinearLayoutManager g;
    public int h;
    public View.OnLongClickListener i = new a();

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnLongClickListener {
        public a() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            Object tag = view.getTag(y63.N);
            if (tag == null) {
                return false;
            }
            int intValue = ((Integer) tag).intValue();
            if (om1.this.e == null) {
                return true;
            }
            om1.this.e.c(intValue);
            return true;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends RecyclerView.t {
        public b() {
        }

        public void a(RecyclerView recyclerView, int i) {
        }

        public void b(RecyclerView recyclerView, int i, int i2) {
            int h2 = om1.this.g.h2();
            if (h2 < 0 || om1.this.h == h2) {
                return;
            }
            om1.this.h = h2;
            if (om1.this.e != null) {
                om1.this.e.b(h2);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface c {
        void a(ImageView imageView, int i);

        void b(int i);

        void c(int i);
    }

    /* loaded from: /tmp/classes2.dex */
    public class d extends RecyclerView.e0 {
        public ImageView u;

        public d(View view) {
            super(view);
            ImageView imageView = (ImageView) view;
            this.u = imageView;
            imageView.setOnLongClickListener(om1.this.i);
        }

        public void O(int i) {
            this.u.setTag(y63.N, Integer.valueOf(i));
            if (om1.this.e != null) {
                om1.this.e.a(this.u, i);
            }
        }
    }

    public om1(Context context, int i) {
        this.f = i;
        this.d = LayoutInflater.from(context);
    }

    public int Q() {
        return this.h;
    }

    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public void z(d dVar, int i) {
        dVar.O(i);
    }

    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public d B(ViewGroup viewGroup, int i) {
        return new d(this.d.inflate(u73.L, viewGroup, false));
    }

    public void T(c cVar) {
        this.e = cVar;
    }

    public void U(int i) {
        this.h = i;
        c cVar = this.e;
        if (cVar != null) {
            cVar.b(i);
        }
    }

    public int j() {
        return this.f;
    }

    public void y(RecyclerView recyclerView) {
        super.y(recyclerView);
        this.g = recyclerView.getLayoutManager();
        new l().b(recyclerView);
        recyclerView.setOnScrollListener(new b());
    }
}
