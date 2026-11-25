package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.mall.bean.GoodsCommentTypeBean;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class hd1 extends ce3 {
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
            if (hd1.this.l == intValue) {
                return;
            }
            GoodsCommentTypeBean goodsCommentTypeBean = (GoodsCommentTypeBean) hd1.this.e.get(intValue);
            goodsCommentTypeBean.setChecked(true);
            ((GoodsCommentTypeBean) hd1.this.e.get(hd1.this.l)).setChecked(false);
            hd1.this.r(intValue, "payload");
            hd1 hd1Var = hd1.this;
            hd1Var.r(hd1Var.l, "payload");
            hd1.this.l = intValue;
            if (hd1.this.h != null) {
                hd1.this.h.onItemClick(goodsCommentTypeBean, intValue);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends RecyclerView.e0 {
        public Drawable u;
        public Drawable v;
        public TextView w;

        public b(View view) {
            super(view);
            this.u = o60.d(hd1.this.d, y53.c);
            this.v = o60.d(hd1.this.d, y53.d);
            view.setOnClickListener(hd1.this.k);
            this.w = (TextView) view;
        }

        public void O(GoodsCommentTypeBean goodsCommentTypeBean, int i, Object obj) {
            if (obj == null) {
                ((RecyclerView.e0) this).a.setTag(Integer.valueOf(i));
                this.w.setText(goodsCommentTypeBean.getText());
            }
            boolean isChecked = goodsCommentTypeBean.isChecked();
            TextView textView = this.w;
            if (isChecked) {
                textView.setTextColor(hd1.this.i);
                this.w.setBackground(this.u);
            } else {
                textView.setTextColor(hd1.this.j);
                this.w.setBackground(this.v);
            }
        }
    }

    public hd1(Context context) {
        super(context);
        GoodsCommentTypeBean goodsCommentTypeBean = new GoodsCommentTypeBean("all", aq4.a(m93.J0));
        goodsCommentTypeBean.setChecked(true);
        this.e.add(goodsCommentTypeBean);
        this.e.add(new GoodsCommentTypeBean("img", aq4.a(m93.r7)));
        this.e.add(new GoodsCommentTypeBean("video", aq4.a(m93.ka)));
        this.e.add(new GoodsCommentTypeBean("append", aq4.a(m93.s7)));
        this.i = o60.b(context, p53.n);
        this.j = o60.b(context, p53.g);
        this.k = new a();
    }

    public void A(RecyclerView.e0 e0Var, int i, List list) {
        ((b) e0Var).O((GoodsCommentTypeBean) this.e.get(i), i, list.size() > 0 ? list.get(0) : null);
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new b(this.f.inflate(z73.K0, viewGroup, false));
    }

    public String d0() {
        return ((GoodsCommentTypeBean) this.e.get(this.l)).getType();
    }

    public void e0(String str, String str2, String str3, String str4) {
        ((GoodsCommentTypeBean) this.e.get(0)).setCount(str);
        ((GoodsCommentTypeBean) this.e.get(1)).setCount(str2);
        ((GoodsCommentTypeBean) this.e.get(2)).setCount(str3);
        ((GoodsCommentTypeBean) this.e.get(3)).setCount(str4);
        p();
    }

    public void z(RecyclerView.e0 e0Var, int i) {
    }
}
