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
import com.alibaba.fastjson.JSONObject;
import com.trtc.tuikit.common.R;
import com.trtc.tuikit.common.ui.PopupDialog;
import com.yunbao.common.bean.UserBean;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.common.utils.a;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class v5 extends PopupDialog {
    public TextView a;
    public RecyclerView b;
    public h02 c;
    public HttpCallback d;

    /* loaded from: /tmp/classes2.dex */
    public class a extends HttpCallback {

        /* renamed from: v5$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/classes2.dex */
        public class C0160a implements et2 {
            public final /* synthetic */ JSONObject a;

            /* renamed from: v5$a$a$a, reason: collision with other inner class name */
            /* loaded from: /tmp/classes2.dex */
            public class C0161a implements a.m {
                public final /* synthetic */ UserBean a;

                /* renamed from: v5$a$a$a$a, reason: collision with other inner class name */
                /* loaded from: /tmp/classes2.dex */
                public class C0162a extends HttpCallback {
                    public C0162a() {
                    }

                    @Override // com.yunbao.common.http.HttpCallback
                    public void onSuccess(int i, String str, String[] strArr) {
                        if (i != 0 || strArr.length <= 0) {
                            return;
                        }
                        int intValue = JSON.parseObject(strArr[0]).getIntValue("isadmin");
                        if (intValue != 0) {
                            if (intValue == 1) {
                                C0161a c0161a = C0161a.this;
                                v5.this.p(c0161a.a.getId());
                                return;
                            }
                            return;
                        }
                        if (v5.this.c != null) {
                            v5.this.c.U(C0161a.this.a.getId());
                            v5.this.a.setText(aq4.a(m93.o3) + "(" + v5.this.c.j() + "/" + C0160a.this.a.getString("total") + ")");
                        }
                        C0161a c0161a2 = C0161a.this;
                        v5.this.n(c0161a2.a.getId());
                    }
                }

                public C0161a(UserBean userBean) {
                    this.a = userBean;
                }

                @Override // com.yunbao.common.utils.a.m
                public void b(Dialog dialog, String str) {
                    String C = j30.q().C();
                    e32.C0(C, this.a.getId(), "live_" + C, new C0162a());
                }
            }

            public C0160a(JSONObject jSONObject) {
                this.a = jSONObject;
            }

            @Override // defpackage.et2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onItemClick(UserBean userBean, int i) {
                com.yunbao.common.utils.a.l(v5.this.getContext(), aq4.b(m93.O4, userBean.getUserNiceName()), new C0161a(userBean));
            }
        }

        public a() {
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [android.app.Dialog, v5] */
        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length <= 0) {
                return;
            }
            JSONObject parseObject = JSON.parseObject(strArr[0]);
            List parseArray = JSON.parseArray(parseObject.getString("list"), UserBean.class);
            h02 h02Var = v5.this.c;
            ?? r0 = v5.this;
            if (h02Var == null) {
                r0.c = new h02(r0.getContext(), parseArray);
                v5.this.c.W(new C0160a(parseObject));
                v5.this.b.setAdapter(v5.this.c);
            } else {
                r0.c.V(parseArray);
            }
            v5.this.a.setText(aq4.a(m93.o3) + "(" + v5.this.c.j() + "/" + parseObject.getString("total") + ")");
        }
    }

    public v5(Context context) {
        super(context, R.style.TUICommonBottomDialogTheme);
        o();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void hide() {
        super/*android.app.Dialog*/.hide();
        e32.f("getAdminList");
        e32.f("setAdmin");
    }

    public final void n(String str) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void o() {
        View inflate = LayoutInflater.from(getContext()).inflate(x73.o, (ViewGroup) null);
        RecyclerView findViewById = inflate.findViewById(b73.B4);
        this.b = findViewById;
        findViewById.setHasFixedSize(true);
        this.b.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        this.a = (TextView) inflate.findViewById(b73.c5);
        this.d = new a();
        setView(inflate);
    }

    public final void p(String str) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void show() {
        super/*android.app.Dialog*/.show();
        e32.B(j30.q().C(), this.d);
    }
}
