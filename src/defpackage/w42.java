package defpackage;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.live.bean.RedPackBean;
import com.yunbao.live.bean.RedPackResultBean;

/* loaded from: /tmp/classes2.dex */
public class w42 extends l0 {
    public TextView A0;
    public TextView B0;
    public TextView C0;
    public View D0;
    public View E0;
    public TextView F0;
    public RecyclerView G0;
    public RedPackBean H0;
    public String I0;
    public String J0;
    public ImageView z0;

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
            JSONObject jSONObject = parseObject.getJSONObject("redinfo");
            if (jSONObject != null) {
                if (w42.this.z0 != null) {
                    kn1.g(w42.this.x0, jSONObject.getString("avatar"), w42.this.z0);
                }
                if (w42.this.A0 != null) {
                    w42.this.A0.setText(aq4.b(m93.B9, jSONObject.getString("user_nickname")));
                }
                if (w42.this.F0 != null) {
                    w42.this.F0.setText(aq4.b(m93.D9, jSONObject.getString("nums_rob") + "/" + jSONObject.getString("nums"), jSONObject.getString("coin_rob") + "/" + jSONObject.getString("coin"), w42.this.J0));
                }
            }
            String string = parseObject.getString("win");
            if (!TextUtils.isEmpty(string) && !"0".equals(string)) {
                if (w42.this.E0 != null && w42.this.E0.getVisibility() != 0) {
                    w42.this.E0.setVisibility(0);
                }
                if (w42.this.B0 != null) {
                    w42.this.B0.setText(string);
                }
                if (w42.this.C0 != null) {
                    w42.this.C0.setText(aq4.b(m93.C9, w42.this.J0));
                }
            } else if (w42.this.D0 != null && w42.this.D0.getVisibility() != 0) {
                w42.this.D0.setVisibility(0);
            }
            if (w42.this.G0 != null) {
                w42.this.G0.setAdapter(new mc3(w42.this.x0, JSON.parseArray(parseObject.getString("list"), RedPackResultBean.class)));
            }
        }
    }

    public void C2(String str) {
        this.J0 = str;
    }

    public void D2(RedPackBean redPackBean) {
        this.H0 = redPackBean;
    }

    public void E2(String str) {
        this.I0 = str;
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
        return x73.U;
    }

    @Override // defpackage.l0
    public void p2(Window window) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = zn0.a(280);
        attributes.height = zn0.a(360);
        attributes.gravity = 17;
        window.setAttributes(attributes);
    }

    public void r0(Bundle bundle) {
        super.r0(bundle);
        if (this.H0 == null || TextUtils.isEmpty(this.I0)) {
            return;
        }
        this.z0 = (ImageView) this.y0.findViewById(b73.d);
        this.A0 = (TextView) this.y0.findViewById(b73.X3);
        this.D0 = this.y0.findViewById(b73.k4);
        this.E0 = this.y0.findViewById(b73.o6);
        this.B0 = (TextView) this.y0.findViewById(b73.n6);
        this.C0 = (TextView) this.y0.findViewById(b73.w1);
        this.F0 = (TextView) this.y0.findViewById(b73.l4);
        RecyclerView findViewById = this.y0.findViewById(b73.B4);
        this.G0 = findViewById;
        findViewById.setHasFixedSize(true);
        this.G0.setLayoutManager(new LinearLayoutManager(this.x0, 1, false));
        e32.d0(this.I0, this.H0.getId(), new a());
    }
}
