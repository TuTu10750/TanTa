package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class u92 extends l0 implements View.OnClickListener {
    public List A0;
    public RecyclerView z0;

    @Override // defpackage.l0
    public boolean f2() {
        return true;
    }

    @Override // defpackage.l0
    public int l2() {
        return s93.c;
    }

    @Override // defpackage.l0
    public int m2() {
        return x73.k0;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == b73.N) {
            S1();
        }
    }

    @Override // defpackage.l0
    public void p2(Window window) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = zn0.a(300);
        attributes.height = zn0.a(280);
        attributes.gravity = 17;
        window.setAttributes(attributes);
    }

    public void r0(Bundle bundle) {
        super.r0(bundle);
        k2(b73.N).setOnClickListener(this);
        this.z0 = k2(b73.B4);
        int size = this.A0.size();
        RecyclerView recyclerView = this.z0;
        Context context = this.x0;
        if (size >= 4) {
            size = 4;
        }
        recyclerView.setLayoutManager(new GridLayoutManager(context, size, 1, false));
        this.z0.setAdapter(new t92(this.x0, this.A0));
    }

    public void r2(List list) {
        this.A0 = list;
    }
}
