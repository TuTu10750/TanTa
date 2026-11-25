package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.l;
import com.yunbao.video.bean.VideoBean;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class xi4 extends RecyclerView.Adapter {
    public Context d;
    public List e;
    public int g;
    public b h;
    public RecyclerView j;
    public LinearLayoutManager k;
    public Drawable[] l;
    public Handler m;
    public SparseArray f = new SparseArray();
    public boolean i = true;

    /* loaded from: /tmp/classes2.dex */
    public class a extends RecyclerView.t {
        public a() {
        }

        public void a(RecyclerView recyclerView, int i) {
        }

        public void b(RecyclerView recyclerView, int i, int i2) {
            xi4.this.N();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface b {
        void e(fi4 fi4Var);

        void g(fi4 fi4Var, boolean z);
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends RecyclerView.e0 {
        public int u;
        public fi4 v;

        public c(fi4 fi4Var) {
            super(fi4Var.getContentView());
            this.v = fi4Var;
        }

        public void O() {
            if (this.v != null) {
                if (xi4.this.f != null && xi4.this.f.get(this.u) == this.v) {
                    xi4.this.f.remove(this.u);
                }
                this.v.release();
            }
        }

        public void P(VideoBean videoBean, int i, Object obj) {
            if (this.v != null) {
                xi4.this.f.put(i, this.v);
                this.v.U0(videoBean, obj);
            }
        }
    }

    public xi4(Context context, List list, int i) {
        this.d = context;
        this.e = list;
        this.g = i;
        List a2 = ai4.a();
        Drawable[] drawableArr = new Drawable[a2.size()];
        this.l = drawableArr;
        int length = drawableArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.l[i2] = o60.d(context, ((Integer) a2.get(i2)).intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        int h2 = this.k.h2();
        if (h2 < 0 || this.g == h2) {
            return;
        }
        Handler handler = this.m;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        fi4 fi4Var = (fi4) this.f.get(h2);
        if (fi4Var != null && this.h != null) {
            fi4Var.R0();
            boolean z = true;
            if (h2 == this.e.size() - 1) {
                if (this.e.size() < 20) {
                    t54.a(m93.xa);
                }
                this.h.g(fi4Var, z);
            }
            z = false;
            this.h.g(fi4Var, z);
        }
        this.g = h2;
        if (h2 == 0) {
            t54.a(m93.Ca);
        }
    }

    public void O(List list) {
        List list2;
        if (list == null || list.size() <= 0 || (list2 = this.e) == null || this.j == null) {
            return;
        }
        int size = list2.size();
        this.e.addAll(list);
        v(size, list.size());
    }

    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public void z(c cVar, int i) {
    }

    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public void A(c cVar, int i, List list) {
        boolean z = false;
        cVar.P((VideoBean) this.e.get(i), i, list.size() > 0 ? list.get(0) : null);
        cVar.u = i;
        if (this.i) {
            this.i = false;
            fi4 fi4Var = (fi4) this.f.get(this.g);
            if (fi4Var != null && this.h != null) {
                fi4Var.R0();
                b bVar = this.h;
                if (this.e.size() >= 20 && this.g == this.e.size() - 1) {
                    z = true;
                }
                bVar.g(fi4Var, z);
            }
        }
        Log.i("9527", "开始预加载");
    }

    public void R(String str, String str2) {
        if (this.e == null || TextUtils.isEmpty(str)) {
            return;
        }
        int size = this.e.size();
        for (int i = 0; i < size; i++) {
            VideoBean videoBean = (VideoBean) this.e.get(i);
            if (videoBean != null && str.equals(videoBean.getId())) {
                videoBean.setCommentNum(str2);
                r(i, "payload");
                return;
            }
        }
    }

    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public c B(ViewGroup viewGroup, int i) {
        fi4 fi4Var = new fi4(this.d, viewGroup);
        fi4Var.V0(this.l);
        return new c(fi4Var);
    }

    public void T(boolean z, String str, String str2, int i) {
        if (this.e == null || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        int size = this.e.size();
        for (int i2 = 0; i2 < size; i2++) {
            VideoBean videoBean = (VideoBean) this.e.get(i2);
            if (videoBean != null && ((!z || !str.equals(videoBean.getId())) && str2.equals(videoBean.getUid()))) {
                videoBean.setAttent(i);
                r(i2, "payload");
            }
        }
    }

    public void U(String str, int i, String str2) {
        if (this.e == null || TextUtils.isEmpty(str)) {
            return;
        }
        int size = this.e.size();
        for (int i2 = 0; i2 < size; i2++) {
            VideoBean videoBean = (VideoBean) this.e.get(i2);
            if (videoBean != null && str.equals(videoBean.getId())) {
                videoBean.setLike(i);
                videoBean.setLikeNum(str2);
                r(i2, "payload");
                return;
            }
        }
    }

    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public void E(c cVar) {
        fi4 fi4Var = cVar.v;
        if (fi4Var != null) {
            fi4Var.P0();
        }
    }

    /* renamed from: W, reason: merged with bridge method [inline-methods] */
    public void F(c cVar) {
        fi4 fi4Var = cVar.v;
        if (fi4Var != null) {
            fi4Var.Q0();
            b bVar = this.h;
            if (bVar != null) {
                bVar.e(fi4Var);
            }
        }
    }

    /* renamed from: X, reason: merged with bridge method [inline-methods] */
    public void G(c cVar) {
        cVar.O();
    }

    public void Y() {
        SparseArray sparseArray;
        this.h = null;
        Handler handler = this.m;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.m = null;
        pg4.s();
        SparseArray sparseArray2 = this.f;
        if (sparseArray2 != null) {
            int size = sparseArray2.size();
            int i = 0;
            while (true) {
                sparseArray = this.f;
                if (i >= size) {
                    break;
                }
                fi4 fi4Var = (fi4) sparseArray.valueAt(i);
                if (fi4Var != null) {
                    fi4Var.release();
                }
                i++;
            }
            sparseArray.clear();
        }
        RecyclerView recyclerView = this.j;
        if (recyclerView != null) {
            recyclerView.x();
        }
        this.j = null;
        this.k = null;
        this.l = null;
        this.d = null;
    }

    public void Z(b bVar) {
        this.h = bVar;
    }

    public int j() {
        return this.e.size();
    }

    public void y(RecyclerView recyclerView) {
        this.j = recyclerView;
        LinearLayoutManager layoutManager = recyclerView.getLayoutManager();
        this.k = layoutManager;
        layoutManager.N2(1);
        recyclerView.v1(this.g);
        new l().b(recyclerView);
        recyclerView.setOnScrollListener(new a());
    }
}
