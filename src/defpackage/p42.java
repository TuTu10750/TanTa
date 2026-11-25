package defpackage;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.common.upload.UploadBean;
import com.yunbao.common.utils.a;
import com.yunbao.live.activity.LiveAnchorActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: /tmp/classes2.dex */
public class p42 extends s42 implements View.OnClickListener {
    public ImageView F;
    public TextView G;
    public EditText H;
    public RecyclerView I;
    public r42 J;
    public File K;
    public TextView L;
    public ImageView M;
    public int N;
    public int O;
    public int P;
    public String Q;
    public s4 R;
    public k30 S;
    public boolean T;
    public int U;
    public int V;
    public String W;
    public boolean X;
    public View Y;
    public View Z;
    public ImageView f0;
    public ImageView g0;
    public int h0;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            if (id == b73.U0) {
                p42.this.D1(0);
            } else if (id == b73.T0) {
                p42.this.D1(1);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements a.m {
        public b() {
        }

        @Override // com.yunbao.common.utils.a.m
        public void b(Dialog dialog, String str) {
            p42.this.d1();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c implements an1 {
        public c() {
        }

        @Override // defpackage.an1
        public void a(File file) {
            if (file != null) {
                kn1.e(p42.this.mContext, file, p42.this.F);
                if (p42.this.K == null) {
                    p42.this.G.setText(aq4.a(m93.x3));
                    p42.this.G.setBackground(o60.d(p42.this.mContext, h63.e));
                }
                p42.this.K = file;
            }
        }

        @Override // defpackage.an1
        public void b() {
        }

        @Override // defpackage.an1
        public void c() {
            ((LiveAnchorActivity) p42.this.mContext).i3();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d implements a.n {
        public final /* synthetic */ an1 a;

        public d(an1 an1Var) {
            this.a = an1Var;
        }

        @Override // com.yunbao.common.utils.a.n
        public void a(String str, int i) {
            int i2 = m93.R0;
            p42 p42Var = p42.this;
            if (i == i2) {
                zj2.l((AbsActivity) p42Var.mContext, this.a);
            } else {
                zj2.i((AbsActivity) p42Var.mContext, this.a);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e extends k30 {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        /* loaded from: /tmp/classes2.dex */
        public class a implements pd4 {

            /* renamed from: p42$e$a$a, reason: collision with other inner class name */
            /* loaded from: /tmp/classes2.dex */
            public class C0142a extends HttpCallback {
                public C0142a() {
                }

                @Override // com.yunbao.common.http.HttpCallback
                public void onSuccess(int i, String str, String[] strArr) {
                    if (i != 0 || strArr.length <= 0) {
                        t54.b(str);
                        return;
                    }
                    lx1.c("开播", "createRoom------->" + strArr[0]);
                    e32.r(strArr[0]);
                    ((LiveAnchorActivity) p42.this.mContext).v2(p42.this.h0);
                    ((LiveAnchorActivity) p42.this.mContext).Q3(strArr[0], p42.this.O, p42.this.P, e.this.a);
                    ((LiveAnchorActivity) p42.this.mContext).G3(false);
                }
            }

            public a() {
            }

            @Override // defpackage.pd4
            public void a(List list, boolean z) {
                if (!z || p42.this.X) {
                    return;
                }
                p42.this.X = true;
                System.out.println("--oooo1111111");
                String C = j30.q().C();
                int i = p42.this.U;
                e eVar = e.this;
                e32.p(C, i, eVar.a, p42.this.N, p42.this.O, e.this.b, 0, ((UploadBean) list.get(0)).getRemoteFileName(), p42.this.T, 1, p42.this.h0, new C0142a());
            }
        }

        public e(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // defpackage.k30
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(qd4 qd4Var) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new UploadBean(p42.this.K, 0));
            qd4Var.a(arrayList, false, new a());
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class f extends HttpCallback {
        public final /* synthetic */ String a;

        public f(String str) {
            this.a = str;
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length <= 0) {
                t54.b(str);
                return;
            }
            lx1.c("开播", "createRoom------->" + strArr[0]);
            e32.r(strArr[0]);
            ((LiveAnchorActivity) p42.this.mContext).v2(p42.this.h0);
            ((LiveAnchorActivity) p42.this.mContext).Q3(strArr[0], p42.this.O, p42.this.P, this.a);
            ((LiveAnchorActivity) p42.this.mContext).G3(false);
        }
    }

    public p42(Context context, ViewGroup viewGroup, int i, int i2, String str) {
        super(context, viewGroup, i, i2, str, false, "", "");
        this.Q = "";
        this.T = true;
        this.h0 = 0;
        View findViewById = findViewById(b73.v2);
        ((ViewGroup.MarginLayoutParams) findViewById.getLayoutParams()).topMargin = gk3.a().d() + zn0.a(5);
        findViewById.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D1(int i) {
        if (this.h0 != i) {
            this.h0 = i;
            View view = this.Y;
            if (i == 0) {
                if (view != null) {
                    view.setBackgroundResource(h63.i);
                }
                View view2 = this.Z;
                if (view2 != null) {
                    view2.setBackgroundResource(h63.h);
                }
                ImageView imageView = this.f0;
                if (imageView != null) {
                    imageView.setImageResource(t83.z0);
                }
                ImageView imageView2 = this.g0;
                if (imageView2 != null) {
                    imageView2.setImageResource(t83.w0);
                    return;
                }
                return;
            }
            if (view != null) {
                view.setBackgroundResource(h63.h);
            }
            View view3 = this.Z;
            if (view3 != null) {
                view3.setBackgroundResource(h63.i);
            }
            ImageView imageView3 = this.f0;
            if (imageView3 != null) {
                imageView3.setImageResource(t83.y0);
            }
            ImageView imageView4 = this.g0;
            if (imageView4 != null) {
                imageView4.setImageResource(t83.x0);
            }
        }
    }

    public final void O0() {
        ((LiveAnchorActivity) this.mContext).onBackPressed();
    }

    public final void P0() {
        String trim = this.H.getText().toString().trim();
        String valueOf = this.O == 1 ? this.Q : String.valueOf(this.P);
        File file = this.K;
        if (file != null && file.exists()) {
            rd4.e("liveshow/", new e(trim, valueOf));
        } else {
            if (this.X) {
                return;
            }
            this.X = true;
            System.out.println("--oooo222222222");
            e32.p(j30.q().C(), this.U, trim, this.N, this.O, valueOf, 0, null, this.T, 1, this.h0, new f(trim));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void W0() {
        c cVar = new c();
        int i = this.U;
        Context context = this.mContext;
        if (i == 1) {
            zj2.i((AbsActivity) context, cVar);
        } else {
            com.yunbao.common.utils.a.r(context, new Integer[]{Integer.valueOf(m93.K0), Integer.valueOf(m93.R0)}, new d(cVar));
        }
    }

    public final void b1() {
        r42 r42Var = this.J;
        if (r42Var == null) {
            System.out.println("on2222222222--------");
            P0();
        } else if (TextUtils.isEmpty(r42Var.P())) {
            System.out.println("on11111111--------");
            P0();
        }
    }

    public final void c1() {
        if (this.T) {
            new a.j(this.mContext).k(aq4.a(m93.d4)).g(true).j(aq4.a(m93.c4)).h(new b()).c().show();
        } else {
            d1();
        }
    }

    public final void d1() {
        boolean z = this.T;
        this.T = !z;
        ImageView imageView = this.M;
        if (imageView != null) {
            imageView.setImageResource(!z ? t83.t0 : t83.s0);
        }
        TextView textView = this.L;
        if (textView != null) {
            textView.setText(this.T ? j30.q().f() : aq4.a(m93.b4));
        }
    }

    @Override // defpackage.s42, defpackage.b1
    public int getLayoutId() {
        return x73.j2;
    }

    @Override // defpackage.s42
    public void hide() {
        View view = this.mContentView;
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        this.mContentView.setVisibility(4);
    }

    @Override // defpackage.s42, defpackage.b1
    public void init() {
        this.Y = findViewById(b73.U0);
        this.Z = findViewById(b73.T0);
        this.f0 = (ImageView) findViewById(b73.P2);
        this.g0 = (ImageView) findViewById(b73.O2);
        a aVar = new a();
        this.Y.setOnClickListener(aVar);
        this.Z.setOnClickListener(aVar);
        this.F = (ImageView) findViewById(b73.d);
        this.G = (TextView) findViewById(b73.G1);
        this.H = (EditText) findViewById(b73.S1);
        TextView textView = (TextView) findViewById(b73.r1);
        this.L = textView;
        textView.setText(j30.q().f());
        this.M = (ImageView) findViewById(b73.N3);
        findViewById(b73.w0).setOnClickListener(this);
        this.T = true;
        RecyclerView findViewById = findViewById(b73.B4);
        this.I = findViewById;
        findViewById.setHasFixedSize(true);
        this.I.setLayoutManager(new LinearLayoutManager(this.mContext, 0, false));
        r42 r42Var = new r42(this.mContext);
        this.J = r42Var;
        this.I.setAdapter(r42Var);
        findViewById(b73.g).setOnClickListener(this);
        findViewById(b73.H).setOnClickListener(this);
        findViewById(b73.f1).setOnClickListener(this);
        TextView textView2 = (TextView) findViewById(b73.X1);
        if (textView2 != null) {
            textView2.setText(this.W);
        }
        if (j30.q().r() == 0.0d || j30.q().v() == 0.0d) {
            zu0.c().n(this);
        }
    }

    @Override // defpackage.s42, android.view.View.OnClickListener
    public void onClick(View view) {
        if (canClick()) {
            int id = view.getId();
            if (id == b73.g) {
                W0();
                return;
            }
            if (id == b73.H) {
                O0();
            } else if (id == b73.f1) {
                b1();
            } else if (id == b73.w0) {
                c1();
            }
        }
    }

    @Override // defpackage.s42, defpackage.b1, defpackage.uy1
    public void onDestroy() {
        if (zu0.c().h(this)) {
            zu0.c().p(this);
        }
        rd4.c();
        e32.f("createRoom");
    }

    @Override // defpackage.s42
    @pw3(threadMode = ThreadMode.MAIN)
    public void onLocationCityEvent(k72 k72Var) {
        if (this.T && this.L != null) {
            throw null;
        }
    }

    @Override // defpackage.s42, defpackage.b1
    public void processArguments(Object... objArr) {
        if (objArr.length > 0) {
            this.U = ((Integer) objArr[0]).intValue();
        }
        if (objArr.length > 1) {
            this.V = ((Integer) objArr[1]).intValue();
        }
        if (objArr.length > 2) {
            this.W = (String) objArr[2];
        }
    }

    @Override // defpackage.s42, defpackage.b1
    public void release() {
        this.R = null;
        this.S = null;
        if (zu0.c().h(this)) {
            zu0.c().p(this);
        }
    }

    @Override // defpackage.s42
    public void show() {
        View view = this.mContentView;
        if (view == null || view.getVisibility() == 0) {
            return;
        }
        this.mContentView.setVisibility(0);
    }
}
