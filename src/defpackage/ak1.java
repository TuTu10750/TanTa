package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.common.bean.LevelBean;
import com.yunbao.im.bean.ImConversationBean;
import com.yunbao.im.dao.IMDbHelper;
import com.yunbao.im.dao.IMUserBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class ak1 extends RecyclerView.Adapter {
    public Context d;
    public List e;
    public LayoutInflater f;
    public View.OnClickListener g;
    public View.OnClickListener h;
    public View.OnLongClickListener i;
    public f j;
    public View k;
    public IMDbHelper l;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null) {
                int intValue = ((Integer) tag).intValue();
                IMUserBean iMUserBean = (IMUserBean) ak1.this.e.get(intValue);
                lx1.c("9527", "onItemClick：" + iMUserBean.getUserNiceName());
                lx1.c("9527", "onItemClick：" + iMUserBean.getUserNiceName().isEmpty());
                lx1.c("9527", "onItemClick：" + iMUserBean.getUserID());
                lx1.c("9527", "onItemClick：" + iMUserBean.getLastMsgString());
                lx1.c("9527", "onItemClick：" + iMUserBean.getUnReadCount());
                if (iMUserBean.getUnReadCount() != 0) {
                    iMUserBean.setUnReadCount(0);
                    ak1.this.r(intValue, "payload");
                    ak1.this.X(iMUserBean);
                }
                if (ak1.this.j != null) {
                    ak1.this.j.b(iMUserBean);
                }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements View.OnLongClickListener {
        public b() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            Object tag = view.getTag();
            if (tag == null) {
                return false;
            }
            IMUserBean iMUserBean = (IMUserBean) ak1.this.e.get(((Integer) tag).intValue());
            if (ak1.this.j == null) {
                return false;
            }
            ak1.this.j.H(iMUserBean);
            return false;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null) {
                int intValue = ((Integer) tag).intValue();
                IMUserBean iMUserBean = (IMUserBean) ak1.this.e.get(intValue);
                ak1.this.a0(intValue);
                if (ak1.this.j != null) {
                    ak1.this.j.j(iMUserBean, ak1.this.e.size());
                }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d implements Comparator {
        public d() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(IMUserBean iMUserBean, IMUserBean iMUserBean2) {
            if ("goodsorder_admin".equals(iMUserBean.getId())) {
                return -1;
            }
            if ("goodsorder_admin".equals(iMUserBean2.getId())) {
                return 1;
            }
            return Long.compare(iMUserBean2.getLastMsgTime(), iMUserBean.getLastMsgTime());
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e implements Comparator {
        public e() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(IMUserBean iMUserBean, IMUserBean iMUserBean2) {
            if ("goodsorder_admin".equals(iMUserBean.getId())) {
                return -1;
            }
            if ("goodsorder_admin".equals(iMUserBean2.getId())) {
                return 1;
            }
            return (int) (iMUserBean2.getLastMsgTime() - iMUserBean.getLastMsgTime());
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface f {
        void H(IMUserBean iMUserBean);

        void b(IMUserBean iMUserBean);

        void j(IMUserBean iMUserBean, int i);
    }

    /* loaded from: /tmp/classes2.dex */
    public class g extends RecyclerView.e0 {
        public TextView A;
        public View B;
        public ImageView u;
        public TextView v;
        public ImageView w;
        public ImageView x;
        public TextView y;
        public TextView z;

        public g(View view) {
            super(view);
            this.u = (ImageView) view.findViewById(a73.c);
            this.v = (TextView) view.findViewById(a73.V);
            this.w = (ImageView) view.findViewById(a73.j0);
            this.x = (ImageView) view.findViewById(a73.Q);
            this.y = (TextView) view.findViewById(a73.U);
            this.z = (TextView) view.findViewById(a73.m0);
            this.A = (TextView) view.findViewById(a73.Z);
            this.B = view.findViewById(a73.x);
            view.setOnClickListener(ak1.this.g);
        }

        public void O(IMUserBean iMUserBean, int i, Object obj) {
            ((RecyclerView.e0) this).a.setTag(Integer.valueOf(i));
            if (obj == null) {
                kn1.g(ak1.this.d, iMUserBean.getAvatar(), this.u);
                this.v.setText(iMUserBean.getUserNiceName());
                this.w.setImageResource(l30.b(iMUserBean.getSex()));
                LevelBean s = j30.q().s(iMUserBean.getLevel());
                if (s != null) {
                    kn1.f(ak1.this.d, s.getThumb(), this.x);
                }
            }
            this.y.setText(iMUserBean.getLastMsgString());
            if (iMUserBean.getUserID().isEmpty()) {
                this.z.setText((CharSequence) null);
                if (this.A.getVisibility() == 0) {
                    this.A.setVisibility(4);
                }
                if (this.B.getVisibility() != 0) {
                    this.B.setVisibility(0);
                    return;
                }
                return;
            }
            if (this.B.getVisibility() == 0) {
                this.B.setVisibility(4);
            }
            if (iMUserBean.getLastMsgTimeString() != null) {
                this.z.setText(iMUserBean.getLastMsgTimeString());
            }
            int unReadCount = iMUserBean.getUnReadCount();
            TextView textView = this.A;
            if (unReadCount > 0) {
                if (textView.getVisibility() != 0) {
                    this.A.setVisibility(0);
                }
                this.A.setText(String.valueOf(iMUserBean.getUnReadCount()));
            } else if (textView.getVisibility() == 0) {
                this.A.setVisibility(4);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class h extends RecyclerView.e0 {
        public h(View view) {
            super(view);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class i extends RecyclerView.e0 {
        public View A;
        public TextView B;
        public ImageView u;
        public TextView v;
        public ImageView w;
        public ImageView x;
        public TextView y;
        public TextView z;

        public i(View view) {
            super(view);
            this.u = (ImageView) view.findViewById(a73.c);
            this.v = (TextView) view.findViewById(a73.V);
            this.w = (ImageView) view.findViewById(a73.j0);
            this.x = (ImageView) view.findViewById(a73.Q);
            this.y = (TextView) view.findViewById(a73.U);
            this.z = (TextView) view.findViewById(a73.m0);
            this.B = (TextView) view.findViewById(a73.Z);
            this.A = view.findViewById(a73.p);
            view.setOnClickListener(ak1.this.g);
            view.setOnLongClickListener(ak1.this.i);
            this.A.setOnClickListener(ak1.this.h);
        }

        public void O(IMUserBean iMUserBean, int i, Object obj) {
            ((RecyclerView.e0) this).a.setTag(Integer.valueOf(i));
            this.A.setTag(Integer.valueOf(i));
            if (obj == null) {
                kn1.g(ak1.this.d, iMUserBean.getAvatar(), this.u);
                this.v.setText(iMUserBean.getUserNiceName());
                boolean equals = "goodsorder_admin".equals(iMUserBean.getId());
                ImageView imageView = this.w;
                if (equals) {
                    imageView.setImageDrawable(null);
                    this.x.setImageDrawable(null);
                } else {
                    imageView.setImageResource(l30.b(iMUserBean.getSex()));
                    LevelBean s = j30.q().s(iMUserBean.getLevel());
                    if (s != null) {
                        kn1.f(ak1.this.d, s.getThumb(), this.x);
                    }
                }
            }
            this.y.setText(iMUserBean.getLastMsgString());
            if (iMUserBean.getLastMsgTimeString() != null) {
                this.z.setText(iMUserBean.getLastMsgTimeString());
            }
            int unReadCount = iMUserBean.getUnReadCount();
            TextView textView = this.B;
            if (unReadCount > 0) {
                if (textView.getVisibility() != 0) {
                    this.B.setVisibility(0);
                }
                this.B.setText(String.valueOf(iMUserBean.getUnReadCount()));
            } else if (textView.getVisibility() == 0) {
                this.B.setVisibility(4);
            }
        }
    }

    public ak1(Context context) {
        this.d = context;
        ArrayList arrayList = new ArrayList();
        this.e = arrayList;
        arrayList.add(IMUserBean.INSTANCE.a());
        LayoutInflater from = LayoutInflater.from(context);
        this.f = from;
        View inflate = from.inflate(w73.t, (ViewGroup) null, false);
        this.k = inflate;
        inflate.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.g = new a();
        this.i = new b();
        this.h = new c();
    }

    public static /* synthetic */ qc4 L(Boolean bool) {
        if (bool.booleanValue()) {
            lx1.c("9999", "22user单个插入成功");
            return null;
        }
        lx1.c("9999", "22user单个插入失败");
        return null;
    }

    public static /* synthetic */ qc4 M(Boolean bool) {
        if (bool.booleanValue()) {
            lx1.c("9999", "33user单个插入成功");
            return null;
        }
        lx1.c("9999", "33user单个插入失败");
        return null;
    }

    public void A(RecyclerView.e0 e0Var, int i2, List list) {
        Object obj = list.size() > 0 ? list.get(0) : null;
        if (e0Var instanceof i) {
            ((i) e0Var).O((IMUserBean) this.e.get(i2), i2, obj);
        } else if (e0Var instanceof g) {
            ((g) e0Var).O((IMUserBean) this.e.get(i2), i2, obj);
        }
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i2) {
        if (i2 != -1) {
            return i2 == -2 ? new g(this.f.inflate(w73.s, viewGroup, false)) : new i(this.f.inflate(w73.r, viewGroup, false));
        }
        ViewParent parent = this.k.getParent();
        if (parent != null) {
            ((ViewGroup) parent).removeView(this.k);
        }
        h hVar = new h(this.k);
        hVar.I(false);
        return hVar;
    }

    public View U() {
        return this.k;
    }

    public int V(String str) {
        int size = this.e.size();
        for (int i2 = 1; i2 < size; i2++) {
            if (((IMUserBean) this.e.get(i2)).getId().equals(str)) {
                return i2;
            }
        }
        return -1;
    }

    public final void W(IMUserBean iMUserBean) {
        if (this.l == null) {
            this.l = IMDbHelper.f.a(this.d);
        }
        this.l.l(iMUserBean, new n81() { // from class: zj1
            @Override // defpackage.n81
            public final Object invoke(Object obj) {
                return ak1.M((Boolean) obj);
            }
        });
    }

    public final void X(IMUserBean iMUserBean) {
        if (this.l == null) {
            this.l = IMDbHelper.f.a(this.d);
        }
        this.l.m(iMUserBean, new n81() { // from class: yj1
            @Override // defpackage.n81
            public final Object invoke(Object obj) {
                return ak1.L((Boolean) obj);
            }
        });
    }

    public void Y(IMUserBean iMUserBean) {
        lx1.c("9999", "新增聊天记录");
        boolean equals = "goodsorder_admin".equals(iMUserBean.getId());
        List list = this.e;
        if (equals) {
            list.add(iMUserBean);
            Collections.sort(this.e, new e());
            p();
        } else {
            list.size();
            this.e.add(1, iMUserBean);
            p();
        }
    }

    public void Z(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        int size = this.e.size();
        for (int i2 = 0; i2 < size; i2++) {
            IMUserBean iMUserBean = (IMUserBean) this.e.get(i2);
            if (str2.equals(iMUserBean.getId())) {
                if (iMUserBean.getLastMsgId().equals(str)) {
                    iMUserBean.setTips(aq4.a(z ? m93.k1 : m93.l1));
                    r(i2, "payload");
                    return;
                }
                return;
            }
        }
    }

    public void a0(int i2) {
        this.e.remove(i2);
        x(i2);
        t(i2, this.e.size());
    }

    public void b0(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < this.e.size(); i2++) {
            if (((IMUserBean) this.e.get(i2)).getUserID().equals(str)) {
                this.e.remove(i2);
                x(i2);
                t(i2, this.e.size());
                return;
            }
        }
    }

    public void c0() {
        List list = this.e;
        if (list == null || list.size() <= 0) {
            return;
        }
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            ((IMUserBean) it.next()).setUnReadCount(0);
        }
        p();
    }

    public void d0(f fVar) {
        this.j = fVar;
    }

    public void e0(String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        for (IMUserBean iMUserBean : this.e) {
            if (str.equals(iMUserBean.getId())) {
                iMUserBean.setAttent(i2);
                return;
            }
        }
    }

    public void f0(List list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.e.clear();
        this.e.add(IMUserBean.INSTANCE.a());
        this.e.addAll(list);
        p();
    }

    public void g0(ImConversationBean imConversationBean, int i2) {
        if (i2 < 0 || i2 >= this.e.size()) {
            return;
        }
        IMUserBean iMUserBean = (IMUserBean) this.e.get(i2);
        lx1.c("9999", "old time:" + iMUserBean.getLastMsgTime() + "\nnew time:" + imConversationBean.getLastMsgTime());
        if (iMUserBean.getLastMsgTimeFormat() < imConversationBean.getLastMsgTimeFormat()) {
            iMUserBean.setConBean(imConversationBean);
            IMUserBean iMUserBean2 = (IMUserBean) this.e.get(0);
            this.e.remove(0);
            Collections.sort(this.e, new d());
            this.e.add(0, iMUserBean2);
            p();
            W(iMUserBean);
        }
    }

    public void h0(String str) {
        for (int i2 = 0; i2 < this.e.size(); i2++) {
            IMUserBean iMUserBean = (IMUserBean) this.e.get(i2);
            if (iMUserBean.getUserID().equals(str)) {
                iMUserBean.setUnReadCount(0);
                r(i2, "payload");
                X(iMUserBean);
            }
        }
    }

    public int j() {
        return this.e.size();
    }

    public int l(int i2) {
        if (i2 == 0) {
            return -1;
        }
        return ((IMUserBean) this.e.get(i2)).getAnchorItem() ? -2 : 0;
    }

    public void z(RecyclerView.e0 e0Var, int i2) {
    }
}
