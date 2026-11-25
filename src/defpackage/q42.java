package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.common.bean.LiveClassBean;
import com.yunbao.common.custom.MyRadioButton;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class q42 extends RecyclerView.Adapter {
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
            if (tag == null || q42.this.h == null) {
                return;
            }
            q42.this.h.onItemClick((LiveClassBean) tag, 0);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends RecyclerView.e0 {
        public ImageView u;
        public TextView v;
        public TextView w;
        public MyRadioButton x;

        public b(View view) {
            super(view);
            this.u = (ImageView) view.findViewById(b73.d5);
            this.v = (TextView) view.findViewById(b73.X3);
            this.w = (TextView) view.findViewById(b73.I1);
            this.x = (MyRadioButton) view.findViewById(b73.x4);
            view.setOnClickListener(q42.this.g);
        }

        public void O(LiveClassBean liveClassBean) {
            ((RecyclerView.e0) this).a.setTag(liveClassBean);
            kn1.f(q42.this.d, liveClassBean.getThumb(), this.u);
            this.v.setText(liveClassBean.getName());
            this.w.setText(liveClassBean.getDes());
            this.x.a(liveClassBean.isChecked());
        }
    }

    public q42(Context context, List list) {
        this.d = context;
        this.e = list;
        this.f = LayoutInflater.from(context);
    }

    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public void z(b bVar, int i) {
        bVar.O((LiveClassBean) this.e.get(i));
    }

    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public b B(ViewGroup viewGroup, int i) {
        return new b(this.f.inflate(x73.R0, viewGroup, false));
    }

    public void Q(et2 et2Var) {
        this.h = et2Var;
    }

    public int j() {
        return this.e.size();
    }
}
