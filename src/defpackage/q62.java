package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.live.activity.LiveAudienceActivity;
import com.yunbao.live.bean.LiveVoiceFaceBean;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class q62 extends RecyclerView.Adapter {
    public Context d;
    public LayoutInflater e;
    public List f;
    public View.OnClickListener g = new a();

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue = ((Integer) view.getTag()).intValue();
            if (q62.this.d != null) {
                ((LiveAudienceActivity) q62.this.d).j4(intValue);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends RecyclerView.e0 {
        public ImageView u;

        public b(View view) {
            super(view);
            this.u = (ImageView) view.findViewById(b73.R2);
            view.setOnClickListener(q62.this.g);
        }

        public void O(LiveVoiceFaceBean liveVoiceFaceBean) {
            this.u.setImageResource(liveVoiceFaceBean.getImageRes());
            ((RecyclerView.e0) this).a.setTag(Integer.valueOf(liveVoiceFaceBean.getIndex()));
        }
    }

    public q62(Context context, LayoutInflater layoutInflater, List list) {
        this.d = context;
        this.e = layoutInflater;
        this.f = list;
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new b(this.e.inflate(x73.i1, viewGroup, false));
    }

    public int j() {
        return this.f.size();
    }

    public void z(RecyclerView.e0 e0Var, int i) {
        ((b) e0Var).O((LiveVoiceFaceBean) this.f.get(i));
    }
}
