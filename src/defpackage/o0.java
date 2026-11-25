package defpackage;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.yunbao.common.bean.LiveGiftBean;
import defpackage.v22;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public abstract class o0 extends b1 implements View.OnClickListener, v22.b, et2 {
    public boolean a;
    public ViewPager b;
    public RadioGroup c;
    public View d;
    public View e;
    public View f;
    public View g;
    public TextView h;
    public PopupWindow i;
    public Drawable j;
    public Drawable k;
    public v22 l;
    public String m;
    public String n;
    public String o;
    public b p;
    public LiveGiftBean q;

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
            RadioGroup radioGroup = o0.this.c;
            if (radioGroup == null || (radioButton = (RadioButton) radioGroup.getChildAt(i)) == null) {
                return;
            }
            radioButton.setChecked(true);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface b {
        void d(String str);

        void j(LiveGiftBean liveGiftBean);

        void l();

        void m();
    }

    public o0(Context context, ViewGroup viewGroup, Object... objArr) {
        super(context, viewGroup, objArr);
        this.a = true;
        this.m = SdkVersion.MINI_VERSION;
    }

    public LiveGiftBean a0() {
        return this.q;
    }

    public abstract int b0();

    @Override // v22.b
    public void c(LiveGiftBean liveGiftBean) {
        this.q = liveGiftBean;
        this.m = SdkVersion.MINI_VERSION;
        b bVar = this.p;
        if (bVar != null) {
            bVar.d(SdkVersion.MINI_VERSION);
        }
        TextView textView = this.h;
        if (textView != null) {
            textView.setText(this.m);
        }
        b bVar2 = this.p;
        if (bVar2 != null) {
            bVar2.j(liveGiftBean);
        }
        this.f.setEnabled(true);
        if (b0() != 1) {
            if (liveGiftBean.getType() == 1 || liveGiftBean.getType() == 3) {
                TextView textView2 = this.h;
                if (textView2 == null || textView2.getVisibility() != 0) {
                    return;
                }
                this.h.setVisibility(4);
                this.e.setVisibility(4);
                this.f.setBackgroundDrawable(this.k);
                return;
            }
            TextView textView3 = this.h;
            if (textView3 == null || textView3.getVisibility() == 0) {
                return;
            }
            this.h.setVisibility(0);
            this.e.setVisibility(0);
            this.f.setBackgroundDrawable(this.j);
        }
    }

    public final void d0() {
        PopupWindow popupWindow = this.i;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        this.i = null;
    }

    @Override // defpackage.et2
    /* renamed from: e0, reason: merged with bridge method [inline-methods] */
    public void onItemClick(String str, int i) {
        if (b0() != 1) {
            this.m = str;
            this.h.setText(str);
            d0();
            b bVar = this.p;
            if (bVar != null) {
                bVar.d(str);
            }
        }
    }

    public void f0(b bVar) {
        this.p = bVar;
    }

    public void g0(boolean z) {
        View view = this.g;
        if (view != null) {
            if (z) {
                if (view.getVisibility() != 0) {
                    this.g.setVisibility(0);
                }
            } else if (view.getVisibility() == 0) {
                this.g.setVisibility(4);
            }
        }
    }

    public final void h0() {
        View inflate = LayoutInflater.from(this.mContext).inflate(x73.w1, (ViewGroup) null);
        RecyclerView findViewById = inflate.findViewById(b73.B4);
        findViewById.setHasFixedSize(true);
        findViewById.setLayoutManager(new LinearLayoutManager(this.mContext, 1, true));
        o22 o22Var = new o22(this.mContext);
        o22Var.P(this);
        findViewById.setAdapter(o22Var);
        PopupWindow popupWindow = new PopupWindow(inflate, -2, -2, true);
        this.i = popupWindow;
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        this.i.setOutsideTouchable(true);
        this.i.showAtLocation(this.h, 85, zn0.a(70), zn0.a(40));
    }

    public void i0(List list) {
        v22 v22Var = new v22(this.mContext, list, b0());
        this.l = v22Var;
        v22Var.x(this);
        this.b.setAdapter(this.l);
        LayoutInflater from = LayoutInflater.from(this.mContext);
        int d = this.l.d();
        for (int i = 0; i < d; i++) {
            RadioButton radioButton = (RadioButton) from.inflate(x73.y1, (ViewGroup) this.c, false);
            radioButton.setId(i + 10000);
            if (i == 0) {
                radioButton.setChecked(true);
            }
            this.c.addView(radioButton);
        }
    }

    @Override // defpackage.b1
    public void init() {
        this.d = findViewById(b73.M3);
        this.e = findViewById(b73.b);
        this.f = findViewById(b73.Y0);
        this.g = findViewById(b73.Z0);
        this.h = (TextView) findViewById(b73.F);
        this.j = o60.d(this.mContext, h63.f);
        this.k = o60.d(this.mContext, h63.g);
        ViewPager findViewById = findViewById(b73.g6);
        this.b = findViewById;
        findViewById.setOffscreenPageLimit(5);
        this.b.c(new a());
        this.c = (RadioGroup) findViewById(b73.y4);
        this.f.setOnClickListener(this);
        TextView textView = this.h;
        if (textView != null) {
            textView.setOnClickListener(this);
        }
    }

    public boolean isFirstLoadData() {
        if (!this.a) {
            return false;
        }
        this.a = false;
        return true;
    }

    public abstract void loadData();

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b bVar;
        int id = view.getId();
        if (id == b73.Y0) {
            b bVar2 = this.p;
            if (bVar2 != null) {
                bVar2.m();
                return;
            }
            return;
        }
        if (id == b73.F) {
            h0();
        } else {
            if (id != b73.D || (bVar = this.p) == null) {
                return;
            }
            bVar.l();
        }
    }
}
