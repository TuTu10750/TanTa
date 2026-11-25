package com.yunbao.live.socket;

import android.graphics.PointF;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.uc.crashsdk.export.CrashStatKey;
import com.umeng.analytics.pro.cl;
import com.yunbao.common.bean.GoodsBean;
import com.yunbao.common.bean.MsgStyleBean;
import com.yunbao.common.bean.UserBean;
import com.yunbao.common.utils.MemoryPressureUtil;
import com.yunbao.live.bean.GlobalGiftBean;
import com.yunbao.live.bean.LiveBuyGuardMsgBean;
import com.yunbao.live.bean.LiveChatBean;
import com.yunbao.live.bean.LiveDanMuBean;
import com.yunbao.live.bean.LiveEnterRoomBean;
import com.yunbao.live.bean.LiveGiftPrizePoolWinBean;
import com.yunbao.live.bean.LiveLuckGiftWinBean;
import com.yunbao.live.bean.LiveReceiveGiftBean;
import com.yunbao.live.bean.LiveUserGiftBean;
import defpackage.aq4;
import defpackage.ig4;
import defpackage.ik;
import defpackage.j30;
import defpackage.kn1;
import defpackage.lx1;
import defpackage.m93;
import defpackage.or3;
import defpackage.rv3;
import defpackage.rx1;
import defpackage.t54;
import defpackage.us0;
import io.socket.client.Socket;
import io.socket.client.a;
import java.lang.ref.WeakReference;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: /tmp/classes2.dex */
public class SocketClient {
    public Socket a;
    public String b;
    public String c;
    public volatile m d;
    public l e;
    public final Handler f = new Handler(Looper.getMainLooper());
    public final SecureRandom g = new SecureRandom();
    public final AtomicInteger h;
    public boolean i;
    public SecretKeySpec j;
    public volatile boolean k;
    public volatile boolean l;
    public us0.a m;
    public us0.a n;
    public us0.a o;
    public us0.a p;
    public us0.a q;
    public us0.a r;
    public us0.a s;
    public us0.a t;
    public us0.a u;
    public us0.a v;
    public us0.a w;

    /* loaded from: /tmp/classes2.dex */
    public class a implements us0.a {

        /* renamed from: com.yunbao.live.socket.SocketClient$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/classes2.dex */
        public class RunnableC0041a implements Runnable {
            public final /* synthetic */ String a;

            public RunnableC0041a(String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                l lVar = SocketClient.this.e;
                if (lVar != null) {
                    lVar.c(this.a);
                }
            }
        }

        public a() {
        }

        @Override // us0.a
        public void call(Object... objArr) {
            String S;
            if (SocketClient.this.k || (S = SocketClient.this.S("heartbeat_stop", objArr)) == null) {
                return;
            }
            lx1.c("socket", "--onHeartbeatStop-->" + SocketClient.this.H(S));
            lx1.c("HeartbeatSocket", "socket receive heartbeat_stop--->" + SocketClient.this.H(S));
            SocketClient.this.I(new RunnableC0041a(S), "heartbeat_stop");
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements us0.a {

        /* loaded from: /tmp/classes2.dex */
        public class a implements Runnable {
            public final /* synthetic */ String a;

            public a(String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                l lVar = SocketClient.this.e;
                if (lVar != null) {
                    lVar.b(this.a);
                }
            }
        }

        public b() {
        }

        @Override // us0.a
        public void call(Object... objArr) {
            String S;
            if (SocketClient.this.k || (S = SocketClient.this.S("heartbeat_result_ack", objArr)) == null) {
                return;
            }
            lx1.c("socket", "--onHeartbeatResultAck-->" + SocketClient.this.H(S));
            lx1.c("HeartbeatSocket", "socket receive heartbeat_result_ack--->" + SocketClient.this.H(S));
            SocketClient.this.I(new a(S), "heartbeat_result_ack");
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c implements us0.a {

        /* loaded from: /tmp/classes2.dex */
        public class a implements Runnable {
            public final /* synthetic */ String a;

            public a(String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                l lVar = SocketClient.this.e;
                if (lVar != null) {
                    lVar.a(this.a);
                }
            }
        }

        public c() {
        }

        @Override // us0.a
        public void call(Object... objArr) {
            String S;
            if (SocketClient.this.k || (S = SocketClient.this.S("server_message", objArr)) == null) {
                return;
            }
            lx1.c("socket", "--onServerMessage-->" + SocketClient.this.H(S));
            lx1.c("HeartbeatSocket", "socket receive server_message--->" + SocketClient.this.H(S));
            SocketClient.this.I(new a(S), "server_message");
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d implements us0.a {
        public d() {
        }

        @Override // us0.a
        public void call(Object... objArr) {
            if (SocketClient.this.k) {
                return;
            }
            SocketClient.this.l = false;
            lx1.c("socket", "--onConnect-->" + objArr);
            if (SocketClient.this.e != null) {
                lx1.c("HeartbeatSocket", "socket connected");
            }
            SocketClient.this.t();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e implements us0.a {
        public e() {
        }

        @Override // us0.a
        public void call(Object... objArr) {
            lx1.c("socket", "--reConnect-->" + objArr);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class f implements us0.a {
        public f() {
        }

        @Override // us0.a
        public void call(Object... objArr) {
            lx1.c("socket", "--onDisconnect-->" + objArr);
            SocketClient.this.l = false;
            if (SocketClient.this.k) {
                return;
            }
            SocketClient.this.M(2);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class g implements us0.a {
        public g() {
        }

        @Override // us0.a
        public void call(Object... objArr) {
            SocketClient.this.l = false;
            if (SocketClient.this.k) {
                return;
            }
            lx1.c("socket", "--onConnectError-->" + objArr);
            for (int i = 0; i < objArr.length; i++) {
                Object obj = objArr[i];
                StringBuilder sb = new StringBuilder("  Argument ");
                sb.append(i);
                sb.append(" (");
                sb.append(obj != null ? obj.getClass().getName() : "null");
                sb.append("): ");
                sb.append(obj);
                lx1.c("socket", sb.toString());
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class h implements us0.a {
        public h() {
        }

        @Override // us0.a
        public void call(Object... objArr) {
            lx1.c("socket", "--onConnectTimeOut-->" + objArr);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class i implements us0.a {
        public i() {
        }

        @Override // us0.a
        public void call(Object... objArr) {
            if (SocketClient.this.k) {
                return;
            }
            try {
                String str = "okk";
                if (SocketClient.this.i) {
                    String S = SocketClient.this.S("conn", objArr);
                    if (S == null) {
                        return;
                    }
                    str = SocketClient.this.G(S);
                    lx1.c("socket", "--onConn-->" + str);
                    if (SocketClient.this.e != null) {
                        lx1.c("HeartbeatSocket", "conn result--->" + str);
                    }
                } else if (objArr != null && objArr.length > 0) {
                    Object obj = objArr[0];
                    if (obj instanceof JSONArray) {
                        str = ((JSONArray) obj).getString(0);
                        lx1.c("socket", "--onConn-->" + str);
                        if (SocketClient.this.e != null) {
                            lx1.c("HeartbeatSocket", "conn result--->" + str);
                        }
                    }
                }
                Message F = SocketClient.this.F(0);
                if (F == null) {
                    return;
                }
                F.obj = Boolean.valueOf(str.equals("ok"));
                SocketClient.this.N(F);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class j implements us0.a {
        public j() {
        }

        @Override // us0.a
        public void call(Object... objArr) {
            Message F;
            if (SocketClient.this.k || objArr == null) {
                return;
            }
            try {
                if (objArr.length != 0) {
                    Object obj = objArr[0];
                    if (obj instanceof JSONArray) {
                        JSONArray jSONArray = (JSONArray) obj;
                        for (int i = 0; i < jSONArray.length() && (F = SocketClient.this.F(1)) != null; i++) {
                            String string = jSONArray.getString(i);
                            if (SocketClient.this.Q("broadcastingListen", string)) {
                                F.recycle();
                            } else {
                                F.obj = string;
                                SocketClient.this.N(F);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } catch (OutOfMemoryError unused) {
                lx1.c("socket", "socket broadcast oom, clear memory");
                SocketClient.this.s();
                MemoryPressureUtil.l();
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class k implements us0.a {

        /* loaded from: /tmp/classes2.dex */
        public class a implements Runnable {
            public final /* synthetic */ String a;

            public a(String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                l lVar = SocketClient.this.e;
                if (lVar != null) {
                    lVar.d(this.a);
                }
            }
        }

        public k() {
        }

        @Override // us0.a
        public void call(Object... objArr) {
            if (SocketClient.this.k) {
                return;
            }
            StringBuilder sb = new StringBuilder("socket raw heartbeat_task args count=");
            sb.append(objArr == null ? 0 : objArr.length);
            sb.append("--->");
            sb.append(SocketClient.this.p(objArr));
            lx1.c("HeartbeatSocket", sb.toString());
            String S = SocketClient.this.S("heartbeat_task", objArr);
            if (S == null) {
                return;
            }
            lx1.c("socket", "--onHeartbeatTask-->" + SocketClient.this.H(S));
            lx1.c("HeartbeatSocket", "socket receive heartbeat_task--->" + SocketClient.this.H(S));
            SocketClient.this.I(new a(S), "heartbeat_task");
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface l {
        void a(String str);

        void b(String str);

        void c(String str);

        void d(String str);
    }

    /* loaded from: /tmp/classes2.dex */
    public static class m extends Handler {
        public WeakReference a;
        public final AtomicInteger b;
        public String c;

        public m(or3 or3Var, AtomicInteger atomicInteger) {
            this.a = new WeakReference(or3Var);
            this.b = atomicInteger;
        }

        public final void a() {
            int i;
            if (this.b == null) {
                return;
            }
            do {
                i = this.b.get();
                if (i <= 0) {
                    return;
                }
            } while (!this.b.compareAndSet(i, i - 1));
        }

        public final String b(JSONObject jSONObject) {
            String string = "en".equals(rx1.c().d()) ? jSONObject.getString("ct_en") : jSONObject.getString("ct");
            return TextUtils.isEmpty(string) ? jSONObject.getString("ct") : string;
        }

        public final MsgStyleBean c(JSONObject jSONObject) {
            if (!jSONObject.containsKey("style")) {
                return null;
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("style");
            MsgStyleBean msgStyleBean = new MsgStyleBean();
            msgStyleBean.setBackgroundColor(jSONObject2.getString("backgroundColor"));
            msgStyleBean.setTextColor(jSONObject2.getString("textColor"));
            msgStyleBean.setBorderColor(jSONObject2.getString("borderColor"));
            return msgStyleBean;
        }

        public final or3 d() {
            WeakReference weakReference = this.a;
            if (weakReference != null) {
                return (or3) weakReference.get();
            }
            return null;
        }

        public final void e(JSONObject jSONObject) {
            or3 d = d();
            int intValue = jSONObject.getIntValue(com.umeng.ccg.a.z);
            if (intValue == 1) {
                UserBean userBean = new UserBean();
                userBean.setId(jSONObject.getString("uid"));
                userBean.setUserNiceName(jSONObject.getString("uname"));
                userBean.setAvatar(jSONObject.getString("uhead"));
                userBean.setSex(jSONObject.getIntValue("sex"));
                userBean.setLevel(jSONObject.getIntValue("level"));
                userBean.setLevelAnchor(jSONObject.getIntValue("level_anchor"));
                if (d != null) {
                    d.B0(userBean, jSONObject.getString("stream"), jSONObject.getIntValue("pktime"));
                    return;
                }
                return;
            }
            if (intValue == 3) {
                if (d != null) {
                    d.n0();
                    return;
                }
                return;
            }
            if (intValue == 4) {
                if (d != null) {
                    d.d0(jSONObject.getString("pkuid"), jSONObject.getIntValue("pktime"));
                    return;
                }
                return;
            }
            if (intValue == 5) {
                if (d != null) {
                    d.l0();
                }
            } else if (intValue == 7) {
                if (d != null) {
                    d.q0();
                }
            } else if (intValue == 8) {
                if (d != null) {
                    d.e0();
                }
            } else if (intValue == 9 && d != null) {
                d.K0(jSONObject.getString("win_uid"));
            }
        }

        public final void f(String str) {
            lx1.b("收到socket--->" + str);
            or3 d = d();
            if ("SuperStopPlay".equals(str)) {
                if (d != null) {
                    d.p0();
                    return;
                }
                return;
            }
            SocketReceiveBean socketReceiveBean = (SocketReceiveBean) JSON.parseObject(str, SocketReceiveBean.class);
            JSONObject jSONObject = socketReceiveBean.getMsg().getJSONObject(0);
            String string = jSONObject.getString("_method_");
            string.getClass();
            char c = 65535;
            switch (string.hashCode()) {
                case -2129689740:
                    if (string.equals("startGame")) {
                        c = 0;
                        break;
                    }
                    break;
                case -2018567161:
                    if (string.equals("LivePK")) {
                        c = 1;
                        break;
                    }
                    break;
                case -1898258297:
                    if (string.equals("Sendplatgift")) {
                        c = 2;
                        break;
                    }
                    break;
                case -1823478987:
                    if (string.equals("xqtbWin")) {
                        c = 3;
                        break;
                    }
                    break;
                case -1811712494:
                    if (string.equals("startRotationGame")) {
                        c = 4;
                        break;
                    }
                    break;
                case -1577607739:
                    if (string.equals("StartEndLive")) {
                        c = 5;
                        break;
                    }
                    break;
                case -1527316170:
                    if (string.equals("SystemAnnouncement")) {
                        c = 6;
                        break;
                    }
                    break;
                case -1161888252:
                    if (string.equals("SystemNot")) {
                        c = 7;
                        break;
                    }
                    break;
                case -1088865062:
                    if (string.equals("SystemNotification")) {
                        c = '\b';
                        break;
                    }
                    break;
                case -1019089619:
                    if (string.equals("voiceRoom")) {
                        c = '\t';
                        break;
                    }
                    break;
                case -941606945:
                    if (string.equals("BuyGuard")) {
                        c = '\n';
                        break;
                    }
                    break;
                case -834957615:
                    if (string.equals("SuperStopPlay")) {
                        c = 11;
                        break;
                    }
                    break;
                case -798856367:
                    if (string.equals("KickUser")) {
                        c = '\f';
                        break;
                    }
                    break;
                case -671392591:
                    if (string.equals("SystemNotTop")) {
                        c = '\r';
                        break;
                    }
                    break;
                case -650417479:
                    if (string.equals("SendMsg")) {
                        c = 14;
                        break;
                    }
                    break;
                case -650413111:
                    if (string.equals("SendRed")) {
                        c = 15;
                        break;
                    }
                    break;
                case -403416738:
                    if (string.equals("LiveUserListUpdate")) {
                        c = 16;
                        break;
                    }
                    break;
                case -224008367:
                    if (string.equals("jackpotUp")) {
                        c = 17;
                        break;
                    }
                    break;
                case 102970646:
                    if (string.equals("light")) {
                        c = 18;
                        break;
                    }
                    break;
                case 510463595:
                    if (string.equals("luckWin")) {
                        c = 19;
                        break;
                    }
                    break;
                case 530405532:
                    if (string.equals("disconnect")) {
                        c = 20;
                        break;
                    }
                    break;
                case 782753456:
                    if (string.equals("shopGoodsLiveFloat")) {
                        c = 21;
                        break;
                    }
                    break;
                case 1001385855:
                    if (string.equals("goodsLiveShow")) {
                        c = 22;
                        break;
                    }
                    break;
                case 1071246616:
                    if (string.equals("SendBarrage")) {
                        c = 23;
                        break;
                    }
                    break;
                case 1124446108:
                    if (string.equals("warning")) {
                        c = 24;
                        break;
                    }
                    break;
                case 1132144150:
                    if (string.equals("changeLiveType")) {
                        c = 25;
                        break;
                    }
                    break;
                case 1311706360:
                    if (string.equals("SendGift")) {
                        c = 26;
                        break;
                    }
                    break;
                case 1358013348:
                    if (string.equals("updateVotesTotal")) {
                        c = 27;
                        break;
                    }
                    break;
                case 1387381773:
                    if (string.equals("setAdmin")) {
                        c = 28;
                        break;
                    }
                    break;
                case 1431529022:
                    if (string.equals("LiveConnect")) {
                        c = 29;
                        break;
                    }
                    break;
                case 1447768495:
                    if (string.equals("RefreshPullUrl")) {
                        c = 30;
                        break;
                    }
                    break;
                case 1520474440:
                    if (string.equals("updateGuardTotal")) {
                        c = 31;
                        break;
                    }
                    break;
                case 1645677030:
                    if (string.equals("jackpotWin")) {
                        c = ' ';
                        break;
                    }
                    break;
                case 1676613923:
                    if (string.equals("xydzpWin")) {
                        c = '!';
                        break;
                    }
                    break;
                case 2033694202:
                    if (string.equals("ShutUpUser")) {
                        c = '\"';
                        break;
                    }
                    break;
                case 2069692881:
                    if (string.equals("ConnectVideo")) {
                        c = '#';
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    if (d != null) {
                        d.v0(jSONObject);
                        return;
                    }
                    return;
                case 1:
                    e(jSONObject);
                    return;
                case 2:
                    if (d != null) {
                        d.f0((GlobalGiftBean) jSONObject.toJavaObject(GlobalGiftBean.class));
                        return;
                    }
                    return;
                case 3:
                    if (d != null) {
                        d.M0(jSONObject.getString("list"));
                        return;
                    }
                    return;
                case 4:
                    if (d != null) {
                        d.r(jSONObject);
                        return;
                    }
                    return;
                case 5:
                    int intValue = jSONObject.getIntValue(com.umeng.ccg.a.z);
                    if (intValue == 18) {
                        if (d != null) {
                            d.A0();
                            return;
                        }
                        return;
                    } else {
                        if (intValue != 19 || d == null) {
                            return;
                        }
                        d.Y();
                        return;
                    }
                case 6:
                case '\r':
                    lx1.c("socket", "socket--------getLanguageCt(map)---" + b(jSONObject));
                    LiveChatBean liveChatBean = new LiveChatBean();
                    liveChatBean.setContent(b(jSONObject));
                    liveChatBean.setMsgStyleBean(c(jSONObject));
                    liveChatBean.setType(6);
                    if (d != null) {
                        d.f(liveChatBean);
                        return;
                    }
                    return;
                case 7:
                case '\b':
                    lx1.c("socket", "socket--------getLanguageCt(map)---" + b(jSONObject));
                    l(b(jSONObject), c(jSONObject));
                    return;
                case '\t':
                    i(jSONObject);
                    return;
                case '\n':
                    LiveBuyGuardMsgBean liveBuyGuardMsgBean = new LiveBuyGuardMsgBean();
                    liveBuyGuardMsgBean.setUid(jSONObject.getString("uid"));
                    liveBuyGuardMsgBean.setUserName(jSONObject.getString("uname"));
                    liveBuyGuardMsgBean.setVotes(jSONObject.getString("votestotal"));
                    liveBuyGuardMsgBean.setGuardNum(jSONObject.getIntValue("guard_nums"));
                    liveBuyGuardMsgBean.setGuardType(jSONObject.getIntValue("guard_type"));
                    if (d != null) {
                        d.E0(liveBuyGuardMsgBean);
                        return;
                    }
                    return;
                case 11:
                    if (d != null) {
                        d.p0();
                        return;
                    }
                    return;
                case '\f':
                    if (d != null) {
                        d.l(jSONObject.getString("touid"));
                        return;
                    }
                    return;
                case 14:
                    lx1.c("socket", "---socket--------SOCKET_SEND_MSG---" + b(jSONObject));
                    String string2 = jSONObject.getString("msgtype");
                    if ("2".equals(string2)) {
                        if ("409002".equals(socketReceiveBean.getRetcode())) {
                            t54.a(m93.X4);
                            return;
                        }
                        LiveChatBean liveChatBean2 = new LiveChatBean();
                        liveChatBean2.setId(jSONObject.getString("uid"));
                        liveChatBean2.setUserNiceName(jSONObject.getString("uname"));
                        liveChatBean2.setLevel(jSONObject.getIntValue("level"));
                        liveChatBean2.setAnchor(jSONObject.getIntValue("isAnchor") == 1);
                        liveChatBean2.setManager(jSONObject.getIntValue("usertype") == 40);
                        liveChatBean2.setUserType(jSONObject.getIntValue("usertype"));
                        int intValue2 = jSONObject.getIntValue("heart");
                        liveChatBean2.setHeart(intValue2);
                        if (intValue2 > 0) {
                            liveChatBean2.setType(4);
                        }
                        lx1.c("socket", "socket--------SOCKET_SEND_MSG(map)---" + b(jSONObject));
                        liveChatBean2.setContent(b(jSONObject));
                        liveChatBean2.setLiangName(jSONObject.getString("liangname"));
                        liveChatBean2.setVipType(jSONObject.getIntValue("vip_type"));
                        liveChatBean2.setGuardType(jSONObject.getIntValue("guard_type"));
                        if (d != null) {
                            d.f(liveChatBean2);
                            return;
                        }
                        return;
                    }
                    if ("0".equals(string2)) {
                        JSONObject parseObject = JSON.parseObject(jSONObject.getString("ct"));
                        LiveUserGiftBean liveUserGiftBean = (LiveUserGiftBean) JSON.toJavaObject(parseObject, LiveUserGiftBean.class);
                        if (j30.q().N() && j30.q().C().equals(liveUserGiftBean.getId())) {
                            j30.q().D().setLevel(liveUserGiftBean.getLevel());
                        }
                        UserBean.Vip vip = new UserBean.Vip();
                        int intValue3 = parseObject.getIntValue("vip_type");
                        vip.setType(intValue3);
                        liveUserGiftBean.setVip(vip);
                        UserBean.Car car = new UserBean.Car();
                        car.setId(parseObject.getIntValue("car_id"));
                        car.setSwf(parseObject.getString("car_swf"));
                        car.setSwftime(parseObject.getFloatValue("car_swftime"));
                        String string3 = parseObject.getString("car_words");
                        if (rx1.g()) {
                            string3 = " " + parseObject.getString("words_en");
                        }
                        car.setWords(string3);
                        liveUserGiftBean.setCar(car);
                        UserBean.Liang liang = new UserBean.Liang();
                        String string4 = parseObject.getString("liangname");
                        liang.setName(string4);
                        liveUserGiftBean.setLiang(liang);
                        LiveChatBean liveChatBean3 = new LiveChatBean();
                        liveChatBean3.setType(3);
                        liveChatBean3.setId(liveUserGiftBean.getId());
                        liveChatBean3.setUserNiceName(liveUserGiftBean.getUserNiceName());
                        liveChatBean3.setLevel(liveUserGiftBean.getLevel());
                        liveChatBean3.setVipType(intValue3);
                        liveChatBean3.setLiangName(string4);
                        liveChatBean3.setManager(parseObject.getIntValue("usertype") == 40);
                        liveChatBean3.setContent(aq4.a(m93.A3));
                        liveChatBean3.setGuardType(parseObject.getIntValue("guard_type"));
                        if (d != null) {
                            d.w(new LiveEnterRoomBean(liveUserGiftBean, liveChatBean3));
                            return;
                        }
                        return;
                    }
                    return;
                case 15:
                    String string5 = jSONObject.getString("uid");
                    if (TextUtils.isEmpty(string5)) {
                        return;
                    }
                    LiveChatBean liveChatBean4 = new LiveChatBean();
                    liveChatBean4.setType(5);
                    liveChatBean4.setId(string5);
                    String a = string5.equals(this.c) ? aq4.a(m93.q3) : jSONObject.getString("uname");
                    if (rx1.h()) {
                        liveChatBean4.setContent(rv3.a(a, b(jSONObject)));
                    } else {
                        liveChatBean4.setContent(rv3.a(a, " ", b(jSONObject)));
                    }
                    if (d != null) {
                        d.L(liveChatBean4);
                        return;
                    }
                    return;
                case 16:
                    if (d != null) {
                        try {
                            com.alibaba.fastjson.JSONArray jSONArray = jSONObject.getJSONArray("userlist");
                            if (jSONArray != null) {
                                d.z0(jSONObject.getString("stream"), jSONObject.getIntValue("nums"), jSONObject.getLongValue("seq"), JSON.parseArray(jSONArray.toJSONString(), LiveUserGiftBean.class));
                                return;
                            }
                            return;
                        } catch (Exception e) {
                            lx1.c("socket", "LiveUserListUpdate parse fail--->" + e.getMessage());
                            return;
                        }
                    }
                    return;
                case 17:
                    if (d != null) {
                        d.P(jSONObject.getString("uplevel"));
                        return;
                    }
                    return;
                case 18:
                    if (d != null) {
                        d.X();
                        return;
                    }
                    return;
                case CrashStatKey.LOG_UPLOAD_BYTES_LIMIT /* 19 */:
                    if (d != null) {
                        d.u((LiveLuckGiftWinBean) jSONObject.toJavaObject(LiveLuckGiftWinBean.class));
                        return;
                    }
                    return;
                case CrashStatKey.LOG_UPLOAD_BUILTIN_LIMIT /* 20 */:
                    UserBean userBean = (UserBean) JSON.parseObject(jSONObject.getString("ct"), UserBean.class);
                    if (d != null) {
                        d.D(userBean);
                        return;
                    }
                    return;
                case CrashStatKey.LOG_UPLOAD_CUSTOM_LIMIT /* 21 */:
                    if (d != null) {
                        d.C0(jSONObject.getString("uname"));
                        return;
                    }
                    return;
                case CrashStatKey.LOG_ABANDONED_BUILTIN_FILE /* 22 */:
                    if (jSONObject.getIntValue(com.umeng.ccg.a.z) != 1) {
                        if (d != null) {
                            d.p(null);
                            return;
                        }
                        return;
                    }
                    GoodsBean goodsBean = new GoodsBean();
                    goodsBean.setId(jSONObject.getString("goodsid"));
                    goodsBean.setThumb(jSONObject.getString("goods_thumb"));
                    goodsBean.setName(jSONObject.getString("goods_name"));
                    goodsBean.setPriceNow(jSONObject.getString("goods_price"));
                    goodsBean.setType(jSONObject.getIntValue("goods_type"));
                    if (d != null) {
                        d.p(goodsBean);
                        return;
                    }
                    return;
                case CrashStatKey.LOG_ABANDONED_CUSTOM_FILE /* 23 */:
                    LiveDanMuBean liveDanMuBean = (LiveDanMuBean) JSON.parseObject(jSONObject.getString("ct"), LiveDanMuBean.class);
                    liveDanMuBean.setAvatar(jSONObject.getString("uhead"));
                    liveDanMuBean.setUserNiceName(jSONObject.getString("uname"));
                    if (d != null) {
                        d.c(liveDanMuBean);
                        return;
                    }
                    return;
                case CrashStatKey.LOG_UPLOAD_ZIP_COUNT /* 24 */:
                    if (d != null) {
                        d.L0(b(jSONObject));
                        return;
                    }
                    return;
                case CrashStatKey.LOG_RENAMED_COUNT /* 25 */:
                    if (jSONObject.containsKey("ct")) {
                        JSONObject jSONObject2 = jSONObject.getJSONObject("ct");
                        if (d != null) {
                            d.N(jSONObject2.getIntValue("live_type"), jSONObject2.getIntValue("live_val"), jSONObject2.getString("connect"));
                            return;
                        }
                        return;
                    }
                    return;
                case CrashStatKey.LOG_SAFE_SKIP_COUNT /* 26 */:
                    LiveReceiveGiftBean liveReceiveGiftBean = (LiveReceiveGiftBean) JSON.parseObject(jSONObject.getString("ct"), LiveReceiveGiftBean.class);
                    liveReceiveGiftBean.setAvatar(jSONObject.getString("uhead"));
                    liveReceiveGiftBean.setUserNiceName(jSONObject.getString("uname"));
                    if (liveReceiveGiftBean.getType() == 3) {
                        liveReceiveGiftBean.setPointList(JSON.parseArray(jSONObject.getString("paintedPath"), PointF.class));
                        liveReceiveGiftBean.setDrawWidth(jSONObject.getFloatValue("paintedWidth"));
                        liveReceiveGiftBean.setDrawHeight(jSONObject.getFloatValue("paintedHeight"));
                    }
                    LiveChatBean liveChatBean5 = new LiveChatBean();
                    liveChatBean5.setUserNiceName(liveReceiveGiftBean.getUserNiceName());
                    liveChatBean5.setLevel(liveReceiveGiftBean.getLevel());
                    liveChatBean5.setId(jSONObject.getString("uid"));
                    liveChatBean5.setLiangName(jSONObject.getString("liangname"));
                    liveChatBean5.setVipType(jSONObject.getIntValue("vip_type"));
                    liveChatBean5.setGuardType(jSONObject.getIntValue("guard_type"));
                    liveChatBean5.setType(2);
                    liveChatBean5.setMsgStyleBean(c(jSONObject));
                    if (jSONObject.getIntValue("ifpk") != 1) {
                        if (d != null) {
                            d.J0(liveReceiveGiftBean, liveChatBean5);
                            return;
                        }
                        return;
                    } else {
                        if (TextUtils.isEmpty(this.c)) {
                            return;
                        }
                        if (this.c.equals(liveReceiveGiftBean.getToUid())) {
                            if (d != null) {
                                d.J0(liveReceiveGiftBean, liveChatBean5);
                                d.G0(jSONObject.getLongValue("pktotal1"), jSONObject.getLongValue("pktotal2"));
                                return;
                            }
                            return;
                        }
                        if (d != null) {
                            d.J0(liveReceiveGiftBean, liveChatBean5);
                            d.G0(jSONObject.getLongValue("pktotal2"), jSONObject.getLongValue("pktotal1"));
                            return;
                        }
                        return;
                    }
                case CrashStatKey.NATIVE_ANR_FG_TIMES /* 27 */:
                    if (d != null) {
                        d.K(jSONObject.getString("votes"));
                        return;
                    }
                    return;
                case CrashStatKey.NATIVE_ANR_BG_TIMES /* 28 */:
                    if (d != null) {
                        d.G(jSONObject.getString("touid"), jSONObject.getIntValue(com.umeng.ccg.a.z));
                        return;
                    }
                    return;
                case CrashStatKey.UNEXP_LOW_MEM_TIMES /* 29 */:
                    h(jSONObject);
                    return;
                case CrashStatKey.UNEXP_KILLED_TIMES /* 30 */:
                    h(jSONObject);
                    String string6 = jSONObject.getString("ct");
                    if (d != null) {
                        d.o(string6);
                        return;
                    }
                    return;
                case CrashStatKey.UNEXP_EXIT_TIMES /* 31 */:
                    if (d != null) {
                        d.g0(jSONObject.getIntValue("guard_nums"));
                        return;
                    }
                    return;
                case ' ':
                    if (d != null) {
                        d.g((LiveGiftPrizePoolWinBean) jSONObject.toJavaObject(LiveGiftPrizePoolWinBean.class));
                        return;
                    }
                    return;
                case '!':
                    if (d != null) {
                        d.y0(jSONObject.getString("list"));
                        return;
                    }
                    return;
                case '\"':
                    if (d != null) {
                        d.n(jSONObject.getString("touid"), jSONObject.getIntValue(com.umeng.ccg.a.z));
                        return;
                    }
                    return;
                case '#':
                    g(jSONObject);
                    return;
                default:
                    return;
            }
        }

        public final void g(JSONObject jSONObject) {
            or3 d = d();
            switch (jSONObject.getIntValue(com.umeng.ccg.a.z)) {
                case 1:
                    UserBean userBean = new UserBean();
                    userBean.setId(jSONObject.getString("uid"));
                    userBean.setUserNiceName(jSONObject.getString("uname"));
                    userBean.setAvatar(jSONObject.getString("uhead"));
                    userBean.setSex(jSONObject.getIntValue("sex"));
                    userBean.setLevel(jSONObject.getIntValue("level"));
                    if (d != null) {
                        d.Q(userBean);
                        return;
                    }
                    return;
                case 2:
                    if (d != null) {
                        d.V(jSONObject.getString("touid"));
                        return;
                    }
                    return;
                case 3:
                    if (!jSONObject.getString("touid").equals(j30.q().C()) || d == null) {
                        return;
                    }
                    d.T();
                    return;
                case 4:
                    String string = jSONObject.getString("uid");
                    if (TextUtils.isEmpty(string) || string.equals(j30.q().C()) || d == null) {
                        return;
                    }
                    d.I0(string, jSONObject.getString("uname"), jSONObject.getString("playurl"));
                    return;
                case 5:
                    if (d != null) {
                        d.m(jSONObject.getString("uid"), jSONObject.getString("uname"));
                        return;
                    }
                    return;
                case 6:
                    if (d != null) {
                        d.H(jSONObject.getString("touid"), jSONObject.getString("uname"));
                        return;
                    }
                    return;
                case 7:
                    if (!jSONObject.getString("touid").equals(j30.q().C()) || d == null) {
                        return;
                    }
                    d.a0();
                    return;
                case 8:
                    if (!jSONObject.getString("touid").equals(j30.q().C()) || d == null) {
                        return;
                    }
                    d.F0();
                    return;
                case 9:
                    if (d != null) {
                        d.F(jSONObject.getString("touid"));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }

        public final void h(JSONObject jSONObject) {
            or3 d = d();
            int intValue = jSONObject.getIntValue(com.umeng.ccg.a.z);
            if (intValue == 1) {
                UserBean userBean = new UserBean();
                userBean.setId(jSONObject.getString("uid"));
                userBean.setUserNiceName(jSONObject.getString("uname"));
                userBean.setAvatar(jSONObject.getString("uhead"));
                userBean.setSex(jSONObject.getIntValue("sex"));
                userBean.setLevel(jSONObject.getIntValue("level"));
                userBean.setLevelAnchor(jSONObject.getIntValue("level_anchor"));
                if (d != null) {
                    d.d(userBean, jSONObject.getString("stream"));
                    return;
                }
                return;
            }
            if (intValue == 3) {
                if (d != null) {
                    d.j0();
                    return;
                }
                return;
            }
            if (intValue == 4) {
                if (d != null) {
                    d.s0(jSONObject.getString("pkuid"), jSONObject.getString("tostream"), jSONObject.getString("pkpull"));
                    return;
                }
                return;
            }
            if (intValue == 5) {
                if (d != null) {
                    d.o0();
                }
            } else if (intValue == 7) {
                if (d != null) {
                    d.m0();
                }
            } else if (intValue == 8) {
                if (d != null) {
                    d.v();
                }
            } else if (intValue == 9 && d != null) {
                d.e();
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            or3 d = d();
            try {
                if (d == null) {
                    a();
                    return;
                }
                try {
                    int i = message.what;
                    if (i == 0) {
                        d.D0(((Boolean) message.obj).booleanValue());
                    } else if (i == 1) {
                        f((String) message.obj);
                    } else if (i == 2) {
                        d.h0();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    a();
                }
            } finally {
                a();
            }
        }

        public final void i(JSONObject jSONObject) {
            or3 d = d();
            switch (jSONObject.getIntValue(com.umeng.ccg.a.z)) {
                case 1:
                    if (d != null) {
                        d.z();
                        return;
                    }
                    return;
                case 2:
                    if (d != null) {
                        d.s(jSONObject.getString("touid"), jSONObject.getString("toname"), jSONObject.getString("avatar"), jSONObject.getIntValue("position"));
                        return;
                    }
                    return;
                case 3:
                    if (d != null) {
                        d.W(jSONObject.getString("uid"), jSONObject.getIntValue("type"));
                        return;
                    }
                    return;
                case 4:
                    if (d != null) {
                        d.I(jSONObject.getString("uid"), jSONObject.getIntValue("position"), jSONObject.getIntValue(cl.i));
                        return;
                    }
                    return;
                case 5:
                    if (d != null) {
                        d.E(jSONObject.getString("uid"), jSONObject.getString("pull"), jSONObject.getString("user_stream"));
                        return;
                    }
                    return;
                case 6:
                    if (d != null) {
                        d.R(jSONObject.getString("uid"), jSONObject.getIntValue("face"));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }

        public void j() {
            WeakReference weakReference = this.a;
            if (weakReference != null) {
                weakReference.clear();
                this.a = null;
            }
            AtomicInteger atomicInteger = this.b;
            if (atomicInteger != null) {
                atomicInteger.set(0);
            }
            removeCallbacksAndMessages(null);
        }

        public void k(String str) {
            this.c = str;
        }

        public final void l(String str, MsgStyleBean msgStyleBean) {
            LiveChatBean liveChatBean = new LiveChatBean();
            liveChatBean.setContent(str);
            liveChatBean.setMsgStyleBean(msgStyleBean);
            liveChatBean.setType(1);
            or3 d = d();
            if (d != null) {
                d.f(liveChatBean);
            }
        }
    }

    public SocketClient(String str, or3 or3Var) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        this.h = atomicInteger;
        this.m = new d();
        this.n = new e();
        this.o = new f();
        this.p = new g();
        this.q = new h();
        this.r = new i();
        this.s = new j();
        this.t = new k();
        this.u = new a();
        this.v = new b();
        this.w = new c();
        lx1.c("socket", "SocketClienturl----------" + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            lx1.c("socket", "SocketClienturlurlurl----------" + str);
            a.C0080a c0080a = new a.C0080a();
            c0080a.B = true;
            c0080a.s = true;
            c0080a.u = 2000L;
            c0080a.b = "/socket.io";
            c0080a.m = new String[]{"websocket"};
            c0080a.z = new HashMap<String, String>() { // from class: com.yunbao.live.socket.SocketClient.1
                {
                    put("uid", j30.q().C());
                    put("token", j30.q().B());
                    put("source", "android");
                    put(cl.n, ig4.b());
                }
            };
            Socket a2 = io.socket.client.a.a(str, c0080a);
            this.a = a2;
            a2.e("connect", this.m);
            this.a.e("disconnect", this.o);
            this.a.e("connect_error", this.p);
            this.a.e("conn", this.r);
            this.a.e("broadcastingListen", this.s);
            this.a.e("heartbeat_task", this.t);
            this.a.e("heartbeat_stop", this.u);
            this.a.e("heartbeat_result_ack", this.v);
            this.a.e("server_message", this.w);
            this.d = new m(or3Var, atomicInteger);
        } catch (Exception e2) {
            lx1.c("socket", "socket url 异常--->" + e2.getMessage());
        }
    }

    public final long A() {
        return MemoryPressureUtil.g();
    }

    public final long B(int i2) {
        MemoryPressureUtil.Level h2 = MemoryPressureUtil.h();
        if (h2 == MemoryPressureUtil.Level.NORMAL) {
            return 0L;
        }
        s();
        MemoryPressureUtil.l();
        if (i2 != 1) {
            return 0L;
        }
        return h2 == MemoryPressureUtil.Level.CRITICAL ? 1200L : 300L;
    }

    public final SecretKeySpec C() {
        if (this.j == null) {
            this.j = new SecretKeySpec(MessageDigest.getInstance("SHA-256").digest("06bba2b804a1dbd2ab8f68bbe67f9627f15be44adabe040870ce30f9ee46fa75".getBytes(StandardCharsets.UTF_8)), "AES");
        }
        return this.j;
    }

    public final boolean D() {
        return MemoryPressureUtil.j();
    }

    public final boolean E(Socket socket) {
        try {
            if (this.l || socket.A()) {
                return true;
            }
            return socket.G();
        } catch (Exception unused) {
            return this.l;
        }
    }

    public final Message F(int i2) {
        if (this.k) {
            return null;
        }
        try {
            Message obtain = Message.obtain();
            obtain.what = i2;
            return obtain;
        } catch (OutOfMemoryError unused) {
            lx1.c("socket", "obtain socket message oom what=" + i2);
            return null;
        }
    }

    public final String G(String str) {
        if (TextUtils.isEmpty(str)) {
            return "okk";
        }
        try {
            Object nextValue = new JSONTokener(str).nextValue();
            if (nextValue instanceof JSONArray) {
                return ((JSONArray) nextValue).optString(0, "okk");
            }
            if (!(nextValue instanceof org.json.JSONObject)) {
                return String.valueOf(nextValue);
            }
            org.json.JSONObject jSONObject = (org.json.JSONObject) nextValue;
            if (jSONObject.optBoolean("ok", false)) {
                return "ok";
            }
            String optString = jSONObject.optString(cl.i, null);
            if (!TextUtils.isEmpty(optString)) {
                return optString;
            }
            String optString2 = jSONObject.optString("result", null);
            return TextUtils.isEmpty(optString2) ? "okk" : optString2;
        } catch (Exception e2) {
            lx1.c("HeartbeatSocket", "conn result parse fail--->" + e2.getMessage());
            return "okk";
        }
    }

    public final String H(String str) {
        if (str == null) {
            return "";
        }
        int length = str.length();
        if (length <= 2048) {
            return str;
        }
        return str.substring(0, IjkMediaMeta.FF_PROFILE_H264_INTRA) + "...(" + length + " chars)";
    }

    public final boolean I(Runnable runnable, String str) {
        if (!this.k && runnable != null) {
            try {
                return this.f.post(runnable);
            } catch (OutOfMemoryError unused) {
                lx1.c("socket", "drop socket main callback oom event=" + str);
            } catch (RuntimeException e2) {
                lx1.c("socket", "drop socket main callback fail event=" + str + "--->" + e2.getMessage());
                return false;
            }
        }
        return false;
    }

    public final String J(String str, String str2) {
        if (str2 == null || Q(str, str2)) {
            return null;
        }
        return str2;
    }

    public void K(SocketSendBean socketSendBean) {
        Object r;
        Socket socket = this.a;
        if (this.k || socket == null || socketSendBean == null || (r = r("broadcast", socketSendBean.create())) == null) {
            return;
        }
        socket.a("broadcast", r);
    }

    public void L(org.json.JSONObject jSONObject) {
        Object r;
        Socket socket = this.a;
        if (this.k || socket == null || jSONObject == null || (r = r("heartbeat_result", jSONObject)) == null) {
            return;
        }
        lx1.c("HeartbeatSocket", "emit heartbeat_result--->" + jSONObject);
        socket.a("heartbeat_result", r);
    }

    public final void M(int i2) {
        N(F(i2));
    }

    public final boolean N(Message message) {
        if (message == null) {
            return false;
        }
        if (this.k) {
            message.recycle();
            return false;
        }
        m mVar = this.d;
        if (mVar == null) {
            message.recycle();
            return false;
        }
        this.h.incrementAndGet();
        try {
            try {
                try {
                    long B = B(message.what);
                    boolean sendMessageDelayed = B > 0 ? mVar.sendMessageDelayed(message, B) : mVar.sendMessage(message);
                    if (!sendMessageDelayed) {
                        w();
                        message.recycle();
                    }
                    return sendMessageDelayed;
                } catch (OutOfMemoryError unused) {
                    lx1.c("socket", "drop socket message oom what=" + message.what);
                    w();
                    message.recycle();
                    return false;
                }
            } catch (RuntimeException e2) {
                lx1.c("socket", "drop socket message fail what=" + message.what + "--->" + e2.getMessage());
                w();
                message.recycle();
                return false;
            }
        } catch (Throwable th) {
            w();
            message.recycle();
            throw th;
        }
    }

    public void O(l lVar) {
        this.e = lVar;
    }

    public void P(boolean z) {
        this.i = z;
    }

    public final boolean Q(String str, String str2) {
        if (str2 == null) {
            return false;
        }
        int length = str2.length();
        if (length > 1048576) {
            lx1.c("socket", "drop socket payload too large event=" + str + ", length=" + length);
            return true;
        }
        if (D()) {
            lx1.c("socket", "socket payload low memory event=" + str + ", available=" + A());
            s();
            MemoryPressureUtil.l();
        }
        return false;
    }

    public final String R(Object obj) {
        return obj == null ? "null" : obj instanceof String ? (String) obj : String.valueOf(obj);
    }

    public final String S(String str, Object... objArr) {
        Object obj;
        if (!this.i) {
            try {
                return J(str, q(objArr));
            } catch (OutOfMemoryError unused) {
                lx1.c("HeartbeatSocket", "socket payload stringify oom event=" + str);
                this.s();
                return null;
            }
        }
        if (objArr == null || objArr.length == 0 || (obj = objArr[0]) == null) {
            lx1.c("HeartbeatSocket", "socket decrypt fail event=" + str + "--->empty encrypted payload");
            return null;
        }
        if (objArr.length != 1 || !(obj instanceof String)) {
            lx1.c("HeartbeatSocket", "socket decrypt fail event=" + str + "--->invalid encrypted payload");
            return null;
        }
        try {
            String valueOf = String.valueOf(obj);
            if (Q(str, valueOf)) {
                return null;
            }
            String x = x(valueOf);
            lx1.c("HeartbeatSocket", "socket decrypt payload event=" + str);
            return J(str, x);
        } catch (Exception e2) {
            lx1.c("HeartbeatSocket", "socket decrypt fail event=" + str + "--->" + e2.getMessage());
            return null;
        } catch (OutOfMemoryError unused2) {
            lx1.c("HeartbeatSocket", "socket decrypt oom event=" + str);
            this.s();
            return null;
        }
    }

    public final String p(Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return "empty";
        }
        StringBuilder sb = new StringBuilder();
        int min = Math.min(objArr.length, 3);
        for (int i2 = 0; i2 < min; i2++) {
            Object obj = objArr[i2];
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append('#');
            sb.append(i2);
            sb.append('=');
            if (obj == null) {
                sb.append("null");
            } else if (obj instanceof String) {
                sb.append("String(");
                sb.append(((String) obj).length());
                sb.append(')');
            } else if (obj instanceof JSONArray) {
                sb.append("JSONArray(");
                sb.append(((JSONArray) obj).length());
                sb.append(')');
            } else {
                sb.append(obj.getClass().getSimpleName());
            }
        }
        if (objArr.length > min) {
            sb.append(", more=");
            sb.append(objArr.length - min);
        }
        return sb.toString();
    }

    public final String q(Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return "";
        }
        Object obj = objArr[0];
        if (obj == null) {
            return "";
        }
        if (objArr.length == 1) {
            return String.valueOf(obj);
        }
        JSONArray jSONArray = new JSONArray();
        for (Object obj2 : objArr) {
            jSONArray.put(obj2);
        }
        return jSONArray.toString();
    }

    public final Object r(String str, Object obj) {
        if (!this.i) {
            return obj;
        }
        try {
            String z = z(obj);
            lx1.c("HeartbeatSocket", "socket encrypt payload event=" + str);
            return z;
        } catch (Exception e2) {
            lx1.c("HeartbeatSocket", "socket encrypt fail event=" + str + "--->" + e2.getMessage());
            return null;
        }
    }

    public final void s() {
        try {
            kn1.c();
        } catch (Throwable unused) {
        }
        try {
            System.gc();
        } catch (Throwable unused2) {
        }
    }

    public final void t() {
        Socket socket;
        if (this.k || (socket = this.a) == null) {
            return;
        }
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("uid", j30.q().C());
            jSONObject.put("token", j30.q().B());
            jSONObject.put("mobileid", j30.q().j());
            jSONObject.put("device_id", j30.q().j());
            jSONObject.put("liveuid", this.b);
            jSONObject.put("roomnum", this.b);
            jSONObject.put("stream", this.c);
            Object r = r("conn", jSONObject);
            if (r != null) {
                socket.a("conn", r);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void u() {
        Socket socket = this.a;
        if (this.k || socket == null || E(socket)) {
            return;
        }
        this.l = true;
        socket.z();
    }

    public void v(String str, String str2) {
        if (this.k) {
            return;
        }
        this.b = str;
        this.c = str2;
        Socket socket = this.a;
        if (socket != null && !E(socket)) {
            this.l = true;
            socket.z();
        }
        if (this.d != null) {
            this.d.k(str);
        }
    }

    public final void w() {
        int i2;
        do {
            i2 = this.h.get();
            if (i2 <= 0) {
                return;
            }
        } while (!this.h.compareAndSet(i2, i2 - 1));
    }

    public final String x(String str) {
        byte[] decode = Base64.decode(str, 2);
        if (decode.length < 29) {
            ik.a("invalid payload length");
            return null;
        }
        byte[] bArr = new byte[12];
        int length = decode.length - 12;
        byte[] bArr2 = new byte[length];
        System.arraycopy(decode, 0, bArr, 0, 12);
        System.arraycopy(decode, 12, bArr2, 0, length);
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(2, C(), new GCMParameterSpec(128, bArr));
        return new String(cipher.doFinal(bArr2), StandardCharsets.UTF_8);
    }

    public void y() {
        this.k = true;
        this.l = false;
        Socket socket = this.a;
        if (socket != null) {
            try {
                socket.F().S(false);
            } catch (Exception unused) {
            }
            try {
                socket.C();
            } catch (Exception unused2) {
            }
            try {
                socket.y();
            } catch (Exception unused3) {
            }
            socket.b();
            this.a = null;
        }
        if (this.d != null) {
            this.d.j();
            this.d = null;
        }
        this.h.set(0);
        this.f.removeCallbacksAndMessages(null);
        this.b = null;
        this.c = null;
        this.e = null;
    }

    public final String z(Object obj) {
        byte[] bArr = new byte[12];
        this.g.nextBytes(bArr);
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(1, C(), new GCMParameterSpec(128, bArr));
        byte[] doFinal = cipher.doFinal(R(obj).getBytes(StandardCharsets.UTF_8));
        byte[] bArr2 = new byte[doFinal.length + 12];
        System.arraycopy(bArr, 0, bArr2, 0, 12);
        System.arraycopy(doFinal, 0, bArr2, 12, doFinal.length);
        return Base64.encodeToString(bArr2, 2);
    }
}
