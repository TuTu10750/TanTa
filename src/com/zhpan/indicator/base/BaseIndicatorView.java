package com.zhpan.indicator.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import com.umeng.analytics.pro.bv;
import com.umeng.analytics.pro.g;
import defpackage.dq1;
import defpackage.io1;
import defpackage.mh1;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000M\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\b\u0005*\u0001J\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B!\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0018\u0010\u0012J\r\u0010\u0019\u001a\u00020\f¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\f¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001e\u001a\u00020\f¢\u0006\u0004\b\u001e\u0010\u001aJ\u0017\u0010 \u001a\u00020\u000e2\b\b\u0001\u0010\u001f\u001a\u00020\f¢\u0006\u0004\b \u0010\u001dJ\u0015\u0010\"\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u0007¢\u0006\u0004\b\"\u0010\u0014J\r\u0010#\u001a\u00020\u0007¢\u0006\u0004\b#\u0010$J\r\u0010%\u001a\u00020\f¢\u0006\u0004\b%\u0010\u001aJ\u0015\u0010'\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\f¢\u0006\u0004\b'\u0010\u001dJ\u0017\u0010)\u001a\u00020\u000e2\b\b\u0001\u0010(\u001a\u00020\u0007¢\u0006\u0004\b)\u0010\u0014J\r\u0010*\u001a\u00020\u0007¢\u0006\u0004\b*\u0010$J\u0017\u0010+\u001a\u00020\u000e2\b\b\u0001\u0010(\u001a\u00020\u0007¢\u0006\u0004\b+\u0010\u0014J\r\u0010,\u001a\u00020\f¢\u0006\u0004\b,\u0010\u001aJ\u0015\u0010.\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020\f¢\u0006\u0004\b.\u0010\u001dJ\r\u0010/\u001a\u00020\u0007¢\u0006\u0004\b/\u0010$J\u0015\u00101\u001a\u00020\u00002\u0006\u00100\u001a\u00020\u0007¢\u0006\u0004\b1\u00102J\r\u00103\u001a\u00020\u0007¢\u0006\u0004\b3\u0010$J\u0015\u00106\u001a\u00020\u000e2\u0006\u00105\u001a\u000204¢\u0006\u0004\b6\u00107J\u0015\u00106\u001a\u00020\u000e2\u0006\u00109\u001a\u000208¢\u0006\u0004\b6\u0010:J\u0017\u0010<\u001a\u00020\u000e2\u0006\u0010;\u001a\u00020\u0007H\u0016¢\u0006\u0004\b<\u0010\u0014J\u0017\u0010?\u001a\u00020\u000e2\u0006\u0010>\u001a\u00020=H\u0016¢\u0006\u0004\b?\u0010@R\"\u0010E\u001a\u00020=8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010@R\u0018\u0010G\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010FR\u0018\u0010I\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010HR\u0014\u0010L\u001a\u00020J8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010KR\u0011\u0010\u001f\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\bM\u0010\u001a¨\u0006N"}, d2 = {"Lcom/zhpan/indicator/base/BaseIndicatorView;", "Landroid/view/View;", "Lmh1;", "Landroid/content/Context;", g.X, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "position", "", "positionOffset", "Lqc4;", "e", "(IF)V", "g", "()V", bv.aF, "(I)V", "positionOffsetPixels", bv.av, "(IFI)V", "d", "getNormalSlideWidth", "()F", "normalSliderWidth", "setNormalSlideWidth", "(F)V", "getCheckedSlideWidth", "checkedSliderWidth", "setCheckedSlideWidth", "currentPosition", "setCurrentPosition", "getCurrentPosition", "()I", "getIndicatorGap", "indicatorGap", "setIndicatorGap", "normalColor", "setCheckedColor", "getCheckedColor", "setNormalColor", "getSlideProgress", "slideProgress", "setSlideProgress", "getPageSize", "pageSize", "f", "(I)Lcom/zhpan/indicator/base/BaseIndicatorView;", "getSlideMode", "Landroidx/viewpager/widget/ViewPager;", "viewPager", "setupWithViewPager", "(Landroidx/viewpager/widget/ViewPager;)V", "Landroidx/viewpager2/widget/ViewPager2;", "viewPager2", "(Landroidx/viewpager2/widget/ViewPager2;)V", "state", "b", "Lio1;", "options", "setIndicatorOptions", "(Lio1;)V", "Lio1;", "getMIndicatorOptions", "()Lio1;", "setMIndicatorOptions", "mIndicatorOptions", "Landroidx/viewpager/widget/ViewPager;", "mViewPager", "Landroidx/viewpager2/widget/ViewPager2;", "mViewPager2", "com/zhpan/indicator/base/BaseIndicatorView$a", "Lcom/zhpan/indicator/base/BaseIndicatorView$a;", "mOnPageChangeCallback", "getCheckedSliderWidth", "indicator_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: /tmp/classes2.dex */
public class BaseIndicatorView extends View implements mh1 {

    /* renamed from: a, reason: from kotlin metadata */
    public io1 mIndicatorOptions;

    /* renamed from: b, reason: from kotlin metadata */
    public ViewPager mViewPager;

    /* renamed from: c, reason: from kotlin metadata */
    public ViewPager2 mViewPager2;

    /* renamed from: d, reason: from kotlin metadata */
    public final a mOnPageChangeCallback;

    /* loaded from: /tmp/classes2.dex */
    public static final class a extends ViewPager2.i {
        public a() {
        }

        public void a(int i) {
            BaseIndicatorView.this.b(i);
        }

        public void b(int i, float f, int i2) {
            BaseIndicatorView.this.a(i, f, i2);
        }

        public void c(int i) {
            BaseIndicatorView.this.c(i);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseIndicatorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        context.getClass();
        this.mOnPageChangeCallback = new a();
        this.mIndicatorOptions = new io1();
    }

    public void a(int position, float positionOffset, int positionOffsetPixels) {
        if (getSlideMode() == 0 || getPageSize() <= 1) {
            return;
        }
        e(position, positionOffset);
        invalidate();
    }

    public void b(int state) {
    }

    public void c(int position) {
        if (getSlideMode() == 0) {
            setCurrentPosition(position);
            setSlideProgress(0.0f);
            invalidate();
        }
    }

    public void d() {
        g();
        requestLayout();
        invalidate();
    }

    public final void e(int position, float positionOffset) {
        if (this.mIndicatorOptions.j() == 4 || this.mIndicatorOptions.j() == 5) {
            setCurrentPosition(position);
            setSlideProgress(positionOffset);
        } else if (position % getPageSize() != getPageSize() - 1) {
            setCurrentPosition(position);
            setSlideProgress(positionOffset);
        } else if (positionOffset < 0.5d) {
            setCurrentPosition(position);
            setSlideProgress(0.0f);
        } else {
            setCurrentPosition(0);
            setSlideProgress(0.0f);
        }
    }

    public final BaseIndicatorView f(int pageSize) {
        this.mIndicatorOptions.v(pageSize);
        return this;
    }

    public final void g() {
        ViewPager viewPager = this.mViewPager;
        if (viewPager != null) {
            if (viewPager != null) {
                viewPager.I(this);
            }
            ViewPager viewPager2 = this.mViewPager;
            if (viewPager2 != null) {
                viewPager2.c(this);
            }
            ViewPager viewPager3 = this.mViewPager;
            if (viewPager3 != null && viewPager3.getAdapter() != null) {
                ViewPager viewPager4 = this.mViewPager;
                if (viewPager4 == null) {
                    dq1.g();
                }
                xv2 adapter = viewPager4.getAdapter();
                if (adapter == null) {
                    dq1.g();
                }
                adapter.getClass();
                f(adapter.d());
            }
        }
        ViewPager2 viewPager22 = this.mViewPager2;
        if (viewPager22 != null) {
            if (viewPager22 != null) {
                viewPager22.n(this.mOnPageChangeCallback);
            }
            ViewPager2 viewPager23 = this.mViewPager2;
            if (viewPager23 != null) {
                viewPager23.g(this.mOnPageChangeCallback);
            }
            ViewPager2 viewPager24 = this.mViewPager2;
            if (viewPager24 == null || viewPager24.getAdapter() == null) {
                return;
            }
            ViewPager2 viewPager25 = this.mViewPager2;
            if (viewPager25 == null) {
                dq1.g();
            }
            RecyclerView.Adapter adapter2 = viewPager25.getAdapter();
            if (adapter2 == null) {
                dq1.g();
            }
            adapter2.getClass();
            f(adapter2.j());
        }
    }

    public final int getCheckedColor() {
        return this.mIndicatorOptions.a();
    }

    public final float getCheckedSlideWidth() {
        return this.mIndicatorOptions.b();
    }

    public final float getCheckedSliderWidth() {
        return this.mIndicatorOptions.b();
    }

    public final int getCurrentPosition() {
        return this.mIndicatorOptions.c();
    }

    public final float getIndicatorGap() {
        return this.mIndicatorOptions.l();
    }

    public final io1 getMIndicatorOptions() {
        return this.mIndicatorOptions;
    }

    public final float getNormalSlideWidth() {
        return this.mIndicatorOptions.f();
    }

    public final int getPageSize() {
        return this.mIndicatorOptions.h();
    }

    public final int getSlideMode() {
        return this.mIndicatorOptions.j();
    }

    public final float getSlideProgress() {
        return this.mIndicatorOptions.k();
    }

    public final void setCheckedColor(int normalColor) {
        this.mIndicatorOptions.o(normalColor);
    }

    public final void setCheckedSlideWidth(float checkedSliderWidth) {
        this.mIndicatorOptions.p(checkedSliderWidth);
    }

    public final void setCurrentPosition(int currentPosition) {
        this.mIndicatorOptions.q(currentPosition);
    }

    public final void setIndicatorGap(float indicatorGap) {
        this.mIndicatorOptions.z(indicatorGap);
    }

    public void setIndicatorOptions(io1 options) {
        options.getClass();
        this.mIndicatorOptions = options;
    }

    public final void setMIndicatorOptions(io1 io1Var) {
        io1Var.getClass();
        this.mIndicatorOptions = io1Var;
    }

    public final void setNormalColor(int normalColor) {
        this.mIndicatorOptions.s(normalColor);
    }

    public final void setNormalSlideWidth(float normalSliderWidth) {
        this.mIndicatorOptions.t(normalSliderWidth);
    }

    public final void setSlideProgress(float slideProgress) {
        this.mIndicatorOptions.x(slideProgress);
    }

    public final void setupWithViewPager(ViewPager viewPager) {
        viewPager.getClass();
        this.mViewPager = viewPager;
        d();
    }

    public final void setupWithViewPager(ViewPager2 viewPager2) {
        viewPager2.getClass();
        this.mViewPager2 = viewPager2;
        d();
    }
}
