package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.main.bean.RecommendBean;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class cc3 extends RecyclerView.Adapter {
    public Context d;
    public List e;
    public LayoutInflater f;
    public View.OnClickListener g = new a();
    public Drawable h;
    public Drawable i;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null) {
                int intValue = ((Integer) tag).intValue();
                ((RecommendBean) cc3.this.e.get(intValue)).toggleChecked();
                cc3.this.r(intValue, "payload");
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends RecyclerView.e0 {
        public ImageView u;
        public ImageView v;
        public TextView w;
        public TextView x;

        public b(View view) {
            super(view);
            this.u = (ImageView) view.findViewById(c73.l);
            this.v = (ImageView) view.findViewById(c73.c4);
            this.w = (TextView) view.findViewById(c73.L3);
            this.x = (TextView) view.findViewById(c73.j2);
            view.setOnClickListener(cc3.this.g);
        }

        public void O(RecommendBean recommendBean, int i, Object obj) {
            ((RecyclerView.e0) this).a.setTag(Integer.valueOf(i));
            if (obj == null) {
                kn1.g(cc3.this.d, recommendBean.getAvatar(), this.u);
                this.w.setText(recommendBean.getUserNiceName());
                this.x.setText(recommendBean.getFans());
            }
            ImageView imageView = this.v;
            boolean isChecked = recommendBean.isChecked();
            cc3 cc3Var = cc3.this;
            imageView.setImageDrawable(isChecked ? cc3Var.h : cc3Var.i);
        }
    }

    public cc3(Context context, List list) {
        this.d = context;
        this.e = list;
        this.f = LayoutInflater.from(context);
        this.h = o60.d(context, u83.E);
        this.i = o60.d(context, u83.D);
    }

    public String Q() {
        List list = this.e;
        if (list == null || list.size() == 0) {
            return "";
        }
        StringBuilder sb = null;
        for (RecommendBean recommendBean : this.e) {
            if (recommendBean.isChecked()) {
                if (sb == null) {
                    sb = new StringBuilder();
                }
                sb.append(recommendBean.getId());
                sb.append(",");
            }
        }
        if (sb == null) {
            return "";
        }
        String sb2 = sb.toString();
        return sb2.length() > 0 ? sb2.substring(0, sb2.length() - 1) : sb2;
    }

    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public void z(b bVar, int i) {
    }

    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public void A(b bVar, int i, List list) {
        bVar.O((RecommendBean) this.e.get(i), i, list.size() > 0 ? list.get(0) : null);
    }

    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public b B(ViewGroup viewGroup, int i) {
        return new b(this.f.inflate(y73.I0, viewGroup, false));
    }

    public int j() {
        return this.e.size();
    }
}
