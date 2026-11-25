package defpackage;

import android.content.Context;
import android.view.ViewGroup;

/* loaded from: /tmp/classes2.dex */
public abstract class q0 extends b1 {
    public j42 a;

    public q0(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    public abstract void F();

    public abstract void a0();

    public abstract void b0();

    public void d0(j42 j42Var) {
        this.a = j42Var;
    }

    public abstract void e0();

    public abstract void f0(String str);

    @Override // defpackage.b1
    public abstract void release();

    public abstract void y();
}
