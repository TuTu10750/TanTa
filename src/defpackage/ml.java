package defpackage;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.mall.activity.BuyerCommentAppendActivity;
import com.yunbao.mall.bean.BuyerOrderBean;
import defpackage.ol;

/* loaded from: /tmp/classes2.dex */
public class ml extends ol {
    public View.OnClickListener n;
    public View.OnClickListener o;
    public View.OnClickListener p;
    public View.OnClickListener q;
    public View.OnClickListener r;
    public View.OnClickListener s;
    public View.OnClickListener t;
    public View.OnClickListener u;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ol.c cVar;
            Object tag = view.getTag();
            if (tag == null || (cVar = ml.this.m) == null) {
                return;
            }
            cVar.Y((BuyerOrderBean) tag);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ol.c cVar;
            Object tag = view.getTag();
            if (tag == null || (cVar = ml.this.m) == null) {
                return;
            }
            cVar.L((BuyerOrderBean) tag);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c implements View.OnClickListener {

        /* loaded from: /tmp/classes2.dex */
        public class a extends s4 {
            public final /* synthetic */ BuyerOrderBean a;
            public final /* synthetic */ int b;

            public a(BuyerOrderBean buyerOrderBean, int i) {
                this.a = buyerOrderBean;
                this.b = i;
            }

            @Override // defpackage.s4
            public void c(Intent intent) {
                this.a.setIsAppend(0);
                ml.this.q(this.b);
            }
        }

        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue = ((Integer) view.getTag()).intValue();
            BuyerOrderBean buyerOrderBean = (BuyerOrderBean) ml.this.e.get(intValue);
            Intent intent = new Intent(ml.this.d, (Class<?>) BuyerCommentAppendActivity.class);
            intent.putExtra("mallOrderId", buyerOrderBean.getId());
            b5.a((AbsActivity) ml.this.d, intent, new a(buyerOrderBean, intValue));
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ol.c cVar;
            Object tag = view.getTag();
            if (tag == null || (cVar = ml.this.m) == null) {
                return;
            }
            cVar.z((BuyerOrderBean) tag);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ol.c cVar;
            Object tag = view.getTag();
            if (tag == null || (cVar = ml.this.m) == null) {
                return;
            }
            cVar.o((BuyerOrderBean) tag);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ol.c cVar;
            Object tag = view.getTag();
            if (tag == null || (cVar = ml.this.m) == null) {
                return;
            }
            cVar.i((BuyerOrderBean) tag);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ol.c cVar;
            Object tag = view.getTag();
            if (tag == null || (cVar = ml.this.m) == null) {
                return;
            }
            cVar.p((BuyerOrderBean) tag);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ol.c cVar;
            Object tag = view.getTag();
            if (tag == null || (cVar = ml.this.m) == null) {
                return;
            }
            cVar.P((BuyerOrderBean) tag);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class i extends m {
        public View G;
        public View H;

        public i(View view) {
            super(view);
            this.G = view.findViewById(d73.r1);
            this.H = view.findViewById(d73.A);
            this.G.setOnClickListener(ml.this.o);
            this.H.setOnClickListener(ml.this.p);
        }

        public void P(BuyerOrderBean buyerOrderBean, int i) {
            this.G.setTag(buyerOrderBean);
            this.H.setTag(Integer.valueOf(i));
            super.O(buyerOrderBean);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class j extends m {
        public View G;

        public j(View view) {
            super(view);
            View findViewById = view.findViewById(d73.r1);
            this.G = findViewById;
            findViewById.setOnClickListener(ml.this.o);
        }

        @Override // ml.m, ol.d
        public void O(BuyerOrderBean buyerOrderBean) {
            this.G.setTag(buyerOrderBean);
            super.O(buyerOrderBean);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class k extends ol.d {
        public View E;
        public View F;

        public k(View view) {
            super(view);
            this.E = view.findViewById(d73.O);
            this.F = view.findViewById(d73.M0);
            this.E.setOnClickListener(ml.this.q);
            this.F.setOnClickListener(ml.this.r);
        }

        @Override // ol.d
        public void O(BuyerOrderBean buyerOrderBean) {
            this.E.setTag(buyerOrderBean);
            this.F.setTag(buyerOrderBean);
            super.O(buyerOrderBean);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class l extends ol.d {
        public View E;

        public l(View view) {
            super(view);
            View findViewById = view.findViewById(d73.V0);
            this.E = findViewById;
            findViewById.setOnClickListener(ml.this.u);
        }

        @Override // ol.d
        public void O(BuyerOrderBean buyerOrderBean) {
            this.E.setTag(buyerOrderBean);
            super.O(buyerOrderBean);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class m extends ol.d {
        public View E;

        public m(View view) {
            super(view);
            View findViewById = view.findViewById(d73.n0);
            this.E = findViewById;
            findViewById.setOnClickListener(ml.this.n);
        }

        @Override // ol.d
        public void O(BuyerOrderBean buyerOrderBean) {
            this.E.setTag(buyerOrderBean);
            super.O(buyerOrderBean);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class n extends ol.d {
        public View E;

        public n(View view) {
            super(view);
            View findViewById = view.findViewById(d73.Y);
            this.E = findViewById;
            findViewById.setOnClickListener(ml.this.t);
        }

        @Override // ol.d
        public void O(BuyerOrderBean buyerOrderBean) {
            this.E.setTag(buyerOrderBean);
            super.O(buyerOrderBean);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class o extends ol.d {
        public View E;
        public View F;

        public o(View view) {
            super(view);
            this.E = view.findViewById(d73.r1);
            this.F = view.findViewById(d73.b0);
            this.E.setOnClickListener(ml.this.o);
            this.F.setOnClickListener(ml.this.s);
        }

        @Override // ol.d
        public void O(BuyerOrderBean buyerOrderBean) {
            this.E.setTag(buyerOrderBean);
            this.F.setTag(buyerOrderBean);
            super.O(buyerOrderBean);
        }
    }

    public ml(Context context) {
        super(context);
        this.n = new a();
        this.o = new b();
        this.p = new c();
        this.q = new d();
        this.r = new e();
        this.s = new f();
        this.t = new g();
        this.u = new h();
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i2) {
        return i2 == -1 ? new m(this.f.inflate(z73.q0, viewGroup, false)) : i2 == 0 ? new k(this.f.inflate(z73.u0, viewGroup, false)) : i2 == 1 ? new ol.d(this.f.inflate(z73.x0, viewGroup, false)) : i2 == 2 ? new o(this.f.inflate(z73.v0, viewGroup, false)) : i2 == 3 ? new n(this.f.inflate(z73.t0, viewGroup, false)) : i2 == 40 ? new j(this.f.inflate(z73.s0, viewGroup, false)) : i2 == 4 ? new i(this.f.inflate(z73.r0, viewGroup, false)) : i2 == 5 ? new l(this.f.inflate(z73.w0, viewGroup, false)) : new m(this.f.inflate(z73.q0, viewGroup, false));
    }

    public int l(int i2) {
        BuyerOrderBean buyerOrderBean = (BuyerOrderBean) this.e.get(i2);
        int status = buyerOrderBean.getStatus();
        if (status == -1) {
            return -1;
        }
        if (status == 0) {
            return 0;
        }
        if (status == 1) {
            return 1;
        }
        if (status == 2) {
            return 2;
        }
        if (status == 3) {
            return 3;
        }
        return status == 4 ? buyerOrderBean.getIsAppend() == 1 ? 4 : 40 : status == 5 ? 5 : -1;
    }

    public void z(RecyclerView.e0 e0Var, int i2) {
        if (e0Var instanceof i) {
            ((i) e0Var).P((BuyerOrderBean) this.e.get(i2), i2);
        } else {
            ((ol.d) e0Var).O((BuyerOrderBean) this.e.get(i2));
        }
    }
}
