package com.yunbao.common.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import defpackage.aq4;
import defpackage.lx1;
import defpackage.m93;
import defpackage.s93;
import defpackage.t54;
import defpackage.u73;
import defpackage.y63;
import defpackage.zn0;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/* loaded from: /tmp/classes2.dex */
public abstract class a {

    /* renamed from: com.yunbao.common.utils.a$a, reason: collision with other inner class name */
    /* loaded from: /tmp/classes2.dex */
    public class ViewOnClickListenerC0031a implements View.OnClickListener {
        public final /* synthetic */ Dialog a;

        public ViewOnClickListenerC0031a(Dialog dialog) {
            this.a = dialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.dismiss();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements View.OnClickListener {
        public final /* synthetic */ n a;
        public final /* synthetic */ Dialog b;

        public b(n nVar, Dialog dialog) {
            this.a = nVar;
            this.b = dialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TextView textView = (TextView) view;
            n nVar = this.a;
            if (nVar != null) {
                nVar.a(textView.getText().toString(), ((Integer) view.getTag()).intValue());
            }
            this.b.dismiss();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c implements View.OnClickListener {
        public final /* synthetic */ Dialog a;

        public c(Dialog dialog) {
            this.a = dialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.dismiss();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d implements View.OnClickListener {
        public final /* synthetic */ n a;
        public final /* synthetic */ Dialog b;

        public d(n nVar, Dialog dialog) {
            this.a = nVar;
            this.b = dialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TextView textView = (TextView) view;
            n nVar = this.a;
            if (nVar != null) {
                nVar.a(textView.getText().toString(), ((Integer) view.getTag()).intValue());
            }
            this.b.dismiss();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e implements View.OnClickListener {
        public final /* synthetic */ Dialog a;

        public e(Dialog dialog) {
            this.a = dialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.dismiss();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class f implements View.OnClickListener {
        public final /* synthetic */ n a;
        public final /* synthetic */ Dialog b;

        public f(n nVar, Dialog dialog) {
            this.a = nVar;
            this.b = dialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TextView textView = (TextView) view;
            n nVar = this.a;
            if (nVar != null) {
                nVar.a(textView.getText().toString(), 0);
            }
            this.b.dismiss();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class g implements View.OnClickListener {
        public final /* synthetic */ Dialog a;

        public g(Dialog dialog) {
            this.a = dialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.dismiss();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class h implements DatePicker.OnDateChangedListener {
        public final /* synthetic */ Calendar a;

        public h(Calendar calendar) {
            this.a = calendar;
        }

        @Override // android.widget.DatePicker.OnDateChangedListener
        public void onDateChanged(DatePicker datePicker, int i, int i2, int i3) {
            this.a.set(i, i2, i3);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class i implements View.OnClickListener {
        public final /* synthetic */ k a;
        public final /* synthetic */ Calendar b;
        public final /* synthetic */ Dialog c;

        public i(k kVar, Calendar calendar, Dialog dialog) {
            this.a = kVar;
            this.b = calendar;
            this.c = dialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() != y63.j) {
                this.c.dismiss();
                return;
            }
            if (this.a != null) {
                if (this.b.getTime().getTime() > new Date().getTime()) {
                    t54.b(aq4.a(m93.D1));
                    return;
                }
                this.a.a(DateFormat.format("yyyy-MM-dd", this.b).toString());
                this.c.dismiss();
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static class j {
        public Context a;
        public String b;
        public String c;
        public String d;
        public String e;
        public boolean f;
        public int g;
        public int h;
        public boolean i;
        public boolean j;
        public boolean k;
        public boolean l = true;
        public String m;
        public int n;
        public int o;
        public m p;

        /* renamed from: com.yunbao.common.utils.a$j$a, reason: collision with other inner class name */
        /* loaded from: /tmp/classes2.dex */
        public class ViewOnClickListenerC0032a implements View.OnClickListener {
            public final /* synthetic */ Dialog a;
            public final /* synthetic */ TextView b;

            public ViewOnClickListenerC0032a(Dialog dialog, TextView textView) {
                this.a = dialog;
                this.b = textView;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() != y63.j) {
                    this.a.dismiss();
                    if (j.this.p instanceof l) {
                        ((l) j.this.p).a();
                        return;
                    }
                    return;
                }
                if (j.this.p == null) {
                    this.a.dismiss();
                } else if (j.this.k) {
                    j.this.p.b(this.a, this.b.getText().toString());
                } else {
                    this.a.dismiss();
                    j.this.p.b(this.a, "");
                }
            }
        }

        public j(Context context) {
            this.a = context;
        }

        public Dialog c() {
            Dialog dialog = new Dialog(this.a, this.j ? s93.c : s93.d);
            dialog.setContentView(this.k ? u73.m : u73.t);
            dialog.setCancelable(this.i);
            dialog.setCanceledOnTouchOutside(this.i);
            TextView textView = (TextView) dialog.findViewById(y63.h0);
            if (this.f) {
                textView.setVisibility(8);
            } else if (!TextUtils.isEmpty(this.b)) {
                textView.setText(this.b);
            }
            TextView textView2 = (TextView) dialog.findViewById(y63.y);
            if (!TextUtils.isEmpty(this.m)) {
                textView2.setHint(this.m);
            }
            if (!TextUtils.isEmpty(this.c)) {
                textView2.setText(this.c);
                if (!this.l) {
                    textView2.setGravity(3);
                }
            }
            int i = this.n;
            if (i == 1) {
                textView2.setInputType(2);
            } else if (i == 2) {
                textView2.setInputType(18);
            } else if (i == 3) {
                textView2.setInputType(128);
            }
            if (this.o > 0 && (textView2 instanceof EditText)) {
                textView2.setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.o)});
            }
            TextView textView3 = (TextView) dialog.findViewById(y63.j);
            if (!TextUtils.isEmpty(this.d)) {
                textView3.setText(this.d);
            }
            int i2 = this.g;
            if (i2 != 0) {
                textView3.setTextColor(i2);
            }
            TextView textView4 = (TextView) dialog.findViewById(y63.g);
            if (!TextUtils.isEmpty(this.e)) {
                textView4.setText(this.e);
            }
            int i3 = this.h;
            if (i3 != 0) {
                textView4.setTextColor(i3);
            }
            ViewOnClickListenerC0032a viewOnClickListenerC0032a = new ViewOnClickListenerC0032a(dialog, textView2);
            textView3.setOnClickListener(viewOnClickListenerC0032a);
            textView4.setOnClickListener(viewOnClickListenerC0032a);
            return dialog;
        }

        public j d(boolean z) {
            this.j = z;
            return this;
        }

        public j e(int i) {
            this.h = i;
            return this;
        }

        public j f(String str) {
            this.e = str;
            return this;
        }

        public j g(boolean z) {
            this.i = z;
            return this;
        }

        public j h(m mVar) {
            this.p = mVar;
            return this;
        }

        public j i(int i) {
            this.g = i;
            return this;
        }

        public j j(String str) {
            this.d = str;
            return this;
        }

        public j k(String str) {
            this.c = str;
            return this;
        }

        public j l(String str) {
            this.m = str;
            return this;
        }

        public j m(boolean z) {
            this.k = z;
            return this;
        }

        public j n(int i) {
            this.n = i;
            return this;
        }

        public j o(boolean z) {
            this.f = z;
            return this;
        }

        public j p(int i) {
            this.o = i;
            return this;
        }

        public j q(String str) {
            this.b = str;
            return this;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface k {
        void a(String str);
    }

    /* loaded from: /tmp/classes2.dex */
    public interface l extends m {
        void a();
    }

    /* loaded from: /tmp/classes2.dex */
    public interface m {
        void b(Dialog dialog, String str);
    }

    /* loaded from: /tmp/classes2.dex */
    public interface n {
        void a(String str, int i);
    }

    public static Activity a(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    public static boolean b(Context context) {
        if (context == null) {
            return false;
        }
        Activity a = a(context);
        if (a != null) {
            return (a.isFinishing() || a.isDestroyed()) ? false : true;
        }
        return true;
    }

    public static Dialog c(Context context) {
        return d(context, "");
    }

    public static Dialog d(Context context, String str) {
        TextView textView;
        Dialog dialog = new Dialog(context, s93.c);
        dialog.setContentView(u73.o);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        if (!TextUtils.isEmpty(str) && (textView = (TextView) dialog.findViewById(y63.f0)) != null) {
            textView.setText(str);
        }
        return dialog;
    }

    public static Dialog e(Context context) {
        Dialog dialog = new Dialog(context, s93.c);
        dialog.setContentView(u73.p);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        return dialog;
    }

    public static void f(Dialog dialog) {
        if (dialog == null || !b(dialog.getContext())) {
            return;
        }
        try {
            dialog.show();
        } catch (WindowManager.BadTokenException e2) {
            lx1.c("DialogUitl", "---show dialog bad token--->" + e2.getMessage());
        } catch (RuntimeException e3) {
            lx1.c("DialogUitl", "---show dialog error--->" + e3.getMessage());
        }
    }

    public static void g(Activity activity, ArrayList arrayList, String str, String str2, String str3, e eVar) {
        if (b(activity)) {
            s5 s5Var = new s5(activity, arrayList);
            s5Var.z(-13487566);
            s5Var.x(-2302756);
            s5Var.f(s93.b);
            s5Var.s(-6908266);
            s5Var.t(-42888);
            s5Var.v(-657931);
            s5Var.u(-657931);
            s5Var.j(zn0.a(250));
            s5Var.y(5);
            s5Var.H(false);
            s5Var.G(false);
            s5Var.A(0.33333334f, 0.33333334f, 0.33333334f);
            if (TextUtils.isEmpty(str)) {
                str = "北京市";
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = "北京市";
            }
            if (TextUtils.isEmpty(str3)) {
                str3 = "东城区";
            }
            s5Var.K(str, str2, str3);
            s5Var.I(eVar);
            try {
                s5Var.l();
            } catch (WindowManager.BadTokenException e2) {
                lx1.c("DialogUitl", "---show city picker bad token--->" + e2.getMessage());
            } catch (RuntimeException e3) {
                lx1.c("DialogUitl", "---show city picker error--->" + e3.getMessage());
            }
        }
    }

    public static void h(Context context, k kVar) {
        Dialog dialog = new Dialog(context, s93.c);
        dialog.setContentView(u73.i);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        DatePicker datePicker = (DatePicker) dialog.findViewById(y63.A);
        Calendar calendar = Calendar.getInstance();
        datePicker.init(calendar.get(1), calendar.get(2), calendar.get(5), new h(calendar));
        i iVar = new i(kVar, calendar, dialog);
        dialog.findViewById(y63.g).setOnClickListener(iVar);
        dialog.findViewById(y63.j).setOnClickListener(iVar);
        f(dialog);
    }

    public static void i(Context context, String str, m mVar) {
        k(context, str, true, mVar);
    }

    public static void j(Context context, String str, String str2, boolean z, m mVar) {
        f(new j(context).q(str).k(str2).g(z).h(mVar).c());
    }

    public static void k(Context context, String str, boolean z, m mVar) {
        j(context, null, str, z, mVar);
    }

    public static void l(Context context, String str, m mVar) {
        f(new j(context).k(str).d(true).g(true).h(mVar).c());
    }

    public static void m(Context context, String str) {
        o(context, null, str, false);
    }

    public static void n(Context context, String str, String str2) {
        o(context, str, str2, false);
    }

    public static void o(Context context, String str, String str2, boolean z) {
        q(context, str, false, str2, z);
    }

    public static void p(Context context, String str, boolean z) {
        o(context, null, str, z);
    }

    public static void q(Context context, String str, boolean z, String str2, boolean z2) {
        Dialog dialog = new Dialog(context, z2 ? s93.c : s93.d);
        dialog.setContentView(u73.u);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        TextView textView = (TextView) dialog.findViewById(y63.h0);
        if (z) {
            textView.setVisibility(8);
        } else if (!TextUtils.isEmpty(str)) {
            textView.setText(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            ((TextView) dialog.findViewById(y63.y)).setText(str2);
        }
        dialog.findViewById(y63.j).setOnClickListener(new ViewOnClickListenerC0031a(dialog));
        f(dialog);
    }

    public static void r(Context context, Integer[] numArr, n nVar) {
        Dialog dialog = new Dialog(context, s93.c);
        dialog.setContentView(u73.v);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        Window window = dialog.getWindow();
        window.setWindowAnimations(s93.b);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        attributes.gravity = 80;
        window.setAttributes(attributes);
        LinearLayout linearLayout = (LinearLayout) dialog.findViewById(y63.x);
        b bVar = new b(nVar, dialog);
        int length = numArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            TextView textView = new TextView(context);
            textView.setLayoutParams(new LinearLayout.LayoutParams(-1, zn0.a(50)));
            textView.setTextColor(-13487566);
            textView.setTextSize(2, 14.0f);
            textView.setGravity(17);
            textView.setText(numArr[i2].intValue());
            textView.setTag(numArr[i2]);
            textView.setOnClickListener(bVar);
            linearLayout.addView(textView);
            if (i2 != length - 1) {
                View view = new View(context);
                view.setLayoutParams(new LinearLayout.LayoutParams(-1, zn0.a(1)));
                view.setBackgroundColor(-657931);
                linearLayout.addView(view);
            }
        }
        dialog.findViewById(y63.g).setOnClickListener(new c(dialog));
        f(dialog);
    }

    public static void s(Context context, String[] strArr, n nVar) {
        Dialog dialog = new Dialog(context, s93.c);
        dialog.setContentView(u73.v);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        Window window = dialog.getWindow();
        window.setWindowAnimations(s93.b);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        attributes.gravity = 80;
        window.setAttributes(attributes);
        LinearLayout linearLayout = (LinearLayout) dialog.findViewById(y63.x);
        f fVar = new f(nVar, dialog);
        int length = strArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            TextView textView = new TextView(context);
            textView.setLayoutParams(new LinearLayout.LayoutParams(-1, zn0.a(50)));
            textView.setTextColor(-13487566);
            textView.setTextSize(2, 14.0f);
            textView.setGravity(17);
            textView.setText(strArr[i2]);
            textView.setTag(strArr[i2]);
            textView.setOnClickListener(fVar);
            linearLayout.addView(textView);
            if (i2 != length - 1) {
                View view = new View(context);
                view.setLayoutParams(new LinearLayout.LayoutParams(-1, zn0.a(1)));
                view.setBackgroundColor(-657931);
                linearLayout.addView(view);
            }
        }
        dialog.findViewById(y63.g).setOnClickListener(new g(dialog));
        f(dialog);
    }

    public static void t(Context context, Integer[][] numArr, n nVar) {
        Dialog dialog = new Dialog(context, s93.c);
        dialog.setContentView(u73.v);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        Window window = dialog.getWindow();
        window.setWindowAnimations(s93.b);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        attributes.gravity = 80;
        window.setAttributes(attributes);
        LinearLayout linearLayout = (LinearLayout) dialog.findViewById(y63.x);
        d dVar = new d(nVar, dialog);
        int length = numArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            TextView textView = new TextView(context);
            textView.setLayoutParams(new LinearLayout.LayoutParams(-1, zn0.a(50)));
            textView.setTextColor(numArr[i2][1].intValue());
            textView.setTextSize(2, 14.0f);
            textView.setGravity(17);
            textView.setText(numArr[i2][0].intValue());
            textView.setTag(numArr[i2][0]);
            textView.setOnClickListener(dVar);
            linearLayout.addView(textView);
            if (i2 != length - 1) {
                View view = new View(context);
                view.setLayoutParams(new LinearLayout.LayoutParams(-1, zn0.a(1)));
                view.setBackgroundColor(-657931);
                linearLayout.addView(view);
            }
        }
        dialog.findViewById(y63.g).setOnClickListener(new e(dialog));
        f(dialog);
    }
}
