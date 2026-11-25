package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.main.activity.MainActivity;
import com.yunbao.video.bean.VideoBean;
import com.yunbao.video.custom.VideoLoadingBar;
import defpackage.di4;
import defpackage.zb2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: /tmp/classes2.dex */
public class bb2 extends v0 implements zb2.b, di4.d {
    public RecyclerView a;
    public zb2 b;
    public fi4 c;
    public VideoLoadingBar d;
    public int e;
    public HttpCallback f;
    public HttpCallback g;
    public yi4 h;
    public VideoBean i;
    public boolean j;
    public di4 k;
    public View l;
    public VideoBean m;

    /* loaded from: /tmp/classes2.dex */
    public class a extends HttpCallback {
        public final /* synthetic */ VideoBean a;

        public a(VideoBean videoBean) {
            this.a = videoBean;
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if ((i == 0 || i == 40019) && strArr.length > 0) {
                JSONObject parseObject = JSON.parseObject(strArr[0]);
                parseObject.getIntValue("is_play");
                int intValue = parseObject.getIntValue("is_vip");
                parseObject.getIntValue("video_free_num");
                int intValue2 = parseObject.getIntValue("used_free_num");
                if (intValue != 0) {
                    pg4.o(this.a.getHref());
                    return;
                }
                pg4.r(intValue2);
                if (intValue2 > 0) {
                    pg4.o(this.a.getHref());
                }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends HttpCallback {
        public b() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onFinish() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i == 0) {
                List parseArray = JSON.parseArray(Arrays.toString(strArr), VideoBean.class);
                if (bb2.this.e == 1 && bb2.this.m != null) {
                    parseArray.add(0, bb2.this.m);
                }
                if (bb2.this.b != null) {
                    bb2.this.b.b0(parseArray);
                }
                if (bb2.this.a != null) {
                    bb2.this.a.v1(0);
                }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends HttpCallback {
        public c() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0) {
                bb2.b0(bb2.this);
                return;
            }
            List parseArray = JSON.parseArray(Arrays.toString(strArr), VideoBean.class);
            int size = parseArray.size();
            bb2 bb2Var = bb2.this;
            if (size <= 0) {
                bb2.b0(bb2Var);
                t54.a(m93.xa);
            } else if (bb2Var.b != null) {
                bb2.this.b.O(parseArray);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d implements yi4 {
        public d() {
        }

        @Override // defpackage.yi4
        public void loadData(int i, HttpCallback httpCallback) {
            zh4.g(i, httpCallback);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e extends m30 {
        public e() {
        }

        @Override // defpackage.m30
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(int i, Integer num) {
            bb2.this.c.X0(i, num.intValue());
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class f extends k30 {
        public f() {
        }

        @Override // defpackage.k30
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(String str) {
            bb2.this.c.Y0(str);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            bb2.this.c.E0();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class h extends k30 {
        public h() {
        }

        @Override // defpackage.k30
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Integer num) {
            bb2.this.c.S0(num.intValue());
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class i extends k30 {
        public i() {
        }

        @Override // defpackage.k30
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Integer num) {
            bb2.this.k.F0(num.intValue());
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class j extends HttpCallback {
        public j() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i == 0) {
                List parseArray = JSON.parseArray(Arrays.toString(strArr), VideoBean.class);
                if (parseArray.size() > 0) {
                    bb2.this.m = (VideoBean) parseArray.get(0);
                    bb2 bb2Var = bb2.this;
                    bb2Var.q0(bb2Var.m);
                }
            }
        }
    }

    public bb2(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
        this.j = true;
    }

    public static /* synthetic */ int b0(bb2 bb2Var) {
        int i2 = bb2Var.e;
        bb2Var.e = i2 - 1;
        return i2;
    }

    @Override // di4.d
    public void I() {
        VideoLoadingBar videoLoadingBar = this.d;
        if (videoLoadingBar != null) {
            videoLoadingBar.setLoading(false);
        }
    }

    @Override // zb2.b
    public void e(fi4 fi4Var) {
        di4 di4Var;
        fi4 fi4Var2 = this.c;
        if (fi4Var2 == null || fi4Var2 != fi4Var || (di4Var = this.k) == null) {
            return;
        }
        di4Var.N0();
    }

    @Override // zb2.b
    public void g(fi4 fi4Var, boolean z) {
        if (fi4Var != null) {
            VideoBean M0 = fi4Var.M0();
            if (M0 != null) {
                this.i = M0;
                this.c = fi4Var;
                View view = this.l;
                if (view != null) {
                    fi4Var.D0(view);
                }
                di4 di4Var = this.k;
                if (di4Var != null) {
                    di4Var.M0(M0, l0());
                    lx1.c("9990", "startPlay111 autoPlay=" + l0());
                    this.k.I0(new e());
                    this.k.J0(new f());
                    this.k.G0(new g());
                    this.k.H0(new h());
                    this.c.W0(new i());
                }
                VideoLoadingBar videoLoadingBar = this.d;
                if (videoLoadingBar != null) {
                    videoLoadingBar.setLoading(true);
                }
            }
            if (z) {
                m0();
            }
        }
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return y73.T0;
    }

    @Override // defpackage.b1
    public void init() {
        RecyclerView findViewById = findViewById(c73.h4);
        this.a = findViewById;
        findViewById.setHasFixedSize(true);
        this.a.setLayoutManager(new LinearLayoutManager(this.mContext, 1, false));
        zb2 zb2Var = new zb2(this.mContext, new ArrayList(), 0);
        this.b = zb2Var;
        zb2Var.a0(this);
        this.a.setAdapter(this.b);
        this.d = (VideoLoadingBar) findViewById(c73.x5);
        zu0.c().n(this);
        this.f = new b();
        this.g = new c();
        this.h = new d();
        di4 di4Var = new di4(this.mContext, null);
        this.k = di4Var;
        di4Var.E0(this);
        this.l = this.k.getContentView();
    }

    public void k0() {
        zh4.k(new j());
    }

    public final boolean l0() {
        Object obj = this.mContext;
        return (obj instanceof MainActivity) && ((MainActivity) obj).w2() == 1;
    }

    @Override // defpackage.y0
    public void loadData() {
        if (isFirstLoadData()) {
            o0();
            n0();
        }
    }

    public final void m0() {
        int i2 = this.e + 1;
        this.e = i2;
        yi4 yi4Var = this.h;
        if (yi4Var != null) {
            yi4Var.loadData(i2, this.g);
        }
    }

    public void n0() {
        di4 di4Var = this.k;
        if (di4Var != null) {
            di4Var.B0();
        }
    }

    public void o0() {
        this.e = 1;
        yi4 yi4Var = this.h;
        if (yi4Var != null) {
            yi4Var.loadData(1, this.f);
        }
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onAppLifecycleEvent(ka kaVar) {
        if (kaVar.a() && ((MainActivity) this.mContext).w2() == 1) {
            lx1.c("9990", "resumePlay();");
            p0();
        } else {
            lx1.c("9990", "pausePlay();");
            n0();
        }
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onFollowEvent(q41 q41Var) {
        fi4 fi4Var;
        VideoBean M0;
        if (this.b == null || (fi4Var = this.c) == null || (M0 = fi4Var.M0()) == null) {
            return;
        }
        this.b.T(false, M0.getId(), q41Var.b(), q41Var.a());
    }

    @Override // defpackage.b1, defpackage.uy1
    public void onPause() {
        super.onPause();
        if (isShowed()) {
            n0();
        }
    }

    @Override // defpackage.b1, defpackage.uy1
    public void onResume() {
        super.onResume();
        if (isShowed()) {
            p0();
        }
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onVideoCommentEvent(ch4 ch4Var) {
        zb2 zb2Var = this.b;
        if (zb2Var != null) {
            zb2Var.R(ch4Var.b(), ch4Var.a());
        }
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onVideoLikeEvent(bi4 bi4Var) {
        zb2 zb2Var = this.b;
        if (zb2Var != null) {
            zb2Var.U(bi4Var.c(), bi4Var.a(), bi4Var.b());
        }
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onVideoShareEvent(bj4 bj4Var) {
        if (this.b != null) {
            throw null;
        }
    }

    public void p0() {
        di4 di4Var = this.k;
        if (di4Var != null) {
            di4Var.D0();
        }
    }

    public final void q0(VideoBean videoBean) {
        zh4.s(videoBean.getUid(), videoBean.getId(), new a(videoBean));
    }

    @Override // defpackage.b1
    public void release() {
        di4 di4Var = this.k;
        if (di4Var != null) {
            di4Var.release();
            this.k = null;
        }
        if (isShowed()) {
            zh4.c();
        }
        zh4.a("getHomeVideoList");
        zu0.c().p(this);
        this.c = null;
        VideoLoadingBar videoLoadingBar = this.d;
        if (videoLoadingBar != null) {
            videoLoadingBar.a();
        }
        this.d = null;
        if (this.b != null) {
            RecyclerView recyclerView = this.a;
            if (recyclerView != null) {
                recyclerView.setAdapter((RecyclerView.Adapter) null);
            }
            this.b.Z();
        }
        this.b = null;
        this.a = null;
        this.h = null;
    }

    @Override // di4.d
    public void s() {
        fi4 fi4Var = this.c;
        if (fi4Var != null) {
            fi4Var.s();
        }
    }

    @Override // defpackage.y0
    public void setShowed(boolean z) {
        if (this.mShowed == z) {
            return;
        }
        super.setShowed(z);
        di4 di4Var = this.k;
        if (!z) {
            if (di4Var != null) {
                di4Var.B0();
            }
            zh4.c();
        } else {
            if (di4Var != null) {
                di4Var.D0();
            }
            fi4 fi4Var = this.c;
            if (fi4Var != null) {
                fi4Var.E0();
            }
            zh4.p();
        }
    }

    @Override // di4.d
    public void t() {
        VideoLoadingBar videoLoadingBar = this.d;
        if (videoLoadingBar != null) {
            videoLoadingBar.setLoading(true);
        }
    }
}
