package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.common.mob.MobBean;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class m82 extends RecyclerView.Adapter {
    public List d;
    public LayoutInflater e;
    public et2 f;
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
                if (m82.this.f != null) {
                    m82.this.f.onItemClick((MobBean) m82.this.d.get(intValue), intValue);
                }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends RecyclerView.e0 {
        public ImageView u;

        public b(View view) {
            super(view);
            this.u = (ImageView) view;
            view.setOnClickListener(m82.this.g);
        }

        public void O(MobBean mobBean, int i) {
            ((RecyclerView.e0) this).a.setTag(Integer.valueOf(i));
            this.u.setImageResource(mobBean.getIcon1());
        }
    }

    public m82(Context context, List list) {
        this.d = list;
        this.e = LayoutInflater.from(context);
    }

    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public void z(b bVar, int i) {
        bVar.O((MobBean) this.d.get(i), i);
    }

    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public b B(ViewGroup viewGroup, int i) {
        return new b(this.e.inflate(y73.A0, viewGroup, false));
    }

    public void Q(et2 et2Var) {
        this.f = et2Var;
    }

    public int j() {
        return this.d.size();
    }
}
