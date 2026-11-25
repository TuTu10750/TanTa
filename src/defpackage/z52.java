package defpackage;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.common.bean.LevelBean;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.live.bean.LiveUserGiftBean;
import defpackage.z52;
import java.util.Iterator;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public final class z52 extends ce3 {
    public final int i;
    public final String j;
    public final View.OnClickListener k;
    public final int l;
    public final int m;
    public final int n;
    public final int o;
    public final String p;

    /* loaded from: /tmp/classes2.dex */
    public final class a extends RecyclerView.e0 {
        public final TextView A;
        public final ImageView B;
        public final ImageView C;
        public final ImageView D;
        public final ImageView E;
        public final TextView F;
        public final TextView G;
        public final /* synthetic */ z52 H;
        public final TextView u;
        public final ImageView v;
        public final TextView w;
        public final View x;
        public final ImageView y;
        public final TextView z;

        /* renamed from: z52$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/classes2.dex */
        public static final class C0170a extends HttpCallback {
            public final /* synthetic */ z52 a;
            public final /* synthetic */ String b;

            public C0170a(z52 z52Var, String str) {
                this.a = z52Var;
                this.b = str;
            }

            @Override // com.yunbao.common.http.HttpCallback
            public void onSuccess(int i, String str, String[] strArr) {
                if (i == 0) {
                    this.a.d0(this.b);
                } else {
                    t54.b(str);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(z52 z52Var, View view) {
            super(view);
            view.getClass();
            this.H = z52Var;
            view.setOnClickListener(z52Var.k);
            View findViewById = view.findViewById(b73.l4);
            findViewById.getClass();
            this.u = (TextView) findViewById;
            View findViewById2 = view.findViewById(b73.d);
            findViewById2.getClass();
            this.v = (ImageView) findViewById2;
            View findViewById3 = view.findViewById(b73.X3);
            findViewById3.getClass();
            this.w = (TextView) findViewById3;
            View findViewById4 = view.findViewById(b73.I2);
            findViewById4.getClass();
            this.x = findViewById4;
            View findViewById5 = view.findViewById(b73.b3);
            findViewById5.getClass();
            this.y = (ImageView) findViewById5;
            View findViewById6 = view.findViewById(b73.a);
            findViewById6.getClass();
            this.z = (TextView) findViewById6;
            View findViewById7 = view.findViewById(b73.z1);
            findViewById7.getClass();
            this.A = (TextView) findViewById7;
            View findViewById8 = view.findViewById(b73.q3);
            findViewById8.getClass();
            this.B = (ImageView) findViewById8;
            View findViewById9 = view.findViewById(b73.n3);
            findViewById9.getClass();
            this.D = (ImageView) findViewById9;
            View findViewById10 = view.findViewById(b73.m3);
            findViewById10.getClass();
            this.C = (ImageView) findViewById10;
            View findViewById11 = view.findViewById(b73.l3);
            findViewById11.getClass();
            this.E = (ImageView) findViewById11;
            View findViewById12 = view.findViewById(b73.G5);
            findViewById12.getClass();
            this.F = (TextView) findViewById12;
            View findViewById13 = view.findViewById(b73.c6);
            findViewById13.getClass();
            this.G = (TextView) findViewById13;
        }

        public static void O(LiveUserGiftBean liveUserGiftBean, z52 z52Var, View view) {
            String id = liveUserGiftBean.getId();
            e32.p0(z52Var.b0(), id, new C0170a(z52Var, id));
        }

        public final void P(final LiveUserGiftBean liveUserGiftBean, int i) {
            liveUserGiftBean.getClass();
            ((RecyclerView.e0) this).a.setTag(liveUserGiftBean);
            if (this.H.c0() == 40 || this.H.c0() == 50) {
                LiveUserGiftBean.WatchTime watchTime = liveUserGiftBean.getWatchTime();
                String watch_time_text = watchTime != null ? watchTime.getWatch_time_text() : null;
                if (watch_time_text == null || hw3.c0(watch_time_text)) {
                    this.G.setVisibility(8);
                } else {
                    this.G.setText(watch_time_text);
                    this.G.setVisibility(0);
                }
            } else {
                this.G.setVisibility(8);
            }
            this.u.setText(String.valueOf(i + 1));
            if (i == 0) {
                this.u.setTextColor(this.H.l);
            } else if (i != 1) {
                TextView textView = this.u;
                if (i != 2) {
                    textView.setTextColor(this.H.o);
                } else {
                    textView.setTextColor(this.H.n);
                }
            } else {
                this.u.setTextColor(this.H.m);
            }
            kn1.g(this.H.d, liveUserGiftBean.getAvatar(), this.v);
            this.w.setText(liveUserGiftBean.getUserNiceName());
            int sex = liveUserGiftBean.getSex();
            View view = this.x;
            if (sex == 1) {
                view.setBackground(o60.d(this.H.d, h63.l));
                this.y.setImageResource(t83.N0);
            } else {
                view.setBackground(o60.d(this.H.d, h63.m));
                this.y.setImageResource(t83.O0);
            }
            this.z.setText(String.valueOf(liveUserGiftBean.getAge()));
            this.A.setText(rv3.a(liveUserGiftBean.getContribution(), this.H.p));
            this.B.setVisibility(liveUserGiftBean.isVip() == 1 ? 0 : 8);
            LevelBean s = j30.q().s(liveUserGiftBean.getLevel());
            if (s != null) {
                kn1.f(this.H.d, s.getThumb(), this.D);
            }
            int guardType = liveUserGiftBean.getGuardType();
            ImageView imageView = this.C;
            if (guardType > 0) {
                imageView.setVisibility(0);
                this.C.setImageResource(t83.A);
                if (liveUserGiftBean.getGuardType() == 2) {
                    this.C.setImageResource(t83.B);
                }
            } else {
                imageView.setVisibility(8);
            }
            LevelBean c = j30.q().c(liveUserGiftBean.getLevelAnchor());
            ImageView imageView2 = this.E;
            if (c != null) {
                imageView2.setVisibility(0);
                kn1.f(this.H.d, c.getThumb(), this.E);
            } else {
                imageView2.setVisibility(8);
            }
            this.F.setVisibility((this.H.c0() <= 30 || liveUserGiftBean.getId().equals(j30.q().C())) ? 8 : 0);
            TextView textView2 = this.F;
            final z52 z52Var = this.H;
            textView2.setOnClickListener(new View.OnClickListener() { // from class: y52
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    z52.a.O(LiveUserGiftBean.this, z52Var, view2);
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z52(Context context, int i, String str) {
        super(context);
        context.getClass();
        this.i = i;
        this.j = str;
        this.k = new View.OnClickListener() { // from class: x52
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                z52.S(z52.this, view);
            }
        };
        this.l = Color.parseColor("#FF4C4C");
        this.m = Color.parseColor("#FFAD4C");
        this.n = Color.parseColor("#FFEC4C");
        this.o = o60.b(context, p53.l);
        this.p = j30.q().F();
    }

    public static void S(z52 z52Var, View view) {
        et2 et2Var;
        Object tag = view.getTag();
        LiveUserGiftBean liveUserGiftBean = tag instanceof LiveUserGiftBean ? (LiveUserGiftBean) tag : null;
        if (liveUserGiftBean == null || (et2Var = z52Var.h) == null) {
            return;
        }
        et2Var.onItemClick(liveUserGiftBean, 0);
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        viewGroup.getClass();
        View inflate = this.f.inflate(x73.e1, viewGroup, false);
        inflate.getClass();
        return new a(this, inflate);
    }

    public final String b0() {
        return this.j;
    }

    public final int c0() {
        return this.i;
    }

    public final void d0(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        List list = this.e;
        list.getClass();
        Iterator it = list.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (dq1.a(str, ((LiveUserGiftBean) it.next()).getId())) {
                break;
            } else {
                i++;
            }
        }
        if (i >= 0) {
            this.e.remove(i);
            p();
        }
    }

    @Override // defpackage.ce3
    public int j() {
        return this.i <= 30 ? Math.min(this.e.size(), 100) : super.j();
    }

    public void z(RecyclerView.e0 e0Var, int i) {
        e0Var.getClass();
        Object obj = this.e.get(i);
        obj.getClass();
        ((a) e0Var).P((LiveUserGiftBean) obj, i);
    }
}
