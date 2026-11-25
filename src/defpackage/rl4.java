package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: /tmp/classes2.dex */
public class rl4 extends RecyclerView.Adapter {
    public final Context d;
    public String e = "";

    /* loaded from: /tmp/classes2.dex */
    public static class a extends RecyclerView.e0 {
        public TextView u;
        public ImageView v;

        public a(View view) {
            super(view);
            this.u = (TextView) view.findViewById(c73.W4);
            this.v = (ImageView) view.findViewById(c73.r3);
        }
    }

    public rl4(Context context) {
        this.d = context;
    }

    /* renamed from: L, reason: merged with bridge method [inline-methods] */
    public void z(a aVar, int i) {
        if (this.e.isEmpty()) {
            aVar.u.setVisibility(8);
            aVar.v.setVisibility(8);
            return;
        }
        aVar.u.setVisibility(0);
        aVar.v.setVisibility(0);
        kn1.f(this.d, this.e, aVar.v);
        ViewGroup.LayoutParams layoutParams = aVar.v.getLayoutParams();
        int c = gk3.a().c() - zn0.a(32);
        layoutParams.width = c;
        layoutParams.height = (c * 2) / 3;
        aVar.v.setLayoutParams(layoutParams);
        aVar.v.setScaleType(ImageView.ScaleType.FIT_CENTER);
    }

    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public a B(ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(y73.R0, viewGroup, false));
    }

    public void N(String str) {
        if (str == null) {
            str = "";
        }
        this.e = str;
        q(0);
    }

    public int j() {
        return 1;
    }
}
