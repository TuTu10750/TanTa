package com.yunbao.common.ijkplay;

import android.view.View;
import android.widget.MediaController;
import defpackage.wh1;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: /tmp/classes2.dex */
public class AndroidMediaController extends MediaController implements wh1 {
    public r3 a;
    public ArrayList b;

    @Override // android.widget.MediaController, defpackage.wh1
    public void hide() {
        super.hide();
        r3 r3Var = this.a;
        if (r3Var != null) {
            r3Var.k();
        }
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((View) it.next()).setVisibility(8);
        }
        this.b.clear();
    }

    public void setSupportActionBar(r3 r3Var) {
        this.a = r3Var;
        if (isShowing()) {
            r3Var.v();
        } else {
            r3Var.k();
        }
    }

    @Override // android.widget.MediaController, defpackage.wh1
    public void show() {
        super.show();
        r3 r3Var = this.a;
        if (r3Var != null) {
            r3Var.v();
        }
    }
}
