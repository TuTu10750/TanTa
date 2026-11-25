package defpackage;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.mall.bean.AddGoodsSpecBean;
import defpackage.pm1;
import java.io.File;

/* loaded from: /tmp/classes2.dex */
public class p5 extends ce3 {
    public String i;
    public View.OnClickListener j;
    public View.OnClickListener k;
    public View.OnClickListener l;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {

        /* renamed from: p5$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/classes2.dex */
        public class C0143a implements pm1.c {
            public final /* synthetic */ AddGoodsSpecBean a;

            public C0143a(AddGoodsSpecBean addGoodsSpecBean) {
                this.a = addGoodsSpecBean;
            }

            @Override // pm1.c
            public void a(ImageView imageView, int i) {
                File file = this.a.getFile();
                if (file != null && file.exists()) {
                    kn1.e(p5.this.d, file, imageView);
                    return;
                }
                String thumb = this.a.getThumb();
                if (TextUtils.isEmpty(thumb)) {
                    return;
                }
                kn1.f(p5.this.d, thumb, imageView);
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
            AddGoodsSpecBean addGoodsSpecBean = (AddGoodsSpecBean) p5.this.e.get(intValue);
            if (addGoodsSpecBean.isEmpty()) {
                if (p5.this.h != null) {
                    p5.this.h.onItemClick(addGoodsSpecBean, intValue);
                }
            } else {
                pm1 pm1Var = new pm1();
                pm1Var.z2(1, 0, false, new C0143a(addGoodsSpecBean));
                pm1Var.d2(((AbsActivity) p5.this.d).getSupportFragmentManager(), "ImagePreviewDialog");
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
            ((AddGoodsSpecBean) p5.this.e.get(intValue)).setEmpty();
            p5.this.q(intValue);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            p5.this.e.remove(((Integer) view.getTag()).intValue());
            p5.this.p();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d extends RecyclerView.e0 {
        public View A;
        public View B;
        public AddGoodsSpecBean C;
        public TextView u;
        public EditText v;
        public EditText w;
        public EditText x;
        public ImageView y;
        public View z;

        /* loaded from: /tmp/classes2.dex */
        public class a implements TextWatcher {
            public final /* synthetic */ p5 a;

            public a(p5 p5Var) {
                this.a = p5Var;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AddGoodsSpecBean addGoodsSpecBean = d.this.C;
                if (addGoodsSpecBean != null) {
                    addGoodsSpecBean.setName(charSequence.toString());
                }
            }
        }

        /* loaded from: /tmp/classes2.dex */
        public class b implements TextWatcher {
            public final /* synthetic */ p5 a;

            public b(p5 p5Var) {
                this.a = p5Var;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AddGoodsSpecBean addGoodsSpecBean = d.this.C;
                if (addGoodsSpecBean != null) {
                    addGoodsSpecBean.setNum(charSequence.toString());
                }
            }
        }

        /* loaded from: /tmp/classes2.dex */
        public class c implements TextWatcher {
            public final /* synthetic */ p5 a;

            public c(p5 p5Var) {
                this.a = p5Var;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AddGoodsSpecBean addGoodsSpecBean = d.this.C;
                if (addGoodsSpecBean != null) {
                    addGoodsSpecBean.setPrice(charSequence.toString());
                }
            }
        }

        public d(View view) {
            super(view);
            this.u = (TextView) view.findViewById(d73.D2);
            this.v = (EditText) view.findViewById(d73.R2);
            this.w = (EditText) view.findViewById(d73.W2);
            this.x = (EditText) view.findViewById(d73.k3);
            this.y = (ImageView) view.findViewById(d73.x2);
            this.A = view.findViewById(d73.t0);
            this.z = view.findViewById(d73.i0);
            this.B = view.findViewById(d73.l0);
            this.A.setOnClickListener(p5.this.j);
            this.z.setOnClickListener(p5.this.k);
            this.B.setOnClickListener(p5.this.l);
            this.v.addTextChangedListener(new a(p5.this));
            this.w.addTextChangedListener(new b(p5.this));
            this.x.addTextChangedListener(new c(p5.this));
        }

        public void O(AddGoodsSpecBean addGoodsSpecBean, int i) {
            this.C = addGoodsSpecBean;
            this.A.setTag(Integer.valueOf(i));
            this.z.setTag(Integer.valueOf(i));
            this.B.setTag(Integer.valueOf(i));
            this.u.setText(rv3.a(p5.this.i, String.valueOf(i + 1)));
            this.v.setText(addGoodsSpecBean.getName());
            this.w.setText(addGoodsSpecBean.getNum());
            this.x.setText(addGoodsSpecBean.getPrice());
            View view = this.B;
            if (i == 0) {
                if (view.getVisibility() == 0) {
                    this.B.setVisibility(4);
                }
            } else if (view.getVisibility() != 0) {
                this.B.setVisibility(0);
            }
            if (addGoodsSpecBean.isEmpty()) {
                this.y.setImageDrawable(null);
                if (this.z.getVisibility() == 0) {
                    this.z.setVisibility(4);
                    return;
                }
                return;
            }
            File file = addGoodsSpecBean.getFile();
            p5 p5Var = p5.this;
            if (file != null) {
                kn1.e(p5Var.d, addGoodsSpecBean.getFile(), this.y);
            } else {
                kn1.f(p5Var.d, addGoodsSpecBean.getThumb(), this.y);
            }
            if (this.z.getVisibility() != 0) {
                this.z.setVisibility(0);
            }
        }
    }

    public p5(Context context) {
        super(context);
        this.i = aq4.a(m93.S5);
        this.j = new a();
        this.k = new b();
        this.l = new c();
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new d(this.f.inflate(z73.n0, viewGroup, false));
    }

    public void g0() {
        int size = this.e.size();
        this.e.add(new AddGoodsSpecBean());
        s(size);
    }

    public void h0(int i, File file) {
        ((AddGoodsSpecBean) this.e.get(i)).setFile(file);
        q(i);
    }

    public void z(RecyclerView.e0 e0Var, int i) {
        ((d) e0Var).O((AddGoodsSpecBean) this.e.get(i), i);
    }
}
