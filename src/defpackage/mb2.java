package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.common.bean.UserItemBean;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class mb2 extends RecyclerView.Adapter {
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
                UserItemBean userItemBean = (UserItemBean) tag;
                if (mb2.this.h != null) {
                    mb2.this.h.onItemClick(userItemBean, 0);
                }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends RecyclerView.e0 {
        public ImageView u;
        public TextView v;

        public b(View view) {
            super(view);
            this.u = (ImageView) view.findViewById(c73.E4);
            this.v = (TextView) view.findViewById(c73.L3);
            view.setOnClickListener(mb2.this.g);
        }

        public void O(UserItemBean userItemBean) {
            ((RecyclerView.e0) this).a.setTag(userItemBean);
            kn1.f(mb2.this.d, userItemBean.getThumb(), this.u);
            this.v.setText(userItemBean.getName());
        }
    }

    public mb2(Context context, List list) {
        this.d = context;
        this.e = list;
        this.f = LayoutInflater.from(context);
    }

    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public void z(b bVar, int i) {
        bVar.O((UserItemBean) this.e.get(i));
    }

    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public b B(ViewGroup viewGroup, int i) {
        return new b(this.f.inflate(y73.G0, viewGroup, false));
    }

    public void Q(List list) {
        if (list == null) {
            return;
        }
        if (this.e.size() == list.size()) {
            int size = this.e.size();
            for (int i = 0; i < size; i++) {
                if (((UserItemBean) this.e.get(i)).isEqual((UserItemBean) list.get(i))) {
                }
            }
            return;
        }
        this.e = list;
        p();
    }

    public void R(et2 et2Var) {
        this.h = et2Var;
    }

    public int j() {
        return this.e.size();
    }
}
