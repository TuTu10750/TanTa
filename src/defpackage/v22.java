package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.common.bean.LiveGiftBean;
import defpackage.j22;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class v22 extends xv2 {
    public Context c;
    public b f;
    public int g;
    public int e = -1;
    public List d = new ArrayList();

    /* loaded from: /tmp/classes2.dex */
    public class a implements j22.b {
        public a() {
        }

        @Override // j22.b
        public void c(LiveGiftBean liveGiftBean) {
            v22.this.e = liveGiftBean.getPage();
            if (v22.this.f != null) {
                v22.this.f.c(liveGiftBean);
            }
        }

        @Override // j22.b
        public void onCancel() {
            j22 j22Var;
            if (v22.this.e < 0 || v22.this.e >= v22.this.d.size() || (j22Var = (j22) ((RecyclerView) v22.this.d.get(v22.this.e)).getAdapter()) == null) {
                return;
            }
            j22Var.b0();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface b {
        void c(LiveGiftBean liveGiftBean);
    }

    public v22(Context context, List list, int i) {
        this.c = context;
        this.g = i;
        int size = list.size();
        int i2 = size / 8;
        i2 = size % 8 > 0 ? i2 + 1 : i2;
        LayoutInflater from = LayoutInflater.from(context);
        String g = j30.q().g();
        a aVar = new a();
        int i3 = 0;
        int i4 = 0;
        while (i4 < i2) {
            RecyclerView inflate = from.inflate(x73.B1, (ViewGroup) null, false);
            inflate.setHasFixedSize(true);
            inflate.setLayoutManager(new GridLayoutManager(context, 4, 1, false));
            int i5 = i3 + 8;
            int i6 = i5 > size ? size : i5;
            ArrayList arrayList = new ArrayList();
            while (i3 < i6) {
                LiveGiftBean liveGiftBean = (LiveGiftBean) list.get(i3);
                liveGiftBean.setPage(i4);
                arrayList.add(liveGiftBean);
                i3++;
            }
            j22 j22Var = new j22(this.c, from, arrayList, g, this.g);
            j22Var.g0(aVar);
            inflate.setAdapter(j22Var);
            this.d.add(inflate);
            i4++;
            i3 = i6;
        }
    }

    public void a(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) this.d.get(i));
    }

    public int d() {
        return this.d.size();
    }

    public Object h(ViewGroup viewGroup, int i) {
        View view = (View) this.d.get(i);
        viewGroup.addView(view);
        return view;
    }

    public boolean i(View view, Object obj) {
        return view == obj;
    }

    public void w(int i, int i2) {
        List list;
        if (this.g == 2 && (list = this.d) != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                j22 j22Var = (j22) ((RecyclerView) it.next()).getAdapter();
                if (j22Var != null && j22Var.f0(i, i2)) {
                    return;
                }
            }
        }
    }

    public void x(b bVar) {
        this.f = bVar;
    }
}
