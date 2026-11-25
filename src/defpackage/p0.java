package defpackage;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: /tmp/classes2.dex */
public abstract class p0 extends b1 {
    public boolean a;
    public boolean b;
    public Handler c;
    public View d;
    public View e;

    public p0(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    public void a0() {
        this.d.setVisibility(8);
    }

    public abstract void b0();

    public abstract void d0(String str);

    public abstract void e0();

    public abstract void f0(View.OnClickListener onClickListener);

    @Override // defpackage.b1
    public void init() {
        this.e = findViewById(b73.M3);
        this.d = findViewById(b73.K);
        this.c = new Handler();
    }

    @Override // defpackage.b1
    public abstract void release();
}
