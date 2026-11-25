package com.zhpan.bannerview.provider;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.h;
import androidx.viewpager2.widget.ViewPager2;
import defpackage.jg;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: /tmp/classes2.dex */
public class ScrollDurationManger extends LinearLayoutManager {
    public final LinearLayoutManager I;
    public final int J;

    /* loaded from: /tmp/classes2.dex */
    public class a extends h {
        public a(Context context) {
            super(context);
        }

        public int w(int i) {
            return ScrollDurationManger.this.J;
        }
    }

    public ScrollDurationManger(ViewPager2 viewPager2, int i, LinearLayoutManager linearLayoutManager) {
        super(viewPager2.getContext(), linearLayoutManager.z2(), false);
        this.J = i;
        this.I = linearLayoutManager;
    }

    public boolean E1(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
        return false;
    }

    public void U1(RecyclerView recyclerView, RecyclerView.a0 a0Var, int i) {
        a aVar = new a(recyclerView.getContext());
        aVar.p(i);
        V1(aVar);
    }

    public void Y0(RecyclerView.v vVar, RecyclerView.a0 a0Var, m3 m3Var) {
        this.I.Y0(vVar, a0Var, m3Var);
    }

    public void Y1(RecyclerView.a0 a0Var, int[] iArr) {
        try {
            Method declaredMethod = this.I.getClass().getDeclaredMethod("calculateExtraLayoutSpace", a0Var.getClass(), iArr.getClass());
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(this.I, a0Var, iArr);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
            jg.e(e.getMessage());
        }
    }

    public boolean s1(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i, Bundle bundle) {
        return this.I.s1(vVar, a0Var, i, bundle);
    }
}
