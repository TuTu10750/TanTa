package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.common.bean.GoodsBean;
import com.yunbao.common.custom.MyRadioButton;
import com.yunbao.common.http.HttpCallback;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class z22 extends ce3 {
    public View.OnClickListener i;
    public String j;
    public String k;
    public String l;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {

        /* renamed from: z22$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/classes2.dex */
        public class C0167a extends HttpCallback {
            public final /* synthetic */ GoodsBean a;
            public final /* synthetic */ int b;
            public final /* synthetic */ int c;

            public C0167a(GoodsBean goodsBean, int i, int i2) {
                this.a = goodsBean;
                this.b = i;
                this.c = i2;
            }

            @Override // com.yunbao.common.http.HttpCallback
            public void onSuccess(int i, String str, String[] strArr) {
                if (i == 0) {
                    this.a.setIssale(this.b);
                    z22.this.r(this.c, "payload");
                }
                t54.b(str);
            }
        }

        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (z22.this.L()) {
                int intValue = ((Integer) view.getTag()).intValue();
                GoodsBean goodsBean = (GoodsBean) z22.this.e.get(intValue);
                if (goodsBean.getIssale() == 1) {
                    return;
                }
                int i = goodsBean.getIssale() == 1 ? 0 : 1;
                e32.J0(goodsBean.getId(), i, new C0167a(goodsBean, i, intValue));
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends RecyclerView.e0 {
        public ImageView u;
        public TextView v;
        public TextView w;
        public TextView x;
        public MyRadioButton y;

        public b(View view) {
            super(view);
            this.u = (ImageView) view.findViewById(b73.d5);
            this.v = (TextView) view.findViewById(b73.i5);
            this.w = (TextView) view.findViewById(b73.t4);
            TextView textView = (TextView) view.findViewById(b73.u4);
            this.x = textView;
            textView.getPaint().setFlags(16);
            MyRadioButton myRadioButton = (MyRadioButton) view.findViewById(b73.s);
            this.y = myRadioButton;
            myRadioButton.setOnClickListener(z22.this.i);
        }

        public void O(GoodsBean goodsBean, int i, Object obj) {
            if (obj == null) {
                this.y.setTag(Integer.valueOf(i));
                kn1.f(z22.this.d, goodsBean.getThumb(), this.u);
                this.w.setText(rv3.a(z22.this.j, goodsBean.getPriceNow()));
                int type = goodsBean.getType();
                TextView textView = this.x;
                if (type == 1) {
                    textView.setText(rv3.a(z22.this.j, goodsBean.getOriginPrice()));
                } else {
                    textView.setText((CharSequence) null);
                }
                this.v.setText(goodsBean.getName());
            }
            int issale = goodsBean.getIssale();
            MyRadioButton myRadioButton = this.y;
            if (issale == 1) {
                myRadioButton.setText(z22.this.l);
                this.y.a(true);
            } else {
                myRadioButton.setText(z22.this.k);
                this.y.a(false);
            }
        }
    }

    public z22(Context context) {
        super(context);
        this.i = new a();
        this.j = aq4.a(m93.O8);
        this.k = aq4.a(m93.H0);
        this.l = aq4.a(m93.I0);
    }

    public void A(RecyclerView.e0 e0Var, int i, List list) {
        ((b) e0Var).O((GoodsBean) this.e.get(i), i, list.size() > 0 ? list.get(0) : null);
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new b(this.f.inflate(x73.O0, viewGroup, false));
    }

    public void z(RecyclerView.e0 e0Var, int i) {
    }
}
