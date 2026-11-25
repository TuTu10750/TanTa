package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.common.bean.CountryBean;
import com.yunbao.common.bean.CountryListBean;

/* loaded from: /tmp/classes2.dex */
public class pl3 extends ce3 {
    public a i;

    /* loaded from: /tmp/classes2.dex */
    public interface a {
        void a(CountryBean countryBean);
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends RecyclerView.e0 {
        public qq1 u;
        public RecyclerView v;
        public TextView w;

        /* loaded from: /tmp/classes2.dex */
        public class a extends LinearLayoutManager {
            public a(Context context, int i, boolean z) {
                super(context, i, z);
            }

            public boolean A() {
                return false;
            }
        }

        /* renamed from: pl3$b$b, reason: collision with other inner class name */
        /* loaded from: /tmp/classes2.dex */
        public class C0145b implements et2 {
            public C0145b() {
            }

            @Override // defpackage.et2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onItemClick(CountryBean countryBean, int i) {
                if (pl3.this.i != null) {
                    pl3.this.i.a(countryBean);
                }
            }
        }

        public b(View view) {
            super(view);
            this.w = (TextView) view.findViewById(y63.h0);
            this.v = view.findViewById(y63.Z);
        }

        public void O(CountryListBean countryListBean) {
            this.u = new qq1(pl3.this.d);
            this.w.setText(countryListBean.getTitle());
            this.v.setLayoutManager(new a(pl3.this.d, 1, false));
            this.v.setAdapter(this.u);
            this.u.P(countryListBean.getLists());
            this.u.R(new C0145b());
        }
    }

    public pl3(Context context) {
        super(context);
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new b(this.f.inflate(u73.M, viewGroup, false));
    }

    public void T(a aVar) {
        this.i = aVar;
    }

    public void z(RecyclerView.e0 e0Var, int i) {
        ((b) e0Var).O((CountryListBean) this.e.get(i));
    }
}
