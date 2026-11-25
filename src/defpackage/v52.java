package defpackage;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alibaba.fastjson.JSON;
import com.trtc.tuikit.common.ui.PopupDialog;
import com.yunbao.common.bean.LiveTypeConfig;
import com.yunbao.common.http.HttpCallback;

/* loaded from: /tmp/classes2.dex */
public class v52 extends PopupDialog {
    public m30 a;
    public LiveTypeConfig b;
    public int c;
    public EditText d;
    public InputMethodManager e;

    /* loaded from: /tmp/classes2.dex */
    public class a extends HttpCallback {
        public a() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i == 0) {
                t54.b("直播间模式切换成功！");
                v52.this.dismiss();
            }
        }
    }

    public v52(Context context, LiveTypeConfig liveTypeConfig) {
        super(context, t93.a);
        this.b = liveTypeConfig;
        n();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void h(v52 v52Var, TextView textView, TextView textView2, TextView textView3, LinearLayout linearLayout, TextView textView4, TextView textView5, View view) {
        InputMethodManager inputMethodManager;
        if (v52Var.c != 2) {
            textView.setBackgroundResource(h63.k);
            textView.setTextColor(Color.parseColor("#4a6cf7"));
            textView2.setTextColor(o60.b(v52Var.getContext(), q53.c));
            textView2.setBackgroundResource(h63.j);
            textView3.setTextColor(o60.b(v52Var.getContext(), q53.c));
            textView3.setBackgroundResource(h63.j);
            linearLayout.setVisibility(0);
            v52Var.c = 2;
            textView4.setText("门票");
            String str = v52Var.b.getTicketMin() + "~" + v52Var.b.getTicketMax();
            v52Var.d.setHint(str);
            textView5.setText("范围建议：" + str + "钻石");
            View currentFocus = v52Var.getCurrentFocus();
            if (currentFocus != null && (inputMethodManager = v52Var.e) != null) {
                inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
            }
            v52Var.d.requestFocus();
            int liveType = v52Var.b.getLiveType();
            EditText editText = v52Var.d;
            if (liveType != 2) {
                editText.setText("");
                return;
            }
            editText.setText(v52Var.b.getLiveTypeVal() + "");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void i(v52 v52Var, TextView textView, TextView textView2, TextView textView3, LinearLayout linearLayout, View view) {
        InputMethodManager inputMethodManager;
        if (v52Var.c != 0) {
            textView.setBackgroundResource(h63.k);
            textView.setTextColor(Color.parseColor("#4a6cf7"));
            textView2.setTextColor(o60.b(v52Var.getContext(), q53.c));
            textView3.setTextColor(o60.b(v52Var.getContext(), q53.c));
            textView2.setBackgroundResource(h63.j);
            textView3.setBackgroundResource(h63.j);
            linearLayout.setVisibility(8);
            v52Var.c = 0;
            View currentFocus = v52Var.getCurrentFocus();
            if (currentFocus != null && (inputMethodManager = v52Var.e) != null) {
                inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
            }
            v52Var.d.clearFocus();
        }
    }

    public static /* synthetic */ void k(v52 v52Var, View view) {
        v52Var.b.setLiveType(v52Var.c);
        if (v52Var.b.getLiveType() == 3) {
            String obj = v52Var.d.getText().toString();
            if (obj.isEmpty()) {
                t54.b("每分钟金额不能为空");
                return;
            }
            int h = rv3.h(obj, 0);
            int timeRoomMin = v52Var.b.getTimeRoomMin();
            LiveTypeConfig liveTypeConfig = v52Var.b;
            if (h < timeRoomMin) {
                t54.b("每分钟金额不能小于" + liveTypeConfig.getTimeRoomMin());
                return;
            }
            int timeRoomMax = liveTypeConfig.getTimeRoomMax();
            LiveTypeConfig liveTypeConfig2 = v52Var.b;
            if (h > timeRoomMax) {
                t54.b("每分钟金额不能大于" + liveTypeConfig2.getTimeRoomMax());
                return;
            }
            liveTypeConfig2.setLiveTypeVal(h);
        }
        if (v52Var.b.getLiveType() == 2) {
            String obj2 = v52Var.d.getText().toString();
            if (obj2.isEmpty()) {
                t54.b("门票金额不能为空");
                return;
            }
            int h2 = rv3.h(obj2, 0);
            int ticketMin = v52Var.b.getTicketMin();
            LiveTypeConfig liveTypeConfig3 = v52Var.b;
            if (h2 < ticketMin) {
                t54.b("门票金额不能小于" + liveTypeConfig3.getTicketMin());
                return;
            }
            int ticketMax = liveTypeConfig3.getTicketMax();
            LiveTypeConfig liveTypeConfig4 = v52Var.b;
            if (h2 > ticketMax) {
                t54.b("门票金额不能大于" + liveTypeConfig4.getTicketMax());
                return;
            }
            liveTypeConfig4.setLiveTypeVal(h2);
        }
        v52Var.m();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void l(v52 v52Var, TextView textView, TextView textView2, TextView textView3, LinearLayout linearLayout, TextView textView4, TextView textView5, View view) {
        InputMethodManager inputMethodManager;
        if (v52Var.c != 3) {
            textView.setBackgroundResource(h63.k);
            textView.setTextColor(Color.parseColor("#4a6cf7"));
            textView2.setTextColor(o60.b(v52Var.getContext(), q53.c));
            textView2.setBackgroundResource(h63.j);
            textView3.setTextColor(o60.b(v52Var.getContext(), q53.c));
            textView3.setBackgroundResource(h63.j);
            linearLayout.setVisibility(0);
            v52Var.c = 3;
            textView4.setText("每分钟");
            String str = v52Var.b.getTimeRoomMin() + "~" + v52Var.b.getTimeRoomMax();
            v52Var.d.setHint(str);
            textView5.setText("范围建议：" + str + "钻石/分钟");
            View currentFocus = v52Var.getCurrentFocus();
            if (currentFocus != null && (inputMethodManager = v52Var.e) != null) {
                inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
            }
            v52Var.d.requestFocus();
            int liveType = v52Var.b.getLiveType();
            EditText editText = v52Var.d;
            if (liveType != 3) {
                editText.setText("");
                return;
            }
            editText.setText(v52Var.b.getLiveTypeVal() + "");
        }
    }

    public final void m() {
        m30 m30Var = this.a;
        LiveTypeConfig liveTypeConfig = this.b;
        if (m30Var == null) {
            e32.i(liveTypeConfig.getStream(), this.b.getLiveType(), this.b.getLiveTypeVal(), new a());
        } else {
            m30Var.a(liveTypeConfig.getLiveType(), Integer.valueOf(this.b.getLiveTypeVal()));
            dismiss();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void n() {
        View inflate = LayoutInflater.from(getContext()).inflate(x73.b0, (ViewGroup) null);
        final TextView textView = (TextView) inflate.findViewById(b73.E0);
        final TextView textView2 = (TextView) inflate.findViewById(b73.H0);
        final TextView textView3 = (TextView) inflate.findViewById(b73.j1);
        final TextView textView4 = (TextView) inflate.findViewById(b73.X5);
        final TextView textView5 = (TextView) inflate.findViewById(b73.J5);
        this.d = (EditText) inflate.findViewById(b73.W1);
        final LinearLayout linearLayout = (LinearLayout) inflate.findViewById(b73.w3);
        inflate.findViewById(b73.C).setOnClickListener(new View.OnClickListener() { // from class: q52
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                v52.this.dismiss();
            }
        });
        this.e = (InputMethodManager) getContext().getSystemService("input_method");
        inflate.findViewById(b73.N).setOnClickListener(new View.OnClickListener() { // from class: r52
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                v52.k(v52.this, view);
            }
        });
        textView.setOnClickListener(new View.OnClickListener() { // from class: s52
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                v52.i(v52.this, textView, textView2, textView3, linearLayout, view);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: t52
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                v52.h(v52.this, textView2, textView, textView3, linearLayout, textView4, textView5, view);
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() { // from class: u52
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                v52.l(v52.this, textView3, textView, textView2, linearLayout, textView4, textView5, view);
            }
        });
        if (this.b.getIsTicketRoom() == 1) {
            textView2.setVisibility(0);
        }
        if (this.b.getIsTimeRoom() == 1) {
            textView3.setVisibility(0);
        }
        ((TextView) inflate.findViewById(b73.H5)).setText(j30.q().g());
        lx1.c("9527", "sss:::" + JSON.toJSONString(this.b));
        this.c = this.b.getLiveType();
        if (this.b.getLiveType() == 0) {
            textView.setBackgroundResource(h63.k);
            textView.setTextColor(Color.parseColor("#4a6cf7"));
            textView2.setTextColor(o60.b(getContext(), q53.c));
            textView2.setBackgroundResource(h63.j);
            textView3.setTextColor(o60.b(getContext(), q53.c));
            textView3.setBackgroundResource(h63.j);
            this.c = 0;
        }
        if (this.b.getLiveType() == 2) {
            textView2.setBackgroundResource(h63.k);
            textView2.setTextColor(Color.parseColor("#4a6cf7"));
            textView.setTextColor(o60.b(getContext(), q53.c));
            textView.setBackgroundResource(h63.j);
            textView3.setTextColor(o60.b(getContext(), q53.c));
            textView3.setBackgroundResource(h63.j);
            linearLayout.setVisibility(0);
            this.c = 2;
            textView4.setText("门票");
            String str = this.b.getTicketMin() + "~" + this.b.getTicketMax();
            this.d.setHint(str);
            this.d.setText(this.b.getLiveTypeVal() + "");
            textView5.setText("范围建议：" + str + "钻石");
        }
        if (this.b.getLiveType() == 3) {
            textView3.setBackgroundResource(h63.k);
            textView3.setTextColor(Color.parseColor("#4a6cf7"));
            textView.setTextColor(o60.b(getContext(), q53.c));
            textView.setBackgroundResource(h63.j);
            textView2.setTextColor(o60.b(getContext(), q53.c));
            textView2.setBackgroundResource(h63.j);
            linearLayout.setVisibility(0);
            this.c = 3;
            textView4.setText("每分钟");
            String str2 = this.b.getTimeRoomMin() + "~" + this.b.getTimeRoomMax();
            this.d.setHint(str2);
            this.d.setText(this.b.getLiveTypeVal() + "");
            textView5.setText("范围建议：" + str2 + "钻石/分钟");
        }
        setView(inflate);
    }

    public void o(m30 m30Var) {
        this.a = m30Var;
    }
}
