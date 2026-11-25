package com.yunbao.live.activity;

import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.bean.GoodsBean;
import com.yunbao.common.custom.CommonRefreshView;
import com.yunbao.common.http.HttpCallback;
import defpackage.aq4;
import defpackage.b73;
import defpackage.ce3;
import defpackage.e32;
import defpackage.m93;
import defpackage.mu1;
import defpackage.t54;
import defpackage.x73;
import defpackage.z22;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class LiveGoodsAddActivity extends AbsActivity {
    public EditText e;
    public String f;
    public CommonRefreshView g;
    public CommonRefreshView h;
    public z22 i;
    public z22 j;
    public e k;

    /* loaded from: /tmp/classes2.dex */
    public class a implements TextView.OnEditorActionListener {
        public a() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 3) {
                return false;
            }
            LiveGoodsAddActivity.this.I1();
            return true;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (LiveGoodsAddActivity.this.k != null) {
                LiveGoodsAddActivity.this.k.removeCallbacksAndMessages(null);
            }
            boolean isEmpty = TextUtils.isEmpty(charSequence);
            LiveGoodsAddActivity liveGoodsAddActivity = LiveGoodsAddActivity.this;
            if (!isEmpty) {
                if (liveGoodsAddActivity.k != null) {
                    LiveGoodsAddActivity.this.k.sendEmptyMessageDelayed(0, 500L);
                }
            } else {
                liveGoodsAddActivity.f = null;
                if (LiveGoodsAddActivity.this.j != null) {
                    LiveGoodsAddActivity.this.j.M();
                }
                if (LiveGoodsAddActivity.this.h.getVisibility() == 0) {
                    LiveGoodsAddActivity.this.h.setVisibility(4);
                }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c implements CommonRefreshView.e {
        public c() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public ce3 getAdapter() {
            if (LiveGoodsAddActivity.this.i == null) {
                LiveGoodsAddActivity liveGoodsAddActivity = LiveGoodsAddActivity.this;
                liveGoodsAddActivity.i = new z22(liveGoodsAddActivity.b);
            }
            return LiveGoodsAddActivity.this.i;
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void loadData(int i, HttpCallback httpCallback) {
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
            return LiveGoodsAddActivity.this.H1(strArr);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d implements CommonRefreshView.e {
        public d() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public ce3 getAdapter() {
            if (LiveGoodsAddActivity.this.j == null) {
                LiveGoodsAddActivity liveGoodsAddActivity = LiveGoodsAddActivity.this;
                liveGoodsAddActivity.j = new z22(liveGoodsAddActivity.b);
            }
            return LiveGoodsAddActivity.this.j;
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void loadData(int i, HttpCallback httpCallback) {
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
            return LiveGoodsAddActivity.this.H1(strArr);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static class e extends Handler {
        public LiveGoodsAddActivity a;

        public e(LiveGoodsAddActivity liveGoodsAddActivity) {
            this.a = (LiveGoodsAddActivity) new WeakReference(liveGoodsAddActivity).get();
        }

        public void a() {
            this.a = null;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            LiveGoodsAddActivity liveGoodsAddActivity = this.a;
            if (liveGoodsAddActivity != null) {
                liveGoodsAddActivity.I1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I1() {
        String trim = this.e.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            t54.a(m93.r1);
            return;
        }
        e eVar = this.k;
        if (eVar != null) {
            eVar.removeCallbacksAndMessages(null);
        }
        this.f = trim;
        if (this.h.getVisibility() != 0) {
            this.h.setVisibility(0);
        }
        this.h.k();
    }

    public final List H1(String[] strArr) {
        return (strArr == null || strArr.length <= 0) ? new ArrayList(1) : mu1.a(Arrays.toString(strArr), GoodsBean.class);
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return x73.g;
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.V1));
        EditText editText = (EditText) findViewById(b73.N1);
        this.e = editText;
        editText.setOnEditorActionListener(new a());
        this.e.addTextChangedListener(new b());
        CommonRefreshView commonRefreshView = (CommonRefreshView) findViewById(b73.E4);
        this.g = commonRefreshView;
        commonRefreshView.setEmptyLayoutId(x73.B2);
        this.g.setLayoutManager(new LinearLayoutManager(this.b, 1, false));
        this.g.setDataHelper(new c());
        this.h.setLayoutManager(new LinearLayoutManager(this.b, 1, false));
        this.h.setDataHelper(new d());
        this.k = new e(this);
        this.g.k();
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        e eVar = this.k;
        if (eVar != null) {
            eVar.removeCallbacksAndMessages(null);
            this.k.a();
        }
        this.k = null;
        e32.f("Shop.SetSale");
        super.onDestroy();
    }
}
