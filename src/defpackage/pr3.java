package defpackage;

import android.text.TextUtils;
import com.umeng.analytics.pro.cl;
import com.umeng.ccg.a;
import com.yunbao.common.bean.UserBean;
import com.yunbao.live.socket.SocketClient;
import com.yunbao.live.socket.SocketSendBean;

/* loaded from: /tmp/classes2.dex */
public abstract class pr3 {
    public static void a(SocketClient socketClient) {
        if (socketClient == null) {
            return;
        }
        socketClient.K(new SocketSendBean().param("_method_", "voiceRoom").param(a.z, 1));
    }

    public static void b(SocketClient socketClient, String str, int i, int i2) {
        if (socketClient == null) {
            return;
        }
        SocketSendBean param = new SocketSendBean().param("_method_", "voiceRoom").param(a.z, 4);
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        socketClient.K(param.param("uid", str).param("position", i).param(cl.i, i2));
    }

    public static void c(SocketClient socketClient, UserBean userBean, int i) {
        if (socketClient == null) {
            return;
        }
        socketClient.K(new SocketSendBean().param("_method_", "voiceRoom").param(a.z, 2).param("touid", userBean.getId()).param("toname", userBean.getUserNiceName()).param("avatar", userBean.getAvatar()).param("position", i));
    }

    public static void d(SocketClient socketClient, String str, int i) {
        if (socketClient == null) {
            return;
        }
        socketClient.K(new SocketSendBean().param("_method_", "voiceRoom").param(a.z, 3).param("uid", str).param("type", i));
    }

    public static void e(SocketClient socketClient, int i) {
        if (socketClient == null) {
            return;
        }
        socketClient.K(new SocketSendBean().param("_method_", "voiceRoom").param(a.z, 6).param("uid", j30.q().C()).param("face", i));
    }
}
