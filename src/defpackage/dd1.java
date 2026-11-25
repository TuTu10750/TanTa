package defpackage;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.mall.bean.GoodsClassTitleBean;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class dd1 extends ce3 {
    public int i;
    public int j;
    public View.OnClickListener k;
    public int l;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue;
            Object tag = view.getTag();
            if (tag == null || dd1.this.l == (intValue = ((Integer) tag).intValue())) {
                return;
            }
            GoodsClassTitleBean goodsClassTitleBean = (GoodsClassTitleBean) dd1.this.e.get(intValue);
            goodsClassTitleBean.setChecked(true);
            dd1.this.r(intValue, "payload");
            if (dd1.this.l >= 0) {
                ((GoodsClassTitleBean) dd1.this.e.get(dd1.this.l)).setChecked(false);
                dd1 dd1Var = dd1.this;
                dd1Var.r(dd1Var.l, "payload");
            }
            dd1.this.l = intValue;
            if (dd1.this.h != null) {
                dd1.this.h.onItemClick(goodsClassTitleBean, intValue);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends RecyclerView.e0 {
        public TextView u;

        public b(View view) {
            super(view);
            this.u = (TextView) view;
            view.setOnClickListener(dd1.this.k);
        }

        public void O(GoodsClassTitleBean goodsClassTitleBean, int i, Object obj) {
            if (obj == null) {
                ((RecyclerView.e0) this).a.setTag(Integer.valueOf(i));
                this.u.setText(goodsClassTitleBean.getName());
            }
            TextView textView = this.u;
            boolean isChecked = goodsClassTitleBean.isChecked();
            dd1 dd1Var = dd1.this;
            textView.setBackgroundColor(isChecked ? dd1Var.i : dd1Var.j);
        }
    }

    public dd1(Context context, List list) {
        super(context, list);
        this.i = o60.b(context, p53.n);
        this.j = Color.parseColor("#f0f0f0");
        this.k = new a();
    }

    public void A(RecyclerView.e0 e0Var, int i, List list) {
        ((b) e0Var).O((GoodsClassTitleBean) this.e.get(i), i, list.size() > 0 ? list.get(0) : null);
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new b(this.f.inflate(z73.A0, viewGroup, false));
    }

    public void z(RecyclerView.e0 e0Var, int i) {
    }
}
