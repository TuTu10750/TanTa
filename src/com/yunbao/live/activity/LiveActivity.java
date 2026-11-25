package com.yunbao.live.activity;

import android.R;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.bean.ConfigBean;
import com.yunbao.common.bean.GoodsBean;
import com.yunbao.common.bean.LiveGiftBean;
import com.yunbao.common.bean.UserBean;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.live.bean.GlobalGiftBean;
import com.yunbao.live.bean.LiveBean;
import com.yunbao.live.bean.LiveBuyGuardMsgBean;
import com.yunbao.live.bean.LiveChatBean;
import com.yunbao.live.bean.LiveDanMuBean;
import com.yunbao.live.bean.LiveEnterRoomBean;
import com.yunbao.live.bean.LiveGiftPrizePoolWinBean;
import com.yunbao.live.bean.LiveGuardInfo;
import com.yunbao.live.bean.LiveLuckGiftWinBean;
import com.yunbao.live.bean.LiveReceiveGiftBean;
import com.yunbao.live.bean.LiveVoiceGiftBean;
import com.yunbao.live.livegame.luckpan.bean.LuckpanWinMsgBean;
import com.yunbao.live.livegame.star.bean.StarWinMsgBean;
import com.yunbao.live.socket.SocketClient;
import defpackage.a90;
import defpackage.ab1;
import defpackage.aq4;
import defpackage.b73;
import defpackage.c32;
import defpackage.c62;
import defpackage.ck1;
import defpackage.e32;
import defpackage.g02;
import defpackage.g12;
import defpackage.h22;
import defpackage.i02;
import defpackage.i12;
import defpackage.i22;
import defpackage.i32;
import defpackage.i52;
import defpackage.ik1;
import defpackage.j12;
import defpackage.j30;
import defpackage.jc1;
import defpackage.jr3;
import defpackage.k32;
import defpackage.k52;
import defpackage.ka;
import defpackage.kx2;
import defpackage.l0;
import defpackage.l20;
import defpackage.lx1;
import defpackage.m32;
import defpackage.m62;
import defpackage.m93;
import defpackage.o12;
import defpackage.or3;
import defpackage.p92;
import defpackage.pr3;
import defpackage.pw3;
import defpackage.q22;
import defpackage.q41;
import defpackage.r92;
import defpackage.rv3;
import defpackage.rx1;
import defpackage.s92;
import defpackage.t0;
import defpackage.t32;
import defpackage.t54;
import defpackage.u92;
import defpackage.uw1;
import defpackage.v42;
import defpackage.v62;
import defpackage.wg1;
import defpackage.y42;
import defpackage.z12;
import defpackage.zu0;
import defpackage.zw2;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: /tmp/classes2.dex */
public abstract class LiveActivity extends AbsActivity implements or3, k52.a, uw1.c {
    public String A;
    public String B;
    public int C;
    public int D;
    public uw1 E;
    public int F;
    public int G;
    public boolean H;
    public boolean I;
    public boolean J;
    public j12 K;
    public LiveGuardInfo L;
    public View M;
    public boolean N;
    public int O;
    public kx2 P;
    public boolean Q;
    public boolean R;
    public i22 S;
    public h22 T;
    public HttpCallback U = new a();
    public ViewGroup e;
    public ViewGroup f;
    public i52 g;
    public t0 h;
    public g02 i;
    public o12 j;
    public v62 k;
    public v62 l;
    public i02 m;
    public z12 n;
    public t32 o;
    public k32 p;
    public m32 q;
    public ab1 r;
    public SocketClient s;
    public LiveBean t;
    public int u;
    public String v;
    public boolean w;
    public int x;
    public String y;
    public String z;

    /* loaded from: /tmp/classes2.dex */
    public class a extends HttpCallback {
        public a() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length <= 0) {
                t54.b(str);
                return;
            }
            JSONObject parseObject = JSON.parseObject(strArr[0]);
            UserBean D = j30.q().D();
            if (D != null) {
                D.setLevel(parseObject.getIntValue("level"));
                String string = parseObject.getString("coin");
                D.setCoin(string);
                LiveActivity.this.R1(string);
            }
            jr3.f(LiveActivity.this.s, parseObject.getString("barragetoken"));
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends HttpCallback {
        public b() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            LiveActivity liveActivity;
            SocketClient socketClient;
            if (i != 0 || strArr.length <= 0 || JSON.parseObject(strArr[0]).getIntValue("is_exist") != 0 || (socketClient = (liveActivity = LiveActivity.this).s) == null) {
                return;
            }
            socketClient.v(liveActivity.z, liveActivity.y);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends HttpCallback {
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;

        public c(String str, int i) {
            this.a = str;
            this.b = i;
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i == 0) {
                pr3.d(LiveActivity.this.s, this.a, this.b);
            }
            t54.b(str);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d implements zw2 {
        public d() {
        }
    }

    @Override // defpackage.or3
    public void A0() {
        J1();
    }

    public void A1() {
        ConfigBean h;
        if (TextUtils.isEmpty(this.z) || (h = j30.q().h()) == null) {
            return;
        }
        String downloadApkUrl = ((LiveActivity) this.b).L1() ? h.getDownloadApkUrl() : rv3.a(h.getLiveWxShareUrl(), this.z);
        if (TextUtils.isEmpty(downloadApkUrl)) {
            return;
        }
        ((ClipboardManager) this.b.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text", downloadApkUrl));
        t54.a(m93.u1);
    }

    public void A2(String str) {
        i52 i52Var = this.g;
        if (i52Var != null) {
            i52Var.x1(str);
        }
    }

    @Override // defpackage.or3
    public void B0(UserBean userBean, String str, int i) {
    }

    public String B1() {
        ik1 h = ck1.e().h();
        return h != null ? h.g() : "0";
    }

    public void B2(String str) {
        i52 i52Var = this.g;
        if (i52Var != null) {
            i52Var.y1(str);
        }
    }

    @Override // defpackage.or3
    public void C0(String str) {
        i52 i52Var = this.g;
        if (i52Var != null) {
            i52Var.T0(str);
        }
    }

    public int C1() {
        k32 k32Var = this.p;
        if (k32Var != null) {
            return rv3.h(k32Var.A(), -1);
        }
        return -1;
    }

    public void C2() {
        c62 c62Var = new c62();
        Bundle bundle = new Bundle();
        bundle.putString("liveUid", this.z);
        bundle.putString("stream", this.y);
        bundle.putInt("userType", this.x);
        c62Var.F1(bundle);
        c62Var.d2(getSupportFragmentManager(), "LiveUserListDialog");
    }

    @Override // defpackage.or3
    public void D(UserBean userBean) {
        i52 i52Var = this.g;
        if (i52Var != null) {
            i52Var.c1(userBean.getId());
            this.g.G0(1);
        }
        t32 t32Var = this.o;
        if (t32Var != null) {
            t32Var.N(userBean);
        }
    }

    @Override // defpackage.or3
    public void D0(boolean z) {
        if (!z || this.H) {
            return;
        }
        this.H = true;
    }

    public int D1() {
        t32 t32Var = this.o;
        if (t32Var != null) {
            return rv3.h(t32Var.E(), -1);
        }
        return -1;
    }

    public void D2() {
        m62 m62Var = new m62();
        Bundle bundle = new Bundle();
        bundle.putString("liveStream", this.y);
        bundle.putBoolean("anchor", this.w);
        m62Var.F1(bundle);
        m62Var.d2(getSupportFragmentManager(), "LiveVoiceApplyUpFragment");
    }

    @Override // defpackage.or3
    public void E(String str, String str2, String str3) {
    }

    @Override // defpackage.or3
    public void E0(LiveBuyGuardMsgBean liveBuyGuardMsgBean) {
        i52 i52Var = this.g;
        if (i52Var != null) {
            i52Var.R0(liveBuyGuardMsgBean);
            LiveChatBean liveChatBean = new LiveChatBean();
            liveChatBean.setContent(aq4.b(m93.c2, liveBuyGuardMsgBean.getUserName()));
            liveChatBean.setType(1);
            this.g.N0(liveChatBean);
        }
    }

    public LiveBean E1() {
        return this.t;
    }

    @Override // defpackage.or3
    public void F(String str) {
        t32 t32Var = this.o;
        if (t32Var != null) {
            t32Var.O(str);
        }
    }

    @Override // defpackage.or3
    public void F0() {
        t32 t32Var = this.o;
        if (t32Var != null) {
            t32Var.J();
        }
    }

    public String F1() {
        return this.z;
    }

    @Override // defpackage.or3
    public void G(String str, int i) {
        if (TextUtils.isEmpty(str) || !str.equals(j30.q().C())) {
            return;
        }
        this.x = i == 1 ? 40 : 30;
    }

    @Override // defpackage.or3
    public void G0(long j, long j2) {
        m32 m32Var = this.q;
        if (m32Var != null) {
            m32Var.Q(j, j2);
        }
    }

    public String G1() {
        return this.y;
    }

    @Override // defpackage.or3
    public void H(String str, String str2) {
        t32 t32Var = this.o;
        if (t32Var != null) {
            t32Var.I(str, str2);
        }
    }

    public int H1() {
        return this.x;
    }

    @Override // defpackage.or3
    public void I(String str, int i, int i2) {
    }

    @Override // defpackage.or3
    public void I0(String str, String str2, String str3) {
        t32 t32Var = this.o;
        if (t32Var != null) {
            t32Var.P(str, str2, str3);
        }
    }

    public List I1() {
        ArrayList arrayList = new ArrayList();
        LiveVoiceGiftBean liveVoiceGiftBean = new LiveVoiceGiftBean();
        liveVoiceGiftBean.setType(-2);
        arrayList.add(liveVoiceGiftBean);
        LiveVoiceGiftBean liveVoiceGiftBean2 = new LiveVoiceGiftBean();
        liveVoiceGiftBean2.setType(-1);
        liveVoiceGiftBean2.setUid(this.z);
        LiveBean liveBean = this.t;
        if (liveBean != null) {
            liveVoiceGiftBean2.setAvatar(liveBean.getAvatar());
        }
        arrayList.add(liveVoiceGiftBean2);
        return arrayList;
    }

    @Override // defpackage.or3
    public void J0(LiveReceiveGiftBean liveReceiveGiftBean, LiveChatBean liveChatBean) {
        if (!L1()) {
            liveReceiveGiftBean.setToName(null);
        }
        boolean equals = "0".equals(liveReceiveGiftBean.getStickerId());
        i52 i52Var = this.g;
        if (equals) {
            i52Var.w1(liveReceiveGiftBean);
        } else {
            i52Var.r1(liveReceiveGiftBean.getVotes());
        }
        if (liveChatBean != null) {
            if (L1()) {
                liveChatBean.setContent(aq4.b(m93.G4, liveReceiveGiftBean.getToName(), Integer.valueOf(liveReceiveGiftBean.getGiftCount()), liveReceiveGiftBean.getGiftName()));
            } else {
                liveChatBean.setContent(aq4.b(m93.B4, Integer.valueOf(liveReceiveGiftBean.getGiftCount()), liveReceiveGiftBean.getGiftName()));
            }
            f(liveChatBean);
        }
    }

    public void J1() {
        List<l0> t0 = getSupportFragmentManager().t0();
        if (t0 == null || t0.size() <= 0) {
            return;
        }
        for (l0 l0Var : t0) {
            if (l0Var != null && (l0Var instanceof l0)) {
                l0Var.T1();
            }
        }
    }

    @Override // defpackage.or3
    public void K(String str) {
        i52 i52Var = this.g;
        if (i52Var != null) {
            i52Var.r1(str);
        }
    }

    @Override // defpackage.or3
    public void K0(String str) {
        m32 m32Var = this.q;
        if (m32Var != null) {
            m32Var.M(str);
        }
    }

    public void K1() {
        i52 i52Var = this.g;
        if (i52Var != null) {
            i52Var.M0();
        }
    }

    @Override // defpackage.or3
    public void L(LiveChatBean liveChatBean) {
        i52 i52Var;
        if (j30.q().Q() || (i52Var = this.g) == null) {
            return;
        }
        i52Var.l1(true);
        this.g.N0(liveChatBean);
    }

    @Override // defpackage.or3
    public void L0(String str) {
    }

    public boolean L1() {
        return this.N;
    }

    @Override // defpackage.or3
    public void M0(String str) {
        List parseArray = JSON.parseArray(str, StarWinMsgBean.class);
        if (parseArray == null || parseArray.size() <= 0) {
            return;
        }
        i22 i22Var = this.S;
        if (i22Var != null) {
            i22Var.R2(parseArray);
        }
        if (this.g != null) {
            ArrayList arrayList = new ArrayList();
            boolean h = rx1.h();
            for (int i = 0; i < parseArray.size(); i++) {
                LiveChatBean liveChatBean = new LiveChatBean();
                if (h) {
                    liveChatBean.setContent(((StarWinMsgBean) parseArray.get(i)).getTitle());
                } else {
                    liveChatBean.setContent(((StarWinMsgBean) parseArray.get(i)).getTitleEn());
                }
                liveChatBean.setType(1);
                arrayList.add(liveChatBean);
            }
            this.g.O0(arrayList);
        }
    }

    public boolean M1() {
        return this.O == 1;
    }

    @Override // defpackage.or3
    public void N(int i, int i2, String str) {
        LiveChatBean liveChatBean = new LiveChatBean();
        liveChatBean.setContent(str);
        liveChatBean.setType(1);
    }

    public boolean N1() {
        return this.I;
    }

    public boolean O1() {
        t32 t32Var = this.o;
        return t32Var != null && t32Var.F();
    }

    @Override // defpackage.or3
    public void P(String str) {
        i52 i52Var;
        if (L1() || (i52Var = this.g) == null) {
            return;
        }
        i52Var.W0(str);
    }

    public boolean P1() {
        k32 k32Var = this.p;
        return k32Var != null && k32Var.C();
    }

    @Override // defpackage.or3
    public void Q(UserBean userBean) {
        t32 t32Var = this.o;
        if (t32Var != null) {
            t32Var.L(userBean);
        }
    }

    public boolean Q1() {
        return this.u == 1;
    }

    @Override // defpackage.or3
    public void R(String str, int i) {
    }

    public void R1(String str) {
        ab1 ab1Var = this.r;
        if (ab1Var != null) {
            ab1Var.j(str);
        }
    }

    public void S1() {
        if (this.P == null) {
            kx2 kx2Var = new kx2(this);
            this.P = kx2Var;
            kx2Var.l("Charge.getAliOrder");
            this.P.n("Charge.getWxOrder");
            this.P.m("Charge.getBraintreePaypalOrder");
            this.P.e(wg1.e);
            this.P.m("Charge.getBraintreePaypalOrder");
            this.P.k(new d());
        }
        g12 g12Var = new g12();
        g12Var.z2(this.P);
        g12Var.d2(getSupportFragmentManager(), "ChatChargeDialogFragment");
    }

    @Override // defpackage.or3
    public void T() {
        t32 t32Var = this.o;
        if (t32Var != null) {
            t32Var.K();
        }
    }

    public void T1() {
        i12 i12Var = new i12();
        if (!this.w) {
            Bundle bundle = new Bundle();
            bundle.putString("liveUid", this.z);
            i12Var.F1(bundle);
        }
        i12Var.d2(getSupportFragmentManager(), "LiveChatListDialogFragment");
    }

    public void U1(UserBean userBean, boolean z) {
        if (this.E == null) {
            this.E = new uw1(super.findViewById(R.id.content), this);
        }
        j12 j12Var = new j12();
        Bundle bundle = new Bundle();
        bundle.putParcelable("userBean", userBean);
        bundle.putBoolean("follow", z);
        j12Var.F1(bundle);
        j12Var.d2(getSupportFragmentManager(), "LiveChatRoomDialogFragment");
    }

    @Override // defpackage.or3
    public void V(String str) {
        t32 t32Var = this.o;
        if (t32Var != null) {
            t32Var.G(str);
        }
    }

    public void V1(String str) {
        W1(str, 0);
    }

    @Override // defpackage.or3
    public void W(String str, int i) {
    }

    public void W1(String str, int i) {
        if (this.E == null) {
            this.E = new uw1(super.findViewById(R.id.content), this);
        }
        i52 i52Var = this.g;
        if (i52Var != null) {
            i52Var.E0();
        }
        i32 i32Var = new i32();
        Bundle bundle = new Bundle();
        bundle.putString("danmuPrice", this.A);
        bundle.putString("coinName", this.B);
        bundle.putString("atName", str);
        bundle.putInt("openFace", i);
        i32Var.F1(bundle);
        i32Var.d2(getSupportFragmentManager(), "LiveInputDialogFragment");
    }

    @Override // defpackage.or3
    public void X() {
    }

    public void X1() {
        if (this.j == null) {
            o12 o12Var = new o12(this.b, this.f);
            this.j = o12Var;
            o12Var.subscribeActivityLifeCycle();
            this.j.addToParent();
        }
        this.j.show();
    }

    @Override // defpackage.or3
    public void Y() {
        J1();
    }

    public void Y1() {
        a90 a90Var = new a90();
        a90Var.v2(this.z);
        a90Var.d2(getSupportFragmentManager(), "DailyTaskDialogFragment");
    }

    public void Z1() {
        if (this.l == null) {
            v62 v62Var = new v62(this.b, this.f, wg1.j);
            this.l = v62Var;
            v62Var.subscribeActivityLifeCycle();
            this.l.addToParent();
        }
        this.l.show();
    }

    @Override // defpackage.or3
    public void a0() {
        t32 t32Var = this.o;
        if (t32Var != null) {
            t32Var.H();
        }
    }

    public void a2() {
        b2(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void b2(boolean z) {
        if (TextUtils.isEmpty(this.z) || TextUtils.isEmpty(this.y)) {
            return;
        }
        k61 supportFragmentManager = getSupportFragmentManager();
        if (this.g == null || isFinishing() || isDestroyed() || supportFragmentManager.O0()) {
            lx1.c("LiveActivity", "ignore openGiftWindow, live room ui not ready");
            return;
        }
        q22 q22Var = new q22();
        q22Var.Y2(this.L);
        Bundle bundle = new Bundle();
        bundle.putString("liveUid", this.z);
        bundle.putString("liveStream", this.y);
        bundle.putBoolean("openPack", z);
        q22Var.F1(bundle);
        q22Var.d2(supportFragmentManager, "LiveGiftDialogFragment");
        y2(false);
    }

    @Override // defpackage.or3
    public void c(LiveDanMuBean liveDanMuBean) {
        i52 i52Var = this.g;
        if (i52Var != null) {
            i52Var.v1(liveDanMuBean);
        }
    }

    @Override // k52.a
    public void c0(String str) {
        if ("link".equals(str)) {
            A1();
        }
    }

    public void c2() {
        c32 c32Var = new c32();
        c32Var.v2(this.L);
        Bundle bundle = new Bundle();
        bundle.putString("liveUid", this.z);
        bundle.putBoolean("anchor", this.w);
        c32Var.F1(bundle);
        c32Var.d2(getSupportFragmentManager(), "LiveGuardDialogFragment");
    }

    @Override // defpackage.or3
    public void d(UserBean userBean, String str) {
    }

    @Override // defpackage.or3
    public void d0(String str, int i) {
        m32 m32Var = this.q;
        if (m32Var != null) {
            m32Var.P(str, i);
        }
    }

    public void d2() {
        if (this.k == null) {
            v62 v62Var = new v62(this.b, this.f, wg1.i);
            this.k = v62Var;
            v62Var.subscribeActivityLifeCycle();
            this.k.addToParent();
        }
        this.k.show();
    }

    @Override // defpackage.or3
    public void e() {
    }

    @Override // defpackage.or3
    public void e0() {
    }

    public void e2() {
        new r92().d2(getSupportFragmentManager(), "LuckPanRecordDialogFragment");
    }

    @Override // defpackage.or3
    public void f(LiveChatBean liveChatBean) {
        i52 i52Var;
        if (liveChatBean.getType() == 6 && (i52Var = this.g) != null) {
            i52Var.P0(liveChatBean);
            return;
        }
        i52 i52Var2 = this.g;
        if (i52Var2 != null) {
            i52Var2.N0(liveChatBean);
        }
        if (liveChatBean.getType() == 4) {
            X();
        }
    }

    @Override // defpackage.or3
    public void f0(GlobalGiftBean globalGiftBean) {
        i52 i52Var = this.g;
        if (i52Var != null) {
            i52Var.Q0(globalGiftBean);
        }
    }

    public void f2() {
        new s92().d2(getSupportFragmentManager(), "LuckPanTipDialogFragment");
    }

    @Override // defpackage.or3
    public void g(LiveGiftPrizePoolWinBean liveGiftPrizePoolWinBean) {
        i52 i52Var;
        if (L1() || (i52Var = this.g) == null) {
            return;
        }
        i52Var.X0(liveGiftPrizePoolWinBean);
    }

    @Override // defpackage.or3
    public void g0(int i) {
        i52 i52Var = this.g;
        if (i52Var != null) {
            i52Var.h1(i);
        }
    }

    public void g2(List list) {
        if (list == null || list.size() == 0) {
            return;
        }
        u92 u92Var = new u92();
        u92Var.r2(list);
        u92Var.d2(getSupportFragmentManager(), "LuckPanWinDialogFragment");
    }

    @Override // uw1.c
    public void h(int i) {
        if (this.J) {
            j12 j12Var = this.K;
            if (j12Var != null) {
                j12Var.r2(i);
                return;
            }
            return;
        }
        i52 i52Var = this.g;
        if (i52Var != null) {
            i52Var.S0(i);
        }
    }

    @Override // defpackage.or3
    public void h0() {
    }

    public void h2() {
        new p92().d2(getSupportFragmentManager(), "LuckPanDialogFragment");
    }

    public void i2() {
        jc1 jc1Var = new jc1();
        jc1Var.t2(this.z);
        jc1Var.u2(this.y);
        jc1Var.d2(getSupportFragmentManager(), "GiftPrizePoolFragment");
    }

    @Override // defpackage.or3
    public void j0() {
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public boolean j1() {
        return true;
    }

    public void j2() {
        v42 v42Var = new v42();
        v42Var.B2(this.y);
        v42Var.A2(this.B);
        v42Var.d2(getSupportFragmentManager(), "LiveRedPackListDialogFragment");
    }

    public void k2() {
        y42 y42Var = new y42();
        y42Var.A2(this.y);
        y42Var.d2(getSupportFragmentManager(), "LiveRedPackSendDialogFragment");
    }

    @Override // defpackage.or3
    public void l(String str) {
    }

    @Override // defpackage.or3
    public void l0() {
        m32 m32Var = this.q;
        if (m32Var != null) {
            m32Var.L();
        }
    }

    public void l2() {
        k52 k52Var = new k52();
        k52Var.s2(this);
        k52Var.d2(getSupportFragmentManager(), "LiveShareDialogFragment");
    }

    @Override // defpackage.or3
    public void m(String str, String str2) {
        t32 t32Var = this.o;
        if (t32Var != null) {
            t32Var.M(str, str2);
        }
    }

    @Override // defpackage.or3
    public void m0() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        j30.q().d0(1);
        getWindow().addFlags(128);
        getWindow().addFlags(8192);
        this.B = j30.q().g();
        this.w = this instanceof LiveAnchorActivity;
        this.f = (ViewGroup) findViewById(b73.m4);
        zu0.c().n(this);
        this.M = findViewById(b73.o4);
    }

    public void m2() {
        zu0.c().p(this);
        e32.f("sendDanmu");
        e32.f("checkSocketConnect");
        uw1 uw1Var = this.E;
        if (uw1Var != null) {
            uw1Var.i();
        }
        t32 t32Var = this.o;
        if (t32Var != null) {
            t32Var.S();
        }
        k32 k32Var = this.p;
        if (k32Var != null) {
            k32Var.M();
        }
        m32 m32Var = this.q;
        if (m32Var != null) {
            m32Var.T();
        }
        i52 i52Var = this.g;
        if (i52Var != null) {
            i52Var.release();
        }
        g02 g02Var = this.i;
        if (g02Var != null) {
            g02Var.release();
        }
        o12 o12Var = this.j;
        if (o12Var != null) {
            o12Var.release();
        }
        v62 v62Var = this.k;
        if (v62Var != null) {
            v62Var.release();
        }
        kx2 kx2Var = this.P;
        if (kx2Var != null) {
            kx2Var.d();
        }
        this.E = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.g = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.P = null;
        lx1.b("LiveActivity--------release------>");
    }

    @Override // defpackage.or3
    public void n(String str, int i) {
    }

    @Override // defpackage.or3
    public void n0() {
    }

    public void n2(String str) {
        UserBean D;
        if (!this.w && (D = j30.q().D()) != null) {
            int level = D.getLevel();
            int i = this.F;
            if (level < i) {
                t54.b(aq4.b(m93.P3, Integer.valueOf(i)));
                return;
            }
        }
        LiveGuardInfo liveGuardInfo = this.L;
        jr3.e(this.s, str, this.w, this.x, liveGuardInfo != null ? liveGuardInfo.getMyGuardType() : 0);
    }

    @Override // defpackage.or3
    public void o(String str) {
    }

    @Override // defpackage.or3
    public void o0() {
        k32 k32Var = this.p;
        if (k32Var != null) {
            k32Var.F();
        }
        m32 m32Var = this.q;
        if (m32Var != null) {
            m32Var.L();
        }
        if (Q1() && (this instanceof LiveAudienceActivity)) {
            ((LiveAudienceActivity) this).M3(false);
        }
        x2(false);
    }

    public void o2(String str, String str2) {
        LiveGuardInfo liveGuardInfo = this.L;
        jr3.d(this.s, str, str2, this.w, this.x, liveGuardInfo != null ? liveGuardInfo.getMyGuardType() : 0);
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onAppLifecycleEvent(ka kaVar) {
        this.R = true;
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onCoinChangeEvent(l20 l20Var) {
        throw null;
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        j30.q().d0(0);
        m2();
        super.onDestroy();
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onFollowEvent(q41 q41Var) {
        if (TextUtils.isEmpty(this.z) || !this.z.equals(q41Var.b())) {
            return;
        }
        z2(q41Var.a());
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onPause() {
        t32 t32Var = this.o;
        if (t32Var != null) {
            t32Var.R();
        }
        k32 k32Var = this.p;
        if (k32Var != null) {
            k32Var.K();
        }
        super.onPause();
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onResume() {
        super.onResume();
        t32 t32Var = this.o;
        if (t32Var != null) {
            t32Var.U();
        }
        k32 k32Var = this.p;
        if (k32Var != null) {
            k32Var.N();
        }
        if (this.R) {
            this.R = false;
            if (this.s != null) {
                e32.l(this.z, this.y, new b());
            }
        }
    }

    @Override // defpackage.or3
    public void p(GoodsBean goodsBean) {
        i52 i52Var;
        if (this.w || (i52Var = this.g) == null) {
            return;
        }
        i52Var.n1(goodsBean);
    }

    @Override // defpackage.or3
    public void p0() {
        J1();
    }

    public void p2(String str) {
        UserBean D;
        if (!this.w && (D = j30.q().D()) != null) {
            int level = D.getLevel();
            int i = this.G;
            if (level < i) {
                t54.b(aq4.b(m93.Q3, Integer.valueOf(i)));
                return;
            }
        }
        e32.y0(str, this.z, this.y, this.U);
    }

    @Override // defpackage.or3
    public void q0() {
    }

    public void q2(LiveGiftBean liveGiftBean, String str, String str2, int i, int i2) {
        LiveBean liveBean = this.t;
        if (liveBean != null) {
            liveBean.getUserNiceName();
        }
        liveGiftBean.getType();
    }

    @Override // defpackage.or3
    public void r(JSONObject jSONObject) {
        ab1 ab1Var;
        if (j30.q().Q() || (ab1Var = this.r) == null) {
            return;
        }
        ab1Var.f(jSONObject);
    }

    public boolean r2(String str, int i, long j, List list) {
        SocketClient socketClient = this.s;
        if (socketClient == null) {
            return false;
        }
        jr3.g(socketClient, str, i, j, list);
        return true;
    }

    @Override // defpackage.or3
    public void s(String str, String str2, String str3, int i) {
    }

    @Override // defpackage.or3
    public void s0(String str, String str2, String str3) {
        k32 k32Var = this.p;
        if (k32Var != null) {
            k32Var.G(str, str2, str3);
        }
        if (this instanceof LiveAudienceActivity) {
            ((LiveAudienceActivity) this).M3(true);
        }
        x2(true);
    }

    public void s2() {
        jr3.h(this.s);
    }

    public void t2(int i, String str, String str2) {
        jr3.i(this.s, i, str, str2);
    }

    @Override // defpackage.or3
    public void u(LiveLuckGiftWinBean liveLuckGiftWinBean) {
        i52 i52Var = this.g;
        if (i52Var != null) {
            i52Var.V0(liveLuckGiftWinBean);
        }
    }

    public void u2(String str, String str2) {
        jr3.j(this.s, str, str2);
    }

    @Override // defpackage.or3
    public void v() {
    }

    @Override // defpackage.or3
    public void v0(JSONObject jSONObject) {
        ab1 ab1Var;
        if (j30.q().Q() || (ab1Var = this.r) == null) {
            return;
        }
        ab1Var.e(jSONObject);
    }

    public void v2(int i) {
        this.O = i;
    }

    @Override // defpackage.or3
    public void w(LiveEnterRoomBean liveEnterRoomBean) {
        if (this.g != null) {
            this.g.H0(liveEnterRoomBean.getUserBean());
        }
    }

    public boolean w1() {
        o12 o12Var = this.j;
        if (o12Var != null && o12Var.isShowed()) {
            this.j.hide();
            return false;
        }
        g02 g02Var = this.i;
        if (g02Var != null && g02Var.isShowed()) {
            this.i.hide();
            return false;
        }
        i02 i02Var = this.m;
        if (i02Var != null && i02Var.isShowed()) {
            this.m.hide();
            return false;
        }
        v62 v62Var = this.k;
        if (v62Var != null && v62Var.isShowed()) {
            this.k.hide();
            return false;
        }
        v62 v62Var2 = this.l;
        if (v62Var2 == null || !v62Var2.isShowed()) {
            return true;
        }
        this.l.hide();
        return false;
    }

    public void w2(boolean z) {
        this.I = z;
    }

    public void x1(String str) {
    }

    public void x2(boolean z) {
        View view = this.M;
        if (view != null) {
            if (z) {
                if (view.getVisibility() != 0) {
                    this.M.setVisibility(0);
                }
            } else if (view.getVisibility() == 0) {
                this.M.setVisibility(4);
            }
        }
    }

    @Override // defpackage.or3
    public void y0(String str) {
        List parseArray = JSON.parseArray(str, LuckpanWinMsgBean.class);
        if (parseArray == null || parseArray.size() <= 0) {
            return;
        }
        h22 h22Var = this.T;
        if (h22Var != null) {
            h22Var.R2(parseArray);
        }
        if (this.g != null) {
            ArrayList arrayList = new ArrayList();
            boolean h = rx1.h();
            for (int i = 0; i < parseArray.size(); i++) {
                LiveChatBean liveChatBean = new LiveChatBean();
                if (h) {
                    liveChatBean.setContent(((LuckpanWinMsgBean) parseArray.get(i)).getTitle());
                } else {
                    liveChatBean.setContent(((LuckpanWinMsgBean) parseArray.get(i)).getTitleEn());
                }
                liveChatBean.setType(1);
                arrayList.add(liveChatBean);
            }
            this.g.O0(arrayList);
        }
    }

    public void y1(String str, int i) {
        e32.o(this.y, str, new c(str, i));
    }

    public void y2(boolean z) {
        i52 i52Var = this.g;
        if (i52Var == null) {
            return;
        }
        i52Var.u1(z);
    }

    @Override // defpackage.or3
    public void z() {
    }

    @Override // defpackage.or3
    public void z0(String str, int i, long j, List list) {
        i52 i52Var = this.g;
        if (i52Var != null) {
            i52Var.U0(str, i, j, list, this.w);
        }
    }

    public void z1(String str, int i, int i2) {
        pr3.b(this.s, str, i, i2);
    }

    public void z2(int i) {
        i52 i52Var = this.g;
        if (i52Var != null) {
            i52Var.f1(i);
        }
    }
}
