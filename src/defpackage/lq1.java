package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.live.bean.InviteBean;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class lq1 extends RecyclerView.Adapter {
    public LayoutInflater e;
    public b g;
    public Context h;
    public List d = new ArrayList();
    public View.OnClickListener f = new a();

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag == null || lq1.this.g == null) {
                return;
            }
            int intValue = ((Integer) tag).intValue();
            lq1.this.g.a((InviteBean) lq1.this.d.get(intValue), intValue);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface b {
        void a(InviteBean inviteBean, int i);
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends RecyclerView.e0 {
        public ImageView u;
        public TextView v;

        public c(View view) {
            super(view);
            this.u = (ImageView) view.findViewById(c73.I4);
            this.v = (TextView) view.findViewById(c73.C);
            view.setOnClickListener(lq1.this.f);
        }

        public void O(InviteBean inviteBean, int i, Object obj) {
            ((RecyclerView.e0) this).a.setTag(Integer.valueOf(i));
            kn1.f(lq1.this.h, inviteBean.getThumb(), this.u);
            this.v.setText(inviteBean.getName());
        }
    }

    public lq1(Context context) {
        this.h = context;
        this.e = LayoutInflater.from(context);
    }

    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public void z(c cVar, int i) {
    }

    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public void A(c cVar, int i, List list) {
        cVar.O((InviteBean) this.d.get(i), i, list.size() > 0 ? list.get(0) : null);
    }

    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public c B(ViewGroup viewGroup, int i) {
        return new c(this.e.inflate(y73.y0, viewGroup, false));
    }

    public void S(b bVar) {
        this.g = bVar;
    }

    public void T(List list) {
        this.d.clear();
        this.d.addAll(list);
        p();
    }

    public int j() {
        return this.d.size();
    }
}
