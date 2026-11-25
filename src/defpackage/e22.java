package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.live.activity.LiveActivity;
import com.yunbao.live.activity.LiveAnchorActivity;
import com.yunbao.live.bean.LiveFunctionBean;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class e22 extends RecyclerView.Adapter {
    public List d = new ArrayList();
    public LayoutInflater e;
    public View.OnClickListener f;
    public et2 g;
    public String h;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null) {
                Integer num = (Integer) tag;
                if (e22.this.g != null) {
                    e22.this.g.onItemClick(num, 0);
                }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends c {
        public TextView x;

        public b(View view) {
            super(view);
            this.x = (TextView) view.findViewById(b73.D4);
        }

        @Override // e22.c
        public void O(LiveFunctionBean liveFunctionBean, Object obj) {
            super.O(liveFunctionBean, obj);
            if (this.x != null) {
                boolean equals = "0".equals(e22.this.h);
                TextView textView = this.x;
                if (equals) {
                    if (textView.getVisibility() == 0) {
                        this.x.setVisibility(4);
                    }
                } else if (textView.getVisibility() != 0) {
                    this.x.setVisibility(0);
                }
                this.x.setText(e22.this.h);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends RecyclerView.e0 {
        public ImageView u;
        public TextView v;

        public c(View view) {
            super(view);
            this.u = (ImageView) view.findViewById(b73.M2);
            this.v = (TextView) view.findViewById(b73.X3);
            view.setOnClickListener(e22.this.f);
        }

        public void O(LiveFunctionBean liveFunctionBean, Object obj) {
            if (obj == null) {
                ((RecyclerView.e0) this).a.setTag(Integer.valueOf(liveFunctionBean.getID()));
                this.u.setImageResource(liveFunctionBean.getIcon());
                this.v.setText(liveFunctionBean.getName());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e22(Context context, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10) {
        if (((LiveActivity) context).L1()) {
            boolean z11 = context instanceof LiveAnchorActivity;
            List list = this.d;
            if (z11) {
                list.add(new LiveFunctionBean(2005, t83.P, m93.R4));
                this.d.add(new LiveFunctionBean(2007, t83.O, m93.u4));
                if (z3) {
                    this.d.add(new LiveFunctionBean(2010, t83.Q, m93.v1));
                }
            } else {
                list.add(new LiveFunctionBean(2005, t83.P, m93.R4));
                if (!j30.q().Q()) {
                    if (z4) {
                        this.d.add(new LiveFunctionBean(2012, t83.n0, m93.f));
                    }
                    this.d.add(new LiveFunctionBean(2007, t83.O, m93.u4));
                    if (z3) {
                        this.d.add(new LiveFunctionBean(2010, t83.Q, m93.v1));
                    }
                }
                if (z5) {
                    this.d.add(new LiveFunctionBean(2014, t83.P0, m93.Ta));
                }
                this.d.add(new LiveFunctionBean(2013, t83.L, m93.o9));
            }
        } else if (context instanceof LiveAnchorActivity) {
            if (!z6) {
                this.d.add(new LiveFunctionBean(2001, t83.U0, m93.s3));
                this.d.add(new LiveFunctionBean(2002, t83.V0, m93.t3));
            }
            this.d.add(new LiveFunctionBean(2024, t83.M, m93.s4));
            this.d.add(new LiveFunctionBean(2025, t83.X0, m93.v4));
            if (z9) {
                this.d.add(new LiveFunctionBean(2022, t83.B0, m93.u3));
            }
            if (z10) {
                this.d.add(new LiveFunctionBean(2023, t83.W0, m93.B3));
            }
            this.d.add(new LiveFunctionBean(2015, z7 ? t83.J : t83.K, m93.Sa));
            if (z) {
                this.d.add(new LiveFunctionBean(2006, t83.H, m93.D3));
            }
            this.d.add(new LiveFunctionBean(2007, t83.O, m93.u4));
            this.d.add(new LiveFunctionBean(2009, t83.I, m93.e4));
            this.d.add(new LiveFunctionBean(2021, z8 ? t83.r1 : t83.s1, m93.Q1));
        } else {
            this.d.add(new LiveFunctionBean(2005, t83.P, m93.R4));
            this.d.add(new LiveFunctionBean(2007, t83.O, m93.u4));
            this.d.add(new LiveFunctionBean(2015, t83.J, z7 ? m93.Y3 : m93.S3));
            if (z7) {
                this.d.add(new LiveFunctionBean(2002, t83.G, m93.t3));
                this.d.add(new LiveFunctionBean(2021, z8 ? t83.r1 : t83.s1, m93.Q1));
            }
            this.d.add(new LiveFunctionBean(2026, t83.N, m93.C3));
        }
        this.e = LayoutInflater.from(context);
        this.f = new a();
        ik1 h = ck1.e().h();
        this.h = h != null ? h.g() : "0";
    }

    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public void z(c cVar, int i) {
    }

    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public void A(c cVar, int i, List list) {
        cVar.O((LiveFunctionBean) this.d.get(i), list.size() > 0 ? list.get(0) : null);
    }

    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public c B(ViewGroup viewGroup, int i) {
        return i == 2013 ? new b(this.e.inflate(x73.K0, viewGroup, false)) : new c(this.e.inflate(x73.J0, viewGroup, false));
    }

    public void R(et2 et2Var) {
        this.g = et2Var;
    }

    public void S(String str) {
        this.h = str;
        for (int i = 0; i < this.d.size(); i++) {
            if (((LiveFunctionBean) this.d.get(i)).getID() == 2013) {
                r(i, "payload");
                return;
            }
        }
    }

    public int j() {
        return this.d.size();
    }

    public int l(int i) {
        return ((LiveFunctionBean) this.d.get(i)).getID();
    }
}
