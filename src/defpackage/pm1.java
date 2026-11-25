package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.ContentValues;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.common.CommonAppContext;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.http.UriDownloadCallback;
import com.yunbao.common.utils.a;
import defpackage.om1;

/* loaded from: /tmp/classes2.dex */
public class pm1 extends l0 implements View.OnClickListener {
    public RecyclerView A0;
    public ValueAnimator B0;
    public int C0;
    public int D0;
    public c E0;
    public TextView F0;
    public om1 G0;
    public boolean H0;
    public View z0;

    /* loaded from: /tmp/classes2.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            pm1.this.z0.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends AnimatorListenerAdapter {

        /* loaded from: /tmp/classes2.dex */
        public class a implements om1.c {

            /* renamed from: pm1$b$a$a, reason: collision with other inner class name */
            /* loaded from: /tmp/classes2.dex */
            public class C0146a implements a.n {
                public final /* synthetic */ String a;

                /* renamed from: pm1$b$a$a$a, reason: collision with other inner class name */
                /* loaded from: /tmp/classes2.dex */
                public class C0147a extends vx2 {

                    /* renamed from: pm1$b$a$a$a$a, reason: collision with other inner class name */
                    /* loaded from: /tmp/classes2.dex */
                    public class C0148a extends UriDownloadCallback {
                        public C0148a() {
                        }

                        @Override // com.yunbao.common.http.UriDownloadCallback
                        public void onSuccess() {
                            t54.a(m93.U9);
                        }
                    }

                    public C0147a() {
                    }

                    @Override // defpackage.vx2
                    public void a() {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        String str = rv3.b() + ".png";
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("_display_name", str);
                        contentValues.put("mime_type", "image/png");
                        contentValues.put("title", str);
                        contentValues.put("date_modified", Long.valueOf(uptimeMillis));
                        contentValues.put("date_added", Long.valueOf(uptimeMillis));
                        if (Build.VERSION.SDK_INT >= 29) {
                            contentValues.put("relative_path", Environment.DIRECTORY_DCIM);
                        } else {
                            contentValues.put("_data", j30.N + str);
                        }
                        new yn0("save_img").b(CommonAppContext.n().getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues), C0146a.this.a, new C0148a());
                    }
                }

                public C0146a(String str) {
                    this.a = str;
                }

                @Override // com.yunbao.common.utils.a.n
                public void a(String str, int i) {
                    yx2.a((AbsActivity) pm1.this.x0, new C0147a(), zj2.u());
                }
            }

            public a() {
            }

            @Override // om1.c
            public void a(ImageView imageView, int i) {
                if (pm1.this.E0 != null) {
                    pm1.this.E0.a(imageView, i);
                }
            }

            @Override // om1.c
            public void b(int i) {
                if (pm1.this.F0 != null) {
                    pm1.this.F0.setText(rv3.a(String.valueOf(i + 1), "/", String.valueOf(pm1.this.D0)));
                }
            }

            @Override // om1.c
            public void c(int i) {
                Context context;
                if (pm1.this.E0 != null) {
                    String c = pm1.this.E0.c(i);
                    if (TextUtils.isEmpty(c) || (context = pm1.this.x0) == null) {
                        return;
                    }
                    com.yunbao.common.utils.a.r(context, new Integer[]{Integer.valueOf(m93.T9)}, new C0146a(c));
                }
            }
        }

        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (pm1.this.A0 == null || pm1.this.D0 <= 0) {
                return;
            }
            pm1 pm1Var = pm1.this;
            om1 om1Var = new om1(pm1Var.x0, pm1Var.D0);
            pm1.this.G0 = om1Var;
            om1Var.T(new a());
            pm1.this.A0.setAdapter(om1Var);
            if (pm1.this.C0 < 0 || pm1.this.C0 >= pm1.this.D0) {
                return;
            }
            om1Var.U(pm1.this.C0);
            pm1.this.A0.v1(pm1.this.C0);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface c {
        void a(ImageView imageView, int i);

        void b(int i);

        String c(int i);
    }

    private void y2() {
        c cVar;
        om1 om1Var = this.G0;
        if (om1Var != null && (cVar = this.E0) != null) {
            cVar.b(om1Var.Q());
        }
        S1();
    }

    @Override // defpackage.l0
    public void C0() {
        ValueAnimator valueAnimator = this.B0;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.x0 = null;
        this.E0 = null;
        super.C0();
    }

    @Override // defpackage.l0
    public boolean f2() {
        return true;
    }

    @Override // defpackage.l0
    public int l2() {
        return s93.d;
    }

    @Override // defpackage.l0
    public int m2() {
        return u73.X;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == y63.i) {
            S1();
        } else if (id == y63.l) {
            y2();
        }
    }

    @Override // defpackage.l0
    public void p2(Window window) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        window.setAttributes(attributes);
    }

    public void r0(Bundle bundle) {
        super.r0(bundle);
        this.z0 = this.y0.findViewById(y63.b);
        this.F0 = (TextView) k2(y63.z);
        k2(y63.i).setOnClickListener(this);
        if (this.H0) {
            View k2 = k2(y63.l);
            k2.setVisibility(0);
            k2.setOnClickListener(this);
        }
        RecyclerView findViewById = this.y0.findViewById(y63.Z);
        this.A0 = findViewById;
        findViewById.setHasFixedSize(true);
        this.A0.setLayoutManager(new LinearLayoutManager(this.x0, 0, false));
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.B0 = ofFloat;
        ofFloat.setDuration(150L);
        this.B0.setInterpolator(new AccelerateDecelerateInterpolator());
        this.B0.addUpdateListener(new a());
        this.B0.addListener(new b());
        this.B0.start();
    }

    public void z2(int i, int i2, boolean z, c cVar) {
        this.E0 = cVar;
        this.D0 = i;
        this.C0 = i2;
        this.H0 = z;
    }
}
