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
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.im.activity.ImMsgAtActivity;
import com.yunbao.im.activity.ImMsgCommentActivity;
import com.yunbao.im.activity.ImMsgConcatActivity;
import com.yunbao.im.activity.ImMsgLikeActivity;
import com.yunbao.im.activity.SystemMessageActivity;
import com.yunbao.im.bean.ImConUserBean;
import com.yunbao.im.bean.SystemMessageBean;
import com.yunbao.im.dao.IMDbHelper;
import com.yunbao.im.dao.IMUserBean;
import defpackage.ak1;
import defpackage.uj1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: /tmp/classes2.dex */
public class uj1 extends b1 implements View.OnClickListener, ak1.f {
    public int a;
    public View b;
    public RecyclerView c;
    public ak1 d;
    public g e;
    public View f;
    public TextView g;
    public TextView h;
    public HttpCallback i;
    public View j;
    public String k;
    public TextView l;
    public TextView m;
    public TextView n;
    public TextView o;
    public IMDbHelper p;
    public SmartRefreshLayout q;
    public tj0 r;

    /* loaded from: /tmp/classes2.dex */
    public class a implements ot2 {
        public a() {
        }

        public void onRefresh(ke3 ke3Var) {
            uj1.this.loadData();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends HttpCallback {
        public b() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length <= 0) {
                return;
            }
            SystemMessageBean systemMessageBean = (SystemMessageBean) JSON.parseObject(strArr[0], SystemMessageBean.class);
            if (uj1.this.g != null) {
                uj1.this.g.setText(systemMessageBean.getContent());
            }
            if (uj1.this.h != null) {
                uj1.this.h.setText(systemMessageBean.getAddtime());
            }
            int e = bs3.d().e("systemMsgCount", 0);
            uj1 uj1Var = uj1.this;
            if (e > 0) {
                if (uj1Var.f == null || uj1.this.f.getVisibility() == 0) {
                    return;
                }
                uj1.this.f.setVisibility(0);
                return;
            }
            if (uj1Var.f == null || uj1.this.f.getVisibility() == 4) {
                return;
            }
            uj1.this.f.setVisibility(4);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c implements n81 {
        public c() {
        }

        @Override // defpackage.n81
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public qc4 invoke(Boolean bool) {
            return null;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d extends k30 {

        /* loaded from: /tmp/classes2.dex */
        public class a extends HttpCallback {
            public final /* synthetic */ boolean a;
            public final /* synthetic */ List b;

            /* renamed from: uj1$d$a$a, reason: collision with other inner class name */
            /* loaded from: /tmp/classes2.dex */
            public class C0159a implements Comparator {
                public C0159a() {
                }

                @Override // java.util.Comparator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public int compare(ImConUserBean imConUserBean, ImConUserBean imConUserBean2) {
                    if (imConUserBean.isAnchorItem()) {
                        return -1;
                    }
                    if (imConUserBean2.isAnchorItem()) {
                        return 1;
                    }
                    if ("goodsorder_admin".equals(imConUserBean.getConUserId())) {
                        return -1;
                    }
                    if ("goodsorder_admin".equals(imConUserBean2.getConUserId())) {
                        return 1;
                    }
                    return Long.compare(imConUserBean2.getMsgTime(), imConUserBean.getMsgTime());
                }
            }

            public a(boolean z, List list) {
                this.a = z;
                this.b = list;
            }

            @Override // com.yunbao.common.http.HttpCallback
            public void onSuccess(int i, String str, String[] strArr) {
                uj1.this.q.u();
                ArrayList arrayList = new ArrayList();
                if (i == 0) {
                    List<ImConUserBean> parseArray = JSON.parseArray(Arrays.toString(strArr), ImConUserBean.class);
                    for (ImConUserBean imConUserBean : parseArray) {
                        if (imConUserBean.getUserStatus() == 0) {
                            arrayList.add(imConUserBean.getId());
                            ck1.e().m(imConUserBean.getId());
                        }
                        lx1.c("9527", "user_status:" + imConUserBean.getUserStatus());
                        if (this.a && imConUserBean.getId().equals(uj1.this.k)) {
                            imConUserBean.setAnchorItem(true);
                            imConUserBean.setTips(aq4.a(m93.v2));
                        }
                        Iterator it = this.b.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                IMUserBean iMUserBean = (IMUserBean) it.next();
                                if (iMUserBean.getUserID().equals(imConUserBean.getId())) {
                                    iMUserBean.setAttent(imConUserBean.getAttent());
                                    iMUserBean.setOtherAttent(imConUserBean.getOtherAttent());
                                    iMUserBean.setAnchorItem(imConUserBean.isAnchorItem());
                                    iMUserBean.setTips(imConUserBean.getLastMsgString());
                                    iMUserBean.setId(imConUserBean.getId());
                                    iMUserBean.setUserNiceName(imConUserBean.getUserNiceName());
                                    iMUserBean.setAvatar(imConUserBean.getAvatar());
                                    iMUserBean.setSex(imConUserBean.getSex());
                                    iMUserBean.setLevel(imConUserBean.getLevel());
                                    break;
                                }
                            }
                        }
                    }
                    Collections.sort(parseArray, new C0159a());
                    List list = this.b;
                    if (list != null && list.size() > 0) {
                        uj1.this.y0(this.b);
                    }
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        uj1.this.s0((String) it2.next());
                    }
                }
            }
        }

        public d() {
        }

        @Override // defpackage.k30
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(List list) {
            boolean z = true;
            boolean z2 = (uj1.this.a != 1 || TextUtils.isEmpty(uj1.this.k) || uj1.this.k.equals(j30.q().C())) ? false : true;
            if (z2) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    if (((IMUserBean) it.next()).getUserID().equals(uj1.this.k)) {
                        break;
                    }
                }
            }
            z = false;
            StringBuilder sb = new StringBuilder();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                sb.append(((IMUserBean) list.get(i)).getUserID());
                if (i < size - 1) {
                    sb.append(",");
                }
            }
            if (z2 && !z) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(uj1.this.k);
            }
            String sb2 = sb.toString();
            if (TextUtils.isEmpty(sb2)) {
                uj1.this.q.u();
            } else {
                xj1.g(sb2, new a(z2, list));
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e extends k30 {
        public final /* synthetic */ IMUserBean a;

        public e(IMUserBean iMUserBean) {
            this.a = iMUserBean;
        }

        public static /* synthetic */ qc4 b(Boolean bool) {
            if (bool.booleanValue()) {
                lx1.c("9999", "删除成功");
                return null;
            }
            lx1.c("9999", "删除失败");
            return null;
        }

        @Override // defpackage.k30
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(Integer num) {
            uj1.this.d.b0(this.a.getUserID());
            ck1.e().m(this.a.getUserID());
            if (uj1.this.p == null) {
                uj1 uj1Var = uj1.this;
                uj1Var.p = IMDbHelper.f.a(uj1Var.mContext);
            }
            uj1.this.p.e(this.a.getUserID(), new n81() { // from class: vj1
                @Override // defpackage.n81
                public final Object invoke(Object obj) {
                    return uj1.e.b((Boolean) obj);
                }
            });
            if (this.a.getUnReadCount() > 0) {
                zu0.c().j(new jk1(0 - this.a.getUnReadCount()));
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class f extends HttpCallback {
        public final /* synthetic */ ij1 a;

        public f(ij1 ij1Var) {
            this.a = ij1Var;
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length <= 0) {
                return;
            }
            ImConUserBean imConUserBean = (ImConUserBean) JSON.parseObject(strArr[0], ImConUserBean.class);
            IMUserBean a = IMUserBean.INSTANCE.a();
            a.setImConUserBean(imConUserBean);
            a.setConBean(this.a.a());
            uj1.this.d.Y(a);
            uj1.this.w0(a);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface g {
        void a();

        void b(IMUserBean iMUserBean);
    }

    public uj1(Context context, ViewGroup viewGroup, int i) {
        super(context, viewGroup, Integer.valueOf(i));
    }

    public static /* synthetic */ qc4 a0(uj1 uj1Var, Boolean bool) {
        uj1Var.getClass();
        if (!bool.booleanValue()) {
            lx1.c("9999", "user删除失败");
            return null;
        }
        lx1.c("9999", "user删除成功");
        uj1Var.z0();
        return null;
    }

    public static /* synthetic */ qc4 b0(Boolean bool) {
        if (bool.booleanValue()) {
            lx1.c("9999", "22user单个插入成功");
            return null;
        }
        lx1.c("9999", "22user单个插入失败");
        return null;
    }

    public static /* synthetic */ qc4 d0(uj1 uj1Var, Boolean bool) {
        uj1Var.getClass();
        if (!bool.booleanValue()) {
            lx1.c("9999", "user插入失败");
            return null;
        }
        lx1.c("9999", "user插入成功");
        uj1Var.z0();
        return null;
    }

    public static /* synthetic */ qc4 e0(uj1 uj1Var, List list) {
        ak1 ak1Var;
        uj1Var.getClass();
        if (list == null || list.size() <= 0) {
            lx1.c("9999", "user没有获取到");
            return null;
        }
        lx1.c("9999", "user获取成功size:" + list.size());
        if (uj1Var.c == null || (ak1Var = uj1Var.d) == null) {
            return null;
        }
        ak1Var.f0(list);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0(List list) {
        if (this.p == null) {
            this.p = IMDbHelper.f.a(this.mContext);
        }
        this.p.n(list, new n81() { // from class: rj1
            @Override // defpackage.n81
            public final Object invoke(Object obj) {
                return uj1.d0(uj1.this, (Boolean) obj);
            }
        });
    }

    private void z0() {
        if (this.p == null) {
            this.p = IMDbHelper.f.a(this.mContext);
        }
        this.p.i(new n81() { // from class: qj1
            @Override // defpackage.n81
            public final Object invoke(Object obj) {
                return uj1.e0(uj1.this, (List) obj);
            }
        });
    }

    public void A0(g gVar) {
        this.e = gVar;
    }

    public final void B0(TextView textView, String str) {
        if (textView != null) {
            if ("0".equals(str)) {
                if (textView.getVisibility() == 0) {
                    textView.setVisibility(4);
                }
            } else {
                if (textView.getVisibility() != 0) {
                    textView.setVisibility(0);
                }
                textView.setText(str);
            }
        }
    }

    @Override // ak1.f
    public void H(IMUserBean iMUserBean) {
        if (this.r == null) {
            this.r = new tj0();
        }
        this.r.u2("确认删除和" + iMUserBean.getUserNiceName() + "的聊天吗？");
        this.r.t2(new e(iMUserBean));
        this.r.d2(this.mContext.getSupportFragmentManager(), "mDeleteIMUserDialog");
    }

    @Override // ak1.f
    public void b(IMUserBean iMUserBean) {
        if (iMUserBean != null) {
            ck1.e().l(iMUserBean.getUserID());
            g gVar = this.e;
            if (gVar != null) {
                gVar.b(iMUserBean);
            }
        }
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return w73.G;
    }

    @Override // defpackage.b1
    public void init() {
        SmartRefreshLayout findViewById = findViewById(y63.a0);
        this.q = findViewById;
        findViewById.J(true);
        this.q.I(false);
        this.q.M(new a());
        RecyclerView findViewById2 = findViewById(a73.Y);
        this.c = findViewById2;
        findViewById2.setHasFixedSize(true);
        this.c.setLayoutManager(new LinearLayoutManager(this.mContext, 1, false));
        ak1 ak1Var = new ak1(this.mContext);
        this.d = ak1Var;
        ak1Var.d0(this);
        this.c.setAdapter(this.d);
        View findViewById3 = findViewById(a73.f);
        this.j = findViewById3;
        if (this.a == 0) {
            findViewById3.setOnClickListener(this);
        } else {
            findViewById3.setVisibility(4);
            findViewById(a73.q0).setBackgroundColor(-394501);
        }
        findViewById(a73.s).setOnClickListener(this);
        View U = this.d.U();
        View findViewById4 = U.findViewById(a73.L);
        if (this.a == 1) {
            findViewById4.setVisibility(8);
        } else {
            this.l = (TextView) U.findViewById(a73.c0);
            this.m = (TextView) U.findViewById(a73.d0);
            this.n = (TextView) U.findViewById(a73.a0);
            this.o = (TextView) U.findViewById(a73.b0);
            U.findViewById(a73.n).setOnClickListener(this);
            U.findViewById(a73.C).setOnClickListener(this);
            U.findViewById(a73.e).setOnClickListener(this);
            U.findViewById(a73.m).setOnClickListener(this);
            ik1 h = ck1.e().h();
            B0(this.l, h.d());
            B0(this.m, h.f());
            B0(this.n, h.b());
            B0(this.o, h.c());
        }
        View findViewById5 = U.findViewById(a73.z);
        this.b = findViewById5;
        findViewById5.setOnClickListener(this);
        this.f = U.findViewById(a73.Z);
        this.g = (TextView) U.findViewById(a73.U);
        this.h = (TextView) U.findViewById(a73.m0);
        this.i = new b();
        ((ImageView) U.findViewById(a73.c)).setImageResource(s83.a);
        zu0.c().n(this);
    }

    @Override // ak1.f
    public void j(IMUserBean iMUserBean, int i) {
        ck1.e().m(iMUserBean.getUserID());
    }

    public void loadData() {
        u0();
        if (j30.q().O()) {
            z0();
            ck1.e().f(new d());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == a73.f) {
            g gVar = this.e;
            if (gVar != null) {
                gVar.a();
                return;
            }
            return;
        }
        if (id == a73.s) {
            v0();
            return;
        }
        if (id == a73.z) {
            t0();
            return;
        }
        if (id == a73.n) {
            ck1.e().l("dsp_fans");
            ImMsgConcatActivity.z1(this.mContext);
            return;
        }
        if (id == a73.C) {
            ck1.e().l("dsp_like");
            ImMsgLikeActivity.z1(this.mContext);
        } else if (id == a73.e) {
            ck1.e().l("dsp_at");
            ImMsgAtActivity.z1(this.mContext);
        } else if (id == a73.m) {
            ck1.e().l("dsp_comment");
            ImMsgCommentActivity.z1(this.mContext);
        }
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onFollowEvent(q41 q41Var) {
        ak1 ak1Var;
        if (q41Var == null || (ak1Var = this.d) == null) {
            return;
        }
        ak1Var.e0(q41Var.b(), q41Var.a());
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onIMReadMsgEvent(sh1 sh1Var) {
        u0();
        this.d.h0(sh1Var.a());
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onImMessageRevokeEvent(bk1 bk1Var) {
        ak1 ak1Var = this.d;
        if (ak1Var != null) {
            ak1Var.Z(bk1Var.a(), bk1Var.b(), bk1Var.c());
        }
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onImUnReadCountEvent(kk1 kk1Var) {
        ik1 h = ck1.e().h();
        if (h != null) {
            B0(this.l, h.d());
            B0(this.m, h.f());
            B0(this.n, h.b());
            B0(this.o, h.c());
        }
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onImUserMsgEvent(ij1 ij1Var) {
        ak1 ak1Var;
        String b2 = ij1Var.b();
        if (("goodsorder_admin".equals(b2) && j30.q().Q()) || "dsp_fans".equals(b2) || "dsp_like".equals(b2) || "dsp_at".equals(b2) || "dsp_comment".equals(b2) || !j30.q().O() || this.c == null || (ak1Var = this.d) == null) {
            return;
        }
        int V = ak1Var.V(b2);
        if (V >= 0) {
            this.d.g0(ij1Var.a(), V);
            return;
        }
        String str = "getImUserInfo_" + b2;
        xj1.a(str);
        xj1.h(b2, str, new f(ij1Var));
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onSystemMsgEvent(l14 l14Var) {
        u0();
    }

    @Override // defpackage.b1
    public void processArguments(Object... objArr) {
        this.a = ((Integer) objArr[0]).intValue();
    }

    @Override // defpackage.b1
    public void release() {
        zu0.c().p(this);
        this.e = null;
        xj1.a("getSystemMessageList");
        xj1.a("getImUserInfo");
    }

    public final void s0(String str) {
        if (this.p == null) {
            this.p = IMDbHelper.f.a(this.mContext);
        }
        this.p.e(str, new n81() { // from class: tj1
            @Override // defpackage.n81
            public final Object invoke(Object obj) {
                return uj1.a0(uj1.this, (Boolean) obj);
            }
        });
        this.p.f(str, new c());
    }

    public final void t0() {
        bs3.d().n("systemMsgCount", 0);
        View view = this.f;
        if (view != null && view.getVisibility() == 0) {
            this.f.setVisibility(4);
        }
        if (this.a == 0) {
            SystemMessageActivity.w1(this.mContext);
        } else {
            new j14().d2(((AbsActivity) this.mContext).getSupportFragmentManager(), "SystemMessageDialogFragment");
        }
    }

    public final void u0() {
        xj1.i(1, this.i);
    }

    public final void v0() {
        ik1 h = ck1.e().h();
        String i = h != null ? h.i(false) : "0";
        boolean z = bs3.d().e("systemMsgCount", 0) > 0;
        if ("0".equals(i) && !z) {
            com.yunbao.common.utils.a.p(this.mContext, aq4.a(m93.z2), true);
            return;
        }
        bs3.d().n("systemMsgCount", 0);
        View view = this.f;
        if (view != null && view.getVisibility() == 0) {
            this.f.setVisibility(4);
        }
        ck1.e().k();
        ak1 ak1Var = this.d;
        if (ak1Var != null) {
            ak1Var.c0();
        }
        if ("0".equals(i)) {
            zu0.c().j(new kk1());
        }
        t54.a(m93.y2);
    }

    public final void w0(IMUserBean iMUserBean) {
        if (this.p == null) {
            this.p = IMDbHelper.f.a(this.mContext);
        }
        this.p.l(iMUserBean, new n81() { // from class: sj1
            @Override // defpackage.n81
            public final Object invoke(Object obj) {
                return uj1.b0((Boolean) obj);
            }
        });
    }
}
