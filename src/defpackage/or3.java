package defpackage;

import com.alibaba.fastjson.JSONObject;
import com.yunbao.common.bean.GoodsBean;
import com.yunbao.common.bean.UserBean;
import com.yunbao.live.bean.GlobalGiftBean;
import com.yunbao.live.bean.LiveBuyGuardMsgBean;
import com.yunbao.live.bean.LiveChatBean;
import com.yunbao.live.bean.LiveDanMuBean;
import com.yunbao.live.bean.LiveEnterRoomBean;
import com.yunbao.live.bean.LiveGiftPrizePoolWinBean;
import com.yunbao.live.bean.LiveLuckGiftWinBean;
import com.yunbao.live.bean.LiveReceiveGiftBean;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public interface or3 {
    void A0();

    void B0(UserBean userBean, String str, int i);

    void C0(String str);

    void D(UserBean userBean);

    void D0(boolean z);

    void E(String str, String str2, String str3);

    void E0(LiveBuyGuardMsgBean liveBuyGuardMsgBean);

    void F(String str);

    void F0();

    void G(String str, int i);

    void G0(long j, long j2);

    void H(String str, String str2);

    void I(String str, int i, int i2);

    void I0(String str, String str2, String str3);

    void J0(LiveReceiveGiftBean liveReceiveGiftBean, LiveChatBean liveChatBean);

    void K(String str);

    void K0(String str);

    void L(LiveChatBean liveChatBean);

    void L0(String str);

    void M0(String str);

    void N(int i, int i2, String str);

    void P(String str);

    void Q(UserBean userBean);

    void R(String str, int i);

    void T();

    void V(String str);

    void W(String str, int i);

    void X();

    void Y();

    void a0();

    void c(LiveDanMuBean liveDanMuBean);

    void d(UserBean userBean, String str);

    void d0(String str, int i);

    void e();

    void e0();

    void f(LiveChatBean liveChatBean);

    void f0(GlobalGiftBean globalGiftBean);

    void g(LiveGiftPrizePoolWinBean liveGiftPrizePoolWinBean);

    void g0(int i);

    void h0();

    void j0();

    void l(String str);

    void l0();

    void m(String str, String str2);

    void m0();

    void n(String str, int i);

    void n0();

    void o(String str);

    void o0();

    void p(GoodsBean goodsBean);

    void p0();

    void q0();

    void r(JSONObject jSONObject);

    void s(String str, String str2, String str3, int i);

    void s0(String str, String str2, String str3);

    void u(LiveLuckGiftWinBean liveLuckGiftWinBean);

    void v();

    void v0(JSONObject jSONObject);

    void w(LiveEnterRoomBean liveEnterRoomBean);

    void y0(String str);

    void z();

    void z0(String str, int i, long j, List list);
}
