package defpackage;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewpager.widget.ViewPager;
import java.util.ArrayList;
import java.util.List;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;

/* loaded from: /tmp/classes2.dex */
public abstract class x0 extends y0 {
    public ViewPager a;
    public MagicIndicator b;
    public v0[] c;
    public boolean d;
    public List e;

    /* loaded from: /tmp/classes2.dex */
    public class a implements ViewPager.j {
        public a() {
        }

        public void a(int i, float f, int i2) {
        }

        public void b(int i) {
        }

        public void c(int i) {
            x0.this.f0(i);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends n30 {
        public final /* synthetic */ String[] b;

        public b(String[] strArr) {
            this.b = strArr;
        }

        @Override // defpackage.n30
        public int a() {
            return this.b.length;
        }

        @Override // defpackage.n30
        public zh1 b(Context context) {
            return x0.this.b0(context);
        }

        @Override // defpackage.n30
        public bi1 c(Context context, int i) {
            return x0.this.a0(context, this.b, i);
        }
    }

    public x0(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    public abstract bi1 a0(Context context, String[] strArr, int i);

    public abstract zh1 b0(Context context);

    public abstract int d0();

    public abstract String[] e0();

    public abstract void f0(int i);

    @Override // defpackage.b1
    public void init() {
        this.e = new ArrayList();
        int d0 = d0();
        for (int i = 0; i < d0; i++) {
            FrameLayout frameLayout = new FrameLayout(this.mContext);
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.e.add(frameLayout);
        }
        this.c = new v0[d0];
        ViewPager findViewById = findViewById(c73.y5);
        this.a = findViewById;
        if (d0 > 1) {
            findViewById.setOffscreenPageLimit(d0 - 1);
        }
        this.a.setAdapter(new dk4(this.e));
        this.a.c(new a());
        this.b = (MagicIndicator) findViewById(c73.V2);
        String[] e0 = e0();
        CommonNavigator commonNavigator = new CommonNavigator(this.mContext);
        commonNavigator.setAdapter(new b(e0));
        this.b.setNavigator(commonNavigator);
        ek4.a(this.b, this.a);
    }

    @Override // defpackage.y0
    public void loadData() {
        ViewPager viewPager = this.a;
        if (viewPager != null) {
            f0(viewPager.getCurrentItem());
        }
    }

    @Override // defpackage.b1, defpackage.uy1
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // defpackage.b1, defpackage.uy1
    public void onPause() {
        super.onPause();
        this.d = true;
    }

    @Override // defpackage.b1, defpackage.uy1
    public void onResume() {
        super.onResume();
        if (isShowed() && this.d) {
            loadData();
        }
        this.d = false;
    }
}
