package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.live.activity.LiveActivity;

/* loaded from: /tmp/classes2.dex */
public abstract class t0 extends b1 implements View.OnClickListener {
    public TextView a;
    public TextView b;

    public t0(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    public void a0(String str) {
        if (this.a != null) {
            boolean equals = "0".equals(str);
            TextView textView = this.a;
            if (equals) {
                if (textView.getVisibility() == 0) {
                    this.a.setVisibility(4);
                }
            } else if (textView.getVisibility() != 0) {
                this.a.setVisibility(0);
            }
            this.a.setText(str);
        }
    }

    @Override // defpackage.b1
    public void init() {
        findViewById(b73.E).setOnClickListener(this);
        findViewById(b73.Y).setOnClickListener(this);
        findViewById(b73.D0).setOnClickListener(this);
        this.a = (TextView) findViewById(b73.D4);
        zu0.c().n(this);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == b73.D0) {
            if (((AbsActivity) this.mContext).e1()) {
                ((LiveActivity) this.mContext).T1();
            }
        } else if (id == b73.E) {
            if (((AbsActivity) this.mContext).e1()) {
                ((LiveActivity) this.mContext).V1(null);
            }
        } else if (id == b73.Y) {
            ((LiveActivity) this.mContext).W1(null, 1);
        }
    }

    @Override // defpackage.b1, defpackage.uy1
    public void onDestroy() {
        super.onDestroy();
        zu0.c().p(this);
    }
}
