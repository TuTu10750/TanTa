package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.common.bean.TxLocationPoiBean;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class j72 extends ce3 {
    public int i;
    public View.OnClickListener j;

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
            TxLocationPoiBean txLocationPoiBean = (TxLocationPoiBean) j72.this.e.get(intValue);
            if (j72.this.i != intValue) {
                ((TxLocationPoiBean) j72.this.e.get(j72.this.i)).setChecked(false);
                txLocationPoiBean.setChecked(true);
                j72 j72Var = j72.this;
                j72Var.r(j72Var.i, "payload");
                j72.this.r(intValue, "payload");
                j72.this.i = intValue;
            }
            if (j72.this.h != null) {
                j72.this.h.onItemClick(txLocationPoiBean, intValue);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends RecyclerView.e0 {
        public TextView u;
        public TextView v;
        public ImageView w;
        public View x;

        public b(View view) {
            super(view);
            this.u = (TextView) view.findViewById(a73.o0);
            this.v = (TextView) view.findViewById(a73.b);
            this.w = (ImageView) view.findViewById(a73.X);
            this.x = view.findViewById(a73.R);
            view.setOnClickListener(j72.this.j);
        }

        public void O(TxLocationPoiBean txLocationPoiBean, int i, Object obj) {
            ((RecyclerView.e0) this).a.setTag(Integer.valueOf(i));
            if (obj == null) {
                this.u.setText(txLocationPoiBean.getTitle());
                this.v.setText(txLocationPoiBean.getAddress());
                int size = j72.this.e.size() - 1;
                View view = this.x;
                if (i == size) {
                    if (view.getVisibility() == 0) {
                        this.x.setVisibility(4);
                    }
                } else if (view.getVisibility() != 0) {
                    this.x.setVisibility(0);
                }
            }
            boolean isChecked = txLocationPoiBean.isChecked();
            ImageView imageView = this.w;
            if (isChecked) {
                imageView.setImageResource(q83.o1);
            } else {
                imageView.setImageDrawable(null);
            }
        }
    }

    public j72(Context context) {
        super(context);
        this.j = new a();
    }

    public void A(RecyclerView.e0 e0Var, int i, List list) {
        ((b) e0Var).O((TxLocationPoiBean) this.e.get(i), i, list.size() > 0 ? list.get(0) : null);
    }

    @Override // defpackage.ce3
    public void P(List list) {
        if (list.size() > 0) {
            ((TxLocationPoiBean) list.get(0)).setChecked(true);
        }
        this.i = 0;
        super.P(list);
    }

    public TxLocationPoiBean a0() {
        int i;
        List list = this.e;
        if (list == null || (i = this.i) < 0 || i >= list.size()) {
            return null;
        }
        return (TxLocationPoiBean) this.e.get(this.i);
    }

    /* renamed from: b0, reason: merged with bridge method [inline-methods] */
    public b B(ViewGroup viewGroup, int i) {
        return new b(this.f.inflate(w73.x, viewGroup, false));
    }

    @Override // defpackage.ce3
    public int j() {
        return this.e.size();
    }

    public void z(RecyclerView.e0 e0Var, int i) {
    }
}
