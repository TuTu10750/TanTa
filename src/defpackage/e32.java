package defpackage;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.umeng.analytics.pro.bv;
import com.umeng.analytics.pro.cl;
import com.umeng.analytics.pro.g;
import com.umeng.commonsdk.deeplink.DeepLinkPresetEvent;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.yunbao.common.bean.UserBean;
import com.yunbao.common.http.CommonHttpUtil;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.common.http.HttpClient;
import com.yunbao.common.http.IHttpRequest;
import defpackage.e32;

/* loaded from: /tmp/classes2.dex */
public abstract class e32 {

    /* loaded from: /tmp/classes2.dex */
    public class a extends HttpCallback {
        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i == 0 && strArr != null && strArr.length > 0) {
                lx1.c("enterRoomDbg", "pull=" + JSON.parseObject(strArr[0]).getString("pull"));
                return;
            }
            lx1.c("enterRoomDbg", "fail code=" + i + " msg=" + str);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends HttpCallback {
        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            lx1.b("开播---心跳---->");
        }
    }

    public static void A(int i, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Game.getXqtbWinList", "gameXqtbRecord").params("uid", j30.q().C()).params("token", j30.q().B()).params(bv.ax, Integer.valueOf(i)).execute(httpCallback);
    }

    public static void A0(String str, String str2, String str3, String str4, int i, int i2, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Red.SendRed", "sendRedPack").params("uid", j30.q().C()).params("token", j30.q().B()).params("stream", str).params("coin", str2).params("nums", str3).params("des", str4).params("type", Integer.valueOf(i)).params("type_grant", Integer.valueOf(i2)).execute(httpCallback);
    }

    public static void B(String str, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Live.getAdminList", "getAdminList").params("uid", j30.q().C()).params("token", j30.q().B()).params("liveuid", str).execute(httpCallback);
    }

    public static void B0(String str, String str2, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Live.setAdmin", "setAdmin").params("uid", j30.q().C()).params("token", j30.q().B()).params("liveuid", str).params("touid", str2).execute(httpCallback);
    }

    public static void C(String str, HttpCallback httpCallback) {
        HttpClient.getInstance().get("User.getAliCdnRecord", "getAliCdnRecord").params("uid", j30.q().C()).params("token", j30.q().B()).params("id", str).execute(httpCallback);
    }

    public static void C0(String str, String str2, String str3, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Live.setAdmin", "setAdmin").params("uid", j30.q().C()).params("token", j30.q().B()).params("liveuid", str).params("room_id", str3).params("touid", str2).execute(httpCallback);
    }

    public static void D(String str, HttpCallback httpCallback) {
        HttpClient.getInstance().get("User.GetUserLabel", "getAllImpress").params("uid", j30.q().C()).params("token", j30.q().B()).params("touid", str).execute(httpCallback);
    }

    public static void D0(String str, String str2, String str3, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Live.cancelShutUp", "setShutUp").params("uid", j30.q().C()).params("token", j30.q().B()).params("room_id", str3).params("liveuid", str).params("touid", str2).execute(httpCallback);
    }

    public static void E(int i, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Backpack.getBackpack", "Backpack.getBackpack").params("uid", j30.q().C()).params("token", j30.q().B()).params("live_type", Integer.valueOf(i)).execute(httpCallback);
    }

    public static void E0(String str, String str2, HttpCallback httpCallback) {
        HttpClient.getInstance().get("User.setUserLabel", "setImpress").params("uid", j30.q().C()).params("token", j30.q().B()).params("touid", str).params("labels", str2).execute(httpCallback);
    }

    public static void F(HttpCallback httpCallback) {
        HttpClient.getInstance().get("Live.getCoin", "getCoin").params("uid", j30.q().C()).params("token", j30.q().B()).execute(httpCallback);
    }

    public static void F0(boolean z, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Linkmic.setMic", "setLinkMicEnable").params("uid", j30.q().C()).params("token", j30.q().B()).params("ismic", Integer.valueOf(z ? 1 : 0)).execute(httpCallback);
    }

    public static void G(String str, int i, HttpCallback httpCallback) {
        HttpClient.getInstance().get("User.seeDailyTasks", "getDailyTask").params("uid", j30.q().C()).params("token", j30.q().B()).params("liveuid", str).params("islive", Integer.valueOf(i)).execute(httpCallback);
    }

    public static void G0(String str, String str2, String str3, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Live.setReport", "setReport").params("uid", j30.q().C()).params("token", j30.q().B()).params("touid", str).params("content", str2).params("source", str3).execute(httpCallback);
    }

    public static void H(String str, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Home.getFilterLive", "getFilterLive").params("live_uid", str).params("uid", j30.q().C()).params("token", j30.q().B()).execute(httpCallback);
    }

    public static void H0(String str, String str2, String str3, int i, String str4, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Live.setShutUp", "setShutUp").params("uid", j30.q().C()).params("token", j30.q().B()).params("liveuid", str).params("room_id", str2).params("stream", str3).params("type", Integer.valueOf(i)).params("touid", str4).execute(httpCallback);
    }

    public static void I(int i, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Live.getGiftList", "getGiftList").params("uid", j30.q().C()).params("token", j30.q().B()).params("live_type", Integer.valueOf(i)).execute(httpCallback);
    }

    public static void I0(String str, HttpCallback httpCallback) {
        HttpClient.getInstance().get("User.updateBgImg", "setUserHomeBgImg").params("uid", j30.q().C()).params("token", j30.q().B()).params("img", str).execute(httpCallback);
    }

    public static void J(HttpCallback httpCallback) {
        HttpClient.getInstance().get("Guard.getList", "getGuardBuyList").params("uid", j30.q().C()).params("token", j30.q().B()).execute(httpCallback);
    }

    public static void J0(String str, int i, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Shop.SetSale", "Shop.SetSale").params("uid", j30.q().C()).params("token", j30.q().B()).params("goodsid", str).params("issale", Integer.valueOf(i)).execute(httpCallback);
    }

    public static void K(String str, int i, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Guard.GetGuardList", "getGuardList").params("uid", j30.q().C()).params("token", j30.q().B()).params("liveuid", str).params(bv.ax, Integer.valueOf(i)).execute(httpCallback);
    }

    public static void K0(String str, String str2, int i, HttpCallback httpCallback) {
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        j30 q = j30.q();
        String C = q.C();
        String B = q.B();
        HttpClient.getInstance().get("Live.stopRoom", "stopLive").params("roomId", str).params("stream", str2).params("uid", C).params("token", B).params(DeepLinkPresetEvent.UMEventParamTime, valueOf).params("sign", fa2.a(rv3.a("stream=", str2, "&time=", valueOf, "&token=", B, "&uid=", C, "&", CommonHttpUtil.SALT))).params("close_type", Integer.valueOf(i)).execute(httpCallback);
    }

    public static void L(String str, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Linkmic.RequestLVBAddrForLinkMic", "getLinkMicStream").params("uid", j30.q().C()).params("token", j30.q().B()).params("liveuid", str).execute(httpCallback);
    }

    public static void L0(String str, String str2, int i, String str3, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Live.superStopRoom", "superCloseRoom").params("uid", j30.q().C()).params("token", j30.q().B()).params("liveuid", str).params("type", Integer.valueOf(i)).params("room_id", str2).params("banruleid", str3).execute(httpCallback);
    }

    public static void M(HttpCallback httpCallback) {
        HttpClient.getInstance().get("Live.getLiveBanInfo", "getLiveBanInfo").params("uid", j30.q().C()).params("token", j30.q().B()).execute(httpCallback);
    }

    public static void M0(String str, String str2, int i, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Live.timeCharge", "timeCharge").params("uid", j30.q().C()).params("token", j30.q().B()).params("stream", str2).params("is_first", Integer.valueOf(i)).params("liveuid", str).params("room_id", "live_" + str).execute(httpCallback);
    }

    public static void N(String str, int i, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Livemanage.getKickList", "getLiveBlackList").params("uid", j30.q().C()).params("token", j30.q().B()).params("liveuid", str).params(bv.ax, Integer.valueOf(i)).execute(httpCallback);
    }

    public static void N0(String str, String str2, String str3, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Turntable.Turn", "Turn").params("uid", j30.q().C()).params("token", j30.q().B()).params("id", str).params("stream", str3).params("liveuid", str2).execute(httpCallback);
    }

    public static void O(String str, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Live.stopInfo", "getLiveEndInfo").params("stream", str).params("uid", j30.q().C()).params("token", j30.q().B()).execute(httpCallback);
    }

    public static void O0(String str, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Live.userCloseVoiceMic", "userDownVoiceMic").params("uid", j30.q().C()).params("token", j30.q().B()).params("stream", str).execute(httpCallback);
    }

    public static void P(String str, String str2, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Jackpot.GetJackpot", "getLiveGiftPrizePool").params("uid", j30.q().C()).params("token", j30.q().B()).params("liveuid", str).params("stream", str2).execute(httpCallback);
    }

    public static void Q(int i, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Livepk.GetLiveList", "getLivePkList").params("uid", j30.q().C()).params("token", j30.q().B()).params(bv.ax, Integer.valueOf(i)).execute(httpCallback);
    }

    public static void R(String str, int i, HttpCallback httpCallback) {
        HttpClient.getInstance().get("User.getLiverecord", "getLiveRecord").params("uid", j30.q().C()).params("token", j30.q().B()).params("touid", str).params(bv.ax, Integer.valueOf(i)).execute(httpCallback);
    }

    public static void S(HttpCallback httpCallback) {
        HttpClient.getInstance().get("Live.getReportClass", "getLiveReportList").params("uid", j30.q().C()).params("token", j30.q().B()).execute(httpCallback);
    }

    public static void T(HttpCallback httpCallback) {
        HttpClient.getInstance().get("Live.newGetSDK", "getLiveSdk").params("uid", j30.q().C()).params("token", j30.q().B()).execute(httpCallback);
    }

    public static void U(String str, int i, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Livemanage.getShutList", "getLiveShutUpList").params("uid", j30.q().C()).params("token", j30.q().B()).params("liveuid", str).params(bv.ax, Integer.valueOf(i)).execute(httpCallback);
    }

    public static void V(String str, String str2, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Live.getPop", "getLiveUser").params("uid", j30.q().C()).params("token", j30.q().B()).params("touid", str).params("liveuid", str2).execute(httpCallback);
    }

    public static void W(String str, String str2, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Live.getUserRankNew", "getLiveUserRank").params("liveuid", str).params("uid", j30.q().C()).params("token", j30.q().B()).params("stream", str2).execute(httpCallback);
    }

    public static void X(String str, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Livemusic.getDownurl", "getMusicUrl").params("uid", j30.q().C()).params("token", j30.q().B()).params("audio_id", str).execute(httpCallback);
    }

    public static void Y(int i, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Livemanage.GetRoomList", "getMyAdminRoomList").params("uid", j30.q().C()).params("token", j30.q().B()).params(bv.ax, Integer.valueOf(i)).execute(httpCallback);
    }

    public static void Z(String str, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Live.getMicPullUrl", "getNewUpMicPullUrl").params("uid", j30.q().C()).params("token", j30.q().B()).params("stream", str).execute(httpCallback);
    }

    public static void a0(HttpCallback httpCallback) {
        HttpClient.getInstance().get("Live.getPull", "getLiveBanInfo").params("uid", j30.q().C()).params("token", j30.q().B()).execute(httpCallback);
    }

    public static void b(String str, String str2, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Live.checkLiveing", "anchorCheckLive").params("uid", j30.q().C()).params("token", j30.q().B()).params("liveuid", str).params("stream", str2).execute(httpCallback);
    }

    public static void b0(HttpCallback httpCallback) {
        HttpClient.getInstance().get("Live.getPush", "getLiveBanInfo").params("uid", j30.q().C()).params("token", j30.q().B()).execute(httpCallback);
    }

    public static void c(String str, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Live.applyVoiceLiveMic", "applyVoiceLiveMic").params("uid", j30.q().C()).params("token", j30.q().B()).params("stream", str).execute(httpCallback);
    }

    public static void c0(String str, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Red.GetRedList", "getRedPackList").params("uid", j30.q().C()).params("token", j30.q().B()).params("stream", str).params("sign", fa2.a("stream=" + str + "&3ae3c1c7c4bc8371ef52a96d0364449d")).execute(httpCallback);
    }

    public static void d(String str, int i, int i2, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Live.changeVoiceEmptyMicStatus", "banEmptyMicPosition").params("uid", j30.q().C()).params("token", j30.q().B()).params("stream", str).params("position", Integer.valueOf(i)).params(cl.i, Integer.valueOf(i2)).execute(httpCallback);
    }

    public static void d0(String str, int i, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Red.GetRedRobList", "getRedPackResult").params("uid", j30.q().C()).params("token", j30.q().B()).params("stream", str).params("redid", Integer.valueOf(i)).params("sign", fa2.a("redid=" + i + "&stream=" + str + "&3ae3c1c7c4bc8371ef52a96d0364449d")).execute(httpCallback);
    }

    public static void e(String str, String str2, String str3, int i, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Guard.BuyGuard", "buyGuard").params("uid", j30.q().C()).params("token", j30.q().B()).params("liveuid", str).params("roomid", str2).params("stream", str3).params("guardid", Integer.valueOf(i)).execute(httpCallback);
    }

    public static void e0(int i, String str, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Shop.GetSale", "Shop.GetSale").params("uid", j30.q().C()).params("token", j30.q().B()).params(bv.ax, Integer.valueOf(i)).params("liveuid", str).execute(httpCallback);
    }

    public static void f(String str) {
        HttpClient.getInstance().cancel(str);
    }

    public static void f0(int i, int i2, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Turntable.GetWin", "Turntable.GetWin").params("uid", j30.q().C()).params("token", j30.q().B()).params("live_type", Integer.valueOf(i)).params(bv.ax, Integer.valueOf(i2)).execute(httpCallback);
    }

    public static void g(String str, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Live.cancelVoiceLiveMicApply", "cancelVoiceLiveMic").params("uid", j30.q().C()).params("token", j30.q().B()).params("stream", str).execute(httpCallback);
    }

    public static void g0(int i, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Turntable.GetTurntable", "GetTurntable").params("uid", j30.q().C()).params("token", j30.q().B()).params("live_type", Integer.valueOf(i)).execute(httpCallback);
    }

    public static void h(String str, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Live.changeLive", "changeLive").params("uid", j30.q().C()).params("token", j30.q().B()).params("stream", str).params(cl.i, SdkVersion.MINI_VERSION).execute(httpCallback);
    }

    public static void h0(String str, String str2, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Linkmic.RequestPlayUrlWithSignForLinkMic", "getTxLinkMicAccUrl").params("uid", j30.q().C()).params("liveuid", str).params("token", j30.q().B()).params("stream", str2).execute(httpCallback);
    }

    public static void i(String str, int i, int i2, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Live.changeLiveType", "changeLiveType").params("uid", j30.q().C()).params("room_id", "live_" + j30.q().C()).params("token", j30.q().B()).params("stream", str).params("type", Integer.valueOf(i)).params("type_val", Integer.valueOf(i2)).execute(httpCallback);
    }

    public static void i0(String str, String str2, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Live.getUserListsNew", "getUserList").params("liveuid", str).params("uid", j30.q().C()).params("token", j30.q().B()).params("stream", str2).execute(httpCallback);
    }

    public static void j(String str, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Linkmic.isMic", "checkLinkMicEnable").params("uid", j30.q().C()).params("token", j30.q().B()).params("liveuid", str).execute(httpCallback);
    }

    public static void j0(String str, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Live.anchorGetVoiceMicList", "getVoiceControlList").params("uid", j30.q().C()).params("token", j30.q().B()).params("stream", str).execute(httpCallback);
    }

    public static void k(String str, String str2, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Live.checkLive", "checkLive").params("uid", j30.q().C()).params("token", j30.q().B()).params("liveuid", str).params("stream", str2).execute(httpCallback);
    }

    public static void k0(String str, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Live.getVoiceLivePullStreams", "getVoiceLivePullStreams").params("uid", j30.q().C()).params("token", j30.q().B()).params("stream", str).execute(httpCallback);
    }

    public static void l(String str, String str2, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Live.checkUserRedis", "checkSocketConnect").params("uid", j30.q().C()).params("token", j30.q().B()).params("mobileid", j30.q().j()).params("liveuid", str).params("stream", str2).execute(httpCallback);
    }

    public static void l0(String str, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Live.getVoiceMicApplyList", "getVoiceMicApplyList").params("uid", j30.q().C()).params("token", j30.q().B()).params("stream", str).execute(httpCallback);
    }

    public static void m(HttpCallback httpCallback) {
        HttpClient.getInstance().get("User.clearTurntableWinLists", "clearTurnRecord").params("uid", j30.q().C()).params("token", j30.q().B()).execute(httpCallback);
    }

    public static void m0(String str, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Live.getVoiceMicStream", "getVoiceMicStream").params("uid", j30.q().C()).params("token", j30.q().B()).params("stream", str).execute(httpCallback);
    }

    public static void n(String str, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Linkmic.userCloseMic", "checkLinkMicEnable").params("uid", j30.q().C()).params("token", j30.q().B()).params("liveuid", str).execute(httpCallback);
    }

    public static void n0(String str, String str2, int i, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Live.handleVoiceMicApply", "handleVoiceMicApply").params("uid", j30.q().C()).params("token", j30.q().B()).params("stream", str).params("apply_uid", str2).params(cl.i, Integer.valueOf(i)).execute(httpCallback);
    }

    public static void o(String str, String str2, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Live.closeUserVoiceMic", "closeUserVoiceMic").params("uid", j30.q().C()).params("token", j30.q().B()).params("stream", str).params("touid", str2).execute(httpCallback);
    }

    public static void o0(String str) {
        HttpClient.getInstance().get("Live.monitor", "Live.monitor").params("uid", j30.q().C()).params("token", j30.q().B()).params("liveuid", str).execute(new b());
    }

    public static void p(String str, int i, String str2, int i2, int i3, String str3, int i4, String str4, boolean z, int i5, int i6, HttpCallback httpCallback) {
        j30 q = j30.q();
        UserBean D = q.D();
        if (D == null) {
            return;
        }
        HttpClient.getInstance().get("Live.createRoom", "createRoom").params("roomId", str).params("live_platform", Integer.valueOf(i)).params("uid", D.getId()).params("token", q.B()).params("user_nickname", D.getUserNiceName()).params("avatar", D.getAvatar()).params("avatar_thumb", D.getAvatarThumb()).params("city", z ? q.f() : "").params("province", z ? q.z() : "").params(g.C, z ? String.valueOf(q.r()) : "").params(g.D, z ? String.valueOf(q.v()) : "").params("title", str2).params("liveclassid", Integer.valueOf(i2)).params("type", Integer.valueOf(i3)).params("type_val", str3).params("isshop", Integer.valueOf(i4)).params("thumb", str4).params("live_type", Integer.valueOf(i5)).params("voice_type", Integer.valueOf(i6)).params("deviceinfo", n12.d()).execute(httpCallback);
    }

    public static void p0(String str, String str2, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Live.kicking", "kicking").params("uid", j30.q().C()).params("token", j30.q().B()).params("liveuid", str).params("touid", str2).execute(httpCallback);
    }

    public static void q(String str, HttpCallback httpCallback) {
        HttpClient.getInstance().get("User.receiveTaskReward", "dailyTaskReward").params("uid", j30.q().C()).params("token", j30.q().B()).params("taskid", str).execute(httpCallback);
    }

    public static void q0(HttpCallback httpCallback) {
        HttpClient.getInstance().get("Live.liveAuth", "getMusicUrl").params("uid", j30.q().C()).params("token", j30.q().B()).execute(httpCallback);
    }

    public static void r(String str) {
        try {
            final String string = JSON.parseObject(str).getString("stream");
            final String C = j30.q().C();
            lx1.c("enterRoomDbg", "schedule enterRoom after 2s, liveUid=" + C + " stream=" + string);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: d32
                @Override // java.lang.Runnable
                public final void run() {
                    e32.s(C, string, new e32.a());
                }
            }, 2000L);
        } catch (Exception e) {
            lx1.c("enterRoomDbg", "parse createRoom result error: " + e.getMessage());
        }
    }

    public static void r0(String str, String str2, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Livemanage.cancelKick", "liveCancelBlack").params("uid", j30.q().C()).params("token", j30.q().B()).params("liveuid", str).params("touid", str2).execute(httpCallback);
    }

    public static void s(String str, String str2, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Live.enterRoomNew", "enterRoom").params("uid", j30.q().C()).params("token", j30.q().B()).params("city", j30.q().f()).params("liveuid", str).params("mobileid", j30.q().j()).params("stream", str2).execute(httpCallback);
    }

    public static void s0(String str, String str2, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Livemanage.cancelShut", "LiveCancelShutUp").params("uid", j30.q().C()).params("token", j30.q().B()).params("liveuid", str).params("touid", str2).execute(httpCallback);
    }

    public static void t(HttpCallback httpCallback) {
        HttpClient.getInstance().get("Game.getXydzpRandList", "gameGetLuckpanInfo").params("uid", j30.q().C()).params("token", j30.q().B()).execute(httpCallback);
    }

    public static void t0(String str, String str2, String str3, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Livepk.checkLive", "livePkCheckLive").params("uid", j30.q().C()).params("token", j30.q().B()).params("liveuid", str).params("stream", str2).params("uid_stream", str3).execute(httpCallback);
    }

    public static void u(HttpCallback httpCallback) {
        HttpClient.getInstance().get("Game.getXqtbRandList", "gameXqtbPlay").params("uid", j30.q().C()).params("token", j30.q().B()).execute(httpCallback);
    }

    public static void u0(String str, int i, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Livepk.Search", "livePkSearchAnchor").params("uid", j30.q().C()).params("token", j30.q().B()).params("key", str).params(bv.ax, Integer.valueOf(i)).execute(httpCallback);
    }

    public static void v(String str, String str2, String str3, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Game.xydzpPlay", "gameLuckpanPlay").params("uid", j30.q().C()).params("token", j30.q().B()).params("liveuid", str).params("stream", str2).params("type", str3).execute(httpCallback);
    }

    public static void v0(String str, int i, HttpCallback httpCallback) {
        String C = j30.q().C();
        HttpClient.getInstance().get("Red.RobRed", "robRedPack").params("uid", C).params("token", j30.q().B()).params("stream", str).params("redid", Integer.valueOf(i)).params("sign", fa2.a("redid=" + i + "&stream=" + str + "&uid=" + C + "&3ae3c1c7c4bc8371ef52a96d0364449d")).execute(httpCallback);
    }

    public static void w(HttpCallback httpCallback) {
        HttpClient.getInstance().get("Game.getXydzpTotalList", "gameLuckpanRank").params("uid", j30.q().C()).params("token", j30.q().B()).execute(httpCallback);
    }

    public static void w0(String str, String str2, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Live.roomCharge", "roomCharge").params("uid", j30.q().C()).params("token", j30.q().B()).params("stream", str2).params("liveuid", str).params("room_id", "live_" + str).execute(httpCallback);
    }

    public static void x(int i, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Game.getXydzpWinList", "gameLuckpanRecord").params("uid", j30.q().C()).params("token", j30.q().B()).params(bv.ax, Integer.valueOf(i)).execute(httpCallback);
    }

    public static void x0(String str, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Livemusic.searchMusic", "searchMusic").params("uid", j30.q().C()).params("token", j30.q().B()).params("key", str).execute(httpCallback);
    }

    public static void y(String str, String str2, int i, int i2, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Game.xqtbPlay", "gameXqtbPlay").params("uid", j30.q().C()).params("token", j30.q().B()).params("liveuid", str).params("stream", str2).params("type", Integer.valueOf(i)).params("nums", Integer.valueOf(i2)).execute(httpCallback);
    }

    public static void y0(String str, String str2, String str3, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Live.sendBarrage", "sendDanmu").params("uid", j30.q().C()).params("token", j30.q().B()).params("liveuid", str2).params("stream", str3).params("giftid", SdkVersion.MINI_VERSION).params("giftcount", SdkVersion.MINI_VERSION).params("content", str).execute(httpCallback);
    }

    public static void z(HttpCallback httpCallback) {
        HttpClient.getInstance().get("Game.getXqtbTotalList", "gameXqtbRank").params("uid", j30.q().C()).params("token", j30.q().B()).execute(httpCallback);
    }

    public static void z0(String str, String str2, String str3, int i, String str4, int i2, int i3, HttpCallback httpCallback) {
        IHttpRequest params = HttpClient.getInstance().get("Live.sendGift", "sendGift").params("uid", j30.q().C()).params("token", j30.q().B()).params("liveuid", str).params("stream", str2).params("touids", str3).params("giftid", Integer.valueOf(i)).params("ispack", Integer.valueOf(i2)).params("is_sticker", Integer.valueOf(i3));
        if (TextUtils.isEmpty(str4)) {
            str4 = SdkVersion.MINI_VERSION;
        }
        params.params("giftcount", str4).execute(httpCallback);
    }
}
