package defpackage;

import android.text.TextUtils;
import com.umeng.ccg.a;
import com.yunbao.common.bean.UserBean;
import com.yunbao.live.bean.LiveUserGiftBean;
import com.yunbao.live.socket.SocketClient;
import com.yunbao.live.socket.SocketSendBean;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /tmp/classes2.dex */
public abstract class jr3 {
    public static void a(SocketClient socketClient, String str) {
        if (socketClient == null || j30.q().D() == null) {
            return;
        }
        socketClient.K(new SocketSendBean().param("_method_", "xydzpWin").paramJsonArray("list", str));
    }

    public static void b(SocketClient socketClient, String str) {
        if (socketClient == null || j30.q().D() == null) {
            return;
        }
        socketClient.K(new SocketSendBean().param("_method_", "xqtbWin").paramJsonArray("list", str));
    }

    public static void c(SocketClient socketClient) {
        UserBean D;
        if (socketClient == null || (D = j30.q().D()) == null) {
            return;
        }
        socketClient.K(new SocketSendBean().param("_method_", "shopGoodsLiveFloat").param(a.z, 0).param("msgtype", 0).param("uid", D.getId()).param("uname", D.getUserNiceName()).param("ct", ""));
    }

    public static void d(SocketClient socketClient, String str, String str2, boolean z, int i, int i2) {
        UserBean D;
        if (socketClient == null || (D = j30.q().D()) == null) {
            return;
        }
        SocketSendBean param = new SocketSendBean().param("_method_", "SendMsg").param(a.z, 0).param("msgtype", 2).param("usertype", i).param("isAnchor", z ? 1 : 0).param("level", D.getLevel()).param("uname", D.getUserNiceName()).param("uid", D.getId()).param("liangname", D.getGoodName()).param("vip_type", D.getVip().getType()).param("guard_type", i2).param("ct", str);
        if (!TextUtils.isEmpty(str2)) {
            param.param("ct_en", str2);
        }
        socketClient.K(param);
    }

    public static void e(SocketClient socketClient, String str, boolean z, int i, int i2) {
        d(socketClient, str, null, z, i, i2);
    }

    public static void f(SocketClient socketClient, String str) {
        UserBean D;
        if (socketClient == null || (D = j30.q().D()) == null) {
            return;
        }
        socketClient.K(new SocketSendBean().param("_method_", "SendBarrage").param(a.z, 7).param("msgtype", 1).param("level", D.getLevel()).param("uname", D.getUserNiceName()).param("uid", D.getId()).param("uhead", D.getAvatar()).param("ct", str));
    }

    public static void g(SocketClient socketClient, String str, int i, long j, List list) {
        if (socketClient == null || TextUtils.isEmpty(str)) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                LiveUserGiftBean liveUserGiftBean = (LiveUserGiftBean) it.next();
                if (liveUserGiftBean != null && !TextUtils.isEmpty(liveUserGiftBean.getId())) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("id", liveUserGiftBean.getId());
                        jSONObject.put("avatar", TextUtils.isEmpty(liveUserGiftBean.getAvatar()) ? "" : liveUserGiftBean.getAvatar());
                        jSONObject.put("level", String.valueOf(liveUserGiftBean.getLevel()));
                        jSONObject.put("guard_type", String.valueOf(liveUserGiftBean.getGuardType()));
                        jSONObject.put("contribution", TextUtils.isEmpty(liveUserGiftBean.getContribution()) ? "0" : liveUserGiftBean.getContribution());
                        jSONArray.put(jSONObject);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        socketClient.K(new SocketSendBean().param("_method_", "LiveUserListUpdate").param(a.z, 0).param("msgtype", 0).param("stream", str).param("nums", i).param("seq", String.valueOf(j)).paramJsonArray("userlist", jSONArray.toString()));
    }

    public static void h(SocketClient socketClient) {
        UserBean D;
        if (socketClient == null || (D = j30.q().D()) == null) {
            return;
        }
        socketClient.K(new SocketSendBean().param("_method_", "SendRed").param(a.z, 0).param("msgtype", 0).param("uid", D.getId()).param("uname", D.getUserNiceName()).param("ct", "在直播间发红包啦！快去抢哦～").param("ct_en", "give out red envelopes in the live broadcast room! Go and grab it~"));
    }

    public static void i(SocketClient socketClient, int i, String str, String str2) {
        UserBean D;
        if (socketClient == null || (D = j30.q().D()) == null) {
            return;
        }
        aq4.a(i == 1 ? m93.I4 : m93.J4);
        socketClient.K(new SocketSendBean().param("_method_", "setAdmin").param(a.z, i).param("msgtype", 1).param("uname", D.getUserNiceName()).param("uid", D.getId()).param("touid", str).param("toname", str2).param("ct", rv3.a(str2, i == 1 ? "被设为管理员" : "被取消管理员")).param("ct_en", rv3.a(str2, i == 1 ? " is set as administrator" : " was removed as administrator")));
    }

    public static void j(SocketClient socketClient, String str, String str2) {
        UserBean D;
        if (socketClient == null || (D = j30.q().D()) == null) {
            return;
        }
        socketClient.K(new SocketSendBean().param("_method_", "SystemNot").param(a.z, 13).param("msgtype", 4).param("level", D.getLevel()).param("uname", D.getUserNiceName()).param("uid", D.getId()).param("ct", str).param("ct_en", str2));
    }
}
