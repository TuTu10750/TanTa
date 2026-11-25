package defpackage;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.yunbao.common.custom.MyRadioButton;
import com.yunbao.live.activity.LiveActivity;
import com.yunbao.live.activity.LiveAudienceActivity;

/* loaded from: /tmp/classes2.dex */
public class i32 extends l0 implements View.OnClickListener, dt2 {
    public EditText A0;
    public CheckBox B0;
    public MyRadioButton C0;
    public String D0;
    public String E0;
    public ImageView F0;
    public FrameLayout G0;
    public boolean H0 = false;
    public InputMethodManager z0;

    /* loaded from: /tmp/classes2.dex */
    public class a implements TextView.OnEditorActionListener {
        public a() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 4) {
                return false;
            }
            i32.this.B2();
            return true;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            int length = charSequence.length();
            i32 i32Var = i32.this;
            if (length == 0) {
                i32Var.C0.a(false);
            } else {
                i32Var.C0.a(true);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c implements CompoundButton.OnCheckedChangeListener {
        public c() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            i32 i32Var = i32.this;
            if (z) {
                i32Var.A0.setHint(i32.this.D0);
            } else {
                i32Var.A0.setHint(i32.this.E0);
            }
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
            i32.this.A2();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            i32.this.D2();
        }
    }

    public static /* synthetic */ void s2(i32 i32Var, View view) {
        if (i32Var.H0) {
            i32Var.H0 = false;
            i32Var.C2(t83.y);
            i32Var.G0.setVisibility(8);
        } else {
            i32Var.H0 = true;
            i32Var.C2(t83.z);
            i32Var.G0.setVisibility(0);
        }
    }

    public final void A2() {
        if (this.z0 != null) {
            this.A0.clearFocus();
            this.z0.hideSoftInputFromWindow(this.A0.getWindowToken(), 0);
        }
    }

    public final void B2() {
        Object obj = this.x0;
        if ((obj instanceof LiveAudienceActivity) && ((LiveAudienceActivity) obj).I0 == 1) {
            t54.b("您已经被禁言");
            return;
        }
        String trim = this.A0.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            return;
        }
        boolean isChecked = this.B0.isChecked();
        Object obj2 = this.x0;
        if (isChecked) {
            ((LiveActivity) obj2).p2(trim);
        } else {
            ((LiveActivity) obj2).n2(trim);
        }
        this.A0.setText("");
    }

    @Override // defpackage.l0
    public void C0() {
        super.C0();
        this.x0 = null;
    }

    public final void C2(int i) {
        this.F0.setTag(Integer.valueOf(i));
        this.F0.setImageResource(i);
    }

    public final void D2() {
        if (this.z0 != null) {
            this.A0.requestFocus();
            this.z0.showSoftInput(this.A0, 2);
        }
    }

    public void N0() {
        super/*androidx.fragment.app.Fragment*/.N0();
        A2();
    }

    @Override // defpackage.dt2
    public void T(String str, int i) {
        EditText editText = this.A0;
        if (editText != null) {
            editText.getText().insert(this.A0.getSelectionStart(), iz0.a(str, i));
        }
    }

    @Override // defpackage.dt2
    public void X() {
        EditText editText = this.A0;
        if (editText != null) {
            int selectionStart = editText.getSelectionStart();
            String obj = this.A0.getText().toString();
            if (selectionStart > 0) {
                int i = selectionStart - 1;
                if (!"]".equals(obj.substring(i, selectionStart))) {
                    this.A0.getText().delete(i, selectionStart);
                    return;
                }
                int lastIndexOf = obj.lastIndexOf("[", selectionStart);
                EditText editText2 = this.A0;
                if (lastIndexOf >= 0) {
                    editText2.getText().delete(lastIndexOf, selectionStart);
                } else {
                    editText2.getText().delete(i, selectionStart);
                }
            }
        }
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
        return x73.I;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        B2();
    }

    @Override // defpackage.l0
    public void p2(Window window) {
        window.setWindowAnimations(s93.b);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        attributes.gravity = 80;
        window.setAttributes(attributes);
    }

    public void r0(Bundle bundle) {
        super.r0(bundle);
        this.z0 = (InputMethodManager) this.x0.getSystemService("input_method");
        this.A0 = (EditText) this.y0.findViewById(b73.j3);
        this.F0 = (ImageView) this.y0.findViewById(b73.T1);
        this.G0 = (FrameLayout) this.y0.findViewById(b73.z2);
        C2(t83.y);
        this.F0.setOnClickListener(new View.OnClickListener() { // from class: g32
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i32.s2(i32.this, view);
            }
        });
        this.A0.setOnEditorActionListener(new a());
        this.A0.addTextChangedListener(new b());
        this.B0 = (CheckBox) this.y0.findViewById(b73.H1);
        MyRadioButton myRadioButton = (MyRadioButton) this.y0.findViewById(b73.Y0);
        this.C0 = myRadioButton;
        myRadioButton.setOnClickListener(this);
        Bundle z = z();
        if (z == null) {
            return;
        }
        this.D0 = aq4.b(m93.j4, z.getString("danmuPrice"), z.getString("coinName"));
        this.E0 = aq4.a(m93.z4);
        this.B0.setOnCheckedChangeListener(new c());
        if (j30.q().Q()) {
            this.B0.setVisibility(8);
        }
        String string = z.getString("atName");
        if (!TextUtils.isEmpty(string)) {
            String a2 = rv3.a("@", string, " ");
            this.A0.setText(a2);
            this.A0.setSelection(a2.length());
        }
        LayoutInflater from = LayoutInflater.from(this.x0);
        final View inflate = from.inflate(x73.H1, this.G0, false);
        inflate.findViewById(y63.q).setOnClickListener(this);
        ViewPager findViewById = inflate.findViewById(y63.o0);
        findViewById.getLayoutParams().height = (int) (((gk3.a().c() / 7.0f) * 3.0f) + 0.5f);
        findViewById.requestLayout();
        findViewById.setOffscreenPageLimit(10);
        RadioGroup radioGroup = (RadioGroup) inflate.findViewById(y63.Y);
        gj1 gj1Var = new gj1(this.x0, this);
        findViewById.setAdapter(gj1Var);
        findViewById.c(new d(radioGroup));
        int d2 = gj1Var.d();
        for (int i = 0; i < d2; i++) {
            RadioButton radioButton = (RadioButton) from.inflate(u73.Q, (ViewGroup) radioGroup, false);
            radioButton.setId(i + 10000);
            if (i == 0) {
                radioButton.setChecked(true);
            }
            radioGroup.addView(radioButton);
        }
        this.G0.post(new Runnable() { // from class: h32
            @Override // java.lang.Runnable
            public final void run() {
                i32.this.G0.addView(inflate);
            }
        });
        int i2 = z.getInt("openFace");
        FrameLayout frameLayout = this.G0;
        if (i2 == 1) {
            frameLayout.setVisibility(0);
            this.H0 = true;
            C2(t83.z);
            this.A0.postDelayed(new e(), 200L);
            return;
        }
        frameLayout.setVisibility(8);
        this.H0 = false;
        C2(t83.y);
        this.A0.postDelayed(new f(), 200L);
    }
}
