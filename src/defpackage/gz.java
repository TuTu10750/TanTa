package defpackage;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;

/* loaded from: /tmp/classes2.dex */
public class gz extends l0 implements View.OnClickListener {
    public ScaleAnimation A0;
    public View B0;
    public View C0;
    public View D0;
    public View E0;
    public TextView F0;
    public String G0;
    public fz H0;
    public View z0;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                gz.this.w2();
            } else if (action == 1) {
                gz.this.x2();
            }
            return true;
        }
    }

    private void t2() {
        this.F0.setText("");
        if (this.E0.getVisibility() == 0) {
            this.E0.setVisibility(4);
        }
        if (this.D0.getVisibility() != 0) {
            this.D0.setVisibility(0);
        }
        if (this.C0.getVisibility() != 0) {
            this.C0.setVisibility(0);
        }
    }

    @Override // defpackage.l0
    public void C0() {
        this.H0 = null;
        super.C0();
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
        return w73.g;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == a73.k) {
            S1();
        } else if (id == a73.i) {
            t2();
        } else if (id == a73.y) {
            u2();
        }
    }

    @Override // defpackage.l0
    public void p2(Window window) {
        window.setWindowAnimations(s93.b);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = zn0.a(200);
        attributes.gravity = 80;
        window.setAttributes(attributes);
    }

    public void r0(Bundle bundle) {
        super.r0(bundle);
        this.z0 = this.y0.findViewById(a73.g);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.5f, 1.0f, 1.5f, 1, 0.5f, 1, 0.5f);
        this.A0 = scaleAnimation;
        scaleAnimation.setDuration(700L);
        this.A0.setRepeatCount(-1);
        View findViewById = this.y0.findViewById(a73.u);
        this.B0 = findViewById;
        findViewById.setOnTouchListener(new a());
        this.C0 = this.y0.findViewById(a73.n0);
        this.E0 = this.y0.findViewById(a73.J);
        this.F0 = (TextView) this.y0.findViewById(a73.G);
        View findViewById2 = this.y0.findViewById(a73.k);
        this.D0 = findViewById2;
        findViewById2.setOnClickListener(this);
        this.y0.findViewById(a73.i).setOnClickListener(this);
        this.y0.findViewById(a73.y).setOnClickListener(this);
        this.G0 = aq4.a(m93.D2);
    }

    public final void u2() {
        if (this.H0 != null) {
            this.H0.J0(this.F0.getText().toString().trim());
        }
        S1();
    }

    public void v2(fz fzVar) {
        this.H0 = fzVar;
    }

    public final void w2() {
        ScaleAnimation scaleAnimation;
        View view = this.z0;
        if (view != null && (scaleAnimation = this.A0) != null) {
            view.startAnimation(scaleAnimation);
        }
        this.F0.setText(this.G0);
        View view2 = this.C0;
        if (view2 != null && view2.getVisibility() == 0) {
            this.C0.setVisibility(4);
        }
        View view3 = this.D0;
        if (view3 == null || view3.getVisibility() != 0) {
            return;
        }
        this.D0.setVisibility(4);
    }

    public final void x2() {
        View view = this.z0;
        if (view != null) {
            view.clearAnimation();
        }
        if (this.G0.equals(this.F0.getText().toString().trim())) {
            t2();
        } else if (this.E0.getVisibility() != 0) {
            this.E0.setVisibility(0);
        }
    }
}
