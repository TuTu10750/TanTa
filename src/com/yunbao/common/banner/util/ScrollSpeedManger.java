package com.yunbao.common.banner.util;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.h;
import androidx.viewpager2.widget.ViewPager2;
import com.yunbao.common.banner.Banner2;
import java.lang.reflect.Field;

/* loaded from: /tmp/classes2.dex */
public class ScrollSpeedManger extends LinearLayoutManager {
    public Banner2 I;

    /* loaded from: /tmp/classes2.dex */
    public class a extends h {
        public a(Context context) {
            super(context);
        }

        public int w(int i) {
            return ScrollSpeedManger.this.I.getScrollTime();
        }
    }

    public ScrollSpeedManger(Banner2 banner2, LinearLayoutManager linearLayoutManager) {
        super(banner2.getContext(), linearLayoutManager.z2(), false);
        this.I = banner2;
    }

    public static void a3(Banner2 banner2) {
        if (banner2.getScrollTime() < 100) {
            return;
        }
        try {
            ViewPager2 viewPager2 = banner2.getViewPager2();
            RecyclerView childAt = viewPager2.getChildAt(0);
            childAt.setOverScrollMode(2);
            ScrollSpeedManger scrollSpeedManger = new ScrollSpeedManger(banner2, childAt.getLayoutManager());
            childAt.setLayoutManager(scrollSpeedManger);
            Field declaredField = ViewPager2.class.getDeclaredField("g");
            declaredField.setAccessible(true);
            declaredField.set(viewPager2, scrollSpeedManger);
            Field declaredField2 = ViewPager2.class.getDeclaredField("o");
            declaredField2.setAccessible(true);
            Object obj = declaredField2.get(viewPager2);
            if (obj != null) {
                Field declaredField3 = obj.getClass().getDeclaredField("mLayoutManager");
                declaredField3.setAccessible(true);
                declaredField3.set(obj, scrollSpeedManger);
            }
            Field declaredField4 = ViewPager2.class.getDeclaredField("l");
            declaredField4.setAccessible(true);
            Object obj2 = declaredField4.get(viewPager2);
            if (obj2 != null) {
                Field declaredField5 = obj2.getClass().getDeclaredField("mLayoutManager");
                declaredField5.setAccessible(true);
                declaredField5.set(obj2, scrollSpeedManger);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void U1(RecyclerView recyclerView, RecyclerView.a0 a0Var, int i) {
        a aVar = new a(recyclerView.getContext());
        aVar.p(i);
        V1(aVar);
    }
}
