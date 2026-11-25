package com.yunbao.im.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.umeng.analytics.pro.g;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.bean.TxLocationPoiBean;
import com.yunbao.common.custom.CommonRefreshView;
import com.yunbao.common.http.CommonHttpConsts;
import com.yunbao.common.http.CommonHttpUtil;
import com.yunbao.common.http.HttpCallback;
import defpackage.a73;
import defpackage.aq4;
import defpackage.ce3;
import defpackage.et2;
import defpackage.j30;
import defpackage.j72;
import defpackage.l72;
import defpackage.m93;
import defpackage.pw3;
import defpackage.t54;
import defpackage.w73;
import defpackage.zu0;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: /tmp/classes2.dex */
public class LocationActivity extends AbsActivity implements View.OnClickListener {
    public CommonRefreshView e;
    public j72 f;
    public CommonRefreshView g;
    public j72 h;
    public double i;
    public double j;
    public boolean k;
    public EditText l;
    public View m;
    public Handler n;
    public InputMethodManager o;
    public String p;
    public boolean q;
    public View r;

    /* loaded from: /tmp/classes2.dex */
    public class a implements CommonRefreshView.e {

        /* renamed from: com.yunbao.im.activity.LocationActivity$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/classes2.dex */
        public class C0034a implements et2 {
            public C0034a() {
            }

            @Override // defpackage.et2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onItemClick(TxLocationPoiBean txLocationPoiBean, int i) {
                LocationActivity.this.q = true;
                txLocationPoiBean.getLocation();
            }
        }

        public a() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public ce3 getAdapter() {
            if (LocationActivity.this.f == null) {
                LocationActivity locationActivity = LocationActivity.this;
                locationActivity.f = new j72(locationActivity.b);
                LocationActivity.this.f.R(new C0034a());
            }
            return LocationActivity.this.f;
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void loadData(int i, HttpCallback httpCallback) {
            CommonHttpUtil.getAddressInfoByTxLocaitonSdk(LocationActivity.this.i, LocationActivity.this.j, 1, i, CommonHttpConsts.GET_MAP_INFO, httpCallback);
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void onLoadMoreFailure() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void onLoadMoreSuccess(List list, int i) {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void onRefreshFailure() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void onRefreshSuccess(List list, int i) {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public List processData(String[] strArr) {
            JSONObject parseObject = JSON.parseObject(strArr[0]);
            if (parseObject != null) {
                return JSON.parseArray(parseObject.getString("pois"), TxLocationPoiBean.class);
            }
            return null;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements CommonRefreshView.e {

        /* loaded from: /tmp/classes2.dex */
        public class a implements et2 {
            public a() {
            }

            @Override // defpackage.et2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onItemClick(TxLocationPoiBean txLocationPoiBean, int i) {
                LocationActivity.this.o.hideSoftInputFromWindow(LocationActivity.this.l.getWindowToken(), 0);
                if (LocationActivity.this.m != null && LocationActivity.this.m.getVisibility() == 0) {
                    LocationActivity.this.m.setVisibility(4);
                }
                if (LocationActivity.this.h != null) {
                    LocationActivity.this.h.M();
                }
                if (LocationActivity.this.l != null) {
                    LocationActivity.this.l.setText("");
                }
                txLocationPoiBean.getLocation();
            }
        }

        public b() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public ce3 getAdapter() {
            if (LocationActivity.this.h == null) {
                LocationActivity locationActivity = LocationActivity.this;
                locationActivity.h = new j72(locationActivity.b);
                LocationActivity.this.h.R(new a());
            }
            return LocationActivity.this.h;
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void loadData(int i, HttpCallback httpCallback) {
            if (TextUtils.isEmpty(LocationActivity.this.p)) {
                return;
            }
            CommonHttpUtil.searchAddressInfoByTxLocaitonSdk(LocationActivity.this.i, LocationActivity.this.j, LocationActivity.this.p, i, httpCallback);
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void onLoadMoreFailure() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void onLoadMoreSuccess(List list, int i) {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void onRefreshFailure() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void onRefreshSuccess(List list, int i) {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public List processData(String[] strArr) {
            return JSON.parseArray(strArr[0], TxLocationPoiBean.class);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c implements TextView.OnEditorActionListener {
        public c() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 3) {
                return false;
            }
            CommonHttpUtil.cancel(CommonHttpConsts.GET_MAP_SEARCH);
            if (LocationActivity.this.n != null) {
                LocationActivity.this.n.removeMessages(0);
            }
            if (LocationActivity.this.i == 0.0d || LocationActivity.this.j == 0.0d) {
                t54.b(aq4.a(m93.w2));
                return true;
            }
            String trim = LocationActivity.this.l.getText().toString().trim();
            if (TextUtils.isEmpty(trim)) {
                t54.b(aq4.a(m93.r1));
            } else {
                if (LocationActivity.this.m.getVisibility() != 0) {
                    LocationActivity.this.m.setVisibility(0);
                }
                LocationActivity.this.o.hideSoftInputFromWindow(LocationActivity.this.l.getWindowToken(), 0);
                LocationActivity.this.p = trim;
                if (LocationActivity.this.g != null) {
                    LocationActivity.this.g.k();
                }
            }
            return true;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d implements TextWatcher {
        public d() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            CommonHttpUtil.cancel(CommonHttpConsts.GET_MAP_SEARCH);
            boolean isEmpty = TextUtils.isEmpty(charSequence);
            LocationActivity locationActivity = LocationActivity.this;
            if (!isEmpty) {
                if (locationActivity.n != null) {
                    LocationActivity.this.n.removeMessages(0);
                    LocationActivity.this.n.sendEmptyMessageDelayed(0, 500L);
                }
                if (LocationActivity.this.r == null || LocationActivity.this.r.getVisibility() == 0) {
                    return;
                }
                LocationActivity.this.r.setVisibility(0);
                return;
            }
            if (locationActivity.m.getVisibility() == 0) {
                LocationActivity.this.m.setVisibility(4);
            }
            if (LocationActivity.this.h != null) {
                LocationActivity.this.h.M();
            }
            if (LocationActivity.this.r == null || LocationActivity.this.r.getVisibility() != 0) {
                return;
            }
            LocationActivity.this.r.setVisibility(4);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e extends Handler {
        public e() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            CommonHttpUtil.cancel(CommonHttpConsts.GET_MAP_SEARCH);
            String trim = LocationActivity.this.l.getText().toString().trim();
            boolean isEmpty = TextUtils.isEmpty(trim);
            LocationActivity locationActivity = LocationActivity.this;
            if (isEmpty) {
                if (locationActivity.m.getVisibility() == 0) {
                    LocationActivity.this.m.setVisibility(4);
                }
                if (LocationActivity.this.h != null) {
                    LocationActivity.this.h.M();
                    return;
                }
                return;
            }
            if (locationActivity.m.getVisibility() != 0) {
                LocationActivity.this.m.setVisibility(0);
            }
            LocationActivity.this.p = trim;
            if (LocationActivity.this.g != null) {
                LocationActivity.this.g.k();
            }
        }
    }

    public final void N1() {
        this.i = j30.q().v();
        this.j = j30.q().r();
        Q1();
    }

    public final void O1() {
        CommonHttpUtil.cancel(CommonHttpConsts.GET_MAP_INFO);
        CommonRefreshView commonRefreshView = this.e;
        if (commonRefreshView != null) {
            commonRefreshView.k();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void P1() {
        if (!this.k) {
            t54.b(aq4.a(m93.x2));
            return;
        }
        if (this.f == null) {
            t54.a(m93.t2);
            return;
        }
        TxLocationPoiBean a0 = this.m.getVisibility() == 0 ? this.h.a0() : this.f.a0();
        if (a0 == null) {
            t54.a(m93.t2);
            return;
        }
        Intent intent = new Intent();
        TxLocationPoiBean.Location location = a0.getLocation();
        intent.putExtra(g.C, location.getLat());
        intent.putExtra(g.D, location.getLng());
        intent.putExtra("address", "{\"name\":\"" + a0.getTitle() + "\",\"info\":\"" + a0.getAddress() + "\"}");
        setResult(-1, intent);
        finish();
    }

    public final void Q1() {
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return w73.e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void n1(Bundle bundle) {
        t1(aq4.a(m93.a5));
        CommonRefreshView commonRefreshView = (CommonRefreshView) findViewById(a73.e0);
        this.e = commonRefreshView;
        commonRefreshView.setLayoutManager(new LinearLayoutManager(this.b, 1, false));
        CommonRefreshView commonRefreshView2 = (CommonRefreshView) findViewById(a73.f0);
        this.g = commonRefreshView2;
        commonRefreshView2.setLayoutManager(new LinearLayoutManager(this.b, 1, false));
        this.e.setDataHelper(new a());
        this.g.setDataHelper(new b());
        this.i = j30.q().v();
        double r = j30.q().r();
        this.j = r;
        if (this.i != 0.0d && r != 0.0d) {
            Q1();
            O1();
        }
        zu0.c().n(this);
        findViewById(a73.y).setOnClickListener(this);
        findViewById(a73.w).setOnClickListener(this);
        View findViewById = findViewById(a73.j);
        this.r = findViewById;
        findViewById.setOnClickListener(this);
        this.m = findViewById(a73.i0);
        this.o = (InputMethodManager) getSystemService("input_method");
        EditText editText = (EditText) findViewById(a73.h0);
        this.l = editText;
        editText.setOnEditorActionListener(new c());
        this.l.addTextChangedListener(new d());
        this.n = new e();
    }

    public void onBackPressed() {
        this.o.hideSoftInputFromWindow(this.l.getWindowToken(), 0);
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        int id = view.getId();
        if (id == a73.y) {
            P1();
            return;
        }
        if (id == a73.w) {
            N1();
        } else {
            if (id != a73.j || (editText = this.l) == null) {
                return;
            }
            editText.setText("");
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        CommonHttpUtil.cancel(CommonHttpConsts.GET_MAP_SEARCH);
        CommonHttpUtil.cancel(CommonHttpConsts.GET_MAP_INFO);
        zu0.c().p(this);
        super.onDestroy();
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onLocationEvent(l72 l72Var) {
        throw null;
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onPause() {
        super.onPause();
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onRestart() {
        super.onRestart();
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onResume() {
        super.onResume();
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onStart() {
        super.onStart();
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onStop() {
        super.onStop();
    }
}
