package defpackage;

import android.text.TextUtils;
import com.umeng.analytics.pro.bv;
import com.yunbao.common.http.CommonHttpUtil;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.common.http.HttpClient;

/* loaded from: /tmp/classes2.dex */
public abstract class zh4 {
    public static void a(String str) {
        HttpClient.getInstance().cancel(str);
    }

    public static void b(String str, String str2, String str3, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Video.delComments", "deleteComment").params("videoid", str).params("commentid", str2).params("commentuid", str3).params("uid", j30.q().C()).params("token", j30.q().B()).execute(httpCallback);
    }

    public static void c() {
        HttpClient.getInstance().get("Video.endWatchVideo", "endWatchVideo").params("uid", j30.q().C()).params("token", j30.q().B()).execute(CommonHttpUtil.NO_CALLBACK);
    }

    public static void d(int i, HttpCallback httpCallback) {
        HttpClient.getInstance().get("User.getFollowsList", "getAtFriendList").params("uid", j30.q().C()).params("token", j30.q().B()).params("touid", j30.q().C()).params(bv.ax, Integer.valueOf(i)).execute(httpCallback);
    }

    public static void e(String str, int i, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Video.getReplys", "getCommentReply").params("commentid", str).params("uid", j30.q().C()).params("token", j30.q().B()).params(bv.ax, Integer.valueOf(i)).execute(httpCallback);
    }

    public static void f(String str, int i, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Video.getHomeVideo", "getHomeVideo").params("uid", j30.q().C()).params("token", j30.q().B()).params("touid", str).params(bv.ax, Integer.valueOf(i)).execute(httpCallback);
    }

    public static void g(int i, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Video.GetVideoList", "getHomeVideoList").params("uid", j30.q().C()).params("token", j30.q().B()).params(bv.ax, Integer.valueOf(i)).execute(httpCallback);
    }

    public static void h(int i, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Video.getLikeVideos", "getLikeVideo").params("uid", j30.q().C()).params("token", j30.q().B()).params(bv.ax, Integer.valueOf(i)).execute(httpCallback);
    }

    public static void i(String str, int i, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Video.GetComments", "getVideoCommentList").params("uid", j30.q().C()).params("token", j30.q().B()).params("videoid", str).params(bv.ax, Integer.valueOf(i)).execute(httpCallback);
    }

    public static void j(String str, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Video.getVideo", "getVideoInfo").params("uid", j30.q().C()).params("token", j30.q().B()).params("videoid", str).execute(httpCallback);
    }

    public static void k(HttpCallback httpCallback) {
        HttpClient.getInstance().get("Video.getVideoOne", "getHomeVideoList").params("uid", j30.q().C()).params("token", j30.q().B()).execute(httpCallback);
    }

    public static void l(HttpCallback httpCallback) {
        HttpClient.getInstance().get("Video.getReportContentlist", "getVideoReportList").params("uid", j30.q().C()).params("token", j30.q().B()).execute(httpCallback);
    }

    public static void m(String str, String str2, String str3, String str4, String str5, String str6, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Video.setComment", "setComment").params("uid", j30.q().C()).params("token", j30.q().B()).params("touid", str).params("videoid", str2).params("commentid", str4).params("parentid", str5).params("content", str3).params("at_info", str6).execute(httpCallback);
    }

    public static void n(String str, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Video.addCommentLike", "setCommentLike").params("commentid", str).params("uid", j30.q().C()).params("token", j30.q().B()).execute(httpCallback);
    }

    public static void o(String str, String str2, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Video.AddLike", str).params("uid", j30.q().C()).params("token", j30.q().B()).params("videoid", str2).execute(httpCallback);
    }

    public static void p() {
        if (j30.q().N()) {
            HttpClient.getInstance().get("Video.startWatchVideo", "startWatchVideo").params("uid", j30.q().C()).params("token", j30.q().B()).execute(CommonHttpUtil.NO_CALLBACK);
        }
    }

    public static void q(String str, String str2, String str3, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Video.report", "videoReport").params("uid", j30.q().C()).params("token", j30.q().B()).params("videoid", str).params("type", str2).params("content", str3).execute(httpCallback);
    }

    public static void r(String str, String str2) {
        if (j30.q().N()) {
            String C = j30.q().C();
            if (TextUtils.isEmpty(C) || C.equals(str)) {
                return;
            }
            a("videoWatchEnd");
            HttpClient.getInstance().get("Video.setConversion", "videoWatchEnd").params("uid", C).params("token", j30.q().B()).params("videoid", str2).params("random_str", fa2.a(C + "-" + str2 + "-#2hgfk85cm23mk58vncsark")).execute(CommonHttpUtil.NO_CALLBACK);
        }
    }

    public static void s(String str, String str2, HttpCallback httpCallback) {
        String C = j30.q().C();
        HttpClient.getInstance().get("Video.addView", "videoWatchStart").params("uid", C).params("token", j30.q().B()).params("videoid", str2).params("random_str", fa2.a(C + "-" + str2 + "-#2hgfk85cm23mk58vncsark")).execute(httpCallback);
    }
}
