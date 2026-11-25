package defpackage;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.yunbao.common.custom.RatingBar;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.mall.activity.PayContentDetailActivity;

/* loaded from: /tmp/classes2.dex */
public class ax2 extends l0 implements RatingBar.a, View.OnClickListener {
    public TextView A0;
    public int[] B0;
    public String C0;
    public RatingBar z0;

    /* loaded from: /tmp/classes2.dex */
    public class a extends HttpCallback {
        public a() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i == 0) {
                ((PayContentDetailActivity) ax2.this.x0).V1();
                ax2.this.S1();
            }
            t54.b(str);
        }
    }

    @Override // defpackage.l0
    public void C0() {
        ec2.u("commentPayContent");
        this.x0 = null;
        super.C0();
    }

    @Override // defpackage.l0
    public boolean f2() {
        return true;
    }

    @Override // defpackage.l0
    public int l2() {
        return s93.c;
    }

    @Override // defpackage.l0
    public int m2() {
        return z73.f0;
    }

    @Override // com.yunbao.common.custom.RatingBar.a
    public void o(int i, int i2) {
        TextView textView = this.A0;
        if (textView != null) {
            if (i == 0) {
                textView.setText((CharSequence) null);
            } else {
                textView.setText(this.B0[i - 1]);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int fillCount;
        if (TextUtils.isEmpty(this.C0) || (fillCount = this.z0.getFillCount()) == 0) {
            return;
        }
        ec2.w(this.C0, fillCount, new a());
    }

    @Override // defpackage.l0
    public void p2(Window window) {
        window.setWindowAnimations(s93.b);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = zn0.a(240);
        attributes.gravity = 80;
        window.setAttributes(attributes);
    }

    public void r0(Bundle bundle) {
        super.r0(bundle);
        Bundle z = z();
        if (z != null) {
            this.C0 = z.getString("mallGoodsId");
        }
        RatingBar ratingBar = (RatingBar) k2(d73.q3);
        this.z0 = ratingBar;
        ratingBar.setOnRatingChangedListener(this);
        this.A0 = (TextView) k2(d73.l4);
        this.B0 = new int[]{m93.W7, m93.X7, m93.Y7, m93.Z7, m93.a8};
        k2(d73.n1).setOnClickListener(this);
    }
}
