package defpackage;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.im.dao.IMMessageBean;
import com.yunbao.live.activity.LiveAnchorActivity;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: /tmp/classes2.dex */
public class k02 extends t0 {
    public ImageView c;
    public View d;
    public View e;
    public boolean f;
    public View g;
    public int h;

    /* loaded from: /tmp/classes2.dex */
    public class a extends HttpCallback {
        public final /* synthetic */ boolean a;

        public a(boolean z) {
            this.a = z;
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i == 0) {
                k02.this.f = this.a;
            }
            t54.b(str);
        }
    }

    public k02(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    private void d0() {
        ((LiveAnchorActivity) this.mContext).g3();
    }

    private void g0() {
        ((LiveAnchorActivity) this.mContext).m3();
    }

    private void k0() {
        ((LiveAnchorActivity) this.mContext).L3();
    }

    public void e0() {
        boolean z = !this.f;
        e32.F0(z, new a(z));
    }

    public void f0() {
        this.h = 0;
        this.b.setText("");
        this.b.setVisibility(8);
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return x73.O1;
    }

    public boolean h0() {
        return this.f;
    }

    public void i0(boolean z) {
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

    @Override // defpackage.t0, defpackage.b1
    public void init() {
        super.init();
        ImageView imageView = (ImageView) findViewById(b73.c0);
        this.c = imageView;
        imageView.setOnClickListener(this);
        View findViewById = findViewById(b73.J);
        this.d = findViewById;
        findViewById.setOnClickListener(this);
        View findViewById2 = findViewById(b73.J0);
        this.e = findViewById2;
        findViewById2.setOnClickListener(this);
        this.b = (TextView) findViewById(b73.i4);
        View findViewById3 = findViewById(b73.r0);
        this.g = findViewById3;
        findViewById3.setOnClickListener(this);
    }

    public void j0(boolean z) {
        View view = this.e;
        if (view != null) {
            if (z) {
                if (view.getVisibility() != 0) {
                    this.e.setVisibility(0);
                }
            } else if (view.getVisibility() == 0) {
                this.e.setVisibility(4);
            }
        }
    }

    @Override // defpackage.t0, android.view.View.OnClickListener
    public void onClick(View view) {
        if (canClick()) {
            super.onClick(view);
            int id = view.getId();
            if (id == b73.c0) {
                k0();
                return;
            }
            if (id == b73.J) {
                g0();
            } else if (id == b73.J0) {
                d0();
            } else if (id == b73.r0) {
                ((LiveAnchorActivity) this.mContext).E3();
            }
        }
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onUpdateCurrentView(IMMessageBean iMMessageBean) {
        Log.i("9527", "onUpdateCurrentView44444444444");
        this.b.setVisibility(0);
        int i = this.h + 1;
        this.h = i;
        if (i > 99) {
            this.h = 99;
        }
        this.b.setText(this.h + "");
    }
}
