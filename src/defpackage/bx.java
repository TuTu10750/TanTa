package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.main.activity.CashActivity;

/* loaded from: /tmp/classes2.dex */
public class bx extends b1 implements View.OnClickListener {
    public TextView a;
    public boolean b;
    public LayoutInflater c;
    public SparseIntArray d;
    public int e;
    public View f;
    public View g;
    public View h;
    public EditText i;
    public EditText j;
    public EditText k;
    public EditText l;
    public EditText m;
    public EditText n;
    public HttpCallback o;

    /* loaded from: /tmp/classes2.dex */
    public class a extends HttpCallback {
        public a() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i == 0 && bx.this.mContext != null) {
                ((CashActivity) bx.this.mContext).z1();
            }
            t54.b(str);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements View.OnClickListener {
        public final /* synthetic */ PopupWindow a;

        public b(PopupWindow popupWindow) {
            this.a = popupWindow;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.dismiss();
            Object tag = view.getTag();
            if (tag != null) {
                int intValue = ((Integer) tag).intValue();
                bx.this.a.setText(bx.this.d.get(intValue));
                bx.this.e = intValue;
                if (intValue == 1) {
                    if (bx.this.f.getVisibility() != 0) {
                        bx.this.f.setVisibility(0);
                    }
                    if (bx.this.g.getVisibility() == 0) {
                        bx.this.g.setVisibility(8);
                    }
                    if (bx.this.h.getVisibility() == 0) {
                        bx.this.h.setVisibility(8);
                        return;
                    }
                    return;
                }
                if (intValue == 2) {
                    if (bx.this.f.getVisibility() == 0) {
                        bx.this.f.setVisibility(8);
                    }
                    if (bx.this.g.getVisibility() != 0) {
                        bx.this.g.setVisibility(0);
                    }
                    if (bx.this.h.getVisibility() == 0) {
                        bx.this.h.setVisibility(8);
                        return;
                    }
                    return;
                }
                if (intValue != 3) {
                    return;
                }
                if (bx.this.f.getVisibility() == 0) {
                    bx.this.f.setVisibility(8);
                }
                if (bx.this.g.getVisibility() == 0) {
                    bx.this.g.setVisibility(8);
                }
                if (bx.this.h.getVisibility() != 0) {
                    bx.this.h.setVisibility(0);
                }
            }
        }
    }

    public bx(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    @Override // defpackage.b1
    public void addToParent() {
        super.addToParent();
        this.b = true;
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return y73.a1;
    }

    @Override // defpackage.b1
    public void init() {
        SparseIntArray sparseIntArray = new SparseIntArray();
        this.d = sparseIntArray;
        sparseIntArray.put(1, m93.g1);
        this.d.put(2, m93.i1);
        this.d.put(3, m93.h1);
        this.e = 1;
        this.c = LayoutInflater.from(this.mContext);
        findViewById(c73.u4).setOnClickListener(this);
        findViewById(c73.c0).setOnClickListener(this);
        TextView textView = (TextView) findViewById(c73.W);
        this.a = textView;
        textView.setOnClickListener(this);
        this.f = findViewById(c73.d3);
        this.g = findViewById(c73.e3);
        this.h = findViewById(c73.f3);
        this.i = (EditText) findViewById(c73.W2);
        this.j = (EditText) findViewById(c73.X2);
        this.k = (EditText) findViewById(c73.g3);
        this.l = (EditText) findViewById(c73.Z2);
        this.m = (EditText) findViewById(c73.Y2);
        this.n = (EditText) findViewById(c73.a3);
        this.o = new a();
    }

    public boolean isShowed() {
        return this.b;
    }

    public final void j0() {
        String trim;
        String trim2;
        String str;
        int i = this.e;
        String str2 = null;
        if (i == 1) {
            trim = this.i.getText().toString().trim();
            if (TextUtils.isEmpty(trim)) {
                t54.a(m93.a1);
                return;
            }
            trim2 = this.j.getText().toString().trim();
            if (TextUtils.isEmpty(trim2)) {
                t54.a(m93.b1);
                return;
            } else {
                this.i.setText("");
                this.j.setText("");
            }
        } else {
            if (i == 2) {
                trim = this.k.getText().toString().trim();
                if (TextUtils.isEmpty(trim)) {
                    t54.a(m93.f1);
                    return;
                }
                this.k.setText("");
                str = null;
                removeFromParent();
                db2.h(trim, str2, str, this.e, this.o);
            }
            str2 = this.l.getText().toString().trim();
            if (TextUtils.isEmpty(str2)) {
                t54.a(m93.d1);
                return;
            }
            trim = this.m.getText().toString().trim();
            if (TextUtils.isEmpty(trim)) {
                t54.a(m93.c1);
                return;
            }
            trim2 = this.n.getText().toString().trim();
            if (TextUtils.isEmpty(trim2)) {
                t54.a(m93.e1);
                return;
            } else {
                this.l.setText("");
                this.m.setText("");
                this.n.setText("");
            }
        }
        String str3 = str2;
        str2 = trim2;
        str = str3;
        removeFromParent();
        db2.h(trim, str2, str, this.e, this.o);
    }

    public final void k0() {
        View inflate = this.c.inflate(y73.d1, (ViewGroup) null);
        PopupWindow popupWindow = new PopupWindow(inflate, zn0.a(60), -2, true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(o60.d(this.mContext, i63.e));
        TextView textView = (TextView) inflate.findViewById(c73.D);
        TextView textView2 = (TextView) inflate.findViewById(c73.E);
        int i = this.e;
        if (i == 1) {
            textView.setTag(Integer.valueOf(this.d.keyAt(1)));
            textView.setText(this.d.valueAt(1));
            textView2.setTag(Integer.valueOf(this.d.keyAt(2)));
            textView2.setText(this.d.valueAt(2));
        } else {
            SparseIntArray sparseIntArray = this.d;
            if (i == 2) {
                textView.setTag(Integer.valueOf(sparseIntArray.keyAt(0)));
                textView.setText(this.d.valueAt(0));
                textView2.setTag(Integer.valueOf(this.d.keyAt(2)));
                textView2.setText(this.d.valueAt(2));
            } else {
                textView.setTag(Integer.valueOf(sparseIntArray.keyAt(0)));
                textView.setText(this.d.valueAt(0));
                textView2.setTag(Integer.valueOf(this.d.keyAt(1)));
                textView2.setText(this.d.valueAt(1));
            }
        }
        b bVar = new b(popupWindow);
        textView.setOnClickListener(bVar);
        textView2.setOnClickListener(bVar);
        popupWindow.showAsDropDown(this.a);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == c73.u4) {
            removeFromParent();
        } else if (id == c73.W) {
            k0();
        } else if (id == c73.c0) {
            j0();
        }
    }

    @Override // defpackage.b1
    public void removeFromParent() {
        super.removeFromParent();
        this.b = false;
    }
}
