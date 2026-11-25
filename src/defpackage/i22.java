package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.viewpager2.widget.ViewPager2;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.umeng.commonsdk.deeplink.DeepLinkPresetEvent;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.banner.Banner2;
import com.yunbao.common.bean.UserBean;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.common.utils.a;
import com.yunbao.live.livegame.star.bean.StarResultBean;
import com.yunbao.live.livegame.star.bean.StarWinMsgBean;
import defpackage.wt3;
import defpackage.xt3;
import java.util.List;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: /tmp/classes2.dex */
public class i22 extends l0 implements View.OnClickListener {
    public View[] A0;
    public TextView[] B0;
    public int C0;
    public boolean D0;
    public int E0;
    public int F0;
    public View G0;
    public TextView H0;
    public int I0 = 1;
    public Banner2 J0;
    public yt3 K0;
    public String L0;
    public String M0;
    public String N0;
    public String O0;
    public String P0;
    public f Q0;
    public Animation R0;
    public View[] z0;

    /* loaded from: /tmp/classes2.dex */
    public class a extends HttpCallback {
        public a() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length <= 0) {
                return;
            }
            JSONObject parseObject = JSON.parseObject(strArr[0]);
            if (i22.this.H0 != null) {
                i22.this.H0.setText(parseObject.getString("coin"));
            }
            JSONArray jSONArray = parseObject.getJSONArray("star_list");
            for (int i2 = 0; i2 < jSONArray.size(); i2++) {
                String string = jSONArray.getJSONObject(i2).getString(DeepLinkPresetEvent.UMEventParamPrice);
                if (i22.this.B0[i2] != null) {
                    i22.this.B0[i2].setText(string + i22.this.N0);
                }
            }
            if (i22.this.J0 != null) {
                List parseArray = JSON.parseArray(parseObject.getString("win_list"), StarWinMsgBean.class);
                i22 i22Var = i22.this;
                i22Var.K0 = new yt3(i22Var.x0, parseArray);
                i22.this.J0.r(i22.this.K0);
                i22.this.J0.p(true);
                i22.this.J0.D();
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ int a;

        public b(int i) {
            this.a = i;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            ViewGroup.LayoutParams layoutParams = i22.this.z0[this.a].getLayoutParams();
            int i = (int) (i22.this.E0 + ((i22.this.F0 - i22.this.E0) * floatValue));
            layoutParams.width = i;
            layoutParams.height = i;
            i22.this.z0[this.a].requestLayout();
            ViewGroup.LayoutParams layoutParams2 = i22.this.z0[i22.this.C0].getLayoutParams();
            int i2 = (int) (i22.this.F0 + ((i22.this.E0 - i22.this.F0) * floatValue));
            layoutParams2.width = i2;
            layoutParams2.height = i2;
            i22.this.z0[i22.this.C0].requestLayout();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends AnimatorListenerAdapter {
        public final /* synthetic */ int a;

        public c(int i) {
            this.a = i;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            i22.this.C0 = this.a;
            i22.this.D0 = false;
            int i = this.a;
            if (i == 0) {
                i22.this.I0 = 1;
            } else if (i == 1) {
                i22.this.I0 = 2;
            } else if (i == 2) {
                i22.this.I0 = 3;
            }
            i22.this.z0[i22.this.C0].startAnimation(i22.this.R0);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d implements View.OnClickListener {
        public final /* synthetic */ PopupWindow a;

        public d(PopupWindow popupWindow) {
            this.a = popupWindow;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            if (id == b73.V0) {
                this.a.dismiss();
                i22.this.T2();
            } else if (id == b73.n1) {
                this.a.dismiss();
                i22.this.U2();
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e extends HttpCallback {
        public final /* synthetic */ int a;

        /* loaded from: /tmp/classes2.dex */
        public class a implements wt3.a {
            public a() {
            }

            @Override // wt3.a
            public void a() {
                e eVar = e.this;
                i22.this.V2(eVar.a);
            }
        }

        /* loaded from: /tmp/classes2.dex */
        public class b implements xt3.a {
            public b() {
            }

            @Override // xt3.a
            public void a() {
                e eVar = e.this;
                i22.this.V2(eVar.a);
            }
        }

        /* loaded from: /tmp/classes2.dex */
        public class c implements a.m {
            public c() {
            }

            @Override // com.yunbao.common.utils.a.m
            public void b(Dialog dialog, String str) {
                i22.this.S1();
                pi3.n(i22.this.x0);
            }
        }

        public e(int i) {
            this.a = i;
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length <= 0) {
                if (i == 1004) {
                    com.yunbao.common.utils.a.k(i22.this.x0, str, true, new c());
                    return;
                }
                return;
            }
            JSONObject parseObject = JSON.parseObject(strArr[0]);
            if (i22.this.H0 != null) {
                i22.this.H0.setText(parseObject.getString("coin"));
            }
            List<StarResultBean> parseArray = JSON.parseArray(parseObject.getString("gift_list"), StarResultBean.class);
            if (parseArray == null || parseArray.size() <= 0) {
                xt3 xt3Var = new xt3();
                xt3Var.r2(new b());
                xt3Var.d2(((AbsActivity) i22.this.x0).getSupportFragmentManager(), "StarResultEmptyDialog");
                return;
            }
            wt3 wt3Var = new wt3();
            wt3Var.s2(parseArray);
            wt3Var.r2(new a());
            wt3Var.d2(((AbsActivity) i22.this.x0).getSupportFragmentManager(), "LiveGameStarResultDialog");
            UserBean D = j30.q().D();
            if (D != null) {
                String userNiceName = D.getUserNiceName();
                if (!TextUtils.isEmpty(userNiceName) && userNiceName.length() > 1) {
                    String substring = userNiceName.substring(1);
                    if (!TextUtils.isEmpty(substring)) {
                        StringBuilder sb = new StringBuilder();
                        for (int i2 = 0; i2 < substring.length(); i2++) {
                            sb.append("*");
                        }
                        String sb2 = sb.toString();
                        if (!TextUtils.isEmpty(sb2)) {
                            userNiceName = userNiceName.replace(substring, sb2);
                        }
                    }
                }
                JSONArray jSONArray = new JSONArray();
                for (StarResultBean starResultBean : parseArray) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("gifticon", starResultBean.getGiftIcon());
                    jSONObject.put("title", String.format(i22.this.O0, userNiceName, starResultBean.getGiftName(), starResultBean.getCount()));
                    jSONObject.put("title_en", String.format(i22.this.P0, userNiceName, starResultBean.getGiftNameEn(), starResultBean.getCount()));
                    jSONArray.add(jSONObject);
                }
                if (i22.this.Q0 != null) {
                    i22.this.Q0.a(jSONArray.toJSONString());
                }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface f {
        void a(String str);

        void b();

        void c();

        void d();
    }

    private void S2() {
        new qt3().d2(((AbsActivity) this.x0).getSupportFragmentManager(), "LiveGameStarRankDialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T2() {
        ym4 ym4Var = new ym4();
        Bundle bundle = new Bundle();
        bundle.putString(IjkMediaPlayer.OnNativeInvokeListener.ARG_URL, wg1.w);
        ym4Var.F1(bundle);
        ym4Var.d2(((AbsActivity) this.x0).getSupportFragmentManager(), "WebViewDialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U2() {
        new tt3().d2(((AbsActivity) this.x0).getSupportFragmentManager(), "LiveGameStarRecordDialog");
    }

    private void X2() {
        View inflate = LayoutInflater.from(this.x0).inflate(x73.y, (ViewGroup) null);
        inflate.measure(0, 0);
        int measuredWidth = inflate.getMeasuredWidth();
        PopupWindow popupWindow = new PopupWindow(inflate, measuredWidth, inflate.getMeasuredHeight(), true);
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        popupWindow.setOutsideTouchable(true);
        int[] iArr = new int[2];
        this.G0.getLocationInWindow(iArr);
        popupWindow.showAtLocation(this.G0, 51, (iArr[0] + (this.G0.getWidth() / 2)) - (measuredWidth / 2), iArr[1] + this.G0.getHeight() + zn0.a(5));
        d dVar = new d(popupWindow);
        inflate.findViewById(b73.V0).setOnClickListener(dVar);
        inflate.findViewById(b73.n1).setOnClickListener(dVar);
    }

    @Override // defpackage.l0
    public void C0() {
        f fVar = this.Q0;
        if (fVar != null) {
            fVar.c();
        }
        this.Q0 = null;
        Banner2 banner2 = this.J0;
        if (banner2 != null) {
            banner2.g();
            this.J0 = null;
        }
        e32.f("gameGetXqtbInfo");
        e32.f("gameXqtbPlay");
        super.C0();
    }

    public final void Q2(int i) {
        if (this.D0 || this.C0 == i) {
            return;
        }
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(150L);
        duration.addUpdateListener(new b(i));
        duration.addListener(new c(i));
        this.z0[this.C0].clearAnimation();
        this.D0 = true;
        duration.start();
        this.A0[i].setVisibility(0);
        this.A0[this.C0].setVisibility(4);
    }

    public void R2(List list) {
        Banner2 banner2 = this.J0;
        if (banner2 != null) {
            banner2.E();
            yt3 yt3Var = this.K0;
            if (yt3Var != null) {
                yt3Var.O(list);
            }
            Banner2 banner22 = this.J0;
            banner22.t(banner22.getStartPosition(), false);
            this.J0.p(true);
            this.J0.D();
        }
    }

    public final void V2(int i) {
        e32.y(this.L0, this.M0, this.I0, i, new e(i));
    }

    public void W2(f fVar) {
        this.Q0 = fVar;
    }

    @Override // defpackage.l0
    public boolean f2() {
        return true;
    }

    @Override // defpackage.l0
    public int l2() {
        return s93.d;
    }

    @Override // defpackage.l0
    public int m2() {
        return x73.x;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == b73.Z4) {
            Q2(0);
            return;
        }
        if (id == b73.a5) {
            Q2(1);
            return;
        }
        if (id == b73.b5) {
            Q2(2);
            return;
        }
        if (id == b73.C0) {
            X2();
            return;
        }
        if (id == b73.M0) {
            S2();
            return;
        }
        if (id == b73.M) {
            S1();
            f fVar = this.Q0;
            if (fVar != null) {
                fVar.b();
                return;
            }
            return;
        }
        if (id == b73.f0) {
            V2(1);
            return;
        }
        if (id == b73.g0) {
            V2(10);
            return;
        }
        if (id == b73.i0) {
            V2(50);
            return;
        }
        if (id == b73.G0) {
            S1();
            f fVar2 = this.Q0;
            if (fVar2 != null) {
                fVar2.d();
            }
        }
    }

    @Override // defpackage.l0
    public void p2(Window window) {
        window.setWindowAnimations(s93.b);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        attributes.gravity = 80;
        window.setAttributes(attributes);
    }

    public void r0(Bundle bundle) {
        super.r0(bundle);
        Bundle z = z();
        if (z != null) {
            this.L0 = z.getString("liveUid");
            this.M0 = z.getString("stream");
        }
        this.N0 = j30.q().g();
        this.O0 = "恭喜%1$s获得%2$s%3$s";
        this.P0 = "Congratulations to %1$s for getting %2$s%3$s";
        this.E0 = zn0.a(100);
        this.F0 = zn0.a(130);
        View[] viewArr = new View[3];
        this.z0 = viewArr;
        viewArr[0] = k2(b73.Z4);
        this.z0[1] = k2(b73.a5);
        this.z0[2] = k2(b73.b5);
        for (View view : this.z0) {
            view.setOnClickListener(this);
        }
        View[] viewArr2 = new View[3];
        this.A0 = viewArr2;
        viewArr2[0] = k2(b73.f3);
        this.A0[1] = k2(b73.g3);
        this.A0[2] = k2(b73.h3);
        TextView[] textViewArr = new TextView[3];
        this.B0 = textViewArr;
        textViewArr[0] = (TextView) k2(b73.t1);
        this.B0[1] = (TextView) k2(b73.u1);
        this.B0[2] = (TextView) k2(b73.v1);
        View k2 = k2(b73.C0);
        this.G0 = k2;
        k2.setOnClickListener(this);
        this.H0 = (TextView) k2(b73.s1);
        k2(b73.M).setOnClickListener(this);
        k2(b73.f0).setOnClickListener(this);
        k2(b73.g0).setOnClickListener(this);
        k2(b73.i0).setOnClickListener(this);
        k2(b73.G0).setOnClickListener(this);
        k2(b73.M0).setOnClickListener(this);
        Banner2 banner2 = (Banner2) k2(b73.i);
        this.J0 = banner2;
        banner2.B(false);
        this.J0.w(3000L);
        this.J0.z(1200);
        this.J0.x(1);
        ViewPager2 viewPager2 = this.J0.getViewPager2();
        if (viewPager2 != null) {
            viewPager2.setOrientation(1);
            viewPager2.setOffscreenPageLimit(IjkMediaCodecInfo.RANK_MAX);
        }
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, -zn0.a(5), zn0.a(5));
        this.R0 = translateAnimation;
        translateAnimation.setDuration(600L);
        this.R0.setRepeatCount(-1);
        this.R0.setRepeatMode(2);
        this.z0[0].startAnimation(this.R0);
        e32.u(new a());
    }
}
