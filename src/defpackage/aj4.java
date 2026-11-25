package defpackage;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.video.activity.AbsVideoPlayActivity;
import com.yunbao.video.bean.VideoBean;
import com.yunbao.video.custom.VideoLoadingBar;
import defpackage.di4;
import defpackage.xi4;
import java.util.Arrays;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: /tmp/classes2.dex */
public class aj4 extends b1 implements xi4.b, di4.d, View.OnClickListener {
    public di4 a;
    public View b;
    public RecyclerView c;
    public xi4 d;
    public int e;
    public String f;
    public fi4 g;
    public VideoLoadingBar h;
    public int i;
    public HttpCallback j;
    public yi4 k;
    public VideoBean l;
    public boolean m;

    /* loaded from: /tmp/classes2.dex */
    public class a extends HttpCallback {
        public a() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0) {
                aj4.e0(aj4.this);
                return;
            }
            List parseArray = JSON.parseArray(Arrays.toString(strArr), VideoBean.class);
            if (parseArray.size() <= 0) {
                t54.a(m93.xa);
                aj4.e0(aj4.this);
            } else {
                if (aj4.this.d != null) {
                    aj4.this.d.O(parseArray);
                }
                zu0.c().j(new zi4(aj4.this.f, aj4.this.i));
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends m30 {
        public b() {
        }

        @Override // defpackage.m30
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(int i, Integer num) {
            aj4.this.g.X0(i, num.intValue());
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends k30 {
        public c() {
        }

        @Override // defpackage.k30
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(String str) {
            if (aj4.this.g != null) {
                aj4.this.g.Y0(str);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d extends k30 {
        public d() {
        }

        @Override // defpackage.k30
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Integer num) {
            aj4.this.a.F0(num.intValue());
        }
    }

    public aj4(Context context, ViewGroup viewGroup, int i, String str, int i2) {
        super(context, viewGroup, Integer.valueOf(i), str, Integer.valueOf(i2));
    }

    public static /* synthetic */ int e0(aj4 aj4Var) {
        int i = aj4Var.i;
        aj4Var.i = i - 1;
        return i;
    }

    private void i0() {
        int i = this.i + 1;
        this.i = i;
        yi4 yi4Var = this.k;
        if (yi4Var != null) {
            yi4Var.loadData(i, this.j);
        }
    }

    @Override // di4.d
    public void I() {
        VideoLoadingBar videoLoadingBar = this.h;
        if (videoLoadingBar != null) {
            videoLoadingBar.setLoading(false);
        }
    }

    @Override // xi4.b
    public void e(fi4 fi4Var) {
        di4 di4Var;
        fi4 fi4Var2 = this.g;
        if (fi4Var2 == null || fi4Var2 != fi4Var || (di4Var = this.a) == null) {
            return;
        }
        di4Var.N0();
    }

    @Override // xi4.b
    public void g(fi4 fi4Var, boolean z) {
        if (fi4Var != null) {
            VideoBean M0 = fi4Var.M0();
            if (M0 != null) {
                this.l = M0;
                this.g = fi4Var;
                View view = this.b;
                if (view != null) {
                    fi4Var.D0(view);
                }
                di4 di4Var = this.a;
                if (di4Var != null) {
                    di4Var.L0(M0);
                    lx1.c("9990", "startPlay222");
                    this.a.I0(new b());
                    this.a.J0(new c());
                    fi4 fi4Var2 = this.g;
                    if (fi4Var2 != null) {
                        fi4Var2.W0(new d());
                    }
                }
                VideoLoadingBar videoLoadingBar = this.h;
                if (videoLoadingBar != null) {
                    videoLoadingBar.setLoading(true);
                }
            }
            if (z) {
                i0();
            }
        }
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return b83.x;
    }

    public final void h0() {
        VideoBean videoBean = this.l;
        if (videoBean != null) {
            AbsVideoPlayActivity absVideoPlayActivity = (AbsVideoPlayActivity) this.mContext;
            absVideoPlayActivity.x1(false, false, false, videoBean.getId(), this.l.getUid());
            absVideoPlayActivity.w1();
        }
    }

    @Override // defpackage.b1
    public void init() {
        List b2 = gj4.d().b(this.f);
        if (b2 == null || b2.size() == 0) {
            return;
        }
        di4 di4Var = new di4(this.mContext, null);
        this.a = di4Var;
        di4Var.E0(this);
        this.b = this.a.getContentView();
        RecyclerView findViewById = findViewById(f73.M);
        this.c = findViewById;
        findViewById.setHasFixedSize(true);
        this.c.setLayoutManager(new LinearLayoutManager(this.mContext, 1, false));
        xi4 xi4Var = new xi4(this.mContext, b2, this.e);
        this.d = xi4Var;
        xi4Var.Z(this);
        this.c.setAdapter(this.d);
        this.h = (VideoLoadingBar) findViewById(f73.d0);
        findViewById(f73.D).setOnClickListener(this);
        findViewById(f73.k).setOnClickListener(this);
        findViewById(f73.e).setOnClickListener(this);
        zu0.c().n(this);
        this.j = new a();
        this.k = gj4.d().c(this.f);
    }

    public final void j0(boolean z) {
        VideoBean videoBean = this.l;
        if (videoBean != null) {
            ((AbsVideoPlayActivity) this.mContext).x1(false, z, true, videoBean.getId(), this.l.getUid());
        }
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onAppLifecycleEvent(ka kaVar) {
        Log.i("9529", "onPauseonPauseonPauseonPause");
        if (kaVar.a()) {
            Log.i("9529", "onResumeonResumeonResumeonResume");
            di4 di4Var = this.a;
            if (di4Var != null) {
                di4Var.D0();
                return;
            }
            return;
        }
        Log.i("9529", "onPauseonPauseonPauseonPause");
        di4 di4Var2 = this.a;
        if (di4Var2 != null) {
            di4Var2.B0();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (((AbsActivity) this.mContext).e1()) {
            int id = view.getId();
            if (id == f73.D) {
                j0(false);
            } else if (id == f73.k) {
                j0(true);
            } else if (id == f73.e) {
                h0();
            }
        }
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onFollowEvent(q41 q41Var) {
        fi4 fi4Var;
        VideoBean M0;
        if (this.d == null || (fi4Var = this.g) == null || (M0 = fi4Var.M0()) == null) {
            return;
        }
        this.d.T(!this.m, M0.getId(), q41Var.b(), q41Var.a());
    }

    @Override // defpackage.b1, defpackage.uy1
    public void onPause() {
        super.onPause();
        this.m = true;
        di4 di4Var = this.a;
        if (di4Var != null) {
            di4Var.B0();
        }
    }

    @Override // defpackage.b1, defpackage.uy1
    public void onResume() {
        super.onResume();
        this.m = false;
        di4 di4Var = this.a;
        if (di4Var != null) {
            di4Var.D0();
        }
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onVideoCommentEvent(ch4 ch4Var) {
        xi4 xi4Var = this.d;
        if (xi4Var != null) {
            xi4Var.R(ch4Var.b(), ch4Var.a());
        }
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onVideoLikeEvent(bi4 bi4Var) {
        xi4 xi4Var = this.d;
        if (xi4Var != null) {
            xi4Var.U(bi4Var.c(), bi4Var.a(), bi4Var.b());
        }
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onVideoShareEvent(bj4 bj4Var) {
        if (this.d != null) {
            throw null;
        }
    }

    @Override // defpackage.b1
    public void processArguments(Object... objArr) {
        this.e = ((Integer) objArr[0]).intValue();
        this.f = (String) objArr[1];
        this.i = ((Integer) objArr[2]).intValue();
    }

    @Override // defpackage.b1
    public void release() {
        Log.i("9529", "releasereleasereleasereleaserelease");
        zh4.a("getHomeVideoList");
        zu0.c().p(this);
        di4 di4Var = this.a;
        if (di4Var != null) {
            di4Var.release();
        }
        this.g = null;
        VideoLoadingBar videoLoadingBar = this.h;
        if (videoLoadingBar != null) {
            videoLoadingBar.a();
        }
        this.h = null;
        if (this.d != null) {
            RecyclerView recyclerView = this.c;
            if (recyclerView != null) {
                recyclerView.setAdapter((RecyclerView.Adapter) null);
            }
            this.d.Y();
        }
        this.d = null;
        this.c = null;
        this.k = null;
    }

    @Override // di4.d
    public void s() {
        fi4 fi4Var = this.g;
        if (fi4Var != null) {
            fi4Var.s();
        }
    }

    @Override // di4.d
    public void t() {
        VideoLoadingBar videoLoadingBar = this.h;
        if (videoLoadingBar != null) {
            videoLoadingBar.setLoading(true);
        }
    }
}
