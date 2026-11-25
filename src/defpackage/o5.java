package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.mall.bean.AddGoodsImageBean;
import defpackage.pm1;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class o5 extends ce3 {
    public String i;
    public View.OnClickListener j;
    public View.OnClickListener k;
    public List l;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {

        /* renamed from: o5$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/classes2.dex */
        public class C0137a implements pm1.c {
            public C0137a() {
            }

            @Override // pm1.c
            public void a(ImageView imageView, int i) {
                AddGoodsImageBean addGoodsImageBean = (AddGoodsImageBean) o5.this.l.get(i);
                File file = addGoodsImageBean.getFile();
                if (file != null && file.exists()) {
                    kn1.e(o5.this.d, file, imageView);
                    return;
                }
                String imgUrl = addGoodsImageBean.getImgUrl();
                if (TextUtils.isEmpty(imgUrl)) {
                    return;
                }
                kn1.f(o5.this.d, imgUrl, imageView);
            }

            @Override // pm1.c
            public void b(int i) {
            }

            @Override // pm1.c
            public String c(int i) {
                return null;
            }
        }

        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            o5 o5Var;
            int intValue = ((Integer) view.getTag()).intValue();
            AddGoodsImageBean addGoodsImageBean = (AddGoodsImageBean) o5.this.e.get(intValue);
            boolean isEmpty = addGoodsImageBean.isEmpty();
            o5 o5Var2 = o5.this;
            if (isEmpty) {
                if (o5Var2.h != null) {
                    o5.this.h.onItemClick(addGoodsImageBean, intValue);
                    return;
                }
                return;
            }
            if (o5Var2.l == null) {
                o5.this.l = new ArrayList();
            }
            if (o5.this.l.size() > 0) {
                o5.this.l.clear();
            }
            int size = o5.this.e.size();
            int i = 0;
            while (true) {
                o5Var = o5.this;
                if (i >= size) {
                    break;
                }
                AddGoodsImageBean addGoodsImageBean2 = (AddGoodsImageBean) o5Var.e.get(i);
                if (!addGoodsImageBean2.isEmpty()) {
                    o5.this.l.add(addGoodsImageBean2);
                }
                i++;
            }
            if (o5Var.l.size() == 0) {
                return;
            }
            int size2 = o5.this.l.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size2; i3++) {
                if (addGoodsImageBean == o5.this.l.get(i3)) {
                    i2 = i3;
                }
            }
            pm1 pm1Var = new pm1();
            pm1Var.z2(o5.this.l.size(), i2, false, new C0137a());
            pm1Var.d2(((AbsActivity) o5.this.d).getSupportFragmentManager(), "ImagePreviewDialog");
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue = ((Integer) view.getTag()).intValue();
            int size = o5.this.e.size() - 1;
            o5 o5Var = o5.this;
            if (intValue == size) {
                ((AddGoodsImageBean) o5Var.e.get(intValue)).setEmpty();
                o5.this.q(intValue);
            } else {
                o5Var.e.remove(intValue);
                if (!((AddGoodsImageBean) o5.this.e.get(o5.this.e.size() - 1)).isEmpty()) {
                    o5.this.e.add(new AddGoodsImageBean());
                }
                o5.this.p();
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends RecyclerView.e0 {
        public TextView u;
        public ImageView v;
        public View w;

        public c(View view) {
            super(view);
            this.u = (TextView) view.findViewById(d73.l4);
            this.v = (ImageView) view.findViewById(d73.x2);
            this.w = view.findViewById(d73.i0);
            view.setOnClickListener(o5.this.j);
            this.w.setOnClickListener(o5.this.k);
        }

        public void O(AddGoodsImageBean addGoodsImageBean, int i) {
            ((RecyclerView.e0) this).a.setTag(Integer.valueOf(i));
            this.w.setTag(Integer.valueOf(i));
            if (i <= 0 || !addGoodsImageBean.isEmpty()) {
                this.u.setText(o5.this.i);
            } else {
                this.u.setText(rv3.a(String.valueOf(o5.this.e.size() - 1), "/20"));
            }
            if (addGoodsImageBean.isEmpty()) {
                this.v.setImageDrawable(null);
                if (this.w.getVisibility() == 0) {
                    this.w.setVisibility(4);
                    return;
                }
                return;
            }
            File file = addGoodsImageBean.getFile();
            o5 o5Var = o5.this;
            if (file != null) {
                kn1.e(o5Var.d, addGoodsImageBean.getFile(), this.v);
            } else {
                kn1.f(o5Var.d, addGoodsImageBean.getImgUrl(), this.v);
            }
            if (this.w.getVisibility() != 0) {
                this.w.setVisibility(0);
            }
        }
    }

    public o5(Context context) {
        super(context);
        this.i = aq4.a(m93.R5);
        this.j = new a();
        this.k = new b();
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new c(this.f.inflate(z73.o0, viewGroup, false));
    }

    public void o0(int i, File file) {
        ((AddGoodsImageBean) this.e.get(i)).setFile(file);
        int size = this.e.size();
        if (i == size - 1 && size < 20) {
            this.e.add(new AddGoodsImageBean());
        }
        p();
    }

    public void z(RecyclerView.e0 e0Var, int i) {
        ((c) e0Var).O((AddGoodsImageBean) this.e.get(i), i);
    }
}
