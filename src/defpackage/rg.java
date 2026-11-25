package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

/* loaded from: /tmp/classes2.dex */
public abstract class rg extends RecyclerView.Adapter {
    public List d = new ArrayList();
    public boolean e;

    public static /* synthetic */ void L(rg rgVar, oh ohVar, View view) {
        rgVar.getClass();
        ohVar.k();
    }

    public abstract void M(oh ohVar, Object obj, int i, int i2);

    public oh N(ViewGroup viewGroup, View view, int i) {
        return new oh(view);
    }

    public List O() {
        return this.d;
    }

    public abstract int P(int i);

    public int Q() {
        return this.d.size();
    }

    public int R(int i) {
        return 0;
    }

    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public final void z(oh ohVar, int i) {
        int c = jg.c(i, Q());
        M(ohVar, this.d.get(c), c, Q());
    }

    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public final oh B(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(P(i), viewGroup, false);
        final oh N = N(viewGroup, inflate, i);
        inflate.setOnClickListener(new View.OnClickListener() { // from class: qg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                rg.L(rg.this, N, view);
            }
        });
        return N;
    }

    public void U(boolean z) {
        this.e = z;
    }

    public void V(List list) {
        if (list != null) {
            this.d.clear();
            this.d.addAll(list);
        }
    }

    public final int j() {
        return (!this.e || Q() <= 1) ? Q() : IjkMediaCodecInfo.RANK_MAX;
    }

    public final int l(int i) {
        return R(jg.c(i, Q()));
    }
}
