package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.live.bean.DailyTaskBean;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class z80 extends ce3 {
    public View.OnClickListener i;
    public String j;
    public String k;
    public String l;
    public int m;
    public int n;
    public Drawable o;
    public Drawable p;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {

        /* renamed from: z80$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/classes2.dex */
        public class C0171a extends HttpCallback {
            public final /* synthetic */ DailyTaskBean a;
            public final /* synthetic */ int b;

            public C0171a(DailyTaskBean dailyTaskBean, int i) {
                this.a = dailyTaskBean;
                this.b = i;
            }

            @Override // com.yunbao.common.http.HttpCallback
            public void onSuccess(int i, String str, String[] strArr) {
                if (i == 0) {
                    this.a.setStatus(2);
                    z80.this.r(this.b, "payload");
                }
                t54.b(str);
            }
        }

        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue = ((Integer) view.getTag()).intValue();
            DailyTaskBean dailyTaskBean = (DailyTaskBean) z80.this.e.get(intValue);
            if (dailyTaskBean.getStatus() == 1) {
                e32.q(dailyTaskBean.getId(), new C0171a(dailyTaskBean, intValue));
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends RecyclerView.e0 {
        public TextView u;
        public TextView v;
        public TextView w;
        public View x;

        public b(View view) {
            super(view);
            this.u = (TextView) view.findViewById(b73.i5);
            this.v = (TextView) view.findViewById(b73.f5);
            this.w = (TextView) view.findViewById(b73.g1);
            this.x = view.findViewById(b73.C3);
            this.w.setOnClickListener(z80.this.i);
        }

        public void O(DailyTaskBean dailyTaskBean, int i, Object obj) {
            if (obj == null) {
                this.u.setText(dailyTaskBean.getTitle());
                this.v.setText(dailyTaskBean.getTip());
                this.w.setTag(Integer.valueOf(i));
                int size = z80.this.e.size() - 1;
                View view = this.x;
                if (i == size) {
                    if (view.getVisibility() == 0) {
                        this.x.setVisibility(4);
                    }
                } else if (view.getVisibility() != 0) {
                    this.x.setVisibility(0);
                }
            }
            int status = dailyTaskBean.getStatus();
            if (status == 0) {
                this.w.setText(z80.this.j);
                this.w.setBackground(null);
                this.w.setTextColor(z80.this.m);
                return;
            }
            TextView textView = this.w;
            if (status == 1) {
                textView.setText(z80.this.k);
                this.w.setBackground(z80.this.p);
            } else {
                textView.setText(z80.this.l);
                this.w.setBackground(z80.this.o);
            }
            this.w.setTextColor(z80.this.n);
        }
    }

    public z80(Context context, List list) {
        super(context, list);
        this.i = new a();
        this.j = aq4.a(m93.w1);
        this.k = aq4.a(m93.x1);
        this.l = aq4.a(m93.y1);
        this.m = o60.b(this.d, p53.i);
        this.n = o60.b(this.d, p53.n);
        this.o = o60.d(this.d, h63.c);
        this.p = o60.d(this.d, h63.d);
    }

    public void A(RecyclerView.e0 e0Var, int i, List list) {
        ((b) e0Var).O((DailyTaskBean) this.e.get(i), i, list.size() > 0 ? list.get(0) : null);
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new b(this.f.inflate(x73.D0, viewGroup, false));
    }

    public void z(RecyclerView.e0 e0Var, int i) {
    }
}
