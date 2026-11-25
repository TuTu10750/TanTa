package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.mall.bean.GoodsChooseSpecBean;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class cd1 extends ce3 {
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
            int intValue = ((Integer) view.getTag()).intValue();
            if (intValue == cd1.this.l) {
                return;
            }
            ((GoodsChooseSpecBean) cd1.this.e.get(intValue)).setChecked(true);
            ((GoodsChooseSpecBean) cd1.this.e.get(cd1.this.l)).setChecked(false);
            cd1.this.q(intValue);
            cd1 cd1Var = cd1.this;
            cd1Var.q(cd1Var.l);
            cd1.this.l = intValue;
            if (cd1.this.h != null) {
                cd1.this.h.onItemClick((GoodsChooseSpecBean) cd1.this.e.get(intValue), intValue);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends RecyclerView.e0 {
        public TextView u;
        public Drawable v;
        public Drawable w;

        public b(View view) {
            super(view);
            this.v = o60.d(cd1.this.d, y53.a);
            this.w = o60.d(cd1.this.d, y53.b);
            this.u = (TextView) view;
            view.setOnClickListener(cd1.this.k);
        }

        public void O(GoodsChooseSpecBean goodsChooseSpecBean, int i) {
            this.u.setTag(Integer.valueOf(i));
            this.u.setText(goodsChooseSpecBean.getName());
            boolean isChecked = goodsChooseSpecBean.isChecked();
            TextView textView = this.u;
            if (isChecked) {
                textView.setTextColor(cd1.this.i);
                this.u.setBackground(this.v);
            } else {
                textView.setTextColor(cd1.this.j);
                this.u.setBackground(this.w);
            }
        }
    }

    public cd1(Context context, List list) {
        super(context, list);
        int size = list.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            if (((GoodsChooseSpecBean) list.get(i)).isChecked()) {
                this.l = i;
                break;
            }
            i++;
        }
        this.i = o60.b(context, p53.n);
        this.j = o60.b(context, p53.m);
        this.k = new a();
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new b(this.f.inflate(z73.z0, viewGroup, false));
    }

    public void z(RecyclerView.e0 e0Var, int i) {
        ((b) e0Var).O((GoodsChooseSpecBean) this.e.get(i), i);
    }
}
