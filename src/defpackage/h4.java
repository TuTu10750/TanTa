package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.main.bean.ActiveImageBean;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class h4 extends RecyclerView.Adapter {
    public Context d;
    public LayoutInflater f;
    public b h;
    public List e = new ArrayList();
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
            File imageFile = ((ActiveImageBean) h4.this.e.get(intValue)).getImageFile();
            h4 h4Var = h4.this;
            if (imageFile == null) {
                if (h4Var.h != null) {
                    h4.this.h.a();
                }
            } else if (h4Var.h != null) {
                h4.this.h.onItemClick(intValue);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface b {
        void a();

        void b();

        void onItemClick(int i);
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends RecyclerView.e0 {
        public View u;
        public ImageView v;

        public c(View view) {
            super(view);
            this.u = view.findViewById(c73.F2);
            this.v = (ImageView) view.findViewById(c73.I2);
            view.setOnClickListener(h4.this.g);
        }

        public void O(ActiveImageBean activeImageBean, int i) {
            ((RecyclerView.e0) this).a.setTag(Integer.valueOf(i));
            if (activeImageBean.getImageFile() != null) {
                if (this.u.getVisibility() == 0) {
                    this.u.setVisibility(4);
                }
                kn1.e(h4.this.d, activeImageBean.getImageFile(), this.v);
            } else {
                this.v.setImageDrawable(null);
                if (this.u.getVisibility() != 0) {
                    this.u.setVisibility(0);
                }
            }
        }
    }

    public h4(Context context) {
        this.d = context;
        this.f = LayoutInflater.from(context);
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new c(this.f.inflate(y73.l0, viewGroup, false));
    }

    public void P(int i) {
        b bVar;
        List list = this.e;
        if (list == null) {
            return;
        }
        if (i >= 0 && i < list.size()) {
            this.e.remove(i);
        }
        int size = this.e.size();
        if (((ActiveImageBean) this.e.get(size - 1)).getImageFile() != null) {
            this.e.add(new ActiveImageBean());
        } else if (size == 1) {
            this.e.clear();
        }
        p();
        if (this.e.size() != 0 || (bVar = this.h) == null) {
            return;
        }
        bVar.b();
    }

    public int Q() {
        Iterator it = this.e.iterator();
        int i = 0;
        while (it.hasNext()) {
            File imageFile = ((ActiveImageBean) it.next()).getImageFile();
            if (imageFile != null && imageFile.exists()) {
                i++;
            }
        }
        return i;
    }

    public List R() {
        Iterator it = this.e.iterator();
        ArrayList arrayList = null;
        while (it.hasNext()) {
            File imageFile = ((ActiveImageBean) it.next()).getImageFile();
            if (imageFile != null && imageFile.exists()) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(imageFile);
            }
        }
        return arrayList;
    }

    public void S(List list) {
        int i = 0;
        for (ActiveImageBean activeImageBean : this.e) {
            if (activeImageBean.getImageFile() == null) {
                activeImageBean.setImageFile(new File((String) list.get(i)));
                i++;
            }
        }
        int size = 9 - this.e.size();
        if (size > 0) {
            int min = Math.min(size, list.size() - i);
            for (int i2 = 0; i2 < min; i2++) {
                this.e.add(new ActiveImageBean(new File((String) list.get(i + i2))));
            }
        }
        if (this.e.size() < 9) {
            this.e.add(new ActiveImageBean());
        }
        p();
    }

    public void T(b bVar) {
        this.h = bVar;
    }

    public int j() {
        return this.e.size();
    }

    public void z(RecyclerView.e0 e0Var, int i) {
        ((c) e0Var).O((ActiveImageBean) this.e.get(i), i);
    }
}
