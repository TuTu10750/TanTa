package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.main.bean.CashAccountBean;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class ax extends RecyclerView.Adapter {
    public LayoutInflater e;
    public c h;
    public String i;
    public List d = new ArrayList();
    public View.OnClickListener f = new a();
    public View.OnClickListener g = new b();

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag == null || ax.this.h == null) {
                return;
            }
            int intValue = ((Integer) tag).intValue();
            ax.this.h.x((CashAccountBean) ax.this.d.get(intValue), intValue);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag == null || ax.this.h == null) {
                return;
            }
            int intValue = ((Integer) tag).intValue();
            ax.this.h.y((CashAccountBean) ax.this.d.get(intValue), intValue);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface c {
        void x(CashAccountBean cashAccountBean, int i);

        void y(CashAccountBean cashAccountBean, int i);
    }

    /* loaded from: /tmp/classes2.dex */
    public class d extends RecyclerView.e0 {
        public RadioButton u;
        public ImageView v;
        public TextView w;
        public View x;

        public d(View view) {
            super(view);
            this.u = (RadioButton) view.findViewById(c73.c4);
            this.v = (ImageView) view.findViewById(c73.E2);
            this.w = (TextView) view.findViewById(c73.a);
            this.x = view.findViewById(c73.f0);
            view.setOnClickListener(ax.this.f);
            this.x.setOnClickListener(ax.this.g);
        }

        public void O(CashAccountBean cashAccountBean, int i, Object obj) {
            ((RecyclerView.e0) this).a.setTag(Integer.valueOf(i));
            this.x.setTag(Integer.valueOf(i));
            if (obj == null) {
                this.v.setImageResource(l30.a(cashAccountBean.getType()));
                int type = cashAccountBean.getType();
                TextView textView = this.w;
                if (type == 2) {
                    textView.setText(cashAccountBean.getAccount());
                } else {
                    textView.setText(rv3.a(cashAccountBean.getAccount(), "(", cashAccountBean.getUserName(), ")"));
                }
            }
            this.u.setChecked(cashAccountBean.getId().equals(ax.this.i));
        }
    }

    public ax(Context context, String str) {
        this.i = str;
        this.e = LayoutInflater.from(context);
    }

    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public void z(d dVar, int i) {
    }

    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public void A(d dVar, int i, List list) {
        dVar.O((CashAccountBean) this.d.get(i), i, list.size() > 0 ? list.get(0) : null);
    }

    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public d B(ViewGroup viewGroup, int i) {
        return new d(this.e.inflate(y73.u0, viewGroup, false));
    }

    public void T(int i) {
        this.d.remove(i);
        p();
    }

    public void U(c cVar) {
        this.h = cVar;
    }

    public void V(List list) {
        this.d.clear();
        this.d.addAll(list);
        p();
    }

    public int j() {
        return this.d.size();
    }
}
