package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.live.activity.LiveActivity;
import com.yunbao.live.activity.LiveAudienceActivity;

/* loaded from: /tmp/classes2.dex */
public class n62 extends t0 {
    public ImageView c;
    public ImageView d;
    public ImageView e;
    public Drawable f;
    public Drawable g;
    public View h;
    public Drawable i;
    public Drawable j;
    public boolean k;
    public View l;

    public n62(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    private void f0() {
        ((LiveAudienceActivity) this.mContext).e4(this.k);
    }

    public void b0(boolean z) {
        this.k = z;
        e0(false);
        ImageView imageView = this.d;
        if (imageView != null) {
            imageView.setImageDrawable(z ? this.g : this.f);
        }
        View view = this.h;
        if (view != null) {
            if (z) {
                if (view.getVisibility() != 0) {
                    this.h.setVisibility(0);
                }
            } else if (view.getVisibility() != 8) {
                this.h.setVisibility(8);
            }
        }
    }

    public void d0(boolean z) {
        View view = this.l;
        if (view != null) {
            if (!z) {
                if (view.getVisibility() != 8) {
                    this.l.setVisibility(8);
                }
            } else {
                if (j30.q().Q() || this.l.getVisibility() == 0) {
                    return;
                }
                this.l.setVisibility(0);
            }
        }
    }

    public void e0(boolean z) {
        ImageView imageView = this.e;
        if (imageView != null) {
            imageView.setImageDrawable(z ? this.j : this.i);
        }
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return x73.R1;
    }

    @Override // defpackage.t0, defpackage.b1
    public void init() {
        super.init();
        this.f = o60.d(this.mContext, t83.R0);
        this.g = o60.d(this.mContext, t83.Q0);
        this.i = o60.d(this.mContext, t83.p0);
        this.j = o60.d(this.mContext, t83.o0);
        ImageView imageView = (ImageView) findViewById(b73.c0);
        this.c = imageView;
        imageView.setOnClickListener(this);
        this.d = (ImageView) findViewById(b73.p0);
        ImageView imageView2 = (ImageView) findViewById(b73.z0);
        this.e = imageView2;
        imageView2.setOnClickListener(this);
        this.h = findViewById(b73.C2);
        findViewById(b73.Y).setOnClickListener(this);
        View findViewById = findViewById(b73.j0);
        View findViewById2 = findViewById(b73.Z);
        View findViewById3 = findViewById(b73.d0);
        this.l = findViewById3;
        findViewById3.setOnClickListener(this);
        if (j30.q().Q()) {
            findViewById.setVisibility(8);
            findViewById2.setVisibility(8);
            this.d.setVisibility(8);
        } else {
            findViewById.setOnClickListener(this);
            findViewById2.setOnClickListener(this);
            this.d.setOnClickListener(this);
        }
    }

    @Override // defpackage.t0, android.view.View.OnClickListener
    public void onClick(View view) {
        if (canClick()) {
            super.onClick(view);
            int id = view.getId();
            if (id == b73.p0) {
                if (((AbsActivity) this.mContext).e1()) {
                    ((LiveAudienceActivity) this.mContext).A3();
                    return;
                }
                return;
            }
            if (id == b73.z0) {
                if (((AbsActivity) this.mContext).e1()) {
                    ((LiveActivity) this.mContext).x1(j30.q().C());
                    return;
                }
                return;
            }
            if (id == b73.Y) {
                if (((AbsActivity) this.mContext).e1()) {
                    ((LiveAudienceActivity) this.mContext).S3();
                    return;
                }
                return;
            }
            if (id == b73.j0) {
                if (((AbsActivity) this.mContext).e1()) {
                    ((LiveActivity) this.mContext).a2();
                }
            } else if (id == b73.c0) {
                if (((AbsActivity) this.mContext).e1()) {
                    f0();
                }
            } else if (id == b73.Z) {
                if (((AbsActivity) this.mContext).e1()) {
                    ((LiveAudienceActivity) this.mContext).O3();
                }
            } else if (id == b73.d0 && ((AbsActivity) this.mContext).e1()) {
                ((LiveAudienceActivity) this.mContext).openGame(this.l);
            }
        }
    }
}
