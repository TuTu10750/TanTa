package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.bean.UserBean;
import com.yunbao.common.custom.CommonRefreshView;
import com.yunbao.common.custom.InterceptFrameLayout;
import com.yunbao.common.custom.MyLinearLayout3;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.common.utils.a;
import com.yunbao.video.activity.AtFriendActivity;
import com.yunbao.video.bean.VideoCommentBean;
import com.yunbao.video.custom.AtEditText;
import defpackage.bh4;
import defpackage.gp1;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class dh4 extends b1 implements View.OnClickListener, et2, bh4.i {
    public View a;
    public MyLinearLayout3 b;
    public CommonRefreshView c;
    public TextView d;
    public bh4 e;
    public String f;
    public String g;
    public String h;
    public ObjectAnimator i;
    public ObjectAnimator j;
    public boolean k;
    public boolean l;
    public gp1 m;
    public VideoCommentBean n;
    public boolean o;
    public AtEditText p;

    /* loaded from: /tmp/classes2.dex */
    public class a extends HttpCallback {
        public final /* synthetic */ VideoCommentBean a;
        public final /* synthetic */ VideoCommentBean b;

        public a(VideoCommentBean videoCommentBean, VideoCommentBean videoCommentBean2) {
            this.a = videoCommentBean;
            this.b = videoCommentBean2;
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            List parseArray;
            if (i != 0 || (parseArray = JSON.parseArray(Arrays.toString(strArr), VideoCommentBean.class)) == null || parseArray.size() == 0) {
                return;
            }
            if (this.a.getChildPage() == 1 && parseArray.size() > 1) {
                parseArray = parseArray.subList(1, parseArray.size());
            }
            Iterator it = parseArray.iterator();
            while (it.hasNext()) {
                ((VideoCommentBean) it.next()).setParentNodeBean(this.a);
            }
            List<VideoCommentBean> childList = this.a.getChildList();
            if (childList != null) {
                childList.addAll(parseArray);
                if (childList.size() < this.a.getReplyNum()) {
                    VideoCommentBean videoCommentBean = this.a;
                    videoCommentBean.setChildPage(videoCommentBean.getChildPage() + 1);
                }
                if (dh4.this.e != null) {
                    dh4.this.e.r0(this.b, parseArray.size());
                }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements a.n {
        public final /* synthetic */ VideoCommentBean a;

        /* loaded from: /tmp/classes2.dex */
        public class a extends HttpCallback {
            public a() {
            }

            @Override // com.yunbao.common.http.HttpCallback
            public void onSuccess(int i, String str, String[] strArr) {
                if (i == 0 && dh4.this.c != null) {
                    dh4.this.c.k();
                }
                t54.b(str);
            }
        }

        public b(VideoCommentBean videoCommentBean) {
            this.a = videoCommentBean;
        }

        @Override // com.yunbao.common.utils.a.n
        public void a(String str, int i) {
            if (i != m93.s1) {
                if (i == m93.z1) {
                    zh4.b(this.a.getVideoId(), this.a.getId(), this.a.getUid(), new a());
                }
            } else {
                UserBean userBean = this.a.getUserBean();
                if (userBean != null) {
                    ((ClipboardManager) dh4.this.mContext.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text", rv3.a("@", userBean.getUserNiceName(), ": ", this.a.getContent())));
                    t54.a(m93.u1);
                }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends AnimatorListenerAdapter {
        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            dh4.this.k = false;
            ObjectAnimator objectAnimator = dh4.this.j;
            dh4 dh4Var = dh4.this;
            if (animator == objectAnimator) {
                if (dh4Var.a == null || dh4.this.a.getVisibility() != 0) {
                    return;
                }
                dh4.this.a.setVisibility(4);
                return;
            }
            if (animator == dh4Var.i && dh4.this.l) {
                dh4.this.l = false;
                if (dh4.this.c != null) {
                    dh4.this.c.k();
                }
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            dh4.this.k = true;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d extends LinearLayoutManager {
        public d(Context context, int i, boolean z) {
            super(context, i, z);
        }

        public void i1(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
            try {
                super.i1(vVar, a0Var);
            } catch (Exception e) {
                lx1.b("onLayoutChildren------>" + e.getMessage());
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e implements CommonRefreshView.e {
        public e() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public ce3 getAdapter() {
            if (dh4.this.e == null) {
                dh4 dh4Var = dh4.this;
                dh4Var.e = new bh4(dh4Var.mContext);
                dh4.this.e.u0(dh4.this.g);
                dh4.this.e.R(dh4.this);
                dh4.this.e.t0(dh4.this);
            }
            return dh4.this.e;
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void loadData(int i, HttpCallback httpCallback) {
            if (TextUtils.isEmpty(dh4.this.f)) {
                return;
            }
            zh4.i(dh4.this.f, i, httpCallback);
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void onLoadMoreFailure() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void onLoadMoreSuccess(List list, int i) {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void onRefreshFailure() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void onRefreshSuccess(List list, int i) {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public List processData(String[] strArr) {
            JSONObject parseObject = JSON.parseObject(strArr[0]);
            String string = parseObject.getString("comments");
            zu0.c().j(new ch4(dh4.this.f, string));
            if (dh4.this.d != null) {
                dh4.this.d.setText(rv3.a(string, " ", dh4.this.h));
            }
            List<VideoCommentBean> parseArray = JSON.parseArray(parseObject.getString("commentlist"), VideoCommentBean.class);
            for (VideoCommentBean videoCommentBean : parseArray) {
                if (videoCommentBean != null) {
                    videoCommentBean.setParentNode(true);
                }
            }
            return parseArray;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class f extends gp1.g {
        public f() {
        }

        @Override // gp1.g
        public void a(String str) {
            dh4.this.F0(str);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            dh4.this.B0();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class h implements AtEditText.c {
        public h() {
        }

        @Override // com.yunbao.video.custom.AtEditText.c
        public void a() {
            t54.a(m93.la);
        }

        @Override // com.yunbao.video.custom.AtEditText.c
        public void b() {
            dh4.this.B0();
        }

        @Override // com.yunbao.video.custom.AtEditText.c
        public void c() {
            t54.a(m93.ma);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class i implements InterceptFrameLayout.a {
        public i() {
        }

        @Override // com.yunbao.common.custom.InterceptFrameLayout.a
        public boolean a() {
            if (dh4.this.m == null) {
                return false;
            }
            boolean B0 = dh4.this.m.B0();
            if (B0 && !dh4.this.o) {
                dh4.this.C0();
            }
            return B0;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class j extends s4 {
        public j() {
        }

        @Override // defpackage.s4
        public void c(Intent intent) {
            UserBean userBean;
            if (intent == null || (userBean = (UserBean) intent.getParcelableExtra("userBean")) == null || dh4.this.p == null) {
                return;
            }
            dh4.this.p.g(userBean.getId(), userBean.getUserNiceName());
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class k extends HttpCallback {
        public k() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public Dialog createLoadingDialog() {
            return com.yunbao.common.utils.a.c(dh4.this.mContext);
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0) {
                t54.b(str);
                return;
            }
            if (strArr.length > 0) {
                zu0.c().j(new ch4(dh4.this.f, JSON.parseObject(strArr[0]).getString("comments")));
                t54.b(str);
                if (dh4.this.m != null) {
                    dh4.this.m.B0();
                    dh4.this.m.t0();
                    dh4.this.m.G0();
                }
                dh4.this.n = null;
                dh4.this.l = true;
                dh4.this.C0();
            }
        }

        @Override // com.yunbao.common.http.HttpCallback
        public boolean showLoadingDialog() {
            return true;
        }
    }

    public dh4(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0() {
        this.m.A0();
        A0();
    }

    public void A0() {
        b5.a((AbsActivity) this.mContext, new Intent(this.mContext, (Class<?>) AtFriendActivity.class), new j());
    }

    public final void C0() {
        ObjectAnimator objectAnimator;
        if (this.o) {
            if (this.k || (objectAnimator = this.j) == null) {
                return;
            }
            objectAnimator.start();
            return;
        }
        View view = this.a;
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        this.a.setVisibility(4);
    }

    @Override // defpackage.et2
    /* renamed from: D0, reason: merged with bridge method [inline-methods] */
    public void onItemClick(VideoCommentBean videoCommentBean, int i2) {
        UserBean userBean;
        if (videoCommentBean != null && !TextUtils.isEmpty(videoCommentBean.getUid()) && videoCommentBean.getUid().equals(j30.q().C())) {
            t54.a(m93.na);
            return;
        }
        this.n = videoCommentBean;
        if (this.m != null) {
            if (videoCommentBean != null && (userBean = videoCommentBean.getUserBean()) != null) {
                this.m.H0(rv3.a(aq4.a(m93.sa), userBean.getUserNiceName()));
            }
            this.m.K0();
        }
    }

    public void E0(int i2) {
        gp1 gp1Var = this.m;
        if (gp1Var != null) {
            gp1Var.E0(i2);
        }
    }

    public final void F0(String str) {
        String str2;
        String str3;
        if (TextUtils.isEmpty(this.f) || TextUtils.isEmpty(this.g)) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            t54.a(m93.r1);
            return;
        }
        String str4 = this.g;
        VideoCommentBean videoCommentBean = this.n;
        if (videoCommentBean != null) {
            str4 = videoCommentBean.getUid();
            str2 = this.n.getCommentId();
            str3 = this.n.getId();
        } else {
            str2 = "0";
            str3 = str2;
        }
        String str5 = str4;
        zh4.m(str5, this.f, str, str2, str3, this.p.getAtUserInfo(), new k());
    }

    public void G0(String str, String str2) {
        bh4 bh4Var;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (!TextUtils.isEmpty(this.f) && !this.f.equals(str) && (bh4Var = this.e) != null) {
            bh4Var.M();
            this.e.u0(str2);
        }
        if (!str.equals(this.f)) {
            this.l = true;
        }
        this.f = str;
        this.g = str2;
    }

    public void H0(boolean z, boolean z2, boolean z3) {
        ObjectAnimator objectAnimator;
        this.o = z;
        View view = this.a;
        if (z) {
            if (view != null && view.getVisibility() != 0) {
                this.a.setVisibility(0);
            }
            MyLinearLayout3 myLinearLayout3 = this.b;
            if (myLinearLayout3 != null && myLinearLayout3.getVisibility() != 0) {
                this.b.setVisibility(0);
            }
            if (!this.k && (objectAnimator = this.i) != null) {
                objectAnimator.start();
            }
        } else {
            if (view != null && view.getVisibility() != 0) {
                this.a.setVisibility(0);
            }
            MyLinearLayout3 myLinearLayout32 = this.b;
            if (myLinearLayout32 != null && myLinearLayout32.getVisibility() == 0) {
                this.b.setVisibility(4);
            }
        }
        this.n = null;
        gp1 gp1Var = this.m;
        if (gp1Var != null) {
            gp1Var.t0();
            this.m.G0();
            if (z) {
                return;
            }
            if (z2) {
                this.m.J0();
            } else if (z3) {
                this.m.K0();
            }
        }
    }

    @Override // bh4.i
    public void J(VideoCommentBean videoCommentBean) {
        VideoCommentBean parentNodeBean = videoCommentBean.getParentNodeBean();
        if (parentNodeBean == null) {
            return;
        }
        zh4.e(parentNodeBean.getId(), parentNodeBean.getChildPage(), new a(parentNodeBean, videoCommentBean));
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return b83.u;
    }

    @Override // bh4.i
    public void h(VideoCommentBean videoCommentBean) {
        String C = j30.q().C();
        boolean z = !TextUtils.isEmpty(this.g) && this.g.equals(C);
        String uid = videoCommentBean.getUid();
        com.yunbao.common.utils.a.r(this.mContext, (z || (!TextUtils.isEmpty(uid) && uid.equals(C))) ? new Integer[]{Integer.valueOf(m93.s1), Integer.valueOf(m93.z1)} : new Integer[]{Integer.valueOf(m93.s1)}, new b(videoCommentBean));
    }

    @Override // defpackage.b1
    public void init() {
        this.a = findViewById(f73.Q);
        MyLinearLayout3 myLinearLayout3 = (MyLinearLayout3) findViewById(f73.d);
        this.b = myLinearLayout3;
        float height2 = myLinearLayout3.getHeight2();
        this.b.setTranslationY(height2);
        this.i = ObjectAnimator.ofFloat(this.b, "translationY", 0.0f);
        this.j = ObjectAnimator.ofFloat(this.b, "translationY", height2);
        this.i.setDuration(200L);
        this.j.setDuration(200L);
        AccelerateDecelerateInterpolator accelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
        this.i.setInterpolator(accelerateDecelerateInterpolator);
        this.j.setInterpolator(accelerateDecelerateInterpolator);
        c cVar = new c();
        this.i.addListener(cVar);
        this.j.addListener(cVar);
        findViewById(f73.Q).setOnClickListener(this);
        findViewById(f73.g).setOnClickListener(this);
        this.h = aq4.a(m93.pa);
        this.d = (TextView) findViewById(f73.t);
        CommonRefreshView commonRefreshView = (CommonRefreshView) findViewById(f73.N);
        this.c = commonRefreshView;
        commonRefreshView.setEmptyLayoutId(b83.s);
        this.c.setLayoutManager(new d(this.mContext, 1, false));
        this.c.setDataHelper(new e());
        gp1 gp1Var = new gp1(this.mContext, (ViewGroup) findViewById(f73.C), Boolean.FALSE, Integer.valueOf(b83.r), Integer.valueOf(u73.S));
        this.m = gp1Var;
        gp1Var.addToParent();
        this.m.F0(new f());
        this.m.I0(f73.e, new g());
        Object y0 = this.m.y0();
        if (y0 instanceof AtEditText) {
            AtEditText atEditText = (AtEditText) y0;
            this.p = atEditText;
            atEditText.setActionListener(new h());
        }
        ((InterceptFrameLayout) findViewById(f73.z)).setOnInterceptListener(new i());
    }

    @Override // bh4.i
    public void k(VideoCommentBean videoCommentBean) {
        VideoCommentBean parentNodeBean = videoCommentBean.getParentNodeBean();
        if (parentNodeBean == null) {
            return;
        }
        List<VideoCommentBean> childList = parentNodeBean.getChildList();
        VideoCommentBean videoCommentBean2 = childList.get(0);
        int size = childList.size();
        parentNodeBean.removeChild();
        parentNodeBean.setChildPage(1);
        bh4 bh4Var = this.e;
        if (bh4Var != null) {
            bh4Var.s0(videoCommentBean2, size - childList.size());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == f73.Q || id == f73.g) {
            C0();
        }
    }

    @Override // defpackage.b1
    public void release() {
        ObjectAnimator objectAnimator = this.i;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        this.i = null;
        ObjectAnimator objectAnimator2 = this.j;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
        }
        this.j = null;
        zh4.a("getVideoCommentList");
        zh4.a("setCommentLike");
        zh4.a("getCommentReply");
        zh4.a("setComment");
        zh4.a("deleteComment");
    }

    public boolean z0() {
        gp1 gp1Var = this.m;
        return gp1Var == null || !gp1Var.B0();
    }
}
