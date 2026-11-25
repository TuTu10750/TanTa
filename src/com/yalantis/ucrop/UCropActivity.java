package com.yalantis.ucrop;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.yalantis.ucrop.view.GestureCropImageView;
import com.yalantis.ucrop.view.OverlayView;
import com.yalantis.ucrop.view.TransformImageView;
import com.yalantis.ucrop.view.UCropView;
import com.yalantis.ucrop.view.widget.AspectRatioTextView;
import com.yalantis.ucrop.view.widget.HorizontalProgressWheelView;
import com.zzhoujay.richtext.ImageHolder;
import defpackage.d63;
import defpackage.k93;
import defpackage.l83;
import defpackage.o53;
import defpackage.p83;
import defpackage.ti;
import defpackage.u63;
import defpackage.w53;
import defpackage.wb;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: /tmp/classes2.dex */
public class UCropActivity extends AppCompatActivity {
    public static final Bitmap.CompressFormat E = Bitmap.CompressFormat.JPEG;
    public String a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public boolean j;
    public UCropView l;
    public GestureCropImageView m;
    public OverlayView n;
    public ViewGroup o;
    public ViewGroup p;
    public ViewGroup q;
    public ViewGroup r;
    public ViewGroup s;
    public ViewGroup t;
    public TextView v;
    public TextView w;
    public View x;
    public w74 y;
    public boolean k = true;
    public List u = new ArrayList();
    public Bitmap.CompressFormat z = E;
    public int A = 90;
    public int[] B = {1, 2, 3};
    public TransformImageView.b C = new a();
    public final View.OnClickListener D = new g();

    /* loaded from: /tmp/classes2.dex */
    public class a implements TransformImageView.b {
        public a() {
        }

        @Override // com.yalantis.ucrop.view.TransformImageView.b
        public void a(float f) {
            UCropActivity.this.t1(f);
        }

        @Override // com.yalantis.ucrop.view.TransformImageView.b
        public void b() {
            UCropActivity.this.l.animate().alpha(1.0f).setDuration(300L).setInterpolator(new AccelerateInterpolator());
            UCropActivity.this.x.setClickable(false);
            UCropActivity.this.k = false;
            UCropActivity.this.supportInvalidateOptionsMenu();
        }

        @Override // com.yalantis.ucrop.view.TransformImageView.b
        public void c(Exception exc) {
            UCropActivity.this.x1(exc);
            UCropActivity.this.finish();
        }

        @Override // com.yalantis.ucrop.view.TransformImageView.b
        public void d(float f) {
            UCropActivity.this.z1(f);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UCropActivity.this.m.setTargetAspectRatio(((AspectRatioTextView) ((ViewGroup) view).getChildAt(0)).t(view.isSelected()));
            UCropActivity.this.m.B();
            if (view.isSelected()) {
                return;
            }
            for (ViewGroup viewGroup : UCropActivity.this.u) {
                viewGroup.setSelected(viewGroup == view);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c implements HorizontalProgressWheelView.a {
        public c() {
        }

        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.a
        public void a() {
            UCropActivity.this.m.B();
        }

        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.a
        public void b(float f, float f2) {
            UCropActivity.this.m.z(f / 42.0f);
        }

        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.a
        public void c() {
            UCropActivity.this.m.v();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UCropActivity.this.q1();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UCropActivity.this.r1(90);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class f implements HorizontalProgressWheelView.a {
        public f() {
        }

        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.a
        public void a() {
            UCropActivity.this.m.B();
        }

        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.a
        public void b(float f, float f2) {
            UCropActivity uCropActivity = UCropActivity.this;
            if (f > 0.0f) {
                uCropActivity.m.E(UCropActivity.this.m.getCurrentScale() + (f * ((UCropActivity.this.m.getMaxScale() - UCropActivity.this.m.getMinScale()) / 15000.0f)));
            } else {
                uCropActivity.m.G(UCropActivity.this.m.getCurrentScale() + (f * ((UCropActivity.this.m.getMaxScale() - UCropActivity.this.m.getMinScale()) / 15000.0f)));
            }
        }

        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.a
        public void c() {
            UCropActivity.this.m.v();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.isSelected()) {
                return;
            }
            UCropActivity.this.C1(view.getId());
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class h implements ti {
        public h() {
        }

        @Override // defpackage.ti
        public void a(Uri uri, int i, int i2, int i3, int i4) {
            UCropActivity uCropActivity = UCropActivity.this;
            uCropActivity.y1(uri, uCropActivity.m.getTargetAspectRatio(), i, i2, i3, i4);
            UCropActivity.this.finish();
        }

        @Override // defpackage.ti
        public void b(Throwable th) {
            UCropActivity.this.x1(th);
            UCropActivity.this.finish();
        }
    }

    static {
        f9.H(true);
    }

    public final void A1(int i) {
        TextView textView = this.w;
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void B1(int i) {
        Window window = getWindow();
        if (window != null) {
            window.addFlags(ImageHolder.WRAP_CONTENT);
            window.setStatusBarColor(i);
        }
    }

    public final void C1(int i) {
        if (this.j) {
            this.o.setSelected(i == u63.n);
            this.p.setSelected(i == u63.o);
            this.q.setSelected(i == u63.p);
            this.r.setVisibility(i == u63.n ? 0 : 8);
            this.s.setVisibility(i == u63.o ? 0 : 8);
            this.t.setVisibility(i == u63.p ? 0 : 8);
            m1(i);
            if (i == u63.p) {
                s1(0);
            } else if (i == u63.o) {
                s1(1);
            } else {
                s1(2);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void D1() {
        B1(this.c);
        Toolbar findViewById = findViewById(u63.t);
        findViewById.setBackgroundColor(this.b);
        findViewById.setTitleTextColor(this.e);
        TextView textView = (TextView) findViewById.findViewById(u63.u);
        textView.setTextColor(this.e);
        textView.setText(this.a);
        Drawable mutate = o60.d(this, this.g).mutate();
        mutate.setColorFilter(this.e, PorterDuff.Mode.SRC_ATOP);
        findViewById.setNavigationIcon(mutate);
        setSupportActionBar(findViewById);
        r3 supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.s(false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void E1(Intent intent) {
        int intExtra = intent.getIntExtra("com.yalantis.ucrop.AspectRatioSelectedByDefault", 0);
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("com.yalantis.ucrop.AspectRatioOptions");
        if (parcelableArrayListExtra == null || parcelableArrayListExtra.isEmpty()) {
            parcelableArrayListExtra = new ArrayList();
            parcelableArrayListExtra.add(new wb(null, 1.0f, 1.0f));
            parcelableArrayListExtra.add(new wb(null, 3.0f, 4.0f));
            parcelableArrayListExtra.add(new wb(getString(k93.c).toUpperCase(), 0.0f, 0.0f));
            parcelableArrayListExtra.add(new wb(null, 3.0f, 2.0f));
            parcelableArrayListExtra.add(new wb(null, 16.0f, 9.0f));
            intExtra = 2;
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(u63.g);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        Iterator it = parcelableArrayListExtra.iterator();
        while (it.hasNext()) {
            wb wbVar = (wb) it.next();
            FrameLayout frameLayout = (FrameLayout) getLayoutInflater().inflate(l83.b, (ViewGroup) null);
            frameLayout.setLayoutParams(layoutParams);
            AspectRatioTextView aspectRatioTextView = (AspectRatioTextView) frameLayout.getChildAt(0);
            aspectRatioTextView.setActiveColor(this.d);
            aspectRatioTextView.setAspectRatio(wbVar);
            linearLayout.addView(frameLayout);
            this.u.add(frameLayout);
        }
        ((ViewGroup) this.u.get(intExtra)).setSelected(true);
        Iterator it2 = this.u.iterator();
        while (it2.hasNext()) {
            ((ViewGroup) it2.next()).setOnClickListener(new b());
        }
    }

    public final void F1() {
        this.v = (TextView) findViewById(u63.r);
        ((HorizontalProgressWheelView) findViewById(u63.l)).setScrollingListener(new c());
        ((HorizontalProgressWheelView) findViewById(u63.l)).setMiddleLineColor(this.d);
        findViewById(u63.z).setOnClickListener(new d());
        findViewById(u63.A).setOnClickListener(new e());
        u1(this.d);
    }

    public final void G1() {
        this.w = (TextView) findViewById(u63.s);
        ((HorizontalProgressWheelView) findViewById(u63.m)).setScrollingListener(new f());
        ((HorizontalProgressWheelView) findViewById(u63.m)).setMiddleLineColor(this.d);
        A1(this.d);
    }

    public final void H1() {
        ImageView imageView = (ImageView) findViewById(u63.f);
        ImageView imageView2 = (ImageView) findViewById(u63.e);
        ImageView imageView3 = (ImageView) findViewById(u63.d);
        imageView.setImageDrawable(new tl3(imageView.getDrawable(), this.d));
        imageView2.setImageDrawable(new tl3(imageView2.getDrawable(), this.d));
        imageView3.setImageDrawable(new tl3(imageView3.getDrawable(), this.d));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void I1(Intent intent) {
        this.c = intent.getIntExtra("com.yalantis.ucrop.StatusBarColor", o60.b(this, o53.h));
        this.b = intent.getIntExtra("com.yalantis.ucrop.ToolbarColor", o60.b(this, o53.i));
        this.d = intent.getIntExtra("com.yalantis.ucrop.UcropColorControlsWidgetActive", o60.b(this, o53.a));
        this.e = intent.getIntExtra("com.yalantis.ucrop.UcropToolbarWidgetColor", o60.b(this, o53.j));
        this.g = intent.getIntExtra("com.yalantis.ucrop.UcropToolbarCancelDrawable", d63.a);
        this.h = intent.getIntExtra("com.yalantis.ucrop.UcropToolbarCropDrawable", d63.b);
        String stringExtra = intent.getStringExtra("com.yalantis.ucrop.UcropToolbarTitleText");
        this.a = stringExtra;
        if (stringExtra == null) {
            stringExtra = getResources().getString(k93.b);
        }
        this.a = stringExtra;
        this.i = intent.getIntExtra("com.yalantis.ucrop.UcropLogoColor", o60.b(this, o53.f));
        this.j = !intent.getBooleanExtra("com.yalantis.ucrop.HideBottomControls", false);
        this.f = intent.getIntExtra("com.yalantis.ucrop.UcropRootViewBackgroundColor", o60.b(this, o53.b));
        D1();
        o1();
        if (this.j) {
            ViewGroup viewGroup = (ViewGroup) ((ViewGroup) findViewById(u63.x)).findViewById(u63.a);
            viewGroup.setVisibility(0);
            LayoutInflater.from(this).inflate(l83.c, viewGroup, true);
            le leVar = new le();
            this.y = leVar;
            leVar.Z(50L);
            ViewGroup viewGroup2 = (ViewGroup) findViewById(u63.n);
            this.o = viewGroup2;
            viewGroup2.setOnClickListener(this.D);
            ViewGroup viewGroup3 = (ViewGroup) findViewById(u63.o);
            this.p = viewGroup3;
            viewGroup3.setOnClickListener(this.D);
            ViewGroup viewGroup4 = (ViewGroup) findViewById(u63.p);
            this.q = viewGroup4;
            viewGroup4.setOnClickListener(this.D);
            this.r = (ViewGroup) findViewById(u63.g);
            this.s = (ViewGroup) findViewById(u63.h);
            this.t = (ViewGroup) findViewById(u63.i);
            E1(intent);
            F1();
            G1();
            H1();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void l1() {
        if (this.x == null) {
            this.x = new View(this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(3, u63.t);
            this.x.setLayoutParams(layoutParams);
            this.x.setClickable(true);
        }
        ((RelativeLayout) findViewById(u63.x)).addView(this.x);
    }

    public final void m1(int i) {
        g84.a((ViewGroup) findViewById(u63.x), this.y);
        this.q.findViewById(u63.s).setVisibility(i == u63.p ? 0 : 8);
        this.o.findViewById(u63.q).setVisibility(i == u63.n ? 0 : 8);
        this.p.findViewById(u63.r).setVisibility(i == u63.o ? 0 : 8);
    }

    public void n1() {
        this.x.setClickable(true);
        this.k = true;
        supportInvalidateOptionsMenu();
        this.m.w(this.z, this.A, new h());
    }

    public final void o1() {
        UCropView uCropView = (UCropView) findViewById(u63.v);
        this.l = uCropView;
        this.m = uCropView.getCropImageView();
        this.n = this.l.getOverlayView();
        this.m.setTransformImageListener(this.C);
        ((ImageView) findViewById(u63.c)).setColorFilter(this.i, PorterDuff.Mode.SRC_ATOP);
        findViewById(u63.w).setBackgroundColor(this.f);
        if (this.j) {
            return;
        }
        ((RelativeLayout.LayoutParams) findViewById(u63.w).getLayoutParams()).bottomMargin = 0;
        findViewById(u63.w).requestLayout();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate(Bundle bundle) {
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(bundle);
        setContentView(l83.a);
        Intent intent = getIntent();
        I1(intent);
        v1(intent);
        w1();
        l1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(p83.a, menu);
        MenuItem findItem = menu.findItem(u63.k);
        Drawable icon = findItem.getIcon();
        if (icon != null) {
            try {
                icon.mutate();
                icon.setColorFilter(this.e, PorterDuff.Mode.SRC_ATOP);
                findItem.setIcon(icon);
            } catch (IllegalStateException e2) {
                Log.i("UCropActivity", String.format("%s - %s", e2.getMessage(), getString(k93.d)));
            }
            ((Animatable) findItem.getIcon()).start();
        }
        MenuItem findItem2 = menu.findItem(u63.j);
        Drawable d2 = o60.d(this, this.h);
        if (d2 == null) {
            return true;
        }
        d2.mutate();
        d2.setColorFilter(this.e, PorterDuff.Mode.SRC_ATOP);
        findItem2.setIcon(d2);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == u63.j) {
            n1();
            return true;
        }
        if (menuItem.getItemId() != 16908332) {
            return super/*android.app.Activity*/.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.findItem(u63.j).setVisible(!this.k);
        menu.findItem(u63.k).setVisible(this.k);
        return super/*android.app.Activity*/.onPrepareOptionsMenu(menu);
    }

    public void onStop() {
        super.onStop();
        GestureCropImageView gestureCropImageView = this.m;
        if (gestureCropImageView != null) {
            gestureCropImageView.v();
        }
    }

    public final void p1(Intent intent) {
        String stringExtra = intent.getStringExtra("com.yalantis.ucrop.CompressionFormatName");
        Bitmap.CompressFormat valueOf = !TextUtils.isEmpty(stringExtra) ? Bitmap.CompressFormat.valueOf(stringExtra) : null;
        if (valueOf == null) {
            valueOf = E;
        }
        this.z = valueOf;
        this.A = intent.getIntExtra("com.yalantis.ucrop.CompressionQuality", 90);
        int[] intArrayExtra = intent.getIntArrayExtra("com.yalantis.ucrop.AllowedGestures");
        if (intArrayExtra != null && intArrayExtra.length == 3) {
            this.B = intArrayExtra;
        }
        this.m.setMaxBitmapSize(intent.getIntExtra("com.yalantis.ucrop.MaxBitmapSize", 0));
        this.m.setMaxScaleMultiplier(intent.getFloatExtra("com.yalantis.ucrop.MaxScaleMultiplier", 10.0f));
        this.m.setImageToWrapCropBoundsAnimDuration(intent.getIntExtra("com.yalantis.ucrop.ImageToCropBoundsAnimDuration", 500));
        this.n.setFreestyleCropEnabled(intent.getBooleanExtra("com.yalantis.ucrop.FreeStyleCrop", false));
        this.n.setDimmedColor(intent.getIntExtra("com.yalantis.ucrop.DimmedLayerColor", getResources().getColor(o53.e)));
        this.n.setCircleDimmedLayer(intent.getBooleanExtra("com.yalantis.ucrop.CircleDimmedLayer", false));
        this.n.setShowCropFrame(intent.getBooleanExtra("com.yalantis.ucrop.ShowCropFrame", true));
        this.n.setCropFrameColor(intent.getIntExtra("com.yalantis.ucrop.CropFrameColor", getResources().getColor(o53.c)));
        this.n.setCropFrameStrokeWidth(intent.getIntExtra("com.yalantis.ucrop.CropFrameStrokeWidth", getResources().getDimensionPixelSize(w53.a)));
        this.n.setShowCropGrid(intent.getBooleanExtra("com.yalantis.ucrop.ShowCropGrid", true));
        this.n.setCropGridRowCount(intent.getIntExtra("com.yalantis.ucrop.CropGridRowCount", 2));
        this.n.setCropGridColumnCount(intent.getIntExtra("com.yalantis.ucrop.CropGridColumnCount", 2));
        this.n.setCropGridColor(intent.getIntExtra("com.yalantis.ucrop.CropGridColor", getResources().getColor(o53.d)));
        this.n.setCropGridStrokeWidth(intent.getIntExtra("com.yalantis.ucrop.CropGridStrokeWidth", getResources().getDimensionPixelSize(w53.b)));
        float floatExtra = intent.getFloatExtra("com.yalantis.ucrop.AspectRatioX", -1.0f);
        float floatExtra2 = intent.getFloatExtra("com.yalantis.ucrop.AspectRatioY", -1.0f);
        int intExtra = intent.getIntExtra("com.yalantis.ucrop.AspectRatioSelectedByDefault", 0);
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("com.yalantis.ucrop.AspectRatioOptions");
        if (floatExtra >= 0.0f && floatExtra2 >= 0.0f) {
            ViewGroup viewGroup = this.o;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
            float f2 = floatExtra / floatExtra2;
            this.m.setTargetAspectRatio(Float.isNaN(f2) ? 0.0f : f2);
        } else if (parcelableArrayListExtra == null || intExtra >= parcelableArrayListExtra.size()) {
            this.m.setTargetAspectRatio(0.0f);
        } else {
            float f3 = ((wb) parcelableArrayListExtra.get(intExtra)).f() / ((wb) parcelableArrayListExtra.get(intExtra)).g();
            this.m.setTargetAspectRatio(Float.isNaN(f3) ? 0.0f : f3);
        }
        int intExtra2 = intent.getIntExtra("com.yalantis.ucrop.MaxSizeX", 0);
        int intExtra3 = intent.getIntExtra("com.yalantis.ucrop.MaxSizeY", 0);
        if (intExtra2 <= 0 || intExtra3 <= 0) {
            return;
        }
        this.m.setMaxResultImageSizeX(intExtra2);
        this.m.setMaxResultImageSizeY(intExtra3);
    }

    public final void q1() {
        GestureCropImageView gestureCropImageView = this.m;
        gestureCropImageView.z(-gestureCropImageView.getCurrentAngle());
        this.m.B();
    }

    public final void r1(int i) {
        this.m.z(i);
        this.m.B();
    }

    public final void s1(int i) {
        GestureCropImageView gestureCropImageView = this.m;
        int i2 = this.B[i];
        gestureCropImageView.setScaleEnabled(i2 == 3 || i2 == 1);
        GestureCropImageView gestureCropImageView2 = this.m;
        int i3 = this.B[i];
        gestureCropImageView2.setRotateEnabled(i3 == 3 || i3 == 2);
    }

    public final void t1(float f2) {
        TextView textView = this.v;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%.1f°", Float.valueOf(f2)));
        }
    }

    public final void u1(int i) {
        TextView textView = this.v;
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void v1(Intent intent) {
        Uri uri = (Uri) intent.getParcelableExtra("com.yalantis.ucrop.InputUri");
        Uri uri2 = (Uri) intent.getParcelableExtra("com.yalantis.ucrop.OutputUri");
        p1(intent);
        if (uri == null || uri2 == null) {
            x1(new NullPointerException(getString(k93.a)));
            finish();
            return;
        }
        try {
            this.m.p(uri, uri2);
        } catch (Exception e2) {
            x1(e2);
            finish();
        }
    }

    public final void w1() {
        if (!this.j) {
            s1(0);
        } else if (this.o.getVisibility() == 0) {
            C1(u63.n);
        } else {
            C1(u63.p);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void x1(Throwable th) {
        setResult(96, new Intent().putExtra("com.yalantis.ucrop.Error", th));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void y1(Uri uri, float f2, int i, int i2, int i3, int i4) {
        setResult(-1, new Intent().putExtra("com.yalantis.ucrop.OutputUri", uri).putExtra("com.yalantis.ucrop.CropAspectRatio", f2).putExtra("com.yalantis.ucrop.ImageWidth", i3).putExtra("com.yalantis.ucrop.ImageHeight", i4).putExtra("com.yalantis.ucrop.OffsetX", i).putExtra("com.yalantis.ucrop.OffsetY", i2));
    }

    public final void z1(float f2) {
        TextView textView = this.w;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%d%%", Integer.valueOf((int) (f2 * 100.0f))));
        }
    }
}
