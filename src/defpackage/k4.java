package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.umeng.analytics.pro.bv;
import com.umeng.commonsdk.statistics.UMErrorCode;
import com.yunbao.common.custom.LineProgress;
import com.yunbao.main.activity.ActivePubActivity;
import com.yunbao.main.utils.AudioRecorderEx;
import java.io.File;

/* loaded from: /tmp/classes2.dex */
public class k4 extends b1 implements View.OnClickListener {
    public ImageView a;
    public LineProgress b;
    public TextView c;
    public ImageView d;
    public TextView e;
    public View f;
    public View g;
    public View h;
    public String i;
    public String j;
    public Drawable k;
    public Drawable l;
    public Drawable[] m;
    public boolean n;
    public boolean o;
    public boolean p;
    public Handler q;
    public int r;
    public int s;
    public File t;
    public boolean u;
    public AudioRecorderEx v;

    /* loaded from: /tmp/classes2.dex */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                k4.this.q0();
            } else if (i == 1) {
                k4.this.r0();
            } else {
                if (i != 2) {
                    return;
                }
                k4.this.t0();
            }
        }
    }

    public k4(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    private void i0() {
        if (this.o) {
            n0();
        }
        if (this.n) {
            u0();
        }
        release();
        p0();
        removeFromParent();
    }

    private void p0() {
        this.n = false;
        this.o = false;
        this.p = false;
        this.r = 0;
        this.s = 0;
        LineProgress lineProgress = this.b;
        if (lineProgress != null) {
            lineProgress.setProgress(0);
        }
        TextView textView = this.c;
        if (textView != null) {
            textView.setText("0s");
        }
        View view = this.g;
        if (view != null && view.getVisibility() != 0) {
            this.g.setVisibility(0);
        }
        ImageView imageView = this.d;
        if (imageView != null) {
            imageView.setImageDrawable(this.m[0]);
        }
        ImageView imageView2 = this.a;
        if (imageView2 != null) {
            imageView2.setImageDrawable(this.k);
            if (this.a.getVisibility() == 0) {
                this.a.setVisibility(4);
            }
        }
        View view2 = this.h;
        if (view2 != null && view2.getVisibility() == 0) {
            this.h.setVisibility(4);
        }
        TextView textView2 = this.e;
        if (textView2 != null) {
            textView2.setText(this.i);
        }
        View view3 = this.f;
        if (view3 == null || view3.getVisibility() != 0) {
            return;
        }
        this.f.setVisibility(4);
    }

    @Override // defpackage.b1
    public void addToParent() {
        super.addToParent();
        this.u = true;
        this.v = AudioRecorderEx.d();
    }

    public final void e0() {
        int i = this.r;
        if (i == 0) {
            t54.a(m93.F0);
            return;
        }
        if (i < 8) {
            t54.a(m93.F2);
        }
        if (this.o) {
            n0();
        }
        this.t = this.v.f();
        w0();
    }

    public final void f0() {
        Handler handler = this.q;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        p0();
        AudioRecorderEx audioRecorderEx = this.v;
        if (audioRecorderEx != null) {
            audioRecorderEx.i();
            this.v.b();
        }
        File file = this.t;
        if (file == null || !file.exists()) {
            return;
        }
        this.t.delete();
    }

    public final void g0() {
        if (j10.a()) {
            if (this.n) {
                u0();
                return;
            }
            int i = this.r;
            if (i == 0) {
                t54.a(m93.F0);
                return;
            }
            if (i < 8) {
                t54.a(m93.F2);
                return;
            }
            if (this.o) {
                n0();
            }
            File f = this.v.f();
            this.t = f;
            if (f == null || !f.exists()) {
                t54.a(m93.F0);
            } else {
                o0();
            }
        }
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return y73.Z0;
    }

    public final void h0() {
        if (this.o) {
            n0();
        } else {
            s0();
        }
    }

    @Override // defpackage.b1
    public void init() {
        this.a = (ImageView) findViewById(c73.A0);
        this.b = (LineProgress) findViewById(c73.z3);
        this.c = (TextView) findViewById(c73.F4);
        this.d = (ImageView) findViewById(c73.f4);
        this.e = (TextView) findViewById(c73.g4);
        this.f = findViewById(c73.f0);
        this.i = aq4.a(m93.A0);
        this.j = aq4.a(m93.z0);
        this.k = o60.d(this.mContext, u83.j);
        this.l = o60.d(this.mContext, u83.i);
        Drawable[] drawableArr = new Drawable[2];
        this.m = drawableArr;
        drawableArr[0] = o60.d(this.mContext, u83.k);
        this.m[1] = o60.d(this.mContext, u83.l);
        findViewById(c73.N).setOnClickListener(this);
        View findViewById = findViewById(c73.c0);
        this.h = findViewById;
        findViewById.setOnClickListener(this);
        View findViewById2 = findViewById(c73.X0);
        this.g = findViewById2;
        findViewById2.setOnClickListener(this);
        this.f.setOnClickListener(this);
        this.a.setOnClickListener(this);
        this.q = new a();
    }

    public final long j0(int i) {
        long uptimeMillis = SystemClock.uptimeMillis();
        return i < 1000 ? uptimeMillis + i : i + uptimeMillis + ((-uptimeMillis) % 1000);
    }

    public boolean k0() {
        return this.u;
    }

    public void l0() {
        this.n = false;
        this.s = 0;
        Handler handler = this.q;
        if (handler != null) {
            handler.removeMessages(0);
        }
        LineProgress lineProgress = this.b;
        if (lineProgress != null) {
            lineProgress.setProgress(this.r);
        }
        TextView textView = this.c;
        if (textView != null) {
            textView.setText(rv3.a(String.valueOf(this.r / 2), bv.aB));
        }
        ImageView imageView = this.a;
        if (imageView != null) {
            imageView.setImageDrawable(this.k);
        }
        View view = this.g;
        if (view != null) {
            if (this.r == 120) {
                if (view.getVisibility() == 0) {
                    this.g.setVisibility(4);
                }
            } else if (view.getVisibility() != 0) {
                this.g.setVisibility(0);
            }
        }
        View view2 = this.f;
        if (view2 == null || view2.getVisibility() == 0) {
            return;
        }
        this.f.setVisibility(0);
    }

    public final void m0() {
        this.o = false;
        t54.a(m93.G0);
        v0();
        View view = this.g;
        if (view != null && view.getVisibility() == 0) {
            this.g.setVisibility(4);
        }
        ImageView imageView = this.d;
        if (imageView != null) {
            imageView.setImageDrawable(this.m[0]);
        }
        if (this.a.getVisibility() != 0) {
            this.a.setVisibility(0);
        }
        if (this.h.getVisibility() != 0) {
            this.h.setVisibility(0);
        }
        View view2 = this.f;
        if (view2 != null && view2.getVisibility() != 0) {
            this.f.setVisibility(0);
        }
        AudioRecorderEx audioRecorderEx = this.v;
        if (audioRecorderEx != null) {
            audioRecorderEx.l();
            this.v.i();
        }
    }

    public final void n0() {
        this.o = false;
        this.e.setText(this.i);
        Handler handler = this.q;
        if (handler != null) {
            handler.removeMessages(1);
        }
        if (this.a.getVisibility() != 0) {
            this.a.setVisibility(0);
        }
        if (this.h.getVisibility() != 0) {
            this.h.setVisibility(0);
        }
        View view = this.f;
        if (view != null && view.getVisibility() != 0) {
            this.f.setVisibility(0);
        }
        v0();
        AudioRecorderEx audioRecorderEx = this.v;
        if (audioRecorderEx != null) {
            audioRecorderEx.l();
            this.v.i();
        }
    }

    public final void o0() {
        this.n = true;
        this.s = 0;
        LineProgress lineProgress = this.b;
        if (lineProgress != null) {
            lineProgress.setProgress(0);
        }
        TextView textView = this.c;
        if (textView != null) {
            textView.setText("0s");
        }
        ImageView imageView = this.a;
        if (imageView != null) {
            imageView.setImageDrawable(this.l);
        }
        View view = this.g;
        if (view != null && view.getVisibility() == 0) {
            this.g.setVisibility(4);
        }
        View view2 = this.f;
        if (view2 != null && view2.getVisibility() == 0) {
            this.f.setVisibility(4);
        }
        Handler handler = this.q;
        if (handler != null) {
            handler.sendEmptyMessageAtTime(0, j0(500));
        }
        ((ActivePubActivity) this.mContext).h2(this.t);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == c73.N) {
            i0();
            return;
        }
        if (id == c73.c0) {
            e0();
            return;
        }
        if (id == c73.X0) {
            h0();
        } else if (id == c73.f0) {
            f0();
        } else if (id == c73.A0) {
            g0();
        }
    }

    @Override // defpackage.b1, defpackage.uy1
    public void onDestroy() {
        super.onDestroy();
        release();
        this.q = null;
    }

    public final void q0() {
        Handler handler;
        int i = this.s + 1;
        this.s = i;
        int i2 = this.r;
        if (i > i2) {
            this.s = i2;
        }
        LineProgress lineProgress = this.b;
        if (lineProgress != null) {
            lineProgress.setProgress(this.s);
        }
        TextView textView = this.c;
        if (textView != null) {
            textView.setText(rv3.a(String.valueOf(this.s / 2), bv.aB));
        }
        if (this.s >= this.r || (handler = this.q) == null) {
            return;
        }
        handler.sendEmptyMessageAtTime(0, j0(500));
    }

    public final void r0() {
        int i = this.r + 1;
        this.r = i;
        if (i > 120) {
            this.r = UMErrorCode.E_UM_BE_NOT_MAINPROCESS;
        }
        LineProgress lineProgress = this.b;
        if (lineProgress != null) {
            lineProgress.setProgress(this.r);
        }
        TextView textView = this.c;
        if (textView != null) {
            textView.setText(rv3.a(String.valueOf(this.r / 2), bv.aB));
        }
        if (this.r >= 120) {
            m0();
            return;
        }
        Handler handler = this.q;
        if (handler != null) {
            handler.sendEmptyMessageAtTime(1, j0(500));
        }
    }

    @Override // defpackage.b1
    public void release() {
        Handler handler = this.q;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        AudioRecorderEx audioRecorderEx = this.v;
        if (audioRecorderEx != null) {
            audioRecorderEx.h();
        }
        this.v = null;
    }

    @Override // defpackage.b1
    public void removeFromParent() {
        super.removeFromParent();
        this.u = false;
        AudioRecorderEx audioRecorderEx = this.v;
        if (audioRecorderEx != null) {
            audioRecorderEx.h();
        }
        this.v = null;
    }

    public final void s0() {
        if (this.n) {
            u0();
        }
        this.o = true;
        this.e.setText(this.j);
        Handler handler = this.q;
        if (handler != null) {
            handler.sendEmptyMessageAtTime(1, j0(500));
        }
        t0();
        if (this.a.getVisibility() == 0) {
            this.a.setVisibility(4);
        }
        if (this.h.getVisibility() == 0) {
            this.h.setVisibility(4);
        }
        View view = this.f;
        if (view != null && view.getVisibility() == 0) {
            this.f.setVisibility(4);
        }
        File file = new File(j30.L);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.v.j(new File(file, rv3.a(rv3.b(), ".mp3")).getAbsolutePath());
        this.v.g();
        this.v.k();
    }

    public final void t0() {
        boolean z = this.p;
        this.p = !z;
        ImageView imageView = this.d;
        Drawable[] drawableArr = this.m;
        imageView.setImageDrawable(!z ? drawableArr[1] : drawableArr[0]);
        Handler handler = this.q;
        if (handler != null) {
            handler.sendEmptyMessageAtTime(2, j0(200));
        }
    }

    public final void u0() {
        l0();
        ((ActivePubActivity) this.mContext).q2();
    }

    public final void v0() {
        Handler handler = this.q;
        if (handler != null) {
            handler.removeMessages(2);
        }
    }

    public final void w0() {
        ((ActivePubActivity) this.mContext).v2(this.t, this.r / 2);
        i0();
    }
}
