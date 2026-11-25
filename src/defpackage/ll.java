package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.mall.bean.BuyerAddressBean;

/* loaded from: /tmp/classes2.dex */
public class ll extends ce3 {
    public View.OnClickListener i;
    public View.OnClickListener j;
    public c k;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag == null || ll.this.k == null) {
                return;
            }
            ll.this.k.u0((BuyerAddressBean) tag);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag == null || ll.this.k == null) {
                return;
            }
            ll.this.k.S((BuyerAddressBean) tag);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface c {
        void S(BuyerAddressBean buyerAddressBean);

        void u0(BuyerAddressBean buyerAddressBean);
    }

    /* loaded from: /tmp/classes2.dex */
    public class d extends RecyclerView.e0 {
        public TextView u;
        public TextView v;
        public View w;
        public View x;

        public d(View view) {
            super(view);
            this.u = (TextView) view.findViewById(d73.R2);
            this.v = (TextView) view.findViewById(d73.d);
            this.w = view.findViewById(d73.e4);
            this.x = view.findViewById(d73.q0);
            view.setOnClickListener(ll.this.i);
            this.x.setOnClickListener(ll.this.j);
        }

        public void O(BuyerAddressBean buyerAddressBean) {
            this.x.setTag(buyerAddressBean);
            ((RecyclerView.e0) this).a.setTag(buyerAddressBean);
            this.u.setText(rv3.a(buyerAddressBean.getName(), "  ", buyerAddressBean.getPhoneNum()));
            this.v.setText(rv3.a(buyerAddressBean.getProvince(), " ", buyerAddressBean.getCity(), " ", buyerAddressBean.getZone(), " ", buyerAddressBean.getAddress()));
            int isDefault = buyerAddressBean.getIsDefault();
            View view = this.w;
            if (isDefault == 1) {
                if (view.getVisibility() != 0) {
                    this.w.setVisibility(0);
                }
            } else if (view.getVisibility() == 0) {
                this.w.setVisibility(4);
            }
        }
    }

    public ll(Context context) {
        super(context);
        this.i = new a();
        this.j = new b();
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new d(this.f.inflate(z73.p0, viewGroup, false));
    }

    public void V(c cVar) {
        this.k = cVar;
    }

    public void z(RecyclerView.e0 e0Var, int i) {
        ((d) e0Var).O((BuyerAddressBean) this.e.get(i));
    }
}
