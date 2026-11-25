package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.yunbao.mall.activity.PayContentPubActivity;
import com.yunbao.mall.bean.PayContentVideoBean;

/* loaded from: /tmp/classes2.dex */
public class hx2 extends k0 implements View.OnClickListener {
    public ImageView b;
    public View c;
    public PayContentVideoBean d;

    public hx2(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    public final void a0() {
        PayContentVideoBean payContentVideoBean = this.d;
        if (payContentVideoBean != null) {
            payContentVideoBean.clear();
        }
        ImageView imageView = this.b;
        if (imageView != null) {
            imageView.setImageDrawable(null);
        }
        View view = this.c;
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        this.c.setVisibility(4);
    }

    public PayContentVideoBean b0() {
        return this.d;
    }

    public void d0(String str, String str2) {
        if (this.d == null) {
            this.d = new PayContentVideoBean();
        }
        this.d.setFilePath(str);
        this.d.setDuration(str2);
        ImageView imageView = this.b;
        if (imageView != null) {
            kn1.o(this.mContext, str, imageView);
        }
        View view = this.c;
        if (view == null || view.getVisibility() == 0) {
            return;
        }
        this.c.setVisibility(0);
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return z73.V1;
    }

    @Override // defpackage.b1
    public void init() {
        this.b = (ImageView) findViewById(d73.x2);
        this.c = findViewById(d73.i0);
        findViewById(d73.p1).setOnClickListener(this);
        this.c.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == d73.i0) {
            a0();
        } else if (id == d73.p1) {
            ((PayContentPubActivity) this.mContext).I1();
        }
    }
}
