package defpackage;

import android.content.Context;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.alibaba.fastjson.JSON;
import com.yunbao.common.custom.CommonRefreshView;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.mall.activity.GoodsSearchActivity;
import com.yunbao.mall.bean.SearchPayBean;
import java.util.Arrays;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class tk3 extends k0 implements et2 {
    public CommonRefreshView b;
    public sk3 c;
    public EditText d;
    public Handler e;
    public String f;

    /* loaded from: /tmp/classes2.dex */
    public class a implements TextView.OnEditorActionListener {
        public a() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 3) {
                return false;
            }
            ec2.u("searchPayList");
            if (tk3.this.e != null) {
                tk3.this.e.removeCallbacksAndMessages(null);
            }
            tk3.this.j0();
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
            ec2.u("searchPayList");
            if (tk3.this.e != null) {
                tk3.this.e.removeCallbacksAndMessages(null);
                tk3.this.e.sendEmptyMessageDelayed(0, 500L);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c implements CommonRefreshView.e {
        public c() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public ce3 getAdapter() {
            if (tk3.this.c == null) {
                tk3 tk3Var = tk3.this;
                tk3Var.c = new sk3(tk3Var.mContext);
                tk3.this.c.R(tk3.this);
            }
            return tk3.this.c;
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void loadData(int i, HttpCallback httpCallback) {
            ec2.u0(tk3.this.f, i, httpCallback);
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
            return JSON.parseArray(Arrays.toString(strArr), SearchPayBean.class);
        }
    }

    public tk3(Context context, ViewGroup viewGroup, Handler handler) {
        super(context, viewGroup);
        this.e = handler;
    }

    public void g0() {
        sk3 sk3Var = this.c;
        if (sk3Var != null) {
            sk3Var.b0();
        }
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return z73.Y1;
    }

    public SearchPayBean h0() {
        sk3 sk3Var = this.c;
        if (sk3Var != null) {
            return sk3Var.c0();
        }
        return null;
    }

    @Override // defpackage.et2
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public void onItemClick(SearchPayBean searchPayBean, int i) {
        ((GoodsSearchActivity) this.mContext).B1();
        ((GoodsSearchActivity) this.mContext).D1();
    }

    @Override // defpackage.b1
    public void init() {
        EditText editText = (EditText) findViewById(d73.R1);
        this.d = editText;
        editText.setOnEditorActionListener(new a());
        this.d.addTextChangedListener(new b());
        CommonRefreshView commonRefreshView = (CommonRefreshView) findViewById(d73.C3);
        this.b = commonRefreshView;
        commonRefreshView.setEmptyLayoutId(z73.Q1);
        this.b.setLayoutManager(new LinearLayoutManager(this.mContext, 1, false));
        this.b.setDataHelper(new c());
    }

    public void j0() {
        this.f = this.d.getText().toString().trim();
        CommonRefreshView commonRefreshView = this.b;
        if (commonRefreshView != null) {
            commonRefreshView.k();
        }
    }

    @Override // defpackage.k0
    public void loadData() {
        if (isFirstLoadData()) {
            j0();
        }
    }

    @Override // defpackage.b1, defpackage.uy1
    public void onDestroy() {
        this.e = null;
        super.onDestroy();
    }
}
