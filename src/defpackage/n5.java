package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.mall.bean.AddGoodsCommentImageBean;
import defpackage.pm1;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class n5 extends ce3 {
    public String i;
    public View.OnClickListener j;
    public View.OnClickListener k;
    public File l;
    public String m;
    public String n;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {

        /* renamed from: n5$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/classes2.dex */
        public class C0135a implements pm1.c {
            public final /* synthetic */ List a;

            public C0135a(List list) {
                this.a = list;
            }

            @Override // pm1.c
            public void a(ImageView imageView, int i) {
                kn1.e(n5.this.d, (File) this.a.get(i), imageView);
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
            int intValue = ((Integer) view.getTag()).intValue();
            AddGoodsCommentImageBean addGoodsCommentImageBean = (AddGoodsCommentImageBean) n5.this.e.get(intValue);
            boolean isEmpty = addGoodsCommentImageBean.isEmpty();
            n5 n5Var = n5.this;
            if (isEmpty) {
                if (n5Var.h != null) {
                    n5.this.h.onItemClick(addGoodsCommentImageBean, intValue);
                    return;
                }
                return;
            }
            if (intValue == n5Var.e.size() - 1) {
                if (n5.this.l != null) {
                    n5.this.l.exists();
                    return;
                }
                return;
            }
            ArrayList arrayList = new ArrayList();
            int size = n5.this.e.size() - 1;
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                AddGoodsCommentImageBean addGoodsCommentImageBean2 = (AddGoodsCommentImageBean) n5.this.e.get(i2);
                if (!addGoodsCommentImageBean2.isEmpty()) {
                    if (addGoodsCommentImageBean == addGoodsCommentImageBean2) {
                        i = arrayList.size();
                    }
                    arrayList.add(addGoodsCommentImageBean2.getFile());
                }
            }
            if (arrayList.size() > 0) {
                pm1 pm1Var = new pm1();
                pm1Var.z2(arrayList.size(), i, false, new C0135a(arrayList));
                pm1Var.d2(((AbsActivity) n5.this.d).getSupportFragmentManager(), "ImagePreviewDialog");
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue = ((Integer) view.getTag()).intValue();
            ((AddGoodsCommentImageBean) n5.this.e.get(intValue)).setEmpty();
            int size = n5.this.e.size() - 1;
            n5 n5Var = n5.this;
            if (intValue == size) {
                n5Var.l = null;
                n5.this.m = null;
                n5.this.n = null;
                n5.this.q(intValue);
                return;
            }
            if (n5Var.e.size() <= 2 || intValue >= n5.this.e.size() - 2) {
                n5.this.q(intValue);
                return;
            }
            n5.this.e.remove(intValue);
            int size2 = n5.this.e.size();
            if (size2 > 2 && !((AddGoodsCommentImageBean) n5.this.e.get(size2 - 2)).isEmpty()) {
                n5.this.e.add(size2 - 1, new AddGoodsCommentImageBean());
            }
            n5.this.p();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends d {
        public TextView x;

        public c(View view) {
            super(view);
            this.x = (TextView) view.findViewById(d73.l4);
        }

        @Override // n5.d
        public void O(AddGoodsCommentImageBean addGoodsCommentImageBean, int i) {
            super.O(addGoodsCommentImageBean, i);
            if (i <= 0 || !addGoodsCommentImageBean.isEmpty()) {
                this.x.setText(n5.this.i);
            } else {
                this.x.setText(rv3.a(String.valueOf(n5.this.e.size() - 2), "/5"));
            }
            if (addGoodsCommentImageBean.isEmpty()) {
                this.u.setImageDrawable(null);
                if (this.v.getVisibility() == 0) {
                    this.v.setVisibility(4);
                    return;
                }
                return;
            }
            if (addGoodsCommentImageBean.getFile() != null) {
                kn1.e(n5.this.d, addGoodsCommentImageBean.getFile(), this.u);
            }
            if (this.v.getVisibility() != 0) {
                this.v.setVisibility(0);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d extends RecyclerView.e0 {
        public ImageView u;
        public View v;

        public d(View view) {
            super(view);
            this.u = (ImageView) view.findViewById(d73.x2);
            this.v = view.findViewById(d73.i0);
            view.setOnClickListener(n5.this.j);
            this.v.setOnClickListener(n5.this.k);
        }

        public void O(AddGoodsCommentImageBean addGoodsCommentImageBean, int i) {
            ((RecyclerView.e0) this).a.setTag(Integer.valueOf(i));
            this.v.setTag(Integer.valueOf(i));
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e extends d {
        public View x;

        public e(View view) {
            super(view);
            this.x = view.findViewById(d73.u4);
        }

        @Override // n5.d
        public void O(AddGoodsCommentImageBean addGoodsCommentImageBean, int i) {
            super.O(addGoodsCommentImageBean, i);
            if (addGoodsCommentImageBean.isEmpty()) {
                this.u.setImageDrawable(null);
                if (this.v.getVisibility() == 0) {
                    this.v.setVisibility(4);
                }
                if (this.x.getVisibility() == 0) {
                    this.x.setVisibility(4);
                    return;
                }
                return;
            }
            if (addGoodsCommentImageBean.getFile() != null) {
                kn1.n(n5.this.d, addGoodsCommentImageBean.getFile(), this.u);
            }
            if (this.v.getVisibility() != 0) {
                this.v.setVisibility(0);
            }
            if (this.x.getVisibility() != 0) {
                this.x.setVisibility(0);
            }
        }
    }

    public n5(Context context) {
        super(context);
        this.e.add(new AddGoodsCommentImageBean());
        this.e.add(new AddGoodsCommentImageBean());
        this.i = aq4.a(m93.b7);
        this.j = new a();
        this.k = new b();
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return i == -1 ? new e(this.f.inflate(z73.m0, viewGroup, false)) : new c(this.f.inflate(z73.l0, viewGroup, false));
    }

    public int l(int i) {
        return i == this.e.size() + (-1) ? -1 : 0;
    }

    public File s0() {
        return this.l;
    }

    public String t0() {
        return this.n;
    }

    public String u0() {
        return this.m;
    }

    public void v0(int i, File file) {
        if (i == this.e.size() - 1) {
            this.l = file;
        }
        ((AddGoodsCommentImageBean) this.e.get(i)).setFile(file);
        int size = this.e.size();
        int i2 = size - 1;
        if (i != i2 && size < 6) {
            this.e.add(i2, new AddGoodsCommentImageBean());
        }
        p();
    }

    public void w0(String str) {
        this.n = str;
    }

    public void x0(String str) {
        this.m = str;
    }

    public void z(RecyclerView.e0 e0Var, int i) {
        ((d) e0Var).O((AddGoodsCommentImageBean) this.e.get(i), i);
    }
}
