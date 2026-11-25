package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.trtc.tuikit.common.R;
import com.trtc.tuikit.common.ui.PopupDialog;

/* loaded from: /tmp/classes2.dex */
public class ji4 extends PopupDialog {
    public k30 a;

    public ji4(Context context) {
        super(context, R.style.TUICommonBottomDialogTheme);
        j();
    }

    public static /* synthetic */ void h(ji4 ji4Var, View view) {
        ji4Var.a.a(1080);
        t54.b("直播视频质量切换为1080p");
        ji4Var.dismiss();
    }

    public static /* synthetic */ void i(ji4 ji4Var, View view) {
        ji4Var.a.a(720);
        t54.b("直播视频质量切换为720p");
        ji4Var.dismiss();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void j() {
        View inflate = LayoutInflater.from(getContext()).inflate(x73.R, (ViewGroup) null);
        inflate.findViewById(b73.q).setOnClickListener(new View.OnClickListener() { // from class: hi4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ji4.i(ji4.this, view);
            }
        });
        inflate.findViewById(b73.n).setOnClickListener(new View.OnClickListener() { // from class: ii4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ji4.h(ji4.this, view);
            }
        });
        setView(inflate);
    }

    public void k(k30 k30Var) {
        this.a = k30Var;
    }
}
