package defpackage;

import com.umeng.analytics.pro.bv;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.common.http.HttpClient;
import java.util.HashMap;

/* loaded from: /tmp/classes2.dex */
public abstract class xj1 {
    public static void a(String str) {
        HttpClient.getInstance().cancel(str);
    }

    public static void b(int i, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Message.atLists", "getImAtLists").params("uid", j30.q().C()).params("token", j30.q().B()).params(bv.ax, Integer.valueOf(i)).execute(httpCallback);
    }

    public static void c(int i, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Message.commentLists", "getImCommentList").params("uid", j30.q().C()).params("token", j30.q().B()).params(bv.ax, Integer.valueOf(i)).execute(httpCallback);
    }

    public static void d(int i, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Message.fansLists", "getImConcatList").params("uid", j30.q().C()).params("token", j30.q().B()).params(bv.ax, Integer.valueOf(i)).execute(httpCallback);
    }

    public static void e(String str, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Home.getImConfig", "getImConfig").params("to_uid", str).params("uid", j30.q().C()).params("token", j30.q().B()).execute(httpCallback);
    }

    public static void f(int i, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Message.praiseLists", "getImLikeList").params("uid", j30.q().C()).params("token", j30.q().B()).params(bv.ax, Integer.valueOf(i)).execute(httpCallback);
    }

    public static void g(String str, HttpCallback httpCallback) {
        h(str, "getImUserInfo", httpCallback);
    }

    public static void h(String str, String str2, HttpCallback httpCallback) {
        HashMap hashMap = new HashMap();
        hashMap.put("uid", j30.q().C());
        hashMap.put("token", j30.q().B());
        hashMap.put("uids", str);
        HttpClient.getInstance().post("User.GetUidsInfo", str2, hashMap).execute(httpCallback);
    }

    public static void i(int i, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Message.GetList", "getSystemMessageList").params("uid", j30.q().C()).params("token", j30.q().B()).params(bv.ax, Integer.valueOf(i)).execute(httpCallback);
    }

    public static void j(String str, int i, String str2, HttpCallback httpCallback) {
        HashMap hashMap = new HashMap();
        hashMap.put("uid", j30.q().C());
        hashMap.put("token", j30.q().B());
        hashMap.put("senderId", j30.q().C());
        hashMap.put("receiverId", str);
        hashMap.put("messageType", i + "");
        hashMap.put("content", str2);
        HttpClient.getInstance().post("Conversation.sendMsg", "checkBlack", hashMap).execute(httpCallback);
    }
}
