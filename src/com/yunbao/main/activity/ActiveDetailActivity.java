package com.yunbao.main.activity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.bean.UserBean;
import com.yunbao.common.custom.CommonRefreshView;
import com.yunbao.common.custom.InterceptFrameLayout;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.common.utils.a;
import com.yunbao.main.bean.ActiveBean;
import com.yunbao.main.bean.ActiveCommentBean;
import defpackage.aq4;
import defpackage.c4;
import defpackage.c73;
import defpackage.ce3;
import defpackage.d4;
import defpackage.db2;
import defpackage.et2;
import defpackage.gp1;
import defpackage.j30;
import defpackage.m93;
import defpackage.pw3;
import defpackage.q41;
import defpackage.rv3;
import defpackage.t54;
import defpackage.u73;
import defpackage.uw1;
import defpackage.vq2;
import defpackage.y73;
import defpackage.zu0;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: /tmp/classes2.dex */
public class ActiveDetailActivity extends AbsActivity implements c4.i, et2, uw1.c {
    public CommonRefreshView e;
    public c4 f;
    public ActiveBean g;
    public ActiveCommentBean h;
    public gp1 i;
    public uw1 j;
    public String k;

    /* loaded from: /tmp/classes2.dex */
    public class a extends gp1.g {
        public a() {
        }

        @Override // gp1.g
        public void a(String str) {
            ActiveDetailActivity.this.K1(str);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements InterceptFrameLayout.a {
        public b() {
        }

        @Override // com.yunbao.common.custom.InterceptFrameLayout.a
        public boolean a() {
            if (ActiveDetailActivity.this.i != null) {
                return ActiveDetailActivity.this.i.B0();
            }
            return false;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ActiveDetailActivity.this.e1();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d extends HttpCallback {
        public d() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length <= 0) {
                return;
            }
            JSONObject parseObject = JSON.parseObject(strArr[0]);
            ActiveDetailActivity.this.g = (ActiveBean) JSON.toJavaObject(parseObject, ActiveBean.class);
            ActiveDetailActivity.this.I1();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e implements CommonRefreshView.e {
        public e() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public ce3 getAdapter() {
            ActiveDetailActivity activeDetailActivity = ActiveDetailActivity.this;
            activeDetailActivity.f = new c4(activeDetailActivity.b, ActiveDetailActivity.this.g);
            ActiveDetailActivity.this.f.R(ActiveDetailActivity.this);
            ActiveDetailActivity.this.f.z0(ActiveDetailActivity.this);
            return ActiveDetailActivity.this.f;
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void loadData(int i, HttpCallback httpCallback) {
            if (ActiveDetailActivity.this.g != null) {
                db2.v(ActiveDetailActivity.this.g.getId(), i, httpCallback);
            }
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
            if (ActiveDetailActivity.this.i != null) {
                ActiveDetailActivity.this.i.t0();
                ActiveDetailActivity.this.i.G0();
            }
            ActiveDetailActivity.this.h = null;
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public List processData(String[] strArr) {
            JSONObject parseObject = JSON.parseObject(strArr[0]);
            if (ActiveDetailActivity.this.f != null) {
                ActiveDetailActivity.this.f.A0(parseObject.getIntValue("comments"));
            }
            List<ActiveCommentBean> parseArray = JSON.parseArray(parseObject.getString("commentlist"), ActiveCommentBean.class);
            for (ActiveCommentBean activeCommentBean : parseArray) {
                if (activeCommentBean != null) {
                    activeCommentBean.setParentNode(true);
                }
            }
            return parseArray;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class f extends HttpCallback {
        public f() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0) {
                t54.b(str);
                return;
            }
            if (strArr.length > 0) {
                zu0.c().j(new d4(ActiveDetailActivity.this.g.getId(), JSON.parseObject(strArr[0]).getIntValue("comments")));
                t54.b(str);
                if (ActiveDetailActivity.this.i != null) {
                    ActiveDetailActivity.this.i.B0();
                    ActiveDetailActivity.this.i.t0();
                    ActiveDetailActivity.this.i.G0();
                }
                ActiveDetailActivity.this.h = null;
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class g extends HttpCallback {
        public final /* synthetic */ ActiveCommentBean a;

        public g(ActiveCommentBean activeCommentBean) {
            this.a = activeCommentBean;
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            List parseArray;
            if (i != 0 || (parseArray = JSON.parseArray(Arrays.toString(strArr), ActiveCommentBean.class)) == null || parseArray.size() == 0) {
                return;
            }
            if (this.a.getChildPage() == 1 && parseArray.size() > 1) {
                parseArray = parseArray.subList(1, parseArray.size());
            }
            Iterator it = parseArray.iterator();
            while (it.hasNext()) {
                ((ActiveCommentBean) it.next()).setParentNodeBean(this.a);
            }
            List<ActiveCommentBean> childList = this.a.getChildList();
            if (childList != null) {
                childList.addAll(parseArray);
                if (childList.size() < this.a.getReplyNum()) {
                    ActiveCommentBean activeCommentBean = this.a;
                    activeCommentBean.setChildPage(activeCommentBean.getChildPage() + 1);
                }
                if (ActiveDetailActivity.this.f != null) {
                    ActiveDetailActivity.this.f.p();
                }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class h implements a.n {
        public final /* synthetic */ ActiveCommentBean a;

        /* loaded from: /tmp/classes2.dex */
        public class a extends HttpCallback {
            public a() {
            }

            @Override // com.yunbao.common.http.HttpCallback
            public void onSuccess(int i, String str, String[] strArr) {
                if (i == 0 && ActiveDetailActivity.this.e != null) {
                    ActiveDetailActivity.this.e.k();
                }
                t54.b(str);
            }
        }

        public h(ActiveCommentBean activeCommentBean) {
            this.a = activeCommentBean;
        }

        @Override // com.yunbao.common.utils.a.n
        public void a(String str, int i) {
            if (i != m93.s1) {
                if (i == m93.z1) {
                    db2.q(ActiveDetailActivity.this.g.getId(), this.a.getId(), this.a.getUid(), new a());
                }
            } else {
                UserBean userBean = this.a.getUserBean();
                if (userBean != null) {
                    ((ClipboardManager) ActiveDetailActivity.this.b.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text", rv3.a("@", userBean.getUserNiceName(), ": ", this.a.getContent())));
                    t54.a(m93.u1);
                }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class i implements vq2.b {
        public i() {
        }

        @Override // vq2.b
        public void a() {
            ActiveDetailActivity.this.finish();
        }
    }

    public static void G1(Context context, ActiveBean activeBean) {
        Intent intent = new Intent(context, (Class<?>) ActiveDetailActivity.class);
        intent.putExtra("activeBean", activeBean);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K1(String str) {
        String str2;
        String str3;
        if (TextUtils.isEmpty(str)) {
            t54.a(m93.r1);
            return;
        }
        ActiveBean activeBean = this.g;
        if (activeBean == null) {
            return;
        }
        String uid = activeBean.getUid();
        ActiveCommentBean activeCommentBean = this.h;
        if (activeCommentBean != null) {
            uid = activeCommentBean.getUid();
            str2 = this.h.getCommentId();
            str3 = this.h.getId();
        } else {
            str2 = "0";
            str3 = str2;
        }
        db2.d(this.g.getId(), uid, str2, str3, str, new f());
    }

    public final void H1(String str) {
        db2.M(str, new d());
    }

    public void I1() {
        this.e.setDataHelper(new e());
        this.e.k();
        this.j = new uw1(this.e, this);
    }

    @Override // defpackage.et2
    /* renamed from: J1, reason: merged with bridge method [inline-methods] */
    public void onItemClick(ActiveCommentBean activeCommentBean, int i2) {
        UserBean userBean;
        if (((AbsActivity) this.b).e1()) {
            if (activeCommentBean != null && !TextUtils.isEmpty(activeCommentBean.getUid()) && activeCommentBean.getUid().equals(j30.q().C())) {
                t54.a(m93.na);
                return;
            }
            this.h = activeCommentBean;
            if (this.i != null) {
                if (activeCommentBean != null && (userBean = activeCommentBean.getUserBean()) != null) {
                    this.i.t0();
                    this.i.H0(rv3.a(aq4.a(m93.sa), userBean.getUserNiceName()));
                }
                this.i.K0();
            }
        }
    }

    @Override // c4.i
    public void b0(ActiveCommentBean activeCommentBean) {
        ActiveCommentBean parentNodeBean = activeCommentBean.getParentNodeBean();
        if (parentNodeBean == null) {
            return;
        }
        db2.u(parentNodeBean.getId(), parentNodeBean.getChildPage(), new g(parentNodeBean));
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return y73.d;
    }

    @Override // uw1.c
    public void h(int i2) {
        gp1 gp1Var = this.i;
        if (gp1Var != null) {
            gp1Var.E0(i2);
        }
    }

    @Override // c4.i
    public void j(ActiveCommentBean activeCommentBean) {
        ActiveCommentBean parentNodeBean = activeCommentBean.getParentNodeBean();
        if (parentNodeBean == null) {
            return;
        }
        parentNodeBean.getChildList();
        parentNodeBean.removeChild();
        parentNodeBean.setChildPage(1);
        c4 c4Var = this.f;
        if (c4Var != null) {
            c4Var.p();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.y0));
        zu0.c().n(this);
        Intent intent = getIntent();
        if (intent.getData() != null) {
            this.k = intent.getData().getQueryParameter("dynamicid");
        }
        this.g = (ActiveBean) getIntent().getParcelableExtra("activeBean");
        gp1 gp1Var = new gp1(this.b, (ViewGroup) findViewById(c73.b3), Boolean.FALSE, Integer.valueOf(y73.f1), Integer.valueOf(u73.S));
        this.i = gp1Var;
        gp1Var.addToParent();
        this.i.subscribeActivityLifeCycle();
        this.i.F0(new a());
        ((InterceptFrameLayout) findViewById(c73.w2)).setOnInterceptListener(new b());
        CommonRefreshView commonRefreshView = (CommonRefreshView) findViewById(c73.r4);
        this.e = commonRefreshView;
        commonRefreshView.setEmptyLayoutId(y73.r1);
        this.e.setLayoutManager(new LinearLayoutManager(this.b, 1, false));
        if (this.g != null) {
            I1();
        }
        String str = this.k;
        if (str != null && !str.isEmpty()) {
            H1(this.k);
        }
        if (j30.q().N()) {
            return;
        }
        View findViewById = findViewById(c73.c3);
        findViewById.setVisibility(0);
        findViewById.setOnClickListener(new c());
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onActiveCommentEvent(d4 d4Var) {
        CommonRefreshView commonRefreshView = this.e;
        if (commonRefreshView != null) {
            commonRefreshView.k();
        }
    }

    public void onBackPressed() {
        gp1 gp1Var = this.i;
        if (gp1Var == null || !gp1Var.B0()) {
            super/*androidx.activity.ComponentActivity*/.onBackPressed();
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        uw1 uw1Var = this.j;
        if (uw1Var != null) {
            uw1Var.i();
        }
        this.j = null;
        zu0.c().p(this);
        db2.i("getActiveComments");
        db2.i("activeComment");
        db2.i("setActiveCommentLike");
        db2.i("getActiveCommentReply");
        db2.i("deleteComment");
        c4 c4Var = this.f;
        if (c4Var != null) {
            c4Var.y0();
        }
        super.onDestroy();
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onFollowEvent(q41 q41Var) {
        c4 c4Var;
        ActiveBean activeBean = this.g;
        if (activeBean == null || !activeBean.getUid().equals(q41Var.b()) || (c4Var = this.f) == null) {
            return;
        }
        c4Var.x0(q41Var.a());
    }

    @Override // c4.i
    public void r0(ActiveCommentBean activeCommentBean) {
        if (this.g == null) {
            return;
        }
        String C = j30.q().C();
        String uid = this.g.getUid();
        boolean z = !TextUtils.isEmpty(uid) && uid.equals(C);
        String uid2 = activeCommentBean.getUid();
        com.yunbao.common.utils.a.r(this.b, (z || (!TextUtils.isEmpty(uid2) && uid2.equals(C))) ? new Integer[]{Integer.valueOf(m93.s1), Integer.valueOf(m93.z1)} : new Integer[]{Integer.valueOf(m93.s1)}, new h(activeCommentBean));
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void u1() {
        vq2 vq2Var = new vq2();
        vq2Var.t2(new i());
        vq2Var.d2(getSupportFragmentManager(), "NotLoginDialogFragment");
    }
}
