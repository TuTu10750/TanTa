package defpackage;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.mall.bean.AddGoodsSpecBean;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class jd1 extends ce3 {
    public String i;

    /* loaded from: /tmp/classes2.dex */
    public class a extends RecyclerView.e0 {
        public TextView u;
        public TextView v;
        public EditText w;
        public EditText x;
        public AddGoodsSpecBean y;

        /* renamed from: jd1$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/classes2.dex */
        public class C0084a implements TextWatcher {
            public final /* synthetic */ jd1 a;

            public C0084a(jd1 jd1Var) {
                this.a = jd1Var;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AddGoodsSpecBean addGoodsSpecBean = a.this.y;
                if (addGoodsSpecBean != null) {
                    addGoodsSpecBean.setNum(charSequence.toString());
                }
            }
        }

        /* loaded from: /tmp/classes2.dex */
        public class b implements TextWatcher {
            public final /* synthetic */ jd1 a;

            public b(jd1 jd1Var) {
                this.a = jd1Var;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AddGoodsSpecBean addGoodsSpecBean = a.this.y;
                if (addGoodsSpecBean != null) {
                    addGoodsSpecBean.setPrice(charSequence.toString());
                }
            }
        }

        public a(View view) {
            super(view);
            this.u = (TextView) view.findViewById(d73.D2);
            this.v = (TextView) view.findViewById(d73.R2);
            this.w = (EditText) view.findViewById(d73.W2);
            this.x = (EditText) view.findViewById(d73.k3);
            this.w.addTextChangedListener(new C0084a(jd1.this));
            this.x.addTextChangedListener(new b(jd1.this));
        }

        public void O(AddGoodsSpecBean addGoodsSpecBean, int i) {
            this.y = addGoodsSpecBean;
            this.u.setText(rv3.a(jd1.this.i, String.valueOf(i + 1)));
            this.v.setText(addGoodsSpecBean.getName());
            this.w.setText(addGoodsSpecBean.getNum());
            this.x.setText(addGoodsSpecBean.getPrice());
        }
    }

    public jd1(Context context, List list) {
        super(context, list);
        this.i = aq4.a(m93.S5);
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new a(this.f.inflate(z73.N0, viewGroup, false));
    }

    public void z(RecyclerView.e0 e0Var, int i) {
        ((a) e0Var).O((AddGoodsSpecBean) this.e.get(i), i);
    }
}
