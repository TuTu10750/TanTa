package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.video.bean.VideoReportBean;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class vi4 extends RecyclerView.Adapter {
    public List d;
    public LayoutInflater e;
    public Drawable f;
    public Drawable g;
    public int h = -1;
    public View.OnClickListener i = new a();
    public View.OnClickListener j = new b();
    public d k;
    public c l;
    public VideoReportBean m;

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
            int intValue = ((Integer) tag).intValue();
            VideoReportBean videoReportBean = (VideoReportBean) vi4.this.d.get(intValue - 1);
            if (vi4.this.h == intValue) {
                videoReportBean.setChecked(false);
                vi4.this.r(intValue, "payload");
                vi4.this.h = -1;
                vi4.this.m = null;
                return;
            }
            if (vi4.this.h >= 0) {
                ((VideoReportBean) vi4.this.d.get(vi4.this.h - 1)).setChecked(false);
                vi4 vi4Var = vi4.this;
                vi4Var.r(vi4Var.h, "payload");
            }
            videoReportBean.setChecked(true);
            vi4.this.r(intValue, "payload");
            vi4.this.h = intValue;
            vi4.this.m = videoReportBean;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (vi4.this.k != null) {
                vi4.this.k.O();
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface c {
        void N0(VideoReportBean videoReportBean, String str);
    }

    /* loaded from: /tmp/classes2.dex */
    public class d extends RecyclerView.e0 {
        public EditText u;

        public d(View view) {
            super(view);
            this.u = (EditText) view.findViewById(f73.y);
            view.findViewById(f73.q).setOnClickListener(vi4.this.j);
        }

        public void O() {
            String trim = this.u.getText().toString().trim();
            if (vi4.this.l != null) {
                vi4.this.l.N0(vi4.this.m, trim);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e extends RecyclerView.e0 {
        public e(View view) {
            super(view);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class f extends RecyclerView.e0 {
        public ImageView u;
        public TextView v;

        public f(View view) {
            super(view);
            this.u = (ImageView) view.findViewById(f73.A);
            this.v = (TextView) view.findViewById(f73.U);
            view.setOnClickListener(vi4.this.i);
        }

        public void O(VideoReportBean videoReportBean, int i, Object obj) {
            if (obj == null) {
                ((RecyclerView.e0) this).a.setTag(Integer.valueOf(i));
                this.v.setText(videoReportBean.getName());
            }
            ImageView imageView = this.u;
            boolean isChecked = videoReportBean.isChecked();
            vi4 vi4Var = vi4.this;
            imageView.setImageDrawable(isChecked ? vi4Var.f : vi4Var.g);
        }
    }

    public vi4(Context context, List list) {
        this.d = list;
        this.e = LayoutInflater.from(context);
        this.f = o60.d(context, q83.k1);
        this.g = o60.d(context, q83.j1);
    }

    public void A(RecyclerView.e0 e0Var, int i, List list) {
        Object obj = list.size() > 0 ? list.get(0) : null;
        if (e0Var instanceof f) {
            ((f) e0Var).O((VideoReportBean) this.d.get(i - 1), i, obj);
        }
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        if (i == -1) {
            return new e(this.e.inflate(b83.p, viewGroup, false));
        }
        if (i != -2) {
            return i == 1 ? new f(this.e.inflate(b83.n, viewGroup, false)) : new f(this.e.inflate(b83.m, viewGroup, false));
        }
        if (this.k == null) {
            this.k = new d(this.e.inflate(b83.o, viewGroup, false));
        }
        return this.k;
    }

    public void W(c cVar) {
        this.l = cVar;
    }

    public int j() {
        return this.d.size() + 2;
    }

    public int l(int i) {
        if (i == 0) {
            return -1;
        }
        if (i == this.d.size() + 1) {
            return -2;
        }
        return i == this.d.size() ? 1 : 0;
    }

    public void z(RecyclerView.e0 e0Var, int i) {
    }
}
