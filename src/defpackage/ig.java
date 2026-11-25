package defpackage;

import android.content.Context;
import android.widget.Scroller;

/* loaded from: /tmp/classes2.dex */
public class ig extends Scroller {
    public int a;

    public ig(Context context) {
        super(context);
        this.a = 800;
    }

    public void a(int i) {
        this.a = i;
    }

    @Override // android.widget.Scroller
    public void startScroll(int i, int i2, int i3, int i4) {
        super.startScroll(i, i2, i3, i4, this.a);
    }

    @Override // android.widget.Scroller
    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        super.startScroll(i, i2, i3, i4, this.a);
    }
}
