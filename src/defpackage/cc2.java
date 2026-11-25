package defpackage;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewpager.widget.ViewPager;
import com.yunbao.main.activity.ActivePubActivity;
import com.yunbao.main.custom.MainHomePageTitleView;
import com.yunbao.main.views.CurvedLinePagerIndicator;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class cc2 extends x0 {
    public int f;
    public List g;
    public CurvedLinePagerIndicator h;
    public oa2 i;
    public ob2 j;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public final /* synthetic */ int a;

        public a(int i) {
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewPager viewPager;
            if (j30.q().L() || (viewPager = cc2.this.a) == null) {
                return;
            }
            viewPager.setCurrentItem(this.a);
        }
    }

    public cc2(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    @Override // defpackage.x0
    public bi1 a0(Context context, String[] strArr, int i) {
        MainHomePageTitleView mainHomePageTitleView = new MainHomePageTitleView(context);
        mainHomePageTitleView.setPadding(zn0.a(8), 0, zn0.a(8), 0);
        mainHomePageTitleView.setNormalColor(o60.b(this.mContext, p53.h));
        mainHomePageTitleView.setSelectedColor(o60.b(this.mContext, p53.d));
        mainHomePageTitleView.setNormalTextSize(14);
        mainHomePageTitleView.setSelectedTextSize(16);
        mainHomePageTitleView.setText(strArr[i]);
        mainHomePageTitleView.setTextSize(18.0f);
        mainHomePageTitleView.getPaint().setFakeBoldText(true);
        mainHomePageTitleView.setOnClickListener(new a(i));
        this.g.add(mainHomePageTitleView);
        return mainHomePageTitleView;
    }

    @Override // defpackage.x0
    public zh1 b0(Context context) {
        CurvedLinePagerIndicator curvedLinePagerIndicator = new CurvedLinePagerIndicator(context);
        curvedLinePagerIndicator.setMode(1);
        curvedLinePagerIndicator.setXOffset(zn0.a(5));
        curvedLinePagerIndicator.setCurveHeight(zn0.a(2));
        curvedLinePagerIndicator.setColors(this.f);
        curvedLinePagerIndicator.setLineWidth(20.0f);
        curvedLinePagerIndicator.setLineScale(0.3f);
        this.h = curvedLinePagerIndicator;
        return curvedLinePagerIndicator;
    }

    @Override // defpackage.x0
    public int d0() {
        return 2;
    }

    @Override // defpackage.x0
    public String[] e0() {
        return new String[]{"消息", "广场"};
    }

    @Override // defpackage.x0
    public void f0(int i) {
        if (this.c == null) {
            return;
        }
        int i2 = 0;
        while (true) {
            boolean z = true;
            if (i2 >= this.g.size()) {
                break;
            }
            MainHomePageTitleView mainHomePageTitleView = (MainHomePageTitleView) this.g.get(i2);
            if (i2 != i) {
                z = false;
            }
            mainHomePageTitleView.b(z);
            i2++;
        }
        v0 v0Var = this.c[i];
        v0 v0Var2 = v0Var;
        if (v0Var == null) {
            List list = this.e;
            v0Var2 = v0Var;
            if (list != null) {
                v0Var2 = v0Var;
                if (i < list.size()) {
                    FrameLayout frameLayout = (FrameLayout) this.e.get(i);
                    v0 v0Var3 = v0Var;
                    if (frameLayout == null) {
                        return;
                    }
                    if (i == 0) {
                        ob2 ob2Var = new ob2(this.mContext, frameLayout);
                        this.j = ob2Var;
                        v0Var3 = ob2Var;
                    } else if (i == 1) {
                        oa2 oa2Var = new oa2(this.mContext, frameLayout);
                        this.i = oa2Var;
                        v0Var3 = oa2Var;
                    }
                    if (v0Var3 == null) {
                        return;
                    }
                    this.c[i] = v0Var3;
                    v0Var3.addToParent();
                    v0Var3.subscribeActivityLifeCycle();
                    v0Var2 = v0Var3;
                }
            }
        }
        v0[] v0VarArr = this.c;
        if (v0VarArr != null) {
            int length = v0VarArr.length;
            int i3 = 0;
            while (i3 < length) {
                v0 v0Var4 = this.c[i3];
                if (v0Var4 != null) {
                    v0Var4.setShowed(i == i3);
                }
                i3++;
            }
        }
        if (v0Var2 != null) {
            v0Var2.loadData();
        }
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return y73.X;
    }

    @Override // defpackage.x0, defpackage.b1
    public void init() {
        setStatusHeight();
        findViewById(c73.d5).setOnClickListener(new View.OnClickListener() { // from class: bc2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r0.mContext.startActivity(new Intent(cc2.this.mContext, (Class<?>) ActivePubActivity.class));
            }
        });
        this.f = o60.b(this.mContext, p53.d);
        this.g = new ArrayList();
        super.init();
    }

    @Override // defpackage.x0, defpackage.b1, defpackage.uy1
    public void onPause() {
        super.onPause();
        if (isShowed()) {
            this.d = true;
        }
    }

    @Override // defpackage.x0, defpackage.b1, defpackage.uy1
    public void onResume() {
        super.onResume();
        if (isShowed()) {
            this.d = false;
        }
    }

    @Override // defpackage.y0
    public void setShowed(boolean z) {
        super.setShowed(z);
        v0[] v0VarArr = this.c;
        if (v0VarArr != null) {
            int length = v0VarArr.length;
            int i = 0;
            while (i < length) {
                v0 v0Var = this.c[i];
                if (v0Var != null) {
                    v0Var.setShowed(i == 0);
                }
                i++;
            }
        }
    }
}
