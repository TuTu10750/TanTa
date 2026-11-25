package com.yunbao.mall.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.custom.StarCountView;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.mall.bean.PayContentVideoPlayBean;
import defpackage.aq4;
import defpackage.ax2;
import defpackage.d73;
import defpackage.ec2;
import defpackage.et2;
import defpackage.fx2;
import defpackage.jx2;
import defpackage.kn1;
import defpackage.m93;
import defpackage.pi3;
import defpackage.z73;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class PayContentDetailActivity extends AbsActivity implements et2, fx2.c {
    public String e;
    public String f;
    public ImageView g;
    public TextView h;
    public TextView i;
    public TextView j;
    public TextView k;
    public StarCountView l;
    public TextView m;
    public View n;
    public View o;
    public ImageView p;
    public TextView q;
    public TextView r;
    public ViewGroup s;
    public RecyclerView t;
    public jx2 u;
    public Double v;
    public String w;
    public List x;

    /* loaded from: /tmp/classes2.dex */
    public class a extends HttpCallback {
        public a() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length <= 0) {
                return;
            }
            JSONObject parseObject = JSON.parseObject(strArr[0]);
            PayContentDetailActivity.this.f = parseObject.getString("uid");
            PayContentDetailActivity.this.v = Double.valueOf(parseObject.getDoubleValue("money"));
            if (PayContentDetailActivity.this.g != null) {
                kn1.f(PayContentDetailActivity.this.b, parseObject.getString("thumb"), PayContentDetailActivity.this.g);
            }
            PayContentDetailActivity.this.w = parseObject.getString("title");
            if (PayContentDetailActivity.this.h != null) {
                PayContentDetailActivity.this.h.setText(PayContentDetailActivity.this.w);
            }
            if (PayContentDetailActivity.this.j != null) {
                PayContentDetailActivity.this.j.setText(aq4.b(m93.N7, parseObject.getString("sale_nums")));
            }
            if (PayContentDetailActivity.this.k != null) {
                PayContentDetailActivity.this.k.setText(parseObject.getString("content"));
            }
            if (PayContentDetailActivity.this.o != null) {
                int intValue = parseObject.getIntValue("can_comment");
                PayContentDetailActivity payContentDetailActivity = PayContentDetailActivity.this;
                if (intValue == 1) {
                    if (payContentDetailActivity.o.getVisibility() != 0) {
                        PayContentDetailActivity.this.o.setVisibility(0);
                    }
                } else if (payContentDetailActivity.o.getVisibility() != 8) {
                    PayContentDetailActivity.this.o.setVisibility(8);
                }
            }
            if (PayContentDetailActivity.this.r != null) {
                PayContentDetailActivity.this.r.setText(parseObject.getString("personal_desc"));
            }
            JSONObject jSONObject = parseObject.getJSONObject("userinfo");
            if (jSONObject != null) {
                if (PayContentDetailActivity.this.p != null) {
                    kn1.g(PayContentDetailActivity.this.b, jSONObject.getString("avatar"), PayContentDetailActivity.this.p);
                }
                if (PayContentDetailActivity.this.q != null) {
                    PayContentDetailActivity.this.q.setText(jSONObject.getString("user_nickname"));
                }
            }
            if (PayContentDetailActivity.this.l != null) {
                PayContentDetailActivity.this.l.setFillCount(parseObject.getIntValue("evaluate_point"));
            }
            if (PayContentDetailActivity.this.m != null) {
                PayContentDetailActivity.this.m.setText(aq4.b(m93.S7, parseObject.getString("evaluate_nums")));
            }
            boolean z = parseObject.getIntValue("is_buy") == 1;
            List parseArray = JSON.parseArray(parseObject.getString("videos"), PayContentVideoPlayBean.class);
            PayContentDetailActivity.this.x = parseArray;
            if (parseArray == null || parseArray.size() <= 0) {
                return;
            }
            int size = parseArray.size();
            PayContentDetailActivity payContentDetailActivity2 = PayContentDetailActivity.this;
            if (size <= 1) {
                if (payContentDetailActivity2.i != null) {
                    PayContentDetailActivity.this.i.setText(aq4.b(m93.Q7, ((PayContentVideoPlayBean) parseArray.get(0)).getDurationString()));
                }
                if (PayContentDetailActivity.this.n != null && PayContentDetailActivity.this.n.getVisibility() != 8) {
                    PayContentDetailActivity.this.n.setVisibility(8);
                }
                if (PayContentDetailActivity.this.s != null) {
                    if (PayContentDetailActivity.this.s.getChildCount() > 0) {
                        PayContentDetailActivity.this.s.removeAllViews();
                    }
                    PayContentDetailActivity payContentDetailActivity3 = PayContentDetailActivity.this;
                    if (z) {
                        LayoutInflater.from(payContentDetailActivity3.b).inflate(z73.G1, PayContentDetailActivity.this.s, true);
                        return;
                    }
                    View inflate = LayoutInflater.from(payContentDetailActivity3.b).inflate(z73.F1, PayContentDetailActivity.this.s, false);
                    ((TextView) inflate.findViewById(d73.k3)).setText(String.valueOf(PayContentDetailActivity.this.v));
                    PayContentDetailActivity.this.s.addView(inflate);
                    return;
                }
                return;
            }
            if (payContentDetailActivity2.i != null) {
                PayContentDetailActivity.this.i.setText(parseObject.getString("video_num"));
            }
            if (PayContentDetailActivity.this.n != null && PayContentDetailActivity.this.n.getVisibility() != 0) {
                PayContentDetailActivity.this.n.setVisibility(0);
            }
            if (PayContentDetailActivity.this.u != null) {
                PayContentDetailActivity.this.u.Z(z);
                PayContentDetailActivity.this.u.P(parseArray);
            }
            if (PayContentDetailActivity.this.s != null) {
                PayContentDetailActivity payContentDetailActivity4 = PayContentDetailActivity.this;
                if (z) {
                    if (payContentDetailActivity4.s.getVisibility() != 8) {
                        PayContentDetailActivity.this.s.setVisibility(8);
                    }
                } else {
                    if (payContentDetailActivity4.s.getChildCount() > 0) {
                        PayContentDetailActivity.this.s.removeAllViews();
                    }
                    View inflate2 = LayoutInflater.from(PayContentDetailActivity.this.b).inflate(z73.F1, PayContentDetailActivity.this.s, false);
                    ((TextView) inflate2.findViewById(d73.k3)).setText(String.valueOf(PayContentDetailActivity.this.v));
                    PayContentDetailActivity.this.s.addView(inflate2);
                }
            }
        }
    }

    private void Z1() {
        if (((AbsActivity) this.b).e1()) {
            fx2 fx2Var = new fx2();
            Bundle bundle = new Bundle();
            bundle.putString("mallGoodsId", this.e);
            bundle.putDouble("mallOrderMoney", this.v.doubleValue());
            bundle.putString("mallGoodsName", this.w);
            fx2Var.F1(bundle);
            fx2Var.B2(this);
            fx2Var.d2(getSupportFragmentManager(), "PayContentPayDialogFragment");
        }
    }

    @Override // fx2.c
    public void A() {
        V1();
    }

    public void V1() {
        ec2.X(this.e, new a());
    }

    @Override // defpackage.et2
    /* renamed from: W1, reason: merged with bridge method [inline-methods] */
    public void onItemClick(PayContentVideoPlayBean payContentVideoPlayBean, int i) {
        pi3.s(this.b, payContentVideoPlayBean.getUploadResultUrl(), null);
    }

    public final void X1() {
        ax2 ax2Var = new ax2();
        Bundle bundle = new Bundle();
        bundle.putString("mallGoodsId", this.e);
        ax2Var.F1(bundle);
        ax2Var.d2(getSupportFragmentManager(), "PayCommentDialogFragment");
    }

    public final void Y1() {
        List list = this.x;
        if (list == null || list.size() <= 0) {
            return;
        }
        pi3.s(this.b, ((PayContentVideoPlayBean) this.x.get(0)).getUploadResultUrl(), null);
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return z73.E;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.P7));
        this.e = getIntent().getStringExtra("mallGoodsId");
        this.g = (ImageView) findViewById(d73.j4);
        this.h = (TextView) findViewById(d73.m4);
        this.i = (TextView) findViewById(d73.W2);
        this.j = (TextView) findViewById(d73.R3);
        this.k = (TextView) findViewById(d73.O1);
        this.l = (StarCountView) findViewById(d73.Z3);
        this.m = (TextView) findViewById(d73.A1);
        this.n = findViewById(d73.p2);
        this.o = findViewById(d73.l2);
        this.p = (ImageView) findViewById(d73.l);
        this.q = (TextView) findViewById(d73.R2);
        this.r = (TextView) findViewById(d73.r4);
        this.s = (ViewGroup) findViewById(d73.h2);
        RecyclerView findViewById = findViewById(d73.u3);
        this.t = findViewById;
        findViewById.setLayoutManager(new LinearLayoutManager(this.b, 1, false));
        jx2 jx2Var = new jx2(this.b);
        this.u = jx2Var;
        jx2Var.R(this);
        this.t.setAdapter(this.u);
        V1();
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        ec2.u("getPayContentDetail");
        super.onDestroy();
    }

    public void payContentClick(View view) {
        int id = view.getId();
        if (id == d73.q1) {
            pi3.q(this.b, this.f);
            return;
        }
        if (id == d73.l2) {
            X1();
        } else if (id == d73.I) {
            Z1();
        } else if (id == d73.N0) {
            Y1();
        }
    }
}
