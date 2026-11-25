package defpackage;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class fj1 extends RecyclerView.Adapter {
    public List d;
    public LayoutInflater e;
    public View.OnClickListener f;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public final /* synthetic */ dt2 a;

        public a(dt2 dt2Var) {
            this.a = dt2Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() == null || this.a == null) {
                return;
            }
            String str = (String) view.getTag();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            boolean equals = "<".equals(str);
            dt2 dt2Var = this.a;
            if (equals) {
                dt2Var.X();
            } else {
                dt2Var.T(str, view.getId());
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends RecyclerView.e0 {
        public ImageView u;

        public b(View view) {
            super(view);
            ImageView imageView = (ImageView) view;
            this.u = imageView;
            imageView.setOnClickListener(fj1.this.f);
        }

        public void O(String str) {
            this.u.setTag(str);
            if (TextUtils.isEmpty(str)) {
                this.u.setClickable(false);
            } else {
                if ("<".equals(str)) {
                    this.u.setImageResource(q83.q1);
                    return;
                }
                int intValue = jz0.a(str).intValue();
                this.u.setId(intValue);
                this.u.setImageResource(intValue);
            }
        }
    }

    public fj1(List list, LayoutInflater layoutInflater, dt2 dt2Var) {
        this.d = list;
        this.e = layoutInflater;
        this.f = new a(dt2Var);
    }

    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public void z(b bVar, int i) {
        bVar.O((String) this.d.get(i));
    }

    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public b B(ViewGroup viewGroup, int i) {
        return new b(this.e.inflate(u73.K, viewGroup, false));
    }

    public int j() {
        return this.d.size();
    }
}
