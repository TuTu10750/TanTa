package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.common.bean.LevelBean;
import com.yunbao.common.bean.UserBean;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class h02 extends RecyclerView.Adapter {
    public Context d;
    public List e;
    public LayoutInflater f;
    public View.OnClickListener g = new a();
    public et2 h;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null) {
                int intValue = ((Integer) tag).intValue();
                if (h02.this.h != null) {
                    h02.this.h.onItemClick((UserBean) h02.this.e.get(intValue), intValue);
                }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends RecyclerView.e0 {
        public ImageView u;
        public TextView v;
        public ImageView w;
        public ImageView x;
        public View y;

        public b(View view) {
            super(view);
            this.u = (ImageView) view.findViewById(b73.d);
            this.v = (TextView) view.findViewById(b73.X3);
            this.w = (ImageView) view.findViewById(b73.U4);
            this.x = (ImageView) view.findViewById(b73.z3);
            View findViewById = view.findViewById(b73.Q);
            this.y = findViewById;
            findViewById.setOnClickListener(h02.this.g);
        }

        public void O(UserBean userBean, int i, Object obj) {
            this.y.setTag(Integer.valueOf(i));
            if (obj == null) {
                kn1.g(h02.this.d, userBean.getAvatar(), this.u);
                this.v.setText(userBean.getUserNiceName());
                this.w.setImageResource(l30.b(userBean.getSex()));
                LevelBean s = j30.q().s(userBean.getLevel());
                if (s != null) {
                    kn1.f(h02.this.d, s.getThumb(), this.x);
                }
            }
        }
    }

    public h02(Context context, List list) {
        this.d = context;
        this.f = LayoutInflater.from(context);
        this.e = list;
    }

    public void P() {
        this.e.clear();
        p();
    }

    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public void z(b bVar, int i) {
    }

    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public void A(b bVar, int i, List list) {
        bVar.O((UserBean) this.e.get(i), i, list.size() > 0 ? list.get(0) : null);
    }

    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public b B(ViewGroup viewGroup, int i) {
        return new b(this.f.inflate(x73.E0, viewGroup, false));
    }

    public void T() {
        List list = this.e;
        if (list != null) {
            list.clear();
        }
        this.g = null;
        this.h = null;
    }

    public void U(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int size = this.e.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            } else if (str.equals(((UserBean) this.e.get(i)).getId())) {
                break;
            } else {
                i++;
            }
        }
        if (i >= 0) {
            this.e.remove(i);
            x(i);
            u(i, this.e.size(), "payload");
        }
    }

    public void V(List list) {
        this.e = list;
        p();
    }

    public void W(et2 et2Var) {
        this.h = et2Var;
    }

    public int j() {
        return this.e.size();
    }
}
