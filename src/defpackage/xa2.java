package defpackage;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.live.bean.LiveBean;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class xa2 extends ce3 {
    public View.OnClickListener i;
    public View j;
    public int k;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag;
            if (xa2.this.L() && (tag = view.getTag()) != null) {
                int intValue = ((Integer) tag).intValue();
                if (xa2.this.e == null || intValue < 0 || intValue >= xa2.this.e.size()) {
                    return;
                }
                xa2.this.h.onItemClick((LiveBean) xa2.this.e.get(intValue), intValue);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static class b extends RecyclerView.e0 {
        public b(View view) {
            super(view);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends RecyclerView.e0 {
        public View A;
        public LinearLayout B;
        public TextView C;
        public ConstraintLayout u;
        public ImageView v;
        public TextView w;
        public TextView x;
        public TextView y;
        public RelativeLayout z;

        public c(View view) {
            super(view);
            this.u = view.findViewById(c73.j3);
            this.v = (ImageView) view.findViewById(c73.L1);
            this.A = view.findViewById(c73.A5);
            this.w = (TextView) view.findViewById(c73.L3);
            this.x = (TextView) view.findViewById(c73.H4);
            this.y = (TextView) view.findViewById(c73.U3);
            this.C = (TextView) view.findViewById(c73.m5);
            this.z = (RelativeLayout) view.findViewById(c73.G3);
            this.B = (LinearLayout) view.findViewById(c73.H3);
            view.setOnClickListener(xa2.this.i);
        }

        public void O() {
            kn1.a(this.v);
        }

        public void P(LiveBean liveBean, int i) {
            int c = (gk3.a().c() - zn0.a(42)) / 3;
            ViewGroup.LayoutParams layoutParams = this.u.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = c;
                this.u.setLayoutParams(layoutParams);
            }
            ((RecyclerView.e0) this).a.setTag(Integer.valueOf(i));
            kn1.l(xa2.this.d, liveBean.getThumb(), this.v, c, c);
            this.w.setText(liveBean.getUserNiceName());
            if (liveBean.getTitle() == null || liveBean.getTitle().isEmpty()) {
                this.x.setText(liveBean.getUserNiceName());
                this.w.setVisibility(8);
            } else {
                this.w.setVisibility(0);
                this.x.setText(liveBean.getTitle());
            }
            this.y.setText(liveBean.getNums());
            boolean isPK = liveBean.getIsPK();
            RelativeLayout relativeLayout = this.z;
            if (isPK) {
                relativeLayout.setVisibility(0);
            } else {
                relativeLayout.setVisibility(8);
            }
            if (liveBean.getType() != 2 && liveBean.getType() != 3) {
                this.B.setVisibility(8);
                return;
            }
            this.B.setVisibility(0);
            if (liveBean.getType() == 2) {
                this.C.setText(liveBean.getTypeVal() + "票/场");
            }
            if (liveBean.getType() == 3) {
                this.C.setText(liveBean.getTypeVal() + "票/分钟");
            }
        }
    }

    public xa2(Context context, List list) {
        super(context, list);
        this.k = -1;
        b0();
        I(false);
    }

    public void A(RecyclerView.e0 e0Var, int i, List list) {
        if (e0Var instanceof b) {
            return;
        }
        if (list.isEmpty()) {
            z(e0Var, i);
        } else if (e0Var instanceof c) {
            if (((Integer) list.get(0)).intValue() == 1) {
                ((c) e0Var).A.setVisibility(0);
            } else {
                ((c) e0Var).A.setVisibility(8);
            }
        }
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        if (i != 0) {
            return new c(this.f.inflate(y73.D0, viewGroup, false));
        }
        if (this.j.getLayoutParams() == null) {
            this.j.setLayoutParams(new RecyclerView.p(-1, -2));
        }
        return new b(this.j);
    }

    public void G(RecyclerView.e0 e0Var) {
        super.G(e0Var);
        if (e0Var instanceof c) {
            ((c) e0Var).O();
        }
    }

    @Override // defpackage.ce3
    public void O(List list) {
        if (this.g == null || this.e == null || list == null || list.size() <= 0) {
            return;
        }
        int size = this.e.size();
        this.e.addAll(list);
        v(size + a0(), list.size());
    }

    public void Z(String str) {
        List list = this.e;
        if (list == null || list.isEmpty()) {
            return;
        }
        int i = 0;
        while (i < this.e.size()) {
            if (((LiveBean) this.e.get(i)).getUid().equals(str)) {
                this.e.remove(i);
                int a0 = a0() + i;
                x(a0);
                t(a0, j() - a0);
                int i2 = this.k;
                if (i2 == i) {
                    this.k = -1;
                } else if (i2 > i) {
                    this.k = i2 - 1;
                }
                i--;
            }
            i++;
        }
    }

    public final int a0() {
        return this.j != null ? 1 : 0;
    }

    public final void b0() {
        this.i = new a();
    }

    public boolean c0(int i) {
        return this.j != null && i == 0;
    }

    public void d0(View view) {
        boolean z = (this.j == null) != (view == null);
        this.j = view;
        if (z) {
            p();
        }
    }

    public void e0(int i) {
        int i2;
        int i3;
        Log.d("9890", "clickPosition:" + this.k + " targetPosition:" + i);
        int a0 = a0();
        List list = this.e;
        if (list == null || i < 0 || i >= list.size()) {
            int i4 = this.k;
            if (i4 != -1 && (i2 = i4 + a0) < j()) {
                r(i2, 0);
            }
            this.k = -1;
            return;
        }
        int i5 = this.k;
        if (i == i5) {
            return;
        }
        if (i5 != -1 && (i3 = i5 + a0) < j()) {
            r(i3, 0);
        }
        this.k = i;
        r(i + a0, 1);
    }

    @Override // defpackage.ce3
    public int j() {
        List list = this.e;
        return a0() + (list != null ? list.size() : 0);
    }

    public int l(int i) {
        if (c0(i)) {
            return 0;
        }
        return (i - a0()) % 2 == 0 ? 1 : 2;
    }

    public void z(RecyclerView.e0 e0Var, int i) {
        if (e0Var instanceof b) {
            return;
        }
        int a0 = i - a0();
        if (e0Var instanceof c) {
            c cVar = (c) e0Var;
            cVar.P((LiveBean) this.e.get(a0), a0);
            int i2 = this.k;
            View view = cVar.A;
            if (a0 == i2) {
                view.setVisibility(0);
            } else {
                view.setVisibility(8);
            }
        }
    }
}
