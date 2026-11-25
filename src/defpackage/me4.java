package defpackage;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.bean.UserBean;
import com.yunbao.common.http.CommonHttpConsts;
import com.yunbao.common.http.CommonHttpUtil;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.im.activity.ChatRoomActivity;
import com.yunbao.live.activity.LiveContributeActivity;
import com.yunbao.live.activity.LiveGuardListActivity;
import com.yunbao.live.activity.LiveReportActivity;
import com.yunbao.live.activity.UserHomeBgActivity;
import com.yunbao.live.bean.LiveBean;
import com.yunbao.live.bean.SearchUserBean;
import com.yunbao.main.activity.EditProfileActivity;
import com.yunbao.main.activity.FansActivity;
import com.yunbao.main.activity.FollowActivity;
import com.yunbao.main.activity.UserHomeActivity;
import com.yunbao.main.bean.UserHomeConBean;
import com.yunbao.main.views.CurvedLinePagerIndicator;
import com.yunbao.mall.activity.ShopHomeActivity;
import defpackage.f4;
import defpackage.k52;
import defpackage.u42;
import defpackage.yh4;
import java.util.ArrayList;
import java.util.List;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;
import org.greenrobot.eventbus.ThreadMode;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: /tmp/classes2.dex */
public class me4 extends r0 implements k52.a {
    public Drawable A;
    public ViewPager B;
    public MagicIndicator C;
    public String[] D;
    public TextView E;
    public TextView F;
    public TextView G;
    public TextView H;
    public TextView I;
    public ImageView[] J;
    public ImageView[] K;
    public String L;
    public boolean M;
    public String N;
    public boolean O;
    public le4 P;
    public SearchUserBean Q;
    public String R;
    public String S;
    public String T;
    public String U;
    public int V;
    public int W;
    public boolean X;
    public boolean Y;
    public String Z;
    public int f;
    public String f0;
    public ke4 g;
    public CurvedLinePagerIndicator g0;
    public yh4 h;
    public f4 i;
    public u42 j;
    public k0[] k;
    public List l;
    public ImageView m;
    public ImageView n;
    public TextView o;
    public ImageView p;
    public ImageView q;
    public ImageView r;
    public ImageView s;
    public View t;
    public TextView u;
    public TextView v;
    public TextView w;
    public TextView x;
    public TextView y;
    public Drawable z;

    /* loaded from: /tmp/classes2.dex */
    public class a implements ViewPager.j {
        public a() {
        }

        public void a(int i, float f, int i2) {
        }

        public void b(int i) {
        }

        public void c(int i) {
            me4.this.u1(i);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends n30 {

        /* loaded from: /tmp/classes2.dex */
        public class a implements View.OnClickListener {
            public final /* synthetic */ int a;

            public a(int i) {
                this.a = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (me4.this.B != null) {
                    me4.this.B.setCurrentItem(this.a);
                }
            }
        }

        public b() {
        }

        @Override // defpackage.n30
        public int a() {
            return me4.this.D.length;
        }

        @Override // defpackage.n30
        public zh1 b(Context context) {
            CurvedLinePagerIndicator curvedLinePagerIndicator = new CurvedLinePagerIndicator(context);
            curvedLinePagerIndicator.setMode(1);
            curvedLinePagerIndicator.setLineWidth(zn0.a(20));
            curvedLinePagerIndicator.setLineHeight(zn0.a(2));
            curvedLinePagerIndicator.setRoundRadius(zn0.a(1));
            curvedLinePagerIndicator.setXOffset(zn0.a(5));
            curvedLinePagerIndicator.setCurveHeight(zn0.a(2));
            curvedLinePagerIndicator.setColors(o60.b(me4.this.mContext, p53.g));
            curvedLinePagerIndicator.setLineWidth(20.0f);
            curvedLinePagerIndicator.setLineScale(0.3f);
            me4.this.g0 = curvedLinePagerIndicator;
            return curvedLinePagerIndicator;
        }

        @Override // defpackage.n30
        public bi1 c(Context context, int i) {
            ColorTransitionPagerTitleView colorTransitionPagerTitleView = new ColorTransitionPagerTitleView(context);
            if (rx1.h()) {
                colorTransitionPagerTitleView.setPadding(0, 0, 0, 0);
            }
            colorTransitionPagerTitleView.setNormalColor(o60.b(me4.this.mContext, p53.h));
            colorTransitionPagerTitleView.setSelectedColor(o60.b(me4.this.mContext, p53.g));
            colorTransitionPagerTitleView.setText(me4.this.D[i]);
            colorTransitionPagerTitleView.setTextSize(13.0f);
            colorTransitionPagerTitleView.setOnClickListener(new a(i));
            if (i == 1) {
                me4.this.E = colorTransitionPagerTitleView;
                return colorTransitionPagerTitleView;
            }
            if (i == 2) {
                me4.this.F = colorTransitionPagerTitleView;
                return colorTransitionPagerTitleView;
            }
            if (i == 3) {
                me4.this.G = colorTransitionPagerTitleView;
                return colorTransitionPagerTitleView;
            }
            if (i == 4) {
                me4.this.H = colorTransitionPagerTitleView;
            }
            return colorTransitionPagerTitleView;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c implements yh4.c {
        public c() {
        }

        @Override // yh4.c
        public void a(int i) {
            me4.i0(me4.this, i);
            if (me4.this.V < 0) {
                me4.this.V = 0;
            }
            if (me4.this.E != null) {
                me4.this.E.setText(me4.this.R + " " + me4.this.V);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d implements f4.b {
        public d() {
        }

        @Override // f4.b
        public void a(int i) {
            me4.m0(me4.this, i);
            if (me4.this.W < 0) {
                me4.this.W = 0;
            }
            if (me4.this.F != null) {
                me4.this.F.setText(me4.this.T + " " + me4.this.W);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e implements u42.c {
        public e() {
        }

        @Override // u42.c
        public UserBean a() {
            return me4.this.Q;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class f extends HttpCallback {
        public f() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length <= 0) {
                t54.b(str);
                return;
            }
            JSONObject parseObject = JSON.parseObject(strArr[0]);
            SearchUserBean searchUserBean = (SearchUserBean) JSON.toJavaObject(parseObject, SearchUserBean.class);
            me4.this.Q = searchUserBean;
            String avatar = searchUserBean.getAvatar();
            me4.this.Z = parseObject.getString("bg_img");
            kn1.f(me4.this.mContext, me4.this.Z, me4.this.m);
            ViewGroup.LayoutParams layoutParams = me4.this.m.getLayoutParams();
            int c = gk3.a().c();
            layoutParams.width = c;
            layoutParams.height = (c / 10) * 7;
            me4.this.m.setLayoutParams(layoutParams);
            me4.this.f0 = avatar;
            kn1.g(me4.this.mContext, avatar, me4.this.n);
            String userNiceName = searchUserBean.getUserNiceName();
            me4.this.o.setText(userNiceName);
            me4.this.q.setImageResource(l30.b(searchUserBean.getSex()));
            if (parseObject.containsKey("vip") && parseObject.getJSONObject("vip") != null && parseObject.getJSONObject("vip").containsKey("type")) {
                boolean equals = parseObject.getJSONObject("vip").getString("type").equals(SdkVersion.MINI_VERSION);
                me4 me4Var = me4.this;
                if (equals) {
                    me4Var.p.setVisibility(0);
                } else {
                    me4Var.p.setVisibility(8);
                }
            } else {
                me4.this.p.setVisibility(8);
            }
            j30 q = j30.q();
            kn1.f(me4.this.mContext, q.c(searchUserBean.getLevelAnchor()).getThumb(), me4.this.r);
            kn1.f(me4.this.mContext, q.s(searchUserBean.getLevel()).getThumb(), me4.this.s);
            String i2 = rv3.i(searchUserBean.getFans());
            me4.this.u.setText(i2);
            me4.this.v.setText(rv3.i(searchUserBean.getFollows()));
            me4.this.w.setText(parseObject.getString("praise_num"));
            me4.this.I.setText(searchUserBean.getSignature());
            if (!me4.this.O) {
                int intValue = parseObject.getIntValue("isattention");
                me4 me4Var2 = me4.this;
                if (intValue == 1) {
                    if (me4Var2.x != null) {
                        me4.this.x.setBackground(me4.this.z);
                        me4.this.x.setTextColor(-8553091);
                        me4.this.x.setText(m93.N1);
                    }
                } else if (me4Var2.x != null) {
                    me4.this.x.setBackground(me4.this.A);
                    me4.this.x.setTextColor(-1);
                    me4.this.x.setText(m93.M1);
                }
                if (me4.this.y != null) {
                    me4.this.y.setText(parseObject.getIntValue("isblack") == 1 ? m93.P0 : m93.N0);
                }
            }
            me4.this.V = parseObject.getIntValue("videonums");
            if (me4.this.E != null) {
                me4.this.E.setText(me4.this.R + " " + me4.this.V);
            }
            me4.this.W = parseObject.getIntValue("dynamicnums");
            if (me4.this.F != null) {
                me4.this.F.setText(me4.this.T + " " + me4.this.W);
            }
            if (me4.this.G != null) {
                me4.this.G.setText(me4.this.S + " " + parseObject.getString("livenums"));
            }
            if (me4.this.H != null) {
                me4.this.H.setText(me4.this.U + " " + parseObject.getString("paidprogram_nums"));
            }
            if (me4.this.P != null) {
                me4.this.P.f(me4.this.L).e(userNiceName).c(searchUserBean.getAvatarThumb()).d(i2);
            }
            if (me4.this.g != null) {
                me4.this.g.h0(searchUserBean, parseObject);
            }
            if (me4.this.t != null) {
                int intValue2 = parseObject.getIntValue("islive");
                me4 me4Var3 = me4.this;
                if (intValue2 == 1) {
                    if (me4Var3.t.getVisibility() != 0) {
                        me4.this.t.setVisibility(0);
                    }
                } else if (me4Var3.t.getVisibility() == 0) {
                    me4.this.t.setVisibility(4);
                }
            }
            if (j30.q().Q()) {
                return;
            }
            me4.this.D1(parseObject.getString("contribute"));
            me4.this.E1(parseObject.getString("guardlist"));
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class g extends HttpCallback {
        public g() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length <= 0) {
                return;
            }
            JSONObject parseObject = JSON.parseObject(strArr[0]);
            if (me4.this.g != null) {
                me4.this.g.i0(parseObject.getString("label"));
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class h extends HttpCallback {
        public h() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length <= 0) {
                return;
            }
            boolean z = JSON.parseObject(strArr[0]).getIntValue("isblack") == 1;
            if (me4.this.y != null) {
                me4.this.y.setText(z ? m93.P0 : m93.N0);
            }
            if (!z) {
                t54.a(m93.Q0);
                return;
            }
            t54.a(m93.O0);
            if (me4.this.x != null) {
                me4.this.x.setBackground(me4.this.A);
                me4.this.x.setTextColor(-1);
                me4.this.x.setText(m93.M1);
            }
            zu0.c().j(new q41(me4.this.L, 0));
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class i extends HttpCallback {
        public i() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length <= 0) {
                t54.b(str);
                return;
            }
            JSONObject parseObject = JSON.parseObject(strArr[0]);
            SearchUserBean searchUserBean = (SearchUserBean) JSON.toJavaObject(parseObject, SearchUserBean.class);
            me4.this.Q = searchUserBean;
            String avatar = searchUserBean.getAvatar();
            me4.this.Z = parseObject.getString("bg_img");
            kn1.f(me4.this.mContext, me4.this.Z, me4.this.m);
            me4.this.f0 = avatar;
            kn1.g(me4.this.mContext, avatar, me4.this.n);
            me4.this.o.setText(searchUserBean.getUserNiceName());
            me4.this.q.setImageResource(l30.b(searchUserBean.getSex()));
            me4.this.u.setText(rv3.i(searchUserBean.getFans()));
            me4.this.v.setText(rv3.i(searchUserBean.getFollows()));
            me4.this.w.setText(parseObject.getString("praise_num"));
            if (me4.this.g != null) {
                me4.this.g.g0(searchUserBean, parseObject);
            }
            if (me4.this.t != null) {
                int intValue = parseObject.getIntValue("islive");
                me4 me4Var = me4.this;
                if (intValue == 1) {
                    if (me4Var.t.getVisibility() != 0) {
                        me4.this.t.setVisibility(0);
                    }
                } else if (me4Var.t.getVisibility() == 0) {
                    me4.this.t.setVisibility(4);
                }
            }
        }
    }

    public me4(Context context, ViewGroup viewGroup, String str, boolean z, String str2) {
        super(context, viewGroup, str, Boolean.valueOf(z), str2);
        this.f = 5;
    }

    public static /* synthetic */ int i0(me4 me4Var, int i2) {
        int i3 = me4Var.V - i2;
        me4Var.V = i3;
        return i3;
    }

    private void k1() {
        Object obj = this.mContext;
        if (obj instanceof UserHomeActivity) {
            ((UserHomeActivity) obj).onBackPressed();
        }
    }

    private void l1() {
        le4 le4Var = this.P;
        if (le4Var != null) {
            le4Var.a();
        }
    }

    public static /* synthetic */ int m0(me4 me4Var, int i2) {
        int i3 = me4Var.W - i2;
        me4Var.W = i3;
        return i3;
    }

    private void m1() {
        CommonHttpUtil.setAttention(this.L, null);
    }

    private void n1() {
        Intent intent = new Intent(this.mContext, (Class<?>) LiveContributeActivity.class);
        intent.putExtra("toUid", this.L);
        this.mContext.startActivity(intent);
    }

    private void q1() {
        LiveGuardListActivity.A1(this.mContext, this.L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u1(int i2) {
        k0 k0Var;
        k0[] k0VarArr = this.k;
        if (k0VarArr == null) {
            return;
        }
        k0 k0Var2 = k0VarArr[i2];
        k0 k0Var3 = k0Var2;
        if (k0Var2 == null) {
            List list = this.l;
            k0Var3 = k0Var2;
            if (list != null) {
                k0Var3 = k0Var2;
                if (i2 < list.size()) {
                    FrameLayout frameLayout = (FrameLayout) this.l.get(i2);
                    if (frameLayout == null) {
                        return;
                    }
                    if (i2 == 0) {
                        ke4 ke4Var = new ke4(this.mContext, frameLayout, this.L, this.O);
                        this.g = ke4Var;
                        k0Var = ke4Var;
                    } else if (i2 == 1) {
                        yh4 yh4Var = new yh4(this.mContext, frameLayout, this.L);
                        this.h = yh4Var;
                        yh4Var.h0(new c());
                        k0Var = this.h;
                    } else if (i2 == 2) {
                        f4 f4Var = new f4(this.mContext, frameLayout, this.L);
                        this.i = f4Var;
                        f4Var.f0(new d());
                        k0Var = this.i;
                    } else if (i2 == 3) {
                        u42 u42Var = new u42(this.mContext, frameLayout, this.L);
                        this.j = u42Var;
                        u42Var.i0(new e());
                        k0Var = this.j;
                    } else {
                        k0Var = k0Var2;
                        if (i2 == 4) {
                            k0Var = new mx2(this.mContext, frameLayout, this.L, false);
                        }
                    }
                    if (k0Var == null) {
                        return;
                    }
                    this.k[i2] = k0Var;
                    k0Var.addToParent();
                    k0Var.subscribeActivityLifeCycle();
                    k0Var3 = k0Var;
                }
            }
        }
        if (k0Var3 != null) {
            k0Var3.loadData();
        }
    }

    public final void A1() {
        k52 k52Var = new k52();
        k52Var.s2(this);
        k52Var.d2(((AbsActivity) this.mContext).getSupportFragmentManager(), "LiveShareDialogFragment");
    }

    public final void B1(String str) {
        le4 le4Var = this.P;
        if (le4Var != null) {
            le4Var.g(str);
        }
    }

    public final void C1() {
        ie4 ie4Var = new ie4();
        Bundle bundle = new Bundle();
        bundle.putString(IjkMediaPlayer.OnNativeInvokeListener.ARG_URL, this.f0);
        ie4Var.F1(bundle);
        ie4Var.d2(((AbsActivity) this.mContext).getSupportFragmentManager(), "UserAvatarPreviewDialog");
    }

    public final void D1(String str) {
        List parseArray = JSON.parseArray(str, UserHomeConBean.class);
        if (parseArray.size() == 0) {
            return;
        }
        if (parseArray.size() > 3) {
            parseArray = parseArray.subList(0, 3);
        }
        int size = parseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.J[i2] != null) {
                kn1.f(this.mContext, ((UserHomeConBean) parseArray.get(i2)).getAvatar(), this.J[i2]);
            }
        }
    }

    public final void E1(String str) {
        List parseArray = JSON.parseArray(str, UserBean.class);
        if (parseArray.size() == 0) {
            return;
        }
        if (parseArray.size() > 3) {
            parseArray = parseArray.subList(0, 3);
        }
        int size = parseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.K[i2] != null) {
                kn1.f(this.mContext, ((UserBean) parseArray.get(i2)).getAvatar(), this.K[i2]);
            }
        }
    }

    @Override // k52.a
    public void c0(String str) {
        if ("link".equals(str)) {
            l1();
        } else {
            B1(str);
        }
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return y73.g1;
    }

    @Override // defpackage.r0, defpackage.b1
    public void init() {
        setStatusHeight();
        super.init();
        View findViewById = findViewById(c73.C);
        if (!this.O) {
            if (findViewById.getVisibility() != 0) {
                findViewById.setVisibility(0);
            }
            View findViewById2 = findViewById(c73.Z0);
            findViewById2.setVisibility(0);
            findViewById2.setOnClickListener(this);
        } else if (findViewById.getVisibility() == 0) {
            findViewById.setVisibility(8);
        }
        ImageView imageView = (ImageView) findViewById(c73.y);
        this.m = imageView;
        imageView.setOnClickListener(this);
        ImageView imageView2 = (ImageView) findViewById(c73.l);
        this.n = imageView2;
        imageView2.setOnClickListener(this);
        this.o = (TextView) findViewById(c73.L3);
        this.p = (ImageView) findViewById(c73.B5);
        this.q = (ImageView) findViewById(c73.x4);
        this.r = (ImageView) findViewById(c73.v3);
        this.s = (ImageView) findViewById(c73.u3);
        this.u = (TextView) findViewById(c73.k2);
        this.v = (TextView) findViewById(c73.l2);
        this.w = (TextView) findViewById(c73.P5);
        this.x = (TextView) findViewById(c73.P0);
        this.I = (TextView) findViewById(c73.f5);
        this.t = findViewById(c73.B0);
        this.y = (TextView) findViewById(c73.B);
        this.J = new ImageView[3];
        this.K = new ImageView[3];
        if (!j30.q().Q()) {
            findViewById(c73.z2).setVisibility(0);
            this.J[0] = (ImageView) findViewById(c73.p);
            this.J[1] = (ImageView) findViewById(c73.q);
            this.J[2] = (ImageView) findViewById(c73.r);
            this.K[0] = (ImageView) findViewById(c73.s);
            this.K[1] = (ImageView) findViewById(c73.t);
            this.K[2] = (ImageView) findViewById(c73.u);
        }
        this.z = o60.d(this.mContext, i63.l);
        this.A = o60.d(this.mContext, i63.m);
        if (this.O) {
            this.x.setText(m93.A1);
            this.x.setBackground(o60.d(this.mContext, i63.n));
            this.x.setTextColor(-1);
        }
        if (j30.q().Q()) {
            this.f = 4;
        } else {
            this.f = 5;
        }
        ViewPager findViewById3 = findViewById(c73.y5);
        this.B = findViewById3;
        int i2 = this.f;
        if (i2 > 1) {
            findViewById3.setOffscreenPageLimit(i2 - 1);
        }
        this.k = new k0[this.f];
        this.l = new ArrayList();
        for (int i3 = 0; i3 < this.f; i3++) {
            FrameLayout frameLayout = new FrameLayout(this.mContext);
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.l.add(frameLayout);
        }
        this.B.setAdapter(new dk4(this.l));
        this.B.c(new a());
        this.R = aq4.a(m93.ka);
        this.S = aq4.a(m93.n3);
        this.T = aq4.a(m93.h5);
        this.U = aq4.a(m93.U7);
        this.C = (MagicIndicator) findViewById(c73.V2);
        if (j30.q().Q()) {
            this.D = new String[]{aq4.a(m93.U4), this.R, this.T, this.S};
        } else {
            this.D = new String[]{aq4.a(m93.U4), this.R, this.T, this.S, this.U};
        }
        CommonNavigator commonNavigator = new CommonNavigator(this.mContext);
        commonNavigator.setAdapter(new b());
        if (rx1.h()) {
            commonNavigator.setAdjustMode(true);
        }
        this.C.setNavigator(commonNavigator);
        ek4.a(this.C, this.B);
        findViewById(c73.k0).setOnClickListener(this);
        findViewById(c73.m0).setOnClickListener(this);
        this.t.setOnClickListener(this);
        this.x.setOnClickListener(this);
        findViewById(c73.K).setOnClickListener(this);
        findViewById(c73.f1).setOnClickListener(this);
        findViewById(c73.M).setOnClickListener(this);
        findViewById(c73.H1).setOnClickListener(this);
        findViewById(c73.C2).setOnClickListener(this);
        if (j30.q().O()) {
            findViewById(c73.R0).setOnClickListener(this);
        } else {
            findViewById(c73.R0).setVisibility(8);
        }
        this.P = new le4(this.mContext);
        zu0.c().n(this);
    }

    @Override // defpackage.r0
    public void loadData() {
        if (TextUtils.isEmpty(this.L)) {
            return;
        }
        u1(0);
        db2.d0(this.L, new f());
    }

    public final void o1() {
        FansActivity.A1(this.mContext, this.L);
    }

    @Override // defpackage.r0, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == c73.y) {
            UserHomeBgActivity.E1(this.mContext, this.Z, this.O);
            return;
        }
        if (id == c73.K) {
            k1();
            return;
        }
        if (id == c73.f1) {
            A1();
            return;
        }
        if (id == c73.k0) {
            o1();
            return;
        }
        if (id == c73.m0) {
            p1();
            return;
        }
        if (id == c73.R0) {
            s1();
            return;
        }
        if (id == c73.M) {
            z1();
            return;
        }
        if (id == c73.B0) {
            r1();
            return;
        }
        if (id == c73.g1) {
            t1();
            return;
        }
        if (id == c73.H1) {
            n1();
            return;
        }
        if (id == c73.C2) {
            q1();
            return;
        }
        if (id == c73.Z0) {
            y1();
            return;
        }
        if (id != c73.P0) {
            if (id == c73.l) {
                C1();
            }
        } else {
            if (!this.O) {
                m1();
                return;
            }
            Context context = this.mContext;
            if (context != null) {
                context.startActivity(new Intent(this.mContext, (Class<?>) EditProfileActivity.class));
            }
        }
    }

    @Override // defpackage.b1, defpackage.uy1
    public void onDestroy() {
        super.onDestroy();
        db2.i("getUserHome");
        CommonHttpUtil.cancel(CommonHttpConsts.SET_ATTENTION);
        db2.i("setBlack");
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onFollowEvent(q41 q41Var) {
        if (q41Var.b().equals(this.L)) {
            int a2 = q41Var.a();
            SearchUserBean searchUserBean = this.Q;
            if (searchUserBean != null) {
                searchUserBean.setAttention(a2);
            }
            v1(a2);
        }
    }

    @Override // defpackage.b1, defpackage.uy1
    public void onPause() {
        this.Y = true;
        super.onPause();
    }

    @Override // defpackage.b1, defpackage.uy1
    public void onResume() {
        super.onResume();
        if (this.O && this.Y && this.X) {
            this.X = false;
            x1();
        }
        this.Y = false;
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onUpdateBgEvent(kd4 kd4Var) {
        if (kd4Var.a() == 1) {
            String b2 = kd4Var.b();
            this.Z = b2;
            kn1.f(this.mContext, b2, this.m);
        } else if (kd4Var.a() == 2) {
            j30.q().D().setAvatar(kd4Var.b());
            kn1.g(this.mContext, kd4Var.b(), this.n);
        }
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onUpdateFieldEvent(hd4 hd4Var) {
        if (this.O) {
            this.X = true;
        }
    }

    public final void p1() {
        FollowActivity.A1(this.mContext, this.L);
    }

    @Override // defpackage.b1
    public void processArguments(Object... objArr) {
        this.L = (String) objArr[0];
        if (objArr.length > 1) {
            this.M = ((Boolean) objArr[1]).booleanValue();
        }
        if (objArr.length > 2) {
            this.N = (String) objArr[2];
        }
        if (TextUtils.isEmpty(this.L)) {
            return;
        }
        this.O = this.L.equals(j30.q().C());
    }

    public final void r1() {
        LiveBean liveBean = new LiveBean();
        liveBean.setUid(this.Q.getId());
        liveBean.setStream(this.Q.getStream());
        liveBean.setLivePlatform(this.Q.getLivePlatformInt());
        liveBean.setRoomId(this.Q.getRoomId());
        zu0.c().j(new d22(liveBean, 0));
    }

    @Override // defpackage.r0, defpackage.b1
    public void release() {
        super.release();
        e32.f("getLiveInfo");
        zu0.c().p(this);
        le4 le4Var = this.P;
        if (le4Var != null) {
            le4Var.b();
        }
        this.P = null;
        yh4 yh4Var = this.h;
        if (yh4Var != null) {
            yh4Var.release();
        }
        this.h = null;
        f4 f4Var = this.i;
        if (f4Var != null) {
            f4Var.release();
        }
        this.i = null;
    }

    public final void s1() {
        SearchUserBean searchUserBean = this.Q;
        if (searchUserBean != null) {
            ChatRoomActivity.A1(this.mContext, searchUserBean, searchUserBean.getAttention() == 1, true);
        }
    }

    public final void t1() {
        ShopHomeActivity.M1(this.mContext, this.L);
    }

    public final void v1(int i2) {
        TextView textView = this.x;
        if (i2 == 1) {
            if (textView != null) {
                textView.setBackground(this.z);
                this.x.setTextColor(-8553091);
                this.x.setText(m93.N1);
            }
        } else if (textView != null) {
            textView.setBackground(this.A);
            this.x.setTextColor(-1);
            this.x.setText(m93.M1);
        }
        TextView textView2 = this.y;
        if (textView2 == null || i2 != 1) {
            return;
        }
        textView2.setText(m93.N0);
    }

    public void w1() {
        db2.d0(this.L, new g());
    }

    public final void x1() {
        if (TextUtils.isEmpty(this.L)) {
            return;
        }
        db2.d0(this.L, new i());
    }

    public final void y1() {
        LiveReportActivity.A1(this.mContext, this.L, "home");
    }

    public final void z1() {
        db2.t0(this.L, new h());
    }
}
