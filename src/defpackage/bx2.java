package defpackage;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewpager.widget.ViewPager;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.activity.ChooseVideoActivity;
import com.yunbao.mall.activity.PayContentPubActivity;
import com.yunbao.mall.bean.PayContentVideoBean;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class bx2 extends r0 implements View.OnClickListener {
    public List f;
    public k0[] g;
    public hx2 h;
    public ex2 i;
    public ViewPager j;

    /* loaded from: /tmp/classes2.dex */
    public class a implements ViewPager.j {
        public a() {
        }

        public void a(int i, float f, int i2) {
        }

        public void b(int i) {
        }

        public void c(int i) {
            bx2.this.k0(i);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends vx2 {

        /* loaded from: /tmp/classes2.dex */
        public class a extends s4 {
            public a() {
            }

            @Override // defpackage.s4
            public void c(Intent intent) {
                String stringExtra = intent.getStringExtra("videoPath");
                long longExtra = intent.getLongExtra("videoDuration", 0L);
                if (TextUtils.isEmpty(stringExtra)) {
                    return;
                }
                if (bx2.this.j == null || bx2.this.j.getCurrentItem() != 0) {
                    if (bx2.this.i != null) {
                        bx2.this.i.d0(stringExtra, String.valueOf(longExtra / 1000));
                    }
                } else if (bx2.this.h != null) {
                    bx2.this.h.d0(stringExtra, String.valueOf(longExtra / 1000));
                }
            }
        }

        public b() {
        }

        @Override // defpackage.vx2
        public void a() {
            b5.a((AbsActivity) bx2.this.mContext, new Intent(bx2.this.mContext, (Class<?>) ChooseVideoActivity.class), new a());
        }
    }

    public bx2(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0(int i) {
        k0 k0Var;
        k0[] k0VarArr = this.g;
        if (k0VarArr == null) {
            return;
        }
        k0 k0Var2 = k0VarArr[i];
        k0 k0Var3 = k0Var2;
        if (k0Var2 == null) {
            List list = this.f;
            k0Var3 = k0Var2;
            if (list != null) {
                k0Var3 = k0Var2;
                if (i < list.size()) {
                    FrameLayout frameLayout = (FrameLayout) this.f.get(i);
                    if (frameLayout == null) {
                        return;
                    }
                    if (i == 0) {
                        hx2 hx2Var = new hx2(this.mContext, frameLayout);
                        this.h = hx2Var;
                        k0Var = hx2Var;
                    } else {
                        k0Var = k0Var2;
                        if (i == 1) {
                            ex2 ex2Var = new ex2(this.mContext, frameLayout);
                            this.i = ex2Var;
                            k0Var = ex2Var;
                        }
                    }
                    if (k0Var == null) {
                        return;
                    }
                    this.g[i] = k0Var;
                    k0Var.addToParent();
                    k0Var.subscribeActivityLifeCycle();
                    k0Var3 = k0Var;
                }
            }
        }
        if (k0Var3 != null) {
            k0Var3.loadData();
        }
    }

    private void l0() {
        List<PayContentVideoBean> a0;
        ViewPager viewPager = this.j;
        if (viewPager == null) {
            return;
        }
        if (viewPager.getCurrentItem() == 0) {
            hx2 hx2Var = this.h;
            if (hx2Var != null) {
                PayContentVideoBean b0 = hx2Var.b0();
                if (b0 == null || !b0.hasFile()) {
                    t54.a(m93.G7);
                    return;
                } else {
                    ((PayContentPubActivity) this.mContext).N1(b0);
                    hide();
                    return;
                }
            }
            return;
        }
        ex2 ex2Var = this.i;
        if (ex2Var == null || (a0 = ex2Var.a0()) == null || a0.size() <= 0) {
            return;
        }
        for (PayContentVideoBean payContentVideoBean : a0) {
            if (!payContentVideoBean.hasFile()) {
                t54.a(m93.G7);
                return;
            } else if (TextUtils.isEmpty(payContentVideoBean.getTitle())) {
                t54.a(m93.H7);
                return;
            }
        }
        ((PayContentPubActivity) this.mContext).O1(a0);
        hide();
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return z73.C;
    }

    @Override // defpackage.r0, defpackage.b1
    public void init() {
        super.init();
        this.f = new ArrayList();
        for (int i = 0; i < 2; i++) {
            FrameLayout frameLayout = new FrameLayout(this.mContext);
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.f.add(frameLayout);
        }
        ViewPager findViewById = findViewById(d73.v4);
        this.j = findViewById;
        findViewById.setOffscreenPageLimit(1);
        this.j.setAdapter(new dk4(this.f));
        this.j.c(new a());
        this.g = new k0[2];
        findViewById(d73.m1).setOnClickListener(this);
        findViewById(d73.F0).setOnClickListener(this);
        findViewById(d73.d1).setOnClickListener(this);
    }

    public void j0() {
        if (v31.a(false)) {
            yx2.a((AbsActivity) this.mContext, new b(), "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.CAMERA", "android.permission.RECORD_AUDIO");
        }
    }

    @Override // defpackage.r0
    public void loadData() {
        if (this.c) {
            return;
        }
        this.c = true;
        k0(0);
    }

    @Override // defpackage.r0, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        int id = view.getId();
        if (id == d73.m1) {
            ViewPager viewPager = this.j;
            if (viewPager == null || viewPager.getCurrentItem() == 0) {
                return;
            }
            this.j.M(0, false);
            return;
        }
        if (id != d73.F0) {
            if (id == d73.d1) {
                l0();
            }
        } else {
            ViewPager viewPager2 = this.j;
            if (viewPager2 == null || viewPager2.getCurrentItem() == 1) {
                return;
            }
            this.j.M(1, false);
        }
    }
}
