package defpackage;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.trtc.tuikit.common.R;
import com.trtc.tuikit.common.ui.PopupDialog;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.common.utils.a;
import com.yunbao.live.bean.LiveShutUpBean;
import java.util.Arrays;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class oj extends PopupDialog {
    public TextView a;
    public TextView b;
    public TextView c;
    public RecyclerView d;
    public e12 e;
    public HttpCallback f;

    /* loaded from: /tmp/classes2.dex */
    public class a extends HttpCallback {

        /* renamed from: oj$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/classes2.dex */
        public class C0138a implements et2 {

            /* renamed from: oj$a$a$a, reason: collision with other inner class name */
            /* loaded from: /tmp/classes2.dex */
            public class C0139a implements a.m {
                public final /* synthetic */ LiveShutUpBean a;

                /* renamed from: oj$a$a$a$a, reason: collision with other inner class name */
                /* loaded from: /tmp/classes2.dex */
                public class C0140a extends HttpCallback {
                    public C0140a() {
                    }

                    @Override // com.yunbao.common.http.HttpCallback
                    public void onSuccess(int i, String str, String[] strArr) {
                        if (i == 0 && oj.this.e != null) {
                            oj.this.e.Y(C0139a.this.a.getUid());
                        }
                        t54.b(str);
                    }
                }

                public C0139a(LiveShutUpBean liveShutUpBean) {
                    this.a = liveShutUpBean;
                }

                @Override // com.yunbao.common.utils.a.m
                public void b(Dialog dialog, String str) {
                    e32.r0(j30.q().C(), this.a.getUid(), new C0140a());
                }
            }

            public C0138a() {
            }

            @Override // defpackage.et2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onItemClick(LiveShutUpBean liveShutUpBean, int i) {
                com.yunbao.common.utils.a.l(oj.this.getContext(), aq4.b(m93.Q4, liveShutUpBean.getUserNiceName()), new C0139a(liveShutUpBean));
            }
        }

        public a() {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [android.app.Dialog, oj] */
        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i == 0 && strArr.length > 0) {
                List parseArray = JSON.parseArray(Arrays.toString(strArr), LiveShutUpBean.class);
                e12 e12Var = oj.this.e;
                ?? r0 = oj.this;
                if (e12Var == null) {
                    r0.e = new e12(r0.getContext());
                    oj.this.e.R(new C0138a());
                    oj.this.d.setAdapter(oj.this.e);
                    oj.this.e.P(parseArray);
                } else {
                    r0.e.P(parseArray);
                }
            }
            if (strArr.length == 0) {
                oj.this.c.setVisibility(0);
                oj.this.c.setText("没有被拉黑的用户");
            }
        }
    }

    public oj(Context context) {
        super(context, R.style.TUICommonBottomDialogTheme);
        l();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void l() {
        View inflate = LayoutInflater.from(getContext()).inflate(x73.o, (ViewGroup) null);
        RecyclerView findViewById = inflate.findViewById(b73.B4);
        this.d = findViewById;
        findViewById.setHasFixedSize(true);
        this.d.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        TextView textView = (TextView) inflate.findViewById(b73.c5);
        this.b = textView;
        textView.setVisibility(8);
        this.a = (TextView) inflate.findViewById(b73.i5);
        this.c = (TextView) inflate.findViewById(b73.v5);
        this.a.setText("拉黑用户列表");
        this.f = new a();
        setView(inflate);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void show() {
        super/*android.app.Dialog*/.show();
        e32.N(j30.q().C(), 0, this.f);
    }
}
