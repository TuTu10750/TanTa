package com.yunbao.live.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.trtc.tuikit.common.util.ScreenUtil;
import com.uc.crashsdk.export.LogType;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.bean.UserBean;
import com.yunbao.common.custom.CustomRecyclerView;
import com.yunbao.common.custom.LiveSecondView;
import com.yunbao.common.custom.MyViewPager;
import com.yunbao.common.http.CommonHttpConsts;
import com.yunbao.common.http.CommonHttpUtil;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.common.utils.MemoryPressureUtil;
import com.yunbao.common.utils.a;
import com.yunbao.live.activity.LiveAudienceActivity;
import com.yunbao.live.bean.LiveAudienceFloatWindowData;
import com.yunbao.live.bean.LiveBean;
import com.yunbao.live.bean.VoiceRoomAccPullBean;
import com.yunbao.live.socket.SocketClient;
import defpackage.a32;
import defpackage.ab1;
import defpackage.aq4;
import defpackage.b52;
import defpackage.b73;
import defpackage.c52;
import defpackage.c82;
import defpackage.cb1;
import defpackage.d12;
import defpackage.d52;
import defpackage.e32;
import defpackage.e52;
import defpackage.et2;
import defpackage.f22;
import defpackage.g22;
import defpackage.h22;
import defpackage.h42;
import defpackage.i22;
import defpackage.i52;
import defpackage.j30;
import defpackage.jr3;
import defpackage.k12;
import defpackage.k21;
import defpackage.k32;
import defpackage.l12;
import defpackage.lx1;
import defpackage.m24;
import defpackage.m32;
import defpackage.m52;
import defpackage.m93;
import defpackage.n0;
import defpackage.n02;
import defpackage.n62;
import defpackage.o02;
import defpackage.p53;
import defpackage.pi3;
import defpackage.pr3;
import defpackage.pw3;
import defpackage.qz1;
import defpackage.r62;
import defpackage.rv3;
import defpackage.s93;
import defpackage.t32;
import defpackage.t54;
import defpackage.ud1;
import defpackage.uo2;
import defpackage.vq2;
import defpackage.vx2;
import defpackage.x73;
import defpackage.ya2;
import defpackage.yx2;
import defpackage.z12;
import defpackage.zn0;
import defpackage.zt2;
import defpackage.zu0;
import java.util.Arrays;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;
import pl.droidsonroids.gif.GifImageView;

/* loaded from: /tmp/classes2.dex */
public class LiveAudienceActivity extends LiveActivity implements f22, View.OnClickListener {
    public static final LinearInterpolator M0 = new LinearInterpolator();
    public String A0;
    public CustomRecyclerView B0;
    public ya2 C0;
    public LinearLayout D0;
    public TextView E0;
    public View F0;
    public int I0;
    public uo2 J0;
    public m24 K0;
    public boolean L0;
    public String W;
    public int X;
    public RecyclerView Y;
    public e52 Z;
    public View f0;
    public MyViewPager g0;
    public View h0;
    public LiveSecondView i0;
    public FrameLayout j0;
    public d52 k0;
    public o02 l0;
    public n62 m0;
    public boolean n0;
    public boolean o0;
    public c52 p0;
    public boolean q0;
    public TextView r0;
    public View s0;
    public View t0;
    public int u0;
    public View v0;
    public Handler w0;
    public boolean x0;
    public boolean y0;
    public boolean z0;
    public boolean V = true;
    public boolean G0 = false;
    public boolean H0 = true;

    /* loaded from: /tmp/classes2.dex */
    public class a implements l12.b {

        /* renamed from: com.yunbao.live.activity.LiveAudienceActivity$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/classes2.dex */
        public class C0036a extends HttpCallback {

            /* renamed from: com.yunbao.live.activity.LiveAudienceActivity$a$a$a, reason: collision with other inner class name */
            /* loaded from: /tmp/classes2.dex */
            public class C0037a implements a.l {
                public C0037a() {
                }

                @Override // com.yunbao.common.utils.a.l
                public void a() {
                    LiveAudienceActivity.this.E3();
                }

                @Override // com.yunbao.common.utils.a.m
                public void b(Dialog dialog, String str) {
                    pi3.t();
                    LiveAudienceActivity.this.f4();
                }
            }

            public C0036a() {
            }

            @Override // com.yunbao.common.http.HttpCallback
            public void onSuccess(int i, String str, String[] strArr) {
                UserBean D;
                if (LiveAudienceActivity.this.isFinishing() || LiveAudienceActivity.this.isDestroyed()) {
                    return;
                }
                if (i == 0) {
                    LiveAudienceActivity.this.X3();
                    JSONObject T3 = LiveAudienceActivity.this.T3(strArr, "roomCharge");
                    if (T3 == null || (D = j30.q().D()) == null) {
                        return;
                    }
                    D.setLevel(T3.getIntValue("level"));
                    D.setCoin(T3.getString("coin"));
                    return;
                }
                if (i != 1008) {
                    t54.b(str);
                    LiveAudienceActivity.this.E3();
                } else {
                    if (LiveAudienceActivity.this.K0 != null) {
                        LiveAudienceActivity.this.K0.c("timeCharge");
                    }
                    LiveAudienceActivity.this.c4(new C0037a());
                }
            }
        }

        /* loaded from: /tmp/classes2.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                LiveAudienceActivity.this.W3(0);
            }
        }

        public a() {
        }

        @Override // l12.b
        public void a() {
            LiveAudienceActivity.this.E3();
        }

        @Override // l12.b
        public void b() {
            LiveAudienceActivity liveAudienceActivity = LiveAudienceActivity.this;
            int i = liveAudienceActivity.C;
            if (i == 2) {
                e32.w0(liveAudienceActivity.z, liveAudienceActivity.y, new C0036a());
                return;
            }
            if (i == 3) {
                liveAudienceActivity.W3(1);
                if (LiveAudienceActivity.this.K0 == null) {
                    LiveAudienceActivity.this.K0 = new m24();
                }
                LiveAudienceActivity.this.K0.d("timeCharge", 60000L, 60000L, new b());
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends HttpCallback {
        public final /* synthetic */ int a;

        /* loaded from: /tmp/classes2.dex */
        public class a implements a.l {
            public a() {
            }

            @Override // com.yunbao.common.utils.a.l
            public void a() {
                LiveAudienceActivity.this.E3();
            }

            @Override // com.yunbao.common.utils.a.m
            public void b(Dialog dialog, String str) {
                pi3.t();
                b bVar = b.this;
                LiveAudienceActivity.this.W3(bVar.a);
            }
        }

        public b(int i) {
            this.a = i;
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            UserBean D;
            if (LiveAudienceActivity.this.isFinishing() || LiveAudienceActivity.this.isDestroyed()) {
                return;
            }
            if (i == 0) {
                JSONObject T3 = LiveAudienceActivity.this.T3(strArr, "timeCharge");
                if (T3 != null && (D = j30.q().D()) != null) {
                    D.setLevel(T3.getIntValue("level"));
                    D.setCoin(T3.getString("coin"));
                }
                LiveAudienceActivity.this.X3();
                return;
            }
            LiveAudienceActivity liveAudienceActivity = LiveAudienceActivity.this;
            if (i != 1008) {
                if (liveAudienceActivity.K0 != null) {
                    LiveAudienceActivity.this.K0.c("timeCharge");
                }
                t54.b(str);
                LiveAudienceActivity.this.E3();
                return;
            }
            liveAudienceActivity.U3();
            LiveAudienceActivity.this.o0 = true;
            if (LiveAudienceActivity.this.K0 != null) {
                LiveAudienceActivity.this.K0.c("timeCharge");
            }
            LiveAudienceActivity.this.c4(new a());
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c implements a.n {
        public c() {
        }

        @Override // com.yunbao.common.utils.a.n
        public void a(String str, int i) {
            if (i != m93.G) {
                if (i == m93.F) {
                    k12.c().e(false);
                    LiveAudienceActivity.this.E3();
                    return;
                }
                return;
            }
            if (LiveAudienceActivity.this.n0) {
                k12.c().e(false);
                LiveAudienceActivity.this.E3();
            } else {
                k12.c().e(true);
                LiveAudienceActivity.this.E3();
                zu0.c().j(new n02(LiveAudienceActivity.this.t, null));
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d extends HttpCallback {
        public d() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (LiveAudienceActivity.this.isFinishing() || LiveAudienceActivity.this.isDestroyed()) {
                return;
            }
            if (i == 0) {
                pr3.d(LiveAudienceActivity.this.s, j30.q().C(), 0);
            }
            t54.b(str);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e extends vx2 {
        public e() {
        }

        @Override // defpackage.vx2
        public void a() {
            LiveAudienceActivity.this.D2();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class f extends HttpCallback {
        public f() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            JSONObject T3;
            if (LiveAudienceActivity.this.isFinishing() || LiveAudienceActivity.this.isDestroyed() || i != 0 || (T3 = LiveAudienceActivity.this.T3(strArr, "getVoiceMicStream")) == null) {
                return;
            }
            T3.getString("push");
            T3.getString("user_stream");
            LiveAudienceActivity.this.getClass();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class g extends HttpCallback {
        public g() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            List<VoiceRoomAccPullBean> parseArray;
            if (LiveAudienceActivity.this.isFinishing() || LiveAudienceActivity.this.isDestroyed() || i != 0 || strArr == null || strArr.length <= 0 || (parseArray = JSON.parseArray(Arrays.toString(strArr), VoiceRoomAccPullBean.class)) == null) {
                return;
            }
            for (VoiceRoomAccPullBean voiceRoomAccPullBean : parseArray) {
                if (voiceRoomAccPullBean != null) {
                    int isAnchor = voiceRoomAccPullBean.getIsAnchor();
                    LiveAudienceActivity liveAudienceActivity = LiveAudienceActivity.this;
                    if (isAnchor == 1) {
                        LiveAudienceActivity.m3(liveAudienceActivity);
                    } else {
                        liveAudienceActivity.getClass();
                    }
                }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class h extends HttpCallback {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        public h(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            JSONObject T3;
            if (LiveAudienceActivity.this.isFinishing() || LiveAudienceActivity.this.isDestroyed() || i != 0 || (T3 = LiveAudienceActivity.this.T3(strArr, "getNewUpMicPullUrl")) == null) {
                return;
            }
            T3.getString("play_url");
            LiveAudienceActivity.this.getClass();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class i implements LiveSecondView.b {
        public i() {
        }

        @Override // com.yunbao.common.custom.LiveSecondView.b
        public void a(float f, float f2) {
            LiveAudienceActivity.this.g4(f, f2);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class j implements vq2.b {
        public j() {
        }

        @Override // vq2.b
        public void a() {
            LiveAudienceActivity.this.E3();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class k implements Runnable {
        public k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (LiveAudienceActivity.this.t0 == null || LiveAudienceActivity.this.t0.getVisibility() != 0) {
                return;
            }
            LiveAudienceActivity.this.t0.setVisibility(4);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class l implements Runnable {
        public l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (LiveAudienceActivity.this.t0 == null || LiveAudienceActivity.this.t0.getVisibility() != 0) {
                return;
            }
            LiveAudienceActivity.this.t0.setVisibility(4);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class m implements View.OnClickListener {
        public final /* synthetic */ PopupWindow a;

        public m(PopupWindow popupWindow) {
            this.a = popupWindow;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            if (id == b73.v0) {
                this.a.dismiss();
                LiveAudienceActivity.this.R3();
            } else if (id == b73.u0) {
                this.a.dismiss();
                LiveAudienceActivity.this.Q3();
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class n implements i22.f {
        public n() {
        }

        @Override // i22.f
        public void a(String str) {
            jr3.b(LiveAudienceActivity.this.s, str);
        }

        @Override // i22.f
        public void b() {
            LiveAudienceActivity.this.S1();
        }

        @Override // i22.f
        public void c() {
            LiveAudienceActivity.this.S = null;
        }

        @Override // i22.f
        public void d() {
            LiveAudienceActivity.this.b2(true);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class o implements h22.h {
        public o() {
        }

        @Override // h22.h
        public void a(String str) {
            jr3.a(LiveAudienceActivity.this.s, str);
        }

        @Override // h22.h
        public void b() {
            LiveAudienceActivity.this.S1();
        }

        @Override // h22.h
        public void c() {
            LiveAudienceActivity.this.T = null;
        }

        @Override // h22.h
        public void d() {
            LiveAudienceActivity.this.b2(true);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class p extends xv2 {
        public p() {
        }

        public void a(ViewGroup viewGroup, int i, Object obj) {
        }

        public int d() {
            return 2;
        }

        public Object h(ViewGroup viewGroup, int i) {
            LiveAudienceActivity liveAudienceActivity = LiveAudienceActivity.this;
            if (i == 0) {
                viewGroup.addView(liveAudienceActivity.h0);
                return LiveAudienceActivity.this.h0;
            }
            viewGroup.addView(liveAudienceActivity.i0);
            return LiveAudienceActivity.this.i0;
        }

        public boolean i(View view, Object obj) {
            return view == obj;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class q implements e52.c {
        public q() {
        }

        @Override // e52.c
        public void a(LiveBean liveBean, ViewGroup viewGroup, boolean z) {
            if (LiveAudienceActivity.this.f0 != null && viewGroup != null) {
                ViewParent parent = LiveAudienceActivity.this.f0.getParent();
                if (parent != null) {
                    ViewGroup viewGroup2 = (ViewGroup) parent;
                    if (viewGroup2 != viewGroup) {
                        viewGroup2.removeView(LiveAudienceActivity.this.f0);
                        viewGroup.addView(LiveAudienceActivity.this.f0);
                    }
                } else {
                    viewGroup.addView(LiveAudienceActivity.this.f0);
                }
            }
            if (z) {
                return;
            }
            LiveAudienceActivity.this.x3(liveBean);
        }

        @Override // e52.c
        public void b(String str) {
            if (TextUtils.isEmpty(LiveAudienceActivity.this.z) || LiveAudienceActivity.this.z.equals(str)) {
                e32.f("checkLive");
                e32.f("enterRoom");
                e32.f("roomCharge");
                LiveAudienceActivity.this.y3();
            }
        }

        @Override // e52.c
        public void c(String str) {
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class r implements Runnable {
        public r() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LiveAudienceActivity.this.finish();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class s extends AnimatorListenerAdapter {
        public final /* synthetic */ float a;
        public final /* synthetic */ float b;

        public s(float f, float f2) {
            this.a = f;
            this.b = f2;
        }

        public final void a(boolean z) {
            float f = this.a;
            float f2 = this.b;
            LiveAudienceActivity liveAudienceActivity = LiveAudienceActivity.this;
            if (f > f2) {
                liveAudienceActivity.i0.setRecommendShow(true);
                LiveAudienceActivity.this.G0 = true;
            } else {
                liveAudienceActivity.i0.setRecommendShow(false);
                LiveAudienceActivity.this.G0 = false;
            }
            if (z) {
                LiveAudienceActivity.this.D0.getX();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            a(true);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a(false);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class t extends HttpCallback {

        /* loaded from: /tmp/classes2.dex */
        public class a implements et2 {
            public a() {
            }

            @Override // defpackage.et2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onItemClick(LiveBean liveBean, int i) {
                Log.i("9527", "onItemClick");
                int screenWidth = ScreenUtil.getScreenWidth(LiveAudienceActivity.this.b);
                LiveAudienceActivity.this.g4(screenWidth - r0.D0.getWidth(), screenWidth);
                LiveAudienceActivity.this.i4(liveBean);
            }
        }

        public t() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (LiveAudienceActivity.this.isFinishing() || LiveAudienceActivity.this.isDestroyed() || i != 0 || strArr == null || strArr.length <= 0) {
                return;
            }
            List parseArray = JSON.parseArray(Arrays.toString(strArr), LiveBean.class);
            ya2 ya2Var = LiveAudienceActivity.this.C0;
            LiveAudienceActivity liveAudienceActivity = LiveAudienceActivity.this;
            if (ya2Var != null) {
                liveAudienceActivity.C0.P(parseArray);
                return;
            }
            liveAudienceActivity.C0 = new ya2(liveAudienceActivity.b, parseArray);
            LiveAudienceActivity.this.C0.R(new a());
            LiveAudienceActivity.this.B0.setAdapter(LiveAudienceActivity.this.C0);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class u implements uo2.c {
        public u() {
        }

        @Override // uo2.c
        public void a(String str) {
            lx1.c("9999", "预览时间：" + str);
            i52 i52Var = LiveAudienceActivity.this.g;
            if (i52Var != null) {
                i52Var.o1(str);
            }
        }

        @Override // uo2.c
        public void c() {
            lx1.c("9999", "结束预览");
            i52 i52Var = LiveAudienceActivity.this.g;
            if (i52Var != null) {
                i52Var.o1("");
            }
            LiveAudienceActivity.this.f4();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class v implements c52.c {
        public v() {
        }

        @Override // c52.c
        public void a(LiveBean liveBean, int i, int i2, int i3) {
            if (LiveAudienceActivity.this.isFinishing() || LiveAudienceActivity.this.isDestroyed() || liveBean == null || !LiveAudienceActivity.this.Z3(liveBean)) {
                return;
            }
            LiveAudienceActivity liveAudienceActivity = LiveAudienceActivity.this;
            liveAudienceActivity.C = i;
            liveAudienceActivity.D = i2;
            if (liveAudienceActivity.Z != null) {
                LiveAudienceActivity.this.Z.R();
            }
            LiveAudienceActivity.this.D3();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class w extends HttpCallback {

        /* loaded from: /tmp/classes2.dex */
        public class a implements uo2.c {
            public a() {
            }

            @Override // uo2.c
            public void a(String str) {
                lx1.c("9999", "预览时间：" + str);
                i52 i52Var = LiveAudienceActivity.this.g;
                if (i52Var != null) {
                    i52Var.o1(str);
                }
            }

            @Override // uo2.c
            public void c() {
                lx1.c("9999", "结束预览");
                i52 i52Var = LiveAudienceActivity.this.g;
                if (i52Var != null) {
                    i52Var.o1("");
                }
                LiveAudienceActivity.this.f4();
            }
        }

        public w() {
        }

        /* JADX WARN: Removed duplicated region for block: B:106:0x0221  */
        /* JADX WARN: Removed duplicated region for block: B:127:0x02b0  */
        /* JADX WARN: Removed duplicated region for block: B:130:0x02bc  */
        /* JADX WARN: Removed duplicated region for block: B:137:0x0300  */
        /* JADX WARN: Removed duplicated region for block: B:140:0x0309  */
        @Override // com.yunbao.common.http.HttpCallback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onSuccess(int r20, java.lang.String r21, java.lang.String[] r22) {
            /*
                Method dump skipped, instructions count: 1093
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.yunbao.live.activity.LiveAudienceActivity.w.onSuccess(int, java.lang.String, java.lang.String[]):void");
        }
    }

    public static /* synthetic */ void E2(LiveAudienceActivity liveAudienceActivity, View view) {
        int screenWidth = ScreenUtil.getScreenWidth(liveAudienceActivity.b);
        Log.i("9527", "width :" + liveAudienceActivity.D0.getWidth());
        liveAudienceActivity.g4((float) (screenWidth - liveAudienceActivity.D0.getWidth()), (float) screenWidth);
    }

    public static /* synthetic */ void F2(LiveAudienceActivity liveAudienceActivity, View view) {
        int screenWidth = ScreenUtil.getScreenWidth(liveAudienceActivity.b);
        Log.i("9527", "width :" + liveAudienceActivity.D0.getWidth());
        liveAudienceActivity.g4((float) screenWidth, (float) (screenWidth - liveAudienceActivity.D0.getWidth()));
    }

    public static void F3(Context context, LiveBean liveBean, int i2, int i3, String str, int i4, int i5, boolean z, int i6) {
        boolean z2 = context instanceof Activity;
        if (z2) {
            Activity activity = (Activity) context;
            if (activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
        }
        Intent intent = new Intent(context, (Class<?>) LiveAudienceActivity.class);
        intent.putExtra("liveBean", liveBean);
        intent.putExtra("liveType", i2);
        intent.putExtra("liveTypeVal", i3);
        intent.putExtra("liveKey", str);
        intent.putExtra("livePosition", i4);
        intent.putExtra("liveSdk", i5);
        intent.putExtra("isChatRoom", z);
        intent.putExtra("voiceChatRoomType", i6);
        if (context instanceof FragmentActivity) {
            ((FragmentActivity) context).startActivityForResult(intent, 0);
        } else if (z2) {
            ((Activity) context).startActivityForResult(intent, 0);
        } else {
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }

    public static /* synthetic */ n0 m3(LiveAudienceActivity liveAudienceActivity) {
        liveAudienceActivity.getClass();
        return null;
    }

    @Override // com.yunbao.live.activity.LiveActivity, defpackage.or3
    public void A0() {
        super.A0();
        C3();
        if (I3()) {
            a4();
        }
        View view = this.v0;
        if (view != null && view.getVisibility() == 0) {
            this.v0.setVisibility(4);
        }
        MyViewPager myViewPager = this.g0;
        if (myViewPager != null) {
            if (myViewPager.getCurrentItem() != 1) {
                this.g0.M(1, false);
            }
            this.g0.setCanScroll(false);
        }
        if (this.n == null) {
            z12 z12Var = new z12(this.b, this.i0);
            this.n = z12Var;
            z12Var.subscribeActivityLifeCycle();
            this.n.addToParent();
        }
        this.n.e0(this.t, this.y);
        b4(true);
    }

    public void A3() {
        if (J3()) {
            e32.O0(this.y, new d());
        } else {
            yx2.a(this, new e(), "android.permission.RECORD_AUDIO", "android.permission.CAMERA");
        }
    }

    public void B3() {
    }

    public final void C3() {
        if (this.n0) {
            return;
        }
        this.n0 = true;
        SocketClient socketClient = this.s;
        if (socketClient != null) {
            socketClient.y();
        }
        this.s = null;
        d52 d52Var = this.k0;
        if (d52Var != null) {
            d52Var.release();
        }
        this.k0 = null;
        m2();
    }

    public final void D3() {
        e32.s(this.z, this.y, new w());
    }

    @Override // com.yunbao.live.activity.LiveActivity, defpackage.or3
    public void E(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || str.equals(j30.q().C()) || !Q1() || !J3()) {
            return;
        }
        e32.Z(str3, new h(str, str3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void E3() {
        C3();
        finish();
    }

    public final LiveAudienceFloatWindowData G3() {
        LiveAudienceFloatWindowData liveAudienceFloatWindowData = new LiveAudienceFloatWindowData();
        liveAudienceFloatWindowData.setTxSDK(Q1());
        liveAudienceFloatWindowData.setAgoraToken(this.A0);
        liveAudienceFloatWindowData.setLiveUid(rv3.h(this.z, -1));
        liveAudienceFloatWindowData.setStream(this.y);
        liveAudienceFloatWindowData.setLinkMicAudienceUid(D1());
        liveAudienceFloatWindowData.setPkUid(C1());
        return liveAudienceFloatWindowData;
    }

    public final void H3() {
        e32.H(this.z, new t());
    }

    @Override // com.yunbao.live.activity.LiveActivity, defpackage.or3
    public void I(String str, int i2, int i3) {
        super.I(str, i2, i3);
        if (TextUtils.isEmpty(str) || !str.equals(j30.q().C())) {
            return;
        }
        if (i3 == 1) {
            t54.a(m93.E);
            n62 n62Var = this.m0;
            if (n62Var != null) {
                n62Var.e0(false);
                return;
            }
            return;
        }
        if (i3 == -1) {
            t54.a(m93.D);
            n62 n62Var2 = this.m0;
            if (n62Var2 != null) {
                n62Var2.e0(true);
            }
        }
    }

    public boolean I3() {
        return getResources().getConfiguration().orientation == 2;
    }

    public final boolean J3() {
        return false;
    }

    public final boolean K3() {
        return false;
    }

    public void L3() {
        jr3.c(this.s);
    }

    public void M3(boolean z) {
        d52 d52Var = this.k0;
        if (d52Var != null) {
            d52Var.i0(z, 2000);
        }
    }

    @Override // com.yunbao.live.activity.LiveActivity, defpackage.or3
    public void N(int i2, int i3, String str) {
        super.N(i2, i3, str);
        this.C = i2;
        this.D = i3;
        m24 m24Var = this.K0;
        if (m24Var != null) {
            m24Var.b();
        }
        uo2 uo2Var = this.J0;
        if (uo2Var != null) {
            uo2Var.k();
        }
        if (this.C != 0) {
            uo2 l2 = new uo2().l(new u());
            this.J0 = l2;
            l2.m(30).n();
        } else {
            i52 i52Var = this.g;
            if (i52Var != null) {
                i52Var.o1("");
            }
        }
    }

    public void N3(int i2, int i3) {
        if (this.n0) {
            return;
        }
        LiveBean liveBean = this.t;
        if (liveBean == null || liveBean.getAnyway() != 0) {
            View view = this.v0;
            if (i2 <= 0) {
                if (view == null || view.getVisibility() != 0) {
                    return;
                }
                this.v0.setVisibility(4);
                return;
            }
            if (view != null) {
                if (view.getVisibility() != 0) {
                    this.v0.setVisibility(0);
                }
                this.v0.setY((((i3 - i2) / 2) + i2) - zn0.a(35));
            }
        }
    }

    public void O3() {
        new k21().d2(getSupportFragmentManager(), "FirstChargeDialogFragment");
    }

    public void P3() {
        jr3.c(this.s);
        a32 a32Var = new a32();
        Bundle bundle = new Bundle();
        bundle.putString("liveUid", this.z);
        a32Var.F1(bundle);
        a32Var.d2(getSupportFragmentManager(), "LiveGoodsDialogFragment");
    }

    public void Q3() {
        h22 h22Var = new h22();
        Bundle bundle = new Bundle();
        bundle.putString("liveUid", this.z);
        bundle.putString("stream", this.y);
        h22Var.F1(bundle);
        h22Var.W2(new o());
        h22Var.d2(((AbsActivity) this.b).getSupportFragmentManager(), "LiveGameLuckPanDialog");
        this.T = h22Var;
    }

    public void R3() {
        i22 i22Var = new i22();
        Bundle bundle = new Bundle();
        bundle.putString("liveUid", this.z);
        bundle.putString("stream", this.y);
        i22Var.F1(bundle);
        i22Var.W2(new n());
        i22Var.d2(((AbsActivity) this.b).getSupportFragmentManager(), "LiveGameStarDialog");
        this.S = i22Var;
    }

    public void S3() {
        new r62().d2(getSupportFragmentManager(), "LiveVoiceFaceFragment");
    }

    public final JSONObject T3(String[] strArr, String str) {
        if (strArr == null || strArr.length == 0 || TextUtils.isEmpty(strArr[0])) {
            lx1.c("LiveAudienceActivity", str + " response info empty");
            return null;
        }
        try {
            return JSON.parseObject(strArr[0]);
        } catch (RuntimeException e2) {
            lx1.c("LiveAudienceActivity", str + " parse response failed: " + e2.getMessage());
            return null;
        }
    }

    @Override // com.yunbao.live.activity.LiveActivity
    public void U1(UserBean userBean, boolean z) {
        super.U1(userBean, z);
        this.l0.d0();
    }

    public void U3() {
        lx1.c("LiveTxPlayViewHolder", "暂停播放");
        d52 d52Var = this.k0;
        if (d52Var != null) {
            d52Var.d0();
        }
    }

    @Override // com.yunbao.live.activity.LiveActivity
    public void V1(String str) {
        if (this.I0 == 1) {
            t54.b("您已经被禁言");
        } else {
            super.V1(str);
        }
    }

    public final boolean V3() {
        if (MemoryPressureUtil.h() == MemoryPressureUtil.Level.NORMAL) {
            return true;
        }
        lx1.c("LiveAudienceActivity", "live enter low memory, available=" + MemoryPressureUtil.g());
        try {
            CommonHttpUtil.cancel(CommonHttpConsts.DOWNLOAD_GIF);
        } catch (Throwable th) {
            lx1.c("LiveAudienceActivity", "cancel gif before live enter failed: " + th.getMessage());
        }
        MemoryPressureUtil.e();
        if (!MemoryPressureUtil.i()) {
            lx1.c("LiveAudienceActivity", "live enter memory recovered, available=" + MemoryPressureUtil.g());
            return true;
        }
        lx1.c("LiveAudienceActivity", "abort live enter for critical memory, available=" + MemoryPressureUtil.g());
        MemoryPressureUtil.m(new r());
        return false;
    }

    @Override // com.yunbao.live.activity.LiveActivity, defpackage.or3
    public void W(String str, int i2) {
        if (TextUtils.isEmpty(str) || !str.equals(j30.q().C())) {
            System.out.println("socket----onVoiceRoomDownMic----");
            return;
        }
        n62 n62Var = this.m0;
        if (n62Var != null) {
            n62Var.b0(false);
        }
        if (i2 == 1 || i2 == 2) {
            t54.a(m93.C);
        }
    }

    public final void W3(int i2) {
        e32.M0(this.z, this.y, i2, new b(i2));
    }

    public void X3() {
        lx1.c("LiveTxPlayViewHolder", "恢复播放");
        d52 d52Var = this.k0;
        if (d52Var != null) {
            d52Var.h0();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void Y3() {
        MyViewPager myViewPager = this.g0;
        if (myViewPager != null) {
            int currentItem = myViewPager.getCurrentItem();
            this.u0 = currentItem;
            if (currentItem != 0) {
                this.g0.M(0, false);
            }
            this.g0.setCanScroll(false);
        }
        b4(true);
        setRequestedOrientation(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean Z3(LiveBean liveBean) {
        if (isFinishing() || isDestroyed()) {
            return false;
        }
        if (liveBean == null) {
            lx1.c("LiveAudienceActivity", "skip setLiveRoomData: liveBean is null");
            return false;
        }
        if (this.g == null) {
            lx1.c("LiveAudienceActivity", "skip setLiveRoomData: room view holder is null");
            return false;
        }
        if (!L1() && (this.k0 == null || this.l0 == null)) {
            lx1.c("LiveAudienceActivity", "skip setLiveRoomData: audience view holder is null");
            return false;
        }
        this.t = liveBean;
        this.z = liveBean.getUid();
        this.y = liveBean.getStream();
        this.g.g1(liveBean.getAvatar());
        this.g.e1(liveBean.getLevelAnchor());
        this.g.j1(liveBean.getUserNiceName());
        TextView textView = this.r0;
        if (textView != null) {
            textView.setText(liveBean.getUserNiceName());
        }
        this.g.m1(liveBean.getLiangNameTip());
        this.g.p1(liveBean.getTitle());
        if (!L1()) {
            this.k0.j0(liveBean.getThumb());
            m32 m32Var = this.q;
            if (m32Var != null) {
                m32Var.U(this.z);
            }
            t32 t32Var = this.o;
            if (t32Var != null) {
                t32Var.V(this.z);
            }
            this.l0.g0(this.z, this.y);
            this.l0.h0(liveBean.getIsshop() == 1);
        }
        return true;
    }

    @Override // defpackage.f22
    public void a(int i2) {
        if (i2 != 2002) {
            if (i2 == 2005) {
                pi3.u();
                return;
            }
            if (i2 == 2007) {
                k2();
                return;
            }
            if (i2 == 2021) {
                t32 t32Var = this.o;
                if (t32Var != null) {
                    if (this.L0) {
                        t32Var.T();
                    } else {
                        t32Var.Y();
                    }
                    this.L0 = !this.L0;
                    return;
                }
                return;
            }
            if (i2 == 2026) {
                LiveReportActivity.A1(this.b, this.z, "live");
                return;
            }
            switch (i2) {
                case 2010:
                    Y1();
                    return;
                case 2011:
                    i2();
                    return;
                case 2012:
                    h2();
                    return;
                case 2013:
                    T1();
                    return;
                case 2014:
                    S3();
                    return;
                case 2015:
                    t32 t32Var2 = this.o;
                    if (t32Var2 != null) {
                        t32Var2.Q();
                        this.L0 = false;
                        break;
                    }
                    break;
                default:
                    return;
            }
        }
        this.o.Z();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a4() {
        MyViewPager myViewPager = this.g0;
        if (myViewPager != null) {
            int i2 = this.u0;
            if (i2 != 0) {
                myViewPager.M(i2, false);
            }
            this.g0.setCanScroll(true);
        }
        b4(false);
        setRequestedOrientation(1);
    }

    public void b4(boolean z) {
        RecyclerView recyclerView;
        if (!K3() || (recyclerView = this.Y) == null) {
            return;
        }
        recyclerView.setLayoutFrozen(z);
    }

    public final void c4(a.l lVar) {
        if (w3()) {
            try {
                com.yunbao.common.utils.a.k(this.b, aq4.a(m93.w3), false, lVar);
            } catch (RuntimeException e2) {
                lx1.c("LiveAudienceActivity", "show coin not enough dialog failed: " + e2.getMessage());
            }
        }
    }

    public void d4() {
        g22 g22Var = new g22();
        Bundle bundle = new Bundle();
        bundle.putBoolean("HAS_MSG", true);
        bundle.putBoolean("isMute", this.L0);
        t32 t32Var = this.o;
        bundle.putBoolean("linkMic", t32Var != null ? t32Var.F() : false);
        g22Var.F1(bundle);
        g22Var.s2(this);
        g22Var.d2(getSupportFragmentManager(), "LiveFunctionDialogFragment");
    }

    public void e4(boolean z) {
        g22 g22Var = new g22();
        Bundle bundle = new Bundle();
        bundle.putBoolean("hasGame", false);
        bundle.putBoolean("openFlash", false);
        bundle.putBoolean("TASK", this.Q);
        bundle.putBoolean("LUCK_PAN", this.x0);
        bundle.putBoolean("HAS_FACE", z);
        bundle.putBoolean("HAS_MSG", false);
        t32 t32Var = this.o;
        bundle.putBoolean("linkMic", t32Var != null ? t32Var.F() : false);
        g22Var.F1(bundle);
        g22Var.s2(this);
        g22Var.d2(getSupportFragmentManager(), "LiveFunctionDialogFragment");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void f1() {
        Intent intent = getIntent();
        this.N = intent.getBooleanExtra("isChatRoom", false);
        v2(intent.getIntExtra("voiceChatRoomType", 0));
        this.u = 1;
        String stringExtra = intent.getStringExtra("liveKey");
        this.W = stringExtra;
        if (TextUtils.isEmpty(stringExtra)) {
            this.V = false;
        }
        this.X = intent.getIntExtra("livePosition", 0);
        this.C = intent.getIntExtra("liveType", 0);
        this.D = intent.getIntExtra("liveTypeVal", 0);
        this.t = (LiveBean) intent.getParcelableExtra("liveBean");
    }

    public final void f4() {
        if (w3()) {
            lx1.c("9999", "遮住画面");
            U3();
            l12 l12Var = new l12();
            l12Var.s2(this.C, String.valueOf(this.D));
            l12Var.r2(new a());
            try {
                l12Var.t2(this.b.getSupportFragmentManager(), "LiveRoomCheckDialogFragment2");
            } catch (RuntimeException e2) {
                lx1.c("LiveAudienceActivity", "show pay room dialog failed: " + e2.getMessage());
            }
        }
    }

    public View findViewById(int i2) {
        View view;
        return (!K3() || (view = this.f0) == null) ? super.findViewById(i2) : view.findViewById(i2);
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return K3() ? x73.e : x73.d;
    }

    public final void g4(float f2, float f3) {
        if (f2 > f3) {
            H3();
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.D0, "X", f2, f3);
        ofFloat.setInterpolator(M0);
        ofFloat.setDuration(200L);
        ofFloat.addListener(new s(f2, f3));
        ofFloat.start();
    }

    public void h4(boolean z) {
        d52 d52Var = this.k0;
        if (d52Var != null) {
            d52Var.l0(z);
        }
    }

    public final void i4(LiveBean liveBean) {
        e32.f("checkLive");
        e32.f("enterRoom");
        e32.f("roomCharge");
        y3();
        x3(liveBean);
    }

    public void j4(int i2) {
        pr3.e(this.s, i2);
    }

    @Override // com.yunbao.live.activity.LiveActivity, defpackage.or3
    public void l(String str) {
        if (TextUtils.isEmpty(str) || !str.equals(j30.q().C())) {
            return;
        }
        E3();
        t54.b(aq4.a(m93.O3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.live.activity.LiveActivity, com.yunbao.common.activity.AbsActivity
    public void m1() {
        d12.E("audienceActivity.main");
        if (V3()) {
            setVolumeControlStream(3);
            if (K3()) {
                RecyclerView findViewById = super.findViewById(b73.B4);
                this.Y = findViewById;
                findViewById.setHasFixedSize(true);
                this.Y.setLayoutManager(new LinearLayoutManager(this.b, 1, false));
                this.f0 = LayoutInflater.from(this.b).inflate(x73.d, (ViewGroup) null, false);
            }
            super.m1();
            if (!L1()) {
                this.k0 = new h42(this.b, (ViewGroup) findViewById(b73.r4));
            }
            this.k0.addToParent();
            this.k0.subscribeActivityLifeCycle();
            this.g0 = (MyViewPager) findViewById(b73.g6);
            if (L1()) {
                View view = new View(this.b);
                this.h0 = view;
                view.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            } else {
                View inflate = LayoutInflater.from(this.b).inflate(x73.s1, (ViewGroup) this.g0, false);
                this.h0 = inflate;
                this.r0 = (TextView) inflate.findViewById(b73.g4);
                View findViewById2 = this.h0.findViewById(b73.b0);
                this.s0 = findViewById2;
                findViewById2.setOnClickListener(this);
                this.t0 = this.h0.findViewById(b73.A2);
                this.h0.findViewById(b73.y).setOnClickListener(this);
                this.h0.findViewById(b73.M4).setOnClickListener(this);
            }
            LiveSecondView liveSecondView = (LiveSecondView) LayoutInflater.from(this.b).inflate(x73.r1, (ViewGroup) this.g0, false);
            this.i0 = liveSecondView;
            liveSecondView.setMoveAction(new i());
            this.i0.d();
            this.j0 = (FrameLayout) this.i0.findViewById(b73.B1);
            ViewGroup viewGroup = (ViewGroup) this.i0.findViewById(b73.A1);
            this.e = viewGroup;
            i52 i52Var = new i52(this.b, viewGroup, (GifImageView) this.i0.findViewById(b73.c2), this.i0.findViewById(b73.j2), this.j0);
            this.g = i52Var;
            i52Var.addToParent();
            this.g.subscribeActivityLifeCycle();
            View findViewById3 = findViewById(b73.q0);
            this.v0 = findViewById3;
            findViewById3.setOnClickListener(this);
            this.D0 = (LinearLayout) this.i0.findViewById(b73.K3);
            this.E0 = (TextView) this.i0.findViewById(b73.L5);
            this.F0 = this.i0.findViewById(b73.L3);
            CustomRecyclerView customRecyclerView = (CustomRecyclerView) this.i0.findViewById(b73.C4);
            this.B0 = customRecyclerView;
            customRecyclerView.setLayoutManager(new LinearLayoutManager(this.b, 1, false));
            ud1 ud1Var = new ud1(1, zn0.a(6), false);
            this.i0.setRecommendLayout(this.D0);
            this.B0.k(ud1Var);
            this.E0.setOnClickListener(new View.OnClickListener() { // from class: l02
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LiveAudienceActivity.F2(LiveAudienceActivity.this, view2);
                }
            });
            this.F0.setOnClickListener(new View.OnClickListener() { // from class: m02
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LiveAudienceActivity.E2(LiveAudienceActivity.this, view2);
                }
            });
            if (L1()) {
                this.g0.setCanScroll(false);
                n62 n62Var = new n62(this.b, this.e);
                this.m0 = n62Var;
                n62Var.addToParent();
                this.h = this.m0;
            } else {
                o02 o02Var = new o02(this.b, this.e);
                this.l0 = o02Var;
                o02Var.addToParent();
                o02 o02Var2 = this.l0;
                this.h = o02Var2;
                this.o = new t32(this.b, this.k0, false, this.u, o02Var2.getContentView());
                this.p = new k32(this.b, this.k0, false, this.u, findViewById(b73.N4));
                this.q = new m32(this.b, this.k0, false, null);
            }
            this.g0.setAdapter(new p());
            this.g0.setCurrentItem(1);
            if (K3()) {
                e52 e52Var = new e52(this.b, m52.c().b(this.W), this.X);
                this.Z = e52Var;
                e52Var.X(new q());
                this.Y.setAdapter(this.Z);
            }
            if (Z3(this.t)) {
                D3();
            }
        }
    }

    @Override // com.yunbao.live.activity.LiveActivity
    public void m2() {
        SocketClient socketClient = this.s;
        if (socketClient != null) {
            socketClient.y();
        }
        uo2 uo2Var = this.J0;
        if (uo2Var != null) {
            uo2Var.k();
        }
        m24 m24Var = this.K0;
        if (m24Var != null) {
            m24Var.b();
        }
        e32.f("checkLive");
        e32.f("enterRoom");
        e32.f("roomCharge");
        CommonHttpUtil.cancel(CommonHttpConsts.GET_BALANCE);
        super.m2();
        e52 e52Var = this.Z;
        if (e52Var != null) {
            e52Var.W();
        }
        this.Z = null;
        Handler handler = this.w0;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.w0 = null;
    }

    @Override // com.yunbao.live.activity.LiveActivity, defpackage.or3
    public void n(String str, int i2) {
        if (TextUtils.isEmpty(str) || !str.equals(j30.q().C())) {
            return;
        }
        this.I0 = i2;
    }

    @Override // com.yunbao.live.activity.LiveActivity, defpackage.or3
    public void o(String str) {
        this.k0.g0(str);
    }

    public void onBackPressed() {
        if (I3()) {
            a4();
            return;
        }
        if (this.n0 || w1()) {
            if (L1() && !this.n0) {
                com.yunbao.common.utils.a.t(this.b, (M1() || J3()) ? new Integer[][]{new Integer[]{Integer.valueOf(m93.F), Integer.valueOf(o60.b(this.b, p53.k))}} : new Integer[][]{new Integer[]{Integer.valueOf(m93.G), Integer.valueOf(o60.b(this.b, p53.l))}, new Integer[]{Integer.valueOf(m93.F), Integer.valueOf(o60.b(this.b, p53.k))}}, new c());
                return;
            }
            LiveAudienceFloatWindowData G3 = G3();
            E3();
            if (!j30.q().P() || this.C == 3) {
                return;
            }
            zu0.c().j(new n02(this.t, G3));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (c1()) {
            int id = view.getId();
            if (id == b73.q0) {
                if (e1()) {
                    Y3();
                }
            } else {
                if (id == b73.y) {
                    a4();
                    return;
                }
                if (id != b73.b0) {
                    if (id == b73.M4) {
                        z3();
                    }
                } else {
                    i52 i52Var = this.g;
                    if (i52Var != null) {
                        i52Var.I0();
                    }
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        boolean z = configuration.orientation == 2;
        if (z) {
            getWindow().getDecorView().setSystemUiVisibility(13572);
            Handler handler = this.w0;
            if (handler == null) {
                this.w0 = new Handler();
            } else {
                handler.removeCallbacksAndMessages(null);
            }
            View view = this.t0;
            if (view != null && view.getVisibility() != 0) {
                this.t0.setVisibility(0);
            }
            this.w0.postDelayed(new k(), 5000L);
        } else {
            getWindow().getDecorView().setSystemUiVisibility(LogType.UNEXP_ANR);
            Handler handler2 = this.w0;
            if (handler2 != null) {
                handler2.removeCallbacksAndMessages(null);
            }
            View view2 = this.t0;
            if (view2 != null && view2.getVisibility() == 0) {
                this.t0.setVisibility(4);
            }
        }
        d52 d52Var = this.k0;
        if (d52Var != null) {
            d52Var.a0(z);
        }
    }

    @Override // com.yunbao.live.activity.LiveActivity, com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        o02 o02Var = this.l0;
        if (o02Var != null) {
            o02Var.b0();
        }
        super.onDestroy();
        lx1.b("LiveAudienceActivity-------onDestroy------->");
        d12.E("audienceActivity.onDestroy");
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onGameWindowChangedEvent(cb1 cb1Var) {
        i52 i52Var = this.g;
        if (i52Var != null) {
            i52Var.k1(cb1Var.a());
        }
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onLinkMicTxAccEvent(qz1 qz1Var) {
        d52 d52Var = this.k0;
        if (d52Var == null || !(d52Var instanceof h42)) {
            return;
        }
        ((h42) d52Var).D0(qz1Var.a());
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onLiveRoomChangeEvent(b52 b52Var) {
        throw null;
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onLoginInvalidEvent(c82 c82Var) {
        J1();
        E3();
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onOpenGameChargeEvent(zt2 zt2Var) {
        S1();
    }

    public void openGame(View view) {
        View inflate = LayoutInflater.from(this.b).inflate(x73.S1, (ViewGroup) null);
        View findViewById = inflate.findViewById(b73.v0);
        View findViewById2 = inflate.findViewById(b73.u0);
        if (!this.y0) {
            findViewById.setVisibility(8);
        }
        if (!this.z0) {
            findViewById2.setVisibility(8);
        }
        inflate.measure(0, 0);
        int measuredWidth = inflate.getMeasuredWidth();
        int measuredHeight = inflate.getMeasuredHeight();
        PopupWindow popupWindow = new PopupWindow(inflate, measuredWidth, measuredHeight, true);
        popupWindow.setAnimationStyle(s93.a);
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        popupWindow.setOutsideTouchable(true);
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        popupWindow.showAtLocation(view, 51, (iArr[0] + (view.getWidth() / 2)) - (measuredWidth / 2), iArr[1] - measuredHeight);
        m mVar = new m(popupWindow);
        findViewById.setOnClickListener(mVar);
        findViewById2.setOnClickListener(mVar);
    }

    @Override // com.yunbao.live.activity.LiveActivity, defpackage.or3
    public void s(String str, String str2, String str3, int i2) {
        super.s(str, str2, str3, i2);
        if (TextUtils.isEmpty(str) || !str.equals(j30.q().C())) {
            return;
        }
        boolean z = i2 >= 0;
        n62 n62Var = this.m0;
        if (n62Var != null) {
            n62Var.b0(z);
        }
        t54.a(z ? m93.w : m93.x);
        if (z && Q1()) {
            e32.m0(this.y, new f());
            e32.k0(this.y, new g());
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void u1() {
        vq2 vq2Var = new vq2();
        vq2Var.t2(new j());
        vq2Var.d2(getSupportFragmentManager(), "NotLoginDialogFragment");
    }

    public void v3() {
        pr3.a(this.s);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean w3() {
        if (!isFinishing() && !isDestroyed()) {
            View decorView = getWindow() == null ? null : getWindow().getDecorView();
            if (decorView == null || !decorView.isAttachedToWindow() || getSupportFragmentManager().O0()) {
                return false;
            }
            FragmentActivity fragmentActivity = this.b;
            if (fragmentActivity instanceof FragmentActivity) {
                FragmentActivity fragmentActivity2 = fragmentActivity;
                return (fragmentActivity2.isFinishing() || fragmentActivity2.isDestroyed()) ? false : true;
            }
            if (fragmentActivity != null) {
                return true;
            }
        }
        return false;
    }

    public final void x3(LiveBean liveBean) {
        if (this.p0 == null) {
            this.p0 = new c52(this.b, new v());
        }
        this.p0.c(liveBean);
    }

    public final void y3() {
        SocketClient socketClient = this.s;
        if (socketClient != null) {
            socketClient.y();
        }
        this.s = null;
        d52 d52Var = this.k0;
        if (d52Var != null) {
            d52Var.k0();
        }
        i52 i52Var = this.g;
        if (i52Var != null) {
            i52Var.F0();
        }
        ab1 ab1Var = this.r;
        if (ab1Var != null) {
            ab1Var.a();
        }
        z12 z12Var = this.n;
        if (z12Var != null) {
            z12Var.removeFromParent();
        }
        t32 t32Var = this.o;
        if (t32Var != null) {
            t32Var.B();
        }
        k32 k32Var = this.p;
        if (k32Var != null) {
            k32Var.x();
        }
        m32 m32Var = this.q;
        if (m32Var != null) {
            m32Var.D();
        }
        x2(false);
        this.q0 = false;
        Handler handler = this.w0;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        View view = this.v0;
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        this.v0.setVisibility(4);
    }

    @Override // com.yunbao.live.activity.LiveActivity
    public void z2(int i2) {
        super.z2(i2);
        View view = this.s0;
        if (view != null) {
            if (i2 == 0) {
                if (view.getVisibility() != 0) {
                    this.s0.setVisibility(0);
                }
            } else if (view.getVisibility() == 0) {
                this.s0.setVisibility(8);
            }
        }
    }

    public final void z3() {
        View view = this.t0;
        if (view == null || view.getVisibility() == 0) {
            return;
        }
        Handler handler = this.w0;
        if (handler == null) {
            this.w0 = new Handler();
        } else {
            handler.removeCallbacksAndMessages(null);
        }
        this.t0.setVisibility(0);
        this.w0.postDelayed(new l(), 5000L);
    }
}
