package defpackage;

import android.os.Bundle;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.yunbao.live.bean.LiveVoiceFaceBean;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class r62 extends l0 {

    /* loaded from: /tmp/classes2.dex */
    public class a extends xv2 {
        public final /* synthetic */ List c;

        public a(List list) {
            this.c = list;
        }

        public void a(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) this.c.get(i));
        }

        public int d() {
            return this.c.size();
        }

        public Object h(ViewGroup viewGroup, int i) {
            View view = (View) this.c.get(i);
            viewGroup.addView(view);
            return view;
        }

        public boolean i(View view, Object obj) {
            return view == obj;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements ViewPager.j {
        public final /* synthetic */ RadioGroup a;

        public b(RadioGroup radioGroup) {
            this.a = radioGroup;
        }

        public void a(int i, float f, int i2) {
        }

        public void b(int i) {
        }

        public void c(int i) {
            RadioButton radioButton;
            RadioGroup radioGroup = this.a;
            if (radioGroup == null || (radioButton = (RadioButton) radioGroup.getChildAt(i)) == null) {
                return;
            }
            radioButton.setChecked(true);
        }
    }

    @Override // defpackage.l0
    public boolean f2() {
        return true;
    }

    @Override // defpackage.l0
    public int l2() {
        return s93.d;
    }

    @Override // defpackage.l0
    public int m2() {
        return x73.g0;
    }

    @Override // defpackage.l0
    public void p2(Window window) {
        window.setWindowAnimations(s93.b);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        attributes.gravity = 80;
        window.setAttributes(attributes);
    }

    public void r0(Bundle bundle) {
        super.r0(bundle);
        ArrayList arrayList = new ArrayList();
        SparseIntArray d = f32.d();
        int size = d.size();
        int i = size / 8;
        if (size % 8 > 0) {
            i++;
        }
        LayoutInflater from = LayoutInflater.from(this.x0);
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            RecyclerView recyclerView = (RecyclerView) from.inflate(x73.B1, (ViewGroup) null, false);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new GridLayoutManager(this.x0, 4, 1, false));
            int i4 = i3 + 8;
            if (i4 > size) {
                i4 = size;
            }
            ArrayList arrayList2 = new ArrayList();
            while (i3 < i4) {
                arrayList2.add(new LiveVoiceFaceBean(d.keyAt(i3), d.valueAt(i3)));
                i3++;
            }
            recyclerView.setAdapter(new q62(this.x0, from, arrayList2));
            arrayList.add(recyclerView);
            i2++;
            i3 = i4;
        }
        ViewPager k2 = k2(b73.g6);
        k2.setOffscreenPageLimit(arrayList.size() + 1);
        k2.setAdapter(new a(arrayList));
        RadioGroup radioGroup = (RadioGroup) k2(b73.y4);
        for (int i5 = 0; i5 < i; i5++) {
            RadioButton radioButton = (RadioButton) from.inflate(x73.y1, (ViewGroup) radioGroup, false);
            radioButton.setId(i5 + 10000);
            if (i5 == 0) {
                radioButton.setChecked(true);
            }
            radioGroup.addView(radioButton);
        }
        k2.c(new b(radioGroup));
    }
}
