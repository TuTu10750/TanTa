package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.alibaba.fastjson.JSON;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.live.activity.LiveAddImpressActivity;
import com.yunbao.live.bean.ImpressBean;
import com.yunbao.live.custom.MyTextView;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class g02 extends r0 {
    public LinearLayout f;
    public String g;
    public LinkedList h;
    public HttpCallback i;
    public View.OnClickListener j;
    public LayoutInflater k;
    public boolean l;
    public boolean m;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MyTextView myTextView = (MyTextView) view;
            boolean t = myTextView.t();
            g02 g02Var = g02.this;
            if (t) {
                g02Var.o0(myTextView.getBean().getId());
                myTextView.setChecked(false);
                g02.this.l = true;
            } else {
                if (g02Var.h.size() >= 3) {
                    t54.a(m93.R2);
                    return;
                }
                myTextView.setChecked(true);
                g02.this.l0(myTextView.getBean().getId());
                g02.this.l = true;
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends HttpCallback {
        public b() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            t54.b(str);
            if (i == 0) {
                g02.this.m = true;
                g02.this.hide();
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends HttpCallback {
        public c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v6, types: [android.view.View, com.yunbao.live.custom.MyTextView] */
        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            g02 g02Var;
            if (i != 0 || strArr.length <= 0) {
                return;
            }
            List parseArray = JSON.parseArray(Arrays.toString(strArr), ImpressBean.class);
            boolean z = true;
            int i2 = 0;
            int i3 = 0;
            while (z) {
                LinearLayout linearLayout = (LinearLayout) g02.this.k.inflate(x73.G1, (ViewGroup) g02.this.f, false);
                int i4 = i2 % 2 == 0 ? i3 + 4 : i3 + 3;
                if (i4 >= parseArray.size()) {
                    i4 = parseArray.size();
                    z = false;
                }
                while (true) {
                    g02Var = g02.this;
                    if (i3 < i4) {
                        ?? r4 = (MyTextView) g02Var.k.inflate(x73.D1, (ViewGroup) linearLayout, false);
                        ImpressBean impressBean = (ImpressBean) parseArray.get(i3);
                        if (impressBean.isChecked()) {
                            g02.this.l0(impressBean.getId());
                        }
                        r4.setBean(impressBean);
                        linearLayout.addView(r4);
                        r4.setOnClickListener(g02.this.j);
                        i3++;
                    }
                }
                i2++;
                g02Var.f.addView(linearLayout);
                i3 = i4;
            }
        }
    }

    public g02(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
        this.h = new LinkedList();
        this.k = LayoutInflater.from(context);
    }

    @Override // defpackage.r0
    public void a0() {
        this.h.clear();
        this.f.removeAllViews();
        removeFromParent();
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return x73.b2;
    }

    @Override // defpackage.r0
    public void hide() {
        Object obj = this.mContext;
        if (obj instanceof LiveAddImpressActivity) {
            ((LiveAddImpressActivity) obj).onBackPressed();
        } else {
            super.hide();
        }
    }

    @Override // defpackage.r0, defpackage.b1
    public void init() {
        super.init();
        this.f = (LinearLayout) findViewById(b73.u2);
        findViewById(b73.W0).setOnClickListener(this);
        this.j = new a();
        this.i = new b();
    }

    public final void l0(int i) {
        this.h.add(Integer.valueOf(i));
    }

    @Override // defpackage.r0
    public void loadData() {
        m0();
    }

    public final void m0() {
        e32.D(this.g, new c());
    }

    public boolean n0() {
        return this.m;
    }

    public final void o0(int i) {
        int size = this.h.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i2 = -1;
                break;
            } else if (i == ((Integer) this.h.get(i2)).intValue()) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 != -1) {
            this.h.remove(i2);
        }
    }

    @Override // defpackage.r0, android.view.View.OnClickListener
    public void onClick(View view) {
        if (canClick()) {
            super.onClick(view);
            if (view.getId() == b73.W0) {
                p0();
            }
        }
    }

    @Override // defpackage.b1, defpackage.uy1
    public void onDestroy() {
        super.onDestroy();
        e32.f("getAllImpress");
        e32.f("setImpress");
    }

    public final void p0() {
        if (this.h.size() == 0) {
            t54.a(m93.T2);
            return;
        }
        if (!this.l) {
            t54.a(m93.S2);
            return;
        }
        Iterator it = this.h.iterator();
        String str = "";
        while (it.hasNext()) {
            str = str + ((Integer) it.next()) + ",";
        }
        if (str.endsWith(",")) {
            str = str.substring(0, str.length() - 1);
        }
        e32.E0(this.g, str, this.i);
    }

    public void q0(String str) {
        this.g = str;
    }
}
