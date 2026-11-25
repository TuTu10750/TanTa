package com.yunbao.mall.activity;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.umeng.analytics.pro.cl;
import com.umeng.commonsdk.deeplink.DeepLinkPresetEvent;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.common.utils.a;
import com.yunbao.im.activity.ChatRoomActivity;
import com.yunbao.im.bean.ImConUserBean;
import defpackage.aq4;
import defpackage.d73;
import defpackage.ec2;
import defpackage.kn1;
import defpackage.m93;
import defpackage.rv3;
import defpackage.t54;
import defpackage.xj1;
import defpackage.z73;
import okhttp3.HttpUrl;

/* loaded from: /tmp/classes2.dex */
public class SellerOrderDetailActivity extends AbsActivity {
    public String A;
    public JSONObject B;
    public String e;
    public TextView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public View j;
    public TextView k;
    public TextView l;
    public View m;
    public TextView n;
    public ImageView o;
    public TextView p;
    public TextView q;
    public TextView r;
    public TextView s;
    public TextView t;
    public TextView u;
    public TextView v;
    public TextView w;
    public TextView x;
    public TextView y;
    public ViewGroup z;

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
            JSONObject jSONObject = parseObject.getJSONObject("order_info");
            SellerOrderDetailActivity.this.B = jSONObject;
            int intValue = jSONObject.getIntValue(cl.i);
            if (SellerOrderDetailActivity.this.f != null) {
                SellerOrderDetailActivity.this.f.setText(jSONObject.getString("status_name"));
            }
            if (SellerOrderDetailActivity.this.g != null) {
                SellerOrderDetailActivity.this.g.setText(jSONObject.getString("status_desc"));
            }
            String string = parseObject.getString("express_info");
            if (intValue > 1 && !HttpUrl.PATH_SEGMENT_ENCODE_SET_URI.equals(string)) {
                JSONObject parseObject2 = JSON.parseObject(string);
                if (SellerOrderDetailActivity.this.j != null) {
                    SellerOrderDetailActivity.this.j.setVisibility(0);
                }
                if (SellerOrderDetailActivity.this.h != null) {
                    SellerOrderDetailActivity.this.h.setText(parseObject2.getString("state_name"));
                }
                if (SellerOrderDetailActivity.this.i != null) {
                    SellerOrderDetailActivity.this.i.setText(parseObject2.getString("desc"));
                }
            } else if (SellerOrderDetailActivity.this.j != null && SellerOrderDetailActivity.this.j.getVisibility() != 8) {
                SellerOrderDetailActivity.this.j.setVisibility(8);
            }
            if (SellerOrderDetailActivity.this.k != null) {
                SellerOrderDetailActivity.this.k.setText(rv3.a(jSONObject.getString("username"), " ", jSONObject.getString("phone")));
            }
            if (SellerOrderDetailActivity.this.l != null) {
                SellerOrderDetailActivity.this.l.setText(jSONObject.getString("address_format"));
            }
            if (intValue > 0) {
                String string2 = jSONObject.getString("message");
                boolean isEmpty = TextUtils.isEmpty(string2);
                SellerOrderDetailActivity sellerOrderDetailActivity = SellerOrderDetailActivity.this;
                if (!isEmpty) {
                    if (sellerOrderDetailActivity.m != null && SellerOrderDetailActivity.this.m.getVisibility() != 0) {
                        SellerOrderDetailActivity.this.m.setVisibility(0);
                    }
                    if (SellerOrderDetailActivity.this.n != null) {
                        SellerOrderDetailActivity.this.n.setText(string2);
                    }
                } else if (sellerOrderDetailActivity.m != null && SellerOrderDetailActivity.this.m.getVisibility() != 8) {
                    SellerOrderDetailActivity.this.m.setVisibility(8);
                }
            } else if (SellerOrderDetailActivity.this.m != null && SellerOrderDetailActivity.this.m.getVisibility() != 8) {
                SellerOrderDetailActivity.this.m.setVisibility(8);
            }
            if (SellerOrderDetailActivity.this.o != null) {
                kn1.f(SellerOrderDetailActivity.this.b, jSONObject.getString("spec_thumb_format"), SellerOrderDetailActivity.this.o);
            }
            if (SellerOrderDetailActivity.this.p != null) {
                SellerOrderDetailActivity.this.p.setText(jSONObject.getString("goods_name"));
            }
            if (SellerOrderDetailActivity.this.q != null) {
                SellerOrderDetailActivity.this.q.setText(rv3.a(SellerOrderDetailActivity.this.A, jSONObject.getString(DeepLinkPresetEvent.UMEventParamPrice)));
            }
            if (SellerOrderDetailActivity.this.r != null) {
                SellerOrderDetailActivity.this.r.setText(jSONObject.getString("spec_name"));
            }
            if (SellerOrderDetailActivity.this.s != null) {
                SellerOrderDetailActivity.this.s.setText(rv3.a("x", jSONObject.getString("nums")));
            }
            if (SellerOrderDetailActivity.this.t != null) {
                SellerOrderDetailActivity.this.t.setText(rv3.a(SellerOrderDetailActivity.this.A, jSONObject.getString("postage")));
            }
            if (SellerOrderDetailActivity.this.u != null) {
                SellerOrderDetailActivity.this.u.setText(rv3.a(SellerOrderDetailActivity.this.A, jSONObject.getString("total")));
            }
            String string3 = jSONObject.getString("orderno");
            if (SellerOrderDetailActivity.this.v != null) {
                SellerOrderDetailActivity.this.v.setText(aq4.b(m93.Y6, string3));
            }
            if (SellerOrderDetailActivity.this.w != null) {
                SellerOrderDetailActivity.this.w.setText(aq4.b(m93.e7, jSONObject.getString("addtime")));
            }
            SellerOrderDetailActivity sellerOrderDetailActivity2 = SellerOrderDetailActivity.this;
            if (intValue > 0) {
                if (sellerOrderDetailActivity2.x != null) {
                    if (SellerOrderDetailActivity.this.x.getVisibility() != 0) {
                        SellerOrderDetailActivity.this.x.setVisibility(0);
                    }
                    SellerOrderDetailActivity.this.x.setText(aq4.b(m93.f7, jSONObject.getString("type_name")));
                }
                if (SellerOrderDetailActivity.this.y != null) {
                    if (SellerOrderDetailActivity.this.y.getVisibility() != 0) {
                        SellerOrderDetailActivity.this.y.setVisibility(0);
                    }
                    SellerOrderDetailActivity.this.y.setText(aq4.b(m93.g7, jSONObject.getString("paytime")));
                }
            } else {
                if (sellerOrderDetailActivity2.x != null && SellerOrderDetailActivity.this.x.getVisibility() == 0) {
                    SellerOrderDetailActivity.this.x.setVisibility(8);
                }
                if (SellerOrderDetailActivity.this.y != null && SellerOrderDetailActivity.this.y.getVisibility() == 0) {
                    SellerOrderDetailActivity.this.y.setVisibility(8);
                }
            }
            if (SellerOrderDetailActivity.this.z != null) {
                if (SellerOrderDetailActivity.this.z.getChildCount() > 0) {
                    SellerOrderDetailActivity.this.z.removeAllViews();
                }
                int i2 = intValue == -1 ? z73.a2 : 0;
                if (i2 != 0) {
                    LayoutInflater.from(SellerOrderDetailActivity.this.b).inflate(i2, SellerOrderDetailActivity.this.z, true);
                }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends HttpCallback {
        public b() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            ImConUserBean imConUserBean;
            if (i != 0 || strArr.length <= 0 || (imConUserBean = (ImConUserBean) JSON.parseObject(strArr[0], ImConUserBean.class)) == null) {
                return;
            }
            ChatRoomActivity.A1(SellerOrderDetailActivity.this.b, imConUserBean, imConUserBean.getAttent() == 1, false);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c implements a.m {

        /* loaded from: /tmp/classes2.dex */
        public class a extends HttpCallback {
            public a() {
            }

            @Override // com.yunbao.common.http.HttpCallback
            public void onSuccess(int i, String str, String[] strArr) {
                if (i == 0) {
                    SellerOrderDetailActivity.this.finish();
                }
                t54.b(str);
            }
        }

        public c() {
        }

        @Override // com.yunbao.common.utils.a.m
        public void b(Dialog dialog, String str) {
            ec2.w0(SellerOrderDetailActivity.this.e, new a());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void X1() {
        if (TextUtils.isEmpty(this.e) || this.B == null) {
            return;
        }
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse(rv3.a("tel:", this.B.getString("phone"))));
        startActivity(intent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void Y1() {
        if (TextUtils.isEmpty(this.e) || this.B == null) {
            return;
        }
        ((ClipboardManager) getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text", this.B.getString("orderno")));
        t54.a(m93.u1);
    }

    public static void Z1(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) SellerOrderDetailActivity.class);
        intent.putExtra("mallOrderId", str);
        context.startActivity(intent);
    }

    private void a2() {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(this.e) || (jSONObject = this.B) == null) {
            return;
        }
        xj1.g(jSONObject.getString("uid"), new b());
    }

    private void b2() {
        ec2.f0(this.e, new a());
    }

    private void c2() {
        if (TextUtils.isEmpty(this.e)) {
            return;
        }
        new a.j(this.b).k(aq4.a(m93.d8)).g(true).d(true).h(new c()).c().show();
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return z73.P;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        this.f = (TextView) findViewById(d73.b4);
        this.g = (TextView) findViewById(d73.d4);
        this.h = (TextView) findViewById(d73.A4);
        this.i = (TextView) findViewById(d73.B4);
        this.j = findViewById(d73.v2);
        this.k = (TextView) findViewById(d73.w1);
        this.l = (TextView) findViewById(d73.u1);
        this.m = findViewById(d73.o2);
        this.n = (TextView) findViewById(d73.v1);
        this.o = (ImageView) findViewById(d73.e2);
        this.p = (TextView) findViewById(d73.W1);
        this.q = (TextView) findViewById(d73.Z1);
        this.r = (TextView) findViewById(d73.d2);
        this.s = (TextView) findViewById(d73.X1);
        this.t = (TextView) findViewById(d73.j3);
        this.u = (TextView) findViewById(d73.P2);
        this.v = (TextView) findViewById(d73.Y2);
        this.w = (TextView) findViewById(d73.X2);
        this.x = (TextView) findViewById(d73.a3);
        this.y = (TextView) findViewById(d73.Z2);
        this.z = (ViewGroup) findViewById(d73.h2);
        this.e = getIntent().getStringExtra("mallOrderId");
        this.A = aq4.a(m93.O8);
        b2();
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        ec2.u("getSellerOrderDetail");
        ec2.u("sellerDeleteOrder");
        ec2.u("getImUserInfo");
        super.onDestroy();
    }

    public void sellerOrderDetailClick(View view) {
        int id = view.getId();
        if (id == d73.y0) {
            a2();
            return;
        }
        if (id == d73.L) {
            X1();
        } else if (id == d73.f0) {
            Y1();
        } else if (id == d73.n0) {
            c2();
        }
    }
}
