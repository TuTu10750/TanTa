package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.umeng.commonsdk.statistics.SdkVersion;

/* loaded from: /tmp/classes2.dex */
public class o22 extends RecyclerView.Adapter {
    public LayoutInflater e;
    public et2 g;
    public String[] d = {SdkVersion.MINI_VERSION, "10", "66", "88", "100", "520", "1314"};
    public View.OnClickListener f = new a();

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag == null || o22.this.g == null) {
                return;
            }
            o22.this.g.onItemClick((String) tag, 0);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends RecyclerView.e0 {
        public b(View view) {
            super(view);
            view.setOnClickListener(o22.this.f);
        }

        public void O(String str) {
            ((RecyclerView.e0) this).a.setTag(str);
            ((TextView) ((RecyclerView.e0) this).a).setText(str);
        }
    }

    public o22(Context context) {
        this.e = LayoutInflater.from(context);
    }

    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public void z(b bVar, int i) {
        bVar.O(this.d[i]);
    }

    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public b B(ViewGroup viewGroup, int i) {
        return new b(this.e.inflate(x73.M0, viewGroup, false));
    }

    public void P(et2 et2Var) {
        this.g = et2Var;
    }

    public int j() {
        return this.d.length;
    }
}
