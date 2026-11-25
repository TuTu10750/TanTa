package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.common.bean.ConfigBean;
import com.yunbao.live.bean.LiveTimeChargeBean;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class o52 extends RecyclerView.Adapter {
    public LayoutInflater e;
    public View.OnClickListener f;
    public int g;
    public String h;
    public int i;
    public int j;
    public String k = aq4.a(m93.I8);
    public List d = new ArrayList();

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue;
            Object tag = view.getTag();
            if (tag == null || o52.this.g == (intValue = ((Integer) tag).intValue())) {
                return;
            }
            if (o52.this.g >= 0 && o52.this.g < o52.this.d.size()) {
                ((LiveTimeChargeBean) o52.this.d.get(o52.this.g)).setChecked(false);
                o52 o52Var = o52.this;
                o52Var.q(o52Var.g);
            }
            ((LiveTimeChargeBean) o52.this.d.get(intValue)).setChecked(true);
            o52.this.q(intValue);
            o52.this.g = intValue;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends RecyclerView.e0 {
        public TextView u;

        public b(View view) {
            super(view);
            this.u = (TextView) view;
            view.setOnClickListener(o52.this.f);
        }

        public void O(LiveTimeChargeBean liveTimeChargeBean, int i) {
            ((RecyclerView.e0) this).a.setTag(Integer.valueOf(i));
            this.u.setText(rv3.a(String.valueOf(liveTimeChargeBean.getCoin()), o52.this.h, "/", o52.this.k));
            boolean isChecked = liveTimeChargeBean.isChecked();
            TextView textView = this.u;
            if (isChecked) {
                textView.setTextColor(o52.this.i);
            } else {
                textView.setTextColor(o52.this.j);
            }
        }
    }

    public o52(Context context, int i) {
        this.g = -1;
        this.i = o60.b(context, p53.g);
        this.j = o60.b(context, p53.l);
        ConfigBean h = j30.q().h();
        if (h != null) {
            this.h = h.getCoinName();
            String[] liveTimeCoin = h.getLiveTimeCoin();
            if (liveTimeCoin != null) {
                int length = liveTimeCoin.length;
                for (int i2 = 0; i2 < length; i2++) {
                    int h2 = rv3.h(liveTimeCoin[i2], 0);
                    LiveTimeChargeBean liveTimeChargeBean = new LiveTimeChargeBean(h2);
                    if (h2 == i) {
                        liveTimeChargeBean.setChecked(true);
                        this.g = i2;
                    }
                    this.d.add(liveTimeChargeBean);
                }
                if (this.g < 0) {
                    this.g = 0;
                    ((LiveTimeChargeBean) this.d.get(0)).setChecked(true);
                }
            }
        }
        this.e = LayoutInflater.from(context);
        this.f = new a();
    }

    public int T() {
        int i = this.g;
        if (i < 0 || i >= this.d.size()) {
            return 0;
        }
        return ((LiveTimeChargeBean) this.d.get(this.g)).getCoin();
    }

    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public void z(b bVar, int i) {
        bVar.O((LiveTimeChargeBean) this.d.get(i), i);
    }

    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public b B(ViewGroup viewGroup, int i) {
        return new b(this.e.inflate(x73.b1, viewGroup, false));
    }

    public int j() {
        return this.d.size();
    }
}
