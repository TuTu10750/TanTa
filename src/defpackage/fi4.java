package defpackage;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.bean.UserBean;
import com.yunbao.common.http.CommonHttpUtil;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.video.activity.AbsVideoPlayActivity;
import com.yunbao.video.bean.VideoBean;
import defpackage.kn1;

/* loaded from: /tmp/classes2.dex */
public class fi4 extends b1 implements View.OnClickListener {
    public View A;
    public TextView B;
    public TextView C;
    public k30 D;
    public int E;
    public int F;
    public int G;
    public boolean H;
    public boolean I;
    public String J;
    public ViewGroup a;
    public ImageView b;
    public ImageView c;
    public TextView d;
    public TextView e;
    public ImageView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public ImageView j;
    public TextView k;
    public View l;
    public VideoBean m;
    public Drawable n;
    public Drawable o;
    public Animation p;
    public boolean q;
    public ValueAnimator r;
    public Drawable[] s;
    public int t;
    public String u;
    public SeekBar v;
    public LinearLayout w;
    public TextView x;
    public View y;
    public View z;

    /* loaded from: /tmp/classes2.dex */
    public class a implements SeekBar.OnSeekBarChangeListener {
        public a() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            fi4.this.E = i;
            fi4.this.B.setText(rv3.e(i, new StringBuilder()));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            new GradientDrawable().setShape(0);
            fi4.this.v.setProgressDrawable(o60.d(fi4.this.mContext, z53.c));
            fi4.this.v.setThumb(o60.d(fi4.this.mContext, z53.f));
            fi4.this.y.setVisibility(8);
            fi4.this.z.setVisibility(8);
            fi4.this.A.setVisibility(0);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (fi4.this.D != null) {
                fi4.this.D.a(Integer.valueOf(fi4.this.E));
                fi4.this.v.setVisibility(4);
            }
            fi4.this.v.setProgressDrawable(o60.d(fi4.this.mContext, z53.d));
            fi4.this.v.setThumb(o60.d(fi4.this.mContext, z53.e));
            fi4.this.y.setVisibility(0);
            fi4.this.z.setVisibility(0);
            fi4.this.A.setVisibility(8);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int floatValue = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (fi4.this.t != floatValue) {
                fi4.this.t = floatValue;
                if (fi4.this.f == null || fi4.this.s == null || floatValue >= fi4.this.s.length) {
                    return;
                }
                fi4.this.f.setImageDrawable(fi4.this.s[floatValue]);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c implements Animation.AnimationListener {
        public c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            if (fi4.this.j == null || fi4.this.m == null) {
                return;
            }
            int attent = fi4.this.m.getAttent();
            fi4 fi4Var = fi4.this;
            if (attent == 1) {
                fi4Var.j.setImageDrawable(fi4.this.n);
            } else {
                fi4Var.j.setImageDrawable(fi4.this.o);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d implements kn1.a {
        public d() {
        }

        @Override // kn1.a
        public void onLoadFailed() {
        }

        @Override // kn1.a
        public void onLoadSuccess(Drawable drawable) {
            if (fi4.this.b == null || drawable == null) {
                return;
            }
            float intrinsicWidth = drawable.getIntrinsicWidth();
            float intrinsicHeight = drawable.getIntrinsicHeight();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) fi4.this.b.getLayoutParams();
            int width = intrinsicWidth / intrinsicHeight > 0.5625f ? (int) ((fi4.this.b.getWidth() / intrinsicWidth) * intrinsicHeight) : -1;
            if (width != layoutParams.height) {
                layoutParams.height = width;
                fi4.this.b.requestLayout();
            }
            fi4.this.b.setImageDrawable(drawable);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e extends HttpCallback {
        public e() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length <= 0) {
                t54.b(str);
                return;
            }
            JSONObject parseObject = JSON.parseObject(strArr[0]);
            String string = parseObject.getString("likes");
            int intValue = parseObject.getIntValue("islike");
            if (fi4.this.m != null) {
                fi4.this.m.setLikeNum(string);
                fi4.this.m.setLike(intValue);
                zu0.c().j(new bi4(fi4.this.m.getId(), intValue, string));
            }
            if (fi4.this.g != null) {
                fi4.this.g.setText(string);
            }
            if (fi4.this.f != null) {
                fi4 fi4Var = fi4.this;
                if (intValue != 1) {
                    fi4Var.f.setImageResource(w83.c);
                    return;
                }
                if (fi4Var.r == null) {
                    fi4.this.O0();
                }
                fi4.this.t = -1;
                if (fi4.this.r != null) {
                    fi4.this.r.start();
                }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class f extends k30 {
        public f() {
        }

        @Override // defpackage.k30
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Integer num) {
            fi4.this.m.setAttent(num.intValue());
            if (fi4.this.q) {
                if (fi4.this.p == null) {
                    fi4.this.N0();
                }
                fi4.this.j.startAnimation(fi4.this.p);
            } else {
                int intValue = num.intValue();
                fi4 fi4Var = fi4.this;
                if (intValue == 1) {
                    fi4Var.j.setImageDrawable(fi4.this.n);
                } else {
                    fi4Var.j.setImageDrawable(fi4.this.o);
                }
            }
        }
    }

    public fi4(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
        this.F = 0;
        this.G = 1;
        this.H = false;
        this.I = false;
        this.J = "";
    }

    public void D0(View view) {
        if (this.a == null || view == null) {
            return;
        }
        ViewParent parent = view.getParent();
        if (parent == null) {
            this.a.addView(view);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        if (viewGroup != this.a) {
            viewGroup.removeView(view);
            this.a.addView(view);
        }
    }

    public void E0() {
        if (this.H) {
            Z0();
        }
    }

    public void F0() {
        VideoBean videoBean = this.m;
        if (videoBean != null) {
            pi3.q(this.mContext, videoBean.getUid());
        }
    }

    public final void G0() {
        ((AbsVideoPlayActivity) this.mContext).x1(true, false, true, this.m.getId(), this.m.getUid());
    }

    public final void H0() {
        UserBean userBean;
        VideoBean videoBean = this.m;
        if (videoBean == null || (userBean = videoBean.getUserBean()) == null) {
            return;
        }
        CommonHttpUtil.setAttention(this.u, userBean.getId(), new f());
    }

    public final void I0() {
        VideoBean videoBean;
        if (this.mContext == null || (videoBean = this.m) == null) {
            return;
        }
        int isAd = videoBean.getIsAd();
        VideoBean videoBean2 = this.m;
        if (isAd == 1) {
            String adUrl = videoBean2.getAdUrl();
            if (TextUtils.isEmpty(adUrl)) {
                return;
            }
            try {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(adUrl));
                this.mContext.startActivity(intent);
                return;
            } catch (Exception unused) {
                t54.a(m93.Z1);
                return;
            }
        }
        int type = videoBean2.getType();
        VideoBean videoBean3 = this.m;
        if (type != 1) {
            if (videoBean3.getType() == 2) {
                pi3.o(this.mContext, this.m.getGoodsId());
            }
        } else {
            int goodsType = videoBean3.getGoodsType();
            Context context = this.mContext;
            if (goodsType == 1) {
                pi3.g(context, this.m.getGoodsId(), false);
            } else {
                pi3.e(context, this.m.getGoodsId(), false, this.m.getUid(), null);
            }
        }
    }

    public final void J0() {
        VideoBean videoBean = this.m;
        if (videoBean == null) {
            return;
        }
        zh4.o(this.u, videoBean.getId(), new e());
    }

    public final void K0() {
        pi3.u();
    }

    public final void L0() {
        if (this.F <= 0) {
            pi3.w("video");
            return;
        }
        FragmentActivity fragmentActivity = this.mContext;
        if (fragmentActivity instanceof FragmentActivity) {
            FragmentActivity fragmentActivity2 = fragmentActivity;
            if (fragmentActivity2.isFinishing() || fragmentActivity2.isDestroyed() || fragmentActivity2.getSupportFragmentManager().O0()) {
                return;
            }
            new kj4().q2(fragmentActivity2.getSupportFragmentManager(), "VideoWatchDialogFragment");
        }
    }

    public VideoBean M0() {
        return this.m;
    }

    public void N0() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.3f, 1.0f, 0.3f, 1, 0.5f, 1, 0.5f);
        this.p = scaleAnimation;
        scaleAnimation.setRepeatMode(2);
        this.p.setRepeatCount(1);
        this.p.setDuration(200L);
        this.p.setAnimationListener(new c());
    }

    public final void O0() {
        Drawable[] drawableArr = this.s;
        if (drawableArr == null || drawableArr.length <= 0) {
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, drawableArr.length);
        this.r = ofFloat;
        ofFloat.setDuration(800L);
        this.r.addUpdateListener(new b());
    }

    public void P0() {
        ImageView imageView = this.b;
        if (imageView != null) {
            if (imageView.getVisibility() != 0) {
                this.b.setVisibility(0);
            }
            this.b.setImageDrawable(null);
            T0();
        }
    }

    public void Q0() {
        this.q = false;
        ImageView imageView = this.b;
        if (imageView == null || imageView.getVisibility() == 0) {
            return;
        }
        this.b.setVisibility(0);
    }

    public void R0() {
        this.q = true;
    }

    public void S0(int i) {
        SeekBar seekBar = this.v;
        if (i == 0) {
            seekBar.setVisibility(0);
        } else {
            seekBar.setVisibility(4);
        }
    }

    public final void T0() {
        kn1.j(this.mContext, this.m.getThumb(), new d());
    }

    public void U0(VideoBean videoBean, Object obj) {
        if (videoBean == null) {
            return;
        }
        this.m = videoBean;
        UserBean userBean = videoBean.getUserBean();
        if (obj == null) {
            if (this.b != null) {
                T0();
            }
            TextView textView = this.e;
            if (textView != null) {
                textView.setText(videoBean.getTitle());
            }
            if (userBean != null) {
                if (this.c != null) {
                    kn1.g(this.mContext, userBean.getAvatar(), this.c);
                }
                TextView textView2 = this.d;
                if (textView2 != null) {
                    textView2.setText("@" + userBean.getUserNiceName());
                }
            }
        }
        if (this.f != null) {
            if (videoBean.getLike() == 1) {
                Drawable[] drawableArr = this.s;
                if (drawableArr != null && drawableArr.length > 0) {
                    this.f.setImageDrawable(drawableArr[drawableArr.length - 1]);
                }
            } else {
                this.f.setImageResource(w83.c);
            }
        }
        TextView textView3 = this.g;
        if (textView3 != null) {
            textView3.setText(videoBean.getLikeNum());
        }
        TextView textView4 = this.h;
        if (textView4 != null) {
            textView4.setText(videoBean.getCommentNum());
        }
        TextView textView5 = this.i;
        if (textView5 != null) {
            textView5.setText(videoBean.getShareNum());
        }
        if (userBean != null && this.j != null) {
            String id = userBean.getId();
            if (!TextUtils.isEmpty(id) && !id.equals(j30.q().C())) {
                if (this.j.getVisibility() != 0) {
                    this.j.setVisibility(0);
                }
                int attent = videoBean.getAttent();
                ImageView imageView = this.j;
                if (attent == 1) {
                    imageView.setImageDrawable(this.n);
                } else {
                    imageView.setImageDrawable(this.o);
                }
            } else if (this.j.getVisibility() == 0) {
                this.j.setVisibility(4);
            }
        }
        if (this.l != null) {
            int isAd = videoBean.getIsAd();
            View view = this.l;
            if (isAd == 1) {
                if (view.getVisibility() != 0) {
                    this.l.setVisibility(0);
                }
            } else if (view.getVisibility() != 4) {
                this.l.setVisibility(4);
            }
        }
        if (this.k != null) {
            if (videoBean.getIsAd() == 1) {
                if (this.k.getVisibility() != 0) {
                    this.k.setVisibility(0);
                }
                this.k.setText(m93.Y1);
                return;
            }
            int type = videoBean.getType();
            TextView textView6 = this.k;
            if (type == 0) {
                if (textView6.getVisibility() != 8) {
                    this.k.setVisibility(8);
                    return;
                }
                return;
            }
            if (textView6.getVisibility() != 0) {
                this.k.setVisibility(0);
            }
            if (type == 1) {
                this.k.setText(m93.X1);
            } else if (type == 2) {
                this.k.setText(m93.V7);
            }
        }
    }

    public void V0(Drawable[] drawableArr) {
        this.s = drawableArr;
    }

    public void W0(k30 k30Var) {
        this.D = k30Var;
    }

    public void X0(int i, int i2) {
        int round = Math.round(i2 / 1000.0f);
        float f2 = i / 1000.0f;
        this.v.setMax(Math.round(f2));
        this.v.setProgress(round);
        this.C.setText(rv3.e(Math.round(f2), new StringBuilder()));
    }

    public void Y0(String str) {
        if (str == null || str.isEmpty() || this.w == null) {
            return;
        }
        JSONObject parseObject = JSON.parseObject(str);
        this.G = parseObject.getIntValue("is_play");
        String string = parseObject.getString("desc");
        boolean isEmpty = string.isEmpty();
        LinearLayout linearLayout = this.w;
        if (isEmpty) {
            linearLayout.setVisibility(8);
            return;
        }
        linearLayout.setVisibility(0);
        this.x.setText(Html.fromHtml(string));
        this.F = parseObject.getIntValue("used_free_num");
        if (this.G == 1) {
            this.H = false;
            this.v.setEnabled(true);
            return;
        }
        this.v.setEnabled(false);
        if (parseObject.getIntValue("is_vip") != 1) {
            String string2 = parseObject.getString("fail_msg");
            if (string2 != null && !string2.isEmpty()) {
                string = string2;
            }
            this.J = string;
            this.H = true;
            if (j30.q().w() == 1) {
                Z0();
            }
        }
    }

    public final void Z0() {
        if (this.I) {
            return;
        }
        Context context = this.mContext;
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
        }
        FragmentActivity fragmentActivity = this.mContext;
        if ((fragmentActivity instanceof FragmentActivity) && fragmentActivity.getSupportFragmentManager().O0()) {
            return;
        }
        this.I = true;
        kj4 t2 = kj4.t2(this.J);
        t2.u2(new Runnable() { // from class: ei4
            @Override // java.lang.Runnable
            public final void run() {
                fi4.this.I = false;
            }
        });
        t2.q2(((AbsVideoPlayActivity) this.mContext).getSupportFragmentManager(), "VideoWatchDialogFragment");
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return b83.w;
    }

    @Override // defpackage.b1
    public void init() {
        this.u = toString();
        this.a = (ViewGroup) findViewById(f73.b0);
        this.b = (ImageView) findViewById(f73.w);
        this.c = (ImageView) findViewById(f73.c);
        this.d = (TextView) findViewById(f73.I);
        this.e = (TextView) findViewById(f73.W);
        this.f = (ImageView) findViewById(f73.o);
        this.g = (TextView) findViewById(f73.E);
        this.h = (TextView) findViewById(f73.t);
        this.i = (TextView) findViewById(f73.S);
        this.j = (ImageView) findViewById(f73.l);
        this.l = findViewById(f73.a);
        this.n = o60.d(this.mContext, w83.b);
        this.o = o60.d(this.mContext, w83.a);
        this.c.setOnClickListener(this);
        this.j.setOnClickListener(this);
        this.f.setOnClickListener(this);
        findViewById(f73.i).setOnClickListener(this);
        findViewById(f73.r).setOnClickListener(this);
        LinearLayout linearLayout = (LinearLayout) findViewById(f73.H);
        this.w = linearLayout;
        linearLayout.setOnClickListener(this);
        TextView textView = (TextView) findViewById(f73.m);
        this.k = textView;
        textView.setOnClickListener(this);
        this.x = (TextView) findViewById(f73.a0);
        this.y = findViewById(f73.F);
        this.z = findViewById(f73.P);
        this.A = findViewById(f73.G);
        this.B = (TextView) findViewById(f73.X);
        this.C = (TextView) findViewById(f73.Z);
        SeekBar seekBar = (SeekBar) findViewById(f73.L);
        this.v = seekBar;
        seekBar.setOnSeekBarChangeListener(new a());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (canClick()) {
            int id = view.getId();
            if (id == f73.c || id == f73.m || ((AbsActivity) this.mContext).e1()) {
                if (id == f73.l) {
                    H0();
                    return;
                }
                if (id == f73.i) {
                    G0();
                    return;
                }
                if (id == f73.r) {
                    K0();
                    return;
                }
                if (id == f73.o) {
                    J0();
                    return;
                }
                if (id == f73.c) {
                    F0();
                } else if (id == f73.m) {
                    I0();
                } else if (id == f73.H) {
                    L0();
                }
            }
        }
    }

    @Override // defpackage.b1
    public void release() {
        zh4.a(this.u);
        ValueAnimator valueAnimator = this.r;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ImageView imageView = this.j;
        if (imageView == null || this.p == null) {
            return;
        }
        imageView.clearAnimation();
    }

    public void s() {
        ImageView imageView = this.b;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        this.b.setVisibility(4);
    }
}
