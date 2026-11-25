package com.yunbao.main.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.SparseIntArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.custom.CommonRefreshView;
import com.yunbao.common.custom.SideIndexBar;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.main.bean.ChooseCountryBean;
import defpackage.c73;
import defpackage.ce3;
import defpackage.db2;
import defpackage.et2;
import defpackage.m04;
import defpackage.m93;
import defpackage.oz;
import defpackage.t54;
import defpackage.y73;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class ChooseCountryActivity extends AbsActivity implements View.OnClickListener, et2 {
    public SideIndexBar e;
    public RecyclerView f;
    public m04 g;
    public LinearLayoutManager h;
    public oz i;
    public oz j;
    public SparseIntArray k;
    public CommonRefreshView l;
    public EditText m;
    public View n;
    public g o;
    public String p;
    public InputMethodManager q;

    /* loaded from: /tmp/classes2.dex */
    public class a implements SideIndexBar.a {
        public a() {
        }

        @Override // com.yunbao.common.custom.SideIndexBar.a
        public void a(int i) {
            int i2 = ChooseCountryActivity.this.k.get(i);
            if (ChooseCountryActivity.this.h != null) {
                ChooseCountryActivity.this.h.M2(i2, 0);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements m04.a {
        public b() {
        }

        @Override // m04.a
        public void a(String str) {
            if (ChooseCountryActivity.this.e != null) {
                ChooseCountryActivity.this.e.setSelectionIndex(str);
            }
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
            ChooseCountryActivity.this.O1();
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
            db2.i("getCountryCode");
            if (ChooseCountryActivity.this.o != null) {
                ChooseCountryActivity.this.o.removeCallbacksAndMessages(null);
            }
            boolean isEmpty = TextUtils.isEmpty(charSequence);
            ChooseCountryActivity chooseCountryActivity = ChooseCountryActivity.this;
            if (!isEmpty) {
                if (chooseCountryActivity.o != null) {
                    ChooseCountryActivity.this.o.sendEmptyMessageDelayed(0, 500L);
                }
                if (ChooseCountryActivity.this.n == null || ChooseCountryActivity.this.n.getVisibility() == 0) {
                    return;
                }
                ChooseCountryActivity.this.n.setVisibility(0);
                return;
            }
            chooseCountryActivity.p = null;
            if (ChooseCountryActivity.this.j != null) {
                ChooseCountryActivity.this.j.M();
            }
            if (ChooseCountryActivity.this.n != null && ChooseCountryActivity.this.n.getVisibility() == 0) {
                ChooseCountryActivity.this.n.setVisibility(4);
            }
            if (ChooseCountryActivity.this.l.getVisibility() == 0) {
                ChooseCountryActivity.this.l.setVisibility(4);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e implements CommonRefreshView.e {
        public e() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public ce3 getAdapter() {
            if (ChooseCountryActivity.this.j == null) {
                ChooseCountryActivity chooseCountryActivity = ChooseCountryActivity.this;
                chooseCountryActivity.j = new oz(chooseCountryActivity.b);
                ChooseCountryActivity.this.j.R(ChooseCountryActivity.this);
            }
            return ChooseCountryActivity.this.j;
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void loadData(int i, HttpCallback httpCallback) {
            if (TextUtils.isEmpty(ChooseCountryActivity.this.p)) {
                return;
            }
            db2.L(ChooseCountryActivity.this.p, httpCallback);
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
            return JSON.parseArray(Arrays.toString(strArr), ChooseCountryBean.class);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class f extends HttpCallback {
        public f() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i == 0) {
                JSONArray jSONArray = (JSONArray) JSON.parse(Arrays.toString(strArr));
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                int size = jSONArray.size();
                for (int i2 = 0; i2 < size; i2++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    JSONArray jSONArray2 = jSONObject.getJSONArray("lists");
                    if (jSONArray2.size() > 0) {
                        String string = jSONObject.getString("title");
                        arrayList.add(string);
                        ChooseCountryActivity.this.k.put(arrayList.size() - 1, arrayList2.size());
                        int size2 = jSONArray2.size();
                        for (int i3 = 0; i3 < size2; i3++) {
                            ChooseCountryBean chooseCountryBean = (ChooseCountryBean) JSON.parseObject(jSONArray2.getString(i3), ChooseCountryBean.class);
                            chooseCountryBean.setIndex(string);
                            arrayList2.add(chooseCountryBean);
                        }
                    }
                }
                if (ChooseCountryActivity.this.e != null) {
                    ChooseCountryActivity.this.e.setData(arrayList);
                }
                if (ChooseCountryActivity.this.g != null) {
                    ChooseCountryActivity.this.g.h(arrayList2);
                }
                if (ChooseCountryActivity.this.f != null) {
                    ChooseCountryActivity chooseCountryActivity = ChooseCountryActivity.this;
                    chooseCountryActivity.i = new oz(chooseCountryActivity.b, arrayList2);
                    ChooseCountryActivity.this.i.R(ChooseCountryActivity.this);
                    ChooseCountryActivity.this.f.setAdapter(ChooseCountryActivity.this.i);
                }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static class g extends Handler {
        public ChooseCountryActivity a;

        public g(ChooseCountryActivity chooseCountryActivity) {
            this.a = (ChooseCountryActivity) new WeakReference(chooseCountryActivity).get();
        }

        public void a() {
            this.a = null;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            ChooseCountryActivity chooseCountryActivity = this.a;
            if (chooseCountryActivity != null) {
                chooseCountryActivity.O1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O1() {
        String trim = this.m.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            t54.a(m93.r1);
            return;
        }
        db2.i("getCountryCode");
        g gVar = this.o;
        if (gVar != null) {
            gVar.removeCallbacksAndMessages(null);
        }
        this.p = trim;
        CommonRefreshView commonRefreshView = this.l;
        if (commonRefreshView != null) {
            if (commonRefreshView.getVisibility() != 0) {
                this.l.setVisibility(0);
            }
            this.l.k();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.et2
    /* renamed from: N1, reason: merged with bridge method [inline-methods] */
    public void onItemClick(ChooseCountryBean chooseCountryBean, int i) {
        EditText editText;
        InputMethodManager inputMethodManager = this.q;
        if (inputMethodManager != null && (editText = this.m) != null) {
            inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
        }
        Intent intent = new Intent();
        intent.putExtra("toName", chooseCountryBean.getTel());
        setResult(-1, intent);
        finish();
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return y73.l;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        this.k = new SparseIntArray();
        this.e = (SideIndexBar) findViewById(c73.U2);
        RecyclerView findViewById = findViewById(c73.h4);
        this.f = findViewById;
        findViewById.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.b, 1, false);
        this.h = linearLayoutManager;
        this.f.setLayoutManager(linearLayoutManager);
        this.e.setActionListener(new a());
        m04 m04Var = new m04(this.b);
        this.g = m04Var;
        m04Var.f(new b());
        this.g.g(0);
        this.f.k(this.g);
        this.o = new g(this);
        this.q = (InputMethodManager) getSystemService("input_method");
        View findViewById2 = findViewById(c73.Y);
        this.n = findViewById2;
        findViewById2.setOnClickListener(this);
        EditText editText = (EditText) findViewById(c73.P1);
        this.m = editText;
        editText.setOnEditorActionListener(new c());
        this.m.addTextChangedListener(new d());
        CommonRefreshView commonRefreshView = (CommonRefreshView) findViewById(c73.r4);
        this.l = commonRefreshView;
        commonRefreshView.setLayoutManager(new LinearLayoutManager(this.b, 1, false));
        this.l.setDataHelper(new e());
        db2.L(null, new f());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText = this.m;
        if (editText != null) {
            editText.setText((CharSequence) null);
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        db2.i("getCountryCode");
        g gVar = this.o;
        if (gVar != null) {
            gVar.removeCallbacksAndMessages(null);
            this.o.a();
        }
        super.onDestroy();
    }
}
