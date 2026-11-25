package defpackage;

import com.yunbao.common.http.HttpCallback;
import com.yunbao.common.http.HttpClient;

/* loaded from: /tmp/classes2.dex */
public abstract class ya1 {
    public static void a(String str) {
        HttpClient.getInstance().cancel(str);
    }

    public static void b(String str, int i, int i2, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Game.JinhuaBet", "gameJinhuaBet").params("uid", j30.q().C()).params("token", j30.q().B()).params("gameid", str).params("coin", Integer.valueOf(i)).params("grade", Integer.valueOf(i2)).execute(httpCallback);
    }

    public static void c(String str, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Game.Jinhua", "gameJinhuaCreate").params("uid", j30.q().C()).params("liveuid", j30.q().C()).params("token", j30.q().B()).params("stream", str).execute(httpCallback);
    }

    public static void d(String str, int i, int i2, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Game.Dial_Bet", "gameLuckPanBet").params("uid", j30.q().C()).params("token", j30.q().B()).params("gameid", str).params("coin", Integer.valueOf(i)).params("grade", Integer.valueOf(i2)).execute(httpCallback);
    }

    public static void e(String str, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Game.Dial", "gameLuckPanCreate").params("uid", j30.q().C()).params("liveuid", j30.q().C()).params("token", j30.q().B()).params("stream", str).execute(httpCallback);
    }

    public static void f(String str, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Game.settleGame", "gameSettle").params("uid", j30.q().C()).params("token", j30.q().B()).params("gameid", str).execute(httpCallback);
    }

    public static void g(HttpCallback httpCallback) {
        HttpClient.getInstance().get("Live.getCoin", "getCoin").params("uid", j30.q().C()).params("token", j30.q().B()).execute(httpCallback);
    }
}
