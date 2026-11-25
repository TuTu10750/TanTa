package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yunbao.common.bean.UserBean;
import com.yunbao.common.http.CommonHttpUtil;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.im.bean.ImConversationBean;
import com.yunbao.im.bean.ImMessageBean;
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
public class yy extends b1 implements View.OnClickListener, hk1.g {
    public RecyclerView a;
    public hk1 b;
    public TextView c;
    public UserBean d;
    public String e;
    public ry f;
    public py g;
    public boolean h;
    public View i;
    public cm4 j;
    public gp1 k;
    public String l;
    public k30 m;
    public TextView n;
    public IMDbHelper o;
    public int p;
    public String q;
    public SimpleDateFormat r;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || yy.this.k == null) {
                return false;
            }
            return yy.this.k.B0();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends gp1.g {
        public b() {
        }

        @Override // gp1.g
        public void a(String str) {
            yy.this.C0(str);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends HttpCallback {
        public c() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length <= 0) {
                return;
            }
            JSONObject parseObject = JSON.parseObject(strArr[0]);
            yy.this.p = parseObject.getIntValue("is_open");
            String string = parseObject.getString("tips");
            yy.this.q = parseObject.getString("fail_msg");
            int intValue = parseObject.getIntValue("isattention");
            if (string == null || string.isEmpty()) {
                string = "个人隐私不外泄，家庭情况不外泄、飞来横财不动心、迷信活动不参与、偶遇路人不轻信、陌生来电不理睬、网上操作不盲目";
            }
            yy.this.n.setText(string);
            yy.this.n.setSelected(true);
            yy yyVar = yy.this;
            if (intValue != 0) {
                yyVar.i.setVisibility(8);
                return;
            }
            yyVar.i.setVisibility(0);
            yy.this.i.findViewById(a73.l).setOnClickListener(yy.this);
            yy.this.i.findViewById(a73.q).setOnClickListener(yy.this);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d extends k30 {
        public d() {
        }

        @Override // defpackage.k30
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(List list) {
            if (list.size() > 0) {
                for (int i = 0; i < list.size(); i++) {
                    IMMessageBean iMMessageBean = (IMMessageBean) list.get(i);
                    long timestamp = iMMessageBean.getTimestamp();
                    if (!wj1.b(timestamp, yy.this.b.f0())) {
                        iMMessageBean.setShowTimeString(wj1.a(timestamp));
                        yy.this.b.m0(timestamp);
                    }
                }
                yy.this.v0(list);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e implements cm4.d {
        public e() {
        }

        @Override // cm4.d
        public void a() {
            if (yy.this.b != null) {
                yy.this.b.o0();
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class f extends HttpCallback {
        public f() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class g implements ck1.a {
        public g() {
        }

        @Override // ck1.a
        public void a(IMMessageBean iMMessageBean, int i) {
        }

        @Override // ck1.a
        public void b(IMMessageBean iMMessageBean) {
            if (yy.this.k != null) {
                yy.this.k.t0();
            }
            if (yy.this.b != null) {
                yy.this.b.g0(iMMessageBean);
            }
        }

        @Override // ck1.a
        public void c(IMMessageBean iMMessageBean, boolean z) {
            yy yyVar = yy.this;
            if (z) {
                if (yyVar.b != null) {
                    yy.this.b.p0(iMMessageBean, 2);
                }
                yy.this.B0(1, iMMessageBean.getText());
            } else {
                if (yyVar.b != null) {
                    yy.this.b.p0(iMMessageBean, 3);
                }
                t54.a(m93.A2);
            }
        }
    }

    public yy(Context context, ViewGroup viewGroup, UserBean userBean, boolean z) {
        super(context, viewGroup, userBean, Boolean.valueOf(z));
        this.q = "发送失败提示。。。";
    }

    public static /* synthetic */ qc4 a0(Boolean bool) {
        if (bool.booleanValue()) {
            lx1.c("9999", "1111msg插入成功");
            return null;
        }
        lx1.c("9999", "msg插入失败");
        return null;
    }

    public static /* synthetic */ qc4 b0(yy yyVar, IMMessageBean iMMessageBean) {
        yyVar.getClass();
        if (iMMessageBean == null) {
            return null;
        }
        iMMessageBean.setRevoked(true);
        yyVar.o.o(iMMessageBean, new n81() { // from class: xy
            @Override // defpackage.n81
            public final Object invoke(Object obj) {
                return yy.f0((Boolean) obj);
            }
        });
        return null;
    }

    public static /* synthetic */ qc4 d0(yy yyVar, Boolean bool) {
        yyVar.getClass();
        if (!bool.booleanValue()) {
            lx1.c("9999", "msg插入失败");
            return null;
        }
        lx1.c("9999", "msg插入成功");
        yyVar.z0();
        return null;
    }

    public static /* synthetic */ qc4 e0(yy yyVar, List list) {
        hk1 hk1Var;
        yyVar.getClass();
        if (list == null || list.size() <= 0) {
            lx1.c("9999", "2222msg没有获取到");
            return null;
        }
        lx1.c("9999", "msg获取成功size:" + list.size());
        if (yyVar.a == null || (hk1Var = yyVar.b) == null) {
            return null;
        }
        hk1Var.n0(list);
        yyVar.b.k0();
        return null;
    }

    public static /* synthetic */ qc4 f0(Boolean bool) {
        if (bool.booleanValue()) {
            lx1.c("9999", "更新成功");
            return null;
        }
        lx1.c("9999", "更新失败");
        return null;
    }

    public static /* synthetic */ qc4 g0(Boolean bool) {
        if (bool.booleanValue()) {
            lx1.c("9999", "msg插入成功");
            return null;
        }
        lx1.c("9999", "msg插入失败");
        return null;
    }

    private void r0() {
        String str;
        String str2 = this.l;
        if (str2 == null || (str = this.e) == null) {
            return;
        }
        if (!str2.equals(str) || this.m == null) {
            CommonHttpUtil.setAttention(this.e, null);
            return;
        }
        CommonHttpUtil.setAttention("tag", "live_" + this.l, this.e, this.m);
    }

    public void A0(int i) {
        hk1 hk1Var = this.b;
        if (hk1Var != null) {
            hk1Var.k0();
        }
        gp1 gp1Var = this.k;
        if (gp1Var != null) {
            gp1Var.E0(i);
        }
    }

    public final void B0(int i, String str) {
        try {
            xj1.j(this.e, i, URLEncoder.encode(str, "UTF-8"), new f());
        } catch (Exception e2) {
            ah1.a(e2);
        }
    }

    public void C0(String str) {
        if (TextUtils.isEmpty(str)) {
            t54.a(m93.r1);
            return;
        }
        if (y0()) {
            ck1.e().q(str, this.e, new g());
            return;
        }
        UserBean D = j30.q().D();
        IMMessageBean.Companion companion = IMMessageBean.INSTANCE;
        IMMessageBean a2 = companion.a(System.currentTimeMillis() + "", this.e, D.getId(), "", System.currentTimeMillis(), true, 1, 3);
        a2.setText(str);
        this.b.g0(a2);
        w0(a2, 1);
        IMMessageBean a3 = companion.a("-110" + System.currentTimeMillis(), this.e, j30.q().D().getId(), "", System.currentTimeMillis(), true, 1, 3);
        a3.setRevoked(true);
        a3.setText(this.q);
        this.b.g0(a3);
        w0(a3, 0);
        gp1 gp1Var = this.k;
        if (gp1Var != null) {
            gp1Var.t0();
        }
    }

    public void D0(ry ryVar) {
        this.f = ryVar;
    }

    public void E0(k30 k30Var) {
        this.m = k30Var;
    }

    public void F0(String str) {
        this.l = str;
    }

    public final void G0(String str) {
        if (this.o == null) {
            this.o = IMDbHelper.f.a(this.mContext);
        }
        this.o.h(str, new n81() { // from class: wy
            @Override // defpackage.n81
            public final Object invoke(Object obj) {
                return yy.b0(yy.this, (IMMessageBean) obj);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // hk1.g
    public void W(MyImageView myImageView, int i, int i2) {
        ImMessageBean imMessageBean;
        if (this.b == null || myImageView == 0 || (imMessageBean = myImageView.getImMessageBean()) == null) {
            return;
        }
        py pyVar = new py();
        this.g = pyVar;
        pyVar.C2(this.b.e0(imMessageBean), i, i2, myImageView.getWidth(), myImageView.getHeight(), myImageView.getDrawable());
        this.g.d2(this.mContext.getSupportFragmentManager(), "ChatImageDialog2");
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return w73.E;
    }

    @Override // defpackage.b1
    public void init() {
        RecyclerView findViewById = findViewById(a73.Y);
        this.a = findViewById;
        findViewById.setHasFixedSize(true);
        this.a.setLayoutManager(new LinearLayoutManager(this.mContext, 1, false));
        this.c = (TextView) findViewById(a73.p0);
        this.i = findViewById(a73.r);
        this.n = (TextView) findViewById(a73.T);
        findViewById(a73.f).setOnClickListener(this);
        this.a.setOnTouchListener(new a());
        zu0.c().n(this);
        gp1 gp1Var = new gp1(this.mContext, (ViewGroup) findViewById(a73.P), Boolean.TRUE, Integer.valueOf(u73.T), Integer.valueOf(u73.S));
        this.k = gp1Var;
        gp1Var.addToParent();
        this.k.F0(new b());
        s0();
    }

    public void loadData() {
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
        z0();
        ck1.e().c(this.e, new d());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == a73.f) {
            p0();
            return;
        }
        if (id == y63.n) {
            return;
        }
        if (id == a73.l) {
            q0();
        } else if (id == a73.q) {
            r0();
        }
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onCoinChangeEvent(l20 l20Var) {
        throw null;
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onFollowEvent(q41 q41Var) {
        if (!q41Var.b().equals(this.e) || this.i == null) {
            return;
        }
        int a2 = q41Var.a();
        View view = this.i;
        if (a2 == 1) {
            if (view.getVisibility() == 0) {
                this.i.setVisibility(8);
            }
            t54.a(m93.u2);
        } else if (view.getVisibility() != 0) {
            this.i.setVisibility(0);
        }
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onImMessageBean(IMMessageBean iMMessageBean) {
        if (iMMessageBean.getSenderId().equals(this.e)) {
            ck1.e().l(this.e);
            ck1.e().b();
            hk1 hk1Var = this.b;
            if (hk1Var != null) {
                hk1Var.g0(iMMessageBean);
            }
            u0(iMMessageBean);
        }
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onImMessagePromptEvent(bk1 bk1Var) {
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
        G0(bk1Var.a());
    }

    @Override // defpackage.b1, defpackage.uy1
    public void onPause() {
        cm4 cm4Var = this.j;
        if (cm4Var != null) {
            cm4Var.g();
        }
    }

    @Override // defpackage.b1, defpackage.uy1
    public void onResume() {
        cm4 cm4Var = this.j;
        if (cm4Var != null) {
            cm4Var.h();
        }
    }

    public void p0() {
        ry ryVar;
        gp1 gp1Var = this.k;
        if ((gp1Var == null || !gp1Var.B0()) && (ryVar = this.f) != null) {
            ryVar.a();
        }
    }

    @Override // defpackage.b1
    public void processArguments(Object... objArr) {
        UserBean userBean = (UserBean) objArr[0];
        this.d = userBean;
        if (userBean != null) {
            this.e = userBean.getId();
        }
        this.h = ((Boolean) objArr[1]).booleanValue();
    }

    public final void q0() {
        View view = this.i;
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        this.i.setVisibility(8);
    }

    @Override // defpackage.b1
    public void release() {
        gp1 gp1Var = this.k;
        if (gp1Var != null) {
            gp1Var.A0();
        }
        cm4 cm4Var = this.j;
        if (cm4Var != null) {
            cm4Var.f();
        }
        this.j = null;
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

    public final void s0() {
        xj1.e(this.e, new c());
    }

    public final String t0(long j) {
        if (this.r == null) {
            this.r = new SimpleDateFormat("MM-dd HH:mm");
        }
        return this.r.format(new Date(j * 1000));
    }

    @Override // hk1.g
    public void u() {
        cm4 cm4Var = this.j;
        if (cm4Var != null) {
            cm4Var.k();
        }
    }

    public final void u0(IMMessageBean iMMessageBean) {
        if (this.o == null) {
            this.o = IMDbHelper.f.a(this.mContext);
        }
        this.o.j(iMMessageBean, new n81() { // from class: sy
            @Override // defpackage.n81
            public final Object invoke(Object obj) {
                return yy.g0((Boolean) obj);
            }
        });
    }

    public final void v0(List list) {
        if (this.o == null) {
            this.o = IMDbHelper.f.a(this.mContext);
        }
        this.o.k(list, new n81() { // from class: vy
            @Override // defpackage.n81
            public final Object invoke(Object obj) {
                return yy.d0(yy.this, (Boolean) obj);
            }
        });
    }

    @Override // hk1.g
    public void w(File file) {
        if (this.j == null) {
            cm4 cm4Var = new cm4(this.mContext);
            this.j = cm4Var;
            cm4Var.i(new e());
        }
        this.j.j(file.getAbsolutePath());
    }

    public final void w0(IMMessageBean iMMessageBean, int i) {
        if (this.o == null) {
            this.o = IMDbHelper.f.a(this.mContext);
        }
        this.o.j(iMMessageBean, new n81() { // from class: ty
            @Override // defpackage.n81
            public final Object invoke(Object obj) {
                return yy.a0((Boolean) obj);
            }
        });
        if (i == 1) {
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
            imConversationBean.setLastMsgTimeString(t0(iMMessageBean.getTimestamp()));
            zu0.c().j(new ij1(imConversationBean));
            lx1.c("9999", "rrrrrrrrrr");
        }
    }

    public final boolean y0() {
        return this.p == 1;
    }

    public void z0() {
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
        if (this.o == null) {
            this.o = IMDbHelper.f.a(this.mContext);
        }
        this.o.g(this.e, new n81() { // from class: uy
            @Override // defpackage.n81
            public final Object invoke(Object obj) {
                return yy.e0(yy.this, (List) obj);
            }
        });
    }
}
