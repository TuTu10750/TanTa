package defpackage;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.yunbao.common.CommonAppContext;
import com.yunbao.common.custom.InterceptFrameLayout;

/* loaded from: /tmp/classes2.dex */
public class gp1 extends b1 implements View.OnClickListener, dt2 {
    public boolean A;
    public InputMethodManager B;
    public g C;
    public vx2 D;
    public boolean E;
    public String F;
    public View a;
    public ViewGroup b;
    public ViewGroup c;
    public ImageView d;
    public ImageView e;
    public EditText f;
    public View g;
    public TextView h;
    public Drawable i;
    public Drawable j;
    public Drawable k;
    public Drawable l;
    public Drawable m;
    public String n;
    public String o;
    public int p;
    public int q;
    public int r;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;
    public View w;
    public boolean x;
    public boolean y;
    public boolean z;

    /* loaded from: /tmp/classes2.dex */
    public class a implements TextView.OnEditorActionListener {
        public a() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 4) {
                return false;
            }
            gp1.this.v0();
            return true;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements InterceptFrameLayout.a {
        public b() {
        }

        @Override // com.yunbao.common.custom.InterceptFrameLayout.a
        public boolean a() {
            if (gp1.this.x) {
                gp1.this.z0();
            }
            if (!gp1.this.z) {
                return false;
            }
            gp1.this.C0();
            return false;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c implements View.OnTouchListener {
        public c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                if (gp1.this.h != null) {
                    gp1.this.h.setBackground(gp1.this.m);
                    gp1.this.h.setText(gp1.this.o);
                }
                if (gp1.this.C != null) {
                    gp1.this.C.d();
                }
            } else if (action == 1 || action == 3) {
                if (gp1.this.h != null) {
                    gp1.this.h.setBackground(gp1.this.l);
                    gp1.this.h.setText(gp1.this.n);
                }
                float rawY = motionEvent.getRawY();
                float f = gp1.this.p;
                gp1 gp1Var = gp1.this;
                if (rawY < f) {
                    if (gp1Var.C != null) {
                        gp1.this.C.b();
                    }
                    t54.a(m93.ta);
                } else if (gp1Var.C != null) {
                    gp1.this.C.c();
                }
            }
            return true;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d implements ViewPager.j {
        public final /* synthetic */ RadioGroup a;

        public d(RadioGroup radioGroup) {
            this.a = radioGroup;
        }

        public void a(int i, float f, int i2) {
        }

        public void b(int i) {
        }

        public void c(int i) {
            ((RadioButton) this.a.getChildAt(i)).setChecked(true);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            gp1.this.K0();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class f extends vx2 {
        public f() {
        }

        @Override // defpackage.vx2
        public void a() {
            if (gp1.this.y) {
                gp1.this.A0();
            }
            if (gp1.this.x) {
                gp1.this.z0();
            }
            if (gp1.this.z) {
                gp1.this.C0();
            }
            if (gp1.this.g != null && gp1.this.g.getVisibility() != 0) {
                gp1.this.g.setVisibility(0);
            }
            if (gp1.this.d != null) {
                gp1.this.d.setImageDrawable(gp1.this.i);
            }
            gp1.this.A = true;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static abstract class g {
        public abstract void a(String str);

        public void b() {
        }

        public void c() {
        }

        public void d() {
        }
    }

    public gp1(Context context, ViewGroup viewGroup, Object... objArr) {
        super(context, viewGroup, objArr);
    }

    public void A0() {
        Context context;
        if (this.B != null) {
            View view = this.f;
            if (view == null && (context = this.mContext) != null) {
                view = ((Activity) context).getCurrentFocus();
            }
            this.B.hideSoftInputFromWindow(view != null ? view.getWindowToken() : null, 0);
        }
    }

    public boolean B0() {
        boolean z;
        if (this.x) {
            z0();
            z = true;
        } else {
            z = false;
        }
        if (this.z) {
            C0();
            z = true;
        }
        if (!this.y) {
            return z;
        }
        A0();
        return true;
    }

    public final void C0() {
        if (this.u) {
            ViewGroup viewGroup = this.c;
            if (viewGroup != null && viewGroup.getVisibility() != 8) {
                this.c.setVisibility(8);
            }
            this.z = false;
        }
    }

    public final void D0() {
        if (this.s) {
            View view = this.g;
            if (view != null && view.getVisibility() != 8) {
                this.g.setVisibility(8);
            }
            ImageView imageView = this.d;
            if (imageView != null) {
                imageView.setImageDrawable(this.k);
            }
            this.A = false;
        }
    }

    public void E0(int i) {
        boolean z = i > 100;
        this.y = z;
        if (z) {
            if (this.x) {
                z0();
            }
            if (this.z) {
                C0();
            }
        } else if (this.E) {
            this.E = false;
            J0();
        }
        if (this.v) {
            return;
        }
        this.a.setPadding(0, 0, 0, i);
    }

    public void F0(g gVar) {
        this.C = gVar;
    }

    public void G0() {
        EditText editText = this.f;
        if (editText != null) {
            editText.setHint(this.F);
        }
    }

    public void H0(String str) {
        EditText editText = this.f;
        if (editText != null) {
            editText.setHint(str);
        }
    }

    public void I0(int i, View.OnClickListener onClickListener) {
        View findViewById;
        View view = this.w;
        if (view == null || (findViewById = view.findViewById(i)) == null) {
            return;
        }
        findViewById.setOnClickListener(onClickListener);
    }

    public void J0() {
        if (this.t) {
            if (this.z) {
                C0();
            }
            if (this.A) {
                D0();
            }
            ViewGroup viewGroup = this.b;
            if (viewGroup != null && viewGroup.getVisibility() != 0) {
                this.b.setVisibility(0);
            }
            ImageView imageView = this.e;
            if (imageView != null) {
                imageView.setImageDrawable(this.i);
            }
            this.x = true;
        }
    }

    public void K0() {
        EditText editText;
        if (this.B == null || (editText = this.f) == null) {
            return;
        }
        editText.requestFocus();
        this.B.showSoftInput(this.f, 2);
    }

    public final void L0() {
        if (this.u) {
            if (this.y) {
                A0();
            }
            if (this.x) {
                z0();
            }
            if (this.A) {
                D0();
            }
            ViewGroup viewGroup = this.c;
            if (viewGroup != null && viewGroup.getVisibility() != 0) {
                this.c.setVisibility(0);
            }
            this.z = true;
        }
    }

    public final void M0() {
        if (this.s && v31.a(false)) {
            if (this.D == null) {
                this.D = new f();
            }
            String[] u = zj2.u();
            String[] strArr = new String[u.length + 1];
            System.arraycopy(u, 0, strArr, 0, u.length);
            strArr[u.length] = "android.permission.RECORD_AUDIO";
            yx2.a(this.mContext, this.D, strArr);
        }
    }

    @Override // defpackage.dt2
    public void T(String str, int i) {
        EditText editText = this.f;
        if (editText != null) {
            editText.getText().insert(this.f.getSelectionStart(), iz0.a(str, i));
        }
    }

    @Override // defpackage.dt2
    public void X() {
        EditText editText = this.f;
        if (editText != null) {
            int selectionStart = editText.getSelectionStart();
            String obj = this.f.getText().toString();
            if (selectionStart > 0) {
                int i = selectionStart - 1;
                if (!"]".equals(obj.substring(i, selectionStart))) {
                    this.f.getText().delete(i, selectionStart);
                    return;
                }
                int lastIndexOf = obj.lastIndexOf("[", selectionStart);
                EditText editText2 = this.f;
                if (lastIndexOf >= 0) {
                    editText2.getText().delete(lastIndexOf, selectionStart);
                } else {
                    editText2.getText().delete(i, selectionStart);
                }
            }
        }
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return u73.R;
    }

    @Override // defpackage.b1
    public void init() {
        LayoutInflater from = LayoutInflater.from(this.mContext);
        ViewGroup viewGroup = (ViewGroup) findViewById(y63.K);
        View inflate = from.inflate(this.q, viewGroup, false);
        this.w = inflate;
        EditText editText = (EditText) inflate.findViewById(y63.D);
        this.f = editText;
        this.F = editText.getHint().toString();
        this.f.setOnEditorActionListener(new a());
        if (this.v) {
            ((InterceptFrameLayout) inflate.findViewById(y63.E)).setOnInterceptListener(new b());
        }
        ImageView imageView = (ImageView) inflate.findViewById(y63.s);
        boolean z = imageView != null;
        this.s = z;
        if (z) {
            this.d = imageView;
            this.k = o60.d(this.mContext, q83.t1);
            this.l = o60.d(this.mContext, g63.a);
            this.m = o60.d(this.mContext, g63.b);
            this.d.setImageDrawable(this.k);
            this.d.setOnClickListener(this);
            this.g = inflate.findViewById(y63.t);
            this.h = (TextView) inflate.findViewById(y63.m0);
            this.n = aq4.a(m93.E2);
            this.o = aq4.a(m93.L2);
            this.p = gk3.a().b() - zn0.a(40);
            this.g.setOnTouchListener(new c());
        }
        ImageView imageView2 = (ImageView) inflate.findViewById(y63.n);
        boolean z2 = imageView2 != null;
        this.t = z2;
        if (z2) {
            this.e = imageView2;
            Drawable d2 = o60.d(this.mContext, q83.r1);
            this.j = d2;
            this.e.setImageDrawable(d2);
            this.e.setOnClickListener(this);
            ViewGroup viewGroup2 = (ViewGroup) findViewById(y63.I);
            this.b = viewGroup2;
            View inflate2 = from.inflate(this.r, viewGroup2, false);
            inflate2.findViewById(y63.q).setOnClickListener(this);
            ViewPager findViewById = inflate2.findViewById(y63.o0);
            findViewById.getLayoutParams().height = (int) (((gk3.a().c() / 7.0f) * 3.0f) + 0.5f);
            findViewById.requestLayout();
            findViewById.setOffscreenPageLimit(10);
            RadioGroup radioGroup = (RadioGroup) inflate2.findViewById(y63.Y);
            gj1 gj1Var = new gj1(this.mContext, this);
            findViewById.setAdapter(gj1Var);
            findViewById.c(new d(radioGroup));
            int d3 = gj1Var.d();
            for (int i = 0; i < d3; i++) {
                RadioButton radioButton = (RadioButton) from.inflate(u73.Q, (ViewGroup) radioGroup, false);
                radioButton.setId(i + 10000);
                if (i == 0) {
                    radioButton.setChecked(true);
                }
                radioGroup.addView(radioButton);
            }
            this.b.addView(inflate2);
        }
        View findViewById2 = inflate.findViewById(y63.o);
        boolean z3 = findViewById2 != null;
        this.u = z3;
        if (z3) {
            findViewById2.setOnClickListener(this);
            this.c = (ViewGroup) findViewById(y63.J);
        }
        if (this.s || this.t) {
            this.i = o60.d(this.mContext, q83.s1);
        }
        viewGroup.addView(inflate);
        this.a = findViewById(y63.e0);
        this.B = (InputMethodManager) this.mContext.getSystemService("input_method");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == y63.s) {
            w0();
            return;
        }
        if (id == y63.n) {
            u0();
        } else if (id == y63.o) {
            L0();
        } else if (id == y63.q) {
            v0();
        }
    }

    @Override // defpackage.b1, defpackage.uy1
    public void onDestroy() {
        this.C = null;
        super.onDestroy();
    }

    @Override // defpackage.b1
    public void processArguments(Object... objArr) {
        int length = objArr.length;
        if (length > 0) {
            this.v = ((Boolean) objArr[0]).booleanValue();
        }
        if (length > 1) {
            this.q = ((Integer) objArr[1]).intValue();
        }
        if (length > 2) {
            this.r = ((Integer) objArr[2]).intValue();
        }
    }

    public void s0(View view) {
        this.c.addView(view);
    }

    public void t0() {
        EditText editText = this.f;
        if (editText != null) {
            editText.setText((CharSequence) null);
        }
    }

    public final void u0() {
        boolean z = this.v;
        boolean z2 = this.y;
        if (z) {
            if (z2) {
                this.E = true;
                A0();
                return;
            } else if (!this.x) {
                J0();
                return;
            } else {
                z0();
                CommonAppContext.A(new e(), 200L);
                return;
            }
        }
        if (z2) {
            A0();
            J0();
        } else if (!this.x) {
            J0();
        } else {
            z0();
            K0();
        }
    }

    public final void v0() {
        g gVar;
        EditText editText = this.f;
        if (editText != null) {
            String trim = editText.getText().toString().trim();
            if (TextUtils.isEmpty(trim) || (gVar = this.C) == null) {
                return;
            }
            gVar.a(trim);
        }
    }

    public final void w0() {
        if (!this.A) {
            M0();
        } else {
            D0();
            K0();
        }
    }

    public EditText y0() {
        return this.f;
    }

    public final void z0() {
        if (this.t) {
            ViewGroup viewGroup = this.b;
            if (viewGroup != null && viewGroup.getVisibility() != 8) {
                this.b.setVisibility(8);
            }
            ImageView imageView = this.e;
            if (imageView != null) {
                imageView.setImageDrawable(this.j);
            }
            this.x = false;
        }
    }
}
