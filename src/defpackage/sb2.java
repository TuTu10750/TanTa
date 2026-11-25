package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewpager.widget.ViewPager;
import com.yunbao.common.activity.WebViewActivity;
import com.yunbao.main.custom.MainHomePageTitleView;
import com.yunbao.main.views.CurvedLinePagerIndicator;
import java.util.ArrayList;
import java.util.List;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;

/* loaded from: /tmp/classes2.dex */
public class sb2 extends y0 {
    public sa2 a;
    public ac2 b;
    public ViewPager c;
    public List d;
    public CurvedLinePagerIndicator e;
    public int f;
    public MagicIndicator g;
    public int h;
    public List i;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String kefu = j30.q().h().getKefu();
            if (kefu.isEmpty()) {
                return;
            }
            WebViewActivity.F1(sb2.this.mContext, kefu, "在线客服");
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements ViewPager.j {
        public b() {
        }

        public void a(int i, float f, int i2) {
        }

        public void b(int i) {
        }

        public void c(int i) {
            sb2.this.h = i;
            sb2.this.g.a(2);
            sb2.this.g.c(i);
            sb2.this.g.b(i, 0.0f, 0);
            sb2.this.g.a(0);
            if (i == 0) {
                sb2.this.b.loadData();
            }
            if (i == 1) {
                sb2.this.a.loadData();
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends n30 {
        public final /* synthetic */ String[] b;

        /* loaded from: /tmp/classes2.dex */
        public class a implements View.OnClickListener {
            public final /* synthetic */ int a;

            public a(int i) {
                this.a = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i = sb2.this.h;
                int i2 = this.a;
                if (i == i2) {
                    return;
                }
                sb2.this.h = i2;
                sb2.this.g.a(2);
                sb2.this.g.c(this.a);
                sb2.this.g.b(this.a, 0.0f, 0);
                sb2.this.g.a(0);
                sb2.this.c.setCurrentItem(this.a);
            }
        }

        public c(String[] strArr) {
            this.b = strArr;
        }

        @Override // defpackage.n30
        public int a() {
            return this.b.length;
        }

        @Override // defpackage.n30
        public zh1 b(Context context) {
            CurvedLinePagerIndicator curvedLinePagerIndicator = new CurvedLinePagerIndicator(context);
            curvedLinePagerIndicator.setMode(1);
            curvedLinePagerIndicator.setXOffset(zn0.a(5));
            curvedLinePagerIndicator.setCurveHeight(zn0.a(2));
            curvedLinePagerIndicator.setColors(sb2.this.f);
            curvedLinePagerIndicator.setLineWidth(20.0f);
            curvedLinePagerIndicator.setLineScale(0.3f);
            sb2.this.e = curvedLinePagerIndicator;
            return curvedLinePagerIndicator;
        }

        @Override // defpackage.n30
        public bi1 c(Context context, int i) {
            MainHomePageTitleView mainHomePageTitleView = new MainHomePageTitleView(context);
            mainHomePageTitleView.setPadding(zn0.a(8), 0, zn0.a(8), 0);
            mainHomePageTitleView.setNormalColor(o60.b(sb2.this.mContext, p53.h));
            mainHomePageTitleView.setSelectedColor(o60.b(sb2.this.mContext, p53.d));
            mainHomePageTitleView.setNormalTextSize(14);
            mainHomePageTitleView.setSelectedTextSize(16);
            mainHomePageTitleView.setText(this.b[i]);
            mainHomePageTitleView.setTextSize(18.0f);
            mainHomePageTitleView.getPaint().setFakeBoldText(true);
            mainHomePageTitleView.setOnClickListener(new a(i));
            return mainHomePageTitleView;
        }
    }

    public sb2(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
        this.i = j30.q().t();
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return y73.U0;
    }

    @Override // defpackage.b1
    public void init() {
        setStatusHeight();
        this.d = new ArrayList();
        this.f = o60.b(this.mContext, p53.d);
        this.c = findViewById(c73.z5);
        findViewById(c73.n3).setOnClickListener(new a());
        ArrayList arrayList = new ArrayList();
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.b = new ac2(this.mContext, frameLayout);
        FrameLayout frameLayout2 = new FrameLayout(this.mContext);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        sa2 sa2Var = new sa2(this.mContext, frameLayout2);
        this.a = sa2Var;
        sa2Var.addToParent();
        this.a.subscribeActivityLifeCycle();
        this.b.addToParent();
        this.b.subscribeActivityLifeCycle();
        this.b.loadData();
        this.a.loadData();
        arrayList.add(frameLayout);
        arrayList.add(frameLayout2);
        this.c.setAdapter(new dk4(arrayList));
        this.c.c(new b());
        this.g = (MagicIndicator) findViewById(d73.E2);
        CommonNavigator commonNavigator = new CommonNavigator(this.mContext);
        commonNavigator.setAdapter(new c(new String[]{"VIP", "充值"}));
        commonNavigator.setAdjustMode(true);
        this.g.setNavigator(commonNavigator);
        this.c.setCurrentItem(j30.q().h().getRecharge_config() != 1 ? 0 : 1);
    }

    @Override // defpackage.y0
    public void loadData() {
        super.loadData();
        if (this.h == 0) {
            this.b.loadData();
        }
        if (this.h == 1) {
            this.a.loadData();
        }
    }
}
