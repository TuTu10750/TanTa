package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.common.bean.TxLocationPoiBean;

/* loaded from: /tmp/classes2.dex */
public class rz extends ce3 {
    public View.OnClickListener i;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            et2 et2Var = rz.this.h;
            if (et2Var != null) {
                if (tag == null) {
                    et2Var.onItemClick(null, 0);
                } else {
                    et2Var.onItemClick((TxLocationPoiBean) tag, 0);
                }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends RecyclerView.e0 {
        public b(View view) {
            super(view);
            view.setOnClickListener(rz.this.i);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends RecyclerView.e0 {
        public TextView u;
        public TextView v;

        public c(View view) {
            super(view);
            this.u = (TextView) view.findViewById(y63.h0);
            this.v = (TextView) view.findViewById(y63.a);
            view.setOnClickListener(rz.this.i);
        }

        public void O(TxLocationPoiBean txLocationPoiBean) {
            ((RecyclerView.e0) this).a.setTag(txLocationPoiBean);
            this.u.setText(txLocationPoiBean.getTitle());
            this.v.setText(txLocationPoiBean.getAddress());
        }
    }

    public rz(Context context) {
        super(context);
        this.i = new a();
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return i == -1 ? new b(this.f.inflate(u73.C, viewGroup, false)) : new c(this.f.inflate(u73.B, viewGroup, false));
    }

    @Override // defpackage.ce3
    public int j() {
        return super.j() + 1;
    }

    public int l(int i) {
        return i == 0 ? -1 : 0;
    }

    public void z(RecyclerView.e0 e0Var, int i) {
        if (e0Var instanceof c) {
            ((c) e0Var).O((TxLocationPoiBean) this.e.get(i - 1));
        }
    }
}
