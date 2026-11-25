package com.yunbao.main.activity;

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
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.custom.CommonRefreshView;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.main.bean.ActiveTopicBean;
import defpackage.c73;
import defpackage.ce3;
import defpackage.db2;
import defpackage.ec2;
import defpackage.j4;
import defpackage.l4;
import defpackage.m93;
import defpackage.t54;
import defpackage.u73;
import defpackage.y73;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class ActiveSearchTopicActivity extends AbsActivity {
    public CommonRefreshView e;
    public EditText f;
    public View g;
    public String h;
    public e i;
    public InputMethodManager j;
    public l4 k;
    public RecyclerView l;

    /* loaded from: /tmp/classes2.dex */
    public class a implements TextView.OnEditorActionListener {
        public a() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 3) {
                return false;
            }
            ec2.u("searchGoodsList");
            if (ActiveSearchTopicActivity.this.i != null) {
                ActiveSearchTopicActivity.this.i.removeCallbacksAndMessages(null);
            }
            if (TextUtils.isEmpty(ActiveSearchTopicActivity.this.f.getText().toString())) {
                t54.a(m93.r1);
                return true;
            }
            ActiveSearchTopicActivity.this.F1();
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
            db2.i("searchActiveTopic");
            if (ActiveSearchTopicActivity.this.i != null) {
                ActiveSearchTopicActivity.this.i.removeCallbacksAndMessages(null);
                ActiveSearchTopicActivity.this.i.sendEmptyMessageDelayed(0, 500L);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c implements CommonRefreshView.e {
        public c() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public ce3 getAdapter() {
            if (ActiveSearchTopicActivity.this.k == null) {
                ActiveSearchTopicActivity activeSearchTopicActivity = ActiveSearchTopicActivity.this;
                activeSearchTopicActivity.k = new l4(activeSearchTopicActivity.b);
            }
            return ActiveSearchTopicActivity.this.k;
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void loadData(int i, HttpCallback httpCallback) {
            db2.p0(ActiveSearchTopicActivity.this.h, i, httpCallback);
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
            if (ActiveSearchTopicActivity.this.j == null || ActiveSearchTopicActivity.this.f == null) {
                return;
            }
            ActiveSearchTopicActivity.this.j.hideSoftInputFromWindow(ActiveSearchTopicActivity.this.f.getWindowToken(), 0);
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public List processData(String[] strArr) {
            return JSON.parseArray(Arrays.toString(strArr), ActiveTopicBean.class);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d extends HttpCallback {
        public d() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || ActiveSearchTopicActivity.this.l == null) {
                return;
            }
            ActiveSearchTopicActivity.this.l.setAdapter(new j4(ActiveSearchTopicActivity.this.b, JSON.parseArray(Arrays.toString(strArr), ActiveTopicBean.class)));
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static class e extends Handler {
        public ActiveSearchTopicActivity a;

        public e(ActiveSearchTopicActivity activeSearchTopicActivity) {
            this.a = (ActiveSearchTopicActivity) new WeakReference(activeSearchTopicActivity).get();
        }

        public void a() {
            removeCallbacksAndMessages(null);
            this.a = null;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            ActiveSearchTopicActivity activeSearchTopicActivity = this.a;
            if (activeSearchTopicActivity != null) {
                activeSearchTopicActivity.F1();
            }
        }
    }

    public void F1() {
        String trim = this.f.getText().toString().trim();
        this.h = trim;
        if (TextUtils.isEmpty(trim)) {
            l4 l4Var = this.k;
            if (l4Var != null) {
                l4Var.M();
            }
            View view = this.g;
            if (view == null || view.getVisibility() == 0) {
                return;
            }
            this.g.setVisibility(0);
            return;
        }
        View view2 = this.g;
        if (view2 != null && view2.getVisibility() == 0) {
            this.g.setVisibility(4);
        }
        CommonRefreshView commonRefreshView = this.e;
        if (commonRefreshView != null) {
            commonRefreshView.k();
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return y73.Q;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        this.g = findViewById(c73.A2);
        this.j = (InputMethodManager) getSystemService("input_method");
        EditText editText = (EditText) findViewById(c73.P1);
        this.f = editText;
        editText.setOnEditorActionListener(new a());
        this.f.addTextChangedListener(new b());
        CommonRefreshView commonRefreshView = (CommonRefreshView) findViewById(c73.r4);
        this.e = commonRefreshView;
        commonRefreshView.setEmptyLayoutId(u73.V);
        this.e.setLayoutManager(new LinearLayoutManager(this.b, 1, false));
        this.e.setDataHelper(new c());
        this.i = new e(this);
        RecyclerView findViewById = findViewById(c73.m4);
        this.l = findViewById;
        findViewById.setHasFixedSize(true);
        this.l.setLayoutManager(new FlexboxLayoutManager(this.b));
        db2.A(new d());
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        e eVar = this.i;
        if (eVar != null) {
            eVar.a();
        }
        this.i = null;
        ec2.u("getActiveRecomTopic");
        ec2.u("searchActiveTopic");
        super.onDestroy();
    }
}
