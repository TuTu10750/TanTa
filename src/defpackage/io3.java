package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.umeng.analytics.pro.cl;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.main.bean.SettingBean;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class io3 extends RecyclerView.Adapter {
    public Context d;
    public List e;
    public LayoutInflater f;
    public d h;
    public String i;
    public String j;
    public Drawable k;
    public Drawable l;
    public String n = V();
    public View.OnClickListener g = new a();
    public View.OnClickListener m = new b();
    public View.OnClickListener o = new c();

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null) {
                int intValue = ((Integer) tag).intValue();
                SettingBean settingBean = (SettingBean) io3.this.e.get(intValue);
                if (io3.this.h != null) {
                    io3.this.h.i(settingBean, intValue);
                }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements View.OnClickListener {

        /* loaded from: /tmp/classes2.dex */
        public class a extends HttpCallback {
            public final /* synthetic */ SettingBean a;
            public final /* synthetic */ int b;

            public a(SettingBean settingBean, int i) {
                this.a = settingBean;
                this.b = i;
            }

            @Override // com.yunbao.common.http.HttpCallback
            public void onSuccess(int i, String str, String[] strArr) {
                if (i == 0 && strArr.length > 0) {
                    boolean z = JSON.parseObject(strArr[0]).getIntValue(cl.i) == 1;
                    j30.q().b0(z);
                    this.a.setChecked(z);
                    io3.this.r(this.b, "payload");
                }
                t54.b(str);
            }
        }

        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue = ((Integer) view.getTag()).intValue();
            SettingBean settingBean = (SettingBean) io3.this.e.get(intValue);
            if (settingBean.getId() == -3) {
                db2.v0(new a(settingBean, intValue));
                return;
            }
            settingBean.setChecked(!settingBean.isChecked());
            io3.this.r(intValue, "payload");
            if (io3.this.h != null) {
                io3.this.h.q(settingBean);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!j10.a() || io3.this.h == null) {
                return;
            }
            io3.this.h.J();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface d {
        void J();

        void i(SettingBean settingBean, int i);

        void q(SettingBean settingBean);
    }

    /* loaded from: /tmp/classes2.dex */
    public class e extends RecyclerView.e0 {
        public TextView u;
        public TextView v;

        public e(View view) {
            super(view);
            this.u = (TextView) view.findViewById(c73.L3);
            this.v = (TextView) view.findViewById(c73.C4);
            view.setOnClickListener(io3.this.o);
        }

        public void O(SettingBean settingBean, Object obj) {
            if (obj == null) {
                this.u.setText(settingBean.getName());
            }
            this.v.setText(io3.this.n);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class f extends RecyclerView.e0 {
        public TextView u;
        public ImageView v;

        public f(View view) {
            super(view);
            this.u = (TextView) view.findViewById(c73.L3);
            ImageView imageView = (ImageView) view.findViewById(c73.V0);
            this.v = imageView;
            imageView.setOnClickListener(io3.this.m);
        }

        public void O(SettingBean settingBean, int i, Object obj) {
            if (obj == null) {
                this.u.setText(settingBean.getName());
                this.v.setTag(Integer.valueOf(i));
            }
            ImageView imageView = this.v;
            boolean isChecked = settingBean.isChecked();
            io3 io3Var = io3.this;
            imageView.setImageDrawable(isChecked ? io3Var.k : io3Var.l);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class g extends RecyclerView.e0 {
        public TextView u;
        public TextView v;
        public View w;

        public g(View view) {
            super(view);
            this.u = (TextView) view.findViewById(c73.L3);
            this.v = (TextView) view.findViewById(c73.C4);
            this.w = view.findViewById(c73.i3);
            view.setOnClickListener(io3.this.g);
        }

        public void O(SettingBean settingBean, int i) {
            ((RecyclerView.e0) this).a.setTag(Integer.valueOf(i));
            this.u.setText(settingBean.getName());
            boolean isChecked = settingBean.isChecked();
            View view = this.w;
            if (isChecked) {
                view.setVisibility(0);
            } else {
                view.setVisibility(8);
            }
            int id = settingBean.getId();
            TextView textView = this.v;
            if (id == 18) {
                textView.setText(io3.this.j);
            } else {
                textView.setText(io3.this.i);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class h extends RecyclerView.e0 {
        public TextView u;

        public h(View view) {
            super(view);
            this.u = (TextView) view.findViewById(c73.L3);
            view.setOnClickListener(io3.this.g);
        }

        public void O(SettingBean settingBean, int i) {
            ((RecyclerView.e0) this).a.setTag(Integer.valueOf(i));
            this.u.setText(settingBean.getName());
        }
    }

    public io3(Context context, List list, String str, String str2) {
        this.d = context;
        this.e = list;
        this.i = str;
        this.j = str2;
        this.f = LayoutInflater.from(context);
        this.k = o60.d(context, q83.g1);
        this.l = o60.d(context, q83.f1);
    }

    public void A(RecyclerView.e0 e0Var, int i, List list) {
        if (e0Var instanceof h) {
            ((h) e0Var).O((SettingBean) this.e.get(i), i);
            return;
        }
        if (e0Var instanceof f) {
            ((f) e0Var).O((SettingBean) this.e.get(i), i, list.size() > 0 ? list.get(0) : null);
        } else if (e0Var instanceof e) {
            ((e) e0Var).O((SettingBean) this.e.get(i), list.size() > 0 ? list.get(0) : null);
        } else {
            ((g) e0Var).O((SettingBean) this.e.get(i), i);
        }
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return i == 1 ? new g(this.f.inflate(y73.L0, viewGroup, false)) : i == 3 ? new f(this.f.inflate(y73.N0, viewGroup, false)) : i == 4 ? new e(this.f.inflate(y73.O0, viewGroup, false)) : i == 2 ? new h(this.f.inflate(y73.M0, viewGroup, false)) : new h(this.f.inflate(y73.K0, viewGroup, false));
    }

    public final String V() {
        return "en".equals(rx1.c().d()) ? "English" : "简体中文";
    }

    public void W(d dVar) {
        this.h = dVar;
    }

    public void X(String str) {
        this.j = str;
    }

    public int j() {
        return this.e.size();
    }

    public int l(int i) {
        SettingBean settingBean = (SettingBean) this.e.get(i);
        if (settingBean.getId() == 16 || settingBean.getId() == 18) {
            return 1;
        }
        if (settingBean.getId() == -1 || settingBean.getId() == -2 || settingBean.getId() == -3) {
            return 3;
        }
        if (settingBean.getId() == -4) {
            return 4;
        }
        return settingBean.getId() == -5 ? 2 : 0;
    }

    public void z(RecyclerView.e0 e0Var, int i) {
    }
}
