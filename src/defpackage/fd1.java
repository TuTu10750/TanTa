package defpackage;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.common.bean.GoodsBean;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.common.utils.a;
import com.yunbao.mall.activity.GoodsCollectActivity;
import com.yunbao.mall.activity.GoodsDetailActivity;
import defpackage.sq1;
import java.util.Iterator;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class fd1 extends ce3 implements sq1.b {
    public String i;
    public View.OnClickListener j;
    public View.OnClickListener k;
    public Drawable l;
    public Drawable m;
    public boolean n;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue = ((Integer) view.getTag()).intValue();
            GoodsBean goodsBean = (GoodsBean) fd1.this.e.get(intValue);
            if (!fd1.this.n) {
                GoodsDetailActivity.t2(fd1.this.d, goodsBean.getId(), goodsBean.getType());
                return;
            }
            goodsBean.setAdded(!goodsBean.isAdded());
            fd1.this.r(intValue, "payload");
            if (fd1.this.d != null) {
                ((GoodsCollectActivity) fd1.this.d).A1(fd1.this.l0());
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements View.OnClickListener {

        /* loaded from: /tmp/classes2.dex */
        public class a implements a.l {
            public final /* synthetic */ GoodsBean a;
            public final /* synthetic */ int b;

            /* renamed from: fd1$b$a$a, reason: collision with other inner class name */
            /* loaded from: /tmp/classes2.dex */
            public class C0065a extends HttpCallback {
                public C0065a() {
                }

                @Override // com.yunbao.common.http.HttpCallback
                public void onSuccess(int i, String str, String[] strArr) {
                    if (i == 0) {
                        fd1.this.e.remove(a.this.b);
                        fd1.this.p();
                        if (fd1.this.d != null) {
                            ((GoodsCollectActivity) fd1.this.d).A1(fd1.this.l0());
                        }
                    }
                    t54.b(str);
                }
            }

            public a(GoodsBean goodsBean, int i) {
                this.a = goodsBean;
                this.b = i;
            }

            @Override // com.yunbao.common.utils.a.l
            public void a() {
                fd1.this.m0(false);
                ((GoodsCollectActivity) fd1.this.d).A1(false);
            }

            @Override // com.yunbao.common.utils.a.m
            public void b(Dialog dialog, String str) {
                ec2.x(this.a.getId(), new C0065a());
            }
        }

        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue = ((Integer) view.getTag()).intValue();
            new a.j(fd1.this.d).k(aq4.a(m93.Q)).g(true).o(true).d(true).h(new a((GoodsBean) fd1.this.e.get(intValue), intValue)).c().show();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends RecyclerView.e0 {
        public ImageView u;
        public TextView v;
        public TextView w;
        public TextView x;
        public View y;
        public ImageView z;

        public c(View view) {
            super(view);
            this.u = (ImageView) view.findViewById(d73.j4);
            this.v = (TextView) view.findViewById(d73.R2);
            this.w = (TextView) view.findViewById(d73.l3);
            TextView textView = (TextView) view.findViewById(d73.m3);
            this.x = textView;
            textView.getPaint().setFlags(16);
            view.setOnClickListener(fd1.this.j);
            View findViewById = view.findViewById(d73.m0);
            this.y = findViewById;
            findViewById.setOnClickListener(fd1.this.k);
            this.z = (ImageView) view.findViewById(d73.y2);
        }

        public void O(GoodsBean goodsBean, int i, Object obj) {
            if (obj == null) {
                ((RecyclerView.e0) this).a.setTag(Integer.valueOf(i));
                kn1.f(fd1.this.d, goodsBean.getThumb(), this.u);
                this.v.setText(goodsBean.getName());
                this.w.setText(goodsBean.getPriceNow());
                int type = goodsBean.getType();
                TextView textView = this.x;
                if (type == 1) {
                    textView.setText(rv3.a(fd1.this.i, goodsBean.getOriginPrice()));
                } else {
                    textView.setText((CharSequence) null);
                }
                this.y.setTag(Integer.valueOf(i));
                boolean z = fd1.this.n;
                ImageView imageView = this.z;
                if (z) {
                    if (imageView.getVisibility() != 0) {
                        this.z.setVisibility(0);
                    }
                } else if (imageView.getVisibility() != 8) {
                    this.z.setVisibility(8);
                }
            }
            ImageView imageView2 = this.z;
            boolean isAdded = goodsBean.isAdded();
            fd1 fd1Var = fd1.this;
            imageView2.setImageDrawable(isAdded ? fd1Var.l : fd1Var.m);
        }
    }

    public fd1(Context context) {
        super(context);
        this.i = aq4.a(m93.O8);
        this.l = o60.d(context, v83.b);
        this.m = o60.d(context, v83.a);
        this.j = new a();
        this.k = new b();
    }

    public void A(RecyclerView.e0 e0Var, int i, List list) {
        ((c) e0Var).O((GoodsBean) this.e.get(i), i, list.size() > 0 ? list.get(0) : null);
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new c(this.f.inflate(z73.D0, viewGroup, false));
    }

    @Override // defpackage.ce3
    public void P(List list) {
        this.n = false;
        super.P(list);
        Object obj = this.d;
        if (obj != null) {
            ((GoodsCollectActivity) obj).A1(l0());
        }
    }

    @Override // sq1.b
    public RecyclerView.e0 a(View view) {
        RecyclerView recyclerView = this.g;
        if (recyclerView == null || view == null) {
            return null;
        }
        return recyclerView.p0(view);
    }

    @Override // sq1.b
    public void b(RecyclerView.e0 e0Var) {
    }

    @Override // sq1.b
    public View c(float f, float f2) {
        return this.g.Z(f, f2);
    }

    @Override // sq1.b
    public int d(RecyclerView.e0 e0Var) {
        if (this.n) {
            return 0;
        }
        return zn0.a(60);
    }

    @Override // sq1.b
    public boolean e() {
        return !this.n;
    }

    public String k0() {
        StringBuilder sb = null;
        for (GoodsBean goodsBean : this.e) {
            if (goodsBean.isAdded()) {
                if (sb == null) {
                    sb = new StringBuilder();
                }
                sb.append(goodsBean.getId());
                sb.append(",");
            }
        }
        if (sb == null) {
            return null;
        }
        String sb2 = sb.toString();
        return sb2.length() > 1 ? sb2.substring(0, sb2.length() - 1) : sb2;
    }

    public final boolean l0() {
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            if (((GoodsBean) it.next()).isAdded()) {
                return true;
            }
        }
        return false;
    }

    public void m0(boolean z) {
        if (this.n == z) {
            return;
        }
        this.n = z;
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            ((GoodsBean) it.next()).setAdded(false);
        }
        p();
    }

    public void n0() {
        this.n = !this.n;
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            ((GoodsBean) it.next()).setAdded(false);
        }
        p();
    }

    @Override // defpackage.ce3
    public void y(RecyclerView recyclerView) {
        super.y(recyclerView);
        this.g.n(new sq1(this.d, this));
    }

    public void z(RecyclerView.e0 e0Var, int i) {
    }
}
