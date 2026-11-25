package defpackage;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.TypedValue;
import android.view.View;

/* loaded from: /tmp/classes2.dex */
public abstract class po3 {
    public static int a(Context context, float f) {
        return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    public static void b(Context context, View view, String str, float f, float f2, String str2, int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(i);
        if (str != null) {
            try {
                gradientDrawable.setColor(Color.parseColor(str));
            } catch (Exception unused) {
                gradientDrawable.setColor(0);
            }
        }
        if (f > 0.0f) {
            gradientDrawable.setCornerRadius(a(context, f));
        }
        if (f2 > 0.0f && !str2.isEmpty()) {
            try {
                gradientDrawable.setStroke(a(context, f2), Color.parseColor(str2));
            } catch (Exception unused2) {
                gradientDrawable.setStroke(a(context, f2), 0);
            }
        }
        view.setBackground(gradientDrawable);
    }
}
