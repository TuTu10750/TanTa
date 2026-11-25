package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.mall.bean.ManageClassBean;
import java.util.Iterator;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class zn3 extends ce3 {
    public Drawable i;
    public Drawable j;
    public int k;
    public int l;
    public View.OnClickListener m;
    public b n;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue = ((Integer) view.getTag()).intValue();
            ManageClassBean manageClassBean = (ManageClassBean) zn3.this.e.get(intValue);
            if (manageClassBean.getExist() == 1) {
                return;
            }
            manageClassBean.setChecked(!manageClassBean.isChecked());
            zn3.this.q(intValue);
            Iterator it = zn3.this.e.iterator();
            int i = 0;
            while (it.hasNext()) {
                if (((ManageClassBean) it.next()).isChecked()) {
                    i++;
                }
            }
            if (zn3.this.n != null) {
                zn3.this.n.k(i);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface b {
        void k(int i);
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends RecyclerView.e0 {
        public ImageView u;
        public TextView v;

        public c(View view) {
            super(view);
            this.u = (ImageView) view.findViewById(d73.x2);
            this.v = (TextView) view.findViewById(d73.h4);
            view.setOnClickListener(zn3.this.m);
        }

        public void O(ManageClassBean manageClassBean, int i) {
            ((RecyclerView.e0) this).a.setTag(Integer.valueOf(i));
            this.v.setText(manageClassBean.getName());
            int exist = manageClassBean.getExist();
            ImageView imageView = this.u;
            if (exist == 1) {
                imageView.setImageDrawable(null);
                this.v.setTextColor(zn3.this.l);
            } else {
                boolean isChecked = manageClassBean.isChecked();
                zn3 zn3Var = zn3.this;
                imageView.setImageDrawable(isChecked ? zn3Var.i : zn3Var.j);
                this.v.setTextColor(zn3.this.k);
            }
        }
    }

    public zn3(Context context, List list) {
        super(context, list);
        this.k = o60.b(context, p53.l);
        this.l = o60.b(context, p53.i);
        this.i = o60.d(context, v83.b);
        this.j = o60.d(context, v83.a);
        this.m = new a();
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new c(this.f.inflate(z73.s1, viewGroup, false));
    }

    public String a0() {
        StringBuilder sb = null;
        for (ManageClassBean manageClassBean : this.e) {
            if (manageClassBean.isChecked()) {
                if (sb == null) {
                    sb = new StringBuilder();
                }
                sb.append(manageClassBean.getId());
                sb.append(",");
            }
        }
        if (sb == null) {
            return null;
        }
        String sb2 = sb.toString();
        return sb2.length() > 1 ? sb2.substring(0, sb2.length() - 1) : sb2;
    }

    public void b0(b bVar) {
        this.n = bVar;
    }

    public void z(RecyclerView.e0 e0Var, int i) {
        ((c) e0Var).O((ManageClassBean) this.e.get(i), i);
    }
}
