package defpackage;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.l;
import com.yunbao.live.bean.LiveBean;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class e52 extends RecyclerView.Adapter {
    public Context d;
    public List e;
    public LayoutInflater f;
    public int g;
    public RecyclerView k;
    public LinearLayoutManager l;
    public c m;
    public boolean h = true;
    public boolean i = true;
    public SparseArray j = new SparseArray();
    public Handler n = new a();

    /* loaded from: /tmp/classes2.dex */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d dVar = (d) e52.this.j.get(e52.this.g);
            if (dVar != null) {
                dVar.R(false);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends RecyclerView.t {
        public b() {
        }

        public void a(RecyclerView recyclerView, int i) {
        }

        public void b(RecyclerView recyclerView, int i, int i2) {
            int h2 = e52.this.l.h2();
            if (h2 < 0 || e52.this.g == h2) {
                return;
            }
            d dVar = (d) e52.this.j.get(h2);
            if (dVar != null) {
                dVar.R(false);
            }
            e52.this.g = h2;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface c {
        void a(LiveBean liveBean, ViewGroup viewGroup, boolean z);

        void b(String str);

        void c(String str);
    }

    /* loaded from: /tmp/classes2.dex */
    public class d extends RecyclerView.e0 {
        public ViewGroup u;
        public ImageView v;
        public LiveBean w;

        public d(View view) {
            super(view);
            this.u = (ViewGroup) view.findViewById(b73.A1);
            this.v = (ImageView) view.findViewById(b73.F1);
        }

        public void O() {
            ImageView imageView = this.v;
            if (imageView == null || imageView.getVisibility() != 0) {
                return;
            }
            this.v.setVisibility(4);
        }

        public void P() {
            ImageView imageView = this.v;
            if (imageView != null) {
                if (imageView.getVisibility() != 0) {
                    this.v.setVisibility(0);
                }
                this.v.setImageDrawable(null);
                if (this.w != null) {
                    kn1.h(e52.this.d, this.w.getThumb(), this.v);
                    if (e52.this.m != null) {
                        e52.this.m.c(this.w.getThumb());
                    }
                }
            }
        }

        public void Q() {
            ImageView imageView = this.v;
            if (imageView != null && imageView.getVisibility() != 0) {
                this.v.setVisibility(0);
            }
            if (e52.this.m != null) {
                e52.this.m.b(this.w.getUid());
            }
        }

        public void R(boolean z) {
            if (e52.this.m != null) {
                e52.this.m.a(this.w, this.u, z);
            }
        }

        public void S(LiveBean liveBean, int i) {
            this.w = liveBean;
            e52.this.j.put(i, this);
            kn1.h(e52.this.d, liveBean.getThumb(), this.v);
        }
    }

    public e52(Context context, List list, int i) {
        this.d = context;
        this.e = list;
        this.f = LayoutInflater.from(context);
        this.g = i;
    }

    public void R() {
        d dVar = (d) this.j.get(this.g);
        if (dVar != null) {
            dVar.O();
        }
    }

    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public void z(d dVar, int i) {
        List list = this.e;
        if (list != null) {
            dVar.S((LiveBean) list.get(i), i);
            if (this.h) {
                this.h = false;
                dVar.O();
                dVar.R(true);
            }
        }
    }

    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public d B(ViewGroup viewGroup, int i) {
        return new d(this.f.inflate(x73.Z0, viewGroup, false));
    }

    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public void E(d dVar) {
        if (this.i) {
            this.i = false;
        } else {
            dVar.P();
        }
    }

    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public void F(d dVar) {
        dVar.Q();
    }

    public void W() {
        this.m = null;
        Handler handler = this.n;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.n = null;
    }

    public void X(c cVar) {
        this.m = cVar;
    }

    public int j() {
        List list = this.e;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public void y(RecyclerView recyclerView) {
        this.k = recyclerView;
        this.l = recyclerView.getLayoutManager();
        recyclerView.v1(this.g);
        new l().b(recyclerView);
        recyclerView.setOnScrollListener(new b());
    }
}
