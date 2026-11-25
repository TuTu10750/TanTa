package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.common.bean.ConfigBean;
import com.yunbao.common.mob.MobBean;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class r42 extends RecyclerView.Adapter {
    public LayoutInflater e;
    public View.OnClickListener f;
    public int g = -1;
    public List d = new ArrayList();

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null) {
                int intValue = ((Integer) tag).intValue();
                int i = r42.this.g;
                r42 r42Var = r42.this;
                if (intValue == i) {
                    ((MobBean) r42Var.d.get(intValue)).setChecked(false);
                    r42.this.q(intValue);
                    r42.this.g = -1;
                    return;
                }
                if (r42Var.g >= 0 && r42.this.g < r42.this.d.size()) {
                    ((MobBean) r42.this.d.get(r42.this.g)).setChecked(false);
                    r42 r42Var2 = r42.this;
                    r42Var2.q(r42Var2.g);
                }
                ((MobBean) r42.this.d.get(intValue)).setChecked(true);
                r42.this.q(intValue);
                r42.this.g = intValue;
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends RecyclerView.e0 {
        public ImageView u;

        public b(View view) {
            super(view);
            this.u = (ImageView) view.findViewById(b73.R2);
            view.setOnClickListener(r42.this.f);
        }

        public void O(MobBean mobBean, int i) {
            ((RecyclerView.e0) this).a.setTag(Integer.valueOf(i));
            boolean isChecked = mobBean.isChecked();
            ImageView imageView = this.u;
            if (isChecked) {
                imageView.setImageResource(mobBean.getIcon1());
            } else {
                imageView.setImageResource(mobBean.getIcon2());
            }
        }
    }

    public r42(Context context) {
        ConfigBean h = j30.q().h();
        if (h != null) {
            this.d.addAll(MobBean.getLiveReadyShareTypeList(h.getShareType()));
        }
        this.e = LayoutInflater.from(context);
        this.f = new a();
    }

    public String P() {
        int i = this.g;
        if (i < 0 || i >= this.d.size()) {
            return null;
        }
        return ((MobBean) this.d.get(this.g)).getType();
    }

    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public void z(b bVar, int i) {
        bVar.O((MobBean) this.d.get(i), i);
    }

    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public b B(ViewGroup viewGroup, int i) {
        return new b(this.e.inflate(x73.S0, viewGroup, false));
    }

    public int j() {
        return this.d.size();
    }
}
