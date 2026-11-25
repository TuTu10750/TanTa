package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.common.bean.ChooseVideoBean;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class sz extends RecyclerView.Adapter {
    public Context d;
    public LayoutInflater e;
    public List f;
    public View.OnClickListener g = new a();
    public b h;

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
            ChooseVideoBean chooseVideoBean = (ChooseVideoBean) sz.this.f.get(((Integer) tag).intValue());
            int type = chooseVideoBean.getType();
            sz szVar = sz.this;
            if (type == 0) {
                if (szVar.h != null) {
                    sz.this.h.b();
                }
            } else if (szVar.h != null) {
                sz.this.h.O(chooseVideoBean);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface b {
        void O(ChooseVideoBean chooseVideoBean);

        void b();
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends d {
        public ImageView v;
        public TextView w;

        public c(View view) {
            super(view);
            this.v = (ImageView) view.findViewById(y63.N);
            this.w = (TextView) view.findViewById(y63.C);
        }

        @Override // sz.d
        public void O(ChooseVideoBean chooseVideoBean, int i) {
            super.O(chooseVideoBean, i);
            kn1.m(sz.this.d, chooseVideoBean.getVideoUri(), this.v);
            this.w.setText(chooseVideoBean.getDurationString());
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d extends RecyclerView.e0 {
        public d(View view) {
            super(view);
            view.setOnClickListener(sz.this.g);
        }

        public void O(ChooseVideoBean chooseVideoBean, int i) {
            ((RecyclerView.e0) this).a.setTag(Integer.valueOf(i));
        }
    }

    public sz(Context context, List list) {
        this.e = LayoutInflater.from(context);
        this.d = context;
        this.f = list;
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return i == 0 ? new d(this.e.inflate(u73.D, viewGroup, false)) : new c(this.e.inflate(u73.E, viewGroup, false));
    }

    public void P(b bVar) {
        this.h = bVar;
    }

    public int j() {
        return this.f.size();
    }

    public int l(int i) {
        return ((ChooseVideoBean) this.f.get(i)).getType();
    }

    public void z(RecyclerView.e0 e0Var, int i) {
        ((d) e0Var).O((ChooseVideoBean) this.f.get(i), i);
    }
}
