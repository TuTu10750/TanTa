package defpackage;

import android.content.Context;
import android.view.ViewGroup;

/* loaded from: /tmp/classes2.dex */
public class oa2 extends v0 {
    public oa2(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return y73.k;
    }

    @Override // defpackage.b1
    public void init() {
        setStatusHeight();
        ja2 ja2Var = new ja2(this.mContext, (ViewGroup) findViewById(a73.g0));
        ja2Var.addToParent();
        ja2Var.loadData();
    }

    @Override // defpackage.b1, defpackage.uy1
    public void onDestroy() {
        super.onDestroy();
    }
}
