package defpackage;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.common.bean.ConfigBean;
import com.yunbao.common.mob.MobBean;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class j52 extends RecyclerView.Adapter {
    public List d = new ArrayList();
    public LayoutInflater e;
    public View.OnClickListener f;
    public et2 g;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public final /* synthetic */ Context a;

        public a(Context context) {
            this.a = context;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null) {
                if (j52.this.g != null) {
                    j52.this.g.onItemClick((MobBean) tag, 0);
                }
                ((ClipboardManager) this.a.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text", ((MobBean) tag).getType()));
                t54.a(m93.u1);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends RecyclerView.e0 {
        public ImageView u;
        public TextView v;

        public b(View view) {
            super(view);
            this.u = (ImageView) view.findViewById(b73.M2);
            this.v = (TextView) view.findViewById(b73.X3);
            view.setOnClickListener(j52.this.f);
        }

        public void O(MobBean mobBean) {
            ((RecyclerView.e0) this).a.setTag(mobBean);
            this.u.setImageResource(mobBean.getIcon1());
            this.v.setText(mobBean.getName());
        }
    }

    public j52(Context context, boolean z) {
        ConfigBean h = j30.q().h();
        if (h != null) {
            this.d.addAll(MobBean.getLiveShareTypeList(h.getShareType()));
        }
        System.out.println("noLink---" + z);
        if (!z) {
            MobBean mobBean = new MobBean();
            mobBean.setType(h.getShare_url());
            System.out.println("configBean.getShare_url()---" + h.getShare_url());
            mobBean.setName(m93.t1);
            mobBean.setIcon1(t83.T0);
            this.d.add(mobBean);
        }
        this.e = LayoutInflater.from(context);
        this.f = new a(context);
    }

    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public void z(b bVar, int i) {
        bVar.O((MobBean) this.d.get(i));
    }

    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public b B(ViewGroup viewGroup, int i) {
        return new b(this.e.inflate(x73.a1, viewGroup, false));
    }

    public void P(et2 et2Var) {
        this.g = et2Var;
    }

    public int j() {
        return this.d.size();
    }
}
