package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.bean.UserBean;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.main.bean.ActiveBean;
import com.yunbao.main.bean.ActiveCommentBean;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class c4 extends ce3 {
    public Drawable i;
    public Drawable j;
    public int k;
    public int l;
    public ScaleAnimation m;
    public View.OnClickListener n;
    public View.OnLongClickListener o;
    public View.OnClickListener p;
    public View.OnClickListener q;
    public View.OnClickListener r;
    public View.OnClickListener s;
    public i t;
    public ImageView u;
    public int v;
    public ActiveCommentBean w;
    public HttpCallback x;
    public z3 y;
    public ActiveBean z;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag == null || c4.this.h == null) {
                return;
            }
            c4.this.h.onItemClick((ActiveCommentBean) tag, 0);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements View.OnLongClickListener {
        public b() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            Object tag;
            if (((AbsActivity) c4.this.d).e1() && (tag = view.getTag()) != null && c4.this.t != null) {
                c4.this.t.r0((ActiveCommentBean) tag);
            }
            return true;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c implements Animation.AnimationListener {
        public c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            if (c4.this.w == null || c4.this.u == null) {
                return;
            }
            ImageView imageView = c4.this.u;
            int isLike = c4.this.w.getIsLike();
            c4 c4Var = c4.this;
            imageView.setImageDrawable(isLike == 1 ? c4Var.i : c4Var.j);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d extends HttpCallback {
        public d() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length <= 0 || c4.this.w == null) {
                return;
            }
            JSONObject parseObject = JSON.parseObject(strArr[0]);
            int intValue = parseObject.getIntValue("islike");
            String string = parseObject.getString("likes");
            if (c4.this.w != null) {
                c4.this.w.setIsLike(intValue);
                c4.this.w.setLikeNum(string);
                c4 c4Var = c4.this;
                c4Var.r(c4Var.v, "payload");
            }
            if (c4.this.u == null || c4.this.m == null) {
                return;
            }
            c4.this.u.startAnimation(c4.this.m);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag;
            if (((AbsActivity) c4.this.d).e1() && (tag = view.getTag()) != null) {
                ActiveCommentBean activeCommentBean = (ActiveCommentBean) tag;
                String uid = activeCommentBean.getUid();
                if (!TextUtils.isEmpty(uid) && uid.equals(j30.q().C())) {
                    t54.a(m93.qa);
                    return;
                }
                c4.this.u = (ImageView) view;
                c4.this.v = activeCommentBean.getPosition();
                c4.this.w = activeCommentBean;
                db2.r0(activeCommentBean.getId(), c4.this.x);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag;
            if (!j10.a() || (tag = view.getTag()) == null || c4.this.t == null) {
                return;
            }
            c4.this.t.b0((ActiveCommentBean) tag);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag;
            if (!j10.a() || (tag = view.getTag()) == null || c4.this.t == null) {
                return;
            }
            c4.this.t.j((ActiveCommentBean) tag);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            pi3.q(c4.this.d, (String) view.getTag(c73.l));
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface i {
        void b0(ActiveCommentBean activeCommentBean);

        void j(ActiveCommentBean activeCommentBean);

        void r0(ActiveCommentBean activeCommentBean);
    }

    /* loaded from: /tmp/classes2.dex */
    public class j extends m {
        public View A;
        public View y;
        public View z;

        public j(View view) {
            super(view);
            this.y = view.findViewById(f73.n);
            this.z = view.findViewById(f73.j);
            this.A = view.findViewById(f73.h);
            this.z.setOnClickListener(c4.this.q);
            this.A.setOnClickListener(c4.this.r);
        }

        @Override // c4.m
        public void O(ActiveCommentBean activeCommentBean, Object obj) {
            super.O(activeCommentBean, obj);
            this.z.setTag(activeCommentBean);
            this.A.setTag(activeCommentBean);
            ActiveCommentBean parentNodeBean = activeCommentBean.getParentNodeBean();
            if (activeCommentBean.needShowExpand(parentNodeBean)) {
                if (this.y.getVisibility() != 0) {
                    this.y.setVisibility(0);
                }
                if (this.A.getVisibility() == 0) {
                    this.A.setVisibility(4);
                }
                if (this.z.getVisibility() != 0) {
                    this.z.setVisibility(0);
                    return;
                }
                return;
            }
            boolean needShowCollapsed = activeCommentBean.needShowCollapsed(parentNodeBean);
            View view = this.y;
            if (!needShowCollapsed) {
                if (view.getVisibility() == 0) {
                    this.y.setVisibility(8);
                    return;
                }
                return;
            }
            if (view.getVisibility() != 0) {
                this.y.setVisibility(0);
            }
            if (this.z.getVisibility() == 0) {
                this.z.setVisibility(4);
            }
            if (this.A.getVisibility() != 0) {
                this.A.setVisibility(0);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class k extends RecyclerView.e0 {
        public RecyclerView u;
        public View v;

        /* loaded from: /tmp/classes2.dex */
        public class a extends LinearLayoutManager {
            public final /* synthetic */ c4 I;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Context context, int i, boolean z, c4 c4Var) {
                super(context, i, z);
                this.I = c4Var;
            }

            public boolean A() {
                return false;
            }

            public boolean z() {
                return false;
            }
        }

        public k(View view) {
            super(view);
            RecyclerView findViewById = view.findViewById(c73.h4);
            this.u = findViewById;
            findViewById.setLayoutManager(new a(c4.this.d, 1, false, c4.this));
            this.v = view.findViewById(c73.R3);
        }

        public void O() {
            if (this.u.getAdapter() == null) {
                this.u.setAdapter(c4.this.y);
            } else {
                c4.this.y.p();
            }
            if (c4.this.e == null || c4.this.e.size() <= 0) {
                if (this.v.getVisibility() != 0) {
                    this.v.setVisibility(0);
                }
            } else if (this.v.getVisibility() != 8) {
                this.v.setVisibility(8);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class l extends m {
        public ImageView A;
        public ImageView y;
        public TextView z;

        public l(View view) {
            super(view);
            this.y = (ImageView) view.findViewById(f73.o);
            this.z = (TextView) view.findViewById(f73.E);
            this.y.setOnClickListener(c4.this.p);
            this.A = (ImageView) view.findViewById(f73.c);
        }

        @Override // c4.m
        public void O(ActiveCommentBean activeCommentBean, Object obj) {
            UserBean userBean;
            super.O(activeCommentBean, obj);
            if (obj == null && (userBean = activeCommentBean.getUserBean()) != null) {
                kn1.g(c4.this.d, userBean.getAvatar(), this.A);
            }
            this.y.setTag(activeCommentBean);
            boolean z = activeCommentBean.getIsLike() == 1;
            ImageView imageView = this.y;
            c4 c4Var = c4.this;
            imageView.setImageDrawable(z ? c4Var.i : c4Var.j);
            this.z.setText(activeCommentBean.getLikeNum());
            TextView textView = this.z;
            c4 c4Var2 = c4.this;
            textView.setTextColor(z ? c4Var2.k : c4Var2.l);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class m extends RecyclerView.e0 {
        public TextView u;
        public TextView v;
        public ImageView w;

        public m(View view) {
            super(view);
            this.u = (TextView) view.findViewById(f73.I);
            this.v = (TextView) view.findViewById(f73.v);
            ImageView imageView = (ImageView) view.findViewById(c73.l);
            this.w = imageView;
            if (imageView != null) {
                imageView.setOnClickListener(c4.this.s);
            }
            view.setOnClickListener(c4.this.n);
            view.setOnLongClickListener(c4.this.o);
        }

        public void O(ActiveCommentBean activeCommentBean, Object obj) {
            ((RecyclerView.e0) this).a.setTag(activeCommentBean);
            if (obj == null) {
                UserBean userBean = activeCommentBean.getUserBean();
                if (userBean != null) {
                    if (this.w != null) {
                        kn1.g(c4.this.d, userBean.getAvatar(), this.w);
                        this.w.setTag(c73.l, userBean.getId());
                    }
                    this.u.setText(userBean.getUserNiceName());
                }
                this.v.setText(iz0.c(activeCommentBean.getContent(), "  " + activeCommentBean.getDatetime()));
            }
        }
    }

    public c4(Context context, ActiveBean activeBean) {
        super(context);
        this.z = activeBean;
        ArrayList arrayList = new ArrayList();
        arrayList.add(activeBean);
        this.y = new z3(this.d, arrayList);
        this.n = new a();
        this.o = new b();
        this.i = o60.d(context, u83.h);
        this.j = o60.d(context, u83.c);
        this.k = o60.b(context, p53.k);
        this.l = o60.b(context, p53.i);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.5f, 1.0f, 0.5f, 1, 0.5f, 1, 0.5f);
        this.m = scaleAnimation;
        scaleAnimation.setDuration(200L);
        this.m.setRepeatCount(1);
        this.m.setRepeatMode(2);
        this.m.setAnimationListener(new c());
        this.x = new d();
        this.p = new e();
        this.q = new f();
        this.r = new g();
        this.s = new h();
    }

    public void A(RecyclerView.e0 e0Var, int i2, List list) {
        if (!(e0Var instanceof m)) {
            ((k) e0Var).O();
            return;
        }
        ActiveCommentBean w0 = w0(i2);
        if (w0 != null) {
            w0.setPosition(i2);
            ((m) e0Var).O(w0, list.size() > 0 ? list.get(0) : null);
        }
    }

    public void A0(int i2) {
        ActiveBean activeBean = this.z;
        if (activeBean != null) {
            activeBean.setCommentNum(i2);
        }
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i2) {
        if (i2 != -1) {
            return i2 == 1 ? new l(this.f.inflate(y73.j0, viewGroup, false)) : new j(this.f.inflate(y73.h0, viewGroup, false));
        }
        k kVar = new k(this.f.inflate(y73.i0, viewGroup, false));
        kVar.I(false);
        return kVar;
    }

    @Override // defpackage.ce3
    public int j() {
        int size = this.e.size();
        int i2 = 1;
        for (int i3 = 0; i3 < size; i3++) {
            i2++;
            List<ActiveCommentBean> childList = ((ActiveCommentBean) this.e.get(i3)).getChildList();
            if (childList != null) {
                i2 += childList.size();
            }
        }
        return i2;
    }

    public int l(int i2) {
        if (i2 == 0) {
            return -1;
        }
        ActiveCommentBean w0 = w0(i2);
        return (w0 == null || !w0.isParentNode()) ? 2 : 1;
    }

    public final ActiveCommentBean w0(int i2) {
        int size = this.e.size();
        int i3 = 1;
        for (int i4 = 0; i4 < size; i4++) {
            ActiveCommentBean activeCommentBean = (ActiveCommentBean) this.e.get(i4);
            if (i3 == i2) {
                return activeCommentBean;
            }
            i3++;
            List<ActiveCommentBean> childList = ((ActiveCommentBean) this.e.get(i4)).getChildList();
            if (childList != null) {
                int size2 = childList.size();
                for (int i5 = 0; i5 < size2; i5++) {
                    if (i2 == i3) {
                        return childList.get(i5);
                    }
                    i3++;
                }
            }
        }
        return null;
    }

    public void x0(int i2) {
        z3 z3Var = this.y;
        if (z3Var != null) {
            z3Var.Q0(this.z.getUid(), i2);
        }
    }

    public void y0() {
        z3 z3Var = this.y;
        if (z3Var != null) {
            z3Var.T0();
        }
    }

    public void z(RecyclerView.e0 e0Var, int i2) {
    }

    public void z0(i iVar) {
        this.t = iVar;
    }
}
