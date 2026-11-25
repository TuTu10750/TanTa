package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class s44 extends RecyclerView.Adapter {
    public Context d;
    public List e = new ArrayList();
    public LayoutInflater f;
    public int g;

    /* loaded from: /tmp/classes2.dex */
    public class a extends RecyclerView.e0 {
        public a(View view) {
            super(view);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends RecyclerView.e0 {
        public ImageView u;

        public b(View view) {
            super(view);
            this.u = (ImageView) view;
        }

        public void O() {
            ImageView imageView = this.u;
            if (imageView != null) {
                imageView.setImageBitmap(null);
            }
        }

        public void P(Bitmap bitmap) {
            this.u.setImageBitmap(bitmap);
        }
    }

    public s44(Context context) {
        this.d = context;
        this.g = this.d.getResources().getDisplayMetrics().widthPixels;
        this.f = LayoutInflater.from(this.d);
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        if (i != 0) {
            return new b(this.f.inflate(b83.l, viewGroup, false));
        }
        View view = new View(this.d);
        view.setLayoutParams(new ViewGroup.LayoutParams(this.g / 2, -1));
        return new a(view);
    }

    public void G(RecyclerView.e0 e0Var) {
        if (e0Var == null || !(e0Var instanceof b)) {
            return;
        }
        ((b) e0Var).O();
    }

    public int j() {
        return this.e.size() + 2;
    }

    public int l(int i) {
        return (i == 0 || i == this.e.size() + 1) ? 0 : 1;
    }

    public void z(RecyclerView.e0 e0Var, int i) {
        if (e0Var instanceof b) {
            ((b) e0Var).P((Bitmap) this.e.get(i - 1));
        }
    }
}
