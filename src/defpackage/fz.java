package defpackage;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.umeng.commonsdk.statistics.UMErrorCode;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.bean.UserBean;
import com.yunbao.common.custom.InterceptFrameLayout;
import com.yunbao.common.http.CommonHttpUtil;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.im.activity.ChatRoomActivity;
import com.yunbao.im.bean.ImConversationBean;
import com.yunbao.im.custom.MyImageView;
import com.yunbao.im.dao.IMDbHelper;
import com.yunbao.im.dao.IMMessageBean;
import defpackage.ck1;
import defpackage.cm4;
import defpackage.gp1;
import defpackage.hk1;
import java.io.File;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: /tmp/classes2.dex */
public class fz extends b1 implements View.OnClickListener, hk1.g {
    public RecyclerView a;
    public hk1 b;
    public TextView c;
    public UserBean d;
    public String e;
    public ry f;
    public py g;
    public View h;
    public ti2 i;
    public File j;
    public long k;
    public Handler l;
    public cm4 m;
    public View n;
    public gp1 o;
    public TextView p;
    public IMDbHelper q;
    public int r;
    public String s;
    public SimpleDateFormat t;

    /* loaded from: /tmp/classes2.dex */
    public class a implements ck1.a {
        public a() {
        }

        @Override // ck1.a
        public void a(IMMessageBean iMMessageBean, int i) {
        }

        @Override // ck1.a
        public void b(IMMessageBean iMMessageBean) {
            if (fz.this.b != null) {
                fz.this.b.g0(iMMessageBean);
            }
        }

        @Override // ck1.a
        public void c(IMMessageBean iMMessageBean, boolean z) {
            fz fzVar = fz.this;
            if (!z) {
                if (fzVar.b != null) {
                    fz.this.b.p0(iMMessageBean, 3);
                }
                t54.a(m93.A2);
                return;
            }
            if (fzVar.b != null) {
                fz.this.b.p0(iMMessageBean, 2);
            }
            if (iMMessageBean.getOriginImageUrl() == null || iMMessageBean.getOriginImageUrl().isEmpty()) {
                return;
            }
            try {
                fz.this.H0(2, URLEncoder.encode(iMMessageBean.getOriginImageUrl(), "UTF-8"));
            } catch (Exception e) {
                ah1.a(e);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements ck1.a {
        public b() {
        }

        @Override // ck1.a
        public void a(IMMessageBean iMMessageBean, int i) {
        }

        @Override // ck1.a
        public void b(IMMessageBean iMMessageBean) {
            if (fz.this.b != null) {
                fz.this.b.g0(iMMessageBean);
            }
        }

        @Override // ck1.a
        public void c(IMMessageBean iMMessageBean, boolean z) {
            fz fzVar = fz.this;
            if (z) {
                if (fzVar.b != null) {
                    fz.this.b.p0(iMMessageBean, 2);
                }
                fz.this.H0(3, "[语音]");
            } else {
                if (fzVar.b != null) {
                    fz.this.b.p0(iMMessageBean, 3);
                }
                t54.a(m93.A2);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends gp1.g {
        public c() {
        }

        @Override // gp1.g
        public void a(String str) {
            fz.this.J0(str);
        }

        @Override // gp1.g
        public void b() {
            fz.this.t0();
        }

        @Override // gp1.g
        public void c() {
            fz.this.M0();
        }

        @Override // gp1.g
        public void d() {
            fz.this.L0();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d implements InterceptFrameLayout.a {
        public d() {
        }

        @Override // com.yunbao.common.custom.InterceptFrameLayout.a
        public boolean a() {
            if (fz.this.o != null) {
                return fz.this.o.B0();
            }
            return false;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e extends HttpCallback {
        public e() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length <= 0) {
                return;
            }
            JSONObject parseObject = JSON.parseObject(strArr[0]);
            fz.this.r = parseObject.getIntValue("is_open");
            String string = parseObject.getString("tips");
            fz.this.s = parseObject.getString("fail_msg");
            int intValue = parseObject.getIntValue("isattention");
            if (string == null || string.isEmpty()) {
                string = "个人隐私不外泄，家庭情况不外泄、飞来横财不动心、迷信活动不参与、偶遇路人不轻信、陌生来电不理睬、网上操作不盲目";
            }
            fz.this.p.setText(string);
            fz.this.p.setSelected(true);
            fz fzVar = fz.this;
            if (intValue != 0) {
                fzVar.h.setVisibility(8);
                return;
            }
            fzVar.h.setVisibility(0);
            fz.this.h.findViewById(a73.l).setOnClickListener(fz.this);
            fz.this.h.findViewById(a73.q).setOnClickListener(fz.this);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class f extends k30 {
        public f() {
        }

        @Override // defpackage.k30
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(List list) {
            if (list.size() > 0) {
                for (int i = 0; i < list.size(); i++) {
                    IMMessageBean iMMessageBean = (IMMessageBean) list.get(i);
                    long timestamp = iMMessageBean.getTimestamp();
                    if (!wj1.b(timestamp, fz.this.b.f0())) {
                        iMMessageBean.setShowTimeString(wj1.a(timestamp));
                        fz.this.b.m0(timestamp);
                    }
                }
                fz.this.B0(list);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class g implements cm4.d {
        public g() {
        }

        @Override // cm4.d
        public void a() {
            if (fz.this.b != null) {
                fz.this.b.o0();
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            fz.this.M0();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class i extends HttpCallback {
        public i() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class j implements ck1.a {
        public j() {
        }

        @Override // ck1.a
        public void a(IMMessageBean iMMessageBean, int i) {
        }

        @Override // ck1.a
        public void b(IMMessageBean iMMessageBean) {
            lx1.c("9999", "发送消息msgId:" + iMMessageBean.getMsgId());
            if (fz.this.o != null) {
                fz.this.o.t0();
            }
            if (fz.this.b != null) {
                fz.this.b.g0(iMMessageBean);
            }
        }

        @Override // ck1.a
        public void c(IMMessageBean iMMessageBean, boolean z) {
            lx1.c("9999", "发送消息success:" + z + "  msgid:" + iMMessageBean.getMsgId());
            fz fzVar = fz.this;
            if (z) {
                if (fzVar.b != null) {
                    fz.this.b.p0(iMMessageBean, 2);
                }
                fz.this.H0(1, iMMessageBean.getText());
            } else {
                if (fzVar.b != null) {
                    fz.this.b.p0(iMMessageBean, 3);
                }
                t54.a(m93.A2);
            }
        }
    }

    public fz(Context context, ViewGroup viewGroup, UserBean userBean, boolean z) {
        super(context, viewGroup, userBean, Boolean.valueOf(z));
        this.s = "发送失败提示。。。";
    }

    private void A0(IMMessageBean iMMessageBean) {
        if (this.q == null) {
            this.q = IMDbHelper.f.a(this.mContext);
        }
        this.q.j(iMMessageBean, new n81() { // from class: cz
            @Override // defpackage.n81
            public final Object invoke(Object obj) {
                return fz.b0((Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0(List list) {
        if (this.q == null) {
            this.q = IMDbHelper.f.a(this.mContext);
        }
        this.q.k(list, new n81() { // from class: bz
            @Override // defpackage.n81
            public final Object invoke(Object obj) {
                return fz.g0(fz.this, (Boolean) obj);
            }
        });
    }

    private void C0(IMMessageBean iMMessageBean, int i2) {
        if (this.q == null) {
            this.q = IMDbHelper.f.a(this.mContext);
        }
        lx1.c("9999", "now msgid:" + iMMessageBean.getMsgId());
        lx1.c("9999", "now time:" + iMMessageBean.getTimestamp());
        this.q.j(iMMessageBean, new n81() { // from class: dz
            @Override // defpackage.n81
            public final Object invoke(Object obj) {
                return fz.a0((Boolean) obj);
            }
        });
        if (i2 == 1) {
            ImConversationBean imConversationBean = new ImConversationBean();
            imConversationBean.setConversationID("");
            imConversationBean.setUserID(iMMessageBean.getUserId());
            imConversationBean.setGroup(false);
            imConversationBean.setGroupID("");
            imConversationBean.setUnReadCount(0);
            imConversationBean.setLastMsgId(iMMessageBean.getMsgId());
            imConversationBean.setLastMsgTime(iMMessageBean.getTimestamp());
            if (iMMessageBean.getType() == 1) {
                imConversationBean.setLastMsgString(iMMessageBean.getText());
            } else if (iMMessageBean.getType() == 2) {
                imConversationBean.setLastMsgString("[图片]");
            } else if (iMMessageBean.getType() == 3) {
                imConversationBean.setLastMsgString("[语音]");
            }
            imConversationBean.setLastMsgTimeString(z0(iMMessageBean.getTimestamp()));
            zu0.c().j(new ij1(imConversationBean));
            lx1.c("9999", "rrrrrrrrrr");
        }
    }

    private boolean D0() {
        return this.r == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H0(int i2, String str) {
        lx1.c("9527", "content:" + str);
        xj1.j(this.e, i2, str, new i());
    }

    private void N0(String str) {
        if (this.q == null) {
            this.q = IMDbHelper.f.a(this.mContext);
        }
        this.q.h(str, new n81() { // from class: zy
            @Override // defpackage.n81
            public final Object invoke(Object obj) {
                return fz.f0(fz.this, (IMMessageBean) obj);
            }
        });
    }

    public static /* synthetic */ qc4 a0(Boolean bool) {
        if (bool.booleanValue()) {
            lx1.c("9999", "1111msg插入成功");
            return null;
        }
        lx1.c("9999", "msg插入失败");
        return null;
    }

    public static /* synthetic */ qc4 b0(Boolean bool) {
        if (bool.booleanValue()) {
            lx1.c("9999", "333333msg插入成功");
            return null;
        }
        lx1.c("9999", "msg插入失败");
        return null;
    }

    public static /* synthetic */ qc4 d0(Boolean bool) {
        if (bool.booleanValue()) {
            lx1.c("9999", "更新成功");
            return null;
        }
        lx1.c("9999", "更新失败");
        return null;
    }

    public static /* synthetic */ qc4 e0(fz fzVar, List list) {
        hk1 hk1Var;
        fzVar.getClass();
        if (list == null || list.size() <= 0) {
            lx1.c("9999", "111msg没有获取到");
            return null;
        }
        lx1.c("9999", "msg获取成功size:" + list.size());
        if (fzVar.a == null || (hk1Var = fzVar.b) == null) {
            return null;
        }
        hk1Var.n0(list);
        fzVar.b.k0();
        return null;
    }

    public static /* synthetic */ qc4 f0(fz fzVar, IMMessageBean iMMessageBean) {
        fzVar.getClass();
        if (iMMessageBean == null) {
            return null;
        }
        iMMessageBean.setRevoked(true);
        fzVar.q.o(iMMessageBean, new n81() { // from class: ez
            @Override // defpackage.n81
            public final Object invoke(Object obj) {
                return fz.d0((Boolean) obj);
            }
        });
        return null;
    }

    public static /* synthetic */ qc4 g0(fz fzVar, Boolean bool) {
        fzVar.getClass();
        if (!bool.booleanValue()) {
            lx1.c("9999", "msg插入失败");
            return null;
        }
        lx1.c("9999", "222222msg插入成功");
        fzVar.E0();
        return null;
    }

    private void u0() {
        View view = this.h;
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        this.h.setVisibility(8);
    }

    private void w0() {
        CommonHttpUtil.setAttention(this.e, null);
    }

    private void y0() {
        xj1.e(this.e, new e());
    }

    private String z0(long j2) {
        if (this.t == null) {
            this.t = new SimpleDateFormat("MM-dd HH:mm");
        }
        return this.t.format(new Date(j2 * 1000));
    }

    public void E0() {
        UserBean userBean = this.d;
        if (userBean == null) {
            return;
        }
        String id = userBean.getId();
        this.e = id;
        if (TextUtils.isEmpty(id)) {
            return;
        }
        this.c.setText(this.d.getUserNiceName());
        if (this.b == null) {
            hk1 hk1Var = new hk1(this.mContext, this.e, this.d);
            this.b = hk1Var;
            hk1Var.l0(this);
            this.a.setAdapter(this.b);
        }
        if (this.q == null) {
            this.q = IMDbHelper.f.a(this.mContext);
        }
        this.q.g(this.e, new n81() { // from class: az
            @Override // defpackage.n81
            public final Object invoke(Object obj) {
                return fz.e0(fz.this, (List) obj);
            }
        });
    }

    public void F0(int i2) {
        hk1 hk1Var = this.b;
        if (hk1Var != null) {
            hk1Var.k0();
        }
        gp1 gp1Var = this.o;
        if (gp1Var != null) {
            gp1Var.E0(i2);
        }
    }

    public void G0(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (D0()) {
            ck1.e().o(str, this.e, new a());
            return;
        }
        UserBean D = j30.q().D();
        IMMessageBean.Companion companion = IMMessageBean.INSTANCE;
        IMMessageBean a2 = companion.a(System.currentTimeMillis() + "", this.e, D.getId(), "", System.currentTimeMillis(), true, 2, 3);
        a2.setLocalPath(str);
        this.b.g0(a2);
        C0(a2, 1);
        IMMessageBean a3 = companion.a("-110" + System.currentTimeMillis(), this.e, j30.q().D().getId(), "", System.currentTimeMillis(), true, 1, 3);
        a3.setRevoked(true);
        a3.setText(this.s);
        this.b.g0(a3);
        C0(a3, 0);
    }

    public void I0() {
        if (D0()) {
            ck1.e().p(this.j.getAbsolutePath(), (int) (this.k / 1000), this.e, new b());
            return;
        }
        UserBean D = j30.q().D();
        IMMessageBean.Companion companion = IMMessageBean.INSTANCE;
        IMMessageBean a2 = companion.a(System.currentTimeMillis() + "", this.e, D.getId(), "", System.currentTimeMillis(), true, 3, 3);
        a2.setDuration((int) (this.k / 1000));
        this.b.g0(a2);
        C0(a2, 1);
        IMMessageBean a3 = companion.a("-110" + System.currentTimeMillis(), this.e, j30.q().D().getId(), "", System.currentTimeMillis(), true, 1, 3);
        a3.setRevoked(true);
        a3.setText(this.s);
        this.b.g0(a3);
        C0(a3, 0);
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void ImMessageRevokeEvent(bk1 bk1Var) {
        String b2 = bk1Var.b();
        if (TextUtils.isEmpty(b2) || !b2.equals(this.e)) {
            return;
        }
        py pyVar = this.g;
        if (pyVar != null) {
            pyVar.S1();
        }
        this.g = null;
        hk1 hk1Var = this.b;
        if (hk1Var != null) {
            hk1Var.h0(bk1Var.a());
        }
        N0(bk1Var.a());
    }

    public void J0(String str) {
        if (TextUtils.isEmpty(str)) {
            t54.a(m93.r1);
            return;
        }
        if (D0()) {
            ck1.e().q(str, this.e, new j());
            return;
        }
        UserBean D = j30.q().D();
        IMMessageBean.Companion companion = IMMessageBean.INSTANCE;
        IMMessageBean a2 = companion.a(System.currentTimeMillis() + "", this.e, D.getId(), "", System.currentTimeMillis(), true, 1, 3);
        a2.setText(str);
        this.b.g0(a2);
        C0(a2, 1);
        IMMessageBean a3 = companion.a("-110" + System.currentTimeMillis(), this.e, j30.q().D().getId(), "", System.currentTimeMillis(), true, 1, 3);
        a3.setRevoked(true);
        a3.setText(this.s);
        this.b.g0(a3);
        C0(a3, 0);
        gp1 gp1Var = this.o;
        if (gp1Var != null) {
            gp1Var.t0();
        }
    }

    public void K0(ry ryVar) {
        this.f = ryVar;
    }

    public final void L0() {
        View view = this.n;
        if (view != null && view.getVisibility() != 0) {
            this.n.setVisibility(0);
        }
        if (this.i == null) {
            this.i = new ti2();
        }
        File file = new File(j30.L);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, da0.a() + ".m4a");
        this.j = file2;
        this.i.g(file2.getAbsolutePath());
        Handler handler = this.l;
        if (handler != null) {
            handler.postDelayed(new h(), 60000L);
        }
    }

    public final void M0() {
        View view = this.n;
        if (view != null && view.getVisibility() == 0) {
            this.n.setVisibility(4);
        }
        long h2 = this.i.h();
        this.k = h2;
        if (h2 >= 2000) {
            I0();
        } else {
            t54.b(aq4.a(m93.F2));
            v0();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // hk1.g
    public void W(MyImageView myImageView, int i2, int i3) {
        IMMessageBean iMMessageBean;
        if (this.b == null || myImageView == 0 || (iMMessageBean = myImageView.getIMMessageBean()) == null) {
            return;
        }
        py pyVar = new py();
        this.g = pyVar;
        pyVar.C2(this.b.e0(iMMessageBean.getImMessageBean()), i2, i3, myImageView.getWidth(), myImageView.getHeight(), myImageView.getDrawable());
        this.g.d2(((AbsActivity) this.mContext).getSupportFragmentManager(), "ChatImageDialog2");
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return w73.D;
    }

    @Override // defpackage.b1
    public void init() {
        this.a = findViewById(a73.Y);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mContext, 1, false);
        linearLayoutManager.Q2(true);
        this.a.setLayoutManager(linearLayoutManager);
        this.c = (TextView) findViewById(a73.p0);
        this.p = (TextView) findViewById(a73.T);
        this.h = findViewById(a73.r);
        findViewById(a73.f).setOnClickListener(this);
        this.n = findViewById(a73.M);
        zu0.c().n(this);
        this.l = new Handler();
        findViewById(a73.A).setOnClickListener(this);
        gp1 gp1Var = new gp1(this.mContext, (ViewGroup) findViewById(a73.P), Boolean.FALSE, Integer.valueOf(u73.U), Integer.valueOf(u73.S));
        this.o = gp1Var;
        gp1Var.addToParent();
        this.o.subscribeActivityLifeCycle();
        View inflate = LayoutInflater.from(this.mContext).inflate(w73.A, (ViewGroup) null, false);
        inflate.setLayoutParams(new ViewGroup.LayoutParams(-1, zn0.a(UMErrorCode.E_UM_BE_NOT_MAINPROCESS)));
        inflate.findViewById(a73.t).setOnClickListener(this);
        inflate.findViewById(a73.h).setOnClickListener(this);
        inflate.findViewById(a73.B).setOnClickListener(this);
        inflate.findViewById(a73.v).setOnClickListener(this);
        this.o.s0(inflate);
        this.o.F0(new c());
        ((InterceptFrameLayout) findViewById(a73.K)).setOnInterceptListener(new d());
        y0();
    }

    public void loadData() {
        lx1.c("9999", "loadData");
        UserBean userBean = this.d;
        if (userBean == null) {
            return;
        }
        String id = userBean.getId();
        this.e = id;
        if (TextUtils.isEmpty(id)) {
            return;
        }
        this.c.setText(this.d.getUserNiceName());
        if (this.b == null) {
            hk1 hk1Var = new hk1(this.mContext, this.e, this.d);
            this.b = hk1Var;
            hk1Var.l0(this);
            this.a.setAdapter(this.b);
        }
        E0();
        ck1.e().c(this.e, new f());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == a73.f) {
            s0();
            return;
        }
        if (id == a73.t) {
            ry ryVar = this.f;
            if (ryVar != null) {
                ryVar.e();
                return;
            }
            return;
        }
        if (id == a73.h) {
            ry ryVar2 = this.f;
            if (ryVar2 != null) {
                ryVar2.b();
                return;
            }
            return;
        }
        if (id == a73.B) {
            ry ryVar3 = this.f;
            if (ryVar3 != null) {
                ryVar3.c();
                return;
            }
            return;
        }
        if (id == a73.v) {
            ry ryVar4 = this.f;
            if (ryVar4 != null) {
                ryVar4.d();
                return;
            }
            return;
        }
        if (id == a73.l) {
            u0();
            return;
        }
        if (id == a73.q) {
            w0();
            return;
        }
        if (id == a73.A) {
            Object obj = this.mContext;
            if ((obj instanceof ChatRoomActivity) && ((ChatRoomActivity) obj).C1()) {
                ((ChatRoomActivity) this.mContext).F1();
            } else {
                pi3.q(this.mContext, this.e);
            }
        }
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onCoinChangeEvent(l20 l20Var) {
        throw null;
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onFollowEvent(q41 q41Var) {
        if (!q41Var.b().equals(this.e) || this.h == null) {
            return;
        }
        int a2 = q41Var.a();
        View view = this.h;
        if (a2 == 1) {
            if (view.getVisibility() == 0) {
                this.h.setVisibility(8);
            }
            t54.a(m93.u2);
        } else if (view.getVisibility() != 0) {
            this.h.setVisibility(0);
        }
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onImMessageBean(IMMessageBean iMMessageBean) {
        lx1.c("9999", "收到消息的回调：userid：" + iMMessageBean.getSenderId());
        if (iMMessageBean.getSenderId().equals(this.e)) {
            ck1.e().l(this.e);
            ck1.e().b();
            hk1 hk1Var = this.b;
            if (hk1Var != null) {
                hk1Var.g0(iMMessageBean);
            }
            A0(iMMessageBean);
        }
    }

    @Override // defpackage.b1, defpackage.uy1
    public void onPause() {
        cm4 cm4Var = this.m;
        if (cm4Var != null) {
            cm4Var.g();
        }
    }

    @Override // defpackage.b1, defpackage.uy1
    public void onResume() {
        cm4 cm4Var = this.m;
        if (cm4Var != null) {
            cm4Var.h();
        }
    }

    @Override // defpackage.b1
    public void processArguments(Object... objArr) {
        UserBean userBean = (UserBean) objArr[0];
        this.d = userBean;
        if (userBean != null) {
            this.e = userBean.getId();
        }
    }

    @Override // defpackage.b1
    public void release() {
        Handler handler = this.l;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.l = null;
        ti2 ti2Var = this.i;
        if (ti2Var != null) {
            ti2Var.f();
        }
        this.i = null;
        cm4 cm4Var = this.m;
        if (cm4Var != null) {
            cm4Var.f();
        }
        this.m = null;
        hk1 hk1Var = this.b;
        if (hk1Var != null) {
            hk1Var.j0();
        }
        zu0.c().p(this);
        this.f = null;
        py pyVar = this.g;
        if (pyVar != null) {
            pyVar.S1();
        }
        this.g = null;
    }

    public void s0() {
        ry ryVar;
        gp1 gp1Var = this.o;
        if ((gp1Var == null || !gp1Var.B0()) && (ryVar = this.f) != null) {
            ryVar.a();
        }
    }

    public final void t0() {
        View view = this.n;
        if (view != null && view.getVisibility() == 0) {
            this.n.setVisibility(4);
        }
        ti2 ti2Var = this.i;
        if (ti2Var != null) {
            ti2Var.h();
        }
        v0();
    }

    @Override // hk1.g
    public void u() {
        cm4 cm4Var = this.m;
        if (cm4Var != null) {
            cm4Var.k();
        }
    }

    public final void v0() {
        File file = this.j;
        if (file != null && file.exists()) {
            this.j.delete();
        }
        this.j = null;
        this.k = 0L;
    }

    @Override // hk1.g
    public void w(File file) {
        if (this.m == null) {
            cm4 cm4Var = new cm4(this.mContext);
            this.m = cm4Var;
            cm4Var.i(new g());
        }
        this.m.j(file.getAbsolutePath());
    }
}
