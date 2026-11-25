package com.yunbao.common.http;

import android.content.Context;
import android.os.Build;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.umeng.analytics.pro.bv;
import com.umeng.analytics.pro.cl;
import com.yunbao.common.activity.ErrorActivity;
import com.yunbao.common.bean.ConfigBean;
import com.yunbao.common.bean.VersionBean;
import defpackage.aq4;
import defpackage.bs3;
import defpackage.j30;
import defpackage.k30;
import defpackage.m93;
import defpackage.q41;
import defpackage.t54;
import defpackage.vl0;
import defpackage.zu0;
import java.util.Map;

/* loaded from: /tmp/classes2.dex */
public class CommonHttpUtil {
    public static final HttpCallback NO_CALLBACK = new HttpCallback() { // from class: com.yunbao.common.http.CommonHttpUtil.4
        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
        }
    };
    public static final String SALT = "3ae3c1c7c4bc8371ef52a96d0364449d";

    public static void bindLogin(String str, String str2, String str3, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Login.bindLogin", CommonHttpConsts.GET_OATH).params("token", j30.q().B()).params("uid", j30.q().C()).params("mobile", str).params(cl.g, str2).params("country_code", str3).execute(httpCallback);
    }

    public static void cancel(String str) {
        HttpClient.getInstance().cancel(str);
    }

    public static void chargePay(int i, String str, HttpCallback httpCallback) {
        HttpClient.getInstance().get("User.chargePay", "chargePay").params("uid", j30.q().C()).params("token", j30.q().B()).params("changeid", Integer.valueOf(i)).params("payid", str).execute(httpCallback);
    }

    public static void checkGoodsExist(String str, HttpCallback httpCallback) {
        cancel("CHECK_GOODS_EXIST");
        HttpClient.getInstance().get("Shop.getGoodExistence", "CHECK_GOODS_EXIST").params("goodsid", str).params("uid", j30.q().C()).params("token", j30.q().B()).execute(httpCallback);
    }

    public static void checkTokenInvalid() {
        HttpClient.getInstance().get("User.ifToken", CommonHttpConsts.CHECK_TOKEN_INVALID).params("uid", j30.q().C()).params("token", j30.q().B()).execute(NO_CALLBACK);
    }

    public static void checkUpgrade(HttpCallback httpCallback) {
        HttpClient.getInstance().get("Home.checkUpgrade", "checkUpgrade").params("token", j30.q().B()).params("uid", j30.q().C()).params("type", "android").execute(httpCallback);
    }

    public static void checkUpgrade(final k30 k30Var) {
        HttpClient.getInstance().get("Home.checkUpgrade", "checkUpgrade").params("token", j30.q().B()).params("uid", j30.q().C()).params("type", "android").execute(new HttpCallback() { // from class: com.yunbao.common.http.CommonHttpUtil.1
            @Override // com.yunbao.common.http.HttpCallback
            public void onSuccess(int i, String str, String[] strArr) {
                if (i != 0 || strArr == null || strArr.length <= 0) {
                    return;
                }
                try {
                    VersionBean versionBean = (VersionBean) JSON.toJavaObject(JSON.parseObject(strArr[0]), VersionBean.class);
                    j30.q().f0(versionBean);
                    k30 k30Var2 = k30.this;
                    if (k30Var2 != null) {
                        k30Var2.a(versionBean);
                    }
                } catch (Exception e) {
                    ErrorActivity.y1("GetConfig接口返回数据异常", "info[0]:" + strArr[0] + "\n\n\nException:" + e.getClass() + "---message--->" + e.getMessage());
                }
            }
        });
    }

    public static void deviceCheck(Context context, String str, String str2) {
        HttpClient.getInstance().get("User.deviceCheck", CommonHttpConsts.GET_OATH).params("token", str2).params("uid", str).params(bv.ac, "android").params("info", vl0.c(context)).params("root", vl0.d()).execute(NO_CALLBACK);
    }

    public static void getAddressInfoByTxLocaitonSdk(double d, double d2, int i, int i2, String str, HttpCallback httpCallback) {
    }

    public static void getAliOrder(String str, Map<String, String> map, HttpCallback httpCallback) {
        HttpClient.getInstance().get(str, CommonHttpConsts.GET_ALI_ORDER, map).params("uid", j30.q().C()).params("token", j30.q().B()).execute(httpCallback);
    }

    public static void getAuth(String str, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Auth.oauth2", CommonHttpConsts.GET_OATH).params("uid", j30.q().C()).params("token", j30.q().B()).params("device", str).params("device_model", Build.MODEL).params("source", "android").execute(httpCallback);
    }

    public static void getBalance(HttpCallback httpCallback) {
        HttpClient.getInstance().get("User.getBalance", CommonHttpConsts.GET_BALANCE).params("uid", j30.q().C()).params("token", j30.q().B()).params("type", 0).execute(httpCallback);
    }

    public static void getBalanceNew(HttpCallback httpCallback) {
        HttpClient.getInstance().get("User.getBalanceNew", CommonHttpConsts.GET_BALANCE_NEW).params("uid", j30.q().C()).params("token", j30.q().B()).params("type", 0).execute(httpCallback);
    }

    public static void getBeautyValue(HttpCallback httpCallback) {
        HttpClient.getInstance().get("User.getBeautyParams", CommonHttpConsts.GET_BEAUTY_VALUE).params("uid", j30.q().C()).params("token", j30.q().B()).execute(httpCallback);
    }

    public static void getBindCode(String str, String str2, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Login.getBindCode", CommonHttpConsts.GET_OATH).params("token", j30.q().B()).params("uid", j30.q().C()).params("mobile", str).params("country_code", str2).execute(httpCallback);
    }

    public static void getConfig(HttpCallback httpCallback) {
        HttpClient.getInstance().get("Home.getConfig", CommonHttpConsts.GET_CONFIG).params("token", j30.q().B()).params("uid", j30.q().C()).execute(httpCallback);
    }

    public static void getConfig(final k30 k30Var) {
        HttpClient.getInstance().get("Home.getConfig", CommonHttpConsts.GET_CONFIG).params("token", j30.q().B()).params("uid", j30.q().C()).execute(new HttpCallback() { // from class: com.yunbao.common.http.CommonHttpUtil.2
            @Override // com.yunbao.common.http.HttpCallback
            public void onSuccess(int i, String str, String[] strArr) {
                if (i != 0 || strArr == null || strArr.length <= 0) {
                    return;
                }
                try {
                    JSONObject parseObject = JSON.parseObject(strArr[0]);
                    ConfigBean configBean = (ConfigBean) JSON.toJavaObject(parseObject, ConfigBean.class);
                    j30.q().T(configBean);
                    j30.q().Y(parseObject.getString("level"));
                    j30.q().R(parseObject.getString("levelanchor"));
                    bs3.d().p("config", strArr[0]);
                    k30 k30Var2 = k30.this;
                    if (k30Var2 != null) {
                        k30Var2.a(configBean);
                    }
                } catch (Exception e) {
                    ErrorActivity.y1("GetConfig接口返回数据异常", "info[0]:" + strArr[0] + "\n\n\nException:" + e.getClass() + "---message--->" + e.getMessage());
                }
            }
        });
    }

    public static void getConfig1(k30 k30Var) {
    }

    public static void getCountrys(HttpCallback httpCallback) {
        HttpClient.getInstance().get("Login.getCountrys", CommonHttpConsts.GET_OATH).params("token", j30.q().B()).params("uid", j30.q().C()).execute(httpCallback);
    }

    public static void getErrorLog(int i, String str, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Live.errorLog", CommonHttpConsts.GET_OATH).params("token", j30.q().B()).params("uid", j30.q().C()).params(cl.g, Integer.valueOf(i)).params("message", str).execute(httpCallback);
    }

    public static void getFirstChargeRules(HttpCallback httpCallback) {
        HttpClient.getInstance().get("Charge.getFirstChargeRules", CommonHttpConsts.GET_FIRST_CHARGE_RULES).params("uid", j30.q().C()).params("token", j30.q().B()).execute(httpCallback);
    }

    public static void getGoodsInfo(String str, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Shop.getGoodsInfo", CommonHttpConsts.GET_GOODS_INFO).params("uid", j30.q().C()).params("token", j30.q().B()).params("goodsid", str).execute(httpCallback);
    }

    public static void getGuide(HttpCallback httpCallback) {
        HttpClient.getInstance().get("Guide.GetGuide", CommonHttpConsts.GET_CONFIG).params("token", j30.q().B()).params("uid", j30.q().C()).execute(httpCallback);
    }

    public static void getUploadInfo(HttpCallback httpCallback) {
        HttpClient.getInstance().get("Upload.getNewCosInfo", CommonHttpConsts.GET_UPLOAD_INFO).params("uid", j30.q().C()).params("token", j30.q().B()).execute(httpCallback);
    }

    public static void getUserInvite(HttpCallback httpCallback) {
        HttpClient.getInstance().get("User.invite", CommonHttpConsts.GET_VIP).params("uid", j30.q().C()).params("token", j30.q().B()).execute(httpCallback);
    }

    public static void getUserPromotion(HttpCallback httpCallback) {
        HttpClient.getInstance().get("User.promotion", CommonHttpConsts.GET_VIP).params("uid", j30.q().C()).params("token", j30.q().B()).execute(httpCallback);
    }

    public static void getVip(HttpCallback httpCallback) {
        HttpClient.getInstance().get("User.getVip", CommonHttpConsts.GET_VIP).params("uid", j30.q().C()).params("token", j30.q().B()).params("type", 0).execute(httpCallback);
    }

    public static void getWxOrder(String str, Map<String, String> map, HttpCallback httpCallback) {
        HttpClient.getInstance().get(str, CommonHttpConsts.GET_WX_ORDER, map).params("uid", j30.q().C()).params("token", j30.q().B()).execute(httpCallback);
    }

    public static void searchAddressInfoByTxLocaitonSdk(double d, double d2, String str, int i, HttpCallback httpCallback) {
    }

    public static void setAttention(String str, String str2, final String str3, final k30 k30Var) {
        if (j30.q().C() == null || j30.q().C().isEmpty() || str3 == null) {
            return;
        }
        if (str3.equals(j30.q().C())) {
            t54.b(aq4.a(m93.Y0));
        } else {
            HttpClient.getInstance().get("User.setAttent", str).params("uid", j30.q().C()).params("token", j30.q().B()).params("roomid", str2).params("touid", str3).execute(new HttpCallback() { // from class: com.yunbao.common.http.CommonHttpUtil.3
                @Override // com.yunbao.common.http.HttpCallback
                public void onSuccess(int i, String str4, String[] strArr) {
                    if (i != 0 || strArr == null || strArr.length <= 0) {
                        t54.b(str4);
                        return;
                    }
                    int intValue = JSON.parseObject(strArr[0]).getIntValue("isattent");
                    zu0.c().j(new q41(str3, intValue));
                    k30 k30Var2 = k30Var;
                    if (k30Var2 != null) {
                        k30Var2.a(Integer.valueOf(intValue));
                    }
                }
            });
        }
    }

    public static void setAttention(String str, String str2, k30 k30Var) {
        setAttention(str, null, str2, k30Var);
    }

    public static void setAttention(String str, k30 k30Var) {
        setAttention(CommonHttpConsts.SET_ATTENTION, str, k30Var);
    }

    public static void setBeautyValue(String str) {
        HttpClient.getInstance().get("User.setBeautyParams", CommonHttpConsts.SET_BEAUTY_VALUE).params("uid", j30.q().C()).params("token", j30.q().B()).params("params", str).execute(NO_CALLBACK);
    }

    public static void updateCity(String str) {
        HttpClient.getInstance().get("Home.updateCity", "updateCity").params("uid", j30.q().C()).params("token", j30.q().B()).params("city", str).execute(NO_CALLBACK);
    }

    public static void vipPay(int i, String str, HttpCallback httpCallback) {
        HttpClient.getInstance().get("User.vipPay", "vipPay").params("uid", j30.q().C()).params("token", j30.q().B()).params("vipid", Integer.valueOf(i)).params("payid", str).execute(httpCallback);
    }
}
