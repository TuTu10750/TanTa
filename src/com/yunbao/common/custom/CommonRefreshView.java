package com.yunbao.common.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.scwang.smart.refresh.footer.ClassicsFooter;
import com.scwang.smart.refresh.header.ClassicsHeader;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.yunbao.common.http.HttpCallback;
import defpackage.ce3;
import defpackage.da3;
import defpackage.m93;
import defpackage.p53;
import defpackage.t54;
import defpackage.u73;
import defpackage.y63;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class CommonRefreshView extends FrameLayout implements View.OnClickListener {
    public Context a;
    public e b;
    public int c;
    public View d;
    public SmartRefreshLayout e;
    public ClassicsHeader f;
    public ClassicsFooter g;
    public RecyclerView h;
    public FrameLayout i;
    public View j;
    public boolean k;
    public boolean l;
    public int m;
    public int n;
    public int o;
    public HttpCallback p;
    public HttpCallback q;

    /* loaded from: /tmp/classes2.dex */
    public class a implements ot2 {
        public a() {
        }

        public void onRefresh(ke3 ke3Var) {
            CommonRefreshView.this.m();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements ft2 {
        public b() {
        }

        public void onLoadMore(ke3 ke3Var) {
            CommonRefreshView.this.l();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends HttpCallback {
        public int a;
        public boolean b;

        public c() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onError() {
            if (CommonRefreshView.this.i != null && CommonRefreshView.this.i.getVisibility() == 0) {
                CommonRefreshView.this.i.setVisibility(4);
            }
            if (CommonRefreshView.this.j != null) {
                if (CommonRefreshView.this.j.getVisibility() != 0) {
                    RecyclerView recyclerView = CommonRefreshView.this.h;
                    CommonRefreshView commonRefreshView = CommonRefreshView.this;
                    if (recyclerView != null) {
                        RecyclerView.Adapter adapter = commonRefreshView.h.getAdapter();
                        if (adapter == null || adapter.j() <= 0) {
                            CommonRefreshView.this.j.setVisibility(0);
                        } else {
                            t54.a(m93.Z4);
                        }
                    } else {
                        commonRefreshView.j.setVisibility(0);
                    }
                } else {
                    t54.a(m93.Z4);
                }
            }
            if (CommonRefreshView.this.b != null) {
                CommonRefreshView.this.b.onRefreshFailure();
            }
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onFinish() {
            if (CommonRefreshView.this.e != null) {
                CommonRefreshView.this.e.x(this.b);
                if (this.b) {
                    e unused = CommonRefreshView.this.b;
                    CommonRefreshView.this.e.K(this.a < CommonRefreshView.this.n);
                }
            }
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onStart() {
            this.a = 0;
            this.b = false;
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            ce3 adapter;
            if (CommonRefreshView.this.b == null) {
                return;
            }
            if (CommonRefreshView.this.j != null && CommonRefreshView.this.j.getVisibility() == 0) {
                CommonRefreshView.this.j.setVisibility(4);
            }
            RecyclerView.Adapter adapter2 = CommonRefreshView.this.h.getAdapter();
            if (adapter2 == null || !(adapter2 instanceof ce3)) {
                adapter = CommonRefreshView.this.b.getAdapter();
                if (adapter == null) {
                    return;
                } else {
                    CommonRefreshView.this.h.setAdapter(adapter);
                }
            } else {
                adapter = (ce3) adapter2;
            }
            if (i != 0) {
                t54.b(str);
                return;
            }
            if (strArr != null) {
                List processData = CommonRefreshView.this.b.processData(strArr);
                if (processData == null) {
                    return;
                }
                int size = processData.size();
                this.a = size;
                if (size > 0) {
                    if (CommonRefreshView.this.i != null && CommonRefreshView.this.i.getVisibility() == 0) {
                        CommonRefreshView.this.i.setVisibility(4);
                    }
                    adapter.P(processData);
                } else {
                    adapter.M();
                    if (CommonRefreshView.this.i != null && CommonRefreshView.this.i.getVisibility() != 0) {
                        CommonRefreshView.this.i.setVisibility(0);
                    }
                }
            } else {
                adapter.M();
                if (CommonRefreshView.this.i != null && CommonRefreshView.this.i.getVisibility() != 0) {
                    CommonRefreshView.this.i.setVisibility(0);
                }
            }
            CommonRefreshView.this.b.onRefreshSuccess(adapter.N(), adapter.j());
            this.b = true;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d extends HttpCallback {
        public int a;
        public boolean b;

        public d() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onError() {
            super.onError();
            CommonRefreshView.i(CommonRefreshView.this);
            if (CommonRefreshView.this.b != null) {
                CommonRefreshView.this.b.onLoadMoreFailure();
            }
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onFinish() {
            if (CommonRefreshView.this.e != null) {
                boolean z = this.b;
                CommonRefreshView commonRefreshView = CommonRefreshView.this;
                if (!z) {
                    commonRefreshView.e.s(false);
                    return;
                }
                e unused = commonRefreshView.b;
                int i = this.a;
                int i2 = CommonRefreshView.this.n;
                CommonRefreshView commonRefreshView2 = CommonRefreshView.this;
                if (i < i2) {
                    commonRefreshView2.e.t();
                } else {
                    commonRefreshView2.e.s(true);
                }
            }
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onStart() {
            this.a = 0;
            this.b = false;
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (CommonRefreshView.this.b == null) {
                CommonRefreshView.i(CommonRefreshView.this);
                return;
            }
            if (i != 0) {
                t54.b(str);
                CommonRefreshView.i(CommonRefreshView.this);
                return;
            }
            if (CommonRefreshView.this.j != null && CommonRefreshView.this.j.getVisibility() == 0) {
                CommonRefreshView.this.j.setVisibility(4);
            }
            CommonRefreshView commonRefreshView = CommonRefreshView.this;
            if (strArr == null) {
                CommonRefreshView.i(commonRefreshView);
                return;
            }
            List processData = commonRefreshView.b.processData(strArr);
            if (processData == null) {
                CommonRefreshView.i(CommonRefreshView.this);
                return;
            }
            this.a = processData.size();
            ce3 ce3Var = (ce3) CommonRefreshView.this.h.getAdapter();
            if (this.a <= 0) {
                CommonRefreshView.i(CommonRefreshView.this);
            } else if (ce3Var != null) {
                ce3Var.O(processData);
            }
            CommonRefreshView.this.b.onLoadMoreSuccess(processData, this.a);
            this.b = true;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface e {
        ce3 getAdapter();

        void loadData(int i, HttpCallback httpCallback);

        void onLoadMoreFailure();

        void onLoadMoreSuccess(List list, int i);

        void onRefreshFailure();

        void onRefreshSuccess(List list, int i);

        List processData(String[] strArr);
    }

    public CommonRefreshView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.p = new c();
        this.q = new d();
        this.a = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, da3.B0);
        this.k = obtainStyledAttributes.getBoolean(da3.F0, true);
        this.l = obtainStyledAttributes.getBoolean(da3.E0, true);
        this.c = obtainStyledAttributes.getResourceId(da3.D0, u73.Y);
        this.n = obtainStyledAttributes.getInteger(da3.C0, 20);
        this.o = obtainStyledAttributes.getColor(da3.G0, o60.b(context, p53.l));
        obtainStyledAttributes.recycle();
    }

    public static /* synthetic */ int i(CommonRefreshView commonRefreshView) {
        int i = commonRefreshView.m;
        commonRefreshView.m = i - 1;
        return i;
    }

    public View getContentView() {
        return this.d;
    }

    public int getItemCount() {
        return this.n;
    }

    public int getPageCount() {
        return this.m;
    }

    public RecyclerView getRecyclerView() {
        return this.h;
    }

    public ViewGroup getmEmptyLayout() {
        return this.i;
    }

    public void j() {
        FrameLayout frameLayout = this.i;
        if (frameLayout == null || frameLayout.getVisibility() != 0) {
            return;
        }
        this.i.setVisibility(4);
    }

    public void k() {
        m();
    }

    public final void l() {
        e eVar = this.b;
        if (eVar != null) {
            int i = this.m + 1;
            this.m = i;
            eVar.loadData(i, this.q);
        }
    }

    public final void m() {
        SmartRefreshLayout smartRefreshLayout;
        if (this.l && (smartRefreshLayout = this.e) != null) {
            smartRefreshLayout.F();
        }
        e eVar = this.b;
        if (eVar != null) {
            this.m = 1;
            eVar.loadData(1, this.p);
        }
    }

    public void n() {
        FrameLayout frameLayout = this.i;
        if (frameLayout == null || frameLayout.getVisibility() == 0) {
            return;
        }
        this.i.setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == y63.p) {
            m();
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        View inflate = LayoutInflater.from(this.a).inflate(this.c, (ViewGroup) this, false);
        this.d = inflate;
        addView(inflate);
        this.e = inflate.findViewById(y63.a0);
        this.i = (FrameLayout) inflate.findViewById(y63.V);
        this.j = inflate.findViewById(y63.Q);
        RecyclerView findViewById = inflate.findViewById(y63.Z);
        this.h = findViewById;
        findViewById.setHasFixedSize(true);
        this.e.M(new a());
        this.e.L(new b());
        this.e.J(this.k);
        this.e.I(this.l);
        View findViewById2 = inflate.findViewById(y63.p);
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(this);
        }
        ClassicsHeader findViewById3 = findViewById(y63.L);
        this.f = findViewById3;
        findViewById3.n(this.o);
        ClassicsFooter findViewById4 = findViewById(y63.G);
        this.g = findViewById4;
        findViewById4.k(this.o);
        this.g.m(14.0f);
    }

    public <T> void setDataHelper(e eVar) {
        this.b = eVar;
    }

    public void setEmptyLayoutId(int i) {
        FrameLayout frameLayout = this.i;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
            View inflate = LayoutInflater.from(this.a).inflate(i, (ViewGroup) this.i, false);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) inflate.getLayoutParams();
            layoutParams.gravity = 17;
            inflate.setLayoutParams(layoutParams);
            this.i.addView(inflate);
        }
    }

    public void setEmptyLayoutView(View view) {
        FrameLayout frameLayout = this.i;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
            this.i.addView(view);
        }
    }

    public void setItemCount(int i) {
        this.n = i;
    }

    public void setItemDecoration(RecyclerView.n nVar) {
        this.h.k(nVar);
    }

    public void setLayoutManager(RecyclerView.o oVar) {
        this.h.setLayoutManager(oVar);
    }

    public void setLoadMoreEnable(boolean z) {
        SmartRefreshLayout smartRefreshLayout = this.e;
        if (smartRefreshLayout != null) {
            smartRefreshLayout.I(z);
        }
    }

    public void setPageCount(int i) {
        this.m = i;
    }

    public void setRecyclerViewAdapter(ce3 ce3Var) {
        RecyclerView recyclerView = this.h;
        if (recyclerView != null) {
            recyclerView.setAdapter(ce3Var);
        }
    }

    public void setRefreshEnable(boolean z) {
        SmartRefreshLayout smartRefreshLayout = this.e;
        if (smartRefreshLayout != null) {
            smartRefreshLayout.J(z);
        }
    }
}
