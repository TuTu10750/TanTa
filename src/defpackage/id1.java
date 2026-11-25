package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import defpackage.kn1;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class id1 extends ce3 {
    public boolean i;

    /* loaded from: /tmp/classes2.dex */
    public class a extends c {
        public ImageView v;
        public kn1.a w;

        /* renamed from: id1$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/classes2.dex */
        public class C0074a implements kn1.a {
            public final /* synthetic */ id1 a;

            public C0074a(id1 id1Var) {
                this.a = id1Var;
            }

            @Override // kn1.a
            public void onLoadFailed() {
                a.this.v.setImageDrawable(null);
            }

            @Override // kn1.a
            public void onLoadSuccess(Drawable drawable) {
                float intrinsicWidth = drawable.getIntrinsicWidth();
                float intrinsicHeight = drawable.getIntrinsicHeight();
                ViewGroup.LayoutParams layoutParams = a.this.v.getLayoutParams();
                int c = (int) ((gk3.a().c() * intrinsicHeight) / intrinsicWidth);
                if (layoutParams.height != c) {
                    layoutParams.height = c;
                    a.this.v.requestLayout();
                }
                a.this.v.setImageDrawable(drawable);
            }
        }

        public a(View view) {
            super(view);
            this.v = (ImageView) view;
            this.w = new C0074a(id1.this);
        }

        @Override // id1.c
        public void O(String str) {
            kn1.j(id1.this.d, str, this.w);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends c {
        public TextView v;

        public b(View view) {
            super(view);
            this.v = (TextView) view;
        }

        @Override // id1.c
        public void O(String str) {
            this.v.setText(str);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public abstract class c extends RecyclerView.e0 {
        public c(View view) {
            super(view);
        }

        public abstract void O(String str);
    }

    public id1(Context context, List list, boolean z) {
        super(context, list);
        this.i = z;
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return i == -1 ? new b(this.f.inflate(z73.M0, viewGroup, false)) : new a(this.f.inflate(z73.L0, viewGroup, false));
    }

    public int l(int i) {
        return (this.i && i == 0) ? -1 : 0;
    }

    public void z(RecyclerView.e0 e0Var, int i) {
        ((c) e0Var).O((String) this.e.get(i));
    }
}
