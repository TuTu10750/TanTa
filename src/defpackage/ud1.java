package defpackage;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: /tmp/classes2.dex */
public final class ud1 extends RecyclerView.n {
    public final int a;
    public final int b;
    public final boolean c;

    public ud1(int i, int i2, boolean z) {
        this.a = i;
        this.b = i2;
        this.c = z;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
        rect.getClass();
        view.getClass();
        recyclerView.getClass();
        a0Var.getClass();
        int n0 = recyclerView.n0(view);
        int i = this.a;
        int i2 = n0 % i;
        boolean z = this.c;
        int i3 = this.b;
        if (z) {
            rect.left = i3 - ((i2 * i3) / i);
            rect.right = ((i2 + 1) * i3) / i;
            if (n0 < i) {
                rect.top = i3;
            }
            rect.bottom = i3;
            return;
        }
        rect.left = (i2 * i3) / i;
        rect.right = i3 - (((i2 + 1) * i3) / i);
        if (n0 >= i) {
            rect.top = i3;
        }
    }
}
