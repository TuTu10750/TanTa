package defpackage;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.im.dao.IMMessageBean;
import com.yunbao.live.activity.LiveActivity;
import com.yunbao.live.activity.LiveAudienceActivity;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: /tmp/classes2.dex */
public class o02 extends t0 {
    public String c;
    public String d;
    public View e;
    public View f;
    public ScaleAnimation g;
    public View h;
    public int i;

    public o02(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    private void e0() {
        ((LiveActivity) this.mContext).l2();
    }

    public void b0() {
        View view = this.f;
        if (view != null) {
            view.clearAnimation();
        }
    }

    public void d0() {
        this.i = 0;
        this.b.setText("");
        this.b.setVisibility(8);
    }

    public void f0(boolean z) {
        View view = this.h;
        if (view != null) {
            if (!z) {
                if (view.getVisibility() != 8) {
                    this.h.setVisibility(8);
                }
            } else {
                if (j30.q().Q() || this.h.getVisibility() == 0) {
                    return;
                }
                this.h.setVisibility(0);
            }
        }
    }

    public void g0(String str, String str2) {
        this.c = str;
        this.d = str2;
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return x73.Q1;
    }

    public void h0(boolean z) {
        if (j30.q().Q()) {
            return;
        }
        if (!z) {
            View view = this.f;
            if (view != null) {
                view.clearAnimation();
            }
            View view2 = this.e;
            if (view2 == null || view2.getVisibility() == 8) {
                return;
            }
            this.e.setVisibility(8);
            return;
        }
        View view3 = this.e;
        if (view3 != null && view3.getVisibility() != 0) {
            this.e.setVisibility(0);
        }
        if (this.f != null) {
            if (this.g == null) {
                ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.8f, 1.0f, 0.8f, 1, 0.5f, 1, 0.5f);
                scaleAnimation.setDuration(500L);
                scaleAnimation.setRepeatCount(-1);
                scaleAnimation.setRepeatMode(2);
                this.g = scaleAnimation;
            }
            this.f.startAnimation(this.g);
        }
    }

    @Override // defpackage.t0, defpackage.b1
    public void init() {
        super.init();
        findViewById(b73.b1).setOnClickListener(this);
        findViewById(b73.c0).setOnClickListener(this);
        View findViewById = findViewById(b73.N0);
        View findViewById2 = findViewById(b73.j0);
        findViewById(b73.H).setOnClickListener(this);
        View findViewById3 = findViewById(b73.Z);
        this.b = (TextView) findViewById(b73.i4);
        View findViewById4 = findViewById(b73.d0);
        this.h = findViewById4;
        findViewById4.setOnClickListener(this);
        if (j30.q().Q()) {
            findViewById.setVisibility(8);
            findViewById2.setVisibility(8);
            findViewById3.setVisibility(8);
            findViewById(b73.s0).setVisibility(4);
        } else {
            findViewById3.setVisibility(8);
            findViewById.setOnClickListener(this);
            findViewById2.setOnClickListener(this);
            findViewById3.setOnClickListener(this);
        }
        View findViewById5 = findViewById(b73.k0);
        this.e = findViewById5;
        findViewById5.setOnClickListener(this);
        this.f = findViewById(b73.q2);
    }

    @Override // defpackage.t0, android.view.View.OnClickListener
    public void onClick(View view) {
        if (canClick()) {
            super.onClick(view);
            int id = view.getId();
            if (id == b73.b1) {
                if (((AbsActivity) this.mContext).e1()) {
                    e0();
                    return;
                }
                return;
            }
            if (id == b73.N0) {
                if (((AbsActivity) this.mContext).e1()) {
                    ((LiveActivity) this.mContext).k2();
                    return;
                }
                return;
            }
            if (id == b73.j0) {
                if (((AbsActivity) this.mContext).e1()) {
                    ((LiveActivity) this.mContext).a2();
                    return;
                }
                return;
            }
            if (id == b73.k0) {
                ((LiveAudienceActivity) this.mContext).P3();
                return;
            }
            if (id == b73.Z) {
                if (((AbsActivity) this.mContext).e1()) {
                    ((LiveAudienceActivity) this.mContext).O3();
                }
            } else {
                if (id == b73.c0) {
                    ((LiveAudienceActivity) this.mContext).d4();
                    return;
                }
                if (id == b73.d0) {
                    if (((AbsActivity) this.mContext).e1()) {
                        ((LiveAudienceActivity) this.mContext).openGame(this.h);
                    }
                } else if (id == b73.H) {
                    ((LiveAudienceActivity) this.mContext).E3();
                }
            }
        }
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onUpdateCurrentView(IMMessageBean iMMessageBean) {
        Log.i("9527", "onUpdateCurrentView44444444444");
        this.b.setVisibility(0);
        int i = this.i + 1;
        this.i = i;
        if (i > 99) {
            this.i = 99;
        }
        this.b.setText(this.i + "");
    }
}
