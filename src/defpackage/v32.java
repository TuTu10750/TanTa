package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.live.custom.MusicProgressTextView;
import com.yunbao.live.music.LiveMusicBean;
import defpackage.sq1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class v32 extends RecyclerView.Adapter implements sq1.b {
    public Context d;
    public LayoutInflater f;
    public RecyclerView g;
    public c j;
    public List e = new ArrayList();
    public HashMap k = new HashMap();
    public View.OnClickListener h = new a();
    public View.OnClickListener i = new b();

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag == null || v32.this.j == null) {
                return;
            }
            Integer num = (Integer) tag;
            LiveMusicBean liveMusicBean = (LiveMusicBean) v32.this.e.get(num.intValue());
            if (liveMusicBean.getProgress() == 100) {
                v32.this.j.k(liveMusicBean);
            } else if (liveMusicBean.getProgress() == 0) {
                v32.this.k.put(liveMusicBean.getId(), num);
                v32.this.j.g(liveMusicBean);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null) {
                int intValue = ((Integer) tag).intValue();
                LiveMusicBean liveMusicBean = (LiveMusicBean) v32.this.e.get(intValue);
                v32.this.e.remove(intValue);
                v32.this.x(intValue);
                v32 v32Var = v32.this;
                v32Var.u(intValue, v32Var.e.size(), "payload");
                if (v32.this.j != null) {
                    v32.this.j.f(liveMusicBean.getId(), v32.this.e.size());
                }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface c {
        void f(String str, int i);

        void g(LiveMusicBean liveMusicBean);

        void k(LiveMusicBean liveMusicBean);
    }

    /* loaded from: /tmp/classes2.dex */
    public class d extends RecyclerView.e0 {
        public TextView u;
        public TextView v;
        public MusicProgressTextView w;
        public View x;
        public View y;

        /* JADX WARN: Type inference failed for: r0v8, types: [com.yunbao.live.custom.MusicProgressTextView, android.view.View] */
        public d(View view) {
            super(view);
            this.u = (TextView) view.findViewById(b73.W3);
            this.v = (TextView) view.findViewById(b73.c);
            ?? r0 = (MusicProgressTextView) view.findViewById(b73.w4);
            this.w = r0;
            r0.setOnClickListener(v32.this.h);
            this.y = view.findViewById(b73.C3);
            View findViewById = view.findViewById(b73.Q);
            this.x = findViewById;
            findViewById.setOnClickListener(v32.this.i);
        }

        public void O(LiveMusicBean liveMusicBean, int i, Object obj) {
            if (obj == null) {
                this.u.setText(liveMusicBean.getName());
                this.v.setText(liveMusicBean.getArtist());
            }
            this.w.setTag(Integer.valueOf(i));
            this.x.setTag(Integer.valueOf(i));
            int size = v32.this.e.size() - 1;
            View view = this.y;
            if (i == size) {
                if (view.getVisibility() == 0) {
                    this.y.setVisibility(4);
                }
            } else if (view.getVisibility() != 0) {
                this.y.setVisibility(0);
            }
            this.w.setProgress(liveMusicBean.getProgress());
        }
    }

    public v32(Context context) {
        this.d = context;
        this.f = LayoutInflater.from(context);
    }

    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public void z(d dVar, int i) {
    }

    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public void A(d dVar, int i, List list) {
        dVar.O((LiveMusicBean) this.e.get(i), i, list.size() > 0 ? list.get(0) : null);
    }

    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public d B(ViewGroup viewGroup, int i) {
        return new d(this.f.inflate(x73.P0, viewGroup, false));
    }

    public void T() {
        List list = this.e;
        if (list != null) {
            list.clear();
        }
        HashMap hashMap = this.k;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.d = null;
        this.j = null;
        this.h = null;
        this.i = null;
    }

    public void U(c cVar) {
        this.j = cVar;
    }

    public void V(List list) {
        this.k.clear();
        this.e.clear();
        this.e.addAll(list);
        p();
    }

    public void W(String str, int i) {
        HashMap hashMap;
        List list;
        Integer num;
        LiveMusicBean liveMusicBean;
        if (TextUtils.isEmpty(str) || (hashMap = this.k) == null || hashMap.size() == 0 || (list = this.e) == null || list.size() == 0 || (num = (Integer) this.k.get(str)) == null || num.intValue() < 0 || num.intValue() >= this.e.size() || (liveMusicBean = (LiveMusicBean) this.e.get(num.intValue())) == null || !str.equals(liveMusicBean.getId())) {
            return;
        }
        liveMusicBean.setProgress(i);
        r(num.intValue(), "payload");
        if (i == 100) {
            this.k.remove(str);
        }
    }

    @Override // sq1.b
    public RecyclerView.e0 a(View view) {
        RecyclerView recyclerView = this.g;
        if (recyclerView == null || view == null) {
            return null;
        }
        return recyclerView.p0(view);
    }

    @Override // sq1.b
    public void b(RecyclerView.e0 e0Var) {
    }

    @Override // sq1.b
    public View c(float f, float f2) {
        return this.g.Z(f, f2);
    }

    @Override // sq1.b
    public int d(RecyclerView.e0 e0Var) {
        return zn0.a(60);
    }

    @Override // sq1.b
    public boolean e() {
        return true;
    }

    public int j() {
        return this.e.size();
    }

    public void y(RecyclerView recyclerView) {
        super.y(recyclerView);
        this.g = recyclerView;
        recyclerView.n(new sq1(this.d, this));
    }
}
