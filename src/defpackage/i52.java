package defpackage;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.opensource.svgaplayer.SVGAImageView;
import com.umeng.analytics.pro.ca;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.bean.GoodsBean;
import com.yunbao.common.bean.LevelBean;
import com.yunbao.common.bean.UserBean;
import com.yunbao.common.http.CommonHttpConsts;
import com.yunbao.common.http.CommonHttpUtil;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.live.activity.LiveActivity;
import com.yunbao.live.activity.LiveAnchorActivity;
import com.yunbao.live.activity.LiveAudienceActivity;
import com.yunbao.live.bean.GlobalGiftBean;
import com.yunbao.live.bean.LiveBean;
import com.yunbao.live.bean.LiveBuyGuardMsgBean;
import com.yunbao.live.bean.LiveChatBean;
import com.yunbao.live.bean.LiveDanMuBean;
import com.yunbao.live.bean.LiveGiftPrizePoolWinBean;
import com.yunbao.live.bean.LiveLuckGiftWinBean;
import com.yunbao.live.bean.LiveReceiveGiftBean;
import com.yunbao.live.bean.LiveUserGiftBean;
import com.yunbao.live.custom.LiveLightView;
import defpackage.kn1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import pl.droidsonroids.gif.GifImageView;

/* loaded from: /tmp/classes2.dex */
public class i52 extends b1 implements View.OnClickListener {
    public n22 A;
    public HttpCallback B;
    public HttpCallback C;
    public int D;
    public GifImageView E;
    public SVGAImageView F;
    public ViewGroup G;
    public TextView H;
    public int I;
    public View J;
    public ImageView K;
    public TextView L;
    public TextView M;
    public TextView N;
    public GoodsBean O;
    public a52 P;
    public int Q;
    public StringBuilder R;
    public m24 S;
    public String T;
    public long U;
    public boolean V;
    public View W;
    public ImageView X;
    public TextView Y;
    public View Z;
    public int a;
    public ViewGroup b;
    public ImageView c;
    public ImageView d;
    public TextView e;
    public TextView f;
    public View g;
    public TextView h;
    public TextView i;
    public TextView j;
    public TextView k;
    public RecyclerView l;
    public LinearLayout m;
    public TextView n;
    public ConstraintLayout o;
    public TextView p;
    public TextView q;
    public RecyclerView r;
    public w52 s;
    public h12 t;
    public View u;
    public String v;
    public String w;
    public j32 x;
    public a22 y;
    public p12 z;

    /* loaded from: /tmp/classes2.dex */
    public class a extends k30 {
        public final /* synthetic */ LiveUserGiftBean a;

        public a(LiveUserGiftBean liveUserGiftBean) {
            this.a = liveUserGiftBean;
        }

        @Override // defpackage.k30
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Drawable drawable) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) "  ");
            drawable.setBounds(0, 0, zn0.a(28), zn0.a(14));
            spannableStringBuilder.setSpan(new mg4(drawable), 0, 1, 33);
            String userNiceName = this.a.getUserNiceName();
            spannableStringBuilder.append((CharSequence) userNiceName);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(-13246995), 2, userNiceName.length() + 2, 33);
            spannableStringBuilder.append((CharSequence) "来了");
            spannableStringBuilder.setSpan(new ForegroundColorSpan(-854532), spannableStringBuilder.length() - 2, spannableStringBuilder.length(), 33);
            i52.this.q.setText(spannableStringBuilder);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements kn1.a {
        public final /* synthetic */ k30 a;

        public b(k30 k30Var) {
            this.a = k30Var;
        }

        @Override // kn1.a
        public void onLoadFailed() {
            this.a.a(null);
        }

        @Override // kn1.a
        public void onLoadSuccess(Drawable drawable) {
            this.a.a(drawable);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends m30 {
        public c() {
        }

        @Override // defpackage.m30
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(int i, String str) {
            if (i == 1) {
                return;
            }
            if (i == 2) {
                i52.this.f1(1);
                return;
            }
            if (i == 3) {
                i52.this.f1(0);
                return;
            }
            if (i == 4) {
                t54.b("设置管理员成功");
            } else if (i == 5) {
                t54.b("取消管理员成功");
            } else if (i == 6) {
                ((LiveActivity) i52.this.mContext).V1(str);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d extends m30 {
        public d() {
        }

        @Override // defpackage.m30
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(int i, UserBean userBean) {
            ((LiveActivity) i52.this.mContext).U1(userBean, i == 1);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (i52.this.H != null) {
                if (i52.this.R == null) {
                    i52.this.R = new StringBuilder();
                }
                i52.this.H.setText(rv3.e(i52.this.I, i52.this.R));
            }
            i52.o0(i52.this, 1);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (i52.this.mContext instanceof LiveAnchorActivity) {
                ((LiveAnchorActivity) i52.this.mContext).j3();
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            i52.this.A0();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class h extends RecyclerView.n {
        public h() {
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
            if (recyclerView.n0(view) != 0) {
                rect.left = -60;
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class i implements et2 {
        public i() {
        }

        @Override // defpackage.et2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onItemClick(UserBean userBean, int i) {
            i52.this.y1(userBean.getId());
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class j implements et2 {
        public j() {
        }

        @Override // defpackage.et2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onItemClick(LiveChatBean liveChatBean, int i) {
            i52.this.y1(liveChatBean.getId());
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class k extends HttpCallback {
        public final /* synthetic */ String a;

        /* loaded from: /tmp/classes2.dex */
        public class a implements View.OnClickListener {

            /* renamed from: i52$k$a$a, reason: collision with other inner class name */
            /* loaded from: /tmp/classes2.dex */
            public class C0073a extends k30 {
                public C0073a() {
                }

                @Override // defpackage.k30
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public void a(Integer num) {
                    if (num.intValue() == 1) {
                        if (i52.this.Z.getVisibility() != 8) {
                            i52.this.Z.setVisibility(8);
                        }
                        t54.a(m93.u2);
                    }
                }
            }

            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CommonHttpUtil.setAttention(k.this.a, new C0073a());
            }
        }

        public k(String str) {
            this.a = str;
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length <= 0) {
                return;
            }
            JSONObject parseObject = JSON.parseObject(strArr[0]);
            if (i52.this.W != null && i52.this.W.getVisibility() != 0) {
                i52.this.W.setVisibility(0);
            }
            if (i52.this.X != null) {
                i52.this.X.setImageDrawable(null);
                kn1.g(i52.this.mContext, parseObject.getString("avatar"), i52.this.X);
            }
            if (i52.this.Y != null) {
                i52.this.Y.setText(parseObject.getString("user_nickname"));
            }
            if (i52.this.Z != null) {
                int intValue = parseObject.getIntValue("utot");
                i52 i52Var = i52.this;
                if (intValue == 1) {
                    if (i52Var.Z.getVisibility() != 8) {
                        i52.this.Z.setVisibility(8);
                    }
                    i52.this.Z.setOnClickListener(null);
                } else {
                    if (i52Var.Z.getVisibility() != 0) {
                        i52.this.Z.setVisibility(0);
                    }
                    i52.this.Z.setOnClickListener(new a());
                }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class l extends k30 {
        public l() {
        }

        @Override // defpackage.k30
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Integer num) {
            num.getClass();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class m extends HttpCallback {
        public m() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            JSONObject parseObject;
            if ((!i52.this.V || (i52.this.mContext instanceof LiveAnchorActivity)) && i == 0 && strArr != null && strArr.length > 0 && (parseObject = JSON.parseObject(strArr[0])) != null) {
                List parseArray = JSON.parseArray(parseObject.getString("userlist"), LiveUserGiftBean.class);
                int intValue = parseObject.getIntValue("nums");
                if (i52.this.s != null) {
                    i52.this.a1(parseArray);
                }
                i52.this.q1(intValue);
                i52.this.Z0(intValue, parseArray);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class n implements Runnable {
        public n() {
        }

        @Override // java.lang.Runnable
        public void run() {
            i52.this.b1();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class o implements Runnable {
        public final /* synthetic */ List a;

        public o(List list) {
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (i52.this.l == null || this.a.size() <= 0) {
                return;
            }
            i52.this.l.v1(this.a.size() - 1);
        }
    }

    public i52(Context context, ViewGroup viewGroup, GifImageView gifImageView, SVGAImageView sVGAImageView, ViewGroup viewGroup2) {
        super(context, viewGroup);
        this.E = gifImageView;
        this.F = sVGAImageView;
        this.G = viewGroup2;
        View findViewById = findViewById(b73.v2);
        ((ViewGroup.MarginLayoutParams) findViewById.getLayoutParams()).topMargin = gk3.a().d() + zn0.a(5);
        findViewById.requestLayout();
    }

    private void Y0() {
        ((LiveActivity) this.mContext).X1();
    }

    public static /* synthetic */ void a0(i52 i52Var, View view) {
        ViewGroup.LayoutParams layoutParams = (ConstraintLayout.b) i52Var.p.getLayoutParams();
        int lineCount = i52Var.n.getLineCount();
        TextView textView = i52Var.n;
        if (lineCount > 1) {
            textView.setSingleLine(true);
            i52Var.p.setText("展开");
            i52Var.n.setPadding(zn0.a(6), zn0.a(4), zn0.a(60), zn0.a(4));
            i52Var.p.setLayoutParams(layoutParams);
            return;
        }
        textView.setSingleLine(false);
        i52Var.p.setText("收起");
        i52Var.n.setPadding(zn0.a(6), zn0.a(4), zn0.a(6), zn0.a(4));
        i52Var.p.setLayoutParams(layoutParams);
    }

    public static /* synthetic */ int o0(i52 i52Var, int i2) {
        int i3 = i52Var.I + i2;
        i52Var.I = i3;
        return i3;
    }

    public final void A0() {
        Object obj = this.mContext;
        if (obj == null || !(obj instanceof LiveAnchorActivity)) {
            return;
        }
        ((LiveAnchorActivity) obj).p3();
    }

    public final void A1() {
        String valueOf;
        if (this.k != null) {
            int i2 = this.Q;
            if (i2 > 999) {
                valueOf = "999+";
            } else {
                if (i2 < 0) {
                    this.Q = 0;
                }
                valueOf = String.valueOf(this.Q);
            }
            this.k.setText(valueOf);
        }
    }

    public void B0() {
        m24 m24Var = this.S;
        if (m24Var != null) {
            m24Var.d("anchorPause", 50000L, 0L, new g());
        }
    }

    public void B1() {
        m24 m24Var = this.S;
        if (m24Var != null) {
            m24Var.d("anchorCheckLive", 30000L, 30000L, new f());
        }
    }

    public void C0() {
        m24 m24Var = this.S;
        if (m24Var != null) {
            m24Var.c("anchorPause");
        }
    }

    public void C1() {
        m24 m24Var = this.S;
        if (m24Var != null) {
            m24Var.d("anchorLiveTime", 0L, 1000L, new e());
        }
    }

    public final String D0(int i2, List list) {
        StringBuilder sb = new StringBuilder();
        sb.append(i2);
        sb.append('|');
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                LiveUserGiftBean liveUserGiftBean = (LiveUserGiftBean) it.next();
                if (liveUserGiftBean != null) {
                    sb.append(d1(liveUserGiftBean.getId()));
                    sb.append(',');
                    sb.append(d1(liveUserGiftBean.getAvatar()));
                    sb.append(',');
                    sb.append(liveUserGiftBean.getLevel());
                    sb.append(',');
                    sb.append(liveUserGiftBean.getGuardType());
                    sb.append(',');
                    sb.append(d1(liveUserGiftBean.getContribution()));
                    sb.append(';');
                }
            }
        }
        return sb.toString();
    }

    public void D1() {
        b1();
        m24 m24Var = this.S;
        if (m24Var != null) {
            int i2 = this.D;
            if (i2 <= 0) {
                i2 = ca.b;
            }
            long j2 = i2;
            m24Var.d("refreshUserList", j2, j2, new n());
        }
    }

    public void E0() {
        h12 h12Var = this.t;
        if (h12Var != null) {
            h12Var.X();
        }
    }

    public final void E1() {
        if (this.V) {
            return;
        }
        this.V = true;
        m24 m24Var = this.S;
        if (m24Var != null) {
            m24Var.c("refreshUserList");
        }
        e32.f("getUserList");
    }

    public void F0() {
        e32.f("getUserList");
        e32.f("timeCharge");
        CommonHttpUtil.cancel(CommonHttpConsts.SET_ATTENTION);
        m24 m24Var = this.S;
        if (m24Var != null) {
            m24Var.b();
        }
        ImageView imageView = this.c;
        if (imageView != null) {
            imageView.setImageDrawable(null);
        }
        ImageView imageView2 = this.d;
        if (imageView2 != null) {
            imageView2.setImageDrawable(null);
        }
        TextView textView = this.e;
        if (textView != null) {
            textView.setText("");
        }
        TextView textView2 = this.f;
        if (textView2 != null) {
            textView2.setText("");
        }
        TextView textView3 = this.i;
        if (textView3 != null) {
            textView3.setText("");
        }
        TextView textView4 = this.j;
        if (textView4 != null) {
            textView4.setText("");
        }
        w52 w52Var = this.s;
        if (w52Var != null) {
            w52Var.R();
        }
        h12 h12Var = this.t;
        if (h12Var != null) {
            h12Var.R();
        }
        a22 a22Var = this.y;
        if (a22Var != null) {
            a22Var.r();
            this.y.v();
        }
        p12 p12Var = this.z;
        if (p12Var != null) {
            p12Var.d();
            this.z.e();
        }
        n22 n22Var = this.A;
        if (n22Var != null) {
            n22Var.q0();
        }
        n1(null);
        this.T = null;
        this.U = 0L;
        this.V = false;
    }

    public void G0(int i2) {
    }

    public void H0(LiveUserGiftBean liveUserGiftBean) {
        this.q.setVisibility(0);
        L0(liveUserGiftBean.getLevel(), new a(liveUserGiftBean));
    }

    public void I0() {
        if (((AbsActivity) this.mContext).e1() && !TextUtils.isEmpty(this.v)) {
            CommonHttpUtil.setAttention(this.v, new l());
        }
    }

    public final void J0() {
        Object obj = this.mContext;
        if (obj != null && (obj instanceof LiveAudienceActivity)) {
            ((LiveAudienceActivity) obj).L3();
        }
        LiveBean E1 = ((LiveActivity) this.mContext).E1();
        GoodsBean goodsBean = this.O;
        if (goodsBean != null) {
            int type = goodsBean.getType();
            Context context = this.mContext;
            if (type == 1) {
                pi3.h(context, this.O.getId(), false, E1);
            } else {
                pi3.f(context, this.O.getId(), false, this.v, null, E1);
            }
        }
    }

    public ViewGroup K0() {
        return (ViewGroup) findViewById(b73.i3);
    }

    public final void L0(int i2, k30 k30Var) {
        LevelBean s = j30.q().s(i2);
        if (s == null || s.getThumb() == null) {
            return;
        }
        kn1.j(this.mContext, s.getThumb(), new b(k30Var));
    }

    public void M0() {
        View view = this.W;
        if (view != null && view.getVisibility() != 4) {
            this.W.setVisibility(4);
        }
        ImageView imageView = this.X;
        if (imageView != null) {
            imageView.setImageDrawable(null);
        }
        TextView textView = this.Y;
        if (textView != null) {
            textView.setText((CharSequence) null);
        }
    }

    public void N0(LiveChatBean liveChatBean) {
        h12 h12Var = this.t;
        if (h12Var != null) {
            h12Var.V(liveChatBean);
        }
    }

    public void O0(List list) {
        h12 h12Var = this.t;
        if (h12Var != null) {
            h12Var.W(list);
        }
    }

    public void P0(LiveChatBean liveChatBean) {
        this.n.setVisibility(0);
        this.n.setText(liveChatBean.getContent());
        if (liveChatBean.getMsgStyleBean() == null || liveChatBean.getMsgStyleBean().getTextColor() == null) {
            return;
        }
        liveChatBean.getMsgStyleBean().setViewBg(this.o);
        this.n.setTextColor(Color.parseColor(liveChatBean.getMsgStyleBean().getTextColor()));
    }

    public void Q0(GlobalGiftBean globalGiftBean) {
        if (this.A == null) {
            this.A = new n22(this.mContext, this.mContentView, this.E, this.F, this.G);
        }
        this.A.S0(globalGiftBean);
    }

    public void R0(LiveBuyGuardMsgBean liveBuyGuardMsgBean) {
        h1(liveBuyGuardMsgBean.getGuardNum());
        r1(liveBuyGuardMsgBean.getVotes());
        w52 w52Var = this.s;
        if (w52Var != null) {
            w52Var.V(liveBuyGuardMsgBean.getUid(), liveBuyGuardMsgBean.getGuardType());
        }
    }

    public void S0(int i2) {
        ViewGroup viewGroup = this.b;
        if (viewGroup != null) {
            if (i2 == 0 || i2 < 200) {
                viewGroup.setTranslationY(0.0f);
                return;
            }
            int i3 = this.a;
            if (i3 == 0) {
                viewGroup.setTranslationY(-i2);
            } else {
                if (i3 <= 0 || i3 >= i2) {
                    return;
                }
                viewGroup.setTranslationY(i3 - i2);
            }
        }
    }

    public void T0(String str) {
        if (j30.q().Q()) {
            return;
        }
        if (this.A == null) {
            this.A = new n22(this.mContext, this.mContentView, this.E, this.F, this.G);
        }
        this.A.C0(str);
    }

    public void U0(String str, int i2, long j2, List list, boolean z) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.w) || TextUtils.equals(str, this.w)) {
            if (j2 <= 0 || j2 > this.U) {
                if (j2 > 0) {
                    this.U = j2;
                }
                a1(list);
                q1(i2);
                if (z) {
                    return;
                }
                E1();
            }
        }
    }

    public void V0(LiveLuckGiftWinBean liveLuckGiftWinBean) {
        if (this.A == null) {
            this.A = new n22(this.mContext, this.mContentView, this.E, this.F, this.G);
        }
        this.A.U0(liveLuckGiftWinBean);
    }

    public void W0(String str) {
    }

    public void X0(LiveGiftPrizePoolWinBean liveGiftPrizePoolWinBean) {
        if (this.A == null) {
            this.A = new n22(this.mContext, this.mContentView, this.E, this.F, this.G);
        }
        this.A.W0(liveGiftPrizePoolWinBean);
    }

    public final void Z0(int i2, List list) {
        if (!(this.mContext instanceof LiveAnchorActivity) || TextUtils.isEmpty(this.w)) {
            return;
        }
        String D0 = D0(i2, list);
        if (TextUtils.equals(D0, this.T)) {
            return;
        }
        long max = Math.max(System.currentTimeMillis(), this.U + 1);
        if (((LiveActivity) this.mContext).r2(this.w, i2, max, list)) {
            this.T = D0;
            this.U = max;
        }
    }

    public final void a1(List list) {
        if (this.s == null || this.l == null || list == null) {
            return;
        }
        if (list.size() == 0) {
            this.s.R();
            return;
        }
        ArrayList arrayList = new ArrayList(list);
        Collections.reverse(arrayList);
        this.s.W(arrayList);
        this.l.postDelayed(new o(arrayList), 200L);
    }

    public final void b1() {
        if (this.B == null) {
            this.B = new m();
        }
        e32.i0(this.v, this.w, this.B);
    }

    public void c1(String str) {
    }

    public final String d1(String str) {
        return str == null ? "" : str;
    }

    public void e1(int i2) {
        LevelBean c2;
        if (this.d == null || (c2 = j30.q().c(i2)) == null) {
            return;
        }
        kn1.f(this.mContext, c2.getThumbIcon(), this.d);
    }

    public void f1(int i2) {
        View view = this.g;
        if (view != null) {
            if (i2 == 0) {
                if (view.getVisibility() != 0) {
                    this.g.setVisibility(0);
                }
            } else if (view.getVisibility() == 0) {
                this.g.setVisibility(8);
            }
        }
    }

    public void g1(String str) {
        ImageView imageView = this.c;
        if (imageView != null) {
            kn1.g(this.mContext, str, imageView);
        }
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return x73.l2;
    }

    public void h1(int i2) {
        TextView textView = this.j;
        if (textView != null) {
            if (i2 > 0) {
                textView.setText(aq4.b(m93.R9, Integer.valueOf(i2)));
            } else {
                textView.setText(m93.k5);
            }
        }
    }

    public void i1(String str, String str2, int i2) {
        this.v = str;
        this.w = str2;
        this.D = i2;
        this.T = null;
        this.U = 0L;
        this.V = false;
    }

    @Override // defpackage.b1
    public void init() {
        this.b = (ViewGroup) findViewById(b73.L4);
        this.c = (ImageView) findViewById(b73.d);
        this.d = (ImageView) findViewById(b73.A3);
        this.e = (TextView) findViewById(b73.X3);
        this.f = (TextView) findViewById(b73.Q2);
        this.g = findViewById(b73.a0);
        this.h = (TextView) findViewById(b73.j6);
        this.i = (TextView) findViewById(b73.i6);
        this.j = (TextView) findViewById(b73.L2);
        this.k = (TextView) findViewById(b73.Z5);
        this.M = (TextView) findViewById(b73.b6);
        this.W = findViewById(b73.F2);
        this.X = (ImageView) findViewById(b73.h);
        this.Y = (TextView) findViewById(b73.h4);
        this.Z = findViewById(b73.N2);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.W.getLayoutParams();
        layoutParams.topMargin = ((int) ((gk3.a().c() / 1080.0f) * 960.0f)) + zn0.a(54);
        this.W.setLayoutParams(layoutParams);
        this.k.setOnClickListener(this);
        this.M.setOnClickListener(this);
        RecyclerView findViewById = findViewById(b73.e6);
        this.l = findViewById;
        findViewById.setHasFixedSize(true);
        this.l.setLayoutManager(new LinearLayoutManager(this.mContext, 0, false));
        this.l.k(new h());
        this.l.setRotationY(180.0f);
        w52 w52Var = new w52(this.mContext);
        this.s = w52Var;
        w52Var.X(new i());
        this.l.setAdapter(this.s);
        LinearLayout linearLayout = (LinearLayout) findViewById(b73.x2);
        this.m = linearLayout;
        ViewGroup.LayoutParams layoutParams2 = linearLayout.getLayoutParams();
        layoutParams2.width = (int) (gk3.a().c() * 0.85d);
        this.m.setLayoutParams(layoutParams2);
        this.n = (TextView) findViewById(b73.q5);
        this.o = findViewById(b73.v3);
        TextView textView = (TextView) findViewById(b73.r5);
        this.p = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: h52
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i52.a0(i52.this, view);
            }
        });
        this.q = (TextView) findViewById(b73.u5);
        RecyclerView findViewById2 = findViewById(b73.p1);
        this.r = findViewById2;
        findViewById2.setHasFixedSize(true);
        this.r.setLayoutManager(new LinearLayoutManager(this.mContext, 1, false));
        h12 h12Var = new h12(this.mContext, this.v);
        this.t = h12Var;
        h12Var.Z(new j());
        this.r.setAdapter(this.t);
        this.h.setText(j30.q().F());
        this.J = findViewById(b73.B2);
        this.K = (ImageView) findViewById(b73.t2);
        this.L = (TextView) findViewById(b73.r2);
        this.N = (TextView) findViewById(b73.s2);
        findViewById(b73.l0).setOnClickListener(this);
        findViewById(b73.L).setOnClickListener(this);
        if (this.mContext instanceof LiveAudienceActivity) {
            findViewById(b73.L).setVisibility(8);
        }
        this.g.setOnClickListener(this);
        this.c.setOnClickListener(this);
        View findViewById3 = findViewById(b73.m1);
        View findViewById4 = findViewById(b73.m0);
        if (j30.q().Q()) {
            findViewById3.setVisibility(4);
            findViewById4.setVisibility(4);
        } else {
            findViewById3.setOnClickListener(this);
            findViewById4.setOnClickListener(this);
        }
        View findViewById5 = findViewById(b73.N0);
        this.u = findViewById5;
        findViewById5.setOnClickListener(this);
        TextView textView2 = (TextView) findViewById(b73.F3);
        this.H = textView2;
        Object obj = this.mContext;
        if (!(obj instanceof LiveAudienceActivity)) {
            textView2.setVisibility(0);
        } else if (!((LiveActivity) obj).L1()) {
            this.b.setOnClickListener(this);
        }
        this.x = new j32(this.mContext, this.mParentView);
        this.y = new a22(this.mContext, this.mContentView);
        this.S = new m24();
    }

    public void j1(String str) {
        TextView textView = this.e;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void k1(int i2) {
        LiveLightView.j = i2;
        this.a = i2;
    }

    public void l1(boolean z) {
        View view;
        if (j30.q().Q() || (view = this.u) == null) {
            return;
        }
        if (z) {
            if (view.getVisibility() != 0) {
                this.u.setVisibility(0);
            }
        } else if (view.getVisibility() == 0) {
            this.u.setVisibility(4);
        }
    }

    public void m1(String str) {
        TextView textView = this.f;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void n1(GoodsBean goodsBean) {
        if (j30.q().Q()) {
            return;
        }
        this.O = goodsBean;
        if (goodsBean != null) {
            View view = this.J;
            if (view != null && view.getVisibility() != 0) {
                this.J.setVisibility(0);
            }
            if (this.K != null) {
                kn1.f(this.mContext, goodsBean.getThumb(), this.K);
            }
            TextView textView = this.L;
            if (textView != null) {
                textView.setText(goodsBean.getName());
            }
            TextView textView2 = this.N;
            if (textView2 != null) {
                textView2.setText(goodsBean.getPriceNow());
                return;
            }
            return;
        }
        ImageView imageView = this.K;
        if (imageView != null) {
            imageView.setImageDrawable(null);
        }
        TextView textView3 = this.L;
        if (textView3 != null) {
            textView3.setText((CharSequence) null);
        }
        TextView textView4 = this.N;
        if (textView4 != null) {
            textView4.setText((CharSequence) null);
        }
        View view2 = this.J;
        if (view2 == null || view2.getVisibility() == 8) {
            return;
        }
        this.J.setVisibility(8);
    }

    public void o1(String str) {
        if (this.H == null) {
            return;
        }
        boolean isEmpty = str.isEmpty();
        TextView textView = this.H;
        if (isEmpty) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        this.H.setText("预览剩余时间：" + str + "秒");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (canClick()) {
            if (id == b73.d) {
                s1();
                return;
            }
            if (id == b73.a0) {
                I0();
                return;
            }
            if (id == b73.m1) {
                if (((AbsActivity) this.mContext).e1()) {
                    Y0();
                    return;
                }
                return;
            }
            if (id == b73.m0) {
                if (((AbsActivity) this.mContext).e1()) {
                    ((LiveActivity) this.mContext).c2();
                    return;
                }
                return;
            }
            if (id == b73.N0) {
                if (((AbsActivity) this.mContext).e1()) {
                    ((LiveActivity) this.mContext).j2();
                    return;
                }
                return;
            }
            if (id == b73.l0) {
                J0();
                return;
            }
            if (id != b73.L) {
                if (id == b73.Z5) {
                    ((LiveActivity) this.mContext).C2();
                    return;
                }
                return;
            }
            Object obj = this.mContext;
            if (obj instanceof LiveAnchorActivity) {
                ((LiveAnchorActivity) obj).n3();
            } else if (obj instanceof LiveAudienceActivity) {
                ((LiveAudienceActivity) obj).onBackPressed();
            }
        }
    }

    public void p1(String str) {
    }

    public void q1(int i2) {
        this.Q = i2;
        A1();
    }

    public void r1(String str) {
        TextView textView = this.i;
        if (textView != null) {
            textView.setText(str);
        }
    }

    @Override // defpackage.b1
    public void release() {
        e32.f("getUserList");
        e32.f("timeCharge");
        CommonHttpUtil.cancel(CommonHttpConsts.SET_ATTENTION);
        m24 m24Var = this.S;
        if (m24Var != null) {
            m24Var.b();
        }
        this.S = null;
        j32 j32Var = this.x;
        if (j32Var != null) {
            j32Var.a();
        }
        a22 a22Var = this.y;
        if (a22Var != null) {
            a22Var.u();
        }
        n22 n22Var = this.A;
        if (n22Var != null) {
            n22Var.H0();
        }
        this.B = null;
        this.C = null;
        a52 a52Var = this.P;
        if (a52Var != null) {
            a52Var.release();
        }
        this.P = null;
        this.T = null;
        this.U = 0L;
        this.V = false;
    }

    public final void s1() {
        if (TextUtils.isEmpty(this.v)) {
            return;
        }
        y1(this.v);
    }

    public void t1(boolean z, int i2, int i3) {
        int i4;
        if (j30.q().Q()) {
            return;
        }
        if (z || i2 >= 0 || i3 == 1) {
            if (this.P == null) {
                i4 = i2;
                a52 a52Var = new a52(this.mContext, (ViewGroup) findViewById(b73.O), z, i4, i3);
                this.P = a52Var;
                a52Var.addToParent();
                this.P.subscribeActivityLifeCycle();
            } else {
                i4 = i2;
            }
            this.P.f0(i4);
        }
    }

    public void u1(boolean z) {
        LinearLayout linearLayout = this.m;
        if (linearLayout == null) {
            return;
        }
        linearLayout.setVisibility(z ? 0 : 4);
    }

    public void v1(LiveDanMuBean liveDanMuBean) {
        TextView textView = this.i;
        if (textView != null) {
            textView.setText(liveDanMuBean.getVotes());
        }
        if (this.z == null) {
            this.z = new p12(this.mContext, this.mParentView);
        }
        this.z.f(liveDanMuBean);
    }

    public void w1(LiveReceiveGiftBean liveReceiveGiftBean) {
        if (this.A == null) {
            this.A = new n22(this.mContext, this.mContentView, this.E, this.F, this.G);
        }
        this.A.R0(liveReceiveGiftBean);
    }

    public void x1(String str) {
        if (j30.q().N()) {
            xj1.g(str, new k(str));
        }
    }

    public void y1(String str) {
        z1(str);
    }

    public void z1(String str) {
        if (TextUtils.isEmpty(this.v) || TextUtils.isEmpty(str)) {
            return;
        }
        f62 f62Var = new f62();
        f62Var.F2(new c());
        f62Var.G2(new d());
        Bundle bundle = new Bundle();
        bundle.putString("liveUid", this.v);
        bundle.putString("toUid", str);
        bundle.putInt("isSupper", 0);
        bundle.putInt("userType", ((LiveActivity) this.mContext).H1());
        f62Var.F1(bundle);
        f62Var.d2(this.mContext.getSupportFragmentManager(), "LiveUserDialogFragment");
    }
}
