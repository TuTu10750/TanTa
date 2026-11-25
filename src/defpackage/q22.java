package defpackage;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.umeng.analytics.pro.bv;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.yunbao.common.bean.LiveGiftBean;
import com.yunbao.common.bean.UserBean;
import com.yunbao.common.custom.DrawGiftView;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.live.activity.LiveActivity;
import com.yunbao.live.bean.BackPackGiftBean;
import com.yunbao.live.bean.LiveGuardInfo;
import com.zzhoujay.richtext.cache.CacheIOHelper;
import defpackage.kn1;
import defpackage.o0;
import java.util.ArrayList;
import java.util.List;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;

/* loaded from: /tmp/classes2.dex */
public class q22 extends l0 implements View.OnClickListener, o0.b {
    public o0[] A0;
    public s22 B0;
    public p22 C0;
    public u22 D0;
    public List E0;
    public ViewPager F0;
    public View G0;
    public LiveGiftBean H0;
    public String J0;
    public String K0;
    public Handler L0;
    public int M0;
    public TextView N0;
    public boolean O0;
    public LiveGuardInfo P0;
    public View Q0;
    public TextView R0;
    public String S0;
    public String T0;
    public View U0;
    public View V0;
    public DrawGiftView W0;
    public TextView X0;
    public String Y0;
    public SpannableStringBuilder Z0;
    public ForegroundColorSpan a1;
    public s62 b1;
    public int z0 = 2;
    public String I0 = SdkVersion.MINI_VERSION;

    /* loaded from: /tmp/classes2.dex */
    public class a implements ViewPager.j {
        public a() {
        }

        public void a(int i, float f, int i2) {
        }

        public void b(int i) {
        }

        public void c(int i) {
            o0 o0Var;
            LiveGiftBean a0;
            q22.this.W2(i);
            q22.this.V2();
            if (q22.this.Q0 != null && q22.this.R0 != null && q22.this.z0 == 2) {
                if (i == 0) {
                    if (q22.this.Q0.getVisibility() != 0) {
                        q22.this.Q0.setVisibility(0);
                    }
                } else if (i == 1 && q22.this.Q0.getVisibility() == 0) {
                    q22.this.Q0.setVisibility(4);
                }
            }
            if (q22.this.A0 == null || q22.this.A0.length <= 0 || (o0Var = q22.this.A0[0]) == null || (a0 = o0Var.a0()) == null || a0.getType() != 3) {
                return;
            }
            q22 q22Var = q22.this;
            if (i == 0) {
                if (q22Var.U0.getVisibility() != 0) {
                    q22.this.U0.setVisibility(0);
                }
            } else if (q22Var.U0.getVisibility() == 0) {
                q22.this.U0.setVisibility(4);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends n30 {
        public final /* synthetic */ String[] b;

        /* loaded from: /tmp/classes2.dex */
        public class a implements View.OnClickListener {
            public final /* synthetic */ int a;

            public a(int i) {
                this.a = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (q22.this.F0 != null) {
                    q22.this.F0.setCurrentItem(this.a);
                }
            }
        }

        public b(String[] strArr) {
            this.b = strArr;
        }

        @Override // defpackage.n30
        public int a() {
            return this.b.length;
        }

        @Override // defpackage.n30
        public zh1 b(Context context) {
            LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
            linePagerIndicator.setMode(1);
            linePagerIndicator.setXOffset(zn0.a(5));
            linePagerIndicator.setRoundRadius(zn0.a(2));
            linePagerIndicator.setColors(Integer.valueOf(o60.b(q22.this.x0, p53.n)));
            return linePagerIndicator;
        }

        @Override // defpackage.n30
        public bi1 c(Context context, int i) {
            ColorTransitionPagerTitleView colorTransitionPagerTitleView = new ColorTransitionPagerTitleView(context);
            colorTransitionPagerTitleView.setNormalColor(o60.b(q22.this.x0, p53.m));
            colorTransitionPagerTitleView.setSelectedColor(o60.b(q22.this.x0, p53.n));
            colorTransitionPagerTitleView.setText(this.b[i]);
            colorTransitionPagerTitleView.setTextSize(13.0f);
            colorTransitionPagerTitleView.setOnClickListener(new a(i));
            return colorTransitionPagerTitleView;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c implements DrawGiftView.a {
        public c() {
        }

        @Override // com.yunbao.common.custom.DrawGiftView.a
        public void a(int i) {
            q22.this.Z2(i);
            q22 q22Var = q22.this;
            if (i > 0) {
                if (q22Var.V0 == null || q22.this.V0.getVisibility() != 0) {
                    return;
                }
                q22.this.V0.setVisibility(4);
                return;
            }
            if (q22Var.V0 == null || q22.this.V0.getVisibility() == 0) {
                return;
            }
            q22.this.V0.setVisibility(0);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d extends Handler {
        public d() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            q22.x2(q22.this);
            int i = q22.this.M0;
            q22 q22Var = q22.this;
            if (i == 0) {
                q22Var.V2();
                return;
            }
            if (q22Var.N0 != null) {
                q22.this.N0.setText(q22.this.M0 + bv.aB);
                if (q22.this.L0 != null) {
                    q22.this.L0.sendEmptyMessageDelayed(100, 1000L);
                }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e extends HttpCallback {
        public final /* synthetic */ int a;

        public e(int i) {
            this.a = i;
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0) {
                q22.this.V2();
                t54.b(str);
                return;
            }
            if (strArr.length > 0) {
                JSONObject parseObject = JSON.parseObject(strArr[0]);
                String string = parseObject.getString("coin");
                UserBean D = j30.q().D();
                if (D != null) {
                    D.setLevel(parseObject.getIntValue("level"));
                    D.setCoin(string);
                }
                if (q22.this.B0 != null) {
                    q22.this.B0.k0(string);
                }
                if (q22.this.C0 != null) {
                    q22.this.C0.k0(string);
                }
                ((LiveActivity) q22.this.x0).R1(string);
                if (q22.this.x0 == null || q22.this.H0 == null) {
                    return;
                }
                int type = q22.this.H0.getType();
                q22 q22Var = q22.this;
                if (type == 3) {
                    if (q22Var.W0 != null) {
                        ((LiveActivity) q22.this.x0).q2(q22.this.H0, parseObject.getString("gifttoken"), JSON.toJSONString(q22.this.W0.getPointList()), q22.this.W0.getWidth(), q22.this.W0.getHeight());
                    }
                    q22.this.S1();
                    return;
                }
                ((LiveActivity) q22Var.x0).q2(q22.this.H0, parseObject.getString("gifttoken"), null, 0, 0);
                if (q22.this.H0.isSticker()) {
                    ((LiveActivity) q22.this.x0).o2(String.format("发送了%1$s道具礼物", q22.this.H0.getName()), String.format("Sent %1$s prop gift", q22.this.H0.getNameEn()));
                }
                if (q22.this.H0.getType() == 0) {
                    q22.this.a3();
                }
                if (!(q22.this.H0 instanceof BackPackGiftBean) || q22.this.D0 == null) {
                    return;
                }
                q22.this.D0.j0(q22.this.H0.getId(), rv3.h(q22.this.I0, 0) * this.a);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class f implements kn1.a {
        public f() {
        }

        @Override // kn1.a
        public void onLoadFailed() {
        }

        @Override // kn1.a
        public void onLoadSuccess(Drawable drawable) {
            if (drawable == null || !(drawable instanceof BitmapDrawable)) {
                return;
            }
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            if (q22.this.W0 != null) {
                q22.this.W0.setBitmap(bitmap);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W2(int i) {
        List list;
        o0[] o0VarArr = this.A0;
        if (o0VarArr == null) {
            return;
        }
        o0 o0Var = o0VarArr[i];
        if (o0Var == null && (list = this.E0) != null && i < list.size()) {
            FrameLayout frameLayout = (FrameLayout) this.E0.get(i);
            if (frameLayout == null) {
                return;
            }
            if (i == 0) {
                s22 s22Var = new s22(this.x0, frameLayout, this.J0, this.K0);
                this.B0 = s22Var;
                s22Var.f0(this);
                o0Var = this.B0;
            } else if (i == 1) {
                int i2 = this.z0;
                Context context = this.x0;
                if (i2 == 3) {
                    p22 p22Var = new p22(context, frameLayout, this.J0, this.K0);
                    this.C0 = p22Var;
                    p22Var.f0(this);
                    o0Var = this.C0;
                } else {
                    u22 u22Var = new u22(context, frameLayout, this.J0, this.K0);
                    this.D0 = u22Var;
                    u22Var.f0(this);
                    o0Var = this.D0;
                }
            } else if (i == 2) {
                u22 u22Var2 = new u22(this.x0, frameLayout, this.J0, this.K0);
                this.D0 = u22Var2;
                u22Var2.f0(this);
                o0Var = this.D0;
            }
            if (o0Var == null) {
                return;
            }
            this.A0[i] = o0Var;
            o0Var.addToParent();
        }
        if (o0Var != null) {
            o0Var.loadData();
        }
    }

    public static /* synthetic */ int x2(q22 q22Var) {
        int i = q22Var.M0;
        q22Var.M0 = i - 1;
        return i;
    }

    @Override // defpackage.l0
    public void C0() {
        Handler handler = this.L0;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.L0 = null;
        e32.f("getGiftList");
        e32.f("getCoin");
        e32.f("sendGift");
        super.C0();
    }

    public final void U2() {
        S1();
        ((LiveActivity) this.x0).S1();
    }

    public final void V2() {
        o0 o0Var;
        this.O0 = false;
        Handler handler = this.L0;
        if (handler != null) {
            handler.removeMessages(100);
        }
        View view = this.G0;
        if (view != null && view.getVisibility() == 0) {
            this.G0.setVisibility(4);
        }
        ViewPager viewPager = this.F0;
        if (viewPager == null || (o0Var = this.A0[viewPager.getCurrentItem()]) == null) {
            return;
        }
        o0Var.g0(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void X2() {
        LiveGiftBean liveGiftBean;
        String str;
        DrawGiftView drawGiftView;
        List<PointF> pointList;
        o0 o0Var = this.A0[this.F0.getCurrentItem()];
        if (o0Var == null) {
            return;
        }
        this.H0 = o0Var.a0();
        if (TextUtils.isEmpty(this.J0) || TextUtils.isEmpty(this.K0) || (liveGiftBean = this.H0) == null) {
            return;
        }
        if (this.P0 != null && liveGiftBean.getMark() == 2 && this.P0.getMyGuardType() != 2) {
            t54.a(m93.g2);
            return;
        }
        if (this.H0.getType() == 3 && (drawGiftView = this.W0) != null && (pointList = drawGiftView.getPointList()) != null) {
            if (pointList.size() < 10) {
                t54.a(m93.R1);
                return;
            }
            this.I0 = String.valueOf(pointList.size());
        }
        int i = 1;
        if (((LiveActivity) this.x0).L1()) {
            s62 s62Var = this.b1;
            if (s62Var != null) {
                Object[] T = s62Var.T();
                str = (String) T[0];
                i = ((Integer) T[1]).intValue();
            } else {
                str = null;
            }
        } else {
            str = this.J0;
        }
        String str2 = str;
        if (TextUtils.isEmpty(str2)) {
            t54.a(m93.K);
            return;
        }
        String str3 = this.J0;
        String str4 = this.K0;
        int id = this.H0.getId();
        String str5 = this.I0;
        LiveGiftBean liveGiftBean2 = this.H0;
        e32.z0(str3, str4, str2, id, str5, liveGiftBean2 instanceof BackPackGiftBean ? 1 : 0, liveGiftBean2.isSticker() ? 1 : 0, new e(i));
    }

    public void Y2(LiveGuardInfo liveGuardInfo) {
        this.P0 = liveGuardInfo;
    }

    public final void Z2(int i) {
        if (this.X0 == null || this.Z0 == null) {
            return;
        }
        String valueOf = String.valueOf(i);
        String format = String.format(this.Y0, valueOf);
        this.Z0.clear();
        this.Z0.append((CharSequence) format);
        int indexOf = format.indexOf(valueOf);
        this.Z0.setSpan(this.a1, indexOf, valueOf.length() + indexOf, 33);
        this.X0.setText(this.Z0);
    }

    public final void a3() {
        o0 o0Var;
        TextView textView = this.N0;
        if (textView != null) {
            textView.setText("5s");
        }
        this.M0 = 5;
        Handler handler = this.L0;
        if (handler != null) {
            handler.removeMessages(100);
            this.L0.sendEmptyMessageDelayed(100, 1000L);
        }
        if (this.O0) {
            return;
        }
        this.O0 = true;
        ViewPager viewPager = this.F0;
        if (viewPager != null && (o0Var = this.A0[viewPager.getCurrentItem()]) != null) {
            o0Var.g0(false);
        }
        View view = this.G0;
        if (view == null || view.getVisibility() == 0) {
            return;
        }
        this.G0.setVisibility(0);
    }

    @Override // o0.b
    public void d(String str) {
        this.I0 = str;
    }

    @Override // defpackage.l0
    public boolean f2() {
        return true;
    }

    @Override // o0.b
    public void j(LiveGiftBean liveGiftBean) {
        V2();
        int type = liveGiftBean.getType();
        DrawGiftView drawGiftView = this.W0;
        if (type == 3) {
            if (drawGiftView != null) {
                drawGiftView.a();
            }
            if (this.U0.getVisibility() != 0) {
                this.U0.setVisibility(0);
            }
            kn1.j(this.x0, liveGiftBean.getIcon(), new f());
            return;
        }
        if (drawGiftView != null) {
            drawGiftView.a();
        }
        if (this.U0.getVisibility() == 0) {
            this.U0.setVisibility(4);
        }
    }

    @Override // o0.b
    public void l() {
        U2();
    }

    @Override // defpackage.l0
    public int l2() {
        return s93.d;
    }

    @Override // o0.b
    public void m() {
        X2();
    }

    @Override // defpackage.l0
    public int m2() {
        return x73.M;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        DrawGiftView drawGiftView;
        int id = view.getId();
        if (id == b73.a1) {
            X2();
            return;
        }
        if (id == b73.x0) {
            S1();
            TextView textView = this.R0;
            if (textView != null) {
                String charSequence = textView.getText().toString();
                if (TextUtils.isEmpty(charSequence)) {
                    return;
                }
                boolean equals = charSequence.equals(this.S0);
                Object obj = this.x0;
                if (equals) {
                    ((LiveActivity) obj).d2();
                    return;
                } else {
                    ((LiveActivity) obj).Z1();
                    return;
                }
            }
            return;
        }
        if (id == b73.H || id == b73.I) {
            S1();
            return;
        }
        if (id == b73.V) {
            DrawGiftView drawGiftView2 = this.W0;
            if (drawGiftView2 != null) {
                drawGiftView2.b();
                return;
            }
            return;
        }
        if (id != b73.W || (drawGiftView = this.W0) == null) {
            return;
        }
        drawGiftView.a();
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        ((LiveActivity) this.x0).y2(true);
    }

    @Override // defpackage.l0
    public void p2(Window window) {
        window.setWindowAnimations(s93.b);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        window.setAttributes(attributes);
        window.addFlags(CacheIOHelper.BUFFER_SIZE);
    }

    public void r0(Bundle bundle) {
        boolean z;
        super.r0(bundle);
        ViewPager k2 = k2(b73.g6);
        this.F0 = k2;
        k2.getLayoutParams().height = (gk3.a().c() / 2) + zn0.a(65);
        this.F0.requestLayout();
        int i = this.z0;
        if (i > 1) {
            this.F0.setOffscreenPageLimit(i - 1);
        }
        this.A0 = new o0[this.z0];
        this.E0 = new ArrayList();
        for (int i2 = 0; i2 < this.z0; i2++) {
            FrameLayout frameLayout = new FrameLayout(this.x0);
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.E0.add(frameLayout);
        }
        this.F0.setAdapter(new dk4(this.E0));
        this.F0.c(new a());
        MagicIndicator magicIndicator = (MagicIndicator) k2(b73.e3);
        String[] strArr = this.z0 == 3 ? new String[]{aq4.a(m93.A4), aq4.a(m93.F4), aq4.a(m93.E4)} : new String[]{aq4.a(m93.A4), aq4.a(m93.E4)};
        CommonNavigator commonNavigator = new CommonNavigator(this.x0);
        commonNavigator.setAdapter(new b(strArr));
        magicIndicator.setNavigator(commonNavigator);
        ek4.a(magicIndicator, this.F0);
        View findViewById = this.y0.findViewById(b73.a1);
        this.G0 = findViewById;
        findViewById.setOnClickListener(this);
        this.N0 = (TextView) this.y0.findViewById(b73.B3);
        View findViewById2 = this.y0.findViewById(b73.x0);
        this.Q0 = findViewById2;
        findViewById2.setOnClickListener(this);
        this.R0 = (TextView) this.y0.findViewById(b73.k2);
        this.S0 = aq4.a(m93.G3);
        this.T0 = aq4.a(m93.H3);
        this.y0.findViewById(b73.H).setOnClickListener(this);
        this.y0.findViewById(b73.I).setOnClickListener(this);
        this.y0.findViewById(b73.V).setOnClickListener(this);
        this.y0.findViewById(b73.W).setOnClickListener(this);
        this.U0 = k2(b73.y2);
        this.V0 = k2(b73.g5);
        this.X0 = (TextView) k2(b73.L1);
        this.Y0 = aq4.a(m93.S1);
        this.Z0 = new SpannableStringBuilder();
        this.a1 = new ForegroundColorSpan(o60.b(this.x0, p53.g));
        DrawGiftView drawGiftView = (DrawGiftView) k2(b73.J1);
        this.W0 = drawGiftView;
        drawGiftView.setActionListener(new c());
        this.L0 = new d();
        Bundle z2 = z();
        if (z2 != null) {
            this.J0 = z2.getString("liveUid");
            this.K0 = z2.getString("liveStream");
            z = z2.getBoolean("openPack", false);
        } else {
            z = false;
        }
        if (((LiveActivity) this.x0).L1()) {
            RecyclerView k22 = k2(b73.h6);
            k22.setVisibility(0);
            k22.setLayoutManager(new LinearLayoutManager(this.x0, 0, false));
            s62 s62Var = new s62(this.x0, ((LiveActivity) this.x0).I1());
            this.b1 = s62Var;
            k22.setAdapter(s62Var);
        }
        if (z) {
            this.F0.setCurrentItem(2);
        } else {
            W2(0);
        }
    }
}
