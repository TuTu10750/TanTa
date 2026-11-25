package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.beauty.bean.SimpleFilterBean;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class tp3 extends RecyclerView.Adapter {
    public List d;
    public LayoutInflater e;
    public View.OnClickListener f;
    public et2 g;
    public int h;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue;
            Object tag = view.getTag();
            if (tag == null || tp3.this.h == (intValue = ((Integer) tag).intValue())) {
                return;
            }
            if (tp3.this.h >= 0 && tp3.this.h < tp3.this.d.size()) {
                ((SimpleFilterBean) tp3.this.d.get(tp3.this.h)).setChecked(false);
                tp3 tp3Var = tp3.this;
                tp3Var.r(tp3Var.h, "payload");
            }
            ((SimpleFilterBean) tp3.this.d.get(intValue)).setChecked(true);
            tp3.this.r(intValue, "payload");
            tp3.this.h = intValue;
            if (tp3.this.g != null) {
                tp3.this.g.onItemClick((SimpleFilterBean) tp3.this.d.get(intValue), intValue);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends RecyclerView.e0 {
        public ImageView u;
        public ImageView v;

        public b(View view) {
            super(view);
            this.u = (ImageView) view.findViewById(x63.j);
            this.v = (ImageView) view.findViewById(x63.f);
            view.setOnClickListener(tp3.this.f);
        }

        public void O(SimpleFilterBean simpleFilterBean, int i, Object obj) {
            ((RecyclerView.e0) this).a.setTag(Integer.valueOf(i));
            if (obj == null) {
                this.u.setImageResource(simpleFilterBean.getImgSrc());
            }
            boolean isChecked = simpleFilterBean.isChecked();
            ImageView imageView = this.v;
            if (isChecked) {
                if (imageView.getVisibility() != 0) {
                    this.v.setVisibility(0);
                }
            } else if (imageView.getVisibility() == 0) {
                this.v.setVisibility(4);
            }
        }
    }

    public tp3(Context context) {
        ArrayList arrayList = new ArrayList();
        this.d = arrayList;
        arrayList.add(new SimpleFilterBean(x83.e, 0, true));
        this.d.add(new SimpleFilterBean(x83.d, f63.e));
        this.d.add(new SimpleFilterBean(x83.g, f63.g));
        this.d.add(new SimpleFilterBean(x83.i, f63.i));
        this.d.add(new SimpleFilterBean(x83.a, f63.b));
        this.d.add(new SimpleFilterBean(x83.b, f63.c));
        this.d.add(new SimpleFilterBean(x83.f, f63.f));
        this.d.add(new SimpleFilterBean(x83.c, f63.d));
        this.d.add(new SimpleFilterBean(x83.h, f63.h));
        this.e = LayoutInflater.from(context);
        this.f = new a();
    }

    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public void z(b bVar, int i) {
    }

    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public void A(b bVar, int i, List list) {
        bVar.O((SimpleFilterBean) this.d.get(i), i, list.size() > 0 ? list.get(0) : null);
    }

    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public b B(ViewGroup viewGroup, int i) {
        return new b(this.e.inflate(n83.a, viewGroup, false));
    }

    public void T(et2 et2Var) {
        this.g = et2Var;
    }

    public int j() {
        return this.d.size();
    }
}
