package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.common.bean.ChooseImageBean;
import java.io.File;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class ej1 extends ce3 {
    public Drawable i;
    public Drawable j;
    public View.OnClickListener k;
    public int l;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue = ((Integer) view.getTag()).intValue();
            if (intValue == ej1.this.l) {
                return;
            }
            ((ChooseImageBean) ej1.this.e.get(intValue)).setChecked(true);
            ej1.this.r(intValue, "payload");
            if (ej1.this.l >= 0) {
                ((ChooseImageBean) ej1.this.e.get(ej1.this.l)).setChecked(false);
                ej1 ej1Var = ej1.this;
                ej1Var.r(ej1Var.l, "payload");
            }
            ej1.this.l = intValue;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends RecyclerView.e0 {
        public ImageView u;
        public ImageView v;

        public b(View view) {
            super(view);
            this.u = (ImageView) view.findViewById(a73.H);
            this.v = (ImageView) view.findViewById(a73.O);
            view.setOnClickListener(ej1.this.k);
        }

        public void O(ChooseImageBean chooseImageBean, int i, Object obj) {
            if (obj == null) {
                ((RecyclerView.e0) this).a.setTag(Integer.valueOf(i));
                kn1.d(ej1.this.d, chooseImageBean.getImageUri(), this.u);
            }
            ImageView imageView = this.v;
            boolean isChecked = chooseImageBean.isChecked();
            ej1 ej1Var = ej1.this;
            imageView.setImageDrawable(isChecked ? ej1Var.i : ej1Var.j);
        }
    }

    public ej1(Context context, List list) {
        super(context, list);
        this.l = -1;
        this.i = o60.d(context, q83.o1);
        this.j = o60.d(context, q83.p1);
        this.k = new a();
    }

    public void A(RecyclerView.e0 e0Var, int i, List list) {
        ((b) e0Var).O((ChooseImageBean) this.e.get(i), i, list.size() > 0 ? list.get(0) : null);
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new b(this.f.inflate(w73.i, viewGroup, false));
    }

    public File a0() {
        int i = this.l;
        if (i >= 0) {
            return ((ChooseImageBean) this.e.get(i)).getImageFile();
        }
        return null;
    }

    public void z(RecyclerView.e0 e0Var, int i) {
    }
}
