package com.yalantis.ucrop.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import defpackage.ba3;
import defpackage.bv2;
import defpackage.l83;
import defpackage.u63;
import defpackage.y70;

/* loaded from: /tmp/classes2.dex */
public class UCropView extends FrameLayout {
    public GestureCropImageView a;
    public final OverlayView b;

    /* loaded from: /tmp/classes2.dex */
    public class a implements y70 {
        public a() {
        }

        @Override // defpackage.y70
        public void a(float f) {
            UCropView.this.b.setTargetAspectRatio(f);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements bv2 {
        public b() {
        }

        @Override // defpackage.bv2
        public void a(RectF rectF) {
            UCropView.this.a.setCropRect(rectF);
        }
    }

    public UCropView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public UCropView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(l83.d, (ViewGroup) this, true);
        this.a = (GestureCropImageView) findViewById(u63.b);
        OverlayView overlayView = (OverlayView) findViewById(u63.y);
        this.b = overlayView;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ba3.Y);
        overlayView.g(obtainStyledAttributes);
        this.a.A(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        c();
    }

    public final void c() {
        this.a.setCropBoundsChangeListener(new a());
        this.b.setOverlayViewChangeListener(new b());
    }

    public GestureCropImageView getCropImageView() {
        return this.a;
    }

    public OverlayView getOverlayView() {
        return this.b;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
