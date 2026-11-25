package defpackage;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.alibaba.fastjson.JSON;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.main.activity.ActiveAllTopicActivity;
import com.yunbao.main.activity.ActiveSearchTopicActivity;
import com.yunbao.main.bean.ActiveTopicBean;
import java.util.Arrays;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class ja2 extends w0 implements View.OnClickListener {
    public u0[] j;
    public ia2 k;
    public ga2 l;
    public ha2 m;
    public RecyclerView n;
    public g4 o;

    /* loaded from: /tmp/classes2.dex */
    public class a extends HttpCallback {
        public a() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || ja2.this.n == null) {
                return;
            }
            List parseArray = JSON.parseArray(Arrays.toString(strArr), ActiveTopicBean.class);
            g4 g4Var = ja2.this.o;
            ja2 ja2Var = ja2.this;
            if (g4Var != null) {
                ja2Var.o.P(parseArray);
            } else {
                ja2Var.o = new g4(ja2Var.mContext, parseArray);
                ja2.this.n.setAdapter(ja2.this.o);
            }
        }
    }

    public ja2(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    private void r0() {
        u0[] u0VarArr = this.j;
        if (u0VarArr != null) {
            for (u0 u0Var : u0VarArr) {
                if (u0Var != null) {
                    u0Var.a0();
                }
            }
        }
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return y73.h1;
    }

    @Override // defpackage.w0
    public String[] h0() {
        return new String[]{aq4.a(m93.v9), aq4.a(m93.M1), aq4.a(m93.R8)};
    }

    @Override // defpackage.w0
    public void i0(int i) {
        u0 u0Var;
        if (this.j == null) {
            return;
        }
        r0();
        u0 u0Var2 = this.j[i];
        u0 u0Var3 = u0Var2;
        if (u0Var2 == null) {
            List list = this.h;
            u0Var3 = u0Var2;
            if (list != null) {
                u0Var3 = u0Var2;
                if (i < list.size()) {
                    FrameLayout frameLayout = (FrameLayout) this.h.get(i);
                    if (frameLayout == null) {
                        return;
                    }
                    if (i == 0) {
                        ia2 ia2Var = new ia2(this.mContext, frameLayout);
                        this.k = ia2Var;
                        u0Var = ia2Var;
                    } else if (i == 1) {
                        ga2 ga2Var = new ga2(this.mContext, frameLayout);
                        this.l = ga2Var;
                        u0Var = ga2Var;
                    } else {
                        u0Var = u0Var2;
                        if (i == 2) {
                            ha2 ha2Var = new ha2(this.mContext, frameLayout);
                            this.m = ha2Var;
                            u0Var = ha2Var;
                        }
                    }
                    if (u0Var == null) {
                        return;
                    }
                    this.j[i] = u0Var;
                    u0Var.addToParent();
                    u0Var.subscribeActivityLifeCycle();
                    u0Var3 = u0Var;
                }
            }
        }
        if (u0Var3 != null) {
            u0Var3.loadData();
        }
    }

    @Override // defpackage.w0, defpackage.b1
    public void init() {
        setStatusHeight();
        this.j = new u0[3];
        super.init();
        findViewById(c73.c1).setOnClickListener(this);
        findViewById(c73.H).setOnClickListener(this);
        RecyclerView findViewById = findViewById(c73.n4);
        this.n = findViewById;
        findViewById.setHasFixedSize(true);
        this.n.setLayoutManager(new LinearLayoutManager(this.mContext, 0, false));
        this.h.clear();
        for (int i = 0; i < 3; i++) {
            FrameLayout frameLayout = new FrameLayout(this.mContext);
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.h.add(frameLayout);
        }
        this.b.setAdapter(new dk4(this.h));
    }

    @Override // defpackage.w0, defpackage.y0
    public void loadData() {
        q0();
        ViewPager viewPager = this.b;
        if (viewPager != null) {
            i0(viewPager.getCurrentItem());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        int id = view.getId();
        if (id == c73.c1) {
            Context context2 = this.mContext;
            if (context2 != null) {
                context2.startActivity(new Intent(this.mContext, (Class<?>) ActiveSearchTopicActivity.class));
                return;
            }
            return;
        }
        if (id != c73.H || (context = this.mContext) == null) {
            return;
        }
        context.startActivity(new Intent(this.mContext, (Class<?>) ActiveAllTopicActivity.class));
    }

    @Override // defpackage.w0, defpackage.b1, defpackage.uy1
    public void onDestroy() {
        ec2.u("getActiveHotTopic");
        super.onDestroy();
    }

    public final void q0() {
        db2.y(new a());
    }

    @Override // defpackage.y0
    public void setShowed(boolean z) {
        super.setShowed(z);
        r0();
    }
}
