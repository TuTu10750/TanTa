package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;

/* loaded from: /tmp/classes2.dex */
public abstract class zc {
    public static void a(Context context, AttributeSet attributeSet, io1 io1Var) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ka3.f);
            int i = obtainStyledAttributes.getInt(ka3.h, 0);
            int i2 = obtainStyledAttributes.getInt(ka3.l, 0);
            int color = obtainStyledAttributes.getColor(ka3.i, Color.parseColor("#6C6D72"));
            int color2 = obtainStyledAttributes.getColor(ka3.j, Color.parseColor("#8C18171C"));
            int i3 = obtainStyledAttributes.getInt(ka3.g, 0);
            float dimension = obtainStyledAttributes.getDimension(ka3.k, jo1.a(8.0f));
            io1Var.n(color);
            io1Var.s(color2);
            io1Var.u(i3);
            io1Var.r(i2);
            io1Var.w(i);
            float f = dimension * 2.0f;
            io1Var.B(f, f);
            obtainStyledAttributes.recycle();
        }
    }
}
