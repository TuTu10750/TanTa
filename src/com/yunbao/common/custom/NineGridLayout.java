package com.yunbao.common.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.makeramen.roundedimageview.RoundedImageView;
import defpackage.da3;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class NineGridLayout extends FrameLayout {
    public Context a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public List g;
    public b h;
    public FrameLayout.LayoutParams i;
    public FrameLayout.LayoutParams j;
    public FrameLayout.LayoutParams k;
    public FrameLayout.LayoutParams[] l;
    public View.OnClickListener m;
    public List n;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (NineGridLayout.this.h != null) {
                int size = NineGridLayout.this.g.size();
                for (int i = 0; i < size; i++) {
                    if (view == NineGridLayout.this.g.get(i)) {
                        NineGridLayout.this.h.b(NineGridLayout.this.n, i);
                        return;
                    }
                }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface b {
        void a(Object obj, ImageView imageView);

        void b(List list, int i);
    }

    public NineGridLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NineGridLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, da3.f3);
        int dimension = (int) obtainStyledAttributes.getDimension(da3.k3, 0.0f);
        int dimension2 = (int) obtainStyledAttributes.getDimension(da3.h3, 0.0f);
        this.f = (int) obtainStyledAttributes.getDimension(da3.g3, 0.0f);
        obtainStyledAttributes.recycle();
        this.a = context;
        this.g = new ArrayList();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float f = displayMetrics.density;
        int i2 = displayMetrics.widthPixels - dimension;
        this.e = dimension2;
        this.b = (int) ((f * 220.0f) + 0.5f);
        this.c = (i2 - dimension2) / 2;
        this.d = (i2 - (dimension2 * 2)) / 3;
        this.m = new a();
    }

    private void setHeight(int i) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (i != layoutParams.height) {
            layoutParams.height = i;
            requestLayout();
        }
    }

    public final void d() {
        RoundedImageView roundedImageView = new RoundedImageView(this.a);
        roundedImageView.setCornerRadius(this.f);
        roundedImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        roundedImageView.setOnClickListener(this.m);
        this.g.add(roundedImageView);
        addView(roundedImageView);
    }

    public final void e(int i) {
        int size = this.g.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (i2 >= i) {
                RoundedImageView roundedImageView = (RoundedImageView) this.g.get(i2);
                roundedImageView.setImageDrawable((Drawable) null);
                if (roundedImageView.getVisibility() == 0) {
                    roundedImageView.setVisibility(4);
                }
            }
        }
    }

    public void setActionListener(b bVar) {
        this.h = bVar;
    }

    public void setData(List<?> list) {
        if (list == null) {
            e(0);
            return;
        }
        int size = list.size();
        if (size == 0) {
            e(0);
            return;
        }
        this.n = list;
        int size2 = this.g.size();
        if (size2 < size) {
            int i = size - size2;
            for (int i2 = 0; i2 < i; i2++) {
                d();
            }
        } else if (size2 > size) {
            e(size);
        }
        if (size == 1) {
            ImageView imageView = (RoundedImageView) this.g.get(0);
            if (this.i == null) {
                int i3 = this.b;
                this.i = new FrameLayout.LayoutParams(i3, i3);
            }
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            FrameLayout.LayoutParams layoutParams2 = this.i;
            if (layoutParams != layoutParams2) {
                imageView.setLayoutParams(layoutParams2);
            }
            if (imageView.getVisibility() != 0) {
                imageView.setVisibility(0);
            }
            setHeight(this.b);
            b bVar = this.h;
            if (bVar != null) {
                bVar.a(list.get(0), imageView);
                return;
            }
            return;
        }
        if (size != 2) {
            if (this.l == null) {
                this.l = new FrameLayout.LayoutParams[9];
            }
            int i4 = size / 3;
            if (size % 3 != 0) {
                i4++;
            }
            setHeight((this.d * i4) + (this.e * (i4 - 1)));
            for (int i5 = 0; i5 < size; i5++) {
                ImageView imageView2 = (RoundedImageView) this.g.get(i5);
                FrameLayout.LayoutParams[] layoutParamsArr = this.l;
                if (layoutParamsArr[i5] == null) {
                    int i6 = this.d;
                    layoutParamsArr[i5] = new FrameLayout.LayoutParams(i6, i6);
                    int i7 = this.d + this.e;
                    FrameLayout.LayoutParams layoutParams3 = this.l[i5];
                    layoutParams3.leftMargin = (i5 % 3) * i7;
                    layoutParams3.topMargin = i7 * (i5 / 3);
                }
                ViewGroup.LayoutParams layoutParams4 = imageView2.getLayoutParams();
                FrameLayout.LayoutParams layoutParams5 = this.l[i5];
                if (layoutParams4 != layoutParams5) {
                    imageView2.setLayoutParams(layoutParams5);
                }
                if (imageView2.getVisibility() != 0) {
                    imageView2.setVisibility(0);
                }
                b bVar2 = this.h;
                if (bVar2 != null) {
                    bVar2.a(list.get(i5), imageView2);
                }
            }
            return;
        }
        ImageView imageView3 = (RoundedImageView) this.g.get(0);
        ImageView imageView4 = (RoundedImageView) this.g.get(1);
        if (this.j == null) {
            int i8 = this.c;
            this.j = new FrameLayout.LayoutParams(i8, i8);
        }
        if (this.k == null) {
            int i9 = this.c;
            FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(i9, i9);
            this.k = layoutParams6;
            layoutParams6.gravity = 5;
        }
        ViewGroup.LayoutParams layoutParams7 = imageView3.getLayoutParams();
        FrameLayout.LayoutParams layoutParams8 = this.j;
        if (layoutParams7 != layoutParams8) {
            imageView3.setLayoutParams(layoutParams8);
        }
        ViewGroup.LayoutParams layoutParams9 = imageView4.getLayoutParams();
        FrameLayout.LayoutParams layoutParams10 = this.k;
        if (layoutParams9 != layoutParams10) {
            imageView4.setLayoutParams(layoutParams10);
        }
        if (imageView3.getVisibility() != 0) {
            imageView3.setVisibility(0);
        }
        if (imageView4.getVisibility() != 0) {
            imageView4.setVisibility(0);
        }
        setHeight(this.c);
        b bVar3 = this.h;
        if (bVar3 != null) {
            bVar3.a(list.get(0), imageView3);
            this.h.a(list.get(1), imageView4);
        }
    }
}
