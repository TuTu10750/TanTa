package defpackage;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.umeng.analytics.pro.cl;
import com.yunbao.common.activity.WebViewActivity;
import com.yunbao.common.http.CommonHttpUtil;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.live.bean.InviteBean;
import com.yunbao.main.activity.PromotionActivity;
import defpackage.lq1;

/* loaded from: /tmp/classes2.dex */
public class hb2 extends v0 {
    public ImageView a;
    public TextView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public RecyclerView h;
    public lq1 i;

    /* loaded from: /tmp/classes2.dex */
    public class a extends GridLayoutManager {
        public a(Context context, int i, int i2, boolean z) {
            super(context, i, i2, z);
        }

        public boolean A() {
            return false;
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
            if (i != 0 || strArr.length <= 0) {
                return;
            }
            JSONObject parseObject = JSON.parseObject(strArr[0]);
            kn1.f(hb2.this.mContext, parseObject.getString("bg"), hb2.this.a);
            JSONObject jSONObject = parseObject.getJSONObject(cl.b);
            hb2.this.b.setText(jSONObject.getString("commission"));
            hb2.this.c.setText(jSONObject.getString("total_num"));
            hb2.this.d.setText(jSONObject.getString("recharge_money"));
            hb2.this.e.setText(jSONObject.getString("today_num"));
            hb2.this.f.setText(jSONObject.getString("sevenDays_num"));
            hb2.this.g.setText(jSONObject.getString("thirtyDays_num"));
            hb2.this.i.T(JSON.parseArray(parseObject.getString("btn"), InviteBean.class));
        }
    }

    public hb2(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    public static /* synthetic */ void a0(hb2 hb2Var, View view) {
        hb2Var.getClass();
        String kefu = j30.q().h().getKefu();
        if (kefu.isEmpty()) {
            return;
        }
        WebViewActivity.F1(hb2Var.mContext, kefu, "在线客服");
    }

    public static /* synthetic */ void b0(hb2 hb2Var, InviteBean inviteBean, int i) {
        String str;
        if (i == 0) {
            hb2Var.mContext.startActivity(new Intent(hb2Var.mContext, (Class<?>) PromotionActivity.class));
            return;
        }
        hb2Var.getClass();
        if (inviteBean.getHref().isEmpty()) {
            return;
        }
        String href = inviteBean.getHref();
        if (href.contains("?")) {
            str = href + "&uid=" + j30.q().C() + "&token=" + j30.q().B();
        } else {
            str = href + "?uid=" + j30.q().C() + "&token=" + j30.q().B();
        }
        WebViewActivity.E1(hb2Var.mContext, str);
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return y73.m1;
    }

    @Override // defpackage.b1
    public void init() {
        this.a = (ImageView) findViewById(c73.q3);
        this.b = (TextView) findViewById(c73.V4);
        this.c = (TextView) findViewById(c73.l5);
        this.d = (TextView) findViewById(c73.X4);
        this.e = (TextView) findViewById(c73.k5);
        this.f = (TextView) findViewById(c73.j5);
        this.g = (TextView) findViewById(c73.i5);
        RecyclerView findViewById = findViewById(c73.o4);
        this.h = findViewById;
        findViewById.setLayoutManager(new a(this.mContext, 3, 1, false));
        this.h.k(new ud1(3, zn0.a(10), false));
        lq1 lq1Var = new lq1(this.mContext);
        this.i = lq1Var;
        lq1Var.S(new lq1.b() { // from class: fb2
            @Override // lq1.b
            public final void a(InviteBean inviteBean, int i) {
                hb2.b0(hb2.this, inviteBean, i);
            }
        });
        this.h.setAdapter(this.i);
        findViewById(c73.F3).setOnClickListener(new View.OnClickListener() { // from class: gb2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                hb2.a0(hb2.this, view);
            }
        });
        ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
        int c = gk3.a().c() - zn0.a(32);
        layoutParams.width = c;
        layoutParams.height = (c * 486) / 864;
        this.a.setLayoutParams(layoutParams);
        loadData();
    }

    @Override // defpackage.y0
    public void loadData() {
        CommonHttpUtil.getUserInvite(new b());
    }

    @Override // defpackage.b1, defpackage.uy1
    public void onResume() {
        super.onResume();
    }
}
