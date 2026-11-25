package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.main.bean.MainStartDialogBean;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class ub2 extends ce3 {
    public View.OnClickListener i;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MainStartDialogBean mainStartDialogBean;
            if (!ub2.this.L() || (mainStartDialogBean = (MainStartDialogBean) view.getTag()) == null || ub2.this.h == null) {
                return;
            }
            ub2.this.h.onItemClick(mainStartDialogBean, 0);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends RecyclerView.e0 {
        public ImageView u;
        public TextView v;

        public b(View view) {
            super(view);
            this.u = (ImageView) view.findViewById(c73.E2);
            this.v = (TextView) view.findViewById(c73.C4);
            view.setOnClickListener(ub2.this.i);
        }

        public void O(MainStartDialogBean mainStartDialogBean) {
            ((RecyclerView.e0) this).a.setTag(mainStartDialogBean);
            this.u.setImageResource(mainStartDialogBean.getIconRes());
            this.v.setText(mainStartDialogBean.getTextRes());
        }
    }

    public ub2(Context context, List list) {
        super(context, list);
        this.i = new a();
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new b(this.f.inflate(y73.w0, viewGroup, false));
    }

    public void z(RecyclerView.e0 e0Var, int i) {
        ((b) e0Var).O((MainStartDialogBean) this.e.get(i));
    }
}
