package defpackage;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.alibaba.fastjson.JSON;
import com.yunbao.common.custom.CommonRefreshView;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.live.activity.LiveAnchorActivity;
import com.yunbao.live.bean.LivePkBean;
import defpackage.n32;
import java.util.Arrays;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class l32 extends l0 implements et2, View.OnClickListener, n32.b {
    public CommonRefreshView A0;
    public b42 B0;
    public b42 C0;
    public View D0;
    public EditText E0;
    public n32 F0;
    public Handler G0;
    public String H0;
    public InputMethodManager I0;
    public CommonRefreshView z0;

    /* loaded from: /tmp/classes2.dex */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            l32.this.G2();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements CommonRefreshView.e {
        public b() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public ce3 getAdapter() {
            if (l32.this.B0 == null) {
                l32 l32Var = l32.this;
                l32Var.B0 = new b42(l32Var.x0);
                l32.this.B0.R(l32.this);
            }
            return l32.this.B0;
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void loadData(int i, HttpCallback httpCallback) {
            e32.Q(i, httpCallback);
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
            return JSON.parseArray(Arrays.toString(strArr), LivePkBean.class);
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
            if (l32.this.I0 != null) {
                l32.this.I0.hideSoftInputFromWindow(l32.this.E0.getWindowToken(), 0);
            }
            l32.this.G2();
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
            e32.f("livePkSearchAnchor");
            if (l32.this.G0 != null) {
                l32.this.G0.removeCallbacksAndMessages(null);
            }
            boolean isEmpty = TextUtils.isEmpty(charSequence);
            l32 l32Var = l32.this;
            if (!isEmpty) {
                if (l32Var.G0 != null) {
                    l32.this.G0.sendEmptyMessageDelayed(0, 500L);
                }
            } else {
                l32Var.H0 = null;
                if (l32.this.C0 != null) {
                    l32.this.C0.M();
                }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e implements CommonRefreshView.e {
        public e() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public ce3 getAdapter() {
            if (l32.this.C0 == null) {
                l32 l32Var = l32.this;
                l32Var.C0 = new b42(l32Var.x0);
                l32.this.C0.R(l32.this);
            }
            return l32.this.C0;
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void loadData(int i, HttpCallback httpCallback) {
            e32.u0(l32.this.H0, i, httpCallback);
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
            return JSON.parseArray(Arrays.toString(strArr), LivePkBean.class);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (l32.this.I0 == null || l32.this.E0 == null) {
                return;
            }
            l32.this.I0.showSoftInput(l32.this.E0, 2);
        }
    }

    @Override // defpackage.l0
    public void C0() {
        Object obj = this.x0;
        if (obj != null) {
            ((LiveAnchorActivity) obj).y3();
        }
        InputMethodManager inputMethodManager = this.I0;
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(this.E0.getWindowToken(), 0);
        }
        this.I0 = null;
        e32.f("getLivePkList");
        e32.f("livePkSearchAnchor");
        Handler handler = this.G0;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.G0 = null;
        super.C0();
    }

    public final void D2() {
        n32 n32Var = this.F0;
        if (n32Var != null) {
            n32Var.dismiss();
        }
    }

    public final View E2() {
        this.I0 = (InputMethodManager) this.x0.getSystemService("input_method");
        View inflate = LayoutInflater.from(this.x0).inflate(x73.Q, (ViewGroup) null);
        EditText editText = (EditText) inflate.findViewById(b73.N1);
        this.E0 = editText;
        editText.setOnEditorActionListener(new c());
        this.E0.addTextChangedListener(new d());
        inflate.findViewById(b73.x).setOnClickListener(this);
        CommonRefreshView commonRefreshView = (CommonRefreshView) inflate.findViewById(b73.E4);
        this.A0 = commonRefreshView;
        commonRefreshView.setEmptyLayoutId(x73.y2);
        this.A0.setLayoutManager(new LinearLayoutManager(this.x0, 1, false));
        this.A0.setDataHelper(new e());
        return inflate;
    }

    @Override // defpackage.et2
    /* renamed from: F2, reason: merged with bridge method [inline-methods] */
    public void onItemClick(LivePkBean livePkBean, int i) {
        if (System.currentTimeMillis() - (livePkBean.getStartTime() * 1000) < 30000) {
            t54.a(m93.T3);
            return;
        }
        InputMethodManager inputMethodManager = this.I0;
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(this.E0.getWindowToken(), 0);
        }
        this.I0 = null;
        n32 n32Var = this.F0;
        if (n32Var != null) {
            n32Var.dismiss();
        }
        this.F0 = null;
        ((LiveAnchorActivity) this.x0).A3(livePkBean.getUid(), livePkBean.getStream());
        S1();
    }

    public final void G2() {
        String trim = this.E0.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            t54.a(m93.r1);
            return;
        }
        e32.f("livePkSearchAnchor");
        Handler handler = this.G0;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.H0 = trim;
        CommonRefreshView commonRefreshView = this.A0;
        if (commonRefreshView != null) {
            commonRefreshView.k();
        }
    }

    public final void H2() {
        if (this.D0 == null) {
            this.D0 = E2();
        }
        n32 n32Var = new n32(this.y0, this.D0, this);
        this.F0 = n32Var;
        n32Var.d();
        Handler handler = this.G0;
        if (handler != null) {
            handler.postDelayed(new f(), 300L);
        }
    }

    @Override // defpackage.l0
    public boolean f2() {
        return true;
    }

    @Override // defpackage.l0
    public int l2() {
        return s93.d;
    }

    @Override // defpackage.l0
    public int m2() {
        return x73.P;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == b73.H) {
            S1();
        } else if (id == b73.X0) {
            H2();
        } else if (id == b73.x) {
            D2();
        }
    }

    @Override // n32.b
    public void p() {
        e32.f("livePkSearchAnchor");
        Handler handler = this.G0;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        EditText editText = this.E0;
        if (editText != null) {
            editText.setText("");
        }
        b42 b42Var = this.C0;
        if (b42Var != null) {
            b42Var.M();
        }
    }

    @Override // defpackage.l0
    public void p2(Window window) {
        window.setWindowAnimations(s93.b);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = zn0.a(300);
        attributes.gravity = 80;
        window.setAttributes(attributes);
    }

    public void r0(Bundle bundle) {
        super.r0(bundle);
        this.G0 = new a();
        this.y0.findViewById(b73.H).setOnClickListener(this);
        this.y0.findViewById(b73.X0).setOnClickListener(this);
        CommonRefreshView commonRefreshView = (CommonRefreshView) this.y0.findViewById(b73.E4);
        this.z0 = commonRefreshView;
        commonRefreshView.setEmptyLayoutId(x73.x2);
        this.z0.setLayoutManager(new LinearLayoutManager(this.x0, 1, false));
        this.z0.setDataHelper(new b());
        this.z0.k();
    }
}
