package defpackage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.uc.crashsdk.export.CrashStatKey;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.activity.WebViewActivity;
import com.yunbao.common.bean.ConfigBean;
import com.yunbao.common.bean.LevelBean;
import com.yunbao.common.bean.UserBean;
import com.yunbao.common.bean.UserItemBean;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.im.activity.ChatActivity;
import com.yunbao.live.activity.LiveAnchorActivity;
import com.yunbao.live.activity.LuckPanRecordActivity;
import com.yunbao.live.activity.RoomManageActivity;
import com.yunbao.live.bean.LiveConfigBean;
import com.yunbao.main.activity.DailyTaskActivity;
import com.yunbao.main.activity.FamilyActivity;
import com.yunbao.main.activity.FansActivity;
import com.yunbao.main.activity.FollowActivity;
import com.yunbao.main.activity.LoginNewActivity;
import com.yunbao.main.activity.MainActivity;
import com.yunbao.main.activity.MyActiveActivity;
import com.yunbao.main.activity.MyBindPhoneActivity;
import com.yunbao.main.activity.MyInviteActivity;
import com.yunbao.main.activity.MyProfitActivity;
import com.yunbao.main.activity.MyVideoActivity;
import com.yunbao.main.activity.MyVipActivity;
import com.yunbao.main.activity.SettingActivity;
import com.yunbao.main.activity.TeenagerActivity;
import com.yunbao.main.activity.ThreeDistributActivity;
import com.yunbao.mall.activity.GoodsCollectActivity;
import com.yunbao.mall.activity.PayContentActivity1;
import com.yunbao.mall.activity.PayContentActivity2;
import java.util.List;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: /tmp/classes2.dex */
public class nb2 extends y0 implements et2, View.OnClickListener {
    public View A;
    public k30 B;
    public ImageView a;
    public TextView b;
    public ImageView c;
    public ImageView d;
    public ImageView e;
    public ImageView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public TextView j;
    public boolean k;
    public RecyclerView l;
    public RecyclerView m;
    public mb2 n;
    public mb2 o;
    public TextView p;
    public TextView q;
    public ImageView r;
    public TextView s;
    public TextView t;
    public View u;
    public View v;
    public View w;
    public String x;
    public String y;
    public TextView z;

    /* loaded from: /tmp/classes2.dex */
    public class a extends k30 {
        public a() {
        }

        @Override // defpackage.k30
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(UserBean userBean) {
            nb2.this.s0();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends vx2 {

        /* loaded from: /tmp/classes2.dex */
        public class a extends HttpCallback {
            public a() {
            }

            @Override // com.yunbao.common.http.HttpCallback
            public void onSuccess(int i, String str, String[] strArr) {
                if (i != 0 || strArr.length <= 0) {
                    t54.b(str);
                    return;
                }
                JSONObject parseObject = JSON.parseObject(strArr[0]);
                if (parseObject.getIntValue("live_sdk") == 6) {
                    return;
                }
                nb2.this.h0(parseObject);
            }
        }

        public b() {
        }

        @Override // defpackage.vx2
        public void a() {
            e32.T(new a());
        }
    }

    public nb2(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
        this.B = new a();
    }

    private void e0() {
        FansActivity.A1(this.mContext, j30.q().C());
    }

    private void f0() {
        FollowActivity.A1(this.mContext, j30.q().C());
    }

    private void r0() {
        ie4 ie4Var = new ie4();
        Bundle bundle = new Bundle();
        bundle.putString(IjkMediaPlayer.OnNativeInvokeListener.ARG_URL, this.x);
        ie4Var.F1(bundle);
        ie4Var.d2(((AbsActivity) this.mContext).getSupportFragmentManager(), "UserAvatarPreviewDialog");
    }

    private void u0() {
        yx2.a(this.mContext, new b(), "android.permission.CAMERA", "android.permission.RECORD_AUDIO");
    }

    public final void d0() {
        pi3.n(this.mContext);
    }

    public final void g0() {
        this.mContext.startActivity(new Intent(this.mContext, (Class<?>) MyInviteActivity.class));
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return y73.p1;
    }

    public final void h0(JSONObject jSONObject) {
        int intValue = jSONObject.getIntValue("isshop");
        String string = jSONObject.getString("liveban_title");
        int intValue2 = jSONObject.getIntValue("live_sdk");
        LiveConfigBean liveConfigBean = (LiveConfigBean) JSON.parseObject(jSONObject.getString("android_tx"), LiveConfigBean.class);
        JSONObject jSONObject2 = jSONObject.getJSONObject("promise");
        if (jSONObject2 == null) {
            LiveAnchorActivity.r3(this.mContext, intValue2, liveConfigBean, intValue, false, string, false);
            return;
        }
        LiveAnchorActivity.s3(this.mContext, intValue2, liveConfigBean, intValue, false, string, false, jSONObject2.getString("title"), jSONObject2.getString(IjkMediaPlayer.OnNativeInvokeListener.ARG_URL));
    }

    public final void i0() {
        this.mContext.startActivity(new Intent(this.mContext, (Class<?>) LoginNewActivity.class));
    }

    @Override // defpackage.b1
    public void init() {
        setStatusHeight();
        ImageView imageView = (ImageView) findViewById(c73.l);
        this.a = imageView;
        imageView.setOnClickListener(this);
        this.b = (TextView) findViewById(c73.L3);
        this.z = (TextView) findViewById(c73.S4);
        this.c = (ImageView) findViewById(c73.x4);
        this.d = (ImageView) findViewById(c73.B5);
        this.e = (ImageView) findViewById(c73.v3);
        this.f = (ImageView) findViewById(c73.u3);
        this.g = (TextView) findViewById(c73.H2);
        this.h = (TextView) findViewById(c73.l2);
        this.i = (TextView) findViewById(c73.k2);
        this.j = (TextView) findViewById(c73.F1);
        this.p = (TextView) findViewById(c73.p4);
        this.q = (TextView) findViewById(c73.C1);
        this.A = findViewById(c73.D2);
        if (!ig4.c(j30.q().h().getVersion())) {
            this.A.setVisibility(0);
        }
        ConfigBean h = j30.q().h();
        if (h != null) {
            this.y = h.getCoinName();
        }
        findViewById(c73.m0).setOnClickListener(this);
        findViewById(c73.k0).setOnClickListener(this);
        findViewById(c73.b0).setOnClickListener(this);
        findViewById(c73.h0).setOnClickListener(this);
        findViewById(c73.L0).setOnClickListener(this);
        findViewById(c73.u1).setOnClickListener(this);
        findViewById(c73.g0).setOnClickListener(this);
        findViewById(c73.d1).setOnClickListener(this);
        findViewById(c73.I).setOnClickListener(this);
        this.z.setOnClickListener(this);
        TextView textView = (TextView) findViewById(c73.r1);
        this.t = textView;
        textView.setOnClickListener(this);
        this.r = (ImageView) findViewById(c73.C5);
        this.s = (TextView) findViewById(c73.D5);
        RecyclerView findViewById = findViewById(c73.i4);
        this.l = findViewById;
        findViewById.setLayoutManager(new GridLayoutManager(this.mContext, 5, 1, false));
        RecyclerView findViewById2 = findViewById(c73.j4);
        this.m = findViewById2;
        findViewById2.setLayoutManager(new GridLayoutManager(this.mContext, 5, 1, false));
        this.u = findViewById(c73.B2);
        this.v = findViewById(c73.u2);
        this.w = findViewById(c73.x2);
        ik1 h2 = ck1.e().h();
        q0(h2 != null ? h2.h() : "0");
    }

    public final void j0() {
        this.mContext.startActivity(new Intent(this.mContext, (Class<?>) MyVideoActivity.class));
    }

    public final void k0() {
        UserBean D = j30.q().D();
        if (D != null) {
            int isOpenPayContent = D.getIsOpenPayContent();
            Context context = this.mContext;
            if (isOpenPayContent == 0) {
                PayContentActivity1.z1(context);
            } else {
                PayContentActivity2.A1(context);
            }
        }
    }

    public final void l0() {
        this.mContext.startActivity(new Intent(this.mContext, (Class<?>) MyProfitActivity.class));
    }

    @Override // defpackage.y0
    public void loadData() {
        if (j30.q().N()) {
            if (isFirstLoadData()) {
                t0();
            }
            db2.E(this.B);
        } else {
            Object obj = this.mContext;
            if (obj != null) {
                ((MainActivity) obj).V2(0);
            }
        }
    }

    public final void m0() {
        this.mContext.startActivity(new Intent(this.mContext, (Class<?>) RoomManageActivity.class));
    }

    public final void n0() {
        this.mContext.startActivity(new Intent(this.mContext, (Class<?>) SettingActivity.class));
    }

    public final void o0() {
        this.mContext.startActivity(new Intent(this.mContext, (Class<?>) LuckPanRecordActivity.class));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == c73.h0) {
            pi3.q(this.mContext, j30.q().C());
            return;
        }
        if (id == c73.m0) {
            f0();
            return;
        }
        if (id == c73.k0) {
            e0();
            return;
        }
        if (id == c73.b0) {
            if (j30.q().Q()) {
                t54.a(m93.t0);
                return;
            } else {
                this.mContext.startActivity(new Intent(this.mContext, (Class<?>) GoodsCollectActivity.class));
                return;
            }
        }
        if (id == c73.L0) {
            ChatActivity.y1(this.mContext);
            return;
        }
        if (id == c73.u1) {
            pi3.n(this.mContext);
            return;
        }
        if (id == c73.g0) {
            WebViewActivity.E1(this.mContext, wg1.m);
            return;
        }
        if (id == c73.r1) {
            this.mContext.startActivity(new Intent(this.mContext, (Class<?>) MyVipActivity.class));
            return;
        }
        if (id == c73.d1) {
            n0();
            return;
        }
        if (id == c73.I) {
            WebViewActivity.E1(this.mContext, wg1.l);
        } else if (id == c73.l) {
            r0();
        } else if (id == c73.S4) {
            i0();
        }
    }

    @Override // defpackage.b1, defpackage.uy1
    public void onDestroy() {
        super.onDestroy();
        db2.i("getBaseInfo");
    }

    @Override // defpackage.b1, defpackage.uy1
    public void onPause() {
        super.onPause();
        this.k = true;
    }

    @Override // defpackage.b1, defpackage.uy1
    public void onResume() {
        super.onResume();
        if (isShowed() && this.k) {
            loadData();
        }
        this.k = false;
    }

    @Override // defpackage.et2
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public void onItemClick(UserItemBean userItemBean, int i) {
        String str;
        if (userItemBean.getId() == 22) {
            this.mContext.startActivity(new Intent(this.mContext, (Class<?>) MyBindPhoneActivity.class));
            return;
        }
        if (userItemBean.getId() == 24) {
            k0();
            return;
        }
        if (userItemBean.getId() == 8) {
            g0();
            return;
        }
        String href = userItemBean.getHref();
        if (!TextUtils.isEmpty(href)) {
            System.out.println("----urlurlurl----" + href);
            if (href.contains("?")) {
                str = href + "&uid=" + j30.q().C() + "&token=" + j30.q().B();
            } else {
                str = href + "?uid=" + j30.q().C() + "&token=" + j30.q().B();
            }
            if (userItemBean.getId() == 8) {
                System.out.println("----urlurlurl---333-".concat(str));
                ThreeDistributActivity.H1(this.mContext, userItemBean.getName(), str);
                return;
            } else if (userItemBean.getId() == 6) {
                System.out.println("----urlurlurl---222-".concat(str));
                FamilyActivity.C1(this.mContext, str);
                return;
            } else {
                System.out.println("----urlurlurl---111-".concat(str));
                WebViewActivity.F1(this.mContext, str, userItemBean.getName());
                return;
            }
        }
        int id = userItemBean.getId();
        if (id == 1) {
            l0();
            return;
        }
        if (id == 2) {
            d0();
            return;
        }
        if (id == 8) {
            g0();
            return;
        }
        if (id == 23) {
            this.mContext.startActivity(new Intent(this.mContext, (Class<?>) MyActiveActivity.class));
            return;
        }
        if (id == 12) {
            u0();
            return;
        }
        if (id == 13) {
            n0();
            return;
        }
        if (id == 19) {
            j0();
            return;
        }
        if (id == 20) {
            m0();
            return;
        }
        switch (id) {
            case CrashStatKey.LOG_RENAMED_COUNT /* 25 */:
                this.mContext.startActivity(new Intent(this.mContext, (Class<?>) DailyTaskActivity.class));
                return;
            case CrashStatKey.LOG_SAFE_SKIP_COUNT /* 26 */:
                o0();
                return;
            case CrashStatKey.NATIVE_ANR_FG_TIMES /* 27 */:
                TeenagerActivity.D1(this.mContext);
                return;
            default:
                return;
        }
    }

    public void q0(String str) {
    }

    public final void s0() {
        String g = bs3.d().g("userInfo");
        if (TextUtils.isEmpty(g)) {
            return;
        }
        JSONObject parseObject = JSON.parseObject(g);
        UserBean userBean = (UserBean) JSON.toJavaObject(parseObject, UserBean.class);
        if (userBean.getUserLogin() == null || userBean.getUserLogin().isEmpty()) {
            this.z.setVisibility(0);
        } else {
            this.z.setVisibility(8);
        }
        String avatar = userBean.getAvatar();
        this.x = avatar;
        kn1.g(this.mContext, avatar, this.a);
        this.b.setText(userBean.getUserNiceName());
        this.c.setImageResource(l30.b(userBean.getSex()));
        j30 q = j30.q();
        LevelBean c = q.c(userBean.getLevelAnchor());
        if (c != null) {
            kn1.f(this.mContext, c.getThumb(), this.e);
        }
        LevelBean s = q.s(userBean.getLevel());
        if (s != null) {
            kn1.f(this.mContext, s.getThumb(), this.f);
        }
        this.g.setText(userBean.getLiangNameTip());
        this.h.setText(rv3.i(userBean.getFollows()));
        this.i.setText(rv3.i(userBean.getFans()));
        this.j.setText(rv3.i(parseObject.getIntValue("goods_collect_nums")));
        JSONArray jSONArray = parseObject.getJSONArray("list");
        boolean Q = j30.q().Q();
        View view = this.u;
        if (Q) {
            if (view.getVisibility() != 8) {
                this.u.setVisibility(8);
            }
            if (this.v.getVisibility() != 8) {
                this.v.setVisibility(8);
            }
            if (this.w.getVisibility() != 8) {
                this.w.setVisibility(8);
            }
            List parseArray = JSON.parseArray(jSONArray.getJSONObject(0).getString("list"), UserItemBean.class);
            mb2 mb2Var = this.o;
            if (mb2Var != null) {
                mb2Var.Q(parseArray);
                return;
            }
            mb2 mb2Var2 = new mb2(this.mContext, parseArray);
            this.o = mb2Var2;
            mb2Var2.R(this);
            this.m.setAdapter(this.o);
            return;
        }
        if (view.getVisibility() != 0) {
            this.u.setVisibility(0);
        }
        if (this.v.getVisibility() != 0) {
            this.v.setVisibility(0);
        }
        if (this.w.getVisibility() != 0) {
            this.w.setVisibility(0);
        }
        String coin = userBean.getCoin();
        SpannableString spannableString = new SpannableString(coin + this.y);
        spannableString.setSpan(new StyleSpan(1), 0, coin.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(-28160), 0, coin.length(), 33);
        this.q.setText(spannableString);
        JSONObject jSONObject = parseObject.getJSONObject("vip");
        int intValue = jSONObject.getIntValue("type");
        ImageView imageView = this.d;
        if (intValue != 0) {
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            TextView textView = this.t;
            if (textView != null) {
                textView.setText(m93.g0);
            }
            TextView textView2 = this.s;
            if (textView2 != null) {
                textView2.setText(aq4.b(m93.h0, jSONObject.getString("endtime")));
            }
            ImageView imageView2 = this.r;
            if (imageView2 != null) {
                imageView2.setImageResource(u83.t);
            }
        } else {
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            TextView textView3 = this.t;
            if (textView3 != null) {
                textView3.setText(m93.a2);
            }
            TextView textView4 = this.s;
            if (textView4 != null) {
                textView4.setText(m93.i0);
            }
            ImageView imageView3 = this.r;
            if (imageView3 != null) {
                imageView3.setImageResource(u83.F);
            }
        }
        List parseArray2 = JSON.parseArray(jSONArray.getJSONObject(0).getString("list"), UserItemBean.class);
        mb2 mb2Var3 = this.n;
        if (mb2Var3 == null) {
            mb2 mb2Var4 = new mb2(this.mContext, parseArray2);
            this.n = mb2Var4;
            mb2Var4.R(this);
            this.l.setAdapter(this.n);
        } else {
            mb2Var3.Q(parseArray2);
        }
        if (jSONArray.size() > 1) {
            List parseArray3 = JSON.parseArray(jSONArray.getJSONObject(1).getString("list"), UserItemBean.class);
            mb2 mb2Var5 = this.o;
            if (mb2Var5 != null) {
                mb2Var5.Q(parseArray3);
                return;
            }
            mb2 mb2Var6 = new mb2(this.mContext, parseArray3);
            this.o = mb2Var6;
            mb2Var6.R(this);
            this.m.setAdapter(this.o);
        }
    }

    public final void t0() {
        String g = bs3.d().g("userInfo");
        if (TextUtils.isEmpty(g)) {
            return;
        }
        UserBean userBean = (UserBean) JSON.toJavaObject(JSON.parseObject(g), UserBean.class);
        this.x = userBean.getAvatar();
        System.out.println("mAvatarUrl--------" + this.x);
        kn1.g(this.mContext, this.x, this.a);
        this.b.setText(userBean.getUserNiceName());
        this.c.setImageResource(l30.b(userBean.getSex()));
        j30 q = j30.q();
        LevelBean c = q.c(userBean.getLevelAnchor());
        if (c != null) {
            kn1.f(this.mContext, c.getThumb(), this.e);
        }
        LevelBean s = q.s(userBean.getLevel());
        if (s != null) {
            kn1.f(this.mContext, s.getThumb(), this.f);
        }
        this.g.setText(userBean.getLiangNameTip());
        this.h.setText(rv3.i(userBean.getFollows()));
        this.i.setText(rv3.i(userBean.getFans()));
        this.j.setText(rv3.i(r0.getIntValue("goods_collect_nums")));
    }
}
