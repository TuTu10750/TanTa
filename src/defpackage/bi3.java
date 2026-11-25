package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.trtc.tuikit.common.R;
import com.trtc.tuikit.common.ui.PopupDialog;

/* loaded from: /tmp/classes2.dex */
public class bi3 extends PopupDialog {
    public bi3(Context context) {
        super(context, R.style.TUICommonBottomDialogTheme);
        k();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void h(bi3 bi3Var, View view) {
        bi3Var.dismiss();
        new v5(bi3Var.getContext()).show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void i(bi3 bi3Var, View view) {
        bi3Var.dismiss();
        new oj(bi3Var.getContext()).show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void j(bi3 bi3Var, View view) {
        bi3Var.dismiss();
        new dp3(bi3Var.getContext()).show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void k() {
        View inflate = LayoutInflater.from(getContext()).inflate(x73.X, (ViewGroup) null);
        inflate.findViewById(b73.t).setOnClickListener(new View.OnClickListener() { // from class: yh3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                bi3.h(bi3.this, view);
            }
        });
        inflate.findViewById(b73.l1).setOnClickListener(new View.OnClickListener() { // from class: zh3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                bi3.j(bi3.this, view);
            }
        });
        inflate.findViewById(b73.k1).setOnClickListener(new View.OnClickListener() { // from class: ai3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                bi3.i(bi3.this, view);
            }
        });
        setView(inflate);
    }
}
