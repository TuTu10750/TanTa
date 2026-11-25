package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.live.bean.LiveReportBean;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class z42 extends RecyclerView.Adapter {
    public List d;
    public LayoutInflater e;
    public Drawable f;
    public Drawable g;
    public int h = -1;
    public View.OnClickListener i = new a();
    public View.OnClickListener j = new b();
    public d k;
    public c l;
    public LiveReportBean m;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag == null) {
                return;
            }
            int intValue = ((Integer) tag).intValue();
            LiveReportBean liveReportBean = (LiveReportBean) z42.this.d.get(intValue - 1);
            if (z42.this.h == intValue) {
                liveReportBean.setChecked(false);
                z42.this.r(intValue, "payload");
                z42.this.h = -1;
                z42.this.m = null;
                return;
            }
            if (z42.this.h >= 0) {
                ((LiveReportBean) z42.this.d.get(z42.this.h - 1)).setChecked(false);
                z42 z42Var = z42.this;
                z42Var.r(z42Var.h, "payload");
            }
            liveReportBean.setChecked(true);
            z42.this.r(intValue, "payload");
            z42.this.h = intValue;
            z42.this.m = liveReportBean;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (z42.this.k != null) {
                z42.this.k.O();
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface c {
        void U(LiveReportBean liveReportBean, String str);
    }

    /* loaded from: /tmp/classes2.dex */
    public class d extends RecyclerView.e0 {
        public EditText u;

        public d(View view) {
            super(view);
            this.u = (EditText) view.findViewById(b73.N1);
            view.findViewById(b73.Q0).setOnClickListener(z42.this.j);
        }

        public void O() {
            String trim = this.u.getText().toString().trim();
            if (z42.this.l != null) {
                z42.this.l.U(z42.this.m, trim);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e extends RecyclerView.e0 {
        public e(View view) {
            super(view);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class f extends RecyclerView.e0 {
        public ImageView u;
        public TextView v;

        public f(View view) {
            super(view);
            this.u = (ImageView) view.findViewById(b73.R2);
            this.v = (TextView) view.findViewById(b73.c5);
            view.setOnClickListener(z42.this.i);
        }

        public void O(LiveReportBean liveReportBean, int i, Object obj) {
            if (obj == null) {
                ((RecyclerView.e0) this).a.setTag(Integer.valueOf(i));
                this.v.setText(liveReportBean.getName());
            }
            ImageView imageView = this.u;
            boolean isChecked = liveReportBean.isChecked();
            z42 z42Var = z42.this;
            imageView.setImageDrawable(isChecked ? z42Var.f : z42Var.g);
        }
    }

    public z42(Context context, List list) {
        this.d = list;
        this.e = LayoutInflater.from(context);
        this.f = o60.d(context, q83.k1);
        this.g = o60.d(context, q83.j1);
    }

    public void A(RecyclerView.e0 e0Var, int i, List list) {
        Object obj = list.size() > 0 ? list.get(0) : null;
        if (e0Var instanceof f) {
            ((f) e0Var).O((LiveReportBean) this.d.get(i - 1), i, obj);
        }
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        if (i == -1) {
            return new e(this.e.inflate(x73.Y0, viewGroup, false));
        }
        if (i != -2) {
            return i == 1 ? new f(this.e.inflate(x73.W0, viewGroup, false)) : new f(this.e.inflate(x73.V0, viewGroup, false));
        }
        if (this.k == null) {
            this.k = new d(this.e.inflate(x73.X0, viewGroup, false));
        }
        return this.k;
    }

    public void W(c cVar) {
        this.l = cVar;
    }

    public int j() {
        return this.d.size() + 2;
    }

    public int l(int i) {
        if (i == 0) {
            return -1;
        }
        if (i == this.d.size() + 1) {
            return -2;
        }
        return i == this.d.size() ? 1 : 0;
    }

    public void z(RecyclerView.e0 e0Var, int i) {
    }
}
