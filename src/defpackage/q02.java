package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: /tmp/classes2.dex */
public class q02 extends RecyclerView.Adapter {
    public final Context d;
    public final String[] e;
    public int f = 0;
    public b g;

    /* loaded from: /tmp/classes2.dex */
    public static class a extends RecyclerView.e0 {
        public LinearLayout u;
        public FrameLayout v;
        public TextView w;

        public a(View view) {
            super(view);
            this.u = (LinearLayout) view.findViewById(x63.n);
            this.v = (FrameLayout) view.findViewById(x63.m);
            this.w = (TextView) view.findViewById(x63.l);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface b {
        void a(int i, String str);
    }

    public q02(Context context) {
        this.d = context;
        this.e = context.getResources().getStringArray(c53.a);
    }

    public static /* synthetic */ void L(q02 q02Var, int i, View view) {
        int i2 = q02Var.f;
        if (i2 == i) {
            return;
        }
        q02Var.f = i;
        q02Var.q(i2);
        q02Var.q(q02Var.f);
        b bVar = q02Var.g;
        if (bVar != null) {
            bVar.a(i, q02Var.e[i]);
        }
    }

    public int M() {
        return this.f;
    }

    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public void z(a aVar, final int i) {
        aVar.w.setText(this.e[i]);
        aVar.v.setBackgroundResource(i == this.f ? f63.a : 0);
        aVar.u.setOnClickListener(new View.OnClickListener() { // from class: p02
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                q02.L(q02.this, i, view);
            }
        });
    }

    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public a B(ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(this.d).inflate(n83.b, viewGroup, false));
    }

    public void P(b bVar) {
        this.g = bVar;
    }

    public int j() {
        return this.e.length;
    }
}
