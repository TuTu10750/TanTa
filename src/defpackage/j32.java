package defpackage;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.yunbao.live.custom.LiveLightView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class j32 {
    public Context a;
    public ViewGroup b;
    public int c;
    public int d;
    public PathMeasure[] e;
    public List f;
    public TimeInterpolator g;
    public boolean h;

    public j32(Context context, ViewGroup viewGroup) {
        LiveLightView.j = 0;
        this.a = context;
        this.b = viewGroup;
        gk3 a = gk3.a();
        this.c = (a.c() * 4) / 5;
        this.d = a.b() - zn0.a(50);
        this.e = new PathMeasure[6];
        int a2 = zn0.a(50);
        int a3 = zn0.a(100);
        int a4 = zn0.a(200);
        int a5 = zn0.a(300);
        Path path = new Path();
        path.lineTo(0.0f, 0.0f);
        path.moveTo(this.c, this.d);
        float f = -a3;
        float f2 = -a4;
        float f3 = -a5;
        path.rCubicTo(0.0f, f, f, f2, f, f3);
        this.e[0] = new PathMeasure(path, false);
        Path path2 = new Path();
        path2.lineTo(0.0f, 0.0f);
        path2.moveTo(this.c, this.d);
        float f4 = -a2;
        path2.rCubicTo(0.0f, f2, f4, f2, f4, f3);
        this.e[1] = new PathMeasure(path2, false);
        Path path3 = new Path();
        path3.lineTo(0.0f, 0.0f);
        path3.moveTo(this.c, this.d);
        float f5 = a3;
        path3.rCubicTo(f5, f, 0.0f, f3, f4, f3);
        this.e[2] = new PathMeasure(path3, false);
        Path path4 = new Path();
        path4.lineTo(0.0f, 0.0f);
        path4.moveTo(this.c, this.d);
        path4.rCubicTo(0.0f, f, f5, f2, 0.0f, f3);
        this.e[3] = new PathMeasure(path4, false);
        Path path5 = new Path();
        path5.lineTo(0.0f, 0.0f);
        path5.moveTo(this.c, this.d);
        float f6 = a2;
        path5.rCubicTo(0.0f, f2, f6, f2, f6, f3);
        this.e[4] = new PathMeasure(path5, false);
        Path path6 = new Path();
        path6.lineTo(0.0f, 0.0f);
        path6.moveTo(this.c, this.d);
        path6.rCubicTo(f, f, 0.0f, f3, f6, f3);
        this.e[5] = new PathMeasure(path6, false);
        this.f = new ArrayList();
        this.g = new AccelerateDecelerateInterpolator();
    }

    public void a() {
        this.h = true;
        List list = this.f;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((LiveLightView) it.next()).c();
            }
            this.f.clear();
        }
        this.a = null;
        this.b = null;
        this.e = null;
    }
}
