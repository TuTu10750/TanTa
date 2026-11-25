package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.mall.activity.GoodsDetailActivity;
import com.yunbao.mall.bean.GoodsRecordBean;
import com.yunbao.mall.bean.GoodsRecordItemBean;
import com.yunbao.mall.bean.GoodsRecordTitleBean;
import java.util.Iterator;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class md1 extends ce3 {
    public Drawable i;
    public Drawable j;
    public boolean k;
    public View.OnClickListener l;
    public b m;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue = ((Integer) view.getTag()).intValue();
            GoodsRecordBean goodsRecordBean = (GoodsRecordBean) md1.this.e.get(intValue);
            if (!md1.this.k) {
                if (goodsRecordBean instanceof GoodsRecordItemBean) {
                    GoodsRecordItemBean goodsRecordItemBean = (GoodsRecordItemBean) goodsRecordBean;
                    if (goodsRecordItemBean.getStatus() == 1) {
                        GoodsDetailActivity.t2(md1.this.d, goodsRecordItemBean.getGoodsId(), goodsRecordItemBean.getType());
                        return;
                    } else {
                        t54.a(m93.g8);
                        return;
                    }
                }
                return;
            }
            goodsRecordBean.toggle();
            boolean z = goodsRecordBean instanceof GoodsRecordTitleBean;
            md1 md1Var = md1.this;
            if (z) {
                for (GoodsRecordBean goodsRecordBean2 : md1Var.e) {
                    if ((goodsRecordBean2 instanceof GoodsRecordItemBean) && ((GoodsRecordItemBean) goodsRecordBean2).getParent() == goodsRecordBean) {
                        goodsRecordBean2.setChecked(goodsRecordBean.isChecked());
                    }
                }
                md1.this.p();
            } else {
                md1Var.r(intValue, "payload");
                GoodsRecordTitleBean parent = ((GoodsRecordItemBean) goodsRecordBean).getParent();
                if (parent.isItemAllChecked()) {
                    if (!parent.isChecked()) {
                        parent.setChecked(true);
                        md1.this.r(parent.getPosition(), "payload");
                    }
                } else if (parent.isChecked()) {
                    parent.setChecked(false);
                    md1.this.r(parent.getPosition(), "payload");
                }
            }
            if (md1.this.m != null) {
                int d0 = md1.this.d0();
                md1.this.m.B(d0 > 0);
                b bVar = md1.this.m;
                int size = md1.this.e.size();
                md1 md1Var2 = md1.this;
                bVar.t(d0 == size ? md1Var2.i : md1Var2.j);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface b {
        void B(boolean z);

        void H0(boolean z);

        void t(Drawable drawable);
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends e {
        public ImageView w;
        public TextView x;
        public TextView y;
        public TextView z;

        public c(View view) {
            super(view);
            this.w = (ImageView) view.findViewById(d73.j4);
            this.x = (TextView) view.findViewById(d73.R2);
            this.y = (TextView) view.findViewById(d73.k3);
            TextView textView = (TextView) view.findViewById(d73.c3);
            this.z = textView;
            textView.getPaint().setFlags(16);
        }

        @Override // md1.e
        public void O(GoodsRecordBean goodsRecordBean, int i, Object obj) {
            super.O(goodsRecordBean, i, obj);
            if (obj == null) {
                GoodsRecordItemBean goodsRecordItemBean = (GoodsRecordItemBean) goodsRecordBean;
                kn1.f(md1.this.d, goodsRecordItemBean.getThumb(), this.w);
                this.x.setText(goodsRecordItemBean.getName());
                this.y.setText(goodsRecordItemBean.getPrice());
                int type = goodsRecordItemBean.getType();
                TextView textView = this.z;
                if (type == 1) {
                    textView.setText(goodsRecordItemBean.getOriginPrice());
                } else {
                    textView.setText((CharSequence) null);
                }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d extends e {
        public TextView w;

        public d(View view) {
            super(view);
            this.w = (TextView) view.findViewById(d73.M1);
        }

        @Override // md1.e
        public void O(GoodsRecordBean goodsRecordBean, int i, Object obj) {
            super.O(goodsRecordBean, i, obj);
            if (obj == null) {
                GoodsRecordTitleBean goodsRecordTitleBean = (GoodsRecordTitleBean) goodsRecordBean;
                goodsRecordTitleBean.setPosition(i);
                this.w.setText(goodsRecordTitleBean.getDate());
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e extends RecyclerView.e0 {
        public ImageView u;

        public e(View view) {
            super(view);
            this.u = (ImageView) view.findViewById(d73.y2);
            view.setOnClickListener(md1.this.l);
        }

        public void O(GoodsRecordBean goodsRecordBean, int i, Object obj) {
            ((RecyclerView.e0) this).a.setTag(Integer.valueOf(i));
            boolean isEdit = goodsRecordBean.isEdit();
            ImageView imageView = this.u;
            if (!isEdit) {
                if (imageView.getVisibility() != 8) {
                    this.u.setVisibility(8);
                }
            } else {
                if (imageView.getVisibility() != 0) {
                    this.u.setVisibility(0);
                }
                ImageView imageView2 = this.u;
                boolean isChecked = goodsRecordBean.isChecked();
                md1 md1Var = md1.this;
                imageView2.setImageDrawable(isChecked ? md1Var.i : md1Var.j);
            }
        }
    }

    public md1(Context context) {
        super(context);
        this.i = o60.d(context, v83.b);
        this.j = o60.d(context, v83.a);
        this.l = new a();
    }

    public void A(RecyclerView.e0 e0Var, int i, List list) {
        ((e) e0Var).O((GoodsRecordBean) this.e.get(i), i, list.size() > 0 ? list.get(0) : null);
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return i == -1 ? new d(this.f.inflate(z73.R0, viewGroup, false)) : new c(this.f.inflate(z73.Q0, viewGroup, false));
    }

    @Override // defpackage.ce3
    public void O(List list) {
        if (this.g == null || this.e == null || list == null || list.size() <= 0) {
            return;
        }
        boolean z = d0() == this.e.size();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            GoodsRecordBean goodsRecordBean = (GoodsRecordBean) it.next();
            goodsRecordBean.setEdit(this.k);
            goodsRecordBean.setChecked(z);
        }
        int size = this.e.size();
        this.e.addAll(list);
        v(size, list.size());
    }

    @Override // defpackage.ce3
    public void P(List list) {
        this.k = false;
        super.P(list);
        b bVar = this.m;
        if (bVar != null) {
            bVar.t(this.j);
            this.m.B(false);
            this.m.H0(false);
        }
    }

    public final int d0() {
        Iterator it = this.e.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (((GoodsRecordBean) it.next()).isChecked()) {
                i++;
            }
        }
        return i;
    }

    public String e0() {
        StringBuilder sb = null;
        for (GoodsRecordBean goodsRecordBean : this.e) {
            if ((goodsRecordBean instanceof GoodsRecordItemBean) && goodsRecordBean.isChecked()) {
                String id = ((GoodsRecordItemBean) goodsRecordBean).getId();
                if (sb == null) {
                    sb = new StringBuilder();
                }
                sb.append(id);
                sb.append(",");
            }
        }
        if (sb != null) {
            String sb2 = sb.toString();
            if (sb2.length() > 0) {
                return sb2.substring(0, sb2.length() - 1);
            }
        }
        return null;
    }

    public void f0(b bVar) {
        this.m = bVar;
    }

    public void g0() {
        boolean z = d0() != this.e.size();
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            ((GoodsRecordBean) it.next()).setChecked(z);
        }
        p();
        b bVar = this.m;
        if (bVar != null) {
            bVar.B(z);
            this.m.t(z ? this.i : this.j);
        }
    }

    public void h0() {
        this.k = !this.k;
        for (GoodsRecordBean goodsRecordBean : this.e) {
            goodsRecordBean.setEdit(this.k);
            goodsRecordBean.setChecked(false);
        }
        p();
        b bVar = this.m;
        if (bVar != null) {
            bVar.t(this.j);
            this.m.B(false);
            this.m.H0(this.k);
        }
    }

    public int l(int i) {
        return ((GoodsRecordBean) this.e.get(i)) instanceof GoodsRecordTitleBean ? -1 : 0;
    }

    public void z(RecyclerView.e0 e0Var, int i) {
    }
}
