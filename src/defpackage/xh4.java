package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.video.bean.VideoBean;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: /tmp/classes2.dex */
public class xh4 extends ce3 {
    public View.OnClickListener i;
    public String j;
    public String k;

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
            VideoBean videoBean = (VideoBean) xh4.this.e.get(intValue);
            if (videoBean == null || xh4.this.h == null) {
                return;
            }
            xh4.this.h.onItemClick(videoBean, intValue);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends RecyclerView.e0 {
        public ImageView u;
        public TextView v;
        public TextView w;

        public b(View view) {
            super(view);
            this.u = (ImageView) view.findViewById(c73.I2);
            this.v = (TextView) view.findViewById(c73.U3);
            this.w = (TextView) view.findViewById(c73.A4);
            view.setOnClickListener(xh4.this.i);
        }

        public void O(VideoBean videoBean, int i) {
            ((RecyclerView.e0) this).a.setTag(Integer.valueOf(i));
            kn1.f(xh4.this.d, videoBean.getThumb(), this.u);
            this.v.setText(videoBean.getViewNum());
            int status = videoBean.getStatus();
            TextView textView = this.w;
            if (status == 1) {
                if (textView.getVisibility() == 0) {
                    this.w.setVisibility(4);
                    return;
                }
                return;
            }
            if (textView.getVisibility() != 0) {
                this.w.setVisibility(0);
            }
            if (status == 0) {
                this.w.setText(xh4.this.j);
            } else if (status == 2) {
                this.w.setText(xh4.this.k);
            }
        }
    }

    public xh4(Context context) {
        super(context);
        this.i = new a();
        this.j = aq4.a(m93.g6);
        this.k = aq4.a(m93.O7);
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new b(this.f.inflate(y73.P0, viewGroup, false));
    }

    public void Z(HashSet hashSet) {
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            Iterator it2 = this.e.iterator();
            while (true) {
                if (it2.hasNext()) {
                    VideoBean videoBean = (VideoBean) it2.next();
                    if (str.equals(videoBean.getId())) {
                        this.e.remove(videoBean);
                        break;
                    }
                }
            }
        }
        p();
    }

    public void z(RecyclerView.e0 e0Var, int i) {
        ((b) e0Var).O((VideoBean) this.e.get(i), i);
    }
}
