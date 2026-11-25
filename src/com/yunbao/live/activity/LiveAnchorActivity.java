package com.yunbao.live.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.ViewGroup;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.netshield.Netshield;
import com.umeng.analytics.pro.cl;
import com.umeng.umcrash.custom_exception.UMCustomLogInfoBuilder;
import com.yunbao.beauty.views.LiveBeautyPopupViewHolder;
import com.yunbao.common.bean.LiveTypeConfig;
import com.yunbao.common.bean.UserBean;
import com.yunbao.common.http.CommonHttpConsts;
import com.yunbao.common.http.CommonHttpUtil;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.common.utils.a;
import com.yunbao.game.bean.GameParam;
import com.yunbao.live.bean.LiveBean;
import com.yunbao.live.bean.LiveConfigBean;
import com.yunbao.live.bean.LiveGuardInfo;
import com.yunbao.live.socket.SocketClient;
import defpackage.ab1;
import defpackage.aq4;
import defpackage.au;
import defpackage.b73;
import defpackage.bi3;
import defpackage.c82;
import defpackage.cb1;
import defpackage.ck1;
import defpackage.d12;
import defpackage.da0;
import defpackage.e32;
import defpackage.f22;
import defpackage.g22;
import defpackage.gh1;
import defpackage.i52;
import defpackage.ik1;
import defpackage.j30;
import defpackage.j42;
import defpackage.ji4;
import defpackage.k02;
import defpackage.k30;
import defpackage.k32;
import defpackage.k42;
import defpackage.k62;
import defpackage.kk1;
import defpackage.l32;
import defpackage.lx1;
import defpackage.m32;
import defpackage.m93;
import defpackage.mx3;
import defpackage.n94;
import defpackage.nh1;
import defpackage.np3;
import defpackage.o42;
import defpackage.p42;
import defpackage.p53;
import defpackage.p62;
import defpackage.pi3;
import defpackage.pr3;
import defpackage.pw3;
import defpackage.rz1;
import defpackage.s0;
import defpackage.s42;
import defpackage.t0;
import defpackage.t32;
import defpackage.t54;
import defpackage.tq2;
import defpackage.u62;
import defpackage.u72;
import defpackage.v52;
import defpackage.va1;
import defpackage.w32;
import defpackage.x73;
import defpackage.xa1;
import defpackage.y32;
import defpackage.z12;
import defpackage.zu0;
import java.io.File;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;
import pl.droidsonroids.gif.GifImageView;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

/* loaded from: /tmp/classes2.dex */
public class LiveAnchorActivity extends LiveActivity implements f22 {
    public LiveTypeConfig C0;
    public ViewGroup V;
    public ViewGroup W;
    public s0 X;
    public s42 Y;
    public gh1 Z;
    public k02 f0;
    public k62 g0;
    public y32 h0;
    public boolean i0;
    public boolean j0;
    public List k0;
    public boolean l0;
    public LiveConfigBean m0;
    public HttpCallback n0;
    public File o0;
    public int p0;
    public boolean q0;
    public boolean s0;
    public boolean t0;
    public boolean u0;
    public l32 v0;
    public boolean w0;
    public String x0;
    public String y0;
    public boolean r0 = true;
    public final Handler z0 = new Handler();
    public final Runnable A0 = new g();
    public int B0 = 10;
    public boolean D0 = false;

    /* loaded from: /tmp/classes2.dex */
    public class a implements j42 {

        /* renamed from: com.yunbao.live.activity.LiveAnchorActivity$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/classes2.dex */
        public class C0035a extends HttpCallback {
            public C0035a() {
            }

            @Override // com.yunbao.common.http.HttpCallback
            public void onSuccess(int i, String str, String[] strArr) {
                String str2;
                StringBuilder sb = new StringBuilder("开播---changeLive---->");
                if (LiveAnchorActivity.this.w3(strArr)) {
                    str2 = strArr[0];
                } else {
                    str2 = "empty info, code=" + i + ", msg=" + str;
                }
                sb.append(str2);
                lx1.b(sb.toString());
                LiveAnchorActivity liveAnchorActivity = LiveAnchorActivity.this;
                liveAnchorActivity.z0.postDelayed(liveAnchorActivity.A0, 1000L);
            }
        }

        public a() {
        }

        @Override // defpackage.j42
        public void a() {
            lx1.c("9999", "------onPushFailed");
            t54.a(m93.r4);
        }

        @Override // defpackage.j42
        public void b() {
            lx1.c("9999", "---ffgghh---onPushStart");
            e32.h(LiveAnchorActivity.this.y, new C0035a());
        }

        @Override // defpackage.j42
        public void c() {
            LiveAnchorActivity.this.i0 = true;
            lx1.c("9999", "---ffgghh---onPreviewStart");
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements a.m {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        public b(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // com.yunbao.common.utils.a.m
        public void b(Dialog dialog, String str) {
            LiveAnchorActivity.this.R3();
            LiveAnchorActivity.this.k3(this.a, this.b);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends HttpCallback {
        public final /* synthetic */ String a;

        public c(String str) {
            this.a = str;
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || !LiveAnchorActivity.this.w3(strArr)) {
                t54.b(LiveAnchorActivity.this.t3(str));
                return;
            }
            String str2 = null;
            if (!LiveAnchorActivity.this.Q1()) {
                LiveAnchorActivity liveAnchorActivity = LiveAnchorActivity.this;
                k32 k32Var = liveAnchorActivity.p;
                if (k32Var != null) {
                    k32Var.v(this.a, null, liveAnchorActivity.y);
                    return;
                }
                return;
            }
            JSONObject parseObject = JSON.parseObject(strArr[0]);
            if (parseObject != null) {
                String string = parseObject.getString("pull");
                if (!TextUtils.isEmpty(string)) {
                    str2 = string;
                }
            }
            LiveAnchorActivity liveAnchorActivity2 = LiveAnchorActivity.this;
            k32 k32Var2 = liveAnchorActivity2.p;
            if (k32Var2 != null) {
                k32Var2.v(this.a, str2, liveAnchorActivity2.y);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d extends HttpCallback {

        /* loaded from: /tmp/classes2.dex */
        public class a implements tq2.b {
            public a() {
            }

            @Override // tq2.b
            public void a(Context context, jm0 jm0Var) {
                jm0Var.S1();
                LiveAnchorActivity.this.m2();
                LiveAnchorActivity.this.S3();
            }
        }

        public d() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i == 0 && LiveAnchorActivity.this.w3(strArr)) {
                int intValue = JSON.parseObject(strArr[0]).getIntValue(cl.i);
                LiveAnchorActivity.this.H3(da0.b() + " <=== " + LiveAnchorActivity.this.p0 + "----status=" + intValue + UMCustomLogInfoBuilder.LINE_SEP);
                if (intValue == 0) {
                    tq2 tq2Var = new tq2();
                    tq2Var.s2(aq4.a(m93.r3));
                    tq2Var.r2(new a());
                    LiveAnchorActivity.this.K3(tq2Var, "VersionUpdateDialog");
                }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e extends HttpCallback {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        public e(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (LiveAnchorActivity.this.isFinishing() || LiveAnchorActivity.this.isDestroyed() || i != 0 || !LiveAnchorActivity.this.w3(strArr)) {
                return;
            }
            JSON.parseObject(strArr[0]).getString("play_url");
            LiveAnchorActivity.this.getClass();
            LiveAnchorActivity.this.B3();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class f extends HttpCallback {
        public f() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (LiveAnchorActivity.this.isFinishing() || LiveAnchorActivity.this.isDestroyed() || i != 0 || !LiveAnchorActivity.this.w3(strArr)) {
                return;
            }
            JSONObject parseObject = JSON.parseObject(strArr[0]);
            int intValue = parseObject.getIntValue("is_full_hd");
            int intValue2 = parseObject.getIntValue("is_time_room");
            int intValue3 = parseObject.getIntValue("is_ticket_room");
            lx1.c("9527", "isFullHD:" + intValue);
            if (LiveAnchorActivity.this.C0 == null) {
                LiveAnchorActivity.this.C0 = new LiveTypeConfig();
            }
            LiveAnchorActivity.this.C0.setIsFullHD(intValue);
            LiveAnchorActivity.this.C0.setIsTicketRoom(intValue3);
            LiveAnchorActivity.this.C0.setIsTimeRoom(intValue2);
            if (intValue3 == 1) {
                JSONObject parseObject2 = JSON.parseObject(parseObject.getString("ticket_room_data"));
                int intValue4 = parseObject2.getIntValue("min");
                int intValue5 = parseObject2.getIntValue("max");
                lx1.c("9527", "ticketMin:" + intValue4);
                lx1.c("9527", "ticketMax:" + intValue5);
                LiveAnchorActivity.this.C0.setTicketMin(intValue4);
                LiveAnchorActivity.this.C0.setTicketMax(intValue5);
            }
            if (intValue2 == 1) {
                JSONObject parseObject3 = JSON.parseObject(parseObject.getString("time_room_data"));
                int intValue6 = parseObject3.getIntValue("min");
                int intValue7 = parseObject3.getIntValue("max");
                lx1.c("9527", "timeMin:" + intValue6);
                lx1.c("9527", "timeMax:" + intValue7);
                LiveAnchorActivity.this.C0.setTimeRoomMin(intValue6);
                LiveAnchorActivity.this.C0.setTimeRoomMax(intValue7);
            }
            if (LiveAnchorActivity.this.Y != null) {
                LiveAnchorActivity.this.Y.Y0(LiveAnchorActivity.this.C0);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e32.o0(LiveAnchorActivity.this.z);
            LiveAnchorActivity.this.z0.postDelayed(this, 10000L);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class h extends k30 {
        public h() {
        }

        @Override // defpackage.k30
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Integer num) {
            LiveAnchorActivity.this.B0 = num.intValue();
            LiveAnchorActivity.this.X.g0(num.intValue() * 0.1f);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class i extends k30 {
        public i() {
        }

        @Override // defpackage.k30
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Integer num) {
            LiveAnchorActivity.this.X.j0(num.intValue());
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class j implements gh1.a {
        public j() {
        }

        @Override // gh1.a
        public void a(boolean z) {
            if (LiveAnchorActivity.this.Y != null) {
                LiveAnchorActivity liveAnchorActivity = LiveAnchorActivity.this;
                if (z) {
                    liveAnchorActivity.Y.hide();
                } else {
                    liveAnchorActivity.Y.show();
                }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class k implements w32.e {
        public k() {
        }

        @Override // w32.e
        public void a(String str) {
            if (LiveAnchorActivity.this.X != null) {
                if (LiveAnchorActivity.this.h0 == null) {
                    LiveAnchorActivity liveAnchorActivity = LiveAnchorActivity.this;
                    Context context = liveAnchorActivity.b;
                    LiveAnchorActivity liveAnchorActivity2 = LiveAnchorActivity.this;
                    liveAnchorActivity.h0 = new y32(context, liveAnchorActivity2.e, liveAnchorActivity2.X);
                    LiveAnchorActivity.this.h0.subscribeActivityLifeCycle();
                    LiveAnchorActivity.this.h0.addToParent();
                }
                LiveAnchorActivity.this.h0.p0(str);
                LiveAnchorActivity.this.l0 = true;
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class l implements a.n {
        public l() {
        }

        @Override // com.yunbao.common.utils.a.n
        public void a(String str, int i) {
            if (i == m93.F) {
                LiveAnchorActivity.this.C3("closeLive.chatRoomConfirm");
                LiveAnchorActivity.this.p3();
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class m implements a.m {
        public m() {
        }

        @Override // com.yunbao.common.utils.a.m
        public void b(Dialog dialog, String str) {
            LiveAnchorActivity.this.C3("closeLive.confirm");
            LiveAnchorActivity.this.p3();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class n extends HttpCallback {

        /* loaded from: /tmp/classes2.dex */
        public class a extends HttpCallback {
            public a() {
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.yunbao.common.http.HttpCallback
            public void onSuccess(int i, String str, String[] strArr) {
                if (i == 0 && LiveAnchorActivity.this.w3(strArr)) {
                    JSONObject parseObject = JSON.parseObject(strArr[0]);
                    String string = parseObject.getString("ban_msg");
                    String string2 = parseObject.getString("ban_num");
                    int indexOf = string.indexOf(string2);
                    if (indexOf >= 0) {
                        SpannableString spannableString = new SpannableString(string);
                        spannableString.setSpan(new ForegroundColorSpan(-65536), indexOf, string2.length() + indexOf, 33);
                        string = spannableString;
                    }
                    LiveAnchorActivity.this.N3(string);
                }
            }
        }

        public n() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public Dialog createLoadingDialog() {
            return com.yunbao.common.utils.a.d(LiveAnchorActivity.this.b, aq4.a(m93.y3));
        }

        @Override // com.yunbao.common.http.HttpCallback
        public boolean isUseLoginInvalid() {
            return true;
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onLoginInvalid() {
            LiveAnchorActivity.this.j0 = false;
            LiveAnchorActivity.this.m2();
            LiveAnchorActivity.this.finish();
            j30.q().b();
            ck1.e().j();
            boolean z = LiveAnchorActivity.this.s0;
            LiveAnchorActivity liveAnchorActivity = LiveAnchorActivity.this;
            if (z) {
                pi3.l(liveAnchorActivity.b, aq4.a(m93.M3));
                return;
            }
            boolean z2 = liveAnchorActivity.t0;
            LiveAnchorActivity liveAnchorActivity2 = LiveAnchorActivity.this;
            if (z2) {
                pi3.l(liveAnchorActivity2.b, aq4.a(m93.g5));
            } else {
                pi3.k(liveAnchorActivity2.b);
            }
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            Runnable runnable;
            if (i != 0) {
                t54.b(str);
                return;
            }
            LiveAnchorActivity liveAnchorActivity = LiveAnchorActivity.this;
            Handler handler = liveAnchorActivity.z0;
            if (handler != null && (runnable = liveAnchorActivity.A0) != null) {
                handler.removeCallbacks(runnable);
            }
            SocketClient socketClient = LiveAnchorActivity.this.s;
            if (socketClient != null) {
                socketClient.y();
                LiveAnchorActivity.this.s = null;
            }
            LiveAnchorActivity liveAnchorActivity2 = LiveAnchorActivity.this;
            if (liveAnchorActivity2.n == null) {
                liveAnchorActivity2.n = new z12(liveAnchorActivity2.b, LiveAnchorActivity.this.V);
                LiveAnchorActivity.this.n.subscribeActivityLifeCycle();
                LiveAnchorActivity.this.n.addToParent();
                LiveAnchorActivity liveAnchorActivity3 = LiveAnchorActivity.this;
                liveAnchorActivity3.n.e0(liveAnchorActivity3.t, liveAnchorActivity3.y);
            }
            LiveAnchorActivity.this.m2();
            LiveAnchorActivity.this.j0 = false;
            if (LiveAnchorActivity.this.s0) {
                e32.M(new a());
            }
        }

        @Override // com.yunbao.common.http.HttpCallback
        public boolean showLoadingDialog() {
            return true;
        }
    }

    private void V3() {
        s0 s0Var = this.X;
        if (s0Var != null) {
            s0Var.n0();
        }
    }

    public static void r3(Context context, int i2, LiveConfigBean liveConfigBean, int i3, boolean z, String str, boolean z2) {
        s3(context, i2, liveConfigBean, i3, z, str, z2, null, null);
    }

    public static void s3(Context context, int i2, LiveConfigBean liveConfigBean, int i3, boolean z, String str, boolean z2, String str2, String str3) {
        System.out.println("--------forward---------");
        Intent intent = new Intent(context, (Class<?>) LiveAnchorActivity.class);
        intent.putExtra("liveSdk", i2);
        if (liveConfigBean != null) {
            intent.putExtra("liveConfig", liveConfigBean);
        }
        intent.putExtra("haveStore", i3);
        intent.putExtra("tip", str);
        intent.putExtra("isChatRoom", z);
        intent.putExtra("screenRecord", z2);
        intent.putExtra("promiseTitle", str2);
        intent.putExtra("promiseUrl", str3);
        context.startActivity(intent);
    }

    public void A3(String str, String str2) {
        if (z3()) {
            com.yunbao.common.utils.a.i(this.b, aq4.a(m93.e3), new b(str, str2));
        } else {
            k3(str, str2);
        }
    }

    @Override // com.yunbao.live.activity.LiveActivity, defpackage.or3
    public void B0(UserBean userBean, String str, int i2) {
        m32 m32Var = this.q;
        if (m32Var != null) {
            m32Var.J(userBean, str, i2);
        }
    }

    public final void B3() {
    }

    public final void C3(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" mStartLive=");
        sb.append(this.j0);
        sb.append(" mEnd=");
        sb.append(this.u0);
        sb.append(" mStream=");
        sb.append(this.y);
        sb.append(UMCustomLogInfoBuilder.LINE_SEP);
        sb.append(Log.getStackTraceString(new Throwable("LiveCloseTrace:" + str)));
        lx1.c("LiveCloseTrace", sb.toString());
    }

    public final void D3() {
        if (O1() || P1()) {
            t54.a(m93.U3);
        } else if (this.r != null) {
            xa1 xa1Var = new xa1();
            xa1Var.s2(this.r);
            K3(xa1Var, "GameDialogFragment");
        }
    }

    @Override // com.yunbao.live.activity.LiveActivity, defpackage.or3
    public void E(String str, String str2, String str3) {
        if (Q1()) {
            e32.Z(str3, new e(str, str3));
        }
    }

    public void E3() {
        k32 k32Var = this.p;
        if (k32Var == null || k32Var.w()) {
            l32 l32Var = new l32();
            this.v0 = l32Var;
            K3(l32Var, "LiveLinkMicListDialogFragment");
        }
    }

    public final void F3() {
        if (O1() || P1()) {
            t54.a(m93.h3);
            return;
        }
        w32 w32Var = new w32();
        w32Var.z2(new k());
        K3(w32Var, "LiveMusicDialogFragment");
    }

    public void G3(boolean z) {
    }

    public final void H3(String str) {
        if (this.o0 == null) {
            File file = new File(j30.O);
            if (!file.exists()) {
                file.mkdirs();
            }
            this.o0 = new File(file, da0.b() + "_" + this.z + "_" + this.y + ".txt");
        }
        u72.a(this.o0, str);
    }

    @Override // com.yunbao.live.activity.LiveActivity, defpackage.or3
    public void I(String str, int i2, int i3) {
        super.I(str, i2, i3);
        zu0.c().j(new u62(i2, i3));
        if (!M1() || TextUtils.isEmpty(str)) {
            return;
        }
        str.equals(j30.q().C());
    }

    public void I3(boolean z) {
        k02 k02Var = this.f0;
        if (k02Var != null) {
            if (!z) {
                k02Var.j0(false);
            } else if (this.p.C()) {
                this.f0.j0(true);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [au, android.app.Dialog] */
    public final void J3() {
        ?? auVar = new au(this.b, this.X.b0(), this.B0);
        auVar.j(new h());
        auVar.show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void K3(jm0 jm0Var, String str) {
        if (jm0Var == null || isFinishing() || isDestroyed()) {
            return;
        }
        k61 supportFragmentManager = getSupportFragmentManager();
        if (supportFragmentManager.G0()) {
            lx1.c("LiveAnchorActivity", "skip show " + str + " after FragmentManager destroyed");
            return;
        }
        if (supportFragmentManager.O0()) {
            lx1.c("LiveAnchorActivity", "skip show " + str + " after state saved");
            return;
        }
        try {
            jm0Var.d2(supportFragmentManager, str);
        } catch (IllegalStateException e2) {
            lx1.c("LiveAnchorActivity", "skip show " + str + "--->" + e2.getMessage());
        }
    }

    @Override // com.yunbao.live.activity.LiveActivity, defpackage.or3
    public void L0(String str) {
        N3(str);
    }

    public void L3() {
        g22 g22Var = new g22();
        Bundle bundle = new Bundle();
        List list = this.k0;
        bundle.putBoolean("hasGame", list != null && list.size() > 0);
        s0 s0Var = this.X;
        bundle.putBoolean("openFlash", s0Var != null && s0Var.d0());
        bundle.putBoolean("TASK", this.Q);
        bundle.putBoolean("screenRecord", this.w0);
        bundle.putBoolean("isMute", this.D0);
        if (this.C0.getIsTimeRoom() == 1 || this.C0.getIsTicketRoom() == 1) {
            bundle.putBoolean("isChangeType", true);
        }
        if (this.C0.getIsFullHD() == 1) {
            bundle.putBoolean("fullHD", true);
        }
        k02 k02Var = this.f0;
        bundle.putBoolean("linkMic", k02Var != null ? k02Var.h0() : false);
        g22Var.F1(bundle);
        g22Var.s2(this);
        K3(g22Var, "LiveFunctionDialogFragment");
    }

    public final void M3() {
        new bi3(this.b).show();
    }

    public final void N3(CharSequence charSequence) {
        mx3 mx3Var = new mx3();
        Bundle bundle = new Bundle();
        bundle.putCharSequence("tip", charSequence);
        mx3Var.F1(bundle);
        K3(mx3Var, "SuperAdminTipDialogFragment");
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [ji4, android.app.Dialog] */
    public final void O3() {
        ?? ji4Var = new ji4(this.b);
        ji4Var.k(new i());
        ji4Var.show();
    }

    public void P3(String str, String str2) {
        s0 s0Var = this.X;
        if (s0Var != null) {
            s0Var.k0(this.y, str, str2);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("method", "LiveConnect");
            jSONObject.put("pkuid", str);
            this.X.f0(jSONObject.toJSONString());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void Q3(String str, int i2, int i3, String str2) {
        L1();
        this.C = i2;
        this.D = i3;
        LiveBean liveBean = this.t;
        if (liveBean != null) {
            liveBean.setTitle(str2);
        }
        JSONObject parseObject = JSON.parseObject(str);
        this.y = parseObject.getString("stream");
        if (this.C0 == null) {
            this.C0 = new LiveTypeConfig();
        }
        this.C0.setStream(this.y);
        this.A = parseObject.getString("barrage_fee");
        String string = parseObject.getString("pull");
        lx1.b("createRoom----播放地址--->" + string);
        this.t.setPull(string);
        this.v = parseObject.getString("tx_appid");
        s42 s42Var = this.Y;
        if (s42Var != null) {
            s42Var.removeFromParent();
            this.Y.release();
        }
        this.Y = null;
        if (this.g == null) {
            i52 i52Var = new i52(this.b, this.e, (GifImageView) findViewById(b73.c2), findViewById(b73.j2), this.W);
            this.g = i52Var;
            i52Var.addToParent();
            this.g.subscribeActivityLifeCycle();
            this.g.i1(this.z, this.y, parseObject.getIntValue("userlist_time") * IjkMediaCodecInfo.RANK_MAX);
            this.g.r1(parseObject.getString("votestotal"));
            this.g.q1(0);
            UserBean D = j30.q().D();
            if (D != null) {
                this.g.m1(D.getLiangNameTip());
                this.g.j1(D.getUserNiceName());
                this.g.g1(D.getAvatar());
                this.g.e1(D.getLevelAnchor());
            }
        }
        if (this.X != null) {
            if (Q1()) {
                lx1.c("9999", "---ffgghh---uu111111mIsScreenRecord1111" + this.w0);
                if (this.w0) {
                    startService(new Intent((Context) this, (Class<?>) ScreenRecordService.class));
                }
                lx1.c("9999", "---ffgghh---uu1111111111" + parseObject.getString("push"));
                this.X.C(parseObject.getString("push"), 0);
            } else {
                lx1.c("9999", "---ffgghh---uu2222222222");
                this.X.m0(parseObject.getString("user_sw_token"), this.y);
            }
        }
        i52 i52Var2 = this.g;
        if (i52Var2 != null) {
            i52Var2.C1();
            this.g.B1();
        }
        this.j0 = true;
        this.g.D1();
        this.L = new LiveGuardInfo();
        int intValue = parseObject.getIntValue("guard_nums");
        this.L.setGuardNum(intValue);
        i52 i52Var3 = this.g;
        if (i52Var3 != null) {
            i52Var3.h1(intValue);
        }
        if (this.s == null) {
            this.s = new SocketClient("ws://127.0.0.1:" + Netshield.getLocalhostPort(j30.H()), this);
        }
        this.s.v(this.z, this.y);
        int intValue2 = parseObject.getIntValue("dailytask_switch");
        this.Q = intValue2 == 1;
        if (L1()) {
            if (this.g0 == null) {
                k62 k62Var = new k62(this.b, this.e);
                this.g0 = k62Var;
                k62Var.addToParent();
                this.g0.a0(((LiveActivity) this.b).B1());
            }
            this.h = this.g0;
            return;
        }
        if (this.f0 == null) {
            k02 k02Var = new k02(this.b, this.e);
            this.f0 = k02Var;
            k02Var.addToParent();
            this.f0.a0(((LiveActivity) this.b).B1());
        }
        this.h = this.f0;
        t32 t32Var = this.o;
        if (t32Var != null) {
            t32Var.W(this.s);
        }
        k32 k32Var = this.p;
        if (k32Var != null) {
            k32Var.S(this.s);
            this.p.Q(string);
            this.p.R(this.y);
        }
        m32 m32Var = this.q;
        if (m32Var != null) {
            m32Var.W(this.s);
            this.q.U(this.z);
            this.q.V(this.y);
        }
        int intValue3 = parseObject.getIntValue("jackpot_level");
        i52 i52Var4 = this.g;
        if (i52Var4 != null) {
            i52Var4.t1(false, intValue3, intValue2);
        }
        this.k0 = JSON.parseArray(parseObject.getString("game_switch"), Integer.class);
        GameParam gameParam = new GameParam();
        gameParam.setContext(this.b);
        gameParam.setParentView(this.W);
        gameParam.setTopView(this.e);
        gameParam.setInnerContainer(this.g.K0());
        gameParam.setGameActionListener(new va1(this, this.s));
        gameParam.setLiveUid(this.z);
        gameParam.setStream(this.y);
        gameParam.setAnchor(true);
        gameParam.setCoinName(j30.q().A());
        gameParam.setObj(parseObject);
        ab1 ab1Var = new ab1(gameParam);
        this.r = ab1Var;
        ab1Var.h(this.k0);
    }

    public void R3() {
        y32 y32Var = this.h0;
        if (y32Var != null) {
            y32Var.release();
        }
        this.h0 = null;
        this.l0 = false;
    }

    public void S3() {
        C3("superBackPressed");
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
    }

    public void T3() {
        s0 s0Var = this.X;
        if (s0Var != null) {
            s0Var.y();
        }
    }

    @Override // com.yunbao.live.activity.LiveActivity
    public void U1(UserBean userBean, boolean z) {
        super.U1(userBean, z);
        this.f0.f0();
    }

    public void U3() {
        s0 s0Var = this.X;
        if (s0Var != null) {
            s0Var.q();
        }
    }

    @Override // com.yunbao.live.activity.LiveActivity, defpackage.or3
    public void W(String str, int i2) {
    }

    @Override // com.yunbao.live.activity.LiveActivity, defpackage.or3
    public void Y() {
        C3("onAnchorInvalid");
        this.t0 = true;
        super.Y();
        p3();
    }

    @Override // defpackage.f22
    public void a(int i2) {
        if (i2 == 2015) {
            k02 k02Var = this.f0;
            if (k02Var != null) {
                k02Var.e0();
                return;
            }
            return;
        }
        switch (i2) {
            case 2001:
                h3();
                return;
            case 2002:
                T3();
                return;
            case 2003:
                U3();
                return;
            case 2004:
                F3();
                return;
            case 2005:
                l2();
                return;
            case 2006:
                D3();
                return;
            case 2007:
                k2();
                return;
            case 2008:
                E3();
                return;
            case 2009:
                V3();
                return;
            case 2010:
                Y1();
                return;
            case 2011:
                i2();
                return;
            default:
                switch (i2) {
                    case 2021:
                        lx1.c("9999", "mLivePushViewHolder------" + this.X);
                        s0 s0Var = this.X;
                        if (s0Var != null) {
                            if (this.D0) {
                                s0Var.S();
                            } else {
                                s0Var.F();
                            }
                            this.D0 = !this.D0;
                            return;
                        }
                        return;
                    case 2022:
                        new v52(this.b, this.C0).show();
                        return;
                    case 2023:
                        O3();
                        return;
                    case 2024:
                        J3();
                        return;
                    case 2025:
                        M3();
                        return;
                    default:
                        return;
                }
        }
    }

    @Override // com.yunbao.live.activity.LiveActivity, defpackage.or3
    public void d(UserBean userBean, String str) {
        k32 k32Var = this.p;
        if (k32Var != null) {
            k32Var.D(userBean, str);
        }
    }

    @Override // com.yunbao.live.activity.LiveActivity, defpackage.or3
    public void e() {
        k32 k32Var = this.p;
        if (k32Var != null) {
            k32Var.J();
        }
    }

    @Override // com.yunbao.live.activity.LiveActivity, defpackage.or3
    public void e0() {
        m32 m32Var = this.q;
        if (m32Var != null) {
            m32Var.N();
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        System.out.println("--------getLayoutId---------" + L1());
        return x73.c;
    }

    public void g3() {
        m32 m32Var;
        k32 k32Var = this.p;
        String A = k32Var != null ? k32Var.A() : null;
        if (TextUtils.isEmpty(A) || (m32Var = this.q) == null) {
            return;
        }
        m32Var.C(A, this.y);
    }

    public void h3() {
        if (this.Z == null) {
            gh1 liveBeautyPopupViewHolder = Q1() ? new LiveBeautyPopupViewHolder(this.b, this.V, true) : new np3(this.b, this.V, false);
            this.Z = liveBeautyPopupViewHolder;
            liveBeautyPopupViewHolder.N(new j());
        }
        this.Z.show();
    }

    public void i3() {
        s0 s0Var = this.X;
        if (s0Var != null) {
            s0Var.i0(true);
        }
    }

    @Override // com.yunbao.live.activity.LiveActivity, defpackage.or3
    public void j0() {
        k32 k32Var = this.p;
        if (k32Var != null) {
            k32Var.H();
        }
    }

    public void j3() {
        if (this.n0 == null) {
            this.n0 = new d();
        }
        this.p0++;
        H3(da0.b() + " ===> " + this.p0 + UMCustomLogInfoBuilder.LINE_SEP);
        e32.b(this.z, this.y, this.n0);
    }

    public final void k3(String str, String str2) {
        e32.t0(str, str2, this.y, new c(str));
    }

    @Override // com.yunbao.live.activity.LiveActivity, defpackage.or3
    public void l(String str) {
    }

    public void l3() {
        s0 s0Var = this.X;
        if (s0Var != null) {
            s0Var.a0();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("method", "LiveConnect");
            jSONObject.put("pkuid", 0);
            this.X.f0(jSONObject.toJSONString());
        }
    }

    @Override // com.yunbao.live.activity.LiveActivity, defpackage.or3
    public void m0() {
        k32 k32Var = this.p;
        if (k32Var != null) {
            k32Var.E();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.live.activity.LiveActivity, com.yunbao.common.activity.AbsActivity
    public void m1() {
        super.m1();
        d12.E("anchorActivity.main");
        System.out.println("--------main---------" + L1());
        Intent intent = getIntent();
        this.u = 1;
        this.m0 = (LiveConfigBean) intent.getParcelableExtra("liveConfig");
        int intExtra = intent.getIntExtra("haveStore", 0);
        String stringExtra = intent.getStringExtra("tip");
        this.N = intent.getBooleanExtra("isChatRoom", false);
        this.w0 = intent.getBooleanExtra("screenRecord", false);
        this.x0 = intent.getStringExtra("promiseTitle");
        this.y0 = intent.getStringExtra("promiseUrl");
        this.V = (ViewGroup) findViewById(b73.L4);
        this.x = 50;
        UserBean D = j30.q().D();
        this.z = D.getId();
        LiveBean liveBean = new LiveBean();
        this.t = liveBean;
        liveBean.setUid(this.z);
        this.t.setUserNiceName(D.getUserNiceName());
        this.t.setAvatar(D.getAvatar());
        this.t.setAvatarThumb(D.getAvatarThumb());
        this.t.setLevelAnchor(D.getLevelAnchor());
        this.t.setGoodNum(D.getGoodName());
        this.t.setCity(D.getCity());
        System.out.println("----ffgghh----isChatRoom---------" + L1());
        System.out.println("----ffgghh----isTxSdK---------" + Q1());
        if (!L1()) {
            if (!Q1()) {
                lx1.c("9999", "------ffgghh--------pp33333333333333---------");
            } else if (this.w0) {
                lx1.c("9999", "-----ffgghh----ppp11111111111---------");
                this.X = new k42(this.b, (ViewGroup) findViewById(b73.s4));
            } else {
                lx1.c("9999", "-----ffgghh-----pp2222222222222---------");
                this.X = new o42(this.b, (ViewGroup) findViewById(b73.s4), this.m0);
            }
        }
        s0 s0Var = this.X;
        if (s0Var == null) {
            finish();
            return;
        }
        s0Var.h0(new a());
        this.X.addToParent();
        this.X.subscribeActivityLifeCycle();
        this.W = (ViewGroup) findViewById(b73.B1);
        this.e = (ViewGroup) findViewById(b73.A1);
        boolean L1 = L1();
        Context context = this.b;
        if (L1) {
            this.Y = new p42(context, this.e, this.u, intExtra, stringExtra);
        } else {
            this.Y = new s42(context, this.e, this.u, intExtra, stringExtra, this.w0, this.x0, this.y0);
        }
        this.Y.addToParent();
        this.Y.subscribeActivityLifeCycle();
        if (!L1()) {
            t32 t32Var = new t32(this.b, this.X, true, this.u, this.e);
            this.o = t32Var;
            t32Var.V(this.z);
            this.p = new k32(this.b, this.X, true, this.u, this.V);
            this.q = new m32(this.b, this.X, true, this.e);
        }
        u3();
    }

    @Override // com.yunbao.live.activity.LiveActivity
    public void m2() {
        C3("release");
        SocketClient socketClient = this.s;
        if (socketClient != null) {
            socketClient.y();
            this.s = null;
        }
        e32.f("changeLive");
        e32.f("stopLive");
        e32.f("livePkCheckLive");
        e32.f("setLinkMicEnable");
        CommonHttpUtil.cancel(CommonHttpConsts.CHECK_TOKEN_INVALID);
        s42 s42Var = this.Y;
        if (s42Var != null) {
            s42Var.release();
        }
        y32 y32Var = this.h0;
        if (y32Var != null) {
            y32Var.release();
        }
        s0 s0Var = this.X;
        if (s0Var != null) {
            s0Var.release();
        }
        t32 t32Var = this.o;
        if (t32Var != null) {
            t32Var.S();
        }
        ab1 ab1Var = this.r;
        if (ab1Var != null) {
            ab1Var.g();
        }
        this.h0 = null;
        this.Y = null;
        this.X = null;
        this.o = null;
        this.Z = null;
        this.r = null;
        super.m2();
    }

    public void m3() {
        ab1 ab1Var = this.r;
        if (ab1Var != null) {
            ab1Var.b();
        }
    }

    @Override // com.yunbao.live.activity.LiveActivity, defpackage.or3
    public void n0() {
        m32 m32Var = this.q;
        if (m32Var != null) {
            m32Var.O();
        }
    }

    public void n3() {
        C3("closeLive");
        boolean L1 = L1();
        Context context = this.b;
        if (L1) {
            com.yunbao.common.utils.a.t(context, new Integer[][]{new Integer[]{Integer.valueOf(m93.F), Integer.valueOf(o60.b(this.b, p53.k))}}, new l());
        } else {
            com.yunbao.common.utils.a.i(context, aq4.a(m93.z3), new m());
        }
    }

    public void o3() {
        p62 p62Var = new p62();
        Bundle bundle = new Bundle();
        bundle.putString("liveStream", this.y);
        p62Var.F1(bundle);
        K3(p62Var, "LiveVoiceControlFragment");
    }

    public void onBackPressed() {
        C3("onBackPressed");
        gh1 gh1Var = this.Z;
        if (gh1Var != null && gh1Var.isShowed()) {
            this.Z.hide();
            return;
        }
        if (this.j0) {
            if (w1()) {
                n3();
                return;
            }
            return;
        }
        s0 s0Var = this.X;
        if (s0Var != null) {
            s0Var.release();
        }
        t32 t32Var = this.o;
        if (t32Var != null) {
            t32Var.S();
        }
        this.X = null;
        this.o = null;
        S3();
    }

    @Override // com.yunbao.live.activity.LiveActivity, com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        Runnable runnable;
        Handler handler = this.z0;
        if (handler != null && (runnable = this.A0) != null) {
            handler.removeCallbacks(runnable);
        }
        e32.f("anchorCheckLive");
        e32.f("getLiveBanInfo");
        super.onDestroy();
        lx1.b("LiveAnchorActivity-------onDestroy------->");
        d12.E("anchorActivity.onDestroy");
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onGameWindowChangedEvent(cb1 cb1Var) {
        i52 i52Var = this.g;
        if (i52Var != null) {
            i52Var.k1(cb1Var.a());
        }
        k02 k02Var = this.f0;
        if (k02Var != null) {
            k02Var.i0(cb1Var.b());
        }
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onImUnReadCountEvent(kk1 kk1Var) {
        t0 t0Var;
        ik1 h2 = ck1.e().h();
        if (h2 != null) {
            String g2 = h2.g();
            if (TextUtils.isEmpty(g2) || (t0Var = this.h) == null) {
                return;
            }
            t0Var.a0(g2);
        }
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onLinkMicTxMixStreamEvent(rz1 rz1Var) {
        nh1 nh1Var = this.X;
        if (nh1Var == null || !(nh1Var instanceof n94)) {
            return;
        }
        ((n94) nh1Var).R(rz1Var.c(), rz1Var.b(), rz1Var.a());
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onLoginInvalidEvent(c82 c82Var) {
        Y();
    }

    @Override // com.yunbao.live.activity.LiveActivity, com.yunbao.common.activity.AbsActivity
    public void onPause() {
        i52 i52Var;
        super.onPause();
        if (!L1() && !this.w0) {
            if (this.r0 && (i52Var = this.g) != null) {
                i52Var.B0();
            }
            u2("主播离开一下，精彩不中断，不要走开哦", "The anchor leaves for a while, the excitement will not be interrupted, don't go away");
        }
        this.q0 = true;
    }

    @Override // com.yunbao.live.activity.LiveActivity, com.yunbao.common.activity.AbsActivity
    public void onResume() {
        super.onResume();
        if (!L1() && !this.w0 && this.q0) {
            i52 i52Var = this.g;
            if (i52Var != null) {
                i52Var.C0();
            }
            u2("主播回来了！", "The host is back!");
            CommonHttpUtil.checkTokenInvalid();
        }
        this.q0 = false;
        this.r0 = true;
    }

    @Override // com.yunbao.live.activity.LiveActivity, defpackage.or3
    public void p0() {
        C3("onSuperCloseLive");
        this.s0 = true;
        super.Y();
        p3();
    }

    public void p3() {
        q3(1);
    }

    @Override // com.yunbao.live.activity.LiveActivity, defpackage.or3
    public void q0() {
        m32 m32Var = this.q;
        if (m32Var != null) {
            m32Var.K();
        }
    }

    public void q3(int i2) {
        C3("endLive type=" + i2);
        if (this.u0) {
            return;
        }
        this.u0 = true;
        k32 k32Var = this.p;
        if (k32Var != null) {
            k32Var.y();
        }
        e32.K0("", this.y, i2, new n());
    }

    public final String t3(String str) {
        return TextUtils.isEmpty(str) ? aq4.a(m93.Z4) : str;
    }

    public final void u3() {
        e32.q0(new f());
    }

    @Override // com.yunbao.live.activity.LiveActivity, defpackage.or3
    public void v() {
        k32 k32Var = this.p;
        if (k32Var != null) {
            k32Var.I();
        }
    }

    public void v3(UserBean userBean, int i2) {
        pr3.c(this.s, userBean, i2);
    }

    @Override // com.yunbao.live.activity.LiveActivity
    public boolean w1() {
        return super.w1();
    }

    public final boolean w3(String[] strArr) {
        return (strArr == null || strArr.length <= 0 || TextUtils.isEmpty(strArr[0])) ? false : true;
    }

    public void x3() {
        l32 l32Var = this.v0;
        if (l32Var != null) {
            l32Var.T1();
        }
        this.v0 = null;
    }

    public void y3() {
        this.v0 = null;
    }

    @Override // com.yunbao.live.activity.LiveActivity, defpackage.or3
    public void z() {
        k62 k62Var = this.g0;
        if (k62Var != null) {
            k62Var.b0(true);
        }
    }

    public boolean z3() {
        return this.l0;
    }
}
