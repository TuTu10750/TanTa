package defpackage;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yunbao.common.bean.UserBean;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.live.activity.LiveAnchorActivity;
import com.yunbao.live.activity.LiveAudienceActivity;
import defpackage.l62;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class m62 extends l0 implements View.OnClickListener, l62.c {
    public TextView A0;
    public String B0;
    public boolean C0;
    public boolean D0;
    public TextView z0;

    /* loaded from: /tmp/classes2.dex */
    public class a extends HttpCallback {
        public a() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length <= 0) {
                return;
            }
            JSONObject parseObject = JSON.parseObject(strArr[0]);
            List parseArray = JSON.parseArray(parseObject.getString("apply_list"), UserBean.class);
            if (m62.this.C0) {
                if (m62.this.z0 != null) {
                    m62.this.z0.setText(aq4.b(m93.v, Integer.valueOf(parseArray.size())));
                }
                RecyclerView k2 = m62.this.k2(b73.B4);
                if (k2 != null) {
                    k2.setVisibility(0);
                    k2.setLayoutManager(new LinearLayoutManager(m62.this.x0, 1, false));
                    l62 l62Var = new l62(m62.this.x0, parseArray, true);
                    l62Var.Z(m62.this);
                    k2.setAdapter(l62Var);
                    return;
                }
                return;
            }
            int intValue = parseObject.getIntValue("position");
            m62.this.D0 = intValue > 0;
            boolean z = m62.this.D0;
            m62 m62Var = m62.this;
            if (z) {
                if (m62Var.z0 != null) {
                    m62.this.z0.setText(aq4.b(m93.u, Integer.valueOf(intValue)));
                }
                if (m62.this.A0 != null) {
                    m62.this.A0.setOnClickListener(m62.this);
                    m62.this.A0.setText(m93.t);
                    m62.this.A0.setTextColor(o60.b(m62.this.x0, p53.i));
                }
                RecyclerView k22 = m62.this.k2(b73.B4);
                if (k22 != null) {
                    k22.setVisibility(0);
                    k22.setLayoutManager(new LinearLayoutManager(m62.this.x0, 1, false));
                    k22.setAdapter(new l62(m62.this.x0, parseArray, false));
                    return;
                }
                return;
            }
            if (m62Var.z0 != null) {
                m62.this.z0.setText(m93.r);
            }
            if (m62.this.A0 != null) {
                m62.this.A0.setOnClickListener(m62.this);
                m62.this.A0.setText(m93.s);
                m62.this.A0.setTextColor(o60.b(m62.this.x0, p53.a));
            }
            m62.this.k2(b73.D2).setVisibility(0);
            ImageView imageView = (ImageView) m62.this.k2(b73.d);
            TextView textView = (TextView) m62.this.k2(b73.X3);
            UserBean D = j30.q().D();
            if (D != null) {
                kn1.g(m62.this.x0, D.getAvatar(), imageView);
                textView.setText(D.getUserNiceName());
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends HttpCallback {
        public b() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i == 0) {
                m62.this.S1();
            }
            t54.b(str);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends HttpCallback {
        public c() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i == 0) {
                if (m62.this.x0 != null) {
                    ((LiveAudienceActivity) m62.this.x0).v3();
                }
                m62.this.S1();
            }
            t54.b(str);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d extends HttpCallback {
        public final /* synthetic */ UserBean a;

        public d(UserBean userBean) {
            this.a = userBean;
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i == 0 && strArr.length > 0) {
                if (m62.this.x0 != null) {
                    ((LiveAnchorActivity) m62.this.x0).v3(this.a, JSON.parseObject(strArr[0]).getIntValue("position"));
                }
                m62.this.S1();
            }
            t54.b(str);
        }
    }

    @Override // defpackage.l0
    public void C0() {
        this.x0 = null;
        e32.f("applyVoiceLiveMic");
        e32.f("cancelVoiceLiveMic");
        e32.f("handleVoiceMicApply");
        super.C0();
    }

    @Override // l62.c
    public void b(UserBean userBean, int i) {
        e32.n0(this.B0, userBean.getId(), i, new d(userBean));
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
        return x73.e0;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z = this.D0;
        String str = this.B0;
        if (z) {
            e32.g(str, new b());
        } else {
            e32.c(str, new c());
        }
    }

    @Override // defpackage.l0
    public void p2(Window window) {
        window.setWindowAnimations(s93.b);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = zn0.a(340);
        attributes.gravity = 80;
        window.setAttributes(attributes);
    }

    public void r0(Bundle bundle) {
        super.r0(bundle);
        Bundle z = z();
        if (z == null) {
            return;
        }
        this.B0 = z.getString("liveStream");
        this.C0 = z.getBoolean("anchor");
        this.z0 = (TextView) k2(b73.i5);
        if (this.C0) {
            k2(b73.w2).setVisibility(8);
        } else {
            this.A0 = (TextView) k2(b73.w);
        }
        e32.l0(this.B0, new a());
    }
}
