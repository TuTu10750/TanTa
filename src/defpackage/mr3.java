package defpackage;

import com.umeng.ccg.a;
import com.yunbao.common.bean.UserBean;
import com.yunbao.live.socket.SocketClient;
import com.yunbao.live.socket.SocketSendBean;

/* loaded from: /tmp/classes2.dex */
public abstract class mr3 {
    public static void a(SocketClient socketClient, String str, int i) {
        UserBean D;
        if (socketClient == null || (D = j30.q().D()) == null) {
            return;
        }
        socketClient.K(new SocketSendBean().param("_method_", "LivePK").param(a.z, 2).param("msgtype", 0).param("uid", D.getId()).param("pktime", i).param("uname", D.getUserNiceName()).param("level", D.getLevel()).param("pkuid", str).param("ct", ""));
    }

    public static void b(SocketClient socketClient, String str, String str2, int i) {
        UserBean D;
        if (socketClient == null || (D = j30.q().D()) == null) {
            return;
        }
        socketClient.K(new SocketSendBean().param("_method_", "LivePK").param(a.z, 1).param("msgtype", 0).param("uid", D.getId()).param("uname", D.getUserNiceName()).param("level", D.getLevel()).param("pktime", i).param("level_anchor", D.getLevelAnchor()).param("sex", D.getSex()).param("uhead", D.getAvatar()).param("ct", "").param("stream", str2).param("pkuid", str));
    }

    public static void c(SocketClient socketClient, String str) {
        if (socketClient == null) {
            return;
        }
        socketClient.K(new SocketSendBean().param("_method_", "LivePK").param(a.z, 7).param("msgtype", 10).param("pkuid", str));
    }

    public static void d(SocketClient socketClient, String str) {
        if (socketClient == null) {
            return;
        }
        socketClient.K(new SocketSendBean().param("_method_", "LivePK").param(a.z, 8).param("msgtype", 10).param("pkuid", str));
    }

    public static void e(SocketClient socketClient, String str) {
        UserBean D;
        if (socketClient == null || (D = j30.q().D()) == null) {
            return;
        }
        socketClient.K(new SocketSendBean().param("_method_", "LivePK").param(a.z, 3).param("msgtype", 0).param("uid", D.getId()).param("uname", D.getUserNiceName()).param("pkuid", str).param("ct", ""));
    }
}
