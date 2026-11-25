package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.viewpager2.widget.ViewPager2;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.banner.Banner2;
import com.yunbao.common.bean.UserBean;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.common.utils.a;
import com.yunbao.live.livegame.luckpan.bean.LuckpanResultBean;
import com.yunbao.live.livegame.luckpan.bean.LuckpanWinMsgBean;
import defpackage.ba2;
import defpackage.ca2;
import java.util.List;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: /tmp/classes2.dex */
public class h22 extends l0 implements View.OnClickListener {
    public View A0;
    public TextView B0;
    public TextView[] C0;
    public Banner2 D0;
    public da2 E0;
    public String F0;
    public String G0;
    public String H0;
    public String I0;
    public String J0;
    public boolean K0;
    public ImageView L0;
    public h M0;
    public boolean N0;
    public boolean P0;
    public Drawable R0;
    public Drawable S0;
    public ValueAnimator T0;
    public ImageView[] z0;
    public int O0 = -1;
    public int Q0 = -1;

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
            if (h22.this.B0 != null) {
                h22.this.B0.setText(parseObject.getString("coin"));
            }
            JSONArray jSONArray = parseObject.getJSONArray("gift_list");
            for (int i2 = 0; i2 < jSONArray.size(); i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                if (i2 < 8 && h22.this.z0[i2] != null) {
                    kn1.f(h22.this.x0, jSONObject.getString("gifticon"), h22.this.z0[i2]);
                }
            }
            JSONObject jSONObject2 = parseObject.getJSONObject("price_list");
            if (h22.this.C0[0] != null) {
                h22.this.C0[0].setText(jSONObject2.getString("xydzp_one_price") + h22.this.H0);
            }
            if (h22.this.C0[1] != null) {
                h22.this.C0[1].setText(jSONObject2.getString("xydzp_ten_price") + h22.this.H0);
            }
            if (h22.this.C0[2] != null) {
                h22.this.C0[2].setText(jSONObject2.getString("xydzp_hundred_price") + h22.this.H0);
            }
            if (h22.this.D0 != null) {
                List parseArray = JSON.parseArray(parseObject.getString("win_list"), LuckpanWinMsgBean.class);
                h22 h22Var = h22.this;
                h22Var.E0 = new da2(h22Var.x0, parseArray);
                h22.this.D0.r(h22.this.E0);
                h22.this.D0.p(true);
                h22.this.D0.D();
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements View.OnClickListener {
        public final /* synthetic */ PopupWindow a;

        public b(PopupWindow popupWindow) {
            this.a = popupWindow;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            if (id == b73.V0) {
                this.a.dismiss();
                h22.this.T2();
            } else if (id == b73.n1) {
                this.a.dismiss();
                h22.this.U2();
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends HttpCallback {
        public final /* synthetic */ String a;

        /* loaded from: /tmp/classes2.dex */
        public class a implements Runnable {
            public final /* synthetic */ String[] a;

            public a(String[] strArr) {
                this.a = strArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                c cVar = c.this;
                h22.this.X2(cVar.a, this.a);
            }
        }

        /* loaded from: /tmp/classes2.dex */
        public class b implements a.m {
            public b() {
            }

            @Override // com.yunbao.common.utils.a.m
            public void b(Dialog dialog, String str) {
                h22.this.S1();
                pi3.n(h22.this.x0);
            }
        }

        public c(String str) {
            this.a = str;
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length <= 0) {
                if (i == 1002) {
                    com.yunbao.common.utils.a.k(h22.this.x0, str, true, new b());
                }
            } else {
                boolean z = h22.this.K0;
                h22 h22Var = h22.this;
                if (z) {
                    h22Var.X2(this.a, strArr);
                } else {
                    h22Var.Z2(new a(strArr));
                }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d implements ba2.a {
        public final /* synthetic */ String a;

        public d(String str) {
            this.a = str;
        }

        @Override // ba2.a
        public void a() {
            h22.this.V2(this.a);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e implements ca2.a {
        public final /* synthetic */ String a;

        public e(String str) {
            this.a = str;
        }

        @Override // ca2.a
        public void a() {
            h22.this.V2(this.a);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class f implements ValueAnimator.AnimatorUpdateListener {
        public f() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (h22.this.O0 != intValue) {
                h22.this.O0 = intValue;
                int i = intValue % 8;
                if (h22.this.z0[i] != null) {
                    h22.this.z0[i].setBackground(h22.this.R0);
                }
                if (h22.this.Q0 >= 0 && h22.this.z0[h22.this.Q0] != null) {
                    h22.this.z0[h22.this.Q0].setBackground(h22.this.S0);
                }
                h22.this.Q0 = i;
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class g extends AnimatorListenerAdapter {
        public final /* synthetic */ Runnable a;

        public g(Runnable runnable) {
            this.a = runnable;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Runnable runnable;
            h22.this.T0 = null;
            h22.this.N0 = false;
            if (h22.this.Q0 >= 0 && h22.this.z0[h22.this.Q0] != null) {
                h22.this.z0[h22.this.Q0].setBackground(h22.this.S0);
            }
            if (h22.this.P0 || (runnable = this.a) == null) {
                return;
            }
            runnable.run();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface h {
        void a(String str);

        void b();

        void c();

        void d();
    }

    @Override // defpackage.l0
    public void C0() {
        this.P0 = true;
        ValueAnimator valueAnimator = this.T0;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.T0 = null;
        }
        h hVar = this.M0;
        if (hVar != null) {
            hVar.c();
        }
        this.M0 = null;
        Banner2 banner2 = this.D0;
        if (banner2 != null) {
            banner2.g();
            this.D0 = null;
        }
        e32.f("gameGetLuckpanInfo");
        e32.f("gameLuckpanPlay");
        super.C0();
    }

    public void R2(List list) {
        Banner2 banner2 = this.D0;
        if (banner2 != null) {
            banner2.E();
            da2 da2Var = this.E0;
            if (da2Var != null) {
                da2Var.O(list);
            }
            Banner2 banner22 = this.D0;
            banner22.t(banner22.getStartPosition(), false);
            this.D0.p(true);
            this.D0.D();
        }
    }

    public final void S2() {
        new w92().d2(((AbsActivity) this.x0).getSupportFragmentManager(), "LuckpanRankDialog");
    }

    public final void T2() {
        ym4 ym4Var = new ym4();
        Bundle bundle = new Bundle();
        bundle.putString(IjkMediaPlayer.OnNativeInvokeListener.ARG_URL, wg1.x);
        ym4Var.F1(bundle);
        ym4Var.d2(((AbsActivity) this.x0).getSupportFragmentManager(), "WebViewDialog");
    }

    public final void U2() {
        new y92().d2(((AbsActivity) this.x0).getSupportFragmentManager(), "LuckpanRecordDialog");
    }

    public final void V2(String str) {
        if (this.N0) {
            return;
        }
        e32.v(this.F0, this.G0, str, new c(str));
    }

    public void W2(h hVar) {
        this.M0 = hVar;
    }

    public final void X2(String str, String[] strArr) {
        JSONObject parseObject = JSON.parseObject(strArr[0]);
        TextView textView = this.B0;
        if (textView != null) {
            textView.setText(parseObject.getString("coin"));
        }
        List<LuckpanResultBean> parseArray = JSON.parseArray(parseObject.getString("gift_list"), LuckpanResultBean.class);
        if (parseArray == null || parseArray.size() <= 0) {
            ca2 ca2Var = new ca2();
            ca2Var.r2(new e(str));
            ca2Var.d2(((AbsActivity) this.x0).getSupportFragmentManager(), "LuckpanResultEmptyDialog");
            return;
        }
        ba2 ba2Var = new ba2();
        ba2Var.s2(parseArray);
        ba2Var.r2(new d(str));
        ba2Var.d2(((AbsActivity) this.x0).getSupportFragmentManager(), "LuckpanResultDialog");
        UserBean D = j30.q().D();
        if (D != null) {
            String userNiceName = D.getUserNiceName();
            if (!TextUtils.isEmpty(userNiceName) && userNiceName.length() > 1) {
                String substring = userNiceName.substring(1);
                if (!TextUtils.isEmpty(substring)) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < substring.length(); i++) {
                        sb.append("*");
                    }
                    String sb2 = sb.toString();
                    if (!TextUtils.isEmpty(sb2)) {
                        userNiceName = userNiceName.replace(substring, sb2);
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            for (LuckpanResultBean luckpanResultBean : parseArray) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("title", String.format(this.I0, userNiceName, luckpanResultBean.getGiftName(), luckpanResultBean.getCount()));
                jSONObject.put("title_en", String.format(this.J0, userNiceName, luckpanResultBean.getGiftNameEn(), luckpanResultBean.getCount()));
                jSONArray.add(jSONObject);
            }
            h hVar = this.M0;
            if (hVar != null) {
                hVar.a(jSONArray.toJSONString());
            }
        }
    }

    public final void Y2() {
        View inflate = LayoutInflater.from(this.x0).inflate(x73.s, (ViewGroup) null);
        inflate.measure(0, 0);
        PopupWindow popupWindow = new PopupWindow(inflate, inflate.getMeasuredWidth(), inflate.getMeasuredHeight(), true);
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        popupWindow.setOutsideTouchable(true);
        int[] iArr = new int[2];
        this.A0.getLocationInWindow(iArr);
        popupWindow.showAtLocation(this.A0, 51, iArr[0], iArr[1]);
        b bVar = new b(popupWindow);
        inflate.findViewById(b73.V0).setOnClickListener(bVar);
        inflate.findViewById(b73.n1).setOnClickListener(bVar);
    }

    public final void Z2(Runnable runnable) {
        if (this.N0) {
            return;
        }
        int f2 = rv3.f(8) + 32;
        ValueAnimator duration = ValueAnimator.ofInt(0, f2).setDuration(f2 * 80);
        duration.setInterpolator(new LinearInterpolator());
        duration.addUpdateListener(new f());
        duration.addListener(new g(runnable));
        this.T0 = duration;
        this.N0 = true;
        this.O0 = -1;
        this.Q0 = -1;
        duration.start();
    }

    public final void a3() {
        boolean z = this.K0;
        this.K0 = !z;
        ImageView imageView = this.L0;
        if (imageView != null) {
            if (z) {
                if (imageView.getVisibility() != 4) {
                    this.L0.setVisibility(4);
                }
            } else if (imageView.getVisibility() != 0) {
                this.L0.setVisibility(0);
            }
        }
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
        return x73.r;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == b73.C0) {
            Y2();
            return;
        }
        if (id == b73.M0) {
            S2();
            return;
        }
        if (id == b73.M) {
            S1();
            h hVar = this.M0;
            if (hVar != null) {
                hVar.b();
                return;
            }
            return;
        }
        if (id == b73.f0) {
            V2("one");
            return;
        }
        if (id == b73.g0) {
            V2("ten");
            return;
        }
        if (id == b73.h0) {
            V2("hundred");
            return;
        }
        if (id != b73.G0) {
            if (id == b73.d1) {
                a3();
            }
        } else {
            S1();
            h hVar2 = this.M0;
            if (hVar2 != null) {
                hVar2.d();
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
            this.F0 = z.getString("liveUid");
            this.G0 = z.getString("stream");
        }
        this.H0 = j30.q().g();
        this.I0 = "恭喜%1$s获得%2$s%3$s";
        this.J0 = "Congratulations to %1$s for getting %2$s%3$s";
        View k2 = k2(b73.C0);
        this.A0 = k2;
        k2.setOnClickListener(this);
        ImageView[] imageViewArr = new ImageView[8];
        this.z0 = imageViewArr;
        imageViewArr[0] = (ImageView) k2(b73.S2);
        this.z0[1] = (ImageView) k2(b73.T2);
        this.z0[2] = (ImageView) k2(b73.U2);
        this.z0[3] = (ImageView) k2(b73.V2);
        this.z0[4] = (ImageView) k2(b73.W2);
        this.z0[5] = (ImageView) k2(b73.X2);
        this.z0[6] = (ImageView) k2(b73.Y2);
        this.z0[7] = (ImageView) k2(b73.Z2);
        this.R0 = o60.d(this.x0, t83.d);
        this.S0 = o60.d(this.x0, t83.c);
        TextView[] textViewArr = new TextView[3];
        this.C0 = textViewArr;
        textViewArr[0] = (TextView) k2(b73.t1);
        this.C0[1] = (TextView) k2(b73.u1);
        this.C0[2] = (TextView) k2(b73.v1);
        this.B0 = (TextView) k2(b73.s1);
        k2(b73.M).setOnClickListener(this);
        k2(b73.f0).setOnClickListener(this);
        k2(b73.g0).setOnClickListener(this);
        k2(b73.h0).setOnClickListener(this);
        k2(b73.G0).setOnClickListener(this);
        k2(b73.M0).setOnClickListener(this);
        k2(b73.d1).setOnClickListener(this);
        this.L0 = (ImageView) k2(b73.c3);
        Banner2 banner2 = (Banner2) k2(b73.i);
        this.D0 = banner2;
        banner2.B(false);
        this.D0.w(3000L);
        this.D0.z(1200);
        this.D0.x(1);
        ViewPager2 viewPager2 = this.D0.getViewPager2();
        if (viewPager2 != null) {
            viewPager2.setOrientation(1);
            viewPager2.setOffscreenPageLimit(IjkMediaCodecInfo.RANK_MAX);
        }
        e32.t(new a());
    }
}
