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
public class q5 extends ce3 {
    public String i;
    public String j;
    public View.OnClickListener k;
    public View.OnClickListener l;
    public File m;
    public String n;
    public String o;
    public String p;
    public String q;
    public List r;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {

        /* renamed from: q5$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/classes2.dex */
        public class C0150a implements pm1.c {
            public C0150a() {
            }

            @Override // pm1.c
            public void a(ImageView imageView, int i) {
                AddGoodsImageBean addGoodsImageBean = (AddGoodsImageBean) q5.this.r.get(i);
                File file = addGoodsImageBean.getFile();
                if (file != null && file.exists()) {
                    kn1.e(q5.this.d, file, imageView);
                    return;
                }
                String imgUrl = addGoodsImageBean.getImgUrl();
                if (TextUtils.isEmpty(imgUrl)) {
                    return;
                }
                kn1.f(q5.this.d, imgUrl, imageView);
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
            q5 q5Var;
            int intValue = ((Integer) view.getTag()).intValue();
            AddGoodsImageBean addGoodsImageBean = (AddGoodsImageBean) q5.this.e.get(intValue);
            if (addGoodsImageBean.isEmpty()) {
                if (q5.this.h != null) {
                    q5.this.h.onItemClick(addGoodsImageBean, intValue);
                    return;
                }
                return;
            }
            if (intValue == 0) {
                File file = addGoodsImageBean.getFile();
                if ((file == null || !file.exists()) && !TextUtils.isEmpty(q5.this.p)) {
                    pi3.s(q5.this.d, q5.this.p, q5.this.q);
                    return;
                }
                return;
            }
            if (q5.this.r == null) {
                q5.this.r = new ArrayList();
            }
            if (q5.this.r.size() > 0) {
                q5.this.r.clear();
            }
            int size = q5.this.e.size();
            int i = 1;
            while (true) {
                q5Var = q5.this;
                if (i >= size) {
                    break;
                }
                AddGoodsImageBean addGoodsImageBean2 = (AddGoodsImageBean) q5Var.e.get(i);
                if (!addGoodsImageBean2.isEmpty()) {
                    q5.this.r.add(addGoodsImageBean2);
                }
                i++;
            }
            if (q5Var.r.size() == 0) {
                return;
            }
            int size2 = q5.this.r.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size2; i3++) {
                if (addGoodsImageBean == q5.this.r.get(i3)) {
                    i2 = i3;
                }
            }
            pm1 pm1Var = new pm1();
            pm1Var.z2(q5.this.r.size(), i2, false, new C0150a());
            pm1Var.d2(((AbsActivity) q5.this.d).getSupportFragmentManager(), "ImagePreviewDialog");
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue = ((Integer) view.getTag()).intValue();
            ((AddGoodsImageBean) q5.this.e.get(intValue)).setEmpty();
            if (intValue != 0 && intValue != q5.this.e.size() - 1) {
                q5.this.e.remove(intValue);
                if (!((AddGoodsImageBean) q5.this.e.get(q5.this.e.size() - 1)).isEmpty()) {
                    q5.this.e.add(new AddGoodsImageBean());
                }
                q5.this.p();
                return;
            }
            if (intValue == 0) {
                q5.this.m = null;
                q5.this.n = null;
                q5.this.o = null;
            }
            q5.this.q(intValue);
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
            view.setOnClickListener(q5.this.k);
            this.w.setOnClickListener(q5.this.l);
        }

        public void O(AddGoodsImageBean addGoodsImageBean, int i) {
            ((RecyclerView.e0) this).a.setTag(Integer.valueOf(i));
            this.w.setTag(Integer.valueOf(i));
            if (i <= 1 || !addGoodsImageBean.isEmpty()) {
                TextView textView = this.u;
                if (i == 0) {
                    textView.setText(q5.this.i);
                } else {
                    textView.setText(q5.this.j);
                }
            } else {
                this.u.setText(rv3.a(String.valueOf(q5.this.e.size() - 2), "/9"));
            }
            if (addGoodsImageBean.isEmpty()) {
                this.v.setImageDrawable(null);
                if (this.w.getVisibility() == 0) {
                    this.w.setVisibility(4);
                    return;
                }
                return;
            }
            if (addGoodsImageBean.getFile() != null) {
                q5 q5Var = q5.this;
                if (i == 0) {
                    kn1.n(q5Var.d, addGoodsImageBean.getFile(), this.v);
                } else {
                    kn1.e(q5Var.d, addGoodsImageBean.getFile(), this.v);
                }
            } else {
                kn1.f(q5.this.d, addGoodsImageBean.getImgUrl(), this.v);
            }
            if (this.w.getVisibility() != 0) {
                this.w.setVisibility(0);
            }
        }
    }

    public q5(Context context) {
        super(context);
        this.i = aq4.a(m93.P5);
        this.j = aq4.a(m93.Q5);
        this.k = new a();
        this.l = new b();
    }

    public void A0(String str) {
        this.o = str;
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new c(this.f.inflate(z73.o0, viewGroup, false));
    }

    public void B0(String str) {
        this.q = str;
    }

    public void C0(String str) {
        this.n = str;
    }

    public void D0(String str) {
        this.p = str;
    }

    public File w0() {
        return this.m;
    }

    public String x0() {
        return this.o;
    }

    public String y0() {
        return this.n;
    }

    public void z(RecyclerView.e0 e0Var, int i) {
        ((c) e0Var).O((AddGoodsImageBean) this.e.get(i), i);
    }

    public void z0(int i, File file) {
        if (i == 0) {
            this.m = file;
        }
        ((AddGoodsImageBean) this.e.get(i)).setFile(file);
        int size = this.e.size();
        if (i == size - 1 && size < 10) {
            this.e.add(new AddGoodsImageBean());
        }
        p();
    }
}
