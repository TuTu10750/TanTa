package defpackage;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.live.activity.LiveContributeActivity;
import com.yunbao.live.activity.LiveGuardListActivity;
import com.yunbao.live.bean.ImpressBean;
import com.yunbao.live.bean.SearchUserBean;
import com.yunbao.live.custom.MyTextView;
import com.yunbao.main.activity.MyImpressActivity;
import com.yunbao.main.activity.UserHomeActivity;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class ke4 extends k0 implements View.OnClickListener {
    public String b;
    public boolean c;
    public LayoutInflater d;
    public TextView e;
    public ImageView[] f;
    public ImageView[] g;
    public LinearLayout h;
    public View i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public View.OnClickListener o;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (((AbsActivity) ke4.this.mContext).e1()) {
                ke4.this.d0();
            }
        }
    }

    public ke4(Context context, ViewGroup viewGroup, String str, boolean z) {
        super(context, viewGroup, str, Boolean.valueOf(z));
    }

    public final void d0() {
        Object obj = this.mContext;
        if (obj instanceof UserHomeActivity) {
            ((UserHomeActivity) obj).x1(this.b);
        }
    }

    public final void e0() {
        Intent intent = new Intent(this.mContext, (Class<?>) LiveContributeActivity.class);
        intent.putExtra("toUid", this.b);
        this.mContext.startActivity(intent);
    }

    public final void f0() {
        LiveGuardListActivity.A1(this.mContext, this.b);
    }

    public void g0(SearchUserBean searchUserBean, JSONObject jSONObject) {
        TextView textView = this.j;
        if (textView != null) {
            textView.setText(searchUserBean.getSignature());
        }
        TextView textView2 = this.k;
        if (textView2 != null) {
            textView2.setText(jSONObject.getString("birthday"));
        }
        TextView textView3 = this.l;
        if (textView3 != null) {
            textView3.setText(jSONObject.getString("location"));
        }
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return y73.G1;
    }

    public void h0(SearchUserBean searchUserBean, JSONObject jSONObject) {
        TextView textView = this.j;
        if (textView != null) {
            textView.setText(searchUserBean.getSignature());
        }
        if (this.e != null) {
            boolean h = rx1.h();
            TextView textView2 = this.e;
            if (h) {
                textView2.setText(rv3.a(j30.q().F(), aq4.a(m93.T4)));
            } else {
                textView2.setText(aq4.a(m93.T4));
            }
        }
        TextView textView3 = this.k;
        if (textView3 != null) {
            textView3.setText(jSONObject.getString("birthday"));
        }
        TextView textView4 = this.l;
        if (textView4 != null) {
            textView4.setText(jSONObject.getString("location"));
        }
        this.m.setText(searchUserBean.getId());
        this.n.setText(searchUserBean.getUserNiceName());
        i0(jSONObject.getString("label"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [android.view.View, com.yunbao.live.custom.MyTextView] */
    public void i0(String str) {
        LinearLayout linearLayout = this.h;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
            List parseArray = JSON.parseArray(str, ImpressBean.class);
            if (parseArray.size() == 0) {
                if (this.c) {
                    this.i.setVisibility(0);
                    return;
                }
                TextView textView = (TextView) this.d.inflate(x73.F1, (ViewGroup) this.h, false);
                textView.setOnClickListener(this.o);
                this.h.addView(textView);
                return;
            }
            if (parseArray.size() > 3) {
                parseArray = parseArray.subList(0, 3);
            }
            int size = parseArray.size();
            for (int i = 0; i < size; i++) {
                ?? r3 = (MyTextView) this.d.inflate(x73.E1, (ViewGroup) this.h, false);
                ImpressBean impressBean = (ImpressBean) parseArray.get(i);
                impressBean.setCheck(1);
                r3.setBean(impressBean);
                this.h.addView(r3);
            }
            if (this.c) {
                return;
            }
            TextView textView2 = (TextView) this.d.inflate(x73.F1, (ViewGroup) this.h, false);
            textView2.setOnClickListener(this.o);
            this.h.addView(textView2);
        }
    }

    @Override // defpackage.b1
    public void init() {
        if (TextUtils.isEmpty(this.b)) {
            return;
        }
        this.d = LayoutInflater.from(this.mContext);
        findViewById(c73.H1).setOnClickListener(this);
        findViewById(c73.C2).setOnClickListener(this);
        if (this.c) {
            findViewById(c73.y0).setOnClickListener(this);
            findViewById(c73.S2).setVisibility(0);
        }
        this.m = (TextView) findViewById(c73.p5);
        this.n = (TextView) findViewById(c73.q5);
        this.e = (TextView) findViewById(c73.K5);
        this.f = new ImageView[3];
        this.g = new ImageView[3];
        if (!j30.q().Q()) {
            this.f[0] = (ImageView) findViewById(c73.p);
            this.f[1] = (ImageView) findViewById(c73.q);
            this.f[2] = (ImageView) findViewById(c73.r);
            this.g[0] = (ImageView) findViewById(c73.s);
            this.g[1] = (ImageView) findViewById(c73.t);
            this.g[2] = (ImageView) findViewById(c73.u);
        }
        this.h = (LinearLayout) findViewById(c73.T2);
        this.i = findViewById(c73.T3);
        this.j = (TextView) findViewById(c73.z4);
        this.k = (TextView) findViewById(c73.A);
        this.l = (TextView) findViewById(c73.B1);
        this.o = new a();
    }

    @Override // defpackage.k0
    public void loadData() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        if (((AbsActivity) this.mContext).e1()) {
            int id = view.getId();
            if (id == c73.H1) {
                e0();
                return;
            }
            if (id == c73.C2) {
                f0();
            } else if (id == c73.y0 && this.c && (context = this.mContext) != null) {
                context.startActivity(new Intent(this.mContext, (Class<?>) MyImpressActivity.class));
            }
        }
    }

    @Override // defpackage.b1
    public void processArguments(Object... objArr) {
        this.b = (String) objArr[0];
        this.c = ((Boolean) objArr[1]).booleanValue();
    }
}
