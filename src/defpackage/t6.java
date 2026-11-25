package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.trtc.tuikit.common.R;
import com.trtc.tuikit.common.ui.PopupDialog;

/* loaded from: /tmp/classes2.dex */
public final class t6 extends PopupDialog {
    public LinearLayout a;
    public k30 b;
    public Context c;

    /* JADX WARN: Multi-variable type inference failed */
    public t6(Context context, k30 k30Var) {
        super(context, R.style.TUICommonBottomDialogTheme);
        this.b = k30Var;
        this.c = context;
        setView(getLayoutInflater().inflate(u73.N, (ViewGroup) null));
    }

    public static /* synthetic */ void i(t6 t6Var, Integer num, View view) {
        k30 k30Var = t6Var.b;
        if (k30Var != null) {
            k30Var.a(num);
        }
        t6Var.dismiss();
    }

    public void dismiss() {
        super/*p9*/.dismiss();
        k30 k30Var = this.b;
        if (k30Var != null) {
            k30Var.a(-1);
        }
    }

    public final TextView j() {
        TextView textView = new TextView(this.c);
        textView.setTextColor(-14539218);
        textView.setTextSize(16.0f);
        textView.setGravity(17);
        this.a.addView(textView, new LinearLayout.LayoutParams(-1, zn0.a(56)));
        k();
        return textView;
    }

    public final void k() {
        View view = new View(this.c);
        view.setBackgroundColor(-854532);
        this.a.addView(view, new LinearLayout.LayoutParams(-1, zn0.a(1)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.trtc.tuikit.common.ui.PopupDialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = (LinearLayout) findViewById(y63.P);
        TextView textView = (TextView) findViewById(y63.j0);
        textView.setText(getContext().getString(m93.q1));
        textView.setOnClickListener(new View.OnClickListener() { // from class: r6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                t6.this.dismiss();
            }
        });
        j().setText("请选择PK时长");
        for (final Integer num : j30.q().h().getLive_pk_time()) {
            TextView j = j();
            j.setText(num + "秒");
            j.setOnClickListener(new View.OnClickListener() { // from class: s6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    t6.i(t6.this, num, view);
                }
            });
        }
    }
}
