package defpackage;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.umeng.analytics.pro.bv;
import com.umeng.analytics.pro.cl;
import com.umeng.analytics.pro.g;
import com.umeng.commonsdk.deeplink.DeepLinkPresetEvent;
import com.yunbao.common.bean.UserBean;
import com.yunbao.common.http.CommonHttpUtil;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.common.http.HttpClient;

/* loaded from: /tmp/classes2.dex */
public abstract class db2 {

    /* loaded from: /tmp/classes2.dex */
    public class a extends HttpCallback {
        public final /* synthetic */ k30 a;
        public final /* synthetic */ Runnable b;

        public a(k30 k30Var, Runnable runnable) {
            this.a = k30Var;
            this.b = runnable;
        }

        @Override // com.yunbao.common.http.HttpCallback
        public boolean isUseLoginInvalid() {
            return this.b != null;
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onError() {
            k30 k30Var = this.a;
            if (k30Var != null) {
                k30Var.a(null);
            }
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onLoginInvalid() {
            Runnable runnable = this.b;
            if (runnable != null) {
                runnable.run();
            }
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length <= 0) {
                return;
            }
            JSONObject parseObject = JSON.parseObject(strArr[0]);
            UserBean userBean = (UserBean) JSON.toJavaObject(parseObject, UserBean.class);
            j30.q().e0(userBean);
            j30.q().b0(parseObject.getIntValue("live_window") == 1);
            bs3.d().p("userInfo", strArr[0]);
            k30 k30Var = this.a;
            if (k30Var != null) {
                k30Var.a(userBean);
            }
        }
    }

    public static void A(HttpCallback httpCallback) {
        HttpClient.getInstance().get("Dynamic.searchHotLabels", "getActiveRecomTopic").params("uid", j30.q().C()).params("token", j30.q().B()).execute(httpCallback);
    }

    public static void B(int i, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Dynamic.getRecommendDynamics", "getActiveRecommend").params("uid", j30.q().C()).params("token", j30.q().B()).params(bv.ax, Integer.valueOf(i)).execute(httpCallback);
    }

    public static void C(HttpCallback httpCallback) {
        HttpClient.getInstance().get("Dynamic.getReportlist", "getActiveReportList").params("uid", j30.q().C()).params("token", j30.q().B()).execute(httpCallback);
    }

    public static void D(HttpCallback httpCallback) {
        HttpClient.getInstance().get("Home.getSlide", "getSlide").params("uid", j30.q().C()).params("token", j30.q().B()).execute(httpCallback);
    }

    public static void E(k30 k30Var) {
        F(j30.q().C(), j30.q().B(), k30Var, null);
    }

    public static void F(String str, String str2, k30 k30Var, Runnable runnable) {
        HttpClient.getInstance().get("User.getBaseInfo", "getBaseInfo").params("uid", str).params("token", str2).execute(new a(k30Var, runnable));
    }

    public static void G(HttpCallback httpCallback) {
        HttpClient.getInstance().get("Login.getCancelCondition", "getCancelCondition").params("uid", j30.q().C()).params("token", j30.q().B()).execute(httpCallback);
    }

    public static void H(HttpCallback httpCallback) {
        HttpClient.getInstance().get("User.GetUserAccountList", "GetUserAccountList").params("uid", j30.q().C()).params("token", j30.q().B()).execute(httpCallback);
    }

    public static void I(int i, int i2, HttpCallback httpCallback) {
        K(i, i2, httpCallback);
    }

    public static void J(int i, String str, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Home.getClassLiveCursor", "getClassLive").params("liveclassid", Integer.valueOf(i)).params("uid", j30.q().C()).params("token", j30.q().B()).params("cursor", str).execute(httpCallback);
    }

    public static void K(int i, int i2, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Home.getClassLiveNew", "getClassLive").params("liveclassid", Integer.valueOf(i)).params("uid", j30.q().C()).params("token", j30.q().B()).params(bv.ax, Integer.valueOf(i2)).execute(httpCallback);
    }

    public static void L(String str, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Login.getCountrys", "getCountryCode").params("uid", j30.q().C()).params("token", j30.q().B()).params("field", str).execute(httpCallback);
    }

    public static void M(String str, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Dynamic.getDynamic", "Dynamic.getDynamic").params("dynamicid", str).params("uid", j30.q().C()).params("token", j30.q().B()).execute(httpCallback);
    }

    public static void N(String str, int i, HttpCallback httpCallback) {
        HttpClient.getInstance().get("User.getFansList", "getFansList").params("uid", j30.q().C()).params("token", j30.q().B()).params("touid", str).params(bv.ax, Integer.valueOf(i)).execute(httpCallback);
    }

    public static void O(String str, String str2, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Login.getForgetCode", "getFindPwdCode").params("uid", j30.q().C()).params("token", j30.q().B()).params("mobile", str).params("country_code", str2).params("sign", fa2.a("mobile=" + str + "&3ae3c1c7c4bc8371ef52a96d0364449d")).execute(httpCallback);
    }

    public static void P(int i, int i2, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Home.getFollow", "getFollow").params("uid", j30.q().C()).params("token", j30.q().B()).params("live_type", Integer.valueOf(i2)).params(bv.ax, Integer.valueOf(i)).execute(httpCallback);
    }

    public static void Q(String str, int i, HttpCallback httpCallback) {
        HttpClient.getInstance().get("User.getFollowsList", "getFollowList").params("uid", j30.q().C()).params("token", j30.q().B()).params("touid", str).params(bv.ax, Integer.valueOf(i)).execute(httpCallback);
    }

    public static void R(HttpCallback httpCallback) {
        HttpClient.getInstance().get("Home.getLogin", "getLoginInfo").params("uid", j30.q().C()).params("token", j30.q().B()).execute(httpCallback);
    }

    public static void S(HttpCallback httpCallback) {
        HttpClient.getInstance().get("User.GetMyLabel", "getMyImpress").params("uid", j30.q().C()).params("token", j30.q().B()).execute(httpCallback);
    }

    public static void T(HttpCallback httpCallback) {
        HttpClient.getInstance().get("Home.getNotice", "getNotice").params("uid", j30.q().C()).params("token", j30.q().B()).execute(httpCallback);
    }

    public static void U(HttpCallback httpCallback) {
        HttpClient.getInstance().get("User.getProfit", "getProfit").params("uid", j30.q().C()).params("token", j30.q().B()).execute(httpCallback);
    }

    public static void V(HttpCallback httpCallback) {
        HttpClient.getInstance().get("Agent.getCode", "getQrCode").params("uid", j30.q().C()).params("token", j30.q().B()).execute(httpCallback);
    }

    public static void W(HttpCallback httpCallback) {
        HttpClient.getInstance().get("Home.getRecommend", "getRecommend").params("uid", j30.q().C()).params("token", j30.q().B()).execute(httpCallback);
    }

    public static void X(int i, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Home.getRecommendLive", "getRecommendLive").params("uid", j30.q().C()).params("token", j30.q().B()).params(bv.ax, Integer.valueOf(i)).execute(httpCallback);
    }

    public static void Y(String str, String str2, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Login.getCode", "getRegisterCode").params("uid", j30.q().C()).params("token", j30.q().B()).params("mobile", str).params("country_code", str2).params("sign", fa2.a("mobile=" + str + "&3ae3c1c7c4bc8371ef52a96d0364449d")).execute(httpCallback);
    }

    public static void Z(HttpCallback httpCallback) {
        HttpClient.getInstance().get("User.getPerSetting", "getSettingList").params("uid", j30.q().C()).params("token", j30.q().B()).execute(httpCallback);
    }

    public static void a(String str, String str2, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Login.accountLogin", "setLiveWindow").params("account", str).params("user_pass", str2).params("uid", j30.q().C()).params("token", j30.q().B()).execute(httpCallback);
    }

    public static void a0(String str, String str2, String str3, int i, int i2, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Home.getShopClassList", "getShopClassList").params("uid", j30.q().C()).params("token", j30.q().B()).params("shopclassid", str).params("sell", str2).params(DeepLinkPresetEvent.UMEventParamPrice, str3).params("isnew", Integer.valueOf(i)).params(bv.ax, Integer.valueOf(i2)).execute(httpCallback);
    }

    public static void b(String str, String str2, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Login.accountReg", "setLiveWindow").params("account", str).params("user_pass", str2).params("uid", j30.q().C()).params("token", j30.q().B()).execute(httpCallback);
    }

    public static void b0(String str, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Home.getShopThreeClass", "getShopThreeClass").params("uid", j30.q().C()).params("token", j30.q().B()).params("shopclassid", str).execute(httpCallback);
    }

    public static void c(String str, HttpCallback httpCallback) {
        String C = j30.q().C();
        HttpClient.getInstance().get("Dynamic.addLike", "activeAddLike").params("uid", C).params("token", j30.q().B()).params("dynamicid", str).params("sign", fa2.a(rv3.a("dynamicid=", str, "&uid=", C, "&", CommonHttpUtil.SALT))).execute(httpCallback);
    }

    public static void c0(String str, int i, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Dynamic.getLabelDynamic", "getTopicActiveList").params("uid", j30.q().C()).params("token", j30.q().B()).params("labelid", str).params(bv.ax, Integer.valueOf(i)).execute(httpCallback);
    }

    public static void d(String str, String str2, String str3, String str4, String str5, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Dynamic.setComment", "activeComment").params("uid", j30.q().C()).params("token", j30.q().B()).params("dynamicid", str).params("touid", str2).params("commentid", str3).params("parentid", str4).params("content", str5).params("type", 0).params("voice", "").params("length", "").execute(httpCallback);
    }

    public static void d0(String str, HttpCallback httpCallback) {
        HttpClient.getInstance().get("User.getUserHome", "getUserHome").params("uid", j30.q().C()).params("token", j30.q().B()).params("touid", str).execute(httpCallback);
    }

    public static void e(String str, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Dynamic.del", "activeDelete").params("uid", j30.q().C()).params("token", j30.q().B()).params("dynamicid", str).execute(httpCallback);
    }

    public static void e0(int i, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Home.getVoiceLiveList", "getVoiceRoomList").params("uid", j30.q().C()).params("token", j30.q().B()).params(bv.ax, Integer.valueOf(i)).execute(httpCallback);
    }

    public static void f(int i, String str, String str2, String str3, String str4, String str5, String str6, int i2, String str7, String str8, HttpCallback httpCallback) {
        j30 q = j30.q();
        String C = q.C();
        HttpClient.getInstance().get("Dynamic.setDynamic", "activePublish").params("uid", C).params("token", q.B()).params(g.C, Double.valueOf(q.r())).params(g.D, Double.valueOf(q.v())).params("city", q.f()).params("type", Integer.valueOf(i)).params("title", str).params("thumb", str2).params("video_thumb", str3).params("href", str4).params("address", str5).params("voice", str6).params("length", Integer.valueOf(i2)).params("labelid", str7).params("goodsid", str8).params("sign", fa2.a(rv3.a("type=", String.valueOf(i), "&uid=", C, "&", CommonHttpUtil.SALT))).execute(httpCallback);
    }

    public static void f0(String str, String str2, String str3, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Login.userLogin", "setLoginInfo").params("uid", j30.q().C()).params("token", j30.q().B()).params("user_login", str).params("user_pass", str2).params("country_code", str3).execute(httpCallback);
    }

    public static void g(String str, String str2, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Dynamic.report", "activeReport").params("uid", j30.q().C()).params("token", j30.q().B()).params("dynamicid", str).params("content", str2).execute(httpCallback);
    }

    public static void g0(String str, String str2, String str3, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Login.mobileCodeLogin", "setLiveWindow").params("account", str).params("country_code", str3).params(cl.g, str2).params("uid", j30.q().C()).params("token", j30.q().B()).execute(httpCallback);
    }

    public static void h(String str, String str2, String str3, int i, HttpCallback httpCallback) {
        HttpClient.getInstance().get("User.SetUserAccount", "addCashAccount").params("uid", j30.q().C()).params("token", j30.q().B()).params("account", str).params("name", str2).params("account_bank", str3).params("type", Integer.valueOf(i)).execute(httpCallback);
    }

    public static void h0(String str, String str2, String str3, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Login.mobileLogin", "setLiveWindow").params("account", str).params("country_code", str3).params("user_pass", str2).params("uid", j30.q().C()).params("token", j30.q().B()).execute(httpCallback);
    }

    public static void i(String str) {
        HttpClient.getInstance().cancel(str);
    }

    public static void i0(String str, String str2, String str3, HttpCallback httpCallback) {
        HttpClient.getInstance().get("User.updatePass", "modifyPwd").params("uid", j30.q().C()).params("token", j30.q().B()).params("oldpass", str).params("pass", str2).params("pass2", str3).execute(httpCallback);
    }

    public static void j(HttpCallback httpCallback) {
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        j30 q = j30.q();
        String C = q.C();
        String B = q.B();
        HttpClient.getInstance().get("Login.cancelAccount", "cancelAccount").params("uid", C).params("token", B).params(DeepLinkPresetEvent.UMEventParamTime, valueOf).params("sign", fa2.a(rv3.a("time=", valueOf, "&token=", B, "&uid=", C, "&", CommonHttpUtil.SALT))).execute(httpCallback);
    }

    public static void j0(String str, String str2, HttpCallback httpCallback) {
        HttpClient.getInstance().get("User.updateTeenagerPassword", "modifyTeenagerPwd").params("uid", j30.q().C()).params("token", j30.q().B()).params("oldpassword", str).params("password", str2).execute(httpCallback);
    }

    public static void k(HttpCallback httpCallback) {
        HttpClient.getInstance().get("User.addTeenagerTime", "changeTeenagerTime").params("uid", j30.q().C()).params("token", j30.q().B()).execute(httpCallback);
    }

    public static void k0(String str, int i, HttpCallback httpCallback) {
        HttpClient.getInstance().get("User.setTeenagerPassword", "openTeenager").params("uid", j30.q().C()).params("token", j30.q().B()).params("password", str).params("type", Integer.valueOf(i)).execute(httpCallback);
    }

    public static void l(HttpCallback httpCallback) {
        HttpClient.getInstance().get("User.checkTeenager", "checkTeenager").params("uid", j30.q().C()).params("token", j30.q().B()).execute(httpCallback);
    }

    public static void l0(String str, int i, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Home.profitList", "profitList").params("uid", j30.q().C()).params("token", j30.q().B()).params("type", str).params(bv.ax, Integer.valueOf(i)).execute(httpCallback);
    }

    public static void m(String str, HttpCallback httpCallback) {
        HttpClient.getInstance().get("User.closeTeenager", "closeTeenager").params("uid", j30.q().C()).params("token", j30.q().B()).params("password", str).execute(httpCallback);
    }

    public static void m0(String str, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Home.attentRecommend", "recommendFollow").params("uid", j30.q().C()).params("token", j30.q().B()).params("touid", str).execute(httpCallback);
    }

    public static void n(String str, int i, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Home.consumeList", "consumeList").params("uid", j30.q().C()).params("token", j30.q().B()).params("type", str).params(bv.ax, Integer.valueOf(i)).execute(httpCallback);
    }

    public static void n0(String str, String str2, String str3, String str4, String str5, String str6, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Login.userReg", "register").params("uid", j30.q().C()).params("token", j30.q().B()).params("invitecode", str).params("user_login", str2).params("user_pass", str3).params("user_pass2", str4).params(cl.g, str5).params("country_code", str6).params("source", "android").execute(httpCallback);
    }

    public static void o(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Family.createFamily", "setAuth").params("uid", j30.q().C()).params("token", j30.q().B()).params("familyname", str).params("username", str2).params("cardno", str3).params("divide_family", str4).params("briefing", str5).params("apply_pos", str6).params("apply_side", str7).params("apply_map", str8).execute(httpCallback);
    }

    public static void o0(String str, int i, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Home.search", "search").params("uid", j30.q().C()).params("token", j30.q().B()).params("key", str).params(bv.ax, Integer.valueOf(i)).execute(httpCallback);
    }

    public static void p(String str, HttpCallback httpCallback) {
        HttpClient.getInstance().get("User.delUserAccount", "deleteCashAccount").params("uid", j30.q().C()).params("token", j30.q().B()).params("id", str).execute(httpCallback);
    }

    public static void p0(String str, int i, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Dynamic.searchLabels", "searchActiveTopic").params("uid", j30.q().C()).params("token", j30.q().B()).params("key", str).params(bv.ax, Integer.valueOf(i)).execute(httpCallback);
    }

    public static void q(String str, String str2, String str3, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Dynamic.delComments", "deleteComment").params("dynamicid", str).params("commentid", str2).params("commentuid", str3).params("uid", j30.q().C()).params("token", j30.q().B()).execute(httpCallback);
    }

    public static void q0(String str, String str2, String str3, int i, int i2, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Home.searchShop", "searchGoodsList").params("uid", j30.q().C()).params("token", j30.q().B()).params("key", str).params("sell", str2).params(DeepLinkPresetEvent.UMEventParamPrice, str3).params("isnew", Integer.valueOf(i)).params(bv.ax, Integer.valueOf(i2)).execute(httpCallback);
    }

    public static void r(String str, String str2, HttpCallback httpCallback) {
        HttpClient.getInstance().get("User.setCash", "doCash").params("uid", j30.q().C()).params("token", j30.q().B()).params("cashvote", str).params("accountid", str2).execute(httpCallback);
    }

    public static void r0(String str, HttpCallback httpCallback) {
        String C = j30.q().C();
        HttpClient.getInstance().get("Dynamic.addCommentLike", "setActiveCommentLike").params("uid", C).params("token", j30.q().B()).params("commentid", str).params("sign", fa2.a(rv3.a("commentid=", str, "&uid=", C, "&", CommonHttpUtil.SALT))).execute(httpCallback);
    }

    public static void s(String str, String str2, String str3, String str4, String str5, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Login.userFindPass", "findPwd").params("uid", j30.q().C()).params("token", j30.q().B()).params("user_login", str).params("user_pass", str2).params("user_pass2", str3).params(cl.g, str4).params("country_code", str5).execute(httpCallback);
    }

    public static void s0(String str, String str2, String str3, String str4, String str5, String str6, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Auth.setAuth", "setAuth").params("uid", j30.q().C()).params("token", j30.q().B()).params("real_name", str).params("mobile", str2).params("cer_no", str3).params("front_view", str4).params("back_view", str5).params("handset_view", str6).execute(httpCallback);
    }

    public static void t(int i, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Dynamic.getDynamicLabels", "getActiveAllTopic").params("uid", j30.q().C()).params("token", j30.q().B()).params(bv.ax, Integer.valueOf(i)).execute(httpCallback);
    }

    public static void t0(String str, HttpCallback httpCallback) {
        HttpClient.getInstance().get("User.setBlack", "setBlack").params("uid", j30.q().C()).params("token", j30.q().B()).params("touid", str).execute(httpCallback);
    }

    public static void u(String str, int i, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Dynamic.getReplys", "getActiveCommentReply").params("commentid", str).params("uid", j30.q().C()).params("token", j30.q().B()).params(bv.ax, Integer.valueOf(i)).execute(httpCallback);
    }

    public static void u0(String str, String str2, HttpCallback httpCallback) {
        HttpClient.getInstance().get("User.setDistribut", "setDistribut").params("uid", j30.q().C()).params("token", j30.q().B()).params(cl.g, str2).params("device_id", str).execute(httpCallback);
    }

    public static void v(String str, int i, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Dynamic.getComments", "getActiveComments").params("uid", j30.q().C()).params("token", j30.q().B()).params("dynamicid", str).params(bv.ax, Integer.valueOf(i)).execute(httpCallback);
    }

    public static void v0(HttpCallback httpCallback) {
        HttpClient.getInstance().get("User.setLiveWindow", "setLiveWindow").params("uid", j30.q().C()).params("token", j30.q().B()).execute(httpCallback);
    }

    public static void w(int i, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Dynamic.getAttentionDynamic", "getActiveFollow").params("uid", j30.q().C()).params("token", j30.q().B()).params(bv.ax, Integer.valueOf(i)).execute(httpCallback);
    }

    public static void w0(String str, HttpCallback httpCallback) {
        HttpClient.getInstance().get("User.setPass", "setLiveWindow").params("pass", str).params("uid", j30.q().C()).params("token", j30.q().B()).execute(httpCallback);
    }

    public static void x(String str, int i, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Dynamic.getHomeDynamic", "getHomeActive").params("uid", j30.q().C()).params("token", j30.q().B()).params("touid", str).params(bv.ax, Integer.valueOf(i)).execute(httpCallback);
    }

    public static void x0(String str, HttpCallback httpCallback) {
        HttpClient.getInstance().get("User.updateAvatar", "updateAvatar").params("uid", j30.q().C()).params("token", j30.q().B()).params("avatar", str).execute(httpCallback);
    }

    public static void y(HttpCallback httpCallback) {
        HttpClient.getInstance().get("Dynamic.getHotDynamicLabels", "getActiveHotTopic").params("uid", j30.q().C()).params("token", j30.q().B()).execute(httpCallback);
    }

    public static void y0(String str, HttpCallback httpCallback) {
        HttpClient.getInstance().get("User.updateFields", "updateFields").params("uid", j30.q().C()).params("token", j30.q().B()).params("fields", str).execute(httpCallback);
    }

    public static void z(int i, HttpCallback httpCallback) {
        j30 q = j30.q();
        HttpClient.getInstance().get("Dynamic.getNewDynamic", "getActiveNewest").params("uid", q.C()).params("token", q.B()).params(g.D, Double.valueOf(q.v())).params(g.C, Double.valueOf(q.r())).params(bv.ax, Integer.valueOf(i)).execute(httpCallback);
    }

    public static void z0(String str, String str2, HttpCallback httpCallback) {
        HttpClient.getInstance().get("User.updatePass", "setLiveWindow").params("oldpass", str).params("pass", str2).params("uid", j30.q().C()).params("token", j30.q().B()).execute(httpCallback);
    }
}
