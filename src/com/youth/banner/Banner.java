package com.youth.banner;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.youth.banner.loader.ImageLoaderInterface;
import com.youth.banner.view.BannerViewPager;
import defpackage.ca3;
import defpackage.e63;
import defpackage.ig;
import defpackage.kc1;
import defpackage.m83;
import defpackage.tm4;
import defpackage.w63;
import defpackage.xs2;
import defpackage.ys2;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class Banner extends FrameLayout implements ViewPager.j {
    public BannerViewPager A;
    public TextView B;
    public TextView C;
    public TextView D;
    public LinearLayout E;
    public LinearLayout F;
    public LinearLayout G;
    public ImageLoaderInterface H;
    public b I;
    public ViewPager.j J;
    public ig K;
    public ys2 L;
    public DisplayMetrics M;
    public tm4 N;
    public final Runnable O;
    public String a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public boolean i;
    public boolean j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public List v;
    public List w;
    public List x;
    public List y;
    public Context z;

    /* loaded from: /tmp/classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Banner.this.q <= 1 || !Banner.this.i) {
                return;
            }
            Banner banner = Banner.this;
            banner.r = (banner.r % (Banner.this.q + 1)) + 1;
            int i = Banner.this.r;
            Banner banner2 = Banner.this;
            if (i == 1) {
                banner2.A.M(Banner.this.r, false);
                Banner.this.N.a(Banner.this.O);
            } else {
                banner2.A.setCurrentItem(Banner.this.r);
                Banner.this.N.b(Banner.this.O, Banner.this.g);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends xv2 {

        /* loaded from: /tmp/classes2.dex */
        public class a implements View.OnClickListener {
            public final /* synthetic */ int a;

            public a(int i) {
                this.a = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Banner.this.L.OnBannerClick(Banner.this.C(this.a));
            }
        }

        public b() {
        }

        public void a(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        public int d() {
            return Banner.this.x.size();
        }

        public Object h(ViewGroup viewGroup, int i) {
            viewGroup.addView((View) Banner.this.x.get(i));
            View view = (View) Banner.this.x.get(i);
            Banner.n(Banner.this);
            if (Banner.this.L != null) {
                view.setOnClickListener(new a(i));
            }
            return view;
        }

        public boolean i(View view, Object obj) {
            return view == obj;
        }
    }

    public Banner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public Banner(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = "banner";
        this.b = 5;
        this.f = 1;
        this.g = 2000;
        this.h = 800;
        this.i = true;
        this.j = true;
        this.k = e63.a;
        this.l = e63.b;
        this.q = 0;
        this.s = -1;
        this.t = 1;
        this.u = 1;
        this.N = new tm4();
        this.O = new a();
        this.z = context;
        this.v = new ArrayList();
        this.w = new ArrayList();
        this.x = new ArrayList();
        this.y = new ArrayList();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.M = displayMetrics;
        this.e = displayMetrics.widthPixels / 80;
        s(context, attributeSet);
    }

    public static /* synthetic */ xs2 n(Banner banner) {
        banner.getClass();
        return null;
    }

    private void setImageList(List<?> list) {
        if (list == null || list.size() <= 0) {
            Log.e(this.a, "Please set the images data.");
            return;
        }
        r();
        int i = 0;
        while (i <= this.q + 1) {
            ImageLoaderInterface imageLoaderInterface = this.H;
            View createImageView = imageLoaderInterface != null ? imageLoaderInterface.createImageView(this.z) : null;
            if (createImageView == null) {
                createImageView = new ImageView(this.z);
            }
            setScaleType(createImageView);
            int i2 = this.q;
            Object obj = i == 0 ? list.get(i2 - 1) : i == i2 + 1 ? list.get(0) : list.get(i - 1);
            this.x.add(createImageView);
            ImageLoaderInterface imageLoaderInterface2 = this.H;
            if (imageLoaderInterface2 != null) {
                imageLoaderInterface2.displayImage(this.z, obj, createImageView);
            } else {
                Log.e(this.a, "Please set images loader.");
            }
            i++;
        }
    }

    private void setScaleType(View view) {
        if (view instanceof ImageView) {
            ImageView imageView = (ImageView) view;
            switch (this.u) {
                case 0:
                    imageView.setScaleType(ImageView.ScaleType.CENTER);
                    return;
                case 1:
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    return;
                case 2:
                    imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                    return;
                case 3:
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    return;
                case 4:
                    imageView.setScaleType(ImageView.ScaleType.FIT_END);
                    return;
                case 5:
                    imageView.setScaleType(ImageView.ScaleType.FIT_START);
                    return;
                case 6:
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    return;
                case 7:
                    imageView.setScaleType(ImageView.ScaleType.MATRIX);
                    return;
                default:
                    return;
            }
        }
    }

    public void A() {
        this.N.c(this.O);
        this.N.b(this.O, this.g);
    }

    public void B() {
        this.N.c(this.O);
    }

    public int C(int i) {
        int i2 = this.q;
        int i3 = (i - 1) % i2;
        return i3 < 0 ? i3 + i2 : i3;
    }

    public void D(List list) {
        this.w.clear();
        this.w.addAll(list);
        this.q = this.w.size();
        z();
    }

    public void a(int i, float f, int i2) {
        ViewPager.j jVar = this.J;
        if (jVar != null) {
            jVar.a(i, f, i2);
        }
    }

    public void b(int i) {
        ViewPager.j jVar = this.J;
        if (jVar != null) {
            jVar.b(i);
        }
        int currentItem = this.A.getCurrentItem();
        this.r = currentItem;
        if (i == 0) {
            if (currentItem == 0) {
                this.A.M(this.q, false);
                return;
            } else {
                if (currentItem == this.q + 1) {
                    this.A.M(1, false);
                    return;
                }
                return;
            }
        }
        if (i != 1) {
            return;
        }
        int i2 = this.q;
        if (currentItem == i2 + 1) {
            this.A.M(1, false);
        } else if (currentItem == 0) {
            this.A.M(i2, false);
        }
    }

    public void c(int i) {
        ViewPager.j jVar = this.J;
        if (jVar != null) {
            jVar.c(i);
        }
        int i2 = this.f;
        if (i2 == 1 || i2 == 4 || i2 == 5) {
            List list = this.y;
            int i3 = this.t - 1;
            int i4 = this.q;
            ((ImageView) list.get((i3 + i4) % i4)).setImageResource(this.l);
            List list2 = this.y;
            int i5 = this.q;
            ((ImageView) list2.get(((i - 1) + i5) % i5)).setImageResource(this.k);
            this.t = i;
        }
        if (i == 0) {
            i = this.q;
        }
        if (i > this.q) {
            i = 1;
        }
        int i6 = this.f;
        if (i6 == 2) {
            this.D.setText(i + "/" + this.q);
            return;
        }
        if (i6 != 3) {
            if (i6 == 4) {
                this.B.setText((CharSequence) this.v.get(i - 1));
                return;
            } else {
                if (i6 != 5) {
                    return;
                }
                this.B.setText((CharSequence) this.v.get(i - 1));
                return;
            }
        }
        this.C.setText(i + "/" + this.q);
        this.B.setText((CharSequence) this.v.get(i - 1));
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.i) {
            int action = motionEvent.getAction();
            if (action == 1 || action == 3 || action == 4) {
                A();
            } else if (action == 0) {
                B();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final void p() {
        this.y.clear();
        this.E.removeAllViews();
        this.F.removeAllViews();
        for (int i = 0; i < this.q; i++) {
            ImageView imageView = new ImageView(this.z);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.c, this.d);
            int i2 = this.b;
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            if (i == 0) {
                imageView.setImageResource(this.k);
            } else {
                imageView.setImageResource(this.l);
            }
            this.y.add(imageView);
            int i3 = this.f;
            if (i3 == 1 || i3 == 4) {
                this.E.addView(imageView, layoutParams);
            } else if (i3 == 5) {
                this.F.addView(imageView, layoutParams);
            }
        }
    }

    public final void q(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ca3.a);
        this.c = obtainStyledAttributes.getDimensionPixelSize(ca3.h, this.e);
        this.d = obtainStyledAttributes.getDimensionPixelSize(ca3.f, this.e);
        this.b = obtainStyledAttributes.getDimensionPixelSize(ca3.g, 5);
        this.k = obtainStyledAttributes.getResourceId(ca3.d, e63.a);
        this.l = obtainStyledAttributes.getResourceId(ca3.e, e63.b);
        this.u = obtainStyledAttributes.getInt(ca3.c, this.u);
        this.g = obtainStyledAttributes.getInt(ca3.b, 2000);
        this.h = obtainStyledAttributes.getInt(ca3.j, 800);
        this.i = obtainStyledAttributes.getBoolean(ca3.i, true);
        this.n = obtainStyledAttributes.getColor(ca3.k, -1);
        this.m = obtainStyledAttributes.getDimensionPixelSize(ca3.l, -1);
        this.o = obtainStyledAttributes.getColor(ca3.m, -1);
        this.p = obtainStyledAttributes.getDimensionPixelSize(ca3.n, -1);
        obtainStyledAttributes.recycle();
    }

    public final void r() {
        this.x.clear();
        int i = this.f;
        if (i == 1 || i == 4 || i == 5) {
            p();
            return;
        }
        if (i == 3) {
            this.C.setText("1/" + this.q);
            return;
        }
        if (i == 2) {
            this.D.setText("1/" + this.q);
        }
    }

    public final void s(Context context, AttributeSet attributeSet) {
        this.x.clear();
        View inflate = LayoutInflater.from(context).inflate(m83.a, (ViewGroup) this, true);
        this.A = (BannerViewPager) inflate.findViewById(w63.b);
        this.G = (LinearLayout) inflate.findViewById(w63.g);
        this.E = (LinearLayout) inflate.findViewById(w63.c);
        this.F = (LinearLayout) inflate.findViewById(w63.d);
        this.B = (TextView) inflate.findViewById(w63.a);
        this.D = (TextView) inflate.findViewById(w63.e);
        this.C = (TextView) inflate.findViewById(w63.f);
        q(context, attributeSet);
        t();
    }

    public void setOnPageChangeListener(ViewPager.j jVar) {
        this.J = jVar;
    }

    public final void t() {
        try {
            Field declaredField = ViewPager.class.getDeclaredField("j");
            declaredField.setAccessible(true);
            ig igVar = new ig(this.A.getContext());
            this.K = igVar;
            igVar.a(this.h);
            declaredField.set(this.A, this.K);
        } catch (Exception e) {
            Log.e(this.a, e.getMessage());
        }
    }

    public final void u() {
        int i = this.q > 1 ? 0 : 8;
        int i2 = this.f;
        if (i2 == 1) {
            this.E.setVisibility(i);
            return;
        }
        if (i2 == 2) {
            this.D.setVisibility(i);
            return;
        }
        if (i2 == 3) {
            this.C.setVisibility(i);
            y();
        } else if (i2 == 4) {
            this.E.setVisibility(i);
            y();
        } else {
            if (i2 != 5) {
                return;
            }
            this.F.setVisibility(i);
            y();
        }
    }

    public final void v() {
        this.r = 1;
        if (this.I == null) {
            this.I = new b();
            this.A.c(this);
        }
        this.A.setAdapter(this.I);
        this.A.setFocusable(true);
        this.A.setCurrentItem(1);
        int i = this.s;
        if (i != -1) {
            this.E.setGravity(i);
        }
        if (!this.j || this.q <= 1) {
            this.A.setScrollable(false);
        } else {
            this.A.setScrollable(true);
        }
        if (this.i) {
            A();
        }
    }

    public Banner w(ImageLoaderInterface imageLoaderInterface) {
        this.H = imageLoaderInterface;
        return this;
    }

    public Banner x(ys2 ys2Var) {
        this.L = ys2Var;
        return this;
    }

    public final void y() {
        if (this.v.size() != this.w.size()) {
            kc1.a("[Banner] --> The number of titles and images is different");
            return;
        }
        int i = this.n;
        if (i != -1) {
            this.G.setBackgroundColor(i);
        }
        if (this.m != -1) {
            this.G.setLayoutParams(new RelativeLayout.LayoutParams(-1, this.m));
        }
        int i2 = this.o;
        if (i2 != -1) {
            this.B.setTextColor(i2);
        }
        int i3 = this.p;
        if (i3 != -1) {
            this.B.setTextSize(0, i3);
        }
        List list = this.v;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.B.setText((CharSequence) this.v.get(0));
        this.B.setVisibility(0);
        this.G.setVisibility(0);
    }

    public Banner z() {
        u();
        setImageList(this.w);
        v();
        return this;
    }
}
