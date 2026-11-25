package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.mall.bean.ManageClassBean;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class gc2 extends ce3 {
    public View.OnClickListener i;
    public Drawable j;
    public Drawable k;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag == null) {
                return;
            }
            int intValue = ((Integer) tag).intValue();
            ManageClassBean manageClassBean = (ManageClassBean) gc2.this.e.get(intValue);
            if (manageClassBean.isChecked()) {
                manageClassBean.setChecked(false);
                gc2.this.r(intValue, "payload");
            } else {
                manageClassBean.setChecked(true);
                gc2.this.r(intValue, "payload");
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends RecyclerView.e0 {
        public ImageView u;
        public TextView v;

        public b(View view) {
            super(view);
            this.u = (ImageView) view.findViewById(d73.x2);
            this.v = (TextView) view.findViewById(d73.R2);
            view.setOnClickListener(gc2.this.i);
        }

        public void O(ManageClassBean manageClassBean, int i, Object obj) {
            if (obj == null) {
                ((RecyclerView.e0) this).a.setTag(Integer.valueOf(i));
                this.v.setText(manageClassBean.getName());
            }
            ImageView imageView = this.u;
            boolean isChecked = manageClassBean.isChecked();
            gc2 gc2Var = gc2.this;
            imageView.setImageDrawable(isChecked ? gc2Var.j : gc2Var.k);
        }
    }

    public gc2(Context context, List list) {
        super(context, list);
        this.j = o60.d(context, v83.b);
        this.k = o60.d(context, v83.a);
        this.i = new a();
    }

    public void A(RecyclerView.e0 e0Var, int i, List list) {
        ((b) e0Var).O((ManageClassBean) this.e.get(i), i, list.size() > 0 ? list.get(0) : null);
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new b(this.f.inflate(z73.S0, viewGroup, false));
    }

    public ArrayList W() {
        ArrayList arrayList = null;
        for (ManageClassBean manageClassBean : this.e) {
            if (manageClassBean.isChecked()) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(manageClassBean);
            }
        }
        return arrayList;
    }

    public void z(RecyclerView.e0 e0Var, int i) {
    }
}
