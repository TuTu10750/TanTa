package defpackage;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.viewpager.widget.ViewPager;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.live.activity.LiveActivity;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class a52 extends b1 implements View.OnClickListener {
    public boolean a;
    public int b;
    public int c;
    public ViewPager d;
    public xv2 e;
    public RadioGroup f;
    public List g;
    public Handler h;

    /* loaded from: /tmp/classes2.dex */
    public class a implements ViewPager.j {
        public a() {
        }

        public void a(int i, float f, int i2) {
        }

        public void b(int i) {
        }

        public void c(int i) {
            RadioButton radioButton;
            if (a52.this.f != null && (radioButton = (RadioButton) a52.this.f.getChildAt(i)) != null) {
                radioButton.setChecked(true);
            }
            if (a52.this.h != null) {
                a52.this.h.removeCallbacksAndMessages(null);
                a52.this.h.sendEmptyMessageDelayed(0, 3000L);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends Handler {
        public b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (a52.this.d == null || a52.this.e == null) {
                return;
            }
            int currentItem = a52.this.d.getCurrentItem();
            int i = currentItem < a52.this.e.d() - 1 ? currentItem + 1 : 0;
            a52.this.d.M(i, i != 0);
        }
    }

    public a52(Context context, ViewGroup viewGroup, boolean z, int i, int i2) {
        super(context, viewGroup, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2));
    }

    public void f0(int i) {
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return x73.m2;
    }

    @Override // defpackage.b1
    public void init() {
        this.d = findViewById(b73.g6);
        this.g = new ArrayList();
        LayoutInflater from = LayoutInflater.from(this.mContext);
        if (this.a) {
            View inflate = from.inflate(x73.n2, (ViewGroup) this.d, false);
            inflate.findViewById(b73.y0).setOnClickListener(this);
            this.g.add(inflate);
        }
        if (this.c == 1 && j30.q().N()) {
            View inflate2 = from.inflate(x73.o2, (ViewGroup) this.d, false);
            inflate2.findViewById(b73.h1).setOnClickListener(this);
            this.g.add(inflate2);
        }
        if (this.b >= 0) {
            View inflate3 = from.inflate(x73.D2, (ViewGroup) this.d, false);
            inflate3.findViewById(b73.K0).setOnClickListener(this);
            this.g.add(inflate3);
        }
        dk4 dk4Var = new dk4(this.g);
        this.e = dk4Var;
        this.d.setAdapter(dk4Var);
        this.f = (RadioGroup) findViewById(b73.y4);
        int size = this.g.size();
        for (int i = 0; i < size; i++) {
            RadioButton radioButton = (RadioButton) from.inflate(x73.z1, (ViewGroup) this.f, false);
            radioButton.setId(i + 10000);
            if (i == 0) {
                radioButton.setChecked(true);
            }
            this.f.addView(radioButton);
        }
        this.d.c(new a());
        if (this.g.size() > 1) {
            b bVar = new b();
            this.h = bVar;
            bVar.sendEmptyMessageDelayed(0, 3000L);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((AbsActivity) this.mContext).e1()) {
            int id = view.getId();
            if (id == b73.h1) {
                ((LiveActivity) this.mContext).Y1();
            } else if (id == b73.K0) {
                ((LiveActivity) this.mContext).i2();
            } else if (id == b73.y0) {
                ((LiveActivity) this.mContext).h2();
            }
        }
    }

    @Override // defpackage.b1, defpackage.uy1
    public void onDestroy() {
        release();
        super.onDestroy();
    }

    @Override // defpackage.b1
    public void processArguments(Object... objArr) {
        this.a = ((Boolean) objArr[0]).booleanValue();
        this.b = ((Integer) objArr[1]).intValue();
        this.c = ((Integer) objArr[2]).intValue();
    }

    @Override // defpackage.b1
    public void release() {
        Handler handler = this.h;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.h = null;
    }
}
