package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.common.bean.LevelBean;
import com.yunbao.common.custom.MyRadioButton;
import com.yunbao.common.http.CommonHttpUtil;
import com.yunbao.live.bean.SearchUserBean;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class ok3 extends ce3 {
    public View.OnClickListener i;
    public View.OnClickListener j;
    public String k;
    public String l;
    public int m;
    public String n;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag;
            if (ok3.this.L() && (tag = view.getTag()) != null) {
                CommonHttpUtil.setAttention(((SearchUserBean) tag).getId(), null);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag;
            if (ok3.this.L() && (tag = view.getTag()) != null) {
                SearchUserBean searchUserBean = (SearchUserBean) tag;
                if (ok3.this.h != null) {
                    ok3.this.h.onItemClick(searchUserBean, 0);
                }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends RecyclerView.e0 {
        public MyRadioButton A;
        public ImageView u;
        public TextView v;
        public TextView w;
        public ImageView x;
        public ImageView y;
        public ImageView z;

        public c(View view) {
            super(view);
            this.u = (ImageView) view.findViewById(c73.l);
            this.v = (TextView) view.findViewById(c73.L3);
            this.w = (TextView) view.findViewById(c73.z4);
            this.x = (ImageView) view.findViewById(c73.x4);
            this.y = (ImageView) view.findViewById(c73.v3);
            this.z = (ImageView) view.findViewById(c73.u3);
            this.A = (MyRadioButton) view.findViewById(c73.m0);
            view.setOnClickListener(ok3.this.j);
            this.A.setOnClickListener(ok3.this.i);
        }

        public void O(SearchUserBean searchUserBean, int i, Object obj) {
            ((RecyclerView.e0) this).a.setTag(searchUserBean);
            this.A.setTag(searchUserBean);
            if (obj == null) {
                kn1.g(ok3.this.d, searchUserBean.getAvatar(), this.u);
                this.v.setText(searchUserBean.getUserNiceName());
                this.w.setText(searchUserBean.getSignature());
                this.x.setImageResource(l30.b(searchUserBean.getSex()));
                LevelBean c = j30.q().c(searchUserBean.getLevelAnchor());
                if (c != null) {
                    kn1.f(ok3.this.d, c.getThumb(), this.y);
                }
                LevelBean s = j30.q().s(searchUserBean.getLevel());
                if (s != null) {
                    kn1.f(ok3.this.d, s.getThumb(), this.z);
                }
            }
            boolean equals = ok3.this.n.equals(searchUserBean.getId());
            MyRadioButton myRadioButton = this.A;
            if (equals) {
                if (myRadioButton.getVisibility() == 0) {
                    this.A.setVisibility(4);
                    return;
                }
                return;
            }
            if (myRadioButton.getVisibility() != 0) {
                this.A.setVisibility(0);
            }
            int attention = searchUserBean.getAttention();
            MyRadioButton myRadioButton2 = this.A;
            if (attention == 1) {
                myRadioButton2.a(true);
                this.A.setText(ok3.this.l);
            } else {
                myRadioButton2.a(false);
                this.A.setText(ok3.this.k);
            }
        }
    }

    public ok3(Context context, int i) {
        super(context);
        this.m = i;
        this.k = aq4.a(m93.M1);
        this.l = aq4.a(m93.N1);
        this.i = new a();
        this.j = new b();
        this.n = j30.q().C();
    }

    public void A(RecyclerView.e0 e0Var, int i, List list) {
        ((c) e0Var).O((SearchUserBean) this.e.get(i), i, list.size() > 0 ? list.get(0) : null);
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new c(this.f.inflate(y73.J0, viewGroup, false));
    }

    public void e0(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int size = this.e.size();
        for (int i2 = 0; i2 < size; i2++) {
            SearchUserBean searchUserBean = (SearchUserBean) this.e.get(i2);
            if (searchUserBean != null && str.equals(searchUserBean.getId())) {
                searchUserBean.setAttention(i);
                r(i2, "payload");
                return;
            }
        }
    }

    public void z(RecyclerView.e0 e0Var, int i) {
    }
}
