package defpackage;

import com.umeng.ccg.a;
import com.yunbao.common.bean.UserBean;
import com.yunbao.live.socket.SocketClient;
import com.yunbao.live.socket.SocketSendBean;

/* loaded from: /tmp/classes2.dex */
public abstract class nr3 {
    public static void a(SocketClient socketClient, String str) {
        UserBean D;
        if (socketClient == null || (D = j30.q().D()) == null) {
            return;
        }
        socketClient.K(new SocketSendBean().param("_method_", "ConnectVideo").param(a.z, 2).param("msgtype", 10).param("uid", D.getId()).param("uname", D.getUserNiceName()).param("level", D.getLevel()).param("touid", str).param("ct", ""));
    }

    public static void b(SocketClient socketClient, String str) {
        if (socketClient == null) {
            return;
        }
        socketClient.K(new SocketSendBean().param("_method_", "ConnectVideo").param(a.z, 7).param("msgtype", 10).param("touid", str));
    }

    public static void c(SocketClient socketClient, String str) {
        if (socketClient == null) {
            return;
        }
        socketClient.K(new SocketSendBean().param("_method_", "ConnectVideo").param(a.z, 8).param("msgtype", 10).param("touid", str));
    }

    public static void d(SocketClient socketClient, String str) {
        UserBean D;
        if (socketClient == null || (D = j30.q().D()) == null) {
            return;
        }
        socketClient.K(new SocketSendBean().param("_method_", "ConnectVideo").param(a.z, 3).param("msgtype", 10).param("uid", D.getId()).param("uname", D.getUserNiceName()).param("level", D.getLevel()).param("touid", str).param("ct", ""));
    }

    public static void e(SocketClient socketClient) {
        UserBean D;
        if (socketClient == null || (D = j30.q().D()) == null) {
            return;
        }
        socketClient.K(new SocketSendBean().param("_method_", "ConnectVideo").param(a.z, 1).param("msgtype", 10).param("uid", D.getId()).param("uname", D.getUserNiceName()).param("level", D.getLevel()).param("sex", D.getSex()).param("uhead", D.getAvatar()).param("ct", ""));
    }

    public static void f(SocketClient socketClient) {
        UserBean D;
        if (socketClient == null || (D = j30.q().D()) == null) {
            return;
        }
        socketClient.K(new SocketSendBean().param("_method_", "ConnectVideo").param(a.z, 5).param("msgtype", 10).param("uid", D.getId()).param("ct", "").param("uname", D.getUserNiceName()));
    }

    public static void g(SocketClient socketClient, String str, String str2) {
        UserBean D;
        if (socketClient == null || (D = j30.q().D()) == null) {
            return;
        }
        socketClient.K(new SocketSendBean().param("_method_", "ConnectVideo").param(a.z, 4).param("msgtype", 10).param("liveid", str2).param("uid", D.getId()).param("ct", "").param("uname", D.getUserNiceName()).param("level", D.getLevel()).param("playurl", str));
    }
}
