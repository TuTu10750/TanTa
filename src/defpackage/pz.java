package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.common.bean.ChooseImageBean;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class pz extends RecyclerView.Adapter {
    public Context d;
    public LayoutInflater e;
    public List f;
    public Drawable h;
    public Drawable i;
    public b j;
    public int l;
    public List k = new ArrayList();
    public View.OnClickListener g = new a();

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
            ChooseImageBean chooseImageBean = (ChooseImageBean) pz.this.f.get(intValue);
            if (chooseImageBean.getType() == 0) {
                if (pz.this.j != null) {
                    pz.this.j.b();
                    return;
                }
                return;
            }
            if (chooseImageBean.isChecked()) {
                chooseImageBean.setChecked(false);
                pz.this.r(intValue, "payload");
                pz.this.k.remove(chooseImageBean);
                if (pz.this.j != null) {
                    pz.this.j.t0(pz.this.k.size());
                    return;
                }
                return;
            }
            if (pz.this.k.size() >= pz.this.l) {
                t54.b(aq4.b(m93.o1, Integer.valueOf(pz.this.l)));
                return;
            }
            chooseImageBean.setChecked(true);
            pz.this.r(intValue, "payload");
            pz.this.k.add(chooseImageBean);
            if (pz.this.j != null) {
                pz.this.j.t0(pz.this.k.size());
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface b {
        void b();

        void t0(int i);
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends d {
        public ImageView v;
        public ImageView w;

        public c(View view) {
            super(view);
            this.v = (ImageView) view.findViewById(y63.N);
            this.w = (ImageView) view.findViewById(y63.v);
        }

        @Override // pz.d
        public void O(ChooseImageBean chooseImageBean, int i, Object obj) {
            super.O(chooseImageBean, i, obj);
            if (obj == null) {
                kn1.d(pz.this.d, chooseImageBean.getImageUri(), this.v);
            }
            ImageView imageView = this.w;
            boolean isChecked = chooseImageBean.isChecked();
            pz pzVar = pz.this;
            imageView.setImageDrawable(isChecked ? pzVar.h : pzVar.i);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d extends RecyclerView.e0 {
        public d(View view) {
            super(view);
            view.setOnClickListener(pz.this.g);
        }

        public void O(ChooseImageBean chooseImageBean, int i, Object obj) {
            ((RecyclerView.e0) this).a.setTag(Integer.valueOf(i));
        }
    }

    public pz(Context context, List list, int i) {
        this.l = i;
        this.e = LayoutInflater.from(context);
        this.d = context;
        this.f = list;
        this.h = o60.d(context, q83.y1);
        this.i = o60.d(context, q83.x1);
    }

    public void A(RecyclerView.e0 e0Var, int i, List list) {
        ((d) e0Var).O((ChooseImageBean) this.f.get(i), i, list.size() > 0 ? list.get(0) : null);
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return i == 0 ? new d(this.e.inflate(u73.z, viewGroup, false)) : new c(this.e.inflate(u73.A, viewGroup, false));
    }

    public ArrayList T() {
        File imageFile;
        List list = this.k;
        ArrayList arrayList = null;
        if (list != null && list.size() != 0) {
            for (ChooseImageBean chooseImageBean : this.k) {
                if (chooseImageBean.getType() == 1 && chooseImageBean.isChecked() && (imageFile = chooseImageBean.getImageFile()) != null && imageFile.exists()) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(imageFile.getAbsolutePath());
                }
            }
        }
        return arrayList;
    }

    public void U(b bVar) {
        this.j = bVar;
    }

    public int j() {
        return this.f.size();
    }

    public int l(int i) {
        return ((ChooseImageBean) this.f.get(i)).getType();
    }

    public void z(RecyclerView.e0 e0Var, int i) {
    }
}
