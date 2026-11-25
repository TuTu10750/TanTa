package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.yunbao.common.custom.MyRadioButton;
import com.yunbao.common.http.CommonHttpConsts;
import com.yunbao.common.http.CommonHttpUtil;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.main.bean.ListBean;
import java.util.Arrays;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class jb2 extends y0 implements View.OnClickListener {
    public ListBean A;
    public int a;
    public String b;
    public SmartRefreshLayout c;
    public ImageView d;
    public ImageView e;
    public ImageView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public MyRadioButton m;
    public MyRadioButton n;
    public MyRadioButton o;
    public View p;
    public View q;
    public View r;
    public RecyclerView s;
    public View t;
    public ib2 u;
    public String v;
    public String w;
    public String x;
    public ListBean y;
    public ListBean z;

    /* loaded from: /tmp/classes2.dex */
    public class a implements ot2 {
        public a() {
        }

        public void onRefresh(ke3 ke3Var) {
            jb2.this.m0();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends HttpCallback {
        public b() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onFinish() {
            if (jb2.this.c != null) {
                jb2.this.c.x(true);
            }
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i == 0) {
                List parseArray = JSON.parseArray(Arrays.toString(strArr), ListBean.class);
                if (parseArray == null || parseArray.size() == 0) {
                    if (jb2.this.t != null && jb2.this.t.getVisibility() != 0) {
                        jb2.this.t.setVisibility(0);
                    }
                } else if (jb2.this.t != null && jb2.this.t.getVisibility() != 4) {
                    jb2.this.t.setVisibility(4);
                }
                int size = parseArray.size();
                jb2 jb2Var = jb2.this;
                if (size > 0) {
                    jb2Var.y = (ListBean) parseArray.get(0);
                } else {
                    jb2Var.y = null;
                }
                jb2 jb2Var2 = jb2.this;
                if (size > 1) {
                    jb2Var2.z = (ListBean) parseArray.get(1);
                } else {
                    jb2Var2.z = null;
                }
                jb2 jb2Var3 = jb2.this;
                if (size > 2) {
                    jb2Var3.A = (ListBean) parseArray.get(2);
                } else {
                    jb2Var3.A = null;
                }
                jb2.this.n0();
                if (size <= 3) {
                    ib2 ib2Var = jb2.this.u;
                    if (ib2Var != null) {
                        ib2Var.M();
                        return;
                    }
                    return;
                }
                List subList = parseArray.subList(3, parseArray.size());
                ib2 ib2Var2 = jb2.this.u;
                if (ib2Var2 != null) {
                    ib2Var2.P(subList);
                }
            }
        }
    }

    public jb2(Context context, ViewGroup viewGroup, int i) {
        super(context, viewGroup, Integer.valueOf(i));
        this.b = "day";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0() {
        b bVar = new b();
        int i = this.a;
        String str = this.b;
        if (i == 1) {
            db2.l0(str, 1, bVar);
        } else {
            db2.n(str, 1, bVar);
        }
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return y73.o1;
    }

    public final void i0(ListBean listBean) {
        if (listBean == null || !canClick()) {
            return;
        }
        CommonHttpUtil.setAttention(listBean.getUid(), null);
    }

    @Override // defpackage.b1
    public void init() {
        findViewById(c73.e0).setOnClickListener(this);
        findViewById(c73.v1).setOnClickListener(this);
        findViewById(c73.H0).setOnClickListener(this);
        findViewById(c73.o1).setOnClickListener(this);
        SmartRefreshLayout findViewById = findViewById(y63.a0);
        this.c = findViewById;
        findViewById.J(true);
        this.c.I(false);
        this.c.M(new a());
        findViewById(c73.k3).setOnClickListener(this);
        findViewById(c73.l3).setOnClickListener(this);
        findViewById(c73.m3).setOnClickListener(this);
        this.d = (ImageView) findViewById(c73.m);
        this.e = (ImageView) findViewById(c73.n);
        this.f = (ImageView) findViewById(c73.o);
        this.g = (TextView) findViewById(c73.M3);
        this.h = (TextView) findViewById(c73.N3);
        this.i = (TextView) findViewById(c73.O3);
        this.j = (TextView) findViewById(c73.H5);
        this.k = (TextView) findViewById(c73.I5);
        this.l = (TextView) findViewById(c73.J5);
        this.m = (MyRadioButton) findViewById(c73.n0);
        this.n = (MyRadioButton) findViewById(c73.o0);
        this.o = (MyRadioButton) findViewById(c73.p0);
        this.m.setOnClickListener(this);
        this.n.setOnClickListener(this);
        this.o.setOnClickListener(this);
        this.p = findViewById(c73.M1);
        this.q = findViewById(c73.N1);
        this.r = findViewById(c73.O1);
        this.t = findViewById(c73.S3);
        RecyclerView findViewById2 = findViewById(c73.h4);
        this.s = findViewById2;
        findViewById2.setLayoutManager(new LinearLayoutManager(this.mContext, 1, false));
        j30 q = j30.q();
        String F = this.a == 1 ? q.F() : q.g();
        this.v = F;
        ib2 ib2Var = new ib2(this.mContext, F);
        this.u = ib2Var;
        this.s.setAdapter(ib2Var);
        this.w = aq4.a(m93.M1);
        this.x = aq4.a(m93.N1);
    }

    public final void j0(ListBean listBean) {
        if (listBean == null || !canClick()) {
            return;
        }
        pi3.q(this.mContext, listBean.getUid());
    }

    public final boolean k0(ListBean listBean, MyRadioButton myRadioButton, String str, int i) {
        if (listBean == null || !str.equals(listBean.getUid())) {
            return false;
        }
        listBean.setAttention(i);
        if (myRadioButton != null) {
            if (i == 1) {
                myRadioButton.a(true);
                myRadioButton.setText(this.x);
            } else {
                myRadioButton.a(false);
                myRadioButton.setText(this.w);
            }
        }
        return true;
    }

    public void l0(String str, int i) {
        ib2 ib2Var;
        if (TextUtils.isEmpty(str) || k0(this.y, this.m, str, i) || k0(this.z, this.n, str, i) || k0(this.A, this.o, str, i) || (ib2Var = this.u) == null) {
            return;
        }
        ib2Var.d0(str, i);
    }

    @Override // defpackage.y0
    public void loadData() {
        if (isFirstLoadData()) {
            m0();
        }
    }

    public final void n0() {
        ListBean listBean = this.y;
        View view = this.p;
        if (listBean != null) {
            if (view != null && view.getVisibility() != 0) {
                this.p.setVisibility(0);
            }
            if (this.d != null) {
                kn1.f(this.mContext, this.y.getAvatarThumb(), this.d);
            }
            TextView textView = this.g;
            if (textView != null) {
                textView.setText(this.y.getUserNiceName());
            }
            TextView textView2 = this.j;
            if (textView2 != null) {
                textView2.setText(rv3.a(this.y.getTotalCoinFormat(), " ", this.v));
            }
            if (this.m != null) {
                int attention = this.y.getAttention();
                MyRadioButton myRadioButton = this.m;
                if (attention == 1) {
                    myRadioButton.a(true);
                    this.m.setText(this.x);
                } else {
                    myRadioButton.a(false);
                    this.m.setText(this.w);
                }
            }
        } else if (view != null && view.getVisibility() != 4) {
            this.p.setVisibility(4);
        }
        ListBean listBean2 = this.z;
        View view2 = this.q;
        if (listBean2 != null) {
            if (view2 != null && view2.getVisibility() != 0) {
                this.q.setVisibility(0);
            }
            if (this.e != null) {
                kn1.f(this.mContext, this.z.getAvatarThumb(), this.e);
            }
            TextView textView3 = this.h;
            if (textView3 != null) {
                textView3.setText(this.z.getUserNiceName());
            }
            TextView textView4 = this.k;
            if (textView4 != null) {
                textView4.setText(rv3.a(this.z.getTotalCoinFormat(), " ", this.v));
            }
            if (this.n != null) {
                int attention2 = this.z.getAttention();
                MyRadioButton myRadioButton2 = this.n;
                if (attention2 == 1) {
                    myRadioButton2.a(true);
                    this.n.setText(this.x);
                } else {
                    myRadioButton2.a(false);
                    this.n.setText(this.w);
                }
            }
        } else if (view2 != null && view2.getVisibility() != 4) {
            this.q.setVisibility(4);
        }
        ListBean listBean3 = this.A;
        View view3 = this.r;
        if (listBean3 == null) {
            if (view3 == null || view3.getVisibility() == 4) {
                return;
            }
            this.r.setVisibility(4);
            return;
        }
        if (view3 != null && view3.getVisibility() != 0) {
            this.r.setVisibility(0);
        }
        if (this.f != null) {
            kn1.f(this.mContext, this.A.getAvatarThumb(), this.f);
        }
        TextView textView5 = this.i;
        if (textView5 != null) {
            textView5.setText(this.A.getUserNiceName());
        }
        TextView textView6 = this.l;
        if (textView6 != null) {
            textView6.setText(rv3.a(this.A.getTotalCoinFormat(), " ", this.v));
        }
        if (this.o != null) {
            int attention3 = this.A.getAttention();
            MyRadioButton myRadioButton3 = this.o;
            if (attention3 == 1) {
                myRadioButton3.a(true);
                this.o.setText(this.x);
            } else {
                myRadioButton3.a(false);
                this.o.setText(this.w);
            }
        }
    }

    public final void o0(String str) {
        if (TextUtils.isEmpty(str) || str.equals(this.b)) {
            return;
        }
        this.b = str;
        m0();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == c73.e0) {
            o0("day");
            return;
        }
        if (id == c73.v1) {
            o0("week");
            return;
        }
        if (id == c73.H0) {
            o0("month");
            return;
        }
        if (id == c73.o1) {
            o0("total");
            return;
        }
        if (id == c73.k3) {
            j0(this.y);
            return;
        }
        if (id == c73.l3) {
            j0(this.z);
            return;
        }
        if (id == c73.m3) {
            j0(this.A);
            return;
        }
        if (id == c73.n0) {
            i0(this.y);
        } else if (id == c73.o0) {
            i0(this.z);
        } else if (id == c73.p0) {
            i0(this.A);
        }
    }

    @Override // defpackage.b1, defpackage.uy1
    public void onDestroy() {
        super.onDestroy();
        db2.i("profitList");
        db2.i("consumeList");
        CommonHttpUtil.cancel(CommonHttpConsts.SET_ATTENTION);
    }

    @Override // defpackage.b1
    public void processArguments(Object... objArr) {
        this.a = ((Integer) objArr[0]).intValue();
    }
}
