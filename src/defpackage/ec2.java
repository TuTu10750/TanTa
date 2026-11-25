package defpackage;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.umeng.analytics.pro.bv;
import com.umeng.analytics.pro.cl;
import com.umeng.commonsdk.deeplink.DeepLinkPresetEvent;
import com.yunbao.common.http.CommonHttpUtil;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.common.http.HttpClient;
import com.yunbao.common.http.IHttpRequest;

/* loaded from: /tmp/classes2.dex */
public abstract class ec2 {

    /* loaded from: /tmp/classes2.dex */
    public class a extends HttpCallback {
        public final /* synthetic */ String a;

        public a(String str) {
            this.a = str;
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i == 0 && strArr.length > 0) {
                zu0.c().j(new ao3(this.a, JSON.parseObject(strArr[0]).getIntValue(cl.i)));
            }
            t54.b(str);
        }
    }

    public static void A(HttpCallback httpCallback) {
        HttpClient.getInstance().get("Shop.getBusinessCategory", "getBusinessCategory").params("uid", j30.q().C()).params("token", j30.q().B()).execute(httpCallback);
    }

    public static void A0(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, HttpCallback httpCallback) {
        IHttpRequest params = HttpClient.getInstance().get(TextUtils.isEmpty(str13) ? "Seller.setGoods" : "Seller.upgoods", "setGoods").params("uid", j30.q().C()).params("token", j30.q().B()).params("one_classid", str).params("two_classid", str2).params("three_classid", str3).params("name", str4).params("content", str5).params("specs", str6).params("postage", str7).params("share_income", str8);
        if (TextUtils.isEmpty(str9)) {
            str9 = "";
        }
        IHttpRequest params2 = params.params("video_url", str9);
        if (TextUtils.isEmpty(str10)) {
            str10 = "";
        }
        IHttpRequest params3 = params2.params("video_thumb", str10);
        if (TextUtils.isEmpty(str11)) {
            str11 = "";
        }
        IHttpRequest params4 = params3.params("thumbs", str11);
        if (TextUtils.isEmpty(str12)) {
            str12 = "";
        }
        params4.params("pictures", str12).params("goodsid", str13).execute(httpCallback);
    }

    public static void B(int i, HttpCallback httpCallback) {
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        j30 q = j30.q();
        String C = q.C();
        String B = q.B();
        HttpClient.getInstance().get("Paidprogram.getPaidProgramList", "getBuyPayContentList").params("uid", C).params("token", B).params(DeepLinkPresetEvent.UMEventParamTime, valueOf).params("sign", fa2.a(rv3.a("time=", valueOf, "&token=", B, "&uid=", C, "&", CommonHttpUtil.SALT))).params(bv.ax, Integer.valueOf(i)).execute(httpCallback);
    }

    public static void B0(String str, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Shop.setCollect", "setGoodsCollect").params("uid", j30.q().C()).params("token", j30.q().B()).params("goodsid", str).execute(httpCallback);
    }

    public static void C(int i, HttpCallback httpCallback) {
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        j30 q = j30.q();
        String C = q.C();
        String B = q.B();
        HttpClient.getInstance().get("Buyer.getRefundList", "getBuyerAccountInfo").params("uid", C).params("token", B).params(DeepLinkPresetEvent.UMEventParamTime, valueOf).params("sign", fa2.a(rv3.a("time=", valueOf, "&token=", B, "&uid=", C, "&", CommonHttpUtil.SALT))).params(bv.ax, Integer.valueOf(i)).execute(httpCallback);
    }

    public static void C0(String str, String str2, String str3, String str4, String str5, String str6, String str7, HttpCallback httpCallback) {
        HttpClient.getInstance().get(TextUtils.isEmpty(str) ? "Seller.setOutsideGoods" : "Seller.upOutsideGoods", "setOutsideGoods").params("uid", j30.q().C()).params("token", j30.q().B()).params("goodsid", str).params("href", str2).params("name", str3).params("original_price", str4).params("present_price", str5).params("goods_desc", str6).params("thumb", str7).execute(httpCallback);
    }

    public static void D(HttpCallback httpCallback) {
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        j30 q = j30.q();
        String C = q.C();
        String B = q.B();
        HttpClient.getInstance().get("Buyer.addressList", "getBuyerAddress").params("uid", C).params("token", B).params(DeepLinkPresetEvent.UMEventParamTime, valueOf).params("sign", fa2.a(rv3.a("time=", valueOf, "&token=", B, "&uid=", C, "&", CommonHttpUtil.SALT))).execute(httpCallback);
    }

    public static void D0(String str) {
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        j30 q = j30.q();
        String C = q.C();
        String B = q.B();
        HttpClient.getInstance().get("Seller.setPlatformGoods", "setPlatGoods").params("uid", C).params("token", B).params(DeepLinkPresetEvent.UMEventParamTime, valueOf).params("sign", fa2.a(rv3.a("time=", valueOf, "&token=", B, "&uid=", C, "&", CommonHttpUtil.SALT))).params("goodsid", str).execute(new a(str));
    }

    public static void E(int i, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Buyer.getGoodsVisitRecord", "getBuyerGoodsRecord").params("uid", j30.q().C()).params("token", j30.q().B()).params(bv.ax, Integer.valueOf(i)).execute(httpCallback);
    }

    public static void F(HttpCallback httpCallback) {
        HttpClient.getInstance().get("Buyer.getHome", "getBuyerHome").params("uid", j30.q().C()).params("token", j30.q().B()).execute(httpCallback);
    }

    public static void G(String str, HttpCallback httpCallback) {
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        j30 q = j30.q();
        String C = q.C();
        String B = q.B();
        HttpClient.getInstance().get("Buyer.getGoodsOrderInfo", "getBuyerOrderDetail").params("uid", C).params("token", B).params(DeepLinkPresetEvent.UMEventParamTime, valueOf).params("sign", fa2.a(rv3.a("time=", valueOf, "&token=", B, "&uid=", C, "&", CommonHttpUtil.SALT))).params("orderid", str).execute(httpCallback);
    }

    public static void H(String str, int i, HttpCallback httpCallback) {
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        j30 q = j30.q();
        String C = q.C();
        String B = q.B();
        HttpClient.getInstance().get("Buyer.getGoodsOrderList", "getBuyerOrderList").params("uid", C).params("token", B).params(DeepLinkPresetEvent.UMEventParamTime, valueOf).params("sign", fa2.a(rv3.a("time=", valueOf, "&token=", B, "&uid=", C, "&", CommonHttpUtil.SALT))).params("type", str).params(bv.ax, Integer.valueOf(i)).execute(httpCallback);
    }

    public static void I(HttpCallback httpCallback) {
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        j30 q = j30.q();
        String C = q.C();
        String B = q.B();
        HttpClient.getInstance().get("Buyer.getBalance", "getBuyerPayList").params("uid", C).params("token", B).params(DeepLinkPresetEvent.UMEventParamTime, valueOf).params("sign", fa2.a(rv3.a("time=", valueOf, "&token=", B, "&uid=", C, "&", CommonHttpUtil.SALT))).execute(httpCallback);
    }

    public static void J(String str, HttpCallback httpCallback) {
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        j30 q = j30.q();
        String C = q.C();
        String B = q.B();
        HttpClient.getInstance().get("Buyer.getGoodsOrderRefundInfo", "getBuyerRefundDetail").params("uid", C).params("token", B).params(DeepLinkPresetEvent.UMEventParamTime, valueOf).params("sign", fa2.a(rv3.a("orderid=", str, "&time=", valueOf, "&token=", B, "&uid=", C, "&", CommonHttpUtil.SALT))).params("orderid", str).execute(httpCallback);
    }

    public static void K(HttpCallback httpCallback) {
        HttpClient.getInstance().get("Seller.getGoodsClass", "getGoodsClass").params("uid", j30.q().C()).params("token", j30.q().B()).execute(httpCallback);
    }

    public static void L(int i, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Shop.getGoodsCollect", "getGoodsCollect").params("uid", j30.q().C()).params("token", j30.q().B()).params(bv.ax, Integer.valueOf(i)).execute(httpCallback);
    }

    public static void M(String str, String str2, int i, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Shop.getGoodsCommentList", "getGoodsCommentList").params("uid", j30.q().C()).params("token", j30.q().B()).params("goodsid", str).params("type", str2).params(bv.ax, Integer.valueOf(i)).execute(httpCallback);
    }

    public static void N(String str, HttpCallback httpCallback) {
        CommonHttpUtil.getGoodsInfo(str, httpCallback);
    }

    public static void O(HttpCallback httpCallback) {
        HttpClient.getInstance().get("Seller.getGoodsNums", "getGoodsNum").params("uid", j30.q().C()).params("token", j30.q().B()).execute(httpCallback);
    }

    public static void P(HttpCallback httpCallback) {
        HttpClient.getInstance().get("Shop.getOneGoodsClass", "getManageClass").params("uid", j30.q().C()).params("token", j30.q().B()).execute(httpCallback);
    }

    public static void Q(String str, int i, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Seller.getGoodsList", "getManageGoodsList").params("uid", j30.q().C()).params("token", j30.q().B()).params("type", str).params(bv.ax, Integer.valueOf(i)).execute(httpCallback);
    }

    public static void R(int i, HttpCallback httpCallback) {
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        j30 q = j30.q();
        String C = q.C();
        String B = q.B();
        HttpClient.getInstance().get("Seller.getOnsalePlatformGoods", "getManagePlatGoods").params("uid", C).params("token", B).params(DeepLinkPresetEvent.UMEventParamTime, valueOf).params("sign", fa2.a(rv3.a("time=", valueOf, "&token=", B, "&uid=", C, "&", CommonHttpUtil.SALT))).params(bv.ax, Integer.valueOf(i)).execute(httpCallback);
    }

    public static void S(int i, HttpCallback httpCallback) {
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        j30 q = j30.q();
        String C = q.C();
        String B = q.B();
        HttpClient.getInstance().get("Paidprogram.getMyPaidProgram", "getMyPayContentList").params("uid", C).params("token", B).params(DeepLinkPresetEvent.UMEventParamTime, valueOf).params("sign", fa2.a(rv3.a("time=", valueOf, "&token=", B, "&uid=", C, "&", CommonHttpUtil.SALT))).params(bv.ax, Integer.valueOf(i)).execute(httpCallback);
    }

    public static void T(HttpCallback httpCallback) {
        HttpClient.getInstance().get("Buyer.getPlatformReasonList", "getOfficialRefundReason").params("uid", j30.q().C()).params("token", j30.q().B()).execute(httpCallback);
    }

    public static void U(int i, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Message.getShopOrderList", "getOrderMsgList").params("uid", j30.q().C()).params("token", j30.q().B()).params(bv.ax, Integer.valueOf(i)).execute(httpCallback);
    }

    public static void V(HttpCallback httpCallback) {
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        j30 q = j30.q();
        String C = q.C();
        String B = q.B();
        HttpClient.getInstance().get("Paidprogram.getApplyStatus", "getPayApplyStatus").params("uid", C).params("token", B).params(DeepLinkPresetEvent.UMEventParamTime, valueOf).params("sign", fa2.a(rv3.a("time=", valueOf, "&token=", B, "&uid=", C, "&", CommonHttpUtil.SALT))).execute(httpCallback);
    }

    public static void W(HttpCallback httpCallback) {
        HttpClient.getInstance().get("Paidprogram.getPaidprogramClassList", "getPayClassList").params("uid", j30.q().C()).params("token", j30.q().B()).execute(httpCallback);
    }

    public static void X(String str, HttpCallback httpCallback) {
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        j30 q = j30.q();
        String C = q.C();
        String B = q.B();
        HttpClient.getInstance().get("Paidprogram.getPaidProgramInfo", "getPayContentDetail").params("uid", C).params("token", B).params(DeepLinkPresetEvent.UMEventParamTime, valueOf).params("sign", fa2.a(rv3.a("object_id=", str, "&time=", valueOf, "&token=", B, "&uid=", C, "&", CommonHttpUtil.SALT))).params("object_id", str).execute(httpCallback);
    }

    public static void Y(HttpCallback httpCallback) {
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        j30 q = j30.q();
        String C = q.C();
        String B = q.B();
        HttpClient.getInstance().get("Paidprogram.getBalance", "getPayContentPayList").params("uid", C).params("token", B).params(DeepLinkPresetEvent.UMEventParamTime, valueOf).params("sign", fa2.a(rv3.a("time=", valueOf, "&token=", B, "&uid=", C, "&", CommonHttpUtil.SALT))).execute(httpCallback);
    }

    public static void Z(String str, int i, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Shop.getOnsalePlatformGoods", "getPlatShop").params("uid", j30.q().C()).params("token", j30.q().B()).params("touid", str).params(bv.ax, Integer.valueOf(i)).execute(httpCallback);
    }

    public static void a(String str, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Shop.applyBusinessCategory", "applyBusinessCategory").params("uid", j30.q().C()).params("token", j30.q().B()).params("classid", str).execute(httpCallback);
    }

    public static void a0(HttpCallback httpCallback) {
        HttpClient.getInstance().get("Seller.getReceiverAddress", "getRefundAddress").params("uid", j30.q().C()).params("token", j30.q().B()).execute(httpCallback);
    }

    public static void b(HttpCallback httpCallback) {
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        j30 q = j30.q();
        String C = q.C();
        String B = q.B();
        HttpClient.getInstance().get("Paidprogram.apply", "applyPayOpen").params("uid", C).params("token", B).params(DeepLinkPresetEvent.UMEventParamTime, valueOf).params("sign", fa2.a(rv3.a("time=", valueOf, "&token=", B, "&uid=", C, "&", CommonHttpUtil.SALT))).execute(httpCallback);
    }

    public static void b0(HttpCallback httpCallback) {
        HttpClient.getInstance().get("Buyer.getRefundReason", "getRefundReasonList").params("uid", j30.q().C()).params("token", j30.q().B()).execute(httpCallback);
    }

    public static void c(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Shop.shopApply", "applyShop").params("uid", j30.q().C()).params("token", j30.q().B()).params("username", str).params("cardno", str2).params("classid", str3).params("contact", str4).params("phone", str5).params("province", str6).params("city", str7).params("area", str8).params("address", str9).params("service_phone", str10).params("receiver", str11).params("receiver_phone", str12).params("receiver_province", str13).params("receiver_city", str14).params("receiver_area", str15).params("receiver_address", str16).params("certificate", str17).params("other", str18).execute(httpCallback);
    }

    public static void c0(HttpCallback httpCallback) {
        HttpClient.getInstance().get("Seller.getRefundRefuseReason", "getRejectRefundReason").params("uid", j30.q().C()).params("token", j30.q().B()).execute(httpCallback);
    }

    public static void d(String str, HttpCallback httpCallback) {
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        j30 q = j30.q();
        String C = q.C();
        String B = q.B();
        HttpClient.getInstance().get("Paidprogram.balancePay", "buyPayContent").params("uid", C).params("token", B).params(DeepLinkPresetEvent.UMEventParamTime, valueOf).params("sign", fa2.a(rv3.a("object_id=", str, "&time=", valueOf, "&token=", B, "&uid=", C, "&", CommonHttpUtil.SALT))).params("object_id", str).execute(httpCallback);
    }

    public static void d0(int i, HttpCallback httpCallback) {
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        j30 q = j30.q();
        String C = q.C();
        String B = q.B();
        HttpClient.getInstance().get("Seller.getSettlementList", "getSellerAccountInfo").params("uid", C).params("token", B).params(DeepLinkPresetEvent.UMEventParamTime, valueOf).params("sign", fa2.a(rv3.a("time=", valueOf, "&token=", B, "&uid=", C, "&", CommonHttpUtil.SALT))).params(bv.ax, Integer.valueOf(i)).execute(httpCallback);
    }

    public static void e(String str, String str2, String str3, String str4, String str5, String str6, String str7, HttpCallback httpCallback) {
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        j30 q = j30.q();
        String C = q.C();
        String B = q.B();
        HttpClient.getInstance().get("Buyer.addAddress", "buyerAddAddress").params("uid", C).params("token", B).params(DeepLinkPresetEvent.UMEventParamTime, valueOf).params("sign", fa2.a(rv3.a("is_default=", str7, "&time=", valueOf, "&token=", B, "&uid=", C, "&", CommonHttpUtil.SALT))).params("username", str).params("phone", str2).params("province", str3).params("city", str4).params("area", str5).params("address", str6).params("is_default", str7).execute(httpCallback);
    }

    public static void e0(HttpCallback httpCallback) {
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        j30 q = j30.q();
        String C = q.C();
        String B = q.B();
        HttpClient.getInstance().get("Seller.getHome", "getSellerHome").params("uid", C).params("token", B).params(DeepLinkPresetEvent.UMEventParamTime, valueOf).params("sign", fa2.a(rv3.a("time=", valueOf, "&token=", B, "&uid=", C, "&", CommonHttpUtil.SALT))).execute(httpCallback);
    }

    public static void f(String str) {
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        j30 q = j30.q();
        String C = q.C();
        String B = q.B();
        HttpClient.getInstance().get("Buyer.addGoodsVisitRecord", "buyerAddBrowseRecord").params("uid", C).params("token", B).params(DeepLinkPresetEvent.UMEventParamTime, valueOf).params("sign", fa2.a(rv3.a("goodsid=", str, "&time=", valueOf, "&token=", B, "&uid=", C, "&", CommonHttpUtil.SALT))).params("goodsid", str).execute(CommonHttpUtil.NO_CALLBACK);
    }

    public static void f0(String str, HttpCallback httpCallback) {
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        j30 q = j30.q();
        String C = q.C();
        String B = q.B();
        HttpClient.getInstance().get("Seller.getGoodsOrderInfo", "getSellerOrderDetail").params("uid", C).params("token", B).params(DeepLinkPresetEvent.UMEventParamTime, valueOf).params("sign", fa2.a(rv3.a("time=", valueOf, "&token=", B, "&uid=", C, "&", CommonHttpUtil.SALT))).params("orderid", str).execute(httpCallback);
    }

    public static void g(String str, String str2, String str3, String str4, String str5, HttpCallback httpCallback) {
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        j30 q = j30.q();
        String C = q.C();
        String B = q.B();
        IHttpRequest params = HttpClient.getInstance().get("Buyer.appendEvaluateGoodsOrder", "buyerAppendComment").params("uid", C).params("token", B).params(DeepLinkPresetEvent.UMEventParamTime, valueOf).params("sign", fa2.a(rv3.a("orderid=", str, "&time=", valueOf, "&token=", B, "&uid=", C, "&", CommonHttpUtil.SALT))).params("orderid", str).params("content", str2);
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        IHttpRequest params2 = params.params("thumbs", str3);
        if (TextUtils.isEmpty(str4)) {
            str4 = "";
        }
        params2.params("video_url", str4).params("video_thumb", TextUtils.isEmpty(str5) ? "" : str5).execute(httpCallback);
    }

    public static void g0(String str, int i, HttpCallback httpCallback) {
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        j30 q = j30.q();
        String C = q.C();
        String B = q.B();
        HttpClient.getInstance().get("Seller.getGoodsOrderList", "getSellerOrderList").params("uid", C).params("token", B).params(DeepLinkPresetEvent.UMEventParamTime, valueOf).params("sign", fa2.a(rv3.a("time=", valueOf, "&token=", B, "&uid=", C, "&", CommonHttpUtil.SALT))).params("type", str).params(bv.ax, Integer.valueOf(i)).execute(httpCallback);
    }

    public static void h(String str, String str2, String str3, String str4, HttpCallback httpCallback) {
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        j30 q = j30.q();
        String C = q.C();
        String B = q.B();
        HttpClient.getInstance().get("Buyer.applyPlatformInterpose", "buyerApplyOfficialRefund").params("uid", C).params("token", B).params(DeepLinkPresetEvent.UMEventParamTime, valueOf).params("sign", fa2.a(rv3.a("orderid=", str, "&reasonid=", str2, "&time=", valueOf, "&token=", B, "&uid=", C, "&", CommonHttpUtil.SALT))).params("orderid", str).params("reasonid", str2).params("content", str3).params("thumb", str4).execute(httpCallback);
    }

    public static void h0(String str, HttpCallback httpCallback) {
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        j30 q = j30.q();
        String C = q.C();
        String B = q.B();
        HttpClient.getInstance().get("Seller.getGoodsOrderRefundInfo", "getSellerRefundDetail").params("uid", C).params("token", B).params(DeepLinkPresetEvent.UMEventParamTime, valueOf).params("sign", fa2.a(rv3.a("orderid=", str, "&time=", valueOf, "&token=", B, "&uid=", C, "&", CommonHttpUtil.SALT))).params("orderid", str).execute(httpCallback);
    }

    public static void i(String str, String str2, String str3, int i, HttpCallback httpCallback) {
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        j30 q = j30.q();
        String C = q.C();
        String B = q.B();
        HttpClient.getInstance().get("Buyer.applyRefundGoodsOrder", "buyerApplyRefund").params("uid", C).params("token", B).params(DeepLinkPresetEvent.UMEventParamTime, valueOf).params("sign", fa2.a(rv3.a("orderid=", str, "&time=", valueOf, "&token=", B, "&uid=", C, "&", CommonHttpUtil.SALT))).params("orderid", str).params("content", str2).params("reasonid", str3).params("type", Integer.valueOf(i)).execute(httpCallback);
    }

    public static void i0(HttpCallback httpCallback) {
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        j30 q = j30.q();
        String C = q.C();
        String B = q.B();
        HttpClient.getInstance().get("Shop.getShopApplyInfo", "getShopApplyInfo").params("uid", C).params("token", B).params(DeepLinkPresetEvent.UMEventParamTime, valueOf).params("sign", fa2.a(rv3.a("time=", valueOf, "&token=", B, "&uid=", C, "&", CommonHttpUtil.SALT))).execute(httpCallback);
    }

    public static void j(String str, HttpCallback httpCallback) {
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        j30 q = j30.q();
        String C = q.C();
        String B = q.B();
        HttpClient.getInstance().get("Buyer.reapplyRefundGoodsOrder", "buyerApplyRefundAgain").params("uid", C).params("token", B).params(DeepLinkPresetEvent.UMEventParamTime, valueOf).params("sign", fa2.a(rv3.a("orderid=", str, "&time=", valueOf, "&token=", B, "&uid=", C, "&", CommonHttpUtil.SALT))).params("orderid", str).execute(httpCallback);
    }

    public static void j0(String str, int i, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Shop.getShop", "getShopHome").params("uid", j30.q().C()).params("token", j30.q().B()).params("touid", str).params(bv.ax, Integer.valueOf(i)).execute(httpCallback);
    }

    public static void k(String str, HttpCallback httpCallback) {
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        j30 q = j30.q();
        String C = q.C();
        String B = q.B();
        HttpClient.getInstance().get("Buyer.cancelGoodsOrder", "buyerCancelOrder").params("uid", C).params("token", B).params(DeepLinkPresetEvent.UMEventParamTime, valueOf).params("sign", fa2.a(rv3.a("time=", valueOf, "&token=", B, "&uid=", C, "&", CommonHttpUtil.SALT))).params("orderid", str).execute(httpCallback);
    }

    public static void k0(String str, int i, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Paidprogram.getHomePaidprogram", "getToPayContent").params("uid", j30.q().C()).params("token", j30.q().B()).params("touid", str).params(bv.ax, Integer.valueOf(i)).execute(httpCallback);
    }

    public static void l(String str, HttpCallback httpCallback) {
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        j30 q = j30.q();
        String C = q.C();
        String B = q.B();
        HttpClient.getInstance().get("Buyer.cancelRefundGoodsOrder", "buyerCancelRefund").params("uid", C).params("token", B).params(DeepLinkPresetEvent.UMEventParamTime, valueOf).params("sign", fa2.a(rv3.a("orderid=", str, "&time=", valueOf, "&token=", B, "&uid=", C, "&", CommonHttpUtil.SALT))).params("orderid", str).execute(httpCallback);
    }

    public static void l0(HttpCallback httpCallback) {
        HttpClient.getInstance().get("User.getAuthInfo", "getUserAuthInfo").params("uid", j30.q().C()).params("token", j30.q().B()).execute(httpCallback);
    }

    public static void m(String str, HttpCallback httpCallback) {
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        j30 q = j30.q();
        String C = q.C();
        String B = q.B();
        HttpClient.getInstance().get("Buyer.receiveGoodsOrder", "buyerConfirmReceive").params("uid", C).params("token", B).params(DeepLinkPresetEvent.UMEventParamTime, valueOf).params("sign", fa2.a(rv3.a("time=", valueOf, "&token=", B, "&uid=", C, "&", CommonHttpUtil.SALT))).params("orderid", str).execute(httpCallback);
    }

    public static void m0(HttpCallback httpCallback) {
        HttpClient.getInstance().get("seller.getExpressList", "getWuliuList").params("uid", j30.q().C()).params("token", j30.q().B()).execute(httpCallback);
    }

    public static void n(String str, String str2, String str3, int i, String str4, String str5, String str6, HttpCallback httpCallback) {
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        j30 q = j30.q();
        String C = q.C();
        HttpClient.getInstance().get("Buyer.createGoodsOrder", "buyerCreateOrder").params("uid", C).params("token", q.B()).params(DeepLinkPresetEvent.UMEventParamTime, valueOf).params("sign", fa2.a(rv3.a("addressid=", str, "&goodsid=", str2, "&spec_id=", str3, "&time=", valueOf, "&uid=", C, "&", CommonHttpUtil.SALT))).params("addressid", str).params("goodsid", str2).params("spec_id", str3).params("nums", Integer.valueOf(i)).params("message", str4).params("liveuid", TextUtils.isEmpty(str5) ? "0" : str5).params("shareuid", str6).execute(httpCallback);
    }

    public static void n0(String str, String str2, HttpCallback httpCallback) {
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        j30 q = j30.q();
        String C = q.C();
        String B = q.B();
        HttpClient.getInstance().get("User.setShopCash", "goodsCash").params("uid", C).params("token", B).params(DeepLinkPresetEvent.UMEventParamTime, valueOf).params("sign", fa2.a(rv3.a("accountid=", str, "&time=", valueOf, "&token=", B, "&uid=", C, "&", CommonHttpUtil.SALT))).params("accountid", str).params("money", str2).execute(httpCallback);
    }

    public static void o(String str, HttpCallback httpCallback) {
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        j30 q = j30.q();
        String C = q.C();
        String B = q.B();
        HttpClient.getInstance().get("Buyer.delAddress", "buyerDeleteAddress").params("uid", C).params("token", B).params(DeepLinkPresetEvent.UMEventParamTime, valueOf).params("sign", fa2.a(rv3.a("addressid=", str, "&time=", valueOf, "&token=", B, "&uid=", C, "&", CommonHttpUtil.SALT))).params("addressid", str).execute(httpCallback);
    }

    public static void o0(String str, HttpCallback httpCallback) {
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        j30 q = j30.q();
        String C = q.C();
        String B = q.B();
        HttpClient.getInstance().get("Seller.delGoods", "goodsDelete").params("uid", C).params("token", B).params(DeepLinkPresetEvent.UMEventParamTime, valueOf).params("sign", fa2.a(rv3.a("time=", valueOf, "&token=", B, "&uid=", C, "&", CommonHttpUtil.SALT))).params("goodsid", str).execute(httpCallback);
    }

    public static void p(String str, HttpCallback httpCallback) {
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        j30 q = j30.q();
        String C = q.C();
        String B = q.B();
        HttpClient.getInstance().get("Buyer.delGoodsVisitRecord", "buyerDeleteBrowseRecord").params("uid", C).params("token", B).params(DeepLinkPresetEvent.UMEventParamTime, valueOf).params("sign", fa2.a(rv3.a("time=", valueOf, "&token=", B, "&uid=", C, "&", CommonHttpUtil.SALT))).params("recordids", str).execute(httpCallback);
    }

    public static void p0(String str, String str2, HttpCallback httpCallback) {
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        j30 q = j30.q();
        String C = q.C();
        String B = q.B();
        HttpClient.getInstance().get("Seller.upGoodsSpecs", "goodsModifySpec").params("uid", C).params("token", B).params(DeepLinkPresetEvent.UMEventParamTime, valueOf).params("sign", fa2.a(rv3.a("time=", valueOf, "&token=", B, "&uid=", C, "&", CommonHttpUtil.SALT))).params("goodsid", str).params("specs", str2).execute(httpCallback);
    }

    public static void q(String str, HttpCallback httpCallback) {
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        j30 q = j30.q();
        String C = q.C();
        String B = q.B();
        HttpClient.getInstance().get("Buyer.delGoodsOrder", "buyerDeleteOrder").params("uid", C).params("token", B).params(DeepLinkPresetEvent.UMEventParamTime, valueOf).params("sign", fa2.a(rv3.a("time=", valueOf, "&token=", B, "&uid=", C, "&", CommonHttpUtil.SALT))).params("orderid", str).execute(httpCallback);
    }

    public static void q0(String str, int i, HttpCallback httpCallback) {
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        j30 q = j30.q();
        String C = q.C();
        String B = q.B();
        HttpClient.getInstance().get("Seller.upStatus", "goodsUpStatus").params("uid", C).params("token", B).params(DeepLinkPresetEvent.UMEventParamTime, valueOf).params("sign", fa2.a(rv3.a("goodsid=", str, "&time=", valueOf, "&token=", B, "&uid=", C, "&", CommonHttpUtil.SALT))).params("goodsid", str).params(cl.i, Integer.valueOf(i)).execute(httpCallback);
    }

    public static void r(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, HttpCallback httpCallback) {
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        j30 q = j30.q();
        String C = q.C();
        String B = q.B();
        HttpClient.getInstance().get("Buyer.editAddress", "buyerModifyAddress").params("uid", C).params("token", B).params(DeepLinkPresetEvent.UMEventParamTime, valueOf).params("sign", fa2.a(rv3.a("addressid=", str8, "&time=", valueOf, "&token=", B, "&uid=", C, "&", CommonHttpUtil.SALT))).params("username", str).params("phone", str2).params("province", str3).params("city", str4).params("area", str5).params("address", str6).params("is_default", str7).params("addressid", str8).execute(httpCallback);
    }

    public static void r0(String str, String str2, String str3, String str4, String str5, String str6, HttpCallback httpCallback) {
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        j30 q = j30.q();
        String C = q.C();
        String B = q.B();
        HttpClient.getInstance().get("Seller.upReceiverAddress", "modifyRefundAddress").params("uid", C).params("token", B).params(DeepLinkPresetEvent.UMEventParamTime, valueOf).params("sign", fa2.a(rv3.a("time=", valueOf, "&token=", B, "&uid=", C, "&", CommonHttpUtil.SALT))).params("receiver", str).params("receiver_phone", str2).params("receiver_province", str3).params("receiver_city", str4).params("receiver_area", str5).params("receiver_address", str6).execute(httpCallback);
    }

    public static void s(String str, String str2, HttpCallback httpCallback) {
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        j30 q = j30.q();
        String C = q.C();
        String B = q.B();
        HttpClient.getInstance().get("Buyer.goodsOrderPay", "buyerPayOrder").params("uid", C).params("token", B).params(DeepLinkPresetEvent.UMEventParamTime, valueOf).params("sign", fa2.a(rv3.a("orderid=", str, "&time=", valueOf, "&token=", B, "&type=", str2, "&uid=", C, "&", CommonHttpUtil.SALT))).params("orderid", str).params("type", str2).execute(httpCallback);
    }

    public static void s0(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, HttpCallback httpCallback) {
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        j30 q = j30.q();
        String C = q.C();
        String B = q.B();
        HttpClient.getInstance().get("Paidprogram.addPaidProgram", "publishPayContent").params("uid", C).params("token", B).params(DeepLinkPresetEvent.UMEventParamTime, valueOf).params("sign", fa2.a(rv3.a("time=", valueOf, "&token=", B, "&uid=", C, "&", CommonHttpUtil.SALT))).params("title", str2).params("content", str3).params("personal_desc", str4).params("money", str5).params("thumb", str6).params("videos", str7).params("type", Integer.valueOf(i)).execute(httpCallback);
    }

    public static void t(String str, String str2, String str3, String str4, String str5, String str6, int i, int i2, int i3, HttpCallback httpCallback) {
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        j30 q = j30.q();
        String C = q.C();
        String B = q.B();
        HttpClient.getInstance().get("Buyer.evaluateGoodsOrder", "buyerSetComment").params("uid", C).params("token", B).params(DeepLinkPresetEvent.UMEventParamTime, valueOf).params("sign", fa2.a(rv3.a("is_anonym=", str6, "&orderid=", str, "&time=", valueOf, "&token=", B, "&uid=", C, "&", CommonHttpUtil.SALT))).params("orderid", str).params("content", str2).params("is_anonym", str6).params("thumbs", TextUtils.isEmpty(str3) ? "" : str3).params("video_url", TextUtils.isEmpty(str4) ? "" : str4).params("video_thumb", TextUtils.isEmpty(str5) ? "" : str5).params("quality_points", Integer.valueOf(i)).params("express_points", Integer.valueOf(i2)).params("service_points", Integer.valueOf(i3)).execute(httpCallback);
    }

    public static void t0(String str, int i, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Shop.searchShopGoods", "searchGoodsList").params("uid", j30.q().C()).params("token", j30.q().B()).params("keywords", str).params(bv.ax, Integer.valueOf(i)).execute(httpCallback);
    }

    public static void u(String str) {
        HttpClient.getInstance().cancel(str);
    }

    public static void u0(String str, int i, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Paidprogram.searchPaidProgram", "searchPayList").params("uid", j30.q().C()).params("token", j30.q().B()).params("keywords", str).params(bv.ax, Integer.valueOf(i)).execute(httpCallback);
    }

    public static void v(HttpCallback httpCallback) {
        HttpClient.getInstance().get("Shop.getApplyBusinessCategory", "checkApplyBusinessCategory").params("uid", j30.q().C()).params("token", j30.q().B()).execute(httpCallback);
    }

    public static void v0(String str, int i, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Shop.searchOnsalePlatformGoods", "searchPlatGoodsList").params("uid", j30.q().C()).params("token", j30.q().B()).params("keywords", str).params(bv.ax, Integer.valueOf(i)).execute(httpCallback);
    }

    public static void w(String str, int i, HttpCallback httpCallback) {
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        j30 q = j30.q();
        String C = q.C();
        String B = q.B();
        HttpClient.getInstance().get("Paidprogram.setComment", "commentPayContent").params("uid", C).params("token", B).params(DeepLinkPresetEvent.UMEventParamTime, valueOf).params("sign", fa2.a(rv3.a("object_id=", str, "&time=", valueOf, "&token=", B, "&uid=", C, "&", CommonHttpUtil.SALT))).params("object_id", str).params("grade", Integer.valueOf(i)).execute(httpCallback);
    }

    public static void w0(String str, HttpCallback httpCallback) {
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        j30 q = j30.q();
        String C = q.C();
        String B = q.B();
        HttpClient.getInstance().get("Seller.delGoodsOrder", "sellerDeleteOrder").params("uid", C).params("token", B).params(DeepLinkPresetEvent.UMEventParamTime, valueOf).params("sign", fa2.a(rv3.a("time=", valueOf, "&token=", B, "&uid=", C, "&", CommonHttpUtil.SALT))).params("orderid", str).execute(httpCallback);
    }

    public static void x(String str, HttpCallback httpCallback) {
        HttpClient.getInstance().get("Shop.delGoodsCollect", "deleteGoodsCollect").params("uid", j30.q().C()).params("token", j30.q().B()).params("ids", str).execute(httpCallback);
    }

    public static void x0(String str, String str2, String str3, HttpCallback httpCallback) {
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        j30 q = j30.q();
        String C = q.C();
        String B = q.B();
        HttpClient.getInstance().get("Seller.setExpressInfo", "sellerSendOrder").params("uid", C).params("token", B).params(DeepLinkPresetEvent.UMEventParamTime, valueOf).params("sign", fa2.a(rv3.a("expressid=", str2, "&orderid=", str, "&time=", valueOf, "&token=", B, "&uid=", C, "&", CommonHttpUtil.SALT))).params("orderid", str).params("expressid", str2).params("express_number", str3).execute(httpCallback);
    }

    public static void y(int i, HttpCallback httpCallback) {
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        j30 q = j30.q();
        String C = q.C();
        String B = q.B();
        HttpClient.getInstance().get("Seller.getPlatformGoodsLists", "getAddPlatGoods").params("uid", C).params("token", B).params(DeepLinkPresetEvent.UMEventParamTime, valueOf).params("sign", fa2.a(rv3.a("time=", valueOf, "&token=", B, "&uid=", C, "&", CommonHttpUtil.SALT))).params(bv.ax, Integer.valueOf(i)).execute(httpCallback);
    }

    public static void y0(String str, int i, String str2, String str3, HttpCallback httpCallback) {
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        j30 q = j30.q();
        String C = q.C();
        String B = q.B();
        HttpClient.getInstance().get("seller.setGoodsOrderRefund", "sellerSetRefund").params("uid", C).params("token", B).params(DeepLinkPresetEvent.UMEventParamTime, valueOf).params("sign", fa2.a(rv3.a("orderid=", str, "&time=", valueOf, "&token=", B, "&uid=", C, "&", CommonHttpUtil.SALT))).params("orderid", str).params("type", Integer.valueOf(i)).params("reasonid", str2).params("refuse_desc", str3).execute(httpCallback);
    }

    public static void z(HttpCallback httpCallback) {
        HttpClient.getInstance().get("Shop.getBond", "getManageClass").params("uid", j30.q().C()).params("token", j30.q().B()).execute(httpCallback);
    }

    public static void z0(HttpCallback httpCallback) {
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        j30 q = j30.q();
        String C = q.C();
        String B = q.B();
        HttpClient.getInstance().get("Shop.deductBond", "setBond").params("uid", C).params("token", B).params(DeepLinkPresetEvent.UMEventParamTime, valueOf).params("sign", fa2.a(rv3.a("time=", valueOf, "&token=", B, "&uid=", C, "&", CommonHttpUtil.SALT))).execute(httpCallback);
    }
}
