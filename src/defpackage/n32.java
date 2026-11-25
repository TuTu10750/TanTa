package defpackage;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.PopupWindow;

/* loaded from: /tmp/classes2.dex */
public class n32 extends PopupWindow {
    public View a;
    public View b;
    public b c;

    /* loaded from: /tmp/classes2.dex */
    public class a implements PopupWindow.OnDismissListener {
        public a() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (n32.this.c != null) {
                n32.this.c.p();
            }
            ViewParent parent = n32.this.b.getParent();
            if (parent != null) {
                ((ViewGroup) parent).removeView(n32.this.b);
            }
            n32.this.b = null;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface b {
        void p();
    }

    public n32(View view, View view2, b bVar) {
        this.a = view;
        this.c = bVar;
        ViewParent parent = view2.getParent();
        if (parent != null) {
            ((ViewGroup) parent).removeView(view2);
        }
        this.b = view2;
        setContentView(view2);
        setWidth(-1);
        setHeight(-1);
        setBackgroundDrawable(new ColorDrawable());
        setOutsideTouchable(true);
        setFocusable(true);
        setAnimationStyle(s93.e);
        setOnDismissListener(new a());
    }

    public void d() {
        showAtLocation(this.a, 17, 0, 0);
    }
}
