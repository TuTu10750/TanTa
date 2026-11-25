package com.yunbao.mall.activity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.umeng.commonsdk.deeplink.DeepLinkPresetEvent;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.mall.bean.WuliuBean;
import defpackage.aq4;
import defpackage.d73;
import defpackage.ec2;
import defpackage.et2;
import defpackage.kn1;
import defpackage.m93;
import defpackage.qm3;
import defpackage.rv3;
import defpackage.t54;
import defpackage.z73;
import defpackage.zn0;
import java.util.Arrays;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class SellerSendActivity extends AbsActivity implements View.OnClickListener, et2, PopupWindow.OnDismissListener {
    public String A;
    public String B;
    public String e;
    public TextView f;
    public TextView g;
    public TextView h;
    public EditText i;
    public TextView j;
    public View k;
    public TextView l;
    public TextView m;
    public View n;
    public TextView o;
    public ImageView p;
    public TextView q;
    public TextView r;
    public TextView s;
    public TextView t;
    public TextView u;
    public TextView v;
    public String w;
    public View x;
    public PopupWindow y;
    public qm3 z;

    /* loaded from: /tmp/classes2.dex */
    public class a extends HttpCallback {
        public a() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length <= 0) {
                return;
            }
            JSONObject jSONObject = JSON.parseObject(strArr[0]).getJSONObject("order_info");
            if (SellerSendActivity.this.f != null) {
                SellerSendActivity.this.f.setText(jSONObject.getString("status_name"));
            }
            if (SellerSendActivity.this.g != null) {
                SellerSendActivity.this.g.setText(jSONObject.getString("status_desc"));
            }
            if (SellerSendActivity.this.h != null) {
                SellerSendActivity.this.h.setText(aq4.b(m93.Y6, jSONObject.getString("orderno")));
            }
            if (SellerSendActivity.this.l != null) {
                SellerSendActivity.this.l.setText(rv3.a(jSONObject.getString("username"), " ", jSONObject.getString("phone")));
            }
            if (SellerSendActivity.this.m != null) {
                SellerSendActivity.this.B = jSONObject.getString("address_format");
                SellerSendActivity.this.m.setText(SellerSendActivity.this.B);
            }
            String string = jSONObject.getString("message");
            if (!TextUtils.isEmpty(string) && SellerSendActivity.this.o != null) {
                SellerSendActivity.this.o.setText(string);
            }
            if (SellerSendActivity.this.p != null) {
                kn1.f(SellerSendActivity.this.b, jSONObject.getString("spec_thumb_format"), SellerSendActivity.this.p);
            }
            if (SellerSendActivity.this.q != null) {
                SellerSendActivity.this.q.setText(jSONObject.getString("goods_name"));
            }
            if (SellerSendActivity.this.r != null) {
                SellerSendActivity.this.r.setText(rv3.a(SellerSendActivity.this.w, jSONObject.getString(DeepLinkPresetEvent.UMEventParamPrice)));
            }
            if (SellerSendActivity.this.s != null) {
                SellerSendActivity.this.s.setText(jSONObject.getString("spec_name"));
            }
            if (SellerSendActivity.this.t != null) {
                SellerSendActivity.this.t.setText(rv3.a("x", jSONObject.getString("nums")));
            }
            if (SellerSendActivity.this.u != null) {
                SellerSendActivity.this.u.setText(rv3.a(SellerSendActivity.this.w, jSONObject.getString("postage")));
            }
            if (SellerSendActivity.this.v != null) {
                SellerSendActivity.this.v.setText(rv3.a(SellerSendActivity.this.w, jSONObject.getString("total")));
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends HttpCallback {
        public b() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i == 0) {
                List parseArray = JSON.parseArray(Arrays.toString(strArr), WuliuBean.class);
                SellerSendActivity sellerSendActivity = SellerSendActivity.this;
                sellerSendActivity.z = new qm3(sellerSendActivity.b, parseArray);
                SellerSendActivity.this.z.R(SellerSendActivity.this);
                SellerSendActivity.this.V1();
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends HttpCallback {
        public c() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i == 0) {
                SellerSendActivity.this.finish();
            }
            t54.b(str);
        }
    }

    public static void T1(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) SellerSendActivity.class);
        intent.putExtra("mallOrderId", str);
        context.startActivity(intent);
    }

    private void W1() {
        if (TextUtils.isEmpty(this.e)) {
            return;
        }
        String trim = this.i.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            t54.a(m93.W6);
        } else if (TextUtils.isEmpty(this.A)) {
            t54.a(m93.X6);
        } else {
            ec2.x0(this.e, this.A, trim, new c());
        }
    }

    public final void R1() {
        if (this.z == null) {
            ec2.m0(new b());
        } else {
            V1();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void S1() {
        if (TextUtils.isEmpty(this.B)) {
            return;
        }
        ((ClipboardManager) getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text", this.B));
        t54.a(m93.u1);
    }

    @Override // defpackage.et2
    /* renamed from: U1, reason: merged with bridge method [inline-methods] */
    public void onItemClick(WuliuBean wuliuBean, int i) {
        this.A = wuliuBean.getId();
        TextView textView = this.j;
        if (textView != null) {
            textView.setText(wuliuBean.getName());
        }
        PopupWindow popupWindow = this.y;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    public final void V1() {
        View inflate = LayoutInflater.from(this.b).inflate(z73.k0, (ViewGroup) null);
        RecyclerView findViewById = inflate.findViewById(d73.u3);
        findViewById.setHasFixedSize(true);
        findViewById.setLayoutManager(new LinearLayoutManager(this.b, 1, false));
        findViewById.setAdapter(this.z);
        PopupWindow popupWindow = new PopupWindow(inflate, -1, zn0.a(250), true);
        this.y = popupWindow;
        popupWindow.setOnDismissListener(this);
        this.y.setBackgroundDrawable(new ColorDrawable());
        this.y.setOutsideTouchable(true);
        this.y.showAsDropDown(this.x);
        View view = this.k;
        if (view != null) {
            view.setRotation(-90.0f);
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return z73.S;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.Z6));
        this.e = getIntent().getStringExtra("mallOrderId");
        this.f = (TextView) findViewById(d73.b4);
        this.g = (TextView) findViewById(d73.d4);
        this.h = (TextView) findViewById(d73.Y2);
        this.i = (EditText) findViewById(d73.z4);
        this.j = (TextView) findViewById(d73.y4);
        this.k = findViewById(d73.k);
        this.l = (TextView) findViewById(d73.w1);
        this.m = (TextView) findViewById(d73.u1);
        this.n = findViewById(d73.o2);
        this.o = (TextView) findViewById(d73.v1);
        this.p = (ImageView) findViewById(d73.e2);
        this.q = (TextView) findViewById(d73.W1);
        this.r = (TextView) findViewById(d73.Z1);
        this.s = (TextView) findViewById(d73.d2);
        this.t = (TextView) findViewById(d73.X1);
        this.u = (TextView) findViewById(d73.j3);
        this.v = (TextView) findViewById(d73.P2);
        this.w = aq4.a(m93.O8);
        View findViewById = findViewById(d73.s1);
        this.x = findViewById;
        findViewById.setOnClickListener(this);
        findViewById(d73.g0).setOnClickListener(this);
        findViewById(d73.n1).setOnClickListener(this);
        ec2.f0(this.e, new a());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == d73.s1) {
            R1();
        } else if (id == d73.n1) {
            W1();
        } else if (id == d73.g0) {
            S1();
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        ec2.u("getSellerOrderDetail");
        ec2.u("getWuliuList");
        ec2.u("sellerSendOrder");
        PopupWindow popupWindow = this.y;
        if (popupWindow != null) {
            popupWindow.setOnDismissListener(null);
            this.y.dismiss();
        }
        this.y = null;
        super.onDestroy();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        View view = this.k;
        if (view != null) {
            view.setRotation(90.0f);
        }
    }
}
