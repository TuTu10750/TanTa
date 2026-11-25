package com.yunbao.video.custom;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import defpackage.gi4;
import defpackage.ue2;
import java.util.Iterator;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class ColorfulProgress extends View {
    public Paint a;
    public RectF b;
    public List c;
    public float d;

    public final void a(Canvas canvas) {
        Iterator it = this.c.iterator();
        if (it.hasNext()) {
            ue2.a(it.next());
            throw null;
        }
    }

    public final void b(Canvas canvas) {
        canvas.drawRect(this.b, this.a);
    }

    public int getMarkListSize() {
        return this.c.size();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        b(canvas);
        a(canvas);
    }

    public void setCurPosition(float f) {
        this.d = f;
        invalidate();
    }

    public void setVideoProgressController(gi4 gi4Var) {
    }
}
