package com.yunbao.main.custom;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;

/* loaded from: /tmp/classes2.dex */
public class ActiveLikeImage extends AppCompatImageView {
    public Drawable[] d;
    public boolean e;
    public Runnable f;
    public int g;

    /* loaded from: /tmp/classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        /* JADX WARN: Type inference failed for: r3v1, types: [android.view.View, com.yunbao.main.custom.ActiveLikeImage] */
        @Override // java.lang.Runnable
        public void run() {
            ActiveLikeImage.d(ActiveLikeImage.this);
            if (ActiveLikeImage.this.g < ActiveLikeImage.this.d.length) {
                ActiveLikeImage activeLikeImage = ActiveLikeImage.this;
                activeLikeImage.setImageDrawable(activeLikeImage.d[ActiveLikeImage.this.g]);
                ?? r3 = ActiveLikeImage.this;
                r3.postDelayed(r3.f, 70L);
            }
        }
    }

    public ActiveLikeImage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public static /* synthetic */ int d(ActiveLikeImage activeLikeImage) {
        int i = activeLikeImage.g;
        activeLikeImage.g = i + 1;
        return i;
    }

    private void h() {
        if (this.d != null) {
            this.g = 0;
            if (this.f == null) {
                this.f = new a();
            }
            this.f.run();
        }
    }

    public void g(boolean z, boolean z2) {
        if (this.e == z) {
            return;
        }
        this.e = z;
        Drawable[] drawableArr = this.d;
        if (drawableArr == null || drawableArr.length <= 0) {
            return;
        }
        if (!z) {
            setImageDrawable(drawableArr[0]);
        } else if (z2) {
            h();
        } else {
            setImageDrawable(drawableArr[drawableArr.length - 1]);
        }
    }

    public void setDrawables(Drawable[] drawableArr) {
        this.d = drawableArr;
    }
}
