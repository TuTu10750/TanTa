package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.main.bean.ChooseCountryBean;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class oz extends ce3 {
    public View.OnClickListener i;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (oz.this.h != null) {
                oz.this.h.onItemClick((ChooseCountryBean) view.getTag(), 0);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (oz.this.h != null) {
                oz.this.h.onItemClick((ChooseCountryBean) view.getTag(), 0);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends RecyclerView.e0 {
        public TextView u;

        public c(View view) {
            super(view);
            this.u = (TextView) view.findViewById(c73.L3);
            view.setOnClickListener(oz.this.i);
        }

        public void O(ChooseCountryBean chooseCountryBean) {
            ((RecyclerView.e0) this).a.setTag(chooseCountryBean);
            this.u.setText(chooseCountryBean.getTransName());
        }
    }

    public oz(Context context) {
        super(context);
        this.i = new a();
    }

    public oz(Context context, List list) {
        super(context, list);
        this.i = new b();
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new c(this.f.inflate(y73.v0, viewGroup, false));
    }

    public void z(RecyclerView.e0 e0Var, int i) {
        ((c) e0Var).O((ChooseCountryBean) this.e.get(i));
    }
}
