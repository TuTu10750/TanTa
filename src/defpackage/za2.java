package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.common.bean.LiveClassBean;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class za2 extends RecyclerView.Adapter {
    public Context d;
    public List e;
    public LayoutInflater f;
    public et2 h;
    public int i = 0;
    public View.OnClickListener g = new a();

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null) {
                int intValue = ((Integer) tag).intValue();
                LiveClassBean liveClassBean = (LiveClassBean) za2.this.e.get(intValue);
                if (za2.this.h != null) {
                    za2.this.h.onItemClick(liveClassBean, intValue);
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
            this.u = (ImageView) view.findViewById(c73.I2);
            this.v = (TextView) view.findViewById(c73.L3);
            view.setOnClickListener(za2.this.g);
        }

        public void O(LiveClassBean liveClassBean, int i) {
            ((RecyclerView.e0) this).a.setTag(Integer.valueOf(i));
            int id = liveClassBean.getId();
            ImageView imageView = this.u;
            if (id == -1) {
                imageView.setVisibility(8);
                this.u.setImageResource(u83.o);
            } else {
                imageView.setVisibility(8);
                kn1.f(za2.this.d, liveClassBean.getThumb(), this.u);
            }
            this.v.setText(liveClassBean.getName());
            int i2 = za2.this.i;
            TextView textView = this.v;
            if (i2 == i) {
                textView.setBackgroundResource(i63.f);
                this.v.setTextColor(-1);
            } else {
                textView.setBackgroundResource(i63.g);
                this.v.setTextColor(-13421773);
            }
        }
    }

    public za2(Context context, List list) {
        this.d = context;
        this.e = list;
        this.f = LayoutInflater.from(context);
    }

    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public void z(b bVar, int i) {
        bVar.O((LiveClassBean) this.e.get(i), i);
    }

    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public b B(ViewGroup viewGroup, int i) {
        return new b(this.f.inflate(y73.C0, viewGroup, false));
    }

    public void R(et2 et2Var) {
        this.h = et2Var;
    }

    public int j() {
        return this.e.size();
    }
}
