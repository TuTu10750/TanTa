package defpackage;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import java.lang.ref.WeakReference;

/* loaded from: /tmp/classes2.dex */
public abstract class l0 extends jm0 {
    public Context x0;
    public View y0;

    /* loaded from: /tmp/classes2.dex */
    public class a extends Dialog {
        public a(Context context, int i) {
            super(context, i);
        }

        @Override // android.app.Dialog
        public void onRestoreInstanceState(Bundle bundle) {
            try {
                super.onRestoreInstanceState(bundle);
            } catch (ClassCastException e) {
                if (!l0.this.n2(e)) {
                    throw e;
                }
                lx1.c(l0.this.getClass().getSimpleName(), "ignore bad dialog view saved state restore--->" + e.getMessage());
            }
        }
    }

    public void C0() {
        lx1.c(getClass().getSimpleName(), "onDestroy----销毁--->");
        super/*androidx.fragment.app.Fragment*/.C0();
    }

    public void U0() {
        try {
            super.U0();
        } catch (IllegalStateException e) {
            if (!o2(e)) {
                throw e;
            }
            lx1.c(getClass().getSimpleName(), "skip dialog show because window count is over max");
            j2();
        }
    }

    public Dialog X1(Bundle bundle) {
        i2(bundle);
        Context context = (Context) new WeakReference(v()).get();
        this.x0 = context;
        this.y0 = LayoutInflater.from(context).inflate(m2(), (ViewGroup) null);
        a aVar = new a(this.x0, l2());
        aVar.setContentView(this.y0);
        aVar.setCancelable(f2());
        aVar.setCanceledOnTouchOutside(f2());
        p2(aVar.getWindow());
        return aVar;
    }

    public void d2(k61 k61Var, String str) {
        if (h2(k61Var, str)) {
            try {
                super.d2(k61Var, str);
            } catch (IllegalStateException e) {
                lx1.c(getClass().getSimpleName(), "skip show after FragmentManager invalid--->" + e.getMessage());
            }
        }
    }

    public abstract boolean f2();

    public boolean g2() {
        return j10.a();
    }

    public final boolean h2(k61 k61Var, String str) {
        if (k61Var == null) {
            return false;
        }
        if (!k61Var.G0()) {
            return true;
        }
        lx1.c(getClass().getSimpleName(), "skip show " + str + " after FragmentManager destroyed");
        return false;
    }

    public final void i2(Bundle bundle) {
        if (bundle == null || !bundle.containsKey("android:savedDialogState")) {
            return;
        }
        bundle.remove("android:savedDialogState");
        lx1.c(getClass().getSimpleName(), "remove saved dialog state to avoid bad view state restore");
    }

    public final void j2() {
        try {
            T1();
        } catch (RuntimeException e) {
            lx1.c(getClass().getSimpleName(), "dismiss after window limit failed--->" + e.getMessage());
        }
    }

    public View k2(int i) {
        View view = this.y0;
        if (view != null) {
            return view.findViewById(i);
        }
        return null;
    }

    public abstract int l2();

    public abstract int m2();

    public final boolean n2(ClassCastException classCastException) {
        String message = classCastException != null ? classCastException.getMessage() : null;
        if (message == null || !message.contains("SavedState")) {
            return false;
        }
        return message.contains("AbsSavedState") || message.contains("CompoundButton$SavedState");
    }

    public final boolean o2(IllegalStateException illegalStateException) {
        String message = illegalStateException != null ? illegalStateException.getMessage() : null;
        return message != null && message.contains("window count is over max");
    }

    public abstract void p2(Window window);

    public void q2(k61 k61Var, String str) {
        if (h2(k61Var, str)) {
            try {
                s61 o = k61Var.o();
                o.d(this, str);
                o.g();
            } catch (IllegalStateException e) {
                lx1.c(getClass().getSimpleName(), "skip showAllowingStateLoss after FragmentManager invalid--->" + e.getMessage());
            }
        }
    }

    public void x0(Bundle bundle) {
        i2(bundle);
        super.x0(bundle);
    }
}
