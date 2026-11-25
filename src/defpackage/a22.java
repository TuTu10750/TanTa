package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import com.yunbao.common.http.CommonHttpConsts;
import com.yunbao.common.http.CommonHttpUtil;
import com.yunbao.live.bean.LiveEnterRoomBean;
import java.io.File;
import java.util.concurrent.ConcurrentLinkedQueue;
import pl.droidsonroids.gif.GifImageView;

/* loaded from: /tmp/classes2.dex */
public class a22 {
    public Context a;
    public View b;
    public View c;
    public ImageView d;
    public TextView e;
    public View f;
    public GifImageView g;
    public pl.droidsonroids.gif.a h;
    public TextView i;
    public MediaController j;
    public ObjectAnimator k;
    public ObjectAnimator l;
    public ObjectAnimator m;
    public ObjectAnimator n;
    public ObjectAnimator o;
    public ObjectAnimator p;
    public Animation q;
    public boolean s;
    public Handler u;
    public int v;
    public k30 w;
    public boolean x;
    public boolean y;
    public int r = zn0.a(500);
    public ConcurrentLinkedQueue t = new ConcurrentLinkedQueue();

    /* loaded from: /tmp/classes2.dex */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a22.this.l.start();
            a22.this.o.start();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a22.this.f.startAnimation(a22.this.q);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends AnimatorListenerAdapter {
        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a22.this.b.setTranslationX(a22.this.r);
            a22.this.c.setTranslationX(-a22.this.r);
            if (a22.this.x) {
                return;
            }
            a22.this.s();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d implements Animation.AnimationListener {
        public d() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            a22.this.m.start();
            a22.this.p.start();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e extends Handler {
        public e() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a22.this.x = false;
            if (a22.this.i != null) {
                a22.this.i.setText("");
            }
            if (a22.this.j != null) {
                a22.this.j.hide();
            }
            if (a22.this.g != null) {
                a22.this.g.setImageDrawable(null);
            }
            if (a22.this.h != null && !a22.this.h.e()) {
                a22.this.h.stop();
                a22.this.h.f();
            }
            a22.this.s();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class f extends k30 {
        public f() {
        }

        @Override // defpackage.k30
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(File file) {
            if (file != null) {
                a22.this.t(file);
            }
        }
    }

    public a22(Context context, View view) {
        this.a = context;
        this.b = view.findViewById(b73.s3);
        this.c = view.findViewById(b73.u3);
        this.d = (ImageView) view.findViewById(b73.r3);
        this.e = (TextView) view.findViewById(b73.t3);
        this.f = view.findViewById(b73.Y4);
        this.g = (GifImageView) view.findViewById(b73.U1);
        this.i = (TextView) view.findViewById(b73.V1);
        AccelerateDecelerateInterpolator accelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.b, "translationX", zn0.a(70));
        this.k = ofFloat;
        ofFloat.setDuration(1000L);
        this.k.setInterpolator(accelerateDecelerateInterpolator);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.b, "translationX", 0.0f);
        this.l = ofFloat2;
        ofFloat2.setDuration(700L);
        this.l.setInterpolator(linearInterpolator);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.b, "translationX", -this.r);
        this.m = ofFloat3;
        ofFloat3.setDuration(300L);
        this.m.setInterpolator(accelerateInterpolator);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.c, "translationX", zn0.a(70));
        this.n = ofFloat4;
        ofFloat4.setDuration(1000L);
        this.n.setInterpolator(accelerateDecelerateInterpolator);
        this.n.addListener(new a());
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.c, "translationX", 0.0f);
        this.o = ofFloat5;
        ofFloat5.setDuration(700L);
        this.o.setInterpolator(linearInterpolator);
        this.o.addListener(new b());
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.c, "translationX", this.r);
        this.p = ofFloat6;
        ofFloat6.setDuration(450L);
        this.p.setInterpolator(accelerateInterpolator);
        this.p.addListener(new c());
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.q = rotateAnimation;
        rotateAnimation.setDuration(1500L);
        this.q.setInterpolator(linearInterpolator);
        this.q.setAnimationListener(new d());
        this.v = gk3.a().c();
        this.u = new e();
        this.w = new f();
    }

    public void r() {
        CommonHttpUtil.cancel(CommonHttpConsts.DOWNLOAD_GIF);
        Handler handler = this.u;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        ObjectAnimator objectAnimator = this.k;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        ObjectAnimator objectAnimator2 = this.l;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
        }
        ObjectAnimator objectAnimator3 = this.m;
        if (objectAnimator3 != null) {
            objectAnimator3.cancel();
        }
        ObjectAnimator objectAnimator4 = this.n;
        if (objectAnimator4 != null) {
            objectAnimator4.cancel();
        }
        ObjectAnimator objectAnimator5 = this.o;
        if (objectAnimator5 != null) {
            objectAnimator5.cancel();
        }
        ObjectAnimator objectAnimator6 = this.p;
        if (objectAnimator6 != null) {
            objectAnimator6.cancel();
        }
        View view = this.f;
        if (view != null) {
            view.clearAnimation();
        }
        ConcurrentLinkedQueue concurrentLinkedQueue = this.t;
        if (concurrentLinkedQueue != null) {
            concurrentLinkedQueue.clear();
        }
        MediaController mediaController = this.j;
        if (mediaController != null) {
            mediaController.hide();
            this.j.setAnchorView(null);
        }
        GifImageView gifImageView = this.g;
        if (gifImageView != null) {
            gifImageView.setImageDrawable(null);
        }
        TextView textView = this.i;
        if (textView != null) {
            textView.setText("");
        }
        pl.droidsonroids.gif.a aVar = this.h;
        if (aVar != null && !aVar.e()) {
            this.h.stop();
            this.h.f();
            this.h = null;
        }
        this.s = false;
    }

    public final void s() {
        ConcurrentLinkedQueue concurrentLinkedQueue = this.t;
        if (concurrentLinkedQueue == null) {
            return;
        }
        LiveEnterRoomBean liveEnterRoomBean = (LiveEnterRoomBean) concurrentLinkedQueue.poll();
        if (liveEnterRoomBean == null) {
            this.s = false;
        } else {
            x(liveEnterRoomBean);
        }
    }

    public final void t(File file) {
        if (this.y) {
            return;
        }
        try {
            pl.droidsonroids.gif.a aVar = new pl.droidsonroids.gif.a(file);
            this.h = aVar;
            aVar.i(1);
            w(this.h);
            this.g.setImageDrawable(this.h);
            if (this.j == null) {
                MediaController mediaController = new MediaController(this.a);
                this.j = mediaController;
                mediaController.setVisibility(8);
            }
            this.j.setMediaPlayer((pl.droidsonroids.gif.a) this.g.getDrawable());
            this.j.setAnchorView(this.g);
            int duration = this.h.getDuration();
            this.j.show(duration);
            if (duration < 4000) {
                duration = 4000;
            }
            Handler handler = this.u;
            if (handler != null) {
                handler.sendEmptyMessageDelayed(0, duration);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            Handler handler2 = this.u;
            if (handler2 != null) {
                handler2.sendEmptyMessageDelayed(0, 4000L);
            }
        }
    }

    public void u() {
        this.y = true;
        r();
        this.w = null;
        this.u = null;
    }

    public void v() {
        View view = this.b;
        if (view != null) {
            view.setTranslationX(this.r);
        }
        View view2 = this.c;
        if (view2 != null) {
            view2.setTranslationX(-this.r);
        }
        ImageView imageView = this.d;
        if (imageView != null) {
            imageView.setImageDrawable(null);
        }
        TextView textView = this.e;
        if (textView != null) {
            textView.setText("");
        }
    }

    public final void w(Drawable drawable) {
        float intrinsicWidth = drawable.getIntrinsicWidth();
        float intrinsicHeight = drawable.getIntrinsicHeight();
        ViewGroup.LayoutParams layoutParams = this.g.getLayoutParams();
        layoutParams.height = (int) ((this.v * intrinsicHeight) / intrinsicWidth);
        this.g.setLayoutParams(layoutParams);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void x(com.yunbao.live.bean.LiveEnterRoomBean r6) {
        /*
            r5 = this;
            com.yunbao.live.bean.LiveUserGiftBean r0 = r6.getUserBean()
            com.yunbao.live.bean.LiveChatBean r1 = r6.getLiveChatBean()
            if (r0 == 0) goto L83
            if (r1 == 0) goto L83
            r2 = 1
            r5.s = r2
            int r3 = r0.getVipType()
            if (r3 != 0) goto L1e
            int r3 = r1.getGuardType()
            if (r3 == 0) goto L1c
            goto L1e
        L1c:
            r6 = 0
            goto L3f
        L1e:
            android.content.Context r3 = r5.a
            com.yunbao.live.bean.LiveUserGiftBean r6 = r6.getUserBean()
            java.lang.String r6 = r6.getAvatar()
            android.widget.ImageView r4 = r5.d
            defpackage.kn1.g(r3, r6, r4)
            android.content.Context r6 = r5.a
            android.widget.TextView r3 = r5.e
            defpackage.n52.c(r6, r3, r1)
            android.animation.ObjectAnimator r6 = r5.k
            r6.start()
            android.animation.ObjectAnimator r6 = r5.n
            r6.start()
            r6 = r2
        L3f:
            com.yunbao.common.bean.UserBean$Car r1 = r0.getCar()
            if (r1 == 0) goto L7d
            int r3 = r1.getId()
            if (r3 == 0) goto L7d
            java.lang.String r3 = r1.getSwf()
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto L7d
            r5.x = r2
            android.widget.TextView r6 = r5.i
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r0 = r0.getUserNiceName()
            r4.append(r0)
            java.lang.String r0 = r1.getWords()
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            r6.setText(r0)
            java.lang.String r6 = defpackage.fa2.a(r3)
            k30 r0 = r5.w
            defpackage.tb1.a(r6, r3, r0)
            goto L7e
        L7d:
            r2 = r6
        L7e:
            if (r2 != 0) goto L83
            r5.s()
        L83:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.a22.x(com.yunbao.live.bean.LiveEnterRoomBean):void");
    }
}
