package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.common.bean.LevelBean;
import com.yunbao.common.bean.UserBean;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class l62 extends ce3 {
    public boolean i;
    public View.OnClickListener j;
    public View.OnClickListener k;
    public c l;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l62.this.l != null) {
                l62.this.l.b((UserBean) view.getTag(), 1);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l62.this.l != null) {
                l62.this.l.b((UserBean) view.getTag(), 0);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface c {
        void b(UserBean userBean, int i);
    }

    /* loaded from: /tmp/classes2.dex */
    public class d extends RecyclerView.e0 {
        public TextView u;
        public ImageView v;
        public TextView w;
        public ImageView x;
        public ImageView y;

        public d(View view) {
            super(view);
            this.u = (TextView) view.findViewById(b73.d3);
            this.v = (ImageView) view.findViewById(b73.d);
            this.w = (TextView) view.findViewById(b73.X3);
            this.x = (ImageView) view.findViewById(b73.U4);
            this.y = (ImageView) view.findViewById(b73.z3);
        }

        public void O(UserBean userBean, int i) {
            this.u.setText(String.valueOf(i + 1));
            kn1.g(l62.this.d, userBean.getAvatar(), this.v);
            this.w.setText(userBean.getUserNiceName());
            this.x.setImageResource(l30.b(userBean.getSex()));
            LevelBean s = j30.q().s(userBean.getLevel());
            if (s != null) {
                kn1.f(l62.this.d, s.getThumb(), this.y);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e extends RecyclerView.e0 {
        public View A;
        public TextView u;
        public ImageView v;
        public TextView w;
        public ImageView x;
        public ImageView y;
        public View z;

        public e(View view) {
            super(view);
            this.u = (TextView) view.findViewById(b73.d3);
            this.v = (ImageView) view.findViewById(b73.d);
            this.w = (TextView) view.findViewById(b73.X3);
            this.x = (ImageView) view.findViewById(b73.U4);
            this.y = (ImageView) view.findViewById(b73.z3);
            this.z = view.findViewById(b73.v);
            this.A = view.findViewById(b73.P0);
            this.z.setOnClickListener(l62.this.j);
            this.A.setOnClickListener(l62.this.k);
        }

        public void O(UserBean userBean, int i) {
            this.z.setTag(userBean);
            this.A.setTag(userBean);
            this.u.setText(String.valueOf(i + 1));
            kn1.g(l62.this.d, userBean.getAvatar(), this.v);
            this.w.setText(userBean.getUserNiceName());
            this.x.setImageResource(l30.b(userBean.getSex()));
            LevelBean s = j30.q().s(userBean.getLevel());
            if (s != null) {
                kn1.f(l62.this.d, s.getThumb(), this.y);
            }
        }
    }

    public l62(Context context, List list, boolean z) {
        super(context, list);
        this.i = z;
        if (z) {
            this.j = new a();
            this.k = new b();
        }
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return this.i ? new e(this.f.inflate(x73.g1, viewGroup, false)) : new d(this.f.inflate(x73.f1, viewGroup, false));
    }

    public void Z(c cVar) {
        this.l = cVar;
    }

    public void z(RecyclerView.e0 e0Var, int i) {
        if (this.i) {
            ((e) e0Var).O((UserBean) this.e.get(i), i);
        } else {
            ((d) e0Var).O((UserBean) this.e.get(i), i);
        }
    }
}
