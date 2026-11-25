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
public class dp3 extends PopupDialog {
    public TextView a;
    public TextView b;
    public TextView c;
    public RecyclerView d;
    public l52 e;
    public HttpCallback f;

    /* loaded from: /tmp/classes2.dex */
    public class a extends HttpCallback {

        /* renamed from: dp3$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/classes2.dex */
        public class C0062a implements et2 {

            /* renamed from: dp3$a$a$a, reason: collision with other inner class name */
            /* loaded from: /tmp/classes2.dex */
            public class C0063a implements a.m {
                public final /* synthetic */ LiveShutUpBean a;

                /* renamed from: dp3$a$a$a$a, reason: collision with other inner class name */
                /* loaded from: /tmp/classes2.dex */
                public class C0064a extends HttpCallback {
                    public C0064a() {
                    }

                    @Override // com.yunbao.common.http.HttpCallback
                    public void onSuccess(int i, String str, String[] strArr) {
                        if (i != 0) {
                            t54.b(str);
                            return;
                        }
                        if (dp3.this.e != null) {
                            dp3.this.e.Y(C0063a.this.a.getId());
                            if (dp3.this.e.j() == 0) {
                                dp3.this.c.setVisibility(0);
                                dp3.this.c.setText("没有被禁言的用户");
                            }
                        }
                    }
                }

                public C0063a(LiveShutUpBean liveShutUpBean) {
                    this.a = liveShutUpBean;
                }

                @Override // com.yunbao.common.utils.a.m
                public void b(Dialog dialog, String str) {
                    String C = j30.q().C();
                    e32.D0(C, this.a.getId(), "live_" + C, new C0064a());
                }
            }

            public C0062a() {
            }

            @Override // defpackage.et2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onItemClick(LiveShutUpBean liveShutUpBean, int i) {
                com.yunbao.common.utils.a.l(dp3.this.getContext(), aq4.b(m93.P4, liveShutUpBean.getUserNiceName()), new C0063a(liveShutUpBean));
            }
        }

        public a() {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [dp3, android.app.Dialog] */
        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i == 0 && strArr.length > 0) {
                List parseArray = JSON.parseArray(Arrays.toString(strArr), LiveShutUpBean.class);
                l52 l52Var = dp3.this.e;
                ?? r0 = dp3.this;
                if (l52Var == null) {
                    r0.e = new l52(r0.getContext());
                    dp3.this.e.R(new C0062a());
                    dp3.this.d.setAdapter(dp3.this.e);
                    dp3.this.e.P(parseArray);
                } else {
                    r0.e.P(parseArray);
                }
            }
            if (strArr.length == 0) {
                dp3.this.c.setVisibility(0);
                dp3.this.c.setText("没有被禁言的用户");
            }
        }
    }

    public dp3(Context context) {
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
        this.a.setText("禁言用户列表");
        this.f = new a();
        setView(inflate);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void show() {
        super/*android.app.Dialog*/.show();
        e32.U(j30.q().C(), 0, this.f);
    }
}
