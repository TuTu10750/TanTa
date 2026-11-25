package defpackage;

import com.umeng.ccg.a;
import com.umeng.commonsdk.deeplink.DeepLinkPresetEvent;
import com.yunbao.common.bean.UserBean;
import com.yunbao.live.socket.SocketClient;
import com.yunbao.live.socket.SocketSendBean;

/* loaded from: /tmp/classes2.dex */
public abstract class kr3 {
    public static void a(SocketClient socketClient) {
        UserBean D;
        if (socketClient == null || (D = j30.q().D()) == null) {
            return;
        }
        socketClient.K(new SocketSendBean().param("_method_", "startGame").param(a.z, 3).param("msgtype", 15).param("level", D.getLevel()).param("uname", D.getUserNiceName()).param("uid", D.getId()).param("ct", ""));
    }

    public static void b(SocketClient socketClient, String str) {
        UserBean D;
        if (socketClient == null || (D = j30.q().D()) == null) {
            return;
        }
        socketClient.K(new SocketSendBean().param("_method_", "startGame").param(a.z, 2).param("msgtype", 15).param("level", D.getLevel()).param("uname", D.getUserNiceName()).param("uid", D.getId()).param("gameid", str).param("ct", ""));
    }

    public static void c(SocketClient socketClient, String str, String str2, String str3, int i) {
        UserBean D;
        if (socketClient == null || (D = j30.q().D()) == null) {
            return;
        }
        socketClient.K(new SocketSendBean().param("_method_", "startGame").param(a.z, 4).param("msgtype", 15).param("level", D.getLevel()).param("uname", D.getUserNiceName()).param("uid", D.getId()).param("liveuid", str).param("gameid", str2).param("token", str3).param(DeepLinkPresetEvent.UMEventParamTime, i).param("ct", ""));
    }

    public static void d(SocketClient socketClient, int i, int i2) {
        UserBean D;
        if (socketClient == null || (D = j30.q().D()) == null) {
            return;
        }
        socketClient.K(new SocketSendBean().param("_method_", "startGame").param(a.z, 5).param("msgtype", 15).param("level", D.getLevel()).param("uname", D.getUserNiceName()).param("uid", D.getId()).param("money", i).param("type", i2).param("ct", ""));
    }

    public static void e(SocketClient socketClient) {
        UserBean D;
        if (socketClient == null || (D = j30.q().D()) == null) {
            return;
        }
        socketClient.K(new SocketSendBean().param("_method_", "startGame").param(a.z, 1).param("msgtype", 15).param("level", D.getLevel()).param("uname", D.getUserNiceName()).param("uid", D.getId()).param("ct", ""));
    }

    public static void f(SocketClient socketClient) {
        UserBean D;
        if (socketClient == null || (D = j30.q().D()) == null) {
            return;
        }
        socketClient.K(new SocketSendBean().param("_method_", "startRotationGame").param(a.z, 3).param("msgtype", 16).param("level", D.getLevel()).param("uname", D.getUserNiceName()).param("uid", D.getId()).param("ct", ""));
    }

    public static void g(SocketClient socketClient, String str, String str2, String str3, int i) {
        UserBean D;
        if (socketClient == null || (D = j30.q().D()) == null) {
            return;
        }
        socketClient.K(new SocketSendBean().param("_method_", "startRotationGame").param(a.z, 4).param("msgtype", 16).param("level", D.getLevel()).param("uname", D.getUserNiceName()).param("uid", D.getId()).param("liveuid", str).param("gameid", str2).param("token", str3).param(DeepLinkPresetEvent.UMEventParamTime, i).param("ct", ""));
    }

    public static void h(SocketClient socketClient, int i, int i2) {
        UserBean D;
        if (socketClient == null || (D = j30.q().D()) == null) {
            return;
        }
        socketClient.K(new SocketSendBean().param("_method_", "startRotationGame").param(a.z, 5).param("msgtype", 16).param("level", D.getLevel()).param("uname", D.getUserNiceName()).param("uid", D.getId()).param("money", i).param("type", i2).param("ct", ""));
    }

    public static void i(SocketClient socketClient) {
        UserBean D;
        if (socketClient == null || (D = j30.q().D()) == null) {
            return;
        }
        socketClient.K(new SocketSendBean().param("_method_", "startRotationGame").param(a.z, 1).param("msgtype", 16).param("level", D.getLevel()).param("uname", D.getUserNiceName()).param("uid", D.getId()).param("ct", ""));
    }
}
