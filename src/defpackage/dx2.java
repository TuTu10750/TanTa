package defpackage;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.mall.bean.PayContentVideoBean;
import java.io.File;

/* loaded from: /tmp/classes2.dex */
public class dx2 extends ce3 {
    public View.OnClickListener i;
    public View.OnClickListener j;
    public View.OnClickListener k;
    public View.OnClickListener l;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue = ((Integer) view.getTag()).intValue();
            if (dx2.this.h != null) {
                dx2.this.h.onItemClick((PayContentVideoBean) dx2.this.e.get(intValue), intValue);
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
            ((PayContentVideoBean) dx2.this.e.get(intValue)).setFilePath(null);
            dx2.this.q(intValue);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int size = dx2.this.e.size();
            dx2.this.e.add(new PayContentVideoBean());
            dx2.this.s(size);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            dx2.this.e.remove(((Integer) view.getTag()).intValue());
            dx2.this.p();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e extends RecyclerView.e0 {
        public View u;
        public ImageView v;
        public View w;
        public EditText x;
        public PayContentVideoBean y;

        /* loaded from: /tmp/classes2.dex */
        public class a implements TextWatcher {
            public final /* synthetic */ dx2 a;

            public a(dx2 dx2Var) {
                this.a = dx2Var;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                PayContentVideoBean payContentVideoBean = e.this.y;
                if (payContentVideoBean != null) {
                    payContentVideoBean.setTitle(charSequence.toString());
                }
            }
        }

        public e(View view) {
            super(view);
            this.u = view.findViewById(d73.p1);
            this.v = (ImageView) view.findViewById(d73.x2);
            this.w = view.findViewById(d73.i0);
            this.u.setOnClickListener(dx2.this.i);
            this.w.setOnClickListener(dx2.this.j);
            EditText editText = (EditText) view.findViewById(d73.R1);
            this.x = editText;
            editText.addTextChangedListener(new a(dx2.this));
        }

        public void O(PayContentVideoBean payContentVideoBean, int i) {
            this.u.setTag(Integer.valueOf(i));
            this.w.setTag(Integer.valueOf(i));
            this.y = payContentVideoBean;
            this.x.setText(payContentVideoBean.getTitle());
            File file = payContentVideoBean.getFile();
            if (file == null || !file.exists()) {
                this.v.setImageDrawable(null);
                if (this.w.getVisibility() == 0) {
                    this.w.setVisibility(4);
                    return;
                }
                return;
            }
            kn1.n(dx2.this.d, file, this.v);
            if (this.w.getVisibility() != 0) {
                this.w.setVisibility(0);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class f extends e {
        public CheckBox A;

        /* loaded from: /tmp/classes2.dex */
        public class a implements CompoundButton.OnCheckedChangeListener {
            public final /* synthetic */ dx2 a;

            public a(dx2 dx2Var) {
                this.a = dx2Var;
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                PayContentVideoBean payContentVideoBean = f.this.y;
                if (payContentVideoBean != null) {
                    payContentVideoBean.setIsSee(z ? 1 : 0);
                }
            }
        }

        public f(View view) {
            super(view);
            CheckBox checkBox = (CheckBox) view.findViewById(d73.y1);
            this.A = checkBox;
            checkBox.setOnCheckedChangeListener(new a(dx2.this));
        }

        @Override // dx2.e
        public void O(PayContentVideoBean payContentVideoBean, int i) {
            super.O(payContentVideoBean, i);
            this.A.setChecked(payContentVideoBean.getIsSee() == 1);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class g extends e {
        public View A;

        public g(View view) {
            super(view);
            View findViewById = view.findViewById(d73.k0);
            this.A = findViewById;
            findViewById.setOnClickListener(dx2.this.l);
        }

        @Override // dx2.e
        public void O(PayContentVideoBean payContentVideoBean, int i) {
            super.O(payContentVideoBean, i);
            this.A.setTag(Integer.valueOf(i));
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class h extends RecyclerView.e0 {
        public h(View view) {
            super(view);
            view.setOnClickListener(dx2.this.k);
        }
    }

    public dx2(Context context) {
        super(context);
        this.e.add(new PayContentVideoBean());
        this.e.add(new PayContentVideoBean());
        this.i = new a();
        this.j = new b();
        this.k = new c();
        this.l = new d();
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return i == -1 ? new h(this.f.inflate(z73.Z0, viewGroup, false)) : i == 0 ? new f(this.f.inflate(z73.X0, viewGroup, false)) : i == 1 ? new e(this.f.inflate(z73.Y0, viewGroup, false)) : new g(this.f.inflate(z73.W0, viewGroup, false));
    }

    public void e0(String str, String str2, int i) {
        PayContentVideoBean payContentVideoBean = (PayContentVideoBean) this.e.get(i);
        payContentVideoBean.setFilePath(str);
        payContentVideoBean.setDuration(str2);
        q(i);
    }

    @Override // defpackage.ce3
    public int j() {
        return super.j() + 1;
    }

    public int l(int i) {
        if (i == this.e.size()) {
            return -1;
        }
        if (i == 0) {
            return 0;
        }
        return i == 1 ? 1 : 2;
    }

    public void z(RecyclerView.e0 e0Var, int i) {
        if (e0Var instanceof e) {
            ((e) e0Var).O((PayContentVideoBean) this.e.get(i), i);
        }
    }
}
