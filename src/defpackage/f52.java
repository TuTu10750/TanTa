package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.common.bean.ConfigBean;
import com.yunbao.live.bean.LiveRoomTypeBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class f52 extends RecyclerView.Adapter {
    public LayoutInflater e;
    public View.OnClickListener f;
    public et2 g;
    public int h;
    public int i = -1;
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
                if (f52.this.g != null) {
                    f52.this.g.onItemClick((LiveRoomTypeBean) f52.this.d.get(intValue), intValue);
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
            this.u = (ImageView) view.findViewById(b73.M2);
            this.v = (TextView) view.findViewById(b73.X3);
            view.setOnClickListener(f52.this.f);
        }

        public void O(LiveRoomTypeBean liveRoomTypeBean, int i) {
            ((RecyclerView.e0) this).a.setTag(Integer.valueOf(i));
            this.v.setText(liveRoomTypeBean.getName());
            boolean isChecked = liveRoomTypeBean.isChecked();
            TextView textView = this.v;
            if (isChecked) {
                textView.setTextColor(f52.this.h);
                this.u.setImageResource(liveRoomTypeBean.getCheckedIcon());
            } else {
                textView.setTextColor(f52.this.i);
                this.u.setImageResource(liveRoomTypeBean.getUnCheckedIcon());
            }
        }
    }

    public f52(Context context, int i) {
        String[][] liveType;
        this.h = o60.b(context, p53.g);
        ConfigBean h = j30.q().h();
        if (h != null && (liveType = h.getLiveType()) != null) {
            this.d.addAll(LiveRoomTypeBean.getLiveTypeList(liveType));
            Iterator it = this.d.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                LiveRoomTypeBean liveRoomTypeBean = (LiveRoomTypeBean) it.next();
                if (liveRoomTypeBean.getId() == i) {
                    liveRoomTypeBean.setChecked(true);
                    break;
                }
            }
        }
        this.e = LayoutInflater.from(context);
        this.f = new a();
    }

    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public void z(b bVar, int i) {
        bVar.O((LiveRoomTypeBean) this.d.get(i), i);
    }

    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public b B(ViewGroup viewGroup, int i) {
        return new b(this.e.inflate(x73.c1, viewGroup, false));
    }

    public void S(et2 et2Var) {
        this.g = et2Var;
    }

    public int j() {
        return this.d.size();
    }
}
