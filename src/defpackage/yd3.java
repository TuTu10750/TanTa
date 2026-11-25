package defpackage;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.zhpan.bannerview.provider.ScrollDurationManger;
import java.lang.reflect.Field;

/* loaded from: /tmp/classes2.dex */
public abstract class yd3 {
    public static void a(ViewPager2 viewPager2, int i) {
        try {
            RecyclerView childAt = viewPager2.getChildAt(0);
            childAt.setOverScrollMode(2);
            LinearLayoutManager layoutManager = childAt.getLayoutManager();
            if (layoutManager == null) {
                return;
            }
            ScrollDurationManger scrollDurationManger = new ScrollDurationManger(viewPager2, i, layoutManager);
            childAt.setLayoutManager(scrollDurationManger);
            Field declaredField = RecyclerView.o.class.getDeclaredField("b");
            declaredField.setAccessible(true);
            declaredField.set(layoutManager, childAt);
            Field declaredField2 = ViewPager2.class.getDeclaredField("g");
            declaredField2.setAccessible(true);
            declaredField2.set(viewPager2, scrollDurationManger);
            Field declaredField3 = ViewPager2.class.getDeclaredField("o");
            declaredField3.setAccessible(true);
            Object obj = declaredField3.get(viewPager2);
            if (obj != null) {
                Field declaredField4 = obj.getClass().getDeclaredField("mLayoutManager");
                declaredField4.setAccessible(true);
                declaredField4.set(obj, scrollDurationManger);
            }
            Field declaredField5 = ViewPager2.class.getDeclaredField("l");
            declaredField5.setAccessible(true);
            Object obj2 = declaredField5.get(viewPager2);
            if (obj2 != null) {
                Field declaredField6 = obj2.getClass().getDeclaredField("mLayoutManager");
                declaredField6.setAccessible(true);
                declaredField6.set(obj2, scrollDurationManger);
            }
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
