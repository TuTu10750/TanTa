package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;

/* loaded from: /tmp/classes2.dex */
public class u14 {
    public Context a;
    public ViewGroup b;
    public TableLayout c;

    /* loaded from: /tmp/classes2.dex */
    public static class b {
        public TextView a;
        public TextView b;

        public b() {
        }

        public void a(String str) {
            TextView textView = this.a;
            if (textView != null) {
                textView.setText(str);
            }
        }

        public void b(String str) {
            TextView textView = this.b;
            if (textView != null) {
                textView.setText(str);
            }
        }
    }

    public u14(Context context, TableLayout tableLayout) {
        this.a = context;
        this.b = tableLayout;
        this.c = tableLayout;
    }

    public View a(int i, String str, String str2) {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.a).inflate(i, (ViewGroup) this.c, false);
        e(viewGroup, str, str2);
        this.c.addView(viewGroup);
        return viewGroup;
    }

    public View b(int i, String str) {
        return c(this.a.getString(i), str);
    }

    public View c(String str, String str2) {
        return a(u73.O, str, str2);
    }

    public b d(View view) {
        b bVar = (b) view.getTag();
        if (bVar != null) {
            return bVar;
        }
        b bVar2 = new b();
        bVar2.a = (TextView) view.findViewById(y63.T);
        bVar2.b = (TextView) view.findViewById(y63.n0);
        view.setTag(bVar2);
        return bVar2;
    }

    public void e(View view, String str, String str2) {
        b d = d(view);
        d.a(str);
        d.b(str2);
    }

    public void f(View view, String str) {
        d(view).b(str);
    }
}
