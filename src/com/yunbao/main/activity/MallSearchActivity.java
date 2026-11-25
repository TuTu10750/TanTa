package com.yunbao.main.activity;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.custom.CommonRefreshView;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.mall.bean.GoodsSimpleBean;
import defpackage.c73;
import defpackage.ce3;
import defpackage.db2;
import defpackage.ec2;
import defpackage.fc2;
import defpackage.m93;
import defpackage.p53;
import defpackage.t54;
import defpackage.u83;
import defpackage.y73;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class MallSearchActivity extends AbsActivity implements View.OnClickListener {
    public GridLayoutManager A;
    public LinearLayoutManager B;
    public InputMethodManager C;
    public EditText e;
    public TextView f;
    public TextView g;
    public TextView h;
    public ImageView i;
    public ImageView j;
    public Drawable k;
    public Drawable l;
    public Drawable m;
    public int n;
    public int o;
    public String p = "";
    public String q = "";
    public int r;
    public CommonRefreshView s;
    public fc2 t;
    public String u;
    public e v;
    public ImageView w;
    public Drawable x;
    public Drawable y;
    public boolean z;

    /* loaded from: /tmp/classes2.dex */
    public class a implements TextView.OnEditorActionListener {
        public a() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 3) {
                return false;
            }
            ec2.u("searchGoodsList");
            if (MallSearchActivity.this.v != null) {
                MallSearchActivity.this.v.removeCallbacksAndMessages(null);
            }
            if (TextUtils.isEmpty(MallSearchActivity.this.e.getText().toString())) {
                t54.a(m93.r1);
                return true;
            }
            MallSearchActivity.this.R1();
            return true;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            db2.i("searchGoodsList");
            if (MallSearchActivity.this.v != null) {
                MallSearchActivity.this.v.removeCallbacksAndMessages(null);
                MallSearchActivity.this.v.sendEmptyMessageDelayed(0, 500L);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c implements CommonRefreshView.e {
        public c() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public ce3 getAdapter() {
            if (MallSearchActivity.this.t == null) {
                MallSearchActivity mallSearchActivity = MallSearchActivity.this;
                mallSearchActivity.t = new fc2(mallSearchActivity.b);
                MallSearchActivity.this.t.Y(MallSearchActivity.this.z);
            }
            return MallSearchActivity.this.t;
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void loadData(int i, HttpCallback httpCallback) {
            db2.q0(MallSearchActivity.this.u, MallSearchActivity.this.p, MallSearchActivity.this.q, MallSearchActivity.this.r, i, httpCallback);
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void onLoadMoreFailure() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void onLoadMoreSuccess(List list, int i) {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void onRefreshFailure() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void onRefreshSuccess(List list, int i) {
            if (MallSearchActivity.this.C == null || MallSearchActivity.this.e == null) {
                return;
            }
            MallSearchActivity.this.C.hideSoftInputFromWindow(MallSearchActivity.this.e.getWindowToken(), 0);
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public List processData(String[] strArr) {
            return JSON.parseArray(Arrays.toString(strArr), GoodsSimpleBean.class);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MallSearchActivity.this.z = !r5.z;
            boolean z = MallSearchActivity.this.z;
            MallSearchActivity mallSearchActivity = MallSearchActivity.this;
            if (!z) {
                mallSearchActivity.w.setImageDrawable(MallSearchActivity.this.x);
                if (MallSearchActivity.this.s != null) {
                    MallSearchActivity.this.s.setLayoutManager(MallSearchActivity.this.A);
                }
                if (MallSearchActivity.this.t != null) {
                    MallSearchActivity.this.t.Y(MallSearchActivity.this.z);
                    MallSearchActivity.this.t.p();
                    return;
                }
                return;
            }
            mallSearchActivity.w.setImageDrawable(MallSearchActivity.this.y);
            if (MallSearchActivity.this.B == null) {
                MallSearchActivity mallSearchActivity2 = MallSearchActivity.this;
                mallSearchActivity2.B = new LinearLayoutManager(mallSearchActivity2.b, 1, false);
            }
            if (MallSearchActivity.this.s != null) {
                MallSearchActivity.this.s.setLayoutManager(MallSearchActivity.this.B);
            }
            if (MallSearchActivity.this.t != null) {
                MallSearchActivity.this.t.Y(MallSearchActivity.this.z);
                MallSearchActivity.this.t.p();
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static class e extends Handler {
        public MallSearchActivity a;

        public e(MallSearchActivity mallSearchActivity) {
            this.a = (MallSearchActivity) new WeakReference(mallSearchActivity).get();
        }

        public void a() {
            removeCallbacksAndMessages(null);
            this.a = null;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            MallSearchActivity mallSearchActivity = this.a;
            if (mallSearchActivity != null) {
                mallSearchActivity.R1();
            }
        }
    }

    private void Q1() {
        CommonRefreshView commonRefreshView = this.s;
        if (commonRefreshView != null) {
            commonRefreshView.k();
        }
    }

    public void R1() {
        String trim = this.e.getText().toString().trim();
        this.u = trim;
        if (!TextUtils.isEmpty(trim)) {
            Q1();
            return;
        }
        fc2 fc2Var = this.t;
        if (fc2Var != null) {
            fc2Var.M();
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return y73.G;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        this.C = (InputMethodManager) getSystemService("input_method");
        EditText editText = (EditText) findViewById(c73.P1);
        this.e = editText;
        editText.setOnEditorActionListener(new a());
        this.e.addTextChangedListener(new b());
        this.f = (TextView) findViewById(c73.N0);
        this.g = (TextView) findViewById(c73.a5);
        this.h = (TextView) findViewById(c73.V4);
        this.i = (ImageView) findViewById(c73.Q2);
        this.j = (ImageView) findViewById(c73.P2);
        this.k = o60.d(this.b, u83.C);
        this.l = o60.d(this.b, u83.y);
        this.m = o60.d(this.b, u83.z);
        this.n = o60.b(this.b, p53.h);
        this.o = o60.b(this.b, p53.l);
        this.f.setOnClickListener(this);
        findViewById(c73.a1).setOnClickListener(this);
        findViewById(c73.S0).setOnClickListener(this);
        CommonRefreshView commonRefreshView = (CommonRefreshView) findViewById(c73.r4);
        this.s = commonRefreshView;
        commonRefreshView.setEmptyLayoutId(y73.C1);
        RecyclerView.o gridLayoutManager = new GridLayoutManager(this.b, 2, 1, false);
        this.A = gridLayoutManager;
        this.s.setLayoutManager(gridLayoutManager);
        RecyclerView.n rq1Var = new rq1(this.b, 0, 10.0f, 0.0f);
        rq1Var.l(true);
        this.s.setItemDecoration(rq1Var);
        this.s.setDataHelper(new c());
        this.x = o60.d(this.b, u83.A);
        this.y = o60.d(this.b, u83.B);
        ImageView imageView = (ImageView) findViewById(c73.Q);
        this.w = imageView;
        imageView.setOnClickListener(new d());
        this.e.requestFocus();
        this.v = new e(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == c73.N0) {
            this.p = "";
            this.q = "";
            this.r = 1;
            this.i.setImageDrawable(this.m);
            this.j.setImageDrawable(this.m);
            this.f.setTextColor(this.o);
            this.g.setTextColor(this.n);
            this.h.setTextColor(this.n);
        } else if (id == c73.a1) {
            if ("".equals(this.p) || "desc".equals(this.p)) {
                this.p = "asc";
                this.i.setImageDrawable(this.k);
            } else if ("asc".equals(this.p)) {
                this.p = "desc";
                this.i.setImageDrawable(this.l);
            }
            this.q = "";
            this.r = 0;
            this.j.setImageDrawable(this.m);
            this.f.setTextColor(this.n);
            this.g.setTextColor(this.o);
            this.h.setTextColor(this.n);
        } else if (id == c73.S0) {
            this.p = "";
            if ("".equals(this.q) || "desc".equals(this.q)) {
                this.q = "asc";
                this.j.setImageDrawable(this.k);
            } else if ("asc".equals(this.q)) {
                this.q = "desc";
                this.j.setImageDrawable(this.l);
            }
            this.r = 0;
            this.i.setImageDrawable(this.m);
            this.f.setTextColor(this.n);
            this.g.setTextColor(this.n);
            this.h.setTextColor(this.o);
        }
        Q1();
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        e eVar = this.v;
        if (eVar != null) {
            eVar.a();
        }
        this.v = null;
        db2.i("searchGoodsList");
        super.onDestroy();
    }
}
