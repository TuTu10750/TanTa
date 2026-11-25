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
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yunbao.common.bean.UserBean;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.video.bean.VideoCommentBean;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class bh4 extends ce3 {
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
    public VideoCommentBean w;
    public HttpCallback x;
    public String y;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag == null || bh4.this.h == null) {
                return;
            }
            bh4.this.h.onItemClick((VideoCommentBean) tag, 0);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements View.OnLongClickListener {
        public b() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            Object tag = view.getTag();
            if (tag == null || bh4.this.t == null) {
                return true;
            }
            bh4.this.t.h((VideoCommentBean) tag);
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
            if (bh4.this.w == null || bh4.this.u == null) {
                return;
            }
            ImageView imageView = bh4.this.u;
            int isLike = bh4.this.w.getIsLike();
            bh4 bh4Var = bh4.this;
            imageView.setImageDrawable(isLike == 1 ? bh4Var.i : bh4Var.j);
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
            if (i != 0 || strArr.length <= 0 || bh4.this.w == null) {
                return;
            }
            JSONObject parseObject = JSON.parseObject(strArr[0]);
            int intValue = parseObject.getIntValue("islike");
            String string = parseObject.getString("likes");
            if (bh4.this.w != null) {
                bh4.this.w.setIsLike(intValue);
                bh4.this.w.setLikeNum(string);
                bh4 bh4Var = bh4.this;
                bh4Var.r(bh4Var.v, "payload");
            }
            if (bh4.this.u == null || bh4.this.m == null) {
                return;
            }
            bh4.this.u.startAnimation(bh4.this.m);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag == null) {
                return;
            }
            VideoCommentBean videoCommentBean = (VideoCommentBean) tag;
            String uid = videoCommentBean.getUid();
            if (!TextUtils.isEmpty(uid) && uid.equals(j30.q().C())) {
                t54.a(m93.qa);
                return;
            }
            bh4.this.u = (ImageView) view;
            bh4.this.v = videoCommentBean.getPosition();
            bh4.this.w = videoCommentBean;
            zh4.n(videoCommentBean.getId(), bh4.this.x);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag == null || bh4.this.t == null) {
                return;
            }
            bh4.this.t.J((VideoCommentBean) tag);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag == null || bh4.this.t == null) {
                return;
            }
            bh4.this.t.k((VideoCommentBean) tag);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            pi3.q(bh4.this.d, (String) view.getTag(f73.c));
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface i {
        void J(VideoCommentBean videoCommentBean);

        void h(VideoCommentBean videoCommentBean);

        void k(VideoCommentBean videoCommentBean);
    }

    /* loaded from: /tmp/classes2.dex */
    public class j extends l {
        public View A;
        public View B;
        public View z;

        public j(View view) {
            super(view);
            this.z = view.findViewById(f73.n);
            this.A = view.findViewById(f73.j);
            this.B = view.findViewById(f73.h);
            this.A.setOnClickListener(bh4.this.q);
            this.B.setOnClickListener(bh4.this.r);
        }

        @Override // bh4.l
        public void O(VideoCommentBean videoCommentBean, Object obj) {
            super.O(videoCommentBean, obj);
            this.A.setTag(videoCommentBean);
            this.B.setTag(videoCommentBean);
            VideoCommentBean parentNodeBean = videoCommentBean.getParentNodeBean();
            if (videoCommentBean.needShowExpand(parentNodeBean)) {
                if (this.z.getVisibility() != 0) {
                    this.z.setVisibility(0);
                }
                if (this.B.getVisibility() == 0) {
                    this.B.setVisibility(4);
                }
                if (this.A.getVisibility() != 0) {
                    this.A.setVisibility(0);
                    return;
                }
                return;
            }
            boolean needShowCollapsed = videoCommentBean.needShowCollapsed(parentNodeBean);
            View view = this.z;
            if (!needShowCollapsed) {
                if (view.getVisibility() == 0) {
                    this.z.setVisibility(8);
                    return;
                }
                return;
            }
            if (view.getVisibility() != 0) {
                this.z.setVisibility(0);
            }
            if (this.A.getVisibility() == 0) {
                this.A.setVisibility(4);
            }
            if (this.B.getVisibility() != 0) {
                this.B.setVisibility(0);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class k extends l {
        public TextView A;
        public ImageView z;

        public k(View view) {
            super(view);
            this.z = (ImageView) view.findViewById(f73.o);
            this.A = (TextView) view.findViewById(f73.E);
            this.z.setOnClickListener(bh4.this.p);
        }

        @Override // bh4.l
        public void O(VideoCommentBean videoCommentBean, Object obj) {
            super.O(videoCommentBean, obj);
            this.z.setTag(videoCommentBean);
            boolean z = videoCommentBean.getIsLike() == 1;
            ImageView imageView = this.z;
            bh4 bh4Var = bh4.this;
            imageView.setImageDrawable(z ? bh4Var.i : bh4Var.j);
            this.A.setText(videoCommentBean.getLikeNum());
            TextView textView = this.A;
            bh4 bh4Var2 = bh4.this;
            textView.setTextColor(z ? bh4Var2.k : bh4Var2.l);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class l extends RecyclerView.e0 {
        public TextView u;
        public TextView v;
        public ImageView w;
        public View x;

        public l(View view) {
            super(view);
            this.u = (TextView) view.findViewById(f73.I);
            this.v = (TextView) view.findViewById(f73.v);
            view.setOnClickListener(bh4.this.n);
            view.setOnLongClickListener(bh4.this.o);
            this.w = (ImageView) view.findViewById(f73.c);
            this.x = view.findViewById(f73.b);
            ImageView imageView = this.w;
            if (imageView != null) {
                imageView.setOnClickListener(bh4.this.s);
            }
        }

        public void O(VideoCommentBean videoCommentBean, Object obj) {
            ((RecyclerView.e0) this).a.setTag(videoCommentBean);
            if (obj == null) {
                UserBean userBean = videoCommentBean.getUserBean();
                if (userBean != null) {
                    if (this.w != null) {
                        kn1.g(bh4.this.d, userBean.getAvatar(), this.w);
                        this.w.setTag(f73.c, userBean.getId());
                    }
                    this.u.setText(userBean.getUserNiceName());
                }
                this.v.setText(iz0.c(videoCommentBean.getContent(), "  " + videoCommentBean.getDatetime()));
                if (TextUtils.isEmpty(bh4.this.y) || !bh4.this.y.equals(videoCommentBean.getUid())) {
                    if (this.x.getVisibility() == 0) {
                        this.x.setVisibility(4);
                    }
                } else if (this.x.getVisibility() != 0) {
                    this.x.setVisibility(0);
                }
            }
        }
    }

    public bh4(Context context) {
        super(context);
        this.n = new a();
        this.o = new b();
        this.i = o60.d(context, z53.b);
        this.j = o60.d(context, z53.a);
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
        VideoCommentBean q0 = q0(i2);
        if (q0 != null) {
            q0.setPosition(i2);
            Object obj = list.size() > 0 ? list.get(0) : null;
            if (e0Var instanceof k) {
                ((k) e0Var).O(q0, obj);
            } else if (e0Var instanceof j) {
                ((j) e0Var).O(q0, obj);
            }
        }
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i2) {
        return i2 == 1 ? new k(this.f.inflate(b83.j, viewGroup, false)) : new j(this.f.inflate(b83.i, viewGroup, false));
    }

    @Override // defpackage.ce3
    public int j() {
        int size = this.e.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2++;
            List<VideoCommentBean> childList = ((VideoCommentBean) this.e.get(i3)).getChildList();
            if (childList != null) {
                i2 += childList.size();
            }
        }
        return i2;
    }

    public int l(int i2) {
        VideoCommentBean q0 = q0(i2);
        return (q0 == null || !q0.isParentNode()) ? 2 : 1;
    }

    public final VideoCommentBean q0(int i2) {
        int size = this.e.size();
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            VideoCommentBean videoCommentBean = (VideoCommentBean) this.e.get(i4);
            if (i3 == i2) {
                return videoCommentBean;
            }
            i3++;
            List<VideoCommentBean> childList = ((VideoCommentBean) this.e.get(i4)).getChildList();
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

    public void r0(VideoCommentBean videoCommentBean, int i2) {
        RecyclerView recyclerView = this.g;
        if (recyclerView != null) {
            recyclerView.v1(videoCommentBean.getPosition());
        }
        u(videoCommentBean.getPosition(), j(), (Object) null);
    }

    public void s0(VideoCommentBean videoCommentBean, int i2) {
        RecyclerView recyclerView = this.g;
        if (recyclerView != null) {
            recyclerView.v1(videoCommentBean.getPosition());
        }
        u(videoCommentBean.getPosition(), j(), (Object) null);
    }

    public void t0(i iVar) {
        this.t = iVar;
    }

    public void u0(String str) {
        this.y = str;
    }

    public void z(RecyclerView.e0 e0Var, int i2) {
    }
}
