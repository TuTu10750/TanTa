package com.yunbao.common.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import defpackage.da3;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class NineGridLayout2 extends FrameLayout {
    public Context a;
    public int b;
    public int c;
    public int d;
    public List e;
    public b f;
    public FrameLayout.LayoutParams[] g;
    public View.OnClickListener h;
    public List i;
    public String j;
    public ImageView k;
    public float l;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (NineGridLayout2.this.f != null) {
                int size = NineGridLayout2.this.e.size();
                for (int i = 0; i < size; i++) {
                    if (view == NineGridLayout2.this.e.get(i)) {
                        b bVar = NineGridLayout2.this.f;
                        NineGridLayout2 nineGridLayout2 = NineGridLayout2.this;
                        bVar.b(nineGridLayout2, nineGridLayout2.i, i);
                        return;
                    }
                }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface b {
        void a(Object obj, ImageView imageView);

        void b(NineGridLayout2 nineGridLayout2, List list, int i);
    }

    public NineGridLayout2(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NineGridLayout2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, da3.f3);
        this.b = (int) obtainStyledAttributes.getDimension(da3.i3, 0.0f);
        this.c = (int) obtainStyledAttributes.getDimension(da3.h3, 0.0f);
        this.d = obtainStyledAttributes.getResourceId(da3.j3, 0);
        obtainStyledAttributes.recycle();
        this.l = context.getResources().getDisplayMetrics().density;
        this.e = new ArrayList();
        this.h = new a();
    }

    private void setHeight(int i) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (i != layoutParams.height) {
            layoutParams.height = i;
            requestLayout();
        }
    }

    public final void d() {
        ImageView imageView = new ImageView(this.a);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setOnClickListener(this.h);
        this.e.add(imageView);
        addView(imageView);
    }

    public final int e(int i) {
        return (int) ((this.l * i) + 0.5f);
    }

    public final void f(int i) {
        int size = this.e.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (i2 >= i) {
                ImageView imageView = (ImageView) this.e.get(i2);
                imageView.setImageDrawable(null);
                if (imageView.getVisibility() == 0) {
                    imageView.setVisibility(4);
                }
            }
        }
    }

    public void g(List list, String str) {
        this.j = str;
        if (list == null) {
            f(0);
            setHeight(0);
            return;
        }
        int size = list.size();
        if (size == 0) {
            f(0);
            setHeight(0);
            return;
        }
        this.i = list;
        int size2 = this.e.size();
        if (size2 < size) {
            int i = size - size2;
            for (int i2 = 0; i2 < i; i2++) {
                d();
            }
        } else if (size2 > size) {
            f(size);
        }
        boolean isEmpty = TextUtils.isEmpty(str);
        ImageView imageView = this.k;
        if (isEmpty) {
            if (imageView != null && imageView.getVisibility() == 0) {
                this.k.setVisibility(4);
            }
        } else if (imageView == null) {
            this.k = new ImageView(this.a);
            int e = e(30);
            int e2 = e(15);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(e, e);
            layoutParams.leftMargin = e2;
            layoutParams.topMargin = e2;
            this.k.setLayoutParams(layoutParams);
            this.k.setImageResource(this.d);
            addView(this.k);
        } else if (imageView.getVisibility() != 0) {
            this.k.setVisibility(0);
        }
        if (this.g == null) {
            this.g = new FrameLayout.LayoutParams[6];
        }
        int i3 = size / 3;
        if (size % 3 != 0) {
            i3++;
        }
        setHeight((this.b * i3) + (this.c * (i3 - 1)));
        for (int i4 = 0; i4 < size; i4++) {
            ImageView imageView2 = (ImageView) this.e.get(i4);
            FrameLayout.LayoutParams[] layoutParamsArr = this.g;
            if (layoutParamsArr[i4] == null) {
                int i5 = this.b;
                layoutParamsArr[i4] = new FrameLayout.LayoutParams(i5, i5);
                int i6 = this.b + this.c;
                FrameLayout.LayoutParams layoutParams2 = this.g[i4];
                layoutParams2.leftMargin = (i4 % 3) * i6;
                layoutParams2.topMargin = i6 * (i4 / 3);
            }
            ViewGroup.LayoutParams layoutParams3 = imageView2.getLayoutParams();
            FrameLayout.LayoutParams layoutParams4 = this.g[i4];
            if (layoutParams3 != layoutParams4) {
                imageView2.setLayoutParams(layoutParams4);
            }
            if (imageView2.getVisibility() != 0) {
                imageView2.setVisibility(0);
            }
            b bVar = this.f;
            if (bVar != null) {
                bVar.a(list.get(i4), imageView2);
            }
        }
    }

    public String getVideoUrl() {
        return this.j;
    }

    public void setActionListener(b bVar) {
        this.f = bVar;
    }
}
