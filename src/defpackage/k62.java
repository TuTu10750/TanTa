package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.live.activity.LiveActivity;
import com.yunbao.live.activity.LiveAnchorActivity;

/* loaded from: /tmp/classes2.dex */
public class k62 extends t0 {
    public ImageView c;
    public View d;

    public k62(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    private void d0() {
        ((LiveAnchorActivity) this.mContext).L3();
    }

    public void b0(boolean z) {
        View view = this.d;
        if (view != null) {
            if (z) {
                if (view.getVisibility() != 0) {
                    this.d.setVisibility(0);
                }
            } else if (view.getVisibility() == 0) {
                this.d.setVisibility(4);
            }
        }
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return x73.P1;
    }

    @Override // defpackage.t0, defpackage.b1
    public void init() {
        super.init();
        ImageView imageView = (ImageView) findViewById(b73.c0);
        this.c = imageView;
        imageView.setOnClickListener(this);
        findViewById(b73.j0).setOnClickListener(this);
        findViewById(b73.A0).setOnClickListener(this);
        findViewById(b73.B0).setOnClickListener(this);
        this.d = findViewById(b73.h5);
    }

    @Override // defpackage.t0, android.view.View.OnClickListener
    public void onClick(View view) {
        if (canClick()) {
            super.onClick(view);
            int id = view.getId();
            if (id == b73.c0) {
                if (((AbsActivity) this.mContext).e1()) {
                    d0();
                    return;
                }
                return;
            }
            if (id == b73.j0) {
                if (((AbsActivity) this.mContext).e1()) {
                    ((LiveActivity) this.mContext).a2();
                }
            } else {
                if (id == b73.A0) {
                    if (((AbsActivity) this.mContext).e1()) {
                        ((LiveActivity) this.mContext).D2();
                        b0(false);
                        return;
                    }
                    return;
                }
                if (id == b73.B0 && ((AbsActivity) this.mContext).e1()) {
                    ((LiveAnchorActivity) this.mContext).o3();
                }
            }
        }
    }
}
