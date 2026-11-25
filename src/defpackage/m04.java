package defpackage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class m04 extends RecyclerView.n {
    public List a;
    public int d;
    public int e;
    public int f;
    public int g;
    public a i;
    public int h = 0;
    public String j = "";
    public Paint b = new Paint();
    public Rect c = new Rect();

    /* loaded from: /tmp/classes2.dex */
    public interface a {
        void a(String str);
    }

    public m04(Context context) {
        this.e = o60.b(context, p53.n);
        this.f = o60.b(context, p53.h);
        this.d = (int) TypedValue.applyDimension(1, 30.0f, context.getResources().getDisplayMetrics());
        int applyDimension = (int) TypedValue.applyDimension(2, 15.0f, context.getResources().getDisplayMetrics());
        this.g = applyDimension;
        this.b.setTextSize(applyDimension);
        this.b.setAntiAlias(true);
    }

    public final void d(Canvas canvas, int i, int i2, View view, RecyclerView.p pVar, int i3) {
        this.b.setColor(this.e);
        canvas.drawRect(i, (view.getTop() - ((ViewGroup.MarginLayoutParams) pVar).topMargin) - this.d, i2, view.getTop() - ((ViewGroup.MarginLayoutParams) pVar).topMargin, this.b);
        this.b.setColor(this.f);
        this.b.getTextBounds(((di1) this.a.get(i3)).getSuspensionTag(), 0, ((di1) this.a.get(i3)).getSuspensionTag().length(), this.c);
        canvas.drawText(((di1) this.a.get(i3)).getSuspensionTag(), view.getPaddingLeft(), (view.getTop() - ((ViewGroup.MarginLayoutParams) pVar).topMargin) - ((this.d / 2) - (this.c.height() / 2)), this.b);
    }

    public int e() {
        return this.h;
    }

    public void f(a aVar) {
        this.i = aVar;
    }

    public m04 g(int i) {
        this.h = i;
        return this;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
        super.getItemOffsets(rect, view, recyclerView, a0Var);
        int e = view.getLayoutParams().e() - e();
        List list = this.a;
        if (list == null || list.isEmpty() || e > this.a.size() - 1 || e <= -1) {
            return;
        }
        di1 di1Var = (di1) this.a.get(e);
        if (di1Var.isShowSuspension()) {
            if (e == 0) {
                rect.set(0, this.d, 0, 0);
            } else {
                if (di1Var.getSuspensionTag() == null || di1Var.getSuspensionTag().equals(((di1) this.a.get(e - 1)).getSuspensionTag())) {
                    return;
                }
                rect.set(0, this.d, 0, 0);
            }
        }
    }

    public m04 h(List list) {
        this.a = list;
        return this;
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
        m04 m04Var;
        Canvas canvas2;
        super.onDraw(canvas, recyclerView, a0Var);
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        int i = 0;
        while (i < childCount) {
            View childAt = recyclerView.getChildAt(i);
            RecyclerView.p pVar = (RecyclerView.p) childAt.getLayoutParams();
            int e = pVar.e() - this.e();
            List list = this.a;
            if (list == null || list.isEmpty() || e > this.a.size() - 1 || e < 0 || !((di1) this.a.get(e)).isShowSuspension() || e <= -1) {
                m04Var = this;
                canvas2 = canvas;
            } else if (e == 0) {
                m04Var = this;
                canvas2 = canvas;
                m04Var.d(canvas2, paddingLeft, width, childAt, pVar, e);
            } else {
                m04Var = this;
                canvas2 = canvas;
                if (((di1) m04Var.a.get(e)).getSuspensionTag() != null && !((di1) m04Var.a.get(e)).getSuspensionTag().equals(((di1) m04Var.a.get(e - 1)).getSuspensionTag())) {
                    m04Var.d(canvas2, paddingLeft, width, childAt, pVar, e);
                }
            }
            i++;
            this = m04Var;
            canvas = canvas2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onDrawOver(android.graphics.Canvas r11, androidx.recyclerview.widget.RecyclerView r12, androidx.recyclerview.widget.RecyclerView.a0 r13) {
        /*
            Method dump skipped, instructions count: 270
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.m04.onDrawOver(android.graphics.Canvas, androidx.recyclerview.widget.RecyclerView, androidx.recyclerview.widget.RecyclerView$a0):void");
    }
}
