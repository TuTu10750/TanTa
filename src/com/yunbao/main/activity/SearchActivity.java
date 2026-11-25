package com.yunbao.main.activity;

import android.content.Context;
import android.content.Intent;
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
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.custom.CommonRefreshView;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.live.bean.SearchUserBean;
import defpackage.c73;
import defpackage.ce3;
import defpackage.db2;
import defpackage.et2;
import defpackage.m93;
import defpackage.ok3;
import defpackage.pi3;
import defpackage.pw3;
import defpackage.q41;
import defpackage.t54;
import defpackage.u73;
import defpackage.y73;
import defpackage.zu0;
import java.util.Arrays;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: /tmp/classes2.dex */
public class SearchActivity extends AbsActivity implements et2, View.OnClickListener {
    public EditText e;
    public CommonRefreshView f;
    public ok3 g;
    public InputMethodManager h;
    public String i;
    public View j;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SearchActivity.this.G1();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements TextView.OnEditorActionListener {
        public b() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 3) {
                return false;
            }
            SearchActivity.this.G1();
            return true;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c implements TextWatcher {
        public c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            db2.i("search");
            if (SearchActivity.this.f != null) {
                SearchActivity.this.f.j();
            }
            boolean isEmpty = TextUtils.isEmpty(charSequence);
            SearchActivity searchActivity = SearchActivity.this;
            if (!isEmpty) {
                if (searchActivity.j == null || SearchActivity.this.j.getVisibility() == 0) {
                    return;
                }
                SearchActivity.this.j.setVisibility(0);
                return;
            }
            searchActivity.i = null;
            if (SearchActivity.this.g != null) {
                SearchActivity.this.g.M();
            }
            if (SearchActivity.this.j == null || SearchActivity.this.j.getVisibility() != 0) {
                return;
            }
            SearchActivity.this.j.setVisibility(4);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d implements CommonRefreshView.e {
        public d() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public ce3 getAdapter() {
            if (SearchActivity.this.g == null) {
                SearchActivity searchActivity = SearchActivity.this;
                searchActivity.g = new ok3(searchActivity.b, 1004);
                SearchActivity.this.g.R(SearchActivity.this);
            }
            return SearchActivity.this.g;
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void loadData(int i, HttpCallback httpCallback) {
            if (TextUtils.isEmpty(SearchActivity.this.i)) {
                return;
            }
            db2.o0(SearchActivity.this.i, i, httpCallback);
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
            return JSON.parseArray(Arrays.toString(strArr), SearchUserBean.class);
        }
    }

    public static void E1(Context context) {
        context.startActivity(new Intent(context, (Class<?>) SearchActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G1() {
        String trim = this.e.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            t54.a(m93.r1);
            return;
        }
        db2.i("search");
        this.i = trim;
        this.f.k();
    }

    @Override // defpackage.et2
    /* renamed from: F1, reason: merged with bridge method [inline-methods] */
    public void onItemClick(SearchUserBean searchUserBean, int i) {
        EditText editText;
        InputMethodManager inputMethodManager = this.h;
        if (inputMethodManager == null || (editText = this.e) == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
        pi3.q(this.b, searchUserBean.getId());
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return y73.P;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        this.h = (InputMethodManager) getSystemService("input_method");
        View findViewById = findViewById(c73.Y);
        this.j = findViewById;
        findViewById.setOnClickListener(this);
        findViewById(c73.c5).setOnClickListener(new a());
        EditText editText = (EditText) findViewById(c73.P1);
        this.e = editText;
        editText.setOnEditorActionListener(new b());
        this.e.addTextChangedListener(new c());
        CommonRefreshView commonRefreshView = (CommonRefreshView) findViewById(c73.r4);
        this.f = commonRefreshView;
        commonRefreshView.setEmptyLayoutId(u73.W);
        this.f.setLayoutManager(new LinearLayoutManager(this.b, 1, false));
        this.f.setDataHelper(new d());
        zu0.c().n(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText = this.e;
        if (editText != null) {
            editText.setText((CharSequence) null);
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        zu0.c().p(this);
        db2.i("search");
        super.onDestroy();
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onFollowEvent(q41 q41Var) {
        ok3 ok3Var = this.g;
        if (ok3Var != null) {
            ok3Var.e0(q41Var.b(), q41Var.a());
        }
    }
}
