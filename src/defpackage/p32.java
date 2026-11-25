package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: /tmp/classes2.dex */
public class p32 extends p0 {
    public p32(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    @Override // defpackage.p0
    public void b0() {
    }

    @Override // defpackage.p0
    public void d0(String str) {
    }

    @Override // defpackage.p0
    public void e0() {
    }

    @Override // defpackage.p0
    public void f0(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.d.setVisibility(0);
            this.d.setOnClickListener(onClickListener);
        }
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return x73.K1;
    }

    @Override // defpackage.p0, defpackage.b1
    public void init() {
        this.d = findViewById(b73.K);
    }

    @Override // defpackage.p0, defpackage.b1
    public void release() {
    }
}
