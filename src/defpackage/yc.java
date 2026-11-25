package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;

/* loaded from: /tmp/classes2.dex */
public class yc {
    public final hg a;

    public yc(hg hgVar) {
        this.a = hgVar;
    }

    public void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ja3.a);
            b(obtainStyledAttributes);
            c(obtainStyledAttributes);
            obtainStyledAttributes.recycle();
        }
    }

    public final void b(TypedArray typedArray) {
        int integer = typedArray.getInteger(ja3.k, 3000);
        boolean z = typedArray.getBoolean(ja3.b, true);
        boolean z2 = typedArray.getBoolean(ja3.c, true);
        int dimension = (int) typedArray.getDimension(ja3.l, 0.0f);
        int dimension2 = (int) typedArray.getDimension(ja3.o, 0.0f);
        int dimension3 = (int) typedArray.getDimension(ja3.n, -1000.0f);
        int i = typedArray.getInt(ja3.m, 0);
        int i2 = typedArray.getInt(ja3.p, 0);
        this.a.F(integer);
        this.a.v(z);
        this.a.w(z2);
        this.a.H(dimension);
        this.a.L(dimension2);
        this.a.K(dimension3);
        this.a.G(dimension3);
        this.a.J(i);
        this.a.M(i2);
    }

    public final void c(TypedArray typedArray) {
        int color = typedArray.getColor(ja3.d, Color.parseColor("#8C18171C"));
        int color2 = typedArray.getColor(ja3.f, Color.parseColor("#8C6C6D72"));
        int dimension = (int) typedArray.getDimension(ja3.g, jg.a(8.0f));
        int i = typedArray.getInt(ja3.e, 0);
        int i2 = typedArray.getInt(ja3.i, 0);
        int i3 = typedArray.getInt(ja3.h, 0);
        int i4 = typedArray.getInt(ja3.j, 0);
        this.a.B(color2, color);
        this.a.C(dimension, dimension);
        this.a.y(i);
        this.a.D(i2);
        this.a.A(i3);
        this.a.E(i4);
        this.a.x(dimension);
        this.a.z(dimension / 2);
    }
}
